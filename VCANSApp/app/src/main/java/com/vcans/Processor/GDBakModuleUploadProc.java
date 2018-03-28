package com.vcans.Processor;


import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;
import com.Vcan.activity.R;
import com.Vcan.activity.DPDetailInfo;
import com.Vcan.activity.GDBakModule;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.BakModuleDao;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ProtocolCMD;

public class GDBakModuleUploadProc extends UploadProcessor {

	public BakModuleDao mSCToupeiDao=null;
	List<HashMap<String,Object> > mTouPeiList=null;
	Vector<Vector<String> > mVctSendData=null;
	private BandleParam mBdParam=new BandleParam();

	public GDBakModuleUploadProc()
	{
		mSCToupeiDao=new BakModuleDao();
	}

	@Override
	public int ProcessData(Vector<String> vctDataId) {

		Vector<Vector<String>> vctReceData=this.mDataTrunsfer.GetReceiveData();
		String strRecordIds=ConvertStringIds(vctDataId);
		if (!strRecordIds.equals("")) {
			mSCToupeiDao.DeleteAll(strRecordIds);
			ActivityHelper.savedImagePath.clear();
			DisplayInfo();
		}



		return 1;
	}

	public void DisplayInfo()
	{
		mTouPeiList=mSCToupeiDao.GetAllInfo();
		String[] szField={"BakType",
				"DataItem1",
				"FuZhuData1Id",
				"FuZhuData2Id",
				"FuZhuData3Id",
				"GoodsId","PiShu",
				"Num","TPId"};

		int[] szRId={R.id.tvBakTypev,
				R.id.tvDataItem1v,
				R.id.tvFuZhuData1Id,
				R.id.tvFuZhuData2Id,
				R.id.tvFuZhuData3Id,
				R.id.tvGoodsId,
				R.id.tvPiShuv,
				R.id.tvNumv,
				R.id.tvInnerId
		};


		BaseActivity.showList(mActParent,
				mTouPeiList,
				R.layout.gd_bakmodule_item,
				szField,
				szRId,
				R.id.lvProdct,
				R.id.tvPage);
	}

	public void displayDetail(List<HashMap<String,Object> > mapInfo)
	{
		String[] szField={"BakType",
				"DataItem1","DataItem2","BakDate","DataItem3",
				"DataItem4","DataItem5","DataItem6","DataItem7",
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
				"FuZhuData6Id",
				"FuZhuData6Name",
				"FuZhuData7Id",
				"FuZhuData7Name",
				"FuZhuData8Id",
				"FuZhuData8Name",
				"FuZhuData9Id",
				"FuZhuData9Name",
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
				"DelPiShu",
				"DelNum",
				"PiShu",
				"Num",
				"UserName",
				"TPId"};

		int[] szRId={R.id.tvBakTypev,R.id.tvDataItem1v,R.id.tvDataItem2v,R.id.tvBakDatev,R.id.tvDataItem3v,
				R.id.tvDataItem4v,R.id.tvDataItem5v,R.id.tvDataItem6v,R.id.tvDataItem7v,
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
				R.id.tvFuZhuData6Id,
				R.id.tvFuZhuData6Name,
				R.id.tvFuZhuData7Id,
				R.id.tvFuZhuData7Name,
				R.id.tvFuZhuData8Id,
				R.id.tvFuZhuData8Name,
				R.id.tvFuZhuData9Id,
				R.id.tvFuZhuData9Name,

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
				R.id.tvDelPiShuv,
				R.id.tvDelNumv,
				R.id.tvPiShuv,
				R.id.tvNumv,
				R.id.tvUserNamev,
				R.id.tvInnerId
		};



		mBdParam.dataList=mapInfo;
		mBdParam.szFieldData=szField;
		mBdParam.szRId=szRId;
		mBdParam.rid=R.layout.gd_bakmodule_itemdetail;

		Intent intent=new Intent(mActParent,DPDetailInfo.class);
		intent.putExtra("data",mBdParam);
		mActParent.startActivity(intent);
	}

