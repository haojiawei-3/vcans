package com.vcans.Processor;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.content.Intent;

import com.Vcan.activity.DPDetailInfo;
import com.Vcan.activity.DPRZTask31;
import com.Vcan.activity.DPRZTask32;
import com.Vcan.activity.R;
import com.Vcan.activity.SplashActivity;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.RZTask32Dao;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.model.RZTask3;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.ZDYzuhe;

public class DPRZTask32UploadProcessor extends UploadProcessor {
	public RZTask32Dao RZTask32Dao=null;
	List<HashMap<String,Object> > RZTask32DaoList=null;
	Vector<Vector<String> > mVctSendData=null;
	private String mModuleId="";
	private BandleParam mBdParam=new BandleParam();
	public DPRZTask32UploadProcessor(String s)
	{
		RZTask32Dao=new RZTask32Dao();
		mModuleId=s;
	}
	@Override
	public int ProcessData(Vector<String> vctDataId) {
		// TODO Auto-generated method stub
		if (vctDataId!=null) {
			for (int i = 0; i < vctDataId.size(); i++) {
				RZTask32Dao.DeleteById(vctDataId.get(i));
			}

		}

		DisplayTouPeiInfo();

		if(mDataTrunsfer.isDownloadContinue()){

		}
		else{
			//backFirstActivity();
			AppManager.getAppManager().finishActivity(DPRZTask31.DPRZTask31);
			AppManager.getAppManager().finishActivity(DPRZTask32.DPRZTask32);
		}

		return 1;
	}

	public void DisplayTouPeiInfo()
	{
		RZTask32DaoList=RZTask32Dao.GetAllTeipei();
		String[] szField={
				"ZhiDuan01Id",
				"ZhiDuan02Id",
				"ZhiDuan03Id",
				"ZhiDuan04Id",
				"ZhiDuan05Id",
				"ZhiDuan06Id",
				"ZhiDuan07Id",
				"ZhiDuan08Id",
				"ZhiDuan09Id",
				"ZhiDuan10Id",
				"ZhiDuan11Id",
				"ZhiDuan12Id",
				"ZhiDuan13Id",
				"ZhiDuan14Id",
				"ZhiDuan15Id",
				"ZhiDuan16Id",
				"ZhiDuan17Id",
				"ZhiDuan18Id",
				"ZhiDuan19Id",
				"ZhiDuan20Id",
				"ZhiDuan21Id",
				"ZhiDuan22Id",
				"ZhiDuan23Id",
				"ZhiDuan24Id",
				"ZhiDuan25Id",
				"ZhiDuan26Id",
				"ZhiDuan27Id",
				"TPId"};

		int[] szRId={R.id.tvBYName1v,
				R.id.tvBYName2v,
				R.id.tvBYName3v,
				R.id.tvBYName4v,
				R.id.tvBYName5v,
				R.id.tvBYName6v,
				R.id.tvBYName7v,
				R.id.tvBYName8v,
				R.id.tvBYName9v,
				R.id.tvBYName10v,
				R.id.tvBYName11v,
				R.id.tvBYName12v,
				R.id.tvBYName13v,
				R.id.tvBYName14v,
				R.id.tvBYName15v,
				R.id.tvBYName16v,
				R.id.tvBYName17v,
				R.id.tvBYName18v,
				R.id.tvBYName19v,
				R.id.tvBYName20v,
				R.id.tvBYName21v,
				R.id.tvBYName22v,
				R.id.tvBYName23v,
				R.id.tvBYName24v,
				R.id.tvBYName25v,
				R.id.tvBYName26v,
				R.id.tvBYName27v,
				R.id.tvInnerId};

		BaseActivity.showList(mActParent,RZTask32DaoList,R.layout.dp_rztask32_item,szField,szRId,R.id.lvProdct,R.id.tvPage);

	}

