package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPPBDownGoodsProcessor;
import com.vcans.Processor.DownloadProcessor;
import com.vcans.Processor.PendingapprovalProcessor1;
import com.vcans.Processor.PendingapprovalProcessor2;
import com.vcans.adapter.NotapprovedAdapter;
import com.vcans.model.Information;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.MorePopWindow04;
import com.vcans.tool.playListview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.AlertDialog;
import android.content.Context;
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
import android.view.View.OnLongClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * 待我审批
 * @author vcans
 *
 */
public class Pendingapproval extends BaseActivity {
	private int mLastClickId=-1;
	private long mLastClickTime=0;
	private TextView mSelectedCount;
	public final static int FUZHU8_DONE=0;
	private DownloadProcessor downWork = null;
	public static Pendingapproval pendingapproval = null;
	ListView view;
	MorePopWindow04 morePopWindow04;
	DPPBDownGoodsProcessor downGoods=null;
	PendingapprovalProcessor1 downGoodss=null;
	PendingapprovalProcessor2 downGoodsss=null;
	Button btnSearchh,dlt,caoz;
	ImageButton btnSearch11,btnSearch;
	String TPId = "TPId =";
	String TPId1 = " or TPId =";
	RelativeLayout lay;
	List<String> list;
	EditText txtContent;
	Spinner spinner1,spinner2,spinner3;
	Cursor cursor;
	SQLiteDatabase db;
	List<Information> Informationlist;
	Information information;
	NotapprovedAdapter adapter;
	String strxxId,NotifyId;
	LinearLayout LinearLayout;
	RelativeLayout LinearLayout1;
	HorizontalScrollView Layout3;
	List<String> typecz1,typecz2,typecz3,shuzuid,weiyi,weiyi1,shuzuid1;
	boolean s=true;
	private PopupWindow mPopupWindwo;
	ModeCallback mCallback;
	playListview playListview;

	private Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			//更新UI
			switch (msg.what)
			{
				case 1:
					Informationlist.clear();
					Resume();
					adapter.setData(Informationlist);
					if (mSelectedCount!=null) {
						mSelectedCount.setText(Integer.toString(view.getCheckedItemCount()));
					}
					break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pendingapproval);
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.tvActtitle,"pullto");
		// SildingFinishLayout();
		pendingapproval=this;
		view=(ListView)findViewById(R.id.lvProdct);

		this.<ImageView> RegOnClickEvent(R.id.imgNetStatus, "onTip");
		playListview = (playListview) findViewById(R.id.refreshable_view);
		view.setEmptyView(findViewById(R.id.img));
		//Layout1=(LinearLayout)findViewById(R.id.Layout1);
		LinearLayout1=(RelativeLayout)findViewById(R.id.LinearLayout);
		mCallback = new ModeCallback();
		setListItemClickMethod("onGoodsItemClick","onGoodsItemDbClick");
		downGoodss=new PendingapprovalProcessor1();
		downGoodsss =new PendingapprovalProcessor2();
		txtContent=(EditText)findViewById(R.id.txtContent);
