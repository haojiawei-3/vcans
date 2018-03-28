package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.widget.Toast;

import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.PendingapprovalDao;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ProtocolCMD;


public class UesrUploadProcessor extends UploadProcessor {
	Vector<Vector<String> > mVctSendData=null;
	public PendingapprovalDao pendingapprovalDao=null;
	List<HashMap<String,Object> > PendingapprovaliList=null;
	List<HashMap<String,Object> > PendingapprovaliList1=null;
	private BandleParam mBdParam=new BandleParam();
	SQLiteDatabase db;
	String strxxId,id;
	Cursor cursor;
	String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";


	public UesrUploadProcessor()
	{
		pendingapprovalDao=new PendingapprovalDao();
	}
	@Override
	public int ProcessData(Vector<String> vctDataId) {
		// TODO Auto-generated method stub
		Vector<Vector<String>> vctReceData;
		String strRecordIds=ConvertStringIds(vctDataId);
		System.out.println(strRecordIds+"上传返回的id");
		id=strRecordIds.replaceAll("'","");
		vctReceData=this.mDataTrunsfer.GetReceiveData();
		if (!strRecordIds.equals("")) {				//返回成功表示上传成功 修改本地标志到     2 我已审批   或     3   已阅未批
			db=SQLiteDatabase.openDatabase(path, null, 2);
			ContentValues values = new ContentValues();
			values.put("Spare1",  "2");// 2 我已审批
			db.update("Pendingapproval", values, "TPId=?", new String[]{id});
			//ActivityHelper.backFirstActivity();
			ActivityHelper.tp1=null;
			ActivityHelper.tp2=null;
			ActivityHelper.tp3=null;
			selectId();	  //查询当前消息的消息id
			DeleteGlxxId(strxxId);//删除   这条消息的所有操作
		} else {

		}

		return 1;
	}
	public void DisplayDwspInfo(String id) {
		PendingapprovaliList=pendingapprovalDao.GetAlldwsp(id);
		System.out.println(PendingapprovaliList+"数据");

	}
	public void DisplayDwspInfo1(ArrayList<String> listid) {
		PendingapprovaliList=pendingapprovalDao.GetAlldwsp1(listid);
		System.out.println(PendingapprovaliList+"数据");

	}
	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		// TODO Auto-generated method stub
		mVctSendData=new Vector<Vector<String> > ();


		for(HashMap<String,Object> Pend:PendingapprovaliList)
		{
			Vector<String> child= new Vector<String>();
			child.add((String)Pend.get("TPId"));
			child.add((String)Pend.get("XXId"));
			child.add(ActivityHelper.information.strSpare3);
			child.add(ActivityHelper.kzxx1);
			child.add(ActivityHelper.kzxx2);
			child.add(ActivityHelper.kzxx3);
			child.add(ActivityHelper.kzxx4);
			child.add(ActivityHelper.kzxx5);
			child.add(ActivityHelper.kzxx6);
			child.add(ActivityHelper.kzxx7);
			child.add(ActivityHelper.kzxx8);
			child.add(ActivityHelper.kzxx9);
			child.add(ActivityHelper.kzxx10);
			child.add(BaseActivity.gUser.getUserName());
			//child.add( BaseActivity.gUser.getUserName());
			String tp1=ActivityHelper.tp1;
			String tp2=ActivityHelper.tp2;
			String tp3=ActivityHelper.tp3;
			//if (tp1!=null) {
			child.add(ProtocolCMD.FILE_FIELD_FLAG+ActivityHelper.tp1);
			//}
			if (tp2!=null) {
				child.add(ProtocolCMD.FILE_FIELD_FLAG+ActivityHelper.tp2);
			}
			if (tp3!=null) {
				child.add(ProtocolCMD.FILE_FIELD_FLAG+ActivityHelper.tp3);
			}
			mVctSendData.add(child);
		}
		return mVctSendData;
	}
	public void selectId(){
		cursor= db.rawQuery("select * from Pendingapproval  where TPId = "+id+"  ", new String[]{});
		while (cursor.moveToNext()) {
			strxxId = cursor.getString(1);
		}
	}

	public int DeleteGlxxId(String strIds)
	{
		db.execSQL("delete from Pendingapprovalcz  where GlxxId = ?",   new Object[]{strIds});
		db.execSQL("delete from Pendingapprovalxx  where XxId = ?",   new Object[]{strIds});
		return 1;
	}


	@Override
	public MyProtocol GetProtocol() {
		MyProtocol myProtocol=new MyProtocol();
		//==信息中心==待我审批-表上传
		myProtocol.sendCmd0= DPProtocol.m_vfxVAG43Vcanxinxizhonxin0;
		myProtocol.sendCmd1=DPProtocol.m_vfxVAG43Vcanxinxizhonxin1;
		myProtocol.sendCmd2=DPProtocol.m_vfxVAG43Vcanxinxizhonxin2;
		myProtocol.sendCmd3=DPProtocol.m_vfxVAG43Vcanxinxizhonxin3;
		myProtocol.receCmd0=DPProtocol.m_vfxVAG43VcanxinxizhonxinRe0;
		myProtocol.receCmd1=DPProtocol.m_vfxVAG43VcanxinxizhonxinRe1;
		myProtocol.receCmd3=DPProtocol.m_vfxVAG43VcanxinxizhonxinRe3;
		myProtocol.receCmd5=DPProtocol.m_vfxVAG43VcanxinxizhonxinRe5;

		return myProtocol;
	}

}
