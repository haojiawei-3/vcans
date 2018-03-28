package com.vcans.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.adapter.MyListView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CommentAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private ViewHolder viewHolder;
	private List<HashMap<String, Object>> list_comment; 
	private List<List<HashMap<String, Object>>> list_comment_child; 
	private Context context;
	private OnClickListener myOnitemcListener;
	private int selectIndex=-1;
	
	private OnTouchListener onTouchListener;
	
	public void setOnTouchListener(OnTouchListener onTouchListener) {
		this.onTouchListener = onTouchListener;
	}

	private CommentReplyAdapter myAdapter;

	public CommentAdapter(Context context,List<HashMap<String, Object>> list_comment,List<List<HashMap<String, Object>>> list_comment_child,OnClickListener myOnitemcListener, CommentReplyAdapter myAdapter) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		this.myAdapter = myAdapter;
		this.list_comment = new ArrayList<HashMap<String, Object>>();
		this.list_comment_child = new ArrayList<List<HashMap<String, Object>>>();
		this.myOnitemcListener = myOnitemcListener;
		this.list_comment.addAll(list_comment);
		this.list_comment_child.addAll(list_comment_child);

	}

	public void clearList() {
		this.list_comment.clear();
		this.list_comment_child.clear();
	}

	public void updateList(List<HashMap<String, Object>> list_comment,
			List<List<HashMap<String, Object>>> list_comment_child) {
		this.list_comment.addAll(list_comment);
		this.list_comment_child.addAll(list_comment_child);
	}


	public int getCount() {
		// TODO Auto-generated method stub
		return list_comment.size();
	}

	
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list_comment.get(position);
	}


	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_comment, null);
			viewHolder = new ViewHolder();
			//viewHolder.iv_user_photo = (ImageView) convertView
			//		.findViewById(R.id.iv_user_photo);
			viewHolder.tv_user_name = (TextView) convertView
					.findViewById(R.id.tv_user_name);
			
			viewHolder.LLayoutItem = (LinearLayout) convertView
					.findViewById(R.id.LLayoutItem);
			//viewHolder.tv_user_comment = (TextView) convertView
			//		.findViewById(R.id.tv_user_comment);

			//viewHolder.tv_user_reply = (TextView) convertView
			//		.findViewById(R.id.tv_user_reply);
			viewHolder.lv_user_comment_replys = (MyListView) convertView
					.findViewById(R.id.lv_user_comment_replys);
		
			//viewHolder.tv_user_reply.setTag(position);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		if(position == selectIndex){  
			viewHolder.LLayoutItem.setBackgroundDrawable(this.context.getResources().getDrawable(R.color.chengse));
        }else{  
            //convertView.setSelected(false);  
            viewHolder.LLayoutItem.setBackgroundColor(Color.WHITE);
        } 
		
		//viewHolder.tv_user_name.setText(" ");
		//viewHolder.tv_user_comment.setText(list_comment.get(position)
		//		.get("YPValue").toString());
		//viewHolder.lv_user_comment_replys.setSelector(new ColorDrawable(
		//		Color.TRANSPARENT));
		// if (list_comment_child.size() > position)
		if (list_comment_child.get(position) != null)
			viewHolder.lv_user_comment_replys
					.setAdapter(new CommentReplyAdapter(context,
							list_comment_child.get(position)));
		
		viewHolder.lv_user_comment_replys.setId(position);
		
		viewHolder.lv_user_comment_replys.setOnTouchListener(onTouchListener);

		// if (myAdapter == null) {
		// myAdapter = new CommentReplyAdapter(context,
		// list_comment_child.get(position));
		// viewHolder.lv_user_comment_replys.setAdapter(myAdapter);
		// } else {
		// myAdapter.notifyDataSetChanged();
		// }
		//viewHolder.tv_user_reply.setTag(position);
		//viewHolder.tv_user_reply.setOnClickListener(myOnitemcListener);
		return convertView;
	}
	
	
	public void setSelectIndex(int i){  
        selectIndex = i;  
    }  

	public class ViewHolder {
		private ImageView iv_user_photo; // 
		private TextView tv_user_name; // 
		private TextView tv_user_comment; 
		// private TextView tv_user_comment_date; //
		private TextView tv_user_reply; 
		private MyListView lv_user_comment_replys; 
		private LinearLayout LLayoutItem; 

	}
}
