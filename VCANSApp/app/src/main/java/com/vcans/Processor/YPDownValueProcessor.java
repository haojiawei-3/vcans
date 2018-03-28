package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.TextView;

import com.Vcan.activity.R;
import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.adapter.HorizontalAdapter;
import com.vcans.adapter.HorizontalListView;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class YPDownValueProcessor extends DownloadProcessor {

	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	List<String > mFieldList=new ArrayList<String >();

	public void setFieldList(List<String > fieldList)
	{
		mFieldList=fieldList;
	}


	@Override
	public int ProcessData() {

		initGoodsList();

		return 1;
	}

	public void initGoodsList()
	{
		if(mFieldList==null)
			return;

		Bitmap[] szBitmap=null;
		Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
		if(mDataTrunsfer!=null)
		{
			vctReceData=this.mDataTrunsfer.GetReceiveData();
			List<byte[]> fileByteList=mDataTrunsfer.getFileByteList();


			if(fileByteList!=null&&fileByteList.size()>0)
			{
				szBitmap=new Bitmap[fileByteList.size()];
				int i=0;
				boolean find=false;
				for(byte[] fileByte:fileByteList)
				{
					//File file=new File(ActivityHelper.getFilePathNoName()+"/test"+(++i)+".jpg");
					//FileOutputStream fos=null;
					try {
						//fos=new FileOutputStream(file);
						//fos.write(fileByte);

						BitmapFactory.Options options=new BitmapFactory.Options();
						options.inPurgeable=true;
						options.inSampleSize = ActivityHelper.IMAGE_COMPRESS_RATIO;
						//imgYp.setVisibility(View.VISIBLE);
						//imgYp.setImageBitmap(BitmapFactory.decodeByteArray(fileByte, 0, fileByte.length,options));

						//imgYp.setImageBitm ' fb  ap(BitmapFactory.decodeFile(file.getPath()));

						if(fileByte!=null)
						{
							szBitmap[i]=BitmapFactory.decodeByteArray(fileByte, 0, fileByte.length,options);
							if(!find)
							{
								find=true;
								if(ActivityHelper.lastQueryBitmapList.size()<6)
									ActivityHelper.lastQueryBitmapList.add(ActivityHelper.fileBtyeToFile(fileByte,"memu_image"+(ActivityHelper.lastQueryBitmapList.size()+1)));
								else
								{
									if(ActivityHelper.nlastQueryBitmapListIndex>=6)
										ActivityHelper.nlastQueryBitmapListIndex=0;

									ActivityHelper.lastQueryBitmapList.set(ActivityHelper.nlastQueryBitmapListIndex,
											ActivityHelper.fileBtyeToFile(fileByte,"memu_image"+(ActivityHelper.nlastQueryBitmapListIndex+1)));
									ActivityHelper.nlastQueryBitmapListIndex++;
								}
							}
							i++;
						}
						else
						{
							szBitmap[i++]=BitmapFactory.decodeResource(mActParent.getResources(),R.drawable.no_img);
						}

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						/*
						finally
						{
							if(fos!=null)
								try {
									fos.flush();
									fos.close();
									fos=null;
								} catch (IOException e) {
									// TODO Auto-generated catch block
									//e.printStackTrace();
								}
						}	
						*/
				}
			}
			else
			{
				//imgYp.setVisibility(View.INVISIBLE);
			}

		}


		mDataList.clear();

		for(Vector<String> record:vctReceData)
		{
			int i=0;

			for(String v:record)
			{
				if(i<mFieldList.size())
				{
					HashMap<String,Object> mapData=new HashMap<String,Object> ();
					mapData.put("field", mFieldList.get(i));
					mapData.put("value", v);

					mDataList.add(mapData);
				}
				else
				{
					break;
				}

				i++;
			}
		}

		String[] szField={"field","value"};
		int[] szRId={R.id.tvField,R.id.tvValue};

		BandleParam param=new BandleParam();
		param.dataList=mDataList;
		param.szFieldData=szField;
		param.szRId=szRId;
		param.itemRId=R.layout.yp_info_item;
		param.listRId=R.id.lvProdct;
		param.pageRId=R.id.tvPage;

		mActParent.showList(param);

		HorizontalListView hListView = (HorizontalListView)mActParent.findViewById(R.id.horizon_listview);

		if(szBitmap!=null)
		{
			HorizontalAdapter hListViewAdapter = new HorizontalAdapter(mActParent.getApplicationContext(),null,szBitmap);
			hListView.setAdapter(hListViewAdapter);
			mActParent.setSzBitmap(szBitmap);
			TextView tvImageNum=(TextView)mActParent.findViewById(R.id.tvImageTitle);
			tvImageNum.setText(mActParent.getString(R.string.imageList)+"("+szBitmap.length+")");
		}
		else
		{
			hListView.setVisibility(View.INVISIBLE);
		}

		mActParent.processMessage(123456, "");
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
		//VCANS模板采集器标准版==样品查询
		p.sendCmd1= YPStandardProtocol.m_vfxVAGSTD_YangPinChaXun1;
		p.sendCmd4=YPStandardProtocol.m_vfxVAGSTD_YangPinChaXun4;
		p.receCmd0=YPStandardProtocol.m_vfxVAGSTD_YangPinChaXunRe0;
		p.receCmd1=YPStandardProtocol.m_vfxVAGSTD_YangPinChaXunRe1;

		return p;
	}
}
