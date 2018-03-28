package com.Vcan.activity;

import java.io.File;
import java.text.SimpleDateFormat;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.model.GDDirectOutInfo;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.CameraTool;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TableLayout.LayoutParams;

/**
 * 备用模块   有5个界面类 分别  GDBakModule GDBakModule1 GDBakModule2 GDBakModule3 GDBakModule4
 * @author vcans
 *
 */
public class GDBakModule2 extends BaseActivity {
	// public static GDBakModule2 bakModule2 = null;
	private EditText txtDelNum1;
	private EditText txtDelNum2;
	String strDelNum1,strDelNum2;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gd_bakmodule2);
		// bakModule2=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");

		txtDelNum1=(EditText)findViewById(R.id.txtDelNum);
		txtDelNum2=(EditText)findViewById(R.id.txtDelPiShu);

	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		// Toast.makeText(GDBakModule2.this, "G22", 500).show();
		//if (txtDelNum1.getText().toString().trim().equals("")) {
		finish();
		//} else {

		//}

		super.onRestart();
	}

	public void onNext()
	{
		strDelNum1=txtDelNum1.getText().toString().trim();
		strDelNum2=txtDelNum2.getText().toString().trim();

		if(strDelNum1.equals("")||strDelNum2.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		GDBakModule.g_BakModuleInfo.strDelNum=strDelNum1;
		GDBakModule.g_BakModuleInfo.strDelPiShu=strDelNum2;

		Intent intent=new Intent(GDBakModule2.this,GDBakModule3.class);
		startActivity(intent);
	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub


	}

}
