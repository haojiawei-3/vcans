package com.vcans.Processor;

import java.io.File;
import java.util.Vector;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.Vcan.activity.R;
import com.vcans.dao.XYRegisterDao;
import com.vcans.model.MyProtocol;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.DataTrunsfer;
import com.vcans.tool.PlProcessor;
import com.vcans.tool.ProtocolCMD;

/**
 * 上传数据处理者
 * @author vcans
 *
 */
public abstract class UploadProcessor extends PlProcessor
{
	public static final int ALL_SUCCESS=0;
	public static final int PART_SUCCESS=1;
	private String mFilePath="";
	private int m_nSendFlag=0;
	private int mIndex=0;//表示存放发送数据的容器索引，为0时也表示数据是刚开始发送
	private int mDataCount=0;
	//用于存储从数据库中获取的将要发送的全部数据
	private Vector<Vector<String> > mVctSendData=new Vector<Vector<String> >();
	//用于按批发送时存储的发送的数据
	Vector<Vector<String> > vctPartRecords=new Vector<Vector<String> >();
	private Vector<String> mVctDataId=new Vector<String>();
	private String mErrMsg;
	private String mErrDataIds="";//用于保存发送错误的数据ID，待发送完毕后显示，这些错误Id
	private String Error="";//用于保存发送错误的数据ID，待发送完毕后显示，这些错误Id
	private boolean mbSendEndNotify=false;
	public void setSendEndNotify(boolean bSendEndNotify)
	{
		mbSendEndNotify=bSendEndNotify;
	}

	public UploadProcessor()
	{
		mIndex=0;
	}

	@Override
	public void ReceTxtSuccess()
	{

		Log.e("TAG","ReceTxtSuccess开始");
		if(m_nSendFlag==DataTrunsfer.SEND_DATA||m_nSendFlag==DataTrunsfer.SEND_FILE_DATA){//接收发送数据成功
			resolveOkIds(vctPartRecords,null);
			ProcessData(mVctDataId);

			if(mVctDataId.size()>0)
				ActivityHelper.showProgressDialog(PlProcessor.mActParent,mDataCount,mVctDataId.size());

			if(!ContinueSendData())
			{//表示发送完毕

				if(mbSendEndNotify)
				{
					this.SendEndNotify(Error,mErrDataIds);
					Error="";
					mErrDataIds="";
					ActivityHelper.closeStatusDialog();  /////////////////////////////////////////////////////////////////////////
				}
				else
				{
					if(!mErrDataIds.equals("")){
						ActivityHelper.ShowErrMsg(PlProcessor.mActParent,mErrMsg+"\r\n"+mActParent.getString(R.string.partUploadError)+"\r\n"+mErrDataIds+"111");
						//Log.e("TAG", mErrMsg+"0");
						this.SendEndNotify(Error,mErrDataIds);
						ActivityHelper.closeStatusDialog();
					}else
					{
						ActivityHelper.showDialog(PlProcessor.mActParent,"",mActParent.getString(R.string.uploadSuccess));
						ActivityHelper.globalSysParam.bAutoCreateId=true;
						ActivityHelper.closeStatusDialog();
					}
				}

				ActivityHelper.closeStatusDialog();
			}
		}
		else
		{//接收开始命令成功

			if(m_nSendFlag==DataTrunsfer.SEND_BEGIN_NOTIFY)
			{//开始发送文本数据

				m_nSendFlag=DataTrunsfer.SEND_DATA;
				SendText(null);
			}
			else
			{//开始发送文件数据

				m_nSendFlag=DataTrunsfer.SEND_FILE_DATA;
				SendFile();
			}
		}
	}


