package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vcans.model.ToupeiInfo;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class YPQueryDao {

	String mDbPath;
	SQLiteDatabase mDatabase=null;
	SQLiteStatement stmt=null;
	String mWhereSQL=null;
	public final static int TRUN_BEGIN=0;//事务开始
	public final static int TRUN_END=1; //事务结束

	public YPQueryDao()
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

		String strSQL="DELETE FROM YangPin ";

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

		String strSQL="DELETE FROM YangPin WHERE TPId="+Integer.valueOf(strIds);

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

	/**
	 * 批量添加数据
	 * 当 actFlag为0时为事务开始并批量添加数据
	 * 当为1时为事务结束并批量添加结束
	 * 需成对使用
	 * @param toupei
	 * @param actFlag
	 * @return
	 */
	public int AddBatchYPInfo(YPExpInfo toupei,int actFlag)
	{
		int rst=-1;

		String strSQL="INSERT INTO YangPin(Barcode,YPField,YPValue)"
				+ " VALUES(?,?,?)";

		if(stmt==null)
		{
			mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
			stmt=mDatabase.compileStatement(strSQL);
			mDatabase.beginTransaction();
		}

		try
		{
			if(actFlag==0)
			{
				stmt.bindString(1, toupei.strBarcode);
				stmt.bindString(2, toupei.strYPField);
				stmt.bindString(3, toupei.strYPValue);
				stmt.executeInsert();
			}
			else
			{
				mDatabase.setTransactionSuccessful();
				mDatabase.endTransaction();
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


	public int AddToupei(YPExpInfo toupei)
	{
		int rst=-1;

		try
		{
			mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


			ContentValues contentValues=new ContentValues();
			contentValues.put("Barcode", toupei.strBarcode);
			contentValues.put("YPField", toupei.strYPField);
			contentValues.put("YPValue", toupei.strYPValue);



			rst=(int) mDatabase.insert("YangPin", null, contentValues);
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

	public List<HashMap<String,Object> > GetYPInfoById(String barcode)
	{
		if(barcode!=null&&!barcode.equals(""))
			this.mWhereSQL=" Where Barcode='"+barcode+"'";


		return GetAllTeipei();
	}

	public List<HashMap<String,Object> > GetAllTeipei()
	{
		Cursor cursor=GetToupeis();

		List<HashMap<String, Object> > list = new ArrayList<HashMap<String,Object>>();

		while(!cursor.isAfterLast())
		{
			HashMap<String, Object> item = new HashMap<String, Object>();

			item.put("Barcode", cursor.getString(cursor.getColumnIndex("Barcode")));
			item.put("YPField", cursor.getString(cursor.getColumnIndex("YPField")));
			item.put("YPValue",cursor.getString(cursor.getColumnIndex("YPValue")));
			item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));

			list.add(item);

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return list;
	}



	public YPExpInfo GetSCToupei(YPExpInfo toupei)
	{
		mWhereSQL=" Where Barcode='"+toupei.strBarcode+"'";


		Cursor cursor=GetToupeis();

		YPExpInfo tempTP=null;

		while(!cursor.isAfterLast())
		{
			tempTP=new YPExpInfo();

			tempTP.strCusBarcode=cursor.getString(cursor.getColumnIndex("CusBarcode"));

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return tempTP;
	}

	public Cursor GetToupeis()
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


		String strSQL="SELECT Barcode,YPField,YPValue,TPId"
				+" FROM YangPin";

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
