package com.vcans.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.Vcan.activity.ByView1Activity;
import com.Vcan.activity.DPRZTask3;
import com.vcans.model.BYModel;
import com.vcans.model.MenuK;
import com.vcans.model.RZTask3;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vcans-1 on 2017-12-21.
 */

public class ByDao {
    String mDbPath;
    SQLiteDatabase mDatabase=null;
    String mWhereSQL=null;
    private final String tableName ="ByModel";
    public ByDao()
    {
        mDbPath=DBHelper.CreateTable();
    }


    /**
     * 删除所有生产投坯信息
     * @param
     * @return
     */
    public int DeleteAll(String strIds)
    {
        mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

        String strSQL="DELETE FROM ByModel ";

        if(strIds!=null)
            strSQL+=" WHERE TPId  IN("+strIds+")";

        try
        {
            mDatabase.execSQL(strSQL);
            return 1;
        }
        catch(Exception e)
        {
            return -1;
        }
        finally
        {
            mDatabase.close();
        }

    }

    public int DeleteById(String strIds)
    {
        mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

        String strSQL="DELETE FROM ByModel WHERE TPId="+Integer.valueOf(strIds);

        try
        {
            mDatabase.execSQL(strSQL);
            return 1;
        }
        catch(Exception e)
        {
            return -1;
        }
        finally
        {
            mDatabase.close();
        }

    }

    public int AddToupei(BYModel toupei)
    {
        int rst=-1;

        if(GetSCToupei(toupei)!=null)
        {return 0;}
        try
        {
            mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
            ContentValues contentValues=new ContentValues();
            contentValues.put("ZhiDuan01Id", toupei.BYName1v);
            contentValues.put("ZhiDuan02Id", toupei.BYName2v);
            contentValues.put("ZhiDuan03Id", toupei.BYName3v);
            contentValues.put("ZhiDuan04Id", toupei.BYName4v);
            contentValues.put("ZhiDuan05Id", toupei.BYName5v);
            contentValues.put("ZhiDuan06Id", toupei.BYName6v);
            contentValues.put("ImgPath", toupei.ImgPath);
            contentValues.put("ZhiDuan07Id", toupei.BYName7v);
            contentValues.put("ZhiDuan08Id", toupei.BYName8v);
            contentValues.put("ZhiDuan09Id", toupei.BYName9v);
            contentValues.put("ZhiDuan10Id", toupei.BYName10v);


            contentValues.put("GoodsId", toupei.GoodsId);
            contentValues.put("GoodsDescribe",toupei .GoodsDescribe);
            contentValues.put("StoreDescribe",toupei .StoreDescribe);
            contentValues.put("StoreFlag", toupei.StoreFlag);
            contentValues.put("GNum",  toupei .GNum);
            contentValues.put("GPiShu",toupei .GPiShu);
            contentValues.put("Remark1",toupei .Remark1);
            contentValues.put("Remark2",toupei .Remark2);
            contentValues.put("Remark3", toupei.Remark3);
            contentValues.put("Remark4",toupei .Remark4);
            contentValues.put("Remark5",toupei .Remark5);



            contentValues.put("ZhiDuan11Id", toupei.BYName11v);
            contentValues.put("ZhiDuan12Id", toupei.BYName12v);
            contentValues.put("ZhiDuan13Id", toupei.BYName13v);
            contentValues.put("ZhiDuan14Id", toupei.BYName14v);
            contentValues.put("ZhiDuan15Id", toupei.BYName15v);
            contentValues.put("ZhiDuan16Id", toupei.BYName16v);
            contentValues.put("ZhiDuan17Id", toupei.BYName17v);
            contentValues.put("ZhiDuan18Id", toupei.BYName18v);
            contentValues.put("ZhiDuan19Id", toupei.BYName19v);
            contentValues.put("ZhiDuan20Id", toupei.BYName20v);
            contentValues.put("ZhiDuan21Id", toupei.BYName21v);
            contentValues.put("ZhiDuan22Id", toupei.BYName22v);
            contentValues.put("ZhiDuan23Id", toupei.BYName23v);
            contentValues.put("ZhiDuan24Id", toupei.BYName24v);
            contentValues.put("ZhiDuan25Id", toupei.BYName25v);
            contentValues.put("ZhiDuan26Id", toupei.BYName26v);
            contentValues.put("ZhiDuan27Id", toupei.BYName27v);
            contentValues.put("ZhiDuan28Id", toupei.BYName26v);
            contentValues.put("ZhiDuan29Id", toupei.BYName27v);
            contentValues.put("ZhiDuan30Id", toupei.BYName30v);



            rst=(int) mDatabase.insert("ByModel", null, contentValues);
        }
        catch(Exception e)
        {
            ActivityHelper.ToastShow(null, e.getMessage());
        }
        finally
        {
            mDatabase.close();
        }

        return rst;
    }

