package com.vcans.adapter;

import java.util.List;

import com.Vcan.activity.R;
import com.vcans.model.Mlqd2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CollectAdapter extends BaseAdapter {
	 List<Mlqd2> mlqd2list;
	    private Context context;  
   private LayoutInflater inflater;  
 
  public CollectAdapter(Context context,  List<Mlqd2> mlqd2list) {  
      this.context = context;  
      inflater = LayoutInflater.from(context);  
      this.mlqd2list = mlqd2list;
  }  
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mlqd2list.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup p) {
			Mlqd2  mlqd2= (Mlqd2)mlqd2list.get(position);  
	            ViewHolder viewHolder = null;  
	            if (convertView == null) {  
	                viewHolder = new ViewHolder();  
	                convertView = inflater.inflate(R.layout.collect, null);  
	                viewHolder.ImageView = (ImageView) convertView .findViewById(R.id.zt);  
	                viewHolder.pmph = (TextView) convertView.findViewById(R.id.pmph);  
	                viewHolder.ms1 = (TextView) convertView.findViewById(R.id.msone);  
	                viewHolder.ms2 = (TextView) convertView.findViewById(R.id.mstow);
	                viewHolder.ms3 = (TextView) convertView.findViewById(R.id.msthree);  
	               		             
	                convertView.setTag(viewHolder);     //gldh rq  dqr  xxlx
	            } else {  
	                viewHolder = (ViewHolder) convertView.getTag();  
	            }  

	            viewHolder.ImageView.setBackgroundResource(R.drawable.shouji); 
	            viewHolder.pmph.setText(mlqd2.strPname+"/"+mlqd2.strPnumber);  
	            viewHolder.ms1.setText(mlqd2.strDescription1);		           
	            viewHolder.ms2.setText(mlqd2.strDescription2);  
	            viewHolder.ms3.setText(mlqd2.strDescription3);  

			return convertView;
		}
		class ViewHolder {  
	        private ImageView ImageView;  
	        private TextView pmph;
	        private TextView ms1;  
	        private TextView ms2; 		     
	        private TextView ms3;  	              
	    }
		public void setData(List<Mlqd2> list){
			this.mlqd2list = list;
			Log.e("TAG", list+"789456");
			super.notifyDataSetChanged();
		}
		
		public List<Mlqd2> getData(){
		       return mlqd2list;
		}
									

}
