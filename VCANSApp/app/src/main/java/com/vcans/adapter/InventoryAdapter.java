package com.vcans.adapter;

import java.util.List;

import com.Vcan.activity.R;
import com.Vcan.activity.MlqdActivity2;
import com.vcans.adapter.NotapprovedAdapter.ViewHolder;
import com.vcans.model.Information;
import com.vcans.model.Mlqd2;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InventoryAdapter extends BaseAdapter {
	List<Mlqd2> mlqd2list;
	private Context context;
	private LayoutInflater inflater;
	ViewHolder viewHolder;
	private CollectInterface collectInterface;
	Bitmap bm;
	Mlqd2  mlqd2;
	String path=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
	SQLiteDatabase db=SQLiteDatabase.openDatabase(path, null, 2);
	Cursor cursor;
	boolean b=false;

	public void setCollectInterface(CollectInterface collectInterface)
	{

		this.collectInterface = collectInterface;
	}

	public InventoryAdapter(Context context,  List<Mlqd2> mlqd2list) {
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
	public View getView(final int position, View convertView, ViewGroup p) {
		mlqd2= (Mlqd2)mlqd2list.get(position);
//	             viewHolder = null;  
//	            if (convertView == null) {  
//	                viewHolder = new ViewHolder();  
		convertView = inflater.inflate(R.layout.inventory1, null);
		ImageView  ImageView = (ImageView) convertView .findViewById(R.id.zt);
		TextView  pmph = (TextView) convertView.findViewById(R.id.tweetName);
		TextView  ms1 = (TextView) convertView.findViewById(R.id.tweetText);
		TextView  ms2 = (TextView) convertView.findViewById(R.id.tweetText1);
		TextView  ms3 = (TextView) convertView.findViewById(R.id.tweetText2);
		View  view =  (View) convertView.findViewById(R.id.tweetDate);
//	            	convertView.setTag(viewHolder);
//	    		}else{

//	    			viewHolder = (ViewHolder) convertView.getTag();	    			
//	    		}
		//向TextView中插入数据
		pmph.setText(mlqd2.strPname+"/"+mlqd2.strPnumber);
		ms1.setText(mlqd2.strDescription1);
		ms2.setText(mlqd2.strDescription2);
		ms3.setText(mlqd2.strDescription3);

		if (!mlqd2.strspare3.equals("null")) {
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = 2;
			bm = BitmapFactory.decodeFile(mlqd2.strspare3, options);
			ImageView.setImageBitmap(bm);

		}else {
			ImageView.setBackgroundResource(R.drawable.no_img);
			bm=null;
		}

		view.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				b=false;
				Mlqd2 mlqd2= mlqd2list.get(position);
				collectInterface.Collect(mlqd2,b);
			}
		});

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
		super.notifyDataSetChanged();
	}

	public List<Mlqd2> getData(){
		return mlqd2list;
	}
	public interface  CollectInterface{

		public void Collect(Mlqd2 mlqd2,boolean b);

	}

}
