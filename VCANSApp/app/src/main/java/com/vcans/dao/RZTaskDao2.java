package com.vcans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vcans.model.ToupeiInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RZTaskDao2 {

	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;
	private final String tableName ="RZTask2";

	public RZTaskDao2()
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

		String strSQL="DELETE FROM RZTask2";

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

		String strSQL="DELETE FROM RZTask2  WHERE TPId="+Integer.valueOf(strIds);

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
			contentValues.put("RZFactoryName", toupei.strRZFactoryName);
			contentValues.put("strtxtby1Name", toupei.strtxtby1Name);
			contentValues.put("strtxtby2Name", toupei.strtxtby2Name);
			contentValues.put("GongXuId", toupei.strGongXuId);
			contentValues.put("GongXuName", toupei.strGongXuName);
			contentValues.put("GongyiId", toupei.strGongyiId);
			contentValues.put("GongyiName", toupei.strGongyiName);
			contentValues.put("strtxtby3Name", toupei.strtxtby3Name);///////////////////
			contentValues.put("strtxtby4Name", toupei.strtxtby4Name);/////////////////
			contentValues.put("strtxtby5Name", toupei.strtxtby5Name);///////////////
			contentValues.put("strtxtby6Name", toupei.strtxtby6Name);/////////////
			contentValues.put("RZDatetime", toupei.strDataTime);
			contentValues.put("Remark", toupei.strRemark);
			contentValues.put("Num", toupei.nNum);
			contentValues.put("shu3", toupei.shu3);
			contentValues.put("shu4", toupei.shu4);
			contentValues.put("PiShu", toupei.nPiShu);


			rst=(int) mDatabase.insert("RZTask2", null, contentValues);
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
			item.put("RZFactoryName", cursor.getString(cursor.getColumnIndex("RZFactoryName")));


			item.put("strtxtby1Name", cursor.getString(cursor.getColumnIndex("strtxtby1Name")));/////////////////////
			item.put("strtxtby2Name", cursor.getString(cursor.getColumnIndex("strtxtby2Name"))); //////////////////
			item.put("strtxtby3Name", cursor.getString(cursor.getColumnIndex("strtxtby3Name")));/////////////////
			item.put("strtxtby4Name", cursor.getString(cursor.getColumnIndex("strtxtby4Name")));///////////////
			item.put("strtxtby5Name", cursor.getString(cursor.getColumnIndex("strtxtby5Name")));//////////////
			item.put("strtxtby6Name", cursor.getString(cursor.getColumnIndex("strtxtby6Name")));/////////////

			item.put("GongXuId", cursor.getString(cursor.getColumnIndex("GongXuId")));
			item.put("GongXuName",cursor.getString(cursor.getColumnIndex("GongXuName")));
			item.put("GongyiId", cursor.getString(cursor.getColumnIndex("GongyiId")));
			item.put("GongyiName",cursor.getString(cursor.getColumnIndex("GongyiName")));
			item.put("RZDatetime", cursor.getString(cursor.getColumnIndex("RZDatetime")));
			item.put("Num", cursor.getString(cursor.getColumnIndex("Num")));
			item.put("PiShu", cursor.getString(cursor.getColumnIndex("PiShu")));
			item.put("shu3", cursor.getString(cursor.getColumnIndex("shu3")));
			item.put("shu4", cursor.getString(cursor.getColumnIndex("shu4")));
			item.put("Remark", cursor.getString(cursor.getColumnIndex("Remark")));
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
				+" AND RZFactoryName='"+toupei.strRZFactoryName+"'"

				+" AND strtxtby1Name='"+toupei.strtxtby1Name+"'"
				+" AND strtxtby2Name='"+toupei.strtxtby2Name+"'"


				+" AND GongXuId='"+toupei.strGongXuId+"'"
				+" AND GongXuName='"+toupei.strGongXuName+"'"
				+" AND GongyiId='"+toupei.strGongyiId+"'"
				+" AND GongyiName='"+toupei.strGongyiName+"'"

				+" AND strtxtby3Name='"+toupei.strtxtby3Name+"'"                                   ///////////////
				+" AND strtxtby4Name='"+toupei.strtxtby4Name+"'"                              //////////////
				+" AND strtxtby5Name='"+toupei.strtxtby5Name+"'"                         //////////////
				+" AND strtxtby6Name='"+toupei.strtxtby6Name+"'"                     ////////////////



				+" AND RZDatetime='"+toupei.strDataTime+"'"
				+" AND Num='"+toupei.nNum+"'"
				+" AND PiShu='"+toupei.nPiShu+"'"
				+" AND Num='"+toupei.shu3+"'"
				+" AND PiShu='"+toupei.shu4+"'"
				+" AND Remark='"+toupei.strRemark+"'";


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


		String strSQL="SELECT RZPlanId,RZFactoryId,RZFactoryName,strtxtby1Name,strtxtby2Name,GongXuId,GongXuName,"
				+"GongyiId,GongyiName,strtxtby3Name,strtxtby4Name,strtxtby5Name,strtxtby6Name,Remark,Num,PiShu,shu3,shu4,RZDatetime,TPId"   /////////
				+" FROM RZTask2";

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
