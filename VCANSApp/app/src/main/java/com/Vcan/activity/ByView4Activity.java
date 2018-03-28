package com.Vcan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.vcans.Processor.BaseActivity;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ZDYzuhe;
import com.vcans.tool.ZDYzuheHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ByView4Activity extends BaseActivity {
    String TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,instant;
    int  scanFlag;
    public static String gBakFlag="";
    @Bind(R.id.ZDYzuhe17)
    ZDYzuhe ZDYzuhe17;
    @Bind(R.id.ZDYzuhe18)
    ZDYzuhe ZDYzuhe18;
    @Bind(R.id.ZDYzuhe19)
    ZDYzuhe ZDYzuhe19;
    @Bind(R.id.ZDYzuhe20)
    ZDYzuhe ZDYzuhe20;
    @Bind(R.id.ZDYzuhe21)
    ZDYzuhe ZDYzuhe21;
    @Bind(R.id.ZDYzuhe22)
    ZDYzuhe ZDYzuhe22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_view4);
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
        TZDYzuhe11= ActivityHelper.BYModel.BYName11v;
        TZDYzuhe12= ActivityHelper.BYModel.BYName12v;
        TZDYzuhe13= ActivityHelper.BYModel.BYName13v;
        TZDYzuhe14= ActivityHelper.BYModel.BYName14v;
        TZDYzuhe15= ActivityHelper.BYModel.BYName15v;
        TZDYzuhe16= ActivityHelper.BYModel.BYName16v;
        ZDYzuhe17.SetMenu(ActivityHelper.MenuList.get(16));
        ZDYzuhe18.SetMenu(ActivityHelper.MenuList.get(17));
        ZDYzuhe19.SetMenu(ActivityHelper.MenuList.get(18));
        ZDYzuhe20.SetMenu(ActivityHelper.MenuList.get(19));
        ZDYzuhe21.SetMenu(ActivityHelper.MenuList.get(20));
        ZDYzuhe22.SetMenu(ActivityHelper.MenuList.get(21));

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
        ZDYzuhe17.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=1;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY17();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe18.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=2;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY18();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe19.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=3;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY19();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe20.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=4;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY20();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe21.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=5;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY21();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe22.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=6;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY22();}
            @Override
            public void OnClickListener3() {}
        });

    }

    public void  Activityfinish(){
        String s1= ActivityHelper.MenuList.get(16).strEnabled;
        String s2= ActivityHelper.MenuList.get(17).strEnabled;
        String s3= ActivityHelper.MenuList.get(18).strEnabled;
        String s4= ActivityHelper.MenuList.get(19).strEnabled;
        String s5= ActivityHelper.MenuList.get(20).strEnabled;
        String s6= ActivityHelper.MenuList.get(21).strEnabled;
        if (  s1.equals("N")&&s2.equals("N")&&s3.equals("N")&&s4.equals("N")&&s5.equals("N")&&s6.equals("N")) {
            Intent intent=new Intent(this,ByView4Activity.class);
            intent.putExtra("instant", instant);
            startActivity(intent);
            finish();
        }
    }


    public void  instant(String s){
        if (s.equals("1")) {
            String[] strings={TZDYzuhe1};
            ZDYzuheHelper.ZDY(this,TZDYzuhe1,strings,ByView1Activity.gBakFlag,1);
        }else if (s.equals("2")) {
            String[] strings={TZDYzuhe2,TZDYzuhe1};
            ZDYzuheHelper.ZDY(this,TZDYzuhe2,strings,ByView1Activity.gBakFlag,2);
        }else if (s.equals("3")) {
            String[] strings={TZDYzuhe3,TZDYzuhe1,TZDYzuhe2};
            ZDYzuheHelper.ZDY(this,TZDYzuhe3,strings,ByView1Activity.gBakFlag,3);
        }else if (s.equals("4")) {
            String[] strings={TZDYzuhe4,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3};
            ZDYzuheHelper.ZDY(this,TZDYzuhe4,strings,ByView1Activity.gBakFlag,4);
        }else if (s.equals("5")) {
            String[] strings={TZDYzuhe5,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4};
            ZDYzuheHelper.ZDY(this,TZDYzuhe5,strings,ByView1Activity.gBakFlag,5);
        }else if (s.equals("6")) {
            String[] strings={TZDYzuhe6,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5};
            ZDYzuheHelper.ZDY(this,TZDYzuhe6,strings,ByView1Activity.gBakFlag,6);
        } else if (s.equals("7")) {
            String[] strings={TZDYzuhe7,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6};
            ZDYzuheHelper.ZDY(this,TZDYzuhe7,strings,ByView1Activity.gBakFlag,7);
        }else if (s.equals("8")) {
            String[] strings={TZDYzuhe8,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7};
            ZDYzuheHelper.ZDY(this,TZDYzuhe8,strings,ByView1Activity.gBakFlag,8);
        }else if (s.equals("9")) {
            String[] strings={TZDYzuhe9,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8};
            ZDYzuheHelper.ZDY(this,TZDYzuhe9,strings,ByView1Activity.gBakFlag,9);
        }else if (s.equals("10")) {
            String[] strings={TZDYzuhe10,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,};
            ZDYzuheHelper.ZDY(this,TZDYzuhe10,strings,ByView1Activity.gBakFlag,10);
        }else if (s.equals("11")) {
            String[] strings={TZDYzuhe11,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,};
            ZDYzuheHelper.ZDY(this,TZDYzuhe11,strings,ByView1Activity.gBakFlag,11);
        }else if (s.equals("12")) {
            String[] strings={TZDYzuhe12,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,};
            ZDYzuheHelper.ZDY(this,TZDYzuhe12,strings,ByView1Activity.gBakFlag,12);
        }else if (s.equals("13")) {
            String[] strings={TZDYzuhe13,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,};
            ZDYzuheHelper.ZDY(this,TZDYzuhe13,strings,ByView1Activity.gBakFlag,13);
        }else if (s.equals("14")) {
            String[] strings={TZDYzuhe14,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,};
            ZDYzuheHelper.ZDY(this,TZDYzuhe14,strings,ByView1Activity.gBakFlag,14);
        }else if (s.equals("15")) {
            String[] strings={TZDYzuhe15,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,};
            ZDYzuheHelper.ZDY(this,TZDYzuhe15,strings,ByView1Activity.gBakFlag,15);
        }else if (s.equals("16")) {
            String[] strings={TZDYzuhe16,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15};
            ZDYzuheHelper.ZDY(this,TZDYzuhe16,strings,ByView1Activity.gBakFlag,16);
        }
    }
    public void ZDY17(){
        String[] strings={ZDYzuhe17.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16};
        ZDYzuheHelper.ZDY(this,ZDYzuhe17,strings,ByView1Activity.gBakFlag,17);
    }
    public void ZDY18(){
        String[] strings={ZDYzuhe18.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,ZDYzuhe17.GetText()};
        ZDYzuheHelper.ZDY(this,ZDYzuhe18,strings,ByView1Activity.gBakFlag,18);
    }
    public void ZDY19(){
        String[] strings={ZDYzuhe19.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,ZDYzuhe17.GetText(),ZDYzuhe18.GetText()};
        ZDYzuheHelper.ZDY(this,ZDYzuhe19,strings,ByView1Activity.gBakFlag,19);
    }
    public void ZDY20(){
        String[] strings={ZDYzuhe20.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,ZDYzuhe17.GetText(),ZDYzuhe18.GetText(),ZDYzuhe19.GetText()};
        ZDYzuheHelper.ZDY(this,ZDYzuhe20,strings,ByView1Activity.gBakFlag,20);
    }
    public void ZDY21(){
        String[] strings={ZDYzuhe21.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,ZDYzuhe17.GetText(),ZDYzuhe18.GetText(),ZDYzuhe19.GetText(),ZDYzuhe20.GetText()};
        ZDYzuheHelper.ZDY(this,ZDYzuhe21,strings,ByView1Activity.gBakFlag,21);
    }
    public void ZDY22(){
        String[] strings={ZDYzuhe22.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,ZDYzuhe17.GetText(),ZDYzuhe18.GetText(),ZDYzuhe19.GetText(),ZDYzuhe20.GetText(),ZDYzuhe21.GetText()};
        ZDYzuheHelper.ZDY(this,ZDYzuhe22,strings,ByView1Activity.gBakFlag,22);
    }


    public void onNext()
    {
        if(ZDYzuhe17.GetText().equals("")||ZDYzuhe18.GetText().equals("")||ZDYzuhe19.GetText().equals("")|| ZDYzuhe20.GetText().equals("")||ZDYzuhe21.GetText().equals("")|| ZDYzuhe22.GetText().equals(""))
        {
            ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
            return ;
        }
        ActivityHelper.BYModel.BYName17v=ZDYzuhe17.GetText();
        ActivityHelper.BYModel.BYName18v=ZDYzuhe18.GetText();
        ActivityHelper.BYModel.BYName19v=ZDYzuhe19.GetText();
        ActivityHelper.BYModel.BYName20v=ZDYzuhe20.GetText();
        ActivityHelper.BYModel.BYName21v=ZDYzuhe21.GetText();
        ActivityHelper.BYModel.BYName22v=ZDYzuhe22.GetText();

        Intent intent=new Intent(this,ByView5Activity.class);
        if (ActivityHelper.MenuList.get(21).instant.equals("Y")&&ActivityHelper.MenuList.get(21).strEnabled.equals("Y")) {
            intent.putExtra("instant", "22");
        }else if (ActivityHelper.MenuList.get(20).instant.equals("Y")&&ActivityHelper.MenuList.get(20).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "21");
        }else if (ActivityHelper.MenuList.get(19).instant.equals("Y")&&ActivityHelper.MenuList.get(19).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "20");
        }else if (ActivityHelper.MenuList.get(18).instant.equals("Y")&&ActivityHelper.MenuList.get(18).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "19");
        }else if (ActivityHelper.MenuList.get(17).instant.equals("Y")&&ActivityHelper.MenuList.get(17).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "18");
        }else if (ActivityHelper.MenuList.get(16).instant.equals("Y")&&ActivityHelper.MenuList.get(16).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "17");
        }
