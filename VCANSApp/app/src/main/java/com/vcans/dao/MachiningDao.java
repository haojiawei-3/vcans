package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vcans.model.ToupeiInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MachiningDao {

	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;

	public MachiningDao()
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

		String strSQL="DELETE FROM Machining ";

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

		String strSQL="DELETE FROM Machining WHERE TPId="+Integer.valueOf(strIds);

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
			contentValues.put("OrderType", toupei.strOrderType);
			contentValues.put("AimFactoryId", toupei.strAimFactoryId);
			contentValues.put("ColorAllOut", toupei.strColorAllOut);
			contentValues.put("RZFactoryId", toupei.strRZFactoryId);
			contentValues.put("GongXuId", toupei.strGongXuId);
			contentValues.put("GongXuName", toupei.strGongXuName);
			contentValues.put("CompanyOrderId", toupei.strCompanyOrderId);
			contentValues.put("PurchaseId", toupei.strPurchaseId);
			contentValues.put("GoodsId", toupei.strGoodsId);
			contentValues.put("GoodsDescribe", toupei.strGoodsDescribe);
			contentValues.put("StoreDescribe", toupei.strStoreDescribe);
			contentValues.put("StoreFlag", toupei.strStoreFlag);
			contentValues.put("OldPiShu", toupei.nOldPiShu);
			contentValues.put("OldNum", toupei.nOldNum);
			contentValues.put("PiShu", toupei.nPiShu);
			contentValues.put("Num", toupei.nNum);
			contentValues.put("UserId", toupei.strUser);
			contentValues.put("ProType", toupei.strProType);
			contentValues.put("ProTypeId", toupei.strProTypeId);

			rst=(int) mDatabase.insert("Machining", null, contentValues);
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
			item.put("OrderType", cursor.getString(cursor.getColumnIndex("OrderType")));
			item.put("AimFactoryId", cursor.getString(cursor.getColumnIndex("AimFactoryId")));
			item.put("ColorAllOut", cursor.getString(cursor.getColumnIndex("ColorAllOut")));
			item.put("RZFactoryId", cursor.getString(cursor.getColumnIndex("RZFactoryId")));
			item.put("GongXuId", cursor.getString(cursor.getColumnIndex("GongXuId")));
			item.put("GongXuName",cursor.getString(cursor.getColumnIndex("GongXuName")));
			item.put("CompanyOrderId", cursor.getString(cursor.getColumnIndex("CompanyOrderId")));
			item.put("PurchaseId", cursor.getString(cursor.getColumnIndex("PurchaseId")));
			item.put("GoodsId", cursor.getString(cursor.getColumnIndex("GoodsId")));
			item.put("GoodsDescribe", cursor.getString(cursor.getColumnIndex("GoodsDescribe")));
			item.put("StoreDescribe",cursor.getString(cursor.getColumnIndex("StoreDescribe")));
			item.put("StoreFlag", cursor.getString(cursor.getColumnIndex("StoreFlag")));
			item.put("OldPiShu", cursor.getString(cursor.getColumnIndex("OldPiShu")));
			item.put("OldNum", cursor.getString(cursor.getColumnIndex("OldNum")));
			item.put("PiShu", cursor.getString(cursor.getColumnIndex("PiShu")));
			item.put("Num", cursor.getString(cursor.getColumnIndex("Num")));
			item.put("UserId", cursor.getString(cursor.getColumnIndex("UserId")));
			item.put("ProType", cursor.getString(cursor.getColumnIndex("ProType")));
			item.put("ProTypeId", cursor.getString(cursor.getColumnIndex("ProTypeId")));
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
				+" AND OrderType='"+toupei.strOrderType+"'"
				+" AND AimFactoryId='"+toupei.strAimFactoryId+"'"
				+" AND ColorAllOut='"+toupei.strColorAllOut+"'"
				+" AND RZFactoryId='"+toupei.strRZFactoryId+"'"
				+" AND GongXuId='"+toupei.strGongXuId+"'"
				+" AND GongXuName='"+toupei.strGongXuName+"'"
				+" AND CompanyOrderId='"+toupei.strCompanyOrderId+"'"
				+" AND PurchaseId='"+toupei.strPurchaseId+"'"
				+" AND GoodsId='"+toupei.strGoodsId+"'"
				+" AND GoodsDescribe='"+toupei.strGoodsDescribe+"'"
				+" AND StoreDescribe='"+toupei.strStoreDescribe+"'"
				+" AND StoreFlag='"+toupei.strStoreFlag+"'"
				+" AND OldPiShu='"+toupei.nOldPiShu+"'"
				+" AND OldNum='"+toupei.nOldNum+"'"
				+" AND UserId='"+toupei.strUser+"'"
				+" AND ProTypeId='"+toupei.strProTypeId+"'"
				+" AND ProType='"+toupei.strProType+"'";
					/*
					+"AND BackModify='"+toupei.strBackModify+"'"
					+"AND InitPeiBuTR='"+toupei.strInitPeiBuTouRu+"'"
					+"AND PiShu='"+toupei.nPiShu+"'"
					+"AND Num='"+toupei.nNum+"'"
					+"AND UserId='"+toupei.strUser+"'"
					+"AND IsFuHeBu='"+toupei.strIsHuHeBu+"'";
					*/


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


		String strSQL="SELECT OrderType,AimFactoryId,ColorAllOut,RZPlanId,RZFactoryId,GongXuId,GongXuName,CompanyOrderId,"
				+"PurchaseId,GoodsId,GoodsDescribe,StoreDescribe,StoreFlag,OldPiShu,"
				+"OldNum,PiShu,Num,UserId,ProTypeId,ProType,TPId"
				+" FROM Machining";

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
