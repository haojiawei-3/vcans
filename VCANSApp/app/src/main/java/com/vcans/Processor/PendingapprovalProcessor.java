package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import android.util.Log;

import com.vcans.Protocol.DPProtocol;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

public class PendingapprovalProcessor extends DownloadProcessor {

	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
	private BandleParam mBdParam=new BandleParam();

	@Override
	public int ProcessData() {

		initGoodsList();

		return 1;
	}

	public void initGoodsList()
	{
		Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
		if(mDataTrunsfer!=null)
			vctReceData=this.mDataTrunsfer.GetReceiveData();
		ArrayList<String> arrayList=new ArrayList<String>();
		for (int i = 0; i < vctReceData.size(); i++) {
			Vector<String> data = vctReceData.get(i);
			arrayList.add(data.get(1));
		}
		ActivityHelper.dwsp= arrayList.get(0);
		Log.e("TAG", "下载来的数据"+arrayList.get(0));
		ActivityHelper.dwyd= arrayList.get(1);
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String> > vctSendData=new Vector<Vector<String>>();

		Vector<String> child= new Vector<String>();

		//child.add(ActivityHelper.gToupei.strOutNotifyId);
		child.add(BaseActivity.gUser.getUserName());

		vctSendData.add(child);
		System.out.println(vctSendData);
		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();
		//信息数量红点下载
		p.sendCmd1= DPProtocol.m_VCANSAPP_XINXIZHONXIN_XXXIAZAI_1FZ1;
		p.sendCmd2=DPProtocol.m_VCANSAPP_XINXIZHONXIN_XXXIAZAI_1FZ2;
		p.receCmd0=DPProtocol.m_VCANSAPP_XINXIZHONXIN_XXXIAZAI_1FZRe0;
		p.receCmd1=DPProtocol.m_VCANSAPP_XINXIZHONXIN_XXXIAZAI_1FZRe1;
		p.receCmd2=DPProtocol.m_VCANSAPP_XINXIZHONXIN_XXXIAZAI_1FZRe2;
		return p;
	}

}
