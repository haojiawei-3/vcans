package com.vcans.adapter;

import java.util.List;

import com.Vcan.activity.R;
import com.Vcan.activity.MpsdActivity;
import com.Vcan.activity.Pendingapproval001;
import com.vcans.model.Mpsbinfo;
import com.vcans.tool.ActivityHelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MpsbAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater inflater;
	List<Mpsbinfo> Mpsbinfolist;
	Mpsbinfo mp;
	public MpsbAdapter(Context context,List<Mpsbinfo> Mpsbinfolist) {
		this.context = context;
		inflater = LayoutInflater.from(context);
		this.Mpsbinfolist=Mpsbinfolist;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Mpsbinfolist.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup p) {
		mp = Mpsbinfolist.get(position);
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = inflater.inflate(R.layout.layout_animation, null);
			viewHolder.txt_name = (TextView) convertView  .findViewById(R.id.tweetName);
			viewHolder.txt_phone = (TextView) convertView.findViewById(R.id.tweetDate);
			viewHolder.txt_company = (TextView) convertView.findViewById(R.id.tweetText);
			viewHolder.txt_img = (ImageView) convertView.findViewById(R.id.img);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.txt_phone.setText(mp.strphone1);
		viewHolder.txt_company.setText(mp.strcompany);
		viewHolder.txt_name.setText(mp.strlinkname);
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 2;
		Bitmap bm = BitmapFactory.decodeFile(mp.strImgPath, options);
		viewHolder.txt_img.setImageBitmap(bm);
		viewHolder.txt_img.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(view.getContext(),Pendingapproval001.class);
				ActivityHelper.filePaths=Mpsbinfolist.get(position).strImgPath;
				view.getContext().startActivity(intent);
				((Activity) context).overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
			}
		});
		return convertView;
	}
	class ViewHolder {
		private TextView txt_name;
		private TextView txt_phone;
		private TextView txt_company;
		private ImageView txt_img;
	}
}
	
	


