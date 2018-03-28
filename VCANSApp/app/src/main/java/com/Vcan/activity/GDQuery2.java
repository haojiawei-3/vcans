package com.Vcan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vcans.Processor.BaseActivity;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ZDYzuhe;
import com.vcans.tool.ZDYzuheHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GDQuery2 extends BaseActivity {
    int  scanFlag;
    String TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,instant;
    @Bind(R.id.ZDYzuhe7)
    ZDYzuhe ZDYzuhe7;
    @Bind(R.id.ZDYzuhe8)
    ZDYzuhe ZDYzuhe8;
    @Bind(R.id.ZDYzuhe9)
    ZDYzuhe ZDYzuhe9;
    @Bind(R.id.ZDYzuhe10)
    ZDYzuhe ZDYzuhe10;
    @Bind(R.id.ZDYzuhe11)
    ZDYzuhe ZDYzuhe11;
    @Bind(R.id.ZDYzuhe12)
    ZDYzuhe ZDYzuhe12;
    @Bind(R.id.btnOk)
    TextView btnOk;
    @Bind(R.id.imgBtnOk)
    ImageButton imgBtnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gdquery2);
        ButterKnife.bind(this);
        initData();
        initDataOnClickListener();
    }

    private void initData() {
        this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
        this.<Button>RegOnClickEvent(R.id.btnOk,"onQuery");
        this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onQuery");
        ZDYzuhe7.SetMenu(ActivityHelper.GDQueryMenuList.get(6));
        ZDYzuhe8.SetMenu(ActivityHelper.GDQueryMenuList.get(7));
        ZDYzuhe9.SetMenu(ActivityHelper.GDQueryMenuList.get(8));
        ZDYzuhe10.SetMenu(ActivityHelper.GDQueryMenuList.get(9));
        ZDYzuhe11.SetMenu(ActivityHelper.GDQueryMenuList.get(10));
        ZDYzuhe12.SetMenu(ActivityHelper.GDQueryMenuList.get(11));

        TZDYzuhe1= ActivityHelper.GDXCModel.GDName1v;
        TZDYzuhe2= ActivityHelper.GDXCModel.GDName2v;
        TZDYzuhe3= ActivityHelper.GDXCModel.GDName3v;
        TZDYzuhe4= ActivityHelper.GDXCModel.GDName4v;
        TZDYzuhe5= ActivityHelper.GDXCModel.GDName5v;
        TZDYzuhe6= ActivityHelper.GDXCModel.GDName6v;
        btnOk.setText(getString(R.string.btn_query));
        imgBtnOk.setImageResource(R.drawable.query_yp);
        Intent intent = this.getIntent();
        instant= (String)intent.getSerializableExtra("instant");

        if (instant!=null) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    instant(instant);
                }
            }, 500);

        }
    }

    private void initDataOnClickListener() {
        ZDYzuhe7.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=1;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY7();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe8.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=2;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY8();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe9.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=3;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY9();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe10.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=4;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY10();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe11.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=5;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY11();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe12.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=6;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY12();}
            @Override
            public void OnClickListener3() {}
        });
    }

    public void  instant(String s){
        if (s.equals("1")) {
            String[] strings={TZDYzuhe1};
            ZDYzuheHelper.GDQuery(GDQuery2.this,TZDYzuhe1,strings,GDQuery1.gQueryFlag,1);
        }else if (s.equals("2")) {
            String[] strings={TZDYzuhe2,TZDYzuhe1};
            ZDYzuheHelper.GDQuery(GDQuery2.this,TZDYzuhe2,strings,GDQuery1.gQueryFlag,2);
        }else if (s.equals("3")) {
            String[] strings={TZDYzuhe3,TZDYzuhe1,TZDYzuhe2};
            ZDYzuheHelper.GDQuery(GDQuery2.this,TZDYzuhe3,strings,GDQuery1.gQueryFlag,3);
        }else if (s.equals("4")) {
            String[] strings={TZDYzuhe4,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3};
            ZDYzuheHelper.GDQuery(GDQuery2.this,TZDYzuhe4,strings,GDQuery1.gQueryFlag,4);
        }else if (s.equals("5")) {
            String[] strings={TZDYzuhe5,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4};
            ZDYzuheHelper.GDQuery(GDQuery2.this,TZDYzuhe5,strings,GDQuery1.gQueryFlag,5);
        }else if (s.equals("6")) {
            String[] strings={TZDYzuhe6,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5};
            ZDYzuheHelper.GDQuery(GDQuery2.this,TZDYzuhe6,strings,GDQuery1.gQueryFlag,6);
        }
    }

    public void ZDY7(){
        String[] strings={ZDYzuhe7.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,};
        ZDYzuheHelper.GDQuery(GDQuery2.this,ZDYzuhe7,strings,GDQuery1.gQueryFlag,7);
    }
    public void ZDY8(){
        String[] strings={ZDYzuhe8.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,ZDYzuhe7.GetText()};
        ZDYzuheHelper.GDQuery(GDQuery2.this,ZDYzuhe8,strings,GDQuery1.gQueryFlag,8);
    }
    public void ZDY9(){
        String[] strings={ZDYzuhe9.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,ZDYzuhe7.GetText(),ZDYzuhe8.GetText()};
        ZDYzuheHelper.GDQuery(GDQuery2.this,ZDYzuhe9,strings,GDQuery1.gQueryFlag,9);
    }
    public void ZDY10(){
        String[] strings={ZDYzuhe10.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,ZDYzuhe7.GetText(),ZDYzuhe8.GetText(),ZDYzuhe9.GetText()};
        ZDYzuheHelper.GDQuery(GDQuery2.this,ZDYzuhe10,strings,GDQuery1.gQueryFlag,10);
    }
    public void ZDY11(){
        String[] strings={ZDYzuhe11.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,ZDYzuhe7.GetText(),ZDYzuhe8.GetText(),ZDYzuhe9.GetText(),ZDYzuhe10.GetText()};
        ZDYzuheHelper.GDQuery(GDQuery2.this,ZDYzuhe11,strings,GDQuery1.gQueryFlag,11);
    }
    public void ZDY12(){
        String[] strings={ZDYzuhe12.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,ZDYzuhe7.GetText(),ZDYzuhe8.GetText(),ZDYzuhe9.GetText(),ZDYzuhe10.GetText(),ZDYzuhe11.GetText()};
        ZDYzuheHelper.GDQuery(GDQuery2.this,ZDYzuhe12,strings,GDQuery1.gQueryFlag,12);
    }


    public void onQuery()
    {

        if(ZDYzuhe7.GetText().equals("")||ZDYzuhe8.GetText().equals("")||ZDYzuhe9.GetText().equals("")|| ZDYzuhe10.GetText().equals("")||ZDYzuhe11.GetText().equals("")||ZDYzuhe12.GetText().equals(""))
        {
            ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
            return ;
        }
        ActivityHelper.GDXCModel.GDName7v=ZDYzuhe7.GetText();
        ActivityHelper.GDXCModel.GDName8v=ZDYzuhe8.GetText();
        ActivityHelper.GDXCModel.GDName9v=ZDYzuhe9.GetText();
        ActivityHelper.GDXCModel.GDName10v=ZDYzuhe10.GetText();
        ActivityHelper.GDXCModel.GDName11v=ZDYzuhe11.GetText();
        ActivityHelper.GDXCModel.GDName12v=ZDYzuhe12.GetText();
        Intent intent=new Intent(this,GDQuery3Result.class);
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
                    ZDYzuhe7.SetEditText(strRst);
                    if (ZDYzuhe7.getMenu().instant.equals("Y")) {
                        ZDY7();
                    }
                } else if (scanFlag == 2) {
                    ZDYzuhe8.SetEditText(strRst);
                    if (ZDYzuhe8.getMenu().instant.equals("Y")) {
                        ZDY8();
                    }
                } else if (scanFlag == 3) {
                    ZDYzuhe9.SetEditText(strRst);
                    if (ZDYzuhe9.getMenu().instant.equals("Y")) {
                        ZDY9();
                    }
                } else if (scanFlag == 4) {
                    ZDYzuhe10.SetEditText(strRst);
                    if (ZDYzuhe10.getMenu().instant.equals("Y")) {
                        ZDY10();
                    }
                }else if (scanFlag == 5) {
                    ZDYzuhe11.SetEditText(strRst);
                    if (ZDYzuhe11.getMenu().instant.equals("Y")) {
                        ZDY11();
                    }
                }else if (scanFlag == 6) {
                    ZDYzuhe12.SetEditText(strRst);
                    if (ZDYzuhe12.getMenu().instant.equals("Y")) {
                        ZDY12();
                    }
                }

            }
        }
    }


    @Override
    public void processMessage(int msgId, String msg) {

    }
}
