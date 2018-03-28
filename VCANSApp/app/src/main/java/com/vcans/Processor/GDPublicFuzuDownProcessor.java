package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


import com.Vcan.activity.R;
import com.Vcan.activity.GDDirectOut2;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class GDPublicFuzuDownProcessor extends DownloadProcessor {

	public final static String FZ4="直接出货辅助四";
	public final static String FZ5="直接出货辅助五";

	private String fzType="";
	@Override
	public int ProcessData() {

		InitOrderAndDropFactory();

		return 1;
	}

	public void InitOrderAndDropFactory()
	{
		Vector<Vector<String> > vctReceData;
		if(this.mDataTrunsfer!=null&&!fzType.equals(""))
			vctReceData=this.mDataTrunsfer.GetReceiveData();
		else
			vctReceData=new Vector<Vector<String> >();

		String[] szData=null;
		List<String> lstFzData=new ArrayList<String>();

		if(vctReceData.size()>0)
		{
			for(Vector<String> record:vctReceData)
			{
				if(record.size()>0)
				{
					if(record.get(0).equals(fzType))
					{
						lstFzData.add(record.get(2)+"["+record.get(1)+"]");
					}
				}
			}
		}
		else
		{
			szData=new String[1];
			szData[0]="";
		}


		if(fzType.equals(FZ4))
		{
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData4, lstFzData, true);
			mActParent.processMessage(GDDirectOut2.nFuZhuDownDone3,"");
		}
		else
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData5, lstFzData, true);
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		for(String str:extrData)
		{
			child.add(str);
			fzType=str;
			break;
		}

		vctSendData.add(child);

		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();

		p.sendCmd1=DPProtocol.m_vfxVAG4BDePei_FuZhuZiLiaoXiaZai1;
		p.receCmd0= DPProtocol.m_vfxVAG4BDePei_FuZhuZiLiaoXiaZaiRe0;
		p.receCmd1=DPProtocol.m_vfxVAG4BDePei_FuZhuZiLiaoXiaZaiRe1;

		return p;
	}

}
