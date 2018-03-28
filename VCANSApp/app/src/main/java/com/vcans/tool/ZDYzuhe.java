package com.vcans.tool;



import java.util.Calendar;
import java.util.List;
import com.Vcan.activity.R;
import com.example.qr_codescan.MipcaActivityCapture;
import com.vcans.model.MenuK;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ViewFlipper;
import android.widget.AdapterView.OnItemSelectedListener;
/**
 *
 *   根据数据显示控件的类型
 *   VCANS需求控件*/

public class ZDYzuhe extends RelativeLayout {
	//不可改动
	public  static String TYPE1="日期输入";
	public  static String TYPE2="数值输入";
	public  static String TYPE3="数值提示";
	public  static String TYPE4="数值提示可改";
	public  static String TYPE5="文本输入";
	public  static String TYPE6="文本提示";
	public  static String TYPE7="文本提示可改";
	public  static String TYPE8="选择";

	public  GifViewOnClickListener clickListener;
	public  Spinner spinner;
	public	RelativeLayout layout;
	public	String Type,contentText;
	public	EditText editText;
	public	GifView gifView;
	public	TextView button;
	public	String name;
	public	MenuK menuK;

	public ZDYzuhe(Context context)
	{
		this(context, null);
	}

	public void setgifView(final GifViewOnClickListener OnClickListener)
	{
		gifView.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				OnClickListener.OnClickListener1();
//
			}
		});

		button.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				OnClickListener.OnClickListener2();
			}
		});

		editText.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				OnClickListener.OnClickListener3();
			}
		});


	}




	public void setGifViewInterface(GifViewOnClickListener GifViewOnClickListener)
	{
		this.clickListener =  GifViewOnClickListener;
	}
	public ZDYzuhe(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.myzdy, this, true);
		button = (TextView) findViewById(R.id.btnLoadFactoryName);
		spinner = (Spinner) findViewById(R.id.Spinner);
		editText= (EditText) findViewById(R.id.EditText);
		layout= (RelativeLayout) findViewById(R.id.RelativeLayout);
		gifView= (GifView) findViewById(R.id.btnScanBarcode);
		TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ZDYzuhe);
		if (attributes != null) {
			Type = attributes.getString(R.styleable.ZDYzuhe_Type);
			if (Type!=null) {
				if (Type.equals(TYPE1)) {
					Date();
				}else if (Type.equals(TYPE2)) {
					editText.setVisibility(View.VISIBLE);
					editText.setInputType(InputType.TYPE_CLASS_NUMBER);
				}else if (Type.equals(TYPE3)) {
					editText.setVisibility(View.VISIBLE);
					editText.setFocusable(false);
				}else if (Type.equals(TYPE4)) {
					editText.setVisibility(View.VISIBLE);
					editText.setInputType(InputType.TYPE_CLASS_NUMBER);
				}else if (Type.equals(TYPE5)) {
					editText.setVisibility(View.VISIBLE);
					//gifView.setVisibility(View.VISIBLE);
				}else if (Type.equals(TYPE6)) {
					editText.setVisibility(View.VISIBLE);
					editText.setFocusable(false);
				}else if (Type.equals(TYPE7)) {
					editText.setVisibility(View.VISIBLE);
				}else if (Type.equals(TYPE8)) {
					spinner.setVisibility(View.VISIBLE);
				}


			}else {




			}


		}

		attributes.recycle();


	}


	//标准模板
	  /* @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	  }

	    @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
	     super.onLayout(changed, left, top, right, bottom);
	   }

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.onDraw(canvas);
		}*/

	public void setText(String name){

		this.name=name;

	}

	public String getText(){

		return this.name;

	}


	public void SetEditText(String string){

		editText.setVisibility(View.VISIBLE);
		editText.setText(string);

	}

	public String GetText(){
		String TEXT = null;
		if (menuK.strEnabled.equals("Y")) {
			if (Type.equals(TYPE1)) {
				TEXT=editText.getText().toString();
				if (TEXT.equals("")&&menuK.notnull.equals("Y")){
					TEXT="1900-01-01";
				}
			}else if (Type.equals(TYPE2)) {
				TEXT=editText.getText().toString();
				if (TEXT.equals("")&&menuK.notnull.equals("Y")){
					TEXT="0";
				}
			}else if (Type.equals(TYPE3)) {
				TEXT=editText.getText().toString();
				if (TEXT.equals("")&&menuK.notnull.equals("Y")){
					TEXT="0";
				}
			}else if (Type.equals(TYPE4)) {
				TEXT=editText.getText().toString();
				if (TEXT.equals("")&&menuK.notnull.equals("Y")){
					TEXT="0";
				}
			}else if (Type.equals(TYPE5)) {
				TEXT=editText.getText().toString();
				if (TEXT.equals("")&&menuK.notnull.equals("Y")){
					TEXT="-";
				}
			}else if (Type.equals(TYPE6)) {
				TEXT=editText.getText().toString();
				if (TEXT.equals("")&&menuK.notnull.equals("Y")){
					TEXT="-";
				}
			}else if (Type.equals(TYPE7)) {
				TEXT=editText.getText().toString();
				if (TEXT.equals("")&&menuK.notnull.equals("Y")){
					TEXT="-";
				}
			}else if (Type.equals(TYPE8)) {
				TEXT=getDropText(spinner);
				if (TEXT.equals("")&&menuK.notnull.equals("Y")){
					TEXT="-";
				}
			}
		}else {
			if (Type.equals(TYPE1)) {
				TEXT="1900-01-01";
			}else if (Type.equals(TYPE2)) {
				TEXT="0";
			}else if (Type.equals(TYPE3)) {
				TEXT="0";
			}else if (Type.equals(TYPE4)) {
				TEXT="0";
			}else if (Type.equals(TYPE5)) {
				TEXT="-";
			}else if (Type.equals(TYPE6)) {
				TEXT="-";
			}else if (Type.equals(TYPE7)) {
				TEXT="-";
			}else if (Type.equals(TYPE8)) {
				TEXT="-";
			}
		}


		return TEXT;
	}



	public String getDropText(Spinner drop) {

		String str="";
		if(drop.getSelectedItem()!=null)
			str=drop.getSelectedItem().toString().trim();

		return str;
	}


	public void SetMenu(MenuK Menu){
		this.Type=Menu.type;
		this.menuK=Menu;
		if (Menu.type.equals(TYPE1)) {
			Date();
		}else if (Menu.type.equals(TYPE2)) {
			editText.setVisibility(View.VISIBLE);
			editText.setInputType(InputType.TYPE_CLASS_PHONE);
		}else if (Menu.type.equals(TYPE3)) {
			editText.setVisibility(View.VISIBLE);
			editText.setFocusable(false);
		}else if (Menu.type.equals(TYPE4)) {
			editText.setVisibility(View.VISIBLE);
			editText.setInputType(InputType.TYPE_CLASS_PHONE);
		}else if (Menu.type.equals(TYPE5)) {
			editText.setVisibility(View.VISIBLE);
			//2017.10.10改
			//gifView.setVisibility(View.VISIBLE);
		}else if (Menu.type.equals(TYPE6)) {
			editText.setVisibility(View.VISIBLE);
			editText.setFocusable(false);
		}else if (Menu.type.equals(TYPE7)) {
			editText.setVisibility(View.VISIBLE);
		}else if (Menu.type.equals(TYPE8)) {
			spinner.setVisibility(View.VISIBLE);
		}
		if (Menu.instant.equals("Y")) {
			button.setVisibility(View.VISIBLE);
		}
//		if (Menu.strEnabled.equals("N")) {
//			editText.setText("0");
//		}

//		if (Menu.total.equals("Y")) {
//			gifView.setVisibility(View.VISIBLE);
//		}
		if (Menu.Scanning.equals("Y")) {
			gifView.setVisibility(View.VISIBLE);
		}

		this.name=Menu.title;


	}

	public MenuK getMenu(){
		return menuK;

	}





	public void SetSpinner(List<String> dataList) {

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
		spinner.setVisibility(View.VISIBLE);
		ArrayAdapter<String>   adapter = new ArrayAdapter<String>(layout.getContext(),android.R.layout.simple_spinner_item,szData);

		//设置下拉列表的风格
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		//将adapter 添加到spinner中


		if(spinner!=null)
		{
			spinner.setAdapter(adapter);


			spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

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


	static class SpinnerSelectedListener implements OnItemSelectedListener{

		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
								   long arg3) {

		}

		public void onNothingSelected(AdapterView<?> arg0) {
		}
	}


	public void Date() {
		editText.setVisibility(View.VISIBLE);
		editText.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View arg0, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {

					final MotionEvent event1=event;

					new Handler().post(new Runnable(){

						public void run() {
							final ViewFlipper viewFlipper;
							Dialog mDatedialog = null;
							AlertDialog.Builder builder = new AlertDialog.Builder(layout.getContext());
							View view = View.inflate(layout.getContext(), R.layout.datetime_dialog, null);
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

							final int inType = editText.getInputType();
							editText.setInputType(InputType.TYPE_NULL);
							editText.onTouchEvent(event1);
							editText.setInputType(inType);
							editText.setSelection(editText.getText().length());


							builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog, int which) {

									StringBuffer sb = new StringBuffer();
									sb.append(String.format("%d-%02d-%02d",
											datePicker.getYear(),
											datePicker.getMonth() + 1,
											datePicker.getDayOfMonth()
											));

									editText.setText(sb);

									dialog.cancel();
									//mDatedialog=null;

									editText.setEnabled(true);
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
		});
	}

	public	interface  GifViewOnClickListener{
		//条码扫描
		public void OnClickListener1();
		//即发字段
		public void OnClickListener2();
		//备用
		public void OnClickListener3();

	}

}
