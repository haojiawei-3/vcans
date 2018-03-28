package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class DPMachiDownWorkProcessor extends DownloadProcessor {

	@Override
	public int ProcessData() {

		InitDropWorkProcess();

		return 1;
	}

	public void InitDropWorkProcess()
	{
		Vector<Vector<String> > vctReceData;
		if(this.mDataTrunsfer!=null)
			vctReceData=this.mDataTrunsfer.GetReceiveData();
		else
			vctReceData=new Vector<Vector<String> >();

		String[] szData;//s-97628a
		List<String> lstProType=new ArrayList<String>();
		ActivityHelper.lstGongXu.clear();

		if(vctReceData.size()>0)
		{
			for(Vector<String> record:vctReceData)
			{
				if(record.size()>0)
				{
					if(record.get(0).equals("工序"))
					{
						if(record.size()<3)
							continue;

						ActivityHelper.lstGongXu.add(record.get(2)+"["+record.get(1)+"]");

					}
					else if(record.get(0).equals("生产类型3"))
					{
						if(record.size()<2)
							continue;

						lstProType.add(record.get(2)+"["+record.get(1)+"]");

					}
				}
			}
		}
		else
		{
			szData=new String[1];
			szData[0]="";
		}

		ActivityHelper.InitDrop(mActParent, R.id.dropProType,lstProType,true);

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
		//==跟单==加工送仓库-物料信息下载
		p.sendCmd1= DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBo_JiaGongChangBianMaX1;
		p.receCmd0=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBo_JiaGongChangBianMaXRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBo_JiaGongChangBianMaXRe1;

		return p;
	}

}
