package com.Vcan.activity;

import java.util.ArrayList;
import java.util.List;

import com.vcans.Processor.AppManager;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPRZTaskDownWorkBY1Processor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.ZDYzuhe;
import com.vcans.tool.ZDYzuhe.GifViewOnClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
/**
 * 新备用模块   有3个界面类 分别  DPRZTask3 DPRZTask31 DPRZTask32
 * @author vcans
 *
 */
public class DPRZTask3 extends BaseActivity implements GifViewOnClickListener{
	public static DPRZTask3 DPRZTask3 = null;
	ZDYzuhe ZDYzuhe1,ZDYzuhe2,ZDYzuhe3,ZDYzuhe4,ZDYzuhe5,ZDYzuhe6,ZDYzuhe7,ZDYzuhe8,ZDYzuhe9;
	TextView TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9;
	int  scanFlag;
	public static String gBakFlag="";
	List<String>  ss=new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dprztask3);
		this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
		DPRZTask3=this;
		ZDYzuhe1=(ZDYzuhe)findViewById(R.id.ZDYzuhe1);
		ZDYzuhe2=(ZDYzuhe)findViewById(R.id.ZDYzuhe2);
		ZDYzuhe3=(ZDYzuhe)findViewById(R.id.ZDYzuhe3);
		ZDYzuhe4=(ZDYzuhe)findViewById(R.id.ZDYzuhe4);
		ZDYzuhe5=(ZDYzuhe)findViewById(R.id.ZDYzuhe5);
		ZDYzuhe6=(ZDYzuhe)findViewById(R.id.ZDYzuhe6);
		ZDYzuhe8=(ZDYzuhe)findViewById(R.id.ZDYzuhe8);
		ZDYzuhe7=(ZDYzuhe)findViewById(R.id.ZDYzuhe7);
		ZDYzuhe9=(ZDYzuhe)findViewById(R.id.ZDYzuhe9);

		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		ActivityHelper.dprzTask3.tvBYName30v=gBakFlag;

		if (gBakFlag.equals(ItemTitleHelper.K1)) {
			if (ActivityHelper.MenuKLists1.size()==0) {
				ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K1);
			}else {
				ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K1);
			}

		}else if (gBakFlag.equals(ItemTitleHelper.K2)) {
			if (ActivityHelper.MenuKLists1.size()==0) {
				ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K2);
			}else {
				ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K2);
			}

		}else if (gBakFlag.equals(ItemTitleHelper.K3)) {
			if (ActivityHelper.MenuKLists1.size()==0) {
				ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K3);
			}else {
				ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K3);
			}

		}else if (gBakFlag.equals(ItemTitleHelper.K4)) {
			if (ActivityHelper.MenuKLists1.size()==0) {
				ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K4);
			}else {
				ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K4);
			}

		}else if (gBakFlag.equals(ItemTitleHelper.K5)) {
			if (ActivityHelper.MenuKLists1.size()==0) {

				ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K5);
			}else {
				ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K5);
				// ActivityHelper.MenuList=ActivityHelper.setItemMenuK(ItemTitleHelper.K5); // 需要该一下
			}

		}

		ZDYzuhe1.SetMenu(ActivityHelper.MenuList.get(0));
		ZDYzuhe2.SetMenu(ActivityHelper.MenuList.get(1));
		ZDYzuhe3.SetMenu(ActivityHelper.MenuList.get(2));
		ZDYzuhe4.SetMenu(ActivityHelper.MenuList.get(3));
		ZDYzuhe5.SetMenu(ActivityHelper.MenuList.get(4));
		ZDYzuhe6.SetMenu(ActivityHelper.MenuList.get(5));
		ZDYzuhe7.SetMenu(ActivityHelper.MenuList.get(6));
		ZDYzuhe8.SetMenu(ActivityHelper.MenuList.get(7));
		ZDYzuhe9.SetMenu(ActivityHelper.MenuList.get(8));

		ZDYzuhe1.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				scanFlag=1;
				onOpenScanBarcode();

			}

			@Override
			public void OnClickListener2() {
				ZDY1();
			}

			@Override
			public void OnClickListener3() {

			}


		});

		ZDYzuhe2.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				scanFlag=2;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				ZDY2();

			}

			@Override
			public void OnClickListener3() {

			}


		});
		ZDYzuhe3.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				scanFlag=3;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				ZDY3();
			}

			@Override
			public void OnClickListener3() {

			}


		});
		ZDYzuhe4.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				scanFlag=4;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				ZDY4();
			}

			@Override
			public void OnClickListener3() {

			}


		});
		ZDYzuhe5.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				scanFlag=5;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				ZDY5();
			}

			@Override
			public void OnClickListener3() {

			}

		});
		ZDYzuhe6.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				scanFlag=6;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				ZDY6();
			}

			@Override
			public void OnClickListener3() {

			}

		});
		ZDYzuhe7.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				scanFlag=7;
				onOpenScanBarcode();
			}

			@Override
			public void OnClickListener2() {
				ZDY7();
			}

			@Override
			public void OnClickListener3() {

			}


		});
		ZDYzuhe8.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				scanFlag=8;
				onOpenScanBarcode();
			}
			@Override
			public void OnClickListener2() {
				ZDY8();
			}

			@Override
			public void OnClickListener3() {

			}


		});
		ZDYzuhe9.setgifView(new GifViewOnClickListener() {

			@Override
			public void OnClickListener1() {
				scanFlag=9;
				onOpenScanBarcode();
			}
			@Override
			public void OnClickListener2() {
				ZDY9();
			}

			@Override
			public void OnClickListener3() {

			}


		});



	}

	public void ZDY1()
	{
		if (!ZDYzuhe1.GetText().equals("")) {


			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask3.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe1.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(1,gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask3.this,ZDYzuhe1.getMenu().title+"不能为空");
		}


	}

	public void ZDY2()
	{

		if (!ZDYzuhe2.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask3.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe2.GetText(),ZDYzuhe1.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(2,gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask3.this,ZDYzuhe2.getMenu().title+"不能为空");
		}


	}

	public void ZDY3()
	{

		if (!ZDYzuhe3.GetText().equals("")) {

			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask3.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe3.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(3,gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask3.this,ZDYzuhe3.getMenu().title+"不能为空");
		}

	}

	public void ZDY4()
	{

		if (!ZDYzuhe4.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask3.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe4.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText(),ZDYzuhe3.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(4,gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask3.this,ZDYzuhe4.getMenu().title+"不能为空");
		}

	}
	public void ZDY5()
	{

		if (!ZDYzuhe5.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask3.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe5.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText(),ZDYzuhe3.GetText(),ZDYzuhe4.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(5,gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask3.this,ZDYzuhe5.getMenu().title+"不能为空");
		}

	}
	public void ZDY6()
	{

		if (!ZDYzuhe6.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask3.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe6.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText(),ZDYzuhe3.GetText(),ZDYzuhe4.GetText(),ZDYzuhe5.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(6,gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask3.this,ZDYzuhe6.getMenu().title+"不能为空");
		}

	}
	public void ZDY7()
	{

		if (!ZDYzuhe7.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask3.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe7.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText(),ZDYzuhe3.GetText(),ZDYzuhe4.GetText(),ZDYzuhe5.GetText(),ZDYzuhe6.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(7,gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask3.this,ZDYzuhe7.getMenu().title+"不能为空");
		}

	}public void ZDY8()
	{

		if (!ZDYzuhe8.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask3.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe8.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText(),ZDYzuhe3.GetText(),ZDYzuhe4.GetText(),ZDYzuhe5.GetText(),ZDYzuhe6.GetText(),ZDYzuhe7.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(8,gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask3.this,ZDYzuhe8.getMenu().title+"不能为空");
		}

	}
	public void ZDY9()
	{

		if (!ZDYzuhe9.GetText().equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = DPRZTask3.this;
			sendParam.tip = getString(R.string.btn_load)+"...";
			sendParam.szData = new String[]{ZDYzuhe9.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText(),ZDYzuhe3.GetText(),ZDYzuhe4.GetText(),ZDYzuhe5.GetText(),ZDYzuhe6.GetText(),ZDYzuhe7.GetText(),ZDYzuhe8.GetText()};
			sendParam.processor = new DPRZTaskDownWorkBY1Processor(9,gBakFlag);
			getDataTrunsfer().request(sendParam);
		}else {
			ActivityHelper.ToastShow(DPRZTask3.this,ZDYzuhe9.getMenu().title+"不能为空");
		}

	}

	public void onNext()
	{
		if(ZDYzuhe1.GetText().equals("")||ZDYzuhe2.GetText().equals("")||ZDYzuhe3.GetText().equals("")|| ZDYzuhe4.GetText().equals("")||ZDYzuhe5.GetText().equals("")||ZDYzuhe6.GetText().equals("") ||ZDYzuhe7.GetText().equals("")||ZDYzuhe8.GetText().equals("")||ZDYzuhe9.GetText().equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}
		ActivityHelper.dprzTask3.tvBYName1v=ZDYzuhe1.GetText();
		ActivityHelper.dprzTask3.tvBYName2v=ZDYzuhe2.GetText();
		ActivityHelper.dprzTask3.tvBYName3v=ZDYzuhe3.GetText();
		ActivityHelper.dprzTask3.tvBYName4v=ZDYzuhe4.GetText();
		ActivityHelper.dprzTask3.tvBYName5v=ZDYzuhe5.GetText();
		ActivityHelper.dprzTask3.tvBYName6v=ZDYzuhe6.GetText();
		ActivityHelper.dprzTask3.tvBYName7v=ZDYzuhe7.GetText();
		ActivityHelper.dprzTask3.tvBYName8v=ZDYzuhe8.GetText();
		ActivityHelper.dprzTask3.tvBYName9v=ZDYzuhe9.GetText();
		Intent intent=new Intent(this,DPRZTask31.class);
		if (ActivityHelper.MenuList.get(8).instant.equals("Y")&&ActivityHelper.MenuList.get(8).strEnabled.equals("Y")) {
			intent.putExtra("instant", "9");
		}else if (ActivityHelper.MenuList.get(7).instant.equals("Y")&&ActivityHelper.MenuList.get(7).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "8");
		}else if (ActivityHelper.MenuList.get(6).instant.equals("Y")&&ActivityHelper.MenuList.get(6).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "7");
		}else if (ActivityHelper.MenuList.get(5).instant.equals("Y")&&ActivityHelper.MenuList.get(5).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "6");
		}else if (ActivityHelper.MenuList.get(4).instant.equals("Y")&&ActivityHelper.MenuList.get(4).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "5");
		}else if (ActivityHelper.MenuList.get(3).instant.equals("Y")&&ActivityHelper.MenuList.get(3).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "4");
		}else if (ActivityHelper.MenuList.get(2).instant.equals("Y")&&ActivityHelper.MenuList.get(2).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "3");
		}else if (ActivityHelper.MenuList.get(1).instant.equals("Y")&&ActivityHelper.MenuList.get(1).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "2");
		}else if (ActivityHelper.MenuList.get(0).instant.equals("Y")&&ActivityHelper.MenuList.get(0).strEnabled.equals("Y")) {
			intent.putExtra("instant",  "1");
		}
