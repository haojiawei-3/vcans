package com.Vcan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPRZTaskDownWorkBY1Processor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ZDYzuhe;
import com.vcans.tool.ZDYzuheHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ByView3Activity extends BaseActivity {
    String TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,instant;
    int  scanFlag;
    @Bind(R.id.ZDYzuhe11)
    ZDYzuhe ZDYzuhe11;
    @Bind(R.id.ZDYzuhe12)
    ZDYzuhe ZDYzuhe12;
    @Bind(R.id.ZDYzuhe13)
    ZDYzuhe ZDYzuhe13;
    @Bind(R.id.ZDYzuhe14)
    ZDYzuhe ZDYzuhe14;
    @Bind(R.id.ZDYzuhe15)
    ZDYzuhe ZDYzuhe15;
    @Bind(R.id.ZDYzuhe16)
    ZDYzuhe ZDYzuhe16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_view3);
        ButterKnife.bind(this);
        initData();
        initDataOnClickListener();
    }
    private void initData() {
        this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
        this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
        this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
        TZDYzuhe1= ActivityHelper.BYModel.BYName1v;
        TZDYzuhe2= ActivityHelper.BYModel.BYName2v;
        TZDYzuhe3= ActivityHelper.BYModel.BYName3v;
        TZDYzuhe4= ActivityHelper.BYModel.BYName4v;
        TZDYzuhe5= ActivityHelper.BYModel.BYName5v;
        TZDYzuhe6= ActivityHelper.BYModel.BYName6v;
        TZDYzuhe7= ActivityHelper.BYModel.BYName7v;
        TZDYzuhe8= ActivityHelper.BYModel.BYName8v;
        TZDYzuhe9= ActivityHelper.BYModel.BYName9v;
        TZDYzuhe10= ActivityHelper.BYModel.BYName10v;
        ZDYzuhe11.SetMenu(ActivityHelper.MenuList.get(10));
        ZDYzuhe12.SetMenu(ActivityHelper.MenuList.get(11));
        ZDYzuhe13.SetMenu(ActivityHelper.MenuList.get(12));
        ZDYzuhe14.SetMenu(ActivityHelper.MenuList.get(13));
        ZDYzuhe15.SetMenu(ActivityHelper.MenuList.get(14));
        ZDYzuhe16.SetMenu(ActivityHelper.MenuList.get(15));
        Intent intent = this.getIntent();
        instant= (String)intent.getSerializableExtra("instant");
        if (instant!=null) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    instant(instant);
                }
            }, 500);

        }
        Activityfinish();

    }

    private void initDataOnClickListener() {
        ZDYzuhe11.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=1;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY11();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe12.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=2;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY12();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe13.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=3;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY13();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe14.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=4;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY14();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe15.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=5;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY15();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe16.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=6;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY16();}
            @Override
            public void OnClickListener3() {}
        });


    }

    public void  instant(String s){
        if (s.equals("1")) {
            String[] strings={TZDYzuhe1};
            ZDYzuheHelper.ZDY(ByView3Activity.this,TZDYzuhe1,strings,ByView1Activity.gBakFlag,1);
        }else if (s.equals("2")) {
            String[] strings={TZDYzuhe2,TZDYzuhe1};
            ZDYzuheHelper.ZDY(ByView3Activity.this,TZDYzuhe2,strings,ByView1Activity.gBakFlag,2);
        }else if (s.equals("3")) {
            String[] strings={TZDYzuhe3,TZDYzuhe1,TZDYzuhe2};
            ZDYzuheHelper.ZDY(ByView3Activity.this,TZDYzuhe3,strings,ByView1Activity.gBakFlag,3);
        }else if (s.equals("4")) {
            String[] strings={TZDYzuhe4,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3};
            ZDYzuheHelper.ZDY(ByView3Activity.this,TZDYzuhe4,strings,ByView1Activity.gBakFlag,4);
        }else if (s.equals("5")) {
            String[] strings={TZDYzuhe5,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4};
            ZDYzuheHelper.ZDY(ByView3Activity.this,TZDYzuhe5,strings,ByView1Activity.gBakFlag,5);
        }else if (s.equals("6")) {
            String[] strings={TZDYzuhe6,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5};
            ZDYzuheHelper.ZDY(ByView3Activity.this,TZDYzuhe6,strings,ByView1Activity.gBakFlag,6);
        } else if (s.equals("7")) {
            String[] strings={TZDYzuhe7,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6};
            ZDYzuheHelper.ZDY(ByView3Activity.this,TZDYzuhe7,strings,ByView1Activity.gBakFlag,7);
        }else if (s.equals("8")) {
            String[] strings={TZDYzuhe8,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7};
            ZDYzuheHelper.ZDY(ByView3Activity.this,TZDYzuhe8,strings,ByView1Activity.gBakFlag,8);
        }else if (s.equals("9")) {
            String[] strings={TZDYzuhe9,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8};
            ZDYzuheHelper.ZDY(ByView3Activity.this,TZDYzuhe9,strings,ByView1Activity.gBakFlag,9);
        }else if (s.equals("10")) {
            String[] strings={TZDYzuhe10,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9};
            ZDYzuheHelper.ZDY(ByView3Activity.this,TZDYzuhe10,strings,ByView1Activity.gBakFlag,10);
        }
    }
    private void  ZDY11(){
           String[] strings={ZDYzuhe11.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5};
           ZDYzuheHelper.ZDY(ByView3Activity.this,ZDYzuhe11,strings,ByView1Activity.gBakFlag,11);
    }
    private void  ZDY12(){
           String[] strings={ZDYzuhe12.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,ZDYzuhe11.GetText()};
           ZDYzuheHelper.ZDY(ByView3Activity.this,ZDYzuhe12,strings,ByView1Activity.gBakFlag,12);
    }
    private void  ZDY13(){
           String[] strings={ZDYzuhe13.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,ZDYzuhe11.GetText(),ZDYzuhe12.GetText()};
           ZDYzuheHelper.ZDY(ByView3Activity.this,ZDYzuhe13,strings,ByView1Activity.gBakFlag,13);
    }
    private void  ZDY14(){
           String[] strings={ZDYzuhe14.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,ZDYzuhe11.GetText(),ZDYzuhe12.GetText(),ZDYzuhe13.GetText()};
           ZDYzuheHelper.ZDY(ByView3Activity.this,ZDYzuhe14,strings,ByView1Activity.gBakFlag,14);
    }
    private void  ZDY15(){
           String[] strings={ZDYzuhe15.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,ZDYzuhe11.GetText(),ZDYzuhe12.GetText(),ZDYzuhe13.GetText(),ZDYzuhe14.GetText()};
           ZDYzuheHelper.ZDY(ByView3Activity.this,ZDYzuhe15,strings,ByView1Activity.gBakFlag,15);
    }
    private void  ZDY16(){
           String[] strings={ZDYzuhe16.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,ZDYzuhe11.GetText(),ZDYzuhe12.GetText(),ZDYzuhe13.GetText(),ZDYzuhe14.GetText(),ZDYzuhe15.GetText()};
           ZDYzuheHelper.ZDY(ByView3Activity.this,ZDYzuhe16,strings,ByView1Activity.gBakFlag,16);
    }

    public void onNext()
    {
        if(ZDYzuhe11.GetText().equals("")||ZDYzuhe12.GetText().equals("")||ZDYzuhe13.GetText().equals("")|| ZDYzuhe14.GetText().equals("")||ZDYzuhe15.GetText().equals("")|| ZDYzuhe16.GetText().equals(""))
        {
            ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
            return ;
        }
        ActivityHelper.BYModel.BYName11v=ZDYzuhe11.GetText();
        ActivityHelper.BYModel.BYName12v=ZDYzuhe12.GetText();
        ActivityHelper.BYModel.BYName13v=ZDYzuhe13.GetText();
        ActivityHelper.BYModel.BYName14v=ZDYzuhe14.GetText();
        ActivityHelper.BYModel.BYName15v=ZDYzuhe15.GetText();
        ActivityHelper.BYModel.BYName16v=ZDYzuhe16.GetText();

        Intent intent=new Intent(this,ByView4Activity.class);
        if (ActivityHelper.MenuList.get(15).instant.equals("Y")&&ActivityHelper.MenuList.get(15).strEnabled.equals("Y")) {
            intent.putExtra("instant", "16");
        }else if (ActivityHelper.MenuList.get(14).instant.equals("Y")&&ActivityHelper.MenuList.get(14).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "15");
        }else if (ActivityHelper.MenuList.get(13).instant.equals("Y")&&ActivityHelper.MenuList.get(13).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "14");
        }else if (ActivityHelper.MenuList.get(12).instant.equals("Y")&&ActivityHelper.MenuList.get(12).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "13");
        }else if (ActivityHelper.MenuList.get(11).instant.equals("Y")&&ActivityHelper.MenuList.get(11).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "12");
        }else if (ActivityHelper.MenuList.get(10).instant.equals("Y")&&ActivityHelper.MenuList.get(10).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "11");
        }
