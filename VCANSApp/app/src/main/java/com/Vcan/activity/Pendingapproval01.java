package com.Vcan.activity;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.PendingapprovalProcessor4;
import com.vcans.Processor.YPDownYpInfoProcessor;
import com.vcans.model.Information;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Pendingapproval01 extends BaseActivity {
	PendingapprovalProcessor4 downGoods;
	String glxxid,id;
	Information information;
	TextView mkmc,dh,dqzt,fqr,zt,gangyao,sj,tvTitle;
	ImageView imgsrc;
	Cursor cursor;

	String strspare3,strspare5;
	SQLiteDatabase  db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
	private Bitmap[] bitmap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pendingapproval01);
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		tvTitle = (TextView) findViewById(R.id.tvActtitle);
		this.setTitle(getString(R.string.image));

		//设置TOP颜色
		LinearLayout layTitle= (LinearLayout)findViewById(R.id.include01);
		layTitle.setBackgroundResource(ActivityHelper.globalSysParam.sysSkin.selectedColor);
		mkmc=(TextView)findViewById(R.id.mkmc);
		dh=(TextView)findViewById(R.id.dh);
		dqzt=(TextView)findViewById(R.id.dqzt);
		fqr=(TextView)findViewById(R.id.fqr);
		zt=(TextView)findViewById(R.id.zt);
		gangyao=(TextView)findViewById(R.id.gangyao);
		sj=(TextView)findViewById(R.id.sj);
		imgsrc=(ImageView)findViewById(R.id.imgsrc);
		imgsrc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if (ActivityHelper.filePaths==null) {
					ActivityHelper.ToastShow(Pendingapproval01.this, "没有图片");
				}else {
					Intent intent=new Intent(Pendingapproval01.this,Pendingapproval001.class);
					ActivityHelper.filePaths=strspare5;
					intent.putExtra("tp", strspare5);
					startActivity(intent);
				}

			}
		});
		Intent intent = this.getIntent();
		glxxid= (String)intent.getSerializableExtra("glxxid");
		id= (String)intent.getSerializableExtra("id");
		information  = (Information)intent.getSerializableExtra("Informationlist");
		ActivityHelper.information.strxxId=glxxid;

		mkmc.setText(information.strmodulename);
		dh.setText(information.strodd);
		dqzt.setText(information.strstateId);
		fqr.setText(information.strinitiator);
		zt.setText(information.strthemer);
		// gangyao.setText(information.strcontent);
		sj.setText(information.strdate);
		downGoods =new PendingapprovalProcessor4();


		ContentValues values = new ContentValues();
		cursor=db.rawQuery("select * from Pendingapproval  where TPId = "+id+"  ", new String[]{});
		while (cursor.moveToNext()) {
			strspare3 = cursor.getString(16);
			strspare5 = cursor.getString(18);
		}
		if (strspare3.equals("null")&&strspare5.equals("null")) {
			new Handler().postDelayed(new Runnable() {
				public void run() {
					SendParam sendParam = new SendParam();
					sendParam.parent =Pendingapproval01.this;
					sendParam.processor =  downGoods;
					getDataTrunsfer().request(sendParam);
				}
			},200 );
		}else {
			tupian();
		}


	}

	public void tupian() {
		// TODO Auto-generated method stub
		TextView  gangyao=(TextView)findViewById(R.id.gangyao);
		gangyao.setText(strspare3);
		if (strspare5.equals("null")) {
			ImageView imgsrc=(ImageView)findViewById(R.id.imgsrc);
			imgsrc.setVisibility(View.GONE);
		} else {
			ImageView imgsrc=(ImageView)findViewById(R.id.imgsrc);
//             BitmapFactory.Options options = new BitmapFactory.Options();
//             options.inSampleSize = 2;
//             Bitmap bm = BitmapFactory.decodeFile(strspare5);
			//bitmap = YPDownYpInfoProcessor.getBitmapsByFilepaths(strspare5);
			ActivityHelper.filePaths=strspare5;
			ActivityHelper.Bitmaps=bitmap;
			imgsrc.setImageBitmap(ActivityHelper.BitmapFactory(strspare5, 2));
		}

	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		//ActivityHelper.Bitmaps=null;
		super.onRestart();
	}



	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		ActivityHelper.Bitmaps=null;
		ActivityHelper.filePaths=null;
		super.onDestroy();
	}



	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
