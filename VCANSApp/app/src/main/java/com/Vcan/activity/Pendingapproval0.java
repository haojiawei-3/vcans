package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.PendingapprovalProcessor2;
import com.vcans.Processor.PendingapprovalProcessor3;
import com.vcans.adapter.NotapprovedAdapter;
import com.vcans.model.Information;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;

import android.net.VpnService;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Pendingapproval0 extends BaseActivity {
	Intent intent;
	public static Pendingapproval0 pendingapproval0 = null;
	String id,glxxid,strczId,bzid;
	Button xq;
	TextView  cz1,cz2,cz3,cz4,cz5,cz6,cz7,cz8,cz9,cz10,cz11,cz12;
	TextView zt,fqr,rq,mkmcdh,zt1,gangyao,mkmcdh1,jqcz;
	List<Information> Informationlist;
	Information information;
	List<String> typecz1,typecz2,type;
	Cursor cursor;
	ScrollView scrollView;
	SQLiteDatabase db;
	ArrayList<String> shuzuid = new ArrayList<String>();
	NotapprovedAdapter adapter;
	ListView View;
	String TPId = "TPId =";
	String TPId1 = " or TPId =";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dwspxq);
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<ImageView> RegOnClickEvent(R.id.imgNetStatus, "onTip");
		scrollView=(ScrollView)findViewById(R.id.ScrollView);
		SildingFinishLayout(scrollView);
		pendingapproval0 = this;
		this.<Button>RegOnClickEvent(R.id.xq,"More");
		cz1=(TextView)findViewById(R.id.cz1);
		cz2=(TextView)findViewById(R.id.cz2);
		cz3=(TextView)findViewById(R.id.cz3);
		cz4=(TextView)findViewById(R.id.cz4);
		cz5=(TextView)findViewById(R.id.cz5);
		cz6=(TextView)findViewById(R.id.cz6);
		cz7=(TextView)findViewById(R.id.cz7);
		cz8=(TextView)findViewById(R.id.cz8);
		cz9=(TextView)findViewById(R.id.cz9);
		cz10=(TextView)findViewById(R.id.cz10);
		cz11=(TextView)findViewById(R.id.cz11);
		cz12=(TextView)findViewById(R.id.cz12);





		xq=(Button)findViewById(R.id.xq);
		View=(ListView)findViewById(R.id.listxz);
		db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);
		typecz1=new ArrayList<String>();
		typecz2=new ArrayList<String>();
		information =new Information();
		zt=(TextView)findViewById(R.id.zt);
		fqr=(TextView)findViewById(R.id.fqr);
		rq=(TextView)findViewById(R.id.sj);
		mkmcdh=(TextView)findViewById(R.id.mkmcdh);
		mkmcdh1=(TextView)findViewById(R.id.mkmcdh1);
		jqcz=(TextView)findViewById(R.id.jqcz);
		zt1=(TextView)findViewById(R.id.zt1);
		gangyao=(TextView)findViewById(R.id.gangyao);

		intent=this.getIntent();
		bzid  = (String)intent.getSerializableExtra("bzid");
		if (bzid.equals("1")) {
			information  = (Information)intent.getSerializableExtra("Informationlist");
			Log.e("TAG", "我被单击了"+information);
			zt.setText(information.strthemer);
			fqr.setText(information.strinitiator);
			rq.setText(information.strdate);
			mkmcdh.setText(information.strodd);
			mkmcdh1.setText(information.strmodulename+"   ");
			jqcz.setText(information.strSpare4);
			zt1.setText(information.strstateId);
			gangyao.setText(information.strcontent);
			id=information.strId;
			glxxid=information.strxxId;
			ActivityHelper.informationxx.strXxId=glxxid;
			Query();

		}else if (bzid.equals("2")) {

			shuzuid = getIntent().getStringArrayListExtra("shuzuid");
			if (shuzuid.size()==1) {
				String sql="select * from Pendingapproval where TPId ="+shuzuid.get(0)+" and  Type = 1 and Spare1 = 0   order by TPId  desc";
				Log.e("TAG", sql);
				cursor = db.rawQuery(sql, new String[]{});
				while (cursor.moveToNext()) {
//		        	String strId = cursor.getString(0);
//			    	String strxxId = cursor.getString(1);
//			        String strtype = cursor.getString(2);
//			        String strthemer = cursor.getString(3);
//			        String strinitiator = cursor.getString(4);
//			        String strcontent = cursor.getString(5);
//			        String strstateId = cursor.getString(6);
//			        String strstate = cursor.getString(7);
//			        String strmoduletype = cursor.getString(8);
//			        String strmoduletypeId = cursor.getString(9);
//			        String strmodulename = cursor.getString(10);
//			        String strodd = cursor.getString(11);
//			        String stroddId = cursor.getString(12);
//			        String strdate = cursor.getString(13);
//			        String strspare1 = cursor.getString(14);
//			        String strspare2 = cursor.getString(15);
//			        String strspare3 = cursor.getString(16);
//			        String strspare4 = cursor.getString(17);
//			        String strspare5 = cursor.getString(18);
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
				mkmcdh1.setText(information.strmodulename+"   ");
				jqcz.setText(information.strSpare4);
				zt1.setText(information.strstateId);
				gangyao.setText(information.strcontent);
				id=information.strId;
				glxxid=information.strxxId;
				ActivityHelper.informationxx.strXxId=glxxid;
				Query();
			}else {
				scrollView.setVisibility(View.GONE);
				xq.setVisibility(View.INVISIBLE);
				View.setVisibility(View.VISIBLE);
				Informationlist = new ArrayList<Information>();
				adapter = new NotapprovedAdapter(Pendingapproval0.this,  Informationlist);
				View.setAdapter(adapter);
				Informationlist.clear();
				Query1();
				adapter.setData(Informationlist);
				information =Informationlist.get(0);
				glxxid=information.strxxId;
				String ztt=information.strstateId;
				String name=information.strmodulename;
				zt1.setText(ztt);
				ActivityHelper.informationxx.strXxId=glxxid;
				fqr.setText(name);
				int j=Informationlist.size();
				rq.setText("批量操作"+"("+ztt+")"+"共"+j+"笔");
				Query();
			}
		}



	}
	public void Query1() {
		//根据数据的状态  StateId查询显示到不同的  模块地方
		for (int i = 0; i < shuzuid.size(); i++) {
			if (i==shuzuid.size()-1) {
				TPId+="'"+shuzuid.get(i)+"'"+" and";
			}else {
				TPId+="'"+shuzuid.get(i)+"'"+TPId1;
			}

		}
		String sql="select * from Pendingapproval where  "+TPId+"   Type = 1 and Spare1 = 0   order by TPId  desc";
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
			Informationlist.add(information);
			System.out.println(Informationlist);

		}

	}

	public void caozuo(View v){
		switch (v.getId()) {
			case R.id.cz1:
				String cz11=(String) cz1.getText().toString();
				Toast.makeText(Pendingapproval0.this,cz11, 500).show();
				showInput(cz11);
				break;
			case R.id.cz2:
				String cz22=(String) cz2.getText().toString();
				Toast.makeText(Pendingapproval0.this,cz22, 500).show();
				showInput(cz22);
				break;
			case R.id.cz3:
				String cz33=(String) cz3.getText().toString();
				Toast.makeText(Pendingapproval0.this,cz33, 500).show();
				showInput(cz33);
				break;
			case R.id.cz4:
				String cz44=(String) cz4.getText().toString();
				Toast.makeText(Pendingapproval0.this,cz44, 500).show();
				showInput(cz44);
				break;
			case R.id.cz5:
				String cz55=(String) cz5.getText().toString();
				Toast.makeText(Pendingapproval0.this,cz55, 500).show();
				showInput(cz55);
				break;
			case R.id.cz6:
				String cz66=(String) cz6.getText().toString();
				Toast.makeText(Pendingapproval0.this,cz66, 500).show();
				showInput(cz66);
				break;
			case R.id.cz7:
				String cz77=(String) cz7.getText().toString();
				Toast.makeText(Pendingapproval0.this,cz77, 500).show();
				showInput(cz77);
				break;
			case R.id.cz8:
				String cz88=(String) cz8.getText().toString();
				Toast.makeText(Pendingapproval0.this,cz88, 500).show();
				showInput(cz88);
				break;
			case R.id.cz9:
				String cz99=(String) cz9.getText().toString();
				Toast.makeText(Pendingapproval0.this,cz99, 500).show();
				showInput(cz99);
				break;
			case R.id.cz10:
				String cz100=(String) cz10.getText().toString();
				Toast.makeText(Pendingapproval0.this,cz100, 500).show();
				showInput(cz100);
				break;
			case R.id.cz11:
				String cz0=(String)this.cz11.getText();//这个不知道为什么
				Toast.makeText(Pendingapproval0.this,cz0, 500).show();
				showInput(cz0);
				break;
			case R.id.cz12:
				String cz122=(String) cz12.getText().toString();
				Toast.makeText(Pendingapproval0.this,cz122, 500).show();
				showInput(cz122);
				break;
		}

	}

	public void showInput(String czname) {
		if (BaseActivity.gUser==null) {
			Toast.makeText(Pendingapproval0.this,getString(R.string.noLoginWait), 500).show();
		}else{
			cursor = db.rawQuery("select * from Pendingapprovalcz  where  GlxxId = "+glxxid+" and  Czname = "+"'"+czname+"'"+" ", new String[]{});
			while (cursor.moveToNext() ){
				strczId = cursor.getString(3);

			}
			intent=new Intent(Pendingapproval0.this,Pendingapproval1.class);
			intent.putExtra("glxxid", glxxid);
			intent.putExtra("strczId", strczId);
			intent.putExtra("czname", czname);
			intent.putExtra("id", id);
			intent.putStringArrayListExtra("shuzuid", (ArrayList<String>) shuzuid);
			startActivity(intent);
		}
	}

	public void More() {
		intent=new Intent(Pendingapproval0.this,Pendingapproval01.class);
		intent.putExtra("glxxid", glxxid);
		intent.putExtra("id", id);
		intent.putExtra("Informationlist", information);
		startActivity(intent);
	}

	public void Query() {
		//根据数据的状态  StateId查询显示到不同的  模块地方
		cursor = db.rawQuery("select * from Pendingapprovalcz  where       Type = 1  and  GlxxId = "+glxxid+"  ", new String[]{});
		while (cursor.moveToNext() ){
			String strId1 = cursor.getString(0);
			String strglxxId1 = cursor.getString(1);
			String strcztype1 = cursor.getString(2);
			String strczId1 = cursor.getString(3);
			String strczname1 = cursor.getString(4);
			typecz1.add(strczname1);   ////////////////////////////////////////////////////////////////////
		}

//        switch (typecz1.size()) {
//		case 1:
//			cz1.setText(typecz1.get(0));
//			cz1.setVisibility(View.VISIBLE);
//			break;
//		case 2:
//			cz1.setText(typecz1.get(0));
//			cz1.setVisibility(View.VISIBLE);
//			cz2.setText(typecz1.get(1));
//		    cz2.setVisibility(View.VISIBLE);
//
//			break;
//		case 3:
//			cz1.setText(typecz1.get(0));
//			cz1.setVisibility(View.VISIBLE);
//			cz2.setText(typecz1.get(1));
//		    cz2.setVisibility(View.VISIBLE);
//			cz3.setText(typecz1.get(2));
//		    cz3.setVisibility(View.VISIBLE);
//
//			break;
//		case 4:
//			cz1.setText(typecz1.get(0));
//			cz1.setVisibility(View.VISIBLE);
//			cz2.setText(typecz1.get(1));
//		    cz2.setVisibility(View.VISIBLE);
//			cz3.setText(typecz1.get(2));
//		    cz3.setVisibility(View.VISIBLE);
//			cz4.setText(typecz1.get(3));
//		    cz4.setVisibility(View.VISIBLE);
//
//			break;
//		case 5:
//			cz1.setText(typecz1.get(0));
//			cz1.setVisibility(View.VISIBLE);
//			cz2.setText(typecz1.get(1));
//		    cz2.setVisibility(View.VISIBLE);
//			cz3.setText(typecz1.get(2));
//		    cz3.setVisibility(View.VISIBLE);
//			cz4.setText(typecz1.get(3));
//		    cz4.setVisibility(View.VISIBLE);
//			cz5.setText(typecz1.get(4));
//		    cz5.setVisibility(View.VISIBLE);
//
//			break;
//		case 6:
//			cz1.setText(typecz1.get(0));
//			cz1.setVisibility(View.VISIBLE);
//			cz2.setText(typecz1.get(1));
//		    cz2.setVisibility(View.VISIBLE);
//			cz3.setText(typecz1.get(2));
//		    cz3.setVisibility(View.VISIBLE);
//			cz4.setText(typecz1.get(3));
//		    cz4.setVisibility(View.VISIBLE);
//			cz5.setText(typecz1.get(4));
//		    cz5.setVisibility(View.VISIBLE);
//			cz6.setText(typecz1.get(5));
//		    cz6.setVisibility(View.VISIBLE);
//
//			break;
//
//		default:
//			break;
//		}
		if (typecz1.size()==1) {
			cz1.setText(typecz1.get(0));
			cz1.setVisibility(View.VISIBLE);
		} else if(typecz1.size()==2){
			cz1.setText(typecz1.get(0));
			cz1.setVisibility(View.VISIBLE);
			cz2.setText(typecz1.get(1));
			cz2.setVisibility(View.VISIBLE);
		}else if(typecz1.size()==3){
			cz1.setText(typecz1.get(0));
			cz1.setVisibility(View.VISIBLE);
			cz2.setText(typecz1.get(1));
			cz2.setVisibility(View.VISIBLE);
			cz3.setText(typecz1.get(2));
			cz3.setVisibility(View.VISIBLE);
		}else if(typecz1.size()==4){
			cz1.setText(typecz1.get(0));
			cz1.setVisibility(View.VISIBLE);
			cz2.setText(typecz1.get(1));
			cz2.setVisibility(View.VISIBLE);
			cz3.setText(typecz1.get(2));
			cz3.setVisibility(View.VISIBLE);
			cz4.setText(typecz1.get(3));
			cz4.setVisibility(View.VISIBLE);
		}else if(typecz1.size()==5){
			cz1.setText(typecz1.get(0));
			cz1.setVisibility(View.VISIBLE);
			cz2.setText(typecz1.get(1));
			cz2.setVisibility(View.VISIBLE);
			cz3.setText(typecz1.get(2));
			cz3.setVisibility(View.VISIBLE);
			cz4.setText(typecz1.get(3));
			cz4.setVisibility(View.VISIBLE);
			cz5.setText(typecz1.get(4));
			cz5.setVisibility(View.VISIBLE);
		}else if(typecz1.size()==6){
			cz1.setText(typecz1.get(0));
			cz1.setVisibility(View.VISIBLE);
			cz2.setText(typecz1.get(1));
			cz2.setVisibility(View.VISIBLE);
			cz3.setText(typecz1.get(2));
			cz3.setVisibility(View.VISIBLE);
			cz4.setText(typecz1.get(3));
			cz4.setVisibility(View.VISIBLE);
			cz5.setText(typecz1.get(4));
			cz5.setVisibility(View.VISIBLE);
			cz6.setText(typecz1.get(5));
			cz6.setVisibility(View.VISIBLE);
		}



		cursor = db.rawQuery("select * from Pendingapprovalcz  where     Type = 2  and  GlxxId = "+glxxid+" ", new String[]{});
		while (cursor.moveToNext()) {
			String strId2 = cursor.getString(0);
			String strglxxId2 = cursor.getString(1);
			String strcztype2 = cursor.getString(2);
			String strczId2 = cursor.getString(3);
			String strczname2 = cursor.getString(4);
			typecz2.add(strczname2);
		}
		if (typecz2.size()==1) {
			cz7.setText(typecz2.get(0));
			cz7.setVisibility(View.VISIBLE);
		} else if(typecz2.size()==2){
			cz7.setText(typecz2.get(0));
			cz7.setVisibility(View.VISIBLE);
			cz8.setText(typecz2.get(1));
			cz8.setVisibility(View.VISIBLE);
		}else if(typecz2.size()==3){
			cz7.setText(typecz2.get(0));
			cz7.setVisibility(View.VISIBLE);
			cz8.setText(typecz2.get(1));
			cz8.setVisibility(View.VISIBLE);
			cz9.setText(typecz2.get(2));
			cz9.setVisibility(View.VISIBLE);
		}else if(typecz2.size()==4){
			cz7.setText(typecz2.get(0));
			cz7.setVisibility(View.VISIBLE);
			cz8.setText(typecz2.get(1));
			cz8.setVisibility(View.VISIBLE);
			cz9.setText(typecz2.get(2));
			cz9.setVisibility(View.VISIBLE);
			cz10.setText(typecz2.get(3));
			cz10.setVisibility(View.VISIBLE);
		}else if(typecz2.size()==5){
			cz7.setText(typecz2.get(0));
			cz7.setVisibility(View.VISIBLE);
			cz8.setText(typecz2.get(1));
			cz8.setVisibility(View.VISIBLE);
			cz9.setText(typecz2.get(2));
			cz9.setVisibility(View.VISIBLE);
			cz10.setText(typecz2.get(3));
			cz10.setVisibility(View.VISIBLE);
			cz11.setText(typecz2.get(4));
			cz11.setVisibility(View.VISIBLE);
		}else if(typecz2.size()==6){
			cz7.setText(typecz2.get(0));
			cz7.setVisibility(View.VISIBLE);
			cz8.setText(typecz2.get(1));
			cz8.setVisibility(View.VISIBLE);
			cz9.setText(typecz2.get(2));
			cz9.setVisibility(View.VISIBLE);
			cz10.setText(typecz2.get(3));
			cz10.setVisibility(View.VISIBLE);
			cz11.setText(typecz2.get(4));
			cz11.setVisibility(View.VISIBLE);
			cz12.setText(typecz2.get(5));
			cz12.setVisibility(View.VISIBLE);
		}
	}


	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		ActivityHelper.biaozhi=null;
		ActivityHelper.Bitmaps=null;
		ActivityHelper.information.strSpare2=null;
		ActivityHelper.filePaths=null;
		super.onRestart();
	}
	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
