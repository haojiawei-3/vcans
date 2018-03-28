package com.Vcan.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.MlqdUploadcacheProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class DPErrorDetail extends BaseActivity  {
	SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
	String id;
	public static DPErrorDetail dPErrorDetail=null;
	String errorData,strContent;
	TextView Prompt,Prompt1;
	LinearLayout layout,layout1;
	Cursor cursor;
	ArrayList<String> Yid;
	MlqdUploadcacheProcessor mlqdUploadcacheProcessor;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setEnabledChangeTitle(false);

		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.dp_errordetail);
		dPErrorDetail = this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.quxiao,"finish");
		this.<Button>RegOnClickEvent(R.id.qd,"finish");
		this.<Button>RegOnClickEvent(R.id.quxiao1,"finish");
		this.<Button>RegOnClickEvent(R.id.qd1,"finish");
		Prompt=(TextView)findViewById(R.id.Prompt);
		layout=(LinearLayout)findViewById(R.id.Layout);
		Prompt1=(TextView)findViewById(R.id.Prompt1);
		layout1=(LinearLayout)findViewById(R.id.Layout1);
		TextView tvTitle=(TextView)findViewById(R.id.tvActtitle);
		Button button=(Button)findViewById(R.id.qd);
		Button button1=(Button)findViewById(R.id.qd1);
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SimpleDateFormat sDateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				String date = sDateFormat.format(new java.util.Date());
				//id=errorData.substring(errorData.length()-3, errorData.length()) ;
				// String id1=id.replaceAll("'","");
				String id = errorData.substring(errorData.indexOf("'")+1,errorData.lastIndexOf("'"));

				ContentValues values = new ContentValues();
				values.put("Spare2",  BaseActivity.gUser.getUserName()+"\n"+date+"\n"+"进行"+"["+ ActivityHelper.czname+"]操作"+"\n"+errorData);//  3   已阅未批
				values.put("Spare1",  "3");
				db.update("Pendingapproval", values, "TPId=?", new String[]{id});
				Toast.makeText(DPErrorDetail.this, "已归档为已阅未批", 500).show();
				finish();
			}
		});
		button1.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				mlqdUploadcacheProcessor=new MlqdUploadcacheProcessor();
				mlqdUploadcacheProcessor.DisplayMlqdInfo(getYID());
				SendParam sendParam = new SendParam();
				sendParam.bShowTipDlg=false;
				sendParam.parent =DPErrorDetail.this;
				sendParam.bSendEndNotify=true;
				sendParam.processor = mlqdUploadcacheProcessor;
				getDataTrunsfer().beginUploadFile(sendParam);
				finish();

			}
		});

		ImageView tvTip=(ImageView) findViewById(R.id.imgNetStatus);
		tvTip.setVisibility(View.INVISIBLE);

		TextView tvNetStatus=(TextView) findViewById(R.id.tvNetStatus);
		tvNetStatus.setVisibility(View.INVISIBLE);

		Intent intent=this.getIntent();
		errorData=(String)intent.getStringExtra("data");
		strContent=(String)intent.getStringExtra("content");
		TextView tvErrInfo=(TextView) findViewById(R.id.tvErrorDetail);
		String title;
		String bz=ActivityHelper.biaozhi;
		if (bz!=null&&bz.equals("100")) {
			Prompt.setVisibility(View.VISIBLE);
			layout.setVisibility(View.VISIBLE);
			ActivityHelper.biaozhi=null;
		}else if (bz!=null&&bz.equals("200")) {
			Prompt1.setVisibility(View.GONE);  //(View.VISIBLE);
			Prompt1.setText("发生以上错误是否继续上传");
			layout1.setVisibility(View.GONE);  //(View.VISIBLE);
			//ActivityHelper.biaozhi=null;
		}
		if(strContent.equals(""))
		{
			title=getString(R.string.tipInfo);
			tvErrInfo.setText(errorData);
		}
		else
		{
			title=getString(R.string.errorInfo);
			tvErrInfo.setText(strContent+"\r\n\r\n{"+errorData+"}");
		}

		tvTitle.setText(title);
	}

	public ArrayList<String> getYID(){
		Yid=new ArrayList<String>();
		String	 sql="select * from CustomerCollect where  mark ="+"'Y'"+" ";
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			String	 strId = cursor.getString(0);
			Yid.add(strId) ;
		}


		return Yid;
	}

	@Override
	public void finish() {

		ActivityHelper.closeStatusDialog();
		super.finish();
	}



	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
