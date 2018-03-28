package com.Vcan.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPRZTaskUploadProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ListViewForScrollView;
import com.vcans.tool.PlProcessor;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TimePicker;
import android.widget.ViewFlipper;
/**
 * 任务简报   有2个界面类 分别  DPRZTask  DPRZTask1
 * @author vcans
 *
 */
public class DPRZTask1 extends BaseActivity {
	// public static DPRZTask1 dprzTask1 = null;
	private DPRZTaskUploadProcessor mUploadTouPei=null;
	private ListViewForScrollView mListView;
	private int mLastClickId=-1;
	private long mLastClickTime=0;
	private List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	private TextView tvPage;
	private EditText txtDatetime;
	private Dialog mDatedialog=null ;
	private ViewFlipper viewFlipper;
	private float startX = 0, startY;
	private float startX2 = 0, startY2;
	private int pageIndex = 1;
	ScrollView sv;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_rztask1);
		// dprzTask1=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onUpload");
		this.<Button>RegOnClickEvent(R.id.btnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.imgBtnSave,"onSave");
		this.<Button>RegOnClickEvent(R.id.tvClear,"onClear");
		this.<Button>RegOnClickEvent(R.id.BtnDelete,"onDelete");
		sv = (ScrollView) findViewById(R.id.sv);
		sv.smoothScrollTo(0, 0);

		Button btnNext=(Button)this.findViewById(R.id.btnOk);
		btnNext.setText(getString(R.string.btn_upload));

		ImageButton imgBtnNext=(ImageButton)this.findViewById(R.id.imgBtnOk);
		imgBtnNext.setImageResource(R.drawable.upload);

		txtDatetime=(EditText)this.findViewById(R.id.txtDatetime);
		txtDatetime.setOnTouchListener(touchListener);

		mUploadTouPei=new DPRZTaskUploadProcessor();
		PlProcessor.SetParent(this);

		mUploadTouPei.DisplayTouPeiInfo();

		mListView=(ListViewForScrollView)this.findViewById(R.id.lvProdct);

		mListView.setOnItemClickListener(listClickListener);
		tvPage = (TextView) findViewById(R.id.tvPage);
	}

	public final OnItemClickListener listClickListener=new OnItemClickListener(){

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
								long arg3) {

			//获得选中项的HashMap对象
			HashMap<String,Object> mapToupei=(HashMap<String,Object>)mListView.getItemAtPosition(arg2);
			mstrDataId=(String)mapToupei.get("TPId");
			String[] szStr=tvPage.getText().toString().split("/");
			tvPage.setText("("+(arg2+1)+"/"+szStr[1]);


			// 如果是双击,1秒内连续点击判断为双击
			if(arg2==mLastClickId
					&& (Math.abs(mLastClickTime-System.currentTimeMillis()) < 1000))
			{
				mLastClickId = -1;
				mLastClickTime = 0;

				mDataList.clear();
				mDataList.add(mapToupei);


				mUploadTouPei.displayDetail(mDataList);

			}
			else
			{
				mLastClickId =arg2;
				mLastClickTime = System.currentTimeMillis();
			}

		}
	};

	public final OnTouchListener viewFltouchListener=new OnTouchListener(){

		public boolean onTouch(View arg0, MotionEvent event) {

			switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					startX = event.getX();
					startY = event.getY();
					break;
				case MotionEvent.ACTION_UP:

					startX2 = event.getX();
					startY2 = event.getY();

					if (Math.abs(startX - startX2) < 10) {
						return false;// 距离较小，当作click事件来处理
					}

					if (event.getX() > startX) { // 向右滑动
						if (pageIndex >= 2) {// 为第二页时可向右滑动
							//viewFlipper.setInAnimation(VCANSAppActivity.this, R.drawable.in_left_right);
							//viewFlipper.setOutAnimation(VCANSAppActivity.this, R.drawable.out_left_right);
							viewFlipper.showPrevious();
							pageIndex--;
							//String[] szStr = mTvPageNum.getText().toString().split("/");
							//mTvPageNum.setText("(" + (pageIndex) + "/" + szStr[1]);
						}

					} else if (event.getX() < startX) { // 向左滑动
						if (pageIndex < 2) {// 为第一页时可向左滑动
							//viewFlipper.setInAnimation(VCANSAppActivity.this, R.drawable.in_right_left);
							//viewFlipper.setOutAnimation(VCANSAppActivity.this, R.drawable.out_right_left);
							viewFlipper.showNext();
							pageIndex++;
							//String[] szStr = mTvPageNum.getText().toString().split("/");
							//mTvPageNum.setText("(" + (pageIndex) + "/" + szStr[1]);
						}
					}

					break;
			}


			return true;
		}

	};



	public final OnTouchListener touchListener=new OnTouchListener(){

		public boolean onTouch(View arg0, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {

				//txtDatetime.setEnabled(false);
				//txtDatetime.setText(getString(R.string.btn_load)+"...");
				final MotionEvent event1=event;

				new Handler().post(new Runnable(){

					public void run() {

						AlertDialog.Builder builder = new AlertDialog.Builder(DPRZTask1.this);
						View view = View.inflate(DPRZTask1.this, R.layout.datetime_dialog, null);
						final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
						final TimePicker timePicker = (android.widget.TimePicker) view.findViewById(R.id.time_picker);
						builder.setView(view);
						final TextView tvData=(TextView) view.findViewById(R.id.tvData);
						final TextView tvTime=(TextView) view.findViewById(R.id.tvTime);
						tvData.setTextColor(Color.GRAY);
						viewFlipper=(ViewFlipper)view.findViewById(R.id.viewFlipper);
						//viewFlipper.setOnTouchListener(viewFltouchListener);
						tvData.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								viewFlipper.showPrevious();
								tvData.setTextColor(Color.GRAY);
								tvTime.setTextColor(Color.WHITE);
							}

						});

						tvTime.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								viewFlipper.showNext();
								tvData.setTextColor(Color.WHITE);
								tvTime.setTextColor(Color.GRAY);
							}

						});

						Calendar cal = Calendar.getInstance();
						cal.setTimeInMillis(System.currentTimeMillis());
						datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);

						timePicker.setIs24HourView(true);
						timePicker.setCurrentHour(cal.get(Calendar.HOUR_OF_DAY));
						timePicker.setCurrentMinute(cal.get(Calendar.MINUTE));

						final int inType = txtDatetime.getInputType();
						txtDatetime.setInputType(InputType.TYPE_NULL);
						txtDatetime.onTouchEvent(event1);
						txtDatetime.setInputType(inType);
						txtDatetime.setSelection(txtDatetime.getText().length());

						//builder.setTitle(getString(R.string.pickTime));
						builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int which) {

								StringBuffer sb = new StringBuffer();
								sb.append(String.format("%d-%02d-%02d %02d:%02d",
										datePicker.getYear(),
										datePicker.getMonth() + 1,
										datePicker.getDayOfMonth(),
										timePicker.getCurrentHour(),
										timePicker.getCurrentMinute()));

								txtDatetime.setText(sb);

								dialog.cancel();
								mDatedialog=null;

								txtDatetime.setEnabled(true);
							}
						});

						if(mDatedialog!=null)
						{
							mDatedialog.cancel();
						}

						mDatedialog = builder.create();

						mDatedialog.show();
					}
				});

			}

			return true;
		}


	};



	public void onUpload()
	{//上传

		if(mListView.getCount()>0)
		{
			//ActivityHelper.showStatusDialog(this, "等待服务器响应...");
			//this.getDataTrunsfer().SetProcessor(mUploadTouPei);
			// mUploadTouPei.SendBeginUpload();

			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.processor = mUploadTouPei;
			getDataTrunsfer().beginUploadText(sendParam);
		}
		else
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.noData));
		}

	}

	public void onSave()
	{
		PlProcessor.SetParent(this);
		ActivityHelper.hidesofeKeyboard(this);
		mUploadTouPei.SaveToupeiInfo();
	}

	public void onClear()
	{
		if(mListView.getCount()<1)
		{
			return ;
		}

		new AlertDialog.Builder(this).setTitle(getString(R.string.askClear))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						mUploadTouPei.ClearToupeiInfo();
						mUploadTouPei.DisplayTouPeiInfo();

					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
	}

	public void onDelete()
	{
		if(mListView.getCount()<1)
		{
			return ;
		}

		if(mstrDataId.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.noSelected));
			return;
		}

		new AlertDialog.Builder(this).setTitle(getString(R.string.askDelete))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						if(!mstrDataId.equals(""))
						{
							mUploadTouPei.DeleteToupeiInfo(mstrDataId);
							mUploadTouPei.DisplayTouPeiInfo();
							mstrDataId="";
						}
					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
	}

	@Override
	public void processMessage(int msgId, String msg) {


	}

}
