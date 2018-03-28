package com.Vcan.activity;

import java.util.HashMap;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPTPDownCpnyProcessor;
import com.vcans.Processor.DPTPDownWorkProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
/**
 * 生产投坏   有3个界面类 分别  DPTouPei    DPTouPei1   DPTouPei2
 * @author vcans
 *
 */
public class DPTouPei extends BaseActivity {
	//public static DPTouPei dpTouPei = null;
	private DPTPDownCpnyProcessor mDownCompayProce=null;
	private EditText txtRZPlan;
	private EditText txtRZFactoryId;
	private int mnScanFlag=0;
	private Dialog mDialog ;
	private CheckBox chkProColor;
	private HashMap<String, String> mapParms;
	private LinearLayout layProType;
	private CheckBox chkProType;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_toupei);
		// dpTouPei=this;
		ActivityHelper.lstGongXu.clear();
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		this.<Button> RegOnClickEvent(R.id.btnSave, "onSet");
		this.<Button> RegOnClickEvent(R.id.imgBtnSave, "onSet");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"onOpenScanRZPlan");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode2,"onOpenScanFactoryId");

		txtRZPlan=(EditText)this.findViewById(R.id.txtRZPlanId);
		txtRZPlan.setFocusable(true);
		txtRZFactoryId=(EditText)findViewById(R.id.txtRZFactoryId);
		txtRZFactoryId.addTextChangedListener(mWatcher);
		layProType=(LinearLayout)findViewById(R.id.layProType);

		ImageButton imgBtnSet = (ImageButton) this.findViewById(R.id.imgBtnSave);
		imgBtnSet.setImageResource(R.drawable.exp_set);

		Button btnSet = (Button) this.findViewById(R.id.btnSave);
		btnSet.setText(getString(R.string.set));

		String[] paramKeys = new String[] { "isInputProColor","isInputProType"};
		mapParms = ActivityHelper.getParams(this, paramKeys);

		if(mapParms.get("isInputProType").equals("1")){

			layProType.setVisibility(View.VISIBLE);
		}
		else{

			layProType.setVisibility(View.GONE);
		}


		txtRZPlan.setOnFocusChangeListener(new OnFocusChangeListener() {

			public void onFocusChange(View v, boolean hasFocus) {

				if (!hasFocus) {


					EditText txtRZPlanTemp=(EditText)findViewById(R.id.txtRZPlanId);
					String strRZPlanTemp=txtRZPlanTemp.getText().toString().trim();

					if(!strRZPlanTemp.equals(""))
					{
						//ActivityHelper.showStatusDialog(DPTouPei.this, "等待服务器响应...");
						// mDownCompayProce.SendInfo(new String[]{strRZPlanTemp});
						sendCompanyRequest(strRZPlanTemp);

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

		//基类中已有该语句  子类中的这条语句可以移除，未移除的地方为旧代码没影响，不做做移除
		//PlProcessor.SetParent(this);
		mDownCompayProce=new DPTPDownCpnyProcessor();
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		EditText txtRZPlanTemp=(EditText)findViewById(R.id.txtRZPlanId);
		EditText txtCompayOrderId=(EditText)findViewById(R.id.txtCompanyOrder);

		txtRZPlanTemp.setEnabled(true);
		txtCompayOrderId.setEnabled(true);
		txtCompayOrderId.setBackgroundColor(Color.WHITE);
	}



	public void onSet() {

		this.showInput();
	}

	private void sendCompanyRequest(String strRZPlanTemp)
	{

		SendParam sendParam = new SendParam();
		sendParam.parent = DPTouPei.this;
		sendParam.processor = mDownCompayProce;
		sendParam.szData = new String[] { strRZPlanTemp };
		getDataTrunsfer().request(sendParam);
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


	public void onOpenScanRZPlan()
	{
		mnScanFlag=0;
		onOpenScanBarcode();
	}


	public void onOpenScanFactoryId()
	{
		mnScanFlag=1;
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

				if(mnScanFlag==0)
				{
					txtRZPlan.setText(strRst);
					sendCompanyRequest(strRst);
				}
				else
				{
					txtRZFactoryId.setText(strRst);
				}
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
			else if(msg.what==2)
			{
				//ActivityHelper.hidesofeKeyboard(DPTouPei.this);
			}
		}
	};


	final OnClickListener onOKListener = new OnClickListener() {

		public void onClick(View arg0) {

			if (arg0.getId() == R.id.btnOk) {
				HashMap<String, String> tMapParms = new HashMap<String, String>();
				tMapParms.put("isInputProColor", chkProColor.isChecked() ? "1": "0");
				tMapParms.put("isInputProType", chkProType.isChecked() ? "1": "0");

				if(!chkProType.isChecked())
					layProType.setVisibility(View.GONE);
				else
					layProType.setVisibility(View.VISIBLE);

				ActivityHelper.saveParams(DPTouPei.this, tMapParms);
				DPTouPei.this.mapParms = tMapParms;

				ActivityHelper.ToastShow(DPTouPei.this, getString(R.string.saveSuccess));
				new Handler().postDelayed(new Runnable() {

					public void run() {

						mDialog.dismiss();
					}
				}, 1000);

			} else if (arg0.getId() == R.id.btnClose) {
				mDialog.dismiss();
			}
		}

	};


	public void showInput() {
		mDialog = new Dialog(this);
		mDialog.setTitle(getString(R.string.set));
		mDialog.setContentView(R.layout.dp_toupeiset_item);

		Button btnOk = (Button) mDialog.findViewById(R.id.btnOk);
		btnOk.setOnClickListener(onOKListener);

		Button btnClose = (Button) mDialog.findViewById(R.id.btnClose);
		btnClose.setOnClickListener(onOKListener);

		this.chkProColor = (CheckBox) mDialog.findViewById(R.id.chkProColor);
		chkProType= (CheckBox) mDialog.findViewById(R.id.chkProType);

		if (mapParms.size() > 0) {
			if (mapParms.get("isInputProColor").equals("1"))
				chkProColor.setChecked(true);
			else
				chkProColor.setChecked(false);


			if (mapParms.get("isInputProType").equals("1"))
				chkProType.setChecked(true);
			else
				chkProType.setChecked(false);
		}

		mDialog.show();
	}

	public void onNext()
	{
		EditText txtRZPlanId=(EditText)findViewById(R.id.txtRZPlanId);
		EditText txtRZFactoryId=(EditText)findViewById(R.id.txtRZFactoryId);
		EditText txtCompanyOrderId=(EditText)findViewById(R.id.txtCompanyOrder);
		Spinner spProType=(Spinner)this.findViewById(R.id.dropProType);

		String strProType=" ";
		String strRZPlanId=txtRZPlanId.getText().toString().trim();
		String strRZFactoryId=txtRZFactoryId.getText().toString().trim();
		String strCompanyOrderId=txtCompanyOrderId.getText().toString().trim();

		if(mapParms.get("isInputProType").equals("1"))
		{
			strProType=spProType.getSelectedItem().toString().trim();
		}

		if(strRZPlanId.equals("")||strRZFactoryId.equals("")
				||strCompanyOrderId.equals("")||strProType.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		ActivityHelper.gToupei.strRZPlanId=strRZPlanId;
		ActivityHelper.gToupei.strRZFactoryId=strRZFactoryId;

		ActivityHelper.gToupei.strProType="";
		ActivityHelper.gToupei.strProTypeId="";
		if(!strProType.trim().equals(""))
		{
			String[] szGongxu=strProType.split("\\[");
			ActivityHelper.gToupei.strProType=szGongxu[0];
			ActivityHelper.gToupei.strProTypeId=szGongxu[1].substring(0,szGongxu[1].length()-1);
		}

		Intent intent=new Intent(this,DPTouPei1.class);
		intent.putExtra("actFlag",DPTouPei1.DP_TOUPEI1);
		startActivity(intent);

	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

		if(msgId==DPTPDownCpnyProcessor.DOWN_WORK)
		{//DPTPDownCpnyProcessor调用
			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.processor = new DPTPDownWorkProcessor();
			getDataTrunsfer().request(sendParam);
		}
	}

}
