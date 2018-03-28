package com.vcans.tool;


import android.content.Context;
import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.ByDownWorkBYProcessor;
import com.vcans.Processor.ByMateLoadDownWorkBYProcessor;
import com.vcans.Processor.DPRZTaskDownWorkBY1Processor;
import com.vcans.Processor.GDQueryProcessor;
import com.vcans.model.SendParam;

import static com.vcans.Processor.Singleton.getDataTrunsfer;

/**
 * Created by vcans-1 on 2017-12-19.
 */

public class ZDYzuheHelper {

    /**
     *
     *   Context   上下文
     *   ZDYzuhe   控件
     *   szData    要上传的数据
     *   gBakFlag  备用几模块
     *   ModuleId  第几个字段
     */
    public static void ZDY(Context context ,ZDYzuhe ZdYzuhe,String[] szData ,String gBakFlag,int ModuleId){
        if (!ZdYzuhe.GetText().equals("")) {
            SendParam sendParam = new SendParam();
            sendParam.parent = (BaseActivity) context;
            sendParam.tip =context.getString(R.string.btn_load)+"...";
            sendParam.szData = szData;
            sendParam.processor = new ByDownWorkBYProcessor(ModuleId,gBakFlag);
            getDataTrunsfer().request(sendParam);
        }else {ActivityHelper.ToastShow((BaseActivity) context,ZdYzuhe.getMenu().title+"不能为空");}
    }
    /**
     *   Context   上下文
     *   ZDYzuhe   控件值
     *   szData    要上传的数据
     *   gBakFlag  备用几模块
     *   ModuleId  第几个字段
     */
    public static void ZDY(Context context ,String TZDYzuhe,String[] szData ,String gBakFlag,int ModuleId) {
        if (!TZDYzuhe.equals("")) {
            SendParam sendParam = new SendParam();
            sendParam.parent = (BaseActivity) context;
            sendParam.tip = context.getString(R.string.btn_load) + "...";
            sendParam.szData = szData;
            sendParam.processor = new ByDownWorkBYProcessor(ModuleId,gBakFlag);
            getDataTrunsfer().request(sendParam);
        } else {
           // ActivityHelper.ToastShow((BaseActivity) context, "备用一不能为空");
        }
    }
    /**
     *   Context   上下文
     *   szData    要上传的数据
     *   gBakFlag  备用几模块
     */
    public static void MateLoad(Context context ,String[] szData ,String gBakFlag) {
        SendParam sendParam = new SendParam();
        sendParam.parent = (BaseActivity) context;
        sendParam.szData=szData;
        sendParam.processor = new ByMateLoadDownWorkBYProcessor(gBakFlag);
        getDataTrunsfer().request(sendParam);
    }
    /**
     *   Context   上下文
     *   ZDYzuhe   控件
     *   szData    要上传的数据
     *   gBakFlag  备用几模块
     *   ModuleId  第几个字段
     */
    public static void GDQuery(Context context ,ZDYzuhe ZdYzuhe ,String[] szData ,String gBakFlag,int ModuleId) {
        if (!ZdYzuhe.GetText().equals("")) {
            SendParam sendParam = new SendParam();
            sendParam.parent = (BaseActivity) context;
            sendParam.tip =context.getString(R.string.btn_load)+"...";
            sendParam.szData = szData;
            sendParam.processor = new GDQueryProcessor(ModuleId,gBakFlag);
            getDataTrunsfer().request(sendParam);
        }else {ActivityHelper.ToastShow((BaseActivity) context,ZdYzuhe.getMenu().title+"不能为空");}
    }
    /**
     *   Context   上下文
     *   ZDYzuhe   控件值
     *   szData    要上传的数据
     *   gBakFlag  备用几模块
     *   ModuleId  第几个字段
     */
    public static void GDQuery(Context context ,String TZDYzuhe,String[] szData ,String gBakFlag,int ModuleId) {
        if (!TZDYzuhe.equals("")) {
            SendParam sendParam = new SendParam();
            sendParam.parent = (BaseActivity) context;
            sendParam.tip = context.getString(R.string.btn_load) + "...";
            sendParam.szData = szData;
            sendParam.processor = new GDQueryProcessor(ModuleId,gBakFlag);
            getDataTrunsfer().request(sendParam);
        } else {
            // ActivityHelper.ToastShow((BaseActivity) context, "备用一不能为空");
        }
    }

}
