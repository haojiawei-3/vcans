package com.Vcan.activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.Vcan.activity.R;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;
import com.vcans.Processor.BaseActivity;
import com.vcans.tool.ActivityHelper;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;




public class SplashActivity extends BaseActivity implements LocationSource, AMapLocationListener {
	AMapLocationClient mLocationClient;
	AMapLocationClientOption  mLocationOption;
	private OnLocationChangedListener mListener;
	public static String   Province;
	public static String   City;
	public static String   District;
	public static String   Street;


	public  static String getProvince() {
		return Province;
	}
	public  static String getCity() {
		return City;
	}
	public  static String getDistrict() {return District;}
	public  static String getStreet() {return Street;}
	public  static  void setProvince(String province) {
		 Province=province;
	}
	public  static void setCity(String city) {
		 City=city;
	}
	public  static void setDistrict(String district) {
		District=district;
	}
	public  static void setStreet(String street) {
		Street=street;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		//ActivityHelper.lstActivities.clear();

		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash_activity);
		initState();
		SetBgImage();
		//getSysLanguage();
		initGaoDeMap();
		TextView tv=(TextView)this.findViewById(R.id.tvVersion);
		tv.setText(" V"+ActivityHelper.getVersion(this)+" ");

		new Handler().postDelayed(new Runnable(){

			public void run() {

				try {
					//Intent intent=new Intent(SplashActivity.this,VCANSAppActivity.class);
					//startActivity(intent);

					//关闭自己,只这里比较特殊，需要选设置关闭标志，原因需了解基类finish方法
					mbQuitFlag=true;
					finish();
					mbQuitFlag=false;

					LinearLayout layMain=(LinearLayout)findViewById(R.id.layMain);
					layMain.setVisibility(View.VISIBLE);

					//再延迟2秒后设置请求服务时弹出提示框
					new Handler().postDelayed(new Runnable(){

						public void run() {
							VCANSAppActivity.bShowTip=true;
						}
					}, 5000);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 2300);
	}

	public void SetBgImage()
	{
		ImageView imagewelcome=(ImageView)this.findViewById(R.id.ivItemImage);

		HashMap<String,String> mapParms=ActivityHelper.getParams(this,
				new String[]{"language"});

		String strLanguage=mapParms.get("language");
		if(strLanguage.equals("ch"))
		{
			imagewelcome.setImageResource(R.drawable.welcome);
		}
		else if(strLanguage.equals("en"))
		{
			imagewelcome.setImageResource(R.drawable.welcome_en);
		}
	}



	/**
	 * 初始化高德地图
	 */
	public void initGaoDeMap() {
		// 初始化定位
		mLocationClient = new AMapLocationClient(getApplicationContext());
		// 设置高德地图定位回调监听
		mLocationClient.setLocationListener(this);
		// 初始化AMapLocationClientOption对象
		mLocationOption = new AMapLocationClientOption();
		// 高精度定位模式：会同时使用网络定位和GPS定位，优先返回最高精度的定位结果，以及对应的地址描述信息
		// 设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式
		mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
		// 低功耗定位模式：不会使用GPS和其他传感器，只会使用网络定位（Wi-Fi和基站定位）；
		//设置定位模式为AMapLocationMode.Battery_Saving，低功耗模式。
//        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
		// 仅用设备定位模式：不需要连接网络，只使用GPS进行定位，这种模式下不支持室内环境的定位，自 v2.9.0 版本支持返回地址描述信息。
		// 设置定位模式为AMapLocationMode.Device_Sensors，仅设备模式。
//        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Device_Sensors);
		// SDK默认采用连续定位模式，时间间隔2000ms
		// 设置定位间隔，单位毫秒，默认为2000ms，最低1000ms。
		mLocationOption.setInterval(3000);
		// 设置定位同时是否需要返回地址描述
		//设置是否返回地址信息（默认返回地址信息）
		mLocationOption.setNeedAddress(true);
		// 设置是否强制刷新WIFI，默认为强制刷新。每次定位主动刷新WIFI模块会提升WIFI定位精度，但相应的会多付出一些电量消耗。
		// 设置是否强制刷新WIFI，默认为true，强制刷新。
		mLocationOption.setWifiActiveScan(true);
		// 设置是否允许模拟软件Mock位置结果，多为模拟GPS定位结果，默认为false，不允许模拟位置。
		// 设置是否允许模拟位置,默认为false，不允许模拟位置
		mLocationOption.setMockEnable(false);
		// 设置定位请求超时时间，默认为30秒
		// 单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
		mLocationOption.setHttpTimeOut(50000);
		// 设置是否开启定位缓存机制
		// 缓存机制默认开启，可以通过以下接口进行关闭。
		// 当开启定位缓存功能，在高精度模式和低功耗模式下进行的网络定位结果均会生成本地缓存，不区分单次定位还是连续定位。GPS定位结果不会被缓存。
		// 关闭缓存机制
		mLocationOption.setLocationCacheEnable(false);
		// 设置是否只定位一次，默认为false
		mLocationOption.setOnceLocation(false);
		// 给定位客户端对象设置定位参数
		mLocationClient.setLocationOption(mLocationOption);
		// 启动高德地图定位
		mLocationClient.startLocation();
	}


	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLocationChanged(AMapLocation aMapLocation) {
		if (aMapLocation != null) {
			if (aMapLocation.getErrorCode() == 0) {
				aMapLocation.getLocationType(); // 获取当前定位结果来源，如网络定位结果，详见定位类型表
				aMapLocation.getLatitude(); // 获取纬度
				aMapLocation.getLongitude(); // 获取经度
				aMapLocation.getAccuracy(); // 获取精度信息
				aMapLocation.getAddress(); // 地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
				aMapLocation.getCountry(); // 国家信息
				Province=	aMapLocation.getProvince(); // 省信息
				City =aMapLocation.getCity(); // 城市信息
				District =aMapLocation.getDistrict(); // 城区信息
				Street =aMapLocation.getStreet()+aMapLocation.getStreetNum(); // 街道信息
				//aMapLocation.getStreetNum(); // 街道门牌号信息
				aMapLocation.getCityCode(); // 城市编码
				aMapLocation.getAdCode(); // 地区编码
				aMapLocation.getAoiName(); // 获取当前定位点的AOI信息
				aMapLocation.getBuildingId(); // 获取当前室内定位的建筑物Id
				aMapLocation.getFloor(); // 获取当前室内定位的楼层
				aMapLocation.getGpsAccuracyStatus(); // 获取GPS的当前状态
				// 获取定位时间
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date(aMapLocation.getTime());
				df.format(date);
				// 如果不设置标志位，拖动地图时，它会不断将地图移动到当前的位置
//				if (isFirstLocation) {
//					// 设置缩放级别
//					aMap.moveCamera(CameraUpdateFactory.zoomTo(17));
//					// 将地图移动到定位点
//					aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude())));
//					// 点击定位按钮 能够将地图的中心移动到定位点
			 	mListener.onLocationChanged(aMapLocation);
//					isFirstLocation = false;
//				}
			} else {
				// 定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
				Log.e("HLQ_Struggle", "location Error, ErrCode:"
						+ aMapLocation.getErrorCode() + ", errInfo:"
						+ aMapLocation.getErrorInfo());
			}
		}
	}

	@Override
	public void activate(OnLocationChangedListener onLocationChangedListener) {
		mListener = onLocationChangedListener;
	}

	@Override
	public void deactivate() {
		mListener = null;
	}
}
