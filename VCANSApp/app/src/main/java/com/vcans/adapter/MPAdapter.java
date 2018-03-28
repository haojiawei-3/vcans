package com.vcans.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Vcan.activity.Pendingapproval001;
import com.Vcan.activity.R;
import com.vcans.model.Mpsbinfo;
import com.vcans.tool.ActivityHelper;

import java.util.List;

/**
 * Created by vcans-1 on 2018-03-05.
 */

public class MPAdapter extends RecyclerView.Adapter<MPAdapter.MyViewHolder>   {
    Context mContext;
    List<Mpsbinfo> datas;
    private MPAdapter.OnItemClickListener onItemClickListener;


        public void setOnItemClickListener(MPAdapter.OnItemClickListener listener) {
            this.onItemClickListener = listener;
   }

    public MPAdapter(Context context, List<Mpsbinfo> datas) {
        mContext=context;
        this.datas=datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // if(viewType==0){
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_animation, parent, false);//这个布局就是一个imageview用来显示图片
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final  Mpsbinfo  Model= datas.get(position);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        Bitmap bm = BitmapFactory.decodeFile(Model.strImgPath, options);
        holder.txt_img.setImageBitmap(bm);
        holder.txt_name.setText(Model.strlinkname);
        holder.txt_phone.setText(Model.strphone1);
        holder.txt_company.setText(Model.strcompany);
       // bm.recycle();
        holder.txt_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),Pendingapproval001.class);
                ActivityHelper.filePaths=datas.get(position).strImgPath;
                view.getContext().startActivity(intent);
                ((Activity) mContext).overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if(onItemClickListener != null) {
                    int pos = holder.getPosition();
                    onItemClickListener.onItemClick(holder.itemView, pos);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(onItemClickListener != null) {
                    int pos = holder.getPosition();
                    onItemClickListener.onItemLongClick(holder.itemView, pos);
                }
                //表示此事件已经消费，不会触发单击事件
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
       // datas.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView txt_name;
        private TextView txt_phone;
        private TextView txt_company;
        private ImageView txt_img;

        public MyViewHolder(View view)
        {
            super(view);
            txt_img = (ImageView) view.findViewById(R.id.img);
            txt_name = (TextView) view.findViewById(R.id.tweetName);
            txt_phone = (TextView) view.findViewById(R.id.tweetDate);
            txt_company = (TextView) view.findViewById(R.id.tweetText);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void addData(int pos,Mpsbinfo data) {
        datas.add(pos, data);
        notifyItemInserted(pos);
    }

    public void deleteData(int pos) {
        datas.remove(pos);
        notifyItemRemoved(pos);
    }
}
