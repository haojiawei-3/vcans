package com.Vcan.activity;

import com.Vcan.activity.R;

import cn.sharp.android.ncr.DisplayRecResult;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class XiangQingActivity extends Activity {
	Intent intent;
	String data,datas,name;
    EditText contact;
    public static String data1,name1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_xiang_qing);
		 contact=(EditText)findViewById(R.id.contact);
		 ImageButton imgBtnSave=(ImageButton)findViewById(R.id.imgBtnSave);
		ImageButton button=(ImageButton)findViewById(R.id.btnBack);
		TextView textView=(TextView)findViewById(R.id.btnSave);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				amend();
			}
		});
		textView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				amend();
			}
		});
		imgBtnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				amend();		 
			}
		});
		  intent=this.getIntent();
		  data = (String)intent.getSerializableExtra("data");
		  name = (String)intent.getSerializableExtra("name");
		  contact.setText(data);
	}
     public void amend(){
//    	 datas=contact.getText().toString();
//		 SharedPreferences SharedPreferences= getSharedPreferences("addres", Activity.MODE_PRIVATE); 
//		 SharedPreferences.Editor editor= SharedPreferences.edit(); 
//		 editor.putString("data", datas); 
//		 editor.putString("name", name);
//		 editor.commit();
    	 XiangQingActivity. data1 =contact.getText().toString();
    	 XiangQingActivity. name1=name;
		 finish();

     }
}
