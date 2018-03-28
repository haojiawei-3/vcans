package com.vcans.Processor;


import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.ZDYzuhe;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by vcans-1 on 2017-12-26.
 */

public class GDQueryProcessor extends DownloadProcessor{
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

    public  GDQueryProcessor(int ModuleId,String MOKUAI){
        mModuleId=ModuleId;
        mModule=MOKUAI;
    }
    @Override
    public int ProcessData() {
        InitDropWorkProcess();
        return 1;
    }

    public  void  InitDropWorkProcess() {
        Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
        vctReceData=this.mDataTrunsfer.GetReceiveData();
        ActivityHelper.closeStatusDialog();

        if (vctReceData.size() > 0) {

            for (Vector<String> record : vctReceData) {
                if (record.size() > 0) {
                    if (record.get(0).equals(ActivityHelper.GDQueryMenuList.get(0).title) && ActivityHelper.GDQueryMenuList.get(0).strEnabled.equals("Y")) {

                        ZDYzuhe1.add(record.get(1));
                        if (!ActivityHelper.GDQueryMenuList.get(0).type.equals(ZDYzuhe.TYPE8)) {
                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe1, ZDYzuhe1, true);
                        } else {
                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe1, ZDYzuhe1, true);
                        }


                    } else if (record.get(0).equals(ActivityHelper.GDQueryMenuList.get(1).title) && ActivityHelper.GDQueryMenuList.get(1).strEnabled.equals("Y")) {


                        ZDYzuhe2.add(record.get(1));
                        if (!ActivityHelper.GDQueryMenuList.get(1).type.equals(ZDYzuhe.TYPE8)) {
                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe2, ZDYzuhe2, true);
                        } else {
                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe2, ZDYzuhe2, true);
                        }

                    } else if (record.get(0).equals(ActivityHelper.GDQueryMenuList.get(2).title) && ActivityHelper.GDQueryMenuList.get(2).strEnabled.equals("Y")) {

                        ZDYzuhe3.add(record.get(1));
                        if (!ActivityHelper.GDQueryMenuList.get(2).type.equals(ZDYzuhe.TYPE8)) {
                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe3, ZDYzuhe3, true);
                        } else {
                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe3, ZDYzuhe3, true);
                        }

                    } else if (record.get(0).equals(ActivityHelper.GDQueryMenuList.get(3).title) && ActivityHelper.GDQueryMenuList.get(3).strEnabled.equals("Y")) {
                        ZDYzuhe4.add(record.get(1));
                        if (!ActivityHelper.GDQueryMenuList.get(3).type.equals(ZDYzuhe.TYPE8)) {
                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe4, ZDYzuhe4, true);
                        } else {
                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe4, ZDYzuhe4, true);
                        }

                    } else if (record.get(0).equals(ActivityHelper.GDQueryMenuList.get(4).title) && ActivityHelper.GDQueryMenuList.get(4).strEnabled.equals("Y")) {

                        ZDYzuhe5.add(record.get(1));
                        if (!ActivityHelper.GDQueryMenuList.get(4).type.equals(ZDYzuhe.TYPE8)) {
                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe5, ZDYzuhe5, true);
                        } else {
                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe5, ZDYzuhe5, true);
                        }

                    } else if (record.get(0).equals(ActivityHelper.GDQueryMenuList.get(5).title) && ActivityHelper.GDQueryMenuList.get(5).strEnabled.equals("Y")) {

                        ZDYzuhe6.add(record.get(1));
                        if (!ActivityHelper.GDQueryMenuList.get(5).type.equals(ZDYzuhe.TYPE8)) {
                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe6, ZDYzuhe6, true);
                        } else {
                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe6, ZDYzuhe6, true);
                        }

                    } else if (record.get(0).equals(ActivityHelper.GDQueryMenuList.get(6).title) && ActivityHelper.GDQueryMenuList.get(6).strEnabled.equals("Y")) {

                        ZDYzuhe7.add(record.get(1));
                        if (!ActivityHelper.GDQueryMenuList.get(6).type.equals(ZDYzuhe.TYPE8)) {
                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe7, ZDYzuhe7, true);
                        } else {
                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe7, ZDYzuhe7, true);
                        }

                    } else if (record.get(0).equals(ActivityHelper.GDQueryMenuList.get(7).title) && ActivityHelper.GDQueryMenuList.get(7).strEnabled.equals("Y")) {

                        ZDYzuhe8.add(record.get(1));
                        if (!ActivityHelper.GDQueryMenuList.get(7).type.equals(ZDYzuhe.TYPE8)) {
                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe8, ZDYzuhe8, true);
                        } else {
                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe8, ZDYzuhe8, true);
                        }

                    } else if (record.get(0).equals(ActivityHelper.GDQueryMenuList.get(8).title) && ActivityHelper.GDQueryMenuList.get(8).strEnabled.equals("Y")) {

                        ZDYzuhe9.add(record.get(1));
                        if (!ActivityHelper.GDQueryMenuList.get(8).type.equals(ZDYzuhe.TYPE8)) {
                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe9, ZDYzuhe9, true);
                        } else {
                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe9, ZDYzuhe9, true);
                        }

                    } else if (record.get(0).equals(ActivityHelper.GDQueryMenuList.get(9).title) && ActivityHelper.GDQueryMenuList.get(9).strEnabled.equals("Y")) {

                        ZDYzuhe10.add(record.get(1));
                        if (!ActivityHelper.GDQueryMenuList.get(9).type.equals(ZDYzuhe.TYPE8)) {
                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe10, ZDYzuhe10, true);
                        } else {
                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe10, ZDYzuhe10, true);
                        }

                    } else if (record.get(0).equals(ActivityHelper.GDQueryMenuList.get(10).title) && ActivityHelper.GDQueryMenuList.get(10).strEnabled.equals("Y")) {

                        ZDYzuhe11.add(record.get(1));
                        if (!ActivityHelper.GDQueryMenuList.get(10).type.equals(ZDYzuhe.TYPE8)) {
                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe11, ZDYzuhe11, true);
                        } else {
                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe11, ZDYzuhe11, true);
                        }

                    } else if (record.get(0).equals(ActivityHelper.GDQueryMenuList.get(11).title) && ActivityHelper.GDQueryMenuList.get(11).strEnabled.equals("Y")) {

                        ZDYzuhe12.add(record.get(1));
                        if (!ActivityHelper.GDQueryMenuList.get(11).type.equals(ZDYzuhe.TYPE8)) {
                            ActivityHelper.InitDrop2(mActParent, R.id.ZDYzuhe12, ZDYzuhe12, true);
                        } else {
                            ActivityHelper.InitDrop1(mActParent, R.id.ZDYzuhe12, ZDYzuhe12, true);
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
        child.add(BaseActivity.gUser.getUserName());
        vctSendData.add(child);
        return vctSendData;
    }

    @Override
    public MyProtocol GetProtocol() {
        MyProtocol p=new MyProtocol();
        if(mModuleId==1)
        {
            if (mModule.equals(ItemTitleHelper.G1)) {
                p.sendCmd1= DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan01Re2;
            }else if (mModule.equals(ItemTitleHelper.G2)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan01Re2;
            }else if (mModule.equals(ItemTitleHelper.G3)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan01Re2;
            }else if (mModule.equals(ItemTitleHelper.G4)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan01Re2;
            }else if (mModule.equals(ItemTitleHelper.G5)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan01Re2;
            }else if (mModule.equals(ItemTitleHelper.G6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan01Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan01Re2;
            }
 else if (mModule.equals(ItemTitleHelper.G8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan011;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan012;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan01Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan01Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan01Re2;
            }

        }else  if (mModuleId==2){
            if (mModule.equals(ItemTitleHelper.G1)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan02Re2;
            }else if (mModule.equals(ItemTitleHelper.G2)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan02Re2;
            }else if (mModule.equals(ItemTitleHelper.G3)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan02Re2;
            }else if (mModule.equals(ItemTitleHelper.G4)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan02Re2;
            }else if (mModule.equals(ItemTitleHelper.G5)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan02Re2;
            }else if (mModule.equals(ItemTitleHelper.G6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan02Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan02Re2;
            }
 else if (mModule.equals(ItemTitleHelper.G8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan021;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan022;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan02Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan02Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan02Re2;
            }
        }else  if (mModuleId==3){
            if (mModule.equals(ItemTitleHelper.G1)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan02Re2;
            }else if (mModule.equals(ItemTitleHelper.G2)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan03Re2;
            }else if (mModule.equals(ItemTitleHelper.G3)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan03Re2;
            }else if (mModule.equals(ItemTitleHelper.G4)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan03Re2;
            }else if (mModule.equals(ItemTitleHelper.G5)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan03Re2;
            }else if (mModule.equals(ItemTitleHelper.G6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan03Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan03Re2;
            }
 else if (mModule.equals(ItemTitleHelper.G8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan031;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan032;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan03Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan03Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan03Re2;
            }
        }else  if (mModuleId==4){
            if (mModule.equals(ItemTitleHelper.G1)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan04Re2;
            }else if (mModule.equals(ItemTitleHelper.G2)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan04Re2;
            }else if (mModule.equals(ItemTitleHelper.G3)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan04Re2;
            }else if (mModule.equals(ItemTitleHelper.G4)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan04Re2;
            }else if (mModule.equals(ItemTitleHelper.G5)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan04Re2;
            }else if (mModule.equals(ItemTitleHelper.G6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan04Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan04Re2;
            }
 else if (mModule.equals(ItemTitleHelper.G8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan041;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan042;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan04Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan04Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan04Re2;
            }
        }else  if (mModuleId==5){
            if (mModule.equals(ItemTitleHelper.G1)) {
                p.sendCmd1= DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan05Re2;
            }else if (mModule.equals(ItemTitleHelper.G2)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan05Re2;
            }else if (mModule.equals(ItemTitleHelper.G3)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan05Re2;
            }else if (mModule.equals(ItemTitleHelper.G4)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan05Re2;
            }else if (mModule.equals(ItemTitleHelper.G5)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan05Re2;
            }else if (mModule.equals(ItemTitleHelper.G6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan05Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan05Re2;
            }
 else if (mModule.equals(ItemTitleHelper.G8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan051;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan052;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan05Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan05Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan05Re2;
            }
        }else  if (mModuleId==6){
            if (mModule.equals(ItemTitleHelper.G1)) {
                p.sendCmd1= DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan06Re2;
            }else if (mModule.equals(ItemTitleHelper.G2)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan06Re2;
            }else if (mModule.equals(ItemTitleHelper.G3)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan06Re2;
            }else if (mModule.equals(ItemTitleHelper.K4)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan06Re2;
            }else if (mModule.equals(ItemTitleHelper.G5)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan06Re2;
            }else if (mModule.equals(ItemTitleHelper.G6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan06Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan06Re2;
            }
 else if (mModule.equals(ItemTitleHelper.G8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan061;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan062;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan06Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan06Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan06Re2;
            }
        }else  if (mModuleId==7){
            if (mModule.equals(ItemTitleHelper.G1)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan07Re2;
            }else if (mModule.equals(ItemTitleHelper.G2)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan07Re2;
            }else if (mModule.equals(ItemTitleHelper.G3)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan07Re2;
            }else if (mModule.equals(ItemTitleHelper.G4)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan07Re2;
            }else if (mModule.equals(ItemTitleHelper.G5)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan07Re2;
            }else if (mModule.equals(ItemTitleHelper.G6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan07Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan07Re2;
            }
 else if (mModule.equals(ItemTitleHelper.G8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan071;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan072;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan07Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan07Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan07Re2;
            }
        }else  if (mModuleId==8){
            if (mModule.equals(ItemTitleHelper.G1)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan08Re2;
            }else if (mModule.equals(ItemTitleHelper.G2)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan08Re2;
            }else if (mModule.equals(ItemTitleHelper.G3)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan08Re2;
            }else if (mModule.equals(ItemTitleHelper.G4)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan08Re2;
            }else if (mModule.equals(ItemTitleHelper.G5)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan08Re2;
            }else if (mModule.equals(ItemTitleHelper.G6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan08Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan08Re2;
            }
 else if (mModule.equals(ItemTitleHelper.G8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan081;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan082;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan08Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan08Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan08Re2;
            }
        }else  if (mModuleId==9){
            if (mModule.equals(ItemTitleHelper.G1)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan09Re2;
            }else if (mModule.equals(ItemTitleHelper.G2)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan09Re2;
            }else if (mModule.equals(ItemTitleHelper.G3)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan09Re2;
            }else if (mModule.equals(ItemTitleHelper.G4)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan09Re2;
            }else if (mModule.equals(ItemTitleHelper.G5)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan09Re2;
            }else if (mModule.equals(ItemTitleHelper.G6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan09Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan09Re2;
            }
 else if (mModule.equals(ItemTitleHelper.G8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan091;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan092;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan09Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan09Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan09Re2;
            }
        }else  if (mModuleId==10){
            if (mModule.equals(ItemTitleHelper.G1)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan10Re2;
            }else if (mModule.equals(ItemTitleHelper.G2)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan10Re2;
            }else if (mModule.equals(ItemTitleHelper.G3)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan10Re2;
            }else if (mModule.equals(ItemTitleHelper.G4)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan10Re2;
            }else if (mModule.equals(ItemTitleHelper.G5)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan10Re2;
            }else if (mModule.equals(ItemTitleHelper.G6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan10Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan10Re2;
            }
 else if (mModule.equals(ItemTitleHelper.G8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan101;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan102;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan10Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan10Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan10Re2;
            }
        }else  if (mModuleId==11){
            if (mModule.equals(ItemTitleHelper.G1)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan11Re2;
            }else if (mModule.equals(ItemTitleHelper.G2)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan11Re2;
            }else if (mModule.equals(ItemTitleHelper.G3)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan11Re2;
            }else if (mModule.equals(ItemTitleHelper.G4)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan11Re2;
            }else if (mModule.equals(ItemTitleHelper.G5)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan11Re2;
            }else if (mModule.equals(ItemTitleHelper.G6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan11Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan11Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan111;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan112;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan11Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan11Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan11Re2;
            }
        }else  if (mModuleId==12){
            if (mModule.equals(ItemTitleHelper.G1)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan12Re2;
            }else if (mModule.equals(ItemTitleHelper.G2)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan12Re2;
            }else if (mModule.equals(ItemTitleHelper.G3)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan12Re2;
            }else if (mModule.equals(ItemTitleHelper.G4)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan12Re2;
            }else if (mModule.equals(ItemTitleHelper.G5)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan12Re2;
            }else if (mModule.equals(ItemTitleHelper.G6)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan12Re2;
            } else if (mModule.equals(ItemTitleHelper.G7)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan12Re2;
            }
            else if (mModule.equals(ItemTitleHelper.G8)) {
                p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan121;
                p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan122;
                p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan12Re0;
                p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan12Re1;
                p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan12Re2;
            }
        }
        return p;
    }
}
