package com.vcans.Processor;


import java.util.Vector;

import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.model.MyProtocol;

public class YPExpBarcodeProcessor extends DownloadProcessor 
{

	
	
	public YPExpBarcodeProcessor()
	{
		
	}
	
	
	@Override
	public int ProcessData()
	{
		Vector<Vector<String> > vctReceData= mDataTrunsfer.GetReceiveData();
		
		for(Vector<String> vctFields : vctReceData)
		{
			if(vctFields.size()<2)
				 continue;
			
			String strPrice=vctFields.get(0);
			String strRemark=vctFields.get(1);
			
			//EditText txtPrice=(EditText)mActParent.findViewById(R.id.txtPrice);
			
			//txtPrice.setText(strPrice);
			
			mActParent.processMessage(1,strPrice);

			//if(!strRemark.equals(""))
			//	ActivityHelper.showDialog(mActParent,"", strRemark);	
		}
		
		return 1;
	}
	
	
	public  Vector<Vector<String> > GetSendData(String[] extrData)
	{
		 Vector<Vector<String> > vctSendData=new Vector<Vector<String> >();
		 
		 Vector<String> vctChild=new Vector<String>();
		 for(int i=0;i<extrData.length;++i)
		 { 
			 vctChild.add(extrData[i]);
		 }
		 
		 vctSendData.add(vctChild);
		 
		 return vctSendData;
	}
	
	public MyProtocol GetProtocol()
	{	
		MyProtocol myProtocol =new MyProtocol();
		
		myProtocol.sendCmd1=YPStandardProtocol.m_vfxVAGSTD_ZhanHuXunYangYangPinTiaoMa1;
		myProtocol.receCmd0= YPStandardProtocol.m_vfxVAGSTD_ZhanHuXunYangYangPinTiaoMaRe0;
		myProtocol.receCmd1=YPStandardProtocol.m_vfxVAGSTD_ZhanHuXunYangYangPinTiaoMaRe1;
		
		return myProtocol;
	}
}