//
        startActivity(intent);

    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SCAN_QRCODE_FLAG) {//条码扫描完毕返回
            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getExtras();
                String strRst = bundle.getString("result");
                if (scanFlag == 1) {
                    ZDYzuhe17.SetEditText(strRst);
                    if (ZDYzuhe17.getMenu().instant.equals("Y")) {
                        ZDY17();
                    }
                } else if (scanFlag == 2) {
                    ZDYzuhe18.SetEditText(strRst);
                    if (ZDYzuhe18.getMenu().instant.equals("Y")) {
                        ZDY18();
                    }
                } else if (scanFlag == 3) {
                    ZDYzuhe19.SetEditText(strRst);
                    if (ZDYzuhe19.getMenu().instant.equals("Y")) {
                        ZDY19();
                    }
                } else if (scanFlag == 4) {
                    ZDYzuhe20.SetEditText(strRst);
                    if (ZDYzuhe20.getMenu().instant.equals("Y")) {
                        ZDY20();
                    }
                }else if (scanFlag == 5) {
                    ZDYzuhe21.SetEditText(strRst);
                    if (ZDYzuhe21.getMenu().instant.equals("Y")) {
                        ZDY21();
                    }
                }else if (scanFlag == 6) {
                    ZDYzuhe22.SetEditText(strRst);
                    if (ZDYzuhe22.getMenu().instant.equals("Y")) {
                        ZDY22();
                    }
                }

            }
        }
    }
    @Override
    public void processMessage(int msgId, String msg) {

    }
}