	public void SaveInfo()
	{
		EditText txtDataItem6=(EditText)mActParent.findViewById(R.id.txtDataItem6);
		EditText txtDataItem7=(EditText)mActParent.findViewById(R.id.txtDataItem7);
		EditText txtPiShu=(EditText)mActParent.findViewById(R.id.txtPiShu);
		EditText txtNum=(EditText)mActParent.findViewById(R.id.txtNum);
		Spinner  dropFz8=(Spinner)mActParent.findViewById(R.id.dropFuZhuData8);
		Spinner  dropFz9=(Spinner)mActParent.findViewById(R.id.dropFuZhuData9);

		String strDataItem6=txtDataItem6.getText().toString().trim();
		String strDataItem7=txtDataItem7.getText().toString().trim();
		String strPiShu=txtPiShu.getText().toString().trim();
		String strNum=txtNum.getText().toString().trim();
		String[] szFZ8=mActParent.getDropArray(dropFz8);
		String[] szFZ9=mActParent.getDropArray(dropFz9);


		if(strDataItem6.equals("")||strDataItem7.equals("")||strPiShu.equals("")||strNum.equals(""))
		{
			ActivityHelper.showDialog(mActParent, "提示", mActParent.getString(R.string.isNUll));
			return;
		}

		GDBakModule.g_BakModuleInfo.strDataItem6=strDataItem6;
		GDBakModule.g_BakModuleInfo.strDataItem7=strDataItem7;
		GDBakModule.g_BakModuleInfo.strPiShu=strPiShu;
		GDBakModule.g_BakModuleInfo.strNum=strNum;
		GDBakModule.g_BakModuleInfo.strFuZhuData8Id=szFZ8[1];
		GDBakModule.g_BakModuleInfo.strFuZhuData8Name=szFZ8[0];
		GDBakModule.g_BakModuleInfo.strFuZhuData9Id=szFZ9[1];
		GDBakModule.g_BakModuleInfo.strFuZhuData9Name=szFZ9[0];
		int nRst=mSCToupeiDao.Add(GDBakModule.g_BakModuleInfo);
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
			ActivityHelper.savedImagePath.add(GDBakModule.g_BakModuleInfo.strImgPath);
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

			/**
			 *  备用一类型/备用一数据1/备用一数据2/备用日期/备用一辅助资料1编号/备用一辅助资料1名称/备用一辅助资料2编号/备用一辅助资料2名称
			 * /备用一辅助资料3编号/备用一辅助资料3名称/备用一辅助资料4编号/备用一辅助资料4名称
			 * /[物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五]
			 * /备用一扣数量1/备用一扣数量2/备用一数据3/备用一数据4/备用一数据5/备用一辅助资料5编号/备用一辅助资料5名称/备用一辅助资料6编号/备用一辅助资料6名称
			 * /备用一辅助资料7编号/备用一辅助资料7名称/备用一数据6/备用一数据7/备用一辅助资料8编号/备用一辅助资料8名称
			 * /备用一辅助资料9编号/备用一辅助资料9名称/数量1/数量2/当前用户
			 * /图片信息
			 */
			child.add((String)mapToupei.get("TPId"));
			child.add((String)mapToupei.get("BakType"));
			child.add((String)mapToupei.get("DataItem1"));
			child.add((String)mapToupei.get("DataItem2"));
			child.add((String)mapToupei.get("BakDate"));
			child.add((String)mapToupei.get("FuZhuData1Id"));
			child.add((String)mapToupei.get("FuZhuData1Name"));
			child.add((String)mapToupei.get("FuZhuData2Id"));
			child.add((String)mapToupei.get("FuZhuData2Name"));
			child.add((String)mapToupei.get("FuZhuData3Id"));
			child.add((String)mapToupei.get("FuZhuData3Name"));
			child.add((String)mapToupei.get("FuZhuData4Id"));
			child.add((String)mapToupei.get("FuZhuData4Name"));
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
			child.add((String)mapToupei.get("DelPiShu"));
			child.add((String)mapToupei.get("DelNum"));
			child.add((String)mapToupei.get("DataItem3"));
			child.add((String)mapToupei.get("DataItem4"));
			child.add((String)mapToupei.get("DataItem5"));
			child.add((String)mapToupei.get("FuZhuData5Id"));
			child.add((String)mapToupei.get("FuZhuData5Name"));
			child.add((String)mapToupei.get("FuZhuData6Id"));
			child.add((String)mapToupei.get("FuZhuData6Name"));
			child.add((String)mapToupei.get("FuZhuData7Id"));
			child.add((String)mapToupei.get("FuZhuData7Name"));
			child.add((String)mapToupei.get("DataItem6"));
			child.add((String)mapToupei.get("DataItem7"));
			child.add((String)mapToupei.get("FuZhuData8Id"));
			child.add((String)mapToupei.get("FuZhuData8Name"));
			child.add((String)mapToupei.get("FuZhuData9Id"));
			child.add((String)mapToupei.get("FuZhuData9Name"));
			child.add((String)mapToupei.get("PiShu"));
			child.add((String)mapToupei.get("Num"));
			child.add((String)mapToupei.get("UserName"));
			String  strImage=(String)mapToupei.get("ImgPath");
			if(!strImage.equals("")){
				child.add(ProtocolCMD.FILE_FIELD_FLAG+strImage);}
			//child.add(ProtocolCMD.FILE_FIELD_FLAG+(String)mapToupei.get("ImgPath"));
			mVctSendData.add(child);
		}

		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		String strNum=GDBakModule.mapBakModuleId.get(GDBakModule.gBakFlag);

		p.sendCmd0=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_UPLOADBIAO0,strNum);
		p.sendCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_UPLOADBIAO1,strNum);
		p.sendCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_UPLOADBIAO2,strNum);
		p.receCmd0=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_UPLOADBIAORe0,strNum);
		p.receCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_UPLOADBIAORe1,strNum);
		p.receCmd3=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_UPLOADBIAORe3,strNum);
		p.receCmd5=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_UPLOADBIAORe5,strNum);

		return p;
	}
}
