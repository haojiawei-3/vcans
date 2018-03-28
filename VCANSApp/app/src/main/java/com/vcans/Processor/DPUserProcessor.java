package com.vcans.Processor;

import java.util.Vector;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;

public class DPUserProcessor extends DownloadProcessor {

	@Override
	public int ProcessData() {

		InitDropUser();

		return 1;
	}

	public void InitDropUser()
	{
		Vector<Vector<String> > vctReceData;
		if(this.mDataTrunsfer!=null)
			vctReceData=this.mDataTrunsfer.GetReceiveData();
		else
			vctReceData=new Vector<Vector<String> >();

		String[] szData;
		if(vctReceData.size()>0)
		{
			szData=new String[vctReceData.size()];

			int i=0;
			for(Vector<String> record:vctReceData)
			{
				if(record.size()>0)
					szData[i++]=record.get(0);
			}
		}
		else
		{
			szData=new String[1];
			szData[0]="";
		}



		ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(mActParent,android.R.layout.simple_spinner_item,szData);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spiUser=(Spinner)mActParent.findViewById(R.id.dropUser);
		spiUser.setAdapter(dataAdapter);

		spiUser.setOnItemSelectedListener(new OnItemSelectedListener(){

			public void onItemSelected(AdapterView<?> arg0, View arg1,
									   int arg2, long arg3) {
				TextView tv = (TextView)arg1;
				if(tv!=null)
				{
					tv.setTextColor(Color.BLACK);    //设置颜色

					//tv.setTextSize(12.0f);    //设置大小

					tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL);   //设置居中
				}

			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		mActParent.processMessage(11,"");
	}

	@Override
	public Vector<Vector<String> > GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();
		Vector<String> child= new Vector<String>();
		child.add("请求下载用户信息");
		vctSendData.add(child);

		return vctSendData;

	}

	@Override
	public MyProtocol GetProtocol() {
		// TODO Auto-generated method stub
		MyProtocol p=new MyProtocol();
		p.sendCmd1=DPProtocol.m_vfxVAG_DengLuXinXiXiaZai1;
		p.sendCmd2= DPProtocol.m_vfxVAG_DengLuXinXiXiaZai2;
		p.receCmd0=DPProtocol.m_vfxVAG_DengLuXinXiXiaZaiRe0;
		p.receCmd1=DPProtocol.m_vfxVAG_DengLuXinXiXiaZaiRe1;

		return p;
	}


}
