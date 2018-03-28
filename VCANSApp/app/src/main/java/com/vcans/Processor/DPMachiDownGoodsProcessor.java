package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import android.content.Intent;
import com.Vcan.activity.R;
import com.Vcan.activity.DPDetailInfo;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.MachiningDao;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.model.ToupeiInfo;
import com.vcans.tool.ActivityHelper;

public class DPMachiDownGoodsProcessor extends DownloadProcessor {

	List<HashMap<String,Object> > dataList=new ArrayList<HashMap<String,Object> >();
	private BandleParam mBdParam=new BandleParam();
	public MachiningDao mSCToupeiDao=new MachiningDao();

	@Override
	public int ProcessData() {


		initGoodsList();

		return 1;
	}


	public void initGoodsList()
	{
		Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
		if(mDataTrunsfer!=null)
			vctReceData=this.mDataTrunsfer.GetReceiveData();

		dataList.clear();
		for(Vector<String> record:vctReceData)
		{
			//下载记录格式[公司订单号,采购合同号,物料编号,物料描述,存货描述,存货标志,匹数,数量]
			HashMap<String,Object> mapData=new HashMap<String,Object> ();

			if(record.size()<8)
				continue;

			mapData.put("companyOrderId", record.get(0));
			mapData.put("purchaseId", record.get(1));
			mapData.put("goodsId", record.get(2));
			mapData.put("goodDescribe", record.get(3));
			mapData.put("storeDescribe", record.get(4));
			mapData.put("storeFlag", record.get(5));
			mapData.put("oldPiShu", record.get(6));
			mapData.put("oldNum", record.get(7));

			dataList.add(mapData);
		}


		String[] szField={"goodsId","goodDescribe","oldPiShu","oldNum"};
		int[] szRId={R.id.tvGoodsId,R.id.tvGoodsDescribe,R.id.tvGPiShu,R.id.tvGNum};


//		SimpleAdapter adpter=new SimpleAdapter(mActParent,dataList,R.layout.dp_goods_item,szField,szRId);
//		ListView listView = (ListView) mActParent.findViewById(R.id.lvProdct);
//		listView.setAdapter(adpter);
//
//		TextView tvPage = (TextView) mActParent.findViewById(R.id.tvPage);
//		tvPage.setText("(0/"+listView.getCount()+")");

		BaseActivity.showList(mActParent,
				dataList,
				R.layout.dp_goods_item,
				szField,
				szRId,
				R.id.lvProdct,
				R.id.tvPage);

		if(ActivityHelper.gToupei.strColorAllOut.equals("Y"))
		{
			SaveToupeiInfo();
		}
	}

	public void displayDetail(List<HashMap<String,Object> > mapInfo)
	{
		String[] szField={"companyOrderId","purchaseId","goodsId","goodDescribe",
				"storeDescribe","oldPiShu","oldNum"};
		int[] szRId={R.id.tvCompanyOrderId,R.id.tvPurchaseId,R.id.tvGoodsId,R.id.tvGoodsDescribe,
				R.id.tvStoreDescribe,R.id.tvGPiShu,R.id.tvGNum};

		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.dp_goods_item_detail;

		Intent intent=new Intent(mActParent,DPDetailInfo.class);
		intent.putExtra("data",mBdParam);
		mActParent.startActivity(intent);
	}

	public void SaveToupeiInfo()
	{
		if(dataList.size()<1)
			return;

		int nRst=0,nExistCount=0;

		ToupeiInfo toupei=ActivityHelper.gToupei;

		for(HashMap<String,Object> mapGoods:dataList)
		{
			toupei.nPiShu=(String)mapGoods.get("oldPiShu");
			toupei.nNum=(String)mapGoods.get("oldNum");
			toupei.strCompanyOrderId=(String)mapGoods.get("companyOrderId");
			toupei.strPurchaseId=(String)mapGoods.get("purchaseId");
			toupei.strGoodsId=(String)mapGoods.get("goodsId");
			toupei.strGoodsDescribe=(String)mapGoods.get("goodDescribe");
			toupei.strStoreDescribe=(String)mapGoods.get("storeDescribe");
			toupei.strStoreFlag=(String)mapGoods.get("storeFlag");
			toupei.nOldPiShu=(String)mapGoods.get("oldPiShu");
			toupei.nOldNum=(String)mapGoods.get("oldNum");

			int nRstTemp=mSCToupeiDao.AddToupei(toupei);
			if(nRstTemp==1)
			{
				nRst++;
			}
			else if(nRstTemp==2)
			{
				nExistCount++;
			}
		}


		if(nExistCount==dataList.size())
		{
			mActParent.processMessage(2,"2");
		}
		else
		{
			mActParent.processMessage(2,"1");
		}
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		// [单据类型,染整计划号,加工厂编码,目的工厂编码,工序编号,工序名称]
		child.add(ActivityHelper.gToupei.strOrderType);
		child.add(ActivityHelper.gToupei.strRZPlanId);
		child.add(ActivityHelper.gToupei.strRZFactoryId);
		child.add(ActivityHelper.gToupei.strAimFactoryId);
		child.add(ActivityHelper.gToupei.strGongXuId);
		child.add(ActivityHelper.gToupei.strGongXuName);

		vctSendData.add(child);

		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();
		//==跟单==加工送仓库-物料信息下载
		p.sendCmd1= DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBo_GongXuXuanZe1;
		p.receCmd0=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBo_GongXuXuanZeRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBo_GongXuXuanZeRe1;

		return p;
	}

}
