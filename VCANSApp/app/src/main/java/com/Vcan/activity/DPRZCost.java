package com.Vcan.activity;

import com.Vcan.activity.R;

import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPRZCostDownFactoryProcessor;
import com.vcans.Processor.DPRZCostDownPlanIdProcessor;
import com.vcans.Processor.DPRZCostDownWorkProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

/**
 * 染整费用   有2个界面类 分别  DPRZCost  DPRZCost1
 * @author vcans
 *
 */
public class DPRZCost extends BaseActivity {
	//public static DPRZCost dprzCost = null;
	private EditText txtRZPlan;
	private EditText txtRZFactoryId;
	private EditText txtRZFactoryName;
	private int scanFlag;
	//ImageView sip;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_rzcost);
		// dprzCost=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"onScanPlanId");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode2,"onScanFactory");
		this.<EditText>RegOnClickEvent(R.id.txtRZFactoryName,"onLoadFactoryName");

		txtRZPlan=(EditText)this.findViewById(R.id.txtRZPlanId);
		txtRZFactoryId=(EditText)findViewById(R.id.txtRZFactoryId);
		txtRZFactoryName=(EditText)findViewById(R.id.txtRZFactoryName);
		// sip=(ImageView)findViewById(R.id.btnScanBarcode2);
		//  sip.setBackground(R.drawable.qrcode_scan);
		PlProcessor.SetParent(this);
		SendParam sendParam = new SendParam();
		sendParam.tip = getString(R.string.btn_load)+"...";
		sendParam.parent = this;
		sendParam.processor = new DPRZCostDownWorkProcessor();
		getDataTrunsfer().request(sendParam);

		txtRZFactoryName.setOnFocusChangeListener(new OnFocusChangeListener() {

			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus) {
					if ( !txtRZPlan.getText().toString().trim().equals("")) {
						//查询计划号
						SendParam sendParam = new SendParam();
						sendParam.parent = DPRZCost.this;
						sendParam.tip = getString(R.string.btn_query)+"...";
						sendParam.processor = new DPRZCostDownPlanIdProcessor();
						sendParam.szData=new String[]{txtRZPlan.getText().toString().trim()};
						getDataTrunsfer().request(sendParam);
					}else {
						ActivityHelper.ToastShow(DPRZCost.this, "数据不能为空");
					}



				}
			}

		});
	}

	final  TextWatcher mWatcher= new TextWatcher() {

		public void afterTextChanged(Editable s) {


			if(!s.toString().trim().equals(""))
			{
				// mDpHandler.removeMessages(2);
				// Message msgObj=new Message();
				// msgObj.what=2;
				// mDpHandler.sendMessageDelayed(msgObj,2000);
			}
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
									  int after) {
			// TODO Auto-generated method stub

		}

		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub

		}
	};

	public void onScanPlanId()
	{
		scanFlag=0;
		onOpenScanBarcode();
	}

	public void onScanFactory()
	{
		scanFlag=1;
		onOpenScanBarcode();
	}


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

				if(scanFlag==0)
					txtRZPlan.setText(strRst);
				else
					txtRZFactoryId.setText(strRst);
			}
		}
		else
		{}
	}

	public  Handler mDpHandler=new Handler()
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
			else if(msg.what==2)
			{
				ActivityHelper.hidesofeKeyboard(DPRZCost.this);
			}
		}
	};


	public void onLoadFactoryName()
	{
		String rzPlanId=txtRZPlan.getText().toString().trim();
		String rzFactoryId=this.txtRZFactoryId.getText().toString().trim();
		if(rzPlanId.equals("")||rzFactoryId.equals(""))
		{
			ActivityHelper.showDialog(this, "", getString(R.string.RZFactoryId)+","+getString(R.string.RZFactoryId)+getString(R.string.isNUll));
			return;
		}

		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.processor = new DPRZCostDownFactoryProcessor();
		sendParam.szData = new String[]{rzFactoryId,rzPlanId};
		getDataTrunsfer().request(sendParam);


		ActivityHelper.hidesofeKeyboard(this);
	}

	public void onNext()
	{
		EditText txtRZFactoryName=(EditText)findViewById(R.id.txtRZFactoryName);

		String strRZPlanId=this.txtRZPlan.getText().toString().trim();
		String strRZFactoryId=txtRZFactoryId.getText().toString().trim();
		String strRZFactoryName=txtRZFactoryName.getText().toString().trim();

		//工序
		Spinner sp=(Spinner)this.findViewById(R.id.dropWorkProcess);
		String strGongxu=sp.getSelectedItem().toString().trim();

		if(strGongxu.equals(""))
			return;

		String[] szGongxu=strGongxu.split("\\[");

		if(szGongxu.length<2)
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		ActivityHelper.gToupei.strGongXuName=szGongxu[0];
		ActivityHelper.gToupei.strGongXuId=szGongxu[1].substring(0,szGongxu[1].length()-1);

		if(strRZPlanId.equals("")||strRZFactoryId.equals("")||strRZFactoryName.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		ActivityHelper.gToupei.strRZPlanId=strRZPlanId;
		ActivityHelper.gToupei.strRZFactoryId=strRZFactoryId;
		ActivityHelper.gToupei.strRZFactoryName=strRZFactoryName;

		Intent intent=new Intent(this,DPRZCost1.class);
		startActivity(intent);

	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub
		if(msgId==10)
		{//DPRZCostDownPlanIdProcessor.ProcessData中调用，查询染整计划号成功
			onLoadFactoryName();
		}
	}

}
