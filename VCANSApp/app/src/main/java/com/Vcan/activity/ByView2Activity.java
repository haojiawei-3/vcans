package com.Vcan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.ByMateLoadDownWorkBYProcessor;
import com.vcans.Processor.DPRZTaskDownWorkBY1Processor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.ListViewForScrollView;
import com.vcans.tool.ZDYzuhe;
import com.vcans.tool.ZDYzuheHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.Vcan.activity.R.id.ZDYzuhe1;
import static com.Vcan.activity.R.id.ZDYzuhe2;
import static com.vcans.Processor.Singleton.getDataTrunsfer;

public class ByView2Activity extends BaseActivity {
    String TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,instant;
    int  scanFlag;
    ByMateLoadDownWorkBYProcessor ByProcessor=new ByMateLoadDownWorkBYProcessor(ByView1Activity.gBakFlag);
    private boolean bLoadFlag=true;
  //  public static String gBakFlag="";
    @Bind(R.id.ZDYzuhe7)
    ZDYzuhe ZDYzuhe7;
    @Bind(R.id.ZDYzuhe8)
    ZDYzuhe ZDYzuhe8;
    @Bind(R.id.ZDYzuhe9)
    ZDYzuhe ZDYzuhe9;
    @Bind(R.id.ZDYzuhe10)
    ZDYzuhe ZDYzuhe10;
    @Bind(R.id.btnOk)
    Button mBtnOk;
    @Bind(R.id.imgBtnOk)
    ImageButton   imgBtnOk;
    @Bind(R.id.lvProdct)
    ListViewForScrollView lvProdct;
    @Bind(R.id.tvPage)
    TextView tvPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_view2);
      ButterKnife.bind(this);
        initData();
        initDataOnClickListener();
    }
    private void initData() {
        this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
        this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
        this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
        setListItemClickMethod("onGoodsItemClick","onGoodsItemDbClick");
        ZDYzuhe7.SetMenu(ActivityHelper.MenuList.get(6));
        ZDYzuhe8.SetMenu(ActivityHelper.MenuList.get(7));
        ZDYzuhe9.SetMenu(ActivityHelper.MenuList.get(8));
        ZDYzuhe10.SetMenu(ActivityHelper.MenuList.get(9));
        mBtnOk.setText(getString(R.string.goodsLoad));
        imgBtnOk.setImageResource(R.drawable.load_goods);
        TZDYzuhe1= ActivityHelper.BYModel.BYName1v;
        TZDYzuhe2= ActivityHelper.BYModel.BYName2v;
        TZDYzuhe3= ActivityHelper.BYModel.BYName3v;
        TZDYzuhe4= ActivityHelper.BYModel.BYName4v;
        TZDYzuhe5= ActivityHelper.BYModel.BYName5v;
        TZDYzuhe6= ActivityHelper.BYModel.BYName6v;
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
    }



    public void  instant(String s){
        if (s.equals("1")) {
            String[] strings={TZDYzuhe1};
            ZDYzuheHelper.ZDY(ByView2Activity.this,TZDYzuhe1,strings,ByView1Activity.gBakFlag,1);
        }else if (s.equals("2")) {
            String[] strings={TZDYzuhe2,TZDYzuhe1};
            ZDYzuheHelper.ZDY(ByView2Activity.this,TZDYzuhe2,strings,ByView1Activity.gBakFlag,2);
        }else if (s.equals("3")) {
            String[] strings={TZDYzuhe3,TZDYzuhe1,TZDYzuhe2};
            ZDYzuheHelper.ZDY(ByView2Activity.this,TZDYzuhe3,strings,ByView1Activity.gBakFlag,3);
        }else if (s.equals("4")) {
            String[] strings={TZDYzuhe4,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3};
            ZDYzuheHelper.ZDY(ByView2Activity.this,TZDYzuhe4,strings,ByView1Activity.gBakFlag,4);
        }else if (s.equals("5")) {
            String[] strings={TZDYzuhe5,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4};
            ZDYzuheHelper.ZDY(ByView2Activity.this,TZDYzuhe5,strings,ByView1Activity.gBakFlag,5);
        }else if (s.equals("6")) {
            String[] strings={TZDYzuhe6,TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5};
            ZDYzuheHelper.ZDY(ByView2Activity.this,TZDYzuhe6,strings,ByView1Activity.gBakFlag,6);
        }
    }

        public void ZDY7(){
           String[] strings={ZDYzuhe7.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6};
           ZDYzuheHelper.ZDY(ByView2Activity.this,ZDYzuhe7,strings,ByView1Activity.gBakFlag,7);
        }
        public void ZDY8(){
            String[] strings={ZDYzuhe8.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,ZDYzuhe7.GetText()};
            ZDYzuheHelper.ZDY(ByView2Activity.this,ZDYzuhe8,strings,ByView1Activity.gBakFlag,8);
        }
        public void ZDY9(){
            String[] strings={ZDYzuhe9.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,ZDYzuhe7.GetText(),ZDYzuhe8.GetText()};
            ZDYzuheHelper.ZDY(ByView2Activity.this,ZDYzuhe9,strings,ByView1Activity.gBakFlag,9);
        }
        public void ZDY10(){
            String[] strings={ZDYzuhe10.GetText(),TZDYzuhe1,TZDYzuhe2,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,ZDYzuhe7.GetText(),ZDYzuhe8.GetText(),ZDYzuhe9.GetText()};
            ZDYzuheHelper.ZDY(ByView2Activity.this,ZDYzuhe10,strings,ByView1Activity.gBakFlag,10);
        }


    public void onGoodsItemClick(int index)
    {
        //获得选中项的HashMap对象
        HashMap<String,Object> mapToupei=(HashMap<String,Object>)lvProdct.getItemAtPosition(index);

        ActivityHelper.BYModel.GoodsId=(String)mapToupei.get("GoodsId");
        ActivityHelper.BYModel.GoodsDescribe=(String)mapToupei.get("GoodDescribe");
        ActivityHelper.BYModel.StoreDescribe=(String)mapToupei.get("StoreDescribe");
        ActivityHelper.BYModel.StoreFlag=(String)mapToupei.get("StoreFlag");
        ActivityHelper.BYModel.GPiShu=(String)mapToupei.get("GPiShu");
        ActivityHelper.BYModel.GNum=(String)mapToupei.get("GNum");
        ActivityHelper.BYModel.Remark1=(String)mapToupei.get("Remark1");
        ActivityHelper.BYModel. Remark2=(String)mapToupei.get("Remark2");
        ActivityHelper.BYModel. Remark3=(String)mapToupei.get("Remark3");
        ActivityHelper.BYModel. Remark4=(String)mapToupei.get("Remark4");
        ActivityHelper.BYModel. Remark5=(String)mapToupei.get("Remark5");

        //设置按钮为下一步
        bLoadFlag=false;
        mBtnOk.setText(getString(R.string.btn_next));
        imgBtnOk.setImageResource(R.drawable.next_blue);


        String[] szStr=tvPage.getText().toString().split("/");
        tvPage.setText("("+(index+1)+"/"+szStr[1]);
    }


    public void onGoodsItemDbClick(int index)
    {
        //获得选中项的HashMap对象
        HashMap<String,Object> mapToupei=(HashMap<String,Object>)lvProdct.getItemAtPosition(index);

        List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
        mDataList.add(mapToupei);
      //  ByProcessor.displayDetail(mDataList);
    }

    public void onNext()
    {


        if(bLoadFlag)
        {
            if(ZDYzuhe7.GetText().equals("")||ZDYzuhe8.GetText().equals("")||ZDYzuhe9.GetText().equals("")|| ZDYzuhe10.GetText().equals(""))
        {
            ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
            return ;
        }else{
                String[] szData={ZDYzuhe10.GetText(),TZDYzuhe1,TZDYzuhe3,TZDYzuhe3,TZDYzuhe4,TZDYzuhe5,TZDYzuhe6,ZDYzuhe7.GetText(),ZDYzuhe8.GetText(),ZDYzuhe9.GetText()};
//                ZDYzuheHelper.MateLoad(ByView2Activity.this,strings, ItemTitleHelper.K6);
                SendParam sendParam = new SendParam();
                sendParam.parent = this;
                sendParam.szData=szData;
                sendParam.processor = ByProcessor;
                getDataTrunsfer().request(sendParam);
             }


        }
        else
        {
            if(ZDYzuhe7.GetText().equals("")||ZDYzuhe8.GetText().equals("")||ZDYzuhe9.GetText().equals("")|| ZDYzuhe10.GetText().equals(""))
        {
            ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
            return ;
        }
            ActivityHelper.BYModel.BYName7v=ZDYzuhe7.GetText();
            ActivityHelper.BYModel.BYName8v=ZDYzuhe8.GetText();
            ActivityHelper.BYModel.BYName9v=ZDYzuhe9.GetText();
            ActivityHelper.BYModel.BYName10v=ZDYzuhe10.GetText();
            Intent intent=new Intent(this,ByView3Activity.class);
            if (ActivityHelper.MenuList.get(9).instant.equals("Y")&&ActivityHelper.MenuList.get(9).strEnabled.equals("Y")) {
                intent.putExtra("instant", "10");
            }else if (ActivityHelper.MenuList.get(8).instant.equals("Y")&&ActivityHelper.MenuList.get(8).strEnabled.equals("Y")) {
                intent.putExtra("instant",  "9");
            }else if (ActivityHelper.MenuList.get(7).instant.equals("Y")&&ActivityHelper.MenuList.get(7).strEnabled.equals("Y")) {
                intent.putExtra("instant",  "8");
            }else if (ActivityHelper.MenuList.get(6).instant.equals("Y")&&ActivityHelper.MenuList.get(6).strEnabled.equals("Y")) {
                intent.putExtra("instant",  "7");
            }
//
            startActivity(intent);
        }


//

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
                }

            }
        }
    }

    @Override
    public void processMessage(int msgId, String msg) {

    }
}
