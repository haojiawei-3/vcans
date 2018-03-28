package com.vcans.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.adapter.NotapprovedAdapter;
import com.vcans.model.Information;

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

public class MorePopWindow04 extends PopupWindow {

	private View conentView; // 存放popupwindow的布局；
	Cursor cursor;
	SQLiteDatabase db;
	List<Information> Informationlist;
	Information information;
	Spinner spinner1,spinner2,spinner3;
	Button btnSearchh;
	RelativeLayout relativeLayout;
	List<String> typecz1,typecz2,typecz3;
	boolean s=true;
	private List<String> mDataList = new ArrayList<String>();
	private List<String> mDataList1 = new ArrayList<String>();
	private List<String> mDataList2 = new ArrayList<String>();
	private List<String> DataList = new ArrayList<String>();
	private List<String> DataList1 = new ArrayList<String>();
	private List<String> DataList2 = new ArrayList<String>();
	String textSelect1 = "ModuleName =";
	String textSelect11 = " or ModuleName =";
	String textSelect2 = "StateId =";
	String textSelect22 = " or StateId =";
	String textSelect3 = "Initiator =";
	String textSelect33 = " or Initiator =";
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

	public MorePopWindow04(final Activity context,final NotapprovedAdapter adapter) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		conentView = inflater.inflate(R.layout.pop_window, null);
		multiChoose1 = (MultiLineChooseLayout)conentView.findViewById(R.id.multiChoose1);
		multiChoose2 = (MultiLineChooseLayout)conentView.findViewById(R.id.multiChoose2);
		multiChoose3 = (MultiLineChooseLayout)conentView.findViewById(R.id.multiChoose3);
//		multiChooseTv1 = (TextView)conentView. findViewById(R.id.Spinner);
//		multiChooseTv2 = (TextView)conentView. findViewById(R.id.Spinner1);
//		multiChooseTv3 = (TextView)conentView. findViewById(R.id.Spinner2);

		relativeLayout=(RelativeLayout)conentView.findViewById(R.id.btnSearchhh);
		btnSearchh=(Button)conentView.findViewById(R.id.btnSearchh);

		typecz1=new ArrayList<String>();
		typecz2=new ArrayList<String>();
		typecz3=new ArrayList<String>();
		Informationlist = new ArrayList<Information>();
		String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
		System.out.println(path);
		db=SQLiteDatabase.openDatabase(path, null, 4);
		initData();
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
				Informationlist.clear();
				guolu();
				adapter.setData(Informationlist);//在
				int sun=Informationlist.size();
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
				Informationlist.clear();
				guolu();
				adapter.setData(Informationlist);//在
				int sun=Informationlist.size();
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





	public void guolu(){

		for (int i = 0; i < DataList.size(); i++) {
			if (i==DataList.size()-1) {
				textSelect1+="'"+DataList.get(i)+"'"+")  and";
			}else {
				textSelect1+="'"+DataList.get(i)+"'"+textSelect11;
			}
		}
		for (int i = 0; i < DataList1.size(); i++) {
			if (i==DataList1.size()-1) {
				textSelect2+="'"+DataList1.get(i)+"'"+")  and";
			}else {
				textSelect2+="'"+DataList1.get(i)+"'"+textSelect22;
			}

		}
		for (int i = 0; i < DataList2.size(); i++) {
			if (i==DataList2.size()-1) {
				textSelect3+="'"+DataList2.get(i)+"'"+")  and";
			}else {
				textSelect3+="'"+DataList2.get(i)+"'"+textSelect33;
			}

		}
		if (textSelect1.equals("ModuleName =")&&textSelect2.equals("StateId =")&&textSelect3.equals("Initiator =")) {
			sql="";
		}else if (textSelect1.equals("ModuleName =")&&textSelect2.equals("StateId =")) {
			sql= "select * from Pendingapproval where (  "+textSelect3+"   Type = 1 and Spare1 = 0  order by TPId  desc";
		}else if (textSelect2.equals("StateId =")&&textSelect3.equals("Initiator =")) {
			sql= "select * from Pendingapproval where  ( "+textSelect1+"    Type = 1 and Spare1 = 0  order by TPId  desc";
		}else if (textSelect3.equals("Initiator =")&&textSelect1.equals("ModuleName =")) {
			sql= "select * from Pendingapproval where  (   "+textSelect2+"   Type = 1 and Spare1 = 0  order by TPId  desc";
		}else if (textSelect1.equals("ModuleName =")) {
			sql= "select * from Pendingapproval where  (( "+textSelect2+"    "+textSelect3+"   Type = 1 and Spare1 = 0  order by TPId  desc";
		}else if (textSelect2.equals("StateId =")) {
			sql= "select * from Pendingapproval where  (( "+textSelect1+"    "+textSelect3+"   Type = 1 and Spare1 = 0  order by TPId  desc";
		}else if (textSelect3.equals("Initiator =")) {
			sql= "select * from Pendingapproval where  (( "+textSelect1+"    "+textSelect2+"   Type = 1 and Spare1 = 0  order by TPId  desc";
		}else {
			sql= "select * from Pendingapproval where  ((( "+textSelect1+"    "+textSelect2+"  "+textSelect3+"   Type = 1 and Spare1 = 0  order by TPId  desc";
		}
		Log.e("TAG", sql+"5555555555555555555555");
		if (!sql.equals("")) {
			cursor = db.rawQuery(sql, new String[]{});
			ActivityHelper.MorePopWindow04sql=sql;
			while (cursor.moveToNext()) {
				String strId = cursor.getString(0);
				String strxxId = cursor.getString(1);
				String strtype = cursor.getString(2);
				String strthemer = cursor.getString(3);
				String strinitiator = cursor.getString(4);
				String strcontent = cursor.getString(5);
				String strstateId = cursor.getString(6);
				String strstate = cursor.getString(7);
				String strmoduletype = cursor.getString(8);
				String strmoduletypeId = cursor.getString(9);
				String strmodulename = cursor.getString(10);
				String strodd = cursor.getString(11);
				String stroddId = cursor.getString(12);
				String strdate = cursor.getString(13);
				String strspare1 = cursor.getString(14);
				String strspare2 = cursor.getString(15);
				String strspare3 = cursor.getString(16);
				String strspare4 = cursor.getString(17);
				String strspare5 = cursor.getString(18);
				information = new Information(strId, strxxId, strtype, strthemer, strinitiator, strcontent, strstateId, strstate, strmoduletype,
						strmoduletypeId, strmodulename, strodd, stroddId, strdate, strspare1, strspare2, strspare3, strspare4, strspare5);
				Informationlist.add(information);
			}
		}else{
			Log.e("TAG", "sql等于null");
		}



	}


	public void initData() {
		cursor = db.rawQuery("select * from Pendingapproval where Type = 1 and Spare1 = 0  order by TPId  desc", new String[]{});
		while (cursor.moveToNext()) {

			String ModuleName = cursor.getString(10);
			String StateId = cursor.getString(6);
			String Initiator = cursor.getString(4);
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
