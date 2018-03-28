package com.Vcan.activity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.PendingapprovalProcessor3;
import com.vcans.Processor.UesrUploadProcessor;
import com.vcans.dao.DBHelper;
import com.vcans.model.Menus;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.CameraTool;
import com.vcans.tool.VcansZuhe;
import com.vcans.tool.ZDYzuhe;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * ´
 * @author vcans
 *
 */
public class Pendingapproval1 extends BaseActivity {
	private final int REQUEST_PHOTO_FLAG = 1;
	private final int REQUEST_PHOTO_FLAG1 = 11;
	private final int REQUEST_PHOTO_FLAG2 = 22;
	public static Pendingapproval1 pendingapproval1 = null;
	private View parentView;
	@Bind(R.id.ZDYzuhe1)
	VcansZuhe ZDYzuhe1;
	@Bind(R.id.ZDYzuhe2)
	VcansZuhe ZDYzuhe2;
	@Bind(R.id.ZDYzuhe3)
	VcansZuhe ZDYzuhe3;
	@Bind(R.id.ZDYzuhe4)
	VcansZuhe ZDYzuhe4;
	@Bind(R.id.ZDYzuhe5)
	VcansZuhe ZDYzuhe5;
	@Bind(R.id.ZDYzuhe6)
	VcansZuhe ZDYzuhe6;
	@Bind(R.id.ZDYzuhe7)
	VcansZuhe ZDYzuhe7;
	@Bind(R.id.ZDYzuhe8)
	VcansZuhe ZDYzuhe8;
	@Bind(R.id.ZDYzuhe9)
	VcansZuhe ZDYzuhe9;
	@Bind(R.id.ZDYzuhe10)
	VcansZuhe ZDYzuhe10;

	@Bind(R.id.LinearLayout1)
	LinearLayout LinearLayout1;
	@Bind(R.id.LinearLayout2)
	LinearLayout LinearLayout2;
	@Bind(R.id.LinearLayout3)
	LinearLayout LinearLayout3;
	@Bind(R.id.LinearLayout4)
	LinearLayout LinearLayout4;
	@Bind(R.id.LinearLayout5)
	LinearLayout LinearLayout5;
	@Bind(R.id.LinearLayout6)
	LinearLayout LinearLayout6;
	@Bind(R.id.LinearLayout7)
	LinearLayout LinearLayout7;
	@Bind(R.id.LinearLayout8)
	LinearLayout LinearLayout8;
	@Bind(R.id.LinearLayout9)
	LinearLayout LinearLayout9;
	@Bind(R.id.LinearLayout10)
	LinearLayout LinearLayout10;
	@Bind(R.id.tvRZPlanId)
	TextView tvRZPlanId;
	@Bind(R.id.tvRZPlanId2)
	TextView tvRZPlanId2;
	@Bind(R.id.tvRZPlanId3)
	TextView tvRZPlanId3;
	@Bind(R.id.tvRZPlanId4)
	TextView tvRZPlanId4;
	@Bind(R.id.tvRZPlanId5)
	TextView tvRZPlanId5;
	@Bind(R.id.tvRZPlanId6)
	TextView tvRZPlanId6;
	@Bind(R.id.tvRZPlanId7)
	TextView tvRZPlanId7;
	@Bind(R.id.tvRZPlanId8)
	TextView tvRZPlanId8;
	@Bind(R.id.tvRZPlanId9)
	TextView tvRZPlanId9;
	@Bind(R.id.tvRZPlanId10)
	TextView tvRZPlanId10;
	@Bind(R.id.qd)
	Button btn1;



