package com.vcans.Processor;

import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.base.*;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.ZDYzuhe;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**  ByDownWorkBYProcessor
 * Created by vcans-1 on 2017-12-27.
 */

public class ByDownWorkBYProcessor extends DownloadProcessor {
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



    public	ByDownWorkBYProcessor(int ModuleId,String MOKUAI){
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
//                    else if(record.get(0).equals(ActivityHelper.MenuList.get(26).title)&&ActivityHelper.MenuList.get(26).strEnabled.equals("Y"))
//                    {
//
//                        ZDYzuhe27.add(record.get(1));
//                        if (!ActivityHelper.MenuList.get(26).type.equals(ZDYzuhe.TYPE8)) {
//                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe27, ZDYzuhe27,true);
//                        }else {
//                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe27, ZDYzuhe27,true);
//                        }
//
//                    }

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
        child.add(BaseActivity.gUser.getUserName());


        vctSendData.add(child);
        return vctSendData;
    }
    @Override
    public MyProtocol GetProtocol() {
        MyProtocol p=new MyProtocol();
        if(mModuleId==1)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1= DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan01Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan01Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan01Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan01Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan01Re2;
            }

        }else if(mModuleId==2)
        {

            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan02Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan02Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan02Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan02Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan02Re2;
            }
        }
        else if(mModuleId==3)
        {

            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan03Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan03Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan03Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan03Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan03Re2;
            }
        }
        else if(mModuleId==4)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan04Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan04Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan04Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan04Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan04Re2;
            }
        }
        else if(mModuleId==5)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan05Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan05Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan05Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan05Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan05Re2;
            }
        }
        else if(mModuleId==6)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan06Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan06Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan06Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan06Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan06Re2;
            }
        }
        else if(mModuleId==7)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan07Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan07Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan07Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan07Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan07Re2;
            }
        }
        else if(mModuleId==8)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan08Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan08Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan08Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan08Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan08Re2;
            }
        }
        else if(mModuleId==9)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan09Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan09Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan09Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan09Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan09Re2;
            }
        }
        else if(mModuleId==10)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan10Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan10Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan10Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan10Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan10Re2;
            }
        }
        else if(mModuleId==11)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan11Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan11Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan11Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan11Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan11Re2;
            }
        }

        else if(mModuleId==12)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1= DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan12Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan12Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan12Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan12Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan12Re2;
            }
        }

        else if(mModuleId==13)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan131;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan132;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan13Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan13Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan13Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan131;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan132;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan13Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan13Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan13Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan131;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan132;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan13Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan13Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan13Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan131;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan132;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan13Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan13Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan13Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan131;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan132;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan13Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan13Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan13Re2;
            }
        }
        else if(mModuleId==14)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan141;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan142;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan14Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan14Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan14Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan141;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan142;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan14Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan14Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan14Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan141;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan142;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan14Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan14Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan03Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan141;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan142;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan14Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan14Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan14Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan141;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan142;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan14Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan14Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan14Re2;
            }
        }

        else if(mModuleId==15)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan151;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan152;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan15Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan15Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan15Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan151;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan152;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan15Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan15Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan15Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan151;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan152;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan15Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan15Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan15Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan151;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan152;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan15Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan15Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan15Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan151;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan152;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan15Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan15Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan15Re2;
            }
        }
        else if(mModuleId==16)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan161;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan162;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan16Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan16Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan16Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan161;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan162;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan16Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan16Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan16Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan161;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan162;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan16Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan16Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan16Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan161;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan162;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan16Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan16Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan16Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan161;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan162;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan16Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan16Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan16Re2;
            }
        }

        else if(mModuleId==17)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan171;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan172;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan17Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan17Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan17Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan171;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan172;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan17Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan17Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan17Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan171;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan172;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan17Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan17Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan17Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan171;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan172;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan17Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan17Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan17Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan171;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan172;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan17Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan17Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan17Re2;
            }
        }
        else if(mModuleId==18)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan181;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan182;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan18Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan18Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan18Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan181;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan182;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan18Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan18Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan18Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan181;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan182;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan18Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan18Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan18Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan181;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan182;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan18Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan18Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan18Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan181;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan182;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan18Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan18Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan18Re2;
            }
        }

        else if(mModuleId==19)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan191;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan192;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan19Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan19Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan19Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan191;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan192;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan19Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan19Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan19Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan191;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan192;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan19Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan19Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan19Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)){
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan191;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan192;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan19Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan19Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan19Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan191;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan192;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan19Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan19Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan19Re2;
            }
        }
        else if(mModuleId==20)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan201;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan202;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan20Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan20Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan20Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan201;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan202;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan20Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan20Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan20Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan201;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan202;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan20Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan20Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan20Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan201;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan202;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan20Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan20Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan20Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan201;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan202;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan20Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan20Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan20Re2;
            }
        }

        else if(mModuleId==21)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan211;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan212;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan21Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan21Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan21Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan211;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan212;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan21Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan21Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan21Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan211;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan212;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan21Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan21Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan21Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan211;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan212;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan21Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan21Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan21Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan211;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan212;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan21Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan21Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan21Re2;
            }
        }
        else if(mModuleId==22)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan221;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan222;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan22Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan22Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan22Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan221;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan222;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan22Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan22Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan22Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)){
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan221;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan222;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan22Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan22Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan22Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan221;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan222;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan22Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan22Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan22Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan221;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan222;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan22Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan22Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan22Re2;
            }
        }
        else if(mModuleId==23)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan231;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan232;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan23Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan23Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan23Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan231;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan232;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan23Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan23Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan23Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan231;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan232;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan23Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan23Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan23Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan231;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan232;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan23Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan23Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan23Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan231;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan232;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan23Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan23Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan23Re2;

            }
        }
        else if(mModuleId==23)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan231;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan232;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan23Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan23Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan23Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan231;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan232;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan23Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan23Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan23Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan231;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan232;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan23Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan23Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan23Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan231;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan232;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan23Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan23Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan23Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan231;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan232;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan23Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan23Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan23Re2;

            }
        }
        else if(mModuleId==24)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan241;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan242;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan24Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan24Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan24Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan241;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan242;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan24Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan24Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan24Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan241;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan242;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan24Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan24Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan24Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan241;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan242;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan24Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan24Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan24Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan241;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan242;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan24Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan24Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan24Re2;
            }
        }
        else if(mModuleId==25)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan251;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan252;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan25Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan25Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan25Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan251;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan252;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan25Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan25Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan25Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan251;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan252;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan25Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan25Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan25Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan251;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan252;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan25Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan25Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan25Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan251;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan252;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan25Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan25Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan25Re2;
            }
        }
        else if(mModuleId==26)
        {
            if (mModule.equals(ItemTitleHelper.K6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan261;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan262;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan26Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan26Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan26Re2;
            }else if (mModule.equals(ItemTitleHelper.K7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan261;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan262;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan26Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan26Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan26Re2;
            }else if (mModule.equals(ItemTitleHelper.K8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan261;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan262;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan26Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan26Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan26Re2;
            }else if (mModule.equals(ItemTitleHelper.K9)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan261;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan262;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan26Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan26Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan26Re2;
            }else if (mModule.equals(ItemTitleHelper.K10)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan261;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan262;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan26Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan26Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan26Re2;
            }
        }
//        else if(mModuleId==27)
//        {
//            if (mModule.equals(ItemTitleHelper.K1)) {
//                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan271;
//                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan272;
//                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan27Re0;
//                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan27Re1;
//                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan27Re2;
//            }else if (mModule.equals(ItemTitleHelper.K2)) {
//                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan271;
//                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan272;
//                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan27Re0;
//                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan27Re1;
//                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan27Re2;
//            }else if (mModule.equals(ItemTitleHelper.K3)) {
//                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan271;
//                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan272;
//                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan27Re0;
//                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan27Re1;
//                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan27Re2;
//            }else if (mModule.equals(ItemTitleHelper.K4)) {
//                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan271;
//                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan272;
//                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan27Re0;
//                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan27Re1;
//                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan27Re2;
//            }else if (mModule.equals(ItemTitleHelper.K5)) {
//                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan271;
//                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan272;
//                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan27Re0;
//                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan27Re1;
//                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan27Re2;
//            }
//        }


        return p;
    }






}