	public void displayDetail(List<HashMap<String,Object> > mapInfo)
	{
		String[] szField={
				"ZhiDuan01Id",
				"ZhiDuan02Id",
				"ZhiDuan03Id",
				"ZhiDuan04Id",
				"ZhiDuan05Id",
				"ZhiDuan06Id",
				"ZhiDuan07Id",
				"ZhiDuan08Id",
				"ZhiDuan09Id",
				"ZhiDuan10Id",
				"ZhiDuan11Id",
				"ZhiDuan12Id",
				"ZhiDuan13Id",
				"ZhiDuan14Id",
				"ZhiDuan15Id",
				"ZhiDuan16Id",
				"ZhiDuan17Id",
				"ZhiDuan18Id",
				"ZhiDuan19Id",
				"ZhiDuan20Id",
				"ZhiDuan21Id",
				"ZhiDuan22Id",
				"ZhiDuan23Id",
				"ZhiDuan24Id",
				"ZhiDuan25Id",
				"ZhiDuan26Id",
				"ZhiDuan27Id",
				"TPId"};

		int[] szRId={R.id.tvBYName1v,
				R.id.tvBYName2v,
				R.id.tvBYName3v,
				R.id.tvBYName4v,
				R.id.tvBYName5v,
				R.id.tvBYName6v,
				R.id.tvBYName7v,
				R.id.tvBYName8v,
				R.id.tvBYName9v,
				R.id.tvBYName10v,
				R.id.tvBYName11v,
				R.id.tvBYName12v,
				R.id.tvBYName13v,
				R.id.tvBYName14v,
				R.id.tvBYName15v,
				R.id.tvBYName16v,
				R.id.tvBYName17v,
				R.id.tvBYName18v,
				R.id.tvBYName19v,
				R.id.tvBYName20v,
				R.id.tvBYName21v,
				R.id.tvBYName22v,
				R.id.tvBYName23v,
				R.id.tvBYName24v,
				R.id.tvBYName25v,
				R.id.tvBYName26v,
				R.id.tvBYName27v,
				R.id.tvInnerId};


		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.dp_rztask32_item;

		Intent intent=new Intent(mActParent,DPDetailInfo.class);
		intent.putExtra("data",mBdParam);
		mActParent.startActivity(intent);
	}

