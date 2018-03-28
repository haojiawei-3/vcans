package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;

import com.Vcan.activity.R;
import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.adapter.CommentImageAdapter;
import com.vcans.adapter.CommentReplyAdapter;
import com.vcans.adapter.ImageSimpleAdapter;
import com.vcans.adapter.testadapter;
import com.vcans.dao.YPQueryDao;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class YPDownQueryAllProcessor extends DownloadProcessor {
	testadapter adapter;
	List<HashMap<String,Object> > mTouPeiList=null;
	Vector<Vector<String> > mVctSendData=null;
	private CommentImageAdapter commentAdapter;
	public CommentImageAdapter getCommentAdapter() {
		return commentAdapter;
	}

	private CommentReplyAdapter commentReplyAdapter;
	private List<HashMap<String, Object>> list_comment=new ArrayList<HashMap<String, Object>>();;

	private OnTouchListener onTouchListener;

	public void setOnTouchListener(OnTouchListener onTouchListener) {
		this.onTouchListener = onTouchListener;
	}

	public List<List<HashMap<String, Object>>> getList_comment_child() {
		return list_comment_child;
	}

	private Bitmap[] szBitmap;

	public Bitmap[] getBitmapList()
	{
		return szBitmap;
	}

	private List<List<HashMap<String, Object>>> list_comment_child=new ArrayList<List<HashMap<String, Object> > >();

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
		if(mDataTrunsfer.isDownloadContinue()){
			Log.e("TAG", "继续下载");
		}
		else{
			ActivityHelper.showDialog(mActParent, "", "全部下载完毕");

		}



		return 1;
	}

	class SaveThread extends Thread
	{
		@Override
		public void run()
		{
			//initGoodsList();
			initYPInfoList();
		}
	};


	public void initYPInfoList()
	{

		if(mDataTrunsfer==null) return ;

		vctReceData=this.mDataTrunsfer.GetReceiveData();



		List<byte[]> imgList=mDataTrunsfer.getFileByteList();


		Bitmap bitmap=null;
		int imageIndex=0;

		szBitmap=new Bitmap[vctReceData.size()];
		int i=0;

		for(Vector<String> record:vctReceData)
		{
			HashMap<String,Object> mapYpInfo=new HashMap<String,Object>();

			if(record.size()>2)
			{
				mapYpInfo.put("Barcode", record.get(0));
				mapYpInfo.put("PinHao", record.get(1));
				mapYpInfo.put("Decribe",record.get(2));
				//问题    //==样品==搜索==
				if (imgList.size()==0) {
					bitmap=BitmapFactory.decodeResource (mActParent.getResources(),R.drawable.no_img);
					mapYpInfo.put("images",bitmap);
				}else {
					byte[] szBuf=imgList.get(0);
					if(szBuf!=null)
						bitmap=ActivityHelper.ByteArrayToBitmap(szBuf);
					else
						bitmap=BitmapFactory.decodeResource (mActParent.getResources(),R.drawable.no_img);
					mapYpInfo.put("images",bitmap);
				}


				szBitmap[i++]=bitmap;
				list_comment.add(mapYpInfo);
			}

			Message msg=new Message();
			msg.what=1;
			msg.obj=1;
			mHandler.sendMessage(msg);
		}


		Message msg=new Message();
		msg.what=0;
		mHandler.sendMessage(msg);
	}





