package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class CollectDao {
	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;
	private final String tableName ="Collect";
	HashMap<String, Object> item;
	public CollectDao()
	{
		mDbPath=DBHelper.CreateTable();
	}


	/**
	 * 删除所有审批信息
	 * @param barcodes
	 * @return
	 */
	public int DeleteAll(String strIds)
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		String strSQL="DELETE FROM Collect ";
		//System.out.println(strSQL+"删除的sql语句");

		if(strIds!=null)
			strSQL+=" WHERE TPId  IN("+strIds+")";
		System.out.println(strSQL+"删除的sql语句");

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
	 * 删除单笔审批信息
	 * @param barcodes
	 * @return
	 */
	public int DeleteById(String strIds)
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
		String strSQL="DELETE FROM Collect WHERE TPId="+Integer.valueOf(strIds);
		System.out.println(strSQL+"删除的sql");
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


	public List<HashMap<String,Object> > GetAlldwsp(String id)
	{
		Cursor cursor=Getdwsp(id);
		List<HashMap<String, Object> > list = new ArrayList<HashMap<String,Object>>();

		while(!cursor.isAfterLast())
		{
			item = new HashMap<String, Object>();
			item.put("Type", cursor.getString(cursor.getColumnIndex("Type")));
			item.put("Themer", cursor.getString(cursor.getColumnIndex("Themer")));
			item.put("StateId", cursor.getString(cursor.getColumnIndex("StateId")));
			item.put("State", cursor.getString(cursor.getColumnIndex("State")));
			item.put("OddId", cursor.getString(cursor.getColumnIndex("OddId")));
			item.put("Odd", cursor.getString(cursor.getColumnIndex("Odd")));
			item.put("ModuletypeId", cursor.getString(cursor.getColumnIndex("ModuletypeId")));
			item.put("Moduletype", cursor.getString(cursor.getColumnIndex("Moduletype")));
			item.put("ModuleName", cursor.getString(cursor.getColumnIndex("ModuleName")));
			item.put("Initiator", cursor.getString(cursor.getColumnIndex("Initiator")));
			item.put("Content", cursor.getString(cursor.getColumnIndex("Content")));
			item.put("Date", cursor.getString(cursor.getColumnIndex("Date")));
			item.put("Spare1", cursor.getString(cursor.getColumnIndex("Spare1")));
			item.put("Spare2", cursor.getString(cursor.getColumnIndex("Spare2")));
			item.put("Spare3", cursor.getString(cursor.getColumnIndex("Spare3")));
			item.put("Spare4", cursor.getString(cursor.getColumnIndex("Spare4")));
			item.put("Spare5", cursor.getString(cursor.getColumnIndex("Spare5")));
			item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));
			item.put("XXId", cursor.getString(cursor.getColumnIndex("XXId")));
			list.add(item);
			cursor.moveToNext();
		}
		System.out.println(list);
		mDatabase.close();

		return list;
	}

	public List<HashMap<String,Object> > GetAlldwsp1(ArrayList<String> listid)
	{
		Cursor cursor=Getdwsp1(listid);
		List<HashMap<String, Object> > list = new ArrayList<HashMap<String,Object>>();

		while(!cursor.isAfterLast())
		{
			item = new HashMap<String, Object>();
			item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));
			item.put("Code", cursor.getString(cursor.getColumnIndex("Code")));
			item.put("Pnumber", cursor.getString(cursor.getColumnIndex("Pnumber")));
			item.put("Pname", cursor.getString(cursor.getColumnIndex("Pname")));
			item.put("Description1", cursor.getString(cursor.getColumnIndex("Description1")));
			item.put("Description2", cursor.getString(cursor.getColumnIndex("Description2")));
			item.put("Description3", cursor.getString(cursor.getColumnIndex("Description3")));
			item.put("Filter1", cursor.getString(cursor.getColumnIndex("Filter1")));
			item.put("Filter2", cursor.getString(cursor.getColumnIndex("Filter2")));
			item.put("Filter3", cursor.getString(cursor.getColumnIndex("Filter3")));
			item.put("mulu2", cursor.getString(cursor.getColumnIndex("mulu2")));
			item.put("mulu3", cursor.getString(cursor.getColumnIndex("mulu3")));
			item.put("Quotation", cursor.getString(cursor.getColumnIndex("Quotation")));
			item.put("Spare", cursor.getString(cursor.getColumnIndex("Spare")));
			item.put("Spare1", cursor.getString(cursor.getColumnIndex("Spare1")));
			item.put("Spare2", cursor.getString(cursor.getColumnIndex("Spare2")));
			item.put("Spare3", cursor.getString(cursor.getColumnIndex("Spare3")));
			item.put("Spare4", cursor.getString(cursor.getColumnIndex("Spare4")));

			list.add(item);
			cursor.moveToNext();
		}
		System.out.println(list);
		mDatabase.close();

		return list;
	}

	public Cursor Getdwsp(String id)
	{// Type Themer Initiator Content StateId State Moduletype ModuletypeId Odd OddId GlxxId Cztype CzId Czname
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
		String strSQL="SELECT * FROM Collect where TPId = "+id+" ";

		if(mWhereSQL!=null)
			strSQL+=" "+mWhereSQL;
		System.out.println(strSQL);
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

	public Cursor Getdwsp1(ArrayList<String> listid)
	{    String id="TPId =";
		String id1=" or TPId =";
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
		for (int i = 0; i < listid.size(); i++) {
			if (i==listid.size()-1) {
				id+="'"+listid.get(i)+"'";
			}else {
				id+="'"+listid.get(i)+"'"+id1;
			}
		}
		String strSQL="SELECT * FROM Collect where  "+id+" ";
		Log.e("TAG", strSQL+"======================");

		if(mWhereSQL!=null)
			strSQL+=" "+mWhereSQL;
		System.out.println(strSQL);
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


	public Cursor Getdwsp()
	{// Type Themer Initiator Content StateId State Moduletype ModuletypeId Odd OddId GlxxId Cztype CzId Czname
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
		String strSQL="SELECT Type,Themer,Initiator,  "
				+"Content,StateId,State,Moduletype,ModuletypeId,"
				+"Odd,OddId,GlxxId,Cztype,CzId,Czname,TPId"
				+" FROM Collect";

		if(mWhereSQL!=null)
			strSQL+=" "+mWhereSQL;
		System.out.println(strSQL);
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

