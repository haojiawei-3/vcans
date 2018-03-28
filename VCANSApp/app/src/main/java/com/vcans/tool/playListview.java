package com.vcans.tool;

import com.Vcan.activity.R;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.View.OnTouchListener;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 鍙繘琛屼笅鎷夊埛鏂扮殑鑷畾涔夋帶浠躲�?
 * 
 * @author guolin
 * 
 */
public class playListview extends LinearLayout implements OnTouchListener {

	/**
	 * 下拉状�?
	 */
	public static final int STATUS_PULL_TO_REFRESH = 0;

	/**
	 * 释放立即刷新状�?
	 */
	public static final int STATUS_RELEASE_TO_REFRESH = 1;

	/**
	 * 正在刷新状�?
	 */
	public static final int STATUS_REFRESHING = 2;

	/**
	 * 刷新完成或未刷新状�?
	 */
	public static final int STATUS_REFRESH_FINISHED = 3;

	/**
	 * 下拉头部回滚的�?�?
	 */
	public static final int SCROLL_SPEED = -30;

	/**
	 * �?��钟的毫秒值，用于判断上次的更新时�?
	 */
	public static final long ONE_MINUTE = 60 * 1000;

	/**
	 * �?��时的毫秒值，用于判断上次的更新时�?
	 *//**
	 * �?��时的毫秒值，用于判断上次的更新时�?
	 */
	public static final long ONE_HOUR = 60 * ONE_MINUTE;

	/**
	 * �?��的毫秒�?，用于判断上次的更新时间
	 */
	public static final long ONE_DAY = 24 * ONE_HOUR;

	/**
	 * �?��的毫秒�?，用于判断上次的更新时间
	 */
	public static final long ONE_MONTH = 30 * ONE_DAY;

	/**
	 * �?��的毫秒�?，用于判断上次的更新时间
	 */
	public static final long ONE_YEAR = 12 * ONE_MONTH;

	/**
	 * 上次更新时间的字符串常量，用于作为SharedPreferences的键�?
	 */
	private static final String UPDATED_AT = "updated_at";

	/**
	 * 涓嬫媺鍒锋柊鐨勫洖璋冩帴鍙�
	 */
	private PullToRefreshListener mListener;

	/**
	 * 鐢ㄤ簬�?樺偍涓婃鏇存柊鏃堕�?
	 */
	private SharedPreferences preferences;

	/**
	 * 涓嬫媺澶寸殑View
	 */
	private View header;

	/**
	 * 闇�鍘讳笅鎷夊埛鏂扮殑ListView
	 */
	private ListView listView;

	/**
	 * 鍒锋柊鏃舵樉�?��殑杩涘害鏉�
	 */
	private ProgressBar progressBar;

	/**
	 * 鎸囩ず涓嬫媺鍜岄噴鏀剧殑绠�?
	 */
	private ImageView arrow;

	/**
	 * 鎸囩ず涓嬫媺鍜岄噴鏀剧殑鏂囧瓧鎻忚堪
	 */
	private TextView description;

	/**
	 * 涓婃鏇存柊鏃堕棿鐨勬枃瀛楁弿杩�?
	 */
	private TextView updateAt;

	/**
	 * 涓嬫媺澶寸殑甯冨眬鍙傛暟
	 */
	private MarginLayoutParams headerLayoutParams;

	/**
	 * 涓婃鏇存柊鏃堕棿鐨勬绉掑�?
	 */
	private long lastUpdateTime;

	/**
	 * 涓轰簡闃叉涓嶅悓鐣岄潰鐨勪笅鎷夊埛鏂板湪涓婃鏇存柊鏃堕棿涓婁簰鐩告湁鍐茬獊锛屼娇鐢╥d鏉ュ仛鍖哄垎
	 */
	private int mId = -1;

	/**
	 * 涓嬫媺澶寸殑楂樺�?
	 */
	private int hideHeaderHeight;