	@Override
	public  void RecePartSuccess()
	{
		Vector<Vector<String> > vctReceData=mDataTrunsfer.GetReceiveData();
		Log.e("TAG", vctReceData+"000000");
		Vector<String> vctErrIds=resolveErrorIds(vctReceData);
		mErrMsg=resolveErrors(vctReceData);
		Error+=mErrMsg+"\r\n";
		Log.e("TAG", vctErrIds+"111111111");
		resolveOkIds(vctPartRecords,vctErrIds);
		ProcessData(mVctDataId);

		String  errRecordId=ConvertStringIds(vctErrIds);
		mErrDataIds+=errRecordId;

		if(mVctDataId.size()>0){
			ActivityHelper.showProgressDialog(PlProcessor.mActParent,mDataCount,mVctDataId.size());
		}

		if(!ContinueSendData())
		{//表示发送完毕
			Log.e("TAG","接总分数据成功的处理ContinueSendData方法执行");
			if(mbSendEndNotify)
			{

				if(!mErrDataIds.equals("")){
					ActivityHelper.ShowErrMsg(PlProcessor.mActParent,Error+"\r\n"+mActParent.getString(R.string.partUploadError)+"\r\n"+mErrDataIds+"222");
					//Log.e("TAG", mErrMsg+"错误信息");
					this.SendEndNotify(Error,mErrDataIds);
					Error="";
				}else
				{
					ActivityHelper.showDialog(PlProcessor.mActParent,"",mActParent.getString(R.string.uploadSuccess));
					ActivityHelper.globalSysParam.bAutoCreateId=true;
					//ActivityHelper.backFirstActivity();
					ActivityHelper.closeStatusDialog();
				}

			}
			else
				//ActivityHelper.ShowErrMsg(PlProcessor.mActParent,mErrMsg+"\r\n"+R.string.sendErrorId+"\r\n"+mErrDataIds);
				ActivityHelper.ShowErrMsg(PlProcessor.mActParent,Error+"\r\n"+mActParent.getString(R.string.partUploadError)+"\r\n"+mErrDataIds);
			ActivityHelper.closeStatusDialog();
		}
	}

	@Override
	public void ReceImageSuccess()
	{

	}

//	@Override
//	public void RecePartdefeated() {
//		Vector<Vector<String> > vctReceData=mDataTrunsfer.GetReceiveData();
//		//ProcessErrorData();
//	}

	private boolean ContinueSendData()
	{
		int actionFlag=0;

		if(m_nSendFlag==DataTrunsfer.SEND_FILE_DATA)
		{
			actionFlag=DataTrunsfer.SEND_FILE_BEGIN_NOTIFY;

		}
		else
		{
			actionFlag=DataTrunsfer.SEND_BEGIN_NOTIFY;

		}

		if(mIndex<mVctSendData.size())
		{
			SendBeginCMD(actionFlag);
			return true;
		}


		//	ActivityHelper.closeStatusDialog();   ////////////////////////////////////////////////////////////////////////
		//返回false表示完成

		return false;
	}

	/**
	 * 解析返回的错误信息
	 * @param vctReceData
	 * @return
	 */
	private String resolveErrors(Vector<Vector<String> > vctReceData)
	{
		int i=0;
		//mErrMsg1+=mErrMsg;
		Vector<String> vctErrIds=new Vector<String>();
		for(Vector<String> vctChild : vctReceData)
		{
			if(mPartProcessFlag==PlProcessor.PART_HAVE_ERROR_MSG&&i==0)
			{//过滤错误信息  接收到错误数据格式 如: [发送错误信息 ,1,2]
				if(i==0)
				{//把文字过滤掉
					mErrMsg=vctChild.get(0);
					System.out.println(mErrMsg+" 解析返回的错误信息");
					i++;
					continue;
				}
			}
		}

		return mErrMsg;
	}
	/**
	 * 解析返回的错误ID
	 * @param vctReceData
	 * @return
	 */
	protected Vector<String> resolveErrorIds(Vector<Vector<String> > vctReceData)
	{
		int i=0;
		mErrMsg="";
		Vector<String> vctErrIds=new Vector<String>();
		for(Vector<String> vctChild : vctReceData)
		{
			if(mPartProcessFlag==PlProcessor.PART_HAVE_ERROR_MSG&&i==0)
			{//过滤错误信息  接收到错误数据格式 如: [发送错误信息 ,1,2]
				if(i==0)
				{//把文字过滤掉
					mErrMsg=vctChild.get(0);
					System.out.println(mErrMsg+" 解析返回的错误ID00000000");
					i++;
					continue;
				}
			}

			for(String strId :vctChild)
			{
				vctErrIds.add(strId);
				System.out.println(vctErrIds+" 解析返回的错误ID");
			}
		}

		return vctErrIds;
	}

