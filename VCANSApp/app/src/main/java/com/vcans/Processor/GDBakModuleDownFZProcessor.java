package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.Vcan.activity.R;
import com.Vcan.activity.GDBakModule;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

/**
 * 备用模块 辅助资料下载（非公共的）
 * @author vcans
 *
 */
public class GDBakModuleDownFZProcessor extends DownloadProcessor {

	public final static String FZ1="备用%s辅助资料1";
	public final static String FZ2="备用%s辅助资料2";
	public final static String FZ3="备用%s辅助资料3";
	public final static String FZ4="备用%s辅助资料4";
	public final static String FZ5="备用%s辅助资料5";
	public final static String FZ6="备用%s辅助资料6";
	public final static String FZ7="备用%s辅助资料7";


	private String mFzType;
	private String fzFlag;
	public GDBakModuleDownFZProcessor(String fzType)
	{
		fzFlag=fzType;
		mFzType=String.format(fzType,GDBakModule.gBakFlag);
	}

	@Override
	public int ProcessData() {

		InitDropFZ();

		return 1;
	}

	public void InitDropFZ()
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

		if(fzFlag.equals(FZ1))
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData1, lstFZ,false);
		else if(fzFlag.equals(FZ2))
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData2, lstFZ,false);
		else  if(fzFlag.equals(FZ3))
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData3, lstFZ,false);
		else  if(fzFlag.equals(FZ4))
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData4, lstFZ,true);
		else  if(fzFlag.equals(FZ5))
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData5, lstFZ,false);
		else  if(fzFlag.equals(FZ6))
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData6, lstFZ,false);
		else  if(fzFlag.equals(FZ7))
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData7, lstFZ,true);
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

		String strNum=GDBakModule.mapBakModuleId.get(GDBakModule.gBakFlag);

		if(fzFlag.equals(FZ1))
		{
			p.sendCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_1FZ1,strNum);
			p.sendCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_1FZ2,strNum);
			p.receCmd0=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_1FZRe0,strNum);
			p.receCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_1FZRe1,strNum);
			p.receCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_1FZRe2,strNum);
		}
		else if(fzFlag.equals(FZ2))
		{
			p.sendCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_2FZ1,strNum);
			p.sendCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_2FZ2,strNum);
			p.receCmd0=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_2FZRe0,strNum);
			p.receCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_2FZRe1,strNum);
			p.receCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_2FZRe2,strNum);
		}
		else if(fzFlag.equals(FZ3))
		{
			p.sendCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_3FZ1,strNum);
			p.sendCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_3FZ2,strNum);
			p.receCmd0=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_3FZRe0,strNum);
			p.receCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_3FZRe1,strNum);
			p.receCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_3FZRe2,strNum);
		}
		else if(fzFlag.equals(FZ4))
		{
			p.sendCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_4FZ1,strNum);
			p.sendCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_4FZ2,strNum);
			p.receCmd0=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_4FZRe0,strNum);
			p.receCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_4FZRe1,strNum);
			p.receCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_4FZRe2,strNum);
		}
		else if(fzFlag.equals(FZ5))
		{
			p.sendCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_5FZ1,strNum);
			p.sendCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_5FZ2,strNum);
			p.receCmd0=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_5FZRe0,strNum);
			p.receCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_5FZRe1,strNum);
			p.receCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_5FZRe2,strNum);
		}
		else if(fzFlag.equals(FZ6))
		{
			p.sendCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_6FZ1,strNum);
			p.sendCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_6FZ2,strNum);
			p.receCmd0=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_6FZRe0,strNum);
			p.receCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_6FZRe1,strNum);
			p.receCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_6FZRe2,strNum);
		}
		else if(fzFlag.equals(FZ7))
		{
			p.sendCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_7FZ1,strNum);
			p.sendCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_7FZ2,strNum);
			p.receCmd0=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_7FZRe0,strNum);
			p.receCmd1=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_7FZRe1,strNum);
			p.receCmd2=String.format(DPProtocol.m_VCANSAPP_BAKMODULEN_XIAZAI_7FZRe2,strNum);
		}

		return p;
	}

}
