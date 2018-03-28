package com.vcans.tool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import com.Vcan.activity.R;
import com.Vcan.activity.DPErrorDetail;
import com.vcans.Processor.AppManager;
import com.vcans.Processor.BaseActivity;
import com.vcans.base.MyApplication;
import com.vcans.dao.DBHelper;
import com.vcans.model.BYModel;
import com.vcans.model.GDXCModel;
import com.vcans.model.Information;
import com.vcans.model.Informationxx;
import com.vcans.model.MenuK;
import com.vcans.model.Mpsbinfo;
import com.vcans.model.RZTask3;
import com.vcans.model.SysParam;
import com.vcans.model.ToupeiInfo;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
public class ActivityHelper {

	public static final String APP_DIR="VCANS";
	public static final String FILE_NAME="/"+APP_DIR+"/XYCusPic.jpg";
	public static final int TEMP_DIALOG_CLOSE=0;
	public static final String INNER_FILE_PATH="/data/data/com."+APP_DIR.toLowerCase()+"/files";
	public static SQLiteDatabase db;//=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);  
	public   static Cursor cursor;
	public static Dialog mTipDlg=null;
	public static ProgressDialog mProgressDlg=null;
	public static Activity mActParent=null;
	public  static List<HashMap<String,Object> > DataList=new ArrayList<HashMap<String,Object> >();
	public static ToupeiInfo gToupei=new ToupeiInfo();
	public static RZTask3 dprzTask3=new RZTask3();
	public static BYModel BYModel=new BYModel();
	public static GDXCModel GDXCModel=new GDXCModel();
	public static  Mpsbinfo mp=new Mpsbinfo();
	public static  Information information=new Information();
	public static  Informationxx informationxx=new Informationxx();
	public static List<BaseActivity> lstActivities=new ArrayList<BaseActivity>();
	public static List<String> lstFlowerAndColor=new ArrayList<String>();
	public static List<String> lstCheckStatus=new ArrayList<String>();
	public static List<String> lstGongXu=new ArrayList<String>();
	public static List<String> lstGongyi=new ArrayList<String>();
	public static  Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
	private static Activity oldActi=null;
	private static String preText="";
	public static Bitmap[] szBitmaps=null;
	public static Bitmap[] Bitmaps=null;
	public static int repalcePhotoFlag=-1;
	public static String filePathList;
	public static List<MenuK>  MenuList=new ArrayList<MenuK>();
	public static  HashMap<String, ArrayList<MenuK>> MenuKLists1=new HashMap<String, ArrayList<MenuK>>();
	public static List<MenuK>  GDQueryMenuList=new ArrayList<MenuK>();
	public static  HashMap<String, ArrayList<MenuK>> GDQueryMenuKLists=new HashMap<String, ArrayList<MenuK>>();
	public static String  PAHT =Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	public static String dwsp;
	public static String dwyd;
	public static String biaozhi;
	public static String czname;
	public static String xxsm;
	public static String filePaths;
	public static String tp1;
	public static String tp2;
	public static String tp3;
	public static String kzxx1;
	public static String kzxx2;
	public static String kzxx3;
	public static String kzxx4;
	public static String kzxx5;
	public static String kzxx6;
	public static String kzxx7;
	public static String kzxx8;
	public static String kzxx9;
	public static String kzxx10;
	public static String Code="";
	public static String MorePopWindow04sql=null;
	public static Vector<String> data ;
	public static ArrayList<String> arrayList=new ArrayList<String>();
	public static String Version=null;
	public static String Version1=null;
	public static  List<HashMap<String,Object> > gDataList;
	public static final int IMAGE_COMPRESS_RATIO=4;
	public static int imageReduceRate=4; //图片缩减比例
	public static boolean bCutPhoto=true;
	public static boolean wangchen=false;
	public static boolean LangyaAdapterbz=false;
	public static String imageCutRate="";//图片剪切例 ，暂无用
	public static int imageCutType=0;
	public static int imageReduceMinSize=700;//kb 图片需要压缩的最小大小 小于该大小时不缩小
	public static List<String> lastQueryBitmapList=new ArrayList<String>();
	public static int bQueryYP=0; //执行了样品查询标志,用于主界面刷新显示样品第次查询到的每一个样品图片, 1为执行过 0为未执行
	public static List<String> savedImagePath=new ArrayList<String>();
	public static int nlastQueryBitmapListIndex=0;
	public static SysParam globalSysParam=new SysParam();

