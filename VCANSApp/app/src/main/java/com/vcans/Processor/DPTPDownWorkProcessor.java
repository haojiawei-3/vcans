package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import android.widget.Spinner;
import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class DPTPDownWorkProcessor extends DownloadProcessor {


	Spinner spiUser;

	@Override
	public int ProcessData() {

		InitDropWorkProcess();

		return 1;
	}

	public void InitDropWorkProcess()
	{
		Vector<Vector<String> > vctReceData;
		if(this.mDataTrunsfer!=null)
			vctReceData=this.mDataTrunsfer.GetReceiveData();
		else
			vctReceData=new Vector<Vector<String> >();

		String[] szData;
		List<String> lstProType=new ArrayList<String>();
		ActivityHelper.lstGongXu.clear();

		if(vctReceData.size()>0)
		{
			for(Vector<String> record:vctReceData)
			{
				if(record.size()>0)
				{
					if(record.get(0).equals("工序"))
					{
						if(record.size()<3)
							continue;

						ActivityHelper.lstGongXu.add(record.get(2)+"["+record.get(1)+"]");

					}
					else if(record.get(0).equals("生产类型"))
					{
						if(record.size()<2)
							continue;

						lstProType.add(record.get(2)+"["+record.get(1)+"]");
					}
				}
			}
		}
		else
		{
			szData=new String[1];
			szData[0]="";
		}


		ActivityHelper.InitDrop(mActParent, R.id.dropProType, lstProType,true);
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		Vector<String> child= new Vector<String>();

		child.add("请求下载辅助资料");


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
