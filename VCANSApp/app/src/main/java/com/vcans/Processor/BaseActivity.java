package com.vcans.Processor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.Vcan.activity.R;
import com.Vcan.activity.SysSet;
import com.example.qr_codescan.MipcaActivityCapture;
import com.vcans.adapter.ImageSimpleAdapter;
import com.vcans.adapter.ImageSimpleAdapter.ItemTitleListener;
import com.vcans.model.BandleParam;
import com.vcans.model.MenuK;
import com.vcans.model.SendParam;
import com.vcans.model.User;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ColorUtil;
import com.vcans.tool.DataTrunsfer;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.JsonHelper;
import com.vcans.tool.PlProcessor;
import com.vcans.tool.SildingFinishLayout;
import com.vcans.tool.ZDYzuhe;
import com.vcans.tool.SildingFinishLayout.OnSildingFinishListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
/**
 * 本项目下的所有Activity组件的基类
 * @author vcans
 *
 */
public abstract class BaseActivity extends FragmentActivity implements OnClickListener, OnItemClickListener, OnMenuItemClickListener {

	private static final int ONCLICK_DELAY_TIME = 400;
	//单击的类型 按钮单击 或 列表控件的Item的单击
	public static final int ONCLICK_FLAG = 100;
	//单击事件消息标志
	public static final int ONCLICK_MSG = 101;
	private static final int ITEM_ONCLICK_MSG = 102;
	//设置
	private static final int SET_MSG = 103;
	public final int REQUEST_SCAN_QRCODE_FLAG = 2;
	public static BaseActivity mMainActivity=null;
	public static List<MenuK>  MenuList=new ArrayList<MenuK>();
	private HashMap<Integer, HashMap<Integer, String>> mapGridView = new HashMap<Integer, HashMap<Integer, String>>();
	private HashMap<Integer, String> mapMethod = new HashMap<Integer, String>();
	private HashMap<Integer, String> mapDoubleMethod = new HashMap<Integer, String>();
	private HashMap<Integer, String> mapMethod2 = null;

	public HashMap<String, String> mapBtnName = new HashMap<String, String>();
	public int mnGridId;
	public static User gUser = null;
	public String mstrDataId = "";
	public static boolean bReconnect = false;
	private static String mTitle = "";
	private static int mRId = 0;
	public static boolean mbQuitFlag = false;
	public static boolean bConnected = false;
	private boolean enabledChangeTitle = true;
	private DataTrunsfer mDataTrunsfer = null;
	private int mLastClickId = -1;
	private long mLastClickTime = 0;
	public Dialog mDialog = null;
	private boolean mChangeFlag = false;
	private ImageView tvTip = null;
	TextView mTvNetStatus = null;

	/**
	 * 列表控件的单元单击事件名
	 */
	private String mListItemClickMethod = "";
	private String mListItemDbClickMethod = "";
	private Bitmap[] szBitmap;
	private Typeface typeFace;
	public static BaseActivity instance;

	public Typeface getTypeFace() {
		return typeFace;
	}

	public Bitmap[] getSzBitmap() {
		return szBitmap;
	}

	public void setSzBitmap(Bitmap[] szBitmap) {
		this.szBitmap = szBitmap;
	}

	/**
	 * 设置列表控件的单元的单击或双击事件
	 * @param clickMethod
	 * @param dbClickMethod
	 */
	public void setListItemClickMethod(String clickMethod, String dbClickMethod) {
		mListItemClickMethod = clickMethod;
		mListItemDbClickMethod = dbClickMethod;
	}

	/**
	 * 设置是否允许改变标题
	 * @param enabledChangeTitle
	 */
	public void setEnabledChangeTitle(boolean enabledChangeTitle) {
		this.enabledChangeTitle = enabledChangeTitle;
	}

	/**
	 * 设置模块标题  目的一次设置标题后，模块下的所有窗体都显示该标题
	 * @param title
	 * @param rId
	 */
	public void setMTitle(String title, int rId) {
		mTitle = title;
		mRId = rId;
	}

