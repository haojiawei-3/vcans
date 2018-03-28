package com.vcans.Processor;


import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.Vcan.activity.R;
import com.Vcan.activity.DPDetailInfo;
import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.dao.YPExpositionDao;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ProtocolCMD;

public class YPExpositionUploadProcessor extends UploadProcessor {

	public YPExpositionDao mSCToupeiDao=null;
	List<HashMap<String,Object> > mTouPeiList=null;
	Vector<Vector<String> > mVctSendData=null;
	private BandleParam mBdParam=new BandleParam();

	public YPExpositionUploadProcessor()
	{
		mSCToupeiDao=new YPExpositionDao();
	}

	@Override
	public int ProcessData(Vector<String> vctDataId) {

		String strRecordIds=ConvertStringIds(vctDataId);

		mSCToupeiDao.DeleteAll(strRecordIds);
		DisplayTouPeiInfo();

		ActivityHelper.savedImagePath.clear();
		if(mDataTrunsfer.isDownloadContinue()){

		 }
		 else{
			mActParent.processMessage(1000,"");
		 }
		return 1;
	}

	public void DisplayTouPeiInfo()
	{
		mTouPeiList=mSCToupeiDao.GetAllTeipei();
		System.out.println(mTouPeiList+"展会寻样上传数据");

		String[] szField={"CusBarcode","CusName","Barcode","Price","Num","TPId"};

		int[] szRId={R.id.tvCusBarcode,R.id.tvCusName,R.id.tvBarcode,
				R.id.tvPrice,R.id.tvNum,R.id.tvInnerId};


		SimpleAdapter adpter=new SimpleAdapter(mActParent,mTouPeiList,R.layout.yp_exposition_item,szField,szRId);
		ListView listView = (ListView) mActParent.findViewById(R.id.lvProdct);
		listView.setAdapter(adpter);

		TextView tvPage = (TextView) mActParent.findViewById(R.id.tvPage);
		tvPage.setText("(0/"+listView.getCount()+")");

		mActParent.processMessage(0, "");
	}

	public void displayDetail(List<HashMap<String,Object> > mapInfo)
	{
		String[] szField={"RZPlanId","RZFactoryId","GongXuId","GongXuName","CompanyOrderId",
				"PurchaseId",
				"GoodsId",
				"GoodsDescribe",
				"StoreDescribe",
				"OldNum",
				"OldPiShu",
				"BackModify",
				"InitPeiBuTR",
				"PiShu",
				"Num",
				"UserId",
				"TPId"};

		int[] szRId={R.id.tvRZPlanId,R.id.tvRZFactoryId,R.id.tvGongXuId,R.id.tvGongXuName,
				R.id.tvCompanyOrderId,
				R.id.tvPurchaseId,
				R.id.tvGoodsId,
				R.id.tvGoodsDescribe,
				R.id.tvStoreDescribe,
				R.id.tvOldPiShu,
				R.id.tvOldNum,
				R.id.tvBackModify,
				R.id.tvInitPeiBuTR,
				R.id.tvPiShu,
				R.id.tvNum,
				R.id.tvUser,
				R.id.tvInnerId};


		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.yp_exposition_item_detail;

		Intent intent=new Intent(mActParent,DPDetailInfo.class);
		intent.putExtra("data",mBdParam);
		mActParent.startActivity(intent);
	}

	public void SaveToupeiInfo()
	{
		YPExpInfo toupei=new YPExpInfo();
		toupei.strCusBarcode=ActivityHelper.gToupei.strCusBarcode;
		toupei.strCusName=ActivityHelper.gToupei.strCusName;
		EditText txtBarcode=(EditText)mActParent.findViewById(R.id.txtYPBarcode);

		if(txtBarcode==null) return;

		toupei.strBarcode=txtBarcode.getText().toString().trim();
		toupei.strPrice=ActivityHelper.gToupei.strPrice;
		toupei.strNum=ActivityHelper.gToupei.nNum;
		toupei.strImgName=ActivityHelper.gToupei.strFilePath;

		if(toupei.strBarcode.equals(""))
		{
			ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.isNUll));
			return ;
		}

		if(toupei.strNum.equals(""))
			toupei.strNum="0";

		if(toupei.strPrice.equals(""))
			toupei.strPrice="0";


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
			mActParent.processMessage(2, "");
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
		mSCToupeiDao.DeleteAll("'"+dataId+"'");
		DisplayTouPeiInfo();
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		if(extrData!=null)
			mTouPeiList=mSCToupeiDao.GetTeipeiById(extrData[0]);

		mVctSendData=new Vector<Vector<String>>();

		for(HashMap<String,Object> mapToupei:mTouPeiList)
		{
			Vector<String> child= new Vector<String>();

			//上传记录格式[采集器记录ID,客户条码,样品条码,报价,数量,客户简称],
			child.add((String)mapToupei.get("TPId"));
			child.add((String)mapToupei.get("CusBarcode"));
			child.add((String)mapToupei.get("Barcode"));
			child.add((String)mapToupei.get("Price"));
			child.add((String)mapToupei.get("Num"));
			child.add((String)mapToupei.get("CusName"));
			child.add(BaseActivity.gUser.getUserName());
			String strImage=(String)mapToupei.get("CusImgName");
			if(!strImage.equals("")){
				child.add(ProtocolCMD.FILE_FIELD_FLAG+strImage);
			}
			mVctSendData.add(child);
			System.out.println(mVctSendData+"sbsbsb");
		}

		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		p.sendCmd0=YPStandardProtocol.m_vfxVAGSTD_ZhanHuXunYangBiao0;
		p.sendCmd1= YPStandardProtocol.m_vfxVAGSTD_ZhanHuXunYangBiao1;
		p.sendCmd2=YPStandardProtocol.m_vfxVAGSTD_ZhanHuXunYangBiao2;
		p.receCmd0=YPStandardProtocol.m_vfxVAGSTD_ZhanHuXunYangBiaoRe0;
		p.receCmd1=YPStandardProtocol.m_vfxVAGSTD_ZhanHuXunYangBiaoRe1;
		p.receCmd3=YPStandardProtocol.m_vfxVAGSTD_ZhanHuXunYangBiaoRe3;
		p.receCmd5=YPStandardProtocol.m_vfxVAGSTD_ZhanHuXunYangBiaoRe5;

		return p;
	}
}
