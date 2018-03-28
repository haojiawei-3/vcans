package com.vcans.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by vcans-1 on 2018-03-12.
 */

public class MyApplication   extends Application {
    private static Context context;//全局上下文

    @Override
    public void onCreate(){
        context = getApplicationContext();
    }

    //获取全局的上下文
    public static Context getContext(){
        return context;
    }
}
