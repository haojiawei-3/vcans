package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class DPMachiFactoryProcessor extends DownloadProcessor {

	@Override
	public int ProcessData() {

		InitDropMachiFactory();

		return 1;
	}

	public void InitDropMachiFactory()
	{
		Vector<Vector<String> > vctReceData;
		if(this.mDataTrunsfer!=null)
			vctReceData=this.mDataTrunsfer.GetReceiveData();
		else
			vctReceData=new Vector<Vector<String> >();

		List<String> lstGongXu=new ArrayList<String>();

		if(vctReceData.size()>0)
		{
			for(Vector<String> record:vctReceData)
			{
				if(record.size()>0)
				{
					if(record.get(0).equals("工厂"))
					{
						if(record.size()>2)
							lstGongXu.add(record.get(2)+"|"+record.get(1));

					}
				}
			}
		}


		ActivityHelper.InitDrop(mActParent, R.id.dropRZFactoryId, lstGongXu,false);
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		if(extrData.length>=2)
		{
			child.add(extrData[0]);
			child.add(extrData[1]);
		}

		vctSendData.add(child);

		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();
		//==跟单==加工送仓库-工厂下载
		p.sendCmd1= DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBo_RanZhengJiHuaHaoX1;
		p.receCmd0=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBo_RanZhengJiHuaHaoXRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBo_RanZhengJiHuaHaoXRe1;

		return p;
	}

}
