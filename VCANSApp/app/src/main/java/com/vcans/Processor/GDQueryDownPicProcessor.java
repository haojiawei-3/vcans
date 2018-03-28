package com.vcans.Processor;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.dao.DBHelper;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * Created by vcans-1 on 2018-01-02.
 */

public class GDQueryDownPicProcessor extends DownloadProcessor {

    String ModuleId;
    private Bitmap[] szBitmap;
    Bitmap bitmap;

    SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
    private List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
    Vector<Vector<String> > vctReceData=new Vector<Vector<String> > ();
    public GDQueryDownPicProcessor(String moduleId){

        ModuleId=moduleId;
    }
    @Override
    public int ProcessData() {
        vctReceData=this.mDataTrunsfer.GetReceiveData();

        List<byte[]> imgList=mDataTrunsfer.getFileByteList();
        szBitmap=new Bitmap[vctReceData.size()];
        for(int i=0;i<imgList.size();i++){
            HashMap<String,Object> mapYpInfo=new HashMap<String,Object>();
                if (imgList.size()==0) {
                    bitmap=BitmapFactory.decodeResource (mActParent.getResources(), R.drawable.no_img);
                    mapYpInfo.put("images",bitmap);
                }else {
                    byte[] szBuf=imgList.get(0);
                    if(szBuf!=null){
                        bitmap= Bytes2Bimap(szBuf);// ActivityHelper.bitmapToFile(bitmap);
                         }
                    else {
                        bitmap = BitmapFactory.decodeResource(mActParent.getResources(), R.drawable.no_img);
                    }
                    mapYpInfo.put("images",bitmap);
                }
                szBitmap[i]=bitmap;
                ActivityHelper.DataList.add(mapYpInfo); //saveBitmap2file
        }
        mActParent.processMessage(1000,"");
        if(mDataTrunsfer.isDownloadContinue()){
            // Log.e("TAG", "继续下载");

        }
        else{
            mActParent.processMessage(200,ModuleId);  //扩展是从哪个模块来
        }
        return 0;
    }

    public void initGoodsList(){

    }

    private Bitmap Bytes2Bimap(byte[] b){
        if(b.length!=0){
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        }
        else {
            return null;
        }
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
            p.sendCmd1= DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe01_CX121;
            p.sendCmd2= DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe01_CX122;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe01_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe01_CX12Re1;
            p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe01_CX12Re2;
        }else if (ModuleId.equals(ItemTitleHelper.G2)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe02_CX121;
            p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe02_CX122;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe02_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe02_CX12Re1;
            p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe02_CX12Re2;
        }
        else if (ModuleId.equals(ItemTitleHelper.G3)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe03_CX121;
            p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe03_CX122;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe03_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe03_CX12Re1;
            p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe03_CX12Re2;
        }
        else if (ModuleId.equals(ItemTitleHelper.G4)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe04_CX121;
            p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe04_CX122;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe04_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe04_CX12Re1;
            p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe04_CX12Re2;
        }
        else if (ModuleId.equals(ItemTitleHelper.G5)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe05_CX121;
            p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe05_CX122;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe05_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe05_CX12Re1;
            p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe05_CX12Re2;
        }
        else if (ModuleId.equals(ItemTitleHelper.G6)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe06_CX121;
            p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe06_CX122;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe06_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe06_CX12Re1;
            p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe06_CX12Re2;
        }
        else if (ModuleId.equals(ItemTitleHelper.G7)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe07_CX121;
            p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe07_CX122;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe07_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe07_CX12Re1;
            p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe07_CX12Re2;
        }
        else if (ModuleId.equals(ItemTitleHelper.G8)) {
            p.sendCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe08_CX121;
            p.sendCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe08_CX122;
            p.receCmd0=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe08_CX12Re0;
            p.receCmd1=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe08_CX12Re1;
            p.receCmd2=DPProtocol.m_vfxVAG62VCANSBiaoZhun_PZonHe08_CX12Re2;
        }
        return p;
    }

}
