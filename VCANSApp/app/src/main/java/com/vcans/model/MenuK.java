package com.vcans.model;

public class MenuK{
	/**
	 * 启用
	 */
	public String strEnabled="";
	/**
	 * 标题
	 */
	public String title="";
	/**
	 * 类型
	 */
	public String type="";
	/**
	 * 入键
	 */
	public String key="";
	/**
	 * 即发
	 */
	public String instant="";
	/**
	 * 合计
	 */
	public String total="";
	/**
	 * 允许为空
	 */
	public String notnull="";
	/**
	 * 启用扫描
	 */
	public String Scanning="";
	public MenuK(String strEnabled, String title, String type, String key,String instant, String total,String notnull,String Scanning) {
		super();
		this.strEnabled = strEnabled;
		this.title = title;
		this.type = type;
		this.key = key;
		this.instant = instant;
		this.total = total;
		this.notnull = notnull;
		this.Scanning = Scanning;
	}
	public MenuK() {

	}


}