	/**
	 * 褰撳墠澶勭悊浠�箞鐘舵�锛屽彲閫夊�鏈塖TATUS_PULL_TO_REFRESH, STATUS_RELEASE_TO_REFRESH,
	 * STATUS_REFRESHING 鍜�STATUS_REFRESH_FINISHED
	 */
	private int currentStatus = STATUS_REFRESH_FINISHED;;

	/**
	 * 璁板綍涓婁竴娆＄殑鐘舵�鏄粈涔堬紝閬垮厤杩涜閲嶅鎿嶄綔
	 */
	private int lastStatus = currentStatus;

	/**
	 * 鎵嬫寚鎸変笅鏃剁殑灞忓箷绾靛潗鏍�?
	 */
	private float yDown;

	/**
	 * 鍦ㄨ鍒ゅ畾涓烘粴鍔ㄤ箣鍓嶇敤鎴锋墜鎸囧彲浠ョЩ鍔ㄧ殑鏈�ぇ鍊笺�
	 */
	private int touchSlop;

	/**
	 * 鏄惁宸插姞杞�?繃涓�layout锛岃繖閲宱nLayout涓殑鍒濆鍖栧彧闇�姞杞戒竴娆�?
	 */
	private boolean loadOnce;

	/**
	 * 褰撳墠鏄惁鍙互涓嬫媺锛屽彧鏈塋istView婊氬姩鍒板ご鐨勬椂鍊欐墠鍏佽涓嬫媺
	 */
	private boolean ableToPull;

	/**
	 * 涓嬫媺鍒锋柊鎺т欢鐨勬瀯閫犲嚱鏁帮紝浼氬湪杩愯鏃跺姩鎬佹坊鍔犱竴涓笅鎷夊ご鐨勫竷灞��
	 * 
	 * @param context
	 * @param attrs
	 */
	public playListview(Context context, AttributeSet attrs) {
		super(context, attrs);
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
		header = LayoutInflater.from(context).inflate(R.layout.pull_to_refresh, null, true);
		progressBar = (ProgressBar) header.findViewById(R.id.progress_bar);
		arrow = (ImageView) header.findViewById(R.id.arrow);
		description = (TextView) header.findViewById(R.id.description);
		updateAt = (TextView) header.findViewById(R.id.updated_at);
		touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
		refreshUpdatedAtValue();
		setOrientation(VERTICAL);
		addView(header, 0);
	}