	//LinearLayout LinearLayout1,LinearLayout2,LinearLayout3,LinearLayout4,LinearLayout5,LinearLayout6,LinearLayout7,LinearLayout8,LinearLayout9,LinearLayout10;
	String id,glxxid,strczId,czname;
	EditText lron,EditText,EditText1,EditText2,EditText3,EditText4;
	UesrUploadProcessor uesrUploadProcessor=null;
	PendingapprovalProcessor3 downGoods;
	List<String> typecz1,typecz2,typecz3,typecz4,typecz5,typecz6,typecz7,typecz8,typecz9,typecz10;
	Cursor cursor;
	private String mFileName = "";
	private String mFileName1 = "";
	private String mFileName2 = "";
	private String mPreFileNameCut = "";
	SQLiteDatabase  db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);
	ImageView image,image1,image2;
	ArrayList<String> shuzuid = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		parentView = getLayoutInflater().inflate(R.layout.activity_pendingapproval1, null);
		setContentView(parentView);
		pendingapproval1=this;
		ButterKnife.bind(this);


		initData();
		initDataOnClickListener();

		
		 btn1.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
                        if(ZDYzuhe1.GetText().equals("")||ZDYzuhe2.GetText().equals("")||ZDYzuhe3.GetText().equals("")||ZDYzuhe4.GetText().equals("")||ZDYzuhe5.GetText().equals("")|| ZDYzuhe6.GetText().equals("")||ZDYzuhe7.GetText().equals("")||ZDYzuhe8.GetText().equals("")||ZDYzuhe9.GetText().equals("")||ZDYzuhe10.GetText().equals(""))
                        {
							ActivityHelper.showDialog(Pendingapproval1.this,"错误",getString(R.string.isNUll));
							return ;
						}
				ActivityHelper.kzxx1=ZDYzuhe1.GetText();
				ActivityHelper.kzxx2=ZDYzuhe2.GetText();
				ActivityHelper.kzxx3=ZDYzuhe3.GetText();
				ActivityHelper.kzxx4=ZDYzuhe4.GetText();
				ActivityHelper.kzxx5=ZDYzuhe5.GetText();
				ActivityHelper.kzxx6=ZDYzuhe6.GetText();
				ActivityHelper.kzxx7=ZDYzuhe7.GetText();
				ActivityHelper.kzxx8=ZDYzuhe8.GetText();
				ActivityHelper.kzxx9=ZDYzuhe9.GetText();
				ActivityHelper.kzxx10=ZDYzuhe10.GetText();

					    onUpload();
					    SimpleDateFormat sDateFormat = new SimpleDateFormat(
								"yyyy-MM-dd hh:mm:ss");
						String date = sDateFormat.format(new java.util.Date());

			    	    ContentValues values = new ContentValues();
			    	    if ( BaseActivity.gUser!=null) {
			    	    	 if (id==null) {
			    				 for (int i = 0; i < shuzuid.size(); i++) {
			    					 String s=shuzuid.get(i);
			    					 values.put("Spare2",  BaseActivity.gUser.getUserName()+"\n"+date+"\n"+"进行"+"["+czname+"]操作"+"\n");
			 			    		 db.update("Pendingapproval", values, "TPId=?", new String[]{s});
			    				 }
			    			 }else {
			    				     values.put("Spare2",  BaseActivity.gUser.getUserName()+"\n"+date+"\n"+"进行"+"["+czname+"]操作"+"\n");
						    		db.update("Pendingapproval", values, "TPId=?", new String[]{id});
						    	    }
							}
