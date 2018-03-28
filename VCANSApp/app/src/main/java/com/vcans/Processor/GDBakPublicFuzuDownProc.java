package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.Vcan.activity.R;
import com.Vcan.activity.GDBakModule;
import com.Vcan.activity.GDBakModule4;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class GDBakPublicFuzuDownProc extends DownloadProcessor {

	public final static String FZ8="备用%s辅助资料8";
	public final static String FZ9="备用%s辅助资料9";
	private String fzType="";
	private String fzFlag="";

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


		if(fzFlag.equals(FZ8))
		{
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData8, lstFzData, true);
			mActParent.processMessage(GDBakModule4.FUZHU8_DONE,"");
		}
		else
			ActivityHelper.InitDrop(mActParent, R.id.dropFuZhuData9, lstFzData, true);
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		for(String str:extrData)
		{
			fzFlag=str;
			fzType=String.format(str,GDBakModule.gBakFlag);

			child.add(fzType);  //fzType 为FZ8、FZ9常量
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