    public List<HashMap<String,Object> > GetTeipeiById(String recordIds)
    {
        if(recordIds!=null&&!recordIds.equals(""))
            this.mWhereSQL=" Where TPId in ("+recordIds+")";


        return GetAllModel();
    }

    public List<HashMap<String,Object> > GetAllModel()
    {
        Cursor cursor=GetCursor() ;

        List<HashMap<String, Object> > list = new ArrayList<HashMap<String,Object>>();

        while(!cursor.isAfterLast())
        {
            HashMap<String, Object> item = new HashMap<String, Object>();

            item.put("ZhiDuan01Id", cursor.getString(cursor.getColumnIndex("ZhiDuan01Id")));
            item.put("ZhiDuan02Id", cursor.getString(cursor.getColumnIndex("ZhiDuan02Id")));
            item.put("ZhiDuan03Id", cursor.getString(cursor.getColumnIndex("ZhiDuan03Id")));
            item.put("ZhiDuan04Id", cursor.getString(cursor.getColumnIndex("ZhiDuan04Id")));
            item.put("ZhiDuan05Id", cursor.getString(cursor.getColumnIndex("ZhiDuan05Id")));
            item.put("ZhiDuan06Id", cursor.getString(cursor.getColumnIndex("ZhiDuan06Id")));
            item.put("ImgPath", cursor.getString(cursor.getColumnIndex("ImgPath")));
            item.put("ZhiDuan07Id", cursor.getString(cursor.getColumnIndex("ZhiDuan07Id")));
            item.put("ZhiDuan08Id", cursor.getString(cursor.getColumnIndex("ZhiDuan08Id")));
            item.put("ZhiDuan09Id", cursor.getString(cursor.getColumnIndex("ZhiDuan09Id")));
            item.put("ZhiDuan10Id", cursor.getString(cursor.getColumnIndex("ZhiDuan10Id")));
            item.put("GoodsId", cursor.getString(cursor.getColumnIndex("GoodsId")));
            item.put("GoodsDescribe", cursor.getString(cursor.getColumnIndex("GoodsDescribe")));
            item.put("StoreDescribe", cursor.getString(cursor.getColumnIndex("StoreDescribe")));
            item.put("StoreFlag", cursor.getString(cursor.getColumnIndex("StoreFlag")));
            item.put("GNum", cursor.getString(cursor.getColumnIndex("GNum")));
            item.put("GPiShu", cursor.getString(cursor.getColumnIndex("GPiShu")));
            item.put("Remark1", cursor.getString(cursor.getColumnIndex("Remark1")));
            item.put("Remark2", cursor.getString(cursor.getColumnIndex("Remark2")));
            item.put("Remark3", cursor.getString(cursor.getColumnIndex("Remark3")));
            item.put("Remark4", cursor.getString(cursor.getColumnIndex("Remark4")));
            item.put("Remark5", cursor.getString(cursor.getColumnIndex("Remark5")));
            item.put("ZhiDuan11Id", cursor.getString(cursor.getColumnIndex("ZhiDuan11Id")));
            item.put("ZhiDuan12Id", cursor.getString(cursor.getColumnIndex("ZhiDuan12Id")));
            item.put("ZhiDuan13Id", cursor.getString(cursor.getColumnIndex("ZhiDuan13Id")));
            item.put("ZhiDuan14Id", cursor.getString(cursor.getColumnIndex("ZhiDuan14Id")));
            item.put("ZhiDuan15Id", cursor.getString(cursor.getColumnIndex("ZhiDuan15Id")));
            item.put("ZhiDuan16Id", cursor.getString(cursor.getColumnIndex("ZhiDuan16Id")));
            item.put("ZhiDuan17Id", cursor.getString(cursor.getColumnIndex("ZhiDuan17Id")));
            item.put("ZhiDuan18Id", cursor.getString(cursor.getColumnIndex("ZhiDuan18Id")));
            item.put("ZhiDuan19Id", cursor.getString(cursor.getColumnIndex("ZhiDuan19Id")));
            item.put("ZhiDuan20Id", cursor.getString(cursor.getColumnIndex("ZhiDuan20Id")));
            item.put("ZhiDuan21Id", cursor.getString(cursor.getColumnIndex("ZhiDuan21Id")));
            item.put("ZhiDuan22Id", cursor.getString(cursor.getColumnIndex("ZhiDuan22Id")));
            item.put("ZhiDuan23Id", cursor.getString(cursor.getColumnIndex("ZhiDuan23Id")));
            item.put("ZhiDuan24Id", cursor.getString(cursor.getColumnIndex("ZhiDuan24Id")));
            item.put("ZhiDuan25Id", cursor.getString(cursor.getColumnIndex("ZhiDuan25Id")));
            item.put("ZhiDuan26Id", cursor.getString(cursor.getColumnIndex("ZhiDuan26Id")));
            item.put("ZhiDuan27Id", cursor.getString(cursor.getColumnIndex("ZhiDuan27Id")));
            item.put("ZhiDuan28Id", cursor.getString(cursor.getColumnIndex("ZhiDuan28Id")));
            item.put("ZhiDuan29Id", cursor.getString(cursor.getColumnIndex("ZhiDuan29Id")));
            item.put("ZhiDuan30Id", cursor.getString(cursor.getColumnIndex("ZhiDuan30Id")));
            item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));

