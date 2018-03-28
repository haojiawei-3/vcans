package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class DPTPDownColorProcessor extends DownloadProcessor {

	@Override
	public int ProcessData() {

		InitOrderAndDropFactory();

		return 1;
	}

	public void InitOrderAndDropFactory()
	{
		Vector<Vector<String> > vctReceData;
		if(this.mDataTrunsfer!=null)
			vctReceData=this.mDataTrunsfer.GetReceiveData();
		else
			vctReceData=new Vector<Vector<String> >();

		String[] szData=null;
		List<String> lstData=new ArrayList<String>();

		ActivityHelper.lstFlowerAndColor.clear();

		if(vctReceData.size()>0)
		{
			for(Vector<String> record:vctReceData)
			{
				if(record.size()>0)
				{
					if(record.get(0).equals("花型颜色"))
					{
						String flower="",strColor="";
						flower=record.get(1);
						strColor=record.get(2);

						//ActivityHelper.lstFlowerAndColor.add(flower+"|"+strColor);
						lstData.add(strColor);
					}
				}
			}
		}
		else
		{
			szData=new String[1];
			szData[0]="";
		}

		ActivityHelper.InitDrop(mActParent, R.id.dropColor, lstData,true);
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
		p.sendCmd1=DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengJiHuaHaoX1;
		p.receCmd0= DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengJiHuaHaoXRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengJiHuaHaoXRe1;

		return p;
	}

}
