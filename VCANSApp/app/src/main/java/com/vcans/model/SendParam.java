package com.vcans.model;


import com.vcans.Processor.BaseActivity;
import com.vcans.tool.PlProcessor;

public class SendParam {
	public String tip="";           //标题
	public String[] szData={""};    //可带数据
	public PlProcessor processor;   //上传下载处理基类
	public BaseActivity parent;     //上下文
	public boolean bSendEndNotify=false;

	public String strCmd;    //不知道
	public String receText;  //不知道
	public boolean bShowTipDlg=true; //是否显示TipDlg
}
