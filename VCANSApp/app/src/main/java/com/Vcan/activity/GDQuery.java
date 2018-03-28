package com.Vcan.activity;
import java.util.ArrayList;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.GDQueryDownFZProc;
import com.vcans.model.GDDirectOutInfo;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * 综合查询   相关界面类 GDQuery，GDQueryResult
 * @author vcans
 *
 */
public class GDQuery extends BaseActivity {
	//public static GDQuery gdQuery = null;
	//查询模块标志  值：一/二/三 /四
	public static String gQueryFlag="";
	private Spinner dropBakType;
	private Spinner dropFuZhuData1;
	private Spinner dropFuZhuData2;
	private Spinner dropFuZhuData3;
	private EditText txtDataItem1;
	private EditText txtDataItem2;
	private Button mBtnOk;
	private ImageButton mImgBtnOk;
	private boolean isDataItem1;
	private String mstrType="";
	private String mstrDataItem1="";
	private String mstrDataItem2="";
	public static GDDirectOutInfo queryData=new GDDirectOutInfo();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gd_query);
		// gdQuery=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onQuery");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onQuery");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"onOpenScanBarcode1");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode2,"onOpenScanBarcode2");

		dropBakType=(Spinner)this.findViewById(R.id.dropBakType);
		txtDataItem1=(EditText)findViewById(R.id.txtDataItem1);
		txtDataItem2=(EditText)findViewById(R.id.txtDataItem2);
		dropFuZhuData1=(Spinner)this.findViewById(R.id.dropFuZhuData1);
		dropFuZhuData2=(Spinner)this.findViewById(R.id.dropFuZhuData2);
		dropFuZhuData3=(Spinner)this.findViewById(R.id.dropFuZhuData3);
		mBtnOk=(Button)this.findViewById(R.id.btnOk);
		mImgBtnOk=(ImageButton)findViewById(R.id.imgBtnOk);
		mBtnOk.setText(getString(R.string.btn_query));
		mImgBtnOk.setImageResource(R.drawable.query_yp);

		dropFuZhuData1.setOnItemSelectedListener(onItemSelectedFZ);
		dropFuZhuData2.setOnItemSelectedListener(onItemSelectedFZ);

		queryData.strBakFlag=gQueryFlag;
		queryData.strUser=BaseActivity.gUser.getUserName();

		dropFuZhuData1.setOnTouchListener(touchListener);
		ActivityHelper.InitDrop(this, R.id.dropFuZhuData1, new ArrayList(), false);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}






	public final OnTouchListener touchListener=new OnTouchListener(){

		public boolean onTouch(View arg0, MotionEvent event)
		{
// 			if (event.getAction() == MotionEvent.ACTION_CANCEL) {
//
// 				return onLoadFZ1();
// 			}
//
// 			return true;
			// 获得触摸的坐标
			int x = (int) event.getX();
			int y = (int) event.getY();
			switch (event.getAction()) {
				// 触摸屏幕时刻
				case MotionEvent.ACTION_DOWN:
					return onLoadFZ1();

				// 触摸并移动时刻
				case MotionEvent.ACTION_MOVE:
					return onLoadFZ1();
				// 终止触摸时刻
				case MotionEvent.ACTION_UP:
					return onLoadFZ1();
			}
			return true;
		}
	};






	public boolean  onLoadFZ1(){
		String strType=getDropText(dropBakType);
		String strDataItem1=txtDataItem1.getText().toString().trim();
		String strDataItem2=txtDataItem2.getText().toString().trim();

		if(strDataItem1.equals("")||strDataItem2.equals(""))
		{
			ActivityHelper.ToastShow(this, getString(R.string.isNUll));
			return true;
		}

		if((!strType.equals(mstrType)|| !strDataItem1.equals(mstrDataItem1)|| !strDataItem2.equals(mstrDataItem2)))
		{
			mstrType=strType;
			mstrDataItem1=strDataItem1;
			mstrDataItem2=strDataItem2;

			queryData.strBakType=strType;
			queryData.strDataItem1=strDataItem1;
			queryData.strDataItem2=strDataItem2;


			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.processor =new GDQueryDownFZProc(GDQueryDownFZProc.FZ1);
			sendParam.szData =new String[]{strType,strDataItem1,strDataItem2,queryData.strUser};
			getDataTrunsfer().request(sendParam);

			return true;
		}

		return false;
	}




	public void onOpenScanBarcode1()
	{
		isDataItem1=true;
		onOpenScanBarcode();
	}

	public void onOpenScanBarcode2()
	{
		isDataItem1=false;
		onOpenScanBarcode();
	}

	final OnItemSelectedListener onItemSelectedFZ = new OnItemSelectedListener(){

		public void onItemSelected(AdapterView<?> arg0, View arg1,
								   int arg2, long arg3) {

			TextView tv = (TextView)arg1;

			if(tv!=null)
			{
				tv.setTextColor(Color.BLACK);    //设置颜色
				tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL);//设置居中

				String strSelectedText=tv.getText().toString();
				String[] szFz=split(strSelectedText,"\\[","\\]");

				if(strSelectedText.indexOf("无数据")>-1)
					return ;

				SendParam sendParam=null;

				if(arg0.getId()==R.id.dropFuZhuData1)
				{
					queryData.strFuZhuData1Id=szFz[1];
					queryData.strFuZhuData1Name=szFz[0];

					sendParam = new SendParam();
					sendParam.parent = GDQuery.this;
					sendParam.szData=new String[]{
							queryData.strBakType,
							queryData.strDataItem1,
							queryData.strDataItem2,
							queryData.strFuZhuData1Id,
							queryData.strFuZhuData1Name,
							queryData.strUser};

					sendParam.processor =new GDQueryDownFZProc(GDQueryDownFZProc.FZ2);
				}
				else if(arg0.getId()==R.id.dropFuZhuData2)
				{
					queryData.strFuZhuData2Id=szFz[1];
					queryData.strFuZhuData2Name=szFz[0];

					sendParam = new SendParam();
					sendParam.parent =GDQuery.this;
					sendParam.szData=new String[]{
							queryData.strBakType,
							queryData.strDataItem1,
							queryData.strDataItem2,
							queryData.strFuZhuData1Id,
							queryData.strFuZhuData1Name,
							queryData.strFuZhuData2Id,
							queryData.strFuZhuData2Name,
							queryData.strUser};
					sendParam.processor =new GDQueryDownFZProc(GDQueryDownFZProc.FZ3);
				}

				if(sendParam!=null)
					getDataTrunsfer().request(sendParam);
			}

		};


		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};

	@Override
	public void onActivityResult(int requestCode,int resultCode,Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode==REQUEST_SCAN_QRCODE_FLAG)
		{//条码扫描完毕返回
			if(resultCode==Activity.RESULT_OK)
			{
				Bundle bundle = data.getExtras();
				String strRst=bundle.getString("result");

				if(isDataItem1)
					txtDataItem1.setText(strRst);
				else
					txtDataItem2.setText(strRst);
			}
		}
	}

	public void onQuery()
	{

		String strType=getDropText(dropFuZhuData3);

		String strDataItem1=txtDataItem1.getText().toString().trim();
		String strDataItem2=txtDataItem2.getText().toString().trim();
		String[] szFz3=getDropArray(dropFuZhuData3);

		if(strType.equals("")||strDataItem1.equals("")||strDataItem2.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		queryData.strFuZhuData3Id=szFz3[1];
		queryData.strFuZhuData3Name=szFz3[0];
		queryData.strDataItem1=strDataItem1;
		queryData.strDataItem2=strDataItem2;

		Intent intent=new Intent(this,GDQueryResult.class);
		startActivity(intent);

	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub


	}

}
