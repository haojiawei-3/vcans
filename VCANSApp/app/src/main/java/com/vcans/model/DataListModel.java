package com.vcans.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by vcans-1 on 2018-02-24.
 */

public class DataListModel extends BaseInfo implements Serializable {
    public HashMap<String,Object>  DataList;
    public String  imgname;

    public DataListModel(){

    }
    public DataListModel(HashMap<String,Object>  DataList, String  imgname){
        this.DataList=DataList;
        this.imgname=imgname;
    }
    public DataListModel(HashMap<String,Object>  DataList){
        this.DataList=DataList;
    }
}
