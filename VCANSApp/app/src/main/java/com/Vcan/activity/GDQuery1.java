package com.Vcan.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.vcans.Processor.BaseActivity;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.ZDYzuhe;
import com.vcans.tool.ZDYzuheHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GDQuery1 extends BaseActivity {
    public static String gQueryFlag="";
    int  scanFlag;

    @Bind(R.id.ZDYzuhe1)
    ZDYzuhe ZDYzuhe1;
    @Bind(R.id.ZDYzuhe2)
    ZDYzuhe ZDYzuhe2;
    @Bind(R.id.ZDYzuhe3)
    ZDYzuhe ZDYzuhe3;
    @Bind(R.id.ZDYzuhe4)
    ZDYzuhe ZDYzuhe4;
    @Bind(R.id.ZDYzuhe5)
    ZDYzuhe ZDYzuhe5;
    @Bind(R.id.ZDYzuhe6)
    ZDYzuhe ZDYzuhe6;
    @Bind(R.id.imgBtnOk)
    ImageButton imgBtnOk;
    @Bind(R.id.btnOk)
    Button btnOk;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gdquery1);
        ButterKnife.bind(this);
        if (gQueryFlag.equals(ItemTitleHelper.G1)) {
            if (ActivityHelper.GDQueryMenuKLists.size()==0) {
                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G1);
            }else {
                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G1);
            }

        }else if (gQueryFlag.equals(ItemTitleHelper.G2)) {
            if (ActivityHelper.GDQueryMenuKLists.size()==0) {
                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G2);
            }else {
                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G2);
            }

        }else if (gQueryFlag.equals(ItemTitleHelper.G3)) {
            if (ActivityHelper.GDQueryMenuKLists.size()==0) {
                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G3);
            }else {
                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G3);
            }

        }else if (gQueryFlag.equals(ItemTitleHelper.G4)) {
            if (ActivityHelper.GDQueryMenuKLists.size()==0) {
                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G4);
            }else {
                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G4);
            }

        }else if (gQueryFlag.equals(ItemTitleHelper.G5)) {
            if (ActivityHelper.GDQueryMenuKLists.size()==0) {

                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G5);
            }else {
                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G5);
                // ActivityHelper.MenuList=ActivityHelper.setItemMenuK(ItemTitleHelper.K5); // 需要该一下
            }

        }else if (gQueryFlag.equals(ItemTitleHelper.G6)) {
            if (ActivityHelper.GDQueryMenuKLists.size()==0) {

                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G6);
            }else {
                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G6);
                // ActivityHelper.MenuList=ActivityHelper.setItemMenuK(ItemTitleHelper.K5); // 需要该一下
            }

        }else if (gQueryFlag.equals(ItemTitleHelper.G7)) {
            if (ActivityHelper.GDQueryMenuKLists.size()==0) {

                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G7);
            }else {
                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G7);
                // ActivityHelper.MenuList=ActivityHelper.setItemMenuK(ItemTitleHelper.K5); // 需要该一下
            }

        }else if (gQueryFlag.equals(ItemTitleHelper.G8)) {
            if (ActivityHelper.GDQueryMenuKLists.size()==0) {

                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G8);
            }else {
                ActivityHelper.GDQueryMenuList=ActivityHelper.GDQueryMenuKLists.get(ItemTitleHelper.G8);
                // ActivityHelper.MenuList=ActivityHelper.setItemMenuK(ItemTitleHelper.K5); // 需要该一下
            }

        }
        initData();
        initDataOnClickListener();
    }

    private void initData() {
        this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
        this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
        this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
        ZDYzuhe1.SetMenu(ActivityHelper.GDQueryMenuList.get(0));
        ZDYzuhe2.SetMenu(ActivityHelper.GDQueryMenuList.get(1));
        ZDYzuhe3.SetMenu(ActivityHelper.GDQueryMenuList.get(2));
        ZDYzuhe4.SetMenu(ActivityHelper.GDQueryMenuList.get(3));
        ZDYzuhe5.SetMenu(ActivityHelper.GDQueryMenuList.get(4));
        ZDYzuhe6.SetMenu(ActivityHelper.GDQueryMenuList.get(5));
        Next();
    }
    private boolean  Next(){
        boolean ss=true;
        if (ActivityHelper.GDQueryMenuList.get(6).strEnabled.equals("N")||
                ActivityHelper.GDQueryMenuList.get(7).strEnabled.equals("N")||
                ActivityHelper.GDQueryMenuList.get(8).strEnabled.equals("N")||
                ActivityHelper.GDQueryMenuList.get(9).strEnabled.equals("N")||
                ActivityHelper.GDQueryMenuList.get(10).strEnabled.equals("N")||
                ActivityHelper.GDQueryMenuList.get(11).strEnabled.equals("N")){
            btnOk.setText(getString(R.string.btn_query));
            imgBtnOk.setImageResource(R.drawable.query_yp);
            ss=false;
        }
        return  ss;
    }

    private void initDataOnClickListener() {
        ZDYzuhe1.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=1;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY1();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe2.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=2;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY2();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe3.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=3;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY3();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe4.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=4;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY4();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe5.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=5;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY5();}
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe6.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=6;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {ZDY6();}
            @Override
            public void OnClickListener3() {}
        });

    }


    public void   ZDY1(){
        String[] strings={ZDYzuhe1.GetText()};
        ZDYzuheHelper.GDQuery(GDQuery1.this,ZDYzuhe1,strings,gQueryFlag,1);
    }
    public void   ZDY2(){
        String[] strings={ZDYzuhe2.GetText(),ZDYzuhe1.GetText()};
        ZDYzuheHelper.GDQuery(GDQuery1.this,ZDYzuhe2,strings,gQueryFlag,2);
    }
    public void   ZDY3(){
        String[] strings={ZDYzuhe3.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText()};
        ZDYzuheHelper.GDQuery(GDQuery1.this,ZDYzuhe3,strings,gQueryFlag,3);
    }
    public void   ZDY4(){
        String[] strings={ZDYzuhe4.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText(),ZDYzuhe3.GetText()};
        ZDYzuheHelper.GDQuery(GDQuery1.this,ZDYzuhe4,strings,gQueryFlag,4);
    }
    public void   ZDY5(){
        String[] strings={ZDYzuhe5.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText(),ZDYzuhe3.GetText(),ZDYzuhe4.GetText()};
        ZDYzuheHelper.GDQuery(GDQuery1.this,ZDYzuhe5,strings,gQueryFlag,5);
    }
    public void   ZDY6(){
        String[] strings={ZDYzuhe6.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText(),ZDYzuhe3.GetText(),ZDYzuhe4.GetText(),ZDYzuhe5.GetText()};
        ZDYzuheHelper.GDQuery(GDQuery1.this,ZDYzuhe6,strings,gQueryFlag,6);
    }

    public void onNext()
    {
        if(ZDYzuhe1.GetText().equals("")||ZDYzuhe2.GetText().equals("")||ZDYzuhe3.GetText().equals("")|| ZDYzuhe4.GetText().equals("")||ZDYzuhe5.GetText().equals("")||ZDYzuhe6.GetText().equals(""))
        {
            ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
            return ;
        }
        ActivityHelper.GDXCModel.GDName1v=ZDYzuhe1.GetText();
        ActivityHelper.GDXCModel.GDName2v=ZDYzuhe2.GetText();
        ActivityHelper.GDXCModel.GDName3v=ZDYzuhe3.GetText();
        ActivityHelper.GDXCModel.GDName4v=ZDYzuhe4.GetText();
        ActivityHelper.GDXCModel.GDName5v=ZDYzuhe5.GetText();
        ActivityHelper.GDXCModel.GDName6v=ZDYzuhe6.GetText();
        if (Next()){
            intent=new Intent(this,GDQuery2.class);
        }else {

            intent=new Intent(this,GDQuery3Result.class);
        }

        if (ActivityHelper.GDQueryMenuList.get(5).instant.equals("Y")&&ActivityHelper.GDQueryMenuList.get(5).strEnabled.equals("Y")) {
            intent.putExtra("instant", "6");
        }else if (ActivityHelper.GDQueryMenuList.get(4).instant.equals("Y")&&ActivityHelper.GDQueryMenuList.get(4).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "5");
        }else if (ActivityHelper.GDQueryMenuList.get(3).instant.equals("Y")&&ActivityHelper.GDQueryMenuList.get(3).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "4");
        }else if (ActivityHelper.GDQueryMenuList.get(2).instant.equals("Y")&&ActivityHelper.GDQueryMenuList.get(2).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "3");
        }else if (ActivityHelper.GDQueryMenuList.get(1).instant.equals("Y")&&ActivityHelper.GDQueryMenuList.get(1).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "2");
        }else if (ActivityHelper.GDQueryMenuList.get(0).instant.equals("Y")&&ActivityHelper.GDQueryMenuList.get(0).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "1");
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
                    ZDYzuhe1.SetEditText(strRst);
                    if (ZDYzuhe1.getMenu().instant.equals("Y")) {
                        ZDY1();
                    }
                } else if (scanFlag == 2) {
                    ZDYzuhe2.SetEditText(strRst);
                    if (ZDYzuhe2.getMenu().instant.equals("Y")) {
                        ZDY2();
                    }
                } else if (scanFlag == 3) {
                    ZDYzuhe3.SetEditText(strRst);
                    if (ZDYzuhe3.getMenu().instant.equals("Y")) {
                        ZDY3();
                    }
                } else if (scanFlag == 4) {
                    ZDYzuhe4.SetEditText(strRst);
                    if (ZDYzuhe4.getMenu().instant.equals("Y")) {
                        ZDY4();
                    }
                }else if (scanFlag == 5) {
                    ZDYzuhe5.SetEditText(strRst);
                    if (ZDYzuhe5.getMenu().instant.equals("Y")) {
                        ZDY5();
                    }
                }else if (scanFlag == 6) {
                    ZDYzuhe6.SetEditText(strRst);
                    if (ZDYzuhe6.getMenu().instant.equals("Y")) {
                        ZDY6();
                    }
                }

            }
        }
    }

    @Override
    public void processMessage(int msgId, String msg) {

    }
}
