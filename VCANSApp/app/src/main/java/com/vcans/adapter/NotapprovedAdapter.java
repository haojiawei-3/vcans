package com.vcans.adapter;

import java.util.ArrayList;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.model.Information;
import com.vcans.model.Mpsbinfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NotapprovedAdapter extends BaseAdapter {
	List<Information> Informationlist;
	private Context context;
	private LayoutInflater inflater;
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}
	public NotapprovedAdapter(Context context,  List<Information> Informationlist) {
		this.context = context;
		inflater = LayoutInflater.from(context);
		this.Informationlist = Informationlist;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Informationlist.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup p) {
		Information  information= (Information)Informationlist.get(position);
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = inflater.inflate(R.layout.dspxq, null);
			viewHolder.txt_zt = (TextView) convertView  .findViewById(R.id.zt);
			viewHolder.txt_gldh = (TextView) convertView.findViewById(R.id.gldh);
			viewHolder.txt_rq = (TextView) convertView.findViewById(R.id.rq);

			viewHolder.txt_xxlx = (TextView) convertView.findViewById(R.id.xxlx);

			convertView.setTag(viewHolder);     //gldh rq  dqr  xxlx
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		//向TextView中插入数据
		viewHolder.txt_zt.setText(information.strstateId);
		viewHolder.txt_gldh.setText(information.strmodulename+"/"+information.strodd);
		viewHolder.txt_rq.setText(information.strdate);
		viewHolder.txt_xxlx.setText(information.strthemer);

		return convertView;
	}
	class ViewHolder {
		private TextView txt_zt;
		private TextView txt_gldh;
		private TextView txt_rq;
		private TextView txt_xxlx;
	}
	public void setData(List<Information> list){
		this.Informationlist = list;
		Log.e("TAG", list+"789456");
		super.notifyDataSetChanged();
	}

	public List<Information> getData(){
		return Informationlist;
	}

}
	
	 