//		spinner1=(Spinner)findViewById(R.id.Spinner1);
//		spinner2=(Spinner)findViewById(R.id.Spinner2);
//		spinner3=(Spinner)findViewById(R.id.Spinner3);
		//ss=(Button)findViewById(R.id.ss);
		btnSearch11=(ImageButton)findViewById(R.id.btnSearch11);
		typecz1=new ArrayList<String>();
		typecz2=new ArrayList<String>();
		typecz3=new ArrayList<String>();
		shuzuid=new ArrayList<String>();
		shuzuid1=new ArrayList<String>();
		weiyi=new ArrayList<String>();
		weiyi1=new ArrayList<String>();
		list=new ArrayList<String>();
		btnSearch=(ImageButton)findViewById(R.id.btnSearch);
		LinearLayout=(LinearLayout)findViewById(R.id.Linear);
		dlt=(Button)findViewById(R.id.dlt);
		caoz=(Button)findViewById(R.id.caoz);
		playListview.setOnRefreshListener(new com.vcans.tool.playListview.PullToRefreshListener() {

			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);
					SendParam sendParam = new SendParam();
					sendParam.parent = Pendingapproval.this;
					sendParam.processor = downGoodss;
					getDataTrunsfer().request(sendParam);

//
					handler.sendEmptyMessage(1);//发送消息

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				playListview.finishRefreshing();
			}
		}, 0);
		dlt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				onDelete();



			}
		});
		dlt.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View arg0) {
				// TODO Auto-generated method stub
				//方便自己全选操作删除
				selectedAll();
				return true;
			}
		});
		caoz.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//unSelectedAll();
				biaoz();
				if (weiyi.size()==1&&weiyi1.size()==1) {
					Intent intent = new Intent(Pendingapproval.this,Pendingapproval0.class);
					intent.putStringArrayListExtra("shuzuid", (ArrayList<String>) shuzuid);
					intent.putExtra("bzid", "2");//作为标准看看你多选模式还好直接进入
					startActivity(intent);
				}else {
					Toast.makeText(Pendingapproval.this, "当前状态不一致,禁止批量操作", 500).show();
				}

			}

		});
		btnSearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				NotifyId = txtContent.getText().toString().trim();
				if (!NotifyId.equals("")) {
					ActivityHelper.gToupei.strOutNotifyId=NotifyId;
					Informationlist.clear();
					Query1();
					unSelectedAll();
					adapter.setData(Informationlist);
					InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
					LinearLayout.setVisibility(View.GONE);
				} else {
					Toast.makeText(Pendingapproval.this, "请输入要查询的数据", 500).show();
				}

			}
		});
		btnSearch.setOnLongClickListener(new OnLongClickListener() {
			//查看全部
			@Override
			public boolean onLongClick(View arg0) {
				Informationlist.clear();
				Query();
				adapter.setData(Informationlist);
				int sun=Informationlist.size();
				Toast.makeText(Pendingapproval.this, "为您查询到"+sun+"条相关数据", 500).show();
				return true;
			}
		});
		btnSearch11.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				morePopWindow04 = new MorePopWindow04(Pendingapproval.this,adapter);
				morePopWindow04.showPopupWindow(btnSearch11);
				unSelectedAll();
				list.clear();
				LinearLayout.setVisibility(View.GONE);
			}
		});
		information=new Information();
		Informationlist = new ArrayList<Information>();

		db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);

		adapter = new NotapprovedAdapter(Pendingapproval.this,  Informationlist);
		view.setAdapter(adapter);
		view.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		view.setMultiChoiceModeListener(mCallback);
		view.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position,long id) {

				Intent intent = new Intent(Pendingapproval.this,Pendingapproval0.class);
				Informationlist=adapter.getData();
				information.setStrcontent(Informationlist.get(position).strcontent);
				information.setStrId(Informationlist.get(position).strId);
				information.setStrxxId(Informationlist.get(position).strxxId);
				information.setStrinitiator(Informationlist.get(position).strinitiator);
				information.setStrmoduletype(Informationlist.get(position).strmoduletype);
				information.setStrmodulename(Informationlist.get(position).strmodulename);
				information.setStrmoduletypeId(Informationlist.get(position).strmoduletypeId);
				information.setStrodd(Informationlist.get(position).strodd);
				information.setStroddId(Informationlist.get(position).stroddId);
				information.setStrstate(Informationlist.get(position).strstate);
				information.setStrstateId(Informationlist.get(position).strstateId);
				information.setStrthemer(Informationlist.get(position).strthemer);
				information.setStrtype(Informationlist.get(position).strtype);
				information.setStrdate(Informationlist.get(position).strdate);
				information.setStrSpare4(Informationlist.get(position).strSpare4);
				// Informationlist.get(position);
				intent.putExtra("Informationlist", information);
				Log.e("TAG", "我被单击了"+information.strId);
				intent.putExtra("bzid", "1");
				startActivity(intent);
			}
		});

		SendParam sendParam = new SendParam();
		sendParam.parent = Pendingapproval.this;
		sendParam.processor = downGoodss;
		getDataTrunsfer().request(sendParam);

		Informationlist.clear();
		Query();
		adapter.setData(Informationlist);




	}




	public void biaoz() {
		//根据数据的状态  StateId查询显示到不同的  模块地方
		weiyi.clear();
		weiyi1.clear();
		for (int i = 0; i < shuzuid.size(); i++) {
			if (i==shuzuid.size()-1) {
				TPId+="'"+shuzuid.get(i)+"'"+" and";
			}else {
				TPId+="'"+shuzuid.get(i)+"'"+TPId1;
			}

		}
		String sql="select * from Pendingapproval where  "+TPId+"   Type = 1 and Spare1 = 0   order by TPId  desc";
		Log.e("TAG", sql);
		TPId = "TPId =";
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			String strstateId = cursor.getString(6);
			String name = cursor.getString(10);
			weiyi.add(strstateId);
			weiyi1.add(name);
		}
		weiyi = new ArrayList(new HashSet(weiyi));
		weiyi1 = new ArrayList(new HashSet(weiyi1));
	}

	public void pullto(){
//
		Informationlist.clear();
		Query();
		adapter.setData(Informationlist);
		int sun=Informationlist.size();
		Toast.makeText(Pendingapproval.this, "为您查询到"+sun+"条相关数据", 500).show();
		//Layout1.setVisibility(View.VISIBLE);
		lay.setVisibility(View.GONE);

	}

	private class ModeCallback implements ListView.MultiChoiceModeListener {
		private View mMultiSelectActionBarView;

		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.layout.multi_select_menu, menu);
			if (mMultiSelectActionBarView == null) {
				mMultiSelectActionBarView = LayoutInflater.from(Pendingapproval.this).inflate(R.layout.list_multi_select_actionbar, null);

				mSelectedCount =(TextView)mMultiSelectActionBarView.findViewById(R.id.selected_conv_count);
			}
			mode.setCustomView(mMultiSelectActionBarView);
			((TextView)mMultiSelectActionBarView.findViewById(R.id.title)).setText("已选择:");
			return true;
		}
		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			switch (item.getItemId()) {
				case R.id.action_slelect:
					if(view.getCheckedItemCount() == adapter.getCount()){
						unSelectedAll();
						mSelectedCount.setText(Integer.toString(view.getCheckedItemCount()));
						LinearLayout.setVisibility(View.GONE);
						list.clear();
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
			if (mMultiSelectActionBarView == null) {
				ViewGroup v = (ViewGroup)LayoutInflater.from(Pendingapproval.this).inflate(R.layout.list_multi_select_actionbar, null);
				mode.setCustomView(v);
				mSelectedCount = (TextView)v.findViewById(R.id.selected_conv_count);
			}
			//更新菜单的状态
			MenuItem mItem = menu.findItem(R.id.action_slelect);
			if(view.getCheckedItemCount() == adapter.getCount()){
				mItem.setTitle(R.string.action_deselect_all);
			}else{
				mItem.setTitle(R.string.action_select_all);
			}
			return true;
		}
		@Override
		public void onItemCheckedStateChanged(ActionMode mode, int position,long arg2, boolean checked) {
			// TODO Auto-generated method stub
			mode.invalidate();
			mSelectedCount.setText(Integer.toString(view.getCheckedItemCount()));
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
				String id=Informationlist.get(ps).strId;
				System.out.println(ps+"456456");
				shuzuid.add(id);

			}
			if (shuzuid.size()>0) {
				LinearLayout.setVisibility(View.VISIBLE);
				if (shuzuid.size()>1) {
					caoz.setText("批量操作");
					dlt.setText("批量删除");
				}else {
					caoz.setText("操作");
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


	public void onDelete()
	{
		if(shuzuid.size()<=0)
		{
			Toast.makeText(Pendingapproval.this, "选择数据", 500).show();
		}

		new AlertDialog.Builder(this).setTitle(getString(R.string.askDelete))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作

						Informationlist.clear();

						for (int i = 0; i < shuzuid.size(); i++) {
							String id=shuzuid.get(i);
							Log.e("TAG", id+"要删除的"+shuzuid.size());
							selectId(id);
							DeleteById(id);
							DeleteGlxxId(strxxId);
						}

						Resume();
						adapter.setData(Informationlist);
						unSelectedAll();
						mSelectedCount.setText(Integer.toString(view.getCheckedItemCount()));


					}
				})
				.setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“返回”后的操作,这里不设置没有任何操作
					}
				}).show();
	}




	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}




	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub



		Log.e("TAG", "PendingapprovalonRestart");
		ActivityHelper.biaozhi=null;
		ActivityHelper.Bitmaps=null;
		super.onRestart();

	}


	@Override
	protected void onStart() {
		super.onStart();
		Log.e("TAG", "PendingapprovalonStart");
	}

	@Override
	protected void onResume() {



		super.onResume();
		Resume();
		if (mSelectedCount!=null) {
			mSelectedCount.setText(Integer.toString(view.getCheckedItemCount()));
		}
		list.clear();

	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.e("TAG", "PendingapprovalonPause");
	}

	@Override
	protected void onStop() {
		super.onStop();

		Log.e("TAG", "PendingapprovalonStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.e("TAG", "PendingapprovalonDestroy");
	}


	//找到这个消息的消息ID
	public void selectId(String id){

		cursor= db.rawQuery("select * from Pendingapproval  where TPId = "+id+"  ", new String[]{});
		while (cursor.moveToNext()) {
			strxxId = cursor.getString(1);
		}
	}
	///全选
	public void selectedAll(){
		for(int i= 0; i< adapter.getCount(); i++){
			view.setItemChecked(i, true);
		}
		//updateSeletedCount();
	}

	///取消选中
	public void unSelectedAll(){
		view.clearChoices();

	}


	public void Resume(){
		Informationlist = new ArrayList<Information>();
		if (ActivityHelper.MorePopWindow04sql!=null) {
			cursor = db.rawQuery(ActivityHelper.MorePopWindow04sql, new String[]{});
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

				Informationlist.add(information);
				unSelectedAll();
			}
			adapter.setData(Informationlist);
			LinearLayout.setVisibility(View.GONE);

			Log.e("TAG", "PendingapprovalonResume");
		}
	}

	public int DeleteById(String strIds)
	{
		//DELETE FROM Pendingapproval WHERE TPId
		db.execSQL("delete from Pendingapproval where TPId=?",   new Object[]{strIds});

		return mLastClickId;
	}

	//删除消息的所有操作
	public int DeleteGlxxId(String strIds)
	{
		db.execSQL("delete from Pendingapprovalcz  where GlxxId = ?",   new Object[]{strIds});
		db.execSQL("delete from Pendingapprovalxx  where XxId = ?",   new Object[]{strIds});
		return 1;
	}

	public void Query1(){
		s=true;
		// cursor = db.rawQuery("select * from Pendingapproval where Odd = "+"'"+NotifyId+"'"+" ", new String[]{});
		String current_sql_sel = "select * from Pendingapproval  where  Type = 1 and Spare1 = 0 " +
				" and  (Themer like '%"+NotifyId+"%' " +
				"or  StateId like '%"+NotifyId+"%' " +
				"or  Odd like '%"+NotifyId+"%' " +
				"or  Initiator like '%"+NotifyId+"%' " +
				"or  Date like '%"+NotifyId+"%' " +
				"or  ModuleName like '%"+NotifyId+"%') order by TPId  desc";
		ActivityHelper.MorePopWindow04sql=current_sql_sel;
		cursor = db.rawQuery(current_sql_sel, new String[]{});

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
			Informationlist.add(information);
			s=false;
		}
		int sun=Informationlist.size();
		Toast.makeText(Pendingapproval.this, "为您查询到"+sun+"条相关数据", 500).show();
		if (s) {
			Toast.makeText(Pendingapproval.this, "不存在的消息", 500).show();
			Toast.makeText(Pendingapproval.this, "点击标题可刷新全部", 500).show();
		}
	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub
		if(msgId==1000)
		{
			Informationlist.clear();
			Resume();
			adapter.setData(Informationlist);

		}

	}

	public void Query() {
		//根据数据的状态  StateId查询显示到不同的  模块地方
		String sql="select * from Pendingapproval where Type = 1 and Spare1 = 0   order by TPId  desc";
		ActivityHelper.MorePopWindow04sql=sql;
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
//        	String strId = cursor.getString(0);
//	    	String strxxId = cursor.getString(1);
//	        String strtype = cursor.getString(2);
//	        String strthemer = cursor.getString(3);
//	        String strinitiator = cursor.getString(4);
//	        String strcontent = cursor.getString(5);
//	        String strstateId = cursor.getString(6);
//	        String strstate = cursor.getString(7);
//	        String strmoduletype = cursor.getString(8);
//	        String strmoduletypeId = cursor.getString(9);
//	        String strmodulename = cursor.getString(10);
//	        String strodd = cursor.getString(11);
//	        String stroddId = cursor.getString(12);
//	        String strdate = cursor.getString(13);
//	        String strspare1 = cursor.getString(14);
//	        String strspare2 = cursor.getString(15);
//	        String strspare3 = cursor.getString(16);
//	        String strspare4 = cursor.getString(17);
//	        String strspare5 = cursor.getString(18);
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


}