	/**
	 * 杩涜涓�簺鍏抽敭鎬х殑鍒濆鍖栨搷浣滐紝姣斿锛氬皢涓嬫媺澶村悜涓婂亸绉昏繘琛岄殣钘忥紝缁橪istView娉ㄥ唽touch浜嬩欢銆�?
	 */
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		if (changed && !loadOnce) {
			hideHeaderHeight = -header.getHeight();
			headerLayoutParams = (MarginLayoutParams) header.getLayoutParams();
			headerLayoutParams.topMargin = hideHeaderHeight;
			listView = (ListView) getChildAt(1);
			listView.setOnTouchListener(this);
			loadOnce = true;
		}
	}

	
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		setIsAbleToPull(event);
		boolean ss=false;
		if (ableToPull) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				yDown = event.getRawY();			
				break;
			case MotionEvent.ACTION_MOVE:
				float yMove = event.getRawY();
				int distance = (int) (yMove - yDown);
				
				if (distance <= 0 && headerLayoutParams.topMargin <= hideHeaderHeight) {
					
					return false;
				}
				if (distance < touchSlop) {
					return false;
				}
				if (currentStatus != STATUS_REFRESHING) {
					if (headerLayoutParams.topMargin > 0) {
						currentStatus = STATUS_RELEASE_TO_REFRESH;
					} else {
						currentStatus = STATUS_PULL_TO_REFRESH;
						ss=true;
					}
					
					headerLayoutParams.topMargin = (distance / 3) + hideHeaderHeight;
					header.setLayoutParams(headerLayoutParams);
					
				}
				
				break;
			case MotionEvent.ACTION_UP:
			default:
				if (currentStatus == STATUS_RELEASE_TO_REFRESH) {
					
					new RefreshingTask().execute();
				} else if (currentStatus == STATUS_PULL_TO_REFRESH) {
					
					new HideHeaderTask().execute();
				}
				if (currentStatus == STATUS_PULL_TO_REFRESH|| currentStatus == STATUS_RELEASE_TO_REFRESH) {
					updateHeaderView();
					
					listView.setPressed(false);
					listView.setFocusable(false);
					listView.setFocusableInTouchMode(false);
					lastStatus = currentStatus;
					
					return true;
				}
				break;
			}
			
			
		}
		return ss;
	}

	public void setOnRefreshListener(PullToRefreshListener listener, int id) {
		mListener = listener;
		mId = id;
	}

	
	public void finishRefreshing() {
		currentStatus = STATUS_REFRESH_FINISHED;
		preferences.edit().putLong(UPDATED_AT + mId, System.currentTimeMillis()).commit();
		new HideHeaderTask().execute();
	}

	private void setIsAbleToPull(MotionEvent event) {
		View firstChild = listView.getChildAt(0);
		if (firstChild != null) {
			int firstVisiblePos = listView.getFirstVisiblePosition();
			if (firstVisiblePos == 0 && firstChild.getTop() == 0) {
				if (!ableToPull) {
					yDown = event.getRawY();
				}
				
				ableToPull = true;
			} else {
				if (headerLayoutParams.topMargin != hideHeaderHeight) {
					headerLayoutParams.topMargin = hideHeaderHeight;
					header.setLayoutParams(headerLayoutParams);
				}
				ableToPull = false;
			}
		} else {
			
			ableToPull = true;
		}
	}

	/**
	 * 鏇存柊涓嬫媺澶翠腑鐨勪俊鎭�?
	 */
	private void updateHeaderView() {
		if (lastStatus != currentStatus) {
			if (currentStatus == STATUS_PULL_TO_REFRESH) {
				description.setText(getResources().getString(R.string.pull_to_refresh));
				arrow.setVisibility(View.VISIBLE);
				progressBar.setVisibility(View.GONE);
				rotateArrow();
			} else if (currentStatus == STATUS_RELEASE_TO_REFRESH) {
				description.setText(getResources().getString(R.string.release_to_refresh));
				arrow.setVisibility(View.VISIBLE);
				progressBar.setVisibility(View.GONE);
				rotateArrow();
			} else if (currentStatus == STATUS_REFRESHING) {
				description.setText(getResources().getString(R.string.refreshing));
				progressBar.setVisibility(View.VISIBLE);
				arrow.clearAnimation();
				arrow.setVisibility(View.GONE);
			}
			refreshUpdatedAtValue();
		}
	}

	/**
	 * 鏍规嵁褰撳墠鐨勭姸鎬佹潵鏃嬭浆绠ご銆�
	 */
	private void rotateArrow() {
		float pivotX = arrow.getWidth() / 2f;
		float pivotY = arrow.getHeight() / 2f;
		float fromDegrees = 0f;
		float toDegrees = 0f;
		if (currentStatus == STATUS_PULL_TO_REFRESH) {
			fromDegrees = 180f;
			toDegrees = 360f;
		} else if (currentStatus == STATUS_RELEASE_TO_REFRESH) {
			fromDegrees = 0f;
			toDegrees = 180f;
		}
		RotateAnimation animation = new RotateAnimation(fromDegrees, toDegrees, pivotX, pivotY);
		animation.setDuration(100);
		animation.setFillAfter(true);
		arrow.startAnimation(animation);
	}

	/**
	 * 鍒锋柊涓嬫媺澶翠腑涓婃鏇存柊鏃堕棿鐨勬枃�?楁弿杩般�?
	 */
	private void refreshUpdatedAtValue() {
		lastUpdateTime = preferences.getLong(UPDATED_AT + mId, -1);
		long currentTime = System.currentTimeMillis();
		long timePassed = currentTime - lastUpdateTime;
		long timeIntoFormat;
		String updateAtValue;
		if (lastUpdateTime == -1) {
			updateAtValue = getResources().getString(R.string.not_updated_yet);
		} else if (timePassed < 0) {
			updateAtValue = getResources().getString(R.string.time_error);
		} else if (timePassed < ONE_MINUTE) {
			updateAtValue = getResources().getString(R.string.updated_just_now);
		} else if (timePassed < ONE_HOUR) {
			timeIntoFormat = timePassed / ONE_MINUTE;
			String value = timeIntoFormat + "分钟";
			updateAtValue = String.format(getResources().getString(R.string.updated_at), value);
		} else if (timePassed < ONE_DAY) {
			timeIntoFormat = timePassed / ONE_HOUR;
			String value = timeIntoFormat + "小时";
			updateAtValue = String.format(getResources().getString(R.string.updated_at), value);
		} else if (timePassed < ONE_MONTH) {
			timeIntoFormat = timePassed / ONE_DAY;
			String value = timeIntoFormat + "天";
			updateAtValue = String.format(getResources().getString(R.string.updated_at), value);
		} else if (timePassed < ONE_YEAR) {
			timeIntoFormat = timePassed / ONE_MONTH;
			String value = timeIntoFormat + "个月";
			updateAtValue = String.format(getResources().getString(R.string.updated_at), value);
		} else {
			timeIntoFormat = timePassed / ONE_YEAR;
			String value = timeIntoFormat + "年";
			updateAtValue = String.format(getResources().getString(R.string.updated_at), value);
		}
		updateAt.setText(updateAtValue);
	}
	/**
	 * 下拉刷新的监听器，使用下拉刷新的地方应该注册此监听器来获取刷新回调�?
	 * 
	 * @author guolin
	 */
	class RefreshingTask extends AsyncTask<Void, Integer, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			int topMargin = headerLayoutParams.topMargin;
			while (true) {
				topMargin = topMargin + SCROLL_SPEED;
				if (topMargin <= 0) {
					topMargin = 0;
					break;
				}
				publishProgress(topMargin);
				sleep(10);
			}
			currentStatus = STATUS_REFRESHING;
			publishProgress(0);
			if (mListener != null) {
				mListener.onRefresh();
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... topMargin) {
			updateHeaderView();
			headerLayoutParams.topMargin = topMargin[0];
			header.setLayoutParams(headerLayoutParams);
		}

	}

	/**
	 * 下拉刷新的监听器，使用下拉刷新的地方应该注册此监听器来获取刷新回调�?
	 * 
	 * @author guolin
	 */
	class HideHeaderTask extends AsyncTask<Void, Integer, Integer> {

		@Override
		protected Integer doInBackground(Void... params) {
			int topMargin = headerLayoutParams.topMargin;
			while (true) {
				topMargin = topMargin + SCROLL_SPEED;
				if (topMargin <= hideHeaderHeight) {
					topMargin = hideHeaderHeight;
					break;
				}
				publishProgress(topMargin);
				sleep(10);
			}
			return topMargin;
		}

		@Override
		protected void onProgressUpdate(Integer... topMargin) {
			headerLayoutParams.topMargin = topMargin[0];
			header.setLayoutParams(headerLayoutParams);
		}

		@Override
		protected void onPostExecute(Integer topMargin) {
			headerLayoutParams.topMargin = topMargin;
			header.setLayoutParams(headerLayoutParams);
			currentStatus = STATUS_REFRESH_FINISHED;
		}
	}

	/**
	 * 浣垮綋鍓嶇嚎绋嬬潯鐪犳寚瀹氱殑姣鏁般�?
	 * 
	 * @param time
	 *            鎸囧畾褰撳墠绾跨▼鐫＄湢澶氫箙锛屼互姣涓哄崟浣�
	 */
	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 下拉刷新的监听器，使用下拉刷新的地方应该注册此监听器来获取刷新回调�?
	 * 
	 * @author guolin
	 */
	public interface PullToRefreshListener {

		/**
		 * 刷新时会去回调此方法，在方法内编写具体的刷新逻辑。注意此方法是在子线程中调用的， 你可以不必另�?��程来进行耗时操作�?
		 */
		void onRefresh();

	}

}
