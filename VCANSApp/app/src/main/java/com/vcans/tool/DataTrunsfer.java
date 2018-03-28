package com.vcans.tool;

import java.util.List;
import java.util.Vector;
import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DownloadProcessor;
import com.vcans.Processor.HandshakeIsEncryptoDown;
import com.vcans.Processor.UploadProcessor;
import com.vcans.model.MyProtocol;
import com.vcans.model.Received_Data;
import com.vcans.model.SendParam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class DataTrunsfer {
	public static final int RECEVIE_SUCCESS_FLAG = 10;
	public static final int OK_FLAG = 11;
	public static final int ERROR_FLAG = 12;
	public static final int MSG_BUSY_FLAG = 13;
	public static final String CANCEL_SERVER_RESPONSE = "cancel";

	public static final int SEND_BEGIN_NOTIFY = 0;
	public static final int SEND_DATA = 1;
	public static final int SEND_FILE_DATA = 2;
	public static final int SEND_FILE_BEGIN_NOTIFY = 3;
	public static final int SEND_ENABLED_FLAG = 4;
	public static final int SEND_END_NOTIFY = 5;
	public static final int DOWNLOAD_TITLE = 1001;

	//是否为加密
	public static boolean ENABLED_DES_ZIP = true;
	public  static boolean isDownloadContinue = false;

	public  static boolean isDownloadContinue() {
		return isDownloadContinue;
	}

	public void setDownloadContinue(boolean isDownloadContinue) {
		this.isDownloadContinue = isDownloadContinue;
	}

	private boolean bEnabledDESTemp;
	private boolean bSocketClose = true;
	/**
	 * 是否为开始上传数据标志 上传数据过程含过两命令开始上传预备命令和上传命令，为一个原子命令，
	 * 根据设计，预备命令结束后，不应算为该组命令结束，仍不允许下一个其它发送请求命令 因此设置些标志来实现
	 */
	private boolean bSendBeginRequest = false;
	private ProtocolCMD mProtocolCmd;
	private boolean bSendHandShake = false;
	private static SocketHelper mSokcetHelper;

	public static void setmSokcetHelper(SocketHelper mSokcetHelper) {
		DataTrunsfer.mSokcetHelper = mSokcetHelper;
	}

	public Handler mClientHandler;
	private byte[] mFileBuf = null;
	List<byte[]> mFileByteList = null;
	/*
     * 得到图片的数据集*/
	public List<byte[]> getFileByteList() {
		return mFileByteList;
	}

	private String mStrCmd = "";
	private String mReceText;

	// 用于存储开始命令数据，避免影响批量发送时的待发送数据
	Vector<Vector<String>> vctBeginCmdRecords = new Vector<Vector<String>>();
	Vector<String> vctBeginOneRecord = new Vector<String>();
	private MyProtocol mP;
	PlProcessor mProcessor;
	String mStrIp;
	int mNPort = 0;

	// 是否允许发送请求 当安全请求通过或服务器已连接才允许发送
	boolean bSendEnabled = true;

	public boolean isbSendEnabled() {
		synchronized (lock2) {
			return bSendEnabled;
		}
	}

	public void setSendEnabled(boolean enabled) {
		synchronized (lock2) {
			bSendEnabled = enabled;
		}
	}

	int handshakeCount = 0;
	private boolean bEnabledQuest = true;// 是否已允许发送请求 当请求未结束时不允许下一个请求

	public boolean isEnabledQuest() {
		synchronized (lock1) {
			return bEnabledQuest;
		}
	}

	public void setSocketClose(boolean isClose) {
		synchronized (lock3) {
			bSocketClose = isClose;
		}
	}

	public boolean isSocketClose() {
		synchronized (lock3) {
			return bSocketClose;
		}
	}

	public final static Object lock1 = new Object();
	public final static Object lock2 = new Object();
	public final static Object lock3 = new Object();
	public static boolean socketFreeDisconnect = false;

	public  boolean isSocketFreeDisconnect() {
		return socketFreeDisconnect;
	}

	DownloadProcessor mHandshake = new HandshakeIsEncryptoDown();

	public DataTrunsfer() {
		mProtocolCmd = new ProtocolCMD();
		handshakeCount = 0;
	}

	public static SocketHelper getSocketHelper() {
		return mSokcetHelper;
	}

	private void SendMsg(String strMsg, int Flag) {
		Bundle bundle = new Bundle();
		bundle.putString("msg", strMsg);
		Message msg = new Message();
		msg.what = Flag;
		;
		msg.setData(bundle);

		if (mClientHandler != null)
			mClientHandler.sendMessage(msg);
	}

	private void SetProcessor(PlProcessor proce) {
		mProcessor = proce;
		mP = mProcessor.GetProtocol();
		mProcessor.SetDataTrunsfer(DataTrunsfer.this);
	}
	/**
	 * 用于判断是否连接
	 * @param sendParam
	 */
	public void connect(SendParam sendParam) {
		if (socketFreeDisconnect) {
			ActivityHelper.showDialog(sendParam.parent, "", sendParam.parent.getString(R.string.freeDisconnect));
			return;
		}

	}
	/**
	 * 用于查询与下载
	 * @param sendParam
	 */
	public void request(SendParam sendParam) {
		if (socketFreeDisconnect) {
			ActivityHelper.showDialog(sendParam.parent, "", sendParam.parent.getString(R.string.freeDisconnect));
			return;
		}
		Log.e("hjw","查询++++数据下载线程启动");
		isDownloadContinue = false;
		new ThreadRequest(sendParam, DataTrunsfer.SEND_DATA).start();   //1
	}

	/**
	 * 用于上传                   文本                 数据
	 * @param sendParam
	 */
	public void beginUploadText(SendParam sendParam) {
		if (socketFreeDisconnect) {
			ActivityHelper.showDialog(sendParam.parent, "", sendParam.parent.getString(R.string.freeDisconnect));
			return;
		}
		Log.e("hjw","文本++++数据上传线程启动");
		new ThreadRequest(sendParam, DataTrunsfer.SEND_BEGIN_NOTIFY).start();  //  0

	}

	/**
	 * 用于上传含                  文件             数据
	 * @param sendParam
	 */
	public void beginUploadFile(SendParam sendParam) {
		if (socketFreeDisconnect) {
			ActivityHelper.showDialog(sendParam.parent, "", sendParam.parent.getString(R.string.freeDisconnect));
			return;
		}
		Log.e("hjw","文件++++数据上传线程启动");
		new ThreadRequest(sendParam, DataTrunsfer.SEND_FILE_BEGIN_NOTIFY).start();   //3

	}



	/**
	 * 请求服务端响应线程
	 * @author vcans
	 *
	 */
	class ThreadRequest extends Thread {
		SendParam mParam;
		int mAction;

		ThreadRequest(SendParam param, int action) {
			mParam = param;
			mAction = action;
		}

		@Override
		public void run() {

			//发送与接收线程同步
			synchronized (lock1) {
				Log.e("HJW","发送数据线程启动");
				Message msg = new Message();
				msg.obj = mParam;
				msg.what = mAction;
				mRequestHandler.sendMessage(msg);
			}
		}

	};

	//处理 ThreadRequest的 请求
	public Handler mRequestHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			int mAction = msg.what;
			Log.e("hjw","Handler开始处理线程数据");
			if (mAction == DataTrunsfer.SEND_ENABLED_FLAG) {
						if (!mStrCmd.equals(CANCEL_SERVER_RESPONSE)) {
							processorCmd();

						}
						if (!bSendBeginRequest) {
							bEnabledQuest = true;
						} else{     // 处于必须恢复标志，上次命令结束后才能设置bSetEnabled为true
							bSendBeginRequest = false;
						}
						return ;
			} else {

				if (!bSendEnabled && !bSendHandShake) {
					ActivityHelper.showDialog(PlProcessor.mActParent, "",PlProcessor.mActParent.getString(R.string.freeDisconnect));
					return;
				}else {
					bSendHandShake = false;
				}

				SendParam mParam = (SendParam) msg.obj;
				String tip = mParam.parent.getString(R.string.waitReponse);             //等待服务端处理...
				if (bEnabledQuest) {
					bEnabledQuest = false;
									if (!mParam.tip.equals("")){
										tip = mParam.tip;
									}
					PlProcessor.mActParent = mParam.parent;

								if(mParam.bShowTipDlg){
									ActivityHelper.showStatusDialog(mParam.parent, tip);
								}
					SetProcessor(mParam.processor);
								if (mAction == DataTrunsfer.SEND_DATA){
									if (mParam.processor != null) {
										bSendBeginRequest = false;
										DownloadProcessor downProcessor = (DownloadProcessor) mParam.processor;
										downProcessor.SendInfo(mParam.szData);
									}
								} else if (mAction == DataTrunsfer.SEND_BEGIN_NOTIFY){
									bSendBeginRequest = true;
									UploadProcessor uploadProcessor = (UploadProcessor) mParam.processor;
									uploadProcessor.SendBeginUpload();
								} else if (mAction == DataTrunsfer.SEND_FILE_BEGIN_NOTIFY) {
									bSendBeginRequest = true;
									UploadProcessor uploadProcessor = (UploadProcessor) mParam.processor;
									uploadProcessor.setSendEndNotify(mParam.bSendEndNotify);
									uploadProcessor.SendFileBeginUpload();
								}
				} else {
//					new AlertDialog.Builder(mParam.parent).setTitle(mParam.parent.getString(R.string.busy))    //这里
//							.setIcon(android.R.drawable.ic_dialog_info)
//							.setPositiveButton(mParam.parent.getString(R.string.stop),
//									new DialogInterface.OnClickListener() {
//						public void onClick(DialogInterface dialog, int which) {
//							// 点击“确认”后的操作
//							// startProcessMsg(DataTrunsfer.CANCEL_SERVER_RESPONSE,"");
//							if (!bEnabledQuest) {
//								CloseSocketConnect();
//								new Handler().postDelayed(new Runnable() {
//									public void run() {
//										startThreadConnectServer();
//									}
//								}, 2500);
//							}
//						}
//					}).setNegativeButton(mParam.parent.getString(R.string.wait), new DialogInterface.OnClickListener() {
//
//						public void onClick(DialogInterface dialog, int which) {
//							// 点击“返回”后的操作,这里不设置没有任何操作
//							ActivityHelper.showDialogAgain();
//						}
//					}).show();

				}
			}
		}
	};


	public void SetProtocolCMD(ProtocolCMD protocolCmd) {
		mProtocolCmd = protocolCmd;
	}

	public void SetClientHandler(Handler clientHandler) {
		mClientHandler = clientHandler;
	}

	public void CloseSocketConnect() {
		if (mSokcetHelper != null) {
			mSokcetHelper.CloseThread();
			mSokcetHelper = null;
		}
	}

	public void SetIpAndPort(String strIp, int port) {
		mStrIp = strIp;
		mNPort = port;
	}




	/**
	 * （并创建sokcet连接）
	 * @author vcans
	 *
	 */
	public void startThreadConnectServer() {
		mSokcetHelper = new SocketHelper();

		if (mStrIp != null && !mStrIp.equals("") && mNPort > 0) {
			mSokcetHelper.SetIpAndPort(mStrIp, mNPort);
			// mSokcetHelper.SetEndStr(ProtocolCMD.m_vfxStrProEnd);
		}

		mSokcetHelper.SetMessageHandler(mHandler);
		mSokcetHelper.setbRunFlag(true);
		mSokcetHelper.start();
		socketFreeDisconnect = false;

	}

	/**
	 * 发送文本数据
	 *
	 * @param vctSendData
	 * @param sendFlag
	 * @return
	 */
	public int SendData(Vector<Vector<String>> vctSendData, int sendFlag) {
		byte[] sendByte = null;

		if (sendFlag == SEND_BEGIN_NOTIFY || sendFlag == SEND_FILE_BEGIN_NOTIFY) {
			vctBeginCmdRecords.clear();
			vctBeginOneRecord.clear();

			if (sendFlag == SEND_BEGIN_NOTIFY) {
				vctBeginOneRecord.add(MyProtocol.SEND_TEXT);
				vctBeginCmdRecords.add(vctBeginOneRecord);
				//格式化并发送文本数据
				sendByte = mProtocolCmd.FormatSendData(mP.sendCmd0, vctBeginCmdRecords);

			} else if (sendFlag == SEND_FILE_BEGIN_NOTIFY){
				vctBeginOneRecord.add(MyProtocol.SEND_FILE);
				vctBeginCmdRecords.add(vctBeginOneRecord);
				//格式化并发送文本数据
				sendByte = mProtocolCmd.FormatSendData(mP.sendCmd0, vctBeginCmdRecords);
			}
		} else if (sendFlag == SEND_END_NOTIFY) {// 暂无使用
			vctBeginCmdRecords.clear();
			vctBeginOneRecord.clear();
			vctBeginOneRecord.add("");
			vctBeginCmdRecords.add(vctBeginOneRecord);
			//格式化并发送文本数据
			sendByte = mProtocolCmd.FormatSendData(MyProtocol.SEND_END, vctBeginCmdRecords);
		} else {

			if (!isDownloadContinue)
			{	//格式化并发送文本数据
				sendByte = mProtocolCmd.FormatSendData(mP.sendCmd1, vctSendData);
			}
			else
			{
				//格式化并发送文本数据
				sendByte = mProtocolCmd.FormatSendData(mP.sendCmd2, vctSendData);
			}
		}

		if (mSokcetHelper!=null&&mSokcetHelper.SendSocketData(sendByte, sendByte.length) == 1)
			return 1;
		else
			return 0;
	}















	class ThreadWriteSend extends Thread {
		private Vector<String> mVctRecord = new Vector<String>();

		ThreadWriteSend(Vector<String> vctSendRecord) {
			mVctRecord = vctSendRecord;
		}

		@Override
		public void run() {

			byte[] sendBytes = mProtocolCmd.FormatSendFileV3(mP.sendCmd1, mVctRecord);        //按协议格式化，发送文件
			if (sendBytes != null)
				mSokcetHelper.SendSocketData(sendBytes, sendBytes.length);
			else
				ActivityHelper.showDialog(PlProcessor.mActParent, "", "准备发送数据时有一个异常");
		}

	};


	public int SendFile(Vector<String> vctSendData) {
		if (vctSendData.size() < 1)
			return 0;

		new ThreadWriteSend(vctSendData).start();

		return 1;
	}
	/**
	 * 得到文字的数据集*/
	public Vector<Vector<String>> GetReceiveData() {
		return mProtocolCmd.GetReceData();
	}

	public byte[] GetFileData() {
		return mFileBuf;
	}

	public void clearReceiveData() {
		if (mProtocolCmd.GetReceData() != null)
			mProtocolCmd.GetReceData().clear();
	}















	// 处理SokcetHelper发送来的消息
	public Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == SocketHelper.RECEVIE_VALID_DATA){// 处理有效数据
				Bundle bundle = msg.getData();
				byte[] szData = bundle.getByteArray("msg");
				bundle.clear();

				List<Received_Data> receDataList = mProtocolCmd.ResolveReceiveFileV2(szData);  //按协议解析文件
				// Received_Data
				//receData=mProtocolCmd.ResolveReceiveFile(szData,"");

				if (receDataList != null) {
					for (Received_Data receData : receDataList) {
						// mFileBuf=receData.fileByte;

						mFileByteList = receData.imgByteList;    //得到图片数据
						ReceiveData(receData.receText);
					}
				}
			} else {// 处理状态信息

				Bundle bundle = msg.getData();
				String strMsg = bundle.getString("msg");

				if (msg.what == SocketHelper.SOCKET_ERROR) {
					startProcessMsg(CANCEL_SERVER_RESPONSE, "");
					ActivityHelper.closeStatusDialog();//
					SendMsg(strMsg, ERROR_FLAG);
					handshakeCount = 0;
					bSendEnabled = false;
					startThreadConnectServer();
				} else if (msg.what == SocketHelper.SOCKET_CONNECTED) {
					setSocketClose(false);
					SendMsg(strMsg, OK_FLAG);
				} else if (msg.what == SocketHelper.SOCKET_DISCONNECT_TIP) {
					SendMsg(strMsg, ERROR_FLAG);
				} else if (msg.what == SocketHelper.SOCKET_DISCONNECT) {
					startProcessMsg(CANCEL_SERVER_RESPONSE, "");
					ActivityHelper.closeStatusDialog();//
					SendMsg(strMsg, ERROR_FLAG);
					setSocketClose(true);
				} else if (msg.what == SocketHelper.SOCKET_SEND_TIMEOUT_ERROR) {
					ActivityHelper.showDialog(PlProcessor.mActParent, "", strMsg);
					startProcessMsg(CANCEL_SERVER_RESPONSE, "");
				} else if (msg.what == SocketHelper.SOCKET_EXCEPTION) {
					ActivityHelper.showDialog(PlProcessor.mActParent, "", strMsg);
				} else if (msg.what == SocketHelper.NEW_SOCKET_CONNECTED) {
					if (++handshakeCount <= 3) {
						bEnabledDESTemp = ENABLED_DES_ZIP;
						ENABLED_DES_ZIP = false;// 确保发送握手命令为未加密数据

						bSendHandShake = true;
						SendParam sendParam = new SendParam();
						sendParam.bShowTipDlg=false;
						sendParam.parent = BaseActivity.mMainActivity;
						sendParam.tip = BaseActivity.mMainActivity.getString(R.string.securityRequest);
						sendParam.processor = mHandshake;
						sendParam.szData = new String[] { bEnabledDESTemp ? "1" : "0" };
						request(sendParam);
						new NotifyIsEncryptoThread().start();

					} else {
						if (!bSendEnabled) {

							new Handler().postDelayed(new Runnable() {

								public void run() {

									DataTrunsfer.this.SendMsg(
											BaseActivity.mMainActivity.getString(R.string.RequestError), ERROR_FLAG);
								}
							}, 2000);
						}
					}

				} else if (msg.what == SocketHelper.SOCKET_RECEVIE_BYTE) {
					SendMsg("Busy... ", MSG_BUSY_FLAG);
					ActivityHelper.showByteStatusDialog(strMsg, 0);
				} else if (msg.what == SocketHelper.SOCKET_SEND_BYTE) {
					ActivityHelper.showByteStatusDialog(strMsg, 1); ///////////////////////////////////////////////
					SendMsg("Busy...", MSG_BUSY_FLAG);
				} else if (msg.what == SocketHelper.SOCKET_FREE_DISCONNECTION) {
					socketFreeDisconnect = true;
					startProcessMsg(CANCEL_SERVER_RESPONSE, "");
					ActivityHelper.closeStatusDialog();  //
					PlProcessor.mActParent.backMainActivity();
				} else {
					SendMsg("unknwon error ", ERROR_FLAG);
				}

				bundle.clear();
			}
		}
	};

	Handler mTempHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			BaseActivity.mMainActivity.processMessage(DOWNLOAD_TITLE, "");
		}

	};

	/**
	 * 安全请求处理线程
	 *
	 * @author vcans
	 *
	 */
	class NotifyIsEncryptoThread extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			bSendHandShake = false;
			bSendEnabled = false;
			ENABLED_DES_ZIP = bEnabledDESTemp;

			if (mHandshake.isHandshakeSuccess()) {
				bSendEnabled = true;
				handshakeCount = 0;
				mTempHandler.sendMessage(new Message());
			} else{
				CloseSocketConnect();

				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				SendMsg("显示断开状态", ERROR_FLAG);
				startThreadConnectServer();

			}

		}// end if(nRst==1)
	};





















	private void processorCmd() {


		isDownloadContinue = false;
		String strCmd = mStrCmd;
		if (strCmd.equals(mP.receCmd0)) {
			mProcessor.ReceTxtSuccess();		                                                    Log.e("服务端返回数据", strCmd+"     成功");
		} else if (strCmd.equals(mP.receCmd1)) {
			ActivityHelper.ShowErrMsg(PlProcessor.mActParent, mReceText, this.GetReceiveData());
			//mProcessor.RecePartdefeated();
			                                                                                        Log.e("服务端返回数据", strCmd+"     失败");
			ActivityHelper.Filterinstructions(strCmd);                            //失败   处理一下 清除 gUser

		} else if (strCmd.equals(mP.receCmd2)) {
			isDownloadContinue = true;
			mProcessor.ReceTxtSuccess();			                                                Log.e("服务端返回数据", strCmd+"     成功+继续执行");

		} else if (strCmd.equals(mP.receCmd3)) {
			mProcessor.mPartProcessFlag = PlProcessor.PART_HAVE_ERROR_MSG;
			mProcessor.RecePartSuccess();                                                           Log.e("服务端返回数据", strCmd+"      失败+错误信息 + 错误记录格式");

		} else if (strCmd.equals(mP.receCmd5)) {
			mProcessor.mPartProcessFlag = PlProcessor.PART_NO_ERROR_MSG;
			mProcessor.RecePartSuccess();                                                           Log.e("服务端返回数据", strCmd+"     错误记录格式");
		}

	}



	public void ReceiveData(String receData){
		String strCmd = mProtocolCmd.ResolveReceiveData(receData);
		startProcessMsg(strCmd, receData);



	}

	private void startProcessMsg(String cmd, String receData) {
		if (cmd == DataTrunsfer.CANCEL_SERVER_RESPONSE)
			bSendBeginRequest = false;

		mStrCmd = cmd;
		this.mReceText = receData;
		if (!mStrCmd.equals("V_SERVER_HEART_")){
			new ThreadRequest(null, DataTrunsfer.SEND_ENABLED_FLAG).start();
			Log.e("TAG","连续执行线程启动"+mStrCmd+"~~~~~~~~~~~~~~~~~~~~~~~");
			isDownloadContinue = true;
		}

	}
}
