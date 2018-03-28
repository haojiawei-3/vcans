package com.Vcan.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

/**
 * 成品进仓   有4个界面类 分别  DPProductIn DPTouPei1（共用） DPProductIn2 DPProductIn3
 * @author vcans
 *
 */
public class DPProductIn2_1 extends BaseActivity {
	//public static DPProductIn2_1 dpProductIn2_1 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_productin2_1);
		// dpProductIn2_1=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");

		InitDrop();

	}

	public void InitDrop()
	{
		ActivityHelper.InitDrop(this, R.id.dropColor, ActivityHelper.lstFlowerAndColor, true);
		ActivityHelper.InitDrop(this, R.id.dropGongYi2_1, ActivityHelper.lstGongyi, true);
		ActivityHelper.InitDrop(this, R.id.dropGongYi2_2, ActivityHelper.lstGongyi, true);
		ActivityHelper.InitDrop(this, R.id.dropGongYi2_3, ActivityHelper.lstGongyi, true);
	}

	public void onNext()
	{
		Spinner spGongyi2_1=(Spinner)this.findViewById(R.id.dropGongYi2_1);
		Spinner spGongyi2_2=(Spinner)this.findViewById(R.id.dropGongYi2_2);
		Spinner spGongyi2_3=(Spinner)this.findViewById(R.id.dropGongYi2_3);
		Spinner spColor=(Spinner)this.findViewById(R.id.dropColor);

		String strGongyi2_1=spGongyi2_1.getSelectedItem().toString();
		String strGongyi2_2=spGongyi2_2.getSelectedItem().toString();
		String strGongyi2_3=spGongyi2_3.getSelectedItem().toString();

		String[] szGongyi2_1=strGongyi2_1.split("\\[");
		String[] szGongyi2_2=strGongyi2_2.split("\\[");
		String[] szGongyi2_3=strGongyi2_3.split("\\[");

		String strColor=spColor.getSelectedItem().toString().trim();
		String[] szsColor=strColor.split("\\|");

		if(strGongyi2_1.equals("")||strGongyi2_2.equals("")||strGongyi2_3.equals("")||strColor.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",this.getString(R.string.isNUll));
			return ;
		}

		ActivityHelper.gToupei.strFlowerType=szsColor[0];

		if(szsColor.length>1)
			ActivityHelper.gToupei.strColor=szsColor[1];

		ActivityHelper.gToupei.strGongyiName2_1=szGongyi2_1[0];
		ActivityHelper.gToupei.strGongyiId2_1=szGongyi2_1[1].substring(0,szGongyi2_1[1].length()-1);

		ActivityHelper.gToupei.strGongyiName2_2=szGongyi2_2[0];
		ActivityHelper.gToupei.strGongyiId2_2=szGongyi2_2[1].substring(0,szGongyi2_2[1].length()-1);

		ActivityHelper.gToupei.strGongyiName2_3=szGongyi2_3[0];
		ActivityHelper.gToupei.strGongyiId2_3=szGongyi2_3[1].substring(0,szGongyi2_3[1].length()-1);

		Intent intent=new Intent(this,DPProductIn3.class);
		startActivity(intent);
	}


	@Override
	public void processMessage(int msgId, String msg)
	{
	}
}
