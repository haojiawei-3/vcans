package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.example.qr_codescan.MipcaActivityCapture;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.YPDownFieldProcessor;
import com.vcans.Processor.YPDownYpInfoProcessor;
import com.vcans.Processor.YPImageUploadProcessorV2;
import com.vcans.dao.YPInfoDao;
import com.vcans.model.BandleParam;
import com.vcans.model.SendParam;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

/**
 *  样品图片
 *
 * @author vcans
 *
 */
public class YPBarcodeImage extends BaseActivity {
	private static final int REPALCE_PHOTO_CODE = 1;
	// private XYBarcodeProcessor mXyBarcodeProce;
	private YPImageUploadProcessorV2 mXyBarcodeimgProce;
	private YPDownYpInfoProcessor downYpInfo = new YPDownYpInfoProcessor(YPInfoDao.DbType.YP_IMAGE);
	private YPDownFieldProcessor downField = new YPDownFieldProcessor();;

	private int mLastClickId = -1;
	private long mLastClickTime = 5000;
	private EditText txtBarcode;
	private TextView tvPage;
	private ListView mListView;
	private Button btnPhoto;
	private String mstrBarcode = "";
	private String filePaths;
	private List<HashMap<String, Object>> mDataList = new ArrayList<HashMap<String, Object>>();
	int testCount=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yp_barcode_image);

		this.<TextView> RegOnClickEvent(R.id.btnPhoto, "onReplacePhoto");
		this.<TextView> RegOnClickEvent(R.id.imgBtnPhoto, "onReplacePhoto");
		this.<Button> RegOnClickEvent(R.id.btnOk, "SendCustomerAndBarCode");
		this.<Button> RegOnClickEvent(R.id.imgBtnOk, "SendCustomerAndBarCode");
		this.<TextView> RegOnClickEvent(R.id.tvClear, "clearData");
		this.<Button> RegOnClickEvent(R.id.BtnDelete, "onDelete");
		this.<TextView> RegOnClickEvent(R.id.btnScanBarcode, "onOpenScan");
		this.<TextView> RegOnClickEvent(R.id.btnLoadYP, "onLoadYpInfo");
		this.<TextView> RegOnClickEvent(R.id.imgBtnLoadYP, "onLoadYpInfo");
		this.<TextView> RegOnClickEvent(R.id.btnBack, "finish");
		this.setListItemClickMethod("onGoodsItemClick", "onGoodsItemDbClick");

		//查询
		ImageButton imgBtnLoadYP= (ImageButton) findViewById(R.id.imgBtnLoadYP);
		imgBtnLoadYP.setImageResource(R.drawable.query_yp);
		setImageSpapeColor(imgBtnLoadYP, ActivityHelper.globalSysParam.sysSkin.selectedColor);

		//替换
		ImageButton imtBtnPhoto= (ImageButton) findViewById(R.id.imgBtnPhoto);
		imtBtnPhoto.setImageResource(R.drawable.replace_img);
		setImageSpapeColor(imtBtnPhoto, ActivityHelper.globalSysParam.sysSkin.selectedColor);

		//上传
		Button btnOk= (Button) findViewById(R.id.btnOk);
		btnOk.setText(getString(R.string.btn_upload));
		ImageButton imtBtnOk= (ImageButton) findViewById(R.id.imgBtnOk);
		imtBtnOk.setImageResource(R.drawable.upload);


		txtBarcode = (EditText) this.findViewById(R.id.txtBarcode);
		mListView = (ListView) this.findViewById(R.id.lvProdct);
		tvPage = (TextView) findViewById(R.id.tvPage);
		btnPhoto = (Button) findViewById(R.id.btnPhoto);
		// txtBarcode.addTextChangedListener(mTxtWatcher);

		this.<Button> RegOnClickEvent(R.id.BtnDelete, "onDelete");

		mXyBarcodeimgProce = new YPImageUploadProcessorV2();
		mXyBarcodeimgProce.setOnTouchListener(onTouchListener);
		mXyBarcodeimgProce.DisplayTouPeiInfo();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		// mXyBarcodeimgProce.DisplayTouPeiInfo();

		super.onResume();
	}

	final public OnTouchListener onTouchListener = new OnTouchListener() {

		public boolean onTouch(View v, MotionEvent event) {

			switch (event.getAction()) {

				case MotionEvent.ACTION_UP:

					int position = v.getId();
					// TODO Auto-generated method stub

					// 如果是双击,1秒内连续点击判断为双击
					if (position == mLastClickId
							&& (Math.abs(mLastClickTime
							- System.currentTimeMillis()) < 1000)) {
						mLastClickId = -1;
						mLastClickTime = 0;

						onReplacePhoto(position);
					} else {

						mLastClickId = position;
						mLastClickTime = System.currentTimeMillis();

						mXyBarcodeimgProce.getCommentAdapter().setSelectIndex(position);
						mXyBarcodeimgProce.getCommentAdapter().notifyDataSetChanged();

						HashMap<String, Object> mapToupei = (HashMap<String, Object>) mListView.getItemAtPosition(position);
						mDataList.clear();
						mDataList.add(mapToupei);
						mstrDataId = (String) mapToupei.get("TPId");
						mstrBarcode = (String) mapToupei.get("Barcode");
						filePaths = (String) mapToupei.get("YPValue");
						String[] szStr = tvPage.getText().toString().split("/");
						tvPage.setText("(" + (position + 1) + "/" + szStr[1]);

					}
				default:
					break;
			}

			return false;
		}
	};

	public void onGoodsItemClick(int index) {
		// 获得选中项的HashMap对象
		HashMap<String, Object> mapToupei = (HashMap<String, Object>) mListView.getItemAtPosition(index);
		mDataList.clear();
		mDataList.add(mapToupei);
		mstrDataId = (String) mapToupei.get("TPId");
		mstrBarcode = (String) mapToupei.get("Barcode");
		filePaths = (String) mapToupei.get("YPValue");
		String[] szStr = tvPage.getText().toString().split("/");
		tvPage.setText("(" + (index + 1) + "/" + szStr[1]);
	}

	public void onGoodsItemDbClick(int index) {

		onReplacePhoto(index);
	}

	public void onReplacePhoto(int index) {
		if (mstrBarcode.equals("")) {
			ActivityHelper.showDialog(this, "", getString(R.string.noSelected));
			return;
		}

		List<List<HashMap<String, Object>>> listList = this.mXyBarcodeimgProce.getList_comment_child();
		BandleParam param = new BandleParam();

		List<HashMap<String, Object>> myList = new ArrayList<HashMap<String, Object>>();

		for (List<HashMap<String, Object>> mapList : listList) {
			if (mapList.get(0).get("Barcode").equals(mstrBarcode)) {

				// 过滤"图片"key
				for (int i = 0; i < mapList.size() - 1; ++i)
					myList.add(mapList.get(i));

				param.dataList = myList;
				break;
			}
		}

		param.other = mXyBarcodeimgProce.getList_comment_child().get(index).get(mXyBarcodeimgProce.getList_comment_child().get(index).size()-1).get("YPValue");   //有问题

		this.setMTitle(getString(R.string.imageWatchReplace), R.id.tvActtitle);
		Intent intent = new Intent(this, YPImageReplace.class);

		intent.putExtra("data", param);
		this.startActivityForResult(intent, REPALCE_PHOTO_CODE);
	}

	final TextWatcher mTxtWatcher = new TextWatcher() {

		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			if (!mTxtWatcher.toString().trim().equals("")) {
				// btnPhoto.setText("拍照");
				// nIsRePhotoFlag=0;
			}
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
									  int after) {
			// TODO Auto-generated method stub

		}

		public void onTextChanged(CharSequence s, int start, int before,
								  int count) {
			// TODO Auto-generated method stub

		}

	};

	public void onDelete() {
		if (mListView.getCount() < 1) {
			return;
		}

		if (mstrBarcode.equals("")) {
			ActivityHelper.showDialog(this, "错误",getString(R.string.noSelected));
			return;
		}

		new AlertDialog.Builder(this).setTitle(getString(R.string.askDelete))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						if (!mstrDataId.equals("")) {
							mXyBarcodeimgProce.DeleteToupeiInfo(mstrBarcode);
							mXyBarcodeimgProce.DisplayTouPeiInfo();
							mstrDataId = "";
						}
					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
	}

	public void clearData() {
		if (mListView.getCount() < 1) {
			return;
		}

		new AlertDialog.Builder(this).setTitle(getString(R.string.askClear))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						mXyBarcodeimgProce.ClearToupeiInfo();
						mXyBarcodeimgProce.DisplayTouPeiInfo();

					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
	}

	public void onLoadYpInfo() {
		String strBarcdoe = txtBarcode.getText().toString().trim();

		if (strBarcdoe.equals("")) {
			ActivityHelper.showDialog(this, "错误", getString(R.string.isNUll));
			return;
		}


		YPExpInfo ypInfo = new YPExpInfo();
		ypInfo.strBarcode = strBarcdoe;

		if (downYpInfo.mDao.GetSCToupei(ypInfo) != null) {
			ActivityHelper.showDialog(this, "提示", getString(R.string.datareplace));
			return;
		}

		//if(BaseActivity.bConnected&&BaseActivity.gUser!=null)
		if(BaseActivity.gUser!=null)
		{
			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.tip = getString(R.string.YPQuerying);
			sendParam.processor = downField;
			sendParam.szData=new String[]{strBarcdoe,BaseActivity.gUser.getUserName()};
			this.getDataTrunsfer().request(sendParam);
		}
		else
		{
			//获取设置的参数  放在createDataTrunsfer之前，设置是否加密数据
			int nPreImageNum=0;

			HashMap<String,String> mapParms=ActivityHelper.getParams(this,
					new String[]{"preImageNum"});
			if(mapParms.get("preImageNum").equals("")||mapParms.get("preImageNum").equals("0"))
				nPreImageNum=8;//离线模式查询样品时，未记录上一次的图片数量时默认为8张
			else
				nPreImageNum=Integer.parseInt(mapParms.get("preImageNum"));


			int r1=0;
			if(nPreImageNum>0)
			{
				ypInfo.strYPField=getString(R.string.image);

				String strSplit="";
				for(int i=0;i<nPreImageNum;i++)
					strSplit+=";";

				ypInfo.strYPValue=strSplit;

				r1=mXyBarcodeimgProce.mSCToupeiDao.AddToupei(ypInfo);
			}


			ypInfo.strYPField=getString(R.string.barcode);
			ypInfo.strYPValue=strBarcdoe;
			int r2=mXyBarcodeimgProce.mSCToupeiDao.AddToupei(ypInfo);

			if(r1>0||r2>0)
			{
				ActivityHelper.showDialog(this,"提示",getString(R.string.saveSuccess));
				mXyBarcodeimgProce.DisplayTouPeiInfo();
			}
		}

		mstrBarcode = strBarcdoe;
		ActivityHelper.hidesofeKeyboard(this);
	}





	public void onOpenScan() {
		Intent intent = new Intent();
		intent.setClass(this, MipcaActivityCapture.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivityForResult(intent, REQUEST_SCAN_QRCODE_FLAG);
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

	public void SendCustomerAndBarCode() {

		if(!getUserPower(2)) return; //2为样品图片模块索引号  索引了解见DPMenuProcessor

		ListView listView = (ListView) findViewById(R.id.lvProdct);

		if (listView.getCount() < 1) {
			ActivityHelper.showDialog(this, "错误", getString(R.string.noData));
			return;
		}


		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.processor = mXyBarcodeimgProce;
		this.getDataTrunsfer().beginUploadFile(sendParam);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == REQUEST_SCAN_QRCODE_FLAG) {// 条码扫描完毕返回
			if (resultCode == Activity.RESULT_OK) {
				Bundle bundle = data.getExtras();
				String strRst = bundle.getString("result");
				strRst = ActivityHelper.resolveBarcode(strRst);
				txtBarcode.setText(strRst);

				onLoadYpInfo();
			}
		} else if (requestCode == REPALCE_PHOTO_CODE) {
			if (resultCode == Activity.RESULT_OK) {

				// mListView.invalidate();
				new Handler().postDelayed(new Runnable() {

					public void run() {
						// TODO Auto-generated method stub
						mXyBarcodeimgProce.DisplayTouPeiInfo();
						filePaths=mXyBarcodeimgProce.filePaths();
					}

				}, 500);
			}
		} else {
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		ActivityHelper.recycleBitmaps(this.getSzBitmap());
		super.onDestroy();
	}

	@Override
	public void processMessage(int msgId, String msg) {
		/*
		 * if(msgId!=0) {//处理此消息，主要是为了调用 显示的方法。YPDownYpInfoProcessor类中调用
		 * mXyBarcodeimgProce.DisplayTouPeiInfo(); mFileName="";
		 * txtBarcode.setText(""); // bitmaps=null; } else {
		 * setListItemClick(R.id.lvProdct); filepaths=""; }
		 */

		if (msgId == 1) {// 处理此消息，主要是为了调用 显示的方法。YPDownYpInfoProcessor类中调用
			mXyBarcodeimgProce.DisplayTouPeiInfo();

			txtBarcode.setText("");
			if(++testCount<=5)
			{
				//txtBarcode.setText(""+testCount);
				//onLoadYpInfo();
			}
			// bitmaps=null;
		} else if (msgId == 0) {
			downYpInfo.setFieldList(downField.GetFieldList());

			String strBarcdoe = txtBarcode.getText().toString().trim();
			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.tip = getString(R.string.YPQuerying);
			sendParam.processor = downYpInfo;
			sendParam.szData = new String[] { strBarcdoe,BaseActivity.gUser.getUserName()};
			getDataTrunsfer().request(sendParam);
		}
		else  if (msgId == 123)
		{

		}
		else {
			// setListItemClick(R.id.lvProdct);
			// mstrBarcode="";
			mstrBarcode = "";
		}

	}
}