//
//
			}
		});			
			        image.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							onBtnPhotoClick();
						}
					});
                     image1.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							onBtnPhotoClick1();
						}
					});
                     image2.setOnClickListener(new OnClickListener() {
 						
 						@Override
 						public void onClick(View arg0) {
 							// TODO Auto-generated method stub
 							onBtnPhotoClick2();
 						}
 					});

	 }

	private void initData() {




		Intent intent = this.getIntent();
		strczId= (String)intent.getSerializableExtra("strczId");
		czname= (String)intent.getSerializableExtra("czname");
		ActivityHelper.czname=czname;
		ActivityHelper.information.strSpare3=strczId;
		id = (String)intent.getSerializableExtra("id");

		glxxid = (String)intent.getSerializableExtra("glxxid");
		shuzuid = getIntent().getStringArrayListExtra("shuzuid");


		typecz1=new ArrayList<String>();
		typecz2=new ArrayList<String>();
		typecz3=new ArrayList<String>();
		typecz4=new ArrayList<String>();
		typecz5=new ArrayList<String>();
		typecz6=new ArrayList<String>();
		typecz7=new ArrayList<String>();
		typecz8=new ArrayList<String>();
		typecz9=new ArrayList<String>();
		typecz10=new ArrayList<String>();

		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.tvActtitle,"pullto");
		this.<ImageView> RegOnClickEvent(R.id.imgNetStatus, "onTip");

		image = (ImageView)findViewById(R.id.imageView);
		image1 = (ImageView)findViewById(R.id.imageView1);
		image2 = (ImageView)findViewById(R.id.imageView2);
		uesrUploadProcessor=new UesrUploadProcessor();
		downGoods =new PendingapprovalProcessor3();
		if (id==null) {
			uesrUploadProcessor.DisplayDwspInfo1(shuzuid);
		}else {
			uesrUploadProcessor.DisplayDwspInfo(id);
		}

		kzmessage();
		ActivityHelper.biaozhi="100";
	}
	private void initDataOnClickListener() {

	}


	public void pullto(){
	//	loading();
	}
	
	public void  kzmessage()
	 {
		
	    SendParam sendParam = new SendParam();
		sendParam.parent =Pendingapproval1.this;
		sendParam.processor =  downGoods;
		getDataTrunsfer().request(sendParam);
	 }


	
	
	public void onUpload()
	 {  		 
			SendParam sendParam = new SendParam();
			sendParam.parent =this;		
			sendParam.bSendEndNotify=true;		
			sendParam.processor = uesrUploadProcessor;
			getDataTrunsfer().beginUploadFile(sendParam);
			
	 }    
	 
	 public void Query() {
		String Sql1="select * from Pendingapprovalxx  where XxId = "+glxxid+"  and  CzId= "+strczId+"   and  Item  =   1 ";
		String Sql2="select * from Pendingapprovalxx  where XxId = "+glxxid+"  and  CzId= "+strczId+"   and  Item  =   2 ";
		String Sql3="select * from Pendingapprovalxx  where XxId = "+glxxid+"  and  CzId= "+strczId+"   and  Item  =   3 ";
		String Sql4="select * from Pendingapprovalxx  where XxId = "+glxxid+"  and  CzId= "+strczId+"   and  Item  =   4 ";
		String Sql5="select * from Pendingapprovalxx  where XxId = "+glxxid+"  and  CzId= "+strczId+"   and  Item  =   5 ";
		String Sql6="select * from Pendingapprovalxx  where XxId = "+glxxid+"  and  CzId= "+strczId+"   and  Item  =   6 ";
		 String Sql7="select * from Pendingapprovalxx  where XxId = "+glxxid+"  and  CzId= "+strczId+"   and  Item  =   7 ";
		 String Sql8="select * from Pendingapprovalxx  where XxId = "+glxxid+"  and  CzId= "+strczId+"   and  Item  =   8 ";
		 String Sql9="select * from Pendingapprovalxx  where XxId = "+glxxid+"  and  CzId= "+strczId+"   and  Item  =   9 ";
		 String Sql10="select * from Pendingapprovalxx  where XxId = "+glxxid+"  and  CzId= "+strczId+"   and  Item  =   10 ";
		
		 cursor = db.rawQuery(Sql1, new String[]{});	            
	        while (cursor.moveToNext()) {
		        String Czname = cursor.getString(4);  	              
		          typecz1.add(Czname);

	            }
                 if (typecz1.size()>=4){
					     tvRZPlanId.setText(typecz1.get(0));
						 LinearLayout1.setVisibility(View.VISIBLE);
					 Menus Menus1=new Menus(typecz1.get(0),typecz1.get(1),typecz1.get(2),typecz1.get(3),typecz1);
					 ZDYzuhe1.SetMenu(Menus1);
				}


	       
	       
	      cursor = db.rawQuery(Sql2, new String[]{});	            
	        while (cursor.moveToNext()) {      
//
		        String Czname = cursor.getString(4);  	              
		        typecz2.add(Czname);
	           }
		 if (typecz2.size()>=4){
			      tvRZPlanId2.setText(typecz2.get(0));
				 LinearLayout2.setVisibility(View.VISIBLE);
			      Menus Menus2=new Menus(typecz2.get(0),typecz2.get(1),typecz2.get(2),typecz2.get(3),typecz2);
			      ZDYzuhe2.SetMenu(Menus2);
		 }

	        
	        
	        cursor = db.rawQuery(Sql3, new String[]{});	            
	        while (cursor.moveToNext()) {      
//
		        String Czname = cursor.getString(4);  	              
		        typecz3.add(Czname);    	

	           }

		 if (typecz3.size()>=4){
			     tvRZPlanId3.setText(typecz3.get(0));
				 LinearLayout3.setVisibility(View.VISIBLE);

			 Menus Menus3=new Menus(typecz3.get(0),typecz3.get(1),typecz3.get(2),typecz3.get(3),typecz3);
			 ZDYzuhe3.SetMenu(Menus3);
		 }
	        
	        
	        cursor = db.rawQuery(Sql4, new String[]{});	            
	        while (cursor.moveToNext()) {
		        String Czname = cursor.getString(4);  	              
		        typecz4.add(Czname);    	

	           }
		 if (typecz4.size()>=4){
			     tvRZPlanId4.setText(typecz4.get(0));
				 LinearLayout4.setVisibility(View.VISIBLE);

			 Menus Menus4=new Menus(typecz4.get(0),typecz4.get(1),typecz4.get(2),typecz4.get(3),typecz4);
			 ZDYzuhe4.SetMenu(Menus4);
		 }

	        
	        cursor = db.rawQuery(Sql5, new String[]{});	            
	        while (cursor.moveToNext()) {
		        String Czname = cursor.getString(4);  	              
		        typecz5.add(Czname);    	

	           }

		 if (typecz5.size()>=4){

			     tvRZPlanId5.setText(typecz5.get(0));
				 LinearLayout5.setVisibility(View.VISIBLE);
			 Menus Menus5=new Menus(typecz5.get(0),typecz5.get(1),typecz5.get(2),typecz5.get(3),typecz5);
			 ZDYzuhe5.SetMenu(Menus5);
		 }
	        
	        cursor = db.rawQuery(Sql6, new String[]{});	            
	        while (cursor.moveToNext()) {      
//
		        String Czname = cursor.getString(4);  	              
		        typecz6.add(Czname); 

            }
		 if (typecz6.size()>=4){
			 tvRZPlanId6.setText(typecz6.get(0));
				 LinearLayout6.setVisibility(View.VISIBLE);

			 Menus Menus6=new Menus(typecz6.get(0),typecz6.get(1),typecz6.get(2),typecz6.get(3),typecz6);
			 ZDYzuhe6.SetMenu(Menus6);
		 }
		 cursor = db.rawQuery(Sql7, new String[]{});
		  while (cursor.moveToNext()) {
			 String Czname = cursor.getString(4);
			 typecz7.add(Czname);

		 }
		 if (typecz7.size()>=4){
			 tvRZPlanId7.setText(typecz7.get(0));
				 LinearLayout7.setVisibility(View.VISIBLE);

			 Menus Menus7=new Menus(typecz7.get(0),typecz7.get(1),typecz7.get(2),typecz7.get(3),typecz7);
			 ZDYzuhe7.SetMenu(Menus7);
		 }
		 cursor = db.rawQuery(Sql8, new String[]{});
		 while (cursor.moveToNext()) {
			 String Czname = cursor.getString(4);
			 typecz8.add(Czname);

		 }
		 if (typecz8.size()>=4){
			 tvRZPlanId8.setText(typecz8.get(0));
				 LinearLayout8.setVisibility(View.VISIBLE);

			 Menus Menus8=new Menus(typecz8.get(0),typecz8.get(1),typecz8.get(2),typecz8.get(3),typecz8);
			 ZDYzuhe8.SetMenu(Menus8);
		 }
		 cursor = db.rawQuery(Sql9, new String[]{});
		 while (cursor.moveToNext()) {
			 String Czname = cursor.getString(4);
			 typecz9.add(Czname);

		 }
		 if (typecz9.size()>=4){
			 tvRZPlanId9.setText(typecz9.get(0));
				 LinearLayout9.setVisibility(View.VISIBLE);

			 Menus Menus9=new Menus(typecz9.get(0),typecz9.get(1),typecz9.get(2),typecz9.get(3),typecz9);
			 ZDYzuhe9.SetMenu(Menus9);
		 }
		 cursor = db.rawQuery(Sql10, new String[]{});
		 while (cursor.moveToNext()) {
			 String Czname = cursor.getString(4);
			 typecz10.add(Czname);

		 }
		 if (typecz10.size()>=4){
			 tvRZPlanId10.setText(typecz10.get(0));
				 LinearLayout10.setVisibility(View.VISIBLE);

			 Menus Menus10=new Menus(typecz10.get(0),typecz10.get(1),typecz10.get(2),typecz10.get(3),typecz10);
			 ZDYzuhe10.SetMenu(Menus10);
		 }
	 }
	 	 	
			
		public void onBtnPhotoClick() {
			
			String strFilePath = ActivityHelper.getFilePathNoName();

			if (strFilePath != null) {
				SimpleDateFormat sDateFormat = new SimpleDateFormat(
						"yyyyMMddhhmmss");
				String date = sDateFormat.format(new java.util.Date());

				mFileName = strFilePath + "/image/i" + date + ".jpg";
			    //mFileName=ActivityHelper.GetFilePath();

				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				Uri imageUri = Uri.fromFile(new File(mFileName));
				intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
				startActivityForResult(intent, REQUEST_PHOTO_FLAG);
			} else {
				ActivityHelper.showDialog(this, "错误", getString(R.string.noPath));
			}
		}
		
        public void onBtnPhotoClick1() {
			
			String strFilePath = ActivityHelper.getFilePathNoName();

			if (strFilePath != null) {
				SimpleDateFormat sDateFormat = new SimpleDateFormat(
						"yyyyMMddhhmmss");
				String date = sDateFormat.format(new java.util.Date());

				mFileName1 = strFilePath + "/image/i" + date + ".jpg";
			    //mFileName=ActivityHelper.GetFilePath();

				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				Uri imageUri = Uri.fromFile(new File(mFileName1));
				intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
				startActivityForResult(intent, REQUEST_PHOTO_FLAG1);
			} else {
				ActivityHelper.showDialog(this, "错误", getString(R.string.noPath));
			}
		}
        
         public void onBtnPhotoClick2() {
			
			String strFilePath = ActivityHelper.getFilePathNoName();

			if (strFilePath != null) {
				SimpleDateFormat sDateFormat = new SimpleDateFormat(
						"yyyyMMddhhmmss");
				String date = sDateFormat.format(new java.util.Date());

				mFileName2 = strFilePath + "/image/i" + date + ".jpg";
			    //mFileName=ActivityHelper.GetFilePath();

				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				Uri imageUri = Uri.fromFile(new File(mFileName2));
				intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
				startActivityForResult(intent, REQUEST_PHOTO_FLAG2);
			} else {
				ActivityHelper.showDialog(this, "´错误", getString(R.string.noPath));
			}
		}
