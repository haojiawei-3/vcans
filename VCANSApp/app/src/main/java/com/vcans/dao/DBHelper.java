package com.vcans.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.vcans.Processor.BaseActivity;
import com.vcans.tool.ActivityHelper;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
/**
 * 数据库工具类         如果数据库有更新        DB_VERSION     要改变
 * @return
 */ //如果数据库有更新        DB_VERSION     要改变
public class DBHelper {

	public static final String DB_PATH="/data/data/com."+ActivityHelper.APP_DIR.toLowerCase()+"/files/VCANS.db";
	static String mDbPath;
	static SQLiteDatabase mDatabase=null;
	public static final String DB_VERSION="db20180209";
	private static String strOldDBPath="";
	private static ArrayList<String> arrCmdList=new ArrayList<String>();
	/**
	 * 产品
	 */
	public static final String Product="Product";
	/**
	 * 客户
	 */
	public static final String Customer="Customer";
	/**
	 * 坯布进仓
	 */
	public static final String PeibuIn="PeibuIn";
	/**
	 * 生产投坯
	 */
	public static final String SCTouPei	="SCTouPei";
	/**
	 * 成品进仓
	 */
	public static final String ProductIn="ProductIn";
	/**
	 * 染整任务简报
	 */
	public static final String RZTask="RZTask";
	/**
	 * 染整任务简报二
	 */
	public static final String RZTask2="RZTask2";
	/**
	 * 新备用模块1-5
	 */
	public static final String RZTask3="RZTask3";
	/**
	 * 新备用模块6-10
	 */
	public static final String ByModel="ByModel";
	/**
	 * 清单
	 */
	public static final String MLQingdan="MLQingdan";
	/**
	 * 备用模块
	 */
	public static final String BakModule="BakModule";
	/**
	 * 配置版本对比
	 */
	public static final String Version	="Version";
	/**
	 * 客户收藏
	 */
	public static final String CustomerCollect="CustomerCollect";
	/**
	 * 购物车
	 */
	public static final String Collect="Collect";
	/**
	 * 样品展会询样
	 */
	public static final String YPExpostion	="YPExpostion";
	/**
	 * 染整费用
	 */
	public static final String RZCost="RZCost";
	/**
	 * 审批
	 */
	public static final String Pendingapproval="Pendingapproval";
	/**
	 * 审批cz
	 */
	public static final String Pendingapprovalcz="Pendingapprovalcz";
	/**
	 * 名片识读
	 */
	public static final String Mpsb	="Mpsb";
	/**
	 * 界面标题
	 */
	public static final String UIItemTitle="UIItemTitle";
	/**
	 * 样品信息
	 */
	public static final String YPInfo="YPInfo";
	/**
	 * 清单
	 */
	public static final String MLQingdanone="MLQingdanone";
	/**
	 * 样品信息 -批量信息
	 */
	public static final String YangPin="YangPin";
	/**
	 * 审批
	 */
	public static final String Pendingapprovalxx="Pendingapprovalxx";
	/**
	 * 直接出货
	 */
	public static final String DirectOut="DirectOut";
	/**
	 * 样品图片
	 */
	public static final String BarcodeImage="BarcodeImage";
	/**
	 * 加工送仓库
	 */
	public static final String Machining="Machining";
	/**
	 * 历史
	 */
	public static final String History="History";

	/**
	 * 比较数据库版本
	 * @param version
	 * @return
	 */
	public static int compareDBVersion(String version)
	{
		if(BaseActivity.mMainActivity==null)
			return -1;

		HashMap<String,String> mapParms=ActivityHelper.getParams(BaseActivity.mMainActivity, new String[]{"dbVersion","DBPath"});

		if(mapParms.size()>0)
		{
			strOldDBPath=mapParms.get("DBPath");

			if(mapParms.get("dbVersion").equals(version))
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}

		return 0;
	}
	/**
	 *
	 *
	 * 保存数据库*/


	/**
	 *
	 *
	 * 保存数据库版本信息*/
	private static void saveDBVersion()
	{
		HashMap<String,String> mapParms=new HashMap<String,String>();
		mapParms.put("dbVersion", DB_VERSION);
		ActivityHelper.saveParams(BaseActivity.mMainActivity,mapParms);
	}
	/**
	 *
	 *
	 * 保存数据库路径信息*/
	private static void saveDBPath()
	{
		HashMap<String,String> mapParms=new HashMap<String,String>();
		mapParms.put("DBPath", mDbPath);
		ActivityHelper.saveParams(BaseActivity.mMainActivity,mapParms);
	}

