package com.Vcan.activity;

import java.util.ArrayList;

import com.vcans.Processor.BaseActivity;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.HackyViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import photoview.OnPhotoTapListener;
import photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;
public class XYImgActivity extends BaseActivity {
	private HackyViewPager viewPager;
	private ArrayList<View> pageview;
	private int currentPosition;
	private ImageView imageView;
	private Bitmap[] bitmaps;
	private ImageView[] imageViews;
	//包裹点点的LinearLayout
	private ViewGroup group;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//设置无标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_xyimg);
		this.<Button>RegOnClickEvent(R.id.btnBack, "finish");
		bitmaps = ActivityHelper.szBitmaps;
		viewPager = (HackyViewPager) findViewById(R.id.mViewPager);
		pageview = new ArrayList<View>();
		currentPosition = getIntent().getIntExtra("imgIndex", 0);


		for (int i = 0; i < bitmaps.length; i++) {
			LayoutInflater inflater1 = getLayoutInflater();
			View view = inflater1.inflate(R.layout.item01, null);
			PhotoView imageView = (PhotoView) view.findViewById(R.id.IMG);
			imageView.setImageBitmap(bitmaps[i]);
			pageview.add(view);


		}

		group = (ViewGroup) findViewById(R.id.viewGroup);
		//有多少张图就有多少个点点
		imageViews = new ImageView[pageview.size()];
		for (int i = 0; i < pageview.size(); i++) {
			imageView = new ImageView(XYImgActivity.this);
			imageView.setLayoutParams(new LayoutParams(20, 20));
			imageView.setPadding(20, 5, 20, 5);
			imageViews[i] = imageView;

			//默认第一张图显示为选中状态

//	        	if (i == 0) {
//	                imageViews[i].setBackgroundResource(R.drawable.page_indicator_focused);
//	            } else {
//	                imageViews[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
//	            }

			group.addView(imageViews[i]);
		}
		//小点跟随
		setImageBackground(currentPosition);
		//绑定适配器
		viewPager.setAdapter(mPagerAdapter);
		//设置显示第几item
		viewPager.setCurrentItem(currentPosition);
		//绑定监听事件
		viewPager.setOnPageChangeListener(new GuidePageChangeListener());
	}


	public  void  pic(Bitmap b){
		Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), b, null,null));
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_SEND);//设置分享行为
		intent.setType("image/*");//设置分享内容的类型
		intent.putExtra(Intent.EXTRA_STREAM, uri);
		intent = Intent.createChooser(intent, "分享");
		startActivity(intent);}

	private void setImageBackground(int selectItems) {
		for (int i = 0; i < imageViews.length; i++) {
			if (i == selectItems) {
				imageViews[i].setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				imageViews[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
			}
		}
	}

	//数据适配器
	PagerAdapter mPagerAdapter = new PagerAdapter(){

		@Override
		//获取当前窗体界面数
		public int getCount() {
			// TODO Auto-generated method stub
			return bitmaps.length;
		}

		@Override
		public View instantiateItem(ViewGroup container, final int position) {
			PhotoView photoView = new PhotoView(container.getContext());
			photoView.setImageBitmap(bitmaps[position]);

			// Now just add PhotoView to ViewPager and return it
			container.addView(photoView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//			photoView.setOnPhotoTapListener(new OnPhotoTapListener() {
//				@Override
//				public void onPhotoTap(ImageView view, float x, float y) {
//                  pic(bitmaps[position]);
//				}
//			});
			photoView.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View view) {
					pic(bitmaps[position]);
					return false;
				}
			});
			return photoView;
		}

		@Override
		//断是否由对象生成界面
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
		//是从ViewGroup中移出当前View
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		//返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
//		public Object instantiateItem(View arg0, int arg1){
//			((ViewPager)arg0).addView(pageview.get(arg1));
//
//			return pageview.get(arg1);
//		}


	};



	//pageView监听器
	class GuidePageChangeListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		//如果切换了，就把当前的点点设置为选中背景，其他设置未选中背景
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			//	ActivityHelper.ToastShow(XYImgActivity.this,arg0+"");
			for(int i=0;i<imageViews.length;i++){
				imageViews[arg0].setBackgroundResource(R.drawable.page_indicator_focused);
				if (arg0 != i) {
					imageViews[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
				}
			}

		}

	}



	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}
}