/*	public void initGoodsList()
	{
		if(mFieldList==null)
			return;


		if(mDataTrunsfer==null) return ;

		vctReceData=this.mDataTrunsfer.GetReceiveData();
		List<byte[]> imgList=mDataTrunsfer.getFileByteList();


		String barcode="";
		String barcodeField="";
		list_comment_child.clear();
		list_comment.clear();

		for(Vector<String> record:vctReceData)
		{
			List<HashMap<String,Object> > dataList=new ArrayList<HashMap<String,Object> >();
			int i=0,imageIndex=0;
			String filePaths="";

			for(String v:record)
			{
				if(i<mFieldList.size())
				{
					if(i==0)
					{
						barcode=v;
						barcodeField=mFieldList.get(i);
					}

					HashMap<String,Object> mapYpInfo=new HashMap<String,Object>();
					mapYpInfo.put("Barcode", barcode);
					mapYpInfo.put("YPField", mFieldList.get(i));
					mapYpInfo.put("YPValue",v);
					dataList.add(mapYpInfo);
				}
				else
				{
					if(imgList.get(imageIndex)!=null)
						filePaths+=ActivityHelper.fileBtyeToFile(imgList.get(imageIndex),imageIndex)+";";
					else
						filePaths+=";";

					imageIndex++;
				}

				i++;
			}


			if(!filePaths.equals(""))
			{
				HashMap<String,Object> map=new HashMap<String,Object>();
				map.put("Barcode", barcode);
				map.put("YPField", mActParent.getString(R.string.image));
				map.put("YPValue",filePaths);
				list_comment.add(map);
			}
			else
			{
				HashMap<String,Object> map=new HashMap<String,Object>();
				map.put("Barcode", barcode);
				map.put("YPField", barcodeField);
				map.put("YPValue",barcode);
				list_comment.add(map);
			}

			list_comment_child.add(dataList);

			Message msg=new Message();
			msg.what=1;
			msg.obj=1;
			mHandler.sendMessage(msg);
		}


		Message msg=new Message();
		msg.what=0;
		mHandler.sendMessage(msg);
	}*/


	public Handler mHandler=new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
//            if (msg.what == 1)
//            {
//            	Integer row=(Integer)msg.obj;
//            	ActivityHelper.showProgressDialog(mActParent, vctReceData.size(),row);
//            }
//            else
//            {

			ActivityHelper.closeStatusDialog();
			//DisplayTouPeiInfo();
			DisplayYPInfo();
//            }
		}
	};


	public void DisplayYPInfo()
	{
		String[] szField={"images","Barcode","PinHao","Decribe"};

		int[] szRId={R.id.iv_YPPic,R.id.tvBarcode,R.id.tvPinHao,R.id.tvDecribe};

		ListView listView = (ListView) mActParent.findViewById(R.id.lvProdct);
		if(listView==null) return;

		ImageSimpleAdapter adpter=new ImageSimpleAdapter(mActParent,list_comment,R.layout.yp_search_item,szField,szRId);
		listView.setAdapter(adpter);
		//这里电脑端存在问题    可能发送过来的图片都是一样   下面是测试
//		adapter=new testadapter(mActParent, list_comment);
//		listView.setAdapter(adapter);


		TextView tvPage = (TextView) mActParent.findViewById(R.id.tvPage);
		tvPage.setText(mActParent.getString(R.string.searchResult)+listView.getCount()+"");

		mActParent.processMessage(10,"");
	}


	public void DisplayTouPeiInfo()
	{
		//String[] szField={"TPId","Barcode","YPField","YPValue"};

		//int[] szRId={R.id.imgYP,R.id.tvBarcode,R.id.tvInnerId,R.id.tvPrice,R.id.tvNum};


		if(list_comment.size()<1) return ;

		commentAdapter = new CommentImageAdapter(mActParent, list_comment,
				list_comment_child, myOnitemcListener, commentReplyAdapter);

		commentAdapter.setOnTouchListener(onTouchListener);

		ListView listView = (ListView) mActParent.findViewById(R.id.lvProdct);
		if(listView==null) return;

		listView.setAdapter(commentAdapter);

		TextView tvPage = (TextView) mActParent.findViewById(R.id.tvPage);
		tvPage.setText("搜索结果: 共"+listView.getCount()+"条记录");

		mActParent.processMessage(10,"");
	}

	final public OnClickListener myOnitemcListener = new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			commentAdapter.setSelectIndex(v.getId());
			commentAdapter.notifyDataSetChanged();
		}
	};

	public void clearYpInfo()
	{
		ypDao.DeleteAll(null);
	}


	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		list_comment.clear();
		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();
		Vector<String> vctChild= new Vector<String>();
		for(String str:extrData)
		{
			vctChild.add(str);

		}
		vctSendData.add(vctChild);

		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		p.sendCmd1= YPStandardProtocol.m_vfxVAGSTD_YangPinSearch1;
		p.sendCmd2=YPStandardProtocol.m_vfxVAGSTD_YangPinSearch2;
		p.receCmd0=YPStandardProtocol.m_vfxVAGSTD_YangPinSearchRe0;
		p.receCmd1=YPStandardProtocol.m_vfxVAGSTD_YangPinSearchRe1;
		p.receCmd2=YPStandardProtocol.m_vfxVAGSTD_YangPinSearchRe2;

		return p;
	}
}
