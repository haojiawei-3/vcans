package com.vcans.dao;

import java.util.HashMap;
import java.util.List;

import com.vcans.model.ItemTitle;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class ItemTitleDao {

	private String mDbPath;
	private SQLiteDatabase mDatabase = null;
	private String mWhereSQL = null;
	private final String tableName = "UIItemTitle";
	private SQLiteStatement stmt=null;

	public final static int TRUN_BEGIN=0;//事务开始
	public final static int TRUN_END=1; //事务结束
	public HashMap<String, HashMap<String, HashMap<String, String>>> mapSysModules = new HashMap<String, HashMap<String, HashMap<String, String>>>();

	public ItemTitleDao() {
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

	/**
	 * 批量添加数据
	 * 当 actFlag为0时为事务开始并批量添加数据
	 * 当为1时为事务结束并批量添加结束
	 * 需成对使用
	 * @param toupei
	 * @param actFlag 值 0或1
	 * @return
	 */
	public int AddBatchItemTitle(ItemTitle itemTitle,int actFlag)
	{
		int rst=-1;

		String strSQL="INSERT INTO "+tableName+"(SysId,ModuleId,ItemValue,ItemName)" + " VALUES(?,?,?,?)";

		if(stmt==null)
		{
			mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
			stmt=mDatabase.compileStatement(strSQL);
			mDatabase.beginTransaction();                                                          //手动设置开始事务
		}

		try
		{
			if(actFlag==0)
			{
				//系统_模块 _标题_En
				String[] items=itemTitle.itemName.split("_");

				if(items.length>=3)
				{
					stmt.bindString(1, items[0]);
					stmt.bindString(2, items[1]);
					stmt.bindString(3, itemTitle.itemValue);

					if(ItemTitle.EN.contains(items[items.length-1])){
						stmt.bindString(4, items[2]+ItemTitle.EN);
					}
					else{
						stmt.bindString(4, items[2]);
					}

					stmt.executeInsert();
				}
			}
			else
			{
				mDatabase.setTransactionSuccessful();            //设置事务处理成功，不设置会自动回滚不提交。
				mDatabase.endTransaction();                      //处理完成
				rst=1;
			}
		}
		catch(Exception e)
		{
			mDatabase.endTransaction();
			e.getMessage();
		}
		finally
		{
			if(actFlag==1)
			{
				mDatabase.close();
				stmt=null;
			}
		}

		return rst;
	}


	public int AddItemTitle(ItemTitle itemTitle) {
		int rst = -1;

		if (GetItemTitle(itemTitle) != null) {
			return 2;
		}

		try {
			mDatabase = SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

			String[] items=itemTitle.itemName.split("_");

			if(items.length>=3)
			{
				//系统_模块 _标题_En
				ContentValues contentValues = new ContentValues();
				contentValues.put("SysId", items[0]);
				contentValues.put("ModuleId", items[1]);
				contentValues.put("ItemValue", itemTitle.itemValue);

				if(ItemTitle.EN.contains(items[items.length-1]))
					contentValues.put("ItemName", items[2]+ItemTitle.EN);
				else
					contentValues.put("ItemName", items[2]);

				rst = (int) mDatabase.insert(tableName, null, contentValues);
			}



		} catch (Exception e) {
			ActivityHelper.ToastShow(null, e.getMessage());
		} finally {
			mDatabase.close();
		}

		return rst;
	}

	public List<HashMap<String, Object>> GetTeipeiById(String recordIds) {
		if (recordIds != null && !recordIds.equals(""))
			this.mWhereSQL = " Where TPId in (" + recordIds + ")";

		return null;
	}

	public HashMap<String, HashMap<String, HashMap<String, String>>> GetAllItemTitles() {

		Cursor cursor = GetItemTitles();
		HashMap<String, String> mapItemValues;
		HashMap<String, HashMap<String, String>> mapModuleItems;
		HashMap<String, HashMap<String, HashMap<String, String>>> mapSysModule = new HashMap<String, HashMap<String, HashMap<String, String>>>();
		String sysId, moduleId,itemName, itemValue;

		while (!cursor.isAfterLast()) {

			sysId = cursor.getString(cursor.getColumnIndex("SysId"));
			moduleId = cursor.getString(cursor.getColumnIndex("ModuleId"));
			itemName = cursor.getString(cursor.getColumnIndex("ItemName"));
			itemValue = cursor.getString(cursor.getColumnIndex("ItemValue"));

			if (mapSysModule.containsKey(sysId)) {

				mapModuleItems = mapSysModule.get(sysId);
			} else {
				mapModuleItems = new HashMap<String, HashMap<String, String>>();
			}

			if (mapModuleItems.containsKey(moduleId)) {
				mapItemValues = mapModuleItems.get(moduleId);

			} else {
				mapItemValues = new HashMap<String, String>();
			}

			mapItemValues.put(itemName, itemValue);
			mapModuleItems.put(moduleId, mapItemValues);

			mapSysModule.put(sysId, mapModuleItems);

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return mapSysModule;
	}

	public ItemTitle GetItemTitle(ItemTitle itemTitle) {
		mWhereSQL = " Where SysId='" + itemTitle.sysId + "'" + " AND ModuleId='" + itemTitle.moduleId + "'"
				+ " AND ItemName='" + itemTitle.itemName + "'" + " AND ItemValue='" + itemTitle.itemValue + "'";

		Cursor cursor = GetItemTitles();

		ItemTitle tempTP = null;

		while (!cursor.isAfterLast()) {
			tempTP = new ItemTitle();

			tempTP.sysId = cursor.getString(cursor.getColumnIndex("SysId"));

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return tempTP;
	}

	public Cursor GetItemTitles() {
		mDatabase = SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		String strSQL = "SELECT SysId,ModuleId,ItemName,ItemValue,TPId" + " FROM " + tableName + " ";

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
