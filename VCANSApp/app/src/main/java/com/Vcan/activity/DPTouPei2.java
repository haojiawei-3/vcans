package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPTPDownColorProcessor;
import com.vcans.Processor.DPTPUploadProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
/**
 * 生产投坏   有3个界面类 分别  DPTouPei    DPTouPei1   DPTouPei2
 * @author vcans
 *
 */
public class DPTouPei2 extends BaseActivity {
	// public static DPTouPei2 dpTouPei2 = null;
	private DPTPUploadProcessor mUploadTouPei=null;
	private ListView mListView;
	private int mLastClickId=-1;
	private long mLastClickTime=0;
	private List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	private TextView tvPage;
	private LinearLayout layProColor;
	private Spinner dropColor;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_toupei2);
		//	 dpTouPei2=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.btnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.imgBtnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.tvClear,"onClear");
		this.<Button>RegOnClickEvent(R.id.BtnDelete,"onDelete");
		ImageButton btnBack= (ImageButton) findViewById(R.id.btnBack);

		Button btnNext=(Button)this.findViewById(R.id.btnOk);
		btnNext.setText(getString(R.string.btn_upload));
		ImageButton imgBtnOk= (ImageButton) findViewById(R.id.imgBtnOk);
		imgBtnOk.setImageResource(R.drawable.upload);
		mListView=(ListView)findViewById(R.id.lvProdct);
		layProColor=(LinearLayout)findViewById(R.id.layProColor);
		dropColor=(Spinner)this.findViewById(R.id.dropColor);

		mUploadTouPei=new DPTPUploadProcessor();
		PlProcessor.SetParent(this);

		mUploadTouPei.DisplayTouPeiInfo();
		mListView.setOnItemClickListener(listClickListener);
		tvPage = (TextView) findViewById(R.id.tvPage);

		HashMap<String,String> mapParms=ActivityHelper.getParams(this, new String[]{"isInputProColor"});

		if(!mapParms.get("isInputProColor").equals("1"))
		{
			layProColor.setVisibility(View.GONE);
		}
		else
		{
			SendParam sendParam=new SendParam();
			sendParam.parent=this;
			sendParam.tip=getString(R.string.btn_load)+"...";
			sendParam.processor=new DPTPDownColorProcessor();
			sendParam.szData=new String[]{ActivityHelper.gToupei.strRZPlanId,"投料"};//投料为固定值
			this.getDataTrunsfer().request(sendParam);
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


				mUploadTouPei.displayDetail(mDataList);

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
		String strColor="";

		if(dropColor.getSelectedItem()!=null)
			strColor=dropColor.getSelectedItem().toString().trim();

		ActivityHelper.gToupei.strColor=strColor;
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
			ActivityHelper.showDialog(DPTouPei2.this,"错误",getString(R.string.noSelected));
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
