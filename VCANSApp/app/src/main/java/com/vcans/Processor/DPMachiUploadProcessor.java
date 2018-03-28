package com.vcans.Processor;


import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import android.content.Intent;
import android.widget.EditText;
import com.Vcan.activity.R;
import com.Vcan.activity.DPDetailInfo;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.MachiningDao;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.model.ToupeiInfo;
import com.vcans.tool.ActivityHelper;

public class DPMachiUploadProcessor extends UploadProcessor {

	public MachiningDao mSCToupeiDao=null;
	List<HashMap<String,Object> > mTouPeiList=null;
	Vector<Vector<String> > mVctSendData=null;
	private BandleParam mBdParam=new BandleParam();

	public DPMachiUploadProcessor()
	{
		mSCToupeiDao=new MachiningDao();
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

	public void DisplayTouPeiInfo()
	{
		mTouPeiList=mSCToupeiDao.GetAllTeipei();

		String[] szField={"RZPlanId",
				"GongXuName",
				"GoodsId",
				"PiShu",
				"Num","TPId"};

		int[] szRId={R.id.tvRZPlanIdv,
				R.id.tvGongXuName,
				R.id.tvGoodsId,
				R.id.tvPiShuv,
				R.id.tvNumv,
				R.id.tvInnerId};


		BaseActivity.showList(mActParent,
				mTouPeiList,
				R.layout.dp_machining_item,
				szField,
				szRId,
				R.id.lvProdct,
				R.id.tvPage);
	}

	public void displayDetail(List<HashMap<String,Object> > mapInfo)
	{
		String[] szField={"RZPlanId",
				"RZFactoryId",
				"AimFactoryId",
				"ProType",
				"ProTypeId",
				"GongXuId",
				"GongXuName",
				"CompanyOrderId",
				"PurchaseId",
				"GoodsId",
				"GoodsDescribe",
				"StoreDescribe",
				"OldNum",
				"OldPiShu",
				"PiShu",
				"Num",
				"UserId",
				"TPId"};

		int[] szRId={R.id.tvRZPlanIdv,
				R.id.tvRZFactoryIdv,
				R.id.tvAimFactoryIdv,
				R.id.tvProTypeName,
				R.id.tvProTypeId,
				R.id.tvGongXuId,R.id.tvGongXuName,
				R.id.tvCompanyOrderv,
				R.id.tvPurchaseId,
				R.id.tvGoodsId,
				R.id.tvGoodsDescribe,
				R.id.tvStoreDescribe,
				R.id.tvGPiShu,
				R.id.tvGNum,
				R.id.tvPiShuv,
				R.id.tvNumv,
				R.id.tvUser,
				R.id.tvInnerId};



		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.dp_machining_item_detail;

		Intent intent=new Intent(mActParent,DPDetailInfo.class);
		intent.putExtra("data",mBdParam);
		mActParent.startActivity(intent);
	}

	public void SaveToupeiInfo()
	{
		ToupeiInfo toupei=ActivityHelper.gToupei;

		EditText txtPiShu=(EditText)mActParent.findViewById(R.id.txtPiShu);
		EditText txtNum=(EditText)mActParent.findViewById(R.id.txtNumber);


		toupei.nPiShu=txtPiShu.getText().toString().trim();
		toupei.nNum=txtNum.getText().toString().trim();

		if(toupei.nPiShu.equals("")||toupei.nNum.equals(""))
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
			DisplayTouPeiInfo();
			ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.saveSuccess));
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

			/**
			 * 上传记录格式[采集器内部内部ID,单据类型,染整计划号,加工厂编码,目的工厂编码,工序编号,工序名称,公司订单号,
			 * 采购合同号,物料编号,物料描述,存货描述,存货标志,原库存匹数,原库存数量,匹数,数量,用户名,生产类型,生产类型编号]
			 */

			child.add((String)mapToupei.get("TPId"));
			child.add((String)mapToupei.get("OrderType"));
			child.add((String)mapToupei.get("RZPlanId"));
			child.add((String)mapToupei.get("RZFactoryId"));
			child.add((String)mapToupei.get("AimFactoryId"));
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
			child.add((String)mapToupei.get("PiShu"));
			child.add((String)mapToupei.get("Num"));
			child.add((String)mapToupei.get("UserId"));
			child.add((String)mapToupei.get("ProType"));
			child.add((String)mapToupei.get("ProTypeId"));

			mVctSendData.add(child);
		}

		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();
		//==跟单==加工送仓库-工厂下载
		p.sendCmd0=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBoBiao0;
		p.sendCmd1= DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBoBiao1;
		p.sendCmd2=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBoBiao2;
		p.receCmd0=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBoBiaoRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBoBiaoRe1;
		p.receCmd3=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBoBiaoRe3;
		p.receCmd5=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBoBiaoRe5;

		return p;
	}
}
