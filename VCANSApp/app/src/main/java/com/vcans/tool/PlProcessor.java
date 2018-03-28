package com.vcans.tool;

import java.util.Vector;

import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.ProcessorImplementor;
import com.vcans.model.MyProtocol;
import com.vcans.model.Send_Data;

import android.app.Activity;
import android.os.Handler;

/***
 * 上传下载 处理基类*/
public abstract class PlProcessor {

	public static String G_CUSCODE="";

	public static BaseActivity mActParent=null;

	// 使用的理由：用于分批发送比较方便
	protected DataTrunsfer mDataTrunsfer=null;

	//部分成功 内容中无错误提示信息 只含错误数据ID
	public final static int PART_NO_ERROR_MSG=0;

	//部分成功 内容中有错误提示信息 并含错误数据ID
	public final static int PART_HAVE_ERROR_MSG=1;

	//部分成功返回信息标志
	public int mPartProcessFlag=PART_NO_ERROR_MSG;

	public PlProcessor()
	{

	}

	public static void SetParent(BaseActivity a)
	{
		mActParent=a;
	}

	public void SetDataTrunsfer(DataTrunsfer dt)
	{
		mDataTrunsfer=dt;
	}

	protected ProcessorImplementor mImplementor=null;
	//public abstract Vector<Vector<Send_Data> > GetSendDataV2(String[] extrData);

	/**
	 * 获取发送到服务端的数据
	 * @param extrData //外部分参数
	 * @return
	 */
	public abstract Vector<Vector<String> > GetSendData(String[] extrData);
	/**
	 * 获得协议对像
	 * @return
	 */
	public abstract MyProtocol GetProtocol();

	/**
	 * 接文本数据成功的处理
	 */
	 public abstract void ReceTxtSuccess();

	/**
	 * 接图片数据成功的处理
	 */
	public abstract void ReceImageSuccess();

	/**
	 * 接总分数据成功的处理
	 */
	public abstract void RecePartSuccess();

//	/**
//	 * 处理失败
//	 */
//	public abstract void RecePartdefeated();
	//处理 接收部分成功，含错误信息
	//public abstract void RecePartSuccessOfErr();
}
