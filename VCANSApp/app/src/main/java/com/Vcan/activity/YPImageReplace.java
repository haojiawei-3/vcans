package com.Vcan.activity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.Vcan.activity.R;
import com.example.qr_codescan.MipcaActivityCapture;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.YPDownYpInfoProcessor;
import com.vcans.Processor.YPImageUploadProcessorV2;
import com.vcans.adapter.HorizontalAdapter;
import com.vcans.adapter.HorizontalListView;
import com.vcans.model.BandleParam;
import com.vcans.model.SendParam;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.CameraTool;
import com.vcans.tool.PlProcessor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TableLayout.LayoutParams;

/**
 * 条码与图片采集
 *
 * @author vcans
 *
 */
public class YPImageReplace extends BaseActivity {
	private static final int REQUEST_CODE = 2;
	private static final int PHOTO_PICKED_WITH_DATA = 3;
	private TextView tvPage;
	private ListView mListView;
	private Bitmap[] bitmaps = null;
	private String filepaths = "";
	private HorizontalListView hListView;
	private YPImageUploadProcessorV2 mXyBarcodeimgProce = new YPImageUploadProcessorV2();
	private int imgIndex = -1;
	private List<HashMap<String, Object>> mDataList = new ArrayList<HashMap<String, Object>>();
	private int mLastClickId = -1;
	private long mLastClickTime = 0;
	private boolean bReReplace = false;
	private String mFileName = "";
	private String mPreFileNameCut = "";//截图前的图片路径
	private final int REQUEST_PHOTO_FLAG = 1;
	BandleParam param;
	String barcode;
	HorizontalAdapter hListViewAdapter;
	private int refreshFlag = 0;
	private boolean bImageViewReplace = false;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yp_image_replace);

		this.<TextView> RegOnClickEvent(R.id.btnBack, "finish");
		this.setListItemClickMethod("onGoodsItemClick", "onGoodsItemDbClick");
		this.<TextView> RegOnClickEvent(R.id.btnReplace, "onReplaceOne");
		this.<TextView> RegOnClickEvent(R.id.btnReReplace, "onReReplace");
		this.<Button> RegOnClickEvent(R.id.btnBrowse, "onBrowse");

		this.<TextView> RegOnClickEvent(R.id.imgBtnReReplace, "onReReplace");
		this.<TextView> RegOnClickEvent(R.id.imgBtnReplace, "onReplaceOne");
		this.<Button> RegOnClickEvent(R.id.imgBtnBrowse, "onBrowse");

		//连续替换
		ImageButton imgBtnReReplace= (ImageButton) findViewById(R.id.imgBtnReReplace);
		imgBtnReReplace.setImageResource(R.drawable.re_replace);
		setImageSpapeColor(imgBtnReReplace, ActivityHelper.globalSysParam.sysSkin.selectedColor);

		//替换当前
		ImageButton imtBtnReplace= (ImageButton) findViewById(R.id.imgBtnReplace);
		imtBtnReplace.setImageResource(R.drawable.replace_img);
		setImageSpapeColor(imtBtnReplace, ActivityHelper.globalSysParam.sysSkin.selectedColor);

		//浏览图片
		ImageButton imtBtnBrowse= (ImageButton) findViewById(R.id.imgBtnBrowse);
		imtBtnBrowse.setImageResource(R.drawable.browser);
		setImageSpapeColor(imtBtnBrowse, ActivityHelper.globalSysParam.sysSkin.selectedColor);

		mListView = (ListView) this.findViewById(R.id.lvProdct);
		tvPage = (TextView) findViewById(R.id.tvPage);
		tvPage.setVisibility(View.INVISIBLE);
		hListView = (HorizontalListView) findViewById(R.id.horizon_listview);
		hListView.setOnItemClickListener(onItemClick);
		hListView.setOnItemLongClickListener(onLongClick);

		Intent intent = this.getIntent();
		param = (BandleParam) intent.getSerializableExtra("data");
		this.filepaths = (String) param.other;
		barcode = (String) param.dataList.get(0).get("Barcode");

		showData();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {

		// 其实这里什么都不要做
		super.onConfigurationChanged(newConfig);
	}

	public void onBrowse() {
		if (imgIndex == -1)
			imgIndex = 0;

		Intent intent = new Intent(YPImageReplace.this, XYImgActivity.class);  //XYImageView  替换
		// intent.putExtra("bitmaps", bitmaps);
		ActivityHelper.szBitmaps = bitmaps;
		intent.putExtra("imgIndex", imgIndex);
		intent.putExtra("filepaths", filepaths);
		intent.putExtra("module", 1);
		this.startActivityForResult(intent, REQUEST_CODE);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
	}

	final OnItemClickListener onItemClick = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> parent, View view, int position,
								long id) {

			if (bitmaps != null) {
				// 如果是双击,1秒内连续点击判断为双击
				if (position == mLastClickId&& (Math.abs(mLastClickTime- System.currentTimeMillis()) < 1000)) {
					mLastClickId = -1;
					mLastClickTime = 0;
					imgIndex = position;
					// byte[]
					// imgByte=ActivityHelper.BitmapToByteArray(bitmaps[position],
					// Bitmap.CompressFormat.JPEG);
					// BandleParam bdParam=new BandleParam();
					// bdParam.byteArrayList.add(imgByte);
					onBrowse();
				} else {

					mLastClickId = position;
					hListViewAdapter.setSelectIndex(position);
					hListViewAdapter.notifyDataSetChanged();
					mLastClickTime = System.currentTimeMillis();
					imgIndex = position;
				}
			}
		}
	};

	final OnItemLongClickListener onLongClick = new OnItemLongClickListener() {

		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
									   int position, long arg3) {
			// TODO Auto-generated method stub

			imgIndex = position;
			onReplaceOne();

			return true;
		}

	};

	public void onReplaceOne() {
		bReReplace = false;
		onBtnPhotoClick();
	}

	public void onReReplace() {
		imgIndex = 0;
		bReReplace = true;
		onBtnPhotoClick();
	}

	public void showData() {
		if (filepaths == null || filepaths.equals("")) {
			ActivityHelper.showDialog(this, "错误", getString(R.string.noSelected));
			return;
		}

		ActivityHelper.recycleBitmaps(bitmaps);
		bitmaps = YPDownYpInfoProcessor.getBitmapsByFilepaths(filepaths);

		if (bitmaps != null) {
			hListViewAdapter = new HorizontalAdapter(getApplicationContext(),null, bitmaps);
			hListView.setAdapter(hListViewAdapter);

			String[] szField = { "YPField", "YPValue" };
			int[] szRId = { R.id.tvField, R.id.tvValue };

			param.szFieldData = szField;
			param.szRId = szRId;
			param.itemRId = R.layout.yp_info_item;
			param.listRId = R.id.lvProdct;
			param.pageRId = R.id.tvPage;

			this.showList(param);
		}

	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub

		onQuit();
		// ActivityHelper.recycleBitmaps(bitmaps);
		super.finish();
	}

	public void onQuit() {
		// this.setMTitle("样品图片", R.id.tvActtitle);
		// Intent intent = new Intent(this, YPBarcodeImage.class);
		// startActivity(intent);
		Intent resultIntent = new Intent();
		this.setResult(refreshFlag, resultIntent);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		ActivityHelper.recycleBitmaps(this.getSzBitmap());
		super.onDestroy();
	}

	public void onCutPhoto(Bitmap data) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setType("image/*");
		intent.putExtra("data", data);
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", 128);
		intent.putExtra("outputY", 128);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, PHOTO_PICKED_WITH_DATA);
	}


	public void onBtnPhotoClick() {
		if (this.imgIndex < 0) {
			ActivityHelper.showDialog(this, "", getString(R.string.imagenotSelected));
			return;
		}
		String strFilePath = ActivityHelper.getFilePathNoName();

		if (strFilePath != null) {
			SimpleDateFormat sDateFormat = new SimpleDateFormat(
					"yyyyMMddhhmmss");
			String date = sDateFormat.format(new java.util.Date());

			mFileName = strFilePath + "/image/i" + date + ".jpg";

			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			Uri imageUri = Uri.fromFile(new File(mFileName));
			intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
			startActivityForResult(intent, REQUEST_PHOTO_FLAG);
		} else {
			ActivityHelper.showDialog(this, "错误", getString(R.string.noPath));
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == REQUEST_PHOTO_FLAG) {
			if (resultCode == Activity.RESULT_OK) {
				if (ActivityHelper.bCutPhoto) {


					mPreFileNameCut=mFileName;
					mFileName=CameraTool.cropImageUri(this,Uri.fromFile(new File(mPreFileNameCut)), PHOTO_PICKED_WITH_DATA);
					//ActivityHelper.recycleBitmaps(new Bitmap[] { bitmap });
				} else
					this.updateImage();
			}
		} else if (requestCode == PHOTO_PICKED_WITH_DATA) {

			if(!mPreFileNameCut.equals(""))
			{
				File file=new  File(mPreFileNameCut);
				file.delete();
				mPreFileNameCut="";
			}

			this.updateImage();
		} else if (requestCode == REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {
				imgIndex = data.getIntExtra("imgIndex", 0);
				bImageViewReplace = true;
				onBtnPhotoClick();
			}
		}

	}

	public void updateImage() {
		if (mFileName != null) {
			File file = new File(mFileName);

			if (file.exists()) {


				YPExpInfo ypExpInfo = new YPExpInfo();
				ypExpInfo.strBarcode = barcode;
				ypExpInfo.strImgName = mFileName;
				ypExpInfo.imgIndex = imgIndex;
				ypExpInfo.strFiles = this.filepaths;

				int rst = mXyBarcodeimgProce.updatePhoto(ypExpInfo);

				if (rst == 1) {
					this.filepaths = ypExpInfo.strFiles;
					this.refreshFlag = RESULT_OK;
					this.showData();

					if (!this.bImageViewReplace) {
						if (this.bReReplace) {
							String[] szFilePath = ActivityHelper.mySplit(filepaths, ";");
							if ((++imgIndex) < szFilePath.length) {
								new Handler().postDelayed(new Runnable() {

									public void run() {

										onBtnPhotoClick();
									}
								}, 1200);

							} else {
								this.imgIndex = -1;
							}
						} else {
							this.imgIndex = -1;
						}
					} else {
						bImageViewReplace = false;
						onBrowse();
					}
				}

			}// end file exists
		}
	}

	@Override
	public void processMessage(int msgId, String msg) {

	}
}
