package com.vcans.Processor;

import android.content.Intent;

import com.Vcan.activity.DPDetailInfo;
import com.Vcan.activity.R;
import com.Vcan.activity.SplashActivity;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.BakModuleDao;
import com.vcans.dao.ByDao;
import com.vcans.model.BYModel;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.ProtocolCMD;
import com.vcans.tool.ZDYzuhe;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * Created by vcans-1 on 2017-12-19.
 */

public class ByModelUploadProcessor extends UploadProcessor {
    public ByDao ByDao=null;
    private BandleParam mBdParam=new BandleParam();
    List<HashMap<String,Object> > ByModelList=null;
    Vector<Vector<String> > mVctSendData=null;
    private String mModuleId="";

    public ByModelUploadProcessor(String s){
        ByDao=new ByDao();
        mModuleId=s;
    }



    @Override
    public int ProcessData(Vector<String> vctDataId) {
        if (vctDataId!=null) {
            for (int i = 0; i < vctDataId.size(); i++) {
                ByDao.DeleteById(vctDataId.get(i));
            }

        }

        DisplaybyModelInfo();

        if(mDataTrunsfer.isDownloadContinue()){

        }
        else{
            //backFirstActivity();
//            AppManager.getAppManager().finishActivity(DPRZTask31.DPRZTask31);
//            AppManager.getAppManager().finishActivity(DPRZTask32.DPRZTask32);
        }
        return 1;
    }

    public void  DisplaybyModelInfo(){
        ByModelList=ByDao.GetAllModel();
        String[] szField={
                "ZhiDuan01Id",
                "ZhiDuan02Id",
                "ZhiDuan03Id",
                "ZhiDuan04Id",
                "ZhiDuan05Id",
                "ZhiDuan06Id",
                "ZhiDuan07Id",
                "ZhiDuan08Id",
                "ZhiDuan09Id",
                "ZhiDuan10Id",
                "ZhiDuan11Id",
                "ZhiDuan12Id",
                "ZhiDuan13Id",
                "ZhiDuan14Id",
                "ZhiDuan15Id",
                "ZhiDuan16Id",
                "ZhiDuan17Id",
                "ZhiDuan18Id",
                "ZhiDuan19Id",
                "ZhiDuan20Id",
                "ZhiDuan21Id",
                "ZhiDuan22Id",
                "ZhiDuan23Id",
                "ZhiDuan24Id",
                "ZhiDuan25Id",
                "ZhiDuan26Id",
                "TPId"};

        int[] szRId={R.id.tvBYName1v,
                R.id.tvBYName2v,
                R.id.tvBYName3v,
                R.id.tvBYName4v,
                R.id.tvBYName5v,
                R.id.tvBYName6v,
                R.id.tvBYName7v,
                R.id.tvBYName8v,
                R.id.tvBYName9v,
                R.id.tvBYName10v,
                R.id.tvBYName11v,
                R.id.tvBYName12v,
                R.id.tvBYName13v,
                R.id.tvBYName14v,
                R.id.tvBYName15v,
                R.id.tvBYName16v,
                R.id.tvBYName17v,
                R.id.tvBYName18v,
                R.id.tvBYName19v,
                R.id.tvBYName20v,
                R.id.tvBYName21v,
                R.id.tvBYName22v,
                R.id.tvBYName23v,
                R.id.tvBYName24v,
                R.id.tvBYName25v,
                R.id.tvBYName26v,
                R.id.tvInnerId};

        BaseActivity.showList(mActParent,ByModelList,R.layout.dp_rztask32_item,szField,szRId,R.id.lvProdct,R.id.tvPage);

    }


