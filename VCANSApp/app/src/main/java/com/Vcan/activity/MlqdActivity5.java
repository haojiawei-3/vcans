package com.Vcan.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.MlqdProcessor51;
import com.vcans.Processor.MlqdUploadcacheProcessor;
import com.vcans.Processor.mpsbProcessor;
import com.vcans.adapter.LangyaAdapter;
import com.vcans.model.CustomerCollect;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.SildingFinishLayout;
import com.vcans.tool.SildingFinishLayout.OnSildingFinishListener;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
/**
 * 这个地方真的很痛苦，痛苦，痛苦。
 *
 */
public class MlqdActivity5 extends BaseActivity {
	public static MlqdActivity5 mlqdActivity5 = null;
	public MlqdUploadcacheProcessor mlqdUploadcache;
	public StickyListHeadersListView  list,list1;
	public String mark ,mark1 ,khname, linkman, Phone, addr, khcode, ypcode ,price, number, category, standby2 ,standby3,strId;
	public LangyaAdapter  langyaAdapter;
	public CustomerCollect customerCollect;
	public List<CustomerCollect>  customerCollectlist;
	public ArrayList<String> Nid,getkhcode,Yid;
	public SQLiteDatabase	db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);
	public Cursor cursor;
	public Button qd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mlqd_activity5);
		mlqdActivity5=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		list = (StickyListHeadersListView) findViewById(R.id.list);

		list.setEmptyView(findViewById(R.id.img));
		qd = (Button) findViewById(R.id.qd);
		Collect();


		list.setOnItemClickListener(new OnPlanItemClick());
		list.setOnItemLongClickListener(new OnPlanItemLongClick());


		langyaAdapter = new LangyaAdapter(this, customerCollectlist);
		list.setAdapter(langyaAdapter);

		qd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				getNID();
				getYID();

				if (Nid.size()!=0) { //新客户进行上传  变成已有客户

					for (int i = 0; i < Nid.size(); i++) {

						CustomerCollect	customerCollect=getCustomerCollect(Nid.get(i));
						if (!customerCollect.standby2.equals("N")) {
							SendParam sendParam = new SendParam();
							sendParam.parent =MlqdActivity5.this;
							sendParam.processor =new mpsbProcessor(new String[]{customerCollect.khcode,customerCollect.khname,customerCollect.linkman,customerCollect.Phone,customerCollect.addr,""});
							getDataTrunsfer().beginUploadText(sendParam);
						}else {
							ActivityHelper.ToastShow(MlqdActivity5.this, "发生错误....");
						}

					}

				}else if (Yid.size()!=0) {
					ActivityHelper.biaozhi="200";//给没有查询到编号的    的客户一个入口  可以忽略错误进行上传
					for (int i = 0; i < Yid.size(); i++) {
						CustomerCollect	customerCollect=getCustomerCollect(Yid.get(i));
						if (!customerCollect.mark1.equals("Y")) {
							SendParam sendParam = new SendParam();
							sendParam.parent = MlqdActivity5.this;
							sendParam.szData=new String[]{customerCollect.khcode};
							sendParam.processor = new MlqdProcessor51(customerCollect.khcode);
							getDataTrunsfer().request(sendParam);
						}else {
//								    SendParam sendParam = new SendParam();
//						 		    sendParam.parent = MlqdActivity5.this;
//						 		    sendParam.szData=new String[]{customerCollect.khcode};
//						 		    sendParam.processor = new MlqdProcessor51(customerCollect.khcode);
//						 		    getDataTrunsfer().request(sendParam);
							ActivityHelper.ToastShow(MlqdActivity5.this, "发生错误...");
						}

					}
				}else {
					ActivityHelper.ToastShow(MlqdActivity5.this, "没有可以上传的数据");
				}



			}
		});

		SildingFinishLayout();
	}

	public void SildingFinishLayout(){
		SildingFinishLayout mSildingFinishLayout = (SildingFinishLayout) findViewById(R.id.sildingFinishLayout);
		mSildingFinishLayout.setOnSildingFinishListener(new OnSildingFinishListener() {

			@Override
			public void onSildingFinish() {
				finish();
			}
		});

		mSildingFinishLayout.setTouchView(mSildingFinishLayout);
		//return activity;
	}

	private void updateData() {

		if (langyaAdapter != null && customerCollectlist != null) {

			langyaAdapter.notifyDataSetChanged();
		}
	}



	private class OnPlanItemClick implements AdapterView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			CustomerCollect customerCollect = (CustomerCollect) parent.getAdapter().getItem( position);

		}
	}

	private class OnPlanItemLongClick implements AdapterView.OnItemLongClickListener {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

			CustomerCollect customerCollect = customerCollectlist.get(position);

			if (ActivityHelper.LangyaAdapterbz) {
				db.execSQL("delete from CustomerCollect  where khcode =? ",   new Object[]{customerCollect.khcode});
				Collect();
				ActivityHelper.ToastShow(MlqdActivity5.this,"("+customerCollect.khcode+")全部删除成功");
				langyaAdapter.setData(customerCollectlist);
			}else {
				customerCollectlist.remove(customerCollect);
				db.execSQL("delete from CustomerCollect  where TPId =? ",   new Object[]{customerCollect.id});
				ActivityHelper.ToastShow(MlqdActivity5.this, "("+customerCollect.ypcode+")单笔删除成功");
				updateData();
			}
			ActivityHelper.LangyaAdapterbz=false;
			return true;
		}
	}

	public List<CustomerCollect> Collect(){
		customerCollectlist = new ArrayList<CustomerCollect>();
		String	 sql="select * from CustomerCollect ";
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			strId = cursor.getString(0);
			mark = cursor.getString(1);
			mark1 = cursor.getString(2);
			khname = cursor.getString(3);
			linkman = cursor.getString(4);
			Phone = cursor.getString(5);
			addr = cursor.getString(6);
			khcode = cursor.getString(7);
			ypcode = cursor.getString(8);
			price = cursor.getString(9);
			number = cursor.getString(10);
			//这是3个备用字段
			//我要根据这个分类
			//2017.06.10  改
			category = cursor.getString(11);
			standby2 = cursor.getString(12);
			standby3 = cursor.getString(13);
			if (category.equals("")) {
				category="0000";
			}else if (num(category)) {
				category = cursor.getString(11);
			}else {
				category="0001";
			}


			customerCollect = new CustomerCollect(strId,mark,mark1,khname,linkman,Phone,addr,khcode,ypcode,price,number,category,standby2,standby3);
			customerCollectlist.add(customerCollect);
		}
		//这里实现一下排序不然StickyListHeadersListView的功能 不能适应我们的需求
		Collections.sort(customerCollectlist);

		return customerCollectlist;
	}

	//判断是不是  数字
	public boolean num(String s){

		try {

			int num=Integer.valueOf(s);//把字符串强制转换为数字
			return true;//如果是数字，返回True
		} catch (Exception e) {
			return false;//如果抛出异常，返回False
		}

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

	public ArrayList<String> getNID(){
		Nid=new ArrayList<String>();
		String	 sql="select * from CustomerCollect where  mark = "+"'N'"+" ";
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			String	 strId = cursor.getString(0);
			Nid.add(strId) ;
		}


		return Nid;
	}

	public ArrayList<String> getkhcode(){
		getkhcode=new ArrayList<String>();
		String	 sql="select * from CustomerCollect  ";
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			String	 strId = cursor.getString(7);
			getkhcode.add(strId) ;
		}


		return getkhcode;
	}

	public CustomerCollect getCustomerCollect(String  id){
		String	 sql="select * from CustomerCollect  where  TPId  =  "+"'"+id+"'"+"  " ;		//
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			strId = cursor.getString(0);
			mark = cursor.getString(1);
			mark1 = cursor.getString(2);
			khname = cursor.getString(3);
			linkman = cursor.getString(4);
			Phone = cursor.getString(5);
			addr = cursor.getString(6);
			khcode = cursor.getString(7);
			ypcode = cursor.getString(8);
			price = cursor.getString(9);
			number = cursor.getString(10);
			category = cursor.getString(11);
			standby2 = cursor.getString(12);
			standby3 = cursor.getString(13);
			if (category.equals("")){
				category="0000";
			}


		}
		customerCollect = new CustomerCollect(strId,mark,mark1,khname,linkman,Phone,addr,khcode,ypcode,price,number,category,standby2,standby3);

		return customerCollect;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		ActivityHelper.biaozhi=null;
		super.onDestroy();

	}


	@Override
	public void processMessage(int msgId, String msg) {//根据指令的  配合完成相应的操作
		// TODO Auto-generated method stub
		if (msgId==1000) {
			ActivityHelper.biaozhi="200";
			//进行新用户上传
			for (int i = 0; i < Nid.size(); i++) {

				CustomerCollect	customerCollect=getCustomerCollect(Nid.get(i));
				if (!customerCollect.standby2.equals("N")) {
					SendParam sendParam = new SendParam();
					sendParam.parent =MlqdActivity5.this;
					sendParam.processor =new mpsbProcessor(new String[]{customerCollect.khcode,customerCollect.khname,customerCollect.linkman,customerCollect.Phone,customerCollect.addr,""});
					getDataTrunsfer().beginUploadText(sendParam);
				}

			}
			getYID();
			for (int i = 0; i < Yid.size(); i++) {
				CustomerCollect	customerCollect=getCustomerCollect(Yid.get(i));
				if (!customerCollect.mark1.equals("Y")) {
					SendParam sendParam = new SendParam();
					sendParam.parent = MlqdActivity5.this;
					sendParam.szData=new String[]{customerCollect.khcode};
					sendParam.processor = new MlqdProcessor51(customerCollect.khcode);
					getDataTrunsfer().request(sendParam);
				}

			}

		}else if(msgId==500) {

			mlqdUploadcache=new MlqdUploadcacheProcessor();
			mlqdUploadcache.DisplayMlqdInfo(getYID());
			SendParam sendParam = new SendParam();
			sendParam.parent =MlqdActivity5.this;
			sendParam.bSendEndNotify=true;
			sendParam.processor = mlqdUploadcache;
			getDataTrunsfer().beginUploadFile(sendParam);

		}else if(msgId==600) {
			ActivityHelper.biaozhi="200";
			getYID();
			for (int i = 0; i < Yid.size(); i++) {
				CustomerCollect	customerCollect=getCustomerCollect(Yid.get(i));
				if (!customerCollect.mark1.equals("Y")) {
					SendParam sendParam = new SendParam();
					sendParam.parent = MlqdActivity5.this;
					sendParam.szData=new String[]{customerCollect.khcode};
					sendParam.processor = new MlqdProcessor51(customerCollect.khcode);
					getDataTrunsfer().request(sendParam);
				}

			}
			processMessage(500,"");

		}

	}



}
