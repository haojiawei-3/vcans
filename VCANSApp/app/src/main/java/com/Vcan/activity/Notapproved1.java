package com.Vcan.activity;

import java.util.ArrayList;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.model.Information;
import com.vcans.tool.ActivityHelper;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/**
 *
 * @author vcans
 *
 */
public class Notapproved1 extends BaseActivity {
	EditText zt1,mk1,dh1,zt2,nr1,xx,mc1,mc2;
	SQLiteDatabase db;
	Cursor cursor;
	Button qd,qx;
	List<Information> Informationlist=null; 
	Information information;
	TextView zt,fqr,rq,mkmcdh,zt11,gangyao,cwxx,mkmcdh1,jqcz;
	String  glxxid,id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notapproved1);
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.xq,"Query");
		 zt=(TextView)findViewById(R.id.zt);	 
			fqr=(TextView)findViewById(R.id.fqr);	 
			rq=(TextView)findViewById(R.id.sj);	 
			mkmcdh=(TextView)findViewById(R.id.mkmcdh);	 
			mkmcdh1=(TextView)findViewById(R.id.mkmcdh1);
			jqcz=(TextView)findViewById(R.id.jqcz); 
			zt11=(TextView)findViewById(R.id.zt1);	 
			gangyao=(TextView)findViewById(R.id.gangyao);
			cwxx=(TextView)findViewById(R.id.cwxx);
			Intent intent = this.getIntent();		 
			information  = (Information)intent.getSerializableExtra("Informationlist");
			zt.setText(information.strthemer);
			fqr.setText(information.strinitiator);
			rq.setText(information.strdate);
			 mkmcdh.setText(information.strodd);
			 mkmcdh1.setText(information.strmodulename+"  ");	
			 jqcz.setText(information.strSpare4);
			zt11.setText(information.strstateId);
			cwxx.setText(information.strSpare2);
			gangyao.setText(information.strcontent);			
			glxxid=information.strxxId;
			 id=information.strId;
		 // Query();
	}
	 public void Query(){  
			
		    Intent   intent=new Intent(Notapproved1.this,Pendingapproval01.class);
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
