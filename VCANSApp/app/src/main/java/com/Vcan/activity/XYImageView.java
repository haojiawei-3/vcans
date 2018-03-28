package com.Vcan.activity;

import java.io.File;
import java.net.URI;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.adapter.ImageSwitcherV2;
import com.vcans.model.BandleParam;
import com.vcans.tool.ActivityHelper;

import android.R.color;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;
import android.widget.TableLayout.LayoutParams;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

public class XYImageView extends BaseActivity implements ViewFactory,OnTouchListener {

	/**
	 * ImagaSwitcher 的引用
	 */
	private ImageSwitcherV2 mImageSwitcher;
	/**
	 * 图片id数组
	 */
	private int[] imgIds;
	/**
	 * 当前选中的图片id序号
	 */
	private int currentPosition;
	/**
	 * 按下点的X坐标
	 */
	private float downX;
	/**
	 * 装载点点的容器
	 */
	private LinearLayout linearLayout;
	/**
	 * 点点数组
	 */
	private ImageView[] tips;
	private Drawable[] bitmapDrawables;
	private Bitmap[] bitmaps;
	private int mLastClickId=-1;
	private long mLastClickTime=0;
	TextView tvTitle;
	String[] szFilepath;
	private boolean bBig=true;
	private int changeImgIndex=-1;
	private Drawable bigDrwable;
	private LinearLayout LLayImage;
	private ImageButton btnReplace;
	private int module;
	TouchListener imageTouchLst=new TouchListener();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setEnabledChangeTitle(false);

		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.xy_imageview);
		this.<Button> RegOnClickEvent(R.id.btnBack, "finish");
		this.<Button> RegOnClickEvent(R.id.btnPhoto,"onReplace");
		LinearLayout layout=(LinearLayout) findViewById(R.id.LinearLayout);
		tvTitle = (TextView) findViewById(R.id.tvActtitle);
		this.setTitle(getString(R.string.image));

		//设置TOP颜色
		LinearLayout layTitle= (LinearLayout)findViewById(R.id.include01);
		layTitle.setBackgroundResource(ActivityHelper.globalSysParam.sysSkin.selectedColor);

		ImageView tvTip = (ImageView) findViewById(R.id.imgNetStatus);
		tvTip.setVisibility(View.INVISIBLE);
		TextView tvNetStatus = (TextView) findViewById(R.id.tvNetStatus);
		tvNetStatus.setVisibility(View.INVISIBLE);
		bitmaps=ActivityHelper.szBitmaps;
		bitmapDrawables=new Drawable[bitmaps.length];

		// 实例化ImageSwitcher
		mImageSwitcher = (ImageSwitcherV2) findViewById(R.id.imageSwitcher1);
		// 设置Factory
		mImageSwitcher.setFactory(this);
		// 设置OnTouchListener，我们通过Touch事件来切换图片
		//mImageSwitcher.setOnTouchListener(this);
		mImageSwitcher.setOnTouchListener(imageTouchLst);

		linearLayout = (LinearLayout) findViewById(R.id.viewGroup);

		tips = new ImageView[bitmaps.length];
		for (int i = 0; i < bitmaps.length; i++) {
			ImageView mImageView = new ImageView(this);
			tips[i] = mImageView;
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT));
			layoutParams.rightMargin = 3;
			layoutParams.leftMargin = 3;

			mImageView.setBackgroundResource(R.drawable.page_indicator_unfocused);
			linearLayout.addView(mImageView, layoutParams);
		}

		currentPosition = getIntent().getIntExtra("imgIndex", 0);
		setImage();
		setImageBackground(currentPosition);

		module=getIntent().getIntExtra("module", 0);
		btnReplace=(ImageButton)this.findViewById(R.id.btnPhoto);
		if(module==0)
		{//样品查询
			layout.setVisibility(View.GONE);
		}
		else
			layout.setVisibility(View.VISIBLE);
	}

	private void setImage()
	{

		Drawable drawable=bitmapDrawables[currentPosition];
		if(drawable==null)
		{
			Bitmap bitmap=Bitmap.createBitmap(bitmaps[currentPosition]);

			WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

			int screenWidth = wm.getDefaultDisplay().getWidth();
			//int screenHeight = wm.getDefaultDisplay().getHeight();
			//int titleHeight=tvTitle.getHeight();
			//width+=200;

			int originWidth=bitmap.getWidth()*ActivityHelper.IMAGE_COMPRESS_RATIO;
			int originHeight=bitmap.getHeight()*ActivityHelper.IMAGE_COMPRESS_RATIO;

			int imgSizeKB=bitmap.getByteCount()/1024;

			if(imgSizeKB<=ActivityHelper.imageReduceMinSize/2)
			{
				int compressRatio=ActivityHelper.IMAGE_COMPRESS_RATIO;
				compressRatio+=1;
				bitmap=ThumbnailUtils.extractThumbnail(bitmap,bitmap.getWidth()*compressRatio,bitmap.getHeight()*compressRatio);
			}
			else if(imgSizeKB<ActivityHelper.imageReduceMinSize)
			{
				int compressRatio=ActivityHelper.IMAGE_COMPRESS_RATIO;
				bitmap=ThumbnailUtils.extractThumbnail(bitmap,bitmap.getWidth()*compressRatio,bitmap.getHeight()*compressRatio);
			}
			else
			{
				screenWidth+=200;
				int outheight1= bitmap.getHeight() * screenWidth/bitmap.getWidth();
				bitmap=ThumbnailUtils.extractThumbnail(bitmap,screenWidth,outheight1);
			}
			drawable=bitmapDrawables[currentPosition] = new BitmapDrawable(bitmap);
		}



		mImageSwitcher.setImageDrawable(drawable);
		tvTitle.setText(getString(R.string.image)+"("+(currentPosition+1)+"/"+bitmaps.length+")");
	}


	public void onReplace()
	{
		Intent resultIntent = new Intent();
		resultIntent.putExtra("imgIndex", this.currentPosition);
		setResult(RESULT_OK, resultIntent);
		this.finish();
	}

	public void onCloseImage()
	{
		mImageSwitcher.setVisibility(View.VISIBLE);
		LLayImage.setVisibility(View.INVISIBLE);

		if(module!=0)
		{//图片替换
			btnReplace.setVisibility(View.VISIBLE);
		}
	}



	final public OnLongClickListener onLongClickListener=new OnLongClickListener()
	{

		public boolean onLongClick(View v) {
			// TODO Auto-generated method stub



			return false;
		}

	};

	//使用Bitmap加Matrix来缩放
	public  Bitmap resizeImage(Bitmap bitmap, int w, int h)
	{
		Bitmap BitmapOrg = bitmap;
		int width = BitmapOrg.getWidth();
		int height = BitmapOrg.getHeight();
		int newWidth = w;
		int newHeight = h;

		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;

		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		// if you want to rotate the Bitmap
		// matrix.postRotate(45);
		Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width,
				height, matrix, true);
		return resizedBitmap;
	}
	/**
	 * 设置选中的tip的背景
	 *
	 * @param selectItems
	 */
	private void setImageBackground(int selectItems) {
		for (int i = 0; i < tips.length; i++) {
			if (i == selectItems) {
				tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
			}
		}
	}

	public View makeView() {
		final ImageView i = new ImageView(this);

		i.setBackgroundColor(0xffe1e0de);//0xff000000
		i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		i.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));

		return i;
	}

	/**
	 * 暂未使用
	 */
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN: {
				// 手指按下的X坐标
				downX = event.getX();

				if(currentPosition==mLastClickId
						&& (Math.abs(mLastClickTime-System.currentTimeMillis()) < 800))
				{
					mLastClickId = -1;
					mLastClickTime = 0;



				}
				else
				{

					mLastClickId =currentPosition;
					mLastClickTime = System.currentTimeMillis();

				}



				break;
			}
			case MotionEvent.ACTION_UP: {


				float lastX = event.getX();

				if (Math.abs(lastX - downX) < 10) {
					return false;// 距离较小，当作click事件来处理
				}

				changeImgIndex=-1;

				// 抬起的时候的X坐标大于按下的时候就显示上一张图片
				if (lastX > downX) {
					if (currentPosition > 0) {//向右滑动
						// 设置动画，这里的动画比较简单，不明白的去网上看看相关内容
						mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(
								getApplication(), R.drawable.in_left_right));
						mImageSwitcher.setOutAnimation(AnimationUtils
								.loadAnimation(getApplication(), R.drawable.out_left_right));
						currentPosition--;
						//mImageSwitcher.setImageResource(imgIds[currentPosition
						//		% imgIds.length]);
						setImage();
						setImageBackground(currentPosition);
					} else {
						Toast.makeText(getApplication(), getString(R.string.firstPage),
								Toast.LENGTH_SHORT).show();
					}
				}

				if (lastX < downX) {
					if (currentPosition < bitmaps.length - 1) {
						mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(
								getApplication(), R.drawable.in_right_left));
						mImageSwitcher.setOutAnimation(AnimationUtils
								.loadAnimation(getApplication(), R.drawable.out_right_left));
						currentPosition++;
						//mImageSwitcher.setImageResource(imgIds[currentPosition]);
						//setImageBackground(currentPosition);
						setImage();
						setImageBackground(currentPosition);
					} else {
						Toast.makeText(getApplication(), getString(R.string.lastPage),
								Toast.LENGTH_SHORT).show();
					}
				}
			}

			break;
		}

		return true;
	}

	private final class TouchListener implements OnTouchListener {

		/** 记录是拖拉照片模式还是放大缩小照片模式 */
		private int mode = 0;// 初始状态
		/** 拖拉照片模式 */
		private static final int MODE_DRAG = 1;
		/** 放大缩小照片模式 */
		private static final int MODE_ZOOM = 2;

		/** 用于记录开始时候的坐标位置 */
		private PointF startPoint = new PointF();
		/** 用于记录拖拉图片移动的坐标位置 */
		private Matrix matrix = new Matrix();
		/** 用于记录图片要进行拖拉时候的坐标位置 */
		private Matrix currentMatrix = new Matrix();

		/** 两个手指的开始距离 */
		private float startDis;
		/** 两个手指的中间点 */
		private PointF midPoint;
		private int pointCount;


		public boolean onTouch(View v, MotionEvent event) {
			/** 通过与运算保留最后八位 MotionEvent.ACTION_MASK = 255 */
			switch (event.getAction() & MotionEvent.ACTION_MASK) {
				// 手指压下屏幕
				case MotionEvent.ACTION_DOWN:

					downX = event.getX();
					mode = MODE_DRAG;
					// 记录ImageView当前的移动位置
					currentMatrix.set( mImageSwitcher.getImageMatrix());
					startPoint.set(event.getX(), event.getY());

					break;
				// 手指在屏幕上移动，改事件会被不断触发
				case MotionEvent.ACTION_MOVE:
					// 拖拉图片

					if (mode == MODE_DRAG) {

						// float dx = event.getX() - startPoint.x; // 得到x轴的移动距离
						// float dy = event.getY() - startPoint.y; // 得到x轴的移动距离
						// 在没有移动之前的位置上进行移动
						// matrix.set(currentMatrix);
						// matrix.postTranslate(dx, dy);
					}
					// 放大缩小图片
					else if (mode == MODE_ZOOM) {

						float endDis = distance(event);// 结束距离
						if (endDis > 10f) { // 两个手指并拢在一起的时候像素大于10

							float scale = endDis / startDis;// 得到缩放倍数
							matrix.set(currentMatrix);

							int x=mImageSwitcher.getImageWidth()/2;
							int y=mImageSwitcher.getImageHeight()/2;
							// matrix.postScale(scale, scale,midPoint.x,midPoint.y);
							matrix.postScale(scale, scale,x,y);
							mImageSwitcher.setScale(scale);
							mImageSwitcher.setScaleType(ScaleType.MATRIX);
						}
					}
					break;
				// 手指离开屏幕
				case MotionEvent.ACTION_UP:

					if(mode == MODE_DRAG)
					{
						float lastX = event.getX();

						if (Math.abs(lastX - downX) < 10) {
							return false;// 距离较小，当作click事件来处理
						}

						changeImgIndex=-1;

						// 抬起的时候的X坐标大于按下的时候就显示上一张图片
						if (lastX > downX) {
							if (currentPosition > 0) {//向右滑动
								// 设置动画，这里的动画比较简单，不明白的去网上看看相关内容
								mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(
										getApplication(), R.drawable.in_left_right));
								mImageSwitcher.setOutAnimation(AnimationUtils
										.loadAnimation(getApplication(), R.drawable.out_left_right));
								currentPosition--;
								//mImageSwitcher.setImageResource(imgIds[currentPosition
								//		% imgIds.length]);
								setImage();
								setImageBackground(currentPosition);
							} else {
								Toast.makeText(getApplication(),  getString(R.string.firstPage),
										Toast.LENGTH_SHORT).show();
							}
						}

						if (lastX < downX) {
							if (currentPosition < bitmaps.length - 1) {
								mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(
										getApplication(), R.drawable.in_right_left));
								mImageSwitcher.setOutAnimation(AnimationUtils
										.loadAnimation(getApplication(), R.drawable.out_right_left));
								currentPosition++;
								//mImageSwitcher.setImageResource(imgIds[currentPosition]);
								//setImageBackground(currentPosition);
								setImage();
								setImageBackground(currentPosition);
							} else {
								Toast.makeText(getApplication(),  getString(R.string.lastPage),
										Toast.LENGTH_SHORT).show();
							}
						}
					}

					break;

				case MotionEvent.ACTION_POINTER_UP:
					mode = 0;

					break;
				// 当屏幕上已经有触点(手指)，再有一个触点压下屏幕
				case MotionEvent.ACTION_POINTER_DOWN:

					// float X0 =event.getX(0);
					// float Y0 =event.getY(0);
					// float X1 =event.getX(1);
					// float Y1 =event.getY(1);

					// int x=mImageSwitcher.getImageWidth()/2;
					// int y=mImageSwitcher.getImageHeight()/2;
					//int w=mImageSwitcher.getInnerWidth()/2;
					// int h=mImageSwitcher.getInnerHeight()/2;
					// if(X0>=(x-w)&&X0<=(x+w)&&Y0>=(y-h)&&Y0<=(y+h)
					// &&X1>=(x-w)&&X1<=(x+w)&&Y1>=(y-h)&&Y1<=(y+h))
					// {
					mode = MODE_ZOOM;

					/** 计算两个手指间的距离 */
					startDis = distance(event);
					/** 计算两个手指间的中间点 */
					if (startDis > 10f) { // 两个手指并拢在一起的时候像素大于10
						midPoint = mid(event);
						//记录当前ImageView的缩放倍数

						currentMatrix.set(mImageSwitcher.getImageMatrix());
					}
					//}



					break;
			}

			mImageSwitcher.setImageMatrix(matrix);
			return true;
		}

		/** 计算两个手指间的距离 */
		private float distance(MotionEvent event) {
			float dx = event.getX(1) - event.getX(0);
			float dy = event.getY(1) - event.getY(0);
			/** 使用勾股定理返回两点之间的距离 */
			return  (float)Math.sqrt(dx * dx + dy * dy);
		}

		/** 计算两个手指间的中间点 */
		private PointF mid(MotionEvent event) {
			float midX = (event.getX(1) + event.getX(0)) / 2;
			float midY = (event.getY(1) + event.getY(0)) / 2;
			return new PointF(midX, midY);
		}

	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