            list.add(item);

            cursor.moveToNext();
        }

        cursor.close();
        mDatabase.close();

        return list;
    }



    public BYModel GetSCToupei(BYModel toupei)
    {
        /**   1
         字段入键 标志是否  纳入  对比  字段*/
        List<MenuK> K=new ArrayList<MenuK>();
        K= ActivityHelper.MenuList;
        mWhereSQL=mWhereSQL(K, toupei);


        /**   2
         全部对比*/
//	   	mWhereSQL=" Where  ZhiDuan01Id='"+toupei.tvBYName1v+"'"
//			    +  "AND ZhiDuan02Id='"+toupei.tvBYName2v+"'"
//				+" AND ZhiDuan03Id='"+toupei.tvBYName3v+"'"
//				+" AND ZhiDuan04Id='"+toupei.tvBYName4v+"'"
//				+" AND ZhiDuan05Id='"+toupei.tvBYName5v+"'"
//				+" AND ZhiDuan06Id='"+toupei.tvBYName6v+"'"
//				+" AND ZhiDuan07Id='"+toupei.tvBYName7v+"'"
//				+" AND ZhiDuan08Id='"+toupei.tvBYName8v+"'"
//				+" AND ZhiDuan09Id='"+toupei.tvBYName9v+"'"
//				+" AND ZhiDuan10Id='"+toupei.tvBYName10v+"'"
//				+" AND ZhiDuan11Id='"+toupei.tvBYName11v+"'"
//				+" AND ZhiDuan12Id='"+toupei.tvBYName12v+"'"
//				+" AND ZhiDuan13Id='"+toupei.tvBYName13v+"'"
//				+" AND ZhiDuan14Id='"+toupei.tvBYName14v+"'"
//				+" AND ZhiDuan15Id='"+toupei.tvBYName15v+"'"
//				+" AND ZhiDuan16Id='"+toupei.tvBYName16v+"'"
//				+" AND ZhiDuan17Id='"+toupei.tvBYName17v+"'"
//				+" AND ZhiDuan18Id='"+toupei.tvBYName18v+"'"
//				+" AND ZhiDuan19Id='"+toupei.tvBYName19v+"'"
//				+" AND ZhiDuan20Id='"+toupei.tvBYName20v+"'"
//				+" AND ZhiDuan21Id='"+toupei.tvBYName21v+"'"
//				+" AND ZhiDuan22Id='"+toupei.tvBYName22v+"'"
//				+" AND ZhiDuan23Id='"+toupei.tvBYName23v+"'"
//				+" AND ZhiDuan24Id='"+toupei.tvBYName24v+"'"
//				+" AND ZhiDuan25Id='"+toupei.tvBYName25v+"'"
//				+" AND ZhiDuan26Id='"+toupei.tvBYName26v+"'"
//				+" AND ZhiDuan27Id='"+toupei.tvBYName27v+"'";

        Cursor cursor=GetCursor();

        BYModel tempTP=null;

        while(!cursor.isAfterLast())
        {
            tempTP=new BYModel();

            tempTP.BYName1v=cursor.getString(cursor.getColumnIndex("ZhiDuan01Id"));

            cursor.moveToNext();
        }

        cursor.close();
        mDatabase.close();

        return tempTP;
    }

    public String   mWhereSQL(List<MenuK> k,BYModel toupei){
        String s1="",s2="",s3="",s4="",s5="",s6="",s7="",s8="",s9 ="",s10="",s11="",s12 ="",s13="",s14="",s15="",s16="",s17="",s18="",s19="",s20="",s21="",s22="",s23="",s24="",s25="",s26="",s27="";
        String s=" Where ";
        if (k.get(0).strEnabled.equals("Y")&&k.get(0).key.equals("Y")) {
            s1=" ZhiDuan01Id='"+toupei.BYName1v+"'";
        }
        if (k.get(1).strEnabled.equals("Y")&&k.get(1).key.equals("Y")) {
            s2="AND ZhiDuan02Id='"+toupei.BYName2v+"'";
        }
        if (k.get(2).strEnabled.equals("Y")&&k.get(2).key.equals("Y")) {
            s3="AND ZhiDuan03Id='"+toupei.BYName3v+"'";
        }
        if (k.get(3).strEnabled.equals("Y")&&k.get(3).key.equals("Y")) {
            s4="AND ZhiDuan04Id='"+toupei.BYName4v+"'";
        }
        if (k.get(4).strEnabled.equals("Y")&&k.get(4).key.equals("Y")) {
            s5="AND ZhiDuan05Id='"+toupei.BYName5v+"'";
        }
        if (k.get(5).strEnabled.equals("Y")&&k.get(5).key.equals("Y")) {
            s6="AND ZhiDuan06Id='"+toupei.BYName6v+"'";
        }
        if (k.get(6).strEnabled.equals("Y")&&k.get(6).key.equals("Y")) {
            s7="AND ZhiDuan07Id='"+toupei.BYName7v+"'";
        }
        if (k.get(7).strEnabled.equals("Y")&&k.get(7).key.equals("Y")) {
            s8="AND ZhiDuan08Id='"+toupei.BYName8v+"'";
        }
        if (k.get(8).strEnabled.equals("Y")&&k.get(8).key.equals("Y")) {
            s9="AND ZhiDuan09Id='"+toupei.BYName9v+"'";
        }
        if (k.get(9).strEnabled.equals("Y")&&k.get(9).key.equals("Y")) {
            s10="AND ZhiDuan10Id='"+toupei.BYName10v+"'";
        }
        if (k.get(10).strEnabled.equals("Y")&&k.get(10).key.equals("Y")) {
            s11="AND ZhiDuan11Id='"+toupei.BYName11v+"'";
        }
        if (k.get(11).strEnabled.equals("Y")&&k.get(11).key.equals("Y")) {
            s12="AND ZhiDuan12Id='"+toupei.BYName12v+"'";
        }
        if (k.get(12).strEnabled.equals("Y")&&k.get(12).key.equals("Y")) {
            s13="AND ZhiDuan13Id='"+toupei.BYName13v+"'";
        }
        if (k.get(13).strEnabled.equals("Y")&&k.get(13).key.equals("Y")) {
            s14="AND ZhiDuan14Id='"+toupei.BYName14v+"'";
        }
        if (k.get(14).strEnabled.equals("Y")&&k.get(14).key.equals("Y")) {
            s15="AND ZhiDuan15Id='"+toupei.BYName15v+"'";
        }
        if (k.get(15).strEnabled.equals("Y")&&k.get(15).key.equals("Y")) {
            s16="AND ZhiDuan16Id='"+toupei.BYName16v+"'";
        }
        if (k.get(16).strEnabled.equals("Y")&&k.get(16).key.equals("Y")) {
            s17="AND ZhiDuan17Id='"+toupei.BYName17v+"'";
        }
        if (k.get(17).strEnabled.equals("Y")&&k.get(17).key.equals("Y")) {
            s18="AND ZhiDuan18Id='"+toupei.BYName18v+"'";
        }
        if (k.get(18).strEnabled.equals("Y")&&k.get(18).key.equals("Y")) {
            s19="AND ZhiDuan19Id='"+toupei.BYName19v+"'";
        }
        if (k.get(19).strEnabled.equals("Y")&&k.get(19).key.equals("Y")) {
            s20="AND ZhiDuan20Id='"+toupei.BYName20v+"'";
        }
        if (k.get(20).strEnabled.equals("Y")&&k.get(20).key.equals("Y")) {
            s21="AND ZhiDuan21Id='"+toupei.BYName21v+"'";
        }
        if (k.get(21).strEnabled.equals("Y")&&k.get(21).key.equals("Y")) {
            s22="AND ZhiDuan22Id='"+toupei.BYName22v+"'";
        }
        if (k.get(22).strEnabled.equals("Y")&&k.get(22).key.equals("Y")) {
            s23="AND ZhiDuan23Id='"+toupei.BYName23v+"'";
        }
        if (k.get(23).strEnabled.equals("Y")&&k.get(23).key.equals("Y")) {
            s24="AND ZhiDuan24Id='"+toupei.BYName24v+"'";
        }
        if (k.get(24).strEnabled.equals("Y")&&k.get(24).key.equals("Y")) {
            s25="AND ZhiDuan25Id='"+toupei.BYName25v+"'";
        }
        if (k.get(25).strEnabled.equals("Y")&&k.get(25).key.equals("Y")) {
            s26="AND ZhiDuan26Id='"+toupei.BYName26v+"'";
        }
//        if (k.get(26).strEnabled.equals("Y")&&k.get(26).key.equals("Y")) {
//            s27="AND ZhiDuan27Id='"+toupei.BYName27v+"'";
//        }
        String s0=s+s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17+s18+s19+s20+s21+s22+s23+s24+s25+s26;
        System.out.println(s0+"     sql");
        return s0;

    }
    public Cursor GetCursor() {
        mDatabase = SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


        String strSQL="SELECT ZhiDuan01Id," +
                "ZhiDuan02Id," +
                "ZhiDuan03Id," +
                "ZhiDuan04Id," +
                "ZhiDuan05Id," +
                "ZhiDuan06Id," +
                "ImgPath," +
                "ZhiDuan07Id," +
                "ZhiDuan08Id," +
                "ZhiDuan09Id," +
                "ZhiDuan10Id," +
                "GoodsId," +
                "GoodsDescribe," +
                "StoreDescribe," +
                "StoreFlag," +
                "GNum," +
                "GPiShu," +
                "Remark1," +
                "Remark2," +
                "Remark3," +
                "Remark4," +
                "Remark5," +
                "ZhiDuan11Id," +
                "ZhiDuan12Id," +
                "ZhiDuan13Id," +
                "ZhiDuan14Id," +
                "ZhiDuan15Id," +
                "ZhiDuan16Id," +
                "ZhiDuan17Id," +
                "ZhiDuan18Id," +
                "ZhiDuan19Id," +
                "ZhiDuan20Id," +
                "ZhiDuan21Id," +
                "ZhiDuan22Id," +
                "ZhiDuan23Id," +
                "ZhiDuan24Id," +
                "ZhiDuan25Id," +
                "ZhiDuan26Id," +
                "ZhiDuan27Id," +
                "ZhiDuan28Id," +
                "ZhiDuan29Id," +
                "ZhiDuan30Id," +
                "TPId"
                +" FROM ByModel";

        if (mWhereSQL != null)
            strSQL += " " + mWhereSQL+" AND ZhiDuan30Id='"+ ByView1Activity.gBakFlag+"'";
        else
            strSQL += " WHERE ZhiDuan30Id='"+ByView1Activity.gBakFlag+"'";   /////////区别是哪一个模块  06  07  08   09  10


        Cursor cursor = null;

        try {
            cursor = mDatabase.rawQuery(strSQL, null);
        } catch (Exception e) {
            e.getMessage();
        }

        if (cursor != null)
            cursor.moveToFirst();

        mWhereSQL = null;

        return cursor;
    }
}
