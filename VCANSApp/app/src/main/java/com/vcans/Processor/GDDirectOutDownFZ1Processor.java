package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class GDDirectOutDownFZ1Processor extends DownloadProcessor {

	public final static String FZ1="直接出货辅助一";
	public final static String FZ2="直接出货辅助二";
	public final static String FZ3="直接出货辅助三";

	private String mFzType;
	public GDDirectOutDownFZ1Processor(String fzType)
	{
		mFzType=fzType;
	}

	@Override
	public int ProcessData() {

		InitDropFZ1();

		return 1;
	}

	public void InitDropFZ1()
	{
		Vector<Vector<String> > vctReceData;
		if(this.mDataTrunsfer!=null)
			vctReceData=this.mDataTrunsfer.GetReceiveData();
		else
			vctReceData=new Vector<Vector<String> >();

		String[] szData;
		List<String> lstFZ=new ArrayList<String>();

		if(vctReceData.size()>0)
		{
			for(Vector<String> record:vctReceData)
			{
				if(record.size()>0&&!mFzType.equals(""))
				{
					if(record.get(0).equals(mFzType))
					{
						if(record.size()<3)
							continue;

						lstFZ.add(record.get(2)+"["+record.get(1)+"]");

					}
				}
			}
		}
		else
		{
			szData=new String[1];
			szData[0]="";
		}

		if(mFzType.equals(FZ1))
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData1, lstFZ,false);
		else if(mFzType.equals(FZ2))
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData2, lstFZ,false);
		else
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData3, lstFZ,true);
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		for(String str:extrData)
			child.add(str);

		vctSendData.add(child);

		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		if(mFzType.equals(FZ1))
		{
			p.sendCmd1= DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_1FZ1;
			p.receCmd0=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_1FZRe0;
			p.receCmd1=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_1FZRe1;
		}
		else if(mFzType.equals(FZ2))
		{
			p.sendCmd1=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_2FZ1;
			p.receCmd0=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_2FZRe0;
			p.receCmd1=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_2FZRe1;
		}
		else
		{
			p.sendCmd1=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_3FZ1;
			p.receCmd0=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_3FZRe0;
			p.receCmd1=DPProtocol.m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_3FZRe1;
		}

		return p;
	}

}
