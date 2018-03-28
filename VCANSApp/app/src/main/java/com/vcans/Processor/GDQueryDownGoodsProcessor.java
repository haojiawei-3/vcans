package com.vcans.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import android.widget.Toast;
import com.Vcan.activity.R;
import com.Vcan.activity.GDBakModule;
import com.Vcan.activity.GDQuery;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ItemTitleHelper;

/**
 * 综合查询  物料信息下载处理
 * @author vcans
 *
 */
public class GDQueryDownGoodsProcessor extends DownloadProcessor {
    String ModuleId;
    private List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
    public GDQueryDownGoodsProcessor(String moduleId){

        ModuleId=moduleId;
    }

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

        for(String str:extrData){
            child.add(str);}
        child.add(BaseActivity.gUser.getUserName());
        vctSendData.add(child);

        return vctSendData;
    }

    @Override
    public MyProtocol GetProtocol() {

        MyProtocol p=new MyProtocol();

        if (ModuleId.equals(ItemTitleHelper.G1)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_CX121;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe01_CX12Re1;
        }else if (ModuleId.equals(ItemTitleHelper.G2)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_CX121;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe02_CX12Re1;
        }
        else if (ModuleId.equals(ItemTitleHelper.G3)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_CX121;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe03_CX12Re1;
        }
        else if (ModuleId.equals(ItemTitleHelper.G4)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_CX121;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe04_CX12Re1;
        }
        else if (ModuleId.equals(ItemTitleHelper.G5)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_CX121;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe05_CX12Re1;
        } else if (ModuleId.equals(ItemTitleHelper.G6)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_CX121;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe06_CX12Re1;
        } else if (ModuleId.equals(ItemTitleHelper.G7)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_CX121;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe07_CX12Re1;
        } else if (ModuleId.equals(ItemTitleHelper.G8)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_CX121;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_ZonHe08_CX12Re1;
        }
        return p;
    }

}
