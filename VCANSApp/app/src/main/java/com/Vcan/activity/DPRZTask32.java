package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPRZTask32UploadProcessor;
import com.vcans.Processor.DPRZTaskDownWorkBY1Processor;
import com.vcans.Processor.DPRZTaskUploadProcessor;
import com.vcans.model.MenuK;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ListViewForScrollView;
import com.vcans.tool.PlProcessor;
import com.vcans.tool.ZDYzuhe;
import com.vcans.tool.ZDYzuhe.GifViewOnClickListener;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
/**
 * 新备用模块   有3个界面类 分别  DPRZTask3 DPRZTask31 DPRZTask32
 * @author vcans
 *
 */
public class DPRZTask32 extends BaseActivity {
	ZDYzuhe ZDYzuhe19,ZDYzuhe20,ZDYzuhe21,ZDYzuhe22,ZDYzuhe23,ZDYzuhe24,ZDYzuhe25,ZDYzuhe26,ZDYzuhe27;
	String TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,instant;
	TextView tvPage;
	public static DPRZTask32 DPRZTask32 = null;
	private DPRZTask32UploadProcessor DPRZTask32Upload=null;
	ScrollView sv;
	private List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	private ListViewForScrollView mListView;
	int scanFlag;
	private int mLastClickId=-1;
	private long mLastClickTime=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dprztask32);
		this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
		DPRZTask32=this;
		ZDYzuhe19=(ZDYzuhe)findViewById(R.id.ZDYzuhe19);
		ZDYzuhe20=(ZDYzuhe)findViewById(R.id.ZDYzuhe20);
		ZDYzuhe21=(ZDYzuhe)findViewById(R.id.ZDYzuhe21);
		ZDYzuhe22=(ZDYzuhe)findViewById(R.id.ZDYzuhe22);
		ZDYzuhe23=(ZDYzuhe)findViewById(R.id.ZDYzuhe23);
		ZDYzuhe24=(ZDYzuhe)findViewById(R.id.ZDYzuhe24);
		ZDYzuhe25=(ZDYzuhe)findViewById(R.id.ZDYzuhe25);
		ZDYzuhe26=(ZDYzuhe)findViewById(R.id.ZDYzuhe26);
		ZDYzuhe27=(ZDYzuhe)findViewById(R.id.ZDYzuhe27);
		Intent intent = this.getIntent();
		instant= (String)intent.getSerializableExtra("instant");
		this.<Button>RegOnClickEvent(R.id.tvClear,"onClear");
		this.<Button>RegOnClickEvent(R.id.btnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.imgBtnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.BtnDelete,"onDelete");
		sv = (ScrollView) findViewById(R.id.sv);
		sv.smoothScrollTo(0, 0);

		Button btnNext=(Button)this.findViewById(R.id.btnOk);
		btnNext.setText(getString(R.string.btn_upload));

		DPRZTask32Upload=new DPRZTask32UploadProcessor(DPRZTask3.gBakFlag);
		PlProcessor.SetParent(this);

		DPRZTask32Upload.DisplayTouPeiInfo();

		ImageButton imgBtnNext=(ImageButton)this.findViewById(R.id.imgBtnOk);
		imgBtnNext.setImageResource(R.drawable.upload);
		TZDYzuhe1=ActivityHelper.dprzTask3.tvBYName1v;
		TZDYzuhe2=ActivityHelper.dprzTask3.tvBYName2v;
		TZDYzuhe3=ActivityHelper.dprzTask3.tvBYName3v;
		TZDYzuhe4=ActivityHelper.dprzTask3.tvBYName4v;
		TZDYzuhe5=ActivityHelper.dprzTask3.tvBYName5v;
		TZDYzuhe6=ActivityHelper.dprzTask3.tvBYName6v;
		TZDYzuhe7=ActivityHelper.dprzTask3.tvBYName7v;
		TZDYzuhe8=ActivityHelper.dprzTask3.tvBYName8v;
		TZDYzuhe9=ActivityHelper.dprzTask3.tvBYName9v;
		TZDYzuhe10=ActivityHelper.dprzTask3.tvBYName10v;
		TZDYzuhe11=ActivityHelper.dprzTask3.tvBYName11v;
		TZDYzuhe12=ActivityHelper.dprzTask3.tvBYName12v;
		TZDYzuhe13=ActivityHelper.dprzTask3.tvBYName13v;
		TZDYzuhe14=ActivityHelper.dprzTask3.tvBYName14v;
		TZDYzuhe15=ActivityHelper.dprzTask3.tvBYName15v;
		TZDYzuhe16=ActivityHelper.dprzTask3.tvBYName16v;
		TZDYzuhe17=ActivityHelper.dprzTask3.tvBYName17v;
		TZDYzuhe18=ActivityHelper.dprzTask3.tvBYName18v;

		ZDYzuhe19.SetMenu(ActivityHelper.MenuList.get(18));
		ZDYzuhe20.SetMenu(ActivityHelper.MenuList.get(19));
		ZDYzuhe21.SetMenu(ActivityHelper.MenuList.get(20));
		ZDYzuhe22.SetMenu(ActivityHelper.MenuList.get(21));
		ZDYzuhe23.SetMenu(ActivityHelper.MenuList.get(22));
		ZDYzuhe24.SetMenu(ActivityHelper.MenuList.get(23));
		ZDYzuhe25.SetMenu(ActivityHelper.MenuList.get(24));
		ZDYzuhe26.SetMenu(ActivityHelper.MenuList.get(25));
		ZDYzuhe27.SetMenu(ActivityHelper.MenuList.get(26));
		mListView=(ListViewForScrollView)this.findViewById(R.id.lvProdct);
		mListView.setOnItemClickListener(listClickListener);
		tvPage = (TextView) findViewById(R.id.tvPage);

		if (instant!=null) {
			new Handler().postDelayed(new Runnable() {
				public void run() {
					instant(instant);
				}
			}, 500);

		}
		ZDYzuhe19.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=1;
				onOpenScanBarcode();

			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY19();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});

		ZDYzuhe20.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=2;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY20();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});
		ZDYzuhe21.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=3;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY21();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});
		ZDYzuhe22.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=4;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY22();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});
		ZDYzuhe23.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=5;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY23();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}

		});
		ZDYzuhe24.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=6;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY24();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});
		ZDYzuhe25.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=7;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY25();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});
		ZDYzuhe26.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=8;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY26();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});
		ZDYzuhe27.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=9;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY27();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});


	}


	public final OnItemClickListener listClickListener=new OnItemClickListener(){

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
								long arg3) {

			//获得选中项的HashMap对象
			HashMap<String,Object> mapToupei=(HashMap<String,Object>)mListView.getItemAtPosition(arg2);
			mstrDataId=(String)mapToupei.get("TPId");
			String[] szStr=tvPage.getText().toString().split("/");
			tvPage.setText("("+(arg2+1)+"/"+szStr[1]);


			// 如果是双击,1秒内连续点击判断为双击
			if(arg2==mLastClickId
					&& (Math.abs(mLastClickTime-System.currentTimeMillis()) < 1000))
			{
				mLastClickId = -1;
				mLastClickTime = 0;

				mDataList.clear();
				mDataList.add(mapToupei);


				DPRZTask32Upload.displayDetail(mDataList);

			}
			else
			{
				mLastClickId =arg2;
				mLastClickTime = System.currentTimeMillis();
			}

		}
	};

	public void onSave()
	{
		PlProcessor.SetParent(this);
		ActivityHelper.hidesofeKeyboard(this);
		DPRZTask32Upload.SaveToupeiInfo();
	}


	public void ZDY1()
	{
		if (!TZDYzuhe1.equals("")) {


			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe1};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(1,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用一不能为空");
		}


	}

	public void ZDY2()
	{

		if (!TZDYzuhe2.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe2,TZDYzuhe1};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(2,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用二不能为空");
		}


	}

	public void ZDY3()
	{

		if (!TZDYzuhe3.equals("")) {

			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe3,TZDYzuhe1,TZDYzuhe2};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(3,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用三不能为空");
		}

	}

	public void ZDY4()
	{

		if (!TZDYzuhe4.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe4,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(4,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用四不能为空");
		}

	}
	public void ZDY5()
	{

		if (!TZDYzuhe5.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe5,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(5,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用五不能为空");
		}

	}
	public void ZDY6()
	{

		if (!TZDYzuhe6.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe6,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(6,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用六不能为空");
		}

	}
	public void ZDY7()
	{

		if (!TZDYzuhe7.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe7,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(7,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用七不能为空");
		}

	}public void ZDY8()
	{

		if (!TZDYzuhe8.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe8,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(8,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用八不能为空");
		}

	}

	public void ZDY9()
	{

		if (!TZDYzuhe9.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe9,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(9,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用九不能为空");
		}

	}
	public void ZDY10()
	{

		if (!TZDYzuhe10.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe10, TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(10,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用10不能为空");
		}

	}
	public void ZDY11()
	{

		if (!TZDYzuhe11.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe11,  TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					TZDYzuhe10};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(11,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用11不能为空");
		}

	}
	public void ZDY12()
	{

		if (!TZDYzuhe12.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe12,  TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					TZDYzuhe10,TZDYzuhe11};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(12,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用12不能为空");
		}

	}
	public void ZDY13()
	{

		if (!TZDYzuhe13.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe13,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					TZDYzuhe10,TZDYzuhe11,TZDYzuhe12};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(13,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用13不能为空");
		}

	}
	public void ZDY14()
	{

		if (!TZDYzuhe14.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe14,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(14,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用14不能为空");
		}

	}
	public void ZDY15()
	{

		if (!TZDYzuhe15.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe15,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(15,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用15不能为空");
		}

	}
	public void ZDY16()
	{

		if (!TZDYzuhe16.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe16,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(16,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用16不能为空");
		}

	}
	public void ZDY17()
	{

		if (!TZDYzuhe17.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe17,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(17,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用17不能为空");
		}

	}
	public void ZDY18()
	{

		if (!TZDYzuhe18.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe18,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(18,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,"备用18不能为空");
		}

	}

	public void ZDY19()
	{

		if (!ZDYzuhe19.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe19.GetText(), TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9, TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(19,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,ZDYzuhe19.getMenu().title+"不能为空");
		}

	}
	public void ZDY20()
	{

		if (!ZDYzuhe20.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe20.GetText(), TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9, TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,
					ZDYzuhe19.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(20,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,ZDYzuhe20.getMenu().title+"不能为空");
		}

	}
	public void ZDY21()
	{

		if (!ZDYzuhe21.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe21.GetText(),  TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9, TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,
					ZDYzuhe19.GetText(),ZDYzuhe20.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(21,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,ZDYzuhe21.getMenu().title+"不能为空");
		}

	}
	public void ZDY22()
	{

		if (!ZDYzuhe22.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe22.GetText(), TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9, TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,
					ZDYzuhe19.GetText(),ZDYzuhe20.GetText(),ZDYzuhe21.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(22,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,ZDYzuhe22.getMenu().title+"不能为空");
		}

	}
	public void ZDY23()
	{

		if (!ZDYzuhe23.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe23.GetText(), TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9, TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,
					ZDYzuhe19.GetText(),ZDYzuhe20.GetText(),ZDYzuhe21.GetText(),ZDYzuhe22.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(23,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,ZDYzuhe23.getMenu().title+"不能为空");
		}

	}
	public void ZDY24()
	{

		if (!ZDYzuhe24.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe24.GetText(), TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9, TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,
					ZDYzuhe19.GetText(),ZDYzuhe20.GetText(),ZDYzuhe21.GetText(),ZDYzuhe22.GetText(),ZDYzuhe23.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(24,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,ZDYzuhe24.getMenu().title+"不能为空");
		}

	}
	public void ZDY25()
	{

		if (!ZDYzuhe25.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe25.GetText(), TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9, TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,
					ZDYzuhe19.GetText(),ZDYzuhe20.GetText(),ZDYzuhe21.GetText(),ZDYzuhe22.GetText(),ZDYzuhe23.GetText(),ZDYzuhe24.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(25,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,ZDYzuhe25.getMenu().title+"不能为空");
		}

	}
	public void ZDY26()
	{

		if (!ZDYzuhe26.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe26.GetText(), TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9, TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,
					ZDYzuhe19.GetText(),ZDYzuhe20.GetText(),ZDYzuhe21.GetText(),ZDYzuhe22.GetText(),ZDYzuhe23.GetText(),ZDYzuhe24.GetText(),ZDYzuhe25.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(26,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,ZDYzuhe26.getMenu().title+"不能为空");
		}

	}
	public void ZDY27()
	{

		if (!ZDYzuhe27.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask32.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe27.GetText(), TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9, TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,
					ZDYzuhe19.GetText(),ZDYzuhe20.GetText(),ZDYzuhe21.GetText(),ZDYzuhe22.GetText(),ZDYzuhe23.GetText(),ZDYzuhe24.GetText(),ZDYzuhe25.GetText(),ZDYzuhe26.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(27,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask32.this,ZDYzuhe27.getMenu().title+"不能为空");
		}

	}




	public void onUpload()
	{//上传

		if(mListView.getCount()>0)
		{
			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.processor = DPRZTask32Upload;
			getDataTrunsfer().beginUploadText(sendParam);
		}
		else
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.noData));
		}

	}

	public void onDelete()
	{
		if(mListView.getCount()<1)
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.noData));
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
							DPRZTask32Upload.DeleteToupeiInfo(mstrDataId);
							DPRZTask32Upload.DisplayTouPeiInfo();
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



	public void onClear()
	{
		if(mListView.getCount()<1)
		{
			return ;
		}

		new AlertDialog.Builder(this).setTitle(getString(R.string.askClear))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						DPRZTask32Upload.ClearToupeiInfo();
						DPRZTask32Upload.DisplayTouPeiInfo();

					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
	}

	public void  instant(String s){
		if (s.equals("18")) {
			ZDY18();
		}else if (s.equals("17")) {
			ZDY17();
		}else if (s.equals("16")) {
			ZDY16();
		}else if (s.equals("15")) {
			ZDY15();
		}else if (s.equals("14")) {
			ZDY14();
		}else if (s.equals("13")) {
			ZDY13();
		}else if (s.equals("12")) {
			ZDY12();
		}else if (s.equals("11")) {
			ZDY11();
		}else if (s.equals("10")) {
			ZDY10();
		}else if (s.equals("9")) {
			ZDY9();
		}else if (s.equals("8")) {
			ZDY8();
		}else if (s.equals("7")) {
			ZDY7();
		}else if (s.equals("6")) {
			ZDY6();
		}else if (s.equals("5")) {
			ZDY5();
		}else if (s.equals("4")) {
			ZDY4();
		}else if (s.equals("3")) {
			ZDY3();
		}else if (s.equals("2")) {
			ZDY2();
		}else if (s.equals("1")) {
			ZDY1();
		}
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

				if(scanFlag==1){
					ZDYzuhe19.SetEditText(strRst);
					if (ZDYzuhe19.getMenu().instant.equals("Y")) {
						ZDY19();
					}

				}
				else if(scanFlag==2){
					ZDYzuhe20.SetEditText(strRst);
					if (ZDYzuhe20.getMenu().instant.equals("Y")) {
						ZDY20();
					}
				}
				else if(scanFlag==3){
					ZDYzuhe21.SetEditText(strRst);
					if (ZDYzuhe21.getMenu().instant.equals("Y")) {
						ZDY21();
					}
				}
				else if(scanFlag==4){
					ZDYzuhe22.SetEditText(strRst);
					if (ZDYzuhe22.getMenu().instant.equals("Y")) {
						ZDY22();
					}
				}
				else if(scanFlag==5){
					ZDYzuhe23.SetEditText(strRst);
					if (ZDYzuhe23.getMenu().instant.equals("Y")) {
						ZDY23();
					}
				}
				else if(scanFlag==6){
					ZDYzuhe24.SetEditText(strRst);
					if (ZDYzuhe24.getMenu().instant.equals("Y")) {
						ZDY24();
					}
				}
				else if(scanFlag==7){
					ZDYzuhe25.SetEditText(strRst);
					if (ZDYzuhe25.getMenu().instant.equals("Y")) {
						ZDY25();
					}
				}
				else if(scanFlag==8){
					ZDYzuhe26.SetEditText(strRst);
					if (ZDYzuhe26.getMenu().instant.equals("Y")) {
						ZDY26();
					}
				}
				else if(scanFlag==9){
					ZDYzuhe27.SetEditText(strRst);
					if (ZDYzuhe27.getMenu().instant.equals("Y")) {
						ZDY27();
					}
				}

			}
		}
		else
		{
			ActivityHelper.ToastShow(DPRZTask32.this, "扫描失败");
		}
	}



	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}