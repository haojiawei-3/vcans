package com.vcans.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.Vcan.activity.R;
import com.vcans.model.DataListModel;
import java.util.List;

/**
 * Created by vcans-1 on 2018-02-01.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    // List<HashMap<String,Object>> szBitmap;
    List<DataListModel> szBitmap;
    private CheckInterfaces checkInterface;

    public void setCheckInterfaces(CheckInterfaces checkInterface)
    {
        this.checkInterface = checkInterface;
    }
    //    public  GridViewAdapter(Context context,List<HashMap<String,Object>> szBitmap){
//        this.context = context;
//        this.szBitmap = szBitmap;
//        inflater = LayoutInflater.from(context);
//
//    }
    public  GridViewAdapter(Context context,List<DataListModel> szBitmap){
        this.context = context;
        this.szBitmap = szBitmap;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return szBitmap.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final  DataListModel  Model= szBitmap.get(position);
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.grid_item, null);
            viewHolder.ImageView = (ImageView) convertView .findViewById(R.id.zt);
            viewHolder.CheckBox = (CheckBox) convertView .findViewById(R.id.check_box);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final ViewHolder finalCholder = viewHolder;
        finalCholder.CheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Model.setChoosed(((CheckBox) v).isChecked());
                finalCholder.CheckBox.setChecked(((CheckBox) v).isChecked());
                checkInterface.checkGroup(position,((CheckBox) v).isChecked());
            }
        });
        //viewHolder.ImageView.setImageBitmap((Bitmap) Bitmaps.get("images"));
        viewHolder.ImageView.setImageBitmap((Bitmap) Model.DataList.get("images"));
        viewHolder.CheckBox.setChecked( Model.isChoosed());
        return convertView;
    }

    private  class ViewHolder {
        public   ImageView ImageView;
        public   CheckBox  CheckBox;
    }

//    public void setData(List<HashMap<String,Object>> szBitmap ){
//        this.szBitmap = szBitmap;
////        Log.e("TAG", list+"789456");
//       super.notifyDataSetChanged();
//    }

    public void setData(List<DataListModel> szBitmap ){
        this.szBitmap = szBitmap;
//        Log.e("TAG", list+"789456");
        super.notifyDataSetChanged();
    }

    public interface CheckInterfaces
    {
        /**
         * 选框状态改变触发的事件
         *
         * @param groupPosition
         *            组元素位置
         * @param isChecked
         *            组元素选中与否
         */
        public void checkGroup(int groupPosition, boolean isChecked);


    }
}
