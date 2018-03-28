package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.vcans.Protocol.DPProtocol;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class PendingapprovalProcessor1 extends DownloadProcessor {

	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	private BandleParam mBdParam=new BandleParam();
	private String mWhereSQL = null;
	boolean b=true;
	SQLiteDatabase db;
	Cursor cursor;
	String strId,xxId;
	String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	@Override
	public int ProcessData() {

		initGoodsList();

		if(mDataTrunsfer.isDownloadContinue()){
			Log.e("TAG", "继续下载");
		}
		else{
			mActParent.SendParam1();
			mActParent.processMessage(1000,"");
		}
		return 1;
	}

	public void initGoodsList()
	{   db=SQLiteDatabase.openDatabase(path, null, 2);
		Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
		if(mDataTrunsfer!=null)
			vctReceData=this.mDataTrunsfer.GetReceiveData();
//		    int s=vctReceData.size();
//		    Log.e("TAG", s+"789456123");
		for (int i = 0; i < vctReceData.size(); i++) {
			Vector<String> data = vctReceData.get(i);
			b=true;
			System.out.println(data+"数据库");

			ContentValues values = new ContentValues();
			values.put("XXId",data.get(0));
			values.put("Type",data.get(1));
			values.put("Themer", data.get(2));
			values.put("Initiator",  data.get(3));
			values.put("Content",  data.get(4));
			values.put("Spare4",  data.get(5));
			values.put("StateId", data.get(6));
			values.put("State",  data.get(7));
			values.put("Moduletype",  data.get(8));
			values.put("ModuletypeId",  data.get(9));
			values.put("ModuleName",  data.get(10));
			values.put("Odd",  data.get(11));
			values.put("OddId", data.get(12));
			values.put("Date",  data.get(13));
			values.put("Spare1",  "0");
			values.put("Spare2",  "null");
			values.put("Spare3",  "null");
			values.put("Spare5",  "null");
			if (b==true) {
				cursor=db.rawQuery("select * from Pendingapproval  where Moduletype = "+"'"+data.get(8)+"'"+" and ModuletypeId = "+data.get(9)+" and OddId = "+data.get(12)+" and Spare1= 0", new String[]{});
				while (cursor.moveToNext()) {
					strId = cursor.getString(0);
					xxId  = cursor.getString(1);
				}
				DeleteGlxxId(xxId);
				db.execSQL("delete from Pendingapproval where TPId=?",   new Object[]{strId});//要保持单据的最新状态
				db.insert("Pendingapproval", null, values);
				// Toast.makeText(mActParent, "0", 500).show();
			} else if(b==false){
				// Toast.makeText(mActParent,"1", 500).show();
			}

		}
		//mActParent.SendParam1();
	}
	public int DeleteGlxxId(String strIds)
	{
		db.execSQL("delete from Pendingapprovalcz  where GlxxId = ?",   new Object[]{strIds});
		db.execSQL("delete from Pendingapprovalxx  where XxId = ?",   new Object[]{strIds});
		return 1;
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();
		if (BaseActivity.gUser==null) {
			Toast.makeText(mActParent, "未连接服务器", 500).show();
		}else{child.add(BaseActivity.gUser.getUserName());}


		vctSendData.add(child);
		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();
		//==信息中心==待我审批-
		p.sendCmd1=DPProtocol.m_VCANSAPP_XINXIZHONXIN_CZXIAZAI_1FZ1;
		p.sendCmd2= DPProtocol.m_VCANSAPP_XINXIZHONXIN_CZXIAZAI_1FZ2;
		p.receCmd0=DPProtocol.m_VCANSAPP_XINXIZHONXIN_CZXIAZAI_1FZRe0;
		p.receCmd1=DPProtocol.m_VCANSAPP_XINXIZHONXIN_CZXIAZAI_1FZRe1;
		p.receCmd2=DPProtocol.m_VCANSAPP_XINXIZHONXIN_CZXIAZAI_1FZRe2;
		return p;
	}

}
