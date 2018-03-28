package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.GDBakModuleDownFZProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;

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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * 备用模块   有5个界面类 分别  GDBakModule GDBakModule1 GDBakModule2 GDBakModule3 GDBakModule4
 * @author vcans
 *
 */
public class GDBakModule3 extends BaseActivity {
	// public static GDBakModule3 bakModule3 = null;
	private EditText txtDataItem3;
	private EditText txtDataItem4;
	private EditText txtDataItem5;
	private Spinner dropFuZhu5;
	private Spinner dropFuZhu6;
	private Spinner dropFuZhu7;
	private String mstrDataItem3="";
	private String mstrDataItem4="";
	private String mstrDataItem5="";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gd_bakmodule3);
		// bakModule3=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.btnLoadFz5,"onLoadFz5");
		this.<Button>RegOnClickEvent(R.id.btnLoadFz6,"btnLoadFz5");
		this.<Button>RegOnClickEvent(R.id.btnLoadFz7,"btnLoadFz5");

		txtDataItem3=(EditText)this.findViewById(R.id.txtDataItem3);
		txtDataItem4=(EditText)this.findViewById(R.id.txtDataItem4);
		txtDataItem5=(EditText)this.findViewById(R.id.txtDataItem5);

		dropFuZhu5=(Spinner)this.findViewById(R.id.dropFuZhuData5);
		dropFuZhu6=(Spinner)this.findViewById(R.id.dropFuZhuData6);
		dropFuZhu7=(Spinner)this.findViewById(R.id.dropFuZhuData7);

		ActivityHelper.InitDrop(this, R.id.dropFuZhuData5, new ArrayList(), false);
		dropFuZhu5.setOnTouchListener(touchListener);
		dropFuZhu5.setOnItemSelectedListener(onItemSelectedFZ);
		dropFuZhu6.setOnItemSelectedListener(onItemSelectedFZ);

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
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
					return;

				SendParam sendParam=null;

				if(arg0.getId()==R.id.dropFuZhuData5)
				{
					GDBakModule.g_BakModuleInfo.strFuZhuData5Id=szFz[1];
					GDBakModule.g_BakModuleInfo.strFuZhuData5Name=szFz[0];

					sendParam = new SendParam();
					sendParam.parent = GDBakModule3.this;
					sendParam.szData=new String[]{
							GDBakModule.g_BakModuleInfo.strBakType,
							GDBakModule.g_BakModuleInfo.strDataItem1,
							GDBakModule.g_BakModuleInfo.strDataItem2,
							GDBakModule.g_BakModuleInfo.strDate,
							GDBakModule.g_BakModuleInfo.strFuZhuData1Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData1Name,
							GDBakModule.g_BakModuleInfo.strFuZhuData2Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData2Name,
							GDBakModule.g_BakModuleInfo.strFuZhuData3Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData3Name,
							GDBakModule.g_BakModuleInfo.strFuZhuData4Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData4Name,
							GDBakModule.g_BakModuleInfo.goods.strGoodsId,
							GDBakModule.g_BakModuleInfo.goods.strGoodsDescribe,
							GDBakModule.g_BakModuleInfo.goods.strStoreDescribe,
							GDBakModule.g_BakModuleInfo.goods.strStoreFlag,
							GDBakModule.g_BakModuleInfo.goods.strPiShu,
							GDBakModule.g_BakModuleInfo.goods.strNum,
							GDBakModule.g_BakModuleInfo.goods.strRemark1,
							GDBakModule.g_BakModuleInfo.goods.strRemark2,
							GDBakModule.g_BakModuleInfo.goods.strRemark3,
							GDBakModule.g_BakModuleInfo.goods.strRemark4,
							GDBakModule.g_BakModuleInfo.goods.strRemark5,
							GDBakModule.g_BakModuleInfo.strDelPiShu,
							GDBakModule.g_BakModuleInfo.strDelNum,
							GDBakModule.g_BakModuleInfo.strDataItem3,
							GDBakModule.g_BakModuleInfo.strDataItem4,
							GDBakModule.g_BakModuleInfo.strDataItem5,
							GDBakModule.g_BakModuleInfo.strFuZhuData5Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData5Name,
							GDBakModule.g_BakModuleInfo.strUser};
					sendParam.processor =new GDBakModuleDownFZProcessor(GDBakModuleDownFZProcessor.FZ6);

				}
				else if(arg0.getId()==R.id.dropFuZhuData6)
				{
					GDBakModule.g_BakModuleInfo.strFuZhuData6Id=szFz[1];
					GDBakModule.g_BakModuleInfo.strFuZhuData6Name=szFz[0];

					sendParam = new SendParam();
					sendParam.parent =GDBakModule3.this;
					sendParam.szData=new String[]{
							GDBakModule.g_BakModuleInfo.strBakType,
							GDBakModule.g_BakModuleInfo.strDataItem1,
							GDBakModule.g_BakModuleInfo.strDataItem2,
							GDBakModule.g_BakModuleInfo.strDate,
							GDBakModule.g_BakModuleInfo.strFuZhuData1Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData1Name,
							GDBakModule.g_BakModuleInfo.strFuZhuData2Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData2Name,
							GDBakModule.g_BakModuleInfo.strFuZhuData3Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData3Name,
							GDBakModule.g_BakModuleInfo.strFuZhuData4Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData4Name,
							GDBakModule.g_BakModuleInfo.goods.strGoodsId,
							GDBakModule.g_BakModuleInfo.goods.strGoodsDescribe,
							GDBakModule.g_BakModuleInfo.goods.strStoreDescribe,
							GDBakModule.g_BakModuleInfo.goods.strStoreFlag,
							GDBakModule.g_BakModuleInfo.goods.strPiShu,
							GDBakModule.g_BakModuleInfo.goods.strNum,
							GDBakModule.g_BakModuleInfo.goods.strRemark1,
							GDBakModule.g_BakModuleInfo.goods.strRemark2,
							GDBakModule.g_BakModuleInfo.goods.strRemark3,
							GDBakModule.g_BakModuleInfo.goods.strRemark4,
							GDBakModule.g_BakModuleInfo.goods.strRemark5,
							GDBakModule.g_BakModuleInfo.strDelPiShu,
							GDBakModule.g_BakModuleInfo.strDelNum,
							GDBakModule.g_BakModuleInfo.strDataItem3,
							GDBakModule.g_BakModuleInfo.strDataItem4,
							GDBakModule.g_BakModuleInfo.strDataItem5,
							GDBakModule.g_BakModuleInfo.strFuZhuData5Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData5Name,
							GDBakModule.g_BakModuleInfo.strFuZhuData6Id,
							GDBakModule.g_BakModuleInfo.strFuZhuData6Name,
							GDBakModule.g_BakModuleInfo.strUser};
					sendParam.processor =new GDBakModuleDownFZProcessor(GDBakModuleDownFZProcessor.FZ7);
				}

				if(sendParam!=null)
					getDataTrunsfer().request(sendParam);
			}

		};


		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};

	public final OnTouchListener touchListener=new OnTouchListener(){

		public boolean onTouch(View arg0, MotionEvent event)
		{
			if (event.getAction() == MotionEvent.ACTION_DOWN) {

				return onLoadFz5();
			}

			return false;
		}
	};

	public boolean onLoadFz5()
	{
		String strDataItem3=txtDataItem3.getText().toString().trim();
		String strDataItem4=txtDataItem4.getText().toString().trim();
		String strDataItem5=txtDataItem5.getText().toString().trim();

		if(strDataItem3.equals("")||strDataItem4.equals("")||strDataItem5.equals(""))
		{
			ActivityHelper.ToastShow(this, getString(R.string.isNUll));
			return true;
		}

		if(!strDataItem3.equals(mstrDataItem3)||!strDataItem4.equals(mstrDataItem4)||!strDataItem5.equals(mstrDataItem5))
		{
			mstrDataItem3=strDataItem3;
			mstrDataItem4=strDataItem4;
			mstrDataItem5=strDataItem5;

			GDBakModule.g_BakModuleInfo.strDataItem3=strDataItem3;
			GDBakModule.g_BakModuleInfo.strDataItem4=strDataItem4;
			GDBakModule.g_BakModuleInfo.strDataItem5=strDataItem5;

			SendParam sendParam = new SendParam();
			sendParam.parent = GDBakModule3.this;
			sendParam.szData=new String[]{
					GDBakModule.g_BakModuleInfo.strBakType,
					GDBakModule.g_BakModuleInfo.strDataItem1,
					GDBakModule.g_BakModuleInfo.strDataItem2,
					GDBakModule.g_BakModuleInfo.strDate,
					GDBakModule.g_BakModuleInfo.strFuZhuData1Id,
					GDBakModule.g_BakModuleInfo.strFuZhuData1Name,
					GDBakModule.g_BakModuleInfo.strFuZhuData2Id,
					GDBakModule.g_BakModuleInfo.strFuZhuData2Name,
					GDBakModule.g_BakModuleInfo.strFuZhuData3Id,
					GDBakModule.g_BakModuleInfo.strFuZhuData3Name,
					GDBakModule.g_BakModuleInfo.strFuZhuData4Id,
					GDBakModule.g_BakModuleInfo.strFuZhuData4Name,
					GDBakModule.g_BakModuleInfo.goods.strGoodsId,
					GDBakModule.g_BakModuleInfo.goods.strGoodsDescribe,
					GDBakModule.g_BakModuleInfo.goods.strStoreDescribe,
					GDBakModule.g_BakModuleInfo.goods.strStoreFlag,
					GDBakModule.g_BakModuleInfo.goods.strPiShu,
					GDBakModule.g_BakModuleInfo.goods.strNum,
					GDBakModule.g_BakModuleInfo.goods.strRemark1,
					GDBakModule.g_BakModuleInfo.goods.strRemark2,
					GDBakModule.g_BakModuleInfo.goods.strRemark3,
					GDBakModule.g_BakModuleInfo.goods.strRemark4,
					GDBakModule.g_BakModuleInfo.goods.strRemark5,
					GDBakModule.g_BakModuleInfo.strDelPiShu,
					GDBakModule.g_BakModuleInfo.strDelNum,
					GDBakModule.g_BakModuleInfo.strDataItem3,
					GDBakModule.g_BakModuleInfo.strDataItem4,
					GDBakModule.g_BakModuleInfo.strDataItem5,
					GDBakModule.g_BakModuleInfo.strUser};
			sendParam.processor =new GDBakModuleDownFZProcessor(GDBakModuleDownFZProcessor.FZ5);
			getDataTrunsfer().request(sendParam);

			return true;
		}
		else
			return false;
	}


	public void onLoadFz6()
	{
		String strDataItem3=txtDataItem3.getText().toString().trim();
		String strDataItem4=txtDataItem4.getText().toString().trim();
		String strDataItem5=txtDataItem5.getText().toString().trim();

		GDBakModule.g_BakModuleInfo.strDataItem3=strDataItem3;
		GDBakModule.g_BakModuleInfo.strDataItem4=strDataItem4;
		GDBakModule.g_BakModuleInfo.strDataItem5=strDataItem5;
	}

	public void onLoadFz7()
	{

	}

	public void onNext()
	{
		onLoadFz6();
		String[] szFz7=getDropArray(dropFuZhu7);
		GDBakModule.g_BakModuleInfo.strFuZhuData7Id=szFz7[1];
		GDBakModule.g_BakModuleInfo.strFuZhuData7Name=szFz7[0];

		Intent intent=new Intent(this,GDBakModule4.class);
		startActivity(intent);
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		// Toast.makeText(GDBakModule3.this, "G3", 500).show();
		super.onRestart();
	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
