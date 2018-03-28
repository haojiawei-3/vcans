package com.Vcan.activity;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.model.GDDirectOutInfo;
import com.vcans.tool.ActivityHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
/**
 * 直接出货   有4个界面类 分别  GDDirectOut GDDirectOut1 GDDirectOut2 GDDirectOut3
 * @author vcans
 *
 */
public class GDDirectOut extends BaseActivity {
	// public static GDDirectOut directOut = null;
	public static GDDirectOutInfo g_DirectOutInfo=new GDDirectOutInfo();

	private EditText txtRZPlan;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gd_directout);
		// directOut=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"onOpenScanBarcode");

		txtRZPlan=(EditText)this.findViewById(R.id.txtRZPlanId);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}


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

				txtRZPlan.setText(strRst);
			}
		}
		else
		{}
	}


	public void onNext()
	{
		EditText txtRZPlanId=(EditText)findViewById(R.id.txtRZPlanId);
		EditText txtDataItem1=(EditText)findViewById(R.id.txtDataItem1);

		String strRZPlanId=txtRZPlanId.getText().toString().trim();
		String strDataItem1=txtDataItem1.getText().toString().trim();

		if(strRZPlanId.equals("")||strDataItem1.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		g_DirectOutInfo.strRZPlanId=strRZPlanId;
		g_DirectOutInfo.strDataItem1=strDataItem1;

		Intent intent=new Intent(this,GDDirectOut1.class);
		startActivity(intent);
	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub


	}

}
