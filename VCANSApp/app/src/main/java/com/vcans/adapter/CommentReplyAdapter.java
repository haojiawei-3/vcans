package com.vcans.adapter;

import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.tool.ActivityHelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CommentReplyAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private List<HashMap<String, Object>> list; 
	private ViewHolder viewHolder;
	private Context mContext;

	public CommentReplyAdapter(Context context,
			List<HashMap<String, Object>> list) {
		inflater = LayoutInflater.from(context);
		// this.list = new ArrayList<HashMap<String, Object>>();
		// this.list.addAll(list);
		this.list = list;
		mContext=context;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public void clearList() {
		this.list.clear();
	}

	public void updateList(List<HashMap<String, Object>> list_comment) {
		this.list.addAll(list_comment);
	}


	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_comment_reply, null);
			viewHolder = new ViewHolder();
			viewHolder.tv_comment_reply_text = (TextView) convertView
					.findViewById(R.id.tv_comment_reply_text);
			viewHolder.tv_comment_reply_writer = (TextView) convertView
					.findViewById(R.id.tv_comment_reply_writer);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
			
		}
		
		String field=list.get(position).get("YPField").toString();
		String value=list.get(position).get("YPValue").toString();
		
		if(field.equals(mContext.getString(R.string.image)))
		{
			String[] szFiles=ActivityHelper.mySplit(value, ";");
			int validNum=0;
			for(String strFile:szFiles)
			{
				if(!strFile.equals(""))
				{
					validNum++;
				}
			}
				
			viewHolder.tv_comment_reply_text.setText(validNum+"/"+szFiles.length);
		}
		else
		{
			viewHolder.tv_comment_reply_text.setText(value);
		}
		
		 viewHolder.tv_comment_reply_writer.setText(field);

		return convertView;
	}

	public class ViewHolder {
		private TextView tv_comment_reply_writer; 
		private TextView tv_comment_reply_text; 
	}
}
