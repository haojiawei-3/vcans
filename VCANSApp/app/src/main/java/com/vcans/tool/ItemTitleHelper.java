package com.vcans.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.Vcan.activity.MlqdActivity1;
import com.Vcan.activity.R;
import com.Vcan.activity.DPPeibuIn2;
import com.Vcan.activity.DPProductIn2;
import com.Vcan.activity.DPProductIn2_1;
import com.Vcan.activity.DPProductIn3;
import com.Vcan.activity.GDBakModule1;
import com.Vcan.activity.GDBakModule3;
import com.Vcan.activity.GDBakModule4;
import com.Vcan.activity.GDDirectOut3;

import com.vcans.dao.ItemTitleDao;
import com.vcans.model.ItemTitle;
import com.vcans.model.MenuK;
import com.vcans.model.MenuU;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.vcans.tool.PlProcessor.mActParent;

/**
 * 用于管理  textview,Spinner 内容的配制、是否启用、是否可为空
 * @author vcans
 *
 */
public class ItemTitleHelper {

	public final static String BAK_MODULE="备用模块";
	public final static String GD_QUERY="综合查询";
	public final static String QD="综合查询";
	public final static String NBAK_MODULE="备用模块";
	public final static   String K1="备用模块01";
	public final static   String K2="备用模块02";
	public final static   String K3="备用模块03";
	public final static   String K4="备用模块04";
	public final static   String K5="备用模块05";
	public final static   String K6="备用模块06";
	public final static   String K7="备用模块07";
	public final static   String K8="备用模块08";
	public final static   String K9="备用模块09";
	public final static   String K10="备用模块10";
	public final static   String G1="综合查询01";
	public final static   String G2="综合查询02";
	public final static   String G3="综合查询03";
	public final static   String G4="综合查询04";
	public final static   String G5="综合查询05";
	public final static   String G6="综合查询06";
	public final static   String G7="综合查询07";
	public final static   String G8="综合查询08";


	/**
	 * 默认排序号
	 */

	//内部自定义模块Id，服务端配制的固定值），不能随意更改
	public static String[] szModuleIds = {  "坯布进仓",   "生产投坯",   "成品进仓",
			                                "加工送仓库", "直接出货",   "任务简报",
											"任务简报二", "染整费用",   "备用模块一",
											"备用模块二", "备用模块三", "备用模块四",
											"备用模块五", "备用模块六", "综合查询一",
											"综合查询二", "综合查询三", "综合查询四",
											"备用模块01", "备用模块02", "备用模块03",
											"备用模块04", "备用模块05",
                                            "备用模块06", "备用模块07", "备用模块08",
                                            "备用模块08", "备用模块10",
                                            "综合查询01", "综合查询02", "综合查询03",
                                            "综合查询04", "综合查询05"

	};

	public static String[] szModuleIds1 = { "样品查询",   "展会询样",    "样品图片",
			                                "名片收集",    "清单一",     "清单二",
			                                "清单三"

	};

	public static String[] szModuleIds2 = { "待我审批",   "我已审批",    "已阅未批", "综合查询06", "综合查询07","综合查询08"

	};

	//是否从服务器获取标题标志  启动软件后只获取一次
	public static boolean bGetItemTitleFlag = true;

	//标题对象
	public static ItemTitle itemTitle = new ItemTitle();

	//系统-模块-固定值-标题/启用/选项值 的关联关系
	public static HashMap<String, HashMap<String, HashMap<String, String>>> mapSysModuleItems = new HashMap<String, HashMap<String, HashMap<String, String>>>();

	//系统-模块-资源ID-固定值 的关联关系
	public static HashMap<String, HashMap<String, HashMap<Integer, String>>> mapSysModuleIds = new HashMap<String, HashMap<String, HashMap<Integer, String>>>();
	//系统-模块-资源ID-固定值 的关联关系
	public static HashMap<String, HashMap<String, HashMap<Integer, String>>> mapxxModuleIds = new HashMap<String, HashMap<String, HashMap<Integer, String>>>();
	//系统-模块-资源ID-是否为空(Y/N)的关联关系
	public static HashMap<String, HashMap<String, HashMap<Integer, String>>> mapSysModuleIdsIsNull = new HashMap<String, HashMap<String, HashMap<Integer, String>>>();

	//Activity的下一个Activity关联关系
	public static HashMap<String,HashMap<String,Class>> mapNextActivity = new HashMap<String,HashMap<String,Class>>();

	/**
	 * 不允许为空的控件ID
	 */
	public static ArrayList<Integer> lstNotNullRId=new ArrayList<Integer>();

	/**
	 * 需检查不允许为空的按钮ID
	 */
	public static ArrayList<Integer> lstCheckNotNullBtnId=new ArrayList<Integer>();

	/**
	 * 是否直接进入下一窗体，窗体所有控件都设置为不启用时为TRUE
	 */
	public static boolean isDirectNextAct;
	private static Activity thisActivity;
	private static Class<?> mCls=null;

	/**
	 * 初始参数及对应关系,初始化资源控件Id与固定值关联关系 和 Activity的下一个Activity关联关系（用于某个窗体的所有控件都为隐藏时，直接进入下一个窗体）
	 */
	public static void InitParamMap() {

		/**
		 * 初始化Activity的下一个Activity关联关系 ，未设置的模块表示该模块窗体都不可缺少
		 */

		//坯布进仓
		HashMap<String,Class> mapPreNext=new HashMap<String,Class> ();
		mapPreNext.put("DPPeibuIn1", DPPeibuIn2.class);
		mapNextActivity.put(szModuleIds[0], mapPreNext);

		//生产投坯
		//mapPreNext=new HashMap<String,Class>();
		//mapNextActivity.put(szModuleIds[1], mapPreNext);

		//成品进仓
		mapPreNext=new HashMap<String,Class>();
		mapPreNext.put("DPTouPei1", DPProductIn2.class);
		mapPreNext.put("DPProductIn2", DPProductIn2_1.class);
		mapPreNext.put("DPProductIn2_1", DPProductIn3.class);
		mapNextActivity.put(szModuleIds[2], mapPreNext);

		//再加工送仓库
		//mapPreNext=new HashMap<String,Class>();
		//mapNextActivity.put(szModuleIds[3], mapPreNext);

		//直接出货
		mapPreNext=new HashMap<String,Class>();
		mapPreNext.put("GDDirectOut2", GDDirectOut3.class);
		mapNextActivity.put(szModuleIds[4], mapPreNext);

		//任务简报
		//mapPreNext=new HashMap<String,Class>();
		//mapNextActivity.put(szModuleIds[5], mapPreNext);

		//染整费用
		//mapPreNext=new HashMap<String,Class>();
		//mapNextActivity.put(szModuleIds[6], mapPreNext);

		//备用模块一/二/三/四
		mapPreNext=new HashMap<String,Class>();
		mapPreNext.put("GDBakModule", GDBakModule1.class);
		mapPreNext.put("GDBakModule2", GDBakModule3.class);
		mapPreNext.put("GDBakModule3", GDBakModule4.class);
		mapNextActivity.put(szModuleIds[7], mapPreNext);
		mapNextActivity.put(szModuleIds[8], mapPreNext);
		mapNextActivity.put(szModuleIds[9], mapPreNext);
		mapNextActivity.put(szModuleIds[10], mapPreNext);
		mapNextActivity.put(szModuleIds[11], mapPreNext);
		mapNextActivity.put(szModuleIds[12], mapPreNext);

		/**
		 * 键： 控件ID，值：服务器下发标题的配制项（为固定值，当为选择类型时且存在编号与名称  则列表标题显示
		 *  中文 加编号或名称  英文加ID而名称为空   格式约定为  固定值+(编号/ID,名称/ )） 注 :  [名称/] 表示英文的名称为空
		 */
		HashMap<Integer, String> mapRIDItem;
		/**
		 * 模块标题项
		 */
		HashMap<String, HashMap<Integer, String>> mapModuleItems = new HashMap<String, HashMap<Integer, String>>();

		// 坯布进仓
		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvActtitle,             "模块");
		mapRIDItem.put(R.id.tvOutNotifyId,          "关联单号");
		mapRIDItem.put(R.id.tvPackQuality,          "包装性质");
		mapRIDItem.put(R.id.dropPackQuality,        "包装性质");
		mapRIDItem.put(R.id.tvFabricQuality,        "面料性质");
		mapRIDItem.put(R.id.dropFabricQuality,      "面料性质");
		mapRIDItem.put(R.id.tvMaKou,                "码扣");
		mapRIDItem.put(R.id.tvRemark,               "说明");
		mapRIDItem.put(R.id.tvPosition,             "位置");
		mapRIDItem.put(R.id.tvPiCi,                 "批次号");
		mapRIDItem.put(R.id.tvPiShu,                "数量1");
		mapRIDItem.put(R.id.tvNum,                  "数量2");
		mapRIDItem.put(R.id.tvTitle,                "物料明细");
		mapRIDItem.put(R.id.tvSupplierId0,          "物料供应商");
		mapRIDItem.put(R.id.tvCompanyOrderId0,      "物料公司订单号");
		mapRIDItem.put(R.id.tvPurchaseId0,          "物料采购合同号");
		mapRIDItem.put(R.id.tvGoodsId0, 			"物料编号");
		mapRIDItem.put(R.id.tvGoodsDescribe0,       "物料描述");
		mapRIDItem.put(R.id.tvGPiShu0,              "物料数量1");
		mapRIDItem.put(R.id.tvGNum0,                "物料数量2");
		mapModuleItems.put(szModuleIds[0], mapRIDItem);



