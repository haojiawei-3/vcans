package com.vcans.Processor;

import java.util.ArrayList;
import java.util.Vector;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class MlqdProcessor51 extends DownloadProcessor {

	Cursor cursor;
	String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	String gangyao;
	String Str;
	ContentValues  values;
	ArrayList<String> id;
	SQLiteDatabase db=SQLiteDatabase.openDatabase(path, null, 2);
	public  MlqdProcessor51(String Str){
		this.Str=Str;
	}
	@Override
	public int ProcessData() {
		initGoodsList();
		if(mDataTrunsfer.isDownloadContinue()){
			Log.e("TAG", "继续下载");
		}
		else{
			mActParent.processMessage(600,"");
		}
		return 0;
	}
	public void initGoodsList()

	{

		Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
		if(mDataTrunsfer!=null){
			vctReceData=this.mDataTrunsfer.GetReceiveData();
			for (int i = 0; i < vctReceData.size(); i++) {
				Vector<String> data = vctReceData.get(i);
				values = new ContentValues();
				values.put("khcode",  data.get(0));// 2 我已审批
				values.put("mark1",  "Y");
			}
			getID();
			for (int j = 0; j < id.size(); j++) {
				db.update("CustomerCollect", values, "TPId=?", new String[]{id.get(j)});
			}

		}

	}

	public ArrayList<String> getID(){
		id=new ArrayList<String>();
		String	 sql="select * from CustomerCollect where  khcode ="+"'"+Str+"'"+"  ";
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			String	 strId = cursor.getString(0);
			id.add(strId) ;
		}


		return id;
	}
	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		child.add(BaseActivity.gUser.getUserName());

		for(String str:extrData){
			child.add(str);
		}

		vctSendData.add(child);
		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {
		MyProtocol p=new MyProtocol();
		//==清单一==客户信息查询
		p.sendCmd1=DPProtocol.m_VCANSAPP_Mlqdml5_XIAZAI_1FZ1;
		//p.sendCmd2=DPProtocol.m_VCANSAPP_Mlqdml5_XIAZAI_1FZ2;
		p.receCmd0= DPProtocol.m_VCANSAPP_Mlqdml5_XIAZAI_1FZRe0;
		p.receCmd1=DPProtocol.m_VCANSAPP_Mlqdml5_XIAZAI_1FZRe1;
		//p.receCmd2=DPProtocol.m_VCANSAPP_Mlqdml5_XIAZAI_1FZRe2;
		return p;
	}

}
