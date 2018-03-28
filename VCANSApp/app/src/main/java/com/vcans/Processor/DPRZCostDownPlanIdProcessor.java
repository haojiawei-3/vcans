package com.vcans.Processor;

import java.util.Vector;

import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;

public class DPRZCostDownPlanIdProcessor extends DownloadProcessor {

	@Override
	public int ProcessData() {
		

		mActParent.processMessage(10,"");
		return 1;
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		
		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();
		
		if(extrData.length>0)
		{
			Vector<String> child= new Vector<String>();
			
			child.add(extrData[0]);
		    vctSendData.add(child);
		}
	    
	    return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {
		
		MyProtocol p=new MyProtocol();
		
		p.sendCmd1=DPProtocol.m_vfxVAG4BDePei_RanZhengFeiYong_RanZhengJiHuaHao;
		p.receCmd0= DPProtocol.m_vfxVAG4BDePei_RanZhengFeiYong_RanZhengJiHuaHaoRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_RanZhengFeiYong_RanZhengJiHuaHaoRe1;
		
		return p;
	}

}
