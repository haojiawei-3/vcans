package com.vcans.adapter;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.List;

import com.Vcan.activity.R;
import com.Vcan.activity.MlqdActivity5;
import com.vcans.model.CustomerCollect;
import com.vcans.model.Mlqd2;
import com.vcans.tool.ActivityHelper;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class LangyaAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private Activity mContext;
    SQLiteDatabase	db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
    private LayoutInflater inflater;
    String headerText,headerText1;
    public List<CustomerCollect> mPlanDetails;
    CustomerCollect customerCollect;
    public LangyaAdapter(Activity context, List<CustomerCollect> mPlanDetails) {
        mContext = context;

        inflater = LayoutInflater.from(context);
        this.mPlanDetails = mPlanDetails;

    }

    @Override
    public int getCount() {
        return mPlanDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return mPlanDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder   holder=null;
        ViewHolder1  holder1=null;
        int Type = getItemViewType(position);
        CustomerCollect planDetail = this.mPlanDetails.get(position);
        if (convertView == null) {

            switch (Type) {
                case 0:
                    holder1 = new ViewHolder1();
                    convertView = inflater.inflate(R.layout.list_item_1, null);

                    holder1.text_plan_name = (TextView) convertView.findViewById(R.id.text_plan_name);
                    holder1.text_plan_info = (TextView) convertView.findViewById(R.id.text_plan_info);
                    holder1.text_shu = (TextView) convertView.findViewById(R.id.text);
                    holder1.name = (TextView) convertView.findViewById(R.id.text1);
                    holder1.lxr = (TextView) convertView.findViewById(R.id.text2);
                    holder1.phone = (TextView) convertView.findViewById(R.id.text3);
                    holder1.addr = (TextView) convertView.findViewById(R.id.text4);
                    convertView.setTag(holder1);
                    //   convertView.setTag(R.id.holder1, holder1);
                    break;
                case 1:
                    holder = new ViewHolder();
                    convertView = inflater.inflate(R.layout.list_item, parent, false);

                    holder.text_plan_name = (TextView) convertView.findViewById(R.id.text_plan_name);
                    holder.text_plan_info = (TextView) convertView.findViewById(R.id.text_plan_info);
                    holder.text_shu = (TextView) convertView.findViewById(R.id.text);
                    holder.kehu = (TextView) convertView.findViewById(R.id.text1);
                    convertView.setTag(holder);

                    break;
            }
        } else {
            switch (Type) {
                case 0:
                    holder1 = (ViewHolder1) convertView.getTag();

                    break;
                case 1:
                    holder = (ViewHolder) convertView.getTag();
                    break;
            }
        }

        switch (Type){
            case 0:
                holder1.text_plan_name.setText("价格:"+planDetail.getPrice());
                holder1.text_plan_info.setText("样品条码:"+planDetail.getYpcode());
                holder1.text_shu.setText("数量:"+planDetail.getNumber());
                holder1.name.setText("客户名称:"+planDetail.getKhname());
                holder1.lxr.setText("联系人:"+planDetail.getLinkman());
                holder1.phone.setText("电话:"+planDetail.getPhone());
                holder1.addr.setText("地址:"+planDetail.getAddr());

                break;
            case 1:
                holder.text_plan_name.setText("价格:"+planDetail.getPrice());
                holder.text_plan_info.setText("样品条码:"+planDetail.getYpcode());
                holder.text_shu.setText("数量:"+planDetail.getNumber());
                holder.kehu.setText("客户编号:"+planDetail.getKhcode());
                break;
        }
        return convertView;
    }

    @Override
    public View getHeaderView(final int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        if (convertView == null) {
            holder = new HeaderViewHolder();
            convertView = inflater.inflate(R.layout.proj_plans_header, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.text1);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }

        headerText = this.mPlanDetails.get(position).getStandby1();
        headerText1 = this.mPlanDetails.get(position).getKhname();
        if (headerText.equals("0000")) {
            holder.text.setText("新客户未上传");
        }else if (headerText.equals("0001")) {
            holder.text.setText("未验证客户信息");
        }else {
            holder.text.setText(headerText+"("+headerText1+")");
        }
//
        holder.text.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {
                // TODO Auto-generated method stub
                // customerCollect.remove(customerCollect);
                // db.execSQL("delete from CustomerCollect  where khcode =? ",   new Object[]{headerText});
                ActivityHelper.LangyaAdapterbz=true;
                return false;
            }
        });



        return convertView;
    }



    @Override
    public int getItemViewType(int position) {
        String i=mPlanDetails.get(position).khcode;
        if (i.equals("")) {
            return  0;
        }else {
            return  1;
        }

    }

    //返回你有多少个不同的布局
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getHeaderId(int position) {
        //return the first character of the country as ID because this is what headers are based upon
        return Long.parseLong(this.mPlanDetails.get(position).getStandby1());
    }
    public void setData(List<CustomerCollect> list){
        this.mPlanDetails = list;
        super.notifyDataSetChanged();
    }



    class HeaderViewHolder {
        TextView text;
    }
    // return listDatas.get(position).type;
    class ViewHolder {
        TextView kehu;

        TextView text_shu;

        TextView text_plan_name;

        TextView text_plan_info;
    }

    class ViewHolder1 {
        TextView name;
        TextView lxr;
        TextView phone;
        TextView addr;
        TextView text_shu;
        TextView text_plan_name;
        TextView text_plan_info;
    }


}