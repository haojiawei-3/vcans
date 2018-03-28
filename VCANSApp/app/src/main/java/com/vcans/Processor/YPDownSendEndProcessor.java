package com.vcans.Processor;

import java.util.Vector;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.Vcan.activity.MlqdActivity3;
import com.Vcan.activity.MlqdActivity4;
import com.Vcan.activity.MlqdActivity5;
import com.Vcan.activity.Pendingapproval0;
import com.Vcan.activity.Pendingapproval1;
import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.model.MyProtocol;

import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

/**
 *
 *
 *
 * 文件模式上传完成*/
public class YPDownSendEndProcessor extends DownloadProcessor
{
	String mErrDataIds="";
	String ErrId="";
	SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
	Cursor cursor;
	public YPDownSendEndProcessor()
	{

	}


	@Override
	public int ProcessData()
	{

		Vector<Vector<String> > vctReceData= mDataTrunsfer.GetReceiveData();
		byte[]  vctReceData1=mDataTrunsfer.GetFileData();
		for(Vector<String> vctFields : vctReceData)
		{
			System.out.println(vctFields+"99999999999999999999999999");

		}

		if(!mErrDataIds.equals("")){
			ActivityHelper.ShowErrMsg(PlProcessor.mActParent,mErrDataIds+"\r\n部分上传完成,含发送错误的数据ID：\r\n"+ErrId+"333");
			mErrDataIds="";
			ErrId="";
			ActivityHelper.closeStatusDialog();
		}

		else
		{
			ActivityHelper.showDialog(PlProcessor.mActParent,"","上传完成.");
			//ActivityHelper.closeStatusDialog();
			//ActivityHelper.backFirstActivity();
			String bz=ActivityHelper.biaozhi;
			if (bz!=null) {
				if(bz.equals("100")){
					ActivityHelper.finishActivity( Pendingapproval0.pendingapproval0);
					ActivityHelper.finishActivity(Pendingapproval1.pendingapproval1);
				}else {
					new Handler().postDelayed(new Runnable() {
						public void run() {
//							ActivityHelper.finishActivity(Pendingapproval0.pendingapproval0);
//							ActivityHelper.finishActivity(Pendingapproval1.pendingapproval1);
							if (sb()) {

								AppManager.getAppManager().finishActivity(MlqdActivity4.mlqdActivity4);
								AppManager.getAppManager().finishActivity(MlqdActivity5.mlqdActivity5);
								AppManager.getAppManager().finishActivity(MlqdActivity3.mlqdActivity3);
								Intent intent = new Intent(mActParent, MlqdActivity3.class);
								mActParent.startActivity(intent);
							} else {
								AppManager.getAppManager().finishActivity(MlqdActivity3.mlqdActivity3);
								AppManager.getAppManager().finishActivity(MlqdActivity4.mlqdActivity4);
								AppManager.getAppManager().finishActivity(MlqdActivity5.mlqdActivity5);
							}


						}
					}, 10);
				}
				ActivityHelper.biaozhi=null;
			}
			ActivityHelper.closeStatusDialog();
		}

		return 1;
	}

	public boolean sb(){
		boolean b=false;
		String	 sql="select * from Collect  ";
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			b=true;
		}
		return b;
	}

	public  Vector<Vector<String> > GetSendData(String[] extrData)
	{
		if(extrData.length>0)
			mErrDataIds=extrData[0];
		ErrId=extrData[1];
		Vector<Vector<String> > vctSendData=new Vector<Vector<String> >();
		Vector<String> vctChild=new Vector<String>();
		vctChild.add("");
		vctSendData.add(vctChild);
		return vctSendData;

	}

	public MyProtocol GetProtocol()
	{
		MyProtocol p =new MyProtocol();

		p.sendCmd1= YPStandardProtocol.m_vfxVcans_SendEndNotify1;
		p.receCmd0=YPStandardProtocol.m_vfxVcans_SendEndNotifyRe0;
		p.receCmd1=YPStandardProtocol.m_vfxVcans_SendEndNotifyRe1;

		return p;
	}
}
