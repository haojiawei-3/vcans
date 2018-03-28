package com.Vcan.activity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.GDBakModuleDownFZProcessor;
import com.vcans.model.GDDirectOutInfo;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.CameraTool;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.TableLayout.LayoutParams;

/**
 * 备用模块   有5个界面类 分别  GDBakModule GDBakModule1 GDBakModule2 GDBakModule3 GDBakModule4
 * @author vcans  //MC46H-JQR3C-2JRHY-XYRKY-QWPVM
 *
 */
public class GDBakModule extends BaseActivity {
	// public static GDBakModule bakModule = null;
	private static final int REQUEST_PHOTO_FLAG = 1;
	private static final int PHOTO_PICKED_WITH_DATA = 3;
	//备用编号关联关系
	public static HashMap<String ,String> mapBakModuleId=new HashMap<String,String>();
	public static String gBakFlag="";
	public static GDDirectOutInfo g_BakModuleInfo=new GDDirectOutInfo();
	private Spinner dropBakType;
	private Spinner dropFuZhuData1;
	private EditText txtDataItem1;
	private EditText txtDataItem2;
	private EditText txtDate;
	private boolean isDataItem1;
	private String mstrType="";
	private String mstrDataItem1="";
	private String mstrDataItem2="";
	private String mstrDate="";
	private ViewFlipper viewFlipper;
	private Dialog mDatedialog=null ;

