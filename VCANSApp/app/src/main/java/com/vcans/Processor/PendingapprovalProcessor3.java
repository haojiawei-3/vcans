package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.vcans.Protocol.DPProtocol;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class PendingapprovalProcessor3 extends DownloadProcessor {

	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	private BandleParam mBdParam=new BandleParam();
	SQLiteDatabase db;
	boolean b=true;
	Cursor cursor;
	String strId;
	 String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	@Override
	public int ProcessData() {
		
		initGoodsList();
		if(mDataTrunsfer.isDownloadContinue()){

		}
		else{
			mActParent.processMessage(1000,"");
		}	
		return 1;
	}
	
	public void initGoodsList()
	{
		Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
		if(mDataTrunsfer!=null)
		    vctReceData=this.mDataTrunsfer.GetReceiveData();	
		for (int i = 0; i < vctReceData.size(); i++) {
			   Vector<String> data = vctReceData.get(i);
			   b=true;
			   db=SQLiteDatabase.openDatabase(path, null, 2);
		 	    ContentValues values = new ContentValues();			 	  			 	   
		 		values.put("XxId",  data.get(0));	 		
		 		values.put("CzId", data.get(1));
		 		values.put("Item", data.get(2));
		 		values.put("Czname", data.get(3));
		 		String Czname= data.get(3);		 
		 		try {//  XxId = "+data.get(0)+" and CzId = "+data.get(1)+" and Item = "+data.get(2)+"  and
//
//		 			cursor=db.rawQuery("select * from Pendingapprovalxx  where XxId = "+data.get(0)+" and CzId = "+data.get(1)+" and Item = "+data.get(2)+"  and Czname = "+"'"+Czname+"'"+" ", new String[]{});
//		 			 while (cursor.moveToNext()) {
//		 	        	strId = cursor.getString(0);
//		 	        	 b=false;
//		 	        }
//
				} catch (Exception e) {
					// TODO: handle exception
				}
		 		//if (b==true) {
		 			 db.insert("Pendingapprovalxx", null, values); 
				//}  else if(b==false){
					// Toast.makeText(mActParent,"1", 500).show();
				//}
			}
		
		
	}


	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		
		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();
		
		Vector<String> child= new Vector<String>();
		//child.add(BaseActivity.gUser.getUserName());
		child.add(BaseActivity.gUser.getUserName());
		child.add(ActivityHelper.informationxx.strXxId); 
		child.add(ActivityHelper.information.strSpare3); 
		vctSendData.add(child);
		
	    System.out.println(vctSendData);
	    return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {
		
		MyProtocol p=new MyProtocol();
		  //==����==��������==����֪ͨ����==����     
		p.sendCmd1=DPProtocol.m_VCANSAPP_XINXIZHONXIN_XIAZAI_1FZ1;
		p.sendCmd2= DPProtocol.m_VCANSAPP_XINXIZHONXIN_XIAZAI_1FZ2;
		p.receCmd0=DPProtocol.m_VCANSAPP_XINXIZHONXIN_XIAZAI_1FZRe0;
		p.receCmd1=DPProtocol.m_VCANSAPP_XINXIZHONXIN_XIAZAI_1FZRe1;
		p.receCmd2=DPProtocol.m_VCANSAPP_XINXIZHONXIN_XIAZAI_1FZRe2;
		return p;
	}

}

