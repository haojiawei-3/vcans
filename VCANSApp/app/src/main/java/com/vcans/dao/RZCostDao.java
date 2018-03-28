package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vcans.model.ToupeiInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RZCostDao {

	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;

	public RZCostDao()
	{
		mDbPath=DBHelper.CreateTable();
	}


	/**
	 * 删除所有生产投坯信息
	 * @param barcodes
	 * @return
	 */
	public int DeleteAll(String strIds)
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		String strSQL="DELETE FROM RZCost ";

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

		String strSQL="DELETE FROM RZCost WHERE TPId="+Integer.valueOf(strIds);

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

	public int AddToupei(ToupeiInfo toupei)
	{
		int rst=-1;

		if(GetSCToupei(toupei)!=null)
		{
			return 0;
		}

		try
		{
			mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


			ContentValues contentValues=new ContentValues();
			contentValues.put("RZPlanId", toupei.strRZPlanId);
			contentValues.put("RZFactoryId", toupei.strRZFactoryId);
			contentValues.put("RZFactoryName", toupei.strRZFactoryName);
			contentValues.put("GongXuId", toupei.strGongXuId);
			contentValues.put("GongXuName", toupei.strGongXuName);
			contentValues.put("CostSelectId", toupei.strCostSelectId);
			contentValues.put("CostSelectName", toupei.strCostSelectName);
			contentValues.put("Cost", toupei.strCost);
			contentValues.put("Remark", toupei.strRemark);
			contentValues.put("Num", toupei.nNum);
			contentValues.put("PiShu", toupei.nPiShu);
			contentValues.put("UserName", toupei.strUser);


			rst=(int) mDatabase.insert("RZCost", null, contentValues);
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


		return GetAllTeipei();
	}

	public List<HashMap<String,Object> > GetAllTeipei()
	{
		Cursor cursor=GetToupeis();

		List<HashMap<String, Object> > list = new ArrayList<HashMap<String,Object>>();

		while(!cursor.isAfterLast())
		{
			HashMap<String, Object> item = new HashMap<String, Object>();


			item.put("RZPlanId", cursor.getString(cursor.getColumnIndex("RZPlanId")));
			item.put("RZFactoryId", cursor.getString(cursor.getColumnIndex("RZFactoryId")));
			item.put("RZFactoryName", cursor.getString(cursor.getColumnIndex("RZFactoryName")));
			item.put("GongXuId", cursor.getString(cursor.getColumnIndex("GongXuId")));
			item.put("GongXuName",cursor.getString(cursor.getColumnIndex("GongXuName")));
			item.put("Cost", cursor.getString(cursor.getColumnIndex("Cost")));
			item.put("CostSelectId",cursor.getString(cursor.getColumnIndex("CostSelectId")));
			item.put("CostSelectName",cursor.getString(cursor.getColumnIndex("CostSelectName")));
			item.put("Num", cursor.getString(cursor.getColumnIndex("Num")));
			item.put("PiShu", cursor.getString(cursor.getColumnIndex("PiShu")));
			item.put("Remark", cursor.getString(cursor.getColumnIndex("Remark")));
			item.put("UserName", cursor.getString(cursor.getColumnIndex("UserName")));
			item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));

			list.add(item);

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return list;
	}



	public ToupeiInfo GetSCToupei(ToupeiInfo toupei)
	{
		mWhereSQL=" Where RZPlanId='"+toupei.strRZPlanId+"'"
				+" AND RZFactoryId='"+toupei.strRZFactoryId+"'"
				+" AND RZFactoryName='"+toupei.strRZFactoryName+"'"
				+" AND GongXuId='"+toupei.strGongXuId+"'"
				+" AND GongXuName='"+toupei.strGongXuName+"'"
				//+" AND Cost='"+toupei.strCost+"'"
				+" AND CostSelectId='"+toupei.strCostSelectId+"'"
				+" AND CostSelectName='"+toupei.strCostSelectName+"'"
				//+" AND Num='"+toupei.nNum+"'"
				//+" AND PiShu='"+toupei.nPiShu+"'"
				+" AND UserName='"+toupei.strUser+"'";

		Cursor cursor=GetToupeis();

		ToupeiInfo tempTP=null;

		while(!cursor.isAfterLast())
		{
			tempTP=new ToupeiInfo();

			tempTP.strRZPlanId=cursor.getString(cursor.getColumnIndex("RZPlanId"));

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return tempTP;
	}

	public Cursor GetToupeis()
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


		String strSQL="SELECT RZPlanId,RZFactoryId,RZFactoryName,GongXuId,GongXuName,"
				+"Cost,CostSelectId,CostSelectName,Remark,Num,PiShu,UserName,TPId"
				+" FROM RZCost";

		if(mWhereSQL!=null)
			strSQL+=" "+mWhereSQL;

		Cursor cursor=null;

		try
		{
			cursor=mDatabase.rawQuery(strSQL, null);
		}
		catch(Exception e)
		{
			e.getMessage();
		}

		if(cursor!=null)
			cursor.moveToFirst();

		mWhereSQL=null;

		return cursor;
	}
}
