package com.vcans.model;

public class MyProtocol
{
	public String sendCmd0; //C     开始命令
	public String sendCmd1; //C     上传记录格式
	public String sendCmd2; //C     上传记录格式
	public String sendCmd3; //C     请求错误信息继续
	public String sendCmd4; //C     发送图片
	public String receCmd0; //C     成功
	public String receCmd1; //s 	 失败
	public String receCmd2; //s 	 成功
	public String receCmd3; //s 	  错误信息 + 错误记录格式
	public String receCmd5; //s 	  错误记录格式
	public String receCmd6=SEND_TEXT; //s 	  服务端接收图片完成

	//注意：FILE_DATA 和  TEXT_DATA 为协议约定字符串，不得随意修改.
	public static final String SEND_FILE="FILE_DATA";
	public static final String SEND_TEXT="TEXT_DATA";
	public static final String SEND_END="VCANS_SEND_END";
}
