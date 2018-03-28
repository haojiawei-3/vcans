package com.vcans.adapter;

import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.adapter.NotapprovedAdapter.ViewHolder;
import com.vcans.model.Information;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class testadapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    List<HashMap<String, Object>> list_comment;
    public testadapter(Context context, List<HashMap<String, Object>> list_comment ) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.list_comment = list_comment;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list_comment.size();
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
    public View getView(int arg0, View convertView, ViewGroup arg2) {
        HashMap<String, Object> s=list_comment.get(3);
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.yp_search_item, null);
            //	int[] szRId={R.id.iv_YPPic,R.id.tvBarcode,R.id.tvPinHao,R.id.tvDecribe};
            viewHolder.TextView1 = (TextView) convertView  .findViewById(R.id.tvBarcode);
            viewHolder.TextView2 = (TextView) convertView.findViewById(R.id.tvPinHao);
            viewHolder.TextView3 = (TextView) convertView.findViewById(R.id.tvDecribe);

            viewHolder.ImageView = (ImageView) convertView.findViewById(R.id.iv_YPPic);

            convertView.setTag(viewHolder);     //gldh rq  dqr  xxlx
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //向TextView中插入数据
        viewHolder.ImageView.setImageBitmap((Bitmap) s.get("images"));
        viewHolder.TextView1.setText(s.get("Barcode").toString());
        viewHolder.TextView2.setText(s.get("PinHao").toString());
        viewHolder.TextView3.setText(s.get("Decribe").toString());
        return convertView;
    }
    class ViewHolder {
        private ImageView ImageView;
        private TextView TextView1;
        private TextView TextView2;
        private TextView TextView3;
    }
}
