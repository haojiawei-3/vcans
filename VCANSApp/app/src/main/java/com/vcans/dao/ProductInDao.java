package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vcans.model.ToupeiInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProductInDao {

	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;

	public ProductInDao()
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

		String strSQL="DELETE FROM ProductIn ";

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

		String strSQL="DELETE FROM ProductIn WHERE TPId="+Integer.valueOf(strIds);

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
			contentValues.put("PiShu", toupei.nPiShu);
			contentValues.put("PiCi", toupei.strPiCi);
			contentValues.put("Num", toupei.nNum);
			contentValues.put("DelPiShu", toupei.strDelPiShu);
			contentValues.put("DelNum", toupei.strDelNum);
			contentValues.put("CheckStatusId", toupei.strCheckStatusId);
			contentValues.put("CheckStatusName",toupei.strCheckStatusName);
			contentValues.put("FabricQuality", toupei.strFabricQuality);
			contentValues.put("KGToM", toupei.strKGToM);
			contentValues.put("FlowerType",toupei.strFlowerType);
			contentValues.put("Color", toupei.strColor);
			contentValues.put("Price", toupei.strPrice);
			contentValues.put("Unit", toupei.strUnit);
			contentValues.put("UserId", toupei.strUser);
			contentValues.put("IsFuHeBu", toupei.strIsHuHeBu);
			contentValues.put("ProType", toupei.strProType);
			contentValues.put("ProTypeId", toupei.strProTypeId);

			contentValues.put("GongyiId2_1", toupei.strGongyiId2_1);
			contentValues.put("GongyiId2_2", toupei.strGongyiId2_2);
			contentValues.put("GongyiId2_3", toupei.strGongyiId2_3);
			contentValues.put("GongyiName2_1", toupei.strGongyiName2_1);
			contentValues.put("GongyiName2_2", toupei.strGongyiName2_2);
			contentValues.put("GongyiName2_3", toupei.strGongyiName2_3);


			rst=(int) mDatabase.insert("ProductIn", null, contentValues);
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
			item.put("PiShu", cursor.getString(cursor.getColumnIndex("PiShu")));
			item.put("PiCi", cursor.getString(cursor.getColumnIndex("PiCi")));
			item.put("Num", cursor.getString(cursor.getColumnIndex("Num")));
			item.put("DelPiShu", cursor.getString(cursor.getColumnIndex("DelPiShu")));
			item.put("DelNum", cursor.getString(cursor.getColumnIndex("DelNum")));
			item.put("CheckStatusId", cursor.getString(cursor.getColumnIndex("CheckStatusId")));
			item.put("CheckStatusName", cursor.getString(cursor.getColumnIndex("CheckStatusName")));
			item.put("FabricQuality", cursor.getString(cursor.getColumnIndex("FabricQuality")));
			item.put("KGToM", cursor.getString(cursor.getColumnIndex("KGToM")));
			item.put("FlowerType", cursor.getString(cursor.getColumnIndex("FlowerType")));
			item.put("Color", cursor.getString(cursor.getColumnIndex("Color")));
			item.put("Price", cursor.getString(cursor.getColumnIndex("Price")));
			item.put("Unit", cursor.getString(cursor.getColumnIndex("Unit")));
			item.put("UserId", cursor.getString(cursor.getColumnIndex("UserId")));
			item.put("IsFuHeBu", cursor.getString(cursor.getColumnIndex("IsFuHeBu")));
			item.put("ProType", cursor.getString(cursor.getColumnIndex("ProType")));
			item.put("ProTypeId", cursor.getString(cursor.getColumnIndex("ProTypeId")));

			item.put("GongyiName2_1", cursor.getString(cursor.getColumnIndex("GongyiName2_1")));
			item.put("GongyiName2_2", cursor.getString(cursor.getColumnIndex("GongyiName2_2")));
			item.put("GongyiName2_3", cursor.getString(cursor.getColumnIndex("GongyiName2_3")));

			item.put("GongyiId2_1", cursor.getString(cursor.getColumnIndex("GongyiId2_1")));
			item.put("GongyiId2_2", cursor.getString(cursor.getColumnIndex("GongyiId2_2")));
			item.put("GongyiId2_3", cursor.getString(cursor.getColumnIndex("GongyiId2_3")));
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
				+" AND CheckStatusId='"+toupei.strCheckStatusId+"'"
				+" AND CheckStatusName='"+toupei.strCheckStatusName+"'"
				+" AND FabricQuality='"+toupei.strFabricQuality+"'"
				+" AND FlowerType='"+toupei.strFlowerType+"'"
				+" AND Color='"+toupei.strColor+"'"
				+" AND PiCi='"+toupei.strPiCi+"'"
				+" AND Unit='"+toupei.strUnit+"'"
				+" AND UserId='"+toupei.strUser+"'"
				+" AND ProTypeId='"+toupei.strProTypeId+"'"
				+" AND ProType='"+toupei.strProType+"'"
				+" AND GongyiId2_1='"+toupei.strGongyiId2_1+"'"
				+" AND GongyiId2_2='"+toupei.strGongyiId2_2+"'"
				+" AND GongyiId2_3='"+toupei.strGongyiId2_3+"'"
				+" AND GongyiName2_1='"+toupei.strGongyiName2_1+"'"
				+" AND GongyiName2_2='"+toupei.strGongyiName2_2+"'"
				+" AND GongyiName2_3='"+toupei.strGongyiName2_3+"'";
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
				+"OldNum,PiShu,PiCi,Num,DelPiShu,DelNum,CheckStatusId,"
				+"CheckStatusName,FabricQuality,KGToM,FlowerType,Color,"
				+"Price,Unit,UserId,IsFuHeBu,ProTypeId,ProType,"
				+"GongyiName2_1,GongyiName2_2,GongyiName2_3,GongyiId2_1,GongyiId2_2,GongyiId2_3,TPId"
				+" FROM ProductIn";

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