//		
		@Override
		public void onActivityResult(int requestCode, int resultCode, Intent data) {
			super.onActivityResult(requestCode, resultCode, data);

			if (requestCode == REQUEST_PHOTO_FLAG) {
				if (resultCode == Activity.RESULT_OK) {
					if (ActivityHelper.bCutPhoto) {
						mPreFileNameCut=mFileName;
						mFileName=CameraTool.cropImageUri(this,Uri.fromFile(new File(mPreFileNameCut)), 111);					
						
					} else{
						tupian();
						}
				  }
				}else if (requestCode == 111){				
					tupian();	
					
			  }	
			if (requestCode == REQUEST_PHOTO_FLAG1) {
				if (resultCode == Activity.RESULT_OK) {
					if (ActivityHelper.bCutPhoto) {
						mPreFileNameCut=mFileName1;
						mFileName1=CameraTool.cropImageUri(this,Uri.fromFile(new File(mPreFileNameCut)), 222);
						//tupian();
						tupian1();
					} else{tupian1();}
				  }
				}else if (requestCode == 222){				
					tupian1();	
					
			  }	
			if (requestCode == REQUEST_PHOTO_FLAG2) {
				if (resultCode == Activity.RESULT_OK) {
					if (ActivityHelper.bCutPhoto) {
						mPreFileNameCut=mFileName2;
						mFileName2=CameraTool.cropImageUri(this,Uri.fromFile(new File(mPreFileNameCut)), 333);						
						tupian2();
					} else{tupian2();}
				  }	
				}else if (requestCode == 333){				
					tupian2();	
					
			  }	
							
					  
			}		
							
					  
					
		
		
		public void tupian() {
			// TODO Auto-generated method stub
			
				     image = (ImageView)findViewById(R.id.imageView);  
		             BitmapFactory.Options options = new BitmapFactory.Options();  
		             options.inSampleSize = 2;  
	                 Bitmap bm = BitmapFactory.decodeFile(mFileName, options); 	              
	                 ActivityHelper.tp1=mFileName;
	                 if(bm == null){	                	   
	                	   return;
	                	 }
	                 image.setImageBitmap(bm);  
	                 image1.setBackgroundResource(R.drawable.icon_addpic_unfocused);
	                 image1.setVisibility(View.VISIBLE);
//	                    db=SQLiteDatabase.openDatabase(path, null, 2);
//		    	        ContentValues values = new ContentValues();			    	   		        	
//			    		values.put("Spare3",  mFileName);
//			    		db.update("Pendingapproval", values, "TPId=?", new String[]{id}); 
			
			       
		}		
		public void tupian1() {
			// TODO Auto-generated method stub
			
			         image1 = (ImageView)findViewById(R.id.imageView1);  
		             BitmapFactory.Options options = new BitmapFactory.Options();  
		             options.inSampleSize = 2;  
	                 Bitmap bm = BitmapFactory.decodeFile(mFileName1, options); 
	                 ActivityHelper.tp2=mFileName1;	
	                 if(bm == null){	                	   
	                	   return;
	                	 }
	                 image1.setImageBitmap(bm);  
	                 image2.setBackgroundResource(R.drawable.icon_addpic_unfocused);
	                 image2.setVisibility(View.VISIBLE);
//	                    
		}	
		public void tupian2() {
			// TODO Auto-generated method stub
			
			         image2 = (ImageView)findViewById(R.id.imageView2);  
		             BitmapFactory.Options options = new BitmapFactory.Options();  
		             options.inSampleSize = 2;  
	                 Bitmap bm = BitmapFactory.decodeFile(mFileName2, options); 
	                 ActivityHelper.tp3=mFileName2;	 
	                 if(bm == null){	                	   
	                	   return;
	                	 }
	                 image2.setImageBitmap(bm);                  
//	                    
		}	
		
		
		
	@Override
		protected void onRestart() {
			// TODO Auto-generated method stub
		    ActivityHelper.biaozhi="100";
		    ActivityHelper.czname=czname;
		   // loading();
			super.onRestart();
		}

	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		    ActivityHelper.tp1=null;
		    ActivityHelper.tp2=null;
		    ActivityHelper.tp3=null;
		    ActivityHelper.biaozhi=null;
		   db.delete(DBHelper.Pendingapprovalxx,null,null);
		 super.onDestroy();
		
	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub
		if (msgId==1000) {
			Query();
		}
		
	}

}
