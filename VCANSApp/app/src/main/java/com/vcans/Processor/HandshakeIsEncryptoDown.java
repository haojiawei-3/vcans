package com.vcans.Processor;

import java.util.Vector;

import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.model.MyProtocol;

public class HandshakeIsEncryptoDown extends DownloadProcessor {
	

	@Override
	public int ProcessData() {
		// TODO Auto-generated method stub
		setHandshakeSuccess(true);
		
		return 1;
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		// TODO Auto-generated method stub
		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();
		
		Vector<String> child= new Vector<String>();
		
		if(extrData.length>0)
			child.add(extrData[0]);  
		else
			child.add("1"); 
		
		vctSendData.add(child);
	    
	    return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {
		// TODO Auto-generated method stub
		MyProtocol p=new MyProtocol();
		
		p.sendCmd1=YPStandardProtocol.m_vcansHandshakeNotifyIsEncrypto;
		p.receCmd0= YPStandardProtocol.m_vcansHandshakeNotifyIsEncryptoRe0;
		p.receCmd1=YPStandardProtocol.m_vcansHandshakeNotifyIsEncryptoRe1;
		
		return p;
	}

}