//
        startActivity(intent);

    }
    public void  Activityfinish(){
        String s1= ActivityHelper.MenuList.get(10).strEnabled;
        String s2= ActivityHelper.MenuList.get(11).strEnabled;
        String s3= ActivityHelper.MenuList.get(12).strEnabled;
        String s4= ActivityHelper.MenuList.get(13).strEnabled;
        String s5= ActivityHelper.MenuList.get(14).strEnabled;
        String s6= ActivityHelper.MenuList.get(15).strEnabled;
        if (  s1.equals("N")&&s2.equals("N")&&s3.equals("N")&&s4.equals("N")&&s5.equals("N")&&s6.equals("N")) {
            Intent intent=new Intent(this,ByView4Activity.class);
            intent.putExtra("instant", instant);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SCAN_QRCODE_FLAG) {//条码扫描完毕返回
            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getExtras();
                String strRst = bundle.getString("result");
                if (scanFlag == 1) {
                    ZDYzuhe11.SetEditText(strRst);
                    if (ZDYzuhe11.getMenu().instant.equals("Y")) {
                        ZDY11();
                    }
                } else if (scanFlag == 2) {
                    ZDYzuhe12.SetEditText(strRst);
                    if (ZDYzuhe12.getMenu().instant.equals("Y")) {
                        ZDY12();
                    }
                } else if (scanFlag == 3) {
                    ZDYzuhe13.SetEditText(strRst);
                    if (ZDYzuhe13.getMenu().instant.equals("Y")) {
                        ZDY13();
                    }
                } else if (scanFlag == 4) {
                    ZDYzuhe14.SetEditText(strRst);
                    if (ZDYzuhe14.getMenu().instant.equals("Y")) {
                        ZDY14();
                    }
                }else if (scanFlag == 5) {
                    ZDYzuhe15.SetEditText(strRst);
                    if (ZDYzuhe15.getMenu().instant.equals("Y")) {
                        ZDY15();
                    }
                }else if (scanFlag == 6) {
                    ZDYzuhe16.SetEditText(strRst);
                    if (ZDYzuhe16.getMenu().instant.equals("Y")) {
                        ZDY16();
                    }
                }

            }
        }
    }
    @Override
    public void processMessage(int msgId, String msg) {

    }
}
