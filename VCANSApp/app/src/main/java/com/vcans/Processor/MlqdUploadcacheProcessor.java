package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.database.sqlite.SQLiteDatabase;

import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.CacheDao;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class MlqdUploadcacheProcessor  extends UploadProcessor{
	Vector<Vector<String> > mVctSendData=null;
	List<String> list;
	List<HashMap<String,Object> > CacheYIDList=new ArrayList<HashMap<String,Object>>();
	public CacheDao cacheDao=null;
	List<String> id=new ArrayList<String>();
	String StrID;
	SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
	public MlqdUploadcacheProcessor()
	{
		cacheDao=new CacheDao();
	}
	@Override
	public int ProcessData(Vector<String> vctDataId) {
		// TODO Auto-generated method stub
		if (vctDataId!=null) {
			for (int i = 0; i < vctDataId.size(); i++) {
				db.execSQL("delete from CustomerCollect  where TPId = ?",   new Object[]{vctDataId.get(0)});
			}

		}


		return 0;
	}


	public void DisplayMlqdInfo(ArrayList<String> listid) {
		id=listid;
		CacheYIDList= cacheDao.GetAllCache1(listid);


	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		mVctSendData=new Vector<Vector<String> > ();
		// TODO Auto-generated method stub
		for(HashMap<String,Object> Pend:CacheYIDList)
		{
			Vector<String> child= new Vector<String>();
			//[采集器记录ID,客户条码,样品条码,报价,数量,客户简称,登陆用户名]
			StrID=(String)Pend.get("TPId");
			child.add(StrID);
			child.add((String)Pend.get("khcode"));
			child.add((String)Pend.get("ypcode"));
			child.add((String)Pend.get("price"));
			child.add((String)Pend.get("number"));
			child.add((String)Pend.get("khname"));
			child.add(BaseActivity.gUser.getUserName());
			mVctSendData.add(child);

		}
		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {
		MyProtocol myProtocol=new MyProtocol();
		//==//==清单一==表上传
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
