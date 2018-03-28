package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vcans.model.GDDirectOutInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DirectOutDao {

	private String mDbPath;
	private SQLiteDatabase mDatabase = null;
	private String mWhereSQL = null;
	private final String tableName = "DirectOut";

	public DirectOutDao() {
		mDbPath = DBHelper.CreateTable();
	}

	/**
	 * 删除所有生产投坯信息
	 *
	 * @param barcodes
	 * @return
	 */
	public int DeleteAll(String strIds) {
		mDatabase = SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		String strSQL = "DELETE FROM " + tableName;

		if (strIds != null)
			strSQL += " WHERE TPId  IN(" + strIds + ")";

		try {
			mDatabase.execSQL(strSQL);
			return 1;
		} catch (Exception e) {
			return -1;
		} finally {
			mDatabase.close();
		}

	}

	public int DeleteById(String strIds) {
		mDatabase = SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		String strSQL = "DELETE FROM " + tableName + " WHERE TPId=" + Integer.valueOf(strIds);

		try {
			mDatabase.execSQL(strSQL);
			return 1;
		} catch (Exception e) {
			return -1;
		} finally {
			mDatabase.close();
		}

	}



	public int Add(GDDirectOutInfo inputData) {
		int rst = -1;

		if (GetSingle(inputData) != null) {
			return 0;
		}

		try {
			mDatabase = SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

			ContentValues contentValues = new ContentValues();
			contentValues.put("RZPlanId", inputData.strRZPlanId);
			contentValues.put("DataItem1", inputData.strDataItem1);
			contentValues.put("DataItem2", inputData.strDataItem2);
			contentValues.put("DataItem3", inputData.strDataItem3);
			contentValues.put("FuZhuData1Id", inputData.strFuZhuData1Id);
			contentValues.put("FuZhuData2Id", inputData.strFuZhuData2Id);
			contentValues.put("FuZhuData3Id", inputData.strFuZhuData3Id);
			contentValues.put("FuZhuData4Id", inputData.strFuZhuData4Id);
			contentValues.put("FuZhuData5Id", inputData.strFuZhuData5Id);
			contentValues.put("FuZhuData1Name", inputData.strFuZhuData1Name);
			contentValues.put("FuZhuData2Name", inputData.strFuZhuData2Name);
			contentValues.put("FuZhuData3Name", inputData.strFuZhuData3Name);
			contentValues.put("FuZhuData4Name", inputData.strFuZhuData4Name);
			contentValues.put("FuZhuData5Name", inputData.strFuZhuData5Name);

			contentValues.put("GoodsId", inputData.goods.strGoodsId);
			contentValues.put("GoodsDescribe", inputData.goods.strGoodsDescribe);
			contentValues.put("StoreDescribe", inputData.goods.strStoreDescribe);
			contentValues.put("StoreFlag", inputData.goods.strStoreFlag);
			contentValues.put("GNum",   inputData.goods.strNum);
			contentValues.put("GPiShu", inputData.goods.strPiShu);
			contentValues.put("Remark1", inputData.goods.strRemark1);
			contentValues.put("Remark2", inputData.goods.strRemark2);
			contentValues.put("Remark3", inputData.goods.strRemark3);
			contentValues.put("Remark4", inputData.goods.strRemark4);
			contentValues.put("Remark5", inputData.goods.strRemark5);
			contentValues.put("Num", inputData.strNum);
			contentValues.put("PiShu", inputData.strPiShu);
			contentValues.put("UserName", inputData.strUser);

			rst = (int) mDatabase.insert(tableName, null, contentValues);

		} catch (Exception e) {
			ActivityHelper.ToastShow(null, e.getMessage());
		} finally {
			mDatabase.close();
		}

		return rst;
	}

	/**
	 * 暂时无用
	 * @param recordIds
	 * @return
	 */
	public List<HashMap<String, Object>> GetTeipeiById(String recordIds) {
		if (recordIds != null && !recordIds.equals(""))
			this.mWhereSQL = " Where TPId in (" + recordIds + ")";

		return null;
	}

	public List<HashMap<String,Object> > GetAllInfo()
	{
		Cursor cursor=GetCursor();

		List<HashMap<String, Object> > list = new ArrayList<HashMap<String,Object>>();

		while(!cursor.isAfterLast())
		{
			HashMap<String, Object> item = new HashMap<String, Object>();

			item.put("RZPlanId", cursor.getString(cursor.getColumnIndex("RZPlanId")));
			item.put("DataItem1", cursor.getString(cursor.getColumnIndex("DataItem1")));
			item.put("DataItem2", cursor.getString(cursor.getColumnIndex("DataItem2")));
			item.put("DataItem3", cursor.getString(cursor.getColumnIndex("DataItem3")));

			item.put("FuZhuData1Id", cursor.getString(cursor.getColumnIndex("FuZhuData1Id")));
			item.put("FuZhuData2Id", cursor.getString(cursor.getColumnIndex("FuZhuData2Id")));
			item.put("FuZhuData3Id", cursor.getString(cursor.getColumnIndex("FuZhuData3Id")));
			item.put("FuZhuData4Id", cursor.getString(cursor.getColumnIndex("FuZhuData4Id")));
			item.put("FuZhuData5Id", cursor.getString(cursor.getColumnIndex("FuZhuData5Id")));

			item.put("FuZhuData1Name", cursor.getString(cursor.getColumnIndex("FuZhuData1Name")));
			item.put("FuZhuData2Name", cursor.getString(cursor.getColumnIndex("FuZhuData2Name")));
			item.put("FuZhuData3Name", cursor.getString(cursor.getColumnIndex("FuZhuData3Name")));
			item.put("FuZhuData4Name", cursor.getString(cursor.getColumnIndex("FuZhuData4Name")));
			item.put("FuZhuData5Name", cursor.getString(cursor.getColumnIndex("FuZhuData5Name")));

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

			item.put("Num", cursor.getString(cursor.getColumnIndex("Num")));
			item.put("PiShu", cursor.getString(cursor.getColumnIndex("PiShu")));
			item.put("UserName", cursor.getString(cursor.getColumnIndex("UserName")));
			item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));

			list.add(item);

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return list;
	}

	public GDDirectOutInfo GetSingle(GDDirectOutInfo obj) {
		mWhereSQL = " Where RZPlanId='" + obj.strRZPlanId + "'" +
				" AND DataItem1='" + obj.strDataItem1 + "'"+
				" AND DataItem2='" + obj.strDataItem2 + "'" +
				" AND DataItem3='" + obj.strDataItem3 + "'"+
				" AND FuZhuData1Id='" + obj.strFuZhuData1Id + "'"+
				" AND FuZhuData2Id='" + obj.strFuZhuData2Id + "'"+
				" AND FuZhuData3Id='" + obj.strFuZhuData3Id + "'"+
				" AND FuZhuData4Id='" + obj.strFuZhuData4Id + "'"+
				" AND FuZhuData5Id='" + obj.strFuZhuData5Id + "'"+


				" AND FuZhuData1Name='" + obj.strFuZhuData1Name + "'"+
				" AND FuZhuData2Name='" + obj.strFuZhuData2Name + "'"+
				" AND FuZhuData3Name='" + obj.strFuZhuData3Name + "'"+
				" AND FuZhuData4Name='" + obj.strFuZhuData4Name + "'"+
				" AND FuZhuData5Name='" + obj.strFuZhuData5Name + "'"+

				" AND GoodsId='" + obj.goods.strGoodsId+ "'"+
				" AND GoodsDescribe='" + obj.goods.strGoodsDescribe+ "'"+
				" AND StoreDescribe='" + obj.goods.strStoreDescribe+ "'"+
				" AND StoreFlag='" + obj.goods.strStoreFlag+ "'"+

				" AND Remark1='" + obj.goods.strRemark1+ "'"+
				" AND Remark2='" + obj.goods.strRemark2+ "'"+
				" AND Remark3='" + obj.goods.strRemark3+ "'"+
				" AND Remark4='" + obj.goods.strRemark4+ "'"+
				" AND Remark5='" + obj.goods.strRemark5+ "'"+

				" AND GoodsId='" + obj.goods.strGoodsId+ "'"+
				" AND UserName='" + obj.strUser + "'";


		Cursor cursor = GetCursor();

		GDDirectOutInfo tempTP = null;

		while (!cursor.isAfterLast()) {
			tempTP = new GDDirectOutInfo();

			tempTP.strRZPlanId = cursor.getString(cursor.getColumnIndex("RZPlanId"));

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return tempTP;
	}

	public Cursor GetCursor() {
		mDatabase = SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


		String strSQL = "SELECT RZPlanId,DataItem1,DataItem2,DataItem3," +
				"FuZhuData1Id,FuZhuData2Id,FuZhuData3Id,FuZhuData4Id,FuZhuData5Id," +
				"FuZhuData1Name,FuZhuData2Name,FuZhuData3Name,FuZhuData4Name,FuZhuData5Name," +
				"GoodsId,GoodsDescribe,StoreDescribe,StoreFlag,GNum,GPiShu," +
				"Remark1,Remark2,Remark3,Remark4,Remark5," +
				"PiShu,Num,UserName,TPId FROM " + tableName + " ";

		if (mWhereSQL != null)
			strSQL += " " + mWhereSQL;

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
