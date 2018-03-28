package com.vcans.adapter;
import java.util.List;
import java.util.Map;

import com.Vcan.activity.Pendingapproval001;
import com.Vcan.activity.R;

import com.vcans.model.GroupInfo;
import com.vcans.model.Mlqd2;
import com.vcans.tool.ActivityHelper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.view.LayoutInflater;

import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;


public class ShopcartExpandableListViewAdapter extends BaseExpandableListAdapter
{
	private List<GroupInfo> groups;
	private Map<String, List<Mlqd2>> children;
	private Context context;
	private CheckInterface checkInterface;
	private PicInterface picInterface;
	private ModifyCountInterface modifyCountInterface;
	private int mTouchItemPosition = -1;
	Bitmap bitmap;
	String str;
	SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);


	/**
	 * 构造函数
	 *
	 * @param groups
	 *            组元素列表
	 * @param children
	 *            子元素列表
	 * @param context
	 */
	public ShopcartExpandableListViewAdapter(List<GroupInfo> groups, Map<String, List<Mlqd2>> children, Context context)
	{
		super();
		this.groups = groups;
		this.children = children;
		this.context = context;
	}

	public void setPicInterface(PicInterface picInterface)
	{
		this.picInterface = picInterface;
	}

	public void setCheckInterface(CheckInterface checkInterface)
	{
		this.checkInterface = checkInterface;
	}

	public void setModifyCountInterface(ModifyCountInterface modifyCountInterface)
	{
		this.modifyCountInterface = modifyCountInterface;
	}

	@Override
	public int getGroupCount()
	{
		return groups.size();
	}

	@Override
	public int getChildrenCount(int groupPosition)
	{
		String groupId = groups.get(groupPosition).getId();
		return children.get(groupId).size();
	}

	@Override
	public Object getGroup(int groupPosition)
	{
		return groups.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition)
	{
		List<Mlqd2> childs = children.get(groups.get(groupPosition).getId());

		return childs.get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition)
	{
		return 0;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition)
	{
		return 0;
	}

	@Override
	public boolean hasStableIds()
	{
		return false;
	}

	@Override
	public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
	{

		GroupHolder gholder;
		if (convertView == null)
		{
			gholder = new GroupHolder();
			convertView = View.inflate(context, R.layout.item_shopcart_group, null);
			gholder.cb_check = (CheckBox) convertView.findViewById(R.id.determine_chekbox);
			gholder.tv_group_name = (TextView) convertView.findViewById(R.id.tv_source_name);
			//groupMap.put(groupPosition, convertView);
			convertView.setTag(gholder);
		} else
		{
			// convertView = groupMap.get(groupPosition);
			gholder = (GroupHolder) convertView.getTag();
		}
		final GroupInfo group = (GroupInfo) getGroup(groupPosition);
		if (group != null)
		{
			gholder.tv_group_name.setText(group.getName());
			gholder.cb_check.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)

				{
					group.setChoosed(((CheckBox) v).isChecked());
					checkInterface.checkGroup(groupPosition, ((CheckBox) v).isChecked());// 暴露组选接口
				}
			});
			gholder.cb_check.setChecked(group.isChoosed());
		}
		return convertView;
	}

	@SuppressLint("ResourceAsColor")
	@Override
	public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
	{

		 ChildHolder cholder = null;
		if (convertView == null) {

			convertView = View.inflate(context, R.layout.item_shopcart_product, null);
			cholder = new ChildHolder();
			cholder.cb_check = (CheckBox) convertView.findViewById(R.id.check_box);
			cholder.tv_product_desc = (TextView) convertView.findViewById(R.id.tv_intro);
			cholder.iv_adapter_list_pic = (ImageView) convertView.findViewById(R.id.iv_adapter_list_pic);
			cholder.tv_price = (TextView) convertView.findViewById(R.id.tv_price);
			cholder.iv_increase = (TextView) convertView.findViewById(R.id.tv_add);
			cholder.iv_decrease = (TextView) convertView.findViewById(R.id.tv_reduce);
			cholder.ms = (TextView) convertView.findViewById(R.id.ms);
			cholder.tv_count = (TextView) convertView.findViewById(R.id.tv_num);
			convertView.setTag(cholder);
		} else {
			cholder = (ChildHolder) convertView.getTag();
		}

		final Mlqd2 mlqd2 = (Mlqd2) getChild(groupPosition, childPosition);
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ActivityHelper.BitmapFactory(mlqd2.strspare3,4).compress(Bitmap.CompressFormat.PNG, 100, baos);
//		byte[] bytes=baos.toByteArray();
//		Glide.with(context).load(bytes)
//				.apply(bitmapTransform(new BlurTransformation(1)))
//				.into(cholder.iv_adapter_list_pic);
		    cholder.iv_adapter_list_pic.setImageBitmap( ActivityHelper.BitmapFactory(mlqd2.strspare3,4));
			cholder.ms.setText(mlqd2.strDescription1);
			cholder.tv_product_desc.setText(mlqd2.strPname+"/"+mlqd2.strPnumber);
			cholder.tv_price.setText("￥" +mlqd2.strQuotation + "");
			cholder.tv_count.setText(mlqd2.getStrspare4()+"");
			cholder.cb_check.setChecked(mlqd2.isChoosed());


			final ChildHolder finalCholder = cholder;
			cholder.cb_check.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					mlqd2.setChoosed(((CheckBox) v).isChecked());
					finalCholder.cb_check.setChecked(((CheckBox) v).isChecked());
					checkInterface.checkChild(groupPosition, childPosition, ((CheckBox) v).isChecked());// 暴露子选接口
				}
			});

			cholder.iv_increase.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					modifyCountInterface.doIncrease(groupPosition, childPosition, finalCholder.tv_count, finalCholder.cb_check.isChecked());// 暴露增加接口
				}
			});
			cholder.	iv_decrease.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					modifyCountInterface.doDecrease(groupPosition, childPosition, finalCholder.tv_count, finalCholder.cb_check.isChecked());// 暴露删减接口
				}
			});


		//}


		cholder.tv_price.setOnClickListener(new OnClickListener() {

			@SuppressLint("ResourceAsColor")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View view = inflater.inflate(R.layout.popjiage, null);

				final EditText ok = (EditText) view.findViewById(R.id.EditText);
				ok.setText(mlqd2.strQuotation);
				Button cancle = (Button) view.findViewById(R.id.xq);
				Button cancle1 = (Button) view.findViewById(R.id.qx);

				final PopupWindow popWindow = new PopupWindow(view, 800,250);
				popWindow.setFocusable(true);
				popWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
				cancle.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						str=ok.getText()+"";
						String s=mlqd2.strId;
						ContentValues  values = new ContentValues();
						if (!str.equals("")) {
							values.put("Quotation", str);
							db.update("Collect", values, "TPId=?", new String[]{s});
							finalCholder.tv_price.setText("￥" +str + "");
							picInterface.PicIncrease();
						}
						popWindow.dismiss();
					}
				});
				cancle1.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						popWindow.dismiss();
					}
				});

			}
		});

		cholder.iv_adapter_list_pic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(arg0.getContext(),Pendingapproval001.class);
				ActivityHelper.filePaths=mlqd2.strspare3;
				arg0.getContext().startActivity(intent);
				( (Activity) context).overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
			}
		});




		return convertView;


	}



	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition)
	{
		return true;
	}

	/**
	 * 组元素绑定器
	 *
	 *
	 */
	private class GroupHolder
	{
		CheckBox cb_check;
		TextView tv_group_name;
	}

	/**
	 * 子元素绑定器
	 *
	 *
	 */
	private class ChildHolder
	{
		CheckBox cb_check;

		TextView ms;
		TextView tv_product_desc;
		TextView tv_price;
		TextView iv_increase;
		TextView tv_count;
		TextView iv_decrease;
		ImageView iv_adapter_list_pic;
	}


	public void setData(Map<String, List<Mlqd2>> children){
		this.children = children;
		super.notifyDataSetChanged();
	}

	/**
	 * 复选框接口
	 *
	 *
	 */
	public interface CheckInterface
	{
		/**
		 * 组选框状态改变触发的事件
		 *
		 * @param groupPosition
		 *            组元素位置
		 * @param isChecked
		 *            组元素选中与否
		 */
		public void checkGroup(int groupPosition, boolean isChecked);

		/**
		 * 子选框状态改变时触发的事件
		 *
		 * @param groupPosition
		 *            组元素位置
		 * @param childPosition
		 *            子元素位置
		 * @param isChecked
		 *            子元素选中与否
		 */
		public void checkChild(int groupPosition, int childPosition, boolean isChecked);
	}

	/**
	 * 改变数量的接口
	 *
	 *
	 */
	public interface ModifyCountInterface
	{
		/**
		 * 增加操作
		 *
		 * @param groupPosition
		 *            组元素位置
		 * @param childPosition
		 *            子元素位置
		 * @param showCountView
		 *            用于展示变化后数量的View
		 * @param isChecked
		 *            子元素选中与否
		 */
		public void doIncrease(int groupPosition, int childPosition, View showCountView, boolean isChecked);

		/**
		 * 删减操作
		 *
		 * @param groupPosition
		 *            组元素位置
		 * @param childPosition
		 *            子元素位置
		 * @param showCountView
		 *            用于展示变化后数量的View
		 * @param isChecked
		 *            子元素选中与否
		 */
		public void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked);
	}
	/**
	 * 改变价格
	 *
	 *
	 */
	public interface PicInterface
	{      /**
	 * 更新Adapter操作
	 *

	 */
	public void PicIncrease();
	}
}
