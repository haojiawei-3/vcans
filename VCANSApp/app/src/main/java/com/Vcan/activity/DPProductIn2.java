package com.Vcan.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.PlProcessor;

/**
 * 成品进仓   有4个界面类 分别  DPProductIn DPTouPei1（共用） DPProductIn2 DPProductIn3
 * @author vcans
 *
 */
public class DPProductIn2 extends BaseActivity {
	// public static DPProductIn2 dpProductIn2 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_productin2);
		// dpProductIn2=this;
		//this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		ImageButton btnBack= (ImageButton) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		ActivityHelper.InitDrop(this, R.id.dropCheckStatus, ActivityHelper.lstCheckStatus, true);
	}

	public void onNext()
	{
		Spinner spFabricQuality=(Spinner)this.findViewById(R.id.dropFabricQuality);
		Spinner spCheckStatus=(Spinner)this.findViewById(R.id.dropCheckStatus);

		EditText txtKGM=(EditText)this.findViewById(R.id.txtKGM);
		EditText txtPiCi=(EditText)this.findViewById(R.id.txtPiCi);

		String strPiCi=txtPiCi.getText().toString().trim();
		String strFabricQuality=spFabricQuality.getSelectedItem().toString();
		String strKGM=txtKGM.getText().toString().trim();

		String strCheckStatus=spCheckStatus.getSelectedItem().toString().trim();
		String[] szCheckStatus=strCheckStatus.split("\\[");


		if(strPiCi.equals("")||strKGM.equals("")||szCheckStatus.length<2||strFabricQuality.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",this.getString(R.string.isNUll));
			return ;
		}


		ActivityHelper.gToupei.strCheckStatusName=szCheckStatus[0];
		ActivityHelper.gToupei.strCheckStatusId=szCheckStatus[1].substring(0,szCheckStatus[1].length()-1);
		ActivityHelper.gToupei.strKGToM=strKGM;
		ActivityHelper.gToupei.strPiCi=strPiCi;
		ActivityHelper.gToupei.strFabricQuality=strFabricQuality;

		Intent intent=new Intent(this,DPProductIn2_1.class);
		startActivity(intent);
	}


	@Override
	public void processMessage(int msgId, String msg)
	{
	}
}
