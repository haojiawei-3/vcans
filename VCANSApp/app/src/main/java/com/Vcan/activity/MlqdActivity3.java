package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.adapter.ShopcartExpandableListViewAdapter;
import com.vcans.adapter.ShopcartExpandableListViewAdapter.CheckInterface;
import com.vcans.adapter.ShopcartExpandableListViewAdapter.ModifyCountInterface;
import com.vcans.adapter.ShopcartExpandableListViewAdapter.PicInterface;
import com.vcans.model.GroupInfo;
import com.vcans.model.Mlqd2;
import com.vcans.tool.ActivityHelper;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
/**
 *   清单模块一   有6个界面类        这是共用       收藏车界面
 * @author vcans
 *
 */
public class MlqdActivity3 extends BaseActivity  implements CheckInterface, ModifyCountInterface, OnClickListener ,PicInterface{
	private ExpandableListView exListView;
	private CheckBox cb_check_all;
	private TextView tv_total_price;
	private TextView tv_delete,tv_cache;
	private TextView tv_go_to_pay,hondian;
	private Context context;
	private ImageButton button;
	List<String> s,ss,hondianlist;
	Mlqd2 mlqd2;
	String   str;
	public static MlqdActivity3 mlqdActivity3 = null;
	List<Mlqd2> mlqd2list;
	SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);
	Cursor cursor;
	private double totalPrice = 0.00;// 购买的商品总价
	private int totalCount = 0;// 购买的商品总数量

	private ShopcartExpandableListViewAdapter selva;
	private List<GroupInfo> groups = new ArrayList<GroupInfo>();// 组元素数据列表
	private Map<String, List<Mlqd2>> children = new HashMap<String, List<Mlqd2>>();// 子元素数据列表

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mlqd_activity3);
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		mlqdActivity3=this;
		this.setTitle("收藏车");
		button=(ImageButton)findViewById(R.id.btnBack);
		hondian= (TextView)findViewById(R.id.hondian);
		hondianlist=new ArrayList<String>();
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();

			}
		});


		mlqd2=new Mlqd2();
		mlqd2list=new ArrayList<Mlqd2>();

		initView();
		initEvents();
		if (!hondian().equals("0")) {
			hondian.setVisibility(View.VISIBLE);
			hondian.setText(hondian());
		}
	}

	public String hondian() {
		hondianlist.clear();
		cursor = db.rawQuery("select * from  CustomerCollect ", new String[]{});
		while (cursor.moveToNext()) {

			String s = cursor.getString(0);
			hondianlist.add(s);
		}
		return hondianlist.size()+"";

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
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	private void initView()
	{
		context = this;
		virtualData();
		exListView = (ExpandableListView) findViewById(R.id.exListView);
		cb_check_all = (CheckBox) findViewById(R.id.all_chekbox);
		tv_total_price = (TextView) findViewById(R.id.tv_total_price);
		tv_delete = (TextView) findViewById(R.id.tv_delete);
		tv_cache = (TextView) findViewById(R.id.tv_cache);
		tv_go_to_pay = (TextView) findViewById(R.id.tv_go_to_pay);

//		exListView.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				ActivityHelper.ToastShow(MlqdActivity3.this, "123456");
//			}
//		});
	}

	private void initEvents()
	{
		selva = new ShopcartExpandableListViewAdapter(groups, children, this);
		selva.setCheckInterface(this);// 关键步骤1,设置复选框接口
		selva.setModifyCountInterface(this);// 关键步骤2,设置数量增减接口
		selva.setPicInterface(this);
		exListView.setAdapter(selva);

		for (int i = 0; i < selva.getGroupCount(); i++)
		{
			exListView.expandGroup(i);// 关键步骤3,初始化时，将ExpandableListView以展开的方式呈现
		}

		cb_check_all.setOnClickListener(this);
		tv_delete.setOnClickListener(this);
		tv_cache.setOnClickListener(this);
		tv_go_to_pay.setOnClickListener(this);
	}

	/**
	 * 模拟数据<br>
	 * 遵循适配器的数据列表填充原则，组元素被放在一个List中，对应的组元素下辖的子元素被放在Map中，<br>
	 * 其键是组元素的Id(通常是一个唯一指定组元素身份的值)
	 */


	public List<Mlqd2> CollectQuery() {
		String	 sql="select * from Collect  ";
		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			mlqd2 = new Mlqd2(cursor.getString(0),
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
					cursor.getInt(17));
			mlqd2list.add(mlqd2);
		}
		return mlqd2list;


	}


	private void virtualData()
	{

		for (int i = 0; i < 1; i++)
		{

			groups.add(new GroupInfo(i + "", "全选"));
			//mlqd2list = new ArrayList<Mlqd2>();
			mlqd2list= CollectQuery();
			children.put(groups.get(i).getId(), mlqd2list);// 将组元素的一个唯一值，这里取Id，作为子元素List的Key
		}
	}


	@Override
	public void PicIncrease() {
		// TODO Auto-generated method stub
		mlqd2list.clear();
		groups.clear();
		children.clear();
		virtualData();
		initEvents();


	}

	@Override
	public void onClick(View v)
	{
		AlertDialog alert;
		switch (v.getId())
		{
			case R.id.all_chekbox:
				doCheckAll();
				break;
			case R.id.tv_go_to_pay:
				if (totalCount == 0) {
					Toast.makeText(context, "还未选择数据", Toast.LENGTH_LONG).show();
					return;
				}else {
					Intent intent=new Intent(MlqdActivity3.this,MlqdActivity4.class);
					intent.putStringArrayListExtra("id", (ArrayList<String>) s) ;
					intent.putStringArrayListExtra("shu", (ArrayList<String>) ss) ;
					startActivityForResult(intent,2);
				}
				break;
			case R.id.tv_cache:
				Intent intent = new Intent(MlqdActivity3.this,MlqdActivity5.class);
				startActivity(intent);
				break;
			case R.id.tv_delete:
				if (totalCount == 0)
				{
					Toast.makeText(context, "请选择要移除的商品", Toast.LENGTH_LONG).show();
					return;
				}
				alert = new AlertDialog.Builder(context).create();
				alert.setTitle("操作提示");
				alert.setMessage("您确定要从收藏车中移除吗？");
				alert.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						return;
					}
				});
				alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						doDelete();
					}
				});
				alert.show();
				break;
		}
	}

	/**
	 * 删除操作<br>
	 * 1.不要边遍历边删除，容易出现数组越界的情况<br>
	 * 2.现将要删除的对象放进相应的列表容器中，待遍历完后，以removeAll的方式进行删除
	 */
	protected void doDelete()
	{
		List<GroupInfo> toBeDeleteGroups = new ArrayList<GroupInfo>();// 待删除的组元素列表
		List<Mlqd2> toBeDeleteProducts = new ArrayList<Mlqd2>();// 待删除的子元素列表
		for (int i = 0; i < groups.size(); i++)
		{
			GroupInfo group = groups.get(i);
			if (group.isChoosed())
			{

				toBeDeleteGroups.add(group);
			}

			List<Mlqd2> childs = children.get(group.getId());
			for (int j = 0; j < childs.size(); j++)
			{
				if (childs.get(j).isChoosed())
				{
					toBeDeleteProducts.add(childs.get(j));
				}
			}
			childs.removeAll(toBeDeleteProducts);

		}

		groups.removeAll(toBeDeleteGroups);
		for (int i = 0; i < toBeDeleteProducts.size(); i++) {
			Mlqd2 mlqd1=toBeDeleteProducts.get(i);
			String id=mlqd1.getStrId();
			db.execSQL("delete from Collect  where TPId = ?",   new Object[]{id});

		}
		selva.notifyDataSetChanged();
		calculate();
	}

	@Override
	public void doIncrease(int groupPosition, int childPosition, View showCountView, boolean isChecked)
	{

		Mlqd2 mlqd2 = (Mlqd2) selva.getChild(groupPosition, childPosition);
		int currentCount = mlqd2.getStrspare4();
		currentCount++;
		mlqd2.setStrspare4(currentCount);
		((TextView) showCountView).setText(currentCount + "");

		selva.notifyDataSetChanged();
		calculate();
	}

	@Override
	public void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked)
	{

		Mlqd2 mlqd2 = (Mlqd2) selva.getChild(groupPosition, childPosition);
		int currentCount = mlqd2.getStrspare4();
		if (currentCount == 1)
			return;
		currentCount--;
		mlqd2.setStrspare4(currentCount);
		((TextView) showCountView).setText(currentCount + "");
		selva.notifyDataSetChanged();
		calculate();
	}