    public void displayDetail(List<HashMap<String,Object> > mapInfo)
    {
        String[] szField={
                "ZhiDuan01Id",
                "ZhiDuan02Id",
                "ZhiDuan03Id",
                "ZhiDuan04Id",
                "ZhiDuan05Id",
                "ZhiDuan06Id",
                "ZhiDuan07Id",
                "ZhiDuan08Id",
                "ZhiDuan09Id",
                "ZhiDuan10Id",
                "ZhiDuan11Id",
                "ZhiDuan12Id",
                "ZhiDuan13Id",
                "ZhiDuan14Id",
                "ZhiDuan15Id",
                "ZhiDuan16Id",
                "ZhiDuan17Id",
                "ZhiDuan18Id",
                "ZhiDuan19Id",
                "ZhiDuan20Id",
                "ZhiDuan21Id",
                "ZhiDuan22Id",
                "ZhiDuan23Id",
                "ZhiDuan24Id",
                "ZhiDuan25Id",
                "ZhiDuan26Id",
                "TPId"};

        int[] szRId={R.id.tvBYName1v,
                R.id.tvBYName2v,
                R.id.tvBYName3v,
                R.id.tvBYName4v,
                R.id.tvBYName5v,
                R.id.tvBYName6v,
                R.id.tvBYName7v,
                R.id.tvBYName8v,
                R.id.tvBYName9v,
                R.id.tvBYName10v,
                R.id.tvBYName11v,
                R.id.tvBYName12v,
                R.id.tvBYName13v,
                R.id.tvBYName14v,
                R.id.tvBYName15v,
                R.id.tvBYName16v,
                R.id.tvBYName17v,
                R.id.tvBYName18v,
                R.id.tvBYName19v,
                R.id.tvBYName20v,
                R.id.tvBYName21v,
                R.id.tvBYName22v,
                R.id.tvBYName23v,
                R.id.tvBYName24v,
                R.id.tvBYName25v,
                R.id.tvBYName26v,
                R.id.tvInnerId};


        mBdParam.dataList=mapInfo;
        mBdParam.szFieldData=szField;
        mBdParam.szRId=szRId;
        mBdParam.rid=R.layout.dp_rztask32_item;

        Intent intent=new Intent(mActParent,DPDetailInfo.class);
        intent.putExtra("data",mBdParam);
        mActParent.startActivity(intent);
    }


