package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.YPInfoDao.DbType;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class PendingapprovalProcessor4 extends DownloadProcessor {

	//List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	private BandleParam mBdParam=new BandleParam();
	List<String> mDataList=new ArrayList<String>();
	List<byte[]> imgList;
	DbType queryType;
	private String fileName="";
	String filePaths="";
	Bitmap bm;
	private Bitmap[] bitmap;
	Cursor cursor;
	//String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	String strId,ss;
	SQLiteDatabase  db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);

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
		imgList=mDataTrunsfer.getFileByteList();
		HashMap<String,String> mapParms=new HashMap<String,String>();

		if(queryType==DbType.YP_IMAGE)
			mapParms.put("preImageNum", imgList.size()+"");

		ActivityHelper.saveParams(mActParent, mapParms);


		for(Vector<String> vctFields : vctReceData)
		{

			SaveYpInfo(vctFields);
		}

		ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.loadSuccess));
		//刷新数据
		mActParent.processMessage(1,"");

		fileName="";

		for(Vector<String> record:vctReceData)
		{
			for(String v:record)
			{
				mDataList.add(v);
			}
		}
		TextView  gangyao=(TextView)mActParent.findViewById(R.id.gangyao);
		gangyao.setText(mDataList.get(1));

		ContentValues values = new ContentValues();
		cursor = db.rawQuery("select * from Pendingapproval  where  XXId = "+mDataList.get(0)+"  ", new String[]{});
		while (cursor.moveToNext() ){
			strId = cursor.getString(0);
		}
		if (mDataList.get(1)==null) {
			ss="null";
		} else {
			ss= mDataList.get(1);
		}
		values.put("Spare3", ss);
		values.put("Spare5", filePaths);
		db.update("Pendingapproval", values, "TPId=?", new String[]{strId});
	}



	public void SaveYpInfo(Vector<String> vctRecord)
	{
		int nStartImageIndex=-1;
		int imageIndex=0;

		if(nStartImageIndex==-1)
			nStartImageIndex=vctRecord.size()-imgList.size();



		for(int i=0;i<imgList.size();i++)
		{
			imageIndex=Integer.valueOf(vctRecord.get(nStartImageIndex+i));

			if(imgList.get(imageIndex)!=null){
				filePaths+=ActivityHelper.fileBtyeToFile(imgList.get(imageIndex),imageIndex)+"";
				System.out.println(filePaths+"图片地址");
				tupian();
			}
			else
				filePaths+="null";
		}

	}




	public void tupian() {
		// TODO Auto-generated method stub
		ImageView imgsrc=(ImageView)mActParent.findViewById(R.id.imgsrc);
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 2;
		Bitmap bm = BitmapFactory.decodeFile(filePaths);
		Log.e("TAG", "方法里的图片地址："+filePaths);
		bitmap = YPDownYpInfoProcessor.getBitmapsByFilepaths(filePaths);
		ActivityHelper.filePaths=filePaths;
		ActivityHelper.Bitmaps=bitmap;
		imgsrc.setImageBitmap(bm);

	}


	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		//child.add(ActivityHelper.gToupei.strOutNotifyId);

		//child.add(BaseActivity.gUser.getUserName());
		if (BaseActivity.gUser==null) {
			Toast.makeText(mActParent, "未连接服务器", 500).show();
		}else{
			child.add(BaseActivity.gUser.getUserName());
			child.add(ActivityHelper.information.strxxId); }
		vctSendData.add(child);
		System.out.println(vctSendData);
		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		p.sendCmd1= DPProtocol.m_VCANSAPP_XINXIZHONXIN1;
		p.receCmd0=DPProtocol.m_VCANSAPP_XINXIZHONXINRe0;
		p.receCmd1=DPProtocol.m_VCANSAPP_XINXIZHONXINRe1;
		return p;
	}

}
