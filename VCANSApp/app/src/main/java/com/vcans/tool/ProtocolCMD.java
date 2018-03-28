package com.vcans.tool;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.vcans.model.Received_Data;
import com.vcans.model.Send_Data;

public class ProtocolCMD {
	public static final char m_vfxChSeparator = 0x7F; // 字段分隔符
	public static final char m_vfxChSeparatorRecord = 0x7E; // 记录分隔符
	public static final int m_vfxICmdLength = 15; // 协议命令标志长度
	public static final int m_vfxIGUIDPlusLength = 54; // GUIDPLUS标志长度
	public static final int m_vfxIDataPos = 15 + 15 + 54; // 字段信息开始位置

	public static final String m_vfxStrProBegin = "VCANSBEGINXXXXX"; // A - 协议开始
	public static final String m_vfxStrProEnd   = "VCANSENDXXXXXXX"; // A - 协议结束

	public static final String m_vfxImageBegin  = "VCANSIMAGEBEGIN";  // - 图片开始
	public static final String m_vfxImageEnd    = "VCANSIMAGEENDXX";  // - 图片结束

	public static final String conStr = "d28d2fe3-71a5-4c8e-9e73-78e938c74da7634438374440000000";
	public static final int RECORD_COUNT = 30; // 分批发送时，每次的记录数据
	public static final int MAX_RECORD_COUNT = 500; // 一次最大发送的记录数
	public static final String FILE_FIELD_FLAG="FILE//";//表示文件字段


	private String mStrCmd;
	int mImgId=0;

	Received_Data mReceData=new Received_Data();
	private ByteArrayOutputStream mByteArray = new ByteArrayOutputStream();
	private Vector<Vector<String> > mVctReceData = null;
	HashMap<String,Vector<Vector<String> > > mapCmdAndRecords=new HashMap<String,Vector<Vector<String> > >();
	List<Received_Data> receiveDataList=new ArrayList<Received_Data>();


	/**
	 * 得到文字的数据集  mVctReceData */
	public Vector<Vector<String>> GetReceData() {
		return mVctReceData;
	}


	public ProtocolCMD() {
		mVctReceData = new Vector<Vector<String>>();
	}