	public static <T> void RegOnClickEvent(Activity activityObj,int ctrlId)
	{
		@SuppressWarnings("unchecked")
		T ctrlObj = (T)activityObj.findViewById(ctrlId);
		Method method=null;

		try
		{
			method=ctrlObj.getClass().getMethod("setOnClickListener",OnClickListener.class);
			method.invoke(ctrlObj, activityObj);

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


	public static String GetFilePath()
	{
		String path;
		String status=Environment.getExternalStorageState();

		if(status.equals(Environment.MEDIA_MOUNTED))
		{
			path=Environment.getExternalStorageDirectory()+ActivityHelper.FILE_NAME;
		}
		else
		{
			File file=new File(ActivityHelper.INNER_FILE_PATH);

			if(!file.exists())
			{
				path=null;
			}

			path=ActivityHelper.INNER_FILE_PATH+ActivityHelper.FILE_NAME;
		}

		return path;
	}



	//获取文件路径 不含文件名
	public static String getFilePathNoName()
	{
		String path;
		String status=Environment.getExternalStorageState();

		if(status.equals(Environment.MEDIA_MOUNTED))
		{
			Log.i("Error!", "no sd card!");
			path=Environment.getExternalStorageDirectory().toString()+"/"+APP_DIR;
		}
		else
		{
			File file=new File(ActivityHelper.INNER_FILE_PATH);

			if(!file.exists())
			{
				path=null;
			}

			path=ActivityHelper.INNER_FILE_PATH;
		}

		return path;
	}

	public static void showDialog(Activity c,String title,String msg)
	{
		closeStatusDialog();

		  	/*
	    	AlertDialog.Builder showDlg=new AlertDialog.Builder(c);
	    	showDlg.setTitle(title);
	    	showDlg.setMessage(msg);
	    	showDlg.setPositiveButton("确定", null);
	    	showDlg.create().show();
	    	*/

		Toast.makeText(c, msg, Toast.LENGTH_LONG).show();
	}
	/**
	 *
	 *
	 * 删除指定的Activity*/

	public static void finishActivity(Activity activity)
	{
		if (activity != null && !activity.isFinishing()) {
			activity.finish();
		}
	}

	public static void showDivDialog(Activity c,String msg)
	{
		AlertDialog.Builder showDlg=new AlertDialog.Builder(c);
		//showDlg.setTitle(title);
		showDlg.setMessage(msg);
		//showDlg.setPositiveButton("确定", null);
		showDlg.create().show();
	}

	public static void  showProgressDialog(Activity c,int max,int progress)
	{
		if(oldActi!=c)
		{
			closeStatusDialog();
			oldActi=c;
		}

		if(mProgressDlg==null)
		{
			mProgressDlg = new ProgressDialog(new ContextThemeWrapper(c, R.style.CustomProgressDialog));
			mProgressDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// 设置水平进度条
			mProgressDlg.setCancelable(false);// 设置是否可以通过点击Back键取消
			mProgressDlg.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
			//mProgressDlg.setTitle("提示");
			mProgressDlg.setMax(max);
			mProgressDlg.setMessage(c.getString(R.string.executing));
			mProgressDlg.show();
			mProgressDlg.incrementProgressBy(progress);
		}
		else
		{
			mProgressDlg.incrementProgressBy(progress);
		}
	}

	private static void setDialogText(View v) {

		if (v instanceof ViewGroup) {
			ViewGroup parent = (ViewGroup) v;
			int count = parent.getChildCount();
			for (int i = 0; i < count; i++) {
				View child = parent.getChildAt(i);
				setDialogText(child);
			}
		} else if (v instanceof TextView) {
			((TextView) v).setTextSize(20);
		}
	}

	public static void  showStatusDialog(Activity c,String msg)
	{
		try {
			closeStatusDialog();            ////////////////////////////////////////
			LinearLayout layout = new LinearLayout(c);
			layout.setOrientation(LinearLayout.HORIZONTAL);
			layout.setGravity(Gravity.CENTER_VERTICAL);
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 100);//与setShowDimension(100,100)相同
			layout.setLayoutParams(lp);


			GifView  gifView = new GifView(c);
			lp.gravity=Gravity.CENTER_VERTICAL;
			lp.width=100;
			lp.height=100;
			lp.leftMargin=20;
			gifView.setMovieResource(R.drawable.animation);
			gifView.setLayoutParams(lp);
			layout.addView(gifView);
			//提示文本
			TextView tvMsg=new TextView(c);
			tvMsg.setId(R.id.textView1);
			LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			lp1.leftMargin=20;
			tvMsg.setLayoutParams(lp1);
			tvMsg.setText(msg);
			layout.addView(tvMsg);

			AlertDialog.Builder showDlg=new AlertDialog.Builder(new ContextThemeWrapper(c, R.style.Dialog));
			showDlg.setView(layout);
			mTipDlg=showDlg.create();
			mTipDlg.setCanceledOnTouchOutside(false);
			mTipDlg.show();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void showDialogAgain()
	{
		if(mTipDlg!=null)
		{
			if(!mTipDlg.isShowing())
				mTipDlg.show();
		}
		else if(mProgressDlg!=null)
		{
			if(!mProgressDlg.isShowing())
				mProgressDlg.show();
		}
	}


	/**
	 *
	 * @param msg
	 * @param action 防止Bitmap   OOM
	 */
	public static Bitmap BitmapFactory(String  pathName,int num)
	{

		BitmapFactory.Options options=new BitmapFactory.Options();

		options.inSampleSize = num;
		Bitmap    bitmap = BitmapFactory.decodeFile(pathName,options);
		return bitmap;

	}

	/**
	 *
	 * @param msg
	 * @param action 显示发送字节或接收字节
	 */
	public static void  showByteStatusDialog(String msg,int action)
	{
		if(mTipDlg!=null&&action==0)
		{
			TextView tv=(TextView)mTipDlg.findViewById(R.id.textView1);
			if(preText=="")
				preText=tv.getText().toString();

			tv.setText(preText+" "+msg);
		}
		else if(action==1&&mProgressDlg!=null)
		{
			mProgressDlg.setMessage(BaseActivity.mMainActivity.getString(R.string.executing)+msg);
		}
	}

	public static void  closeStatusDialog()
	{
		if(mTipDlg!=null)
		{
			mTipDlg.dismiss();
			mTipDlg=null;
			preText="";
		}

		if(mProgressDlg!=null)
		{
			mProgressDlg.dismiss();
			mProgressDlg=null;
		}
	}


	public static Handler mHandler=new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			if(msg.what == TEMP_DIALOG_CLOSE)
			{
				Boolean bcloseParent=(Boolean)msg.obj;
				closeStatusDialog();

				if(bcloseParent)
					mActParent.finish();
			}
		}
	};




	public static void  showTempDialog(Activity c,String msg,long time,Boolean closeParent)
	{
//		    AlertDialog.Builder showDlg=new AlertDialog.Builder(c);
//		    showDlg.setMessage(msg);
//		    mTipDlg=showDlg.create();
//		    mTipDlg.show();
		ToastShow(c, msg);

		mHandler.removeMessages(TEMP_DIALOG_CLOSE);
		Message msgObj = Message.obtain();
		msgObj.what = TEMP_DIALOG_CLOSE;
		msgObj.obj=closeParent;
		mActParent=c;
		mHandler.sendMessageDelayed(msgObj,time);
	}

	public static void ToastShow(Activity a,String msg)
	{
		if(a==null)
			a=BaseActivity.mMainActivity;
		Toast.makeText(a, msg, Toast.LENGTH_SHORT).show();
	}
	public static void ToastShow(String msg)
	{
		if(!TextUtils.isEmpty(msg)){
			Toast.makeText(MyApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
		}
	}
	/*
	 *  过滤指令*/
	public static void Filterinstructions(String strCmd)
	{
		//登录失败  清除gUser
		if (strCmd.equals("V48V_DLXXXXXRE1")) { //DPProtocol.m_vfxVAG_DengLuXinXiRe1

			BaseActivity.gUser=null;
		}
	}



	public static void InitDrop(Activity activity,int rId,List<String> dataList,boolean setOnSelectFlag)
	{
		String[] szData=null;
		if(dataList.size()>0)
		{
			szData=new String[dataList.size()];

			int i=0;
			for(String strContent:dataList)
			{
				szData[i++]=strContent;
			}
		}
		else
		{
			szData=new String[1];
			szData[0]="[无数据]";//注意：设置无数据时需加 []号并禁止修改此处，以便与获取控件数据时统一
		}


		ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_item,szData);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner dropControll=(Spinner)activity.findViewById(rId);

		/**
		 * 当窗体中的所有控件都未启用且有一个下载控件数据的请求正在执行时，当直接进入下一窗体，
		 * 会更改原因的activity，因此找不到，dropControll会有空
		 */

		if(dropControll!=null)
		{
			dropControll.setAdapter(dataAdapter);

			if(setOnSelectFlag)
			{
				dropControll.setOnItemSelectedListener(new OnItemSelectedListener(){

					public void onItemSelected(AdapterView<?> arg0, View arg1,
											   int arg2, long arg3) {
						TextView tv = (TextView)arg1;

						if(tv!=null)
						{
							tv.setTextColor(Color.BLACK);    //设置颜色
							// tv.setTextSize(12.0f);    //设置大小
							tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL);   //设置居中
						}

					}

					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});
			}
		}
	}


