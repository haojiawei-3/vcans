package com.Vcan.activity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import com.vcans.Processor.AppManager;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPMenuProcessor;
import com.vcans.Processor.PendingapprovalProcessor;
import com.vcans.Processor.Skin;
import com.vcans.Processor.Versioncomparison;
import com.vcans.Processor.YPDownItemTitleProcessor;
import com.vcans.adapter.ImageSimpleAdapter;
import com.vcans.model.MenuU;
import com.vcans.model.ModuleInfo;
import com.vcans.model.SendParam;
import com.vcans.model.SysParam.ELanguage;
import com.vcans.model.User;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.DataTrunsfer;
import com.vcans.tool.GifView;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.JsonHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.DrawableRes;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.net.rtp.RtpStream;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import static com.Vcan.activity.DPErrorDetail.dPErrorDetail;

/**
 * 主界面 类
 * @author vcans
 *
 */
public class VCANSAppActivity extends BaseActivity {

	/**
	 * 样品权限列表的起始索引
	 */
	public static int mYpStart = 0;
	public static int mYpStart1 = 0;
	public static int mYpStart2 = 0;
	/**
	 * 底部菜单权限列表起始索引
	 */
	private int mBottomStart = 0;
	private int ypColorStartIndex=0;
	private int bottomColorStartIndex=0;
	private float startX = 0;
	private ViewFlipper viewFlipper;
	private TextView mTvPageNum;
	private String strUser = "";
	private String strPwd = "";
	private TextView tvTitle;
	private TextView tvTitleLogo;
	private String mStrTitle = "跟单大师";
	private TextView mTvNetStatus;
	private EditText txtContent;
	private Button Button;
	private GifView Button1;
	private ImageView tvTip,img1,img2,img3;
	private ImageView ivAdvert;
	private Dialog mDialog = null;
	private boolean bOpenCamera;
	private boolean hd=false;
	private int mAdvertImgRId;
	private int mAdvertImgYPRId;
	public int[] szColor;
	private ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
	private Bitmap[] szbitmap = null;
	private String page = "0",xiaoxi="1",xiaoxi1="1";
	private DPMenuProcessor mMenuProcessor;
	public static boolean bShowTip=false;
	//有权限的内部模块ID，背景颜色，事件 （实现当模块不启用时，不显示在在菜单列表中需要用）
	private   static ArrayList<String>  lstHasModuleIds=new ArrayList<String>();
	private ArrayList<Integer> lstHasColors=new ArrayList<Integer>();
	private ArrayList<String>  lstHasEvents=new ArrayList<String>();
	private   static ArrayList<String>  lstHasModuleIds1=new ArrayList<String>();
	private ArrayList<Integer> lstHasColors1=new ArrayList<Integer>();
	private ArrayList<String>  lstHasEvents1=new ArrayList<String>();
	private   static ArrayList<String>  lstHasModuleIds2=new ArrayList<String>();
	private ArrayList<Integer> lstHasColors2=new ArrayList<Integer>();
	private ArrayList<String>  lstHasEvents2=new ArrayList<String>();
	private ArrayList<MenuU>  mLstMenu;
	private ArrayList<MenuU> mLstMenu1=new ArrayList<MenuU>();
	private ArrayList<MenuU> mLstMenu2=new ArrayList<MenuU>();
	PendingapprovalProcessor downGoods=null;
	Versioncomparison downGoodss=null;
	SQLiteDatabase db;
	Context context;
	Cursor cursor;
	String dwsp,dwyd;
	String VersionId,TPId;
	String  biao;
	private View view1, view2, view3;
	 List<View> viewList ;
	private ViewPager mViewPager;
	private ViewPagerAdapter adapter;
	boolean allMenuDisabled=true;
	boolean allMenuDisabled1=true;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//initState();

		mMainActivity = this;
			 new Handler().postDelayed(new Runnable() {
				public void run() {
					timer.schedule(task, 0 , 30*60*1000 );//30*60*1000
				}
			 },10*1000*60 );//10*1000*60
		//启动宣传界面
		Intent intent=new Intent(VCANSAppActivity.this,SplashActivity.class);
		startActivity(intent);

		getSysLanguage();


		ActivityHelper.createDis();

		createDataTrunsfer();

		InitUISkin();

		this.<ImageView> RegOnClickEvent(R.id.imgNetStatus, "onTip");

		this.<ImageView> RegOnClickEvent(R.id.tvNetStatus, "onTip");
		this.<TextView> RegOnClickEvent(R.id.tvActtitle0, "showDialog");



		LayoutInflater lf = LayoutInflater.from(VCANSAppActivity.this);
		view1 = lf.inflate(R.layout.viewpager_item1, null);
		view2 = lf.inflate(R.layout.viewpager_item2, null);
		view3 = lf.inflate(R.layout.viewpager_item3, null);
		viewList = new ArrayList<View>();
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		mTvNetStatus = (TextView) findViewById(R.id.tvNetStatus);
		img1 = (ImageView)view1. findViewById(R.id.img);
		img2 = (ImageView)view2.findViewById(R.id.img);
		img3 = (ImageView)view3.findViewById(R.id.img);

		Display mDisplay = getWindowManager().getDefaultDisplay();
		int w = mDisplay.getWidth();
		int h = mDisplay.getHeight();
		//ActivityHelper.ToastShow(VCANSAppActivity.this,w+""+h+"");
		if (w>1080){
			setViewSize(img1,1600,743);
			setViewSize(img2,1600,743);
			setViewSize(img3,1600,743);
		}


		tvTip = (ImageView) findViewById(R.id.imgNetStatus);
		txtContent = (EditText) view2.findViewById(R.id.txtContent);
		Button = (Button) view2.findViewById(R.id.btnSearch);
		Button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				onSearch();
			}
		});

		Button1 = (GifView) view2.findViewById(R.id.btnScanBarcode);
		Button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				OnScanBarcode();
			}
		});
		tvTitle = (TextView) this.findViewById(R.id.tvActtitle);
		tvTitleLogo = (TextView) this.findViewById(R.id.tvActtitle0);


		mViewPager = (ViewPager) findViewById(R.id.vp);

		adapter = new ViewPagerAdapter();
		mViewPager.setAdapter(adapter);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
