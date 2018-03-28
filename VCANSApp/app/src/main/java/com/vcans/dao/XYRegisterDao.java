package com.vcans.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.vcans.model.Customer;
import com.vcans.model.Product;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

public class XYRegisterDao {

	public static final String DB_PATH="/data/data/com.vcans/files/VCANS.db";
	String mDbPath;
	SQLiteDatabase mDatabase=null;
	String mWhereSQL=null;


	public XYRegisterDao()
	{
		CreateTable();
	}

	public int CreateTable()
	{
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
		{
			mDbPath=Environment.getExternalStorageDirectory().toString()+"/VCANS.db";
		}
		else
		{
			mDbPath=DB_PATH;
		}

		File file=new File(mDbPath);

		boolean bExist= file.exists();

		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		if(!bExist)
		{
			//产品
			String strCreateTableSQL="CREATE TABLE Product ("
					+"BarCode VARCHAR(200) primary key NOT NULL,"
					+"GoodsId VARCHAR(200)  NULL,"
					+"GoodsName VARCHAR(200)  NULL,"
					+"StyleInfo VARCHAR(200)  NULL,"
					+"PriceInfo VARCHAR(200)  NULL,"
					+"CusCode VARCHAR(200) NOT NULL)";

			try
			{
				mDatabase.execSQL(strCreateTableSQL);
			}
			catch(Exception e)
			{
				e.getMessage();
				mDatabase.close();
				return -1;
			}

			//客户
			strCreateTableSQL="CREATE TABLE Customer ("
					+"CusCode VARCHAR(200) primary key NOT NULL,"
					+"CusName VARCHAR(200) NULL)";

			try
			{
				mDatabase.execSQL(strCreateTableSQL);
			}
			catch(Exception e)
			{
				e.getMessage();
				mDatabase.close();
				return -1;
			}

			//生产投坯
			strCreateTableSQL="CREATE TABLE SCTouPei ("
					+"TPId INT identity(1,1) primary key  NOT NULL,"
					+"RZPlanId VARCHAR(200) NOT NULL,"
					+"RZFactoryId VARCHAR(200) NOT NULL,"
					+"GongXuId VARCHAR(200) NOT NULL,"
					+"GongXuName VARCHAR(200) NOT NULL,"
					+"CompanyOrderId VARCHAR(200) NOT NULL,"
					+"PurchaseId VARCHAR(200) NOT NULL,"
					+"GoodsId VARCHAR(200) NOT NULL,"
					+"GoodsDescribe VARCHAR(200) NOT NULL,"
					+"StoreDescribe VARCHAR(200) NOT NULL,"
					+"StoreFlag VARCHAR(200) NOT NULL,"
					+"OldPiShu INT NOT NULL,"
					+"OldNum INT NOT NULL,"
					+"BackModify VARCHAR(200) NOT NULL,"
					+"PiShu INT NOT NULL,"
					+"Num INT NOT NULL,"
					+"UserId VARCHAR(200) NOT NULL,"
					+"IsFuHeBu VARCHAR(200) NULL)";

			try
			{
				mDatabase.execSQL(strCreateTableSQL);

				mDatabase.close();
				return 1;
			}
			catch(Exception e)
			{
				e.getMessage();
				mDatabase.close();
				return -1;
			}
		}

		return 0;
	}

	public int AddCustomer(Customer customer)
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		ContentValues contentValues=new ContentValues();
		contentValues.put("CusCode", customer.strCusCode);
		contentValues.put("CusName", customer.strCusName);

		int rst=(int) mDatabase.insert("Customer", null, contentValues);

