package com.vcans.Processor;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.Vcan.activity.R;
import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.dao.YPInfoDao;
import com.vcans.dao.YPInfoDao.DbType;
import com.vcans.model.MyProtocol;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;

public class YPDownYpInfoProcessor extends DownloadProcessor
{
	public YPInfoDao mDao;
	private String fileName="";
	List<byte[]> imgList;
	String mBarcode;

	List<String > mFieldList=new ArrayList<String >();

	public void setFieldList(List<String > fieldList)
	{
		mFieldList=fieldList;
	}


	DbType queryType;

	public YPDownYpInfoProcessor(YPInfoDao.DbType dbType)
	{
		queryType=dbType;
		mDao=new YPInfoDao(dbType);
	}


	@Override
	public int ProcessData()
	{

		Vector<Vector<String> > vctReceData= mDataTrunsfer.GetReceiveData();
		imgList=mDataTrunsfer.getFileByteList();

		HashMap<String,String> mapParms=new HashMap<String,String>();

		if(queryType==DbType.YP_IMAGE)
			mapParms.put("preImageNum", imgList.size()+"");

		ActivityHelper.saveParams(mActParent, mapParms);


		for(Vector<String> vctFields : vctReceData)
		{

			SaveYpInfo(vctFields);
		}

		ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.loadSuccess));
		//刷新数据
		mActParent.processMessage(1,"");

		fileName="";

		return 1;
	}

	public void SaveYpInfo(Vector<String> vctRecord)
	{
		int nStartImageIndex=-1;
		int imageIndex=0;

		if(nStartImageIndex==-1)
			nStartImageIndex=vctRecord.size()-imgList.size();


		String filePaths="";
		for(int i=0;i<imgList.size();i++)
		{
			imageIndex=Integer.valueOf(vctRecord.get(nStartImageIndex+i));

			if(imgList.get(imageIndex)!=null){
				filePaths+=ActivityHelper.fileBtyeToFile(imgList.get(imageIndex),imageIndex)+";";
				System.out.println(filePaths+"图片地址");
			}
			else
				filePaths+=";";
		}
		YPExpInfo ypInfoFile;
		YPExpInfo ypInfo=new YPExpInfo();
		ypInfo.strBarcode=this.mBarcode;
		ypInfo.strYPValue=filePaths.equals("")? ";":filePaths;
		ypInfo.strYPField=mActParent.getString(R.string.image);

		ypInfoFile=ypInfo;
		mDao.AddToupei(ypInfoFile);

		ypInfo=new YPExpInfo();
		ypInfo.strBarcode=this.mBarcode;

		for(int i=mFieldList.size()-1;i>=0;i--)
		{

			ypInfo.strYPField=mFieldList.get(i);
			if(i<vctRecord.size())
				ypInfo.strYPValue=vctRecord.get(i);

			mDao.AddToupei(ypInfo);
		}


	}

	public static Bitmap[] getBitmapsByFilepaths(String paths)
	{
		String[] szFiles=ActivityHelper.mySplit(paths, ";");
		Bitmap bitmap;
		Bitmap[] images=new Bitmap[szFiles.length];
		int i=0;
		for(String filePath:szFiles)
		{


			//旋转  纠正图片

			BitmapFactory.Options options=new BitmapFactory.Options();
			options.inSampleSize = 9;
			bitmap=null;
			if(!filePath.equals(""))
			{
				bitmap=BitmapFactory.decodeFile(filePath,options);

				if(bitmap!=null)
					bitmap=ActivityHelper.autoMatrixBitmap(filePath, bitmap);
				else
				{
					File file=new File(filePath);
					file.delete();
					bitmap=BitmapFactory.decodeResource(mActParent.getResources(), R.drawable.no_img);
				}
			}
			else
			{
				bitmap=null;
			}



			images[i++]=bitmap;
		}
		//bitmap.recycle();
		return images;
	}

	public  Vector<Vector<String> > GetSendData(String[] extrData)
	{

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> >();
		Vector<String> vctChild=new Vector<String>();
		if(extrData.length>0)
			this.mBarcode=extrData[0];

		for(String str:extrData)
		{
			vctChild.add(str);

		}

		vctSendData.add(vctChild);
		return vctSendData;
	}

	public MyProtocol GetProtocol()
	{
		MyProtocol p =new MyProtocol();

		p.sendCmd1=YPStandardProtocol.m_vfxVAGSTD_YangPinChaXun1;
		p.sendCmd4= YPStandardProtocol.m_vfxVAGSTD_YangPinChaXun4;
		p.receCmd0=YPStandardProtocol.m_vfxVAGSTD_YangPinChaXunRe0;
		p.receCmd1=YPStandardProtocol.m_vfxVAGSTD_YangPinChaXunRe1;

		return p;
	}
}
