package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import android.content.Intent;
import com.Vcan.activity.R;
import com.Vcan.activity.DPDetailInfo;
import com.Vcan.activity.GDBakModule;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;

/**
 * 直接出货或备用模块的  物料信息下载处理
 * @author vcans
 *
 */
public class GDDirectOutDownGoodsProcessor extends DownloadProcessor {

	public static final int DIRECTOUT_MODULE=0;
	public static final int BAK_MODULE=1;

	private List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	private BandleParam mBdParam=new BandleParam();
	private int mModuleId=DIRECTOUT_MODULE;

	public GDDirectOutDownGoodsProcessor()
	{}

	public GDDirectOutDownGoodsProcessor(int moduleFlag)
	{
		mModuleId=moduleFlag;
	}

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
			//[物料编号, 物料描述, 存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五]
			HashMap<String,Object> mapData=new HashMap<String,Object> ();

			if(record.size()<11)
				continue;

			mapData.put("GoodsId", record.get(0));
			mapData.put("GoodDescribe", record.get(1));
			mapData.put("StoreDescribe",record.get(2));
			mapData.put("StoreFlag", record.get(3));
			mapData.put("GPiShu", record.get(4));
			mapData.put("GNum", record.get(5));
			mapData.put("Remark1", record.get(6));
			mapData.put("Remark2", record.get(7));
			mapData.put("Remark3", record.get(8));
			mapData.put("Remark4", record.get(9));
			mapData.put("Remark5", record.get(10));

			mDataList.add(mapData);
		}


		String[] szField={"GoodsId","GoodDescribe","GPiShu","GNum"};

		int[] szRId={R.id.tvGoodsId,R.id.tvGoodsDescribe,R.id.tvGPiShu,R.id.tvGNum};



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
		String[] szField={"GoodsId","GoodDescribe","StoreDescribe",
				"GPiShu","GNum","Remark1","Remark2","Remark3","Remark4","Remark5"};

		int[] szRId={R.id.tvGoodsId,R.id.tvGoodsDescribe,R.id.tvStoreDescribe,R.id.tvGPiShu,R.id.tvGNum
				,R.id.tvRemark1,R.id.tvRemark2,R.id.tvRemark3,R.id.tvRemark4,R.id.tvRemark5};

		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.gd_directout_goodsitem_detail;

		Intent intent=new Intent(mActParent,DPDetailInfo.class);
		intent.putExtra("data",mBdParam);
		mActParent.startActivity(intent);
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		for(String str:extrData)
			child.add(str);

		vctSendData.add(child);

		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		if(mModuleId==DIRECTOUT_MODULE)
		{//直接出货
			p.sendCmd1=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_WULIAO1;
			p.receCmd0= DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_WULIAORe0;
			p.receCmd1=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_WULIAORe1;
		}
		else
		{//备用模块
			String strNum=GDBakModule.mapBakModuleId.get(GDBakModule.gBakFlag);
			p.sendCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_WULIAO1,strNum);
			p.receCmd0=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_WULIAORe0,strNum);
			p.receCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_WULIAORe1,strNum);
		}

		return p;
	}

}
