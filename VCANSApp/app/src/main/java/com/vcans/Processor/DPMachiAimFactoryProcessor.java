package com.vcans.Processor;

import java.util.Vector;

import android.widget.EditText;

import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;

public class DPMachiAimFactoryProcessor extends DownloadProcessor {

	@Override
	public int ProcessData() {
		
		Vector<Vector<String> > vctReceData=this.mDataTrunsfer.GetReceiveData();
		
		for(Vector<String> record:vctReceData)
		{
			if(record.size()>0)
			{
				EditText txtOrder=(EditText)mActParent.findViewById(R.id.txtRZFactory);
				txtOrder.setText(record.get(0));
				//mActParent.processMessage(0, null);
			}
		}
		
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
	public MyProtocol GetProtocol(){
		
		MyProtocol p=new MyProtocol();
		//==跟单==加工送仓库-目的工厂查询
		p.sendCmd1= DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBo_MuDiGongChangBianMa;
		p.receCmd0=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBo_MuDiGongChangBianMa0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_ShengChanDiaoBo_MuDiGongChangBianMa1;
		
		return p;
	}

}
