package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vcans.model.ToupeiInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PeiBuInDao {

	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;

	public PeiBuInDao()
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

		String strSQL="DELETE FROM PeibuIn ";
		System.out.println(strSQL+"1111111111111111111111111");
		if(strIds!=null)
			strSQL+=" WHERE TPId  IN("+strIds+")";
		System.out.println(strSQL+"222222222222222222222222222");

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

		String strSQL="DELETE FROM PeibuIn WHERE TPId="+Integer.valueOf(strIds);
		System.out.println(strSQL+"3333333333333333333333333");
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
			contentValues.put("OutNotifyId", toupei.strOutNotifyId);
			contentValues.put("SupplierId", toupei.strSupplierId);
			contentValues.put("CompanyOrderId", toupei.strCompanyOrderId);
			contentValues.put("PurchaseId", toupei.strPurchaseId);
			contentValues.put("GoodsId", toupei.strGoodsId);
			contentValues.put("GoodsDescribe", toupei.strGoodsDescribe);
			contentValues.put("SendGoodsNum", toupei.strSendGoodsNum);
			contentValues.put("OrderNum", toupei.strOrderNum);
			contentValues.put("GoodsRecordId", toupei.strGoodsRecordId);
			contentValues.put("FabricQuality", toupei.strFabricQuality);
			contentValues.put("PackQuality", toupei.strPackQuality);
			contentValues.put("MaKou",toupei.strMaKou);
			contentValues.put("Remark", toupei.strRemark);
			contentValues.put("Position", toupei.strPosition);
			contentValues.put("PiShu", toupei.nPiShu);
			contentValues.put("PiCi", toupei.strPiCi);
			contentValues.put("Num", toupei.nNum);
			contentValues.put("UserId", toupei.strUser);

			rst=(int) mDatabase.insert("PeibuIn", null, contentValues);
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

			item.put("OutNotifyId", cursor.getString(cursor.getColumnIndex("OutNotifyId")));
			item.put("SupplierId", cursor.getString(cursor.getColumnIndex("SupplierId")));
			item.put("CompanyOrderId", cursor.getString(cursor.getColumnIndex("CompanyOrderId")));
			item.put("PurchaseId", cursor.getString(cursor.getColumnIndex("PurchaseId")));
			item.put("GoodsId", cursor.getString(cursor.getColumnIndex("GoodsId")));
			item.put("GoodsDescribe", cursor.getString(cursor.getColumnIndex("GoodsDescribe")));
			item.put("SendGoodsNum", cursor.getString(cursor.getColumnIndex("SendGoodsNum")));
			item.put("OrderNum", cursor.getString(cursor.getColumnIndex("OrderNum")));
			item.put("GoodsRecordId", cursor.getString(cursor.getColumnIndex("GoodsRecordId")));
			item.put("FabricQuality", cursor.getString(cursor.getColumnIndex("FabricQuality")));
			item.put("PackQuality", cursor.getString(cursor.getColumnIndex("PackQuality")));
			item.put("MaKou", cursor.getString(cursor.getColumnIndex("MaKou")));
			item.put("Remark", cursor.getString(cursor.getColumnIndex("Remark")));
			item.put("Position", cursor.getString(cursor.getColumnIndex("Position")));
			item.put("PiShu", cursor.getString(cursor.getColumnIndex("PiShu")));
			item.put("PiCi", cursor.getString(cursor.getColumnIndex("PiCi")));
			item.put("Num", cursor.getString(cursor.getColumnIndex("Num")));
			item.put("UserId", cursor.getString(cursor.getColumnIndex("UserId")));
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
		mWhereSQL=" Where OutNotifyId='"+toupei.strOutNotifyId+"'"
				+" AND SupplierId='"+toupei.strSupplierId+"'"
				+" AND CompanyOrderId='"+toupei.strCompanyOrderId+"'"
				+" AND PurchaseId='"+toupei.strPurchaseId+"'"
				+" AND GoodsId='"+toupei.strGoodsId+"'"
				+" AND GoodsDescribe='"+toupei.strGoodsDescribe+"'"
				+" AND SendGoodsNum='"+toupei.strSendGoodsNum+"'"
				+" AND OrderNum='"+toupei.strOrderNum+"'"
				+" AND GoodsRecordId='"+toupei.strGoodsRecordId+"'"
				+" AND FabricQuality='"+toupei.strFabricQuality+"'"
				+" AND PackQuality='"+toupei.strPackQuality+"'"
				+" AND MaKou='"+toupei.strMaKou+"'"
				+" AND PiCi='"+toupei.strPiCi+"'"
				//+" AND Remark='"+toupei.strRemark+"'"
				+" AND Position='"+toupei.strPosition+"'"
				+" AND UserId='"+toupei.strUser+"'";
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

			tempTP.strOutNotifyId=cursor.getString(cursor.getColumnIndex("OutNotifyId"));

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return tempTP;
	}

	public Cursor GetToupeis()
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


		String strSQL="SELECT OutNotifyId,SupplierId,CompanyOrderId,"
				+"PurchaseId,GoodsId,GoodsDescribe,SendGoodsNum,OrderNum,GoodsRecordId,FabricQuality,"
				+"PackQuality,MaKou,Remark,Position,PiShu,PiCi,Num,UserId,TPId"
				+" FROM PeibuIn";

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
