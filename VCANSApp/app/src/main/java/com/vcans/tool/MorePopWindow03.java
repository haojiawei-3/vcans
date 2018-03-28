package com.vcans.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.adapter.InventoryAdapter;
import com.vcans.adapter.NotapprovedAdapter;
import com.vcans.model.Information;
import com.vcans.model.Mlqd2;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * 点击更多按钮弹出PopupWindow
 *
 * @style 测试
 * @author hjw
 * @date 2017/1/08
 *
 */

public class MorePopWindow03 extends PopupWindow {

	private View conentView; // 存放popupwindow的布局；
	Cursor cursor;
	SQLiteDatabase db;
	List<Mlqd2> Mlqd2list;
	Mlqd2 Mlqd2;
	Spinner spinner1,spinner2,spinner3;
	Button btnSearchh;
	RelativeLayout relativeLayout;
	List<String> typecz1,typecz2,typecz3;
	String[] szData1,szData2,szData3;
	ArrayAdapter<String> adapter1,adapter2,adapter3;
	TextView TextView1,TextView2,TextView3;
	boolean s=true;
	private List<String> mDataList = new ArrayList<String>();
	private List<String> mDataList1 = new ArrayList<String>();
	private List<String> mDataList2 = new ArrayList<String>();
	private List<String> DataList = new ArrayList<String>();
	private List<String> DataList1 = new ArrayList<String>();
	private List<String> DataList2 = new ArrayList<String>();
	private List<String> name = new ArrayList<String>();
	String textSelect1 = "Filter1 =";
	String textSelect11 = " or Filter1 =";
	String textSelect2 = "Filter2 =";
	String textSelect22 = " or Filter2 =";
	String textSelect3 = "Filter3 =";
	String textSelect33 = " or Filter3 =";

	String text1 = "'清单一'";
	String text2 = "'过滤一名称'";
	String text3 = "'过滤二名称'";
	String text4 = "'过滤三名称'";
	String sql;

	private MultiLineChooseLayout multiChoose1;

	private MultiLineChooseLayout multiChoose2;

	private MultiLineChooseLayout multiChoose3;

	private TextView multiChooseTv1;

	private TextView multiChooseTv2;

	private TextView multiChooseTv3;
	List<String> multiChooseResult = new ArrayList<String>();
	List<String> multiChooseResult1 = new ArrayList<String>();
	List<String> multiChooseResult2 = new ArrayList<String>();

	public MorePopWindow03(final Activity context,final InventoryAdapter adapter,final String Sql) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		conentView = inflater.inflate(R.layout.pop_window1, null);
		multiChoose1 = (MultiLineChooseLayout)conentView.findViewById(R.id.multiChoose1);
		multiChoose2 = (MultiLineChooseLayout)conentView.findViewById(R.id.multiChoose2);
		multiChoose3 = (MultiLineChooseLayout)conentView.findViewById(R.id.multiChoose3);
//		multiChooseTv1 = (TextView)conentView. findViewById(R.id.Spinner);
//		multiChooseTv2 = (TextView)conentView. findViewById(R.id.Spinner1);
//		multiChooseTv3 = (TextView)conentView. findViewById(R.id.Spinner2);
		TextView1= (TextView)conentView. findViewById(R.id.TextView1);
		TextView2= (TextView)conentView. findViewById(R.id.TextView2);
		TextView3= (TextView)conentView. findViewById(R.id.TextView3);

		relativeLayout=(RelativeLayout)conentView.findViewById(R.id.btnSearchhh);
		btnSearchh=(Button)conentView.findViewById(R.id.btnSearchh);

		typecz1=new ArrayList<String>();
		typecz2=new ArrayList<String>();
		typecz3=new ArrayList<String>();
		Mlqd2list = new ArrayList<Mlqd2>();
		String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
		System.out.println(path);
		db=SQLiteDatabase.openDatabase(path, null, 4);
		initData(Sql);
		initData1();

