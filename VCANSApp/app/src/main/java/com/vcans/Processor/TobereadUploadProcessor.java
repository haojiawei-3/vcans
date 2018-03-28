package com.vcans.Processor;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.PendingapprovalDao;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class TobereadUploadProcessor extends UploadProcessor {
	Vector<Vector<String> > mVctSendData=null;
	public PendingapprovalDao pendingapprovalDao=null;
	List<HashMap<String,Object> > PendingapprovaliList=null;
	private BandleParam mBdParam=new BandleParam();
	SQLiteDatabase db;
	String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";


	public TobereadUploadProcessor()
	{
		pendingapprovalDao=new PendingapprovalDao();
	}
	@Override
	public int ProcessData(Vector<String> vctDataId) {
		// TODO Auto-generated method stub
		Vector<Vector<String>> vctReceData;
		String strRecordIds=ConvertStringIds(vctDataId);
		System.out.println(strRecordIds+"上传返回的id");
		String id=strRecordIds.replaceAll("'","");
		vctReceData=this.mDataTrunsfer.GetReceiveData();
		if (!strRecordIds.equals("")) {				//返回成功表示上传成功 修改本地标志到    我已审批   或    已阅未批
			db=SQLiteDatabase.openDatabase(path, null, 2);
			ContentValues values = new ContentValues();
			values.put("Spare1",  "2");
			db.update("Pendingapproval", values, "TPId=?", new String[]{id});
			//db.delete("Pendingapproval", "TPId=?", new String[]{"2"});
			//db.close();

		} else {

		}
		ActivityHelper.backFirstActivity();
		return 1;
	}
	public void DisplayDwspInfo(String id) {
		PendingapprovaliList=pendingapprovalDao.GetAlldwsp(id);
		System.out.println(PendingapprovaliList+"数据");
	}
	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		// TODO Auto-generated method stub

//		if(extrData!=null)
//			PendingapprovaliList=pendingapprovalDao.GetTeipeiById(extrData[0]);
		mVctSendData=new Vector<Vector<String> > ();


		for(HashMap<String,Object> Pend:PendingapprovaliList)
		{
			Vector<String> child= new Vector<String>();
			child.add((String)Pend.get("TPId"));
			child.add( ActivityHelper.information.strxxId);
			child.add( ActivityHelper.information.strSpare2);
			child.add( BaseActivity.gUser.getUserName());
			mVctSendData.add(child);
			System.out.println(mVctSendData+"要上传的数据");
		}
		return mVctSendData;
	}


//	  public int DeleteById(String strIds)
//			{
//		    	  //DELETE FROM Pendingapproval WHERE TPId
//		    	   db.execSQL("delete from Pendingapproval where TPId=?",   new Object[]{mstrDataId});
//				 return 1;
//			}


	@Override
	public MyProtocol GetProtocol() {
		MyProtocol myProtocol=new MyProtocol();
		//==信息中心==待我审批-表上传
		myProtocol.sendCmd0=DPProtocol.m_vfxVAG43Vcanxinxizhonxindwyd0;
		myProtocol.sendCmd1= DPProtocol.m_vfxVAG43Vcanxinxizhonxindwyd1;
		myProtocol.sendCmd2=DPProtocol.m_vfxVAG43Vcanxinxizhonxindwyd2;
		myProtocol.sendCmd3=DPProtocol.m_vfxVAG43Vcanxinxizhonxindwyd3;
		myProtocol.receCmd0=DPProtocol.m_vfxVAG43VcanxinxizhonxinRedwyd0;
		myProtocol.receCmd1=DPProtocol.m_vfxVAG43VcanxinxizhonxinRedwyd1;
		myProtocol.receCmd3=DPProtocol.m_vfxVAG43VcanxinxizhonxinRedwyd3;
		myProtocol.receCmd5=DPProtocol.m_vfxVAG43VcanxinxizhonxinRedwyd5;

		return myProtocol;
	}

}
