package com.vcans.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vcans.Processor.BaseActivity;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class YPBarcodeImageDao {

	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;
	List<HashMap<String, Object> > list;

	public YPBarcodeImageDao()
	{
		mDbPath=DBHelper.CreateTable();
	}



	/**
	 * 删除所有生产投坯信息
	 * @param strIds
	 * @return
	 */
	public int DeleteAll(String strIds)
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		String strSQL="DELETE FROM BarcodeImage";

		if(strIds!=null)
			strSQL+=" WHERE TPId IN("+strIds+")";

		try
		{
			mDatabase.execSQL(strSQL);

			for(HashMap<String, Object> mapInfo:list)
			{
				String dataId=(String)mapInfo.get("TPId");
				if(strIds==null||strIds.contains("'"+dataId+"'"))
				{
					String filePath=(String)mapInfo.get("FilePath");

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

		String strSQL="DELETE FROM BarcodeImage WHERE TPId="+Integer.valueOf(strIds);

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

	public int AddToupei(YPExpInfo toupei)
	{
		int rst=-1;

		try
		{
			ContentValues contentValues=new ContentValues();

			if(!toupei.strImgName.equals(""))
				contentValues.put("ImgName", toupei.strImgName);
			else
				contentValues.put("ImgName", ";");

			if(GetSCToupei(toupei)!=null)
			{
				// mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
				// rst=(int) mDatabase.update("BarcodeImage", contentValues,"Barcode='"+toupei.strBarcode+"'", null);
				return 2;
			}
			else
			{
				mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
				contentValues.put("Barcode", toupei.strBarcode);
				contentValues.put("Num", toupei.strNum);
				contentValues.put("Price", toupei.strPrice);
				rst=(int) mDatabase.insert("BarcodeImage", null, contentValues);
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

	public int update(YPExpInfo toupei)
	{
		int rst=-1;

		try
		{
			YPExpInfo tempExpInfo=GetSCToupeiById(toupei);

			if(tempExpInfo!=null)
			{
				ContentValues contentValues=new ContentValues();

				String filePath=tempExpInfo.strImgName;
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

				contentValues.put("ImgName",updatedPath);

				mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);
				rst=(int) mDatabase.update("BarcodeImage", contentValues,"TPId='"+toupei.strDataId+"'", null);


				if(!oldImage.equals(""))
				{
					File file=new File(oldImage);
					if(file.exists())
					{
						file.delete();
					}
				}

				return 1;
			}
			else
			{
				return 0;
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

	public List<HashMap<String,Object> > GetToupeiById(String recordIds)
	{
		if(recordIds!=null&&!recordIds.equals(""))
			this.mWhereSQL=" Where TPId in ("+recordIds+")";


		return GetAllTeipei();
	}

	public List<HashMap<String,Object> > GetAllTeipei()
	{
		Cursor cursor=GetToupeis();

		if(cursor==null)
			return null;

		list = new ArrayList<HashMap<String,Object>>();

		String strPath;
		//BitmapFactory.Options options=new BitmapFactory.Options();
		//options.inPurgeable = true;
		//options.inSampleSize = 4;

		while(!cursor.isAfterLast())
		{
			HashMap<String, Object> item = new HashMap<String, Object>();


			item.put("Barcode", cursor.getString(cursor.getColumnIndex("Barcode")));
			strPath=cursor.getString(cursor.getColumnIndex("ImgName"));

			if(strPath==null)
			{
				//item.put("ImgName", getResourceBitmap(R.drawable.no_img));
				item.put("FilePath", ";");
			}
			else
			{
		    	 /*
		    	 if(strPath.equals(";"))
		    	 {
				    	item.put("ImgName", getResourceBitmap(R.drawable.no_img)); 
		    	 }
		    	 else
		    	 {
		    		 String[] subFiles=ActivityHelper.mySplit(strPath, ";");
		    		 
					 if(!subFiles[0].equals(""))
					    	item.put("ImgName", BitmapFactory.decodeFile(subFiles[0],options));
					 else
					    	item.put("ImgName", getResourceBitmap(R.drawable.no_img));  
		    	 }
		    	 */

				item.put("FilePath",strPath);
			}

			item.put("Num", cursor.getString(cursor.getColumnIndex("Num")));
			item.put("Price", cursor.getString(cursor.getColumnIndex("Price")));
			item.put("TPId", cursor.getString(cursor.getColumnIndex("TPId")));

			list.add(item);

			cursor.moveToNext();
		}


		cursor.close();
		mDatabase.close();

		return list;
	}


	public Bitmap getResourceBitmap(int rid) {

		Resources mResources =BaseActivity.mMainActivity.getResources();

		Bitmap mBitmap = BitmapFactory.decodeResource(mResources,rid);



		return mBitmap;

	}


	public YPExpInfo GetSCToupeiById(YPExpInfo toupei)
	{
		mWhereSQL=" Where TPID='"+toupei.strDataId+"'";


		Cursor cursor=GetToupeis();

		YPExpInfo tempTP=null;

		while(!cursor.isAfterLast())
		{
			tempTP=new YPExpInfo();

			tempTP.strCusBarcode=cursor.getString(cursor.getColumnIndex("Barcode"));
			tempTP.strImgName=cursor.getString(cursor.getColumnIndex("ImgName"));

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return tempTP;
	}

	public YPExpInfo GetSCToupei(YPExpInfo toupei)
	{
		mWhereSQL=" Where Barcode='"+toupei.strBarcode+"'";


		Cursor cursor=GetToupeis();

		YPExpInfo tempTP=null;

		while(!cursor.isAfterLast())
		{
			tempTP=new YPExpInfo();

			tempTP.strCusBarcode=cursor.getString(cursor.getColumnIndex("Barcode"));

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return tempTP;
	}

	public Cursor GetToupeis()
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


		String strSQL="SELECT Barcode,ImgName,Num,Price,TPId"
				+" FROM BarcodeImage";

		if(mWhereSQL!=null)
			strSQL+=" "+mWhereSQL;

		strSQL+=" ORDER BY TPId DESC";

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
