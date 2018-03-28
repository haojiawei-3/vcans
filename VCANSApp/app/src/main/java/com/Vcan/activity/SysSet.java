package com.Vcan.activity;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPMenuProcessor;
import com.vcans.dao.DBHelper;
import com.vcans.model.SysParam.ELanguage;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.DataTrunsfer;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.JsonHelper;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

import static com.vcans.dao.DBHelper.DB_PATH;

public class SysSet extends BaseActivity {

	/** Called when the activity is first created. */
	public final static String ADDR="ipAdr";
	public final static String PORT="port";
	public final static String URL="url";

	private CheckBox mChkBox;
	private CheckBox mChkCutPhoto;
	private Spinner dropReduceRate;
	private Spinner dropCutRate;
	private Spinner dropCutType;
	private Spinner dropReduceNumber;
	private HashMap<String, String> mapParms;
	private String mOldIp;
	private String mOldPort;
	private String mHostIp = "";
	private boolean mOldEncrypto;
	private EditText txtYPHistoryNum;
	private ViewFlipper viewFlipper;
	private TextView mTvPageNum;
	private float startX = 0, startY = 0;
	private float startX2 = 0, startY2 = 0;
	private int pageIndex = 1;
	private TextView tvTitle;
	private RadioButton rdBtnCh;
	private RadioButton rdBtnEn;
	private RadioGroup rdGroupLanguage;
	SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
	private ArrayList<Integer> arrDisableResId = new ArrayList<Integer>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.sys_set);
		//initState();
		this.<Button> RegOnClickEvent(R.id.btnOk, "onOpenQRCodeScan");
		this.<Button> RegOnClickEvent(R.id.btnBack, "finish");
		this.<Button> RegOnClickEvent(R.id.chkCutPhoto, "onCutPhotoCheck");
		this.<RadioButton> RegOnClickEvent(R.id.rdBtnCh, "onSwitchCh");
		this.<RadioButton> RegOnClickEvent(R.id.rdBtnEn, "onSwitchEn");
		this.<TextView> RegOnClickEvent(R.id.tvDeivceName, "onCpyDevice");
		this.<TextView> RegOnClickEvent(R.id.btnClear, "delete");
		TextView tvNetStatus = (TextView) findViewById(R.id.tvNetStatus);
		if (tvNetStatus != null)
			tvNetStatus.setVisibility(View.INVISIBLE);

		HashMap<String,String> mapValues = JsonHelper.GetJsonData();


		txtYPHistoryNum = (EditText) findViewById(R.id.txtYPHistoryNum);
		txtYPHistoryNum.setText(ActivityHelper.globalSysParam.nYpQueryHistoryNum + "");

		if (mapValues.size() >= 2) {
			EditText txtIp = (EditText) findViewById(R.id.txtIp);
			EditText txtPort = (EditText) findViewById(R.id.txtPort);
			//txtIp.setInputType(InputType.TYPE_CLASS_PHONE);
			mOldIp = mapValues.get(ADDR);
			mOldPort = mapValues.get(PORT);
			String url=mapValues.get(URL);
			if(url==null||url.equals(""))
			{
				txtIp.setText(mOldIp);
			}
			else
				txtIp.setText(url);


			txtPort.setText(mOldPort);
		}

		mChkBox = (CheckBox) this.findViewById(R.id.chkEncrypto);
		mChkCutPhoto = (CheckBox) this.findViewById(R.id.chkCutPhoto);
		mOldEncrypto = DataTrunsfer.ENABLED_DES_ZIP;
		mChkBox.setChecked(DataTrunsfer.ENABLED_DES_ZIP);
		mChkCutPhoto.setChecked(ActivityHelper.bCutPhoto);
		dropReduceRate = (Spinner) this.findViewById(R.id.dropReduceRate);
		dropCutRate = (Spinner) this.findViewById(R.id.dropCutRate);
		dropCutType = (Spinner) this.findViewById(R.id.dropCutType);
		dropReduceNumber = (Spinner) this.findViewById(R.id.dropReduceNumber);
		rdBtnCh = (RadioButton) this.findViewById(R.id.rdBtnCh);
		rdBtnEn = (RadioButton) this.findViewById(R.id.rdBtnEn);
		rdGroupLanguage = (RadioGroup) this.findViewById(R.id.radioGroup1);

		ActivityHelper.InitDrop(this, R.id.dropReduceRate, new ArrayList<String>(Arrays.asList("原图", "1/2", "1/4")),
				true);
		ActivityHelper.InitDrop(this, R.id.dropCutRate, new ArrayList<String>(Arrays.asList("1/1", "1/4", "3/4")),
				true);
		ActivityHelper.InitDrop(this, R.id.dropCutType, new ArrayList<String>(Arrays.asList("高", "宽")), true);
		ActivityHelper.InitDrop(this, R.id.dropReduceNumber,
				new ArrayList<String>(Arrays.asList(">1024", ">700", ">500")), true);

		// 无权限时禁用的控件Id
		//arrDisableResId.add(R.id.dropReduceRate);
		//arrDisableResId.add(R.id.dropReduceNumber);
		//arrDisableResId.add(R.id.chkCutPhoto);
		//arrDisableResId.add(R.id.txtYPHistoryNum);
		//setUserItemPower();

		viewFlipper = (ViewFlipper) this.findViewById(R.id.viewFlipper);
		tvTitle = (TextView) this.findViewById(R.id.tvActtitle);

		TextView tvVersion = (TextView) this.findViewById(R.id.tvVersion);
		tvVersion.setText(getString(R.string.version) + " V" + ActivityHelper.getVersion(this) + " ");

		// setSpinnerItemSelectedByValue(dropReduceRate,mapParms.get("ImgReduceRate"));
		dropReduceRate.setSelection(ActivityHelper.imageReduceRate / 2, true);
		setSpinnerItemSelectedByValue(dropReduceNumber, ">" + ActivityHelper.imageReduceMinSize);
		dropCutType.setSelection(ActivityHelper.imageCutType);
		setSpinnerItemSelectedByValue(dropCutRate, ActivityHelper.imageCutRate);

		if (ActivityHelper.globalSysParam.language == ELanguage.CH) {
			rdBtnCh.setChecked(true);
			// rdBtnEn.setChecked(false);
		} else if (ActivityHelper.globalSysParam.language == ELanguage.EN) {
			// rdBtnCh.setChecked(false);
			rdBtnEn.setChecked(true);
		}

		this.onCutPhotoCheck();
	}

	public void setUserItemPower() {

		//0为系统设置模块索引号 索引了解见DPMenuProcessor
		if (gUser == null || !gUser.getItemPower(0)) {
			for (int resId : arrDisableResId) {
				findViewById(resId).setEnabled(false);
			}
		} else {
			for (int resId : arrDisableResId) {
				findViewById(resId).setEnabled(true);
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				startX = event.getX();
				break;
			case MotionEvent.ACTION_UP:

				float upX = event.getX();
				float upY = event.getY();

				if (upX > 600 && upY <= 120) {
					return super.onTouchEvent(event);
				}

				if (Math.abs(startX - upX) < 20) {
					return super.onTouchEvent(event);
				}

				if (event.getX() > startX) { // 向右滑动
					if (pageIndex >= 2) {// 为第二页时可向右滑动
						viewFlipper.setInAnimation(SysSet.this, R.drawable.in_left_right);
						viewFlipper.setOutAnimation(SysSet.this, R.drawable.out_left_right);
						viewFlipper.showPrevious();
						pageIndex--;
						tvTitle.setText(getString(R.string.sysSet) + "(" + pageIndex + "/2)");

						// HashMap<String,String> mapParms=new
						// HashMap<String,String>();
						// mapParms.put("page", "1");
						// ActivityHelper.saveParams(this,mapParms);
					}

				} else if (event.getX() < startX) { // 向左滑动
					if (pageIndex < 2) {// 为第一页时可向左滑动
						viewFlipper.setInAnimation(SysSet.this, R.drawable.in_right_left);
						viewFlipper.setOutAnimation(SysSet.this, R.drawable.out_right_left);
						viewFlipper.showNext();
						pageIndex++;
						tvTitle.setText(getString(R.string.sysSet) + "(" + pageIndex + "/2)");
					}
				}

				break;
		}

		return super.onTouchEvent(event);
	}

	/*
	 * RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new
	 * RadioGroup.OnCheckedChangeListener() {
	 *
	 * @Override public void onCheckedChanged(RadioGroup group, int checkedId) {
	 * // TODO Auto-generated method stub if(checkedId==R.id.rdBtnCh){
	 *
	 * } else { Toast.makeText(MainActivity.this, "你的性别是女",
	 * Toast.LENGTH_LONG).show(); } } }
	 */

	public void onSwitchEn() {
		if (!rdBtnEn.isChecked()) {
			// rdBtnCh.setChecked(false);
			rdBtnEn.setChecked(true);
		}

	}

	public void onCutPhotoCheck() {
		LinearLayout layCutRate = (LinearLayout) this.findViewById(R.id.layCutRate);
		LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, 100);
		if (mChkCutPhoto.isChecked()) {
			parms.height = 0;// 80;
			layCutRate.setLayoutParams(parms);
			layCutRate.setVisibility(View.VISIBLE);
		} else {
			parms.height = 0;
			layCutRate.setLayoutParams(parms);
			layCutRate.setVisibility(View.INVISIBLE);
		}
	}

	public void reStart() {
		mbQuitFlag = true;
		try {
			Intent k = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
			k.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(k);

//			if (ActivityHelper.lstActivities.size() > 0)
//				ActivityHelper.lstActivities.get(0).finish();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 解析URL对应的IP地址
	 * @author vcans
	 *
	 */
	public class HostResolveTask extends AsyncTask<String, Void, Void> {

		String strPort;
		String strHis; //当为空时说明，app启动时该类被调用
		String strUrl;
		private Handler mHandler;

		public void setHandler(Handler handler)
		{
			mHandler=handler;
		}

		public HostResolveTask(String url,String port,String his) {

			strUrl=url;
			strPort = port;
			strHis = his;

		}

		protected Void doInBackground(String... params) {


			String strIp="";
			InetAddress inetAddr;
			try {
				inetAddr = InetAddress.getByName(strUrl);
				strIp = inetAddr.getHostAddress();

				saveAdrrPort(strIp,strPort,strUrl,strHis);


			} catch (UnknownHostException e) {
				e.printStackTrace();
			}

			if(strIp.equals("")&&mHandler!=null)
			{
				Message msg=new Message();
				msg.what=1;
				mHandler.sendMessage(msg);
			}

			return null;

		}

		protected void onPostExecute(Boolean... result) {

		}

	}

	public void onOpenQRCodeScan() {
		EditText txtIp = (EditText) findViewById(R.id.txtIp);
		EditText txtPort = (EditText) findViewById(R.id.txtPort);

		String ipAdr = txtIp.getText().toString().trim();
		String strPort = txtPort.getText().toString().trim();

		String strYPHistoryNum = this.txtYPHistoryNum.getText().toString().trim();
		if (strYPHistoryNum.equals("")) {
			ActivityHelper.ToastShow(this, getString(R.string.historyInNull));
			return;
		}

		if (!ipAdr.equals("") && !strPort.equals("")) {

			Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

			if (pattern.matcher(ipAdr).matches()) {
				saveAdrrPort(ipAdr,strPort,"",strYPHistoryNum);
			} else {

				String url=ipAdr;

				String[] szHost=url.split("\\.");

				if(url.indexOf("http")>=0||szHost.length<3)
				{
					ActivityHelper.ToastShow(this, getString(R.string.urlError)+"eg: www.baidu.com/tieba.baidu.com");
					return;
				}



				HostResolveTask tast = new HostResolveTask(url,strPort,strYPHistoryNum);
				tast.setHandler(mTempHandler);
				ActivityHelper.ToastShow(this, getString(R.string.executing));
				tast.execute();

			}


		} else {
			ActivityHelper.showDialog(this, "", getString(R.string.noSetIpAndPort));
		}
	}

	public void saveAdrrPort(String ipAdr,String strPort,String url,String strYPHistoryNum)
	{
		HashMap<String,String> mapValues=new HashMap<String,String>();
		mapValues.put(ADDR, ipAdr);
		mapValues.put(PORT, strPort);
		mapValues.put(URL, url);
		int nRst = JsonHelper.SaveJsonData(mapValues);

		if (nRst == 1) {
			// 保存参数
			String reduceNumber = "0";

			HashMap<String, String> mapParms = new HashMap<String, String>();
			mapParms.put("isEncrypto", mChkBox.isChecked() ? "1" : "0");
			mapParms.put("isCutPhoto", mChkCutPhoto.isChecked() ? "1" : "0");
			mapParms.put("cutType", dropCutType.getSelectedItemPosition() + "");
			mapParms.put("cutRate", dropCutRate.getSelectedItem().toString());
			reduceNumber = dropReduceNumber.getSelectedItem().toString().substring(1);
			mapParms.put("ReduceNumber", reduceNumber);
			mapParms.put("YpHistoryNum", strYPHistoryNum);
			// 应用语言
			ELanguage lan;
			if (rdGroupLanguage.getCheckedRadioButtonId() == R.id.rdBtnCh) {
				mapParms.put("language", "ch");
				lan = ELanguage.CH;
			} else {
				mapParms.put("language", "en");
				lan = ELanguage.EN;
			}

			ActivityHelper.globalSysParam.nYpQueryHistoryNum = Integer.valueOf(strYPHistoryNum);
			ActivityHelper.imageCutRate = dropCutRate.getSelectedItem().toString();
			ActivityHelper.imageCutType = dropCutType.getSelectedItemPosition();

			int rate = 0;
			if (this.dropReduceRate.getSelectedItemId() == 0)
				rate = 1;
			else if (this.dropReduceRate.getSelectedItemId() == 1)
				rate = 2;
			else
				rate = 4;

			mapParms.put("ImgReduceRate", rate + "");

			ActivityHelper.saveParams(this, mapParms);
			ActivityHelper.imageReduceRate = rate;
			ActivityHelper.imageReduceMinSize = Integer.valueOf(reduceNumber);

			if (!ipAdr.equals(mOldIp) || !strPort.equals(mOldPort) || (mChkBox.isChecked() != mOldEncrypto)) {
				this.getDataTrunsfer().CloseSocketConnect();
				BaseActivity.bReconnect = true;
				ItemTitleHelper.bGetItemTitleFlag = true;
			}

			DataTrunsfer.ENABLED_DES_ZIP = mChkBox.isChecked();
			ActivityHelper.bCutPhoto = mChkCutPhoto.isChecked();

			if (ActivityHelper.globalSysParam.language != lan) {

				Message msg=new Message();
				msg.what=2;
				mTempHandler.sendMessage(msg);
			}
			else
			{
				Message msg=new Message();
				msg.what=0;
				mTempHandler.sendMessage(msg);
			}

		} else {
			Message msg=new Message();
			msg.what=3;
			mTempHandler.sendMessage(msg);
		}
	}

	@SuppressWarnings("deprecation")
	public void onCpyDevice()
	{
		ClipboardManager myClipboard;
		myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
		myClipboard.setText(DPMenuProcessor.getDeviceName());
		ActivityHelper.ToastShow(SysSet.this, DPMenuProcessor.getDeviceName()+"   成功复制至剪贴板");
	}

	public void delete()
	{

		new AlertDialog.Builder(this).setTitle(getString(R.string.askClear))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						db.delete(DBHelper.Product,null,null);
						db.delete(DBHelper.Customer,null,null);
						db.delete(DBHelper.PeibuIn,null,null);
						db.delete(DBHelper.SCTouPei,null,null);
						db.delete(DBHelper.ProductIn,null,null);
						db.delete(DBHelper.RZTask,null,null);
						db.delete(DBHelper.RZTask2,null,null);
						db.delete(DBHelper.RZTask3,null,null);
						db.delete(DBHelper.ByModel,null,null);
						db.delete(DBHelper.MLQingdan,null,null);
						db.delete(DBHelper.BakModule,null,null);
						db.delete(DBHelper.Version,null,null);
						db.delete(DBHelper.CustomerCollect,null,null);
						db.delete(DBHelper.Collect,null,null);
						db.delete(DBHelper.YPExpostion,null,null);
						db.delete(DBHelper.RZCost,null,null);
						db.delete(DBHelper.Pendingapproval,null,null);
						db.delete(DBHelper.Pendingapprovalcz,null,null);
						db.delete(DBHelper.Mpsb,null,null);
						db.delete(DBHelper.UIItemTitle,null,null);
						db.delete(DBHelper.YPInfo,null,null);
						db.delete(DBHelper.MLQingdanone,null,null);
						db.delete(DBHelper.Pendingapprovalxx,null,null);
						db.delete(DBHelper.Machining,null,null);
						db.delete(DBHelper.YangPin,null,null);
						db.delete(DBHelper.DirectOut,null,null);
						db.delete(DBHelper.BarcodeImage,null,null);
						db.delete(DBHelper.History,null,null);
						ItemTitleHelper.mapSysModuleItems.clear();
						ActivityHelper.ToastShow(SysSet.this, "清除缓存成功");

					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();

	}



	/**  	db.delete("MLQingdan",null,null);
	 * 用于访问主线程
	 */
	Handler mTempHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			if(msg.what==0)
				ActivityHelper.showTempDialog(SysSet.this, getString(R.string.setSucc), 1000, true);
			else if(msg.what==1)
				ActivityHelper.ToastShow(SysSet.this,"URL ERROR");
			else if(msg.what==2)
			{
				ActivityHelper.ToastShow(SysSet.this, getString(R.string.restarting));
				new Handler().postDelayed(new Runnable() {

					public void run() {

						reStart();
					}
				}, 1000);
			}
			else
				ActivityHelper.ToastShow(SysSet.this, getString(R.string.setFail));
		}

	};

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}
}