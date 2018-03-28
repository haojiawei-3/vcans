package com.Vcan.activity;

import java.util.ArrayList;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.MlqdProcessor1;
import com.vcans.Processor.MlqdProcessor3;
import com.vcans.model.Information;
import com.vcans.model.Mlqd2;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;

import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
/**
 *   清单模块一   有6个界面类
 * @author vcans
 *
 */
public class MlqdActivity2 extends BaseActivity {
	public static MlqdActivity2 mlqdActivity2 = null;
	private Button xq;
	private String text1 = "'清单一'";
	private String text2 = "'描述一名称'";
	private String text3 = "'描述二名称'";
	private String text4 = "'描述三名称'";
	private Intent intent;
	private ImageView zt1,baobiao;
	private  String img,str;
	private  ScrollView scrollView;
	private Mlqd2 mlqd2;
	private TextView pm,ph,msone,mstow,msthree,gangyao,TextView1,TextView2,TextView3,button1,button,hondian;
	private String code,strcj;
	private ImageButton imageButton;
	private SQLiteDatabase   db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
	private Cursor cursor;
	private RelativeLayout RelativeLayoutqd;

	boolean b=false;
	private List<String> name = new ArrayList<String>();
	private List<String> name1 = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mlqd_activity2);
		this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
		mlqdActivity2=this;
		scrollView=(ScrollView)findViewById(R.id.ScrollView);
		SildingFinishLayout(scrollView);
		TextView textView=(TextView)findViewById(R.id.tvActtitle);
		TextView1= (TextView)findViewById(R.id.TextView1);
		TextView2= (TextView)findViewById(R.id.TextView2);
		TextView3= (TextView)findViewById(R.id.TextView3);
		hondian= (TextView)findViewById(R.id.hondian);
		imageButton=(ImageButton)findViewById(R.id.qd);
		RelativeLayoutqd=(RelativeLayout)findViewById(R.id.RelativeLayoutqd);
		button1=(TextView)findViewById(R.id.sc);
		zt1=(ImageView)findViewById(R.id.zt1);
		baobiao=(ImageView)findViewById(R.id.imageView);
		xq=(Button)findViewById(R.id.xq);
		pm=(TextView)findViewById(R.id.pm);
		ph=(TextView)findViewById(R.id.ph);
		msone=(TextView)findViewById(R.id.msone);
		mstow=(TextView)findViewById(R.id.mstow);
		msthree=(TextView)findViewById(R.id.msthree);
		gangyao=(TextView)findViewById(R.id.gangyao);
		mlqd2=new Mlqd2();
		intent=this.getIntent();
		mlqd2  = (Mlqd2)intent.getSerializableExtra("mlqd2list");
		strcj  = (String)intent.getSerializableExtra("strcj");
		pm.setText(mlqd2.strPname);
		ph.setText(mlqd2.strPnumber);
		msone.setText(   mlqd2.strDescription1);
		mstow.setText(   mlqd2.strDescription2);
		msthree.setText(   mlqd2.strDescription3);
		String s=mlqd2.strspare3;
		if (s.equals("null")) {
			zt1.setBackgroundResource(R.drawable.no_img);
		}else {
			// Bitmap bitmap = BitmapFactory.decodeFile(mlqd2.strspare3);
			Bitmap bitmap=ActivityHelper.BitmapFactory(mlqd2.strspare3, 1);
			zt1.setImageBitmap(bitmap);

		}

		textView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//db.delete("MLQingdan",null,null);
				xiazai();
			}
		});

		code=mlqd2.strCode;

		if (!initData2(code).equals("null")) {
			//  Bitmap bitmap = BitmapFactory.decodeFile(initData2(code));
			Bitmap bitmap=ActivityHelper.BitmapFactory(initData2(code), 1);
			if (bitmap==null) {
				//baobiao.setImageBitmap(R.drawable.no_img);
			}else {baobiao.setImageBitmap(bitmap);}

			gangyao.setText(str);
		}else {
			xiazai();
		}
		initData1();
		if (!hondian().equals("0")) {
			hondian.setVisibility(View.VISIBLE);
			hondian.setText(hondian());
		}

		zt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MlqdActivity2.this,Pendingapproval001.class);
				ActivityHelper.filePaths=mlqd2.strspare3;
				startActivity(intent);

				overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
			}
		});


		baobiao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MlqdActivity2.this,Pendingapproval001.class);
				ActivityHelper.filePaths=img;
				startActivity(intent);
				overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
			}
		});

		RelativeLayoutqd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MlqdActivity2.this,MlqdActivity3.class);

				startActivity(intent);
			}
		});
		imageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MlqdActivity2.this,MlqdActivity3.class);

				startActivity(intent);
			}
		});
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ContentValues values = new ContentValues();
				b=false;
				values.put("Code",mlqd2.strCode);
				values.put("Pnumber",mlqd2.strPnumber);
				values.put("Pname", mlqd2.strPname);
				values.put("Description1",  mlqd2.strDescription1);
				values.put("Description2",  mlqd2.strDescription2);
				values.put("Description3",  mlqd2.strDescription3);
				values.put("Filter1",  mlqd2.strFilter1);
				values.put("Filter2",  mlqd2.strFilter2);
				values.put("Filter3",  mlqd2.strFilter3);
				values.put("mulu2",  mlqd2.strmulu2);
				values.put("mulu3",  mlqd2.strmulu3);
				values.put("Quotation", mlqd2.strQuotation);
				values.put("Spare", mlqd2.strspare);
				values.put("Spare1", mlqd2.strspare1);
				values.put("Spare2", mlqd2.strspare2);
				values.put("Spare3", mlqd2.strspare3);
				values.put("Spare4", mlqd2.strspare4);

				cursor= db.rawQuery("select * from Collect where Code=? ", new String[]{mlqd2.strCode});
				while (cursor.moveToNext()) {
					b=true;
				}
				if (b==true) {
					Toast.makeText(MlqdActivity2.this, "不能重复收藏", Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(MlqdActivity2.this, "加入收藏车成功", Toast.LENGTH_SHORT).show();
				}


				db.execSQL("delete from Collect where Code=?",   new Object[]{mlqd2.strCode});
				db.insert("Collect", null, values);

				if (!hondian().equals("0")) {
					hondian.setVisibility(View.VISIBLE);
					hondian.setText(hondian());
				}
			}

		});
		xq.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MlqdActivity2.this,MlqdActivity21.class);
				intent.putExtra("code", code);
				intent.putExtra("pm", mlqd2.strPname);
				intent.putExtra("ph", mlqd2.strPnumber);
				intent.putExtra("msone", mlqd2.strDescription1);
				intent.putExtra("mstow", mlqd2.strDescription2);
				intent.putExtra("msthree", mlqd2.strDescription3);
				intent.putExtra("gangyao", mlqd2.strspare1);
				intent.putStringArrayListExtra("name", (ArrayList<String>) name);
				startActivity(intent);
			}
		});


	}

	public String hondian() {
		name1.clear();
		cursor = db.rawQuery("select * from  Collect ", new String[]{});
		while (cursor.moveToNext()) {

			String s = cursor.getString(0);
			name1.add(s);
		}
		return name1.size()+"";

	}

	public void initData1() {
		cursor = db.rawQuery("select * from  UIItemTitle  where ModuleId ="+text1+" and  (ItemName ="+text2+" or ItemName ="+text3+" or ItemName ="+text4+")", new String[]{});
		while (cursor.moveToNext()) {

			String s = cursor.getString(4);

			name.add(s);

		}
		cursor.close();
                if(name.size()>0){
					TextView1.setText(name.get(0)+":");
					TextView2.setText(name.get(1)+":");
					TextView3.setText(name.get(2)+":");
				}else {
					ActivityHelper.ToastShow(MlqdActivity2.this,"配置错误");
				}


	}
	public String initData2(String s) {
		cursor = db.rawQuery("select * from  MLQingdanone  where Code ="+"'"+s+"'"+" ", new String[]{});
		while (cursor.moveToNext()) {
			str = cursor.getString(13);
			img = cursor.getString(15);
		}
		cursor.close();
		return img;



	}

	public void xiazai() {

		if (!BaseActivity.bConnected) {
			ActivityHelper.showDialog(this, "", getString(R.string.serDisconnect));
			return ;
		}
		SendParam sendParam = new SendParam();
		sendParam.tip=getString(R.string.ypxq);
		sendParam.parent = MlqdActivity2.this;
		sendParam.szData=new String[]{code};
		sendParam.processor = new MlqdProcessor3();
		getDataTrunsfer().request(sendParam);
	}

	@Override
	protected void onResume() {

		if (hondian().equals("0")) {
			hondian.setVisibility(View.GONE);
		}else {
			hondian.setVisibility(View.VISIBLE);
			hondian.setText(hondian());
		}
		super.onResume();

	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub
		if (msgId==2000) {
			gangyao.setText(msg);
		}else if (msgId==3000) {
			// Bitmap bitmap = BitmapFactory.decodeFile(initData2(msg));
			Bitmap bitmap=ActivityHelper.BitmapFactory(initData2(msg), 1);
			if (bitmap==null) {
				baobiao.setBackgroundResource(R.drawable.no_img);
			}else {
				baobiao.setImageBitmap(bitmap);
			}

		}

	}

}
