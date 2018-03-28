package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Environment;

import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class Versioncomparison  extends DownloadProcessor{

	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	private BandleParam mBdParam=new BandleParam();
	SQLiteDatabase db;
	String Versionid;
	Cursor cursor;
	String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	String VersionId,id;
	public  Versioncomparison(String versionId){
		VersionId=versionId;
	}
	@Override


	public int ProcessData() {

		initGoodsList();

		return 1;
	}

	public void initGoodsList()
	{    ActivityHelper.Version=null;
		Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
		if(mDataTrunsfer!=null)
			vctReceData=this.mDataTrunsfer.GetReceiveData();
		for (int i = 0; i < vctReceData.size(); i++) {
			Vector<String> data = vctReceData.get(i);
			id=data.get(0);
		}
		ActivityHelper.Version=id;

		mActParent.processMessage(200,"");
	}






	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();
		//String id=Secure.getString(mActParent.getContentResolver(), Secure.ANDROID_ID);
		String IMEI=DPMenuProcessor.getDeviceId(); //Log.e("TAG", IMEI+"    IMEI码");
		String name=Build.MANUFACTURER+" "+Build.MODEL;	//Log.e("TAG", name+"     手机名称");
		Vector<String> child= new Vector<String>();
		child.add(VersionId);
		child.add(IMEI);
		child.add(name);
		vctSendData.add(child);

		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		p.sendCmd1=YPStandardProtocol.m_vfxVAG53VCANSBiaoZhun_PeiZhiXinXiBanBen;
		p.receCmd0= YPStandardProtocol.m_vfxVAG53VCANSBiaoZhun_PeiZhiXinXiBanBenRe0;
		p.receCmd1=YPStandardProtocol.m_vfxVAG53VCANSBiaoZhun_PeiZhiXinXiBanBenRe1;

		return p;
	}

}

