package com.Vcan.activity;
/**
 * 染整费用   有2个界面类 分别  DPRZCost  DPRZCost1
 * @author vcans
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPRZCostUploadProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TimePicker;

public class DPRZCost1 extends BaseActivity {
	//public static DPRZCost1 dprzCost1 = null;
	DPRZCostUploadProcessor mUploadTouPei=null;
	ListView mListView;
	private int mLastClickId=-1;
	private long mLastClickTime=0;
	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	TextView tvPage;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_rzcost1);
		// dprzCost1=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.btnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.imgBtnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.tvClear,"onClear");
		this.<Button>RegOnClickEvent(R.id.BtnDelete,"onDelete");

		Button btnNext=(Button)this.findViewById(R.id.btnOk);
		btnNext.setText(getString(R.string.btn_upload));

		ImageButton imgBtnNext=(ImageButton)this.findViewById(R.id.imgBtnOk);
		imgBtnNext.setImageResource(R.drawable.upload);



		mUploadTouPei=new DPRZCostUploadProcessor();
		PlProcessor.SetParent(this);

		InitCostSelect();

		mUploadTouPei.DisplayTouPeiInfo();

		mListView=(ListView)this.findViewById(R.id.lvProdct);

		mListView.setOnItemClickListener(listClickListener);
		tvPage = (TextView) findViewById(R.id.tvPage);
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


				mUploadTouPei.displayDetail(mDataList);

			}
			else
			{
				mLastClickId =arg2;
				mLastClickTime = System.currentTimeMillis();
			}

		}
	};


	public void InitCostSelect()
	{
		ActivityHelper.InitDrop(this, R.id.dropCostSelect, ActivityHelper.lstGongyi,true);
	}

	public void onUpload()
	{//上传

		if(mListView.getCount()>0)
		{
			//ActivityHelper.showStatusDialog(this, "等待服务器响应...");
			//this.getDataTrunsfer().SetProcessor(mUploadTouPei);
			//mUploadTouPei.SendBeginUpload();

			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.processor = mUploadTouPei;
			getDataTrunsfer().beginUploadText(sendParam);
		}
		else
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.noData));
		}

	}

	public void onSave()
	{
		//费用选择
		Spinner sp=(Spinner)this.findViewById(R.id.dropCostSelect);
		String strCostSelect=sp.getSelectedItem().toString().trim();

		if(strCostSelect.equals(""))
			return;

		String[] szCostSelect=strCostSelect.split("\\[");

		if(szCostSelect.length<2)
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		ActivityHelper.gToupei.strCostSelectName=szCostSelect[0];
		ActivityHelper.gToupei.strCostSelectId=szCostSelect[1].substring(0,szCostSelect[1].length()-1);
		PlProcessor.SetParent(this);
		ActivityHelper.hidesofeKeyboard(this);
		mUploadTouPei.SaveToupeiInfo();
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
						mUploadTouPei.ClearToupeiInfo();

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
							mUploadTouPei.DeleteToupeiInfo(mstrDataId);
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
