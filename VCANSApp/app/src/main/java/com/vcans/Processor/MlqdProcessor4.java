package com.vcans.Processor;

import java.util.Vector;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;
/**
 *
 * @author vcans
 *
 */
public class MlqdProcessor4 extends DownloadProcessor {
	//SQLiteDatabase db;
	Cursor cursor;

	String gangyao;
	boolean b=true;
	SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
	@Override
	public int ProcessData() {
		initGoodsList();
		if(mDataTrunsfer.isDownloadContinue()){
			Log.e("TAG", "继续下载");
		}
		else{
			mActParent.processMessage(200,gangyao);
			mActParent.processMessage(5000,"");
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
				b=true;
				ContentValues values = new ContentValues();
				values.put("Spare1",data.get(1));
				if (b==true) {
					db.update("MLQingdanone", values, "Code=?", new String[]{ data.get(0)});

				} else if(b==false){
					// Toast.makeText(mActParent,"1", 500).show();
				}
				gangyao=data.get(1);

			}
		}

	}
	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		for(String str:extrData){
			child.add(str);
		}

		child.add(BaseActivity.gUser.getUserName());

		vctSendData.add(child);
		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {
		MyProtocol p=new MyProtocol();
		//==面料清单==目录下载-
		p.sendCmd1=DPProtocol.m_VCANSAPP_Mlqdml4_XIAZAI_1FZ1;
		p.sendCmd2= DPProtocol.m_VCANSAPP_Mlqdml4_XIAZAI_1FZ2;
		p.receCmd0=DPProtocol.m_VCANSAPP_Mlqdml4_XIAZAI_1FZRe0;
		p.receCmd1=DPProtocol.m_VCANSAPP_Mlqdml4_XIAZAI_1FZRe1;
		p.receCmd2=DPProtocol.m_VCANSAPP_Mlqdml4_XIAZAI_1FZRe2;
		return p;
	}

}
