package com.vcans.Processor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.Vcan.activity.R;
import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.dao.YPQueryDao;
import com.vcans.model.MyProtocol;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;

public class YPDownBatchValueProcessor extends DownloadProcessor {

	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	List<String > mFieldList=new ArrayList<String >();
	YPQueryDao ypDao=new YPQueryDao();

	Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();

	public void setFieldList(List<String > fieldList)
	{
		mFieldList=fieldList;
	}


	@Override
	public int ProcessData() {


		new SaveThread().start();


		return 1;
	}

	class SaveThread extends Thread
	{
		@Override
		public void run()
		{
			initGoodsList();
		}
	};

	public void initGoodsList()
	{
		if(mFieldList==null)
			return;


		if(mDataTrunsfer!=null)
		{
			vctReceData=this.mDataTrunsfer.GetReceiveData();
			byte[] fileByte=mDataTrunsfer.GetFileData();

			if(fileByte!=null)
			{
				File file=new File(ActivityHelper.getFilePathNoName()+"/test.jpg");
				FileOutputStream fos=null;
				try {
					fos=new FileOutputStream(file);
					fos.write(fileByte);

					ImageView imgYp = (ImageView) mActParent.findViewById(R.id.imgYP);

					imgYp.setImageBitmap(BitmapFactory.decodeFile(file.getPath()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					if(fos!=null)
						try {
							fos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
		}

		String barcode="";
		YPExpInfo ypInfo=new YPExpInfo();

		for(Vector<String> record:vctReceData)
		{
			int i=0;

			for(String v:record)
			{
				if(i<mFieldList.size())
				{
					if(i==0)
						barcode=v;

					ypInfo.strBarcode=barcode;
					ypInfo.strYPField=mFieldList.get(i);
					ypInfo.strYPValue=v;

					//预添加
					ypDao.AddBatchYPInfo(ypInfo, YPQueryDao.TRUN_BEGIN);
				}
				else
				{
					break;
				}

				i++;
			}



			Message msg=new Message();
			msg.what=1;
			msg.obj=1;
			mHandler.sendMessage(msg);

		}

		//结束添加  提交事务
		ypDao.AddBatchYPInfo(null,YPQueryDao.TRUN_END);

		Message msg=new Message();
		msg.what=0;
		mHandler.sendMessage(msg);
	}


	public Handler mHandler=new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			if (msg.what == 1)
			{
				Integer row=(Integer)msg.obj;
				ActivityHelper.showProgressDialog(mActParent, vctReceData.size(),row);
			}
			else
			{
				ActivityHelper.showDialog(mActParent, "", "下载完毕");
			}
		}
	};


	public void displayYPInfo(String barcode)
	{
		mDataList.clear();
		mDataList=ypDao.GetYPInfoById(barcode);

		String[] szField={"YPField","YPValue"};
		int[] szRId={R.id.tvField,R.id.tvValue};
		SimpleAdapter adpter=new SimpleAdapter(mActParent,mDataList,R.layout.yp_info_item,szField,szRId);
		ListView listView = (ListView) mActParent.findViewById(R.id.lvProdct);
		listView.setAdapter(adpter);

		TextView tvPage = (TextView) mActParent.findViewById(R.id.tvPage);
		tvPage.setText("(0/"+listView.getCount()+")");

		if(mDataList.size()<1)
			ActivityHelper.showDialog(mActParent, "", "未查到该样品信息 ");
	}

	public void clearYpInfo()
	{
		ypDao.DeleteAll(null);
	}


	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();
		Vector<String> child= new Vector<String>();
		child.add("请求下载样品...");
		vctSendData.add(child);

		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		p.sendCmd1=YPStandardProtocol.m_vfxVAGSTD_YangPinXiaZai1;
		p.sendCmd2= YPStandardProtocol.m_vfxVAGSTD_YangPinXiaZai2;
		p.receCmd0=YPStandardProtocol.m_vfxVAGSTD_YangPinXiaZaiRe0;
		p.receCmd1=YPStandardProtocol.m_vfxVAGSTD_YangPinXiaZaiRe1;
		p.receCmd1=YPStandardProtocol.m_vfxVAGSTD_YangPinXiaZaiRe2;

		return p;
	}
}
