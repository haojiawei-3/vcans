 package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.TextView;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.YPDownYpInfoProcessor;
import com.vcans.adapter.HorizontalAdapter;
import com.vcans.adapter.HorizontalListView;
import com.vcans.dao.YPInfoDao;
import com.vcans.model.BandleParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

public class YPDownValueProcessorV2{

	YPDownYpInfoProcessor downYPInfo=new YPDownYpInfoProcessor(YPInfoDao.DbType.YPQUERY);
	BaseActivity mActParent=PlProcessor.mActParent;
	
	private List<HashMap<String, Object>> barcodeList; 
	private List<HashMap<String, Object>> AllDataList; 
	private String oldBarcode="";
	
	private boolean bNewQuery;
	
	public  YPDownValueProcessorV2()
	{
		
	}
	
	public void setNewQuery(boolean newQuery)
	{
		bNewQuery=newQuery;
	}
	
	public void clearData()
	{
		downYPInfo.mDao.DeleteAll(null);
	}
	
	public void deleteOldData(String value)
	{
		if(value==null)
			downYPInfo.mDao.DeleteAll("'"+oldBarcode+"'");
		else
			downYPInfo.mDao.DeleteAll("'"+value+"'");
	}
	
	public  void getYPQueryHistory()
	{
		ActivityHelper.lastQueryBitmapList.clear();
		if(barcodeList==null)
			barcodeList=downYPInfo.mDao.GetParentList();
		int i=0;
		for(HashMap<String,Object> mapList:barcodeList)
		{
			if(++i>ActivityHelper.globalSysParam.nYpQueryHistoryNum) break;
			
			String str=(String)mapList.get("YPValue");
			String[] files=ActivityHelper.mySplit(str,";");
			
			for(String strF:files)
			{
				if(!strF.equals(""))
				{
					ActivityHelper.lastQueryBitmapList.add(strF);
					break;
				}
			}
		}
		
	}
	
	public int displayInfo(int index)
	{	 
		if(bNewQuery)
		{
			barcodeList=downYPInfo.mDao.GetParentList();			
			getYPQueryHistory();
			AllDataList=downYPInfo.mDao.GetAllTeipei();			
			bNewQuery=false;
		}
		
		 List<HashMap<String, Object> > listChild=new ArrayList<HashMap<String, Object> >();
		
		 String strFiles="";
		 
		if(index<barcodeList.size()) 
		{
		
			 String stBarcodeParent=(String)barcodeList.get(index).get("Barcode");
			 strFiles=(String)barcodeList.get(index).get("YPValue");
			 
			 int min=0;
			 
		
			 for(HashMap<String,Object> mapList:AllDataList)
			 {  
				   String stBarcode=(String)mapList.get("Barcode");
				   String strField=(String)mapList.get("YPField");
				  
				   if(stBarcode.equals(stBarcodeParent)&&!strField.equals(mActParent.getString(R.string.image)))
				   {
					   listChild.add(mapList);
				   } 
				   
				  
				  if(min==0)
				  {
					  min=Integer.valueOf((String)mapList.get("TPId"));
					  oldBarcode=(String)mapList.get("Barcode");
				  }
	
				  int temp=Integer.valueOf((String)mapList.get("TPId"));
				  
				  if(min>temp)
				  {
					  min=temp; 
					  oldBarcode=(String)mapList.get("Barcode");
				  }
			 }
		}
		 
		String[] szField={"YPField","YPValue"};
		int[] szRId={R.id.tvField,R.id.tvValue};
		
		BandleParam param=new BandleParam();
		param.dataList=listChild;
		param.szFieldData=szField;
		param.szRId=szRId;
		param.itemRId=R.layout.yp_info_item;
		param.listRId=R.id.lvProdct;
		param.pageRId=R.id.tvPage;
		
		
		mActParent.showList(param);	
		
		HorizontalListView hListView = (HorizontalListView)mActParent.findViewById(R.id.horizon_listview);     
		 Bitmap[] szBitmap=YPDownYpInfoProcessor.getBitmapsByFilepaths(strFiles);
		 mActParent.setSzBitmap(szBitmap);
		 Bitmap bitmap=BitmapFactory.decodeResource(mActParent.getResources(), R.drawable.no_img);
		if(listChild.size()==0)
		{ 
			hListView.setVisibility(View.GONE);  
		}
		else  {
			if(szBitmap!=null&&szBitmap.length>0){
			

			if (szBitmap[0]==bitmap) {
				   hListView.setVisibility(View.INVISIBLE);
			}else
			{
				   HorizontalAdapter hListViewAdapter = new HorizontalAdapter(mActParent.getApplicationContext(),null,szBitmap);  
			       hListView.setAdapter(hListViewAdapter); 	      
			       TextView tvImageNum=(TextView)mActParent.findViewById(R.id.tvImageTitle);
			       tvImageNum.setText(mActParent.getString(R.string.imageList)+"("+szBitmap.length+")");
			       hListView.setVisibility(View.VISIBLE);	
			}
		}	
		}
		
		return barcodeList.size();
	}
}
