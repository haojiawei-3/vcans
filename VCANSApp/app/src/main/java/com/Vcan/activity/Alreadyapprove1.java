package com.Vcan.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.GDBakPublicFuzuDownProc;
import com.vcans.Processor.UesrUploadProcessor;
import com.vcans.model.Information;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/**
 * 我已审批    Alreadyapprove   Alreadyapprove1
 * @author vcans
 *
 */
public class Alreadyapprove1 extends BaseActivity {
	TextView zt,fqr,rq,mkmcdh,zt11,gangyao,wc,mkmcdh1,jqcz;
	Button xxcz;
	SQLiteDatabase db;
	Cursor cursor;
	Button qd,qc;
	List<Information> Informationlist=null;
	Information information;
	String id,glxxid,shuzuid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alreadyapprove1);
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.xq,"gengduo");
		zt=(TextView)findViewById(R.id.zt);
		fqr=(TextView)findViewById(R.id.fqr);
		rq=(TextView)findViewById(R.id.sj);
		mkmcdh=(TextView)findViewById(R.id.mkmcdh);
		mkmcdh1=(TextView)findViewById(R.id.mkmcdh1);
		jqcz=(TextView)findViewById(R.id.jqcz);
		zt11=(TextView)findViewById(R.id.zt1);
		gangyao=(TextView)findViewById(R.id.gangyao);
		wc=(TextView)findViewById(R.id.wc);
		db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);
		Intent intent = this.getIntent();
		information  = (Information)intent.getSerializableExtra("Informationlist");
		shuzuid  = (String)intent.getSerializableExtra("shuzuid");
		if (information!=null) {
			zt.setText(information.strthemer);
			fqr.setText(information.strinitiator);
			rq.setText(information.strdate);
			mkmcdh.setText(information.strodd);
			mkmcdh1.setText(information.strmodulename+"  ");
			jqcz.setText(information.strSpare4);
			zt11.setText(information.strstateId);
			gangyao.setText(information.strcontent);
			wc.setText(information.strSpare2);
			glxxid=information.strxxId;
			id=information.strId;
		}else {
			String sql="select * from Pendingapproval where TPId ="+shuzuid+" and  Type = 1 and Spare1 = 2   order by TPId  desc";
			Log.e("TAG", sql);
			cursor = db.rawQuery(sql, new String[]{});
			while (cursor.moveToNext()) {
				information = new Information(cursor.getString(0),
						cursor.getString(1),
						cursor.getString(2),
						cursor.getString(3),
						cursor.getString(4),
						cursor.getString(5),
						cursor.getString(6),
						cursor.getString(7),
						cursor.getString(8),
						cursor.getString(9),
						cursor.getString(10),
						cursor.getString(11),
						cursor.getString(12),
						cursor.getString(13),
						cursor.getString(14),
						cursor.getString(15),
						cursor.getString(16),
						cursor.getString(17),
						cursor.getString(18));
			}
			zt.setText(information.strthemer);
			fqr.setText(information.strinitiator);
			rq.setText(information.strdate);
			mkmcdh.setText(information.strodd);
			mkmcdh1.setText(information.strmodulename+"  ");
			jqcz.setText(information.strSpare4);
			zt11.setText(information.strstateId);
			gangyao.setText(information.strcontent);
			wc.setText(information.strSpare2);
			glxxid=information.strxxId;
			id=information.strId;
		}



	}
	public void gengduo()
	{

		Intent   intent=new Intent(Alreadyapprove1.this,Pendingapproval01.class);
		intent.putExtra("glxxid", glxxid);
		intent.putExtra("id", id);
		intent.putExtra("Informationlist", information);
		startActivity(intent);
	}
	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
