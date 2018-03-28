package com.vcans.Processor;


import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.content.Intent;
import android.widget.EditText;


import com.Vcan.activity.R;
import com.Vcan.activity.DPDetailInfo;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.RZTaskDao;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.model.ToupeiInfo;
import com.vcans.tool.ActivityHelper;

public class DPRZTaskUploadProcessor extends UploadProcessor {

	public RZTaskDao mSCToupeiDao=null;
	List<HashMap<String,Object> > mTouPeiList=null;
	Vector<Vector<String> > mVctSendData=null;

	private BandleParam mBdParam=new BandleParam();

	public DPRZTaskUploadProcessor()
	{
		mSCToupeiDao=new RZTaskDao();

	}

	@Override
	public int ProcessData(Vector<String> vctDataId) {

		mSCToupeiDao.DeleteAll(null);
		DisplayTouPeiInfo();

		if(mDataTrunsfer.isDownloadContinue()){

		}
		else{
			backFirstActivity();

		}

		return 1;
	}

	public void DisplayTouPeiInfo()
	{
		mTouPeiList=mSCToupeiDao.GetAllTeipei();
		String[] szField={"RZPlanId",
				"RZFactoryId",

				"strtxtby1Name",
				"strtxtby2Name",
				"GongXuId",
				"GongyiId",
				"strtxtby3Name",//////////////////
				"strtxtby4Name",//////////////////
				"strtxtby5Name",//////////////////
				"strtxtby6Name",///////////////////
				"Num",
				"PiShu",
				"shu3",
				"shu4",
				"RZDatetime",
				"TPId"};

		int[] szRId={
				R.id.tvRZPlanIdv,
				R.id.tvRZFactoryIdv,
				R.id.tvbyy,
				R.id.tvbye,
				R.id.tvGongXuId,
				R.id.tvGongyiId,
				R.id.tvbys, ///////////////   dp_rztask_item 中的
				R.id.tvbysi,///////////////
				R.id.tvbyw,////////////////
				R.id.tvbyl,///////////////
				R.id.tvNumv,
				R.id.tvPiShuv,
				R.id.tvshu3,
				R.id.tvshu4,
				R.id.tvDatetimev,
				R.id.tvInnerId};

		BaseActivity.showList(mActParent,mTouPeiList,R.layout.dp_rztask_item,szField,szRId,R.id.lvProdct,R.id.tvPage);

	}

	public void displayDetail(List<HashMap<String,Object> > mapInfo)
	{
		String[] szField={"RZPlanId",
				"RZFactoryId",
				"RZFactoryName",
				"strtxtby1Name",
				"strtxtby2Name",
				"GongXuId",
				"GongXuName",
				"GongyiId",
				"GongyiName",
				"strtxtby3Name",
				"strtxtby4Name",
				"strtxtby5Name",
				"strtxtby6Name",
				"Num",
				"PiShu",
				"Remark",
				"shu3",
				"shu4",
				"RZDatetime",
				"TPId"};

		int[] szRId={R.id.tvRZPlanIdv,
				R.id.tvRZFactoryIdv,
				R.id.tvRZFactoryNamev,
				R.id.tvbyy,
				R.id.tvbye,
				R.id.tvGongXuId,
				R.id.tvGongXuName,
				R.id.tvGongyiId,
				R.id.tvGongyiName,
				R.id.tvNumv,
				R.id.tvbys,
				R.id.tvbysi,
				R.id.tvbyw,
				R.id.tvbyl,
				R.id.tvPiShuv,
				R.id.tvRemarkv,
				R.id.tvshu3,
				R.id.tvshu4,
				R.id.tvDatetimev,
				R.id.tvInnerId};


		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.dp_rztask_item_detail;

		Intent intent=new Intent(mActParent,DPDetailInfo.class);
		intent.putExtra("data",mBdParam);
		mActParent.startActivity(intent);
	}

