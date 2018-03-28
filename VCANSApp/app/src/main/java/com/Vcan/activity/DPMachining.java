package com.Vcan.activity;

import java.util.Arrays;
import java.util.HashMap;

import com.Vcan.activity.R;
import com.example.qr_codescan.MipcaActivityCapture;

import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPMachiDownWorkProcessor;
import com.vcans.Processor.DPMachiFactoryProcessor;
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
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * 加工送仓库   有3个界面类 分别  DPMachining DPTouPei1（共用） DPMachining2
 * @author vcans
 *
 */
public class DPMachining extends BaseActivity {
	public static DPMachining dpMachining = null;
	private DPMachiFactoryProcessor mDownFactoryProce=null;
	DPMachining mThis;

	EditText txtRZPlan;
	Spinner dropOrderType;
	Spinner dropMachiFactory;
	EditText txtAimFactory;
	private int nFirst=1;
	private int mnScanFlag=0;
	private LinearLayout layProType;
	private SetDialog setDialog;
	private String mstrRZPlanId="";
	private String mstrOrderType="";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_machining);
		dpMachining=this;
		ActivityHelper.lstGongXu.clear();
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.btnSave, "onSet");
		this.<Button>RegOnClickEvent(R.id.imgBtnSave, "onSet");
		this.<Button>RegOnClickEvent(R.id.btnLoadFactory,"onLoadFactory");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"onOpenScanRZPlan");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode2,"onOpenScanAimFactoryId");

		ImageButton imgBtnSet = (ImageButton) this.findViewById(R.id.imgBtnSave);
		imgBtnSet.setImageResource(R.drawable.exp_set);

		Button btnSet = (Button) this.findViewById(R.id.btnSave);
		btnSet.setText(getString(R.string.set));

		txtRZPlan=(EditText)this.findViewById(R.id.txtRZPlanId);
		txtRZPlan.setFocusable(true);

		dropMachiFactory=(Spinner)findViewById(R.id.dropRZFactoryId);
		dropOrderType=(Spinner)findViewById(R.id.dropOrderType);
		txtAimFactory=(EditText)findViewById(R.id.txtAimFactoryId);
		txtAimFactory.addTextChangedListener(mWatcher);

		dropMachiFactory.setOnItemSelectedListener(dropClickListener);
		dropMachiFactory.setOnTouchListener(touchListener);

		layProType=(LinearLayout)findViewById(R.id.layProType);

		//设置
		String [] mParams=new String[]{"machProType"};
		HashMap<String,String> mapParams=ActivityHelper.getParams(this, mParams);

		if(mapParams.size()>0)
		{
			if(!mapParams.get("machProType").equals("1"))
				layProType.setVisibility(View.GONE);
			else
				layProType.setVisibility(View.VISIBLE);
		}

		setDialog=new SetDialog(this,R.layout.dp_machiningset_item,new int[]{R.id.chkProType},mParams);


		mDownFactoryProce=new DPMachiFactoryProcessor();
		InitDropColrAndUnitList();
		mDownFactoryProce.InitDropMachiFactory();

		mThis=this;

		txtRZPlan.setOnFocusChangeListener(new OnFocusChangeListener() {

			public void onFocusChange(View v, boolean hasFocus) {

				if (!hasFocus) {

					onLoadFactory();
				}
			}

		});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		dropOrderType.setEnabled(true);
		txtRZPlan.setEnabled(true);
	}

	public void onSet() {

		this.setDialog.show();
	}

	public void onOpenScanRZPlan()
	{
		mnScanFlag=0;
		onOpenScanBarcode();
	}


	public void onOpenScanAimFactoryId()
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
					onLoadFactory();
				}
				else
					txtAimFactory.setText(strRst);
			}
		}
		else
		{}
	}

	public void InitDropColrAndUnitList()
	{

		String[] szData={getString(R.string.fahuo),getString(R.string.shouhuo)};

		ActivityHelper.InitDrop(this, R.id.dropOrderType, Arrays.asList(szData),true);

	}

	public final OnItemSelectedListener dropClickListener=new OnItemSelectedListener(){
		public void onItemSelected(AdapterView<?> arg0, View arg1,
								   int arg2, long arg3) {

			if(arg1==null)
				return;

			TextView tv = (TextView)arg1;
			tv.setTextColor(Color.BLACK);    //设置颜色
			tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL);   //设置居中

			if(tv.getText().toString().trim().indexOf("无数据")>-1)
				return ;

			Spinner   dropOrderType=(Spinner)findViewById(R.id.dropOrderType);

			String factoryId= arg0.getSelectedItem().toString();

			if(factoryId.equals("")) return;

			String[] szFactoryId=factoryId.split("\\|");

			if(dropOrderType.getSelectedItem().toString().equals(getString(R.string.shouhuo)))
				txtAimFactory.setText(szFactoryId[1]);

			onLoadWorkProcess();

		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}
	};

	public void onLoadWorkProcess()
	{
		String[] szFactory=getDropText(dropMachiFactory).split("\\|");
		String strOrderyType=getDropText(dropOrderType);

		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.szData=new String[]{szFactory[1],strOrderyType,txtRZPlan.getText().toString().trim()};
		sendParam.processor = new DPMachiDownWorkProcessor();
		getDataTrunsfer().request(sendParam);
	}

	public final OnTouchListener touchListener=new OnTouchListener(){

		public boolean onTouch(View arg0, MotionEvent event)
		{
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				return onLoadFactory();
			}else if (event.getAction() == MotionEvent.ACTION_MOVE) {
				return onLoadFactory();
			}else if (event.getAction() == MotionEvent.ACTION_UP) {
				return onLoadFactory();
			}

			return true;
		}
	};

	public boolean onLoadFactory()
	{
		EditText txtRZPlanTemp=txtRZPlan;

		String strRZPlanId=txtRZPlanTemp.getText().toString().trim();
		String strOrderType=getDropText(dropOrderType);

		if(strRZPlanId.equals(""))
		{
			ActivityHelper.ToastShow(this, getString(R.string.isNUll));

			return true;
		}


		if((!mstrRZPlanId.equals(strRZPlanId)||!mstrOrderType.equals(strOrderType)))
		{
			dropOrderType.setEnabled(false);
			txtRZPlanTemp.setEnabled(false);
			dropMachiFactory.setClickable(true);
			txtAimFactory.setEnabled(true);

			mstrRZPlanId=strRZPlanId;
			mstrOrderType=strOrderType;

			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.processor = mDownFactoryProce;
			sendParam.szData =new String[]{strRZPlanId,strOrderType};
			getDataTrunsfer().request(sendParam);

			return true;
		}else{
			return false;
		}
	}



	final  TextWatcher mWatcher= new TextWatcher() {

		public void afterTextChanged(Editable s) {

			Button btn=(Button) findViewById(R.id.btnClearUser);


			if(!s.toString().trim().equals(""))
			{
				mDpHandler.removeMessages(2);
				Message msgObj=new Message();
				msgObj.what=2;
				mDpHandler.sendMessageDelayed(msgObj,2500);
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
				ActivityHelper.showDialog(mThis, "", getString(R.string.RZPlanId)+""+getString(R.string.isNUll));
			}
			else if(msg.what==2)
			{
				//ActivityHelper.hidesofeKeyboard(mThis);
			}

		}
	};

	public void onNext()
	{
		String strRZPlanId=txtRZPlan.getText().toString().trim();
		String strOrderType=dropOrderType.getSelectedItem().toString();
		String strMachiFactory=this.dropMachiFactory.getSelectedItem().toString();
		String strAimFactoryId=this.txtAimFactory.getText().toString();
		CheckBox chkColrAllOut=(CheckBox)findViewById(R.id.chkColorAllOut);
		Spinner spProType=(Spinner)findViewById(R.id.dropProType);
		String strProType=" ";
		if(layProType.getVisibility()==View.VISIBLE)
			strProType=spProType.getSelectedItem().toString().trim();

		if(strRZPlanId.equals("")||strAimFactoryId.equals("")||strProType.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		ActivityHelper.gToupei.strRZPlanId=strRZPlanId;
		String[] szMachiFactory=strMachiFactory.split("\\|");

		if(szMachiFactory.length>1)
			ActivityHelper.gToupei.strRZFactoryId=szMachiFactory[1];

		ActivityHelper.gToupei.strRZFactoryName=szMachiFactory[0];
		ActivityHelper.gToupei.strAimFactoryId=strAimFactoryId;
		ActivityHelper.gToupei.strOrderType=strOrderType;
		ActivityHelper.gToupei.strColorAllOut=chkColrAllOut.isChecked()?"Y":"N";
		ActivityHelper.gToupei.strProType="";
		ActivityHelper.gToupei.strProTypeId="";
		if(!strProType.trim().equals(""))
		{
			String[] szGongxu=strProType.split("\\[");
			ActivityHelper.gToupei.strProType=szGongxu[0];
			ActivityHelper.gToupei.strProTypeId=szGongxu[1].substring(0,szGongxu[1].length()-1);
		}

		Intent intent=new Intent(this,DPTouPei1.class);
		intent.putExtra("actFlag",DPTouPei1.DP_MACHINING1);
		startActivity(intent);

	}

	@Override
	public void processMessage(int msgId, String msg) {

	}

}