		// 生产投坯
		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvActtitle,              "模块");
		mapRIDItem.put(R.id.tvRZPlanId,              "染整计划号");
		mapRIDItem.put(R.id.tvCompanyOrder,          "公司订单号");
		mapRIDItem.put(R.id.tvRZFactoryId,           "染整厂编号");
		mapRIDItem.put(R.id.tvProType,               "生产类型");
		mapRIDItem.put(R.id.tvProTypeId0,            "生产类型+编号/ID");
		mapRIDItem.put(R.id.tvProTypeName0,          "生产类型+名称/");
		mapRIDItem.put(R.id.tvRZFactoryName,         "染整厂名称");
		mapRIDItem.put(R.id.tvWorkProcess,           "工序选择");
		mapRIDItem.put(R.id.tvGongXuId0,             "工序选择+编号/ID");
		mapRIDItem.put(R.id.tvGongXuName0,           "工序选择+名称/");
		mapRIDItem.put(R.id.tvProColor,              "投入颜色");
		mapRIDItem.put(R.id.tvPiCi,                  "批次号");
		mapRIDItem.put(R.id.tvPiShu,                 "数量1");
		mapRIDItem.put(R.id.tvNum,                   "数量2");
		mapRIDItem.put(R.id.chkBackModify,           "回修");
		mapRIDItem.put(R.id.chkInitPBTR,             "初始坯布投入");
		mapRIDItem.put(R.id.tvTitle,                 "物料明细");
		mapRIDItem.put(R.id.tvSupplierId0,           "物料供应商");
		mapRIDItem.put(R.id.tvCompanyOrderId0,       "物料公司订单号");
		mapRIDItem.put(R.id.tvPurchaseId0,           "物料采购合同号");
		mapRIDItem.put(R.id.tvGoodsId0,              "物料编号");
		mapRIDItem.put(R.id.tvGoodsDescribe0,        "物料描述");
		mapRIDItem.put(R.id.tvStoreDescribe0,        "物料存货描述");
		mapRIDItem.put(R.id.tvGPiShu0,               "物料数量1");
		mapRIDItem.put(R.id.tvGNum0,                 "物料数量2");
		mapModuleItems.put(szModuleIds[1], mapRIDItem);

		// 成品进仓
		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvActtitle,               "模块");
		mapRIDItem.put(R.id.tvRZPlanId,               "染整计划号");
		mapRIDItem.put(R.id.tvCompanyOrder,           "公司订单号");
		mapRIDItem.put(R.id.tvRZFactoryId,            "染整厂编号");
		mapRIDItem.put(R.id.tvProType,                "生产类型");
		mapRIDItem.put(R.id.tvProTypeId0,             "生产类型+编号/ID");
		mapRIDItem.put(R.id.tvProTypeName0,           "生产类型+名称/");
		mapRIDItem.put(R.id.tvRZFactoryName,          "染整厂名称");
		mapRIDItem.put(R.id.tvWorkProcess,            "工序选择");
		mapRIDItem.put(R.id.tvGongXuId0,              "工序选择+编号/ID");
		mapRIDItem.put(R.id.tvGongXuName0,            "工序选择+名称/");
		mapRIDItem.put(R.id.tvDelPiShu,               "扣除数量1");
		mapRIDItem.put(R.id.tvDelNum,                 "扣除数量2");
		mapRIDItem.put(R.id.tvCheckStatus,            "品检状态");
		mapRIDItem.put(R.id.tvCheckStatusId0,         "品检状态+编号/ID");
		mapRIDItem.put(R.id.tvCheckStatusName0,       "品检状态+名称/");
		mapRIDItem.put(R.id.tvFabricQuality,          "面料性质");
		mapRIDItem.put(R.id.dropFabricQuality,        "面料性质");
		mapRIDItem.put(R.id.tvKGM,                    "KG转M系数");
		mapRIDItem.put(R.id.tvColor,                  "产出颜色");
		mapRIDItem.put(R.id.tvPiCi,                   "批次号");
		mapRIDItem.put(R.id.tvUnit,                   "单位");
		mapRIDItem.put(R.id.dropUnit,                 "单位");
		mapRIDItem.put(R.id.tvPrice,                  "单价");
		mapRIDItem.put(R.id.tvPiShu,                  "数量1");
		mapRIDItem.put(R.id.tvNum,                    "数量2");
		mapRIDItem.put(R.id.tvGongYi2_1,              "工艺二1");
		mapRIDItem.put(R.id.tvGongyiId2_10,           "工艺二1+编号/ID");
		mapRIDItem.put(R.id.tvGongyiName2_10,         "工艺二1+名称/");
		mapRIDItem.put(R.id.tvGongYi2_2,              "工艺二2");
		mapRIDItem.put(R.id.tvGongyiId2_20,           "工艺二2+编号/ID");
		mapRIDItem.put(R.id.tvGongyiName2_20,         "工艺二2+名称/");
		mapRIDItem.put(R.id.tvGongYi2_3,              "工艺二3");
		mapRIDItem.put(R.id.tvGongyiId2_30,           "工艺二3+编号/ID");
		mapRIDItem.put(R.id.tvGongyiName2_30,         "工艺二3+名称/");
		mapRIDItem.put(R.id.tvTitle,                  "物料明细");
		mapRIDItem.put(R.id.tvSupplierId0,            "物料供应商");
		mapRIDItem.put(R.id.tvCompanyOrderId0,        "物料公司订单号");
		mapRIDItem.put(R.id.tvPurchaseId0,            "物料采购合同号");
		mapRIDItem.put(R.id.tvGoodsId0,               "物料编号");
		mapRIDItem.put(R.id.tvGoodsDescribe0,         "物料描述");
		mapRIDItem.put(R.id.tvStoreDescribe0,         "物料存货描述");
		mapRIDItem.put(R.id.tvGPiShu0,                "物料数量1");
		mapRIDItem.put(R.id.tvGNum0,                  "物料数量2");
		mapModuleItems.put(szModuleIds[2], mapRIDItem);


		// 加工送仓库
		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvOrderType,              "单据类型");
		mapRIDItem.put(R.id.dropOrderType,            "单据类型");
		mapRIDItem.put(R.id.tvActtitle,               "模块");
		mapRIDItem.put(R.id.tvRZPlanId,               "染整计划号");
		mapRIDItem.put(R.id.tvRZFactoryId,            "加工厂编号");
		mapRIDItem.put(R.id.tvAimFactoryId,           "目的厂编号");
		mapRIDItem.put(R.id.tvProType,                "生产类型");
		mapRIDItem.put(R.id.tvProTypeId0,             "生产类型+编号/ID");
		mapRIDItem.put(R.id.tvProTypeName0,           "生产类型+名称/");
		mapRIDItem.put(R.id.tvRZFactoryName,          "目的厂名称");
		mapRIDItem.put(R.id.tvWorkProcess,            "工序选择");
		mapRIDItem.put(R.id.tvGongXuId0,              "工序选择+编号/ID");
		mapRIDItem.put(R.id.tvGongXuName0,            "工序选择+名称/");
		mapRIDItem.put(R.id.tvPiShu,                  "数量1");
		mapRIDItem.put(R.id.tvNum,                    "数量2");
		mapRIDItem.put(R.id.tvTitle,                  "物料明细");
		mapRIDItem.put(R.id.tvSupplierId0,            "物料供应商");
		mapRIDItem.put(R.id.tvCompanyOrderId0,        "物料公司订单号");
		mapRIDItem.put(R.id.tvPurchaseId0,            "物料采购合同号");
		mapRIDItem.put(R.id.tvGoodsId0,               "物料编号");
		mapRIDItem.put(R.id.tvGoodsDescribe0,         "物料描述");
		mapRIDItem.put(R.id.tvStoreDescribe0,         "物料存货描述");
		mapRIDItem.put(R.id.tvGPiShu0,                "物料数量1");
		mapRIDItem.put(R.id.tvGNum0,                  "物料数量2");

		mapModuleItems.put(szModuleIds[3], mapRIDItem);

		//直接出货
		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvActtitle,               "模块");
		mapRIDItem.put(R.id.tvRZPlanId,               "关联单号");
		mapRIDItem.put(R.id.tvDataItem1,              "数据采集项1");
		mapRIDItem.put(R.id.tvDataItem2,              "数据采集项2");
		mapRIDItem.put(R.id.tvDataItem3,              "数据采集项3");
		mapRIDItem.put(R.id.tvFuZhuData1,             "辅助一");
		mapRIDItem.put(R.id.tvFuZhuData1Id0,          "辅助一+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData1Name0,        "辅助一+名称/");
		mapRIDItem.put(R.id.tvFuZhuData2,             "辅助二");
		mapRIDItem.put(R.id.tvFuZhuData2Id0,          "辅助二+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData2Name0,        "辅助二+名称/");
		mapRIDItem.put(R.id.tvFuZhuData3,             "辅助三");
		mapRIDItem.put(R.id.tvFuZhuData3Id0,          "辅助三+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData3Name0,        "辅助三+名称/");
		mapRIDItem.put(R.id.tvFuZhuData4,             "辅助四");
		mapRIDItem.put(R.id.tvFuZhuData4Id0,          "辅助四+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData4Name0,        "辅助四+名称/");
		mapRIDItem.put(R.id.tvFuZhuData5,             "辅助五");
		mapRIDItem.put(R.id.tvFuZhuData5Id0,          "辅助五+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData5Name0,        "辅助五+名称/");
		mapRIDItem.put(R.id.tvPiShu,                  "数量1");
		mapRIDItem.put(R.id.tvNum,                    "数量2");
		mapRIDItem.put(R.id.tvTitle,                  "物料明细");
		mapRIDItem.put(R.id.tvGoodsId0,               "物料编号");
		mapRIDItem.put(R.id.tvGoodsDescribe0,         "物料描述");
		mapRIDItem.put(R.id.tvStoreDescribe0,         "物料存货描述");
		mapRIDItem.put(R.id.tvGPiShu0,                "物料数量1");
		mapRIDItem.put(R.id.tvGNum0,                  "物料数量2");
		mapRIDItem.put(R.id.tvRemark10,               "物料备用一");
		mapRIDItem.put(R.id.tvRemark20,               "物料备用二");
		mapRIDItem.put(R.id.tvRemark30,               "物料备用三");
		mapRIDItem.put(R.id.tvRemark40,               "物料备用四");
		mapRIDItem.put(R.id.tvRemark50,               "物料备用五");

		mapModuleItems.put(szModuleIds[4], mapRIDItem);

		// 任务简报
		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvActtitle,                "模块");
		mapRIDItem.put(R.id.tvRZPlanId,                "染整计划号");
		mapRIDItem.put(R.id.tvRZFactoryId,             "染整厂编号");
		mapRIDItem.put(R.id.tvRZFactoryName,           "染整厂名称");
		mapRIDItem.put(R.id.tvwenbenyiName,            "备用1");
		mapRIDItem.put(R.id.tvwenbenerName,            "备用2");
		mapRIDItem.put(R.id.tvWorkProcess,             "工序选择");
		mapRIDItem.put(R.id.tvGongXuId0,               "工序选择+编号/ID");
		mapRIDItem.put(R.id.tvGongXuName0,             "工序选择+名称/");
		mapRIDItem.put(R.id.tvCraftwork,               "工艺选择");
		mapRIDItem.put(R.id.tvGongyiId0,               "工艺选择+编号/ID");
		mapRIDItem.put(R.id.tvGongyiName0,             "工艺选择+名称/");
		mapRIDItem.put(R.id.tvwenbensanName,           "备用3");
		mapRIDItem.put(R.id.tvwenbensiName,            "备用4");
		mapRIDItem.put(R.id.tvDatetime,                "日期");
		mapRIDItem.put(R.id.tvwenbenwuName,            "备用5");
		mapRIDItem.put(R.id.tvwenbenliuName,           "备用6");
		mapRIDItem.put(R.id.tvPiShu,                   "数量1");
		mapRIDItem.put(R.id.tvNum,                     "数量2");
		mapRIDItem.put(R.id.shu3,                      "数量3");
		mapRIDItem.put(R.id.shu4,                      "数量4");
		mapModuleItems.put(szModuleIds[5], mapRIDItem);

		// 任务简报二
		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvActtitle,                "模块");
		mapRIDItem.put(R.id.tvRZPlanId,                "染整计划号");
		mapRIDItem.put(R.id.tvRZFactoryId,             "染整厂编号");
		mapRIDItem.put(R.id.tvRZFactoryName,           "染整厂名称");
		mapRIDItem.put(R.id.tvwenbenyiName,            "备用1");
		mapRIDItem.put(R.id.tvwenbenerName,            "备用2");
		mapRIDItem.put(R.id.tvWorkProcess,             "工序选择");
		mapRIDItem.put(R.id.tvGongXuId0,               "工序选择+编号/ID");
		mapRIDItem.put(R.id.tvGongXuName0,             "工序选择+名称/");
		mapRIDItem.put(R.id.tvCraftwork,               "工艺选择");
		mapRIDItem.put(R.id.tvGongyiId0,               "工艺选择+编号/ID");
		mapRIDItem.put(R.id.tvGongyiName0,             "工艺选择+名称/");
		mapRIDItem.put(R.id.tvwenbensanName,           "备用3");
		mapRIDItem.put(R.id.tvwenbensiName,            "备用4");
		mapRIDItem.put(R.id.tvDatetime,                "日期");
		mapRIDItem.put(R.id.tvwenbenwuName,            "备用5");
		mapRIDItem.put(R.id.tvwenbenliuName,           "备用6");
		mapRIDItem.put(R.id.tvPiShu,                   "数量1");
		mapRIDItem.put(R.id.tvNum,                     "数量2");
		mapRIDItem.put(R.id.shu3,                      "数量3");
		mapRIDItem.put(R.id.shu4,                      "数量4");
		mapModuleItems.put(szModuleIds[6], mapRIDItem);





		// 染整费用
		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvActtitle,                 "模块");
		mapRIDItem.put(R.id.tvRZPlanId,                 "染整计划号");
		mapRIDItem.put(R.id.tvRZFactoryId,              "染整厂编号");
		mapRIDItem.put(R.id.tvRZFactoryName,            "染整厂名称");
		mapRIDItem.put(R.id.tvWorkProcess,              "工序选择");
		mapRIDItem.put(R.id.tvGongXuId0,                "工序选择+编号/ID");
		mapRIDItem.put(R.id.tvGongXuName0,              "工序选择+名称/");
		mapRIDItem.put(R.id.tvCostSelect,               "费用选择");
		mapRIDItem.put(R.id.tvCostSelectId0,            "费用选择+编号/ID");
		mapRIDItem.put(R.id.tvCostSelect0,              "费用选择+名称/");
		mapRIDItem.put(R.id.tvCost,                     "费用");
		mapRIDItem.put(R.id.tvPiShu,                    "数量1");
		mapRIDItem.put(R.id.tvNum,                      "数量2");
		mapRIDItem.put(R.id.tvRemark,                   "说明");
		mapModuleItems.put(szModuleIds[7], mapRIDItem);

		// 备用模块一/二/三/四
		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvActtitle,                 "模块");
		mapRIDItem.put(R.id.tvBakType,                  "备用类型");
		mapRIDItem.put(R.id.dropBakType,                "备用类型");
		mapRIDItem.put(R.id.tvDataItem1,                "备用数据1");
		mapRIDItem.put(R.id.tvDataItem2,                "备用数据2");
		mapRIDItem.put(R.id.tvBakDate,                  "备用日期");
		mapRIDItem.put(R.id.tvDataItem3,                "备用数据3");
		mapRIDItem.put(R.id.tvDataItem4,                "备用数据4");
		mapRIDItem.put(R.id.tvDataItem5,                "备用数据5");
		mapRIDItem.put(R.id.tvDataItem6,                "备用数据6");
		mapRIDItem.put(R.id.tvDataItem7,                "备用数据7");
		mapRIDItem.put(R.id.tvFuZhuData1,               "备用辅助资料1");
		mapRIDItem.put(R.id.tvFuZhuData1Id0,            "备用辅助资料1+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData1Name0,          "备用辅助资料1+名称/");
		mapRIDItem.put(R.id.tvFuZhuData2,               "备用辅助资料2");
		mapRIDItem.put(R.id.tvFuZhuData2Id0,            "备用辅助资料2+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData2Name0,          "备用辅助资料2+名称/");
		mapRIDItem.put(R.id.tvFuZhuData3,               "备用辅助资料3");
		mapRIDItem.put(R.id.tvFuZhuData3Id0,            "备用辅助资料3+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData3Name0,          "备用辅助资料3+名称/");
		mapRIDItem.put(R.id.tvFuZhuData4,               "备用辅助资料4");
		mapRIDItem.put(R.id.tvFuZhuData4Id0,            "备用辅助资料4+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData4Name0,          "备用辅助资料4+名称/");
		mapRIDItem.put(R.id.tvFuZhuData5,               "备用辅助资料5");
		mapRIDItem.put(R.id.tvFuZhuData5Id0,            "备用辅助资料5+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData5Name0,          "备用辅助资料5+名称/");
		mapRIDItem.put(R.id.tvFuZhuData6,               "备用辅助资料6");
		mapRIDItem.put(R.id.tvFuZhuData6Id0,            "备用辅助资料6+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData6Name0,          "备用辅助资料6+名称/");
		mapRIDItem.put(R.id.tvFuZhuData7,               "备用辅助资料7");
		mapRIDItem.put(R.id.tvFuZhuData7Id0,            "备用辅助资料7+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData7Name0,          "备用辅助资料7+名称/");
		mapRIDItem.put(R.id.tvFuZhuData8,               "备用辅助资料8");
		mapRIDItem.put(R.id.tvFuZhuData8Id0,            "备用辅助资料8+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData8Name0,          "备用辅助资料8+名称/");
		mapRIDItem.put(R.id.tvFuZhuData9,               "备用辅助资料9");
		mapRIDItem.put(R.id.tvFuZhuData9Id0,            "备用辅助资料9+编号/ID");
		mapRIDItem.put(R.id.tvFuZhuData9Name0,          "备用辅助资料9+名称/");
		mapRIDItem.put(R.id.tvDelPiShu,                 "扣除数量1");
		mapRIDItem.put(R.id.tvDelNum,                   "扣除数量2");
		mapRIDItem.put(R.id.tvPiShu,                    "数量1");
		mapRIDItem.put(R.id.tvNum,                      "数量2");
		mapRIDItem.put(R.id.imgCusCard,                 "图片");
		mapRIDItem.put(R.id.tvTitle,                    "物料明细");
		mapRIDItem.put(R.id.tvGoodsId0,                 "物料编号");
		mapRIDItem.put(R.id.tvGoodsDescribe0,           "物料描述");
		mapRIDItem.put(R.id.tvStoreDescribe0,           "物料存货描述");
		mapRIDItem.put(R.id.tvGPiShu0,                  "物料数量1");
		mapRIDItem.put(R.id.tvGNum0,                    "物料数量2");
		mapRIDItem.put(R.id.tvRemark10,                 "物料备用一");
		mapRIDItem.put(R.id.tvRemark20,                 "物料备用二");
		mapRIDItem.put(R.id.tvRemark30,                 "物料备用三");
		mapRIDItem.put(R.id.tvRemark40,                 "物料备用四");
		mapRIDItem.put(R.id.tvRemark50,                 "物料备用五");

		mapModuleItems.put(szModuleIds[8], mapRIDItem); //1
		mapModuleItems.put(szModuleIds[9], mapRIDItem);//2
		mapModuleItems.put(szModuleIds[10], mapRIDItem);//3
		mapModuleItems.put(szModuleIds[11], mapRIDItem);//4
		mapModuleItems.put(szModuleIds[12], mapRIDItem);//5
		mapModuleItems.put(szModuleIds[13], mapRIDItem);//6

		//综合查询  一/二/三
		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvActtitle,                 "模块");
		mapRIDItem.put(R.id.tvBakType,                  "备用类型");
		mapRIDItem.put(R.id.dropBakType,                "备用类型");
		mapRIDItem.put(R.id.tvDataItem1,                "查询条件1");
		mapRIDItem.put(R.id.tvDataItem2,                "查询条件2");
		mapRIDItem.put(R.id.tvFuZhuData1,               "辅助条件1");
		mapRIDItem.put(R.id.tvFuZhuData2,               "辅助条件2");
		mapRIDItem.put(R.id.tvFuZhuData3,               "辅助条件3");
		mapRIDItem.put(R.id.tvTitle,                    "物料明细");
		mapRIDItem.put(R.id.tvGoodsId0,                 "物料编号");
		mapRIDItem.put(R.id.tvGoodsDescribe0,           "物料描述");
		mapRIDItem.put(R.id.tvStoreDescribe0,           "物料存货描述");
		mapRIDItem.put(R.id.tvGPiShu0,                  "物料数量1");
		mapRIDItem.put(R.id.tvGNum0,                    "物料数量2");
		mapRIDItem.put(R.id.tvRemark10,                 "物料备用一");
		mapRIDItem.put(R.id.tvRemark20,                 "物料备用二");
		mapRIDItem.put(R.id.tvRemark30,                 "物料备用三");
		mapRIDItem.put(R.id.tvRemark40,                 "物料备用四");
		mapRIDItem.put(R.id.tvRemark50,                 "物料备用五");

		mapModuleItems.put(szModuleIds[14], mapRIDItem);
		mapModuleItems.put(szModuleIds[15], mapRIDItem);
		mapModuleItems.put(szModuleIds[16], mapRIDItem);
		mapModuleItems.put(szModuleIds[17], mapRIDItem);

		//备用模块  01/02/03/04/05
		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvActtitle,                 "模块");
		mapRIDItem.put(R.id.tvBYName1,                  "字段01");
		mapRIDItem.put(R.id.tvBYName2,                  "字段02");
		mapRIDItem.put(R.id.tvBYName3,                  "字段03");
		mapRIDItem.put(R.id.tvBYName4,                  "字段04");
		mapRIDItem.put(R.id.tvBYName5,                  "字段05");
		mapRIDItem.put(R.id.tvBYName6,                  "字段06");
		mapRIDItem.put(R.id.tvBYName7,                  "字段07");
		mapRIDItem.put(R.id.tvBYName8,                  "字段08");
		mapRIDItem.put(R.id.tvBYName9,                  "字段09");
		mapRIDItem.put(R.id.tvBYName10,                 "字段10");
		mapRIDItem.put(R.id.tvBYName11,                 "字段11");
		mapRIDItem.put(R.id.tvBYName12,                 "字段12");
		mapRIDItem.put(R.id.tvBYName13,                 "字段13");
		mapRIDItem.put(R.id.tvBYName14,                 "字段14");
		mapRIDItem.put(R.id.tvBYName15,                 "字段15");
		mapRIDItem.put(R.id.tvBYName16,                 "字段16");
		mapRIDItem.put(R.id.tvBYName17,                 "字段17");
		mapRIDItem.put(R.id.tvBYName18,                 "字段18");
		mapRIDItem.put(R.id.tvBYName19,                 "字段19");
		mapRIDItem.put(R.id.tvBYName20,                 "字段20");
		mapRIDItem.put(R.id.tvBYName21,                 "字段21");
		mapRIDItem.put(R.id.tvBYName22,                 "字段22");
		mapRIDItem.put(R.id.tvBYName23,                 "字段23");
		mapRIDItem.put(R.id.tvBYName24,                 "字段24");
		mapRIDItem.put(R.id.tvBYName25,                 "字段25");
		mapRIDItem.put(R.id.tvBYName26,                 "字段26");
		mapRIDItem.put(R.id.tvBYName27,                 "字段27");



		mapModuleItems.put(szModuleIds[18], mapRIDItem); //1
		mapModuleItems.put(szModuleIds[19], mapRIDItem);//2
		mapModuleItems.put(szModuleIds[20], mapRIDItem);//3
		mapModuleItems.put(szModuleIds[21], mapRIDItem);//4
		mapModuleItems.put(szModuleIds[22], mapRIDItem);//5

		//备用模块  06/07/08/09/10
		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvActtitle,                 "模块");
		mapRIDItem.put(R.id.tvBYName1,                  "字段01");
		mapRIDItem.put(R.id.tvBYName2,                  "字段02");
		mapRIDItem.put(R.id.tvBYName3,                  "字段03");
		mapRIDItem.put(R.id.tvBYName4,                  "字段04");
		mapRIDItem.put(R.id.tvBYName5,                  "字段05");
		mapRIDItem.put(R.id.tvBYName6,                  "字段06");

		mapRIDItem.put(R.id.tvBYName7,                  "字段07");
		mapRIDItem.put(R.id.tvBYName8,                  "字段08");
		mapRIDItem.put(R.id.tvBYName9,                  "字段09");
		mapRIDItem.put(R.id.tvBYName10,                 "字段10");
		mapRIDItem.put(R.id.tvTitle,                    "物料明细");
		mapRIDItem.put(R.id.tvGoodsId0,                 "物料编号");
		mapRIDItem.put(R.id.tvGoodsDescribe0,           "物料描述");
		mapRIDItem.put(R.id.tvStoreDescribe0,           "物料存货描述");
		mapRIDItem.put(R.id.tvGPiShu0,                  "物料数量1");
		mapRIDItem.put(R.id.tvGNum0,                    "物料数量2");
		mapRIDItem.put(R.id.tvRemark10,                 "物料备用一");
		mapRIDItem.put(R.id.tvRemark20,                 "物料备用二");
		mapRIDItem.put(R.id.tvRemark30,                 "物料备用三");
		mapRIDItem.put(R.id.tvRemark40,                 "物料备用四");
		mapRIDItem.put(R.id.tvRemark50,                 "物料备用五");
		mapRIDItem.put(R.id.tvBYName11,                 "字段11");
		mapRIDItem.put(R.id.tvBYName12,                 "字段12");
		mapRIDItem.put(R.id.tvBYName13,                 "字段13");
		mapRIDItem.put(R.id.tvBYName14,                 "字段14");
		mapRIDItem.put(R.id.tvBYName15,                 "字段15");
		mapRIDItem.put(R.id.tvBYName16,                 "字段16");
		mapRIDItem.put(R.id.tvBYName17,                 "字段17");
		mapRIDItem.put(R.id.tvBYName18,                 "字段18");
		mapRIDItem.put(R.id.tvBYName19,                 "字段19");
		mapRIDItem.put(R.id.tvBYName20,                 "字段20");
		mapRIDItem.put(R.id.tvBYName21,                 "字段21");
		mapRIDItem.put(R.id.tvBYName22,                 "字段22");
		mapRIDItem.put(R.id.tvBYName23,                 "字段23");
		mapRIDItem.put(R.id.tvBYName24,                 "字段24");
		mapRIDItem.put(R.id.tvBYName25,                 "字段25");
		mapRIDItem.put(R.id.tvBYName26,                 "字段26");



		mapModuleItems.put(szModuleIds[23], mapRIDItem);//6
		mapModuleItems.put(szModuleIds[24], mapRIDItem);//7
		mapModuleItems.put(szModuleIds[25], mapRIDItem);//8
		mapModuleItems.put(szModuleIds[26], mapRIDItem);//9
		mapModuleItems.put(szModuleIds[27], mapRIDItem);//10


		mapRIDItem = new HashMap<Integer, String>();
		mapRIDItem.put(R.id.tvActtitle,                 "模块");
		mapRIDItem.put(R.id.tvBYName1,                  "字段01");
		mapRIDItem.put(R.id.tvBYName2,                  "字段02");
		mapRIDItem.put(R.id.tvBYName3,                  "字段03");
		mapRIDItem.put(R.id.tvBYName4,                  "字段04");
		mapRIDItem.put(R.id.tvBYName5,                  "字段05");
		mapRIDItem.put(R.id.tvBYName6,                  "字段06");
		mapRIDItem.put(R.id.tvBYName7,                  "字段07");
		mapRIDItem.put(R.id.tvBYName8,                  "字段08");
		mapRIDItem.put(R.id.tvBYName9,                  "字段09");
		mapRIDItem.put(R.id.tvBYName10,                 "字段10");
		mapRIDItem.put(R.id.tvBYName11,                 "字段11");
		mapRIDItem.put(R.id.tvBYName12,                 "字段12");
		mapRIDItem.put(R.id.tvTitle,                    "物料明细");
		mapRIDItem.put(R.id.tvGoodsId0,                 "物料编号");
		mapRIDItem.put(R.id.tvGoodsDescribe0,           "物料描述");
		mapRIDItem.put(R.id.tvStoreDescribe0,           "物料存货描述");
		mapRIDItem.put(R.id.tvGPiShu0,                  "物料数量1");
		mapRIDItem.put(R.id.tvGNum0,                    "物料数量2");
		mapRIDItem.put(R.id.tvRemark10,                 "物料备用一");
		mapRIDItem.put(R.id.tvRemark20,                 "物料备用二");
		mapRIDItem.put(R.id.tvRemark30,                 "物料备用三");
		mapRIDItem.put(R.id.tvRemark40,                 "物料备用四");
		mapRIDItem.put(R.id.tvRemark50,                 "物料备用五");



		mapModuleItems.put(szModuleIds[28], mapRIDItem);//01
		mapModuleItems.put(szModuleIds[29], mapRIDItem);//02
		mapModuleItems.put(szModuleIds[30], mapRIDItem);//03
		mapModuleItems.put(szModuleIds[31], mapRIDItem);//04
		mapModuleItems.put(szModuleIds[32], mapRIDItem);//05
		mapModuleItems.put(szModuleIds2[3], mapRIDItem);//03
		mapModuleItems.put(szModuleIds2[4], mapRIDItem);//04
		mapModuleItems.put(szModuleIds2[5], mapRIDItem);//05

		mapSysModuleIds.put("跟单", mapModuleItems);

		mapSysModuleIds.put("信息中心", mapModuleItems);
	}

	/**
	 * 通过下载下来的模块配制信息来，来获得模块标题和模块启用标志
	 * @return 返回null表示无配制信息
	 */
	public static ArrayList<MenuU> getMenuInfo() {

		ItemTitleDao titleDao = new ItemTitleDao();
		mapSysModuleItems=titleDao.GetAllItemTitles();

		ArrayList<MenuU> list=new ArrayList<MenuU>();

		if (mapSysModuleItems.size() > 0) {
			HashMap<String, HashMap<String, String>> mapModuleItems= ItemTitleHelper.mapSysModuleItems.get("跟单");

			//如此遍历保证菜单顺序
			int i=1;
			for(String innerModuleName :szModuleIds)
			{
				HashMap<String, String> itemValues=mapModuleItems.get(innerModuleName);

				String strSortId,strIconId;
				MenuU menu=new MenuU();

				if(itemValues!=null) //"模块"  为固定值  入键
				{
					menu.name=itemValues.get(ItemTitle.MODULE+ItemTitle.TITLE+itemTitle.language);
					menu.nameCh=itemValues.get(ItemTitle.MODULE+ItemTitle.TITLE);
					menu.strEnabled=itemValues.get(ItemTitle.MODULE+ItemTitle.ENABLED);
					strSortId=itemValues.get(ItemTitle.MODULE+ItemTitle.SORT);
					strIconId=itemValues.get(ItemTitle.MODULE+ItemTitle.ICON);

					if(menu.strEnabled==null)
						menu.strEnabled="N";

					if(strSortId!=null) {
						try {
							menu.sortId = Integer.valueOf(strSortId);
						}catch (Exception e){
							ActivityHelper.ToastShow(mActParent,"配置异常<"+strSortId+">无法转化为排序（int）");
						}
					}
					else {
						menu.sortId = i;
					}


					if(strIconId!=null)
						menu.iconId=Integer.valueOf(strIconId);
					else
						menu.iconId=i;
				}
				else
				{
					menu.name=innerModuleName;
					menu.nameCh=innerModuleName;
					menu.sortId=i;
					menu.iconId=i;
				}

				menu.modulesId=innerModuleName;
				i++;

				list.add(menu);
			}

			return list;
		}

		return list;
	}

	public static HashMap<String, ArrayList<MenuK>> getMenuInfo2() {
		String  [] list={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27"};
		String ss="字段";
		HashMap<String, ArrayList<MenuK>>   MenuKlist=new HashMap<String, ArrayList<MenuK>>();

		if (mapSysModuleItems.size() > 0) {
			HashMap<String, HashMap<String, String>> mapModuleItems= ItemTitleHelper.mapSysModuleItems.get("跟单");

			//如此遍历保证菜单顺序
			int i=1;
			for(String innerModuleName :szModuleIds)
			{
				HashMap<String, String> itemValues=mapModuleItems.get(innerModuleName);



				if(itemValues!=null){
					if (innerModuleName.equals(ItemTitleHelper.K1)) {
						ArrayList<MenuK> menuKs1=new ArrayList<MenuK>();
						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs1.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.K1, menuKs1);
					} else if (innerModuleName.equals(ItemTitleHelper.K2)) {
						ArrayList<MenuK> menuKs2=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs2.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.K2, menuKs2);
					}else if (innerModuleName.equals(ItemTitleHelper.K3)) {
						ArrayList<MenuK> menuKs3=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs3.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.K3, menuKs3);
					}else if (innerModuleName.equals(ItemTitleHelper.K4)) {
						ArrayList<MenuK> menuKs4=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs4.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.K4, menuKs4);
					} else if (innerModuleName.equals(ItemTitleHelper.K5)) {
						ArrayList<MenuK> menuKs5=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs5.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.K5, menuKs5);
					}else if (innerModuleName.equals(ItemTitleHelper.K6)) {
						ArrayList<MenuK> menuKs6=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs6.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.K6, menuKs6);
					}else if (innerModuleName.equals(ItemTitleHelper.K7)) {
						ArrayList<MenuK> menuKs7=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs7.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.K7, menuKs7);
					}else if (innerModuleName.equals(ItemTitleHelper.K8)) {
						ArrayList<MenuK> menuKs8=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs8.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.K8, menuKs8);
					}else if (innerModuleName.equals(ItemTitleHelper.K9)) {
						ArrayList<MenuK> menuKs9=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs9.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.K9, menuKs9);
					}else if (innerModuleName.equals(ItemTitleHelper.K10)) {
						ArrayList<MenuK> menuKs10=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs10.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.K10, menuKs10);
					}


				}


			}


		}
		return MenuKlist;
	}

	public static HashMap<String, ArrayList<MenuK>> getMenuInfo3() {
		String  [] list={"01","02","03","04","05","06","07","08","09","10","11","12"};
		String ss="字段";
		HashMap<String, ArrayList<MenuK>>   MenuKlist=new HashMap<String, ArrayList<MenuK>>();

		if (mapSysModuleItems.size() > 0) {
			HashMap<String, HashMap<String, String>> mapModuleItems= ItemTitleHelper.mapSysModuleItems.get("跟单");
			HashMap<String, HashMap<String, String>> mapModuleItemsxx= ItemTitleHelper.mapSysModuleItems.get("信息中心");

			//如此遍历保证菜单顺序
			int i=1;
			for(String innerModuleName :szModuleIds)
			{
				HashMap<String, String> itemValues=mapModuleItems.get(innerModuleName);



				if(itemValues!=null){
					if (innerModuleName.equals(ItemTitleHelper.G1)) {
						ArrayList<MenuK> menuKs1=new ArrayList<MenuK>();
						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs1.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.G1, menuKs1);
					} else if (innerModuleName.equals(ItemTitleHelper.G2)) {
						ArrayList<MenuK> menuKs2=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs2.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.G2, menuKs2);
					}else if (innerModuleName.equals(ItemTitleHelper.G3)) {
						ArrayList<MenuK> menuKs3=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs3.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.G3, menuKs3);
					}else if (innerModuleName.equals(ItemTitleHelper.G4)) {
						ArrayList<MenuK> menuKs4=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs4.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.G4, menuKs4);
					} else if (innerModuleName.equals(ItemTitleHelper.G5)) {
						ArrayList<MenuK> menuKs5=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs5.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.G5, menuKs5);
					}else if (innerModuleName.equals(ItemTitleHelper.G6)) {
						ArrayList<MenuK> menuKs6=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs6.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.G6, menuKs6);
					}else if (innerModuleName.equals(ItemTitleHelper.G7)) {
						ArrayList<MenuK> menuKs7=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs7.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.G7, menuKs7);
					}else if (innerModuleName.equals(ItemTitleHelper.G8)) {
						ArrayList<MenuK> menuKs8=new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu=new MenuK();
							menu.strEnabled=itemValues.get(ss+list[j]+"启用");
							menu.instant=itemValues.get(ss+list[j]+"即发");
							menu.key=itemValues.get(ss+list[j]+"入键");
							menu.notnull=itemValues.get(ss+list[j]+"允许为空");
							menu.Scanning=itemValues.get(ss+list[j]+"启用扫描");
							menu.title=itemValues.get(ss+list[j]+"标题");
							menu.total=itemValues.get(ss+list[j]+"合计");
							menu.type=itemValues.get(ss+list[j]+"类型");
							menuKs8.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.G8, menuKs8);
					}


				}


			}

			for(String innerModuleName :szModuleIds2)
			{
				HashMap<String, String> itemValues=mapModuleItemsxx.get(innerModuleName);



				if(itemValues!=null) {
					if (innerModuleName.equals(ItemTitleHelper.G6)) {
						ArrayList<MenuK> menuKs1 = new ArrayList<MenuK>();
						for (int j = 0; j < list.length; j++) {
							MenuK menu = new MenuK();
							menu.strEnabled = itemValues.get(ss + list[j] + "启用");
							menu.instant = itemValues.get(ss + list[j] + "即发");
							menu.key = itemValues.get(ss + list[j] + "入键");
							menu.notnull = itemValues.get(ss + list[j] + "允许为空");
							menu.Scanning = itemValues.get(ss + list[j] + "启用扫描");
							menu.title = itemValues.get(ss + list[j] + "标题");
							menu.total = itemValues.get(ss + list[j] + "合计");
							menu.type = itemValues.get(ss + list[j] + "类型");
							menuKs1.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.G6, menuKs1);
					} else if (innerModuleName.equals(ItemTitleHelper.G7)) {
						ArrayList<MenuK> menuKs2 = new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu = new MenuK();
							menu.strEnabled = itemValues.get(ss + list[j] + "启用");
							menu.instant = itemValues.get(ss + list[j] + "即发");
							menu.key = itemValues.get(ss + list[j] + "入键");
							menu.notnull = itemValues.get(ss + list[j] + "允许为空");
							menu.Scanning = itemValues.get(ss + list[j] + "启用扫描");
							menu.title = itemValues.get(ss + list[j] + "标题");
							menu.total = itemValues.get(ss + list[j] + "合计");
							menu.type = itemValues.get(ss + list[j] + "类型");
							menuKs2.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.G7, menuKs2);
					} else if (innerModuleName.equals(ItemTitleHelper.G8)) {
						ArrayList<MenuK> menuKs3 = new ArrayList<MenuK>();

						for (int j = 0; j < list.length; j++) {
							MenuK menu = new MenuK();
							menu.strEnabled = itemValues.get(ss + list[j] + "启用");
							menu.instant = itemValues.get(ss + list[j] + "即发");
							menu.key = itemValues.get(ss + list[j] + "入键");
							menu.notnull = itemValues.get(ss + list[j] + "允许为空");
							menu.Scanning = itemValues.get(ss + list[j] + "启用扫描");
							menu.title = itemValues.get(ss + list[j] + "标题");
							menu.total = itemValues.get(ss + list[j] + "合计");
							menu.type = itemValues.get(ss + list[j] + "类型");
							menuKs3.add(menu);
						}
						MenuKlist.put(ItemTitleHelper.G8, menuKs3);
					}

				}
			}


		}
		return MenuKlist;
	}

	public static ArrayList<MenuU> getMenuInfo1() {

		ItemTitleDao titleDao = new ItemTitleDao();
		mapSysModuleItems=titleDao.GetAllItemTitles();

		ArrayList<MenuU> list=new ArrayList<MenuU>();

		if (mapSysModuleItems.size() > 0) {
			HashMap<String, HashMap<String, String>> mapModuleItems= ItemTitleHelper.mapSysModuleItems.get("样品管家");
			if (mapModuleItems!=null) {
				//如此遍历保证菜单顺序
				int i=1;
				for(String innerModuleName :szModuleIds1)
				{
					HashMap<String, String> itemValues=mapModuleItems.get(innerModuleName);

					String strSortId,strIconId;
					MenuU menu=new MenuU();

					if(itemValues!=null) //"模块"  为固定值
					{
						menu.name=itemValues.get(ItemTitle.MODULE+ItemTitle.TITLE+itemTitle.language);
						menu.nameCh=itemValues.get(ItemTitle.MODULE+ItemTitle.TITLE);
						menu.strEnabled=itemValues.get(ItemTitle.MODULE+ItemTitle.ENABLED);
						strSortId=itemValues.get(ItemTitle.MODULE+ItemTitle.SORT);
						strIconId=itemValues.get(ItemTitle.MODULE+ItemTitle.ICON);

						if(menu.strEnabled==null)
							menu.strEnabled="N";

						if(strSortId!=null)
							menu.sortId=Integer.valueOf(strSortId);
						else
							menu.sortId=i;


						if(strIconId!=null)
							menu.iconId=Integer.valueOf(strIconId);
						else
							menu.iconId=i;
					}
					else
					{
						menu.name=innerModuleName;
						menu.nameCh=innerModuleName;
						menu.sortId=i;
						menu.iconId=i;
						menu.strEnabled="Y";
					}

					menu.modulesId=innerModuleName;
					i++;

					list.add(menu);
				}

				return list;
			}

		}

		return list;
	}





	public static ArrayList<MenuU> getMenuxx() {

		ItemTitleDao titleDao = new ItemTitleDao();
		mapSysModuleItems=titleDao.GetAllItemTitles();

		ArrayList<MenuU> list=new ArrayList<MenuU>();

		if (mapSysModuleItems.size() > 0) {
			HashMap<String, HashMap<String, String>> mapModuleItems= ItemTitleHelper.mapSysModuleItems.get("信息中心");
			if (mapModuleItems!=null) {
				//如此遍历保证菜单顺序
				int i=1;
				for(String innerModuleName :szModuleIds2)
				{
					HashMap<String, String> itemValues=mapModuleItems.get(innerModuleName);

					String strSortId,strIconId;
					MenuU menu=new MenuU();

					if(itemValues!=null) //"模块"  为固定值
					{
						menu.name=itemValues.get(ItemTitle.MODULE+ItemTitle.TITLE+itemTitle.language);
						menu.nameCh=itemValues.get(ItemTitle.MODULE+ItemTitle.TITLE);
						menu.strEnabled=itemValues.get(ItemTitle.MODULE+ItemTitle.ENABLED);
						strSortId=itemValues.get(ItemTitle.MODULE+ItemTitle.SORT);
						strIconId=itemValues.get(ItemTitle.MODULE+ItemTitle.ICON);

						if(menu.strEnabled==null)
							menu.strEnabled="N";

						if(strSortId!=null)
							menu.sortId=Integer.valueOf(strSortId);
						else
							menu.sortId=i;


						if(strIconId!=null) {
							menu.iconId = Integer.valueOf(strIconId);
							menu.iconId = menu.iconId - 33;
						}
						else {
							menu.iconId = i;
						}
					}
					else
					{
						menu.name=innerModuleName;
						menu.nameCh=innerModuleName;
						menu.sortId=i;
						menu.iconId=i;
						menu.strEnabled="Y";
					}

					menu.modulesId=innerModuleName;
					i++;

					list.add(menu);
				}

				return list;
			}

		}

		return list;
	}

	/**
	 * 通过模块配制信息，设置控件标题、初始下拉框内容，控件是否使用
	 * @param parent
	 */
	public static void setItemTitle(Object parent) {

		if (ItemTitleHelper.mapSysModuleItems.size() > 0) {
			String s=ItemTitleHelper.itemTitle.sysId;
			String s1=ItemTitleHelper.itemTitle.moduleId;
			HashMap<Integer, String> mapIdItem = ItemTitleHelper.mapSysModuleIds.get(ItemTitleHelper.itemTitle.sysId).get(ItemTitleHelper.itemTitle.moduleId);

			HashMap<String, String> mapItemValue = ItemTitleHelper.mapSysModuleItems.get(ItemTitleHelper.itemTitle.sysId).get(ItemTitleHelper.itemTitle.moduleId);

			if (mapItemValue != null) {
				View v=null;
				int nResId;

				String itemName;//标题
				String itemOption;//选项
				String itemEnabled;//选项
				String itemIsNull;//是否为空
				String strTeil="";//固定值   尾部值(当为选择类型项时，尾部值可能为 编号或名称)
				Iterator it = mapIdItem.keySet().iterator();
				Activity activty=null;
				isDirectNextAct=true;
				boolean isActivity;

				if (parent instanceof Activity) {//更新界面标题
					isActivity=true;
					lstNotNullRId.clear();
				}
				else
					isActivity=false;


				while (it.hasNext()) {

					nResId = (Integer) it.next();

					itemName = mapIdItem.get(nResId);
					itemOption=itemName;
					itemEnabled=itemName;
					itemIsNull=itemName;

					if(itemName.indexOf("+")>=0)   //"+"为约定符号  解决列表中存在编号和名称
					{
						String[] szTemp=itemName.split("\\+");

						itemName=szTemp[0]+ItemTitle.TITLE + itemTitle.language;
						strTeil=szTemp[1];

						itemOption=szTemp[0]+ ItemTitle.OPTION;
						itemEnabled=szTemp[0]+ ItemTitle.ENABLED;
						itemIsNull=szTemp[0]+ ItemTitle.ISNULL;

						String[] szTeil= strTeil.split("/");

						strTeil="";

						if(szTeil.length>=2)
						{
							if(itemTitle.language.equals(itemTitle.EN))
								strTeil=" "+szTeil[1]; //英文标题后缀
							else
								strTeil=szTeil[0]; //中文标题后缀
						}
						else if(szTeil.length==1)
						{
							if(itemTitle.language.equals(itemTitle.EN))
								strTeil="";
							else
								strTeil=szTeil[0]; //中文标题后缀
						}
					}
					else
					{
						strTeil="";
						itemName+= ItemTitle.TITLE + itemTitle.language;
						itemOption+= ItemTitle.OPTION;
						itemEnabled+= ItemTitle.ENABLED;
						itemIsNull+= ItemTitle.ISNULL;
					}

					//获取控件对像
					if (isActivity) {//更新界面标题
						activty = (Activity) parent;
						v = activty.findViewById(nResId);
					} else {//更新列表控件中的标题
						View view = (View) parent;
						v = view.findViewById(nResId);
					}








					//标题    判断控件Id对应的固定值  是否存在于配制项-配制值容器中
					if (mapItemValue.get(itemName) != null) {
						//设置标题
						if (v != null) {
							if (v instanceof TextView) {
								TextView tv = (TextView) v;
								tv.setText(mapItemValue.get(itemName)+strTeil);
							}
						}
					}







					//选项    判断控件Id对应的固定值  是否存在于配制项-配制值容器中
					if (mapItemValue.get(itemOption) != null) {

						//初始选项值
						if (v != null) {
							if (v instanceof Spinner) {
								String strValues=mapItemValue.get(itemOption);
								String[] szOptionValues=strValues.split("/");

								if(activty!=null)
									ActivityHelper.InitDrop(activty, nResId, Arrays.asList(szOptionValues), true);
							}
						}
					}

					//是否启用    判断控件Id对应的固定值  是否存在于配制项-配制值容器中   模块启用固定值不需要在这里使用
					if (mapItemValue.get(itemEnabled) != null&&!itemEnabled.equals(ItemTitle.MODULE_ENABLED_ITEM)) {
						//设置启用  隐藏或显示
						if (v != null) {
							LinearLayout layView=(LinearLayout)v.getParent();
							String flag=mapItemValue.get(itemEnabled);

							if(flag.equals("N"))
							{//为未启用
								layView.setVisibility(View.GONE);

								for(int i=0;i<layView.getChildCount();++i)
								{
									View cv=layView.getChildAt(i);
									if (cv instanceof EditText)
									{
										EditText et=(EditText)cv;
										et.setText("0");
										break;
									}
									else if (cv instanceof Spinner)
									{
										Spinner drop=(Spinner)cv;
										int rid=drop.getId();
										////设置无数据时需加 []号，以便与获取控件数据时统一
										ActivityHelper.InitDrop(activty, rid, Arrays.asList("[无数据]"), true);
										break;
									}

								}
							}else{
								isDirectNextAct=false;
							}
						}
					}

				}


				/**
				 * 进入下一个窗体
				 */
				if(activty!=null)
				{
					if(isDirectNextAct)
					{
						String className=activty.getClass().getSimpleName();
						mCls=null;

						try{
							mCls=mapNextActivity.get(ItemTitleHelper.itemTitle.moduleId).get(className);
						}
						catch(Exception e)
						{

							e.getMessage();
						}


						thisActivity=activty;
						if(mCls!=null){

							//获取当前窗体所在位置
							int index=ActivityHelper.lstActivities.indexOf(thisActivity);
							for(int i=index;i>1;--i)
							{
								//获取当前窗体的上一个窗体
								Activity preAct=ActivityHelper.lstActivities.get(i);
								if(preAct!=null)
								{
									Intent intent=new Intent(preAct,mCls);
									preAct.startActivity(intent);
									preAct.finish();
//									new Handler().postDelayed(new Runnable(){
//
//										public void run() {
//											thisActivity.finish();
//										}
//
//									},300);

									break;
								}
							}
						}

						int ii=0;

					}
				}
			}
		}
	}







	public static void setItemType(Object parent) {

		if (ItemTitleHelper.mapSysModuleItems.size() > 0) {
			HashMap<Integer, String> mapIdItem = ItemTitleHelper.mapSysModuleIds.get(ItemTitleHelper.itemTitle.sysId).get(ItemTitleHelper.itemTitle.moduleId);

			HashMap<String, String> mapItemValue = ItemTitleHelper.mapSysModuleItems.get(ItemTitleHelper.itemTitle.sysId).get(ItemTitleHelper.itemTitle.moduleId);

			if (mapItemValue != null) {
				View v=null;
				int nResId;

				String itemName;//标题
				String itemOption;//选项
				String itemEnabled;//选项
				String itemIsNull;//是否为空
				String strTeil="";//固定值   尾部值(当为选择类型项时，尾部值可能为 编号或名称)
				Iterator it = mapIdItem.keySet().iterator();
				Activity activty=null;
				isDirectNextAct=true;
				boolean isActivity;

				if (parent instanceof Activity) {//更新界面标题
					isActivity=true;
					lstNotNullRId.clear();
				}
				else
					isActivity=false;


				while (it.hasNext()) {

					nResId = (Integer) it.next();

					itemName = mapIdItem.get(nResId);
					itemOption=itemName;
					itemEnabled=itemName;
					itemIsNull=itemName;

					if(itemName.indexOf("+")>=0)   //"+"为约定符号  解决列表中存在编号和名称
					{
						String[] szTemp=itemName.split("\\+");

						itemName=szTemp[0]+ItemTitle.TITLE + itemTitle.language;
						strTeil=szTemp[1];

						itemOption=szTemp[0]+ ItemTitle.OPTION;
						itemEnabled=szTemp[0]+ ItemTitle.ENABLED;
						itemIsNull=szTemp[0]+ ItemTitle.ISNULL;

						String[] szTeil= strTeil.split("/");

						strTeil="";

						if(szTeil.length>=2)
						{
							if(itemTitle.language.equals(itemTitle.EN))
								strTeil=" "+szTeil[1]; //英文标题后缀
							else
								strTeil=szTeil[0]; //中文标题后缀
						}
						else if(szTeil.length==1)
						{
							if(itemTitle.language.equals(itemTitle.EN))
								strTeil="";
							else
								strTeil=szTeil[0]; //中文标题后缀
						}
					}
					else
					{
						strTeil="";
						itemName+= ItemTitle.TITLE + itemTitle.language;
						itemOption+= ItemTitle.OPTION;
						itemEnabled+= ItemTitle.ENABLED;
						itemIsNull+= ItemTitle.ISNULL;
					}

					//获取控件对像
					if (isActivity) {//更新界面标题
						activty = (Activity) parent;
						v = activty.findViewById(nResId);
					} else {//更新列表控件中的标题
						View view = (View) parent;
						v = view.findViewById(nResId);
					}

					//标题    判断控件Id对应的固定值  是否存在于配制项-配制值容器中
					if (mapItemValue.get(itemName) != null) {
						//设置标题
						if (v != null) {
							if (v instanceof TextView) {
								TextView tv = (TextView) v;
								tv.setText(mapItemValue.get(itemName)+strTeil);
							}
						}
					}

					//选项    判断控件Id对应的固定值  是否存在于配制项-配制值容器中
					if (mapItemValue.get(itemOption) != null) {

						//初始选项值
						if (v != null) {
							if (v instanceof Spinner) {
								String strValues=mapItemValue.get(itemOption);
								String[] szOptionValues=strValues.split("/");

								if(activty!=null)
									ActivityHelper.InitDrop(activty, nResId, Arrays.asList(szOptionValues), true);
							}
						}
					}


					//是否启用    判断控件Id对应的固定值  是否存在于配制项-配制值容器中   模块启用固定值不需要在这里使用
					if (mapItemValue.get(itemEnabled) != null&&!itemEnabled.equals(ItemTitle.MODULE_ENABLED_ITEM)) {
						//设置启用  隐藏或显示
						if (v != null) {
							LinearLayout layView=(LinearLayout)v.getParent();
							String flag=mapItemValue.get(itemEnabled);

							if(flag.equals("N"))
							{//为未启用
								layView.setVisibility(View.GONE);

								for(int i=0;i<layView.getChildCount();++i)
								{
									View cv=layView.getChildAt(i);
									if (cv instanceof EditText)
									{
										EditText et=(EditText)cv;
										et.setText("0");
										break;
									}
									else if (cv instanceof Spinner)
									{
										Spinner drop=(Spinner)cv;
										int rid=drop.getId();
										////设置无数据时需加 []号，以便与获取控件数据时统一
										ActivityHelper.InitDrop(activty, rid, Arrays.asList("[无数据]"), true);
										break;
									}

								}
							}
							else
							{
								isDirectNextAct=false;
							}
						}
					}



				}
			}



		}
	}












}











