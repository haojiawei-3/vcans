package com.Vcan.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.YPExpBarcodeProcessor;
import com.vcans.Processor.YPExpositionUploadProcessor;
import com.vcans.model.SendParam;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TableLayout.LayoutParams;

public class YPExposition1 extends BaseActivity {
	//public static YPExposition1 exposition1 = null;
	YPExpositionUploadProcessor mUploadProcessor=null;
	ListView mListView;
	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	TextView tvPage;
	EditText txtBarcode;

	HashMap<EditText,String> mapTxt=new HashMap<EditText,String> ();
	EditText txtNum;
	EditText txtPrice;
	String mStrOriginPrice="";
	private LinearLayout layPrice;
	private LinearLayout layNum;
	private Bundle mapParms;
	private boolean bBarcodeValid;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yp_exposition1);
		// exposition1=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.btnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.imgBtnSave,"onSave");
		this.<TextView>RegOnClickEvent(R.id.tvClear,"onClear");
		this.<Button>RegOnClickEvent(R.id.BtnDelete,"onDelete");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"onOpenScanBarcode");
		this.<TextView>RegOnClickEvent(R.id.tvYpBarCode,"onClearText");

		PlProcessor.SetParent(this);

		Button btnOk= (Button) findViewById(R.id.btnOk);
		btnOk.setText(getString(R.string.btn_upload));

		ImageButton imgbtnOk= (ImageButton) findViewById(R.id.imgBtnOk);
		imgbtnOk.setImageResource(R.drawable.upload);

		txtBarcode = (EditText) findViewById(R.id.txtYPBarcode);
		txtPrice = (EditText) findViewById(R.id.txtPrice);
		txtNum = (EditText) findViewById(R.id.txtNum);
		tvPage = (TextView) findViewById(R.id.tvPage);
		mListView=(ListView)this.findViewById(R.id.lvProdct);
		layPrice=(LinearLayout)this.findViewById(R.id.layPrice);
		layNum=(LinearLayout)this.findViewById(R.id.layNum);

		mUploadProcessor=new YPExpositionUploadProcessor();
		mUploadProcessor.DisplayTouPeiInfo();

		mapParms=this.getIntent().getExtras();

		if(mapParms!=null&&mapParms.size()>0)
		{

			if(!mapParms.get("isInputPrice").equals("1"))
				layPrice.setVisibility(View.GONE);
			// else
			txtBarcode.addTextChangedListener(onTextChange);

			txtBarcode.setOnFocusChangeListener(onFocusChangeListener);


			if(!mapParms.get("isInputNum").equals("1"))
			{
				layNum.setVisibility(View.GONE);
			}

			if(mapParms.get("isAutoScan").equals("1"))
			{
				onOpenScanBarcode();
			}
		}
	}



	@Override
	protected void onResume() {



		super.onResume();

	}



	@Override
	public void finish() {
		super.finish();
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
				strRst=ActivityHelper.resolveBarcode(strRst);
				txtBarcode.setText(strRst);

				if(layPrice.getVisibility()==View.GONE&&
						layNum.getVisibility()==View.GONE)
				{
					onSave();
				}
				else
				{
					if(BaseActivity.bConnected)
						onGetPrice();
				}
			}
		}
		else
		{}
	}

	final OnFocusChangeListener onFocusChangeListener=new OnFocusChangeListener()
	{

		public void onFocusChange(View v, boolean hasFocus) {

			if (!hasFocus) {

				if(BaseActivity.bConnected)
					onGetPrice();
			}
		}

	};

	final TextWatcher onTextChange = new TextWatcher() {

		public void beforeTextChanged(CharSequence s, int start, int count,
									  int after) {
			// TODO Auto-generated method stub

		}

		public void onTextChanged(CharSequence s, int start, int before,
								  int count) {
			// TODO Auto-generated method stub

		}

		public void afterTextChanged(Editable s) {
			bBarcodeValid=false;
			txtPrice.setText("");
		}

	};

	public void onGoodsItemClick(int index)
	{
		//获得选中项的HashMap对象
		String[] szStr=tvPage.getText().toString().split("/");
		tvPage.setText("("+(index+1)+"/"+szStr[1]);
		HashMap<String,Object> mapToupei=(HashMap<String,Object>)mListView.getItemAtPosition(index);
		mstrDataId=(String)mapToupei.get("TPId");
	}

	public void onClearText()
	{
		clearText(R.id.txtYPBarcode);
	}


	public void onGetPrice()
	{
		String strBarcode=txtBarcode.getText().toString().trim();

		if(strBarcode.equals(""))
		{
			return;
		}

		bBarcodeValid=false;
		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.tip = "获取价格中...";
		sendParam.processor =new YPExpBarcodeProcessor();
		sendParam.szData =new String[]{strBarcode,ActivityHelper.gToupei.strCusName};
		getDataTrunsfer().request(sendParam);
	}

	private  boolean getUserPower(int index)
	{
		if (gUser == null) {
			ActivityHelper.ToastShow(this, getString(R.string.noLoginWait));
			return false;
		}

		if(!gUser.getPower(VCANSAppActivity.mYpStart+index))  //mYpStart为模块起始号
		{
			ActivityHelper.ToastShow(this, getString(R.string.noPower));
			return false;
		}

		return true;
	}

	public void onUpload()
	{//上传
		if(!getUserPower(1)) return; //1为展会询样模块索引号 索引了解见DPMenuProcessor

		if(mListView.getCount()>0)
		{
			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.processor =mUploadProcessor;
			sendParam.bSendEndNotify=true;
			getDataTrunsfer().beginUploadFile(sendParam);
		}
		else
		{
			ActivityHelper.showDialog(this,"错误","无数据");
		}
	}

	private void exeSave()
	{
		if(txtBarcode.getText().toString().trim().equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return;
		}


		if(layPrice.getVisibility()==View.VISIBLE)
		{
			if(txtPrice.getText().toString().trim().equals(""))
			{
				ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
				return;
			}
		}

		if(BaseActivity.bConnected)
		{
			if(!bBarcodeValid)
			{
				ActivityHelper.showDialog(this,"错误",getString(R.string.barcdoeInvalid));
				return;
			}
		}


		if(layNum.getVisibility()==View.VISIBLE)
		{
			if(txtNum.getText().toString().trim().equals(""))
			{
				ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
				return;
			}
		}

		String strPrice=txtPrice.getText().toString().trim();
		String strNum=txtNum.getText().toString().trim();

		ActivityHelper.gToupei.strPrice=strPrice;
		ActivityHelper.gToupei.nNum=strNum;

		PlProcessor.SetParent(this);
		ActivityHelper.hidesofeKeyboard(this);

		mUploadProcessor.SaveToupeiInfo();
	}

	public void onSave()
	{
		txtBarcode.requestFocus();
		if(layNum.getVisibility()==View.GONE&&
				layPrice.getVisibility()==View.GONE)
		{
			if(BaseActivity.bConnected)
				this.onGetPrice();
			else
				exeSave();
		}
		else
			exeSave();
	}


	public void onClear()
	{
		if(mListView.getCount()<1)
		{
			return;
		}

		new AlertDialog.Builder(this).setTitle(getString(R.string.askClear))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						mUploadProcessor.ClearToupeiInfo();

					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
	}

	public void onDelete()
	{
		if(mListView.getCount()<1)
		{
			return ;
		}

		if(mstrDataId.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.noSelected));
			return;
		}

		new AlertDialog.Builder(this).setTitle(getString(R.string.askDelete))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						if(!mstrDataId.equals(""))
						{
							mUploadProcessor.DeleteToupeiInfo(mstrDataId);
							mstrDataId="";
						}
					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
	}

	@Override
	public void processMessage(int msgId, String msg) {

		if(msgId==0)
		{//YPExpositionUploadProcessor DisplayTouPeiInfo方法中调用
			String[] szMethods=null;

			if(mListView.getCount()>0)
			{
				szMethods=new String[mListView.getCount()];


				for(int i=0;i<mListView.getCount();++i)
				{
					szMethods[i]="onGoodsItemClick";
				}

				this.RegItemOnClickEvent(R.id.lvProdct, szMethods);
			}
		}
		else if(msgId==1)
		{
			//通过发送价格请求得到的
			if(layPrice.getVisibility()==View.VISIBLE)
			{
				mStrOriginPrice=msg;
				txtPrice.setText(msg);
			}

			bBarcodeValid=true;

			if(layNum.getVisibility()==View.GONE&&
					layPrice.getVisibility()==View.GONE)
			{//当数量和价格都不用输入时
				exeSave();
			}
			else if(layNum.getVisibility()==View.VISIBLE)
			{

				txtNum.setFocusableInTouchMode(true);
				txtNum.requestFocusFromTouch();
				ActivityHelper.showsofeKeyboard(this);
			}
		}
		else if(msgId==2)
		{//YPExpositionUploadProcessor saveTouPeiInfo方法中调用

			txtBarcode.setText("");
			txtPrice.setText("");
			txtNum.setText("");
			ActivityHelper.savedImagePath.add(ActivityHelper.gToupei.strFilePath);
			if(mapParms!=null&&mapParms.size()>0)
			{

				if(mapParms.get("isAutoScan").equals("1"))
				{
					onOpenScanBarcode();
				}
			}
		}else if(msgId==1000){
			txtBarcode.requestFocus();
		}
	}

}