	public void SaveToupeiInfo()
	{
		RZTask3 dprzTask3=ActivityHelper.dprzTask3;

		ZDYzuhe   txt19=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe19);
		ZDYzuhe   txt20=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe20);
		ZDYzuhe   txt21=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe21);
		ZDYzuhe   txt22=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe22);
		ZDYzuhe   txt23=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe23);
		ZDYzuhe   txt24=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe24);
		ZDYzuhe   txt25=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe25);
		ZDYzuhe   txt26=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe26);
		ZDYzuhe   txt27=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe27);



		dprzTask3.tvBYName19v=txt19.GetText();
		dprzTask3.tvBYName20v=txt20.GetText();
		dprzTask3.tvBYName21v=txt21.GetText();
		dprzTask3.tvBYName22v=txt22.GetText();
		dprzTask3.tvBYName23v=txt23.GetText();
		dprzTask3.tvBYName24v=txt24.GetText();
		dprzTask3.tvBYName25v=txt25.GetText();
		dprzTask3.tvBYName26v=txt26.GetText();
		dprzTask3.tvBYName27v=txt27.GetText();



		if(dprzTask3.tvBYName19v.equals("")||dprzTask3.tvBYName20v.equals("")||dprzTask3.tvBYName21v.equals("")||dprzTask3.tvBYName22v.equals("")||dprzTask3.tvBYName23v.equals("")||
				dprzTask3.tvBYName24v.equals("")||dprzTask3.tvBYName25v.equals("")||dprzTask3.tvBYName26v.equals("")||dprzTask3.tvBYName27v.equals(""))
		{
			ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.isNUll));
			return ;
		}


		int nRst=RZTask32Dao.AddToupei(dprzTask3);
		if(nRst==0)
		{
			ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.datareplace));
			DisplayTouPeiInfo();
		}
		else if(nRst<1)
		{
			ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.saveFail));
		}
		else
		{
			ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.saveSuccess));
			DisplayTouPeiInfo();
		}
	}

	public void ClearToupeiInfo()
	{
		RZTask32Dao.DeleteAll(null);
		DisplayTouPeiInfo();
	}

	public void DeleteToupeiInfo(String dataId)
	{
		RZTask32Dao.DeleteById(dataId);
		DisplayTouPeiInfo();
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		if(extrData!=null)
			RZTask32DaoList=RZTask32Dao.GetTeipeiById(extrData[0]);

		mVctSendData=new Vector<Vector<String> > ();

		for(HashMap<String,Object> mapToupei:RZTask32DaoList)
		{
			Vector<String> child= new Vector<String>();

			//上传记录格式[内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]

			child.add((String)mapToupei.get("TPId"));
			child.add((String)mapToupei.get("ZhiDuan01Id"));
			child.add((String)mapToupei.get("ZhiDuan02Id"));
			child.add((String)mapToupei.get("ZhiDuan03Id"));
			child.add((String)mapToupei.get("ZhiDuan04Id"));
			child.add((String)mapToupei.get("ZhiDuan05Id"));
			child.add((String)mapToupei.get("ZhiDuan06Id"));
			child.add((String)mapToupei.get("ZhiDuan07Id"));
			child.add((String)mapToupei.get("ZhiDuan08Id"));
			child.add((String)mapToupei.get("ZhiDuan09Id"));
			child.add((String)mapToupei.get("ZhiDuan10Id"));
			child.add((String)mapToupei.get("ZhiDuan11Id"));
			child.add((String)mapToupei.get("ZhiDuan12Id"));
			child.add((String)mapToupei.get("ZhiDuan13Id"));
			child.add((String)mapToupei.get("ZhiDuan14Id"));
			child.add((String)mapToupei.get("ZhiDuan15Id"));
			child.add((String)mapToupei.get("ZhiDuan16Id"));
			child.add((String)mapToupei.get("ZhiDuan17Id"));
			child.add((String)mapToupei.get("ZhiDuan18Id"));
			child.add((String)mapToupei.get("ZhiDuan19Id"));
			child.add((String)mapToupei.get("ZhiDuan20Id"));
			child.add((String)mapToupei.get("ZhiDuan21Id"));
			child.add((String)mapToupei.get("ZhiDuan22Id"));
			child.add((String)mapToupei.get("ZhiDuan23Id"));
			child.add((String)mapToupei.get("ZhiDuan24Id"));
			child.add((String)mapToupei.get("ZhiDuan25Id"));
			child.add((String)mapToupei.get("ZhiDuan26Id"));
			child.add((String)mapToupei.get("ZhiDuan27Id"));

			child.add(BaseActivity.gUser.getUserName());
			child.add(SplashActivity.getProvince());
			child.add(SplashActivity.getCity());
			child.add(SplashActivity.getDistrict());
			child.add(SplashActivity.getStreet());


			mVctSendData.add(child);
		}

		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {
		// TODO Auto-generated method stub
		MyProtocol p=new MyProtocol();
		if (mModuleId.equals(ItemTitleHelper.K1)) {
			p.sendCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01Biao0;
			p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01Biao1;
			p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01Biao2;
			p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01BiaoRe0;
			p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01BiaoRe1;
			p.receCmd3=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01BiaoRe3;
			p.receCmd5=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01BiaoRe5;
		}else if (mModuleId.equals(ItemTitleHelper.K2)) {
			p.sendCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02Biao0;
			p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02Biao1;
			p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02Biao2;
			p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02BiaoRe0;
			p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02BiaoRe1;
			p.receCmd3=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02BiaoRe3;
			p.receCmd5=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02BiaoRe5;
		}
		else if (mModuleId.equals(ItemTitleHelper.K3)) {
			p.sendCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03Biao0;
			p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03Biao1;
			p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03Biao2;
			p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03BiaoRe0;
			p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03BiaoRe1;
			p.receCmd3=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03BiaoRe3;
			p.receCmd5= DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03BiaoRe5;
		}
		else if (mModuleId.equals(ItemTitleHelper.K4)) {
			p.sendCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04Biao0;
			p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04Biao1;
			p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04Biao2;
			p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04BiaoRe0;
			p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04BiaoRe1;
			p.receCmd3=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04BiaoRe3;
			p.receCmd5=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04BiaoRe5;
		}
		else if (mModuleId.equals(ItemTitleHelper.K5)) {
			p.sendCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05Biao0;
			p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05Biao1;
			p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05Biao2;
			p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05BiaoRe0;
			p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05BiaoRe1;
			p.receCmd3=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05BiaoRe3;
			p.receCmd5=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05BiaoRe5;
		}
//		





		return p;
	}

}
