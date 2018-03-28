package com.vcans.Processor;

import java.util.List;
import java.util.Vector;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class MlqdProcessor3 extends DownloadProcessor {

	Cursor cursor;
	String gangyao;
	List<byte[]> imgList;
	String filePaths="";
	ContentValues values;
	Vector<String> data ;
	boolean b=true;
	SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
	@Override
	public int ProcessData() {
		initGoodsList();
		if(mDataTrunsfer.isDownloadContinue()){
			Log.e("TAG", "继续下载");
		}
		else{
			mActParent.processMessage(2000,gangyao);
			mActParent.processMessage(3000, data.get(0));
			mActParent.processMessage(4000, "");//执行详情下载
		}
		return 0;
	}
	public void initGoodsList(){
		Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
		if(mDataTrunsfer!=null){
			vctReceData=this.mDataTrunsfer.GetReceiveData();
			for (int i = 0; i < vctReceData.size(); i++) {
				data = vctReceData.get(i);
				b=true;
				values = new ContentValues();
				values.put("Spare",data.get(1));
				if (b==true) {
					db.update("MLQingdanone", values, "Code=?", new String[]{ data.get(0)});

				} else if(b==false){
					// Toast.makeText(mActParent,"1", 500).show();
				}
				gangyao=data.get(1);

			}

			imgList=mDataTrunsfer.getFileByteList();

			for(Vector<String> vctFields : vctReceData)
			{

				SaveYpPic(vctFields);
			}
		}

	}

	public void SaveYpPic(Vector<String> vctRecord)
	{
		int nStartImageIndex=-1;
		int imageIndex=0;

		if(nStartImageIndex==-1){
			nStartImageIndex=vctRecord.size()-imgList.size();
		}

		for(int i=0;i<imgList.size();i++)
		{
			imageIndex=Integer.valueOf(vctRecord.get(nStartImageIndex+i));
			filePaths="";
			if(imgList.get(imageIndex)!=null){

				filePaths=ActivityHelper.fileBtyeToFile(imgList.get(imageIndex),data.get(0)+"报表");
				System.out.println(filePaths+"图片地址");
				values.put("Spare2", filePaths);
				db.update("MLQingdanone", values, "Code=?", new String[]{data.get(0)});

			}
			else{

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
           if(BaseActivity.gUser.getUserName()!=null)
           {
			   child.add(BaseActivity.gUser.getUserName());
           }
		//child.add(BaseActivity.gUser.getUserName());
		vctSendData.add(child);
		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {
		MyProtocol p=new MyProtocol();
		//==面料清单==
		p.sendCmd1=DPProtocol.m_VCANSAPP_Mlqdml3_XIAZAI_1FZ1;
		p.sendCmd2= DPProtocol.m_VCANSAPP_Mlqdml3_XIAZAI_1FZ2;
		p.receCmd0=DPProtocol.m_VCANSAPP_Mlqdml3_XIAZAI_1FZRe0;
		p.receCmd1=DPProtocol.m_VCANSAPP_Mlqdml3_XIAZAI_1FZRe1;
		p.receCmd2=DPProtocol.m_VCANSAPP_Mlqdml3_XIAZAI_1FZRe2;
		return p;
	}

}
