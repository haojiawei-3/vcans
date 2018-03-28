package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.widget.Toast;

import com.vcans.Protocol.DPProtocol;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class PendingapprovalProcessor2 extends DownloadProcessor {

	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	private BandleParam mBdParam=new BandleParam();

	Cursor cursor;
	String strId;
	boolean b=true;
	String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	SQLiteDatabase db=SQLiteDatabase.openDatabase(path, null, 2);
	@Override
	public int ProcessData() {

		initGoodsList();

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

			ContentValues values = new ContentValues();
			values.put("GlxxId",  data.get(0));
			values.put("Type", data.get(1));
			values.put("CzId", data.get(2));
			values.put("Czname", data.get(3));

			if (b==true) {

//		 			cursor=db.rawQuery("select * from Pendingapprovalcz  where GlxxId = "+data.get(0)+" and Type = "+data.get(1)+" and CzId = "+data.get(2)+" ", new String[]{});
//		 			 while (cursor.moveToNext()) {  
//		 	        	strId = cursor.getString(0); 		 		    			 		         		 	          
//		 	        	
//		 	        }	
				db.execSQL("delete from Pendingapprovalcz  where GlxxId = "+data.get(0)+" and Type = "+data.get(1)+" and CzId = "+data.get(2)+" ",   new Object[]{});
				db.insert("Pendingapprovalcz", null, values);
				// Toast.makeText(mActParent, "0", 500).show();
			} else if(b==false){
				//Toast.makeText(mActParent,"1", 500).show();
			}
		}



	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		//child.add(ActivityHelper.gToupei.strOutNotifyId);   
		//child.add(BaseActivity.gUser.getUserName());
		if (BaseActivity.gUser==null) {
			Toast.makeText(mActParent, "未连接服务器", 500).show();
		}else{child.add(BaseActivity.gUser.getUserName());}

		vctSendData.add(child);
		System.out.println(vctSendData);
		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();
		p.sendCmd1=DPProtocol.m_VCANSAPP_XINXIZHONXIN_XXIAZAI_1FZ1;
		p.sendCmd2= DPProtocol.m_VCANSAPP_XINXIZHONXIN_XXIAZAI_1FZ2;
		p.receCmd0=DPProtocol.m_VCANSAPP_XINXIZHONXIN_XXIAZAI_1FZRe0;
		p.receCmd1=DPProtocol.m_VCANSAPP_XINXIZHONXIN_XXIAZAI_1FZRe1;
		p.receCmd2=DPProtocol.m_VCANSAPP_XINXIZHONXIN_XXIAZAI_1FZRe2;
		return p;
	}

}
