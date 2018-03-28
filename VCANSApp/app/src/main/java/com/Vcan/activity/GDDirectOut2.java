package com.Vcan.activity;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.GDPublicFuzuDownProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * 直接出货   有4个界面类 分别  GDDirectOut GDDirectOut1 GDDirectOut2 GDDirectOut3
 * @author vcans
 *
 */
public class GDDirectOut2 extends BaseActivity {
	// public static GDDirectOut2 directOut2 = null;
	private EditText txtDataItem2;
	private EditText txtDataItem3;
	private Spinner  dropFZ4;
	private Spinner  dropFZ5;

	public final static int nFuZhuDownDone3=3;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gd_directout2);
		// directOut2=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");

		txtDataItem2=(EditText)findViewById(R.id.txtDataItem2);
		txtDataItem3=(EditText)findViewById(R.id.txtDataItem3);
		dropFZ4=(Spinner)findViewById(R.id.dropFuZhuData4);
		dropFZ5=(Spinner)findViewById(R.id.dropFuZhuData5);

		SendParam sendParam = new SendParam();
		sendParam.parent = GDDirectOut2.this;
		sendParam.szData=new String[]{GDPublicFuzuDownProcessor.FZ4};
		sendParam.processor = new GDPublicFuzuDownProcessor();
		getDataTrunsfer().request(sendParam);

	}

//	 @Override
//	protected void onResume() {
//		// TODO Auto-generated method stub
//		super.onResume();
//
//	}


	public void onNext()
	{
		String strDataItem2=txtDataItem2.getText().toString().trim();
		String strDataItem3=txtDataItem3.getText().toString().trim();
		String strFZ4=getDropText(dropFZ4);
		String strFZ5=getDropText(dropFZ5);

		String[] szFZ4=split(strFZ4,"\\[","\\]");
		String[] szFZ5=split(strFZ5,"\\[","\\]");

		if(strDataItem2.equals("")||strDataItem3.equals("")||strFZ4.equals("")||strFZ5.equals(""))
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
			return ;
		}

		GDDirectOut.g_DirectOutInfo.strDataItem2=strDataItem2;
		GDDirectOut.g_DirectOutInfo.strDataItem3=strDataItem3;
		GDDirectOut.g_DirectOutInfo.strFuZhuData4Id=szFZ4[1];
		GDDirectOut.g_DirectOutInfo.strFuZhuData5Id=szFZ5[1];
		GDDirectOut.g_DirectOutInfo.strFuZhuData4Name=szFZ4[0];
		GDDirectOut.g_DirectOutInfo.strFuZhuData5Name=szFZ5[0];

		Intent intent=new Intent(this,GDDirectOut3.class);
		startActivity(intent);

	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

		if(msgId==nFuZhuDownDone3)
		{
			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.szData=new String[]{GDPublicFuzuDownProcessor.FZ5};
			sendParam.processor = new GDPublicFuzuDownProcessor();
			getDataTrunsfer().request(sendParam);
		}
	}

}