		relativeLayout.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < multiChooseResult.size(); i++) {
					String a=multiChooseResult.get(i);
					DataList.add(a);
				}
				for (int i = 0; i < multiChooseResult1.size(); i++) {
					String a=multiChooseResult1.get(i);
					DataList1.add(a);
				}
				for (int i = 0; i < multiChooseResult2.size(); i++) {
					String a=multiChooseResult2.get(i);
					DataList2.add(a);
				}
				Mlqd2list.clear();
				guolu(Sql);
				adapter.setData(Mlqd2list);//在
				int sun=Mlqd2list.size();
				Toast.makeText(context, "为您查询到"+sun+"条相关数据", 500).show();
				dismiss();

			}
		});
		btnSearchh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < multiChooseResult.size(); i++) {
					String a=multiChooseResult.get(i);
					DataList.add(a);
				}
				for (int i = 0; i < multiChooseResult1.size(); i++) {
					String a=multiChooseResult1.get(i);
					DataList1.add(a);
				}
				for (int i = 0; i < multiChooseResult2.size(); i++) {
					String a=multiChooseResult2.get(i);
					DataList2.add(a);
				}
				Mlqd2list.clear();
				guolu(Sql);
				adapter.setData(Mlqd2list);//在
				int sun=Mlqd2list.size();
				Toast.makeText(context, "为您查询到"+sun+"条相关数据", 500).show();
				dismiss();
			}
		});
		// 获取context窗口的宽高；
		int h = context.getWindowManager().getDefaultDisplay().getHeight();
		int w = context.getWindowManager().getDefaultDisplay().getWidth();

		// 设置SelectPicPopupWindow的View
		this.setContentView(conentView);

		// 设置SelectPicPopupWindow弹出窗体的宽
		this.setWidth(w);
		// 设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(LayoutParams.WRAP_CONTENT);

		// 设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);
		// 当前窗体外围可触摸，加这个貌似没什么效果，这里可以不加；
		this.setOutsideTouchable(true);

		// 刷新状态，加或者不加并没有什么影响。
		this.update();

		// 实例化一个ColorDrawable颜色为半透明
		ColorDrawable dw = new ColorDrawable(0000000000);
		// 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
		this.setBackgroundDrawable(dw);
		multiChoose1.setOnItemClickListener(new MultiLineChooseLayout.onItemClickListener() {
			@Override
			public void onItemClick(int position, String text) {
				multiChooseResult = multiChoose1.getAllItemSelectedTextWithListArray();
				if (multiChooseResult != null && multiChooseResult.size() > 0) {
					String textSelect = "";
					for (int i = 0; i < multiChooseResult.size(); i++) {
						textSelect += multiChooseResult.get(i) + " , ";
					}

				}
			}
		});

		multiChoose2.setOnItemClickListener(new MultiLineChooseLayout.onItemClickListener() {
			@Override
			public void onItemClick(int position, String text) {
				multiChooseResult1 = multiChoose2.getAllItemSelectedTextWithListArray();
				if (multiChooseResult1 != null && multiChooseResult1.size() > 0) {
					String textSelect = "";
					for (int i = 0; i < multiChooseResult1.size(); i++) {
						textSelect += multiChooseResult1.get(i) + " , ";
					}

				}
			}
		});
		multiChoose3.setOnItemClickListener(new MultiLineChooseLayout.onItemClickListener() {
			@Override
			public void onItemClick(int position, String text) {
				multiChooseResult2 = multiChoose3.getAllItemSelectedTextWithListArray();
				if (multiChooseResult2 != null && multiChooseResult2.size() > 0) {
					String textSelect = "";
					for (int i = 0; i < multiChooseResult2.size(); i++) {
						textSelect += multiChooseResult2.get(i) + " , ";
					}
				}
			}
		});



	}





	public void guolu(String Sql){

		for (int i = 0; i < DataList.size(); i++) {
			if (i==DataList.size()-1) {
				textSelect1+="'"+DataList.get(i)+"'";
			}else {
				textSelect1+="'"+DataList.get(i)+"'"+textSelect11;
			}
		}
		if (DataList.size()!=0) {
			if (DataList1.size()!=0||DataList2.size()!=0) {
				textSelect1=textSelect1+" or";
			}
		}

		for (int i = 0; i < DataList1.size(); i++) {
			if (i==DataList1.size()-1) {
				textSelect2+="'"+DataList1.get(i)+"'";
			}else {
				textSelect2+="'"+DataList1.get(i)+"'"+textSelect22;
			}
		}
		if (DataList1.size()!=0) {
			if (DataList2.size()!=0) {
				textSelect2=textSelect2+" or";
			}
		}

		for (int i = 0; i < DataList2.size(); i++) {
			if (i==DataList2.size()-1) {
				textSelect3+="'"+DataList2.get(i)+"'";
			}else {
				textSelect3+="'"+DataList2.get(i)+"'"+textSelect33;
			}

		}
		if (textSelect1.equals("Filter1 =")&&textSelect2.equals("Filter2 =")&&textSelect3.equals("Filter3 =")) {
			sql=Sql;
		}else if (textSelect1.equals("Filter1 =")&&textSelect2.equals("Filter2 =")) {
			// sql= "select * from MLQingdanone where   "+textSelect3+"     order by TPId  desc";
			sql=Sql+"and ( "+textSelect3+"  ) order by TPId  desc";
		}else if (textSelect2.equals("Filter2 =")&&textSelect3.equals("Filter3 =")) {
			//sql= "select * from MLQingdanone where   "+textSelect1+"     order by TPId  desc";
			sql= Sql+"and  ("+textSelect1+"  )   order by TPId  desc";
		}else if (textSelect3.equals("Filter3 =")&&textSelect1.equals("Filter1 =")) {
			// sql= "select * from MLQingdanone where     "+textSelect2+"    order by TPId  desc";
			sql= Sql+"and  ("+textSelect2+"  )   order by TPId  desc";
		}else if (textSelect1.equals("Filter1 =")) {
			// sql= "select * from MLQingdanone where   "+textSelect2+"    "+textSelect3+"    order by TPId  desc";
			sql= Sql+"and  ( "+textSelect2+"    "+textSelect3+"  )  order by TPId  desc";
		}else if (textSelect2.equals("Filter2 =")) {
			// sql= "select * from MLQingdanone where   "+textSelect1+"    "+textSelect3+"    order by TPId  desc";
			sql= Sql +"and ( "+textSelect1+"    "+textSelect3+"  )  order by TPId  desc";
		}else if (textSelect3.equals("Filter3 =")) {
			// sql= "select * from MLQingdanone where   "+textSelect1+"    "+textSelect2+"    order by TPId  desc";
			sql= Sql +"and ( "+textSelect1+"    "+textSelect2+" )   order by TPId  desc";
		}else {
			//sql= "select * from MLQingdanone where   "+textSelect1+"    "+textSelect2+"  "+textSelect3+"    order by TPId  desc";
			sql= Sql +"and ( "+textSelect1+"    "+textSelect2+"  "+textSelect3+"  )  order by TPId  desc";
		}
		Log.e("TAG", sql+"5555555555555555555555");
		if (!sql.equals("")) {
			cursor = db.rawQuery(sql, new String[]{});
			while (cursor.moveToNext()) {
				String strId = cursor.getString(0);
				String strCode = cursor.getString(1);
				String strPnumber = cursor.getString(2);
				String strPname = cursor.getString(3);
				String strDescription1 = cursor.getString(4);
				String strDescription2 = cursor.getString(5);
				String strDescription3 = cursor.getString(6);
				String strFilter1 = cursor.getString(7);
				String strFilter2 = cursor.getString(8);
				String strFilter3 = cursor.getString(9);
				String strmulu2 = cursor.getString(10);
				String strmulu3 = cursor.getString(11);
				String strQuotation = cursor.getString(12);
				String strspare = cursor.getString(13);
				String strspare1 = cursor.getString(14);
				String strspare2 = cursor.getString(15);
				String strspare3 = cursor.getString(16);
				int strspare4 = cursor.getInt(17);
				Mlqd2 = new Mlqd2(strId, strCode, strPnumber, strPname, strDescription1, strDescription2, strDescription3, strFilter1, strFilter2, strFilter3, strmulu2, strmulu3, strQuotation, strspare, strspare1, strspare2, strspare3, strspare4);
				Mlqd2list.add(Mlqd2);
			}
		}else{
			Log.e("TAG", "sql等于null");
		}



	}


	public void initData(String sql) {
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {

			String ModuleName = cursor.getString(7);
			String StateId = cursor.getString(8);
			String Initiator = cursor.getString(9);
			typecz1.add(ModuleName);
			typecz2.add(StateId);
			typecz3.add(Initiator);
		}
		mDataList = new ArrayList(new HashSet(typecz1));
		mDataList1 = new ArrayList(new HashSet(typecz2));
		mDataList2 = new ArrayList(new HashSet(typecz3));
		multiChoose1.setList(mDataList);
		multiChoose2.setList(mDataList1);
		multiChoose3.setList(mDataList2);
	}

	public void initData1() {
		cursor = db.rawQuery("select * from  UIItemTitle  where ModuleId ="+text1+" and  (ItemName ="+text2+" or ItemName ="+text3+" or ItemName ="+text4+")", new String[]{});
		while (cursor.moveToNext()) {

			String ModuleName = cursor.getString(4);

			name.add(ModuleName);

		}

		TextView1.setText(name.get(0));
		TextView2.setText(name.get(1));
		TextView3.setText(name.get(2));

	}



	public void showPopupWindow(View parent) {
		if (!this.isShowing()) {
			//this.showAsDropDown(parent, 0, 5); // 出现在父控件正左下方，x、y方向有偏移；
			//this.showAtLocation(parent, Gravity.CENTER,0, 0);
			this.showAsDropDown(parent, Gravity.CLIP_HORIZONTAL, 0);
			//this.showAtLocation(parent, Gravity.BOTTOM, 0, 0); //出现在父控件下方正中间，无偏移。
		} else {
			this.dismiss();
		}
	}
}
