package com.vcans.adapter;
import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.tool.PlProcessor;
import android.content.Context;  
import android.graphics.Bitmap;  
import android.graphics.BitmapFactory; 
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.BaseAdapter;  
import android.widget.ImageView;  
import android.widget.TextView;  
  
public class HorizontalAdapter extends BaseAdapter{  
    private int[] mIconIDs=null;  
    private String[] mTitles;  
    private Context mContext;  
    private LayoutInflater mInflater;  
    Bitmap iconBitmap;  
    private int selectIndex = -1;  
    private Bitmap[] szBitmap=null; 
    BaseActivity mActParent=PlProcessor.mActParent;
  
    public HorizontalAdapter(Context context, String[] titles, int[] ids){  
        this.mContext = context;  
        this.mIconIDs = ids;  
        this.mTitles = titles;  
        szBitmap=null;
        mInflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//LayoutInflater.from(mContext);  
    }  
    
    public HorizontalAdapter(Context context, String[] titles, Bitmap[] bitmaps){  
        this.mContext = context;  
        this.szBitmap = bitmaps; 
        this.mIconIDs=null;
        this.mTitles = titles;  
        mInflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//LayoutInflater.from(mContext);  
    } 
    
    public int getCount() { 
    	
    	int Length=mIconIDs!=null?mIconIDs.length:szBitmap.length;
        return Length;
    }  
    public Object getItem(int position) {  
        return position;  
    }  
  
    public long getItemId(int position) {  
        return position;  
    }  
  
    public View getView(int position, View convertView, ViewGroup parent) {  
  
        ViewHolder holder;  
        if(convertView==null){  
            holder = new ViewHolder();  
            convertView = mInflater.inflate(R.layout.yp_query_imgitem, null);  
            holder.mImage=(ImageView)convertView.findViewById(R.id.img_list_item);  
            holder.mTitle=(TextView)convertView.findViewById(R.id.text_list_item);
            convertView.setTag(holder);  
        }else{  
            holder=(ViewHolder)convertView.getTag();  
        }  
        if(position == selectIndex){  
            convertView.setSelected(true);  
        }else{  
            convertView.setSelected(false);  
        }  
        
        if(mTitles!=null)
        	holder.mTitle.setText(mTitles[position]);
    
        if(mIconIDs!=null)
        	iconBitmap = getPropThumnail(mIconIDs[position]); 
        else
        	iconBitmap=szBitmap[position];// ThumbnailUtils.extractThumbnail(szBitmap[position], 120, 160); //
        
        if (szBitmap.length>0) {
        	holder.mImage.setVisibility(View.VISIBLE);
        	holder.mImage.setImageBitmap(iconBitmap);
        	
		}
        if(iconBitmap==null) {
			holder.mImage.setBackgroundResource(R.drawable.no_img);
			Bitmap bitmap=BitmapFactory.decodeResource(mActParent.getResources(), R.drawable.no_img);
			szBitmap[position]=bitmap;
			 mActParent.setSzBitmap(szBitmap);
		}
          
  
        return convertView;  
    }  
  
    private static class ViewHolder {  
        private TextView mTitle ;
        private ImageView mImage;
    } 
    
    private Bitmap getPropThumnail(int id){  
        //Drawable d = mContext.getResources().getDrawable(id);  
        //Bitmap b =null;// BitmapUtil.drawableToBitmap(d);  
    	Bitmap bmp = BitmapFactory.decodeResource(mContext.getResources(), id);
//      Bitmap bb = BitmapUtil.getRoundedCornerBitmap(b, 100);  
        //int w = mContext.getResources().getDimensionPixelOffset(R.dimen.thumnail_default_width);  
        //int h = mContext.getResources().getDimensionPixelSize(R.dimen.thumnail_default_height);  
          
       // Bitmap thumBitmap = ThumbnailUtils.extractThumbnail(b, w, h);  
          
        return bmp;//thumBitmap;  
    }
    
    
    public void setSelectIndex(int i){  
        selectIndex = i;  
    }  
}