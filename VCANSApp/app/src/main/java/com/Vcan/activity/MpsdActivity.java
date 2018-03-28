package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import cn.sharp.android.ncr.StaticRecFromCamera;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.MpsbUploadProcessor;
import com.vcans.adapter.MPAdapter;
import com.vcans.model.Mpsbinfo;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 名片识读
 *  @since 2016 07
 * @author hjw
 */
public class MpsdActivity extends BaseActivity  {
//	private GridLayoutManager mLayoutManager;
	private RecyclerView.LayoutManager mLayoutManager;
	RecyclerView recyclerview;
	List<Mpsbinfo> Mpsbinfolist=null;
	ImageButton btnBack;
	MpsbUploadProcessor mpsbUploadProcessor=null;
	SwipeRefreshLayout swipeRefreshLayout;
	String mstrDataId;
	Cursor cursor;
	SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);
	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	MPAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mpsj);
		this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
		this.<ImageButton>RegOnClickEvent(R.id.xinzeng,"xinzeng");
		this.<ImageButton>RegOnClickEvent(R.id.tonbu,"tonbu");
		this.<ImageButton>RegOnClickEvent(R.id.qingkong,"qingkong");
		//mListView=(ListView)findViewById(R.id.mpsdlist);

		recyclerview=(RecyclerView)findViewById(R.id.recycler);
		//mLayoutManager=new GridLayoutManager(MpsdActivity.this,3,GridLayoutManager.HORIZONTAL,false);//设置为一个3列的纵向网格布局
		 mLayoutManager = new LinearLayoutManager(MpsdActivity.this, LinearLayoutManager.VERTICAL, false);

        recyclerview.setLayoutManager(mLayoutManager);


		mpsbUploadProcessor =new MpsbUploadProcessor("0");
		Mpsbinfolist = new ArrayList<Mpsbinfo>();
		swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
		swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
		Query();
		swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
													@Override
													public void onRefresh() {
														new Handler().postDelayed(new Runnable() {
															@Override
															public void run() {
																Mpsbinfolist.clear();
																Query();
																mAdapter.notifyDataSetChanged();
																swipeRefreshLayout.setRefreshing(false);
															}
														}, 4000);
													}
												});
		mAdapter = new MPAdapter(MpsdActivity.this,Mpsbinfolist);
		recyclerview.setAdapter(mAdapter);



		mAdapter.setOnItemClickListener(new MPAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				Intent intent = new Intent(MpsdActivity.this,MpsbxqActivity.class);
				intent.putExtra("company",Mpsbinfolist.get(position).strcompany);
				intent.putExtra("address",Mpsbinfolist.get(position).straddress);
				intent.putExtra("email",Mpsbinfolist.get(position).stremail);
				intent.putExtra("fax",Mpsbinfolist.get(position).strfax);
				intent.putExtra("ImgPath",Mpsbinfolist.get(position).strImgPath);
				intent.putExtra("linkname",Mpsbinfolist.get(position).strlinkname);
				intent.putExtra("note",Mpsbinfolist.get(position).strnote);
				intent.putExtra("phone1",Mpsbinfolist.get(position).strphone1);
				intent.putExtra("phone2",Mpsbinfolist.get(position).strphone2);
				intent.putExtra("position",Mpsbinfolist.get(position).strposition);
				intent.putExtra("www",Mpsbinfolist.get(position).strwww);
				intent.putExtra("id",Mpsbinfolist.get(position).id);
				startActivity(intent);
			}

			@Override
			public void onItemLongClick(View view, int position) {

				onDelete(Mpsbinfolist.get(position).id);
			}
		});
	}
	/**
	 * 名片识读
	 * @param index
	 */
	public final OnItemClickListener listClickListener=new OnItemClickListener(){

		public void onItemClick(AdapterView<?> parent, View view, int position,
								long id) {


			Intent intent = new Intent(MpsdActivity.this,MpsbxqActivity.class);
			intent.putExtra("company",Mpsbinfolist.get(position).strcompany);
			intent.putExtra("address",Mpsbinfolist.get(position).straddress);
			intent.putExtra("email",Mpsbinfolist.get(position).stremail);
			intent.putExtra("fax",Mpsbinfolist.get(position).strfax);
			intent.putExtra("ImgPath",Mpsbinfolist.get(position).strImgPath);
			intent.putExtra("linkname",Mpsbinfolist.get(position).strlinkname);
			intent.putExtra("note",Mpsbinfolist.get(position).strnote);
			intent.putExtra("phone1",Mpsbinfolist.get(position).strphone1);
			intent.putExtra("phone2",Mpsbinfolist.get(position).strphone2);
			intent.putExtra("position",Mpsbinfolist.get(position).strposition);
			intent.putExtra("www",Mpsbinfolist.get(position).strwww);
			intent.putExtra("id",Mpsbinfolist.get(position).id);
			startActivity(intent);
		}
	};






	/**
	 * 名片识读进入新增
	 * @param
	 */
	public void xinzeng(){
		Intent intent = new Intent(this,StaticRecFromCamera.class);
		intent.putExtra("id","0");
		startActivity(intent);
		finish();
	}


	/**
	 * 名片识读进入同步
	 * @param
	 */
	public void tonbu(){
		new AlertDialog.Builder(this).setTitle(getString(R.string.askQuittt))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						//完成同步上传动作
						mpsbUploadProcessor.DisplayMpsbInfoo();
						onUpload();
					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();

	}

	public void onUpload()
	{
		if(Mpsbinfolist.size()!=0){
			SendParam sendParam = new SendParam();
			sendParam.parent =this;
			sendParam.bSendEndNotify=true;
			sendParam.processor = mpsbUploadProcessor;
			getDataTrunsfer().beginUploadFile(sendParam);
		}
		else
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.noData));
		}
	}

	/**
	 * 名片识读清空数据
	 * @param
	 */
	public void qingkong(){
		if(Mpsbinfolist.size()!=0){
			new AlertDialog.Builder(this).setTitle(getString(R.string.askQuitt))
					.setIcon(android.R.drawable.ic_dialog_info)
					.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							// 点击“确认”后的操作

							mpsbUploadProcessor.ClearMpsdInfo();
							Mpsbinfolist.clear();
							mAdapter.notifyDataSetChanged();

						}
					})
					.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							// 点击“返回”后的操作,这里不设置没有任何操作
						}
					}).show();
		}
		else
		{
			ActivityHelper.showDialog(this,"错误",getString(R.string.noData));
		}
	}




	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		System.out.println("onRestart");
		super.onRestart();
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		System.out.println("onPause");
		super.onPause();
	}


	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		Mpsbinfolist.clear();
		Query();
		mAdapter.notifyDataSetChanged();
		super.onPostResume();
	}


	/**
	 * 名片识读删除数据
	 * @param
	 */
	public void onDelete(final String mstrDataId)
	{
//		if(mListView.getCount()<1)
//		{
//			return ;
//		}

		new AlertDialog.Builder(this).setTitle(getString(R.string.askDelete))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						if(!mstrDataId.equals(""))
						{
							Mpsbinfolist.clear();
							mpsbUploadProcessor.DeleteMpsdInfo(mstrDataId);
							Query();
							mAdapter.notifyDataSetChanged();
						}
					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
	}


	// 查询数据
	public void Query(){

		//company, linkname ,position ,phone1, phone2, fax ,address , www ,email ,note;
		String sql="select * from  Mpsb ";
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			String id = cursor.getString(0);
			String company = cursor.getString(1);
			String linkname = cursor.getString(2);
			String position = cursor.getString(3);
			String phone1 = cursor.getString(4);
			String phone2 = cursor.getString(5);
			String fax = cursor.getString(6);
			String address = cursor.getString(7);
			String www = cursor.getString(8);
			String email = cursor.getString(9);
			String note = cursor.getString(10);
			String ImgPath = cursor.getString(11);
			Mpsbinfo mpsb = new Mpsbinfo(id, company, linkname,position, phone1, phone2,fax,address, www, email, note, ImgPath) ;
			Mpsbinfolist.add(mpsb);
		}

	}
	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub


		if (msgId==200) {
			Mpsbinfolist.clear();
			Query();
			mAdapter.notifyDataSetChanged();
		}
		switch (msgId) {

			default:
				int nSize = ActivityHelper.lstActivities.size();
				if (nSize > 0) {
					BaseActivity topActivity = null;

					for (int i = nSize; i > 0; i--) {
						topActivity = ActivityHelper.lstActivities.get(i - 1);
						if (topActivity != null) {
							topActivity.ShowNetStatus(msgId);
							break;
						}
					}
				}
				break;

		}

	}


}

