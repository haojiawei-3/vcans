package com.Vcan.activity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.Vcan.activity.R;
import com.example.qr_codescan.MipcaActivityCapture;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.MlqdProcessor;
import com.vcans.Processor.MlqdProcessor1;
import com.vcans.Processor.MlqdProcessor3;
import com.vcans.Processor.MlqdProcessor4;
import com.vcans.model.Mlqd;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.SildingFinishLayout1;
import com.vcans.tool.mlqdfragment;
import com.vcans.tool.SildingFinishLayout.OnSildingFinishListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
/**
 *   清单模块一   有6个界面类
 * @author vcans
 *
 */
public class MlqdActivity extends BaseActivity  {
	public static MlqdActivity mlqdActivity = null;
	private String toolsList[];
	private TextView toolsTextViews[];
	private View views[];
	private LayoutInflater inflater;
	private ScrollView scrollView;
	private int scrllViewWidth = 0, scrollViewMiddle = 0;
	private ViewPager shop_pager;
	private int currentItem=0;
	private ShopAdapter shopAdapter;
	private Mlqd mlqdinfo;
	private List<Mlqd> listmlqd;
	private Cursor cursor;
	private SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);
	private List<String>  shuju;
	boolean b=false;
	private EditText txtContent;
	private Button btnSearch;
	private String txtContents;
	private String strRst;
	private List<String> mlbh;
	boolean standard=true;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mlqd);

		this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
		mlqdActivity=this;
		txtContent=(EditText)findViewById(R.id.txtContent);
		btnSearch=(Button)findViewById(R.id.btnSearch);
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"onOpenScanBarcode");
		TextView textView=(TextView)findViewById(R.id.tvActtitle);
		scrollView=(ScrollView) findViewById(R.id.tools_scrlllview);
		shopAdapter=new ShopAdapter(getSupportFragmentManager());
		listmlqd=new ArrayList<Mlqd>();


		inflater=LayoutInflater.from(this);
		Query();
		if (b==false) {
			if (BaseActivity.gUser==null) {
				ActivityHelper.ToastShow(MlqdActivity.this, getString(R.string.noLoginWait));
				finish();
			}else {
				xiazai();
			}

		} else {
			processMessage(5000, "");
		}
		textView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(MlqdActivity.this).setTitle("加载时间可能稍长是否继续")
						.setIcon(android.R.drawable.ic_dialog_info)
						.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int which) {
								if (standard) {
									standard=false;
									xiazai();
								}else {
									ActivityHelper.ToastShow(MlqdActivity.this, "数据下载中，请稍等...");
								}
							}
						}).setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
			}
		});
		btnSearch.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtContents  =	txtContent.getText().toString();

				if (!txtContents.equals("")) {
					// ActivityHelper.gToupei.strOutNotifyId=NotifyId;
					Intent intent=new Intent(MlqdActivity.this,MlqdActivity1.class);
					intent.putExtra("txtContents", txtContents);
					startActivity(intent);
				} else {
					Toast.makeText(MlqdActivity.this, "请输入要查询的数据", Toast.LENGTH_SHORT).show();
				}

			}
		});
		SildingFinishLayout();

	}


	public void SildingFinishLayout(){
		SildingFinishLayout1 mSildingFinishLayout = (SildingFinishLayout1) findViewById(R.id.sildingFinishLayout);
		mSildingFinishLayout.setOnSildingFinishListener(new com.vcans.tool.SildingFinishLayout1.OnSildingFinishListener() {

			@Override
			public void onSildingFinish() {
				// TODO Auto-generated method stub
				finish();
			}
		});

		mSildingFinishLayout.setTouchView(scrollView);
		//return activity;
	}

	private void xiazai() {

		SendParam sendParam = new SendParam();
		sendParam.tip = getString(R.string.ypml);
		sendParam.parent = MlqdActivity.this;
		sendParam.processor = new MlqdProcessor();
		getDataTrunsfer().request(sendParam);

	}

	public void onOpenScanBarcode() {
		Intent intent = new Intent();
		intent.setClass(this, MipcaActivityCapture.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivityForResult(intent, REQUEST_SCAN_QRCODE_FLAG);
	}

	/**
	 * initPager<br/>
	 * 初始化ViewPager控件相关内容
	 */
	private void initPager() {
		shop_pager=(ViewPager)findViewById(R.id.goods_pager);
		shop_pager.setAdapter(shopAdapter);
		shopAdapter.notifyDataSetChanged();
		shop_pager.setOnPageChangeListener(onPageChangeListener);
	}

	private void showToolsView() {

		toolsList=new String[shuju.size()];

		for(int i=0;i<shuju.size();i++){
			toolsList[i]=(String)shuju.get(i);
		}
		//去重复
		toolsList = ActivityHelper.array_unique(toolsList);
		LinearLayout toolsLayout=(LinearLayout) findViewById(R.id.tools);
		toolsTextViews=new TextView[toolsList.length];
		views=new View[toolsList.length];
		toolsLayout.removeAllViews();
		for (int i = 0; i < toolsList.length; i++) {
			View view=inflater.inflate(R.layout.item_b_top_nav_layout, null);
			view.setId(i);
			view.setOnClickListener(toolsItemListener);
			view.setOnLongClickListener(toolsItemLongListener);
			TextView textView=(TextView) view.findViewById(R.id.text);
			textView.setText(toolsList[i]);
			toolsLayout.addView(view);
			toolsTextViews[i]=textView;
			views[i]=view;
		}
		changeTextColor(0);
	}





	private View.OnClickListener toolsItemListener =new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			shop_pager.setCurrentItem(v.getId());
			//Toast.makeText(MlqdActivity.this,v.getId()+"", 500).show();
		}
	};

	private View.OnLongClickListener toolsItemLongListener =new View.OnLongClickListener() {

		@Override
		public boolean onLongClick(View arg0) {
			// TODO Auto-generated method stub
			shop_pager.setCurrentItem(arg0.getId());
			//Toast.makeText(MlqdActivity.this,toolsList[arg0.getId()], 500).show();
			List<String> mlbh=new ArrayList<String>();
			String s=toolsList[arg0.getId()];
			mlbh=Query(s);
			Intent intent=new Intent(MlqdActivity.this,MlqdActivity1.class);
			intent.putStringArrayListExtra("Mlbh", (ArrayList<String>)  mlbh) ;
			startActivity(intent);
			return false;
		}
	};



	/**
	 * 改变textView的颜色
	 * @param id
	 */
	private void changeTextColor(int id) {
		for (int i = 0; i < toolsTextViews.length; i++) {
			if(i!=id){
				toolsTextViews[i].setBackgroundResource(android.R.color.transparent);
				toolsTextViews[i].setTextColor(0xff000000);
			}
		}
		toolsTextViews[id].setBackgroundResource(R.color.bbb);
		toolsTextViews[id].setTextColor(0xffff5d5e);
	}

	/**
	 * OnPageChangeListener<br/>
	 * 监听ViewPager选项卡变化事的事件
	 */

	private OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {
		@Override
		public void onPageSelected(int arg0) {
			if(shop_pager.getCurrentItem()!=arg0)shop_pager.setCurrentItem(arg0);
			if(currentItem!=arg0){
				changeTextColor(arg0);
				changeTextLocation(arg0);
			}
			currentItem=arg0;
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	};

	/**
	 * ViewPager 加载选项卡
	 * @author Administrator
	 *
	 */
	private class ShopAdapter extends FragmentPagerAdapter {
		public ShopAdapter(FragmentManager fm) {
			super(fm);
		}
		@Override
		public Fragment getItem(int arg0) {
			Fragment fragment =new mlqdfragment();
			Bundle bundle=new Bundle();
			String str=toolsList[arg0];
			bundle.putString("typename",str);
			fragment.setArguments(bundle);
			return fragment;
		}

		@Override
		public int getCount() {
			return toolsList.length;
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			return super.instantiateItem(container, position);
		}



	}


	/**
	 * 改变栏目位置
	 *
	 * @param clickPosition
	 */
	private void changeTextLocation(int clickPosition) {

		int x = (views[clickPosition].getTop() - getScrollViewMiddle() + (getViewheight(views[clickPosition]) / 2));
		scrollView.smoothScrollTo(0, x);
	}

	/**
	 * 返回scrollview的中间位置
	 *
	 * @return
	 */
	private int getScrollViewMiddle() {
		if (scrollViewMiddle == 0)
			scrollViewMiddle = getScrollViewheight() / 2;
		return scrollViewMiddle;
	}

	/**
	 * 返回ScrollView的宽度
	 *
	 * @return
	 */
	private int getScrollViewheight() {
		if (scrllViewWidth == 0)
			scrllViewWidth = scrollView.getBottom() - scrollView.getTop();
		return scrllViewWidth;
	}

	/**
	 * 返回view的宽度
	 *
	 * @param view
	 * @return
	 */
	private int getViewheight(View view) {
		return view.getBottom() - view.getTop();
	}


	public List<String> Query(String s) {
		String strmlbh = "";
		String sql="select * from MLQingdan where Cj = 1  and Mlname = "+"'"+s+"'"+" ";
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			strmlbh = cursor.getString(2);

		}
		cursor.close();

		String sql1="select * from MLQingdan where Cj = 2  and Ssfjbh = "+"'"+strmlbh+"'"+" ";
		List<String> mlbh=new ArrayList<String>();
		cursor = db.rawQuery(sql1, new String[]{});
		while (cursor.moveToNext()) {
			String smlbh = cursor.getString(2);
			mlbh.add(smlbh);

		}
		cursor.close();
		return mlbh  ;//


	}


	public boolean Query() {
		String sql="select * from MLQingdan where Cj = 1 ";
		shuju=new ArrayList<String>();
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			String strmlname = cursor.getString(3);
			shuju.add(strmlname);
			b=true;
		}
		cursor.close();
		return b  ;//


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
				strRst=bundle.getString("result");
				EditText txtContent=(EditText)findViewById(R.id.txtContent);
				txtContent.setText(strRst);
				if(txtContent.getText().toString().equals("")) {

				}else {
					Intent intent=new Intent(MlqdActivity.this,MlqdActivity1.class);
					intent.putExtra("txtContents", strRst);
					startActivity(intent);
				}
			}
		}

	}




	@Override
	public void processMessage(int msgId, String msg ) {
		// TODO Auto-generated method stub
		if (msgId==200) {
			Query();
			if (shuju.size()==0) {
			}else {
//				new Handler().postDelayed(new Runnable() {
//
//					public void run() {
//						showToolsView();
//						initPager();
//					}
//				},50);
			}


		}else if (msgId==100) {

			SendParam sendParam = new SendParam();
			// sendParam.bShowTipDlg=false;
			sendParam.tip = getString(R.string.ypbiao);
			sendParam.parent = MlqdActivity.this;
			sendParam.szData=new String[]{0+"",0+"",0+""};
			sendParam.processor = new MlqdProcessor1();
			getDataTrunsfer().request(sendParam);

			// db.delete("Collect",null,null);

		}
		else if (msgId==999) {
//
			SendParam sendParam = new SendParam();
			sendParam.bShowTipDlg=true;
			sendParam.tip = getString(R.string.ypbiao1);
			sendParam.parent = MlqdActivity.this;
			sendParam.szData=new String[]{msg};
			sendParam.processor = new MlqdProcessor3();
			getDataTrunsfer().request(sendParam);
		}
		else if (msgId==4000) {
//
			SendParam sendParam = new SendParam();
			sendParam.bShowTipDlg=true;
			sendParam.tip = getString(R.string.ypbiao2);
			sendParam.parent = MlqdActivity.this;
			sendParam.szData=new String[]{msg};
			sendParam.processor = new MlqdProcessor4();
			getDataTrunsfer().request(sendParam);
		}else if (msgId==5000) {
//
			new Handler().postDelayed(new Runnable() {

				public void run() {
					Query();
					showToolsView();
					initPager();
					standard=true;
				}
			},0);

		}

	}

}
