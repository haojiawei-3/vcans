package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.CollectDao;

import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class MlqdUploadProcessor extends UploadProcessor {
	Vector<Vector<String> > mVctSendData=null;
	public CollectDao collectDao=null;
	List<HashMap<String,Object> > CollectList=null;
	List<String> id=new ArrayList<String>();
	ArrayList<String> Str=new ArrayList<String>();

	Cursor cursor;
	String []  Data;
	List<HashMap<String,Object> > CollectList1=new ArrayList<HashMap<String,Object>>();
	String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
	public MlqdUploadProcessor(String [] data    ,     ArrayList<String> str)
	{
		Data=data;
		Str=str;
		collectDao=new CollectDao();
	}
	@Override
	public int ProcessData(Vector<String> vctDataId) {
		// TODO Auto-generated method stub
		db.execSQL("delete from Collect  where TPId = ?",   new Object[]{vctDataId.get(0)});
//		for (int i = 0; i < id.size(); i++) {
//			String ids=id.get(i);
//			db.execSQL("delete from Collect  where TPId = ?",   new Object[]{ids});  
//		}  	       	   
		return 0;
	}
	public void DisplayMlqdInfo(ArrayList<String> listid) {
		id=listid;
		CollectList=collectDao.GetAlldwsp1(listid);



	}
	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		mVctSendData=new Vector<Vector<String> > ();
		for (int i = 0; i < CollectList.size(); i++) {
			HashMap<String, Object> list1  =CollectList.get(i);

			list1.put("shu", Str.get(i));
			CollectList1.add(list1);
		}


		for(HashMap<String,Object> Pend:CollectList1)
		{
			Vector<String> child= new Vector<String>();
			//[采集器记录ID,客户条码,样品条码,报价,数量,客户简称,登陆用户名]
			child.add((String)Pend.get("TPId"));
			child.add(Data[0]);//客户条码
			child.add((String)Pend.get("Code"));
			child.add(Double.parseDouble((String)Pend.get("Quotation"))*Integer.parseInt((String)Pend.get("shu"))+"");
			child.add((String)Pend.get("shu"));
			child.add(Data[1]);	//客户简称
			child.add(BaseActivity.gUser.getUserName());
			mVctSendData.add(child);
			System.out.println(mVctSendData+"要上传的数据");
		}
		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {
		MyProtocol myProtocol=new MyProtocol();
		//==信息中心==待我审批-表上传
		myProtocol.sendCmd0=DPProtocol.m_vfxVAG43VcanYPGJMLQD0;
		myProtocol.sendCmd1= DPProtocol.m_vfxVAG43VcanYPGJMLQD1;
		myProtocol.sendCmd2=DPProtocol.m_vfxVAG43VcanYPGJMLQD2;
		myProtocol.sendCmd3=DPProtocol.m_vfxVAG43VcanYPGJMLQD3;
		myProtocol.receCmd0=DPProtocol.m_vfxVAG43VcanYPGJMLQDRe0;
		myProtocol.receCmd1=DPProtocol.m_vfxVAG43VcanYPGJMLQDRe1;
		myProtocol.receCmd3=DPProtocol.m_vfxVAG43VcanYPGJMLQDRe3;
		myProtocol.receCmd5=DPProtocol.m_vfxVAG43VcanYPGJMLQDRe5;

		return myProtocol;
	}

}
