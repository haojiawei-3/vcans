package com.Vcan.activity;

import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPRZTaskDownWorkBY1Processor;
import com.vcans.model.MenuK;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ZDYzuhe;
import com.vcans.tool.ZDYzuhe.GifViewOnClickListener;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;
/**
 * 新备用模块   有3个界面类 分别  DPRZTask3 DPRZTask31 DPRZTask32
 * @author vcans
 *
 */
public class DPRZTask31 extends BaseActivity {
	ZDYzuhe ZDYzuhe10,ZDYzuhe11,ZDYzuhe12,ZDYzuhe13,ZDYzuhe14,ZDYzuhe15,ZDYzuhe16,ZDYzuhe17,ZDYzuhe18;
	String TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,instant;
	int scanFlag;
	public static DPRZTask31 DPRZTask31 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dprztask31);
		this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
		DPRZTask31=this;
		ZDYzuhe10=(ZDYzuhe)findViewById(R.id.ZDYzuhe10);
		ZDYzuhe11=(ZDYzuhe)findViewById(R.id.ZDYzuhe11);
		ZDYzuhe12=(ZDYzuhe)findViewById(R.id.ZDYzuhe12);
		ZDYzuhe13=(ZDYzuhe)findViewById(R.id.ZDYzuhe13);
		ZDYzuhe14=(ZDYzuhe)findViewById(R.id.ZDYzuhe14);
		ZDYzuhe15=(ZDYzuhe)findViewById(R.id.ZDYzuhe15);
		ZDYzuhe16=(ZDYzuhe)findViewById(R.id.ZDYzuhe16);
		ZDYzuhe17=(ZDYzuhe)findViewById(R.id.ZDYzuhe17);
		ZDYzuhe18=(ZDYzuhe)findViewById(R.id.ZDYzuhe18);
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");

		TZDYzuhe1=ActivityHelper.dprzTask3.tvBYName1v;
		TZDYzuhe2=ActivityHelper.dprzTask3.tvBYName2v;
		TZDYzuhe3=ActivityHelper.dprzTask3.tvBYName3v;
		TZDYzuhe4=ActivityHelper.dprzTask3.tvBYName4v;
		TZDYzuhe5=ActivityHelper.dprzTask3.tvBYName5v;
		TZDYzuhe6=ActivityHelper.dprzTask3.tvBYName6v;
		TZDYzuhe7=ActivityHelper.dprzTask3.tvBYName7v;
		TZDYzuhe8=ActivityHelper.dprzTask3.tvBYName8v;
		TZDYzuhe9=ActivityHelper.dprzTask3.tvBYName9v;

		Intent intent = this.getIntent();
		instant= (String)intent.getSerializableExtra("instant");
		Activityfinish();
		ZDYzuhe10.SetMenu(ActivityHelper.MenuList.get(9));
		ZDYzuhe11.SetMenu(ActivityHelper.MenuList.get(10));
		ZDYzuhe12.SetMenu(ActivityHelper.MenuList.get(11));
		ZDYzuhe13.SetMenu(ActivityHelper.MenuList.get(12));
		ZDYzuhe14.SetMenu(ActivityHelper.MenuList.get(13));
		ZDYzuhe15.SetMenu(ActivityHelper.MenuList.get(14));
		ZDYzuhe16.SetMenu(ActivityHelper.MenuList.get(15));
		ZDYzuhe17.SetMenu(ActivityHelper.MenuList.get(16));
		ZDYzuhe18.SetMenu(ActivityHelper.MenuList.get(17));
		if (instant!=null) {
			new Handler().postDelayed(new Runnable() {
				public void run() {
					instant(instant);
				}
			}, 500);

		}

		ZDYzuhe10.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=1;
				onOpenScanBarcode();

			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY10();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});

		ZDYzuhe11.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=2;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY11();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});
		ZDYzuhe12.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=3;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY12();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});
		ZDYzuhe13.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=4;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY13();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});
		ZDYzuhe14.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=5;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY14();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}

		});
		ZDYzuhe15.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=6;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY15();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});
		ZDYzuhe16.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=7;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY16();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});
		ZDYzuhe17.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=8;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY17();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});
		ZDYzuhe18.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				// TODO Auto-generated method stub
				scanFlag=9;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				// TODO Auto-generated method stub
				ZDY18();
			}

			@Override
			public void OnClickListener3() {
				// TODO Auto-generated method stub

			}


		});


	}

	public void ZDY1()
	{
		if (!TZDYzuhe1.equals("")) {


			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe1};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(1,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,"备用一不能为空");
		}


	}

	public void ZDY2()
	{

		if (!TZDYzuhe2.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe2,TZDYzuhe1};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(2,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,"备用二不能为空");
		}


	}

	public void ZDY3()
	{

		if (!TZDYzuhe3.equals("")) {

			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe3,TZDYzuhe1,TZDYzuhe2};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(3,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,"备用三不能为空");
		}

	}

	public void ZDY4()
	{

		if (!TZDYzuhe4.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe4,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(4,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,"备用四不能为空");
		}

	}
	public void ZDY5()
	{

		if (!TZDYzuhe5.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe5,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(5,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,"备用五不能为空");
		}

	}
	public void ZDY6()
	{

		if (!TZDYzuhe6.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe6,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(6,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,"备用六不能为空");
		}

	}
	public void ZDY7()
	{

		if (!TZDYzuhe7.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe7,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(7,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,"备用七不能为空");
		}

	}public void ZDY8()
	{

		if (!TZDYzuhe8.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe8,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(8,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,"备用八不能为空");
		}

	}

	public void ZDY9()
	{

		if (!TZDYzuhe9.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{TZDYzuhe9,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(9,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,"备用九不能为空");
		}

	}
	public void ZDY10()
	{

		if (!ZDYzuhe10.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe10.GetText(), TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(10,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,ZDYzuhe10.getMenu().title+"不能为空");
		}

	}
	public void ZDY11()
	{

		if (!ZDYzuhe11.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe11.GetText(),  TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					ZDYzuhe10.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(11,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,ZDYzuhe11.getMenu().title+"不能为空");
		}

	}
	public void ZDY12()
	{

		if (!ZDYzuhe12.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe12.GetText(),  TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					ZDYzuhe10.GetText(),ZDYzuhe11.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(12,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,ZDYzuhe12.getMenu().title+"不能为空");
		}

	}
	public void ZDY13()
	{

		if (!ZDYzuhe13.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe13.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					ZDYzuhe10.GetText(),ZDYzuhe11.GetText(),ZDYzuhe12.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(13,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,ZDYzuhe13.getMenu().title+"不能为空");
		}

	}
	public void ZDY14()
	{

		if (!ZDYzuhe14.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe14.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					ZDYzuhe10.GetText(),ZDYzuhe11.GetText(),ZDYzuhe12.GetText(),ZDYzuhe13.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(14,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,ZDYzuhe14.getMenu().title+"不能为空");
		}

	}
	public void ZDY15()
	{

		if (!ZDYzuhe15.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe15.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					ZDYzuhe10.GetText(),ZDYzuhe11.GetText(),ZDYzuhe12.GetText(),ZDYzuhe13.GetText(),ZDYzuhe14.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(15,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,ZDYzuhe15.getMenu().title+"不能为空");
		}

	}
	public void ZDY16()
	{

		if (!ZDYzuhe16.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe16.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					ZDYzuhe10.GetText(),ZDYzuhe11.GetText(),ZDYzuhe12.GetText(),ZDYzuhe13.GetText(),ZDYzuhe14.GetText(),ZDYzuhe15.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(16,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,ZDYzuhe16.getMenu().title+"不能为空");
		}

	}
	public void ZDY17()
	{

		if (!ZDYzuhe17.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe17.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					ZDYzuhe10.GetText(),ZDYzuhe11.GetText(),ZDYzuhe12.GetText(),ZDYzuhe13.GetText(),ZDYzuhe14.GetText(),ZDYzuhe15.GetText(),ZDYzuhe16.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(17,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,ZDYzuhe17.getMenu().title+"不能为空");
		}

	}
	public void ZDY18()
	{

		if (!ZDYzuhe18.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask31.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe18.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,
					ZDYzuhe10.GetText(),ZDYzuhe11.GetText(),ZDYzuhe12.GetText(),ZDYzuhe13.GetText(),ZDYzuhe14.GetText(),ZDYzuhe15.GetText(),ZDYzuhe16.GetText(),ZDYzuhe16.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(18,DPRZTask3.gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask31.this,ZDYzuhe18.getMenu().title+"不能为空");
		}

	}

	public void onNext()
	{
		if(ZDYzuhe10.GetText().equals("")||ZDYzuhe11.GetText().equals("")||ZDYzuhe12.GetText().equals("")||
				ZDYzuhe13.GetText().equals("")||ZDYzuhe14.GetText().equals("")||ZDYzuhe15.GetText().equals("")
				||ZDYzuhe16.GetText().equals("")||ZDYzuhe17.GetText().equals("")||ZDYzuhe18.GetText().equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}
		ActivityHelper.dprzTask3.tvBYName10v=ZDYzuhe10.GetText();
		ActivityHelper.dprzTask3.tvBYName11v=ZDYzuhe11.GetText();
		ActivityHelper.dprzTask3.tvBYName12v=ZDYzuhe12.GetText();
		ActivityHelper.dprzTask3.tvBYName13v=ZDYzuhe13.GetText();
		ActivityHelper.dprzTask3.tvBYName14v=ZDYzuhe14.GetText();
		ActivityHelper.dprzTask3.tvBYName15v=ZDYzuhe15.GetText();
		ActivityHelper.dprzTask3.tvBYName16v=ZDYzuhe16.GetText();
		ActivityHelper.dprzTask3.tvBYName17v=ZDYzuhe17.GetText();
		ActivityHelper.dprzTask3.tvBYName18v=ZDYzuhe18.GetText();
		Intent intent=new Intent(this,DPRZTask32.class);	   // &&       sy                     ||     yg
		if (ActivityHelper.MenuList.get(17).instant.equals("Y")&&ActivityHelper.MenuList.get(17).strEnabled.equals("Y")) {
			intent.putExtra("instant", "18");
		}else if (ActivityHelper.MenuList.get(16).instant.equals("Y")&&ActivityHelper.MenuList.get(16).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "17");
		}else if (ActivityHelper.MenuList.get(15).instant.equals("Y")&&ActivityHelper.MenuList.get(15).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "16");
		}else if (ActivityHelper.MenuList.get(14).instant.equals("Y")&&ActivityHelper.MenuList.get(14).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "15");
		}else if (ActivityHelper.MenuList.get(13).instant.equals("Y")&&ActivityHelper.MenuList.get(13).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "14");
		}else if (ActivityHelper.MenuList.get(12).instant.equals("Y")&&ActivityHelper.MenuList.get(12).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "13");
		}else if (ActivityHelper.MenuList.get(11).instant.equals("Y")&&ActivityHelper.MenuList.get(11).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "12");
		}else if (ActivityHelper.MenuList.get(10).instant.equals("Y")&&ActivityHelper.MenuList.get(10).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "11");
		}else if (ActivityHelper.MenuList.get(9).instant.equals("Y")&&ActivityHelper.MenuList.get(9).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "10");
		}
		startActivity(intent);

	}

	@Override
	protected void onRestart() {


		super.onRestart();
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
					ZDYzuhe10.SetEditText(strRst);
					if (ZDYzuhe10.getMenu().instant.equals("Y")) {
						ZDY10();
					}

				}
				else if(scanFlag==2){
					ZDYzuhe11.SetEditText(strRst);
					if (ZDYzuhe11.getMenu().instant.equals("Y")) {
						ZDY11();
					}
				}
				else if(scanFlag==3){
					ZDYzuhe12.SetEditText(strRst);
					if (ZDYzuhe12.getMenu().instant.equals("Y")) {
						ZDY12();
					}
				}
				else if(scanFlag==4){
					ZDYzuhe13.SetEditText(strRst);
					if (ZDYzuhe13.getMenu().instant.equals("Y")) {
						ZDY13();
					}
				}
				else if(scanFlag==5){
					ZDYzuhe14.SetEditText(strRst);
					if (ZDYzuhe14.getMenu().instant.equals("Y")) {
						ZDY14();
					}
				}
				else if(scanFlag==6){
					ZDYzuhe15.SetEditText(strRst);
					if (ZDYzuhe15.getMenu().instant.equals("Y")) {
						ZDY15();
					}
				}
				else if(scanFlag==7){
					ZDYzuhe16.SetEditText(strRst);
					if (ZDYzuhe16.getMenu().instant.equals("Y")) {
						ZDY16();
					}
				}
				else if(scanFlag==8){
					ZDYzuhe17.SetEditText(strRst);
					if (ZDYzuhe17.getMenu().instant.equals("Y")) {
						ZDY17();
					}
				}
				else if(scanFlag==9){
					ZDYzuhe18.SetEditText(strRst);
					if (ZDYzuhe18.getMenu().instant.equals("Y")) {
						ZDY18();
					}
				}

			}
		}
		else
		{
			ActivityHelper.ToastShow(DPRZTask31.this, "扫描失败");
		}
	}

	public void  Activityfinish(){
		String s1= ActivityHelper.MenuList.get(9).strEnabled;
		String s2= ActivityHelper.MenuList.get(10).strEnabled;
		String s3= ActivityHelper.MenuList.get(11).strEnabled;
		String s4= ActivityHelper.MenuList.get(12).strEnabled;
		String s5= ActivityHelper.MenuList.get(13).strEnabled;
		String s6= ActivityHelper.MenuList.get(14).strEnabled;
		String s7= ActivityHelper.MenuList.get(15).strEnabled;
		String s8= ActivityHelper.MenuList.get(16).strEnabled;
		String s9= ActivityHelper.MenuList.get(17).strEnabled;
		if (  s1.equals("N")&&s2.equals("N")&&s3.equals("N")&&s4.equals("N")&&s5.equals("N")&&s6.equals("N")&&s7.equals("N")&&s8.equals("N")&&s9.equals("N")) {
			Intent intent=new Intent(this,DPRZTask32.class);
			intent.putExtra("instant", instant);
			startActivity(intent);
			finish();
		}
	}
	public void  instant(String s){
		if (s.equals("1")) {
			ZDY1();
		}else if (s.equals("2")) {
			ZDY2();
		}else if (s.equals("3")) {
			ZDY3();
		}else if (s.equals("4")) {
			ZDY4();
		}else if (s.equals("5")) {
			ZDY5();
		}else if (s.equals("6")) {
			ZDY6();
		}else if (s.equals("7")) {
			ZDY7();
		}else if (s.equals("8")) {
			ZDY8();
		}else if (s.equals("9")) {
			ZDY9();
		}
	}



	@Override
	protected void onResume() {

		super.onResume();

	}


	@Override
	protected void onDestroy() {

		super.onDestroy();
	}


	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
