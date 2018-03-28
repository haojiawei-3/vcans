package com.vcans.tool;

import com.Vcan.activity.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
/**
 *    显示GJF   自定义view
 */
public class GifView extends View {

	/**
	 * 榛樿涓?绉?
	 */
	private static final int DEFAULT_MOVIE_DURATION = 1000;

	private int mMovieResourceId;

	private Movie mMovie;

	private long mMovieStart;

	private int mCurrentAnimationTime = 0;

	private float mLeft;

	private float mTop;

	private float mScale;

	private int mMeasuredMovieWidth;

	private int mMeasuredMovieHeight;

	private boolean mVisible = true;

	private volatile boolean mPaused = false;

	/**
	 * 鏋勯?鍑芥暟
	 */
	public GifView(Context context) {
		this(context, null);
	}

	public GifView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public GifView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setViewAttributes(context, attrs, defStyle);
		//可设置背景
		//setBackgroundColor(Color.parseColor("#FFB6C1"));
	}

	@SuppressLint("NewApi")
	private void setViewAttributes(Context context, AttributeSet attrs,
								   int defStyle) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}
		final TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.GifView);
		mMovieResourceId = array.getResourceId(R.styleable.GifView_gif, -1);
		mPaused = array.getBoolean(R.styleable.GifView_paused, false);
		array.recycle();
		if (mMovieResourceId != -1) {
			mMovie = Movie.decodeStream(getResources().openRawResource(
					mMovieResourceId));
		}
	}

	/**
	 * 璁剧疆gif鍥捐祫婧?
	 */
	public void setMovieResource(int movieResId) {
		this.mMovieResourceId = movieResId;
		mMovie = Movie.decodeStream(getResources().openRawResource(
				mMovieResourceId));
		requestLayout();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (mMovie != null) {
			//gif鍔ㄧ敾鐨勫搴︺?楂樺害
			int movieWidth = mMovie.width();
			int movieHeight = mMovie.height();
			//鎺т欢鐨勫搴?
			int maximumWidth = MeasureSpec.getSize(widthMeasureSpec);
			//gif鍥剧墖瀹?鎺т欢瀹?
			float scaleW = (float) movieWidth / (float) maximumWidth;
			mScale = 1f / scaleW;
			mMeasuredMovieWidth = maximumWidth;
			mMeasuredMovieHeight = (int) (movieHeight * mScale);
			setMeasuredDimension(mMeasuredMovieWidth, mMeasuredMovieHeight);
		} else {
			setMeasuredDimension(getSuggestedMinimumWidth(),
					getSuggestedMinimumHeight());
		}
	}

//	@Override
//	protected void onLayout(boolean changed, int l, int t, int r, int b) {
//		super.onLayout(changed, l, t, r, b);
//		mLeft = (getWidth() - mMeasuredMovieWidth) / 2f;
//		mTop = (getHeight() - mMeasuredMovieHeight) / 2f;
//		mVisible = getVisibility() == View.VISIBLE;
//	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (mMovie != null) {
			if (!mPaused) {
				updateAnimationTime();
				drawMovieFrame(canvas);
				invalidateView();
			} else {
				drawMovieFrame(canvas);
			}
		}
	}
	private void updateAnimationTime() {
		long now = android.os.SystemClock.uptimeMillis();
		// 濡傛灉绗竴甯э紝璁板綍璧峰鏃堕棿
		if (mMovieStart == 0) {
			mMovieStart = now;
		}
		// 鍙栧嚭鍔ㄧ敾鐨勬椂闀?
		int dur = mMovie.duration();
		if (dur == 0) {
			dur = DEFAULT_MOVIE_DURATION;
		}
		// 绠楀嚭闇?鏄剧ず绗嚑甯?
		mCurrentAnimationTime = (int) ((now - mMovieStart) % dur);
	}


	private void drawMovieFrame(Canvas canvas) {
		// 璁剧疆瑕佹樉绀虹殑甯э紝缁樺埗鍗冲彲
		mMovie.setTime(mCurrentAnimationTime);
		canvas.save(Canvas.MATRIX_SAVE_FLAG);
		canvas.scale(mScale, mScale);
		mMovie.draw(canvas, mLeft / mScale, mTop / mScale);
		canvas.restore();
	}


	@SuppressLint("NewApi")
	private void invalidateView() {
		if (mVisible) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
				postInvalidateOnAnimation();
			} else {
				invalidate();
			}
		}
	}




	// --------------------浠ヤ笅鏂规硶鏈皟鐢?-----------------------------------/
	public void setMovie(Movie movie) {
		this.mMovie = movie;
		requestLayout();
	}

	public Movie getMovie() {
		return mMovie;
	}

	public void setMovieTime(int time) {
		mCurrentAnimationTime = time;
		invalidate();
	}

	public void setPaused(boolean paused) {
		this.mPaused = paused;
		if (!paused) {
			mMovieStart = android.os.SystemClock.uptimeMillis()
					- mCurrentAnimationTime;
		}
		invalidate();
	}

	public boolean isPaused() {
		return this.mPaused;
	}

	@SuppressLint("NewApi")
	@Override
	public void onScreenStateChanged(int screenState) {
		super.onScreenStateChanged(screenState);
		mVisible = screenState == SCREEN_STATE_ON;
		invalidateView();
	}

	@SuppressLint("NewApi")
	@Override
	protected void onVisibilityChanged(View changedView, int visibility) {
		super.onVisibilityChanged(changedView, visibility);
		mVisible = visibility == View.VISIBLE;
		invalidateView();
	}

	@Override
	protected void onWindowVisibilityChanged(int visibility) {
		super.onWindowVisibilityChanged(visibility);
		mVisible = visibility == View.VISIBLE;
		invalidateView();
	}
	// --------------------------------------------------------/
}
