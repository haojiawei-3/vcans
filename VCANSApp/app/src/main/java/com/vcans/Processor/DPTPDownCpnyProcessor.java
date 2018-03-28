package com.vcans.Processor;

import java.util.Vector;

import android.graphics.Color;
import android.widget.EditText;

import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;

public class DPTPDownCpnyProcessor extends DownloadProcessor {

	public final static int DOWN_WORK=0;
	@Override
	public int ProcessData() {
		
		Vector<Vector<String> > vctReceData=this.mDataTrunsfer.GetReceiveData();
		
		for(Vector<String> record:vctReceData)
		{
			if(record.size()>0)
			{
				EditText txtOrder=(EditText)mActParent.findViewById(R.id.txtCompanyOrder);
				txtOrder.setText(record.get(0));
				
				 EditText txtRZPlanTemp=(EditText)mActParent.findViewById(R.id.txtRZPlanId);	
				 EditText txtCompayOrderId=(EditText)mActParent.findViewById(R.id.txtCompanyOrder);	
				 EditText txtRZFactoryId=(EditText)mActParent.findViewById(R.id.txtRZFactoryId);
				 
				 txtRZPlanTemp.setEnabled(false);
				 txtRZFactoryId.setEnabled(true);
				 txtCompayOrderId.setEnabled(false);
				 txtCompayOrderId.setBackgroundColor(Color.GRAY);
				 
				 mActParent.processMessage(DOWN_WORK, "");
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
	public MyProtocol GetProtocol() {
		
		MyProtocol p=new MyProtocol();
		
		p.sendCmd1= DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_RanZhengJiHuaHao;
		p.receCmd0=DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_RanZhengJiHuaHaoRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_RanZhengJiHuaHaoRe1;
		
		return p;
	}

}
