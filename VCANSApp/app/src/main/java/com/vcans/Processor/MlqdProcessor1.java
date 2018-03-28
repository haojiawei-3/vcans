package com.vcans.Processor;

import java.util.List;
import java.util.Vector;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;
/**
 *
 * @author vcans
 *
 */
public class MlqdProcessor1 extends DownloadProcessor {
	Cursor cursor;
	String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	Vector<Vector<String> > vctReceData;
	List<byte[]> imgList;
	String filePaths="";
	Vector<String> data;
	ContentValues values;
	boolean b=true;
	SQLiteDatabase db=SQLiteDatabase.openDatabase(path, null, 2);

	@Override
	public int ProcessData() {
		initGoodsList();

		if(mDataTrunsfer.isDownloadContinue()){
			// Log.e("TAG", "继续下载");

		}
		else{
			mActParent.processMessage(200,"");
			mActParent.processMessage(999,"");
		}
		return 0;
	}
	public void initGoodsList()
	{
		vctReceData=new Vector<Vector<String> > ();
		vctReceData=this.mDataTrunsfer.GetReceiveData();
		if(mDataTrunsfer!=null){
			for (int i = 0; i < vctReceData.size(); i++){
				data = vctReceData.get(i);
				b=true;
				values = new ContentValues();
				values.put("Code",data.get(0));
				values.put("Pnumber",data.get(1));
				values.put("Pname", data.get(2));
				values.put("Description1",  data.get(3));
				values.put("Description2",  data.get(4));
				values.put("Description3",  data.get(5));
				values.put("Filter1",  data.get(6));
				values.put("Filter2",  data.get(7));
				values.put("Filter3",  data.get(8));
				values.put("mulu2",  data.get(9));
				values.put("mulu3",  data.get(10));
				values.put("Quotation",  data.get(11));
				values.put("Spare",  "null");
				values.put("Spare1",  "null");
				values.put("Spare2",  "null");
				values.put("Spare3",  "null");
				values.put("Spare4",  "1");
				if (b==true) {
					db.execSQL("delete from MLQingdanone where Code = "+"'"+data.get(0)+"'"+"  ",   new Object[]{});
					db.insert("MLQingdanone", null, values);

				} else if(b==false){
					// Toast.makeText(mActParent,"1", 500).show();
				}


			}
			imgList=mDataTrunsfer.getFileByteList();
			for(Vector<String> vctFields : vctReceData)
			{
				SaveYpInfo(vctFields);
			}
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

				filePaths=ActivityHelper.fileBtyeToFile(imgList.get(imageIndex),data.get(0)+data.get(1));
				values.put("Spare3", filePaths);
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


		if(BaseActivity.gUser==null)
		{

		}else {
			child.add(BaseActivity.gUser.getUserName());
		}

		vctSendData.add(child);
		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {
		MyProtocol p=new MyProtocol();
		//==面料清单==目录下载-
		p.sendCmd1=DPProtocol.m_VCANSAPP_Mlqdml2_XIAZAI_1FZ1;
		p.sendCmd2= DPProtocol.m_VCANSAPP_Mlqdml2_XIAZAI_1FZ2;
		p.receCmd0=DPProtocol.m_VCANSAPP_Mlqdml2_XIAZAI_1FZRe0;
		p.receCmd1=DPProtocol.m_VCANSAPP_Mlqdml2_XIAZAI_1FZRe1;
		p.receCmd2=DPProtocol.m_VCANSAPP_Mlqdml2_XIAZAI_1FZRe2;
		return p;
	}

}
