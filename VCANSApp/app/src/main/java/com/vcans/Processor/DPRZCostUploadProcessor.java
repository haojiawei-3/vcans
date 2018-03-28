package com.vcans.Processor;


import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.content.Intent;
import android.widget.EditText;

import com.Vcan.activity.R;
import com.Vcan.activity.DPDetailInfo;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.RZCostDao;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.model.ToupeiInfo;
import com.vcans.tool.ActivityHelper;

public class DPRZCostUploadProcessor extends UploadProcessor {

	public RZCostDao mSCToupeiDao=null;
	List<HashMap<String,Object> > mTouPeiList=null;
	Vector<Vector<String> > mVctSendData=null;
	private BandleParam mBdParam=new BandleParam();

	public DPRZCostUploadProcessor()
	{
		mSCToupeiDao=new RZCostDao();
	}

	@Override
	public int ProcessData(Vector<String> vctDataId) {

		//String strRecordIds=ConvertStringIds(vctDataId);

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

		String[] szField={"RZPlanId","RZFactoryId","GongXuId",
				"CostSelectId",
				"Num",
				"PiShu",
				"Cost",
				"TPId"};

		int[] szRId={R.id.tvRZPlanIdv,R.id.tvRZFactoryIdv,R.id.tvGongXuId,
				R.id.tvCostSelectId,
				R.id.tvNumv,
				R.id.tvPiShuv,
				R.id.tvCostv,
				R.id.tvInnerId};




//		ImageSimpleAdapter adpter=new ImageSimpleAdapter(mActParent,mTouPeiList,R.layout.dp_rzcost_item,szField,szRId);
//		adpter.addItemTitleListener(itemTitle);
//		ListView listView = (ListView) mActParent.findViewById(R.id.lvProdct);
//		listView.setAdapter(adpter);
//		
//		TextView tvPage = (TextView) mActParent.findViewById(R.id.tvPage);
//		tvPage.setText("(0/"+listView.getCount()+")");


		BaseActivity.showList(mActParent,
				mTouPeiList,
				R.layout.dp_rzcost_item,
				szField,
				szRId,
				R.id.lvProdct,
				R.id.tvPage);


	}




	public void displayDetail(List<HashMap<String,Object> > mapInfo)
	{
		String[] szField={"RZPlanId","RZFactoryId","RZFactoryName","GongXuId","GongXuName",
				"CostSelectName",
				"CostSelectId",
				"Num",
				"PiShu",
				"Cost",
				"Remark",
				"UserName",
				"TPId"};

		int[] szRId={R.id.tvRZPlanIdv,R.id.tvRZFactoryIdv,R.id.tvRZFactoryNamev,R.id.tvGongXuId,R.id.tvGongXuName,
				R.id.tvCostSelect,
				R.id.tvCostSelectId,
				R.id.tvNumv,
				R.id.tvPiShuv,
				R.id.tvCostv,
				R.id.tvRemarkv,
				R.id.tvUserName,
				R.id.tvInnerId};


		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.dp_rzcost_item_detail;

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
		EditText txtCost=(EditText)mActParent.findViewById(R.id.txtCost);

		toupei.strRemark=txtRemark.getText().toString().trim();
		toupei.strCost=txtCost.getText().toString().trim();
		toupei.nNum=txtNum.getText().toString().trim();
		toupei.nPiShu=txtPiShu.getText().toString().trim();

		if(toupei.strRemark.equals(""))
			toupei.strRemark=" ";

		if(toupei.nNum.equals("")||toupei.strCost.equals("")||toupei.nPiShu.equals(""))
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

			//上传记录格式[染整计划号,染整厂编码,工序编码,工序名称,费用选择编号,费用选择名称,匹数,数量,费用,备注,用户名]

			child.add((String)mapToupei.get("TPId"));
			child.add((String)mapToupei.get("RZPlanId"));
			child.add((String)mapToupei.get("RZFactoryId"));
			child.add((String)mapToupei.get("GongXuId"));
			child.add((String)mapToupei.get("GongXuName"));
			child.add((String)mapToupei.get("CostSelectId"));
			child.add((String)mapToupei.get("CostSelectName"));
			child.add((String)mapToupei.get("PiShu"));
			child.add((String)mapToupei.get("Num"));
			child.add((String)mapToupei.get("Cost"));
			child.add((String)mapToupei.get("Remark"));
			child.add((String)mapToupei.get("UserName"));


			mVctSendData.add(child);
		}

		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		p.sendCmd0= DPProtocol.m_vfxVAG4BDePei_RanZhengFeiYongBiao0;
		p.sendCmd1=DPProtocol.m_vfxVAG4BDePei_RanZhengFeiYongBiao1;
		p.sendCmd2=DPProtocol.m_vfxVAG4BDePei_RanZhengFeiYongBiao2;
		p.receCmd0=DPProtocol.m_vfxVAG4BDePei_RanZhengFeiYongBiaoRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_RanZhengFeiYongBiaoRe1;
		p.receCmd3=DPProtocol.m_vfxVAG4BDePei_RanZhengFeiYongBiaoRe3;
		p.receCmd5=DPProtocol.m_vfxVAG4BDePei_RanZhengFeiYongBiaoRe5;

		return p;
	}
}
