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

public class DPPBDownGoodsProcessor extends DownloadProcessor {

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
			//[供应商,采购合同号,物料编号,物料描述,发货数量,订单数,公司订单号,ID]
			HashMap<String,Object> mapData=new HashMap<String,Object> ();

			if(record.size()<8)
				continue;

			mapData.put("SupplierId", record.get(0));
			mapData.put("purchaseId", record.get(1));
			mapData.put("goodsId",    record.get(2));
			mapData.put("goodDescribe", record.get(3));
			mapData.put("SendGoodsNum", record.get(4));
			mapData.put("OrderNum", 	record.get(5));
			mapData.put("companyOrderId", record.get(6));
			mapData.put("GoodsRecordId",  record.get(7));

			mDataList.add(mapData);

		}


		String[] szField={"goodsId","goodDescribe","SendGoodsNum","OrderNum"};
		int[] szRId={R.id.tvGoodsId,R.id.tvGoodsDescribe,R.id.tvGPiShu,R.id.tvGNum};

//		BandleParam param=new BandleParam();
//		param.dataList=mDataList;
//		param.szFieldData=szField;
//		param.szRId=szRId;
//		param.itemRId=R.layout.dp_pbgoods_item;////布局文件与 dp_goods_item一样
//		param.listRId=R.id.lvProdct;
//		param.pageRId=R.id.tvPage;
//
//		mActParent.showList(param);

		BaseActivity.showList(mActParent,
				mDataList,
				R.layout.dp_pbgoods_item,
				szField,
				szRId,
				R.id.lvProdct,
				R.id.tvPage);
	}

	public void displayDetail(List<HashMap<String,Object> > mapInfo)
	{
		String[] szField={"SupplierId",
				"companyOrderId",
				"purchaseId",
				"goodsId",
				"goodDescribe","SendGoodsNum",
				"OrderNum","GoodsRecordId"};
		int[] szRId={R.id.tvSupplierId,
				R.id.tvCompanyOrderId,
				R.id.tvPurchaseId,
				R.id.tvGoodsId,
				R.id.tvGoodsDescribe,
				R.id.tvGPiShu,
				R.id.tvGNum,
				R.id.tvRecordId};

		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.dp_peibuin_goods_item_detail;

		Intent intent=new Intent(mActParent,DPDetailInfo.class);
		intent.putExtra("data",mBdParam);
		mActParent.startActivity(intent);
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		child.add(ActivityHelper.gToupei.strOutNotifyId);
		//child.add(BaseActivity.gUser.getUserName());

		vctSendData.add(child);
		System.out.println(vctSendData);
		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();
		//==跟单==坯布进仓==出库通知单号==下载
		p.sendCmd1=DPProtocol.m_vfxVAG4BDePei_PeiBuJinCang_ChuKuTongZhiDanHao1;
		p.receCmd0= DPProtocol.m_vfxVAG4BDePei_PeiBuJinCang_ChuKuTongZhiDanHaoRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_PeiBuJinCang_ChuKuTongZhiDanHaoRe1;

		return p;
	}

}