    public void SaveInfo(){
        BYModel byModel= ActivityHelper.BYModel;
        ZDYzuhe   txt23=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe23);
        ZDYzuhe   txt24=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe24);
        ZDYzuhe   txt25=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe25);
        ZDYzuhe   txt26=(ZDYzuhe)mActParent.findViewById(R.id.ZDYzuhe26);

        byModel.BYName23v=txt23.GetText();
        byModel.BYName24v=txt24.GetText();
        byModel.BYName25v=txt25.GetText();
        byModel.BYName26v=txt26.GetText();

        if(byModel.BYName23v.equals("")||byModel.BYName24v.equals("")||byModel.BYName25v.equals("")||byModel.BYName26v.equals(""))
        {
            ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.isNUll));
            return ;
        }


        int nRst=ByDao.AddToupei(byModel);
        if(nRst==0)
        {
            ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.datareplace));
            DisplaybyModelInfo();
        }
        else if(nRst<1)
        {
            ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.saveFail));
        }
        else
        {
            ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.saveSuccess));
            DisplaybyModelInfo();
        }
    }

    public void ClearToupeiInfo()
    {
        ByDao.DeleteAll(null);
        DisplaybyModelInfo();
    }

    public void DeleteToupeiInfo(String dataId)
    {
        ByDao.DeleteById(dataId);
        DisplaybyModelInfo();
    }

    @Override
    public Vector<Vector<String>> GetSendData(String[] extrData) {
        if(extrData!=null)
            ByModelList=ByDao.GetTeipeiById(extrData[0]);

        mVctSendData=new Vector<Vector<String> > ();

        for(HashMap<String,Object> mapToupei:ByModelList)
        {
            Vector<String> child= new Vector<String>();

            child.add((String)mapToupei.get("TPId"));
            child.add((String)mapToupei.get("ZhiDuan01Id"));
            child.add((String)mapToupei.get("ZhiDuan02Id"));
            child.add((String)mapToupei.get("ZhiDuan03Id"));
            child.add((String)mapToupei.get("ZhiDuan04Id"));
            child.add((String)mapToupei.get("ZhiDuan05Id"));
            child.add((String)mapToupei.get("ZhiDuan06Id"));
            String  strImage=(String)mapToupei.get("ImgPath");
            if(!strImage.equals("")){
                child.add(ProtocolCMD.FILE_FIELD_FLAG+strImage);
            }else {
                child.add((String)mapToupei.get("ImgPath"));
            }
            child.add((String)mapToupei.get("ZhiDuan07Id"));
            child.add((String)mapToupei.get("ZhiDuan08Id"));
            child.add((String)mapToupei.get("ZhiDuan09Id"));
            child.add((String)mapToupei.get("ZhiDuan10Id"));
            child.add((String)mapToupei.get("GoodsId"));
            child.add((String)mapToupei.get("GoodsDescribe"));
            child.add((String)mapToupei.get("StoreDescribe"));
            child.add((String)mapToupei.get("StoreFlag"));
            child.add((String)mapToupei.get("GNum"));
            child.add((String)mapToupei.get("GPiShu"));
            child.add((String)mapToupei.get("Remark1"));
            child.add((String)mapToupei.get("Remark2"));
            child.add((String)mapToupei.get("Remark3"));
            child.add((String)mapToupei.get("Remark4"));
            child.add((String)mapToupei.get("Remark5"));
            child.add((String)mapToupei.get("ZhiDuan11Id"));
            child.add((String)mapToupei.get("ZhiDuan12Id"));
            child.add((String)mapToupei.get("ZhiDuan13Id"));
            child.add((String)mapToupei.get("ZhiDuan14Id"));
            child.add((String)mapToupei.get("ZhiDuan15Id"));
            child.add((String)mapToupei.get("ZhiDuan16Id"));
            child.add((String)mapToupei.get("ZhiDuan17Id"));
            child.add((String)mapToupei.get("ZhiDuan18Id"));
            child.add((String)mapToupei.get("ZhiDuan19Id"));
            child.add((String)mapToupei.get("ZhiDuan20Id"));
            child.add((String)mapToupei.get("ZhiDuan21Id"));
            child.add((String)mapToupei.get("ZhiDuan22Id"));
            child.add((String)mapToupei.get("ZhiDuan23Id"));
            child.add((String)mapToupei.get("ZhiDuan24Id"));
            child.add((String)mapToupei.get("ZhiDuan25Id"));
            child.add((String)mapToupei.get("ZhiDuan26Id"));
            child.add(BaseActivity.gUser.getUserName());
            child.add(SplashActivity.getProvince());
            child.add(SplashActivity.getCity());
            child.add(SplashActivity.getDistrict());
            child.add(SplashActivity.getStreet());


            mVctSendData.add(child);
        }

        return mVctSendData;
    }



    @Override
    public MyProtocol GetProtocol() {
        MyProtocol p=new MyProtocol();
        if (mModuleId.equals(ItemTitleHelper.K6)) {
            p.sendCmd0= DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06Biao0;
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06Biao1;
            p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06Biao2;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06BiaoRe0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06BiaoRe1;
            p.receCmd3=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06BiaoRe3;
            p.receCmd5=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06BiaoRe5;
        }else if (mModuleId.equals(ItemTitleHelper.K7)) {
            p.sendCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07Biao0;
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07Biao1;
            p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07Biao2;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07BiaoRe0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07BiaoRe1;
            p.receCmd3=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07BiaoRe3;
            p.receCmd5=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07BiaoRe5;
        }else if (mModuleId.equals(ItemTitleHelper.K8)) {
            p.sendCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08Biao0;
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08Biao1;
            p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08Biao2;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08BiaoRe0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08BiaoRe1;
            p.receCmd3=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08BiaoRe3;
            p.receCmd5=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08BiaoRe5;
        }else if (mModuleId.equals(ItemTitleHelper.K9)) {
            p.sendCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09Biao0;
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09Biao1;
            p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09Biao2;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09BiaoRe0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09BiaoRe1;
            p.receCmd3=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09BiaoRe3;
            p.receCmd5=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09BiaoRe5;
        }else if (mModuleId.equals(ItemTitleHelper.K10)) {
            p.sendCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10Biao0;
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10Biao1;
            p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10Biao2;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10BiaoRe0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10BiaoRe1;
            p.receCmd3=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10BiaoRe3;
            p.receCmd5=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10BiaoRe5;
        }
        return p;
    }
}
