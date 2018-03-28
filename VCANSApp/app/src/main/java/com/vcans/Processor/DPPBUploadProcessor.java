package com.vcans.Processor;


import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import android.content.Intent;
import android.widget.EditText;
import com.Vcan.activity.R;
import com.Vcan.activity.DPDetailInfo;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.PeiBuInDao;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.model.ToupeiInfo;
import com.vcans.tool.ActivityHelper;

public class DPPBUploadProcessor extends UploadProcessor {

	public PeiBuInDao mSCToupeiDao=null;
	List<HashMap<String,Object> > mTouPeiList=null;
	Vector<Vector<String> > mVctSendData=null;
	private BandleParam mBdParam=new BandleParam();

	public DPPBUploadProcessor()
	{
		mSCToupeiDao=new PeiBuInDao();
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
		String[] szField={"OutNotifyId","GoodsId","PiShu","Num","TPId"};

		int[] szRId={R.id.tvOutNotifyIdv,
				R.id.tvGoodsId,
				R.id.tvPiShuv,
				R.id.tvNumv,
				R.id.tvInnerId};


		BaseActivity.showList(mActParent,
				mTouPeiList,
				R.layout.dp_peibuin_item,
				szField,
				szRId,
				R.id.lvProdct,
				R.id.tvPage);
	}

	public void displayDetail(List<HashMap<String,Object> > mapInfo)
	{
		String[] szField={"OutNotifyId","SupplierId","CompanyOrderId",
				"PurchaseId",
				"GoodsId",
				"GoodsDescribe",
				"SendGoodsNum",
				"OrderNum",
				"GoodsRecordId",
				"FabricQuality",
				"PackQuality",
				"PiCi",
				"MaKou",
				"Remark",
				"Position",
				"PiShu",
				"Num",
				"UserId",
				"TPId"};

		int[] szRId={R.id.tvOutNotifyIdv,R.id.tvSupplierId,R.id.tvCompanyOrderv,
				R.id.tvPurchaseId,
				R.id.tvGoodsId,
				R.id.tvGoodsDescribe,
				R.id.tvGPiShu,
				R.id.tvGNum,
				R.id.tvRecordId,
				R.id.tvFabricQualityv,
				R.id.tvPackQualityv,
				R.id.tvPiCiv,
				R.id.tvMaKouv,
				R.id.tvRemarkv,
				R.id.tvPositionv,
				R.id.tvPiShuv,
				R.id.tvNumv,
				R.id.tvUser,
				R.id.tvInnerId};



		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.dp_peibuin_item_detail;

		Intent intent=new Intent(mActParent,DPDetailInfo.class);
		intent.putExtra("data",mBdParam);
		mActParent.startActivity(intent);
	}

	public void SaveToupeiInfo()
	{
		ToupeiInfo toupei=ActivityHelper.gToupei;

		EditText txtPiShu=(EditText)mActParent.findViewById(R.id.txtPiShu);
		EditText txtPiCi=(EditText)mActParent.findViewById(R.id.txtPiCi);
		EditText txtNum=(EditText)mActParent.findViewById(R.id.txtNumber);

		EditText txtPosition=(EditText)mActParent.findViewById(R.id.txtPosition);
		String strPosition=txtPosition.getText().toString().trim();


		toupei.nPiShu=txtPiShu.getText().toString().trim();
		toupei.strPiCi=txtPiCi.getText().toString().trim();
		toupei.nNum=txtNum.getText().toString().trim();
		toupei.strPosition=strPosition;

		if(toupei.nPiShu.equals("")||
				toupei.nNum.equals("")||
				toupei.strPiCi.equals("")||
				strPosition.equals(""))
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
		System.out.println("4");
		if(extrData!=null){
			mTouPeiList=mSCToupeiDao.GetTeipeiById(extrData[0]);

		}
		mVctSendData=new Vector<Vector<String> > ();

		System.out.println("1");
		for(HashMap<String,Object> mapToupei:mTouPeiList)
		{
			Vector<String> child= new Vector<String>();
			//上传记录格式[采集器内部ID,出库通知单号,供应商,采购合同号,物料编号,物料描述,发货数量,
			//订单数,公司订单号,ID,面料性质,包装方式,码口,说明,存放位置,匹数,数量,用户名]

			child.add((String)mapToupei.get("TPId"));
			child.add((String)mapToupei.get("OutNotifyId"));
			child.add((String)mapToupei.get("SupplierId"));
			child.add((String)mapToupei.get("PurchaseId"));
			child.add((String)mapToupei.get("GoodsId"));
			child.add((String)mapToupei.get("GoodsDescribe"));
			child.add((String)mapToupei.get("SendGoodsNum"));
			child.add((String)mapToupei.get("OrderNum"));
			child.add((String)mapToupei.get("CompanyOrderId"));
			child.add((String)mapToupei.get("GoodsRecordId"));
			child.add((String)mapToupei.get("FabricQuality"));
			child.add((String)mapToupei.get("PackQuality"));
			child.add((String)mapToupei.get("MaKou"));
			child.add((String)mapToupei.get("Remark"));
			child.add((String)mapToupei.get("Position"));
			child.add((String)mapToupei.get("PiShu"));
			child.add((String)mapToupei.get("Num"));
			child.add((String)mapToupei.get("UserId"));
			child.add((String)mapToupei.get("PiCi"));
			mVctSendData.add(child);
		}

		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();
		//==跟单==坯布进仓==表上传
		p.sendCmd0=DPProtocol.m_vfxVAG4BDePei_PeiBuJinCangBiao0;
		p.sendCmd1= DPProtocol.m_vfxVAG4BDePei_PeiBuJinCangBiao1;
		p.sendCmd2=DPProtocol.m_vfxVAG4BDePei_PeiBuJinCangBiao2;
		p.receCmd0=DPProtocol.m_vfxVAG4BDePei_PeiBuJinCangBiaoRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_PeiBuJinCangBiaoRe1;
		p.receCmd3=DPProtocol.m_vfxVAG4BDePei_PeiBuJinCangBiaoRe3;
		p.receCmd5=DPProtocol.m_vfxVAG4BDePei_PeiBuJinCangBiaoRe5;

		return p;
	}
}