	public void SaveToupeiInfo()
	{
		ToupeiInfo toupei=ActivityHelper.gToupei;

		EditText txtRemark=(EditText)mActParent.findViewById(R.id.txtRemark);
		EditText txtNum=(EditText)mActParent.findViewById(R.id.txtNumber);
		EditText txtPiShu=(EditText)mActParent.findViewById(R.id.txtPiShu);
		EditText shu3=(EditText)mActParent.findViewById(R.id.txtShu3);
		EditText shu4=(EditText)mActParent.findViewById(R.id.txtShu4);
		EditText txtDatetime=(EditText)mActParent.findViewById(R.id.txtDatetime);

		EditText txtby5=(EditText)mActParent.findViewById(R.id.txtwenbenwuName);
		EditText txtby6=(EditText)mActParent.findViewById(R.id.txtwenbenliuName);


		toupei.strRemark=txtRemark.getText().toString().trim();
		toupei.strDataTime=txtDatetime.getText().toString().trim();
		toupei.nNum=txtNum.getText().toString().trim();
		toupei.nPiShu=txtPiShu.getText().toString().trim();
		toupei.shu3=shu3.getText().toString().trim();
		toupei.shu4=shu4.getText().toString().trim();

		toupei.strtxtby5Name=txtby5.getText().toString().trim();
		toupei.strtxtby6Name=txtby6.getText().toString().trim();

		if(toupei.strRemark.equals(""))
			toupei.strRemark=" ";

		if(toupei.nNum.equals("")||toupei.strDataTime.equals("")||toupei.nPiShu.equals("")||
				toupei.shu3.equals("")||toupei.shu4.equals("")||toupei.strtxtby5Name.equals("")||toupei.strtxtby6Name.equals(""))
		{
			ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.isNUll));
			return ;
		}


		int nRst=mSCToupeiDao.AddToupei(toupei);
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
		mSCToupeiDao.DeleteAll(null);
		DisplayTouPeiInfo();
	}

	public void DeleteToupeiInfo(String dataId)
	{
		mSCToupeiDao.DeleteById(dataId);
		DisplayTouPeiInfo();
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		if(extrData!=null)
			mTouPeiList=mSCToupeiDao.GetTeipeiById(extrData[0]);

		mVctSendData=new Vector<Vector<String> > ();

		for(HashMap<String,Object> mapToupei:mTouPeiList)
		{
			Vector<String> child= new Vector<String>();

			//上传记录格式[染整计划号,染整厂编码,工序编码,工序名称,工艺编码,工艺名称,日期时间,匹数,数量,备注,123456,数量3,数量4]

			//child.add((String)mapToupei.get("TPId"));
			child.add((String)mapToupei.get("RZPlanId"));
			child.add((String)mapToupei.get("RZFactoryId"));
			child.add((String)mapToupei.get("GongXuId"));
			child.add((String)mapToupei.get("GongXuName"));
			child.add((String)mapToupei.get("GongyiId"));
			child.add((String)mapToupei.get("GongyiName"));
			child.add((String)mapToupei.get("RZDatetime"));
			child.add((String)mapToupei.get("PiShu"));
			child.add((String)mapToupei.get("Num"));
			child.add((String)mapToupei.get("Remark"));

			child.add((String)mapToupei.get("strtxtby1Name"));
			child.add((String)mapToupei.get("strtxtby2Name"));
			child.add((String)mapToupei.get("strtxtby3Name"));
			child.add((String)mapToupei.get("strtxtby4Name"));
			child.add((String)mapToupei.get("strtxtby5Name"));
			child.add((String)mapToupei.get("strtxtby6Name"));
			child.add((String)mapToupei.get("shu3"));
			child.add((String)mapToupei.get("shu4"));

			child.add(BaseActivity.gUser.getUserName());


			mVctSendData.add(child);
		}

		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();
//		
		p.sendCmd0=DPProtocol.m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiao0;
		p.sendCmd1= DPProtocol.m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiao1;
		p.sendCmd2=DPProtocol.m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiao2;
		p.receCmd0=DPProtocol.m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiaoRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiaoRe1;
		p.receCmd3=DPProtocol.m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiaoRe3;
		p.receCmd5=DPProtocol.m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiaoRe5;




		return p;
	}
}