//
		startActivity(intent);

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
					ZDYzuhe1.SetEditText(strRst);
					if (ZDYzuhe1.getMenu().instant.equals("Y")) {
						ZDY1();
					}
				}
				else if(scanFlag==2){
					ZDYzuhe2.SetEditText(strRst);
					if (ZDYzuhe2.getMenu().instant.equals("Y")) {
						ZDY2();
					}

				}
				else if(scanFlag==3){
					ZDYzuhe3.SetEditText(strRst);
					if (ZDYzuhe3.getMenu().instant.equals("Y")) {
						ZDY3();
					}
				}
				else if(scanFlag==4){
					ZDYzuhe4.SetEditText(strRst);
					if (ZDYzuhe4.getMenu().instant.equals("Y")) {
						ZDY4();
					}

				}
				else if(scanFlag==5){
					ZDYzuhe5.SetEditText(strRst);
					if (ZDYzuhe5.getMenu().instant.equals("Y")) {
						ZDY5();
					}
				}
				else if(scanFlag==6){
					ZDYzuhe6.SetEditText(strRst);
					if (ZDYzuhe6.getMenu().instant.equals("Y")) {
						ZDY6();
					}
				}
				else if(scanFlag==7){
					ZDYzuhe7.SetEditText(strRst);
					if (ZDYzuhe7.getMenu().instant.equals("Y")) {
						ZDY7();
					}
				}
				else if(scanFlag==8){
					ZDYzuhe8.SetEditText(strRst);
					if (ZDYzuhe8.getMenu().instant.equals("Y")) {
						ZDY8();
					}
				}
				else if(scanFlag==9){
					ZDYzuhe9.SetEditText(strRst);
					if (ZDYzuhe9.getMenu().instant.equals("Y")) {
						ZDY9();
					}
				}

			}
		}else{
			ActivityHelper.ToastShow(DPRZTask3.this, "扫描失败");
		}
	}


	@Override
	protected void onResume() {

		super.onResume();

	}


	@Override
	protected void onDestroy() {
		ActivityHelper.dprzTask3.tvBYName30v=null;
		super.onDestroy();
	}


	@Override
	public void OnClickListener1() {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnClickListener2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnClickListener3() {
		// TODO Auto-generated method stub

	}

	@Override
	public void processMessage(int msgId, String msg) {

	}








}
