package com.Vcan.activity;

import java.util.ArrayList;
import java.util.List;

import cn.sharp.android.ncr.DisplayRecResult;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.MpsbUploadProcessor;
import com.vcans.model.Mpsbinfo;
import com.vcans.tool.ActivityHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

public class MpsbxqActivity extends  BaseActivity {
	Intent intent;
	MpsbUploadProcessor mpsbUploadProcessor=null;
	private EditText  company, linkname ,position ,phone1, phone2, fax ,address , www ,email ,note;
	private String  scompany, slinkname ,sposition ,sphone1, sphone2, sfax ,saddress , swww ,semail ,snote,sImgPath,strcompany,id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mpsbxq);
		
		this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");	
		 company=(EditText)findViewById(R.id.company);
		 linkname =(EditText)findViewById(R.id.contact);
		 position =(EditText)findViewById(R.id.position);
		 phone1=(EditText)findViewById(R.id.phone1);
		 phone2 =(EditText)findViewById(R.id.phone2);
		fax =(EditText)findViewById(R.id.fax);
		 address=(EditText)findViewById(R.id.address);
		 www =(EditText)findViewById(R.id.www);
		 email=(EditText)findViewById(R.id.email);
		 note=(EditText)findViewById(R.id.note);
		 ImageButton imgBtnOk = (ImageButton)findViewById(R.id.imgBtnOk);
		 imgBtnOk.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					    loading();
					    mpsbUploadProcessor.DeleteMpsdInfo(id);
