package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;

import com.Vcan.activity.R;

/**
 * 皮肤
 * @author vcans
 *
 */
public class Skin {

	/*先定义成颜色资源，然后根据选择设置颜色，而用直接用颜色值时，某颜色值发现转换异常 如#0093DD
	 * 一共13个模块 跟单，样品，底部菜单
	 */
	public static final int[] szColorDefault={R.color.pbiGreen,R.color.toupeiRed,
			R.color.PIblue,R.color.MachingRed,R.color.DirectOutYellow,R.color.taskRed,R.color.YPGreen,
			R.color.rzCost,
			R.color.pbiGreen,               //备用模块一
			R.color.toupeiRed,              //备用模块二
			R.color.PIblue,                 //备用模块三
			R.color.MachingRed,             //备用模块四
			R.color.DirectOutYellow,        //备用模块五
			R.color.taskRed,                //备用模块六
			R.color.gdQuery1,               //综合查询一
			R.color.gdQuery2,               //综合查询二
			R.color.gdQuery3,               //综合查询三
			R.color.gdQuery4,               //综合查询四
			R.color.YPGreen,                //备用模块01
			R.color.gdQuery1,               //备用模块02
			R.color.gdQuery2,               //备用模块03
			R.color.gdQuery3,               //备用模块04
			R.color.gdQuery4,               //备用模块05
			R.color.YPGreen,                //备用模块06
			R.color.gdQuery1,               //备用模块07
			R.color.gdQuery2,               //备用模块08
			R.color.gdQuery3,               //备用模块09
			R.color.gdQuery4,               //备用模块10
			R.color.gdQuery1,               //综合查询01
			R.color.gdQuery2,               //综合查询02
			R.color.gdQuery3,               //综合查询03
			R.color.gdQuery4,               //综合查询04
			R.color.gdQuery1,               //综合查询05

			R.color.YPGreen,                //样品查询
			R.color.topRed,                 //展会询样
			R.color.YPImgZiSe,              //样品图片
			R.color.toupeiRed,              //名品收集
			R.color.PIblue,                 //清单一
			R.color.DirectOutYellow,        //清单二
			R.color.gdQuery4,               //清单三


			R.color.YPGreen,                //样品查询
			R.color.topRed,                 //展会询样
			R.color.YPImgZiSe,              //样品图片
			R.color.PIblue,                 //综合查询06
			R.color.DirectOutYellow,        //综合查询07
			R.color.gdQuery4,               //综合查询08
			};


	//主题颜色
	public  static int themeColor;

	//进入模块后选中的行色（或模块颜色）
	public   static  int selectedColor;

	//模块颜色列表
	public   static List<Integer> moduleColorList=new ArrayList<Integer>();
}
