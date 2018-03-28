package com.vcans.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.ZDYzuhe;

public class DPRZTaskDownWorkBY1Processor extends DownloadProcessor {
	Vector<String> child;
	Vector<String> Data=new Vector<String>();
	List<String> list=new ArrayList<String>();
	private int mModuleId=0;
	private String mModule="";
	List<String>  ZDYzuhe1=new ArrayList<String>();
	List<String>  ZDYzuhe2=new ArrayList<String>();
	List<String>  ZDYzuhe3=new ArrayList<String>();
	List<String>  ZDYzuhe4=new ArrayList<String>();
	List<String>  ZDYzuhe5=new ArrayList<String>();
	List<String>  ZDYzuhe6=new ArrayList<String>();
	List<String>  ZDYzuhe7=new ArrayList<String>();
	List<String>  ZDYzuhe8=new ArrayList<String>();
	List<String>  ZDYzuhe9=new ArrayList<String>();
	List<String>  ZDYzuhe10=new ArrayList<String>();
	List<String>  ZDYzuhe11=new ArrayList<String>();
	List<String>  ZDYzuhe12=new ArrayList<String>();
	List<String>  ZDYzuhe13=new ArrayList<String>();
	List<String>  ZDYzuhe14=new ArrayList<String>();
	List<String>  ZDYzuhe15=new ArrayList<String>();
	List<String>  ZDYzuhe16=new ArrayList<String>();
	List<String>  ZDYzuhe17=new ArrayList<String>();
	List<String>  ZDYzuhe18=new ArrayList<String>();
	List<String>  ZDYzuhe19=new ArrayList<String>();
	List<String>  ZDYzuhe20=new ArrayList<String>();
	List<String>  ZDYzuhe21=new ArrayList<String>();
	List<String>  ZDYzuhe22=new ArrayList<String>();
	List<String>  ZDYzuhe23=new ArrayList<String>();
	List<String>  ZDYzuhe24=new ArrayList<String>();
	List<String>  ZDYzuhe25=new ArrayList<String>();
	List<String>  ZDYzuhe26=new ArrayList<String>();
	List<String>  ZDYzuhe27=new ArrayList<String>();


	public	DPRZTaskDownWorkBY1Processor(int ModuleId,String MOKUAI){
		mModuleId=ModuleId;
		mModule=MOKUAI;
	}
	@Override
	public int ProcessData() {
		// TODO Auto-generated method stub
		InitDropWorkProcess();
		return 1;
	}

