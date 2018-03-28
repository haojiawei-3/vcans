package com.vcans.model;

public class MenuU {
	/**
	 * 菜单名
	 */
	public String name="";
	/**
	 * 菜单中文名，主要作用 用于上传到服务器认证菜单
	 */
	public String nameCh="";

	/**
	 * 图片Id
	 */
	public int iconId;

	/**
	 * 菜单是否启用
	 */
	public String strEnabled="N"; //Y/N

	/**
	 * 排序号
	 */
	public int sortId;

	/**
	 * 颜色ID
	 */
	public int colorId;

	/**
	 * 事件名
	 */

	public String eventName;

	/**
	 * 菜单对应的模块ID
	 */

	public String modulesId;
}
