package com.Vcan.activity;

import java.util.ArrayList;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.MlqdProcessor3;
import com.vcans.Processor.MlqdProcessor4;
import com.vcans.model.Mlqd;
import com.vcans.model.Mlqd2;
import com.vcans.model.SendParam;
import com.vcans.tool.SildingFinishLayout;
import com.vcans.tool.SildingFinishLayout.OnSildingFinishListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
/**
 *   清单模块一   有6个界面类
 * @author vcans
 *
 */
public class MlqdActivity21 extends BaseActivity {
	public static MlqdActivity21 mlqdActivity21=null;
	String code,msone,mstow,msthree,pm,ph,gangyao;
	TextView bcode,bmsone,bmstow,bmsthree,bgangyao,pmph,TextView1,TextView2,TextView3;
	ArrayList<String> name=new ArrayList<String>();
	ScrollView scrollView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mlqd_activity21);
		mlqdActivity21=this;

		this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
		pmph=(TextView)findViewById(R.id.pmph);
		bmsone=(TextView)findViewById(R.id.msone);
		bmstow=(TextView)findViewById(R.id.mstow);
		TextView1=(TextView)findViewById(R.id.TextView1);
		TextView2=(TextView)findViewById(R.id.TextView2);
		TextView3=(TextView)findViewById(R.id.TextView3);
		bmsthree=(TextView)findViewById(R.id.msthree);
		bgangyao=(TextView)findViewById(R.id.gangyao);
		TextView textView=(TextView)findViewById(R.id.tvActtitle);
		Intent intent = this.getIntent();
		scrollView=(ScrollView)findViewById(R.id.ScrollView);
		name = getIntent().getStringArrayListExtra("name");
		code = (String)intent.getSerializableExtra("code");
		pm   =   (String)intent.getSerializableExtra("pm");
		ph   =   (String)intent.getSerializableExtra("ph");
		msone= (String)intent.getSerializableExtra("msone");
		mstow= (String)intent.getSerializableExtra("mstow");
		msthree= (String)intent.getSerializableExtra("msthree");
		gangyao= (String)intent.getSerializableExtra("gangyao");
		pmph.setText(pm+"/"+ph);
		bmsone.setText(   msone);
		bmstow.setText(   mstow);
		bmsthree.setText(   msthree);
		TextView1.setText(name.get(0)+":");
		TextView2.setText(name.get(1)+":");
		TextView3.setText(name.get(2)+":");
		if (!gangyao.equals("null")) {
			bgangyao.setText(gangyao);
		}else {
			xiazai();
		}

		textView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				xiazai();
			}
		});

		SildingFinishLayout1();
	}
	public void SildingFinishLayout1(){
		SildingFinishLayout mSildingFinishLayout = (SildingFinishLayout) findViewById(R.id.sildingFinishLayout);
		mSildingFinishLayout.setOnSildingFinishListener(new OnSildingFinishListener() {

			@Override
			public void onSildingFinish() {
				finish();
			}
		});

		mSildingFinishLayout.setTouchView(scrollView);
		//return activity;
	}
	private void xiazai() {
		// TODO Auto-generated method stub
		SendParam sendParam = new SendParam();
		sendParam.tip=getString(R.string.ypxq);
		sendParam.parent = MlqdActivity21.this;
		sendParam.szData=new String[]{code};
		sendParam.processor = new MlqdProcessor4();
		getDataTrunsfer().request(sendParam);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_mlqd_activity21, menu);
		return true;
	}




	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub
		if (msgId==200) {
			bgangyao.setText(msg);
		}
	}

}
