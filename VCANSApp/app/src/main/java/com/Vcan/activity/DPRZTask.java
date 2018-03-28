package com.Vcan.activity;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPRZTaskDownFactoryProcessor;
import com.vcans.Processor.DPRZTaskDownWorkProcessor;
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
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * 任务简报   有2个界面类 分别  DPRZTask  DPRZTask1
 * @author vcans
 *
 */
public class DPRZTask extends BaseActivity {
	// public static DPRZTask dprzTask = null;
	EditText txtRZPlan;
	EditText txtRZFactoryId;
	EditText txtRZFactoryName,txtby1Name,txtby2Name,txtby3Name,txtby4Name;
	private int scanFlag;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_rztask);
		// dprzTask=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"onScanPlanId");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode2,"onScanFactory");
		this.<EditText>RegOnClickEvent(R.id.txtRZFactoryName,"onLoadFactoryName");

		txtRZPlan=(EditText)this.findViewById(R.id.txtRZPlanId);
		txtRZFactoryId=(EditText)findViewById(R.id.txtRZFactoryId);
		txtRZFactoryName=(EditText)findViewById(R.id.txtRZFactoryName);


		txtby1Name=(EditText)findViewById(R.id.txtwenbenyiName);
		txtby2Name=(EditText)findViewById(R.id.txtwenbenerName);
		txtby3Name=(EditText)findViewById(R.id.txtwenbensanName);
		txtby4Name=(EditText)findViewById(R.id.txtwenbensiName);


		PlProcessor.SetParent(this);

		// DPRZTaskDownWorkProcessor  downProce=new DPRZTaskDownWorkProcessor();
		//this.getDataTrunsfer().SetProcessor(downProce);
		//ActivityHelper.showStatusDialog(this, "正在加载工序及工艺信息...");
		//downProce.SendInfo(null);
		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.tip = getString(R.string.btn_load)+"...";
		sendParam.processor = new DPRZTaskDownWorkProcessor();
		getDataTrunsfer().request(sendParam);


		txtRZFactoryName.setOnFocusChangeListener(new OnFocusChangeListener() {

			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus) {

					onLoadFactoryName();
				}
			}

		});
	}

	final  TextWatcher mWatcher= new TextWatcher() {

		public void afterTextChanged(Editable s) {


			if(!s.toString().trim().equals(""))
			{
				mDpHandler.removeMessages(2);
				Message msgObj=new Message();
				msgObj.what=2;
				mDpHandler.sendMessageDelayed(msgObj,2000);
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
				ActivityHelper.hidesofeKeyboard(DPRZTask.this);
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
		sendParam.processor = new DPRZTaskDownFactoryProcessor();
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

		String stxtby1Name=txtby1Name.getText().toString().trim();
		String stxtby2Name=txtby2Name.getText().toString().trim();
		String stxtby3Name=txtby3Name.getText().toString().trim();
		String stxtby4Name=txtby4Name.getText().toString().trim();

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

		//工艺
		Spinner sp1=(Spinner)this.findViewById(R.id.dropCraftwork);
		String strGongyi=sp1.getSelectedItem().toString().trim();

		if(strGongyi.equals(""))
			return;

		String[] szGongyi=strGongyi.split("\\[");

		if(szGongyi.length<2)
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		ActivityHelper.gToupei.strGongyiName=szGongyi[0];
		ActivityHelper.gToupei.strGongyiId=szGongyi[1].substring(0,szGongyi[1].length()-1);

		if(strRZPlanId.equals("")||strRZFactoryId.equals("")||strRZFactoryName.equals("")||stxtby1Name.equals("")||stxtby2Name.equals("")||stxtby3Name.equals("")||stxtby4Name.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		ActivityHelper.gToupei.strRZPlanId=strRZPlanId;  //>染整计划号
		ActivityHelper.gToupei.strRZFactoryId=strRZFactoryId; //染整厂编号
		ActivityHelper.gToupei.strRZFactoryName=strRZFactoryName;// >染整厂名称
		ActivityHelper.gToupei.strtxtby1Name=stxtby1Name;// >1
		ActivityHelper.gToupei.strtxtby2Name=stxtby2Name;// >2
		ActivityHelper.gToupei.strtxtby3Name=stxtby3Name;// >3
		ActivityHelper.gToupei.strtxtby4Name=stxtby4Name;// >4

		Intent intent=new Intent(this,DPRZTask1.class);
		startActivity(intent);

	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
