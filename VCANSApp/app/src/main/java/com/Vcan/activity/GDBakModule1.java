package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.GDBakModuleDownFZProcessor;
import com.vcans.Processor.GDDirectOutDownGoodsProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * 备用模块   有5个界面类 分别  GDBakModule GDBakModule1 GDBakModule2 GDBakModule3 GDBakModule4
 * @author vcans
 *
 */
public class GDBakModule1 extends BaseActivity {

	// public static GDBakModule1 bakModule1 = null;
	private Spinner dropFuZhu2;
	private Spinner dropFuZhu3;
	private Spinner dropFuZhu4;
	private ListView mLvTouPei;
	private Button mBtnOk,tvLoad;
	private ImageButton imgBtnOk;
	private GDDirectOutDownGoodsProcessor downGoods=new GDDirectOutDownGoodsProcessor(GDDirectOutDownGoodsProcessor.BAK_MODULE);
	private TextView tvPage ,tvFuZhuData2,tvFuZhuData3,tvFuZhuData4;
	String FuZhu2,FuZhu3,FuZhu4;
	private boolean bLoadFlag=true;
	private boolean bLoadFlag1=false;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gd_bakmodule1);

		// bakModule1=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		setListItemClickMethod("onGoodsItemClick","onGoodsItemDbClick");
		tvFuZhuData2=(TextView)this.findViewById(R.id.tvFuZhuData2);
		tvFuZhuData3=(TextView)this.findViewById(R.id.tvFuZhuData3);
		tvFuZhuData4=(TextView)this.findViewById(R.id.tvFuZhuData4);
		dropFuZhu2=(Spinner)this.findViewById(R.id.dropFuZhuData2);
		dropFuZhu3=(Spinner)this.findViewById(R.id.dropFuZhuData3);
		dropFuZhu4=(Spinner)this.findViewById(R.id.dropFuZhuData4);
		mLvTouPei=(ListView)this.findViewById(R.id.lvProdct);
		mBtnOk=(Button)this.findViewById(R.id.btnOk);
		imgBtnOk=(ImageButton)this.findViewById(R.id.imgBtnOk);
		imgBtnOk.setImageResource(R.drawable.load_goods);
		mBtnOk.setText(getString(R.string.goodsLoad));
		tvPage=(TextView)this.findViewById(R.id.tvPage);

		dropFuZhu2.setOnItemSelectedListener(onItemSelectedFZ);
		dropFuZhu3.setOnItemSelectedListener(onItemSelectedFZ);
		request();
		new Handler().postDelayed(new Runnable() {
			public void run() {
				if (bLoadFlag1) {
					onNext();
				}
			}
		}, 1000);
	}
	private void request() {
		// TODO Auto-generated method stub
		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.szData=new String[]{
				GDBakModule.g_BakModuleInfo.strBakType,
				GDBakModule.g_BakModuleInfo.strDataItem1,
				GDBakModule.g_BakModuleInfo.strDataItem2,
				GDBakModule.g_BakModuleInfo.strDate,
				GDBakModule.g_BakModuleInfo.strFuZhuData1Id,
				GDBakModule.g_BakModuleInfo.strFuZhuData1Name,
				GDBakModule.g_BakModuleInfo.strUser};
		sendParam.processor =new GDBakModuleDownFZProcessor(GDBakModuleDownFZProcessor.FZ2);
		getDataTrunsfer().request(sendParam);
		bLoadFlag1=true;

	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub

		super.onResume();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		setListItemClickMethod("onGoodsItemClick","onGoodsItemDbClick");

		super.onRestart();
	}

	public void onGoodsItemClick(int index)
	{
		//获得选中项的HashMap对象
		HashMap<String,Object> mapToupei=(HashMap<String,Object>)mLvTouPei.getItemAtPosition(index);

		GDBakModule.g_BakModuleInfo.goods.strGoodsId=(String)mapToupei.get("GoodsId");
		GDBakModule.g_BakModuleInfo.goods.strGoodsDescribe=(String)mapToupei.get("GoodDescribe");
		GDBakModule.g_BakModuleInfo.goods.strStoreDescribe=(String)mapToupei.get("StoreDescribe");
		GDBakModule.g_BakModuleInfo.goods.strStoreFlag=(String)mapToupei.get("StoreFlag");
		GDBakModule.g_BakModuleInfo.goods.strPiShu=(String)mapToupei.get("GPiShu");
		GDBakModule.g_BakModuleInfo.goods.strNum=(String)mapToupei.get("GNum");
		GDBakModule.g_BakModuleInfo.goods.strRemark1=(String)mapToupei.get("Remark1");
		GDBakModule.g_BakModuleInfo.goods.strRemark2=(String)mapToupei.get("Remark2");
		GDBakModule.g_BakModuleInfo.goods.strRemark3=(String)mapToupei.get("Remark3");
		GDBakModule.g_BakModuleInfo.goods.strRemark4=(String)mapToupei.get("Remark4");
		GDBakModule.g_BakModuleInfo.goods.strRemark5=(String)mapToupei.get("Remark5");

		//设置按钮为下一步
		bLoadFlag=false;
		mBtnOk.setText(getString(R.string.btn_next));
		imgBtnOk.setImageResource(R.drawable.next_blue);


		String[] szStr=tvPage.getText().toString().split("/");
		tvPage.setText("("+(index+1)+"/"+szStr[1]);
	}

	public void onGoodsItemDbClick(int index)
	{
		//获得选中项的HashMap对象
		HashMap<String,Object> mapToupei=(HashMap<String,Object>)mLvTouPei.getItemAtPosition(index);

		List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
		mDataList.add(mapToupei);
		downGoods.displayDetail(mDataList);
	}


	final OnItemSelectedListener onItemSelectedFZ = new OnItemSelectedListener(){

		public void onItemSelected(AdapterView<?> arg0, View arg1,
								   int arg2, long arg3) {
			FuZhu2=(String)dropFuZhu2.getSelectedItem();
			FuZhu3=(String)dropFuZhu3.getSelectedItem();
			FuZhu4=(String)dropFuZhu4.getSelectedItem();

			TextView tv = (TextView)arg1;

			if(tv!=null)
			{
				tv.setTextColor(Color.BLACK);    //设置颜色
				tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL);//设置居中
				imgBtnOk.setImageResource(R.drawable.load_goods);
				mBtnOk.setText(getString(R.string.goodsLoad));
				bLoadFlag=true;

				String strSelectedText=tv.getText().toString();
				String[] szFz=split(strSelectedText,"\\[","\\]");

				SendParam sendParam=null;

				if(arg0.getId()==R.id.dropFuZhuData2)
				{
					GDBakModule.g_BakModuleInfo.strFuZhuData2Id=szFz[1];
					GDBakModule.g_BakModuleInfo.strFuZhuData2Name=szFz[0];

					sendParam = new SendParam();
					sendParam.parent = GDBakModule1.this;
					sendParam.szData=new String[]{
							GDBakModule.g_BakModuleInfo.strBakType,
							GDBakModule.g_BakModuleInfo.strDataItem1,
							GDBakModule.g_BakModuleInfo.strDataItem2,
							GDBakModule.g_BakModuleInfo.strDate,
							GDBakModule.g_BakModuleInfo.strFuZhuData1Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData1Name,
							GDBakModule.g_BakModuleInfo.strFuZhuData2Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData2Name,
							GDBakModule.g_BakModuleInfo.strUser};
					sendParam.processor =new GDBakModuleDownFZProcessor(GDBakModuleDownFZProcessor.FZ3);
					bLoadFlag1=false;
				}
				else if(arg0.getId()==R.id.dropFuZhuData3)
				{
					GDBakModule.g_BakModuleInfo.strFuZhuData3Id=szFz[1];
					GDBakModule.g_BakModuleInfo.strFuZhuData3Name=szFz[0];

					sendParam = new SendParam();
					sendParam.parent =GDBakModule1.this;
					sendParam.szData=new String[]{
							GDBakModule.g_BakModuleInfo.strBakType,
							GDBakModule.g_BakModuleInfo.strDataItem1,
							GDBakModule.g_BakModuleInfo.strDataItem2,
							GDBakModule.g_BakModuleInfo.strDate,
							GDBakModule.g_BakModuleInfo.strFuZhuData1Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData1Name,
							GDBakModule.g_BakModuleInfo.strFuZhuData2Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData2Name,
							GDBakModule.g_BakModuleInfo.strFuZhuData3Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData3Name,
							GDBakModule.g_BakModuleInfo.strUser};
					sendParam.processor =new GDBakModuleDownFZProcessor(GDBakModuleDownFZProcessor.FZ4);
					bLoadFlag1=false;
				}

				if(sendParam!=null)
					getDataTrunsfer().request(sendParam);
			}


		};


		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};

	public void onLoadGoodsInfo()
	{
		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.processor = downGoods;
		sendParam.szData=new String[]{GDBakModule.g_BakModuleInfo.strBakType,
				GDBakModule.g_BakModuleInfo.strDataItem1,
				GDBakModule.g_BakModuleInfo.strDataItem2,
				GDBakModule.g_BakModuleInfo.strDate,
				GDBakModule.g_BakModuleInfo.strFuZhuData1Id,
				GDBakModule.g_BakModuleInfo.strFuZhuData1Name,
				GDBakModule.g_BakModuleInfo.strFuZhuData2Id,
				GDBakModule.g_BakModuleInfo.strFuZhuData2Name,
				GDBakModule.g_BakModuleInfo.strFuZhuData3Id,
				GDBakModule.g_BakModuleInfo.strFuZhuData3Name,
				GDBakModule.g_BakModuleInfo.strFuZhuData4Id,
				GDBakModule.g_BakModuleInfo.strFuZhuData4Name,
				GDBakModule.g_BakModuleInfo.strUser
		};
		getDataTrunsfer().request(sendParam);
	}

	public void onNext()
	{
		if(bLoadFlag)
		{
			String[] szFz4=getDropArray(dropFuZhu4);
			GDBakModule.g_BakModuleInfo.strFuZhuData4Id=szFz4[1];
			GDBakModule.g_BakModuleInfo.strFuZhuData4Name=szFz4[0];

			onLoadGoodsInfo();
		}
		else
		{
			Intent intent=new Intent(this,GDBakModule2.class);
			startActivity(intent);
		}
	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub


	}

}