	/**
	 * 解析发送成功的数据Id
	 * @param vctSendData
	 * @param
	 */
	private void resolveOkIds(Vector<Vector<String> > vctSendData,Vector<String> vctErrIds)
	{
		String strDataId;
		mVctDataId.clear();
		for(Vector<String> vctChild : vctSendData)
		{
			strDataId=vctChild.get(0);


			if(vctErrIds!=null)
			{
				if(!vctErrIds.contains(strDataId))
				{
					mVctDataId.add(strDataId);
					System.out.println(mVctDataId+" 解析返回成功的ID1");
				}
			}
			else
			{
				mVctDataId.add(strDataId);
				System.out.println(mVctDataId+" 解析返回成功的ID");
			}
		}
	}


	/**
	 * 服务端返回成功时的处理
	 */
	public abstract int ProcessData(Vector<String> vctDataId);

	//public abstract int ProcessErrorData(Vector<String> vctDataId);


	private void SendText(String recordId)
	{
		if(m_nSendFlag==DataTrunsfer.SEND_DATA)
		{
			if(mIndex==0)
			{
				if(recordId==null){
					mVctSendData=GetSendData(null);
					Log.e("TAG", mVctSendData+"2");
				}else
					mVctSendData=GetSendData(new String[]{recordId});
				Log.e("TAG", mVctSendData+"3");

				mDataCount=mVctSendData.size();
			}

			if(mDataCount>=ProtocolCMD.MAX_RECORD_COUNT)
				resolvePartData();//该方法会提取本次要发送数据放到vctPartRecords
			else
			{
				vctPartRecords=mVctSendData;
				mIndex=mDataCount;
			}
		}

		int nRst=0;
		if(mDataTrunsfer!=null)
			nRst=mDataTrunsfer.SendData(vctPartRecords,m_nSendFlag);///////


		if(nRst!=1)
		{
			ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.sendFailOrDisconnect));
		}
	}

	private void resolvePartData()
	{
		vctPartRecords.clear();

		for(int i=0;i<ProtocolCMD.RECORD_COUNT;++i)
		{
			if(mIndex<mVctSendData.size())
			{
				vctPartRecords.add(mVctSendData.get(mIndex++));
			}
			else
			{
				break;
			}
		}
	}

	private void SendFile()
	{
		if(mIndex==0)
		{
			mVctSendData=GetSendData(null);
			mDataCount=mVctSendData.size();

			ActivityHelper.showProgressDialog(PlProcessor.mActParent,mDataCount,0);
		}

		vctPartRecords.clear();
		Vector<String> vctRecord=mVctSendData.get(mIndex++);
		vctPartRecords.add(vctRecord);



		int nRst=0;

		if(mDataTrunsfer!=null)
			nRst=mDataTrunsfer.SendFile(vctRecord);

		if(nRst!=1)
		{
			ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.sendFailOrDisconnect));
		}
	}

	public  void SendBeginUpload()
	{
		mIndex=0;
		mErrDataIds="";
		SendBeginCMD(DataTrunsfer.SEND_BEGIN_NOTIFY);
	}

	public  void SendFileBeginUpload()
	{
		mIndex=0;
		mErrDataIds="";
		SendBeginCMD(DataTrunsfer.SEND_FILE_BEGIN_NOTIFY);
	}
	//文件模式上传完成
	public  void SendEndNotify(String ErrId,String ErrMsg)
	{
		SendParam sendParam=new SendParam();
		sendParam.parent=mActParent;
		sendParam.tip=mActParent.getString(R.string.waitReponse);
		sendParam.processor=new YPDownSendEndProcessor();
		sendParam.szData=new String[]{ErrId,ErrMsg};
		mDataTrunsfer.request(sendParam);
	}

	private  void SendBeginCMD(int cmdFlag)
	{
		m_nSendFlag=cmdFlag;
		//Log.e("TAG", m_nSendFlag+"5");
		SendText(null);
	}

	public void DeleteFile()
	{
		File file=new File(mFilePath);

		if(file.exists())
		{
			file.delete();
		}
	}

	public String ConvertStringIds(Vector<String> vctErrId)
	{
		String errRecordId="";

		for(String str :vctErrId)
		{
			if(errRecordId.equals(""))
				errRecordId="'"+str+"'";
			else
				errRecordId+=",'"+str+"'";
		}

		return errRecordId;
	}

	public void backFirstActivity()
	{
		new Handler().postDelayed(new Runnable() {
			public void run() {
				ActivityHelper.backFirstActivity1();
			}
		}, 600);
	}


}