	private String mFileName = "";
	private String mPreFileNameCut;//前一个剪切的图片，用于在保存新剪切图片之前，删除之前的剪切的图片
	private boolean bOpenCamera=false;
	private ImageView imgCusCard;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gd_bakmodule);
		// bakModule=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"onOpenScanBarcode1");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode2,"onOpenScanBarcode2");
		this.<Button>RegOnClickEvent(R.id.btnLoadFz1,"onLoadFZ1");
		this.<Button>RegOnClickEvent(R.id.imgCusCard,"onBtnPhotoClick");


		dropBakType=(Spinner)this.findViewById(R.id.dropBakType);
		txtDataItem1=(EditText)findViewById(R.id.txtDataItem1);
		txtDataItem2=(EditText)findViewById(R.id.txtDataItem2);
		txtDate=(EditText)findViewById(R.id.txtBakDate);
		txtDate.setOnTouchListener(dateTouchListener);
		dropFuZhuData1=(Spinner)this.findViewById(R.id.dropFuZhuData1);
		imgCusCard = (ImageView) this.findViewById(R.id.imgCusCard);

		g_BakModuleInfo.strUser=BaseActivity.gUser.getUserName();
		g_BakModuleInfo.strBakFlag=gBakFlag;


		dropFuZhuData1.setOnTouchListener(touchListener);
		ActivityHelper.InitDrop(this, R.id.dropFuZhuData1, new ArrayList(), true);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

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



	//日期
	public final OnTouchListener dateTouchListener=new OnTouchListener(){

		public boolean onTouch(View arg0, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {

				//txtDate.setEnabled(false);
				//txtDate.setText(getString(R.string.btn_load)+"...");
				final MotionEvent event1=event;

				new Handler().post(new Runnable(){

					public void run() {

						AlertDialog.Builder builder = new AlertDialog.Builder(GDBakModule.this);
						View view = View.inflate(GDBakModule.this, R.layout.datetime_dialog, null);
						final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
						final TimePicker timePicker = (android.widget.TimePicker) view.findViewById(R.id.time_picker);
						builder.setView(view);
						final TextView tvData=(TextView) view.findViewById(R.id.tvData);
						final TextView tvTime=(TextView) view.findViewById(R.id.tvTime);
						tvData.setTextColor(Color.GRAY);
						viewFlipper=(ViewFlipper)view.findViewById(R.id.viewFlipper);
						//viewFlipper.setOnTouchListener(viewFltouchListener);
						tvData.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								viewFlipper.showPrevious();
								tvData.setTextColor(Color.GRAY);
								tvTime.setTextColor(Color.WHITE);
							}

						});

						tvTime.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								viewFlipper.showNext();
								tvData.setTextColor(Color.WHITE);
								tvTime.setTextColor(Color.GRAY);
							}

						});

						Calendar cal = Calendar.getInstance();
						cal.setTimeInMillis(System.currentTimeMillis());
						datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);

						timePicker.setIs24HourView(true);
						timePicker.setCurrentHour(cal.get(Calendar.HOUR_OF_DAY));
						timePicker.setCurrentMinute(cal.get(Calendar.MINUTE));

						final int inType = txtDate.getInputType();
						txtDate.setInputType(InputType.TYPE_NULL);
						txtDate.onTouchEvent(event1);
						txtDate.setInputType(inType);
						txtDate.setSelection(txtDate.getText().length());

						//builder.setTitle(getString(R.string.pickTime));
						builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int which) {

								StringBuffer sb = new StringBuffer();
								sb.append(String.format("%d-%02d-%02d %02d:%02d",
										datePicker.getYear(),
										datePicker.getMonth() + 1,
										datePicker.getDayOfMonth(),
										timePicker.getCurrentHour(),
										timePicker.getCurrentMinute()));

								txtDate.setText(sb);

								dialog.cancel();
								mDatedialog=null;

								txtDate.setEnabled(true);
							}
						});

						if(mDatedialog!=null)
						{
							mDatedialog.cancel();
						}

						mDatedialog = builder.create();

						mDatedialog.show();
					}
				});

			}

			return true;
		}


	};

	public final OnTouchListener touchListener=new OnTouchListener(){

		public boolean onTouch(View arg0, MotionEvent event)
		{
			if (event.getAction() == MotionEvent.ACTION_DOWN) {

				return onLoadFZ1();
			}

			return false;
		}
	};

	/**
	 * 返回TRUE，下拉框不弹出
	 * @return
	 */
	public boolean  onLoadFZ1()
	{
		String strType=getDropText(dropBakType);
		String strDataItem1=txtDataItem1.getText().toString().trim();
		String strDataItem2=txtDataItem2.getText().toString().trim();
		String strDate=txtDate.getText().toString().trim();

		if(strDataItem1.equals("")||strDataItem2.equals("")||strDate.equals(""))
		{
			ActivityHelper.ToastShow(this, getString(R.string.isNUll));
			return true;
		}

		if((!strType.equals(mstrType)||
				!strDataItem1.equals(mstrDataItem1)||
				!strDate.equals(mstrDate)||
				!strDataItem2.equals(mstrDataItem2)))
		{
			mstrType=strType;
			mstrDataItem1=strDataItem1;
			mstrDataItem2=strDataItem2;
			mstrDate=strDate;

			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.processor =new GDBakModuleDownFZProcessor(GDBakModuleDownFZProcessor.FZ1);
			sendParam.szData =new String[]{strType,strDataItem1,strDataItem2,strDate,g_BakModuleInfo.strUser};
			getDataTrunsfer().request(sendParam);

			return true;
		}

		return false;
	}

	public void onOpenScanBarcode1()
	{
		isDataItem1=true;
		onOpenScanBarcode();
	}

	public void onOpenScanBarcode2()
	{
		isDataItem1=false;
		onOpenScanBarcode();
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
					txtDataItem1.setText(strRst);
				else
					txtDataItem2.setText(strRst);
			}
		}
		else if (requestCode == REQUEST_PHOTO_FLAG) {
			if (resultCode == Activity.RESULT_OK) {
				if (ActivityHelper.bCutPhoto) {//设置为不裁剪
					bOpenCamera=true;
					mPreFileNameCut=mFileName;
					mFileName=CameraTool.cropImageUri(this,Uri.fromFile(new File(mPreFileNameCut)), PHOTO_PICKED_WITH_DATA);
				} else
					intoNextActivity();
			}
		}else if (requestCode == PHOTO_PICKED_WITH_DATA) {

			if(!mPreFileNameCut.equals(""))
			{//删除旧的剪切的图片，为了兼容所有机型，因为有些机型在覆盖旧图片时会报错（如：摩托罗拉）。
				File file=new  File(mPreFileNameCut);
				file.delete();
				mPreFileNameCut="";
			}

			intoNextActivity();
		}
	}


	private void intoNextActivity()
	{
		if (mFileName != null) {
			File file = new File(mFileName);

			if (file.exists()) {

				Bitmap bitmap = ActivityHelper.fileToBitmap(mFileName);
				displayImage(bitmap);

				g_BakModuleInfo.strImgPath = mFileName;
			}
		}
	}


	public void onBtnPhotoClick() {
		String strFilePath = ActivityHelper.getFilePathNoName();
		if (strFilePath != null) {
			SimpleDateFormat sDateFormat = new SimpleDateFormat(
					"yyyyMMddhhmmss");
			String date = sDateFormat.format(new java.util.Date());
			if(!ActivityHelper.savedImagePath.contains(mFileName))
			{
				File file=new File(mFileName);
				if(file.exists()) file.delete();
			}
			mFileName = strFilePath + "/image/i" + date + ".jpg";
			bOpenCamera=true;
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			Uri imageUri = Uri.fromFile(new File(mFileName));
			intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
			intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
			startActivityForResult(intent, REQUEST_PHOTO_FLAG);
		} else {
			ActivityHelper.showDialog(this, "错误", getString(R.string.noPath));
		}
	}

	public void displayImage(Bitmap bitmap) {

		LayoutParams params = new LayoutParams();

		if (bitmap == null) {
			params.height = LayoutParams.WRAP_CONTENT;
			imgCusCard.setLayoutParams(params);
			imgCusCard.setImageResource(R.drawable.contact_card);
		} else {
			params.height = 380;
			imgCusCard.setLayoutParams(params);

			bitmap = ActivityHelper.autoMatrixBitmap(mFileName, bitmap);
			int compressRatio=ActivityHelper.IMAGE_COMPRESS_RATIO;
			bitmap=ThumbnailUtils.extractThumbnail(bitmap,bitmap.getWidth()*compressRatio,bitmap.getHeight()*compressRatio);
			imgCusCard.setImageBitmap(bitmap);
		}
	}


	public void onNext()
	{
		Spinner dropFZ1=(Spinner)findViewById(R.id.dropFuZhuData1);

		String strType=getDropText(dropBakType);

		String strDataItem1=txtDataItem1.getText().toString().trim();
		String strDataItem2=txtDataItem2.getText().toString().trim();
		String strDate=txtDate.getText().toString().trim();

		String[] szFz1=getDropArray(dropFZ1);
		//
		if(strType.equals("")||strDataItem1.equals("")||strDataItem2.equals("")||strDate.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		g_BakModuleInfo.strBakType=strType;
		g_BakModuleInfo.strDataItem1=strDataItem1;
		g_BakModuleInfo.strDataItem2=strDataItem2;
		g_BakModuleInfo.strDate=strDate;
		g_BakModuleInfo.strFuZhuData1Id=szFz1[1];
		g_BakModuleInfo.strFuZhuData1Name=szFz1[0];

		Intent intent=new Intent(this,GDBakModule1.class);
		startActivity(intent);
	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub


	}

}
