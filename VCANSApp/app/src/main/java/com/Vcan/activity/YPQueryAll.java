package com.Vcan.activity;

import java.util.HashMap;

import com.Vcan.activity.R;
import com.example.qr_codescan.MipcaActivityCapture;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.YPDownFieldProcessor;
import com.vcans.Processor.YPDownQueryAllProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class YPQueryAll extends BaseActivity
{  // public static YPQueryAll ypQueryAll= null;
	private final int REQUEST_PHOTO_FLAG=1;
	private int mLastClickId = -1;
	private long mLastClickTime = 5000;
	private YPDownFieldProcessor downField=new YPDownFieldProcessor();
	private YPDownQueryAllProcessor mValueProce=new YPDownQueryAllProcessor();
	private EditText txtContent;
	String strContent="";
	String mstrBarcode;
	LinearLayout llSearchResult;
	ListView listView ;
	public int[] szColor;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yp_query_all);
		// ypQueryAll=this;
		this.<TextView>RegOnClickEvent(R.id.btnSearch,"onSearch");
		//this.<TextView>RegOnClickEvent(R.id.tvOpenScan,"onOpenScan");
		this.<TextView>RegOnClickEvent(R.id.btnBack,"finish");
		llSearchResult=(LinearLayout)this.findViewById(R.id.llSearchResult);

		listView = (ListView) findViewById(R.id.lvProdct);
		listView.setEmptyView(findViewById(R.id.tvTip));
		txtContent=(EditText)this.findViewById(R.id.txtContent);

		PlProcessor.SetParent(this);

		strContent=this.getIntent().getStringExtra("content");
		txtContent.setText(strContent);
		listView.setOnItemClickListener(listClickListener);
		onSearch();
	}

	@Override
	public void finish()
	{
		//mDataTrunsfer.CloseSocketConnect();
		ActivityHelper.recycleBitmaps(mValueProce.getBitmapList());
		super.finish();
	}


	public void onToYPQuery()
	{
		this.setMTitle("样品查询", R.id.tvActtitle);
		Intent intent = new Intent(this, YPQuery.class);
		intent.putExtra("barcode", mstrBarcode);
		startActivity(intent);
	}


	public final OnItemClickListener listClickListener=new OnItemClickListener(){

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
								long arg3) {

			// 如果是双击,1秒内连续点击判断为双击
			if(arg2==mLastClickId
					&& (Math.abs(mLastClickTime-System.currentTimeMillis()) < 1000))
			{
				mLastClickId = -1;
				mLastClickTime = 0;

				onToYPQuery();
			}
			else
			{
				mLastClickId =arg2;
				mLastClickTime = System.currentTimeMillis();

				HashMap<String,Object> mapToupei=(HashMap<String,Object>)listView.getItemAtPosition(arg2);
				mstrBarcode = (String) mapToupei.get("Barcode");
			}
		}
	};



	public void clearData()
	{
		new AlertDialog.Builder(this).setTitle("您确定清除吗？")
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						//mXyCustomerProce.ProcessData(null);

					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
	}

	public void onOpenScan()
	{
		Intent intent = new Intent();
		intent.setClass(this, MipcaActivityCapture.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivityForResult(intent,REQUEST_SCAN_QRCODE_FLAG);
	}

	public void onSearch()
	{
		strContent=txtContent.getText().toString().trim();

		if(strContent.equals("")||(BaseActivity.gUser==null))
		{
			return;
		}
		//这个地方有问题
		ActivityHelper.recycleBitmaps(mValueProce.getBitmapList());
		SendParam sendParam=new SendParam();
		sendParam.parent=YPQueryAll.this;
		sendParam.tip=getString(R.string.searching);
		sendParam.processor=mValueProce;
		sendParam.szData=new String[]{strContent,BaseActivity.gUser.getUserName()};//,BaseActivity.gUser.getUserName()
		getDataTrunsfer().request(sendParam);
	}


	@Override
	public void onActivityResult(int requestCode,int resultCode,Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode==REQUEST_PHOTO_FLAG)
		{
			if(resultCode==Activity.RESULT_OK)
			{

			}
		}
		else if(requestCode==REQUEST_SCAN_QRCODE_FLAG)
		{//条码扫描完毕返回
			if(resultCode==Activity.RESULT_OK)
			{
				Bundle bundle = data.getExtras();
				String strRst=bundle.getString("result");
				strContent=ActivityHelper.resolveBarcode(strRst);

				onSearch();
			}

		}
		else
		{
			//这里什么  都不用做
		}
	}



	@Override
	public void processMessage(int msgId,String msg)
	{
		if(msgId==0)
		{
			mValueProce.setFieldList(downField.GetFieldList());
			ActivityHelper.recycleBitmaps(this.getSzBitmap());
			SendParam sendParam=new SendParam();
			sendParam.parent=YPQueryAll.this;
			sendParam.tip=getString(R.string.searching);
			sendParam.processor=mValueProce;
			sendParam.szData=new String[]{strContent,BaseActivity.gUser.getUserName()};//,BaseActivity.gUser.getUserName()
			getDataTrunsfer().request(sendParam);
		}
		else
		{
//			 txtContent.setText("");
//			 strContent="";
			llSearchResult.setVisibility(View.VISIBLE);
		}

	}
}
