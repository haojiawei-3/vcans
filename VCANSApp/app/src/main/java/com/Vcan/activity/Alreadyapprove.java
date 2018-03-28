package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.vcans.Processor.BaseActivity;
import com.vcans.adapter.NotapprovedAdapter;
import com.vcans.model.Information;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.playListview;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
/**
 * 我已审批    Alreadyapprove   Alreadyapprove1
 * @author vcans
 *
 */
public class Alreadyapprove extends BaseActivity{
	private int mLastClickId=-1;
	private long mLastClickTime=0;
	List<Information>  Informationlist;
	SQLiteDatabase db;
	private TextView mSelectedCount;
	Information information;
	ListView myview;
	List<String> list;
	NotapprovedAdapter adapter;
	Cursor cursor;
	LinearLayout LinearLayout;
	List<String> shuzuid,shuzuid1;
	LinearLayout LinearLayout1;
	long[] ids;
	Button dlt,caoz;
	ModeCallback mCallback;
	playListview playListview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_alreadyapprove);
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		myview=(ListView)findViewById(R.id.splist);
		playListview = (playListview) findViewById(R.id.refreshable_view);
		myview.setEmptyView(findViewById(R.id.img));
		LinearLayout=(LinearLayout)findViewById(R.id.Linear);
		Informationlist = new ArrayList<Information>();
		shuzuid=new ArrayList<String>();
		list=new ArrayList<String>();
		LinearLayout1=(LinearLayout)findViewById(R.id.include01);
		mCallback = new ModeCallback();
		dlt=(Button)findViewById(R.id.dlt);
		dlt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				onDelete();
				list.clear();
			}
		});
		caoz=(Button)findViewById(R.id.caoz);
		caoz.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Alreadyapprove.this,Alreadyapprove1.class);
				intent.putExtra("shuzuid", shuzuid.get(0));
				startActivity(intent);

			}
		});




		playListview.setOnRefreshListener(new com.vcans.tool.playListview.PullToRefreshListener() {

			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
					// handler.sendEmptyMessage(1);//发送消息

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				playListview.finishRefreshing();
			}
		}, 0);


		db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);
		Query();
		adapter = new NotapprovedAdapter(Alreadyapprove.this, Informationlist) ;//这里共用一个adapter
		myview.setAdapter(adapter);
		myview.setOnItemClickListener(listClickListener);
		myview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		myview.setMultiChoiceModeListener(mCallback);
	}


	private class ModeCallback implements ListView.MultiChoiceModeListener {
		private View mMultiSelectActionBarView;


		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.layout.multi_select_menu, menu);
			if (mMultiSelectActionBarView == null) {
				mMultiSelectActionBarView = LayoutInflater.from(Alreadyapprove.this).inflate(R.layout.list_multi_select_actionbar, null);

				mSelectedCount =(TextView)mMultiSelectActionBarView.findViewById(R.id.selected_conv_count);
			}
			mode.setCustomView(mMultiSelectActionBarView);
			((TextView)mMultiSelectActionBarView.findViewById(R.id.title)).setText("已选择:");
			return true;
		}
		@Override
		public boolean onActionItemClicked(ActionMode arg0, MenuItem item) {
			switch (item.getItemId()) {
				case R.id.action_slelect:
					if(myview.getCheckedItemCount() == adapter.getCount()){
						unSelectedAll();
					}else{
						selectedAll();
					}
					adapter.notifyDataSetChanged();
					break;
				default:
					break;
			}
			return true;
		}
		@Override
		public void onDestroyActionMode(ActionMode arg0) {
			// TODO Auto-generated method stub
			list.clear();
			LinearLayout1.setVisibility(View.VISIBLE);
			LinearLayout.setVisibility(View.GONE);
		}

		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
			if (mMultiSelectActionBarView == null) {
				ViewGroup v = (ViewGroup)LayoutInflater.from(Alreadyapprove.this).inflate(R.layout.list_multi_select_actionbar, null);
				mode.setCustomView(v);
				mSelectedCount = (TextView)v.findViewById(R.id.selected_conv_count);
			}
			//更新菜单的状态
			MenuItem mItem = menu.findItem(R.id.action_slelect);
			if(myview.getCheckedItemCount() == adapter.getCount()){
				mItem.setTitle(R.string.action_deselect_all);
			}else{
				mItem.setTitle(R.string.action_select_all);
			}
			return true;
		}

		@Override
		public void onItemCheckedStateChanged(ActionMode mode, int position,long id, boolean checked) {
			mode.invalidate();
			mSelectedCount.setText(Integer.toString(myview.getCheckedItemCount()));
			LinearLayout1.setVisibility(View.GONE);
			adapter.notifyDataSetChanged();
			String k=position+"";
			String v=checked+"";
			shuzuid1= zhi(k, v);
			Informationlist=adapter.getData();
			shuzuid.clear();
			for (int i = 0; i < shuzuid1.size(); i++) {
				System.out.println(shuzuid1.get(i));
				int ps=Integer.parseInt(shuzuid1.get(i));
				String id1=Informationlist.get(ps).strId;
				System.out.println(ps+"456456");
				shuzuid.add(id1);

			}
			if (shuzuid.size()>0) {
				LinearLayout.setVisibility(View.VISIBLE);
				if (shuzuid.size()>1) {
					caoz.setVisibility(View.GONE);
					dlt.setText("批量删除");
				}else {
					caoz.setVisibility(View.VISIBLE);
					caoz.setText("查看");
					dlt.setText("删除");
				}
			}else {
				LinearLayout.setVisibility(View.GONE);
			}

		}

	}



	public List<String> zhi(String k,String v){
		if (v.equals("true")) {
			list.add(k);
		}else {
			list.remove(k);
		}
		list = new ArrayList(new HashSet(list));
		return list;
	}













	public final OnItemClickListener listClickListener=new OnItemClickListener(){

		public void onItemClick(AdapterView<?> parent, View view, int position,
								long id) {


			// 如果是双击,1秒内连续点击判断为双击
			if(position==mLastClickId && (Math.abs(mLastClickTime-System.currentTimeMillis()) < 1000))
			{
				mLastClickId = -1;
				mLastClickTime = 0;
				Log.e("TAG", "我被双击了"+Informationlist.get(position).strId);

			}
			else
			{
				Log.e("TAG", "我被单击了"+Informationlist.get(position).strId);
				Intent intent = new Intent(Alreadyapprove.this,Alreadyapprove1.class);
				information=new Information();
				information.setStrcontent(Informationlist.get(position).strcontent);
				information.setStrxxId(Informationlist.get(position).strxxId);
				information.setStrId(Informationlist.get(position).strId);
				information.setStrinitiator(Informationlist.get(position).strinitiator);
				information.setStrmoduletype(Informationlist.get(position).strmoduletype);
				information.setStrmoduletypeId(Informationlist.get(position).strmoduletypeId);
				information.setStrodd(Informationlist.get(position).strodd);
				information.setStroddId(Informationlist.get(position).stroddId);
				information.setStrstate(Informationlist.get(position).strstate);
				information.setStrstateId(Informationlist.get(position).strstateId);
				information.setStrthemer(Informationlist.get(position).strthemer);
				information.setStrtype(Informationlist.get(position).strtype);
				information.setStrmodulename(Informationlist.get(position).strmodulename);
				information.setStrdate(Informationlist.get(position).strdate);
				information.setStrSpare2(Informationlist.get(position).strSpare2);
				information.setStrSpare4(Informationlist.get(position).strSpare4);
				intent.putExtra("Informationlist", information);
				startActivity(intent);
				mLastClickId =position;
				mLastClickTime = System.currentTimeMillis();
			}
		}
	};

	@Override
	protected void onResume() {



		super.onResume();

		list.clear();

	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		Informationlist.clear();
		Query();
		adapter.notifyDataSetChanged();
		Log.e("TAG", "onRestart");
		super.onRestart();
	}

	public void selectedAll(){
		for(int i= 0; i< adapter.getCount(); i++){
			myview.setItemChecked(i, true);
		}
	}


	public void onDelete()
	{
		if(shuzuid.size()<1)
		{
			Toast.makeText(Alreadyapprove.this, "选择数据", 500).show();
		}

		new AlertDialog.Builder(this).setTitle(getString(R.string.askDelete))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作

						Informationlist.clear();
						for (int i = 0; i < shuzuid.size(); i++) {
							String s=shuzuid.get(i);
							DeleteById(s);
						}

						Query();
						adapter.notifyDataSetChanged();
						unSelectedAll();
						mSelectedCount.setText(Integer.toString(myview.getCheckedItemCount()));

					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {

					}
				}).show();
	}
	public void unSelectedAll(){
		myview.clearChoices();
		if (mSelectedCount!=null) {
			mSelectedCount.setText(Integer.toString(myview.getCheckedItemCount()));
		}
		LinearLayout.setVisibility(View.GONE);
		list.clear();

	}

	public int DeleteById(String strIds)
	{
		//DELETE FROM Pendingapproval WHERE TPId
		db.execSQL("delete from Pendingapproval where TPId=?",   new Object[]{strIds});
		return mLastClickId;
	}


	public void Query() {
		//根据数据的状态  StateId查询显示到不同的  模块地方   这里的  2  代表是哪一个模块
		cursor = db.rawQuery("select * from Pendingapproval where   Type = 1  and Spare1 = 2  order by TPId  desc", new String[]{});
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
		}
		LinearLayout.setVisibility(View.GONE);
	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
