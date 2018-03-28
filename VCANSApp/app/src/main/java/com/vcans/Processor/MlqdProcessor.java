package com.vcans.Processor;
import java.util.List;
import java.util.Vector;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.YPInfoDao.DbType;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;
/**
 *
 *
 * 下载清单界面*/
public class MlqdProcessor extends DownloadProcessor {
	SQLiteDatabase  db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
	Cursor cursor;
	String strId,xxId;
	String filePaths="";
	List<byte[]> imgList;
	DbType queryType;
	Vector<String> data ;

	Vector<Vector<String> > vctReceData;

	@Override
	public int ProcessData() {
		// TODO Auto-generated method stub
		initGoodsList();

		if(mDataTrunsfer.isDownloadContinue()){
		}
		else{
			mActParent.processMessage(100,"");
			mActParent.processMessage(5000,"");
		}
		//mActParent.processMessage(200,"");

		return 0;
	}
	public void initGoodsList()
	{   try {


		vctReceData=new Vector<Vector<String> > ();
		vctReceData=this.mDataTrunsfer.GetReceiveData();


		imgList=mDataTrunsfer.getFileByteList();

		for(Vector<String> vctFields : vctReceData)
		{

			SaveYpInfo(vctFields);
		}
		if(mDataTrunsfer!=null){

			for (int i = 0; i < vctReceData.size(); i++) {
				data = vctReceData.get(i);
				ContentValues values = new ContentValues();
				values.put("Cj",data.get(0));
				values.put("Mlbh",data.get(1));
				values.put("Mlname", data.get(2));
				values.put("Ssfjbh",  data.get(3));
				values.put("Spare",  filePaths);
				values.put("Spare1",  "null");
				db.insert("MLQingdan", null, values);


			}
		}
	} catch (Exception e) {
		// TODO: handle exception
	}


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
			filePaths="";
			if(imgList.get(imageIndex)!=null){

				filePaths=ActivityHelper.fileBtyeToFile(imgList.get(imageIndex),data.get(0)+data.get(1)+data.get(2)+data.get(3));
				System.out.println(filePaths+"图片地址");

			}
			else{

			}

		}

	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();



		db.delete("MLQingdan",null,null);
		db.delete("MLQingdanone",null,null);
		db.delete("Collect",null,null);
		child.add(BaseActivity.gUser.getUserName());

		vctSendData.add(child);
		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();
		//==面料清单==目录下载-
		p.sendCmd1=DPProtocol.m_VCANSAPP_Mlqdml_XIAZAI_1FZ1;
		p.sendCmd2= DPProtocol.m_VCANSAPP_Mlqdml_XIAZAI_1FZ2;
		p.receCmd0=DPProtocol.m_VCANSAPP_Mlqdml_XIAZAI_1FZRe0;
		p.receCmd1=DPProtocol.m_VCANSAPP_Mlqdml_XIAZAI_1FZRe1;
		p.receCmd2=DPProtocol.m_VCANSAPP_Mlqdml_XIAZAI_1FZRe2;
		return p;
	}

}