	public static void InitDrop1(Activity activity,int rId,List<String> dataList,boolean setOnSelectFlag)
	{
		String[] szData=null;
		if(dataList.size()>0)
		{
			szData=new String[dataList.size()];

			int i=0;
			for(String strContent:dataList)
			{
				szData[i++]=strContent;
			}
		}
		else
		{
			szData=new String[1];
			szData[0]="[无数据]";//注意：设置无数据时需加 []号并禁止修改此处，以便与获取控件数据时统一
		}


		ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_item,szData);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		ZDYzuhe zdyzuhe=(ZDYzuhe)activity.findViewById(rId);



		/**
		 * 当窗体中的所有控件都未启用且有一个下载控件数据的请求正在执行时，当直接进入下一窗体，
		 * 会更改原因的activity，因此找不到，dropControll会有空
		 */

		if(zdyzuhe!=null)
		{
			zdyzuhe.spinner.setAdapter(dataAdapter);

			if(setOnSelectFlag)
			{
				zdyzuhe.spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

					public void onItemSelected(AdapterView<?> arg0, View arg1,
											   int arg2, long arg3) {
						TextView tv = (TextView)arg1;

						if(tv!=null)
						{
							tv.setTextColor(Color.BLACK);    //设置颜色
							// tv.setTextSize(12.0f);    //设置大小
							tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL);   //设置居中
						}

					}

					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});
			}
		}
	}

	public static void InitDrop2(Activity activity,int rId,List<String> dataList,boolean setOnSelectFlag)
	{


		ZDYzuhe zdyzuhe=(ZDYzuhe)activity.findViewById(rId);
		//	zdyzuhe.editText.setVisibility(View.VISIBLE);
		if(zdyzuhe!=null)
		{

			if(setOnSelectFlag)
			{
				zdyzuhe.editText.setText(dataList.get(0));
			}
		}
	}



	public static void hidesofeKeyboard(Activity activity)
	{
		View view = activity.getWindow().peekDecorView();
		if (view != null) {
			InputMethodManager inputmanger = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
			inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	}


	public static void showsofeKeyboard(Activity activity)
	{

		InputMethodManager inputmanger = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		inputmanger.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
	}


	public static void saveParams(Activity a,HashMap<String,String> mapParms)
	{
		SharedPreferences shared=a.getSharedPreferences(ActivityHelper.APP_DIR.toLowerCase()+"Param",Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor=shared.edit();
		Iterator<String> it=mapParms.keySet().iterator();
		while(it.hasNext())
		{
			Object key=it.next();
			editor.putString((String) key, mapParms.get(key));
		}
		editor.commit();
	}

	public static HashMap<String,String> getParams(Activity a,String[] parmNames)
	{
		SharedPreferences shared=a.getSharedPreferences(ActivityHelper.APP_DIR.toLowerCase()+"Param",Activity.MODE_PRIVATE);

		HashMap<String,String> mapParms=new HashMap<String,String>();
		for(String key : parmNames)
		{
			String value=shared.getString(key,"");
			mapParms.put(key,value) ;
		}

		return mapParms;
	}

	public static void ShowErrMsg(Activity a,String msg,Vector<Vector<String>> receData)
	{
		startErrorDetialActivity(a,msg,receData);
	}

	public static void ShowErrMsg(Activity a,String msg)
	{
		startErrorDetialActivity(a,msg,null);
	}

	private static void startErrorDetialActivity(Activity a,String msg,Vector<Vector<String>> vctReceData)
	{//20161130  改  s3  s4   s5 为待我审批  返回为空数据    需求是  不许报错
		String strContent="";

		String s2=msg;
		String s3="VCANSBEGINXXXXXVPXXCZ1FZ1XZRE1d28d2fe3-71a5-4c8e-9e73-78e938c74da7634438374440000000数据为空!VCANSENDXXXXXXX";
		String s4="VCANSBEGINXXXXXVPXXZX1FZ1XZRE1d28d2fe3-71a5-4c8e-9e73-78e938c74da7634438374440000000数据为空!VCANSENDXXXXXXX";
		String s5="VCANSBEGINXXXXXVPXXXZ1FZ1XZRE1d28d2fe3-71a5-4c8e-9e73-78e938c74da7634438374440000000数据为空!VCANSENDXXXXXXX";
		String s6="VCANSBEGINXXXXXVPMLQD2FZ1XZRE1d28d2fe3-71a5-4c8e-9e73-78e938c74da7634438374440000000数据为空!VCANSENDXXXXXXX";
		String s7="VCANSBEGINXXXXXVPMLQD3FZ1XZRE1d28d2fe3-71a5-4c8e-9e73-78e938c74da7634438374440000000数据为空!VCANSENDXXXXXXX";
		String s8="VCANSBEGINXXXXXVPMLQD4FZ1CXRE1d28d2fe3-71a5-4c8e-9e73-78e938c74da7634438374440000000数据为空!VCANSENDXXXXXXX";
		if(s2.equals(s3))
		{
			ActivityHelper.closeStatusDialog();
		}else if (s2.equals(s4)) {
			ActivityHelper.closeStatusDialog();
		}else if (s2.equals(s5)) {
			ActivityHelper.closeStatusDialog();
		}else if (s2.equals(s6)) {
			ActivityHelper.closeStatusDialog();
		}else if (s2.equals(s7)) {
			ActivityHelper.closeStatusDialog();
		}else if (s2.equals(s8)) {
			ActivityHelper.closeStatusDialog();
		}
		else if (msg!=null) {
			if (vctReceData!=null) {
				for(Vector<String> record:vctReceData)
				{
					for(String data:record)
					{
						strContent+=data;
						System.out.println(strContent+"错误信息");
					}
				}

				if(strContent.equals("")){

					strContent=a.getString(R.string.noData);

				}
			}
			Intent intent=new Intent(a,DPErrorDetail.class);
			intent.putExtra("data", msg);
			intent.putExtra("content", strContent);
			a.startActivity(intent);
		}
	}


	public static String GetTextValue(Activity a,int id)
	{
		EditText txt=(EditText)a.findViewById(id);

		return txt.getText().toString().trim();
	}

	public static boolean isNumber(String source)
	{
		for (int i = source.length();--i>=0;)
		{
			if (!Character.isDigit(source.charAt(i)))
			{
				return false;
			}
		}

		return true;
	}
	/**
	 * 创建系统目录*/
	public static void createDis()
	{
		String strDir;
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
		{
			strDir=Environment.getExternalStorageDirectory().toString()+"/"+APP_DIR;

			File file=new File(strDir);

			if(!file.exists())
			{
				file.mkdirs();
			}

			file=new File(strDir+"/image");
			if(!file.exists())
			{
				file.mkdirs();
			}
		}
	}

	public static Bitmap compressImageReBimap(Bitmap image) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
		int options = 100;
		while ( baos.toByteArray().length / 1024>100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
			baos.reset();//重置baos即清空baos
			image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
			options -= 10;//每次都减少10
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片

		return bitmap;
	}

	public static ByteArrayInputStream compressImage(Bitmap image) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
		int options = 100;
		while ( baos.toByteArray().length / 1024>100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
			baos.reset();//重置baos即清空baos
			image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
			options -= 10;//每次都减少10
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
		// Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
		// return bitmap;
		return isBm;
	}

	public static byte[] int2byte(int res) {
		byte[] targets = new byte[4];

		targets[0] = (byte) ((res >>> 24) & 0xff);
		targets[1] = (byte) ((res >> 16) & 0xff);
		targets[2] = (byte) ((res >> 8) & 0xff);
		targets[3] = (byte) (res &0xff);
		return targets;
	}

	/**
	 * 基于位移的 byte[]转化成int
	 * @param byte[] bytes
	 * @return int  number
	 */

	public static int bytesToInt(byte[] bytes) {
		int number = bytes[3] & 0xFF;
		// "|="按位或赋值。
		number |= ((bytes[2] << 8) & 0xFF00);
		number |= ((bytes[1] << 16) & 0xFF0000);
		number |= ((bytes[0] << 24) & 0xFF000000);
		return number;
	}

	/**
	 * 上传完成，返回到第一个页面
	 */
	public static void backFirstActivity()
	{
		try {
			int startFinish=0;
			for(int i=2;i<ActivityHelper.lstActivities.size();++i)
			{
				BaseActivity acti=ActivityHelper.lstActivities.get(i);
				if(acti!=null&&startFinish==0)
				{
					startFinish=1;
				}
				else if(acti!=null&&startFinish==1)
				{
					BaseActivity.mbQuitFlag=true;
					acti.finish();
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 上传完成，返回到第一个页面
	 */
	public static void backFirstActivity1()
	{
		try {
			int startFinish=0;

			for(int i=2;i<AppManager.activityStack.size();++i)
			{
				Activity acti=AppManager.activityStack.get(i);
				if(acti!=null&&startFinish==0)
				{
					startFinish=1;
				}
				else if(acti!=null&&startFinish==1)
				{
					BaseActivity.mbQuitFlag=true;
					acti.finish();
				}
			}
			for (int i = 2; i < AppManager.activityStack.size(); i++) {
				Activity acti=AppManager.activityStack.get(i);
				AppManager.activityStack.remove(acti);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static byte[] BitmapToByteArray(Bitmap bitmap,CompressFormat format)
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		bitmap.compress(format, 100, out);
		byte[] array= out.toByteArray();

		return array;
	}

	public static Bitmap  ByteArrayToBitmap(byte[] szImageByte)
	{
		BitmapFactory.Options options=new BitmapFactory.Options();
		options.inPurgeable=true;
		options.inSampleSize = ActivityHelper.IMAGE_COMPRESS_RATIO;

		return BitmapFactory.decodeByteArray(szImageByte,0,szImageByte.length, options);


		//ByteArrayInputStream isBm = new ByteArrayInputStream(szImageByte);//把压缩后的数据baos存放到ByteArrayInputStream中
		//return  BitmapFactory.decodeStream(isBm, null, null,options);//把ByteArrayInputStream数据生成图片
	}

	public static Bitmap zoomImg(Bitmap bm, int newWidth ,int newHeight){
		// 获得图片的宽高
		int width = bm.getWidth();
		int height = bm.getHeight();
		// 计算缩放比例
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// 取得想要缩放的matrix参数
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		// 得到新的图片
		Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
		return newbm;
	}

	public static String resolveBarcode(String strContent)
	{
		String[] szBarcode=strContent.split("\r\n");
		String strBarcode="";

		int pos=szBarcode[0].indexOf(":");
		if(pos>=0)
		{
			strBarcode=szBarcode[0].substring(pos+1);
		}
		else
		{
			strBarcode=szBarcode[0];
		}

		return strBarcode;
	}

	public static String fileBtyeToFile(byte[] fileByte,int index)
	{
		SimpleDateFormat    sDateFormat    =   new    SimpleDateFormat("yyyyMMddhhmmss");
		String    date    =    sDateFormat.format(new java.util.Date());
		String filePath=ActivityHelper.getFilePathNoName()+"/image/i"+date+"_"+index+".jpg";
		File file=new File(filePath);
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(file);
			fos.write(fileByte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			filePath="";
		}
		finally
		{
			if(fos!=null)
				try {
					fos.flush();
					fos.close();
					fos=null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
		}




		return filePath;
	}

	/**
	 *
	 *
	 * 根据模块  获取MenuKlist*/
	public static List<MenuK> setItemMenuK(String s){


		String  [] list={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27"};
		List<MenuK> MenuK=new ArrayList<MenuK>();

		for (int i = 0; i < list.length; i++) {

			MenuK.add(MenuK(list[i],s));
		}
		return MenuK;

	}


	/**
	 *
	 *
	 * 根据模块  获取MenuK*/


	public static MenuK MenuK(String s, String s2 ){
		db = SQLiteDatabase.openOrCreateDatabase( DBHelper.CreateTable(), null);
		String Value1 = "";
		String Value2 = "";
		String Value3 = "";
		String Value4 = "";
		String Value5 = "";
		String Value6 = "";
		String Value7 = "";
		String Value8 = "";

		try {
			String sql1="select * from UIItemTitle   where   ModuleId = "+"'"+s2+"'"+" and ItemName = "+"'字段"+s+"启用'"+"  " ;// 启用

			cursor = db.rawQuery(sql1, new String[]{});
			if (cursor != null) {
				while (cursor.moveToNext()) {
					Value1=cursor.getString(4);

				}
			}

			String sql2="select * from UIItemTitle   where   ModuleId = "+"'"+s2+"'"+" and ItemName = "+"'字段"+s+"标题'"+"  " ;// 标题

			cursor = db.rawQuery(sql2, new String[]{});
			if (cursor != null) {
				while (cursor.moveToNext()) {
					Value2=cursor.getString(4);

				}
			}



			String sql3="select * from UIItemTitle   where   ModuleId = "+"'"+s2+"'"+" and ItemName = "+"'字段"+s+"类型'"+"  " ;// 类型

			cursor = db.rawQuery(sql3, new String[]{});
			if (cursor != null) {
				while (cursor.moveToNext()) {
					Value3=cursor.getString(4);

				}
			}


			String sql4="select * from UIItemTitle   where   ModuleId = "+"'"+s2+"'"+" and ItemName = "+"'字段"+s+"入键'"+"  " ;// 入键

			cursor = db.rawQuery(sql4, new String[]{});
			if (cursor != null) {
				while (cursor.moveToNext()) {
					Value4=cursor.getString(4);

				}
			}


			String sql5="select * from UIItemTitle   where   ModuleId = "+"'"+s2+"'"+" and ItemName = "+"'字段"+s+"即发'"+"  " ;// 即发

			cursor = db.rawQuery(sql5, new String[]{});
			if (cursor != null) {
				while (cursor.moveToNext()) {
					Value5=cursor.getString(4);

				}
			}


			String sql6="select * from UIItemTitle   where   ModuleId = "+"'"+s2+"'"+" and ItemName = "+"'字段"+s+"合计'"+"  " ;// 合计

			cursor = db.rawQuery(sql6, new String[]{});
			if (cursor != null) {
				while (cursor.moveToNext()) {
					Value6=cursor.getString(4);

				}
			}


			String sql7="select * from UIItemTitle   where   ModuleId = "+"'"+s2+"'"+" and ItemName = "+"'字段"+s+"允许为空'"+"  " ;// 允许为空

			cursor = db.rawQuery(sql7, new String[]{});
			if (cursor != null) {
				while (cursor.moveToNext()) {
					Value7=cursor.getString(4);

				}
			}

			String sql8="select * from UIItemTitle   where   ModuleId = "+"'"+s2+"'"+" and ItemName = "+"'字段"+s+"启用扫描'"+"  " ;// 条码扫描是否启用

			cursor = db.rawQuery(sql8, new String[]{});
			if (cursor != null) {
				while (cursor.moveToNext()) {
					Value8=cursor.getString(4);

				}
			}


		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (cursor != null)
				cursor.close();
			db.close();
		}


		MenuK MenuK=new MenuK(Value1, Value2, Value3, Value4, Value5, Value6,Value7,Value8);





		return MenuK;

	}




	public static boolean  saveBitmap2file(Bitmap bmp,String fileName){
		CompressFormat format= Bitmap.CompressFormat.JPEG;
		int quality = 100;
		OutputStream stream = null;
		try {
			String filePath=ActivityHelper.getFilePathNoName()+"/image/"+fileName+".jpg";
			stream = new FileOutputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bmp.compress(format, quality, stream);
	}

	public static String fileBtyeToFile(byte[] fileByte,String fileName)
	{
		String filePath=ActivityHelper.getFilePathNoName()+"/image/"+fileName+".jpg";
		File file=new File(filePath);
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(file);
			fos.write(fileByte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			filePath="";
		}
		finally
		{
			if(fos!=null)
				try {
					fos.flush();
					fos.close();
					fos=null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
		}


		return filePath;
	}

	public static String bitmapToFile(Bitmap bitmap)
	{
		SimpleDateFormat    sDateFormat    =   new    SimpleDateFormat("yyyyMMddhhmmss");
		String    date    =    sDateFormat.format(new java.util.Date());
		String filePath=ActivityHelper.getFilePathNoName()+"/image/i"+date+".jpg";
		File file=new File(filePath);
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(file);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			filePath="";
		}
		finally
		{
			if(fos!=null)
				try {
					fos.flush();
					fos.close();
					fos=null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
		}


		return filePath;
	}

	public static String bitmapToFile(Bitmap bitmap,String fileName)
	{
		String filePath=ActivityHelper.getFilePathNoName()+"/image/"+fileName+".jpg";
		File file=new File(filePath);
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(file);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			filePath="";
		}
		finally
		{
			if(fos!=null)
				try {
					fos.flush();
					fos.close();
					fos=null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
		}


		return filePath;
	}

	public static String[] mySplit(String src,String subStr)
	{
		int num=0;
		int index=0;
		String temp=src;

		while(true)
		{
			index=temp.indexOf(subStr);

			if(index>-1)
			{
				num++;

				temp=temp.substring(index+1);
			}
			else
			{
				break;
			}
		}

		if(num==0)
			return new String[]{src};

		String[] result=new String[num];
		for(int j=0;j<num;j++)
			result[j]="";

		String[] szTemp=src.split(subStr);
		for(int i=0;i<szTemp.length;i++)
			result[i]=szTemp[i];

		return result;
	}


	public static void recycleBitmaps(Bitmap[] bitmpas)
	{
		if(bitmpas==null) {
			return;
		}else{
			Bitmap[] szBitmap=bitmpas;
			for(Bitmap b:szBitmap)
			{
				if(b!=null) {
					if(!b.isRecycled())
					{
						b.recycle();
						System.gc();
					}
				}

			}
		}



	}

	/**
	 * 自动翻转，纠正图片
	 * 发现调用三星手机的相机拍照后，会翻转图片变横向的
	 */
	public static Bitmap autoMatrixBitmap(String filePath,Bitmap bitmap)
	{
		if(bitmap==null) return null;

		ExifInterface exifInterface=null;
		try {
			exifInterface = new ExifInterface(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		int tag = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1);

		int degree = 0;

		if (tag == ExifInterface.ORIENTATION_ROTATE_90) {
			degree = 90;
		} else if (tag == ExifInterface.ORIENTATION_ROTATE_180) {
			degree = 180;
		} else if (tag == ExifInterface.ORIENTATION_ROTATE_270) {
			degree = 270;
		}

		Bitmap bm=null;

		if(degree==0)
		{
			bm=bitmap;
		}
		else
		{
			Matrix matrix = new Matrix();
			matrix.postRotate(degree);

			bm = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
					bitmap.getHeight(), matrix, true);


			ActivityHelper.recycleBitmaps(new Bitmap[]{bitmap});
		}

		return bm;
	}

	public static Bitmap fileToBitmap(String filePath)
	{
		if(filePath==null) return null;

		File file=new File(filePath);
		if(file.exists())
		{
			BitmapFactory.Options options=new BitmapFactory.Options();
			options.inPurgeable = true;
			options.inSampleSize = ActivityHelper.IMAGE_COMPRESS_RATIO;

			return BitmapFactory.decodeFile(filePath,options);
		}

		return null;
	}

	public static Bitmap fileToBitmap(String filePath,int sizeRate)
	{
		File file=new File(filePath);
		if(file.exists())
		{
			BitmapFactory.Options options=new BitmapFactory.Options();
			options.inPurgeable = true;
			options.inSampleSize = sizeRate;

			return BitmapFactory.decodeFile(filePath,options);
		}

		return null;
	}

	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}


	private static String digitToFormatStrDig(int num)
	{
		String strTemp=""+(num);
		String strZero="";
		for(int i=0;i<4-strTemp.length();i++)
		{
			strZero+="0";
		}

		return strZero+strTemp;
	}

	public static String autoCreator(String sourceStr)
	{
		String oldBarcode=sourceStr;

		int index=oldBarcode.length()-1;
		int preIndex=-1;
		while(index>=0)
		{
			char c=oldBarcode.charAt(index);

			if (!Character.isDigit(c)){
				if(preIndex==-1)
				{
					oldBarcode+="0001" ;
				}
				else
				{
					String strNum=oldBarcode.substring(preIndex);
					String strString=oldBarcode.substring(0,preIndex);
					int num=Integer.valueOf(strNum);
					if(c=='-')
						oldBarcode=strString+digitToFormatStrDig(num+1);
					else
						oldBarcode=strString+""+digitToFormatStrDig(num+1);
				}

				break;
			}
			else
			{
				if(index==0)
				{
					int num=Integer.valueOf(oldBarcode);
					oldBarcode=digitToFormatStrDig(num+1);
					break;
				}
			}

			preIndex=index;
			index--;


		}

		return oldBarcode;
	}



	/**
	 *  去除数组中重复的记录
	 */

	public static String[] array_unique(String[] a) {
		// array_unique
		List<String> list = new LinkedList<String>();
		for(int i = 0; i < a.length; i++) {
			if(!list.contains(a[i])) {
				list.add(a[i]);
			}
		}
		return (String[])list.toArray(new String[list.size()]);
	}

	public static String getVersion(Activity parent) {

		PackageManager manager = parent.getPackageManager();
		PackageInfo info;
		try {
			info = manager.getPackageInfo(parent.getPackageName(), 0);
			String version = info.versionName;
			return  version;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
