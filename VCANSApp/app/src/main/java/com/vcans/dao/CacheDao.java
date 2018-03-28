package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CacheDao {
	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;
	private final String tableName ="CustomerCollect ";
	HashMap<String, Object> item;
	public CacheDao()
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

		String strSQL="DELETE  FROM CustomerCollect  ";
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
		String strSQL="DELETE FROM  CustomerCollect  WHERE TPId ="+Integer.valueOf(strIds);
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

//	
//	public List<HashMap<String,Object> > GetAlldwsp(String id)
//	{
//		 Cursor cursor=Getdwsp(id);
//		 List<HashMap<String, Object> > list = new ArrayList<HashMap<String,Object>>();
//		
//	  while(!cursor.isAfterLast())
//	  {    
//	              item = new HashMap<String, Object>();	         
//	         item.put("Type", cursor.getString(cursor.getColumnIndex("Type")));
//	         item.put("Themer", cursor.getString(cursor.getColumnIndex("Themer")));
//	         item.put("StateId", cursor.getString(cursor.getColumnIndex("StateId")));
//	         item.put("State", cursor.getString(cursor.getColumnIndex("State")));
//	         item.put("OddId", cursor.getString(cursor.getColumnIndex("OddId")));
//	         item.put("Odd", cursor.getString(cursor.getColumnIndex("Odd")));
//	         item.put("ModuletypeId", cursor.getString(cursor.getColumnIndex("ModuletypeId")));
//	         item.put("Moduletype", cursor.getString(cursor.getColumnIndex("Moduletype")));
//	         item.put("ModuleName", cursor.getString(cursor.getColumnIndex("ModuleName")));
//	         item.put("Initiator", cursor.getString(cursor.getColumnIndex("Initiator")));
//	         item.put("Content", cursor.getString(cursor.getColumnIndex("Content")));
//	         item.put("Date", cursor.getString(cursor.getColumnIndex("Date")));
//	         item.put("Spare1", cursor.getString(cursor.getColumnIndex("Spare1")));
//	         item.put("Spare2", cursor.getString(cursor.getColumnIndex("Spare2")));
//	         item.put("Spare3", cursor.getString(cursor.getColumnIndex("Spare3")));
//	         item.put("Spare4", cursor.getString(cursor.getColumnIndex("Spare4")));
//	         item.put("Spare5", cursor.getString(cursor.getColumnIndex("Spare5")));
//	         item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));
//	         item.put("XXId", cursor.getString(cursor.getColumnIndex("XXId")));
//	         list.add(item);
//	         cursor.moveToNext();
//	     }	             
//	     System.out.println(list);
//	     mDatabase.close();
//	     
//	     return list;
//	}

	public List<HashMap<String,Object> > GetAllCache1(ArrayList<String> listid)
	{
		Cursor cursor=GetCache1(listid);
		List<HashMap<String, Object> > list = new ArrayList<HashMap<String,Object>>();

		while(!cursor.isAfterLast())
		{
			item = new HashMap<String, Object>();
			//   TPId mark mark1 khname linkman Phone addr khcode ypcode price number standby1 standby2 standby3
			item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));
			item.put("mark", cursor.getString(cursor.getColumnIndex("mark")));
			item.put("mark1", cursor.getString(cursor.getColumnIndex("mark1")));
			item.put("khname", cursor.getString(cursor.getColumnIndex("khname")));
			item.put("linkman", cursor.getString(cursor.getColumnIndex("linkman")));
			item.put("Phone", cursor.getString(cursor.getColumnIndex("Phone")));
			item.put("addr", cursor.getString(cursor.getColumnIndex("addr")));
			item.put("khcode", cursor.getString(cursor.getColumnIndex("khcode")));
			item.put("ypcode", cursor.getString(cursor.getColumnIndex("ypcode")));
			item.put("price", cursor.getString(cursor.getColumnIndex("price")));
			item.put("number", cursor.getString(cursor.getColumnIndex("number")));
			item.put("standby1", cursor.getString(cursor.getColumnIndex("standby1")));
			item.put("standby2", cursor.getString(cursor.getColumnIndex("standby2")));
			item.put("standby3", cursor.getString(cursor.getColumnIndex("standby3")));


			list.add(item);
			cursor.moveToNext();
		}
		System.out.println(list);
		mDatabase.close();

		return list;
	}

//	public Cursor Getdwsp(String id)
//	{
//		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
//	     String strSQL="SELECT * FROM CustomerCollect where TPId   =  "+id+" "; 
//	   
//	   if(mWhereSQL!=null)
//		   strSQL+=" "+mWhereSQL;
//	   System.out.println(strSQL);
//	   Cursor cursor=null;
//
//	   try
//	   {
//		   cursor=mDatabase.rawQuery(strSQL, null);
//	   }
//	   catch(Exception e)
//	   {
//		   e.getMessage();
//	   }
//			 
//	   if(cursor!=null)
//		   cursor.moveToFirst();
//	   
//	   mWhereSQL=null;
//	   
//	   return cursor;
//	}

	public Cursor GetCache1(ArrayList<String> listid)
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
		String strSQL="SELECT * FROM  CustomerCollect  where  "+id+" ";
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