		mDatabase.close();
		return rst;
	}


	/**
	 * 删除所有产品及所属客户
	 * @param barcodes
	 * @return
	 */
	public int DeleteAllProductAndCus()
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		String	strSQL="DELETE FROM Customer";

		try
		{
			mDatabase.execSQL(strSQL);
		}
		catch(Exception e)
		{
		}

		strSQL="DELETE FROM Product ";

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

	public int AddProduct(Product product)
	{
		int rst=-1;

		if(GetProductByCuscodeAndBarcodes(product.strCusCode,"'"+product.strBarCode+"'").size()>0)
		{
			return 1;
		}

		try
		{
			mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

			ContentValues contentValues=new ContentValues();
			contentValues.put("BarCode", product.strBarCode);
			contentValues.put("GoodsId", product.strGoodsId);
			contentValues.put("GoodsName", product.strGoodsName);
			contentValues.put("StyleInfo", product.strStyleInfo);
			contentValues.put("PriceInfo", product.strPriceInfo);
			contentValues.put("CusCode", product.strCusCode);


			rst=(int) mDatabase.insert("Product", null, contentValues);
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

	public List<HashMap<String,Object> > GetAllProdcts()
	{
		Cursor cursor=GetProducts();

		List<HashMap<String, Object> > list = new ArrayList<HashMap<String,Object>>();

		while(!cursor.isAfterLast())
		{
			HashMap<String, Object> item = new HashMap<String, Object>();

			item.put("BarCode", cursor.getString(cursor.getColumnIndex("BarCode")));
			item.put("GoodsId", cursor.getString(cursor.getColumnIndex("GoodsId")));
			item.put("GoodsName", cursor.getString(cursor.getColumnIndex("GoodsName")));
			item.put("StyleInfo",cursor.getString(cursor.getColumnIndex("StyleInfo")));
			item.put("PriceInfo", cursor.getString(cursor.getColumnIndex("PriceInfo")));

			list.add(item);

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return list;
	}


	public List<Customer> GetAllCustomer()
	{
		return GetCustomers(null);
	}

	public Customer GetCustomerByCusCode(String cusCode)
	{
		List<Customer>  list=GetCustomers(" CusCode='"+cusCode+"'");
		if(list.size()<1)
			return null;
		else
			return list.get(0);
	}

	public List<Customer> GetCustomers(String whereSQL)
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		String strSQL="SELECT CusCode,CusName FROM Customer ";

		if(whereSQL!=null)
			strSQL+=" Where "+whereSQL;

		Cursor cursor=mDatabase.rawQuery(strSQL, null);

		List<Customer>  list=new ArrayList<Customer>();

		cursor.moveToFirst();

		while(!cursor.isAfterLast())
		{
			Customer c=new Customer();
			c.strCusCode=cursor.getString(cursor.getColumnIndex("CusCode"));
			c.strCusName=cursor.getString(cursor.getColumnIndex("CusName"));

			list.add(c);
			cursor.moveToNext();
		}


		cursor.close();
		mDatabase.close();

		return list;
	}


	public List<Product> GetProductByCuscodeAndBarcodes(String cuscode,String barcodes)
	{
		mWhereSQL="Where CusCode='"+cuscode+"'";

		if(barcodes!=null&&!barcodes.equals(""))
			mWhereSQL+=" and BarCode in ("+barcodes+")" ;

		Cursor cursor=GetProducts();

		List<Product> list=new ArrayList<Product>();

		while(!cursor.isAfterLast())
		{
			Product p=new Product();
			p.strBarCode=cursor.getString(cursor.getColumnIndex("BarCode"));
			list.add(p);

			cursor.moveToNext();
		}

		cursor.close();
		mDatabase.close();

		return list;
	}

	public Cursor GetProducts()
	{
		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);


		String strSQL="SELECT BarCode as _id,BarCode,GoodsId,GoodsName,StyleInfo,PriceInfo"
				+" FROM Product";

		if(mWhereSQL!=null)
			strSQL+=" "+mWhereSQL;


		Cursor cursor=mDatabase.rawQuery(strSQL, null);

		cursor.moveToFirst();

		mWhereSQL=null;

		return cursor;
	}
}
