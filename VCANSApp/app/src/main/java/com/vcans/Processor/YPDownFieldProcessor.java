package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.model.MyProtocol;


public class YPDownFieldProcessor extends DownloadProcessor {

	List<String> mDataList=new ArrayList<String>();

	
	@Override
	public int ProcessData() {
		
		initGoodsList();
		
		return 1;
	}
	
	public List<String> GetFieldList()
	{
		return mDataList;
	}
	
	public void initGoodsList()
	{
		Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
		if(mDataTrunsfer!=null)
		    vctReceData=this.mDataTrunsfer.GetReceiveData();
		
		mDataList.clear();
		
		for(Vector<String> record:vctReceData)
		{
			for(String v:record)
			{
				mDataList.add(v);
			}
		}
		
		mActParent.processMessage(0, "");
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
		
		p.sendCmd1= YPStandardProtocol.m_vfxVAGSTD_YangPinZiDuanXinXi1;
		p.receCmd0=YPStandardProtocol.m_vfxVAGSTD_YangPinZiDuanXinXiRe0;
		p.receCmd1=YPStandardProtocol.m_vfxVAGSTD_YangPinZiDuanXinXiRe1;
		
		return p;
	}

}
