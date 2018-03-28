package com.vcans.base;

/**
 * Created by vcans-1 on 2017-12-14.
 */

import com.Vcan.activity.R;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.DataTrunsfer;
import com.vcans.tool.PlProcessor;
import java.util.Vector;


/**
 * 下载数据的处理者
 * @author vcans
 *
 */
public abstract class DownloadProcessor extends PlProcessor
{
    private boolean handshakeSuccess=false;

    private Vector<Vector<String>> m_vctSendData;

    public boolean isHandshakeSuccess() {
        return handshakeSuccess;
    }

    public void setHandshakeSuccess(boolean success) {
        handshakeSuccess=success;
    }

    public DownloadProcessor()
    {

    }

    @Override
    public  void ReceTxtSuccess()
    {
        //
        ProcessData();
        if(mDataTrunsfer.isDownloadContinue()){
            sendData();
        }
        else{
            ActivityHelper.closeStatusDialog();
            //mActParent.SendParam1();
        }
    }

    @Override
    public  void ReceImageSuccess()
    {

    }

    @Override
    public  void RecePartSuccess()
    {
        ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.partDone));
    }



    /**
     * 服务端返回成功时的处理
     */
    public abstract int ProcessData();






    private int sendData()
    {
        int nRst=0;

        if(mDataTrunsfer!=null)
            nRst=mDataTrunsfer.SendData(m_vctSendData, DataTrunsfer.SEND_DATA);

        if(nRst!=1)
        {
            ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.sendFailOrDisconnect));
            return 0;
        }

        return nRst;
    }


    public int SendInfo(String[] extrData)
    {
        m_vctSendData=GetSendData(extrData);

        return sendData();
    }
}

