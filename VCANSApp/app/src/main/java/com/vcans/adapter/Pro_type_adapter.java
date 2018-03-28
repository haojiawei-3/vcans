package com.vcans.adapter;

import java.util.ArrayList;

import com.Vcan.activity.R;
import com.Vcan.activity.MlqdActivity1;
import com.Vcan.activity.Pendingapproval001;
import com.vcans.model.Mlqd;
import com.vcans.tool.ActivityHelper;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Pro_type_adapter extends BaseAdapter {
	// 定义Context
	private LayoutInflater mInflater;
	private ArrayList<String> list;
	private ArrayList<String> list1;
	private Context context;
	private String type;
	String s;
	Cursor cursor;
	String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	SQLiteDatabase db=SQLiteDatabase.openDatabase(path, null, 2);
	Mlqd mlqd;
	public Pro_type_adapter(Context context,ArrayList<String> list,ArrayList<String> list1,String s){
		mInflater=LayoutInflater.from(context);
		this.list=list;
		this.list1=list1;
		this.s=s;
		this.context=context;
	}

	@Override
	public int getCount() {
		if(list!=null&&list.size()>0){
			return list.size();
		}
		else{
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final MyView view;
		if(convertView==null){
			view=new MyView();
			convertView=mInflater.inflate(R.layout.list_pro_type_item, null);
			view.icon=(ImageView)convertView.findViewById(R.id.typeicon);
			view.name=(TextView)convertView.findViewById(R.id.typename);
			convertView.setTag(view);
		}else{
			view=(MyView) convertView.getTag();
		}
		if(list!=null&&list.size()>0)
		{
			type=list.get(position);
			view.name.setText(type);
			if (list1.get(position).equals("")) {
				//view.icon.setBackgroundResource(R.drawable.no_img);
			}else {
				Bitmap bitmap = BitmapFactory.decodeFile(list1.get(position));
				view.icon.setImageBitmap(bitmap);
			}

		}
		view.icon.setOnClickListener(new View.OnClickListener() {


			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Query(s,list.get(position));
				Intent intent=new Intent(arg0.getContext(),MlqdActivity1.class);
				intent.putExtra("strcj", mlqd.strcj);
				intent.putExtra("strmlbh", mlqd.strmlbh);
				intent.putExtra("strmlname", mlqd.strmlname);
				arg0.getContext().startActivity(intent);
			}
		});
		view.icon.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View arg0) {

				Intent intent=new Intent(arg0.getContext(),Pendingapproval001.class);
				ActivityHelper.filePaths=list1.get(position);
				arg0.getContext().startActivity(intent);
				return true;
			}
		});
		return convertView;
	}



	private class MyView{
		private ImageView icon;
		private TextView name;
	}

	private Mlqd Query(String ss,String s) {
		String sql="select * from MLQingdan where Ssfjbh = "+"'"+ss+"'"+" and  Mlname = "+"'"+s+"'"+" ";

		cursor = db.rawQuery(sql, new String[]{});
		while (cursor.moveToNext()) {
			String strId= cursor.getString(0);
			String strcj= cursor.getString(1);
			String  strmlbh  = cursor.getString(2);
			String strmlname= cursor.getString(3);
			String strssfjbh= cursor.getString(4);
			String strspare= cursor.getString(5);
			String strspare1= cursor.getString(6);
			Mlqd.Builder builder=new Mlqd.Builder();
			mlqd=builder.strcj(strcj)
					.strId(strId)
					.strmlbh(strmlbh)
					.strmlname(strmlname)
					.strspare(strspare1)
					.strssfjbh(strssfjbh)
					.strspare(strspare)
					.strspare1(strspare1)
					.build();
		}
		cursor.close();
		return mlqd;

	}

}
