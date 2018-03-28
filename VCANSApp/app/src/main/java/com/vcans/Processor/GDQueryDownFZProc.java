package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.Vcan.activity.R;
import com.Vcan.activity.GDBakModule;
import com.Vcan.activity.GDQuery;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

/**
 * 备用模块 辅助资料下载（非公共的）
 * @author vcans
 *
 */
public class GDQueryDownFZProc extends DownloadProcessor {

	public final static String FZ1="综合查询%s辅助条件1";
	public final static String FZ2="综合查询%s辅助条件2";
	public final static String FZ3="综合查询%s辅助条件3";


	private String mFzType;
	private String mFzFlag="";
	public GDQueryDownFZProc(String fzType)
	{
		mFzFlag=fzType;
		mFzType=String.format(fzType,GDQuery.gQueryFlag);
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
		else{
			szData=new String[1];
			szData[0]="";
		}
		if(mFzFlag.equals(FZ1))
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData1, lstFZ,false);
		else if(mFzFlag.equals(FZ2))
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData2, lstFZ,false);
		else  if(mFzFlag.equals(FZ3))
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

		String strNum=GDBakModule.mapBakModuleId.get(GDQuery.gQueryFlag);

		if(mFzFlag.equals(FZ1))
		{
			p.sendCmd1=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_1FZ1,strNum);
			p.sendCmd2=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_1FZ2,strNum);
			p.receCmd0=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_1FZRe0,strNum);
			p.receCmd1=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_1FZRe1,strNum);
			p.receCmd2=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_1FZRe2,strNum);
		}
		else if(mFzFlag.equals(FZ2))
		{
			p.sendCmd1=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_2FZ1,strNum);
			p.sendCmd2=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_2FZ2,strNum);
			p.receCmd0=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_2FZRe0,strNum);
			p.receCmd1=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_2FZRe1,strNum);
			p.receCmd2=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_2FZRe2,strNum);
		}
		else if(mFzFlag.equals(FZ3))
		{
			p.sendCmd1=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_3FZ1,strNum);
			p.sendCmd2=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_3FZ2,strNum);
			p.receCmd0=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_3FZRe0,strNum);
			p.receCmd1=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_3FZRe1,strNum);
			p.receCmd2=String.format(DPProtocol.m_VCANSAPP_GDQUERYN_XIAZAI_3FZRe2,strNum);
		}

		return p;
	}

}
