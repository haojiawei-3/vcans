package com.Vcan.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import cn.sharp.android.ncr.StaticRecFromCamera;

import com.Vcan.activity.R;
import com.Vcan.activity.R.id;
import com.example.qr_codescan.MipcaActivityCapture;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.MlqdProcessor3;
import com.vcans.Processor.MlqdProcessor5;
import com.vcans.Processor.MlqdUploadProcessor;
import com.vcans.Processor.mpsbProcessor;
import com.vcans.model.CustomerCollect;
import com.vcans.model.Mlqd2;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.SildingFinishLayout;
import com.vcans.tool.SildingFinishLayout.OnSildingFinishListener;

import android.widget.RadioGroup.OnCheckedChangeListener;
import android.os.Bundle;
import android.os.Environment;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;
/**
 *   清单模块一   有6个界面类
 * @author vcans
 *
 */
public class MlqdActivity4 extends BaseActivity  {
	public static MlqdActivity4 mlqdActivity4 = null;
	EditText hkbh,khmc,lxr,lxdh,lxadd,scbz;
	Button button,sm,cxun, button1;
	MlqdUploadProcessor mlqdUploadProcessor;
	//mpsbProcessor mpsbProcessor;
	String name,shkbh,skhmc,slxr,slxadd,sscbz,slxdh,   company,contact,phone1,address;
	Vector<String> s;
	static ArrayList<String> listid = new ArrayList<String>();
	static ArrayList<String> listid1 = new ArrayList<String>();
	RadioButton rdBtnCh,rdBtnEn;
	RadioGroup rdGroupLanguage;
	Cursor cursor;
	ScrollView scrollView;
	CustomerCollect customerCollect;
	List<CustomerCollect>  Collectlist=new ArrayList<CustomerCollect>();
	boolean you;
	Intent intent;
	SQLiteDatabase	db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mlqd_activity4);
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		mlqdActivity4=this;
		button=(Button)findViewById(R.id.qd);
		button1=(Button)findViewById(R.id.bc);
		sm=(Button)findViewById(R.id.sm);
		cxun=(Button)findViewById(R.id.cxun);
		hkbh=(EditText)findViewById(R.id.khbh);
		khmc=(EditText)findViewById(R.id.khmc);
		lxr=(EditText)findViewById(R.id.lxr);
		lxdh=(EditText)findViewById(R.id.lxdh);
		lxadd=(EditText)findViewById(R.id.lxadd);
		scrollView=(ScrollView)findViewById(R.id.ScrollView);
		scbz=(EditText)findViewById(R.id.scbz);
		rdBtnCh = (RadioButton) this.findViewById(R.id.rdBtnCh);
		rdBtnEn = (RadioButton) this.findViewById(R.id.rdBtnEn);


		rdGroupLanguage = (RadioGroup) this.findViewById(R.id.radioGroup1);
		intent=this.getIntent();
		you=true;
		khmc.setEnabled(false);
		lxr.setEnabled(false);
		lxdh.setEnabled(false);
		lxadd.setEnabled(false);

		listid = getIntent().getStringArrayListExtra("id");
		listid1 = getIntent().getStringArrayListExtra("shu");
		rdGroupLanguage.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int checkedId) {
				// TODO Auto-generated method stub
				if(R.id.rdBtnCh == checkedId){
					you=true;
					khmc.setEnabled(false);
					lxr.setEnabled(false);
					lxdh.setEnabled(false);
					lxadd.setEnabled(false);
					cxun.setVisibility(View.VISIBLE);

				}
				else if(R.id.rdBtnEn == checkedId){
					you=false;
					cxun.setVisibility(View.INVISIBLE);
					khmc.setEnabled(true);
					lxr.setEnabled(true);
					lxdh.setEnabled(true);
					lxadd.setEnabled(true);

				}

			}
		});

		SildingFinishLayout();
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//[客户编号][客户名称][联系人][电话][地址]
				shkbh=hkbh.getText().toString();
				skhmc=khmc.getText().toString();
				slxr=lxr.getText().toString();
				slxdh=lxdh.getText().toString();
				slxadd=lxadd.getText().toString();
				sscbz=scbz.getText().toString();

				if (you) {
					if(shkbh.equals(""))//||skhmc.equals("")||slxr.equals("")||slxdh.equals("")||slxadd.equals("")
					{
						ActivityHelper.showDialog(MlqdActivity4.this, "提示", "客户编号不能为空");
						return;
					}else {
						if (BaseActivity.bConnected==false) {
							ActivityHelper.showDialog(MlqdActivity4.this, "提示", "连接异常---可先缓存");
						}else {
							processMessage(300,shkbh);
						}
					}


				}else {
					if(skhmc.equals("")||slxr.equals("")||slxdh.equals("")||slxadd.equals(""))//||slxr.equals("")||slxdh.equals("")||slxadd.equals("")
					{
						ActivityHelper.showDialog(MlqdActivity4.this, "提示", "客户信息不能为空");
						// ActivityHelper.showDialog(MlqdActivity4.this, "提示", "客户不能为空");
						return;
					}else {
						if (BaseActivity.bConnected==false) {
							ActivityHelper.showDialog(MlqdActivity4.this, "提示", "连接异常---可先缓存");
						}else {
							SendParam sendParam = new SendParam();
							sendParam.tip="名片上传";
							sendParam.parent =MlqdActivity4.this;
							sendParam.processor =new mpsbProcessor(new String[]{shkbh,skhmc,slxr,slxdh,slxadd,sscbz});
							getDataTrunsfer().beginUploadText(sendParam);
						}

					}

				}


			}
		});
		cxun.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cxun();

			}
		});
		sm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (you) {
					onOpenScanBarcode();
				}else {
					Intent intent = new Intent(MlqdActivity4.this,StaticRecFromCamera.class);
					intent.putExtra("id","2");
					startActivityForResult(intent, 1);
				}


			}
		});

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub


				ContentValues values = new ContentValues();
				if ( Collect(listid)==null) {
					ActivityHelper.showDialog(MlqdActivity4.this, "提示", "保存失败");
				}else {
					for (int i = 0; i <  Collectlist.size(); i++) {
						customerCollect=Collectlist.get(i);
						values.put("mark",customerCollect.mark);
						values.put("mark1",customerCollect.mark1);
						values.put("khname", customerCollect.khname);
						values.put("linkman", customerCollect.linkman);
						values.put("Phone",  customerCollect.Phone);
						values.put("addr",  customerCollect.addr);
						values.put("khcode",  customerCollect.khcode);
						values.put("ypcode",  customerCollect.ypcode);
						values.put("price",  customerCollect.price);
						values.put("number",  customerCollect.number);
						values.put("standby1",  customerCollect.khcode);//根据这个分类
						values.put("standby2", "null");
						values.put("standby3", "null");


						db.execSQL("delete from CustomerCollect  where mark=? and mark1=?  and khname=? and linkman=? " +
										" and Phone=?  and  addr=? and khcode=?  and ypcode=? and  price=? and number=?  ",
								new Object[]{
										customerCollect.mark,
										customerCollect.mark1,
										customerCollect.khname,
										customerCollect.linkman,
										customerCollect.Phone,
										customerCollect.addr,
										customerCollect.khcode,
										customerCollect.ypcode,
										customerCollect.price,
										customerCollect.number,
								});
						db.insert("CustomerCollect", null, values);
					}
					if (MlqdActivity4.mlqdActivity4!=null) {
						MlqdActivity4.mlqdActivity4.finish();
					}
					if (MlqdActivity5.mlqdActivity5!=null) {
						MlqdActivity5.mlqdActivity5.finish();
					}
					if (MlqdActivity3.mlqdActivity3!=null) {
						MlqdActivity3.mlqdActivity3.finish();
					}
					Intent intent=new Intent(MlqdActivity4.this,MlqdActivity3.class);

					startActivity(intent);

					for (int i = 0; i < listid.size(); i++) {
						String id=listid.get(i);
						db.execSQL("delete from Collect  where TPId=?  ", new Object[]{id});
					}
//                    finish();
					ActivityHelper.showDialog(MlqdActivity4.this, "提示", "保存成功");
				}
			}
		});
	}


	public void SildingFinishLayout(){
		SildingFinishLayout mSildingFinishLayout = (SildingFinishLayout) findViewById(R.id.sildingFinishLayout);
		mSildingFinishLayout.setOnSildingFinishListener(new OnSildingFinishListener() {

			@Override
			public void onSildingFinish() {
				finish();
			}
		});

		mSildingFinishLayout.setTouchView(scrollView);
		//return activity;
	}

	public List<CustomerCollect> Collect(List<String> ss){
		shkbh=hkbh.getText().toString();
		skhmc=khmc.getText().toString();
		slxr=lxr.getText().toString();
		slxdh=lxdh.getText().toString();
		slxadd=lxadd.getText().toString();
		String s="Y";
		if (you==false) {
			s="N";
			//Toast.makeText(MlqdActivity4.this, "新客户模式", Toast.LENGTH_LONG).show();
			if(skhmc.equals("")||slxr.equals("")||slxdh.equals("")||slxadd.equals(""))//
			{
				ActivityHelper.showDialog(MlqdActivity4.this, "提示", "客户信息不能为空");
				return null;
			}
		}else {
			//Toast.makeText(MlqdActivity4.this, "已有客户模式", Toast.LENGTH_LONG).show();
			if (shkbh.equals("")) {
				Toast.makeText(MlqdActivity4.this, "已有客户模式客户编号不能为空", Toast.LENGTH_LONG).show();
				return null;
			}

		}
		for (int i = 0; i < ss.size(); i++) {
			String	 sql="select * from Collect where  TPId ="+"'"+ss.get(i)+"'"+" ";
			cursor = db.rawQuery(sql, new String[]{});
			while (cursor.moveToNext()) {
				String strCode = cursor.getString(1);
				String strQuotation = cursor.getString(12);
				customerCollect = new CustomerCollect(s,"N",slxr,slxdh,slxadd,skhmc,shkbh,strCode,strQuotation,listid1.get(i));
				Collectlist.add(customerCollect);
			}

		}

		return Collectlist;

	}




	public void cxun(){
		name=hkbh.getText().toString();
		if (!name.equals("")) {
			SendParam sendParam = new SendParam();
			sendParam.parent = MlqdActivity4.this;
			sendParam.szData=new String[]{name};
			sendParam.processor = new MlqdProcessor5();
			getDataTrunsfer().request(sendParam);
		}else {
			Toast.makeText(MlqdActivity4.this, "搜索内容为空", Toast.LENGTH_LONG).show();
			// onOpenScanBarcode();
		}
	}


	public void onOpenScanBarcode() {
		Intent intent = new Intent();
		intent.setClass(this, MipcaActivityCapture.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivityForResult(intent, REQUEST_SCAN_QRCODE_FLAG);
	}

	@Override
	public void onActivityResult(int requestCode,int resultCode,Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		Log.e("hjw", "onActivityResult开始执行");
		if(requestCode==REQUEST_SCAN_QRCODE_FLAG)
		{//条码扫描完毕返回
			if(resultCode==Activity.RESULT_OK)
			{
				Bundle bundle = data.getExtras();
				String strRst=bundle.getString("result");
				EditText hkbh=(EditText)findViewById(R.id.khbh);
				hkbh.setText(strRst);
				if (hkbh.getText().toString().equals("")) {

				}else {
					cxun();
				}
			}
		}else if(requestCode==1){
			for (int i = 0; i < ActivityHelper.arrayList.size(); i++) {
				khmc.setText(ActivityHelper.arrayList.get(0));
				lxr.setText(ActivityHelper.arrayList.get(1));
				lxdh.setText(ActivityHelper.arrayList.get(2));
				lxadd.setText(ActivityHelper.arrayList.get(3));
			}
		}else {
			String code= ActivityHelper.Code;

			hkbh.setText(code);
			if (hkbh.getText().toString().equals("")) {

			}else {
				cxun();
			}
			ActivityHelper.Code="";
		}

	}


	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub
		if (msgId==200) {
			s=new Vector<String>();
			s=ActivityHelper.data;
			hkbh.setText(s.get(0));
			khmc.setText(s.get(1));
			lxr.setText(s.get(2));
			lxdh.setText(s.get(3));
			lxadd.setText(s.get(4));

		}else if (msgId==300) {
			ActivityHelper.biaozhi="200";
			String  shkbh= hkbh.getText().toString();
			String  skhmc= khmc.getText().toString();
			mlqdUploadProcessor=new MlqdUploadProcessor(new String[]{msg,skhmc},   listid1);
			//mpsbProcessor=new mpsbProcessor();
			if (listid!=null) {
				for (int i = 0; i < listid.size(); i++) {
					String s=listid.get(i);
				}
				mlqdUploadProcessor.DisplayMlqdInfo(listid);
			}

			SendParam sendParam = new SendParam();
			sendParam.parent =MlqdActivity4.this;
			sendParam.bSendEndNotify=true;
			sendParam.processor = mlqdUploadProcessor;
			getDataTrunsfer().beginUploadFile(sendParam);
		}

	}

}
