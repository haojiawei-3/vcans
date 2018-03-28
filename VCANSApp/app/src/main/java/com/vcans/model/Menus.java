package com.vcans.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vcans-1 on 2018-01-31.
 */

public class Menus {
    /**
     * 启用
     */
    public String strEnabled="";
    /**
     * 标题
     */
    public String title="";
    /**
     * 类型
     */
    public String type="";
    /**
     * 允许为空
     */
    public String notnull="";

    public List<String> s;

    public Menus(String strEnabled, String type , String  notnull, String title, List<String> s) {
        super();
        this.strEnabled = strEnabled;
        this.title = title;
        this.type = type;
        this.s = s;
        this.notnull = notnull;

    }
    public Menus() {

    }

}
