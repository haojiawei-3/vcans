package com.Vcan.activity;

import java.util.Arrays;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

/**
 * 坯布进仓   有3个界面类 分别  DPPeibuIn DPPeibuIn1 DPPeibuIn2
 * @author vcans
 *
 */
public class DPPeibuIn1 extends BaseActivity {
	//public static DPPeibuIn1 dpPeibuIn1 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_peibuin1);
		// dpPeibuIn1=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");

		InitDropPackAndFabricList();
	}


	public void InitDropPackAndFabricList()
	{
		String[] szData={getString(R.string.quannengPei),
				getString(R.string.rspei),
				getString(R.string.sezhiPei),
				getString(R.string.yinhuaPei),
				getString(R.string.banChenPin),
				getString(R.string.product)};

		ActivityHelper.InitDrop(this, R.id.dropFabricQuality,Arrays.asList(szData), true);

		String[] szData2={getString(R.string.juanZhuang),
				getString(R.string.piZhuang),
				getString(R.string.baoZhuang)};

		ActivityHelper.InitDrop(this, R.id.dropPackQuality,Arrays.asList(szData2), true);
	}

	public void onNext()
	{
		Spinner spFabricQuality=(Spinner)this.findViewById(R.id.dropFabricQuality);
		Spinner spPack=(Spinner)this.findViewById(R.id.dropPackQuality);
		EditText txtMakou=(EditText)this.findViewById(R.id.txtMaKou);
		EditText txtRemark=(EditText)this.findViewById(R.id.txtRemark);


		String strFabricQuality=spFabricQuality.getSelectedItem().toString();
		String strPackQuality=spPack.getSelectedItem().toString();
		String strMakou=txtMakou.getText().toString().trim();
		String strRemark=txtRemark.getText().toString().trim();

		if(strMakou.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		ActivityHelper.gToupei.strRemark=strRemark;
		ActivityHelper.gToupei.strMaKou=strMakou;
		ActivityHelper.gToupei.strFabricQuality=strFabricQuality;
		ActivityHelper.gToupei.strPackQuality=strPackQuality;
		System.out.println(ActivityHelper.gToupei.strRemark+"123456789");

		Intent intent=new Intent(this,DPPeibuIn2.class);
		startActivity(intent);
	}


	@Override
	public void processMessage(int msgId, String msg)
	{
	}
}
