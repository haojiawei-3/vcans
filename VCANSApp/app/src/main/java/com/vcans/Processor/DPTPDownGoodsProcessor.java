package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.content.Intent;

import com.Vcan.activity.R;
import com.Vcan.activity.DPDetailInfo;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class DPTPDownGoodsProcessor extends DownloadProcessor {

	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	private BandleParam mBdParam=new BandleParam();

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

		mDataList.clear();

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

			mDataList.add(mapData);
		}


		String[] szField={"goodsId","goodDescribe","oldPiShu","oldNum"};
		int[] szRId={R.id.tvGoodsId,R.id.tvGoodsDescribe,R.id.tvGPiShu,R.id.tvGNum};


//		SimpleAdapter adpter=new SimpleAdapter(mActParent,mDataList,R.layout.dp_goods_item,szField,szRId);
//		ListView listView = (ListView) mActParent.findViewById(R.id.lvProdct);
//		listView.setAdapter(adpter);
//
//		TextView tvPage = (TextView) mActParent.findViewById(R.id.tvPage);
//		tvPage.setText("(0/"+listView.getCount()+")");

		BaseActivity.showList(mActParent,
				mDataList,
				R.layout.dp_goods_item,
				szField,
				szRId,
				R.id.lvProdct,
				R.id.tvPage);
	}

	public void displayDetail(List<HashMap<String,Object> > mapInfo)
	{
		String[] szField={"companyOrderId","purchaseId","goodsId","goodDescribe","storeDescribe",
				"oldPiShu","oldNum"};
		int[] szRId={R.id.tvCompanyOrderId,R.id.tvPurchaseId,R.id.tvGoodsId,R.id.tvGoodsDescribe,
				R.id.tvStoreDescribe,
				R.id.tvGPiShu,R.id.tvGNum};

		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.dp_goods_item_detail;

		Intent intent=new Intent(mActParent,DPDetailInfo.class);
		intent.putExtra("data",mBdParam);
		mActParent.startActivity(intent);
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		//[染整计划号,染整厂编码,工序编号,工序名称,是否复合布(Y/N)]
		child.add(ActivityHelper.gToupei.strRZPlanId);
		child.add(ActivityHelper.gToupei.strRZFactoryId);
		child.add(ActivityHelper.gToupei.strGongXuId);
		child.add(ActivityHelper.gToupei.strGongXuName);
		child.add("N");
		vctSendData.add(child);

		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		p.sendCmd1= DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_GongXuXuanZe1;
		p.receCmd0=DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_GongXuXuanZeRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_GongXuXuanZeRe1;

		return p;
	}

}
