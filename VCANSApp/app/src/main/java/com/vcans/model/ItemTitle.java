package com.vcans.model;

public class ItemTitle {

	/*
	 * 从服务器下载下来的 数据格式为 如： 包装性质启用:Y/N 包装性质选项：卷装/包装/匹装 包装性质标题:包装性质 包装性质标题_En:
	 *
	 * 把可能今后会改变的词提取出来
	 */


	public static final String SORT = "排序";
	public static final String ICON = "图标";
	public static final String TITLE = "标题";
	public static final String ENABLED = "启用";
	public static final String OPTION = "选项";
	public static final String ISNULL = "为空";

	public static final String MODULE="模块";
	public static final String MODULE_ENABLED_ITEM=MODULE+ENABLED;
	public static final String EN = "_En";
	public static final String CH = "";

	/**
	 * 系统ID  跟单 或 样品  固定值
	 */
	public  String sysId;

	/**
	 * 模块ID  如  坯布进仓或生成投坯 等等
	 */
	public  String moduleId;

	/**
	 * 标题固定值
	 */
	public  String itemName;

	/**
	 * 标题值
	 */
	public  String itemValue;
	/**
	 * EN
	 */
	public  String language = "EN";
}
