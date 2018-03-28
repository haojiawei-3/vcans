package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import android.graphics.Color;
import android.widget.EditText;
import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class DPPIDownOrderFactoryProcessor extends DownloadProcessor {

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
					if(record.get(0).equals("工厂"))
					{
						if(record.size()>2)
							lstData.add(record.get(2)+"["+record.get(1)+"]");
					}
					else if(record.get(0).equals("花型颜色"))
					{
						String flower="",strColor="";
						flower=record.get(1);
						strColor=record.get(2);

						ActivityHelper.lstFlowerAndColor.add(flower+"|"+strColor);
					}
					else if(record.get(0).equals("公司订单号"))
					{
						if(record.size()>1)
						{
							EditText txtCompanyOrderId=(EditText)mActParent.findViewById(R.id.txtCompanyOrder);
							txtCompanyOrderId.setText(record.get(1));
							EditText txtRZPlanTemp=(EditText)mActParent.findViewById(R.id.txtRZPlanId);
							txtRZPlanTemp.setEnabled(false);
							txtCompanyOrderId.setEnabled(false);
							txtCompanyOrderId.setBackgroundColor(Color.GRAY);
						}
					}
					/*
					else if(record.get(0).equals("品检状态"))
					{
						ActivityHelper.lstCheckStatus.add(record.get(2)+"["+record.get(1)+"]");
					}
					*/
				}
			}

		}
		else
		{
			szData=new String[1];
			szData[0]="";
		}


		ActivityHelper.InitDrop(mActParent, R.id.dropRZFactoryId, lstData,false);

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
