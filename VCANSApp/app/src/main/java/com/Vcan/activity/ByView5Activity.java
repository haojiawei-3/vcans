package com.Vcan.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.ByModelUploadProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.ListViewForScrollView;
import com.vcans.tool.PlProcessor;
import com.vcans.tool.ZDYzuhe;
import com.vcans.tool.ZDYzuheHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ByView5Activity extends BaseActivity {
    String TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,TZDYzuhe19,TZDYzuhe20,TZDYzuhe21,TZDYzuhe22,instant;
    int  scanFlag;
    private int mLastClickId=-1;
    private long mLastClickTime=0;
    private List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
    ByModelUploadProcessor ByModelUploadProcessor;
    @Bind(R.id.ZDYzuhe23)
    ZDYzuhe ZDYzuhe23;
    @Bind(R.id.ZDYzuhe24)
    ZDYzuhe ZDYzuhe24;
    @Bind(R.id.ZDYzuhe25)
    ZDYzuhe ZDYzuhe25;
    @Bind(R.id.ZDYzuhe26)
    ZDYzuhe ZDYzuhe26;
    @Bind(R.id.lvProdct)
    ListViewForScrollView listView;
    @Bind(R.id.sv)
    ScrollView sv;
    @Bind(R.id.btnOk)
    Button btnOk;
    @Bind(R.id.tvPage)
    TextView tvPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_view5);
        ButterKnife.bind(this);
        initData();
        initDataOnClickListener();
    }
    private void initData() {
        this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
        this.<Button>RegOnClickEvent(R.id.btnOk,"onUpload");
        this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onUpload");
        this.<Button>RegOnClickEvent(R.id.btnSave,"onSave");
        this.<Button>RegOnClickEvent(R.id.imgBtnSave,"onSave");
        this.<TextView>RegOnClickEvent(R.id.tvClear,"onClear");
        this.<Button>RegOnClickEvent(R.id.BtnDelete,"onDelete");
        listView.setOnItemClickListener(listClickListener);
        sv.smoothScrollTo(0, 0);
        ByModelUploadProcessor =new ByModelUploadProcessor(ByView1Activity.gBakFlag);
        ByModelUploadProcessor.DisplaybyModelInfo();
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
        TZDYzuhe17= ActivityHelper.BYModel.BYName17v;
        TZDYzuhe18= ActivityHelper.BYModel.BYName18v;
        TZDYzuhe19= ActivityHelper.BYModel.BYName19v;
        TZDYzuhe20= ActivityHelper.BYModel.BYName20v;
        TZDYzuhe21= ActivityHelper.BYModel.BYName21v;
        TZDYzuhe22= ActivityHelper.BYModel.BYName22v;
        ZDYzuhe23.SetMenu(ActivityHelper.MenuList.get(22));
        ZDYzuhe24.SetMenu(ActivityHelper.MenuList.get(23));
        ZDYzuhe25.SetMenu(ActivityHelper.MenuList.get(24));
        ZDYzuhe26.SetMenu(ActivityHelper.MenuList.get(25));
        btnOk.setText(getString(R.string.btn_upload));
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
        ZDYzuhe23.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=1;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {
                ZDY23();
            }
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe24.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=2;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {
               ZDY24();
            }
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe25.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=3;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {
                ZDY25();
            }
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe26.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=4;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {
                ZDY26();
            }
            @Override
            public void OnClickListener3() {}
        });

    }

    public final AdapterView.OnItemClickListener listClickListener=new AdapterView.OnItemClickListener(){

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {

            //获得选中项的HashMap对象
            HashMap<String,Object> mapToupei=(HashMap<String,Object>)listView.getItemAtPosition(arg2);
            mstrDataId=(String)mapToupei.get("TPId");
            String[] szStr=tvPage.getText().toString().split("/");
            tvPage.setText("("+(arg2+1)+"/"+szStr[1]);


            // 如果是双击,1秒内连续点击判断为双击
            if(arg2==mLastClickId && (Math.abs(mLastClickTime-System.currentTimeMillis()) < 1000))
            {
                mLastClickId = -1;
                mLastClickTime = 0;

                mDataList.clear();
                mDataList.add(mapToupei);


                ByModelUploadProcessor.displayDetail(mDataList);

            }
            else
            {
                mLastClickId =arg2;
                mLastClickTime = System.currentTimeMillis();
            }

        }
    };



    public void onUpload()
    {//上传
        if(listView.getCount()>0)
        {
            SendParam sendParam = new SendParam();
            sendParam.parent = this;
            sendParam.bSendEndNotify=true;
            sendParam.processor = ByModelUploadProcessor;
            getDataTrunsfer().beginUploadFile(sendParam);
        }
        else
        {
            ActivityHelper.showDialog(this,"错误",getString(R.string.noData));
        }

    }

    public void onSave()
    {
        PlProcessor.SetParent(this);
        ActivityHelper.hidesofeKeyboard(this);
        ByModelUploadProcessor.SaveInfo();
    }

    public void onClear()
    {
        if(listView.getCount()<1)
        {
            return;
        }

        new AlertDialog.Builder(this).setTitle(getString(R.string.askClear))
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“确认”后的操作
                        ByModelUploadProcessor.ClearToupeiInfo();

                    }
                })
                .setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“返回”后的操作,这里不设置没有任何操作
                    }
                }).show();
    }

    public void onDelete()
    {
        if(listView.getCount()<1)
        {
            return ;
        }

        if(mstrDataId.equals(""))
        {
            ActivityHelper.showDialog(this,"错误",getString(R.string.noSelected));
            return;
        }

        new AlertDialog.Builder(this).setTitle(getString(R.string.askDelete))
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“确认”后的操作
                        if(!mstrDataId.equals(""))
                        {
                            ByModelUploadProcessor.DeleteToupeiInfo(mstrDataId);
                            mstrDataId="";
                        }
                    }
                })
                .setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“返回”后的操作,这里不设置没有任何操作
                    }
                }).show();
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
        } else if (s.equals("17")) {
            String[] strings={TZDYzuhe17,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16};
            ZDYzuheHelper.ZDY(this,TZDYzuhe17,strings,ByView1Activity.gBakFlag,17);
        }else if (s.equals("18")) {
            String[] strings={TZDYzuhe18,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17};
            ZDYzuheHelper.ZDY(this,TZDYzuhe18,strings,ByView1Activity.gBakFlag,18);
        }else if (s.equals("19")) {
            String[] strings={TZDYzuhe19,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18};
            ZDYzuheHelper.ZDY(this,TZDYzuhe19,strings,ByView1Activity.gBakFlag,19);
        }else if (s.equals("20")) {
            String[] strings={TZDYzuhe20,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,TZDYzuhe19};
            ZDYzuheHelper.ZDY(this,TZDYzuhe20,strings,ByView1Activity.gBakFlag,20);
        }else if (s.equals("21")) {
            String[] strings={TZDYzuhe21,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe17,TZDYzuhe18,TZDYzuhe19,TZDYzuhe20};
            ZDYzuheHelper.ZDY(this,TZDYzuhe21,strings,ByView1Activity.gBakFlag,21);
        }else if (s.equals("22")) {
            String[] strings={TZDYzuhe22,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,TZDYzuhe19,TZDYzuhe20,TZDYzuhe21};
            ZDYzuheHelper.ZDY(this,TZDYzuhe22,strings,ByView1Activity.gBakFlag,22);
        }
    }

    public void  ZDY23(){
        String[] strings={ZDYzuhe23.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,TZDYzuhe19,TZDYzuhe20,TZDYzuhe21,TZDYzuhe22};
        ZDYzuheHelper.ZDY(ByView5Activity.this,ZDYzuhe23,strings,ByView1Activity.gBakFlag,23);
    }
    public void  ZDY24(){
        String[] strings={ZDYzuhe24.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,TZDYzuhe19,TZDYzuhe20,TZDYzuhe21,TZDYzuhe22,ZDYzuhe23.GetText()};
        ZDYzuheHelper.ZDY(ByView5Activity.this,ZDYzuhe24,strings,ByView1Activity.gBakFlag,24);
    }
    public void  ZDY25(){
        String[] strings={ZDYzuhe25.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,TZDYzuhe19,TZDYzuhe20,TZDYzuhe21,TZDYzuhe22,ZDYzuhe23.GetText(),ZDYzuhe24.GetText()};
        ZDYzuheHelper.ZDY(ByView5Activity.this,ZDYzuhe25,strings,ByView1Activity.gBakFlag,25);
    }
    public void  ZDY26(){
        String[] strings={ZDYzuhe26.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,TZDYzuhe7,TZDYzuhe8,TZDYzuhe9,TZDYzuhe10,ActivityHelper.BYModel.GoodsId,ActivityHelper.BYModel.GoodsDescribe,ActivityHelper.BYModel.StoreDescribe,ActivityHelper.BYModel.StoreFlag,ActivityHelper.BYModel.GPiShu,ActivityHelper.BYModel.GNum,ActivityHelper.BYModel.Remark1,ActivityHelper.BYModel.Remark2,ActivityHelper.BYModel.Remark3,ActivityHelper.BYModel.Remark4,ActivityHelper.BYModel.Remark5,TZDYzuhe11,TZDYzuhe12,TZDYzuhe13,TZDYzuhe14,TZDYzuhe15,TZDYzuhe16,TZDYzuhe17,TZDYzuhe18,TZDYzuhe19,TZDYzuhe20,TZDYzuhe21,TZDYzuhe22,ZDYzuhe23.GetText(),ZDYzuhe24.GetText(),ZDYzuhe25.GetText()};
        ZDYzuheHelper.ZDY(ByView5Activity.this,ZDYzuhe26,strings,ByView1Activity.gBakFlag,26);
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SCAN_QRCODE_FLAG) {//条码扫描完毕返回
            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getExtras();
                String strRst = bundle.getString("result");
                if (scanFlag == 1) {
                    ZDYzuhe23.SetEditText(strRst);
                    if (ZDYzuhe23.getMenu().instant.equals("Y")) {
                       ZDY23();
                    }
                } else if (scanFlag == 2) {
                    ZDYzuhe24.SetEditText(strRst);
                    if (ZDYzuhe24.getMenu().instant.equals("Y")) {
                        ZDY24();
                    }
                } else if (scanFlag == 3) {
                    ZDYzuhe25.SetEditText(strRst);
                    if (ZDYzuhe25.getMenu().instant.equals("Y")) {
                       ZDY25();
                    }
                } else if (scanFlag == 4) {
                    ZDYzuhe26.SetEditText(strRst);
                    if (ZDYzuhe26.getMenu().instant.equals("Y")) {
                       ZDY26();
                    }
                }


            }
        }
    }
    @Override
    public void processMessage(int msgId, String msg) {

    }
}
