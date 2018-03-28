package com.Vcan.activity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;

import cn.sharp.android.ncr.StaticRecFromCamera;

import com.Vcan.activity.R;
import com.example.qr_codescan.MipcaActivityCapture;
import com.vcans.Processor.BaseActivity;
import com.vcans.dao.YPExpositionDao;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.CameraTool;
import com.vcans.tool.ColorUtil;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
/**
 *  展会询样
 * @param index
 */
public class YPExposition extends BaseActivity {
	//public static YPExposition exposition = null;
	private String mFileName = "";
	private String mPreFileNameCut;//用于删除旧的剪切的图片，为了兼容所有机型，因为有些机型在覆盖旧图片时会报错（如：摩托罗拉）。
	private final int REQUEST_PHOTO_FLAG = 1;
	private static final int PHOTO_PICKED_WITH_DATA = 3;
	private EditText txtCusBarcode;
	private CheckBox chkCusName;
	private CheckBox chkCusPhoto;
	private CheckBox mpsm;
	private CheckBox chkNum;
	private CheckBox chkPrice;
	private CheckBox chkAutoScan;
	private ImageView imgCusCard,imgCusCardd;
	private LinearLayout layCusName;
	private HashMap<String, String> mapParms;
	private String[] paramKeys;
	private Bundle bundle = new Bundle();
	private Dialog mDialog = null;
	private HashMap<EditText, String> mapTxt = new HashMap<EditText, String>();
	private EditText txtCusName;
	private YPExpositionDao expositionDao = new YPExpositionDao();
	private boolean bOpenCamera=false;
	String addname;
	ImageView view;
	String name,company;
	String result;
	Intent intent;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yp_exposition);
		// exposition=this;
		this.<Button> RegOnClickEvent(R.id.btnBack, "finishh");
		this.<Button> RegOnClickEvent(R.id.btnOk, "onNext");
		this.<Button> RegOnClickEvent(R.id.imgBtnOk, "onNext");
		this.<Button> RegOnClickEvent(R.id.btnSave, "onSet");
		this.<Button> RegOnClickEvent(R.id.imgBtnSave, "onSet");
		this.<Button> RegOnClickEvent(R.id.btnScanBarcode, "OnScanBarcode");
		this.<ImageView> RegOnClickEvent(R.id.imgCusCard, "onCusPhotoo");//拍照
		this.<ImageView> RegOnClickEvent(R.id.imgCusCardd, "onCusPhoto");//扫描
		ImageButton imgBtnSet = (ImageButton) this.findViewById(R.id.imgBtnSave);
		imgBtnSet.setImageResource(R.drawable.exp_set);
		Button btnSet = (Button) this.findViewById(R.id.btnSave);
		btnSet.setText(getString(R.string.set));
		ImageView imgCard = (ImageView) this.findViewById(R.id.imgCusCard);

		txtCusBarcode = (EditText) this.findViewById(R.id.txtCusBarcode);
		txtCusName = (EditText) this.findViewById(R.id.txtCusName);
		chkCusName = (CheckBox) this.findViewById(R.id.chkCusName);
		chkCusPhoto = (CheckBox) this.findViewById(R.id.chkCusPhoto);
		mpsm = (CheckBox) this.findViewById(R.id.chkCusmpsm);

		layCusName = (LinearLayout) this.findViewById(R.id.layCusName);
		imgCusCard = (ImageView) this.findViewById(R.id.imgCusCard);
		imgCusCardd = (ImageView) this.findViewById(R.id.imgCusCardd);
		txtCusBarcode.addTextChangedListener(onTextChange);


		configuration();
		/**
		 * 得到
		 */
		intent=this.getIntent();
		name = (String)intent.getSerializableExtra("name");
		String company = (String)intent.getSerializableExtra("company");
		String code = (String)intent.getSerializableExtra("code");
		Log.e("TAG", "图片地址是shi："+name+"客户简称"+company+code);
		if (name!=null) {
			tupian();
			txtCusBarcode.setText(code);
			txtCusName.setText(company);
		} else {

		}
	}



	@Override
	protected void onResume() {

		super.onResume();
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.e("TAG", "onPause");
		super.onPause();
	}



	@Override
	protected void onRestart() {
		Log.e("TAG", "onRestart");
		super.onRestart();
	}



	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.e("TAG", "onStop");
		super.onStop();
	}



	@Override
	public void finish() {
		// TODO Auto-generated method stub
		if(!ActivityHelper.savedImagePath.contains(mFileName))
		{
			File file=new File(mFileName);
			if(file.exists()) file.delete();
		}

		super.finish();
	}
	public void finishh() {
		// TODO Auto-generated method stub
		finish();
	}

	public void OnScanBarcode()
	{
		bOpenCamera=true;
		onOpenScanBarcode();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}



	@Override
	protected void onStart() {

		super.onStart();
		Log.e("TAG", "onStart");
	}



	//名片识别
	public void onCusPhoto() {
		Intent intent = new Intent(this,StaticRecFromCamera.class);
		intent.putExtra("id","1");
		// intent.putExtra("name",name);
		startActivity(intent);
		finish();
	}



	public void onCusPhotoo() {
		if(txtCusBarcode.getText().toString().trim().equals(""))
		{
			ActivityHelper.ToastShow(this, getString(R.string.isNUll));
			return;
		}
		onBtnPhotoClick();
	}



	public void onBtnPhotoClick() {
		String strFilePath = ActivityHelper.getFilePathNoName();

		if (strFilePath != null) {
			SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
			String date = sDateFormat.format(new java.util.Date());


			if(!ActivityHelper.savedImagePath.contains(mFileName))
			{
				File file=new File(mFileName);
				if(file.exists()) file.delete();
			}

			mFileName = strFilePath + "/image/i" + date + ".jpg";

			bOpenCamera=true;
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			intent.putExtra(MediaStore.EXTRA_SCREEN_ORIENTATION, ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			intent.putExtra(MediaStore.EXTRA_SCREEN_ORIENTATION, ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
			Uri imageUri = Uri.fromFile(new File(mFileName));
			intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
			intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
			startActivityForResult(intent, REQUEST_PHOTO_FLAG);
		} else {
			ActivityHelper.showDialog(this, "错误", getString(R.string.noPath));
		}
	}


	public void onSet() {
		this.showInput();
	}



	private Handler mTextChangeHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			YPExpInfo param = new YPExpInfo();
			param.strCusBarcode = (String) msg.obj;
			YPExpInfo cusInfo = expositionDao.GetCusInfo(param);

			if (cusInfo != null) {
				ActivityHelper.ToastShow(YPExposition.this, getString(R.string.datareplace)+" ["
						+ param.strCusBarcode + "]");
				txtCusName.setText(cusInfo.strCusName);
				String imgName = cusInfo.strImgName.substring(0,
						cusInfo.strImgName.length() - 1);

				//if (!imgName.equals(mFileName)) {
				ActivityHelper.gToupei.strFilePath = imgName;
				//displayImage(ActivityHelper.fileToBitmap(imgName));

				//}
			} else {
				//ActivityHelper.gToupei.strFilePath = "";
				//txtCusName.setText("");
				//displayImage(null);
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
			// TODO Auto-generated method stub
			String text = s.toString().trim();
			if (!text.equals("")) {
				Message msg = new Message();
				msg.what = 1;
				msg.obj = text;
				mTextChangeHandler.removeMessages(1);
				mTextChangeHandler.sendMessageDelayed(msg, 500);
			} else {
				//ActivityHelper.gToupei.strFilePath = "";
				//txtCusName.setText("");
				//displayImage(null);
			}
		}

	};
	/**
	 * 保存配置设置
	 */
	public void configuration(){
		paramKeys = new String[] { "isInputCusName", "isInputCusPhoto","isInputCusmpsm",
				"isAutoScan", "isInputPrice", "isInputNum" };
		mapParms = ActivityHelper.getParams(this, paramKeys);

		boolean bSet = false;
		if (mapParms.size() > 0) {
			bundle.clear();
			for (String key : paramKeys) {
				if (!mapParms.get(key).equals("")) {
					bSet = true;
					// break;
				}

				// bundle.putString(key, mapParms.get(key));
			}

			if (!mapParms.get("isInputCusName").equals("1")) {
				LayoutParams params = new LayoutParams();
				params.height = 0;
				layCusName.setLayoutParams(params);
				layCusName.setVisibility(View.INVISIBLE);
			}

			if (!mapParms.get("isInputCusPhoto").equals("1")) {
				LayoutParams params = new LayoutParams();
				params.height = 0;
				imgCusCard.setLayoutParams(params);
				imgCusCard.setVisibility(View.INVISIBLE);
			}
			if (!mapParms.get("isInputCusmpsm").equals("1")) {
				LayoutParams params = new LayoutParams();
				params.height = 0;
				imgCusCardd.setLayoutParams(params);
				imgCusCardd.setVisibility(View.INVISIBLE);
			}
		}

		if (!bSet)
			this.showInput();

	}



	public void tupian() {
		// TODO Auto-generated method stub
		view = (ImageView)findViewById(R.id.imgCusCardd);
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 2;
		Bitmap bm = BitmapFactory.decodeFile(name, options);
		Log.e("TAG", "方法里的图片地址："+name+bm);
		//ActivityHelper.gToupei.strFilePath = name;
		view.setImageBitmap(bm);
	}

	public void tp() {
		// TODO Auto-generated method stub
		view = (ImageView)findViewById(R.id.imgCusCard);
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 5;
		Bitmap bm = BitmapFactory.decodeFile(mFileName, options);
		Log.e("TAG", "方法里的图片地址："+mFileName+bm);
		view.setImageBitmap(bm);
		ActivityHelper.showDialog(this, "", getString(R.string.nexting));
		new Handler().postDelayed(new Runnable() {

			public void run() {

				showExposition1();
			}
		}, 1200);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == REQUEST_PHOTO_FLAG) {
			if (resultCode == Activity.RESULT_OK) {
				if (ActivityHelper.bCutPhoto) {



					bOpenCamera=true;
					mPreFileNameCut=mFileName;
					mFileName=CameraTool.cropImageUri(this,Uri.fromFile(new File(mPreFileNameCut)), PHOTO_PICKED_WITH_DATA);
				} else
					intoNextActivity();
				//tp();
			}
		}else if (requestCode == PHOTO_PICKED_WITH_DATA) {

			if(!mPreFileNameCut.equals(""))
			{//删除旧的剪切的图片，为了兼容所有机型，因为有些机型在覆盖旧图片时会报错（如：摩托罗拉）。
				File file=new  File(mPreFileNameCut);
				file.delete();
				mPreFileNameCut="";
			}

			intoNextActivity();
			//tp();
		}
		else if (requestCode == REQUEST_SCAN_QRCODE_FLAG) {// 条码扫描完毕返回
			if (resultCode == Activity.RESULT_OK) {
				Bundle bundle = data.getExtras();
				String strRst = bundle.getString("result");
				// strRst=ActivityHelper.resolveBarcode(strRst);
				txtCusBarcode.setText(strRst);
			}
		} else {
		}
	}


	private void intoNextActivity()
	{
		if (mFileName != null) {
			File file = new File(mFileName);

			if (file.exists()) {

				Bitmap bitmap = ActivityHelper.fileToBitmap(mFileName);
				displayImage(bitmap);
				ActivityHelper.showDialog(this, "", getString(R.string.nexting));
				new Handler().postDelayed(new Runnable() {

					public void run() {

						showExposition1();
					}
				}, 1200);

			}
		}
	}



	public void displayImage(Bitmap bitmap) {

		LayoutParams params = new LayoutParams();

		if (bitmap == null) {
			params.height = LayoutParams.WRAP_CONTENT;
			imgCusCard.setLayoutParams(params);
			imgCusCard.setImageResource(R.drawable.contact_card);
		} else {
			params.height = 800;
			imgCusCard.setLayoutParams(params);

			bitmap = ActivityHelper.autoMatrixBitmap(mFileName, bitmap);
			int compressRatio=ActivityHelper.IMAGE_COMPRESS_RATIO;
			///bitmap=ThumbnailUtils.extractThumbnail(bitmap,bitmap.getWidth()*compressRatio,bitmap.getHeight()*compressRatio);
			imgCusCard.setImageBitmap(bitmap);

		}
	}



	public void showInput() {
		mDialog = new Dialog(this);
		mDialog.setTitle(getString(R.string.set));
		mDialog.setContentView(R.layout.yp_exp_dialog_setitem);

		Button btnOk = (Button) mDialog.findViewById(R.id.btnOk);
		btnOk.setOnClickListener(onOKListener);

		Button btnClose = (Button) mDialog.findViewById(R.id.btnClose);
		btnClose.setOnClickListener(onOKListener);

		this.chkCusName = (CheckBox) mDialog.findViewById(R.id.chkCusName);
		this.chkCusPhoto = (CheckBox) mDialog.findViewById(R.id.chkCusPhoto);
		this.mpsm = (CheckBox) mDialog.findViewById(R.id.chkCusmpsm);//
		this.chkPrice = (CheckBox) mDialog.findViewById(R.id.chkPrice);
		this.chkNum = (CheckBox) mDialog.findViewById(R.id.chkNum);
		this.chkAutoScan = (CheckBox) mDialog.findViewById(R.id.chkAutoScan);
		chkCusPhoto.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					ActivityHelper.showDialog(YPExposition.this, "", "客户名片和名片扫描不能双选");
					mpsm.setEnabled(false);
				}else{
					mpsm.setEnabled(true);
				}
			}
		});

		mpsm.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					ActivityHelper.showDialog(YPExposition.this, "", "客户名片和名片扫描不能双选");
					chkCusPhoto.setEnabled(false);
				}else{
					chkCusPhoto.setEnabled(true);
				}
			}
		});


		if (mapParms.size() > 0) {
			if (mapParms.get("isInputCusName").equals("1"))
				chkCusName.setChecked(true);
			else
				chkCusName.setChecked(false);

			if (mapParms.get("isInputCusPhoto").equals("1"))
				chkCusPhoto.setChecked(true);
			else
				chkCusPhoto.setChecked(false);

			if (mapParms.get("isInputCusmpsm").equals("1"))//
				mpsm.setChecked(true);
			else
				mpsm.setChecked(false);

			if (mapParms.get("isAutoScan").equals("1"))
				chkAutoScan.setChecked(true);
			else
				chkAutoScan.setChecked(false);

			if (mapParms.get("isInputPrice").equals("1"))
				chkPrice.setChecked(true);
			else
				chkPrice.setChecked(false);

			if (mapParms.get("isInputNum").equals("1"))
				chkNum.setChecked(true);
			else
				chkNum.setChecked(false);
		}

		mDialog.show();
	}

	final OnClickListener onOKListener = new OnClickListener() {

		public void onClick(View arg0) {

			if (arg0.getId() == R.id.btnOk) {
				HashMap<String, String> tMapParms = new HashMap<String, String>();
				tMapParms.put("isInputCusName", chkCusName.isChecked() ? "1": "0");
				tMapParms.put("isInputCusPhoto", chkCusPhoto.isChecked() ? "1": "0");
				tMapParms.put("isInputCusmpsm", mpsm.isChecked() ? "1": "0");//
				tMapParms.put("isAutoScan", chkAutoScan.isChecked() ? "1" : "0");
				tMapParms.put("isInputPrice", chkPrice.isChecked() ? "1" : "0");
				tMapParms.put("isInputNum", chkNum.isChecked() ? "1" : "0");
				ActivityHelper.saveParams(YPExposition.this, tMapParms);
				YPExposition.this.mapParms = tMapParms;

				ActivityHelper.ToastShow(YPExposition.this, getString(R.string.saveSuccess));
				new Handler().postDelayed(new Runnable() {

					public void run() {

						mDialog.dismiss();
						finish();
						Intent intent = new Intent(YPExposition.this,YPExposition.class);
						startActivity(intent);
						//overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
						overridePendingTransition(0,0);
					}
				}, 1000);

			} else if (arg0.getId() == R.id.btnClose) {
				mDialog.dismiss();
			}
		}

	};

	public void onNext() {
		String strCusBacode = txtCusBarcode.getText().toString().trim();

		if (strCusBacode.equals("")) {
			ActivityHelper.showDialog(this, "错误", getString(R.string.isNUll));
			return;
		}

		showExposition1();
	}

	private void showExposition1() {
		ActivityHelper.gToupei.strCusBarcode = this.txtCusBarcode.getText().toString().trim();
		ActivityHelper.gToupei.strCusName = txtCusName.getText().toString().trim();
		ActivityHelper.gToupei.strCusBarcode = txtCusBarcode.getText().toString().trim();
		if (name!=null) {
			ActivityHelper.gToupei.strFilePath = name;
		} else if(mFileName!=null){
			ActivityHelper.gToupei.strFilePath = mFileName;
		}

		Intent intent = new Intent(this, YPExposition1.class);

		if (mapParms.size() > 0) {
			bundle.clear();
			for (String key : paramKeys) {

				bundle.putString(key, mapParms.get(key));
			}
		}

		bOpenCamera=false;
		intent.putExtras(bundle);
		startActivity(intent);
	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