	private void InitDropWorkProcess() {
		Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
		vctReceData=this.mDataTrunsfer.GetReceiveData();
		ActivityHelper.closeStatusDialog();

		if(vctReceData.size()>0)
		{

			for(Vector<String> record:vctReceData)
			{
				if(record.size()>0)
				{
					if(record.get(0).equals(ActivityHelper.MenuList.get(0).title)&&ActivityHelper.MenuList.get(0).strEnabled.equals("Y"))
					{

						ZDYzuhe1.add(record.get(1));
						if (!ActivityHelper.MenuList.get(0).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe1, ZDYzuhe1,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe1, ZDYzuhe1,true);
						}


					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(1).title)&&ActivityHelper.MenuList.get(1).strEnabled.equals("Y"))
					{


						ZDYzuhe2.add(record.get(1));
						if (!ActivityHelper.MenuList.get(1).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe2, ZDYzuhe2,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe2, ZDYzuhe2,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(2).title)&&ActivityHelper.MenuList.get(2).strEnabled.equals("Y"))
					{

						ZDYzuhe3.add(record.get(1));
						if (!ActivityHelper.MenuList.get(2).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe3, ZDYzuhe3,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe3, ZDYzuhe3,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(3).title)&&ActivityHelper.MenuList.get(3).strEnabled.equals("Y"))
					{
						ZDYzuhe4.add(record.get(1));
						if (!ActivityHelper.MenuList.get(3).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe4, ZDYzuhe4,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe4, ZDYzuhe4,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(4).title)&&ActivityHelper.MenuList.get(4).strEnabled.equals("Y"))
					{

						ZDYzuhe5.add(record.get(1));
						if (!ActivityHelper.MenuList.get(4).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe5, ZDYzuhe5,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe5, ZDYzuhe5,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(5).title)&&ActivityHelper.MenuList.get(5).strEnabled.equals("Y"))
					{

						ZDYzuhe6.add(record.get(1));
						if (!ActivityHelper.MenuList.get(5).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe6, ZDYzuhe6,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe6, ZDYzuhe6,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(6).title)&&ActivityHelper.MenuList.get(6).strEnabled.equals("Y"))
					{

						ZDYzuhe7.add(record.get(1));
						if (!ActivityHelper.MenuList.get(6).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe7, ZDYzuhe7,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe7, ZDYzuhe7,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(7).title)&&ActivityHelper.MenuList.get(7).strEnabled.equals("Y"))
					{

						ZDYzuhe8.add(record.get(1));
						if (!ActivityHelper.MenuList.get(7).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe8, ZDYzuhe8,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe8, ZDYzuhe8,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(8).title)&&ActivityHelper.MenuList.get(8).strEnabled.equals("Y"))
					{

						ZDYzuhe9.add(record.get(1));
						if (!ActivityHelper.MenuList.get(8).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe9, ZDYzuhe9,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe9, ZDYzuhe9,true);
						}

					}

					else if(record.get(0).equals(ActivityHelper.MenuList.get(9).title)&&ActivityHelper.MenuList.get(9).strEnabled.equals("Y"))
					{

						ZDYzuhe10.add(record.get(1));
						if (!ActivityHelper.MenuList.get(9).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe10, ZDYzuhe10,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe10, ZDYzuhe10,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(10).title)&&ActivityHelper.MenuList.get(10).strEnabled.equals("Y"))
					{

						ZDYzuhe11.add(record.get(1));
						if (!ActivityHelper.MenuList.get(10).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe11, ZDYzuhe11,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe11, ZDYzuhe11,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(11).title)&&ActivityHelper.MenuList.get(11).strEnabled.equals("Y"))
					{

						ZDYzuhe12.add(record.get(1));
						if (!ActivityHelper.MenuList.get(11).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe12, ZDYzuhe12,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe12, ZDYzuhe12,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(12).title)&&ActivityHelper.MenuList.get(12).strEnabled.equals("Y"))
					{

						ZDYzuhe13.add(record.get(1));
						if (!ActivityHelper.MenuList.get(12).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe13, ZDYzuhe13,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe13, ZDYzuhe13,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(13).title)&&ActivityHelper.MenuList.get(13).strEnabled.equals("Y"))
					{

						ZDYzuhe14.add(record.get(1));
						if (!ActivityHelper.MenuList.get(13).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe14, ZDYzuhe14,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe14, ZDYzuhe14,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(14).title)&&ActivityHelper.MenuList.get(14).strEnabled.equals("Y"))
					{

						ZDYzuhe15.add(record.get(1));
						if (!ActivityHelper.MenuList.get(14).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe15, ZDYzuhe15,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe15, ZDYzuhe15,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(15).title)&&ActivityHelper.MenuList.get(15).strEnabled.equals("Y"))
					{

						ZDYzuhe16.add(record.get(1));
						if (!ActivityHelper.MenuList.get(15).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe16, ZDYzuhe16,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe16, ZDYzuhe16,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(16).title)&&ActivityHelper.MenuList.get(16).strEnabled.equals("Y"))
					{

						ZDYzuhe17.add(record.get(1));
						if (!ActivityHelper.MenuList.get(16).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe17, ZDYzuhe17,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe17, ZDYzuhe17,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(17).title)&&ActivityHelper.MenuList.get(17).strEnabled.equals("Y"))
					{

						ZDYzuhe18.add(record.get(1));
						if (!ActivityHelper.MenuList.get(17).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe18, ZDYzuhe18,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe18, ZDYzuhe18,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(18).title)&&ActivityHelper.MenuList.get(18).strEnabled.equals("Y"))
					{

						ZDYzuhe19.add(record.get(1));
						if (!ActivityHelper.MenuList.get(18).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe19, ZDYzuhe19,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe19, ZDYzuhe19,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(19).title)&&ActivityHelper.MenuList.get(19).strEnabled.equals("Y"))
					{

						ZDYzuhe20.add(record.get(1));
						if (!ActivityHelper.MenuList.get(19).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe20, ZDYzuhe20,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe20, ZDYzuhe20,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(20).title)&&ActivityHelper.MenuList.get(20).strEnabled.equals("Y"))
					{

						ZDYzuhe21.add(record.get(1));
						if (!ActivityHelper.MenuList.get(20).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe21, ZDYzuhe21,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe21, ZDYzuhe21,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(21).title)&&ActivityHelper.MenuList.get(21).strEnabled.equals("Y"))
					{

						ZDYzuhe22.add(record.get(1));
						if (!ActivityHelper.MenuList.get(21).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe22, ZDYzuhe22,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe22, ZDYzuhe22,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(22).title)&&ActivityHelper.MenuList.get(22).strEnabled.equals("Y"))
					{

						ZDYzuhe23.add(record.get(1));
						if (!ActivityHelper.MenuList.get(22).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe23, ZDYzuhe23,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe23, ZDYzuhe23,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(23).title)&&ActivityHelper.MenuList.get(23).strEnabled.equals("Y"))
					{

						ZDYzuhe24.add(record.get(1));
						if (!ActivityHelper.MenuList.get(23).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe24, ZDYzuhe24,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe24, ZDYzuhe24,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(24).title)&&ActivityHelper.MenuList.get(24).strEnabled.equals("Y"))
					{

						ZDYzuhe25.add(record.get(1));
						if (!ActivityHelper.MenuList.get(24).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe25, ZDYzuhe25,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe25, ZDYzuhe25,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(25).title)&&ActivityHelper.MenuList.get(25).strEnabled.equals("Y"))
					{

						ZDYzuhe26.add(record.get(1));
						if (!ActivityHelper.MenuList.get(25).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe26, ZDYzuhe26,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe26, ZDYzuhe26,true);
						}

					}
					else if(record.get(0).equals(ActivityHelper.MenuList.get(26).title)&&ActivityHelper.MenuList.get(26).strEnabled.equals("Y"))
					{

						ZDYzuhe27.add(record.get(1));
						if (!ActivityHelper.MenuList.get(26).type.equals(ZDYzuhe.TYPE8)) {
							ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe27, ZDYzuhe27,true);
						}else {
							ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe27, ZDYzuhe27,true);
						}

					}

				}
			}
		}



	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {
		// TODO Auto-generated method stub
		Vector<Vector<String> > vctSendData=new Vector<Vector<String> > ();

		child= new Vector<String>();

		for(String str:extrData){
			child.add(str);
		}
//			if (BaseActivity.gUser==null) {
//				 Toast.makeText(mActParent, "系统未登录或已退出，稍后重试", 500).show();
//				 
//			}else {
		child.add(BaseActivity.gUser.getUserName());
		//	}

		vctSendData.add(child);
		return vctSendData;
	}
	@Override
	public MyProtocol GetProtocol() {
		MyProtocol p=new MyProtocol();
		if(mModuleId==1)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan011;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan012;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan01Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan01Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan01Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan011;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan012;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan01Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan01Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan01Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan011;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan012;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan01Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan01Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan01Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan011;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan012;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan01Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan01Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan01Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan011;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan012;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan01Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan01Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan01Re2;
			}

		}else if(mModuleId==2)
		{

			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan021;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan022;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan02Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan02Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan02Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan021;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan022;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan02Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan02Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan02Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan021;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan022;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan02Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan02Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan02Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan021;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan022;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan02Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan02Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan02Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan021;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan022;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan02Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan02Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan02Re2;
			}
		}
		else if(mModuleId==3)
		{

			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan031;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan032;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan03Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan03Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan03Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan031;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan032;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan03Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan03Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan03Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan031;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan032;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan03Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan03Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan03Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan031;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan032;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan03Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan03Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan03Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan031;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan032;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan03Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan03Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan03Re2;
			}
		}
		else if(mModuleId==4)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan041;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan042;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan04Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan04Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan04Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan041;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan042;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan04Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan04Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan04Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan041;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan042;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan04Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan04Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan04Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan041;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan042;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan04Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan04Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan04Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan041;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan042;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan04Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan04Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan04Re2;
			}
		}
		else if(mModuleId==5)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan051;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan052;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan05Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan05Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan05Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan051;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan052;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan05Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan05Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan05Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan051;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan052;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan05Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan05Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan05Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan051;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan052;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan05Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan05Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan05Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan051;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan052;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan05Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan05Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan05Re2;
			}
		}
		else if(mModuleId==6)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan061;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan062;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan06Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan06Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan06Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan061;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan062;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan06Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan06Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan06Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan061;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan062;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan06Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan06Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan06Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan061;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan062;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan06Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan06Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan06Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan061;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan062;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan06Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan06Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan06Re2;
			}
		}
		else if(mModuleId==7)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan071;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan072;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan07Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan07Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan07Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan071;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan072;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan07Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan07Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan07Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan071;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan072;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan07Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan07Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan07Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan071;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan072;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan07Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan07Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan07Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan071;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan072;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan07Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan07Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan07Re2;
			}
		}
		else if(mModuleId==8)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan081;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan082;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan08Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan08Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan08Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan081;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan082;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan08Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan08Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan08Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan081;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan082;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan08Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan08Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan08Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan081;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan082;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan08Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan08Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan08Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan081;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan082;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan08Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan08Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan08Re2;
			}
		}
		else if(mModuleId==9)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan091;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan092;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan09Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan09Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan09Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan091;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan092;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan09Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan09Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan09Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan091;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan092;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan09Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan09Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan09Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan091;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan092;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan09Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan09Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan09Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan091;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan092;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan09Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan09Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan09Re2;
			}
		}
		else if(mModuleId==10)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan101;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan102;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan10Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan10Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan10Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan101;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan102;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan10Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan10Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan10Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan101;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan102;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan10Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan10Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan10Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan101;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan102;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan10Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan10Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan10Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan101;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan102;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan10Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan10Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan10Re2;
			}
		}
		else if(mModuleId==11)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan111;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan112;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan11Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan11Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan11Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan111;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan112;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan11Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan11Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan11Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan111;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan112;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan11Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan11Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan11Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan111;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan112;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan11Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan11Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan11Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan111;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan112;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan11Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan11Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan11Re2;
			}
		}

		else if(mModuleId==12)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1= DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan121;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan122;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan12Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan12Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan12Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan121;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan122;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan12Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan12Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan12Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan121;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan122;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan12Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan12Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan12Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan121;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan122;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan12Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan12Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan12Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan121;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan122;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan12Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan12Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan12Re2;
			}
		}

		else if(mModuleId==13)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan131;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan132;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan13Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan13Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan13Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan131;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan132;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan13Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan13Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan13Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan131;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan132;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan13Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan13Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan13Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan131;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan132;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan13Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan13Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan13Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan131;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan132;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan13Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan13Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan13Re2;
			}
		}
		else if(mModuleId==14)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan141;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan142;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan14Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan14Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan14Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan141;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan142;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan14Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan14Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan14Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan141;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan142;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan14Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan14Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan03Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan141;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan142;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan14Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan14Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan14Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan141;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan142;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan14Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan14Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan14Re2;
			}
		}

		else if(mModuleId==15)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan151;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan152;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan15Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan15Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan15Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan151;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan152;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan15Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan15Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan15Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan151;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan152;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan15Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan15Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan15Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan151;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan152;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan15Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan15Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan15Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan151;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan152;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan15Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan15Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan15Re2;
			}
		}
		else if(mModuleId==16)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan161;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan162;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan16Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan16Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan16Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan161;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan162;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan16Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan16Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan16Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan161;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan162;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan16Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan16Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan16Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan161;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan162;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan16Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan16Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan16Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan161;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan162;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan16Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan16Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan16Re2;
			}
		}

		else if(mModuleId==17)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan171;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan172;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan17Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan17Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan17Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan171;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan172;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan17Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan17Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan17Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan171;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan172;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan17Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan17Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan17Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan171;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan172;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan17Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan17Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan17Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan171;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan172;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan17Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan17Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan17Re2;
			}
		}
		else if(mModuleId==18)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan181;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan182;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan18Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan18Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan18Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan181;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan182;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan18Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan18Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan18Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan181;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan182;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan18Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan18Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan18Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan181;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan182;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan18Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan18Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan18Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan181;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan182;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan18Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan18Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan18Re2;
			}
		}

		else if(mModuleId==19)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan191;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan192;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan19Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan19Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan19Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan191;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan192;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan19Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan19Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan19Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan191;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan192;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan19Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan19Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan19Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)){
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan191;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan192;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan19Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan19Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan19Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan191;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan192;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan19Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan19Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan19Re2;
			}
		}
		else if(mModuleId==20)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan201;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan202;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan20Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan20Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan20Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan201;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan202;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan20Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan20Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan20Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan201;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan202;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan20Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan20Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan20Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan201;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan202;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan20Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan20Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan20Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan201;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan202;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan20Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan20Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan20Re2;
			}
		}

		else if(mModuleId==21)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan211;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan212;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan21Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan21Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan21Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan211;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan212;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan21Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan21Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan21Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan211;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan212;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan21Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan21Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan21Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan211;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan212;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan21Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan21Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan21Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan211;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan212;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan21Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan21Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan21Re2;
			}
		}
		else if(mModuleId==22)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan221;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan222;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan22Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan22Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan22Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan221;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan222;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan22Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan22Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan22Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)){
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan221;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan222;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan22Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan22Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan22Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan221;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan222;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan22Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan22Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan22Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan221;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan222;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan22Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan22Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan22Re2;
			}
		}
		else if(mModuleId==23)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan231;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan232;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan23Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan23Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan23Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan231;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan232;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan23Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan23Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan23Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan231;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan232;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan23Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan23Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan23Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan231;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan232;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan23Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan23Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan23Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan231;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan232;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan23Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan23Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan23Re2;

			}
		}
		else if(mModuleId==23)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan231;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan232;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan23Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan23Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan23Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan231;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan232;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan23Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan23Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan23Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan231;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan232;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan23Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan23Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan23Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan231;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan232;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan23Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan23Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan23Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan231;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan232;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan23Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan23Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan23Re2;

			}
		}
		else if(mModuleId==24)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan241;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan242;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan24Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan24Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan24Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan241;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan242;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan24Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan24Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan24Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan241;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan242;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan24Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan24Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan24Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan241;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan242;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan24Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan24Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan24Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan241;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan242;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan24Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan24Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan24Re2;
			}
		}
		else if(mModuleId==25)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan251;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan252;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan25Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan25Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan25Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan251;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan252;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan25Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan25Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan25Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan251;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan252;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan25Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan25Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan25Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan251;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan252;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan25Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan25Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan25Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan251;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan252;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan25Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan25Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan25Re2;
			}
		}
		else if(mModuleId==26)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan261;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan262;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan26Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan26Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan26Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan261;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan262;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan26Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan26Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan26Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan261;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan262;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan26Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan26Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan26Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan261;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan262;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan26Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan26Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan26Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan261;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan262;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan26Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan26Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan26Re2;
			}
		}
		else if(mModuleId==27)
		{
			if (mModule.equals(ItemTitleHelper.K1)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan271;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan272;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan27Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan27Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan27Re2;
			}else if (mModule.equals(ItemTitleHelper.K2)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan271;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan272;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan27Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan27Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan27Re2;
			}else if (mModule.equals(ItemTitleHelper.K3)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan271;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan272;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan27Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan27Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan27Re2;
			}else if (mModule.equals(ItemTitleHelper.K4)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan271;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan272;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan27Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan27Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan27Re2;
			}else if (mModule.equals(ItemTitleHelper.K5)) {
				p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan271;
				p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan272;
				p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan27Re0;
				p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan27Re1;
				p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan27Re2;
			}
		}


		return p;
	}






}
