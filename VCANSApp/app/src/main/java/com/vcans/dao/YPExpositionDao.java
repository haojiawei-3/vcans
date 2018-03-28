package com.vcans.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vcans.model.ToupeiInfo;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class YPExpositionDao {

	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;
	List<HashMap<String, Object> > list;

	public YPExpositionDao()
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

		String strSQL="DELETE FROM YPExpostion ";

		if(strIds!=null)
			strSQL+=" WHERE TPId  IN("+strIds+")";

		try
		{
			mDatabase.execSQL(strSQL);

			for(HashMap<String, Object> mapInfo:list)
			{
				String dataId=(String)mapInfo.get("TPId");
				if(strIds==null||strIds.contains("'"+dataId+"'"))
				{
					String filePath=(String)mapInfo.get("CusImgName");

					if(!filePath.equals(";"))
					{
						String[] szFilePath=ActivityHelper.mySplit(filePath, ";");

						for(String tmFile:szFilePath)
						{
							File file=new File(tmFile);
							if(file.exists())
							{
								file.delete();
							}
						}
					}
				}

			}

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

		String strSQL="DELETE FROM YPExpostion WHERE TPId="+Integer.valueOf(strIds);

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

	public int updateCustomer(YPExpInfo toupei)
	{
		int rst=-1;

		YPExpInfo oldExpInfo=GetCusInfo(toupei);
		if(oldExpInfo==null)
		{
			return 2;
		}

		try
		{
			mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


			ContentValues contentValues=new ContentValues();
			contentValues.put("CusName", toupei.strCusName);
			contentValues.put("CusImgName", toupei.strImgName+";");

			rst=(int) mDatabase.update("YPExpostion", contentValues,"CusBarcode='"+toupei.strCusBarcode+"'",null);

			if(!oldExpInfo.strImgName.equals(toupei.strImgName+";"))
			{
				File file=new File(oldExpInfo.strImgName.substring(0,
						oldExpInfo.strImgName.length()-1));

				if(file.exists())
					file.delete();
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		finally
		{
			mDatabase.close();
		}

		return rst;
	}

	public int AddToupei(YPExpInfo toupei)
	{
		int rst=-1;

		if(GetSCToupei(toupei)!=null)
		{
			return 0;
		}

		try
		{
			if(updateCustomer(toupei)<1)
			{
				return rst;
			}

			mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


			ContentValues contentValues=new ContentValues();
			contentValues.put("CusBarcode", toupei.strCusBarcode);
			contentValues.put("CusName", toupei.strCusName);
			contentValues.put("CusImgName", toupei.strImgName+";");
			contentValues.put("Barcode", toupei.strBarcode);
			contentValues.put("Price", toupei.strPrice);
			contentValues.put("Num", toupei.strNum);



			rst=(int) mDatabase.insert("YPExpostion", null, contentValues);
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

		list = new ArrayList<HashMap<String,Object>>();

		while(!cursor.isAfterLast())
		{
			HashMap<String, Object> item = new HashMap<String, Object>();


			item.put("CusBarcode", cursor.getString(cursor.getColumnIndex("CusBarcode")));
			item.put("CusName", cursor.getString(cursor.getColumnIndex("CusName")));
			item.put("CusImgName", cursor.getString(cursor.getColumnIndex("CusImgName")));
			item.put("Barcode", cursor.getString(cursor.getColumnIndex("Barcode")));
			item.put("Price", cursor.getString(cursor.getColumnIndex("Price")));
			item.put("Num",cursor.getString(cursor.getColumnIndex("Num")));
			item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));

			list.add(item);

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return list;
	}


	public YPExpInfo GetCusInfo(YPExpInfo toupei)
	{
		mWhereSQL=" Where CusBarcode='"+toupei.strCusBarcode+"'";


		Cursor cursor=GetToupeis();

		YPExpInfo tempTP=null;

		while(!cursor.isAfterLast())
		{
			tempTP=new YPExpInfo();

			tempTP.strCusBarcode=cursor.getString(cursor.getColumnIndex("CusBarcode"));
			tempTP.strCusName=cursor.getString(cursor.getColumnIndex("CusName"));
			tempTP.strImgName=cursor.getString(cursor.getColumnIndex("CusImgName"));
			cursor.moveToNext();
			break;
		}

		cursor.close();
		mDatabase.close();

		return tempTP;
	}


	public YPExpInfo GetSCToupei(YPExpInfo toupei)
	{
		mWhereSQL=" Where CusBarcode='"+toupei.strCusBarcode+"'"
				+" AND Barcode='"+toupei.strBarcode+"'";


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


		String strSQL="SELECT CusBarcode,CusName,CusImgName,Barcode,Price,Num,TPId"
				+" FROM YPExpostion";

		if(mWhereSQL!=null)
			strSQL+=" "+mWhereSQL;

		strSQL+=" ORDER BY CusBarcode desc";

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