//						Intent intent=new Intent(MpsbxqActivity.this,MpsdActivity.class);
//						startActivity(intent);
						finish();
					
				}

			});
		  intent = this.getIntent();
		  id= (String)intent.getSerializableExtra("id");
		  mpsbUploadProcessor=new MpsbUploadProcessor(id);
		  scompany= (String)intent.getSerializableExtra("company");
		  slinkname= (String)intent.getSerializableExtra("linkname");
		  sposition= (String)intent.getSerializableExtra("position");
		  sphone1= (String)intent.getSerializableExtra("phone1");
		  sphone2= (String)intent.getSerializableExtra("phone2");
		  sfax= (String)intent.getSerializableExtra("fax");
		  saddress= (String)intent.getSerializableExtra("address");
		  swww= (String)intent.getSerializableExtra("www");
		  semail= (String)intent.getSerializableExtra("email");
		  snote= (String)intent.getSerializableExtra("note");
		  sImgPath= (String)intent.getSerializableExtra("ImgPath");
		 
	      company.setText(scompany);
	      linkname .setText(slinkname);
	      position .setText(sposition);
	      phone1.setText(sphone1);
	      phone2.setText(sphone2);
	      fax .setText(sfax);
	      address.setText(saddress);
	      www .setText(swww);
	      email.setText(semail);
          note.setText(snote);
	}
	 public void onAction(View v) {
		 Intent intent = null;
	 switch (v.getId()) {
			case R.id.company:
				String Company=company.getText().toString();
				intent=new Intent(MpsbxqActivity.this,XiangQingActivity.class);
				intent.putExtra("data", Company);
				intent.putExtra("name", "company");
				//startActivity(intent);
				break;
			case R.id.contact:
				String Linkname=linkname.getText().toString();
				 intent=new Intent(MpsbxqActivity.this,XiangQingActivity.class);
				intent.putExtra("data", Linkname);
				intent.putExtra("name", "linkname");
				//startActivity(intent);
				break;
			case R.id.position:
				String Position=position.getText().toString();
				intent=new Intent(MpsbxqActivity.this,XiangQingActivity.class);
				intent.putExtra("data", Position);
				intent.putExtra("name", "position");
				//startActivity(intent);
					break;
			case R.id.phone1:
				String Phone1=phone1.getText().toString();
				intent=new Intent(MpsbxqActivity.this,XiangQingActivity.class);
				intent.putExtra("data", Phone1);
				intent.putExtra("name", "phone1");
				//startActivity(intent);
				break;
			case R.id.phone2:
				String Phone2=phone2.getText().toString();
			    intent=new Intent(MpsbxqActivity.this,XiangQingActivity.class);
				intent.putExtra("data", Phone2);
				intent.putExtra("name", "phone2");
				//startActivity(intent);
				break;
			case R.id.fax:
				String Fax=fax.getText().toString();
			    intent=new Intent(MpsbxqActivity.this,XiangQingActivity.class);
				intent.putExtra("data", Fax);
				intent.putExtra("name", "fax");
				//startActivity(intent);
				break;
			case R.id.address:
				String Address=address.getText().toString();
			    intent=new Intent(MpsbxqActivity.this,XiangQingActivity.class);
				intent.putExtra("data", Address);
				intent.putExtra("name", "address");
				//startActivity(intent);
				break;
			case R.id.www:
				String Www=www.getText().toString();
				intent=new Intent(MpsbxqActivity.this,XiangQingActivity.class);
				intent.putExtra("data", Www);
				intent.putExtra("name", "www");
				//startActivity(intent);
				break;
			case R.id.email:
				String Email=email.getText().toString();
			    intent=new Intent(MpsbxqActivity.this,XiangQingActivity.class);
				intent.putExtra("data", Email);
				intent.putExtra("name", "email");
				//startActivity(intent);
				break;
			case R.id.note:
				String Note=note.getText().toString();
			    intent=new Intent(MpsbxqActivity.this,XiangQingActivity.class);
				intent.putExtra("data", Note);
				intent.putExtra("name", "note");
				//startActivity(intent);
				break;
	}
	 startActivity(intent);
	 }
	 public void fhui()
	 {
		 Intent intent=new Intent(MpsbxqActivity.this,MpsdActivity.class);
		 startActivity(intent);
		 finish();
	 }
	 
	 public void loading()
	 {
		strcompany=company.getText().toString();
		              String strcompany1=strcompany.replaceAll("~",".");
		String strlinkname=linkname.getText().toString();
		              String strlinkname1=strlinkname.replaceAll("~",".");
		String strposition =position.getText().toString();
		              String strposition1=strposition.replaceAll("~",".");
		String strphone1=phone1.getText().toString();
		              String strphone11=strphone1.replaceAll("~",".");
		String strphone2=phone2.getText().toString();
		              String strphone21=strphone2.replaceAll("~",".");
		String strfax =fax.getText().toString();
		              String strfax1=strfax.replaceAll("~",".");
		String straddress=address.getText().toString();
		              String straddress1=straddress.replaceAll("~",".");
		String strwww=www.getText().toString();
		              String strwww1=strwww.replaceAll("~",".");
		String stremail =email.getText().toString();
		              String stremail1=stremail.replaceAll("~",".");
		String strnote=note.getText().toString();
		ActivityHelper.mp.strcompany=strcompany1;	
		ActivityHelper.mp.strlinkname=strlinkname1;	
		ActivityHelper.mp.strposition=strposition1;	
		ActivityHelper.mp.strphone1=strphone11;	
		ActivityHelper.mp.strphone2=strphone21;	
		ActivityHelper.mp.strfax=strfax1;	
		ActivityHelper.mp.straddress=straddress1;	
		ActivityHelper.mp.strwww=strwww1;	
		ActivityHelper.mp.stremail=stremail1;	
		ActivityHelper.mp.strnote=strnote;
		ActivityHelper.mp.strImgPath=sImgPath;	

		 mpsbUploadProcessor.SaveToupeiInfo();

		 mpsbUploadProcessor.DisplayMpsbInfo();
		
	 }
	 
	 
	@Override
	protected void onRestart() {
		if (XiangQingActivity.data1==null&&XiangQingActivity.name1==null) {
			//ActivityHelper.ToastShow(MpsbxqActivity.this, "..");
		}else {
			//ActivityHelper.ToastShow(MpsbxqActivity.this, ".");
			 String data=XiangQingActivity.data1;
	         String name=XiangQingActivity.name1;
			 if (name.equals("company")) {
				 company.setText(data);
			}else if(name.equals("linkname")){
				linkname.setText(data);
			}else if(name.equals("position")){
				position.setText(data);
			}else if(name.equals("phone1")){
				phone1.setText(data);
			}else if(name.equals("phone2")){
				phone2.setText(data);
			}else if(name.equals("fax")){
				fax.setText(data);
			}else if(name.equals("address")){
				address.setText(data);
			}else if(name.equals("www")){
				www.setText(data);
			}else if(name.equals("email")){
				email.setText(data);
			}else if(name.equals("note")){
				note.setText(data);
			}
			 XiangQingActivity.data1=null;
			 XiangQingActivity.name1=null;
		}
		super.onRestart();
	}
	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub
		
	}

}