//	@Override
//	public void PicDecrease( int childPosition,
//			final View showCountView, final String id) {
//		// TODO Auto-generated method stub
//		LayoutInflater inflater = (LayoutInflater) context
//				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//				View view = inflater.inflate(R.layout.popjiage, null);
//					final EditText ok = (EditText) view.findViewById(R.id.EditText);
//					Button cancle = (Button) view.findViewById(R.id.xq);
//
//					final PopupWindow popWindow = new PopupWindow(view, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
//					//popWindow.setAnimationStyle(R.anim.pop);
//					popWindow.setFocusable(true);
//					popWindow.showAsDropDown(showCountView);
//					cancle.setOnClickListener(new OnClickListener() {
//
//						@Override
//						public void onClick(View arg0) {
//							// TODO Auto-generated method stub
//							str=ok.getText()+"";
//
//
//						    //ActivityHelper.ToastShow((Activity) arg0.getContext(), s);
//						    ContentValues  values = new ContentValues();
//						    if (!str.equals("")) {
//						    	values.put("Quotation", str);
//						    	db.update("Collect", values, "TPId=?", new String[]{id});
//						    	((TextView) showCountView).setText("￥" +str + "");
//							}
//					    	popWindow.dismiss();
//						}
//					});
//
//	}




	@Override
	public void checkGroup(int groupPosition, boolean isChecked)
	{
		GroupInfo group = groups.get(groupPosition);
		List<Mlqd2> childs = children.get(group.getId());
		for (int i = 0; i < childs.size(); i++)
		{
			childs.get(i).setChoosed(isChecked);
		}
		if (isAllCheck())
			cb_check_all.setChecked(true);
		else
			cb_check_all.setChecked(false);
		selva.notifyDataSetChanged();
		calculate();
	}

	@Override
	public void checkChild(int groupPosition, int childPosiTion, boolean isChecked)
	{
		boolean allChildSameState = true;// 判断改组下面的所有子元素是否是同一种状态
		GroupInfo group = groups.get(groupPosition);
		List<Mlqd2> childs = children.get(group.getId());
		for (int i = 0; i < childs.size(); i++)
		{
			if (childs.get(i).isChoosed() != isChecked)
			{
				allChildSameState = false;
				break;
			}
		}
		if (allChildSameState)
		{
			group.setChoosed(isChecked);// 如果所有子元素状态相同，那么对应的组元素被设为这种统一状态
		} else
		{
			group.setChoosed(false);// 否则，组元素一律设置为未选中状态
		}

		if (isAllCheck())
			cb_check_all.setChecked(true);
		else
			cb_check_all.setChecked(false);
		selva.notifyDataSetChanged();
		calculate();
	}

	private boolean isAllCheck()
	{

		for (GroupInfo group : groups)
		{
			if (!group.isChoosed())
				return false;

		}

		return true;
	}

	/** 全选与反选 */
	private void doCheckAll()
	{
		for (int i = 0; i < groups.size(); i++)
		{
			groups.get(i).setChoosed(cb_check_all.isChecked());
			GroupInfo group = groups.get(i);
			List<Mlqd2> childs = children.get(group.getId());
			for (int j = 0; j < childs.size(); j++)
			{
				childs.get(j).setChoosed(cb_check_all.isChecked());
			}
		}
		selva.notifyDataSetChanged();
	}

	/**
	 * 统计操作<br>
	 * 1.先清空全局计数器<br>
	 * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作<br>
	 * 3.给底部的textView进行数据填充
	 */
	private void calculate()
	{
		s=new ArrayList<String>();
		ss=new ArrayList<String>();
		totalCount = 0;
		totalPrice = 0.0;
		for (int i = 0; i < groups.size(); i++)
		{
			GroupInfo group = groups.get(i);
			List<Mlqd2> childs = children.get(group.getId());
			for (int j = 0; j < childs.size(); j++)
			{
				Mlqd2 mlqd2 = childs.get(j);
				if (mlqd2.isChoosed())
				{
					s.add(mlqd2.strId);
					System.out.println(s+"789456123");
					totalCount++;
					int ii= mlqd2.getStrspare4();
					totalPrice +=Double.parseDouble(mlqd2.getStrQuotation()) *ii;
					ss.add(ii+"");
				}
			}
		}
		tv_total_price.setText("￥" + totalPrice);
		tv_go_to_pay.setText("提交(" + totalCount + ")");
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (requestCode==2) {
			//Toast.makeText(context, "requestCode", Toast.LENGTH_LONG).show();
//			initView();
//			initEvents();
		}

		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		System.gc();
		super.onDestroy();
	}




	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}





}
