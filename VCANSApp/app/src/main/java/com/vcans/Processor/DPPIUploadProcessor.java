package com.vcans.Processor;


import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;

import com.Vcan.activity.R;
import com.Vcan.activity.DPDetailInfo;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.ProductInDao;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class DPPIUploadProcessor extends UploadProcessor {

	public ProductInDao mSCToupeiDao=null;
	List<HashMap<String,Object> > mTouPeiList=null;
	Vector<Vector<String> > mVctSendData=null;
	private BandleParam mBdParam=new BandleParam();

	public DPPIUploadProcessor()
	{
		mSCToupeiDao=new ProductInDao();
	}

	@Override
	public int ProcessData(Vector<String> vctDataId) {

		String strRecordIds=ConvertStringIds(vctDataId);

		mSCToupeiDao.DeleteAll(strRecordIds);
		DisplayTouPeiInfo();
		if(mDataTrunsfer.isDownloadContinue()){

		}
		else{
			backFirstActivity();
		}

		return 1;
	}

	public void DisplayTouPeiInfo(){
		mTouPeiList=mSCToupeiDao.GetAllTeipei();


		String[] szField={"RZPlanId",
				"RZFactoryId",
				"GongXuName",
				"GoodsId",
				"FlowerType",
				"Color",
				"PiShu",
				"Num",
				"TPId"};

		int[] szRId={R.id.tvRZPlanIdv,
				R.id.tvRZFactoryIdv,
				R.id.tvGongXuName,
				R.id.tvGoodsId,
				R.id.tvFlowerv,
				R.id.tvColorv,
				R.id.tvPiShuv,
				R.id.tvNumv,
				R.id.tvInnerId
		};


		BaseActivity.showList(mActParent,
				mTouPeiList,
				R.layout.dp_productin_item,
				szField,
				szRId,
				R.id.lvProdct,
				R.id.tvPage);
	}

	public void displayDetail(List<HashMap<String,Object> > mapInfo)
	{
		String[] szField={"RZPlanId","RZFactoryId","ProType","ProTypeId","GongXuId","GongXuName","CompanyOrderId",
				"PurchaseId",
				"GoodsId",
				"GoodsDescribe",
				"StoreDescribe",
				"OldNum",
				"OldPiShu",
				"DelPiShu",
				"DelNum",
				"PiCi",
				"CheckStatusId",
				"CheckStatusName",
				"FabricQuality",
				"KGToM",
				"FlowerType",
				"Color",
				"Price",
				"Unit",
				"UserId",
				"GongyiName2_1",
				"GongyiName2_2",
				"GongyiName2_3",
				"GongyiId2_1",
				"GongyiId2_2",
				"GongyiId2_3",
				"TPId"};

		int[] szRId={R.id.tvRZPlanIdv,
				R.id.tvRZFactoryIdv,
				R.id.tvProTypeName,
				R.id.tvProTypeId,
				R.id.tvGongXuId,
				R.id.tvGongXuName,
				R.id.tvCompanyOrderId,
				R.id.tvPurchaseId,
				R.id.tvGoodsId,
				R.id.tvGoodsDescribe,
				R.id.tvStoreDescribe,
				R.id.tvGPiShu,
				R.id.tvGNum,
				R.id.tvDelPiShuv,
				R.id.tvDelNumv,
				R.id.tvPiCiv,
				R.id.tvCheckStatusId,
				R.id.tvCheckStatusName,
				R.id.tvFabricQualityv,
				R.id.tvKGToMv,
				R.id.tvFlowerv,
				R.id.tvColorv,
				R.id.tvPricev,
				R.id.tvUnitv,
				R.id.tvUser,
				R.id.tvGongyiName2_1,
				R.id.tvGongyiName2_2,
				R.id.tvGongyiName2_3,
				R.id.tvGongyiId2_1,
				R.id.tvGongyiId2_2,
				R.id.tvGongyiId2_3,
				R.id.tvInnerId};



		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.dp_productin_item_detail;

		Intent intent=new Intent(mActParent,DPDetailInfo.class);
		intent.putExtra("data",mBdParam);
		mActParent.startActivity(intent);
	}

	public void SaveToupeiInfo()
	{
		EditText txtPiShu=(EditText)mActParent.findViewById(R.id.txtPiShu);
		EditText txtNum=(EditText)mActParent.findViewById(R.id.txtNum);
		EditText txtPrice=(EditText)mActParent.findViewById(R.id.txtPrice);
		Spinner  spUnit=(Spinner)mActParent.findViewById(R.id.dropUnit);

		String strPiShu=txtPiShu.getText().toString().trim();
		String strNum=txtNum.getText().toString().trim();
		String strPrice=txtPrice.getText().toString().trim();
		String strUnit=spUnit.getSelectedItem().toString().trim();

		if(strPiShu.equals("")||strNum.equals(""))
		{
			ActivityHelper.showDialog(mActParent, "提示", mActParent.getString(R.string.isNUll));
			return;
		}

		if(strPrice.equals(""))
			strPrice="0";

		ActivityHelper.gToupei.strUnit=strUnit;
		ActivityHelper.gToupei.strPrice=strPrice;
		ActivityHelper.gToupei.nPiShu=strPiShu;
		ActivityHelper.gToupei.nNum=strNum;

		int nRst=mSCToupeiDao.AddToupei(ActivityHelper.gToupei);
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


			//[采集器内部ID,染整计划号,染整厂编码,工序编码,工序名称,公司订单号,采购合同号,物料编号,物料描述,
			//存货描述,存货标志,在制匹数,在制数量,花型,颜色,品检状态编码,品检状态名称,面料性质,KG转M系数,单价,单位,扣匹数，扣数量,匹数,数量,用户名]
			child.add((String)mapToupei.get("TPId"));
			child.add((String)mapToupei.get("RZPlanId"));
			child.add((String)mapToupei.get("RZFactoryId"));
			child.add((String)mapToupei.get("GongXuId"));
			child.add((String)mapToupei.get("GongXuName"));
			child.add((String)mapToupei.get("CompanyOrderId"));
			child.add((String)mapToupei.get("PurchaseId"));
			child.add((String)mapToupei.get("GoodsId"));
			child.add((String)mapToupei.get("GoodsDescribe"));
			child.add((String)mapToupei.get("StoreDescribe"));
			child.add((String)mapToupei.get("StoreFlag"));
			child.add((String)mapToupei.get("OldPiShu"));
			child.add((String)mapToupei.get("OldNum"));
			child.add((String)mapToupei.get("FlowerType"));
			child.add((String)mapToupei.get("Color"));
			child.add((String)mapToupei.get("CheckStatusId"));
			child.add((String)mapToupei.get("CheckStatusName"));
			child.add((String)mapToupei.get("FabricQuality"));
			child.add((String)mapToupei.get("KGToM"));
			child.add((String)mapToupei.get("Price"));
			child.add((String)mapToupei.get("Unit"));
			child.add((String)mapToupei.get("DelPiShu"));
			child.add((String)mapToupei.get("DelNum"));
			child.add((String)mapToupei.get("PiShu"));
			child.add((String)mapToupei.get("Num"));
			child.add((String)mapToupei.get("UserId"));
			child.add((String)mapToupei.get("GongyiName2_1"));
			child.add((String)mapToupei.get("GongyiName2_2"));
			child.add((String)mapToupei.get("GongyiName2_3"));
			child.add((String)mapToupei.get("ProType"));
			child.add((String)mapToupei.get("ProTypeId"));
			child.add((String)mapToupei.get("PiCi"));
			mVctSendData.add(child);
		}

		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		p.sendCmd0=DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiao0;
		p.sendCmd1= DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiao1;
		p.sendCmd2=DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiao2;
		p.receCmd0=DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiaoRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiaoRe1;
		p.receCmd3=DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiaoRe3;
		p.receCmd5=DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiaoRe5;

		return p;
	}
}
