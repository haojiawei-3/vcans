package com.vcans.Processor;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.Vcan.activity.R;
import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.adapter.ImageSimpleAdapter;
import com.vcans.dao.YPBarcodeImageDao;
import com.vcans.model.MyProtocol;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ProtocolCMD;

public class YPImageUploadProcessor extends UploadProcessor {

	public YPBarcodeImageDao mSCToupeiDao=null;
	List<HashMap<String,Object> > mTouPeiList=null;
	Vector<Vector<String> > mVctSendData=null;

	public YPImageUploadProcessor()
	{
		mSCToupeiDao=new YPBarcodeImageDao();
	}

	@Override
	public int ProcessData(Vector<String> vctDataId) {

		String strRecordIds=ConvertStringIds(vctDataId);

		mSCToupeiDao.DeleteAll(strRecordIds);
		DisplayTouPeiInfo();


		return 1;
	}

	public void DisplayTouPeiInfo()
	{
		mTouPeiList=mSCToupeiDao.GetAllTeipei();

		String[] szField={"ImgName","Barcode","TPId","Price","Num"};

		int[] szRId={R.id.imgYP,R.id.tvBarcode,R.id.tvInnerId,R.id.tvPrice,R.id.tvNum};

		SimpleAdapter adpter=new ImageSimpleAdapter(mActParent,mTouPeiList,R.layout.yp_barcodeimg_item,szField,szRId);
		ListView listView = (ListView) mActParent.findViewById(R.id.lvProdct);
		listView.setAdapter(adpter);
		TextView tvPage = (TextView) mActParent.findViewById(R.id.tvPage);
		tvPage.setText("(0/"+listView.getCount()+")");

		mActParent.processMessage(0,"");
	}

	public void DisplayOneInfo(List<HashMap<String,Object> > listMap)
	{

		String[] szField={"ImgName","Barcode","TPId","Price","Num"};

		int[] szRId={R.id.imgYP,R.id.tvBarcode,R.id.tvInnerId,R.id.tvPrice,R.id.tvNum};

		SimpleAdapter adpter=new ImageSimpleAdapter(mActParent,listMap,R.layout.yp_barcodenoimg_item,szField,szRId);
		ListView listView = (ListView) mActParent.findViewById(R.id.lvProdct);
		listView.setAdapter(adpter);
		TextView tvPage = (TextView) mActParent.findViewById(R.id.tvPage);
		tvPage.setText("(0/"+listView.getCount()+")");

		//mActParent.processMessage(0,"");
	}

	public int SaveToupeiInfo(YPExpInfo toupei)
	{
		if(toupei.strBarcode.equals("")||toupei.strImgName.equals(""))
		{
			ActivityHelper.showDialog(mActParent,"错误","条码不能为空!");
			return 0;
		}

		int nRst=mSCToupeiDao.AddToupei(toupei);
		if(nRst==2)
		{
			ActivityHelper.showDialog(mActParent,"提示","该信息已存在!");
			DisplayTouPeiInfo();
		}
		else if(nRst<1)
		{
			ActivityHelper.showDialog(mActParent,"错误","添加失败!");
		}
		else
		{
			ActivityHelper.showDialog(mActParent,"提示","保存成功!");
			DisplayTouPeiInfo();
			return 1;
		}

		return 0;
	}


	public int updatePhoto(YPExpInfo toupei)
	{
		int nRst=mSCToupeiDao.update(toupei);
		if(nRst==0)
		{
			ActivityHelper.showDialog(mActParent,"提示","该信息不存在!");
			DisplayTouPeiInfo();
		}
		else if(nRst<1)
		{
			ActivityHelper.showDialog(mActParent,"错误","添加失败!");
		}
		else
		{
			ActivityHelper.showDialog(mActParent,"提示","替换成功!");
			DisplayTouPeiInfo();
			return 1;
		}

		return 0;
	}

	public Bitmap[] getBitmapsByFilepaths(String paths)
	{

		String[] szFiles=ActivityHelper.mySplit(paths, ";");

		Bitmap[] images=new Bitmap[szFiles.length];
		int i=0;
		for(String filePath:szFiles)
		{
			BitmapFactory.Options options=new BitmapFactory.Options();
			options.inPurgeable=true;
			options.inSampleSize = 4;
			if(!filePath.equals(""))
				images[i++]=BitmapFactory.decodeFile(filePath,options);
			else
				images[i++]=BitmapFactory.decodeResource(mActParent.getResources(), R.drawable.no_img);

		}

		return images;
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
			mTouPeiList=mSCToupeiDao.GetToupeiById(extrData[0]);

		mVctSendData=new Vector<Vector<String> > ();

		for(HashMap<String,Object> mapToupei:mTouPeiList)
		{
			Vector<String> child= new Vector<String>();

			child.add((String)mapToupei.get("TPId"));
			child.add((String)mapToupei.get("Barcode"));
			child.add(ProtocolCMD.FILE_FIELD_FLAG+(String)mapToupei.get("FilePath"));


			mVctSendData.add(child);
		}

		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol myProtocol=new MyProtocol();

		myProtocol.sendCmd0=YPStandardProtocol.m_vfxVAG43VcanYangpinImage0;
		myProtocol.sendCmd1= YPStandardProtocol.m_vfxVAG43VcanYangpinImage1;
		myProtocol.sendCmd2=YPStandardProtocol.m_vfxVAG43VcanYangpinImage2;
		myProtocol.sendCmd3=YPStandardProtocol.m_vfxVAG43VcanYangpinImage3;
		myProtocol.receCmd0=YPStandardProtocol.m_vfxVAG43VcanYangpinImageRe0;
		myProtocol.receCmd1=YPStandardProtocol.m_vfxVAG43VcanYangpinImageRe1;
		myProtocol.receCmd3=YPStandardProtocol.m_vfxVAG43VcanYangpinImageRe3;
		myProtocol.receCmd5=YPStandardProtocol.m_vfxVAG43VcanYangpinImageRe5;

		return myProtocol;
	}
}