//
				if (allMenuDisabled) {
					if (position==0) {
						tvTitle.setText("样品管家");
						ItemTitleHelper.itemTitle.sysId = "样品";
					}else if (position==1) {
						tvTitle.setText("信息中心");
						ItemTitleHelper.itemTitle.sysId = "信息中心";
						getData();
					}
				} else {
					if (position==0) {
						tvTitle.setText("跟单大师");
						ItemTitleHelper.itemTitle.sysId = "跟单";
					}else if (position==1) {
						tvTitle.setText("样品管家");
						ItemTitleHelper.itemTitle.sysId = "样品";
					}else if (position==2) {
						tvTitle.setText("信息中心");
						ItemTitleHelper.itemTitle.sysId = "信息中心";
						getData();
					} }
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
			}
		});

		// 初始化参数
		InitParams();


		//初始化菜单
		InitMenu();


		//检查SD卡是否可读
		CheckSDCard();



		downGoods =new PendingapprovalProcessor();
	}




	public static void setViewSize(View view,int width,int height){
		ViewGroup.LayoutParams params = view.getLayoutParams();
		params.width = width;
		params.height = height;
		view.setLayoutParams(params);

	}






	private class ViewPagerAdapter extends PagerAdapter {

		public ViewPagerAdapter() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return viewList.size();
		}
		//
		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == object;
		}
		@Override
		public void destroyItem(ViewGroup view, int position, Object object) {
			((ViewPager) view).removeView(viewList.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup view, int position) {

			//看这里
			View v=viewList.get(position);
			ViewGroup parent = (ViewGroup) v.getParent();
			//Log.i("ViewPaperAdapter", parent.toString());
			if (parent != null) {
			//	parent.removeAllViews();
			}else {
				((ViewPager) view).addView(viewList.get(position));
			}
			return viewList.get(position);
		}
		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
			return POSITION_NONE;
		}

	}

	@Override
	protected void onResume() {

		super.onResume();

		if (bOpenCamera) {
			bOpenCamera = false;
			return;
		}
		if (allMenuDisabled) {
			tvTitle.setText("样品管家");
		}else {
			//tvTitle.setText(mStrTitle);
		}

		if (BaseActivity.bReconnect) {
			createDataTrunsfer();

			BaseActivity.bReconnect = false;
		} else {

		}

		if (BaseActivity.bConnected) {
			tvTip.setBackgroundResource(R.drawable.connected);
			mTvNetStatus.setVisibility(View.INVISIBLE);
		} else {
			tvTip.setBackgroundResource(R.drawable.disconnected);
			mTvNetStatus.setVisibility(View.VISIBLE);
		}

		if (ActivityHelper.bQueryYP == 1) {
			//InitGridViewMneu();
			ActivityHelper.bQueryYP = 0;
		}

		InitMenu();
	}


	public void getData(){

		if (!BaseActivity.bConnected) {
			ActivityHelper.showDialog(this, "", getString(R.string.serDisconnect));
			return ;
		}

		if (gUser == null) {
			ActivityHelper.ToastShow(this, getString(R.string.noLoginWait));
			return ;
		}else {
			SendParam sendParam = new SendParam();
			sendParam.bShowTipDlg=false;
			sendParam.parent = VCANSAppActivity.this;
			sendParam.processor = downGoods;
			getDataTrunsfer().request(sendParam);

			new Handler().postDelayed(new Runnable() {
				public void run() {
					dwsp=ActivityHelper.dwsp;
					dwyd=ActivityHelper.dwyd;
					InitGridViewXX(dwsp,dwyd);
				}
			}, 800);
		}


	}

	/**获取系统语言*/
	public void getSysLanguage()
	{
		HashMap<String,String> mapParms=ActivityHelper.getParams(this,
				new String[]{"language"});

		String strLanguage=mapParms.get("language");
		if(strLanguage.equals("ch"))
		{
			setLanguage(Locale.CHINA);
			ActivityHelper.globalSysParam.language=ELanguage.CH;
		}
		else if(strLanguage.equals("en"))
		{
			setLanguage(Locale.ENGLISH);
			ActivityHelper.globalSysParam.language=ELanguage.EN;
		}
		else
		{
			if(isZh())
			{
				ActivityHelper.globalSysParam.language=ELanguage.CH;
			}
			else
				ActivityHelper.globalSysParam.language=ELanguage.EN;
		}
	}

	//设置系统语言
	private void setLanguage(Locale lauguage)
	{
		Locale.setDefault(lauguage);
		Configuration config = getBaseContext().getResources().getConfiguration();
		config.locale = lauguage;
		getBaseContext().getResources().updateConfiguration(config
				, getBaseContext().getResources().getDisplayMetrics());
	}

	/**
	 * 是否为中文
	 * @return
	 */
	private boolean isZh() {
		Locale locale = getResources().getConfiguration().locale;
		String language = locale.getLanguage();
		if (language.endsWith("zh"))
			return true;
		else
			return false;
	}

	/**
	 * 初始化系統皮肤
	 */
	public void InitUISkin() {
		ActivityHelper.globalSysParam.sysSkin.themeColor = R.color.topRed;//主界面主题颜色（红）         PIblue

		ActivityHelper.globalSysParam.sysSkin.selectedColor = ActivityHelper.globalSysParam.sysSkin.themeColor;
		szColor = Skin.szColorDefault;
		for (int color : szColor) {
			ActivityHelper.globalSysParam.sysSkin.moduleColorList.add(color);
		}
	}

	public void CheckSDCard()
	{
		if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

			ActivityHelper.ToastShow(this, getString(R.string.noSDCard));

			new Handler().postDelayed(new Runnable() {

				public void run() {

					mbQuitFlag = true;
					quitSys();
					ActivityHelper.lstActivities.get(0).finish();
				}
			}, 5000);

		}
	}

	public void InitMenu()
	{

//		// 跟单大师-菜单初始化 维护
		int gdMneuNum=InitGridViewGD();

//		// 样品管家-菜单初始化
		mYpStart = gdMneuNum;
		int ypMenuNum=InitGridViewYP();
//

//		// 信息中心-菜单初始化 维护
		int xxMneuNum=InitGridViewXX(xiaoxi,xiaoxi1);
//
//		// 底部-菜单初始化
		mBottomStart = mYpStart + ypMenuNum;
		bottomColorStartIndex=this.ypColorStartIndex+ypMenuNum;
		InitBottomMenu();


	}












	/**初始化参数
	 */
	public void InitParams() {

		// 设置自定义字体
		tvTitleLogo.setTypeface(this.getTypeFace());
		tvTitle.setTypeface(this.getTypeFace());

		ItemTitleHelper.itemTitle.sysId = "跟单";
		if (ActivityHelper.globalSysParam.language == ELanguage.CH) {

			img1.setImageResource(R.drawable.advert);
			img2.setImageResource(R.drawable.advertyp);
			img3.setImageResource(R.drawable.xxzx);	    //等待一张新图片
			ItemTitleHelper.itemTitle.language =ItemTitleHelper.itemTitle.CH;

		} else {
			img1.setImageResource(R.drawable.advert_en);
			img2.setImageResource(R.drawable.advertyp_en);
			img3.setImageResource(R.drawable.xxzx);    //等待一张新图片
			ItemTitleHelper.itemTitle.language = ItemTitleHelper.itemTitle.EN;
		}

		//设置生产类型和投入颜色 默认为启用   隐藏app端的设置接口，避免修改程序。由服务端进行设置
		HashMap<String, String> tMapParms = new HashMap<String, String>();
		tMapParms.put("isInputProColor", "1");
		tMapParms.put("isInputProType", "1");
		tMapParms.put("inProType", "1");
		tMapParms.put("machProType","1");
		tMapParms.put("isEncrypto","0");

		ActivityHelper.saveParams(this, tMapParms);

		//标题设置的相关参数初始化
		ItemTitleHelper.itemTitle.moduleId="";
		ItemTitleHelper.bGetItemTitleFlag=true;
		mbQuitFlag=false;
		ItemTitleHelper.InitParamMap();

		//设置备用模块的备用中文编号与数字编号关联关系
		GDBakModule.mapBakModuleId.put("一", "1");
		GDBakModule.mapBakModuleId.put("二", "2");
		GDBakModule.mapBakModuleId.put("三", "3");
		GDBakModule.mapBakModuleId.put("四", "4");
		GDBakModule.mapBakModuleId.put("五", "5");
		GDBakModule.mapBakModuleId.put("六", "6");
		GDBakModule.mapBakModuleId.put("七", "7");
		GDBakModule.mapBakModuleId.put("八", "8");

		// 获取设置的参数 放在createDataTrunsfer之前，设置是否加密数据
		HashMap<String, String> mapParms = ActivityHelper.getParams(this, new String[] { "isEncrypto", "isCutPhoto",
				"ImgReduceRate", "ReduceNumber", "cutType", "cutRate", "page", "YpHistoryNum" });

		//是否为数据加密
		if (mapParms.get("isEncrypto").equals("1"))
			DataTrunsfer.ENABLED_DES_ZIP = true;
		else
			DataTrunsfer.ENABLED_DES_ZIP = false;

		//是否为剪切图片
		if (mapParms.get("isCutPhoto").equals("1")) {
			ActivityHelper.bCutPhoto = true;
		} else
			ActivityHelper.bCutPhoto = false;

		//菜单页
		page = mapParms.get("page");

		/*************图片处理相关参数  *********************/
		//图片缩减比例
		String strRate = mapParms.get("ImgReduceRate");
		if (!strRate.equals(""))
			ActivityHelper.imageReduceRate = Integer.valueOf(strRate);

		//剪切比例
		ActivityHelper.imageCutRate = mapParms.get("cutRate");
		if (!mapParms.get("cutType").equals(""))
			ActivityHelper.imageCutType = Integer.valueOf(mapParms.get("cutType"));

		//图片需要压缩的最小大小 小于该大小时不缩小
		if (!mapParms.get("ReduceNumber").equals(""))
			ActivityHelper.imageReduceMinSize = Integer.valueOf(mapParms.get("ReduceNumber"));

		//样品查询历史记录数
		if (!mapParms.get("YpHistoryNum").equals(""))
			ActivityHelper.globalSysParam.nYpQueryHistoryNum = Integer.valueOf(mapParms.get("YpHistoryNum"));
		// end 获取参数
	}
















	public void OnScanBarcode() {
		bOpenCamera = true;
		onOpenScanBarcode();
	}

	@Override
	protected void onDestroy() {
		ActivityHelper.recycleBitmaps(szbitmap);
		super.onDestroy();
	}


	public String hondian(){
		if (DataTrunsfer.isDownloadContinue()==false) {
			if (BaseActivity.gUser != null) {
				SendParam sendParam = new SendParam();
				sendParam.bShowTipDlg = false;
				sendParam.parent = this;
				sendParam.processor = downGoods;
				getDataTrunsfer().request(sendParam);

			}
		}else {
			ActivityHelper.ToastShow(VCANSAppActivity.this,"消息指令发送失败");
		}
		new Handler().postDelayed(new Runnable() {
			public void run() {
				dwsp=ActivityHelper.dwsp;
				dwyd=ActivityHelper.dwyd;
				System.out.println(dwsp+dwyd+"红点消息数目");
				InitGridViewXX(dwsp,dwyd);
			}
		}, 500);

		return dwsp;
	}







	public void autoLogin() {

		// 获取IP端口
		HashMap<String,String> mapValues= JsonHelper.GetJsonData();

		if (mapValues.size()<1)
			ActivityHelper.showDialog(this, "错误", getString(R.string.noSetIpAndPort));

		HashMap<String, String> mapParms = ActivityHelper.getParams(this,
				new String[] { "isSave", "isAutoLogin", "user_name", "password" });

		// 处理自动登录 此代码需放到InitBottomMenu()之前
		if (mapParms.size() > 0 ) {
			if (mapParms.get("isSave").equals("1") && mapParms.get("isAutoLogin").equals("1")) {
				strUser = mapParms.get("user_name");
				strPwd = mapParms.get("password");

				String[] szData = { strUser, strPwd };

				SendParam sendParam = new SendParam();
				sendParam.bShowTipDlg=bShowTip;
				sendParam.parent = this;
				sendParam.tip = getString(R.string.autoLoginning);
				mMenuProcessor = new DPMenuProcessor();
				mMenuProcessor.setLstMenu(mLstMenu);
				mMenuProcessor.setLstMenu2(ItemTitleHelper.getMenuxx());
				sendParam.processor = mMenuProcessor;
				sendParam.szData = szData;
				getDataTrunsfer().request(sendParam);

				new Handler().postDelayed(new Runnable() {

					public void run() {

						if (BaseActivity.gUser == null) {
							ActivityHelper.showDialog(VCANSAppActivity.this, "错误", getString(R.string.loginFail));
						}
					}
				}, 30000);
			} else {
				BaseActivity.gUser = null;
			}
		}
	}




	/**
	 * 配置版本对比
	 */

	public void Version(String s)
	{
		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.tip = getString(R.string.Version);
		sendParam.processor = new Versioncomparison(s);
		getDataTrunsfer().request(sendParam);
	}
	/**
	 * 加载界面标题
	 */
	public void DownloadUIItemTitle()
	{
		allMenuDisabled=true;
		allMenuDisabled1=true;
		SendParam sendParam = new SendParam();
		sendParam.bShowTipDlg=bShowTip;
		sendParam.parent = this;
		sendParam.tip = getString(R.string.loadItemTitle);
		sendParam.processor = new YPDownItemTitleProcessor();
		getDataTrunsfer().request(sendParam);
	}

	public void onTip() {

		if (this.getDataTrunsfer().isSocketFreeDisconnect()) {
			mTvNetStatus.setText(getString(R.string.connecting));
			this.getDataTrunsfer().startThreadConnectServer();
			//this.getDataTrunsfer().CloseSocketConnect();
			//createDataTrunsfer();
		} else {
			showDialog();
		}
	}


	/**
	 * 获取当前用户权限
	 * @param index
	 */
	public boolean getUserPower(int index) {
		if (!BaseActivity.bConnected) {
			ActivityHelper.showDialog(this, "", getString(R.string.serDisconnect));
			return false;
		}

		if (gUser == null) {
			ActivityHelper.ToastShow(this, getString(R.string.noLoginWait));
			return false;
		}

		if (!gUser.getPower(index)) {
			ActivityHelper.ToastShow(this, getString(R.string.noPower));
			return false;
		}

		if(index>=lstHasModuleIds.size()&&index<mYpStart)
		{
			ActivityHelper.ToastShow(this, "index out of lstHasModuleIds");
			return false;
		}

		return true;
	}







	/**
	 * 跟单大师
	 * 返回值  菜单数量
	 * 注意 新增菜单时要，需要同时新增 事件，名称，标题管理(ItemTitleHelper)中模块数组，图标，图标背景颜色(Skin类中)
	 */
	private int InitGridViewGD() {

		//事件
		String[] szMethodNames = {
				"onOpenPeibuin",
				"onOpenTouPei",
				"onOpenProductIn",
				"onOpenMachining",
				"onOpenDirectOut",
				"onOpenRZTask",
				"onOpenRZTask2",
				"onOpenRZCost",
				"onBakModule",
				"onBakModule",
				"onBakModule",
				"onBakModule",
				"onBakModule",
				"onBakModule",
				"onGDQuery",
				"onGDQuery",
				"onGDQuery",
				"onGDQuery",
				"onOpenBakModule",
				"onOpenBakModule",
				"onOpenBakModule",
				"onOpenBakModule",
				"onOpenBakModule",
				"onOpenByModule",
				"onOpenByModule",
				"onOpenByModule",
				"onOpenByModule",
				"onOpenByModule",
				"GDQuery",
				"GDQuery",
				"GDQuery",
				"GDQuery",
				"GDQuery",
//				"GDQuery",
//				"GDQuery",
//				"GDQuery"
		};

		ypColorStartIndex=szMethodNames.length;

		//如果无配制的菜单标题时使用些默认菜单名     23
		String[] szMenuName = {
				getString(R.string.peibuin),
				getString(R.string.toupei),
				getString(R.string.productin),
				getString(R.string.machining),
				getString(R.string.gdDirectOut),
				getString(R.string.rztask),
				getString(R.string.rztask2),
				getString(R.string.rzCost),
				getString(R.string.gdBakModule1),//备用模块一
				getString(R.string.gdBakModule2),//备用模块二
				getString(R.string.gdBakModule3),//备用模块三
				getString(R.string.gdBakModule4),//备用模块四
				getString(R.string.gdBakModule5),//备用模块五
				getString(R.string.gdBakModule6),//备用模块六
				getString(R.string.gdQuery),//综合查询一
				getString(R.string.gdQuery),//综合查询二
				getString(R.string.gdQuery),//综合查询三
				getString(R.string.gdQuery),//综合查询四
				getString(R.string.xgdBakModule1),//备用模块01
				getString(R.string.xgdBakModule2),//备用模块02
				getString(R.string.xgdBakModule3),//备用模块03
				getString(R.string.xgdBakModule4),//备用模块04
				getString(R.string.xgdBakModule5),//备用模块05
				getString(R.string.xgdBakModule6),//备用模块06
				getString(R.string.xgdBakModule7),//备用模块07
				getString(R.string.xgdBakModule8),//备用模块08
				getString(R.string.xgdBakModule9),//备用模块09
				getString(R.string.xgdBakModule10),//备用模块10
				getString(R.string.gdQuery01),//备用模块06
				getString(R.string.gdQuery02),//备用模块07
				getString(R.string.gdQuery03),//备用模块08
				getString(R.string.gdQuery04),//备用模块09
				getString(R.string.gdQuery05),//备用模块10
//				getString(R.string.gdQuery06),//备用模块08
//				getString(R.string.gdQuery07),//备用模块09
//				getString(R.string.gdQuery08),//备用模块10
		};




		//默认菜单图标
		int[] szIconId = {
				R.drawable.menu_peibuin,
				R.drawable.menu_toupei,
				R.drawable.menu_productin,
				R.drawable.menu_maching,
				R.drawable.menu_directout,
				R.drawable.menu_directout2,
				R.drawable.menu_task,
				R.drawable.menu_cost,

				R.drawable.menu_peibuin2,  //备用模块一
				R.drawable.menu_toupei2,   //备用模块二
				R.drawable.menu_productin2,//备用模块三
				R.drawable.menu_maching2,  //备用模块四
				R.drawable.menu_task2,	   //备用模块五
				R.drawable.menu_cost2,	   //备用模块六

				R.drawable.menu_gdquery1,//综合查询一
				R.drawable.menu_gdquery2,//综合查询二
				R.drawable.menu_gdquery3,//综合查询三
				R.drawable.menu_gdquery4,//综合查询四


				R.drawable.menu_peibuin3,  //备用模块1
				R.drawable.menu_toupei3,   //备用模块2
				R.drawable.menu_productin3,//备用模块3
				R.drawable.menu_maching3,  //备用模块4
				R.drawable.menu_task3,	   //备用模块5
				R.drawable.menu_cost3,     //备用模块6
				R.drawable.menu_directout3,//备用模块7
				R.drawable.menu_cost3,     //备用模块8
				R.drawable.menu_directout3,//备用模块9
				R.drawable.menu_directout2, //备用模块10

				R.drawable.menu_gdquery1,//综合查询01
				R.drawable.menu_gdquery2,//综合查询02
				R.drawable.menu_gdquery3,//综合查询03
				R.drawable.menu_gdquery4,//综合查询04
				R.drawable.menu_gdquery1,//综合查询05

		};


		//获取已保存在数据库中的配制的菜单标题
		mLstMenu=ItemTitleHelper.getMenuInfo();
		//获取已保存在数据库中的备用模块控件配制
		ActivityHelper.MenuKLists1= ItemTitleHelper.getMenuInfo2();
        ActivityHelper.GDQueryMenuKLists= ItemTitleHelper.getMenuInfo3();
		//ActivityHelper.GDQueryMenuKLists= ItemTitleHelper.getMenuInfo4();
		if(mLstMenu.size()<1)
		{
			//添加默认菜单
			for(int i=0;i<szMenuName.length;++i)
			{
				MenuU menu=new MenuU();
				menu.name=szMenuName[i];
				menu.nameCh=szMenuName[i];
				menu.iconId=i+1;
				menu.strEnabled="Y";
				menu.sortId=i+1;
				mLstMenu.add(menu);
			}

		}

		//初始事件 颜色
		for(int i=0;i<mLstMenu.size();++i)
		{
			mLstMenu.get(i).eventName=szMethodNames[i];

			if(i<ActivityHelper.globalSysParam.sysSkin.moduleColorList.size())
				mLstMenu.get(i).colorId=ActivityHelper.globalSysParam.sysSkin.moduleColorList.get(i);
			else
				mLstMenu.get(i).colorId=ActivityHelper.globalSysParam.sysSkin.moduleColorList.get(0);
		}


		//注意 ：颜色值数量也要与菜单名称一致  颜色在com.vcans.Skin对像中设置
		if(szMethodNames.length!=szMenuName.length||szMethodNames.length!=mLstMenu.size())
		{
			ActivityHelper.ToastShow(this, "跟单菜单名、事件及图标数量不一致");
			return 0;
		}

		//mYpStart 会在下面方法被设置值
		InitGridViewGD(mLstMenu,szIconId);

		return mYpStart;
	}

	/**
	 * @param lstMenu
	 * @param szDefaultIcon
	 */
	private void InitGridViewGD(ArrayList<MenuU> lstMenu,int[] szDefaultIcon) {

		GridView gridview = (GridView)view1.findViewById(R.id.gridview);

		// 生成动态数组，并且转入数据
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();

		// item颜色 某view shape的颜色
		lstHasEvents.clear();
		lstHasColors.clear();
		lstHasModuleIds.clear();

		ModuleInfo.sort(lstMenu);



		for (int i = 0; i < lstMenu.size(); ++i) {

			MenuU menu=lstMenu.get(i);

			//判断菜单是否启用a
			if(menu.strEnabled.equals("Y"))
			{
				allMenuDisabled=false;
				//名称与图标
				HashMap<String, Object> map3 = new HashMap<String, Object>();
				if(menu.iconId-1<szDefaultIcon.length){
					map3.put("ivItemImage", szDefaultIcon[menu.iconId-1]);
				}// 添加图像资源的ID
				else{
					map3.put("ivItemImage", R.drawable.menu_null);
				}// 添加图像资源的ID
				map3.put("tvItemText", menu.nameCh);    ////////////////////////////
				lstImageItem.add(map3);

				//有权限模块ID
				lstHasModuleIds.add(menu.modulesId);

				//有权限颜色
				lstHasColors.add(menu.colorId);

				//有权限事件
				lstHasEvents.add(menu.eventName);
			}


		}



		//根据实际启用的跟单菜单数来设置样品菜单起始索引（该索引用来做定位权限列表）
		mYpStart=lstHasModuleIds.size();

		if(allMenuDisabled)
		{//无启用的跟单菜单时，显示样品菜单
			tvTitle.setText("样品管家");
			viewList.clear();
			viewList.add(view2);
			viewList.add(view3);
			adapter.notifyDataSetChanged();
		}
		//20171110
		//The specified child already has a parent. You must call removeView() on the child's parent first.
		//没有找到问题的解决方法 如果这样刷新viewpager

		   else {
			//20171127   《 public Object instantiateItem(ViewGroup view, int position) {   》   看这个方法
			    viewList.clear();
			    viewList.add(view1);
				viewList.add(view2);
				viewList.add(view3);
		        adapter.notifyDataSetChanged();
		}





		//注册列表的单元单击事件
		this.<GridView> RegItemOnClickEvent(view1,R.id.gridview, lstHasEvents.toArray(new String[0]));

		ImageSimpleAdapter saImageItems = new ImageSimpleAdapter(this, // 没什么解释
				lstImageItem, // 数据来源
				R.layout.main_item_icon,
				// 动态数组与ImageItem对应的子项
				new String[] { "ivItemImage", "tvItemText" },
				// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] { R.id.ivItemImage, R.id.tvItemText },
				// item中某view的shape颜色
				lstHasColors.toArray(new Integer[0]));
		// 添加并且显示
		gridview.setAdapter(saImageItems);
	}



	/**
	 * 样品管家
	 * 返回值 样品菜单数量
	 * 注意  新增菜单时要，需要同时新增 事件，名称，图标，图标背景颜色(Skin类中)及上传到服务端认证的样品菜单名称（供权限功能使用  在DPMenuProcessor类中）
	 */
	private int InitGridViewYP() {

		//菜单事件
		String[] szYPMethods = {    "onOpenQRCodeScan",
				"onOpenXYRegister",
				"onOpenBarcodeImage",
				"onOpenmpsb" ,
				"onOpenqdmk1" ,
				"onOpenqdmk2" ,
				"onOpenqdmk3"
		};


		//菜单名称
		String[] szThisMenu = { getString(R.string.YPQuery),
				getString(R.string.exposition),
				getString(R.string.YPImage),
				getString(R.string.mpsb),
				getString(R.string.qdmk),
				getString(R.string.qdmk),
				getString(R.string.qdmk)
		};

		int[] m_szIconId = {    R.drawable.menu_ypquery,
				R.drawable.menu_exposition,
				R.drawable.menu_ypimg,
				R.drawable.menu_ypimg,
				R.drawable.menu_toupei3,
				R.drawable.menu_gdquery4,
				R.drawable.menu_toupei3
		};



		mLstMenu1=ItemTitleHelper.getMenuInfo1();

		if(mLstMenu1.size()<1)
		{
			//添加默认菜单
			for(int i=0;i<szThisMenu.length;++i)
			{
				MenuU menu=new MenuU();
				menu.name=szThisMenu[i];
				menu.nameCh=szThisMenu[i];
				menu.iconId=i+1;


				if (i==4||i==5||i==6) {
					menu.strEnabled="N";
				}else {
					menu.strEnabled="Y";
				}

				menu.sortId=i+1;
				mLstMenu1.add(menu);
			}
		}

		//初始事件 颜色
		for(int i=0;i<mLstMenu1.size();++i)
		{
			mLstMenu1.get(i).eventName=szYPMethods[i];

			if(i<ActivityHelper.globalSysParam.sysSkin.moduleColorList.size())
				mLstMenu1.get(i).colorId=ActivityHelper.globalSysParam.sysSkin.moduleColorList.get(i+mLstMenu.size());
			else
				mLstMenu1.get(i).colorId=ActivityHelper.globalSysParam.sysSkin.moduleColorList.get(0);

		}

		//注意 ：颜色值数量也要与菜单名称一致 颜色在com.vcans.Skin对像中设置
		if(szThisMenu.length!=m_szIconId.length||szYPMethods.length!=szThisMenu.length)
		{
			ActivityHelper.ToastShow(this, "样品菜单名,事件及图标数量不一致");
			return 0;
		}

		InitGridViewYP(mLstMenu1, m_szIconId);

		return mYpStart1;
	}



	private void InitGridViewYP(ArrayList<MenuU> lstMenu,int[] szDefaultIcon) {
		GridView gridview = (GridView)view2. findViewById(R.id.gridview2);
		// 生成动态数组，并且转入数据
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		//ArrayList<Integer> lstColors=new ArrayList<Integer>();


		lstHasEvents1.clear();
		lstHasColors1.clear();
		lstHasModuleIds1.clear();

		ModuleInfo.sort(lstMenu);

		for (int i = 0; i < lstMenu.size(); ++i) {

			MenuU menu=lstMenu.get(i);

			//判断菜单是否启用
			if(menu.strEnabled.equals("Y"))
			{

				//名称与图标
				HashMap<String, Object> map3 = new HashMap<String, Object>();
				if(menu.iconId-1<szDefaultIcon.length){
					map3.put("ivItemImage", szDefaultIcon[menu.iconId-1]);
				}// 添加图像资源的ID
				else{
					map3.put("ivItemImage", R.drawable.menu_null);
				}// 添加图像资源的ID
				String s=menu.nameCh;
				map3.put("tvItemText", s);

				lstImageItem.add(map3);

				//有权限模块ID
				lstHasModuleIds1.add(menu.nameCh);

				//有权限颜色
				lstHasColors1.add(menu.colorId);

				//有权限事件
				lstHasEvents1.add(menu.eventName);
			}

			mYpStart1=lstHasModuleIds1.size();

//					if(i<ActivityHelper.globalSysParam.sysSkin.moduleColorList.size())
//					{
//						lstColors.add(ActivityHelper.globalSysParam.sysSkin.moduleColorList.get(ypColorStartIndex+i));
//					}
//					else
//						lstColors.add(ActivityHelper.globalSysParam.sysSkin.moduleColorList.get(0));
		}


		//事件 样品菜单实现是否启用时，将会用到
		//lstHasEvents.add(szYPMethods[i]);


		//添加有权模块颜色列表中
//				for(Integer colorId:lstColors)
//					lstHasColors1.add(colorId);

		//注册列表单元单击事件
		this.<GridView> RegItemOnClickEvent(view2,R.id.gridview2,lstHasEvents1.toArray(new String[0]));

		ImageSimpleAdapter saImageItems = new ImageSimpleAdapter(this, // 没什么解释
				lstImageItem, // 数据来源
				R.layout.main_item_icon,
				// 动态数组与ImageItem对应的子项
				new String[] { "ivItemImage", "tvItemText" },
				// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] { R.id.ivItemImage, R.id.tvItemText },
				lstHasColors1.toArray(new Integer[0]));
		// 添加并且显示
		gridview.setAdapter(saImageItems);

	}




	/**
	 * 信息中心
	 * 返回值 信息中心菜单数量
	 * 注意  新增菜单时要，需要同时新增 事件，名称，图标，图标背景颜色(Skin类中)及上传到服务端认证的样品菜单名称（供权限功能使用  在DPMenuProcessor类中）
	 */
	private int InitGridViewXX(String xiaoxi,String xiaoxi1) {

		//菜单事件

		String[] szYPMethods = { "onOpendwsp",
				"onOpenwysp",
				"onOpenyywp",
				"onOpenzhcx",
				"onOpenzhcx",
				"onOpenzhcx"};

		//菜单名称

		String[] szThisMenu = { getString(R.string.dwsp),
				getString(R.string.wysp),
				getString(R.string.yywp),
				getString(R.string.gdQuery06),
				getString(R.string.gdQuery07),
				getString(R.string.gdQuery08)};

		//菜单图标
		int[] m_szIconId = { R.drawable.menu_gdquery1,
				R.drawable.menu_gdquery2,
				R.drawable.menu_gdquery3,
				R.drawable.menu_toupei3,
				R.drawable.menu_gdquery4,
				R.drawable.menu_toupei3};
		//模仿消息
		// xiaoxi="1";

		//消息红点配置
		int[] Id = { 1, 2, 3, 4, 5,6};
		String[] shu = { "0","0", "0", "0", "0", "0"};
		if(dwsp!=null){
			if (!dwsp.equals("0")) {
				int a = Integer.parseInt(dwsp);
				if (a>99) {
					shu[0]="99+";
				}else {
					shu[0]=dwsp;
				}
				if (!shu[0].equals("")) {
					Id[0]=R.drawable.shape1;
					//dwsp=null;
				}
			}

		}
//		if(dwyd!=null){
//			if (! dwyd.equals("0")) {
//				shu[3]=dwyd;
//				if (!shu[0].equals("")) {
//					Id[3]=R.drawable.shape1;
//					//dwyd=null;
//				}
//			}
//
//		}

		mLstMenu2=ItemTitleHelper.getMenuxx();



		if(mLstMenu2.size()<1)
		{
			//添加默认菜单
			for(int i=0;i<szThisMenu.length;++i)
			{
				MenuU menu=new MenuU();
				menu.name=szThisMenu[i];
				menu.nameCh=szThisMenu[i];
				menu.iconId=i+1;


				if (i==3||i==4||i==5) {
					menu.strEnabled="N";
				}else {
					menu.strEnabled="Y";
				}

				menu.sortId=i+1;
				mLstMenu2.add(menu);
			}
		}

		//初始事件 颜色
		for(int i=0;i<mLstMenu2.size();++i)
		{
			mLstMenu2.get(i).eventName=szYPMethods[i];

			if(i<ActivityHelper.globalSysParam.sysSkin.moduleColorList.size())
				mLstMenu2.get(i).colorId=ActivityHelper.globalSysParam.sysSkin.moduleColorList.get(i+mLstMenu.size());
			else
				mLstMenu2.get(i).colorId=ActivityHelper.globalSysParam.sysSkin.moduleColorList.get(0);

		}

		//注意 ：颜色值数量也要与菜单名称一致 颜色在com.vcans.Skin对像中设置
		if(szThisMenu.length!=m_szIconId.length||szYPMethods.length!=szThisMenu.length)
		{
			ActivityHelper.ToastShow(this, "样品菜单名,事件及图标数量不一致");
			return 0;
		}

		InitGridViewXX(mLstMenu2, m_szIconId, Id, shu);

		return mYpStart2;

	}


	private void InitGridViewXX(ArrayList<MenuU> lstMenu,int[] szDefaultIcon,int[] Id,String[] shu) {
		GridView gridview = (GridView)view3. findViewById(R.id.gridview3);
		// 生成动态数组，并且转入数据
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		//ArrayList<Integer> lstColors=new ArrayList<Integer>();


		lstHasEvents2.clear();
		lstHasColors2.clear();
		lstHasModuleIds2.clear();

		ModuleInfo.sort(lstMenu);

		for (int i = 0; i < lstMenu.size(); ++i) {

			MenuU menu=lstMenu.get(i);

			//判断菜单是否启用
			if(menu.strEnabled.equals("Y"))
			{

				//名称与图标
				HashMap<String, Object> map3 = new HashMap<String, Object>();
				map3.put("hondian", Id[i]);
				map3.put("hondians", shu[i]);
				if(menu.iconId-1<szDefaultIcon.length){
					map3.put("ivItemImage", szDefaultIcon[menu.iconId-1]);
				}// 添加图像资源的ID
				else{
					map3.put("ivItemImage", R.drawable.menu_null);
				}// 添加图像资源的ID
				String s=menu.nameCh;
				map3.put("tvItemText", s);

				lstImageItem.add(map3);

				//有权限模块ID
				lstHasModuleIds2.add(menu.modulesId);

				//有权限颜色
				lstHasColors2.add(menu.colorId);

				//有权限事件
				lstHasEvents2.add(menu.eventName);
			}

			mYpStart2=lstHasModuleIds2.size();

		}

		//注册列表单元单击事件
		this.<GridView> RegItemOnClickEvent(view3,R.id.gridview3,lstHasEvents2.toArray(new String[0]));

		ImageSimpleAdapter saImageItems = new ImageSimpleAdapter(this, // 没什么解释
				lstImageItem, // 数据来源
				R.layout.mian_itme_icon1,
				// 动态数组与ImageItem对应的子项
				new String[] { "ivItemImage", "tvItemText", "hondian","hondians"},
				// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] { R.id.ivItemImage, R.id.tvItemText , R.id.hondian,R.id.hondians},
				lstHasColors1.toArray(new Integer[0]));

		gridview.setAdapter(saImageItems);

	}

	/*
	 * 界面图片列表 （暂无用）
	 */

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	/**
	 * 初始化底部菜单
	 */
	private void InitBottomMenu() {

		String[] szMethodNames3 = { "onLogin", "onShowMenuImage", "onOpenSetActivity", "onTemp" };//
		this.<GridView> RegItemOnClickEvent(R.id.gvBottomMenu, szMethodNames3);

		GridView gridview = (GridView) findViewById(R.id.gvBottomMenu);

		// 生成动态数组，并且转入数据match_parent
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> map = new HashMap<String, Object>();
		if (BaseActivity.gUser == null)
		{
			map.put("ivItemImage", R.drawable.login);
		}// 添加图像资源的ID
		else{
			map.put("ivItemImage", R.drawable.login_success);
		}// 添加图像资源的ID

		map.put("tvItemText", getString(R.string.login));
		lstImageItem.add(map);

		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("ivItemImage", R.drawable.favorite);// 添加图像资源的ID
		map1.put("tvItemText", getString(R.string.favorite));
		lstImageItem.add(map1);

		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("ivItemImage", R.drawable.set);// 添加图像资源的ID
		map2.put("tvItemText", getString(R.string.set));
		lstImageItem.add(map2);

		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("ivItemImage", R.drawable.history);// 添加图像资源的ID
		map3.put("tvItemText", getString(R.string.history));
		lstImageItem.add(map3);

		if(szMethodNames3.length!=lstImageItem.size())
		{
			ActivityHelper.ToastShow(this, "底部菜单名与事件数量不一致");
			return;
		}

		SimpleAdapter saImageItems = new SimpleAdapter(this,
				lstImageItem, // 数据来源
				R.layout.main_item_bottom_icon,
				// 动态数组与ImageItem对应的子项
				new String[] { "ivItemImage", "tvItemText" },
				// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] { R.id.ivItemImage, R.id.tvItemText });
		// 添加并且显示
		gridview.setAdapter(saImageItems);
	}





	private void quitSys() {

		mbQuitFlag = true;
		gUser = null;
		ActivityHelper.showDialog(this, "", getString(R.string.quit) + "....");
		this.getDataTrunsfer().CloseSocketConnect();


		new Handler().postDelayed(new Runnable() {

			public void run() {

				while (true) {

					if (getDataTrunsfer().isSocketClose()) {

						VCANSAppActivity.super.finish();
						//ActivityHelper.lstActivities.get(0).finish();
						break;
					}

					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}
		}, 1500);
	}

	@Override
	public void finish() {

		if (!mbQuitFlag) {
			new AlertDialog.Builder(this).setTitle(getString(R.string.askQuit))
					.setIcon(android.R.drawable.ic_dialog_info)
					.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {

							quitSys();

						}
					}).setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					// 点击“返回”后的操作,这里不设置没有任何操作
				}
			}).show();
		} else {
			quitSys();
		}
	}


	private Handler handler  = new Handler(){
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if(msg.what == 1){
				hondian();
				if (dwsp!=null&&dwyd!=null) {
					if (dwsp.equals("0")&&dwyd.equals("0")) {

					}else {
						PendingIntent();
					}
				}
			}
		}
	};
	private void PendingIntent(){
		NotificationCompat.Builder mBuilder =
				        new NotificationCompat.Builder(this)
						.setSmallIcon(R.drawable.logo0)
						.setContentTitle("信息中心消息更新")
						.setContentText("待我审批"+(dwsp)+"待我阅读"+(dwyd));
		Intent resultIntent = new Intent(this, VCANSAppActivity.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(VCANSAppActivity.class);
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		mBuilder.setAutoCancel(true);
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(1, mBuilder.build());
	}

	private Timer timer = new Timer(true);

	//任务
	private TimerTask task = new TimerTask() {
		public void run() {
			Message msg = new Message();
			msg.what = 1;
			handler.sendMessage(msg);
		}
	};


	private String data(){
		db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
		cursor = db.rawQuery("select * from Version where VId = "+"'版本号'"+" ", new String[]{});
		while (cursor.moveToNext()) {
			VersionId = cursor.getString(2);
		}
		return VersionId;
	}



	@Override
	public void processMessage(int msgId, String msg) {

		switch (msgId) {
			case DPMenuProcessor.LOGIN_SUCCESS:
				// 登录成功
				User user = new User();
				user.setUserName(strUser);
				user.setPwd(strPwd);
				user.setSzPower(mMenuProcessor.getSzMenuEnable());
				user.setSzItemPower(mMenuProcessor.getSZItemEnable());
				BaseActivity.gUser = user;

				ActivityHelper.gToupei.strUser = user.getUserName();
				ActivityHelper.gToupei.strPwd = user.getPwd();

				if(!bShowTip)
					ActivityHelper.ToastShow(this, getString(R.string.autoLogined));
					AppManager.getAppManager().finishActivity(DPErrorDetail.dPErrorDetail);
				    this.InitBottomMenu();
				    hondian();

				if (BaseActivity.bConnected) {
					tvTip.setBackgroundResource(R.drawable.connected);
					mTvNetStatus.setVisibility(View.INVISIBLE);
				} else {
					tvTip.setBackgroundResource(R.drawable.disconnected);
					mTvNetStatus.setVisibility(View.VISIBLE);
				}

				break;
			case DataTrunsfer.DOWNLOAD_TITLE:

				if(ItemTitleHelper.bGetItemTitleFlag)
				{
					biao= data();
					if (biao==null) {
						db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);
						ContentValues values = new ContentValues();
						values.put("VId","版本号");
						values.put("VersionId","null");
						db.insert("Version", null, values);
					}
					//得到下载来的  版本号   ActivityHelper.Version
					Version(biao);

					ItemTitleHelper.bGetItemTitleFlag=false;
				}
				else{
					autoLogin();

				}

				break;
			case YPDownItemTitleProcessor.DOWNLOAD_TITLE_DONE:
				InitGridViewGD();
				InitGridViewYP();
				autoLogin();
				break;
			case 200:


				if (biao==null) {
					DownloadUIItemTitle();
					ContentValues values = new ContentValues();
					values.put("VersionId",ActivityHelper.Version);
					db.update("Version", values, "VId=?", new String[]{"版本号"});
					String s=  data();
					autoLogin();
				}else if(!biao.equals("")) {
					if (biao.equals(ActivityHelper.Version)) {
						ActivityHelper.ToastShow(VCANSAppActivity.this, "配置版本号相同");
						autoLogin();
					}else {
						DownloadUIItemTitle();
						ContentValues values = new ContentValues();
						values.put("VersionId",ActivityHelper.Version);
						db.update("Version", values, "VId=?", new String[]{"版本号"});
						autoLogin();

					}
				}else {
					ActivityHelper.ToastShow(VCANSAppActivity.this, "错误");
				}


				break;
			default:
				int nSize = ActivityHelper.lstActivities.size();
				if (nSize > 0) {
					BaseActivity topActivity = null;

					for (int i = nSize; i > 0; i--) {
						topActivity = ActivityHelper.lstActivities.get(i - 1);
						if (topActivity != null) {
							topActivity.ShowNetStatus(msgId);
							break;
						}
					}
				}
				break;

		}

	}


	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub

		super.onRestart();
	}







	/**
	 * 选项设置
	 *
	 * @param index
	 * @return
	 */
	public boolean getUserItemPower(int index) {

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


	/**
	 * 查询
	 * @param
	 */

	public void onSearch() {


		//ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[this.mYpStart];

		String key = txtContent.getText().toString().trim();
		if (key.equals("")) {
			ActivityHelper.ToastShow(this, getString(R.string.inputKey));
			return;
		}

		Intent intent = new Intent(this, YPQueryAll.class);
		intent.putExtra("content", key);
		startActivity(intent);
		//txtContent.setText("");
	}






	/**
	 * 待我审批
	 * @param index
	 */
	public void onOpendwsp(int index)
	{
//	if (!getUserPower(index))
		//		return;
		dwsp=0+"";
		InitGridViewXX(dwsp,dwyd);
		ActivityHelper.dwsp=0+"";
		ActivityHelper.dwyd=0+"";
		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds2.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index];
		this.setMTitle(getString(R.string.dwsp), R.id.tvActtitle);
		Intent intent = new Intent(this,Pendingapproval.class);
		startActivity(intent);
		//Toast.makeText(VCANSAppActivity.this, "待我审批", 500).show();
	}


	/**
	 * 我已审批
	 * @param index
	 */
	public void onOpenwysp(int index)
	{
//		if (!getUserPower(index))
//		return;
		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds2.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index];
		this.setMTitle(getString(R.string.wysp), R.id.tvActtitle);
		Intent intent = new Intent(this,Alreadyapprove.class);
		startActivity(intent);
		//Toast.makeText(VCANSAppActivity.this, "我已审批", 500).show();
	}


	/**
	 * 已阅未批
	 * @param index
	 */
	public void onOpenyywp(int index)
	{
//		if (!getUserPower(index))
//		return;
		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds2.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index];
		this.setMTitle(getString(R.string.yywp), R.id.tvActtitle);
		Intent intent = new Intent(this,Notapproved.class);
		startActivity(intent);
		//Toast.makeText(VCANSAppActivity.this, "已阅未批", 500).show();
	}

	/**
	 *     zhcx模块
	 * @param index
	 */

	public void onOpenzhcx(int index)
	{

		if (!getUserPower(this.mYpStart +4+index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds2.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index];
		GDQuery1.gQueryFlag=ItemTitleHelper.itemTitle.moduleId;
		this.setMTitle(ItemTitleHelper.itemTitle.moduleId, R.id.tvActtitle);
		Intent intent = new Intent(this,GDQuery1.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
	}






	/**
	 * 进入 坯布进仓
	 * @param index
	 */
	public void onOpenPeibuin(int index) {
		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		this.setMTitle(getString(R.string.peibuin), R.id.tvActtitle);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);
		Intent intent = new Intent(this, DPPeibuIn.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		//Toast.makeText(VCANSAppActivity.this, "进入 坯布进仓", 500).show();
	}

	/**
	 * 进入 生产投坯
	 * @param index
	 */
	public void onOpenTouPei(int index) {
		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);
		this.setMTitle(getString(R.string.toupei), R.id.tvActtitle);
		Intent intent = new Intent(this, DPTouPei.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		//Toast.makeText(VCANSAppActivity.this, "进入 生产投坯", 500).show();
	}

	/**
	 * 进入成品进仓
	 */
	public void onOpenProductIn(int index) {
		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);
		this.setMTitle(getString(R.string.productin), R.id.tvActtitle);
		Intent intent = new Intent(this, DPProductIn.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		//Toast.makeText(VCANSAppActivity.this, "进入成品进仓", 500).show();
	}

	/**
	 * 进入再加工送仓库
	 * @param index
	 */
	public void onOpenMachining(int index) {
		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);
		this.setMTitle(getString(R.string.machining), R.id.tvActtitle);
		Intent intent = new Intent(this, DPMachining.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		//Toast.makeText(VCANSAppActivity.this, "进入再加工送仓库", 500).show();
	}

	/**
	 * 进入 任务简报
	 * @param index
	 */
	public void onOpenRZTask(int index) {
		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);
		this.setMTitle(getString(R.string.rztask), R.id.tvActtitle);
		Intent intent = new Intent(this, DPRZTask.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		//Toast.makeText(VCANSAppActivity.this, "进入 任务简报", 500).show();
	}

	/**
	 * 进入 任务简报二
	 * @param index
	 */
	public void onOpenRZTask2(int index) {
		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);
		this.setMTitle(getString(R.string.rztask), R.id.tvActtitle);
		Intent intent = new Intent(this, DPRZTask2.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		//Toast.makeText(VCANSAppActivity.this, "进入 任务简报", 500).show();

	}

	/**
	 * 进入 染整费用
	 * @param index
	 */
	public void onOpenRZCost(int index) {
		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);
		this.setMTitle(getString(R.string.rzCost), R.id.tvActtitle);
		Intent intent = new Intent(this, DPRZCost.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		//Toast.makeText(VCANSAppActivity.this, "进入 染整费用", 500).show();
	}

	/**
	 * 进入 直接出货
	 * @param index
	 */
	public void onOpenDirectOut(int index) {
		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);
		this.setMTitle(getString(R.string.gdDirectOut), R.id.tvActtitle);
		Intent intent = new Intent(this, GDDirectOut.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
	}

	public String getModuleChNum(String inModuleId,String baseName)
	{
		Iterator keys=GDBakModule.mapBakModuleId.keySet().iterator();


		while(keys.hasNext())
		{
			String key=(String)keys.next();
			String strModuleId=baseName+key;

			if(inModuleId.equals(strModuleId))
			{
				return key;
			}
		}

		return null;
	}

	/**
	 * 新     备用模块01-05
	 * @param index
	 */
	public void onOpenBakModule(int index)
	{
		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);
		DPRZTask3.gBakFlag=ItemTitleHelper.itemTitle.moduleId;
		this.setMTitle(getString(R.string.gdBakModule), R.id.tvActtitle);
		Intent intent = new Intent(this, DPRZTask3.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

//		if (!getUserPower(index))
//			return;
//
//		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
//		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);
//		DPRZTask3.gBakFlag=ItemTitleHelper.itemTitle.moduleId;
//		this.setMTitle(getString(R.string.gdBakModule), R.id.tvActtitle);
//		Intent intent = new Intent(this, ByView1Activity.class);
//		startActivity(intent);
//		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
	}

	/**
	 * 新     备用模块06-10
	 * @param index
	 */
	public void onOpenByModule(int index)
	{

		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);
		ByView1Activity.gBakFlag=ItemTitleHelper.itemTitle.moduleId;
		this.setMTitle(getString(R.string.gdBakModule), R.id.tvActtitle);
		Intent intent = new Intent(this, ByView1Activity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
	}
	/**
	 *    模块
	 * @param index
	 */

	public void GDQuery(int index)
	{

		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);
		GDQuery1.gQueryFlag=ItemTitleHelper.itemTitle.moduleId;
		this.setMTitle(getString(R.string.gdBakModule), R.id.tvActtitle);
		Intent intent = new Intent(this, GDQuery1.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
	}



	/**
	 * 备用模块
	 * @param index
	 */
	public void onBakModule(int index)
	{
		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);

		GDBakModule.gBakFlag=getModuleChNum(ItemTitleHelper.itemTitle.moduleId,ItemTitleHelper.BAK_MODULE); //模块标志 值： 一/二/三/四
		this.setMTitle(ItemTitleHelper.itemTitle.moduleId, R.id.tvActtitle);

		Intent intent = new Intent(this, GDBakModule.class);
		startActivity(intent);
		//Toast.makeText(VCANSAppActivity.this, "备用模块", 500).show();
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
	}



	/**
	 * 综合查询
	 * @param index
	 */
	public void onGDQuery(int index)
	{
		if (!getUserPower(index))
			return;

		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = lstHasColors.get(index);

		GDQuery.gQueryFlag=getModuleChNum(ItemTitleHelper.itemTitle.moduleId,ItemTitleHelper.GD_QUERY);
		this.setMTitle(ItemTitleHelper.itemTitle.moduleId, R.id.tvActtitle);
		Intent intent = new Intent(this, GDQuery.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
	}

	/**
	 * 进入 样品查询
	 * @param index
	 */
	public void onOpenQRCodeScan(int index) {

		if (!getUserPower(this.mYpStart + index))
			return;
		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index];
		this.setMTitle(getString(R.string.YPQuery), R.id.tvActtitle);
		Intent intent = new Intent(this, YPQuery.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		//Toast.makeText(VCANSAppActivity.this, "进入 样品查询", 500).show();
	}


	/**
	 * 进入 展会询样
	 * @param index
	 */
	public void onOpenXYRegister(int index) {
		if (!getUserPower(this.mYpStart + index))
			return;

		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index];
		this.setMTitle(getString(R.string.exposition), R.id.tvActtitle);
		Intent intent = new Intent(this, YPExposition.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		//Toast.makeText(VCANSAppActivity.this, "进入 展会询样", 500).show();
	}

	/**
	 * 进入 样品图片
	 * @param index
	 */
	public void onOpenBarcodeImage(int index) {
		if (!getUserPower(this.mYpStart + index))
			return;
		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index];
		this.setMTitle(getString(R.string.YPImage), R.id.tvActtitle);
		Intent intent = new Intent(this, YPBarcodeImage.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		//Toast.makeText(VCANSAppActivity.this, "进入 样品图片", 500).show();
	}


	/**
	 * 名片识读
	 * @param index
	 */
	public void onOpenmpsb(int index)
	{
//		if (gUser == null) {
//			ActivityHelper.ToastShow(this, getString(R.string.noLoginWait));
//			return;
//		}else {
		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index];
		this.setMTitle(getString(R.string.mpsb), R.id.tvActtitle);
		Intent intent = new Intent(this,MpsdActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		//	}
		//Toast.makeText(VCANSAppActivity.this, "名片识读", 500).show();
	}


	/**
	 * 清单一
	 * @param index
	 */
	public void onOpenqdmk1(int index)
	{
		if (gUser == null) {
			ActivityHelper.ToastShow(this, getString(R.string.noLoginWait));
			return;
		}else {
		ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds1.get(index);
		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index];
		this.setMTitle(ItemTitleHelper.itemTitle.moduleId, R.id.tvActtitle);
		Intent intent = new Intent(this,MlqdActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
			}

//		Intent intent = new Intent(this,MAPActivity.class);
//		startActivity(intent);
	}

	/**
	 * 清单二
	 * @param index
	 */
	public void onOpenqdmk2(int index)
	{
		/*ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds1.get(index);

		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index];
		this.setMTitle(ItemTitleHelper.itemTitle.moduleId, R.id.tvActtitle);
		Intent intent = new Intent(this,MlqdActivity.class);
		startActivity(intent);
		ActivityHelper.ToastShow(VCANSAppActivity.this, "清单二");
	    overridePendingTransition(R.anim.zoomin, R.anim.zoomout);*/
		ActivityHelper.ToastShow(VCANSAppActivity.this, "清单二敬请期待");

	}

	/**
	 * 清单三
	 * @param index
	 */
	public void onOpenqdmk3(int index)
	{
		/*ItemTitleHelper.itemTitle.moduleId = lstHasModuleIds1.get(index);

		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index];
		this.setMTitle(ItemTitleHelper.itemTitle.moduleId, R.id.tvActtitle);
		Intent intent = new Intent(this,MlqdActivity.class);
		startActivity(intent);
		ActivityHelper.ToastShow(VCANSAppActivity.this, "清单三");
	    overridePendingTransition(R.anim.zoomin, R.anim.zoomout);*/
		ActivityHelper.ToastShow(VCANSAppActivity.this, "清单三敬请期待");

	}





	/**
	 * app 登录
	 * @param index
	 */
	public void onLogin(int index) {

		ItemTitleHelper.itemTitle.moduleId="";
		ActivityHelper.globalSysParam.sysSkin.selectedColor = 20;
		this.setMTitle(getString(R.string.vcanslogin), R.id.tvActtitle);
		Intent intent = new Intent(this, VcansLogin.class);
		startActivityForResult(intent, 1);
		//  overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
	}

	/**
	 * app 收藏车
	 * @param index
	 */
	public void onShowMenuImage(int index) {

		ItemTitleHelper.itemTitle.moduleId ="收藏车上传";

		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index+3];
		this.setMTitle(ItemTitleHelper.itemTitle.moduleId, R.id.tvActtitle);
		Intent intent = new Intent(this,MlqdActivity3.class);
		startActivity(intent);
		//  overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
	}

	private String getResourcesUri(@DrawableRes int id) {
		Resources resources = getResources();
		String uriPath = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
				resources.getResourcePackageName(id) + "/" +
				resources.getResourceTypeName(id) + "/" +
				resources.getResourceEntryName(id);
		return uriPath;
	}
	/**
	 * app 历史
	 * @param index
	 */
	public void onTemp(int index) {

		//ActivityHelper.showDialog(this, "", "该功能暂未实现");

		ItemTitleHelper.itemTitle.moduleId ="历史";

		ActivityHelper.globalSysParam.sysSkin.selectedColor = szColor[ypColorStartIndex + index+1];
		this.setMTitle(ItemTitleHelper.itemTitle.moduleId, R.id.tvActtitle);
		Intent intent = new Intent(this,HistoryActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
	}





	/**
	 * app 设置
	 * @param index
	 */
	public void onOpenSetActivity(int index) {

		ItemTitleHelper.itemTitle.moduleId="";

		//
		//ActivityHelper.globalSysParam.sysSkin.selectedColor = 20;
		this.setMTitle(getString(R.string.sysSet) + "(1/2)", R.id.tvActtitle);
		Intent intent = new Intent(this, SysSet.class);
		startActivity(intent);
		//  overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
	}




	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == 0){
				Uri uri=data.getData();
				ActivityHelper.ToastShow(VCANSAppActivity.this,uri+"");
			}else if (requestCode == 1) {
			if (resultCode == 2) {
				InitBottomMenu();
				hondian();
			}
		} else if (requestCode == REQUEST_SCAN_QRCODE_FLAG) {// 条码扫描完毕返回
			if (resultCode == Activity.RESULT_OK) {
				Bundle bundle = data.getExtras();
				String strRst = bundle.getString("result");
				// strRst=ActivityHelper.resolveBarcode(strRst);
				txtContent.setText(strRst);
				onSearch();
			}
		}
	}
}