	/**
	 * 按协议解析文件
	 * @param byteRece
	 * @return
	 */
	public List<Received_Data> ResolveReceiveFileV2(byte[] byteRece) {

		if(byteRece==null)
			return null;


		try {

			byte[] szTotalData=byteRece;

			int nBeginIndex=myIndexOf(szTotalData,m_vfxStrProBegin);
			int nEndIndex=myIndexOf(szTotalData,m_vfxStrProEnd);

			int nTotalDataLen=szTotalData.length;
			byte[] szMyData=null;
			String strTxtData="";
			//ByteArrayOutputStream fileBAO = new ByteArrayOutputStream();
			for(Received_Data receData:receiveDataList)receData.imgByteList.clear();
			receiveDataList.clear();
			mImgId=0;
			while(nBeginIndex>=0&&nEndIndex>=0)
			{
				String strCmd=new String(szTotalData,nBeginIndex+m_vfxICmdLength, m_vfxICmdLength,SocketHelper.CHAR_SET);
				//String strGuid=new String(szTotalData,nBeginIndex+m_vfxICmdLength*2,m_vfxIGUIDPlusLength,SocketHelper.CHAR_SET);
				int nDataStartIndex=nBeginIndex+(m_vfxICmdLength*2)+m_vfxIGUIDPlusLength;
				if(nDataStartIndex<nEndIndex)
				{
					szMyData=Arrays.copyOfRange(szTotalData,nDataStartIndex,nEndIndex);
				}
				else
				{
					szMyData=null;//new byte[0];
				}


				if(DataTrunsfer.ENABLED_DES_ZIP)
				{
					if(szMyData!=null&&szMyData.length>0)
						szMyData=DESTool.decrypto(szMyData);
				}

				Received_Data receData=new Received_Data();
				strTxtData=ResolveImage(szMyData,receData,strCmd);	//解析图片
				receData.receText=strTxtData;

				receiveDataList.add(receData);

				int leftDataStartIndex=nEndIndex+m_vfxICmdLength;
				if(leftDataStartIndex<nTotalDataLen)
				{
					szTotalData=Arrays.copyOfRange(szTotalData, leftDataStartIndex,nTotalDataLen);
				}
				else
					szTotalData=null;

				if(szTotalData!=null&&szTotalData.length>0)
				{
					nTotalDataLen=szTotalData.length;

					nBeginIndex=myIndexOf(szTotalData,m_vfxStrProBegin);
					nEndIndex=myIndexOf(szTotalData,m_vfxStrProEnd);
				}
				else
				{
					break;
				}
			}

			//fileBAO.close();

			if(DataTrunsfer.getSocketHelper()!=null)
				DataTrunsfer.getSocketHelper().InitReceByteArray(szTotalData);


		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return receiveDataList;
	}

	/**
	 * 解析并提取图片数据
	 * @param myData
	 * @param receData
	 * @param strCmd
	 * @return
	 * @throws IOException
	 */
	public String ResolveImage(byte[] myData,Received_Data receData,String strCmd) throws IOException
	{
		String strTextData="";
		try{

			// ByteArrayOutputStream fileBAO = new ByteArrayOutputStream();

			byte[] myDataTemp=myData;
			int nImgIndexBegin=myIndexOf(myDataTemp,m_vfxImageBegin);
			int nImgIndexEnd=myIndexOf(myDataTemp,m_vfxImageEnd);

			byte[] szImg=null;

			while(nImgIndexBegin>=0&&nImgIndexEnd>=0)
			{
				szImg=null;

				//提取数据数据
				int imageStartIndex=nImgIndexBegin+m_vfxICmdLength;
				if(imageStartIndex<nImgIndexEnd)
				{
					szImg=Arrays.copyOfRange(myDataTemp,imageStartIndex, nImgIndexEnd);
				}
				receData.imgByteList.add(szImg);

				//截取图片开始命令之前的数据
				strTextData+=new String(myDataTemp,0,nImgIndexBegin,SocketHelper.CHAR_SET);
				strTextData+=mImgId++;

				//截取图片结束命令之后的数据
				int imgBehindLen=nImgIndexEnd+m_vfxICmdLength;
				if(imgBehindLen<myDataTemp.length)
				{
					myDataTemp=Arrays.copyOfRange(myDataTemp,imgBehindLen, myDataTemp.length);
				}
				else
				{
					myDataTemp=null;
					break;
				}

				nImgIndexBegin=myIndexOf(myDataTemp,m_vfxImageBegin);
				nImgIndexEnd=myIndexOf(myDataTemp,m_vfxImageEnd);
			}

			String imgBehindStr="";
			if(myDataTemp!=null&&myDataTemp.length>0)
			{
				imgBehindStr=new String(myDataTemp,0,myDataTemp.length,SocketHelper.CHAR_SET);
				int lastIndex=imgBehindStr.lastIndexOf(m_vfxChSeparatorRecord+"");
				if(lastIndex>-1)
					imgBehindStr=imgBehindStr.substring(0, lastIndex+1);
			}

			strTextData=m_vfxStrProBegin+strCmd+conStr+strTextData+imgBehindStr+m_vfxStrProEnd;//strDataTemp 此处为最后面的不含图片的数据
		}catch(Exception e)
		{
			e.getMessage();
		}

		return  strTextData;
	}

	/**
	 * 从 szSource中查找 strDest所在起始位置
	 * @param szSource
	 * @param strDest
	 * @return
	 */
	public int myIndexOf(byte[] szSource,String strDest)
	{
		if(strDest.equals("")) return -1;
		byte[] szDest=null;
		try {
			szDest=strDest.getBytes(SocketHelper.CHAR_SET);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int  pos=-1;
		boolean success=false;

		if(szSource==null) return pos;

		for(int i=0;i<szSource.length;i++)
		{
			if(szSource[i]==szDest[0])
			{
				for(int j=1;j<szDest.length;j++)
				{
					if(i+j<szSource.length)
					{
						if(szSource[i+j]==szDest[j])
						{
							success=true;
						}
						else
						{
							success=false;
							break;
						}
					}
					else
					{
						return -1;
					}
				}// end for(j)

				if(success)
				{
					pos=i;
					break;
				}
			}
		}

		return pos;
	}

	/**
	 * 从startIndex开始  从 szSource中查找 strDest所在起始位置 暂无用
	 * @param szSource
	 * @param startIndex
	 * @param endIndex
	 * @param strDest
	 * @return
	 */
	public int myIndexOf(byte[] szSource,int startIndex,int endIndex,String strDest)
	{
		if(strDest.equals("")) return -1;
		byte[] szDest=null;
		try {
			szDest=strDest.getBytes(SocketHelper.CHAR_SET);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int  pos=-1;
		boolean success=false;

		for(int i=startIndex;i<=endIndex;i++)
		{
			if(szSource[i]==szDest[0])
			{
				for(int j=1;j<szDest.length;j++)
				{
					success=true;
					if(i+j<szSource.length)
					{
						if(szSource[i+j]==szDest[j])
						{

						}
						else
						{
							success=false;
							break;
						}
					}
					else
					{
						return -1;
					}
				}// end for(j)

				if(success)
				{
					pos=i;
				}
			}
		}

		return pos;
	}



	/**
	 * 按协议格式化，发送文件
	 * @param strCmd
	 * @param vctRecord
	 * @return
	 */
	public byte[] FormatSendFileV3(String strCmd, Vector<String> vctRecord) {

		if (vctRecord.size()<1)
			return null;


		FileInputStream fileIn = null;
		byte[] sendByte=null;

		try {

			mByteArray.flush();
			mByteArray.reset();

			/***准备数据*****/

			ByteArrayOutputStream dataByteArray=new ByteArrayOutputStream();

			String strField="";
			for (int i = 0; i < vctRecord.size(); ++i) {

				strField = vctRecord.get(i);

				if(strField.indexOf(FILE_FIELD_FLAG)<0)
				{
					dataByteArray.write(strField.getBytes(SocketHelper.CHAR_SET));
					//字段分隔
					dataByteArray.write((m_vfxChSeparator+"").getBytes(SocketHelper.CHAR_SET));
				}
				else
				{//读、写文件
					if(strField.equals(FILE_FIELD_FLAG)||strField.equals(FILE_FIELD_FLAG+";"))
					{//
						dataByteArray.write(m_vfxImageBegin.getBytes(SocketHelper.CHAR_SET));
						dataByteArray.write(m_vfxImageEnd.getBytes(SocketHelper.CHAR_SET));
						dataByteArray.write((m_vfxChSeparator+"").getBytes(SocketHelper.CHAR_SET));
					}
					else
					{
						String[] szFilePath=ActivityHelper.mySplit(strField.substring(FILE_FIELD_FLAG.length(),strField.length()), ";");
						for(int j=0;j<szFilePath.length;++j)
						{
							dataByteArray.write(m_vfxImageBegin.getBytes(SocketHelper.CHAR_SET));

							if(!szFilePath[j].equals(""))
							{
								//压缩图片
								File file=new File(szFilePath[j]);

								if(file.exists())
								{
									int fileSizkKb=(int)(file.length()/1024);

									BitmapFactory.Options options=new BitmapFactory.Options();
									options.inPurgeable = true;

									if(fileSizkKb>=ActivityHelper.imageReduceMinSize) //
									{
										options.inSampleSize = ActivityHelper.imageReduceRate;
									}
									else
									{
										options.inSampleSize = 1;
									}

									Bitmap bitmap=BitmapFactory.decodeFile(szFilePath[j],options);

									ByteArrayOutputStream out = new ByteArrayOutputStream();
									bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
									byte[] imgBuf=out.toByteArray();
									out.flush();
									out.close();
									ActivityHelper.recycleBitmaps(new Bitmap[]{bitmap});


									dataByteArray.write(imgBuf,0,imgBuf.length);

							         /*
								         * 按原图
										//读写文件
										fileIn=new FileInputStream(szFilePath[j]);
										int readLen=0;
										byte[]readBuf=new byte[1024*100];

										do {
											  readLen=fileIn.read(readBuf,0,readBuf.length);

											  if(readLen>0)
												  dataByteArray.write(readBuf,0,readLen);
											  else break;

										 } while(true);

										fileIn.close();
										*/
								}
							}

							dataByteArray.write(m_vfxImageEnd.getBytes(SocketHelper.CHAR_SET));

							dataByteArray.write((m_vfxChSeparator+"").getBytes(SocketHelper.CHAR_SET));

						}//end for(j)
					}
				}
			}//end for i

			//记录分隔
			dataByteArray.write((m_vfxChSeparatorRecord+"").getBytes(SocketHelper.CHAR_SET));
			/*END **准备数据*****/

			// 开始命令
			mByteArray.write(m_vfxStrProBegin.getBytes(SocketHelper.CHAR_SET));
			// 数据命令
			mByteArray.write(strCmd.getBytes(SocketHelper.CHAR_SET));
			// GUID
			mByteArray.write(conStr.getBytes(SocketHelper.CHAR_SET));
			//数据
			if(DataTrunsfer.ENABLED_DES_ZIP)
				mByteArray.write(DESTool.encrypto(dataByteArray.toByteArray()));
			else
				mByteArray.write(dataByteArray.toByteArray());

			// 结束命令
			mByteArray.write(m_vfxStrProEnd.getBytes(SocketHelper.CHAR_SET));

			dataByteArray.flush();
			dataByteArray.close();

			sendByte=mByteArray.toByteArray();
			mByteArray.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileIn != null)
				try {
					fileIn.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return sendByte;
	}



	/**
	 * 格式化并发送文本数据
	 * @param strCmd
	 * @param vctSendData
	 * @return
	 */
	public byte[] FormatSendData(String strCmd,Vector<Vector<String>> vctSendData) {
		String strFormatData = "";

		if(vctSendData!=null)
		{
			for (int i = 0; i < vctSendData.size(); i++) {
				for (int j = 0; j < vctSendData.get(i).size(); ++j) {
					strFormatData += vctSendData.get(i).get(j) + m_vfxChSeparator;
				}

				strFormatData += m_vfxChSeparatorRecord;
			}
		}


		byte[] dataByte=null;

		try {

			mByteArray.reset();

			if(DataTrunsfer.ENABLED_DES_ZIP)
				dataByte=DESTool.encrypto(strFormatData.getBytes(SocketHelper.CHAR_SET));
			else
				dataByte=strFormatData.getBytes(SocketHelper.CHAR_SET);

			mByteArray.write((m_vfxStrProBegin + strCmd + conStr).getBytes(SocketHelper.CHAR_SET));
			mByteArray.write(dataByte);
			mByteArray.write(m_vfxStrProEnd.getBytes(SocketHelper.CHAR_SET));

			dataByte=mByteArray.toByteArray();

			mByteArray.flush();
			mByteArray.close();

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return dataByte;
	}












	/**
	 * 解析单帧文本数据                       mVctReceData
	 * @param strReceData
	 * @returnC:\Users\Administrator\Desktop\WebPrj
	 */
	public String ResolveReceiveData(String strReceData) {
		if (strReceData == null || strReceData == "")
			return "";


		int nBeginFrame=strReceData.indexOf(m_vfxStrProBegin);
		int nEndFrame=strReceData.indexOf(m_vfxStrProEnd);

		if(nBeginFrame<0||nEndFrame<0){
			return "";
		}

		String strReceive = strReceData.substring(nBeginFrame,
				nEndFrame+m_vfxStrProEnd.length());

		//String strReceive = strReceData;//.substring(strReceData.indexOf(m_vfxStrProBegin),//strReceData.indexOf(m_vfxStrProEnd)+m_vfxStrProBegin.length());
		mStrCmd = strReceive.substring(m_vfxStrProBegin.length(),m_vfxStrProBegin.length() + m_vfxICmdLength);

		int nStart = m_vfxICmdLength * 2 + m_vfxIGUIDPlusLength;

		int nEnd = strReceData.indexOf(m_vfxStrProEnd) - m_vfxICmdLength * 2- m_vfxIGUIDPlusLength;
		strReceData = strReceive.substring(nStart, nStart + nEnd);

		// 示例数据VCANSBEGINXXXXXV4BDPHBCCRZXRE0d28d2fe3-71a5-4c8e-9e73-78e938c74da7634438374440000000
		// 公司订单号GX15094GX15094~
		// 工厂GX094浙江东方华强纺织印染有限公司~
		// 花型颜色1#~
		// 花型颜色1#~
		// VCANSENDXXXXXXX
		mVctReceData.clear();
		//String[] szRecords = strReceData.split("" + m_vfxChSeparatorRecord);
		String[] szRecords=ActivityHelper.mySplit(strReceData, "" + m_vfxChSeparatorRecord);
		for (int i = 0; i < szRecords.length; ++i) {
			Vector<String> vctFields = new Vector<String>();

			String strRecord = szRecords[i].trim();
			//strRecord.split("" + m_vfxChSeparator); 内置函数有问题
			String[] szFields =ActivityHelper.mySplit(strRecord, "" + m_vfxChSeparator);

			for (String strField : szFields)
				vctFields.add(strField);

			if(vctFields.size()>0)
				mVctReceData.add(vctFields);
		}

		return mStrCmd;
	}

	/**
	 * 解析多帧文本数据  备用
	 * @param strReceData
	 * @return
	 */
	public HashMap<String,Vector<Vector<String> > > ResolveMultiFrameData(String strReceData) {

		mapCmdAndRecords.clear();

		if (strReceData == null || strReceData == "")
			return mapCmdAndRecords;


		int nBeginFrame=0;
		int nEndFrame=0;



		while(true)
		{
			nBeginFrame=strReceData.indexOf(m_vfxStrProBegin);
			nEndFrame=strReceData.indexOf(m_vfxStrProEnd);

			if(nBeginFrame>-1&&nEndFrame>-1)
			{}
			else
			{
				break;
			}


			String strReceive = strReceData.substring(nBeginFrame,nEndFrame+m_vfxStrProEnd.length());
			mStrCmd = ResolveReceiveData(strReceive);

			strReceData=strReceData.substring(nEndFrame+m_vfxStrProEnd.length());

			mapCmdAndRecords.put(mStrCmd, (Vector<Vector<String> >)mVctReceData.clone());

		}

		return mapCmdAndRecords;
	}
}