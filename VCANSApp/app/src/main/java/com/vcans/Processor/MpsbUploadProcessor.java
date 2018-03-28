package com.vcans.Processor;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.content.Intent;

import cn.sharp.android.ncr.DisplayRecResult;
import com.Vcan.activity.YPExposition;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.MpsbDao;
import com.vcans.model.Mpsbinfo;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ProtocolCMD;

/**
 *
 *  @since 2016 08
 * @author hjw
 */
public class MpsbUploadProcessor extends UploadProcessor {
	public MpsbDao mpsbDao=null;
	Vector<Vector<String> > mVctSendData=null;
	List<HashMap<String,Object> > mpsbiList=null;
	//private BandleParam mBdParam=new BandleParam();
	String company,ok,strImage,code,id,biao;
	Vector<String> c;
	Vector<String> ids;
	public MpsbUploadProcessor(String id)
	{
		mpsbDao=new MpsbDao();
		this.biao=id;
	}
	//[[数据[1笔]全部处理失败:1.单据表头信息PostNewBillNumber()中发生异常:【简称】:禁止为空！], [3]]
	@Override
	public int ProcessData(Vector<String> vctDataId) {
		Vector<Vector<String>> vctReceData;

		if (vctDataId.size()==0) {
			if (biao.equals("1")) {
				vctReceData=this.mDataTrunsfer.GetReceiveData();
				ids=vctReceData.get(1);
				id=ids.get(0);
				DeleteMpsdInfo(id);
			}
//


		}else{
			for (int i = 0; i < vctDataId.size(); i++) {
				DeleteMpsdInfo(vctDataId.get(i));
			}
			vctReceData=this.mDataTrunsfer.GetReceiveData();
			c=vctReceData.get(0);
			code=c.get(0);
		}
//			 c=vctReceData.get(0);
//			 code=c.get(0);
		String strRecordIds=ConvertStringIds(vctDataId);
//		     id=strRecordIds.replaceAll("'","");
//		     ids=vctReceData.get(1);
//		     id1=ids.get(0);
//			// mpsbDao.DeleteAll(strRecordIds);
//		     if ( id.equals("")) {
//		    	 DeleteMpsdInfo(id1);
//			 }else {
//				 DeleteMpsdInfo(id);
////			 }
//			         SharedPreferences sharedPreferences = mActParent.getSharedPreferences("biaozhi",  Activity.MODE_PRIVATE);
//					 String name = sharedPreferences.getString("biaozhi", "");
		if (biao.equals("1")&&!strRecordIds.equals("")) {
			Intent intent=new Intent(mActParent,YPExposition.class);
			intent.putExtra("name",strImage);
			intent.putExtra("company",company);
			intent.putExtra("code",code);
			mActParent.startActivity(intent);
			DisplayRecResult.instance.finish();
		} else {
			//Toast.makeText(mActParent, "名片识读", Toast.LENGTH_SHORT).show();
			ActivityHelper.Code=code;
			//	DisplayRecResult.instance.finish();
		}
		mActParent.processMessage(200,"");
		return 1;
	}
	public void DisplayMpsbInfo() {		//展会寻样的上传
		mpsbiList=mpsbDao.GetAllMpsb();
		System.out.println("0000000000000000000"+mpsbiList+"5555555555555555555555555");
	}
	public void DisplayMpsbInfoo() {    //名片识读的上传
		mpsbiList=mpsbDao.GetAllMpsbb();
		System.out.println("5555555555555555"+mpsbiList+"55555555555555555");
	}
	public void SaveToupeiInfo(){
		Mpsbinfo mpsb=ActivityHelper.mp;
		mpsbDao.AddMpsb(mpsb);
	}



	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
//		if(extrData!=null){
//			mpsbiList=mpsbDao.GetTeipeiById(extrData[0]);
//
//	    }
		mVctSendData=new Vector<Vector<String> > ();

		for(HashMap<String,Object> Mpsb:mpsbiList)
		{
			Vector<String> child= new Vector<String>();
			//上传记录格式[id,公司简称,客户姓名,职位,phone1,phone2,传真,地址,公司网站,email,备注]
			// company, linkname ,position ,phone1, phone2, fax ,address , www ,email ,note;
			child.add((String)Mpsb.get("TPId"));
			child.add((String)Mpsb.get("company"));
			child.add((String)Mpsb.get("linkname"));
			child.add((String)Mpsb.get("position"));
			child.add((String)Mpsb.get("phone1"));
			child.add((String)Mpsb.get("phone2"));
			child.add((String)Mpsb.get("fax"));
			child.add((String)Mpsb.get("address"));
			child.add((String)Mpsb.get("www"));
			child.add((String)Mpsb.get("email"));
			child.add((String)Mpsb.get("note"));
			strImage=(String)Mpsb.get("ImgPath");
			if(!strImage.equals(""))
				child.add(ProtocolCMD.FILE_FIELD_FLAG+strImage);
			mVctSendData.add(child);
			//拿到我上传id    上传完成进行删除
			Vector<String> s=mVctSendData.get(0);
			company=s.get(1);

			System.out.println(mVctSendData);
		}

		return mVctSendData;
	}


	public void ClearMpsdInfo()
	{
		System.out.println("123123123");
		mpsbDao.DeleteAll(null);
		DisplayMpsbInfo();
	}

	public void DeleteMpsdInfo(String dataId)
	{
		mpsbDao.DeleteById(dataId);
	}
	@Override
	public MyProtocol GetProtocol() {

		MyProtocol myProtocol=new MyProtocol();
		myProtocol.sendCmd0=DPProtocol.m_vfxVAG43VcanMingpianshibie0;
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
