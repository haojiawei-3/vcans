package com.vcans.Processor;


import android.content.Intent;
import android.widget.Toast;

import com.Vcan.activity.DPDetailInfo;
import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.BandleParam;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ItemTitleHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * Created by vcans-1 on 2017-12-20.
 */

public class ByMateLoadDownWorkBYProcessor extends DownloadProcessor {
    String ModuleId;
    private List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
    private BandleParam mBdParam=new BandleParam();
    public ByMateLoadDownWorkBYProcessor(String moduleId){

        ModuleId=moduleId;
    }

    @Override
    public int ProcessData() {
        initGoodsList();
        return 0;
    }

    public void initGoodsList()
    {
        Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
        if(mDataTrunsfer!=null)
            vctReceData=this.mDataTrunsfer.GetReceiveData();
        else
            vctReceData=new Vector<Vector<String>>();

        mDataList.clear();

        for(Vector<String> record:vctReceData)
        {
            //[物料编号, 物料描述, 存货描述,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五]
            HashMap<String,Object> mapData=new HashMap<String,Object> ();
            if(record.size()!=11){
                Toast.makeText(mActParent, "pc端配置不完整", Toast.LENGTH_SHORT).show();
            }

            if(record.size()==1){
                mapData.put("GoodsId", record.get(0));
            }else if(record.size()==2){
                mapData.put("GoodsId", record.get(0));
                mapData.put("GoodDescribe", record.get(1));
            }else if(record.size()==3){
                mapData.put("GoodsId", record.get(0));
                mapData.put("GoodDescribe", record.get(1));
                mapData.put("StoreDescribe",record.get(2));
            }else if(record.size()==4){
                mapData.put("GoodsId", record.get(0));
                mapData.put("GoodDescribe", record.get(1));
                mapData.put("StoreDescribe",record.get(2));
                mapData.put("StoreFlag", record.get(3));
            }else if(record.size()==5){
                mapData.put("GoodsId", record.get(0));
                mapData.put("GoodDescribe", record.get(1));
                mapData.put("StoreDescribe",record.get(2));
                mapData.put("StoreFlag", record.get(3));
                mapData.put("GPiShu", record.get(4));
            }else if(record.size()==6){
                mapData.put("GoodsId", record.get(0));
                mapData.put("GoodDescribe", record.get(1));
                mapData.put("StoreDescribe",record.get(2));
                mapData.put("StoreFlag", record.get(3));
                mapData.put("GPiShu", record.get(4));
                mapData.put("GNum", record.get(5));
            }else if(record.size()==7){
                mapData.put("GoodsId", record.get(0));
                mapData.put("GoodDescribe", record.get(1));
                mapData.put("StoreDescribe",record.get(2));
                mapData.put("StoreFlag", record.get(3));
                mapData.put("GPiShu", record.get(4));
                mapData.put("GNum", record.get(5));
                mapData.put("Remark1", record.get(6));
            }else if(record.size()==8){
                mapData.put("GoodsId", record.get(0));
                mapData.put("GoodDescribe", record.get(1));
                mapData.put("StoreDescribe",record.get(2));
                mapData.put("StoreFlag", record.get(3));
                mapData.put("GPiShu", record.get(4));
                mapData.put("GNum", record.get(5));
                mapData.put("Remark1", record.get(6));
                mapData.put("Remark2", record.get(7));
            }else if(record.size()==9){
                mapData.put("GoodsId", record.get(0));
                mapData.put("GoodDescribe", record.get(1));
                mapData.put("StoreDescribe",record.get(2));
                mapData.put("StoreFlag", record.get(3));
                mapData.put("GPiShu", record.get(4));
                mapData.put("GNum", record.get(5));
                mapData.put("Remark1", record.get(6));
                mapData.put("Remark2", record.get(7));
                mapData.put("Remark3", record.get(8));
            }else if(record.size()==10){
                mapData.put("GoodsId", record.get(0));
                mapData.put("GoodDescribe", record.get(1));
                mapData.put("StoreDescribe",record.get(2));
                mapData.put("StoreFlag", record.get(3));
                mapData.put("GPiShu", record.get(4));
                mapData.put("GNum", record.get(5));
                mapData.put("Remark1", record.get(6));
                mapData.put("Remark2", record.get(7));
                mapData.put("Remark3", record.get(8));
                mapData.put("Remark4", record.get(9));
            }else if(record.size()==11){
                mapData.put("GoodsId", record.get(0));
                mapData.put("GoodDescribe", record.get(1));
                mapData.put("StoreDescribe",record.get(2));
                mapData.put("StoreFlag", record.get(3));
                mapData.put("GPiShu", record.get(4));
                mapData.put("GNum", record.get(5));
                mapData.put("Remark1", record.get(6));
                mapData.put("Remark2", record.get(7));
                mapData.put("Remark3", record.get(8));
                mapData.put("Remark4", record.get(9));
                mapData.put("Remark5", record.get(10));
            }



//			for(int i=0;i<=11;i++){
//
//				for(int j = 0; j < 11; j++){
//					record.add(String.valueOf(j));
//				}
//				mapData.put("GoodsId", record.get(0));
//				mapData.put("GoodDescribe", record.get(1));
//				mapData.put("StoreDescribe",record.get(2));
//				mapData.put("StoreFlag", record.get(3));
//				mapData.put("GPiShu", record.get(4));
//				mapData.put("GNum", record.get(5));
//				mapData.put("Remark1", record.get(6));
//				mapData.put("Remark2", record.get(7));
//				mapData.put("Remark3", record.get(8));
//				mapData.put("Remark4", record.get(9));
//				mapData.put("Remark5", record.get(10));
//			}


            mDataList.add(mapData);
        }


        String[] szField={"GoodsId","GoodDescribe","StoreDescribe",
                "GPiShu","GNum","Remark1","Remark2","Remark3","Remark4","Remark5"};

        int[] szRId={R.id.tvGoodsId,R.id.tvGoodsDescribe,R.id.tvStoreDescribe,R.id.tvGPiShu,R.id.tvGNum
                ,R.id.tvRemark1,R.id.tvRemark2,R.id.tvRemark3,R.id.tvRemark4,R.id.tvRemark5};


        BaseActivity.showList(mActParent,
                mDataList,
                R.layout.gd_directout_goodsitem_detail,
                szField,
                szRId,
                R.id.lvProdct,
                R.id.tvPage);
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
        if (ModuleId.equals(ItemTitleHelper.K6)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan1;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuanRe0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuanRe1;
        }else if (ModuleId.equals(ItemTitleHelper.K7)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan1;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuanRe0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuanRe1;
        }
        else if (ModuleId.equals(ItemTitleHelper.K8)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan1;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuanRe0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuanRe1;
        }
        else if (ModuleId.equals(ItemTitleHelper.K9)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan1;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuanRe0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuanRe1;
        }
        else if (ModuleId.equals(ItemTitleHelper.K10)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan1;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuanRe0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuanRe1;
        }
        return p;
    }
}
