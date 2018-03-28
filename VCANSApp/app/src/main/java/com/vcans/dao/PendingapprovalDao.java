package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.vcans.model.Information;
import com.vcans.model.Mpsbinfo;
import com.vcans.tool.ActivityHelper;

public class PendingapprovalDao {
	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;
	private final String tableName ="Pendingapproval";
	HashMap<String, Object> item;
	public PendingapprovalDao()
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

		String strSQL="DELETE FROM Pendingapproval ";
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
		String strSQL="DELETE FROM Pendingapproval WHERE TPId="+Integer.valueOf(strIds);
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

	public int AdDwsp(Information dwsp)
	{
		int rst=-1;

		if(GetSCToupei(dwsp)!=null)
		{
			return 2;
		}
		try
		{
			mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
			ContentValues contentValues=new ContentValues();
			contentValues.put("XXId", dwsp.strxxId);
			contentValues.put("Type", dwsp.strtype);
			contentValues.put("Themer", dwsp.strthemer);
			contentValues.put("StateId", dwsp.strstateId);
			contentValues.put("State", dwsp.strstate);
			contentValues.put("0ddId", dwsp.stroddId);
			contentValues.put("0dd", dwsp.strodd);
			contentValues.put("ModuletypeId", dwsp.strmoduletypeId);
			contentValues.put("Moduletype", dwsp.strmoduletype);
			contentValues.put("Initiator", dwsp.strinitiator);
			contentValues.put("Content", dwsp.strcontent);
			contentValues.put("ModuleName", dwsp.strmodulename);
			contentValues.put("Date", dwsp.strdate);
			contentValues.put("Spare1", dwsp.strSpare1);
			contentValues.put("Spare2", dwsp.strSpare2);
			contentValues.put("Spare3", dwsp.strSpare3);
			contentValues.put("Spare4", dwsp.strSpare4);
			contentValues.put("Spare5", dwsp.strSpare5);
			System.out.println(contentValues);
			rst=(int) mDatabase.insert("Pendingapproval", null, contentValues);
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






//	public List<HashMap<String,Object> > GetTeipeiById(String recordIds)
//	{
//		if(recordIds!=null&&!recordIds.equals(""))
//			this.mWhereSQL=" Where TPId in ("+recordIds+")";   
//		
//		
//		return GetAlldwsp();
//	}


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



	public Information GetSCToupei(Information dwsp)
	{

		mWhereSQL=" Where Type='"+dwsp.strtype+"'"

				+" AND Initiator='"+dwsp.strinitiator+"'"
				+" AND Content='"+dwsp.strcontent+"'"
				+" AND StateId='"+dwsp.strstateId+"'"
				+" AND State='"+dwsp.strstate+"'"
				+" AND Moduletype='"+dwsp.strmoduletype+"'"
				+" AND ModuletypeId='"+dwsp.strmoduletypeId+"'"
				+" AND Odd='"+dwsp.strodd+"'"
				+" AND Czname='"+dwsp.stroddId+"'";
		Cursor cursor=Getdwsp();

		Information tempTP=null;

		while(!cursor.isAfterLast())
		{
			tempTP=new Information();

			tempTP.strtype=cursor.getString(cursor.getColumnIndex("Type"));

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return tempTP;
	}

	public Cursor Getdwsp(String id)
	{// Type Themer Initiator Content StateId State Moduletype ModuletypeId Odd OddId GlxxId Cztype CzId Czname
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
		String strSQL="SELECT * FROM Pendingapproval where TPId = "+id+" ";

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
		String strSQL="SELECT * FROM Pendingapproval where  "+id+" ";
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
				+" FROM Pendingapproval";

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
