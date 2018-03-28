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

public class mpsbProcessor extends UploadProcessor {
	Vector<Vector<String> > mVctSendData=null;
	String khmh;
	String[] Data;
	String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	SQLiteDatabase db=SQLiteDatabase.openDatabase(path, null, 2);
	Cursor cursor;
	ContentValues values;
	public mpsbProcessor(String[] extrData) {
		// TODO Auto-generated constructor stub
		Data=extrData;
	}

	@Override
	public int ProcessData(Vector<String> vctDataId) {
		initGoodsList();
		if(mDataTrunsfer.isDownloadContinue()){
			Log.e("TAG", "继续下载");
		}
		else{
			mActParent.processMessage(1000,"");
			mActParent.processMessage(300,khmh);

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
				khmh=data.get(0);
				mActParent.processMessage(100,khmh);
				values = new ContentValues();
				values.put("khcode",  khmh);// 2 我已审批
				values.put("standby2",  "N");
				values.put("mark",  "Y");
				//values.put("mark1",  "Y");



			}
			for (int j = 0; j < getID().size(); j++) {
				db.update("CustomerCollect", values, "TPId=?", new String[]{getID().get(j)});
			}

		}

	}


	public ArrayList<String> getID(){
		ArrayList<String> id=new ArrayList<String>();
		String	 sql="select * from CustomerCollect where  khname ="+"'"+Data[1]+"'"+" and linkman ="+"'"+Data[2]+"'"+" and Phone ="+"'"+Data[3]+"'"+"   and addr ="+"'"+Data[4]+"'"+" ";
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			String	 strId = cursor.getString(0);
			id.add(strId) ;
		}


		return id;
	}


	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		mVctSendData=new Vector<Vector<String> > ();

		// shkbh,skhmc,slxr,slxdh,slxadd [客户编号][客户名称][联系人][电话][地址]
		Vector<String> child= new Vector<String>();
		//上传记录格式[id,公司简称,客户姓名,职位,phone1,phone2,传真,地址,公司网站,email,备注]
		child.add("1");
		child.add(Data[1]);//公司简称
		child.add(Data[2]);  //客户姓名
		child.add("职位");   //职位
		child.add(Data[3]);//phone1
		child.add("phone2");
		child.add("fax");
		child.add(Data[4]);//地址
		child.add("www");
		child.add("email");
		child.add(Data[5]);	//备注
		child.add("图片");
		mVctSendData.add(child);
		System.out.println(mVctSendData);


		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {
		MyProtocol myProtocol=new MyProtocol();
		myProtocol.sendCmd0= DPProtocol.m_vfxVAG43VcanMingpianshibie0;
		myProtocol.sendCmd1=DPProtocol.m_vfxVAG43VcanMingpianshibie1;
		myProtocol.sendCmd2=DPProtocol.m_vfxVAG43VcanMingpianshibie2;
		myProtocol.sendCmd3=DPProtocol.m_vfxVAG43VcanMingpianshibie3;
		myProtocol.receCmd0=DPProtocol.m_vfxVAG43VcanMingpianshibieRe0;
		myProtocol.receCmd1=DPProtocol.m_vfxVAG43VcanMingpianshibieRe1;
		myProtocol.receCmd3=DPProtocol.m_vfxVAG43VcanMingpianshibieRe3;
		myProtocol.receCmd5=DPProtocol.m_vfxVAG43VcanMingpianshibieRe5;
		return myProtocol;
	}

}
