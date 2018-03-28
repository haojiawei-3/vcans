package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.GDBakModuleUploadProc;
import com.vcans.Processor.GDBakPublicFuzuDownProc;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 备用模块   有5个界面类 分别  GDBakModule GDBakModule1 GDBakModule2 GDBakModule3 GDBakModule4
 * @author vcans
 *
 */
public class GDBakModule4 extends BaseActivity {
	// public static GDBakModule4 bakModule4 = null;
	public final static int FUZHU8_DONE=0;
	private GDBakModuleUploadProc mUploadProcessor=null;
	private ListView mListView;
	private boolean isDataItem1;
	private int mLastClickId=-1;
	private long mLastClickTime=0;
	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	TextView tvPage;
	EditText txtDataItem6,txtDataItem7,txtPiShu,txtNum;
	String txtDataItem66,txtDataItem77,txtPiShuu,txtNumm;
	private boolean bLoadFlag1=false;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gd_bakmodule4);
		// bakModule4=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.btnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.imgBtnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"onOpenScanBarcode1");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode2,"onOpenScanBarcode2");
		this.<TextView>RegOnClickEvent(R.id.tvClear,"onClear");
		this.<Button>RegOnClickEvent(R.id.BtnDelete,"onDelete");
		txtDataItem6= (EditText) findViewById(R.id.txtDataItem6);
		txtDataItem7= (EditText) findViewById(R.id.txtDataItem7);
		txtPiShu= (EditText) findViewById(R.id.txtPiShu);
		txtNum= (EditText) findViewById(R.id.txtNum);

		PlProcessor.SetParent(this);

		Button btnOk= (Button) findViewById(R.id.btnOk);
		btnOk.setText(getString(R.string.btn_upload));

		ImageButton imgBtnOk= (ImageButton) findViewById(R.id.imgBtnOk);
		imgBtnOk.setImageResource(R.drawable.upload);

		mUploadProcessor=new GDBakModuleUploadProc();
		mUploadProcessor.DisplayInfo();

		tvPage = (TextView) findViewById(R.id.tvPage);

		mListView=(ListView)this.findViewById(R.id.lvProdct);
		mListView.setOnItemClickListener(listClickListener);

		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.szData=new String[]{GDBakPublicFuzuDownProc.FZ8};
		sendParam.processor = new GDBakPublicFuzuDownProc();
		getDataTrunsfer().request(sendParam);

		new Handler().postDelayed(new Runnable() {
			public void run() {
				txtDataItem66=txtDataItem6.getText().toString();
				txtDataItem77=txtDataItem7.getText().toString();
				txtPiShuu=txtPiShu.getText().toString();
				txtNumm=txtNum.getText().toString();
				if (txtDataItem66.equals("0")||txtDataItem77.equals("0")||txtPiShuu.equals("0")||txtNumm.equals("0")) {
					onSave();
				}	else  {
					Toast.makeText(GDBakModule4.this, "数据", 1).show();
				}
			}
		}, 1000);
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

				mUploadProcessor.displayDetail(mDataList);

			}
			else
			{
				mLastClickId =arg2;
				mLastClickTime = System.currentTimeMillis();
			}
		}
	};


	public void onUpload()
	{//上传
		if(mListView.getCount()>0)
		{
			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.bSendEndNotify=true;
			sendParam.processor = mUploadProcessor;
			getDataTrunsfer().beginUploadFile(sendParam);
		}
		else
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.noData));
		}

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub

		super.onResume();
	}


	public void onOpenScanBarcode1()
	{
		isDataItem1 = true;
		onOpenScanBarcode();
	}

	public void onOpenScanBarcode2()
	{
		isDataItem1 = false;
		onOpenScanBarcode();
	}

	public void onSave()
	{
		PlProcessor.SetParent(this);
		ActivityHelper.hidesofeKeyboard(this);
		mUploadProcessor.SaveInfo();
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
	public void onActivityResult(int requestCode,int resultCode,Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode==REQUEST_SCAN_QRCODE_FLAG)
		{//条码扫描完毕返回
			if(resultCode==Activity.RESULT_OK)
			{
				Bundle bundle = data.getExtras();
				String strRst=bundle.getString("result");
				if(isDataItem1)
					txtDataItem6.setText(strRst);
				else
					txtDataItem7.setText(strRst);
			}
		}
		else
		{

		}
	}

	@Override
	public void processMessage(int msgId, String msg) {

		if(msgId==FUZHU8_DONE)
		{
			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.szData=new String[]{GDBakPublicFuzuDownProc.FZ9};
			sendParam.processor = new GDBakPublicFuzuDownProc();
			getDataTrunsfer().request(sendParam);

		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}




}
