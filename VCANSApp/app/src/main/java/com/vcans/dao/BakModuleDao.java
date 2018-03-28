package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.GDBakModule;
import com.vcans.model.GDDirectOutInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class BakModuleDao {

	private String mDbPath;
	private SQLiteDatabase mDatabase = null;
	private String mWhereSQL = null;
	private final String tableName = "BakModule";

	public BakModuleDao() {
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
			contentValues.put("BakType",   inputData.strBakType);
			contentValues.put("DataItem1", inputData.strDataItem1);
			contentValues.put("DataItem2", inputData.strDataItem2);
			contentValues.put("BakDate",   inputData.strDate);
			contentValues.put("DataItem3", inputData.strDataItem3);
			contentValues.put("DataItem4", inputData.strDataItem4);
			contentValues.put("DataItem5", inputData.strDataItem5);
			contentValues.put("DataItem6", inputData.strDataItem6);
			contentValues.put("DataItem7", inputData.strDataItem7);

			contentValues.put("FuZhuData1Id", inputData.strFuZhuData1Id);
			contentValues.put("FuZhuData2Id", inputData.strFuZhuData2Id);
			contentValues.put("FuZhuData3Id", inputData.strFuZhuData3Id);
			contentValues.put("FuZhuData4Id", inputData.strFuZhuData4Id);
			contentValues.put("FuZhuData5Id", inputData.strFuZhuData5Id);
			contentValues.put("FuZhuData6Id", inputData.strFuZhuData6Id);
			contentValues.put("FuZhuData7Id", inputData.strFuZhuData7Id);
			contentValues.put("FuZhuData8Id", inputData.strFuZhuData8Id);
			contentValues.put("FuZhuData9Id", inputData.strFuZhuData9Id);
			contentValues.put("FuZhuData1Name", inputData.strFuZhuData1Name);
			contentValues.put("FuZhuData2Name", inputData.strFuZhuData2Name);
			contentValues.put("FuZhuData3Name", inputData.strFuZhuData3Name);
			contentValues.put("FuZhuData4Name", inputData.strFuZhuData4Name);
			contentValues.put("FuZhuData5Name", inputData.strFuZhuData5Name);
			contentValues.put("FuZhuData6Name", inputData.strFuZhuData6Name);
			contentValues.put("FuZhuData7Name", inputData.strFuZhuData7Name);
			contentValues.put("FuZhuData8Name", inputData.strFuZhuData8Name);
			contentValues.put("FuZhuData9Name", inputData.strFuZhuData9Name);

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
			contentValues.put("DelNum", inputData.strDelNum);
			contentValues.put("DelPiShu", inputData.strDelPiShu);
			contentValues.put("Num", inputData.strNum);
			contentValues.put("PiShu", inputData.strPiShu);
			contentValues.put("ImgPath", inputData.strImgPath);
			contentValues.put("UserName", inputData.strUser);
			contentValues.put("BakFlag", inputData.strBakFlag);

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

			item.put("BakType", cursor.getString(cursor.getColumnIndex("BakType")));
			item.put("DataItem1", cursor.getString(cursor.getColumnIndex("DataItem1")));
			item.put("DataItem2", cursor.getString(cursor.getColumnIndex("DataItem2")));
			item.put("BakDate", cursor.getString(cursor.getColumnIndex("BakDate")));
			item.put("DataItem3", cursor.getString(cursor.getColumnIndex("DataItem3")));
			item.put("DataItem4", cursor.getString(cursor.getColumnIndex("DataItem4")));
			item.put("DataItem5", cursor.getString(cursor.getColumnIndex("DataItem5")));
			item.put("DataItem6", cursor.getString(cursor.getColumnIndex("DataItem6")));
			item.put("DataItem7", cursor.getString(cursor.getColumnIndex("DataItem7")));

			item.put("FuZhuData1Id", cursor.getString(cursor.getColumnIndex("FuZhuData1Id")));
			item.put("FuZhuData2Id", cursor.getString(cursor.getColumnIndex("FuZhuData2Id")));
			item.put("FuZhuData3Id", cursor.getString(cursor.getColumnIndex("FuZhuData3Id")));
			item.put("FuZhuData4Id", cursor.getString(cursor.getColumnIndex("FuZhuData4Id")));
			item.put("FuZhuData5Id", cursor.getString(cursor.getColumnIndex("FuZhuData5Id")));
			item.put("FuZhuData6Id", cursor.getString(cursor.getColumnIndex("FuZhuData6Id")));
			item.put("FuZhuData7Id", cursor.getString(cursor.getColumnIndex("FuZhuData7Id")));
			item.put("FuZhuData8Id", cursor.getString(cursor.getColumnIndex("FuZhuData8Id")));
			item.put("FuZhuData9Id", cursor.getString(cursor.getColumnIndex("FuZhuData9Id")));

			item.put("FuZhuData1Name", cursor.getString(cursor.getColumnIndex("FuZhuData1Name")));
			item.put("FuZhuData2Name", cursor.getString(cursor.getColumnIndex("FuZhuData2Name")));
			item.put("FuZhuData3Name", cursor.getString(cursor.getColumnIndex("FuZhuData3Name")));
			item.put("FuZhuData4Name", cursor.getString(cursor.getColumnIndex("FuZhuData4Name")));
			item.put("FuZhuData5Name", cursor.getString(cursor.getColumnIndex("FuZhuData5Name")));
			item.put("FuZhuData6Name", cursor.getString(cursor.getColumnIndex("FuZhuData6Name")));
			item.put("FuZhuData7Name", cursor.getString(cursor.getColumnIndex("FuZhuData7Name")));
			item.put("FuZhuData8Name", cursor.getString(cursor.getColumnIndex("FuZhuData8Name")));
			item.put("FuZhuData9Name", cursor.getString(cursor.getColumnIndex("FuZhuData9Name")));

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

			item.put("DelNum", cursor.getString(cursor.getColumnIndex("DelNum")));
			item.put("DelPiShu", cursor.getString(cursor.getColumnIndex("DelPiShu")));
			item.put("PiShu", cursor.getString(cursor.getColumnIndex("PiShu")));
			item.put("Num", cursor.getString(cursor.getColumnIndex("Num")));
			item.put("UserName", cursor.getString(cursor.getColumnIndex("UserName")));
			item.put("ImgPath", cursor.getString(cursor.getColumnIndex("ImgPath")));
			item.put("BakFlag", cursor.getString(cursor.getColumnIndex("BakFlag")));
			item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));

			list.add(item);
			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return list;
	}

	public GDDirectOutInfo GetSingle(GDDirectOutInfo obj) {
		mWhereSQL = " Where BakType='" + obj.strBakType + "'" +
				" AND DataItem1='" + obj.strDataItem1 + "'"+
				" AND DataItem2='" + obj.strDataItem2 + "'" +
				//" AND BakDate='" + obj.strDate + "'" +
				" AND DataItem3='" + obj.strDataItem3 + "'"+
				" AND DataItem4='" + obj.strDataItem4 + "'"+
				" AND DataItem5='" + obj.strDataItem5 + "'"+
				" AND DataItem6='" + obj.strDataItem6 + "'"+
				" AND DataItem7='" + obj.strDataItem7 + "'"+


				" AND FuZhuData1Id='" + obj.strFuZhuData1Id + "'"+
				" AND FuZhuData2Id='" + obj.strFuZhuData2Id + "'"+
				" AND FuZhuData3Id='" + obj.strFuZhuData3Id + "'"+
				" AND FuZhuData4Id='" + obj.strFuZhuData4Id + "'"+
				" AND FuZhuData5Id='" + obj.strFuZhuData5Id + "'"+
				" AND FuZhuData6Id='" + obj.strFuZhuData6Id + "'"+
				" AND FuZhuData7Id='" + obj.strFuZhuData7Id + "'"+
				" AND FuZhuData8Id='" + obj.strFuZhuData8Id + "'"+
				" AND FuZhuData9Id='" + obj.strFuZhuData9Id + "'"+

				" AND GoodsId='" + obj.goods.strGoodsId+ "'"+
				" AND GoodsDescribe='" + obj.goods.strGoodsDescribe+ "'"+
				" AND StoreDescribe='" + obj.goods.strStoreDescribe+ "'"+
				" AND StoreFlag='" + obj.goods.strStoreFlag+ "'"+
//					" AND PiShu='" + obj.goods.strPiShu+ "'"+
//					" AND Num='" + obj.goods.strNum+ "'"+				
				" AND Remark1='" + obj.goods.strRemark1+ "'"+
				" AND Remark2='" + obj.goods.strRemark2+ "'"+
				" AND Remark3='" + obj.goods.strRemark3+ "'"+
				" AND Remark4='" + obj.goods.strRemark4+ "'"+
				" AND Remark5='" + obj.goods.strRemark5+ "'"+

				" AND UserName='" + obj.strUser + "'"+
				" AND BakFlag='" + obj.strBakFlag + "'";

		Cursor cursor = GetCursor();

		GDDirectOutInfo tempTP = null;

		while (!cursor.isAfterLast()) {
			tempTP = new GDDirectOutInfo();

			//tempTP.strRZPlanId = cursor.getString(cursor.getColumnIndex("RZPlanId"));
			tempTP.strBakType = cursor.getString(cursor.getColumnIndex("BakType"));
			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return tempTP;
	}

	public Cursor GetCursor() {
		mDatabase = SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


		String strSQL = "SELECT BakType,DataItem1,DataItem2,BakDate,DataItem3,DataItem4,DataItem5,DataItem6,DataItem7," +
				"FuZhuData1Id,FuZhuData2Id,FuZhuData3Id,FuZhuData4Id,FuZhuData5Id,FuZhuData6Id,FuZhuData7Id,FuZhuData8Id,FuZhuData9Id," +
				"FuZhuData1Name,FuZhuData2Name,FuZhuData3Name,FuZhuData4Name,FuZhuData5Name,FuZhuData6Name,FuZhuData7Name,FuZhuData8Name,FuZhuData9Name," +
				"GoodsId,GoodsDescribe,StoreDescribe,StoreFlag,GNum,GPiShu," +
				"Remark1,Remark2,Remark3,Remark4,Remark5," +
				"DelPiShu,DelNum,PiShu,Num,UserName,ImgPath,BakFlag,TPId FROM " + tableName + " ";

		if (mWhereSQL != null)
			strSQL += " " + mWhereSQL+" AND BakFlag='"+GDBakModule.gBakFlag+"'";
		else
			strSQL += " WHERE BakFlag='"+GDBakModule.gBakFlag+"'";


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
