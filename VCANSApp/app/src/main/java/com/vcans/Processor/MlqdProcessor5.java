package com.vcans.Processor;

import java.util.Vector;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class MlqdProcessor5 extends DownloadProcessor {
	SQLiteDatabase db;
	Cursor cursor;
	String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	String gangyao;
	@Override
	public int ProcessData() {
		initGoodsList();
		if(mDataTrunsfer.isDownloadContinue()){
			Log.e("TAG", "继续下载");
		}
		else{
			//mActParent.processMessage(200,gangyao);
		}
		return 0;
	}
	public void initGoodsList()
	{    //db=SQLiteDatabase.openDatabase(path, null, 2);
		Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
		if(mDataTrunsfer!=null){
			vctReceData=this.mDataTrunsfer.GetReceiveData();
			for (int i = 0; i < vctReceData.size(); i++) {
				Vector<String> data = vctReceData.get(i);
				ActivityHelper.data=data;
				mActParent.processMessage(200,gangyao);
			}

		}

	}
	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();
		if (BaseActivity.gUser==null) {
			Toast.makeText(mActParent, "系统未登录或已退出，稍后重试", 500).show();
			//mActParent.processMessage(200,"");
		}else{
			child.add(BaseActivity.gUser.getUserName());
		}
		for(String str:extrData){
			child.add(str);   	}

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
