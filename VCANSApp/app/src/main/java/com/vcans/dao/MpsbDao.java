package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vcans.model.Mpsbinfo;
import com.vcans.model.ToupeiInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MpsbDao {
	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;
	private final String tableName ="Mpsb";
	HashMap<String, Object> item;
	public MpsbDao()
	{
		mDbPath=DBHelper.CreateTable();
	}


	/**
	 * 删除所有mpsb信息
	 * @param barcodes
	 * @return
	 */
	public int DeleteAll(String strIds)
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		String strSQL="DELETE FROM Mpsb ";
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

	public int DeleteById(String strIds)
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
		String strSQL="DELETE FROM Mpsb WHERE TPId="+Integer.valueOf(strIds);
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

	public int AddMpsb(Mpsbinfo mpsb)
	{
		int rst=-1;

		//if(GetSCToupei(mpsb)!=null)
		// {
		//   return 2;
		// }

		try
		{//company, linkname ,position ,phone1, phone2, fax ,address , www ,email ,note;
			mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
			ContentValues contentValues=new ContentValues();
			contentValues.put("company", mpsb.strcompany);
			contentValues.put("linkname", mpsb.strlinkname);
			contentValues.put("position", mpsb.strposition);
			contentValues.put("phone1", mpsb.strphone1);
			contentValues.put("phone2", mpsb.strphone2);
			contentValues.put("fax", mpsb.strfax);
			contentValues.put("address", mpsb.straddress);
			contentValues.put("www", mpsb.strwww);
			contentValues.put("ImgPath", mpsb.strImgPath);
			contentValues.put("email", mpsb.stremail);
			contentValues.put("note", mpsb.strnote);
			System.out.println(contentValues);
			rst=(int) mDatabase.insert("Mpsb", null, contentValues);
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


		return GetAllMpsb();
	}

	public List<HashMap<String,Object> > GetAllMpsb()
	{
		Cursor cursor=Getmpsb();
		List<HashMap<String, Object> > list = new ArrayList<HashMap<String,Object>>();

		while(!cursor.isAfterLast())
		{
			item = new HashMap<String, Object>();
			// company, linkname ,position ,phone1, phone2, fax ,address , www ,email ,note;
			item.put("company", cursor.getString(cursor.getColumnIndex("company")));
			item.put("linkname", cursor.getString(cursor.getColumnIndex("linkname")));
			item.put("position", cursor.getString(cursor.getColumnIndex("position")));
			item.put("phone1", cursor.getString(cursor.getColumnIndex("phone1")));
			item.put("phone2", cursor.getString(cursor.getColumnIndex("phone2")));
			item.put("fax", cursor.getString(cursor.getColumnIndex("fax")));
			item.put("address", cursor.getString(cursor.getColumnIndex("address")));
			item.put("www", cursor.getString(cursor.getColumnIndex("www")));
			item.put("email", cursor.getString(cursor.getColumnIndex("email")));
			item.put("note", cursor.getString(cursor.getColumnIndex("note")));
			item.put("ImgPath", cursor.getString(cursor.getColumnIndex("ImgPath")));
			item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));
			cursor.moveToNext();
		}
		list.add(item);

		cursor.moveToNext();
		mDatabase.close();

		return list;
	}



	public List<HashMap<String,Object> > GetAllMpsbb()
	{
		Cursor cursor=Getmpsb();
		List<HashMap<String, Object> > list = new ArrayList<HashMap<String,Object>>();

		while(!cursor.isAfterLast())
		{
			item = new HashMap<String, Object>();

			item.put("company", cursor.getString(cursor.getColumnIndex("company")));
			item.put("linkname", cursor.getString(cursor.getColumnIndex("linkname")));
			item.put("position", cursor.getString(cursor.getColumnIndex("position")));
			item.put("phone1", cursor.getString(cursor.getColumnIndex("phone1")));
			item.put("phone2", cursor.getString(cursor.getColumnIndex("phone2")));
			item.put("fax", cursor.getString(cursor.getColumnIndex("fax")));
			item.put("address", cursor.getString(cursor.getColumnIndex("address")));
			item.put("www", cursor.getString(cursor.getColumnIndex("www")));
			item.put("email", cursor.getString(cursor.getColumnIndex("email")));
			item.put("note", cursor.getString(cursor.getColumnIndex("note")));
			item.put("ImgPath", cursor.getString(cursor.getColumnIndex("ImgPath")));
			item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));
			list.add(item);
			System.out.println(cursor.isAfterLast()+"123456789");
			cursor.moveToNext();
		}
		// list.add(item);
		cursor.moveToNext();
		mDatabase.close();

		return list;
	}



	public Mpsbinfo GetSCToupei(Mpsbinfo mpsb)
	{

		mWhereSQL=" Where company='"+mpsb.strcompany+"'"
				+" AND linkname='"+mpsb.strlinkname+"'"
				+" AND position='"+mpsb.strposition+"'"
				+" AND phone1='"+mpsb.strphone1+"'"
				+" AND phone2='"+mpsb.strphone2+"'"
				+" AND fax='"+mpsb.strfax+"'"
				+" AND address='"+mpsb.straddress+"'"
				+" AND www='"+mpsb.strwww+"'"
				+" AND email='"+mpsb.stremail+"'"
				+" AND note='"+mpsb.strnote+"'"
				+" AND ImgPath='"+mpsb.strImgPath+"'";
		Cursor cursor=Getmpsb();

		Mpsbinfo tempTP=null;

		while(!cursor.isAfterLast())
		{
			tempTP=new Mpsbinfo();

			tempTP.strcompany=cursor.getString(cursor.getColumnIndex("company"));

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return tempTP;
	}

	public Cursor Getmpsb()
	{ // company, linkname ,position ,phone1, phone2, fax ,address , www ,email ,note;
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
		String strSQL="SELECT company,linkname,position,"
				+"phone1,phone2,fax,address,www,"
				+"email,note,ImgPath,TPId"
				+" FROM Mpsb";

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