	/**
	 *
	 *
	 * 新建数据库*/
	public static  String CreateTable()
	{
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
		{
			mDbPath=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/VCANS.db";
		}
		else
		{
			//mDbPath=DB_PATH;
			mDbPath=null;
		}


		int nChange=compareDBVersion(DB_VERSION);

		if(nChange==2)
		{
			File file=new File(mDbPath);
			if(file.exists())
			{
				file.delete();
			}
		}
		else if(nChange==-1)
		{
			return "";
		}


		mDatabase=SQLiteDatabase.openOrCreateDatabase(mDbPath, null);

		if(mDatabase!=null)
			saveDBPath();

		arrCmdList.clear();

		//比较结果为2 表示版本已更新
		if(nChange==2)
		{
//		    String [] s={"Product"};
//		    CreateTableSQL(s);
			//产品1
			String strCreateTableSQL="CREATE TABLE "+ Product +"("
					+"BarCode VARCHAR(200) primary key NOT NULL,"
					+"GoodsId VARCHAR(200)  NULL,"
					+"GoodsName VARCHAR(200)  NULL,"
					+"StyleInfo VARCHAR(200)  NULL,"
					+"PriceInfo VARCHAR(200)  NULL,"
					+"CusCode VARCHAR(200) NOT NULL)";

			arrCmdList.add(strCreateTableSQL);

//产品1
			 strCreateTableSQL="CREATE TABLE "+ History +"("
					 +"TPId integer primary key autoincrement  NOT NULL,"
					 +"Type VARCHAR(200)  NULL,"
					 +"ImagePath VARCHAR(200)  NULL,"
					 +"Spare1 VARCHAR(200)  NULL,"
					 +"Spare2 VARCHAR(200)  NULL,"
					 +"Spare3 VARCHAR(200)  NULL,"
					 +"Spare4 VARCHAR(200)  NULL,"
					 +"Spare5 VARCHAR(200)  NULL,"
					 +"Spare6 VARCHAR(200)  NULL,"
					 +"Spare7 VARCHAR(200) NOT NULL)";

			arrCmdList.add(strCreateTableSQL);

			//客户2
			strCreateTableSQL="CREATE TABLE "+ Customer +" ("
					+"CusCode VARCHAR(200) primary key NOT NULL,"
					+"CusName VARCHAR(200) NULL,"
					+"CusImagePath VARCHAR(500) NULL)";

			arrCmdList.add(strCreateTableSQL);

			//坯布进仓3
			strCreateTableSQL="CREATE TABLE  "+ PeibuIn +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"OutNotifyId VARCHAR(200)  NOT NULL,"
					+"SupplierId VARCHAR(200) NOT NULL,"
					+"CompanyOrderId VARCHAR(200) NOT NULL,"
					+"PurchaseId VARCHAR(200) NOT NULL,"
					+"GoodsId VARCHAR(200) NOT NULL,"
					+"GoodsDescribe VARCHAR(200) NOT NULL,"
					+"SendGoodsNum VARCHAR(200) NOT NULL,"
					+"OrderNum VARCHAR(200) NOT NULL,"
					+"GoodsRecordId VARCHAR(200) NOT NULL,"
					+"FabricQuality VARCHAR(200) NOT NULL,"
					+"PackQuality VARCHAR(200) NOT NULL,"
					+"MaKou VARCHAR(200) NOT NULL,"
					+"Remark VARCHAR(200) NOT NULL,"
					+"Position VARCHAR(200) NOT NULL,"
					+"PiShu VARCHAR(200) NOT NULL,"
					+"PiCi VARCHAR(200) NOT NULL,"
					+"Num VARCHAR(200) NOT NULL,"
					+"UserId VARCHAR(200) NOT NULL)";

			arrCmdList.add(strCreateTableSQL);

			//生产投坯4
			strCreateTableSQL="CREATE TABLE   "+ SCTouPei +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
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
					+"OldPiShu VARCHAR(200) NOT NULL,"
					+"OldNum VARCHAR(200) NOT NULL,"
					+"BackModify VARCHAR(200) NOT NULL,"
					+"InitPeiBuTR VARCHAR(200) NOT NULL,"
					+"PiShu VARCHAR(200) NOT NULL,"
					+"PiCi VARCHAR(200) NOT NULL,"
					+"Num VARCHAR(200) NOT NULL,"
					+"UserId VARCHAR(200) NOT NULL,"
					+"IsFuHeBu VARCHAR(200) NULL,"
					+"ProColor VARCHAR(200) NULL,"
					+"ProTypeId VARCHAR(200) NULL,"
					+"ProType VARCHAR(200) NULL)";

			arrCmdList.add(strCreateTableSQL);


			//成品进仓5
			strCreateTableSQL="CREATE TABLE   "+ ProductIn +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
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
					+"OldPiShu VARCHAR(200) NOT NULL,"
					+"OldNum VARCHAR(200) NOT NULL,"
					+"PiShu VARCHAR(200) NOT NULL,"
					+"PiCi VARCHAR(200) NOT NULL,"
					+"Num VARCHAR(200) NOT NULL,"

					+"DelPiShu VARCHAR(200) NOT NULL,"
					+"DelNum VARCHAR(200) NOT NULL,"
					+"CheckStatusId VARCHAR(200) NOT NULL,"
					+"CheckStatusName VARCHAR(200) NOT NULL,"
					+"FabricQuality VARCHAR(200) NOT NULL,"
					+"KGToM VARCHAR(200) NOT NULL,"
					+"FlowerType VARCHAR(200) NOT NULL,"
					+"Color VARCHAR(200) NOT NULL,"
					+"Price VARCHAR(200) NOT NULL,"
					+"Unit VARCHAR(200) NOT NULL,"
					+"UserId VARCHAR(200) NOT NULL,"
					+"IsFuHeBu VARCHAR(200) NULL,"
					+"ProTypeId VARCHAR(200) NULL,"
					+"ProType VARCHAR(200) NULL,"
					+"GongyiId2_1 VARCHAR(200) NULL,"
					+"GongyiId2_2 VARCHAR(200) NULL,"
					+"GongyiId2_3 VARCHAR(200) NULL,"
					+"GongyiName2_1 VARCHAR(200) NULL,"
					+"GongyiName2_2 VARCHAR(200) NULL,"
					+"GongyiName2_3 VARCHAR(200) NULL)";

			arrCmdList.add(strCreateTableSQL);


			//加工送仓库6
			strCreateTableSQL="CREATE TABLE  "+ Machining +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"RZPlanId VARCHAR(200) NOT NULL,"
					+"OrderType VARCHAR(200) NOT NULL,"
					+"AimFactoryId VARCHAR(200) NOT NULL,"
					+"ColorAllOut VARCHAR(200) NOT NULL,"
					+"RZFactoryId VARCHAR(200) NOT NULL,"
					+"GongXuId VARCHAR(200) NOT NULL,"
					+"GongXuName VARCHAR(200) NOT NULL,"
					+"CompanyOrderId VARCHAR(200) NOT NULL,"
					+"PurchaseId VARCHAR(200) NOT NULL,"
					+"GoodsId VARCHAR(200) NOT NULL,"
					+"GoodsDescribe VARCHAR(200) NOT NULL,"
					+"StoreDescribe VARCHAR(200) NOT NULL,"
					+"StoreFlag VARCHAR(200) NOT NULL,"
					+"OldPiShu VARCHAR(200) NOT NULL,"
					+"OldNum VARCHAR(200) NOT NULL,"
					+"PiShu VARCHAR(200) NOT NULL,"
					+"Num VARCHAR(200) NOT NULL,"
					+"UserId VARCHAR(200) NOT NULL,"
					+"ProTypeId VARCHAR(200) NULL,"
					+"ProType VARCHAR(200) NULL)";

			arrCmdList.add(strCreateTableSQL);

			//染整任务简报7
			strCreateTableSQL="CREATE TABLE  "+ RZTask +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"RZPlanId VARCHAR(200) NOT NULL,"
					+"RZFactoryId VARCHAR(200) NOT NULL,"
					+"RZFactoryName VARCHAR(200) NOT NULL,"

					+"strtxtby1Name VARCHAR(200) NOT NULL,"
					+"strtxtby2Name VARCHAR(200) NOT NULL,"

					+"GongXuId VARCHAR(200) NOT NULL,"
					+"GongXuName VARCHAR(200) NOT NULL,"
					+"GongyiId VARCHAR(200) NOT NULL,"
					+"GongyiName VARCHAR(200) NOT NULL,"

					+"strtxtby3Name VARCHAR(200) NOT NULL,"
					+"strtxtby4Name VARCHAR(200) NOT NULL,"

					+"RZDatetime VARCHAR(200) NOT NULL,"

					+"strtxtby5Name VARCHAR(200) NOT NULL,"
					+"strtxtby6Name VARCHAR(200) NOT NULL,"
					+"Remark VARCHAR(200) NULL,"
					+"PiShu VARCHAR(200) NULL,"
					+"shu3 VARCHAR(200) NULL,"
					+"shu4 VARCHAR(200) NULL,"
					+"Num VARCHAR(200) NOT NULL)";

			arrCmdList.add(strCreateTableSQL);


			//染整任务简报二 7
			strCreateTableSQL="CREATE TABLE  "+ RZTask2 +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"RZPlanId VARCHAR(200) NOT NULL,"
					+"RZFactoryId VARCHAR(200) NOT NULL,"
					+"RZFactoryName VARCHAR(200) NOT NULL,"

					+"strtxtby1Name VARCHAR(200) NOT NULL,"
					+"strtxtby2Name VARCHAR(200) NOT NULL,"

					+"GongXuId VARCHAR(200) NOT NULL,"
					+"GongXuName VARCHAR(200) NOT NULL,"
					+"GongyiId VARCHAR(200) NOT NULL,"
					+"GongyiName VARCHAR(200) NOT NULL,"

					+"strtxtby3Name VARCHAR(200) NOT NULL,"
					+"strtxtby4Name VARCHAR(200) NOT NULL,"

					+"RZDatetime VARCHAR(200) NOT NULL,"

					+"strtxtby5Name VARCHAR(200) NOT NULL,"
					+"strtxtby6Name VARCHAR(200) NOT NULL,"
					+"Remark VARCHAR(200) NULL,"
					+"PiShu VARCHAR(200) NULL,"
					+"shu3 VARCHAR(200) NULL,"
					+"shu4 VARCHAR(200) NULL,"
					+"Num VARCHAR(200) NOT NULL)";

			arrCmdList.add(strCreateTableSQL);


			//备用 1-5
			strCreateTableSQL="CREATE TABLE  "+ RZTask3 +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"ZhiDuan01Id VARCHAR(200) ,"
					+"ZhiDuan02Id VARCHAR(200) ,"
					+"ZhiDuan03Id VARCHAR(200)  ,"
					+"ZhiDuan04Id VARCHAR(200)  ,"
					+"ZhiDuan05Id VARCHAR(200)  ,"
					+"ZhiDuan06Id VARCHAR(200)  ,"
					+"ZhiDuan07Id VARCHAR(200)  ,"
					+"ZhiDuan08Id VARCHAR(200)  ,"
					+"ZhiDuan09Id VARCHAR(200)  ,"
					+"ZhiDuan10Id VARCHAR(200)  ,"
					+"ZhiDuan11Id VARCHAR(200)  ,"
					+"ZhiDuan12Id VARCHAR(200)  ,"
					+"ZhiDuan13Id VARCHAR(200)  ,"
					+"ZhiDuan14Id VARCHAR(200)  ,"
					+"ZhiDuan15Id VARCHAR(200)  ,"
					+"ZhiDuan16Id VARCHAR(200)  ,"
					+"ZhiDuan17Id VARCHAR(200)  ,"
					+"ZhiDuan18Id VARCHAR(200)  ,"
					+"ZhiDuan19Id VARCHAR(200)  ,"
					+"ZhiDuan20Id VARCHAR(200)  ,"
					+"ZhiDuan21Id VARCHAR(200)  ,"
					+"ZhiDuan22Id VARCHAR(200)  ,"
					+"ZhiDuan23Id VARCHAR(200)  ,"
					+"ZhiDuan24Id VARCHAR(200)  ,"
					+"ZhiDuan25Id VARCHAR(200)  ,"
					+"ZhiDuan26Id VARCHAR(200)  ,"
					+"ZhiDuan27Id VARCHAR(200)  ,"
					+"ZhiDuan28Id VARCHAR(200)  ,"//备用
					+"ZhiDuan29Id VARCHAR(200)  ,"//	备用
					+"ZhiDuan30Id VARCHAR(200)  )";//备用

			arrCmdList.add(strCreateTableSQL);


			//备用6-10
			strCreateTableSQL="CREATE TABLE  "+ ByModel +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"ZhiDuan01Id VARCHAR(200) ,"
					+"ZhiDuan02Id VARCHAR(200) ,"
					+"ZhiDuan03Id VARCHAR(200)  ,"
					+"ZhiDuan04Id VARCHAR(200)  ,"
					+"ZhiDuan05Id VARCHAR(200)  ,"
					+"ZhiDuan06Id VARCHAR(200)  ,"
					+"ImgPath VARCHAR(200) ,"
					+"ZhiDuan07Id VARCHAR(200)  ,"
					+"ZhiDuan08Id VARCHAR(200)  ,"
					+"ZhiDuan09Id VARCHAR(200)  ,"
					+"ZhiDuan10Id VARCHAR(200)  ,"
					+"GoodsId VARCHAR(200) ,"
					+"GoodsDescribe VARCHAR(200) ,"
					+"StoreDescribe VARCHAR(200) ,"
					+"StoreFlag VARCHAR(200) ,"
					+"GNum    VARCHAR(200) ,"
					+"GPiShu  VARCHAR(200) ,"
					+"Remark1 VARCHAR(200) ,"
					+"Remark2 VARCHAR(200) ,"
					+"Remark3 VARCHAR(200) ,"
					+"Remark4 VARCHAR(200) ,"
					+"Remark5 VARCHAR(200) ,"
					+"ZhiDuan11Id VARCHAR(200)  ,"
					+"ZhiDuan12Id VARCHAR(200)  ,"
					+"ZhiDuan13Id VARCHAR(200)  ,"
					+"ZhiDuan14Id VARCHAR(200)  ,"
					+"ZhiDuan15Id VARCHAR(200)  ,"
					+"ZhiDuan16Id VARCHAR(200)  ,"
					+"ZhiDuan17Id VARCHAR(200)  ,"
					+"ZhiDuan18Id VARCHAR(200)  ,"
					+"ZhiDuan19Id VARCHAR(200)  ,"
					+"ZhiDuan20Id VARCHAR(200)  ,"
					+"ZhiDuan21Id VARCHAR(200)  ,"
					+"ZhiDuan22Id VARCHAR(200)  ,"
					+"ZhiDuan23Id VARCHAR(200)  ,"
					+"ZhiDuan24Id VARCHAR(200)  ,"
					+"ZhiDuan25Id VARCHAR(200)  ,"
					+"ZhiDuan26Id VARCHAR(200)  ,"
					+"ZhiDuan27Id VARCHAR(200)  ,"
					+"ZhiDuan28Id VARCHAR(200)  ,"
					+"ZhiDuan29Id VARCHAR(200)  ,"
					+"ZhiDuan30Id VARCHAR(200)  )";

			arrCmdList.add(strCreateTableSQL);

			//染整费用8
			strCreateTableSQL="CREATE TABLE  "+ RZCost +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"RZPlanId VARCHAR(200) NOT NULL,"
					+"RZFactoryId VARCHAR(200) NOT NULL,"
					+"RZFactoryName VARCHAR(200) NOT NULL,"
					+"GongXuId VARCHAR(200) NOT NULL,"
					+"GongXuName VARCHAR(200) NOT NULL,"
					+"Cost VARCHAR(200) NOT NULL,"
					+"CostSelectId VARCHAR(200) NOT NULL,"
					+"CostSelectName VARCHAR(200) NOT NULL,"
					+"Remark VARCHAR(200) NULL,"
					+"PiShu VARCHAR(200) NULL,"
					+"Num VARCHAR(200) NOT NULL,"
					+"UserName VARCHAR(200) NOT NULL)";

			arrCmdList.add(strCreateTableSQL);

			//清单2  9

			strCreateTableSQL="CREATE TABLE  "+ MLQingdanone +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"Code VARCHAR(200) NOT NULL,"
					+"Pnumber VARCHAR(200) NOT NULL,"
					+"Pname VARCHAR(200) NULL,"
					+"Description1 VARCHAR(200) NULL,"
					+"Description2 VARCHAR(200) NULL,"
					+"Description3 VARCHAR(200) NULL,"
					+"Filter1 VARCHAR(200) NULL,"
					+"Filter2 VARCHAR(200) NULL,"
					+"Filter3 VARCHAR(200) NULL,"
					+"mulu2 VARCHAR(200) NULL,"
					+"mulu3 VARCHAR(200) NULL,"
					+"Quotation VARCHAR(200) NULL,"
					+"Spare VARCHAR(200) NULL,"
					+"Spare1 VARCHAR(200) NULL,"
					+"Spare2 VARCHAR(200) NULL,"
					+"Spare3 VARCHAR(200) NULL,"
					+"Spare4 VARCHAR(200) NOT NULL)";

			arrCmdList.add(strCreateTableSQL);



			//清单 10

			strCreateTableSQL="CREATE TABLE  "+ MLQingdan +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"Cj VARCHAR(200) NOT NULL,"
					+"Mlbh VARCHAR(200) NOT NULL,"
					+"Mlname VARCHAR(200) NULL,"
					+"Ssfjbh VARCHAR(200) NULL,"
					+"Spare VARCHAR(200) NULL,"
					+"Spare1 VARCHAR(200) NOT NULL)";

			arrCmdList.add(strCreateTableSQL);



			//购物车  11
			strCreateTableSQL="CREATE TABLE  "+ Collect +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"Code VARCHAR(200) NOT NULL,"
					+"Pnumber VARCHAR(200) NOT NULL,"
					+"Pname VARCHAR(200) NULL,"
					+"Description1 VARCHAR(200) NULL,"
					+"Description2 VARCHAR(200) NULL,"
					+"Description3 VARCHAR(200) NULL,"
					+"Filter1 VARCHAR(200) NULL,"
					+"Filter2 VARCHAR(200) NULL,"
					+"Filter3 VARCHAR(200) NULL,"
					+"mulu2 VARCHAR(200) NULL,"
					+"mulu3 VARCHAR(200) NULL,"
					+"Quotation VARCHAR(200) NULL,"
					+"Spare VARCHAR(200) NULL,"
					+"Spare1 VARCHAR(200) NULL,"
					+"Spare2 VARCHAR(200) NULL,"
					+"Spare3 VARCHAR(200) NULL,"
					+"Spare4 VARCHAR(200) NOT NULL)";

			arrCmdList.add(strCreateTableSQL);


			//客户收藏	  12
			//TPId mark mark1 khname linkman Phone addr khcode ypcode price number standby1 standby2 standby3
			strCreateTableSQL="CREATE TABLE  "+ CustomerCollect +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"mark VARCHAR(200) NOT NULL,"
					+"mark1 VARCHAR(200) NOT NULL,"
					+"khname VARCHAR(200) NULL,"
					+"linkman VARCHAR(200) NULL,"
					+"Phone VARCHAR(200) NULL,"
					+"addr VARCHAR(200) NULL,"
					+"khcode VARCHAR(200) NULL,"
					+"ypcode VARCHAR(200) NULL,"
					+"price VARCHAR(200) NULL,"
					+"number VARCHAR(200) NULL,"
					+"standby1 VARCHAR(200) NULL,"
					+"standby2 VARCHAR(200) NULL,"
					+"standby3 VARCHAR(200) NOT NULL)";

			arrCmdList.add(strCreateTableSQL);
			//审批 13

			strCreateTableSQL="CREATE TABLE  "+ Pendingapproval +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"XXId VARCHAR(200) NOT NULL,"
					+"Type VARCHAR(200) NOT NULL,"
					+"Themer VARCHAR(200) NOT NULL,"
					+"Initiator VARCHAR(200) NOT NULL,"
					+"Content VARCHAR(200) NOT NULL,"
					+"StateId VARCHAR(200) NOT NULL,"
					+"State VARCHAR(200) NOT NULL,"
					+"Moduletype VARCHAR(200) NOT NULL,"
					+"ModuletypeId VARCHAR(200) NOT NULL,"
					+"ModuleName VARCHAR(200) NOT NULL,"
					+"Odd VARCHAR(200) NULL,"
					+"OddId VARCHAR(200) NULL,"
					+"Date VARCHAR(200) NULL,"
					+"Spare1 VARCHAR(200) NOT NULL,"
					+"Spare2 VARCHAR(200) NOT NULL,"
					+"Spare3 VARCHAR(200) NULL,"
					+"Spare4 VARCHAR(200) NULL,"
					+"Spare5 VARCHAR(200) NOT NULL)";

			arrCmdList.add(strCreateTableSQL);

			//审批操作  TPId GlxxId Type CzId Czname  14
			strCreateTableSQL="CREATE TABLE  "+ Pendingapprovalcz +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"GlxxId VARCHAR(200) NOT NULL,"
					+"Type VARCHAR(200) NOT NULL,"
					+"CzId VARCHAR(200) NOT NULL,"
					+"Czname VARCHAR(200) NULL)";

			arrCmdList.add(strCreateTableSQL);

			//审批    15
			strCreateTableSQL="CREATE TABLE  "+ Pendingapprovalxx +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"XxId VARCHAR(200) NOT NULL,"
					+"CzId VARCHAR(200) NOT NULL,"
					+"Item  VARCHAR(200) NOT NULL,"
					+"Czname VARCHAR(200) NULL)";

			arrCmdList.add(strCreateTableSQL);

			//样品展会询样  16
			strCreateTableSQL="CREATE TABLE  "+ YPExpostion +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"CusBarcode VARCHAR(200) NOT NULL,"
					+"CusName VARCHAR(200) NULL,"
					+"CusImgName VARCHAR(500) NULL,"
					+"Barcode VARCHAR(200) NOT NULL,"
					+"Price VARCHAR(200) NOT NULL,"
					+"Num VARCHAR(200) NOT NULL)";

			arrCmdList.add(strCreateTableSQL);


			//名片识读company, linkname ,position ,phone1, phone2, fax ,address , www ,email ,note,ImgPath;   17
			strCreateTableSQL="CREATE TABLE  "+ Mpsb +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"company VARCHAR(200) NOT NULL,"
					+"linkname VARCHAR(200) NOT NULL,"
					+"position VARCHAR(200) NOT NULL, "
					+"phone1 VARCHAR(200) NOT NULL,"
					+"phone2 VARCHAR(200) NOT NULL,"
					+"fax VARCHAR(200) NOT NULL, "
					+"address VARCHAR(200) NOT NULL,"
					+"www VARCHAR(200) NOT NULL,"
					+"email VARCHAR(200) NOT NULL,"
					+"note VARCHAR(200) NOT NULL,"
					+"ImgPath VARCHAR(200) NOT NULL)";
			arrCmdList.add(strCreateTableSQL);

			//样品图片  18
			strCreateTableSQL="CREATE TABLE  "+ BarcodeImage +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"Barcode VARCHAR(200) NOT NULL,"
					+"Num VARCHAR(200) NOT NULL,"
					+"Price VARCHAR(200) NOT NULL,"
					+"ImgName VARCHAR(500) NULL)";

			arrCmdList.add(strCreateTableSQL);

			//样品信息 -批量信息  19
			strCreateTableSQL="CREATE TABLE "+ YangPin +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"Barcode VARCHAR(200) NOT NULL,"
					+"YPField VARCHAR(200) NOT NULL,"
					+"YPValue VARCHAR(200) NULL)";

			arrCmdList.add(strCreateTableSQL);

			//样品信息  20
			strCreateTableSQL="CREATE TABLE "+ YPInfo +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"Barcode VARCHAR(200) NOT NULL,"
					+"YPField VARCHAR(200) NOT NULL,"
					+"YPValue VARCHAR(200) NULL,"
					+"YPFlag integer NOT NULL)";

			arrCmdList.add(strCreateTableSQL);

			//界面标题   21
			strCreateTableSQL="CREATE TABLE "+ UIItemTitle +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"SysId VARCHAR(200),"
					+"ModuleId VARCHAR(200),"
					+"ItemName VARCHAR(200),"
					+"ItemValue VARCHAR(200))";

			arrCmdList.add(strCreateTableSQL);


			//配置版本对比  22
			strCreateTableSQL="CREATE TABLE "+ Version +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"VId VARCHAR(200),"
					+"VersionId VARCHAR(200))";

			arrCmdList.add(strCreateTableSQL);

			//直接出货     23
			strCreateTableSQL="CREATE TABLE "+ DirectOut +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"RZPlanId VARCHAR(200),"
					+"DataItem1 VARCHAR(200),"
					+"DataItem2 VARCHAR(200),"
					+"DataItem3 VARCHAR(200),"
					+"FuZhuData1Id VARCHAR(200),"
					+"FuZhuData2Id VARCHAR(200),"
					+"FuZhuData3Id VARCHAR(200),"
					+"FuZhuData4Id VARCHAR(200),"
					+"FuZhuData5Id VARCHAR(200),"
					+"FuZhuData1Name VARCHAR(200),"
					+"FuZhuData2Name VARCHAR(200),"
					+"FuZhuData3Name VARCHAR(200),"
					+"FuZhuData4Name VARCHAR(200),"
					+"FuZhuData5Name VARCHAR(200),"
					+"GoodsId VARCHAR(200),"
					+"GoodsDescribe VARCHAR(200),"
					+"StoreDescribe VARCHAR(200),"
					+"StoreFlag VARCHAR(200),"
					+"GNum VARCHAR(200),"
					+"GPiShu VARCHAR(200),"
					+"Remark1 VARCHAR(200),"
					+"Remark2 VARCHAR(200),"
					+"Remark3 VARCHAR(200),"
					+"Remark4 VARCHAR(200),"
					+"Remark5 VARCHAR(200),"
					+"Num VARCHAR(200),"
					+"PiShu VARCHAR(200),"
					+"UserName VARCHAR(200))";

			arrCmdList.add(strCreateTableSQL);

			//备用模块  24
			strCreateTableSQL="CREATE TABLE "+ BakModule +"("
					+"TPId integer primary key autoincrement  NOT NULL,"
					+"BakType VARCHAR(200),"
					+"DataItem1 VARCHAR(200),"
					+"DataItem2 VARCHAR(200),"
					+"BakDate   VARCHAR(200),"
					+"DataItem3 VARCHAR(200),"
					+"DataItem4 VARCHAR(200),"
					+"DataItem5 VARCHAR(200),"
					+"DataItem6 VARCHAR(200),"
					+"DataItem7 VARCHAR(200),"
					+"FuZhuData1Id VARCHAR(200),"
					+"FuZhuData2Id VARCHAR(200),"
					+"FuZhuData3Id VARCHAR(200),"
					+"FuZhuData4Id VARCHAR(200),"
					+"FuZhuData5Id VARCHAR(200),"
					+"FuZhuData6Id VARCHAR(200),"
					+"FuZhuData7Id VARCHAR(200),"
					+"FuZhuData8Id VARCHAR(200),"
					+"FuZhuData9Id VARCHAR(200),"
					+"FuZhuData1Name VARCHAR(200),"
					+"FuZhuData2Name VARCHAR(200),"
					+"FuZhuData3Name VARCHAR(200),"
					+"FuZhuData4Name VARCHAR(200),"
					+"FuZhuData5Name VARCHAR(200),"
					+"FuZhuData6Name VARCHAR(200),"
					+"FuZhuData7Name VARCHAR(200),"
					+"FuZhuData8Name VARCHAR(200),"
					+"FuZhuData9Name VARCHAR(200),"
					+"GoodsId VARCHAR(200),"
					+"GoodsDescribe VARCHAR(200),"
					+"StoreDescribe VARCHAR(200),"
					+"StoreFlag VARCHAR(200),"
					+"GNum    VARCHAR(200),"
					+"GPiShu  VARCHAR(200),"
					+"Remark1 VARCHAR(200),"
					+"Remark2 VARCHAR(200),"
					+"Remark3 VARCHAR(200),"
					+"Remark4 VARCHAR(200),"
					+"Remark5 VARCHAR(200),"
					+"DelNum VARCHAR(200),"
					+"DelPiShu VARCHAR(200),"
					+"Num VARCHAR(200),"
					+"PiShu VARCHAR(200),"
					+"UserName VARCHAR(200),"
					+"ImgPath VARCHAR(200),"
					+"BakFlag VARCHAR(200))";

			arrCmdList.add(strCreateTableSQL);

			//执行SQL
			try
			{
				for(String strSQL:arrCmdList)
					mDatabase.execSQL(strSQL);
			}
			catch(Exception e)
			{
				e.getMessage();

			}

			saveDBVersion();
		}


		mDatabase.close();
		return mDbPath;
	}
}
