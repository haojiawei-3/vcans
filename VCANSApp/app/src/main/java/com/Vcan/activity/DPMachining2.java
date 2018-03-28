package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;

import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPMachiUploadProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
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

public class DPMachining2 extends BaseActivity {
	//public static DPMachining2 dpMachining2 = null;
	DPMachiUploadProcessor mUploadProcessor=null;
	ListView mListView;
	private int mLastClickId=-1;
	private long mLastClickTime=0;
	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	TextView tvPage;
	String strRst;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_machining2);
		// dpMachining2=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.btnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.imgBtnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.tvClear,"onClear");
		this.<Button>RegOnClickEvent(R.id.BtnDelete,"onDelete");

		PlProcessor.SetParent(this);

		mUploadProcessor=new DPMachiUploadProcessor();
		mUploadProcessor.DisplayTouPeiInfo();

		Button btnOk= (Button) findViewById(R.id.btnOk);
		btnOk.setText(getString(R.string.btn_upload));

		ImageButton imgBtnOk= (ImageButton) findViewById(R.id.imgBtnOk);
		imgBtnOk.setImageResource(R.drawable.upload);

		mListView=(ListView)this.findViewById(R.id.lvProdct);
		mListView.setOnItemClickListener(listClickListener);
		tvPage = (TextView) findViewById(R.id.tvPage);

		if(ActivityHelper.gToupei.strColorAllOut.equals("Y"))
		{
			EditText pishu=(EditText)findViewById(R.id.txtPiShu);
			EditText num=(EditText)findViewById(R.id.txtNumber);
			Button btnSave=(Button)findViewById(R.id.btnSave);
			btnSave.setVisibility(View.INVISIBLE);

			pishu.setEnabled(false);
			num.setEnabled(false);
			pishu.setBackgroundColor(Color.GRAY);
			num.setBackgroundColor(Color.GRAY);

			Intent intent=this.getIntent();
			strRst =intent.getStringExtra("result");

			new Handler().postDelayed(new Runnable(){

				public void run() {

					ActivityHelper.hidesofeKeyboard(DPMachining2.this);

					if(strRst.equals("2"))
						ActivityHelper.showDialog(DPMachining2.this,"错误",getString(R.string.datareplace));
				}
			}, 300);



		}
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
			//ActivityHelper.showStatusDialog(this, "等待服务器响应...");
			//this.getDataTrunsfer().SetProcessor(mUploadProcessor);
			//mUploadProcessor.SendBeginUpload();

			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.processor = mUploadProcessor;
			getDataTrunsfer().beginUploadText(sendParam);
		}
		else
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.noData));
		}

	}

	public void onSave()
	{
		PlProcessor.SetParent(this);
		ActivityHelper.hidesofeKeyboard(this);
		mUploadProcessor.SaveToupeiInfo();
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


	}

}
