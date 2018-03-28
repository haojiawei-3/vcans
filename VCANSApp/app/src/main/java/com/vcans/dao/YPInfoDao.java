package com.vcans.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;

import com.vcans.Processor.BaseActivity;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class YPInfoDao{

	String mDbPath;
	SQLiteDatabase mDatabase=null;
	SQLiteStatement stmt=null;
	String mWhereSQL=null;
	List<HashMap<String, Object> > 	 list ;
	public enum DbType{YPQUERY,YP_IMAGE};

	DbType mDbType;

	public YPInfoDao(DbType dbType)
	{
		mDbPath=DBHelper.CreateTable();
		mDbType=dbType;
	}


	/**
	 * 删除所有生产投坯信息
	 * @param barcodes
	 * @return
	 */
	public int DeleteAll(String strIds)
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		String strSQL="DELETE FROM YPInfo WHERE YPFlag="+mDbType.ordinal();

		if(strIds!=null)
			strSQL+=" AND Barcode IN("+strIds+")";

		try
		{
			mDatabase.execSQL(strSQL);

			for(HashMap<String, Object> mapInfo:list)
			{
				String dataId=(String)mapInfo.get("Barcode");
				if(strIds==null||strIds.contains("'"+dataId+"'"))
				{
					String strField=(String)mapInfo.get("YPField");
					if(strField.equals(BaseActivity.mMainActivity.getString(R.string.image)))
					{
						String filePath=(String)mapInfo.get("YPValue");

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

		String strSQL="DELETE FROM YPInfo WHERE YPFlag="+mDbType.ordinal()+" AND TPId="+Integer.valueOf(strIds);

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

	public int AddBatchYPInfo(YPExpInfo toupei,int actFlag)
	{
		int rst=-1;

		String strSQL="INSERT INTO YPInfo(Barcode,YPField,YPValue)"
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

	public int update(YPExpInfo toupei)
	{
		int rst=-1;

		try
		{

			ContentValues contentValues=new ContentValues();

			String filePath=toupei.strFiles;
			String[] szFilePath=ActivityHelper.mySplit(filePath, ";");

			String oldImage="";
			String updatedPath="";
			int i=0;
			for(String tmFile:szFilePath)
			{
				if(i==toupei.imgIndex)
				{
					oldImage=tmFile;
					updatedPath+=toupei.strImgName+";";
				}
				else
				{
					updatedPath+=tmFile+";";
				}

				i++;
			}

			contentValues.put("YPValue",updatedPath);

			mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
			rst=(int) mDatabase.update("YPInfo"    , contentValues,    "YPFlag="+mDbType.ordinal()+" AND Barcode='"+toupei.strBarcode+"' AND ( YPField='图片'  or  YPField='Picture') ", null);

			if(!oldImage.equals(""))
			{
				File file=new File(oldImage);
				if(file.exists())
				{
					file.delete();
				}
			}

			toupei.strFiles=updatedPath;
			return 1;

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

		try
		{

			mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


			ContentValues contentValues=new ContentValues();
			contentValues.put("Barcode", toupei.strBarcode);
			contentValues.put("YPField", toupei.strYPField);
			contentValues.put("YPValue", toupei.strYPValue);
			contentValues.put("YPFlag",  mDbType.ordinal());



			rst=(int) mDatabase.insert("YPInfo", null, contentValues);


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
			this.mWhereSQL=" Where YPFlag="+mDbType.ordinal()+" AND Barcode='"+barcode+"'";


		return GetAllTeipei();
	}

	public List<HashMap<String,Object> > GetParentList()
	{
		Cursor cursor=GetToupeis();

		list = new ArrayList<HashMap<String,Object>>();

		while(!cursor.isAfterLast())
		{
			String fieldName=cursor.getString(cursor.getColumnIndex("YPField"));

			if(fieldName.equals(BaseActivity.mMainActivity.getString(R.string.image)))
			{
				HashMap<String, Object> item = new HashMap<String, Object>();

				item.put("Barcode", cursor.getString(cursor.getColumnIndex("Barcode")));
				item.put("YPField", cursor.getString(cursor.getColumnIndex("YPField")));
				item.put("YPValue",cursor.getString(cursor.getColumnIndex("YPValue")));
				item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));

				list.add(item);
				//System.out.println(list+"1111111111111111111111111111111111111111111");

			}

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return list;
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
			//System.out.println(list+"22222222222222222222222222222222222");
			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return list;
	}



	public YPExpInfo GetSCToupei(YPExpInfo toupei)
	{
		mWhereSQL=" Where YPFlag="+mDbType.ordinal()+" AND Barcode='"+toupei.strBarcode+"'";


		Cursor cursor=GetToupeis();

		YPExpInfo tempTP=null;

		while(!cursor.isAfterLast())
		{
			tempTP=new YPExpInfo();

			tempTP.strBarcode=cursor.getString(cursor.getColumnIndex("Barcode"));


			cursor.moveToNext();
			break;
		}

		cursor.close();
		mDatabase.close();

		return tempTP;
	}

	public Cursor GetToupeis()
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


		String strSQL="SELECT Barcode,YPField,YPValue,TPId"
				+" FROM YPInfo ";

		if(mWhereSQL!=null)
			strSQL+=" "+mWhereSQL;
		else
			strSQL+=" WHERE YPFlag="+mDbType.ordinal();


		// if(mDbType.ordinal()==0)
		strSQL+=" order by TPId desc";
		// else
		//   strSQL+=" order by TPId";

		Cursor cursor=null;

		try
		{
			cursor=mDatabase.rawQuery(strSQL, null);
			System.out.println(strSQL+"+++++++++++++++++++++++++++++++++++++");
			//SELECT Barcode,YPField,YPValue,TPId FROM YPInfo  WHERE YPFlag=0 order by TPId desc+++++++++++++++++++++++++++++++++++++

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
