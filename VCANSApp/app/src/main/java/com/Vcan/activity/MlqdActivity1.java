package com.Vcan.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.MlqdProcessor1;
import com.vcans.adapter.InventoryAdapter;
import com.vcans.model.Mlqd2;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.MorePopWindow03;
import com.vcans.tool.XListView;
import com.vcans.tool.XListView.IXListViewListener;
import com.vcans.tool.playListview;

import android.os.Bundle;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
/**
 *   清单模块一   有6个界面类
 * @author vcans
 * @param <>
 *
 */
public class MlqdActivity1 extends BaseActivity implements IXListViewListener  , InventoryAdapter.CollectInterface {
	public static MlqdActivity1 mlqdActivity1 = null;
	public Button tj,btnSearch11,btnSearch;
	public LinearLayout LinearLayout,LinearLayout1;
	public RelativeLayout lay;
	public XListView  view;
	public List<Mlqd2> mlqd2list,mlqd2list1;
	public ArrayList<String> mlbh;
	public Mlqd2 mlqd2 ,mlqd3;
	public InventoryAdapter adapter;
	public SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);
	public Cursor cursor;
	public EditText txtContent;
	public playListview playListview;
	public String strcj,strmlbh,strmlname,sql,sql1,NotifyId;
	public ModeCallback mCallback;
	public int strspare4;
	public String txtContents,strId, strCode, strPnumber, strPname, strDescription1, strDescription2, strDescription3, strFilter1, strFilter2, strFilter3, strmulu2, strmulu3, strQuotation, strspare, strspare1, strspare2, strspare3;
	public TextView mSelectedCount;
	public List<String> shuzuid1,shuzuid,list;
	public boolean b=false;
	public boolean s=true;
	public MorePopWindow03 morePopWindow03;
	public String max;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mlqd_activity1);
		this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
		mlqdActivity1=this;
		view=(XListView)findViewById(R.id.lvProdct);
		view.setPullLoadEnable(false);
		view.setXListViewListener(this);
		view.setEmptyView(findViewById(R.id.img));
		mCallback = new ModeCallback();
		lay=(RelativeLayout)findViewById(R.id.Layout);
		LinearLayout=(LinearLayout)findViewById(R.id.Linear);
		LinearLayout1=(LinearLayout)findViewById(R.id.include01);
		tj=(Button)findViewById(R.id.dlt);
		btnSearch11=(Button)findViewById(R.id.btnSearch11);
		btnSearch=(Button)findViewById(R.id.btnSearch);
		txtContent=(EditText)findViewById(R.id.txtContent);
		list=new ArrayList<String>();
		mlqd2=new Mlqd2();
		shuzuid1=new ArrayList<String>();
		shuzuid=new ArrayList<String>();
		mlqd2list = new ArrayList<Mlqd2>();

		Intent intent = this.getIntent();
		strcj= (String)intent.getSerializableExtra("strcj");
		strmlbh= (String)intent.getSerializableExtra("strmlbh");
		strmlname= (String)intent.getSerializableExtra("strmlname");

		txtContents= (String)intent.getSerializableExtra("txtContents");
		mlbh = getIntent().getStringArrayListExtra("Mlbh");

		if (txtContents!=null) {
			mlqd2list.clear();
			strcj=1+"";
			Query1(txtContents);
			adapter = new InventoryAdapter(MlqdActivity1.this,  mlqd2list);
			view.setAdapter(adapter);
		}else if (mlbh!=null) {
			mlqd2list.clear();
			strcj=1+"";
			if (mlbh.size()!=0) {
				Query2(mlbh);
			}
			adapter = new InventoryAdapter(MlqdActivity1.this,  mlqd2list);
			view.setAdapter(adapter);
		}  else {
			mlqd2list.clear();
			max= Query();
			adapter = new InventoryAdapter(MlqdActivity1.this,  mlqd2list);
            adapter.setCollectInterface(this);
			view.setAdapter(adapter);

			if (max.equals("0")) {
				mlqd2list.clear();
				SendParam sendParam = new SendParam();
				sendParam.parent = MlqdActivity1.this;
				sendParam.szData=new String[]{strcj,strmlbh,strmlname};
				sendParam.processor = new MlqdProcessor1();
				getDataTrunsfer().request(sendParam);
			}
		}




		view.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position,long id) {

				Intent intent = new Intent(MlqdActivity1.this,MlqdActivity2.class);
				mlqd2list=adapter.getData();
				mlqd2= mlqd2list.get(position-1);
				intent.putExtra("mlqd2list", mlqd2);
				intent.putExtra("strcj", strcj);
				startActivity(intent);
			}
		});

		view.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position,long id) {

				Intent intent = new Intent(MlqdActivity1.this,MlqdActivity2.class);
				mlqd2list=adapter.getData();
				mlqd2= mlqd2list.get(position-1);
				intent.putExtra("mlqd2list", mlqd2);
				intent.putExtra("strcj", strcj);
				startActivity(intent);
			}
		});


		tj.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//onDelete();
				ContentValues values = new ContentValues();
				for (int i = 0; i < MLQingdanoneQuery1(shuzuid).size(); i++) {
					Mlqd2 mlqd2=MLQingdanoneQuery1(shuzuid).get(i);

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
						Toast.makeText(MlqdActivity1.this, "已经收藏过了", Toast.LENGTH_LONG).show();
					}else {
						Toast.makeText(MlqdActivity1.this, "收藏成功", Toast.LENGTH_SHORT).show();
					}


					db.execSQL("delete from Collect where Code=?",   new Object[]{mlqd2.strCode});
					db.insert("Collect", null, values);
				}


				Intent intent=new Intent(MlqdActivity1.this,MlqdActivity3.class);
				startActivity(intent);

			}
		});

		   /*选择搜索*/
		btnSearch11.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				morePopWindow03 = new MorePopWindow03(MlqdActivity1.this,adapter,sql);
				morePopWindow03.showPopupWindow(btnSearch11);
				unSelectedAll();
				list.clear();
				LinearLayout.setVisibility(View.GONE);
			}
		});

		    /*搜索*/
		btnSearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				NotifyId = txtContent.getText().toString().trim();
				if (!NotifyId.equals("")) {
					// ActivityHelper.gToupei.strOutNotifyId=NotifyId;
					mlqd2list.clear();
					Query1(NotifyId,strcj);
					unSelectedAll();
					adapter.setData(mlqd2list);
					adapter.notifyDataSetChanged();
					InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
					LinearLayout.setVisibility(View.GONE);
				} else {
					Toast.makeText(MlqdActivity1.this, "请输入要查询的数据", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}



	private class ModeCallback implements ListView.MultiChoiceModeListener {
		private View mMultiSelectActionBarView;

		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.layout.multi_select_menu, menu);
			if (mMultiSelectActionBarView == null) {
				mMultiSelectActionBarView = LayoutInflater.from(MlqdActivity1.this).inflate(R.layout.list_multi_select_actionbar, null);

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
				ViewGroup v = (ViewGroup)LayoutInflater.from(MlqdActivity1.this).inflate(R.layout.list_multi_select_actionbar, null);
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
			mlqd2list=adapter.getData();
			shuzuid.clear();
			for (int i = 0; i < shuzuid1.size(); i++) {
				System.out.println(shuzuid1.get(i));
				int ps=Integer.parseInt(shuzuid1.get(i));
				String id=mlqd2list.get(ps).strId;
				shuzuid.add(id);

			}
			if (shuzuid.size()>0) {
				LinearLayout.setVisibility(View.VISIBLE);
//					if (shuzuid.size()>1) {
//						caoz.setText("批量操作");
//						dlt.setText("批量删除");
//					}else {
//						caoz.setText("操作");
//						dlt.setText("删除");
//					}
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







	public String Query() {
		mlqd2list.clear();
		if (strcj.equals("2")) {
			sql="select * from MLQingdanone where mulu2 = "+"'"+strmlbh+"'"+"  ";
		} else if(strcj.equals("3")){
			sql="select * from MLQingdanone where mulu3 = "+"'"+strmlbh+"'"+"  ";
		}

		cursor = db.rawQuery(sql+"order by TPId  desc", new String[]{});
		while (cursor.moveToNext()) {
			mlqd2list.add(Cursor(cursor));

		}
		return mlqd2list.size()+"";


	}




	/***/
	public List<Mlqd2> MLQingdanoneQuery1(List<String> Str) {
		mlqd2list1 = new ArrayList<Mlqd2>();
		mlqd3=new Mlqd2();
		for (int i = 0; i < Str.size(); i++) {
			sql="select * from MLQingdanone where TPId = "+"'"+Str.get(i)+"'"+" ";
			cursor = db.rawQuery(sql, new String[]{});
			while (cursor.moveToNext()) {
				strId = cursor.getString(0);
				strCode = cursor.getString(1);
				strPnumber = cursor.getString(2);
				strPname = cursor.getString(3);
				strDescription1 = cursor.getString(4);
				strDescription2 = cursor.getString(5);
				strDescription3 = cursor.getString(6);
				strFilter1 = cursor.getString(7);
				strFilter2 = cursor.getString(8);
				strFilter3 = cursor.getString(9);
				strmulu2 = cursor.getString(10);
				strmulu3 = cursor.getString(11);
				strQuotation = cursor.getString(12);
				strspare = cursor.getString(13);
				strspare1 = cursor.getString(14);
				strspare2 = cursor.getString(15);
				strspare3 = cursor.getString(16);
				strspare4 = cursor.getInt(17);


			}
			mlqd3 = new Mlqd2(strId, strCode, strPnumber, strPname, strDescription1, strDescription2, strDescription3, strFilter1, strFilter2, strFilter3, strmulu2, strmulu3, strQuotation, strspare, strspare1, strspare2, strspare3, strspare4);
			mlqd2list1.add(mlqd3);
		}
		for (int i = 0; i < mlqd2list1.size(); i++) {
			Mlqd2 mlqd2=mlqd2list1.get(i);
		}
		return mlqd2list1;


	}





	/**模糊查询*/
	public void Query1(String Str,String Str1){
		s=true;
		if (Str1.equals("2")) {
			sql1="select * from MLQingdanone where mulu2 = "+"'"+strmlbh+"'"+
					" and  (Code like '%"+Str+"%' " +
					"or  Pnumber like '%"+Str+"%' " +
					"or  Filter1 like '%"+Str+"%' " +
					"or  Filter2 like '%"+Str+"%' " +
					"or  Filter3 like '%"+Str+"%' " +
					"or  Quotation like '%"+Str+"%') order by TPId  desc";
		} else if(Str1.equals("3")){
			sql1="select * from MLQingdanone where mulu3 = "+"'"+strmlbh+"'"+
					" and  (Code like '%"+Str+"%' " +
					"or  Pnumber like '%"+Str+"%' " +
					"or  Filter1 like '%"+Str+"%' " +
					"or  Filter2 like '%"+Str+"%' " +
					"or  Filter3 like '%"+Str+"%' " +
					"or  Quotation like '%"+Str+"%') order by TPId  desc";
		}else {
			sql1="select * from MLQingdanone where Spare4 = "+"'"+1+"'"+
					" and  (Code like '%"+Str+"%' " +
					"or  Pnumber like '%"+Str+"%' " +
					"or  Filter1 like '%"+Str+"%' " +
					"or  Filter2 like '%"+Str+"%' " +
					"or  Filter3 like '%"+Str+"%' " +
					"or  Quotation like '%"+Str+"%') order by TPId  desc";
		}


		cursor = db.rawQuery(sql1, new String[]{});

		while (cursor.moveToNext()) {
			mlqd2list.add(Cursor(cursor));
			s=false;
		}
		int sun=mlqd2list.size();
		Toast.makeText(MlqdActivity1.this, "为您查询到"+sun+"条相关数据", Toast.LENGTH_SHORT).show();
		if (s) {
			Toast.makeText(MlqdActivity1.this, "不存在的消息", Toast.LENGTH_SHORT).show();

		}
	}





	public void Query1(String Str){
		s=true;

		sql="select * from MLQingdanone where   Spare4 = "+"'"+1+"'"+
				" and  (Code like '%"+Str+"%' " +
				"or  Pnumber like '%"+Str+"%' " +
				"or  Filter1 like '%"+Str+"%' " +
				"or  Filter2 like '%"+Str+"%' " +
				"or  Filter3 like '%"+Str+"%' " +
				"or  Quotation like '%"+Str+"%')";



		cursor = db.rawQuery(sql, new String[]{});

		while (cursor.moveToNext()) {
			mlqd2list.add(Cursor(cursor));
			s=false;
		}
		int sun=mlqd2list.size();
		Toast.makeText(MlqdActivity1.this, "为您查询到"+sun+"条相关数据", Toast.LENGTH_SHORT).show();
		if (s) {
			Toast.makeText(MlqdActivity1.this, "不存在的消息", Toast.LENGTH_SHORT).show();

		}
	}





	public void Query2(List<String>  s){

		String textSelect1 = "mulu2 =";
		String textSelect2 = " or mulu2 =";
		for (int i = 0; i < s.size(); i++) {
			if (i==s.size()-1) {
				textSelect1+="'"+s.get(i)+"'";
			}else {
				textSelect1+="'"+s.get(i)+"'"+textSelect2;
			}
		}
		sql="select * from MLQingdanone where   "+textSelect1+" "  ;



		cursor = db.rawQuery(sql, new String[]{});

		while (cursor.moveToNext()) {

			mlqd2list.add(Cursor(cursor));

		}

	}

	public Mlqd2 Cursor(Cursor cursor){
		mlqd2 = new Mlqd2(cursor.getString(0), cursor.getString(1),cursor.getString(2),cursor.getString(3),
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
				cursor.getInt(17));
		return mlqd2;

	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub
		if (msgId==200) {
			Query();
			adapter.setData(mlqd2list);
			adapter.notifyDataSetChanged();
		}

	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub

		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				mlqd2list.clear();
				SendParam sendParam = new SendParam();
				sendParam.tip = getString(R.string.ypbiao);
				sendParam.parent = MlqdActivity1.this;
				sendParam.szData=new String[]{strcj,strmlbh,strmlname};
				sendParam.processor = new MlqdProcessor1();
				getDataTrunsfer().request(sendParam);

				SimpleDateFormat sDateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				String date = sDateFormat.format(new java.util.Date());
				view.stopRefresh();
				view.stopLoadMore();
				view.setRefreshTime(date);

				processMessage(200, "");
			}
		}, 2000);



	}

	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				ActivityHelper.ToastShow(MlqdActivity1.this, "onLoadMore");
			}
		}, 2000);

	}


    @Override
    public void Collect(Mlqd2 mlqd2 ,boolean b) {
        ContentValues values = new ContentValues();
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
            Toast.makeText(MlqdActivity1.this, "不能重复收藏", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MlqdActivity1.this, "加入收藏车成功", Toast.LENGTH_SHORT).show();
        }


        db.execSQL("delete from Collect where Code=?",   new Object[]{mlqd2.strCode});
        db.insert("Collect", null, values);
    }


}
