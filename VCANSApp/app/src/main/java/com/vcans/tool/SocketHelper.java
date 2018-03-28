package com.vcans.tool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SocketHelper extends Thread {
	public static final String CHAR_SET = "GBK";

	// 消息ID
	public static final char RECEVIE_VALID_DATA = 0x01;
	public static final char PROCESS_FILE_SUCCESS = 0x02;
	public static final char SOCKET_CONNECTED = 0x03;
	public static final char SOCKET_DISCONNECT_TIP = 0x04;// 用于提示消息Socket断开连接
	public static final char SOCKET_ERROR = 0x05;
	public static final char SOCKET_SEND_TIMEOUT_ERROR = 0x06;
	public static final char SOCKET_EXCEPTION = 0x07;
	public static final char NEW_SOCKET_CONNECTED = 0x08;
	public static final char SOCKET_RECEVIE_BYTE = 0x09;
	public static final char SOCKET_SEND_BYTE = 0x0A;
	public static final char SOCKET_FREE_DISCONNECTION = 0x0B;
	public static final char SOCKET_DISCONNECT = 0x0C;// Socket断开连接

	public static final int CONNECT_DELAY_TIME = 3; // 多少秒后连接sokcet
	public static final int CONNECT_DELAY_TIME_LONG = 30; // 当连接多少次后还未连接上socket时的较长连接时间
	public static final int CONNECT_TIMEOUT_TIME = 25; // 连接超时 2秒一次
	public static final int ERROR_TIME_OUT = 5;
	public static final int READ_BUF_LEN = 1024 * 200;
	public static final int DELAY_DISPLAY_TIME = 1500; // ms
	public static final int SEND_TIMEOUT = 8; // S
	public static final int SOCKET_FREE_TIME = 30; // m 分钟
	public static final int RECONNECT_WIFI_COUNT = 3;

	public static final Object lock1 = new Object();
	public static final Object lock2 = new Object();
	public static final Object lockSendStop = new Object();
	public static final Object lockReceiveFree = new Object();

	public Handler myHandler = null;
	private String mStrIp = "0.0.0.0";
	private int m_nPort = 4431;
	private Socket socket = null;
	private boolean bRunFlag = false;
	private boolean bStopThreadFree = false;

	private int mSocketFreeTime = 0;

	public int getmSocketFreeTime() {

		return mSocketFreeTime;

	}

	public void setmSocketFreeTime(int mSocketFreeTime) {

		synchronized (lockReceiveFree) {
			this.mSocketFreeTime = mSocketFreeTime;
		}
	}

	private boolean bSendStop = true;

	public boolean isbSendStop() {

		synchronized (lockSendStop) {
			return bSendStop;

		}
	}

	public void setbSendStop(boolean bSendStop) {

		synchronized (lockSendStop) {
			this.bSendStop = bSendStop;

		}
	}

	public boolean isbRunFlag() {

		synchronized (lock2) {
			return bRunFlag;
		}
	}

	public void setbRunFlag(boolean bRunFlag) {

		synchronized (lock2) {
			this.bRunFlag = bRunFlag;
		}
	}

	private InputStream mInputStream = null;
	private OutputStream ou = null;
	private byte[] mReceBuf = new byte[READ_BUF_LEN];
	private ByteArrayOutputStream mByteArray = new ByteArrayOutputStream();

	public void InitReceByteArray(byte[] leftData) throws IOException {
		mByteArray.flush();
		mByteArray.reset();

		if (leftData != null) {
			m_strPreReceiveEnd = new String(leftData, leftData.length - ProtocolCMD.m_vfxICmdLength,ProtocolCMD.m_vfxICmdLength);
			mByteArray.write(leftData);
		}

	}

	private int mConnectCount = 0;
	private int mNShowConnTime = 0;
	private SocketSendThread mSendThread = null;
	private int nDelayConnectTime = 0;
	private boolean mbConnected = false;
	private String m_strPreReceiveEnd = "";
	private WifiManager wifiManager;
	private int reconectWifiNnum = 0;

	public SocketHelper() {
		// TODO Auto-generated constructor stub
		nDelayConnectTime = CONNECT_DELAY_TIME;
		new ThreadReceiveFree().start();
		reconectWifiNnum = 0;
		wifiManager = (WifiManager) BaseActivity.mMainActivity.getSystemService(Context.WIFI_SERVICE);
	}

	public SocketHelper(String ip, int port, Handler handler) {
		// TODO Auto-generated constructor stub
		mStrIp = ip;
		m_nPort = port;
	}

	public void SetIpAndPort(String ip, int port) {
		mStrIp = ip;
		m_nPort = port;
	}

	public void SetMessageHandler(Handler handler) {
		myHandler = handler;
	}

	private void SendMsg(String msgobj, int Flag) {
		Bundle mBundle = new Bundle();
		mBundle.putString("msg", msgobj);
		Message msg = new Message();
		msg.what = Flag;
		;
		msg.setData(mBundle);

		if (myHandler != null)
			myHandler.sendMessage(msg);
	}

	private void SendMsg(byte[] szByte, int Flag) {
		Bundle mBundle = new Bundle();
		mBundle.putByteArray("msg", szByte);
		Message msg = new Message();
		msg.what = Flag;
		;
		msg.setData(mBundle);

		if (myHandler != null)
			myHandler.sendMessage(msg);
	}

	public int isIpReachable(String ip) {
		try {
			InetAddress addr = InetAddress.getByName(ip);
			if (addr.isReachable(3000)) {
				return 1;
			}

			return 0;
		} catch (UnknownHostException e) {
			return -1;
		} catch (IOException e) {
			int ii = 0;
			return -2;
		}
	}

	private int ConnServerSocket() {
		// 连接服务器 并设置连接超时为5秒
		int nSucFlag = 0;
		boolean bConn = false;

		if (socket != null)
			bConn = socket.isConnected();

		if (!bConn) {
			try {

				if (socket == null)
					socket = new Socket();

				if (mStrIp == null || m_nPort == 0)
					return 0;

				socket.connect(new InetSocketAddress(mStrIp, m_nPort), 8000);
				ou = socket.getOutputStream();
				mInputStream = socket.getInputStream();
				nSucFlag = 1;
			} catch (SocketTimeoutException e) {
				nSucFlag = 0;
			} catch (SocketException e) {
				// if(isIpReachable(mStrIp)==1)
				// {
				String strAdd = "";
				if (e.getMessage().indexOf("No route to host") > -1) {
					strAdd = "Restart WiFi ";

					if (reconectWifiNnum < RECONNECT_WIFI_COUNT) {
						reconectWifiNnum++;
						if (wifiManager.isWifiEnabled()) {
							wifiManager.setWifiEnabled(false);

							try {
								Thread.sleep(3000);
							} catch (InterruptedException e1) {

								e1.printStackTrace();
							}

							wifiManager.setWifiEnabled(true);
						}
					}

					SendMsg(strAdd + e.getMessage(), SocketHelper.SOCKET_EXCEPTION);
				}

				nSucFlag = 0;
				// }
			} catch (IOException e) {

				nSucFlag = 0;
			}

			if (nSucFlag == 1)
				SendMsg("新Socket已连接!", SocketHelper.NEW_SOCKET_CONNECTED);
		} else
			nSucFlag = 1;

		if (nSucFlag != 1) {
			try {
				SendMsg("未连接服务," + nDelayConnectTime + "秒后重连!", SocketHelper.SOCKET_DISCONNECT_TIP);
				Thread.sleep(nDelayConnectTime * 1000);

				SendMsg("正在连接...", SocketHelper.SOCKET_DISCONNECT_TIP);
				Thread.sleep(2000);

				if (mConnectCount >= CONNECT_TIMEOUT_TIME) {
					nDelayConnectTime = CONNECT_DELAY_TIME_LONG;
				} else {
					++mConnectCount;
				}

				if (!socket.isClosed())
					socket.close();

				socket = null;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// if(mNShowConnTime>0)
			// {
			// new ShowConnThread().start();
			// }
			// else
			SendMsg("服务已连接...", SocketHelper.SOCKET_CONNECTED);

			nDelayConnectTime = CONNECT_DELAY_TIME;
		}

		// setConnectedSync(nSucFlag==1?true:false);

		return nSucFlag;

	}

	public void CloseThread() {
		new CloseThread().start();
	}

	class CloseThread extends Thread {
		@Override
		public void run() {
			synchronized (lockReceiveFree) {
				bStopThreadFree = true;
			}

			synchronized (lock2) {
				if (bRunFlag) {
					bRunFlag = false;

					if (socket.isConnected()) {
						try {
							if (mInputStream != null)
								mInputStream.close();

							setbSendStop(false);
							if (ou != null)
								ou.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					this.interrupt();
				}
			}
		}
	}

	public boolean IsConnected() {
		if (socket != null)
			return socket.isConnected();
		else
			return false;
	}

	public boolean IsConnectedSync() {
		synchronized (lock1) {
			return mbConnected;
		}

	}

	public void setConnectedSync(boolean connected) {
		synchronized (lock1) {
			mbConnected = connected;
			;
		}

	}

	class SocketSendThread extends Thread {
		String mSendData = "";
		byte[] mDataBuf;
		int mRealLen = 0;

		SocketSendThread() {
		}

		SocketSendThread(byte[] dataBuf, int realLen) {
			mDataBuf = dataBuf;
			mRealLen = realLen;
		}

		int nSendTime = 0;

		@Override
		public void run() {
			while (true) {
				if (!IsConnected()) {
					if (++nSendTime >= SEND_TIMEOUT) {
						SendMsg("数据发送超时，服务器连接失败...", SocketHelper.SOCKET_SEND_TIMEOUT_ERROR);
						break;
					}

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				} else if (mRealLen == 0)
					return;

				try {
					if (ou != null) {
						int sendStartIndex = 0;
						int sendBaseLen = 1024 * 200;// 200kb
						int leftLen = 0;

						int s = 100;

						int kb = mRealLen / 1024;

						if (kb > 3000) {
							s = 500;
						}

						// 数据分块发送 提高效率，防止网络阻塞
						while (sendStartIndex < mRealLen && isbSendStop()) {
							leftLen = mRealLen - sendStartIndex;
							if (leftLen < sendBaseLen)
								sendBaseLen = leftLen;

							ou.write(mDataBuf, sendStartIndex, sendBaseLen);
							sendStartIndex += sendBaseLen;

							int kbsize = sendStartIndex / 1024;
							if (kbsize > 0)
								SendMsg("↑" + kbsize + "SB", SocketHelper.SOCKET_SEND_BYTE);

							Thread.sleep(s);

						}

						SocketHelper.this.setmSocketFreeTime(0);

						int kbsize = sendStartIndex / 1024;
						if (kbsize > 0)
							SendMsg(BaseActivity.mMainActivity.getString(R.string.sendDone) + kbsize + "KB,"
											+ BaseActivity.mMainActivity.getString(R.string.waitReceive),
									SocketHelper.SOCKET_SEND_BYTE);
					}

					break;
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
			}
		}
	}

	class ShowConnThread extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(mNShowConnTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			mNShowConnTime = 0;

			SendMsg("服务已连接...", SocketHelper.SOCKET_CONNECTED);
		}
	}

	/*
	 * class ShowConnThread extends Thread {
	 *
	 * @Override public void run() { try { Thread.sleep(mNShowConnTime); } catch
	 * (InterruptedException e) { e.printStackTrace(); }
	 *
	 * mNShowConnTime=0;
	 *
	 * SendMsg("服务已连接...",SocketHelper.SOCKET_CONNECTED); } }
	 */

	/**
	 * 空闲监控线程
	 *
	 * @author vcans
	 *
	 */
	class ThreadReceiveFree extends Thread {
		final int INTERVAL = 60000;

		@Override
		public void run() {
			while (true) {

				try {
					Thread.sleep(INTERVAL);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				synchronized (lockReceiveFree) {
					if (bStopThreadFree) {
						break;
					}

					int min = ++mSocketFreeTime;
					min *= INTERVAL;

					if (min > (SOCKET_FREE_TIME * 60 * 1000)) {
						SocketHelper.this.mSocketFreeTime = 0;
						SendMsg("Socket空闲断开", SOCKET_FREE_DISCONNECTION);
						SocketHelper.this.CloseThread();
						break;

					}

				}

			}
		}
	}

	public int SendSocketData(byte[] dataBuf, int realLen) {
		mSendThread = new SocketSendThread(dataBuf, realLen);
		mSendThread.start();

		return 1;
	}

	@Override
	public void run() {

		boolean sevrDisconnection = false;

		while (this.isbRunFlag()) {
			try {
				// 连接Socket
				if (ConnServerSocket() != 1)
					continue;

				// mByteArray.flush();
				// mByteArray.reset();

				// 阻塞模式 读取服务器数据
				int realSize = 0;
				do {

					realSize = mInputStream.read(mReceBuf, 0, READ_BUF_LEN);

					if (realSize > 0) {
						mByteArray.write(mReceBuf, 0, realSize);
					} else {// 一般表示服务器已断开
						sevrDisconnection = true;
						break;
					}

					// 清除空闲计数
					setmSocketFreeTime(0);





					// 发送到界面提示，已接到的数据字节
					int kbsize = mByteArray.size() / 1024;
					if (kbsize > 0)
						SendMsg("↓" + kbsize + "KB", SocketHelper.SOCKET_RECEVIE_BYTE);

					// 解析并判断一帧数据是否接收完毕
					String strCurrentHead = new String(mReceBuf, 0, ProtocolCMD.m_vfxICmdLength, CHAR_SET);
					String strCurrentTeil = "";
					if (realSize >= ProtocolCMD.m_vfxICmdLength)
						strCurrentTeil = new String(mReceBuf, realSize - ProtocolCMD.m_vfxICmdLength,
								ProtocolCMD.m_vfxICmdLength, CHAR_SET);
					else
						strCurrentTeil = new String(mReceBuf, 0, realSize, CHAR_SET);

					String frameEndStr1 = "";
					String frameEndStr2 = "";

					if (!m_strPreReceiveEnd.equals(""))
						frameEndStr2 = m_strPreReceiveEnd + strCurrentHead;

					frameEndStr1 = strCurrentTeil;

					int endPos1 = frameEndStr1.indexOf(ProtocolCMD.m_vfxStrProEnd);
					int endPos2 = frameEndStr2.indexOf(ProtocolCMD.m_vfxStrProEnd);

					if (endPos1 < 0) {
						if (endPos2 < 0) {// 数据未接收完
							m_strPreReceiveEnd = strCurrentTeil;
						} else {
							if (kbsize > 0)
								SendMsg(BaseActivity.mMainActivity.getString(R.string.done) + kbsize + "KB",
										SocketHelper.SOCKET_RECEVIE_BYTE);
							break;
						}
					} else {
						if (kbsize > 0)
							SendMsg(BaseActivity.mMainActivity.getString(R.string.done) + kbsize + "KB",
									SocketHelper.SOCKET_RECEVIE_BYTE);
						break;
					}

				} while (true);

				if (sevrDisconnection) {// 接收到空数据的超时间处理
					// Thread.sleep(2000);
					// if(++mNoDataTime>=ERROR_TIME_OUT)
					// {
					SendMsg("Socket服务已断开连接,稍后重新连接", SocketHelper.SOCKET_ERROR);
					mNShowConnTime = DELAY_DISPLAY_TIME;

					break;
					// }
				} else if (mByteArray.size() > 0) {
					byte[] byteRece = mByteArray.toByteArray();
					SendMsg(byteRece, SocketHelper.RECEVIE_VALID_DATA);

					mByteArray.flush();
					mByteArray.close();

					mNShowConnTime = DELAY_DISPLAY_TIME;

				}

			} catch (SocketTimeoutException aa) {

				SendMsg("服务器连接失败！请检查网络是否打开", SocketHelper.SOCKET_ERROR);
				break;
			} catch (IOException e) {
				e.printStackTrace();
			}

		} // end while(this.bRunFlag)

		try {
			if (this.socket != null) {
				if (!this.socket.isClosed())
					this.socket.close();

				socket = null;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.setbRunFlag(false);
		SendMsg("SOCKET已断开", SocketHelper.SOCKET_DISCONNECT);

	} // end run

} // end socketHelper