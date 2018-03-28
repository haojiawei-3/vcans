package com.Vcan.activity;

import java.util.HashMap;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.YPDownBatchValueProcessor;
import com.vcans.Processor.YPDownFieldProcessor;
import com.vcans.adapter.HorizontalListView;
import com.vcans.model.BandleParam;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.TableLayout.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
/**
 * 样品查询*/
public class YPQuery extends BaseActivity {
	//public static YPQuery query = null;
	ListView mLvTouPei;
	EditText txtOutNotifyId;
	CheckBox mCheckOffLine;
	private int pageCount;
	private int index=0;
	float startX = 0, startY = 0;
	float startX2 = 0, startY2 = 0;
	YPDownFieldProcessor downField=null;
	YPDownValueProcessorV2 downValue=null;
	YPDownBatchValueProcessor downBatchValue=new YPDownBatchValueProcessor();
	TextView tvPage ;
	Button mBtnOk;
	ImageButton mImgBtnOk;
	String strBarcode;
	LinearLayout tvImgList;

	HorizontalListView hListView = null;
	int testCount=0;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yp_query);

		// query=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"onOpenScanBarcode");
		this.<CheckBox>RegOnClickEvent(R.id.chkOffLine,"onOfflineCheck");
		this.<Button>RegOnClickEvent(R.id.btnDownload,"onDownloadBatchYP");
		this.<TextView> RegOnClickEvent(R.id.tvLoad, "clearData");
		//setListItemClickMethod("onGoodsItemClick","onYPImageDbItemClick");
		this.RegItemOnDbClickEvent(R.id.horizon_listview, "onYPImageDbItemClick");

		mBtnOk=(Button)this.findViewById(R.id.btnOk);
		mImgBtnOk=(ImageButton)findViewById(R.id.imgBtnOk);
		mBtnOk.setText(getString(R.string.btn_query));
		mImgBtnOk.setImageResource(R.drawable.query_yp);

		tvImgList=(LinearLayout)this.findViewById(R.id.tvImageList);
		tvImgList.setVisibility(View.INVISIBLE);

		downField=new YPDownFieldProcessor();
		//downValue=new YPDownValueProcessor();
		downValue=new YPDownValueProcessorV2();

		txtOutNotifyId= (EditText) findViewById(R.id.txtOutNotifyId);
		txtOutNotifyId.addTextChangedListener(mTxtWatcher);

		mCheckOffLine=(CheckBox)this.findViewById(R.id.chkOffLine);
		mLvTouPei=(ListView)this.findViewById(R.id.lvProdct);
		//mLvTouPei.setOnItemClickListener(listClickListener);
		tvPage = (TextView) findViewById(R.id.tvPage);
		ListView layList = (ListView) findViewById(R.id.lvProdct);
		layList.setOnTouchListener(viewTouchListener);


		HashMap<String,String> mapParms=ActivityHelper.getParams(this,
				new String[]{"isOffLine"});

		if(mapParms.get("isOffLine").equals("1"))
		{
			mCheckOffLine.setChecked(true);
		}
		else
			mCheckOffLine.setChecked(false);

		onOfflineCheck();

		 /*
		 if(!DataTrunsfer.ENABLED_DES_ZIP)
		 {
		    LinearLayout layImgYp = (LinearLayout) findViewById(R.id.layImgYP);
	    	layImgYp.setVisibility(View.INVISIBLE);
	    	LayoutParams parm=new LayoutParams();
	    	parm.width=0;
	    	layImgYp.setLayoutParams(parm);
		 }
		 */

		hListView=(HorizontalListView)findViewById(R.id.horizon_listview);
		hListView.setOnItemClickListener(onItemClick);

		downValue.setNewQuery(true);
		display();

		Intent intent = this.getIntent();
		String barcode=intent.getStringExtra("barcode");
		if(barcode!=null)
		{
			txtOutNotifyId.setText(barcode);
			onNext();

		}
	}



	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		 if (getSzBitmap()==null) {
			// ActivityHelper.recycleBitmaps(this.getSzBitmap());
		 }else {
			 ActivityHelper.recycleBitmaps(this.getSzBitmap());
		}
		super.onDestroy();
	}




	public void clearData()
	{
		if (mLvTouPei.getCount() < 1) {
			return;
		}

		new AlertDialog.Builder(this).setTitle(getString(R.string.btn_clear))
				.setIcon(R.drawable.icon_shanchu_unfocused)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						downValue.clearData();
						downValue.setNewQuery(true);
						index=0;
						display();

					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
	}

	final OnTouchListener viewTouchListener = new OnTouchListener() {

		public boolean onTouch(View arg0, MotionEvent event) {
			// TODO Auto-generated method stub
			switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					startX = event.getX();
					startY = event.getY();
					break;
				case MotionEvent.ACTION_UP:

					startX2 = event.getX();
					startY2 = event.getY();

					if (Math.abs(startX - startX2) < 60) {
						return true;// 距离较小，当作click事件来处理
					}

					if (event.getX() > startX) { // 向右滑动
						if (--index >=0) {// 为第二页时可向右滑动
							display();
						}
						else
							index=0;
					} else if (event.getX() < startX) { // 向左滑动
						if (++index >= pageCount)// 为第一页时可向左滑动
							index=0;

						display();
					}

					break;
			}

			return false;
		}

	};

	final  TextWatcher mTxtWatcher= new TextWatcher() {

		public void onTextChanged(CharSequence s, int start, int before, int count) {


		}

		public void afterTextChanged(Editable s) {

			/*
			mBtnOk.setText("物料信息加载");

			getDataTrunsfer().clearReceiveData();
			downGoods.initGoodsList();
			*/
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
									  int after) {
			// TODO Auto-generated method stub

		}
	};


	final OnItemClickListener onItemClick= new OnItemClickListener() {

		public void onItemClick(AdapterView<?> parent, View view,
								int position, long id) {

			Bitmap[] szBitmap=getSzBitmap();
			if(szBitmap!=null)
			{
//
				Intent intent=new Intent(YPQuery.this,XYImgActivity.class);  //XYImageView  现在更高效代码更简洁
				ActivityHelper.szBitmaps=szBitmap;
				//  intent.putExtra("bitmaps", szBitmap);
				intent.putExtra("imgIndex", position);
				intent.putExtra("module", 0);
				startActivity(intent);
				overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
			}

		}
	};


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

				strBarcode=ActivityHelper.resolveBarcode(strRst);
				txtOutNotifyId.setText(strBarcode);

				onLoadYPInfo();
			}
		}
		else
		{}
	}

	public void onOfflineCheck()
	{
		LayoutParams parm=new LayoutParams();


		LinearLayout layDownload=(LinearLayout)this.findViewById(R.id.layDownload);
		if(mCheckOffLine.isChecked())
		{
			layDownload.setVisibility(View.VISIBLE);
		}
		else
		{
			layDownload.setVisibility(View.GONE);
		}


		HashMap<String,String> mapParms=new HashMap<String,String>();
		mapParms.put("isOffLine", mCheckOffLine.isChecked()?"1":"0");
		ActivityHelper.saveParams(this,mapParms);
	}

	public void onDownloadBatchYP()
	{
		new AlertDialog.Builder(this).setTitle("注意：下载之前会清空原来的样品信息，您确定下载吗？")
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作

						downBatchValue.clearYpInfo();
						SendParam sendParam=new SendParam();
						sendParam.parent=YPQuery.this;
						sendParam.tip="等待服务器响应...";
						sendParam.processor=downField;
						sendParam.szData=new String[]{"",BaseActivity.gUser.getUserName()};
						getDataTrunsfer().request(sendParam);
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
	}

	public void onNext()
	{
		strBarcode=txtOutNotifyId.getText().toString().trim();

		if(strBarcode.equals(""))
		{
			ActivityHelper.showDialog(this, "", getString(R.string.isNUll));
			return;
		}

		ActivityHelper.hidesofeKeyboard(this);

		if(!mCheckOffLine.isChecked())
			onLoadYPInfo();
		else
		{
			downBatchValue.displayYPInfo(strBarcode);
		}

	}


	public void display()
	{
		pageCount=downValue.displayInfo(index);

		if(pageCount>0){
			tvImgList.setVisibility(View.VISIBLE);
		}else{
			tvImgList.setVisibility(View.GONE);
		}
		if(pageCount>0)
			tvPage.setText("("+(index+1)+"/"+pageCount+")");
		else
			tvPage.setText("(0/0)");

	}

	public void onLoadYPInfo()
	{
		if(downValue.downYPInfo.mDao.GetYPInfoById(strBarcode).size()>0)
		{
			downValue.deleteOldData(strBarcode);
		}

		//ActivityHelper.recycleBitmaps(this.getSzBitmap());
		if(BaseActivity.gUser!=null)
		{
			SendParam sendParam=new SendParam();
			sendParam.parent=YPQuery.this;
			sendParam.processor=downField;
			sendParam.szData=new String[]{strBarcode,BaseActivity.gUser.getUserName()};
			getDataTrunsfer().request(sendParam);
			ActivityHelper.bQueryYP=1;
		}
	}


	@Override
	public void processMessage(int msgId, String msg) {

		if(msgId==0)
		{
			if(this.mCheckOffLine.isChecked())
			{
				downBatchValue.setFieldList(downField.GetFieldList());
				SendParam sendParam=new SendParam();
				sendParam.parent=YPQuery.this;
				sendParam.tip="下载中...";
				sendParam.processor=downBatchValue;
				sendParam.szData=new String[]{BaseActivity.gUser.getUserName()};
				getDataTrunsfer().request(sendParam);

			}
			else
			{
				downValue.downYPInfo.setFieldList(downField.GetFieldList());

				SendParam sendParam=new SendParam();
				sendParam.parent=YPQuery.this;
				sendParam.tip=getString(R.string.YPQuerying);
				sendParam.processor=downValue.downYPInfo;
				sendParam.szData=new String[]{strBarcode,BaseActivity.gUser.getUserName()};
				getDataTrunsfer().request(sendParam);
			}
		}
		else
		{
			downValue.setNewQuery(true);
			display();
			txtOutNotifyId.setText("");
			strBarcode="";
		}
	}

}