	public String getMTitle() {
		return mTitle;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setListItemClickMethod("", "");
		//initState();
		instance=this;
		ActivityHelper.lstActivities.add(this);
		AppManager.getAppManager().addActivity(this);
		PlProcessor.SetParent(this);

		if (enabledChangeTitle) {
			Message msg = new Message();
			msg.what = BaseActivity.SET_MSG;
			mHandler.sendMessageDelayed(msg, 50);
		} else {

			new Handler().postDelayed(new Runnable() {

				public void run() {

					mTvNetStatus = (TextView) findViewById(R.id.tvNetStatus);
					tvTip = (ImageView) findViewById(R.id.imgNetStatus);
					mTvNetStatus.setVisibility(View.INVISIBLE);
					tvTip.setVisibility(View.INVISIBLE);
				}
			}, 500);
		}

		//通过字体文件创建新字体
		typeFace = Typeface.createFromAsset(getAssets(), "fonts/BAUHAUSM.TTF");
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		PlProcessor.SetParent(this);
	}

	private void quit() {

		//if (!mbQuitFlag) {

		int index = ActivityHelper.lstActivities.indexOf(this);
		if (index >= 0) {
			ActivityHelper.lstActivities.set(index, null);
		}
		//}

		super.finish();
	}

	public void finishs() {

		//enabledQuest 当为true 表示无的请求 此时可以关闭Activity
		boolean enabledQuest = this.getDataTrunsfer().isEnabledQuest();

		if (mbQuitFlag||enabledQuest) {
			quit();
		} else {
			new AlertDialog.Builder(this).setTitle(R.string.busy).setIcon(android.R.drawable.ic_dialog_info)
					.setPositiveButton(R.string.stop, new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							// 点击“确认”后的操作
							// startProcessMsg(DataTrunsfer.CANCEL_SERVER_RESPONSE,"");
							if (!getDataTrunsfer().isEnabledQuest()) {
								getDataTrunsfer().CloseSocketConnect();

								new Handler().postDelayed(new Runnable() {

									public void run() {

										getDataTrunsfer().startThreadConnectServer();

										new Handler().postDelayed(new Runnable() {

											public void run() {

												quit();
											}
										}, 1000);
									}
								}, 2500);

							}
						}
					}).setNegativeButton(R.string.wait, new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					// 点击“返回”后的操作,这里不设置没有任何操作
					ActivityHelper.showDialogAgain();
				}
			}).show();
		}
	}



	/**
	 * 沉浸式状态栏
	 */
	protected void initState() {

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
			localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
		}
	}



	/**
	 * 设置系统皮肤
	 */
	public void setSkin()
	{
		// 设置TOP颜色 除XYImageView和DPDetailInfo类中的top颜色外 都是在此处设置
		LinearLayout layTitle = (LinearLayout) findViewById(R.id.include01);

		if (layTitle != null)
			layTitle.setBackgroundResource(ActivityHelper.globalSysParam.sysSkin.selectedColor);

		// 设置信息列表TOP颜色
		LinearLayout layInfoList = (LinearLayout) findViewById(R.id.layInfoList);

		if (layInfoList != null)
			layInfoList.setBackgroundResource(ActivityHelper.globalSysParam.sysSkin.selectedColor);

		ImageButton mImgBtnOk = (ImageButton) findViewById(R.id.imgBtnOk);

		if (mImgBtnOk != null)
			setImageSpapeColor(mImgBtnOk, ActivityHelper.globalSysParam.sysSkin.selectedColor);

		ImageButton mImgBtnSave = (ImageButton) findViewById(R.id.imgBtnSave);

		if (mImgBtnSave != null)
			setImageSpapeColor(mImgBtnSave, ActivityHelper.globalSysParam.sysSkin.selectedColor);
	}

	/**
	 * 设置图片背景
	 */
	public void setImageSpapeColor(View v, int resColor) {
		GradientDrawable bgShape = (GradientDrawable) v.getBackground();
		if (bgShape != null)
			bgShape.setColor(ColorUtil.getResourcesColor(this, resColor));
	}

	/**
	 * 根据值, 设置spinner默认选中:
	 *
	 * @param spinner
	 * @param value
	 */
	public void setSpinnerItemSelectedByValue(Spinner spinner, String value) {
		SpinnerAdapter apsAdapter = spinner.getAdapter(); // 得到SpinnerAdapter对象
		int k = apsAdapter.getCount();
		for (int i = 0; i < k; i++) {
			if (value.equals(apsAdapter.getItem(i).toString())) {
				spinner.setSelection(i, true);// 默认选中项
				break;
			}
		}
	}


	public void onOpenScanBarcode() {
		Intent intent = new Intent();
		intent.setClass(this, MipcaActivityCapture.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivityForResult(intent, REQUEST_SCAN_QRCODE_FLAG);
	}

	public boolean onMenuItemClick(MenuItem arg0) {
		// 退出菜单
		new AlertDialog.Builder(this).setTitle(R.string.askQuit).setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						mbQuitFlag = true;
						try {
							for (int i = 0; i < ActivityHelper.lstActivities.size(); ++i) {
								if (ActivityHelper.lstActivities.get(i) != null)
									ActivityHelper.lstActivities.get(i).finish();
							}

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).setNegativeButton(R.string.cancle, new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// 点击“返回”后的操作,这里不设置没有任何操作
			}
		}).show();

		return true;
	}


	public void onTip() {

		if (this.getDataTrunsfer().isSocketFreeDisconnect()) {
			//mTvNetStatus.setText(getString(R.string.connecting));
			this.getDataTrunsfer().startThreadConnectServer();
		} else {
			showDialog();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem menuItem = menu.add(1, 1, 1,R.string.quit);

		menuItem.setOnMenuItemClickListener(this);
		return true;
	}

	public DataTrunsfer getDataTrunsfer() {
		return Singleton.getDataTrunsfer();
	}

	/**
	 * 获取URL对应的IP地址
	 * @author vcans
	 *
	 */
	public class HostResolveTask extends AsyncTask<String, Void, Void> {

		String strPort;
		String strUrl;
		private Handler mHandler;

		public void setHandler(Handler handler)
		{
			mHandler=handler;
		}


		public HostResolveTask(String url,String port) {

			strUrl=url;
			strPort = port;
		}

		protected Void doInBackground(String... params) {

			String strIp="";
			InetAddress inetAddr;
			try {
				inetAddr = InetAddress.getByName(strUrl);
				strIp = inetAddr.getHostAddress();

				HashMap<String,String> mapValues=new HashMap<String,String>();
				mapValues.put(SysSet.ADDR, strIp);
				mapValues.put(SysSet.PORT, strPort);
				mapValues.put(SysSet.URL,  strUrl);
				JsonHelper.SaveJsonData(mapValues);

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}

			if(!strIp.equals(""))
			{
				mDataTrunsfer.SetIpAndPort(strIp, Integer.valueOf(strPort));
				mDataTrunsfer.startThreadConnectServer();
			}

			return null;

		}

		protected void onPostExecute(Boolean... result) {

		}


		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}



	}





	/**
	 *   创建数据传输者（并创建sokcet连接）
	 * @author vcans
	 *
	 */
	public void createDataTrunsfer() {
		PlProcessor.SetParent(this);
		mDataTrunsfer = Singleton.getDataTrunsfer();
		mDataTrunsfer.SetClientHandler(mHandler);

		String strIp = "", strPort = "",strUrl="";

		HashMap<String,String> mapValues = JsonHelper.GetJsonData();

		if (mapValues.size()>1) {
			strIp = mapValues.get(SysSet.ADDR);
			strPort = mapValues.get(SysSet.PORT);
			strUrl = mapValues.get(SysSet.URL);
			if(strUrl==null||strUrl.equals(""))
			{//设置为ip地址时
				mDataTrunsfer.SetIpAndPort(strIp, Integer.parseInt(strPort));
				mDataTrunsfer.startThreadConnectServer();
			}
			else
			{//设置地址为URL时，获取URL对应的ip地址后，连接服务
				HostResolveTask hostTask=new HostResolveTask(strUrl,strPort);
				hostTask.execute();
			}
		}
	}







	/**
	 * 注册按钮的单击事件
	 * @param ctrlId
	 * @param
	 */
	public <T> void RegOnClickEvent(int ctrlId, String methodName) {
		RegClickEvent(ctrlId, methodName, ONCLICK_FLAG);
	}

	/**
	 * 注册列表ITEM的单击事件 如ListView GridView
	 * @param ctrlId
	 * @param szMethodName
	 */
	public <T> void RegItemOnClickEvent(int ctrlId, String[] szMethodName) {
		mapMethod2 = new HashMap<Integer, String>();

		RegClickEvent(ctrlId, null, ITEM_ONCLICK_MSG);
		for (int i = 0; i < szMethodName.length; ++i) {
			mapMethod2.put(i, szMethodName[i]);
		}

		mapGridView.put(ctrlId, mapMethod2);










	}

	public <T> void RegItemOnClickEvent(View view,int ctrlId, String[] szMethodName) {
		mapMethod2 = new HashMap<Integer, String>();

		RegClickEvent(view,ctrlId, null, ITEM_ONCLICK_MSG);
		for (int i = 0; i < szMethodName.length; ++i) {
			mapMethod2.put(i, szMethodName[i]);
		}

		mapGridView.put(ctrlId, mapMethod2);
	}

	private <T> void RegClickEvent(View view,int ctrlId, String methodName, int clickFlag) {
		@SuppressWarnings("unchecked")
		T ctrlObj = (T) view.findViewById(ctrlId);
		Method method = null;


		try {
			if (clickFlag == ONCLICK_FLAG) {
				method = ctrlObj.getClass().getMethod("setOnClickListener", OnClickListener.class);
				mapMethod.put(ctrlId, methodName);
			} else {
				method = ctrlObj.getClass().getMethod("setOnItemClickListener", OnItemClickListener.class);
			}

			method.invoke(ctrlObj, this);

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


















	public void RegItemOnDbClickEvent(int ctrlId, String methodName) {

		mapDoubleMethod.put(ctrlId, methodName);
	}

	/**
	 * 注册单击事件
	 * @param ctrlId
	 * @param methodName
	 * @param clickFlag
	 */
	private <T> void RegClickEvent(int ctrlId, String methodName, int clickFlag) {
		@SuppressWarnings("unchecked")
		T ctrlObj = (T) findViewById(ctrlId);
		Method method = null;


		try {
			if (clickFlag == ONCLICK_FLAG) {
				method = ctrlObj.getClass().getMethod("setOnClickListener", OnClickListener.class);
				mapMethod.put(ctrlId, methodName);
			} else {
				method = ctrlObj.getClass().getMethod("setOnItemClickListener", OnItemClickListener.class);
			}

			method.invoke(ctrlObj, this);

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onClick(View v) {
		mHandler.removeMessages(ONCLICK_MSG);
		Message msg = Message.obtain();
		msg.what = ONCLICK_MSG;
		msg.obj = v.getId();
		mHandler.sendMessageDelayed(msg, ONCLICK_DELAY_TIME);
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		// @SuppressWarnings("unchecked")
		// HashMap<String, Object> mAllAppsList=(HashMap<String, Object>)
		// arg0.getItemAtPosition(arg2);

		mnGridId = arg0.getId();
		int iconId = arg2;

		// 如果是双击,1秒内连续点击判断为双击
		if (arg2 == mLastClickId && (Math.abs(mLastClickTime - System.currentTimeMillis()) < 1000)) {
			mLastClickId = -1;
			mLastClickTime = 0;

			onDbClickMsg(iconId, 0);
		} else {
			mLastClickId = arg2;
			mLastClickTime = System.currentTimeMillis();

			onClickEvent(iconId, ITEM_ONCLICK_MSG);
		}
	}

	public void getScreenSize(Point p) {
		WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);

		wm.getDefaultDisplay().getSize(p);
	}

	public int dipToPx(float dpValue) {
		final float scale = getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}



















	//消息处理者
	public Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {


			if (msg.what == ONCLICK_MSG) {//按钮单击事件消息

				onClickEvent((Integer) msg.obj, ONCLICK_FLAG);
			} else if (msg.what == SET_MSG) {
				/**
				 *  放在父类OnCreate进行控件的设置，从而达到程序复用日的
				 *  是所以要通过消息进行延时，是为了让子类创建初始化完成后，进行设置，否则未创建完成，会找不到相应的控件。
				 */
				try {
					TextView tvTitle = (TextView) findViewById(mRId);

					if (!mTitle.equals("")) {
						tvTitle.setText(mTitle);
					}

					//设置皮肤
					setSkin();

					//设置界面标题

					ItemTitleHelper.setItemTitle(BaseActivity.this);



					//设置网络连接状态
					mTvNetStatus = (TextView) findViewById(R.id.tvNetStatus);
					tvTip = (ImageView) findViewById(R.id.imgNetStatus);

					if (BaseActivity.bConnected) {
						tvTip.setBackgroundResource(R.drawable.connected);
					} else {
						tvTip.setBackgroundResource(R.drawable.disconnected);
					}

					/**
					 * 用于点击标题，返回到主界面
					 */
					//	BaseActivity.this.RegOnClickEvent(R.id.tvActtitle, "backMainActivity");

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				Bundle bundle = msg.getData();
				String strContent = bundle.getString("msg");

				processMessage(msg.what, strContent);

				bundle.clear();
			}
		}
	};

	/**
	 * 用于点击标题，返回到主界面
	 */
	public void backMainActivity() {

		int nSize = ActivityHelper.lstActivities.size();
		BaseActivity topActivity = null;

		for (int i = 2; i < nSize; i++) {
			topActivity = ActivityHelper.lstActivities.get(i);
			if (topActivity != null) {
				mbQuitFlag = true;
				//ActivityHelper.lstActivities.set(i, null);
				topActivity.finish();
			}
		}
	}

	public abstract void processMessage(int msgId, String msg);

	//public abstract void processMessage(int msgId, List<String> msg);

	/**
	 * 检查配制好的不能为空的控件是否为空
	 * @return
	 */
	private boolean checkContainNull()
	{
		boolean hasNull=false;
		String value="";

		for(int i=0;i<ItemTitleHelper.lstNotNullRId.size();++i)
		{
			View v=this.findViewById(ItemTitleHelper.lstNotNullRId.get(i));

			if(v instanceof TextView)
			{
				value=((TextView) v).getText().toString().trim();
				if(value.equals(""))
				{
					hasNull=true;
					break;
				}
			}
			else if(v instanceof Spinner)
			{
				Object obj=((Spinner) v).getSelectedItem();
				if(obj!=null)
				{
					value=obj.toString();
				}

				if(value.equals(""))
				{
					hasNull=true;
					break;
				}
			}
		}

		if(hasNull)
			ActivityHelper.ToastShow(this, getString(R.string.isNUll));

		return hasNull;
	}

	/**
	 * 单击事件
	 * @param viewId
	 * @param clickFlag
	 */
	public void onClickEvent(int viewId, int clickFlag) {
		String strMethodName = "";

		if (clickFlag == ONCLICK_FLAG) {
			strMethodName = mapMethod.get(viewId);
		} else // ITEM_ONCLICK_MSG
		{
			strMethodName = this.mapGridView.get(mnGridId).get(viewId);
		}

		Method method = null;
		try {
			if (strMethodName != null) {
				if (clickFlag == ONCLICK_FLAG) {
					method = this.getClass().getMethod(strMethodName);
					//if(!checkContainNull())
					method.invoke(this);
				} else {
					method = this.getClass().getMethod(strMethodName, int.class);
					method.invoke(this, viewId);
				}

			}

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onDbClickMsg(int viewId, int clickFlag) {
		if (mapDoubleMethod.size() < 1)
			return;

		String strMethodName = mapDoubleMethod.get(mnGridId);

		Method method = null;
		try {
			if (strMethodName != null) {
				method = this.getClass().getMethod(strMethodName, int.class);
				method.invoke(this, viewId);
			}

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 显示网络连接状态
	 * @param msgId
	 */
	public void ShowNetStatus(int msgId) {
		try {
			if (msgId == DataTrunsfer.OK_FLAG) {

				tvTip = (ImageView) findViewById(R.id.imgNetStatus);
				mTvNetStatus = (TextView) findViewById(R.id.tvNetStatus);

				if (tvTip != null) {

					tvTip.setBackgroundResource(R.drawable.connected);
					mTvNetStatus.setVisibility(View.INVISIBLE);
				}

				BaseActivity.bConnected = true;
			} else if (msgId == DataTrunsfer.MSG_BUSY_FLAG) {

				//tvTip = (ImageView) findViewById(R.id.imgNetStatus);

				if (tvTip == null)
					return;

				if (mChangeFlag == false) {
					tvTip.setBackgroundResource(R.drawable.connected);
					mChangeFlag = true;
				} else {
					tvTip.setBackgroundResource(R.drawable.connected2);
					mChangeFlag = false;
				}
			} else {

				//tvTip = (ImageView) findViewById(R.id.imgNetStatus);

				if (tvTip == null)
					return;

				if (mChangeFlag == false) {
					tvTip.setBackgroundResource(R.drawable.disconnected);
					mChangeFlag = true;
				} else {
					tvTip.setBackgroundResource(R.drawable.disconnected2);
					mChangeFlag = false;
				}

				BaseActivity.gUser=null;
				BaseActivity.bConnected = false;
				ActivityHelper.gToupei.strUser=null;
				mTvNetStatus.setVisibility(View.VISIBLE);

				mTvNetStatus.setText(getString(R.string.connecting));
				if (this.getDataTrunsfer().isSocketFreeDisconnect()) {
					mTvNetStatus.setText(getString(R.string.clickConnect));
				}
			}
		} catch (Exception e) {

		}
	}

	public void clearText(int viewId) {
		EditText txt = (EditText) this.findViewById(viewId);
		txt.setText("");
	}

	/**
	 * 设置列表控件单元单击事件，只有初始化了
	 * mListItemClickMethod
	 * 及mListItemDbClickMethod 方法才允许设置
	 * @param lstRId
	 */
	public void setListItemClick(int lstRId) {

		if (!mListItemClickMethod.equals("")) {
			ListView listView = (ListView) findViewById(lstRId);

			String[] szMethods = new String[listView.getCount()];

			// 为了重用gridview的itemclick注册事件的程序，而做出如下处理。实际可以用一个就可以
			for (int i = 0; i < listView.getCount(); ++i) {
				szMethods[i] = mListItemClickMethod;
			}

			this.RegItemOnClickEvent(lstRId, szMethods);
		}

		if (!mListItemDbClickMethod.equals("")) {
			this.RegItemOnDbClickEvent(lstRId, mListItemDbClickMethod);
		}
	}

	/**
	 * 显示 列表并会 根据配制修改属性名称
	 *
	 * @param parent
	 * @param data
	 * @param resource
	 * @param from
	 * @param to
	 * @param listId
	 * @param pageId
	 */
	public static void showList(Activity parent,List<? extends Map<String, ?>> data, int resource, String[] from,
								int[] to,int listId,int pageId) {

		ImageSimpleAdapter adpter=new ImageSimpleAdapter(parent,data,resource,from,to);
		adpter.addItemTitleListener(new ItemTitleListener(){
			public void SetItemTitle(View view) {

				ItemTitleHelper.setItemTitle(view);
			}
		});
		ListView listView = (ListView) parent.findViewById(listId);
		listView.setAdapter(adpter);

		TextView tvPage = (TextView) parent.findViewById(pageId);

		if (tvPage != null)
			tvPage.setText("(0/" + listView.getCount() + ")");


		BaseActivity baseAct=(BaseActivity)parent;
		baseAct.setListItemClick(listId);
	}





	public void showList(BandleParam lstParam) {
		SimpleAdapter adpter = new SimpleAdapter(this, lstParam.dataList, lstParam.itemRId, lstParam.szFieldData,
				lstParam.szRId);



/*		ImageSimpleAdapter adpter=new ImageSimpleAdapter(this,lstParam.dataList,
				lstParam.itemRId,
				lstParam.szFieldData,
				lstParam.szRId);
		adpter.addItemTitleListener(new ItemTitleListener()
		{
			public void SetItemTitle(View view) {

				ItemTitleHelper.setItemTitle(view);
			}
		});*/


		ListView listView = (ListView) findViewById(lstParam.listRId);
		listView.setAdapter(adpter);
		TextView tvPage = (TextView) findViewById(lstParam.pageRId);
		if (tvPage != null)
			tvPage.setText("(0/" + listView.getCount() + ")");

		setListItemClick(lstParam.listRId);
	}

	public String getDropText(Spinner drop) {

		String str="";
		if(drop.getSelectedItem()!=null)
			str=drop.getSelectedItem().toString().trim();

		return str;
	}

	public String[] getDropArray(Spinner drop) {

		String str="";
		if(drop.getSelectedItem()!=null)
			str=drop.getSelectedItem().toString().trim();

		if(!str.equals(""))
			return split(str,"\\[","\\]");
		else
			return new String[]{"",""};
	}

	public String[] split(String src,String sp1,String sp2) {

		String[] szStr=src.split(sp1);
		String[] dest=new String[]{"",""};

		if(szStr.length>=1)
		{
			dest[0]=szStr[0];
		}

		if(szStr.length>=2)
		{
			int index=szStr[1].indexOf("]");
			if(index>0)
			{
				dest[1]=szStr[1].substring(0,index);
			}
		}

		return dest;
	}

	public void SildingFinishLayout(View v){
		SildingFinishLayout mSildingFinishLayout = (SildingFinishLayout) findViewById(R.id.sildingFinishLayout);
		mSildingFinishLayout.setOnSildingFinishListener(new OnSildingFinishListener() {

			@Override
			public void onSildingFinish() {
				finish();
			}
		});

		mSildingFinishLayout.setTouchView(v);
		//return activity;
	}





	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		// TODO Auto-generated method stub
		super.onPrepareDialog(id, dialog);
	}



	public void showDialog() {

		mDialog = new Dialog(this);
		mDialog.setTitle(getString(R.string.sysInfo));
		mDialog.setContentView(R.layout.yp_msgdialog_item);

		Button btnOk = (Button) mDialog.findViewById(R.id.btnOk);
		btnOk.setOnClickListener(onOKListener);

		TextView btnStatus = (TextView) mDialog.findViewById(R.id.tvNetStatus);
		TextView tvIp = (TextView) mDialog.findViewById(R.id.tvIP);
		TextView tvPort = (TextView) mDialog.findViewById(R.id.tvPort);
		TextView tvUserName = (TextView) mDialog.findViewById(R.id.tvUser);
		TextView tvVersion = (TextView) mDialog.findViewById(R.id.tvVersion);

		if (BaseActivity.bConnected) {
			btnStatus.setText(getString(R.string.connected));
			btnStatus.setTextColor(Color.BLUE);
		} else {
			btnStatus.setText(getString(R.string.disconnected));
			btnStatus.setTextColor(Color.RED);
		}

		HashMap<String,String> mapValues= JsonHelper.GetJsonData();

		if (mapValues.size()>0) {

			if (getUserItemPower(0)) {
				tvIp.setText(mapValues.get(SysSet.ADDR));
				tvPort.setText(mapValues.get(SysSet.PORT));
			} else {
				tvIp.setText("****");
				tvPort.setText("****");
			}
		}

		if (BaseActivity.gUser != null)
			tvUserName.setText(BaseActivity.gUser.getUserName());
		else
			tvUserName.setText(this.getString(R.string.nologin));

		// 版本
		tvVersion.setText(getString(R.string.version) + " V" + ActivityHelper.getVersion(this) + " ");

		mDialog.show();
	}

	final OnClickListener onOKListener = new OnClickListener() {

		public void onClick(View arg0) {

			if (arg0.getId() == R.id.btnOk) {
				mDialog.dismiss();
			} else if (arg0.getId() == R.id.btnClose) {
				mDialog.dismiss();
			}
		}

	};

	/**
	 * 选项设置
	 *
	 * @param index
	 * @return
	 */
	public boolean getUserItemPower(int index){

		if (gUser == null) {
			ActivityHelper.ToastShow(this, getString(R.string.noLoginWait));
			return false;
		}

		if (!gUser.getItemPower(index)) {
			ActivityHelper.ToastShow(this, getString(R.string.noPower));
			return false;
		}

		return true;
	}
	public void SendParam1(){
		// TODO Auto-generated method stub
		SendParam sendParam1 = new SendParam();
		sendParam1.parent = this;
		sendParam1.processor = new PendingapprovalProcessor2();
		getDataTrunsfer().request(sendParam1);
	}

}
