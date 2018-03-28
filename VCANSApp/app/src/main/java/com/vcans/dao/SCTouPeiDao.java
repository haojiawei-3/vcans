package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vcans.model.ToupeiInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SCTouPeiDao {

	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;

	public SCTouPeiDao()
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

		String strSQL="DELETE FROM SCTouPei ";
		System.out.println(strSQL+"11111111111111111111111");
		if(strIds!=null)
			strSQL+=" WHERE TPId  IN("+strIds+")";
		System.out.println(strSQL+"22222222222222222222222222");

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

		String strSQL="DELETE FROM SCTouPei WHERE TPId="+Integer.valueOf(strIds);
		System.out.println(strSQL);
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
			contentValues.put("BackModify", toupei.strBackModify);
			contentValues.put("InitPeiBuTR", toupei.strInitPeiBuTouRu);
			contentValues.put("PiShu", toupei.nPiShu);
			contentValues.put("PiCi", toupei.strPiCi);
			contentValues.put("Num", toupei.nNum);
			contentValues.put("UserId", toupei.strUser);
			contentValues.put("IsFuHeBu", toupei.strIsHuHeBu);
			contentValues.put("ProColor", toupei.strColor);
			contentValues.put("ProType", toupei.strProType);
			contentValues.put("ProTypeId", toupei.strProTypeId);


			rst=(int) mDatabase.insert("SCTouPei", null, contentValues);
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
			item.put("BackModify", cursor.getString(cursor.getColumnIndex("BackModify")));
			item.put("InitPeiBuTR", cursor.getString(cursor.getColumnIndex("InitPeiBuTR")));
			item.put("PiShu", cursor.getString(cursor.getColumnIndex("PiShu")));
			item.put("PiCi", cursor.getString(cursor.getColumnIndex("PiCi")));
			item.put("Num", cursor.getString(cursor.getColumnIndex("Num")));
			item.put("UserId", cursor.getString(cursor.getColumnIndex("UserId")));
			item.put("IsFuHeBu", cursor.getString(cursor.getColumnIndex("IsFuHeBu")));
			item.put("ProColor", cursor.getString(cursor.getColumnIndex("ProColor")));
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
				+" AND PiCi='"+toupei.strPiCi+"'"
				+" AND UserId='"+toupei.strUser+"'"
				+" AND ProColor='"+toupei.strColor+"'"
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


		String strSQL="SELECT RZPlanId,RZFactoryId,GongXuId,GongXuName,CompanyOrderId,"
				+"PurchaseId,GoodsId,GoodsDescribe,StoreDescribe,StoreFlag,OldPiShu,"
				+"OldNum,BackModify,InitPeiBuTR,PiShu,PiCi,Num,UserId,IsFuHeBu,ProColor,ProTypeId,ProType,TPId"
				+" FROM SCTouPei";

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
