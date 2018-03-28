package com.vcans.Processor;


import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import android.content.Intent;
import android.widget.EditText;
import com.Vcan.activity.R;
import com.Vcan.activity.DPDetailInfo;
import com.Vcan.activity.GDDirectOut;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.DirectOutDao;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class GDDirectOutUploadProcessor extends UploadProcessor {

	public DirectOutDao mSCToupeiDao=null;
	List<HashMap<String,Object> > mTouPeiList=null;
	Vector<Vector<String> > mVctSendData=null;
	private BandleParam mBdParam=new BandleParam();

	public GDDirectOutUploadProcessor()
	{
		mSCToupeiDao=new DirectOutDao();
	}

	@Override
	public int ProcessData(Vector<String> vctDataId) {

		String strRecordIds=ConvertStringIds(vctDataId);

		mSCToupeiDao.DeleteAll(strRecordIds);
		DisplayInfo();

		if(mDataTrunsfer.isDownloadContinue()){

		}
		else{
			backFirstActivity();
		}

		return 1;
	}

	public void DisplayInfo()
	{
		mTouPeiList=mSCToupeiDao.GetAllInfo();


		String[] szField={"RZPlanId","DataItem1","FuZhuData1Id","FuZhuData2Id","FuZhuData3Id","GoodsId","PiShu","Num","TPId"};

		int[] szRId={R.id.tvRZPlanIdv,R.id.tvDataItem1v,
				R.id.tvFuZhuData1Id,
				R.id.tvFuZhuData2Id,
				R.id.tvFuZhuData3Id,
				R.id.tvGoodsId,R.id.tvPiShuv,R.id.tvNumv,R.id.tvInnerId
		};


		BaseActivity.showList(mActParent,
				mTouPeiList,
				R.layout.gd_directout_item,
				szField,
				szRId,
				R.id.lvProdct,
				R.id.tvPage);
	}

	public void displayDetail(List<HashMap<String,Object> > mapInfo)
	{
		String[] szField={"RZPlanId","DataItem1","DataItem2","DataItem3",
				"FuZhuData1Id",
				"FuZhuData1Name",
				"FuZhuData2Id",
				"FuZhuData2Name",
				"FuZhuData3Id",
				"FuZhuData3Name",
				"FuZhuData4Id",
				"FuZhuData4Name",
				"FuZhuData5Id",
				"FuZhuData5Name",
				"GoodsId",
				"GoodsDescribe",
				"StoreDescribe",
				"GNum",
				"GPiShu",
				"Remark1",
				"Remark2",
				"Remark3",
				"Remark4",
				"Remark5",
				"PiShu",
				"Num",
				"UserName",
				"TPId"};

		int[] szRId={R.id.tvRZPlanIdv,R.id.tvDataItem1v,R.id.tvDataItem2v,R.id.tvDataItem3v,
				R.id.tvFuZhuData1Id,
				R.id.tvFuZhuData1Name,
				R.id.tvFuZhuData2Id,
				R.id.tvFuZhuData2Name,
				R.id.tvFuZhuData3Id,
				R.id.tvFuZhuData3Name,
				R.id.tvFuZhuData4Id,
				R.id.tvFuZhuData4Name,
				R.id.tvFuZhuData5Id,
				R.id.tvFuZhuData5Name,
				R.id.tvGoodsId,
				R.id.tvGoodsDescribe,
				R.id.tvStoreDescribe,
				R.id.tvGNum,
				R.id.tvGPiShu,
				R.id.tvRemark1,
				R.id.tvRemark2,
				R.id.tvRemark3,
				R.id.tvRemark4,
				R.id.tvRemark5,
				R.id.tvPiShuv,
				R.id.tvNumv,
				R.id.tvUserNamev,
				R.id.tvInnerId
		};



		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.gd_directout_itemdetail;

		Intent intent=new Intent(mActParent,DPDetailInfo.class);
		intent.putExtra("data",mBdParam);
		mActParent.startActivity(intent);
	}

	public void SaveInfo()
	{
		EditText txtPiShu=(EditText)mActParent.findViewById(R.id.txtPiShu);
		EditText txtNum=(EditText)mActParent.findViewById(R.id.txtNum);

		String strPiShu=txtPiShu.getText().toString().trim();
		String strNum=txtNum.getText().toString().trim();


		if(strPiShu.equals("")||strNum.equals(""))
		{
			ActivityHelper.showDialog(mActParent, "提示", mActParent.getString(R.string.isNUll));
			return;
		}

		GDDirectOut.g_DirectOutInfo.strPiShu=strPiShu;
		GDDirectOut.g_DirectOutInfo.strNum=strNum;
		GDDirectOut.g_DirectOutInfo.strUser=BaseActivity.gUser.getUserName();

		int nRst=mSCToupeiDao.Add(GDDirectOut.g_DirectOutInfo);
		if(nRst==0)
		{
			ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.datareplace));
			DisplayInfo();
		}
		else if(nRst<1)
		{
			ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.saveFail));
		}
		else
		{
			ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.saveSuccess));
			DisplayInfo();
		}
	}

	public void ClearToupeiInfo()
	{
		mSCToupeiDao.DeleteAll(null);
		DisplayInfo();
	}

	public void DeleteToupeiInfo(String dataId)
	{
		mSCToupeiDao.DeleteById(dataId);
		DisplayInfo();
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		if(extrData!=null)
			mTouPeiList=mSCToupeiDao.GetTeipeiById(extrData[0]);

		mVctSendData=new Vector<Vector<String> > ();

		for(HashMap<String,Object> mapToupei:mTouPeiList)
		{
			Vector<String> child= new Vector<String>();

			//[采集器内部ID,染整计划号,数据项1,辅助1编号,辅助1名称,,辅助2编号,辅助2名称,辅助3编号,辅助3名称,
			//物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5,数据项2,数据项3,辅助4编号,辅助4名称,辅助5编号,辅助5名称,匹数,数量,用户名]
			child.add((String)mapToupei.get("TPId"));
			child.add((String)mapToupei.get("RZPlanId"));
			child.add((String)mapToupei.get("DataItem1"));
			child.add((String)mapToupei.get("FuZhuData1Id"));
			child.add((String)mapToupei.get("FuZhuData1Name"));
			child.add((String)mapToupei.get("FuZhuData2Id"));
			child.add((String)mapToupei.get("FuZhuData2Name"));
			child.add((String)mapToupei.get("FuZhuData3Id"));
			child.add((String)mapToupei.get("FuZhuData3Name"));
			child.add((String)mapToupei.get("GoodsId"));
			child.add((String)mapToupei.get("GoodsDescribe"));
			child.add((String)mapToupei.get("StoreDescribe"));
			child.add((String)mapToupei.get("StoreFlag"));
			child.add((String)mapToupei.get("GPiShu"));
			child.add((String)mapToupei.get("GNum"));
			child.add((String)mapToupei.get("Remark1"));
			child.add((String)mapToupei.get("Remark2"));
			child.add((String)mapToupei.get("Remark3"));
			child.add((String)mapToupei.get("Remark4"));
			child.add((String)mapToupei.get("Remark5"));
			child.add((String)mapToupei.get("DataItem2"));
			child.add((String)mapToupei.get("DataItem3"));
			child.add((String)mapToupei.get("FuZhuData4Id"));
			child.add((String)mapToupei.get("FuZhuData4Name"));
			child.add((String)mapToupei.get("FuZhuData5Id"));
			child.add((String)mapToupei.get("FuZhuData5Name"));
			child.add((String)mapToupei.get("PiShu"));
			child.add((String)mapToupei.get("Num"));
			child.add((String)mapToupei.get("UserName"));
			mVctSendData.add(child);
		}

		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		p.sendCmd0= DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAO0;
		p.sendCmd1=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAO1;
		p.sendCmd2=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAO2;
		p.receCmd0=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAORe0;
		p.receCmd1=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAORe1;
		p.receCmd3=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAORe3;
		p.receCmd5=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAORe5;

		return p;
	}
}
