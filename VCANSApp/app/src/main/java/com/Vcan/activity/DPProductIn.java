package com.Vcan.activity;

import java.util.HashMap;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPFuzuDownProcessor;
import com.vcans.Processor.DPPIDownOrderFactoryProcessor;
import com.vcans.Processor.DPPIDownWorkProcessor;
import com.vcans.adapter.SetDialog;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * 成品进仓   有4个界面类 分别  DPProductIn DPTouPei1（共用） DPProductIn2 DPProductIn3
 * @author vcans
 *
 */
public class DPProductIn extends BaseActivity {
	// public static DPProductIn dpProductIn = null;
	private DPPIDownOrderFactoryProcessor mDownProce=null;
	private SetDialog setDialog;
	private EditText txtRZPlan;
	private LinearLayout layProType;
	private Spinner dropRZFactory;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_productin);
		// dpProductIn=this;
		ActivityHelper.lstGongXu.clear();
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		this.<Button> RegOnClickEvent(R.id.btnSave, "onSet");
		this.<Button> RegOnClickEvent(R.id.imgBtnSave, "onSet");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"onOpenScanBarcode");

		txtRZPlan=(EditText)this.findViewById(R.id.txtRZPlanId);
		txtRZPlan.setFocusable(true);
		layProType=(LinearLayout)findViewById(R.id.layProType);
		dropRZFactory=(Spinner)findViewById(R.id.dropRZFactoryId);
		dropRZFactory.setOnItemSelectedListener(onItemSelectedFactoryId);


		ImageButton imgBtnSet = (ImageButton) this.findViewById(R.id.imgBtnSave);
		imgBtnSet.setImageResource(R.drawable.exp_set);

		Button btnSet = (Button) this.findViewById(R.id.btnSave);
		btnSet.setText(getString(R.string.set));

		String [] mParams=new String[]{"inProType"};
		HashMap<String,String> mapParams=ActivityHelper.getParams(this, mParams);

		if(mapParams.size()>0)
		{
			if(!mapParams.get("inProType").equals("1"))
				layProType.setVisibility(View.GONE);
			else
				layProType.setVisibility(View.VISIBLE);
		}

		setDialog=new SetDialog(this,R.layout.dp_productinset_item,new int[]{R.id.chkProType},mParams);

		mDownProce=new DPPIDownOrderFactoryProcessor();
		mDownProce.InitOrderAndDropFactory();

		txtRZPlan.setOnFocusChangeListener(new OnFocusChangeListener() {

			public void onFocusChange(View v, boolean hasFocus) {

				if (!hasFocus) {

					EditText txtRZPlanTemp=(EditText)findViewById(R.id.txtRZPlanId);
					String strRZPlanTemp=txtRZPlanTemp.getText().toString().trim();

					if(!strRZPlanTemp.equals(""))
					{
						//ActivityHelper.showStatusDialog(DPProductIn.this, "等待服务器响应...");
						//mDownProce.SendInfo(new String[]{strRZPlanTemp});

						sendFactoryRequest(strRZPlanTemp);
					}
					else
					{
						Message msgObj=new Message();
						msgObj.what=1;
						mDpHandler.sendMessageDelayed(msgObj, 500);
					}
				}
			}

		});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		EditText txtCompanyOrderId=(EditText)findViewById(R.id.txtCompanyOrder);
		EditText txtRZPlanTemp=(EditText)findViewById(R.id.txtRZPlanId);
		txtRZPlanTemp.setEnabled(true);
		txtCompanyOrderId.setEnabled(true);
		txtCompanyOrderId.setBackgroundColor(Color.WHITE);
	}

	public void onSet() {

		this.setDialog.show();
	}

	private void sendFactoryRequest(String strRZPlanTemp)
	{
		SendParam sendParam = new SendParam();
		sendParam.parent = DPProductIn.this;
		sendParam.processor = mDownProce;
		sendParam.szData = new String[]{strRZPlanTemp,"产出"};//产出为固定值
		getDataTrunsfer().request(sendParam);
	}

	final OnItemSelectedListener onItemSelectedFactoryId = new OnItemSelectedListener(){

		public void onItemSelected(AdapterView<?> arg0, View arg1,
								   int arg2, long arg3) {

			TextView tv = (TextView)arg1;

			if(tv!=null)
			{
				tv.setTextColor(Color.BLACK);    //设置颜色
				tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL);//设置居中

				String strSelectedText=tv.getText().toString();
				String[] szRZFactory=split(strSelectedText,"\\[","\\]");

				if(strSelectedText.indexOf("无数据")>-1)
					return ;

				SendParam sendParam = new SendParam();
				sendParam.parent = DPProductIn.this;
				sendParam.szData=new String[]{szRZFactory[1],txtRZPlan.getText().toString().trim()};
				sendParam.processor = new DPPIDownWorkProcessor();
				getDataTrunsfer().request(sendParam);
			}
		}


		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};


	@Override
	public void onActivityResult(int requestCode,int resultCode,Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode==REQUEST_SCAN_QRCODE_FLAG)
		{//条码扫描完毕返回
			if(resultCode==Activity.RESULT_OK)
			{
				Bundle bundle = data.getExtras();
				String strRst=bundle.getString("result");

				txtRZPlan.setText(strRst);
				sendFactoryRequest(strRst);
			}
		}
		else
		{}
	}

	public Handler mDpHandler=new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			if(msg.what==1)
			{
				EditText txtRZPlanTemp=(EditText)findViewById(R.id.txtRZPlanId);


				txtRZPlanTemp.setFocusable(true);
				txtRZPlanTemp.requestFocusFromTouch();
			}
		}
	};

	public void onNext()
	{
		Spinner dropProType=(Spinner)findViewById(R.id.dropProType);

		String strRZPlanId=txtRZPlan.getText().toString().trim();
		String strRZFactory=dropRZFactory.getSelectedItem().toString().trim();
		String[] szRZFactory=strRZFactory.split("\\[");

		String strProType=" ";
		if(layProType.getVisibility()==View.VISIBLE)
			strProType=dropProType.getSelectedItem().toString().trim();


		if(strRZPlanId.equals("")||szRZFactory.length<2||strProType.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		ActivityHelper.gToupei.strRZPlanId=strRZPlanId;
		ActivityHelper.gToupei.strRZFactoryName=szRZFactory[0];
		ActivityHelper.gToupei.strRZFactoryId=szRZFactory[1].substring(0,szRZFactory[1].length()-1);

		ActivityHelper.gToupei.strProType="";
		ActivityHelper.gToupei.strProTypeId="";
		if(!strProType.trim().equals(""))
		{
			String[] szGongxu=strProType.split("\\[");
			ActivityHelper.gToupei.strProType=szGongxu[0];
			ActivityHelper.gToupei.strProTypeId=szGongxu[1].substring(0,szGongxu[1].length()-1);
		}


		//与生产投坯共用一个 类DPTouPei1
		Intent intent=new Intent(this,DPTouPei1.class);
		intent.putExtra("actFlag",DPTouPei1.DP_PRODUCT_IN1);

		startActivity(intent);

	}

	@Override
	public void processMessage(int msgId, String msg) {

		if(msgId==DPPIDownWorkProcessor.DOWNLOAD_WORKPRCE_DONE)
		{
			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.processor = new DPFuzuDownProcessor();
			getDataTrunsfer().request(sendParam);
		}
	}

}
