package com.Vcan.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPRZTaskDownWorkBY1Processor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.CameraTool;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.ZDYzuhe;
import com.vcans.tool.ZDYzuheHelper;

import java.io.File;
import java.text.SimpleDateFormat;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ByView1Activity extends BaseActivity {
    public static String gBakFlag="";
    int  scanFlag;
    private String mFileName = "";
    private boolean bOpenCamera=false;
    private String mPreFileNameCut;//前一个剪切的图片，用于在保存新剪切图片之前，删除之前的剪切的图片
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
    @Bind(R.id.imgCusCard)
    ImageView  imgCusCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_view1);
        ButterKnife.bind(this);
        ActivityHelper.BYModel.BYName30v=gBakFlag;
        if (gBakFlag.equals(ItemTitleHelper.K6)) {
                if (ActivityHelper.MenuKLists1.size()==0) {
                ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K6);
            }else {
                ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K6);
            }

        }else if (gBakFlag.equals(ItemTitleHelper.K7)) {
            if (ActivityHelper.MenuKLists1.size()==0) {
                ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K7);
            }else {
                ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K7);
            }

        }else if (gBakFlag.equals(ItemTitleHelper.K8)) {
            if (ActivityHelper.MenuKLists1.size()==0) {
                ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K8);
            }else {
                ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K8);
            }

        }else if (gBakFlag.equals(ItemTitleHelper.K9)) {
            if (ActivityHelper.MenuKLists1.size()==0) {
                ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K9);
            }else {
                ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K9);
            }

        }else if (gBakFlag.equals(ItemTitleHelper.K10)) {
            if (ActivityHelper.MenuKLists1.size()==0) {

                ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K10);
            }else {
                ActivityHelper.MenuList=ActivityHelper.MenuKLists1.get(ItemTitleHelper.K10);
                // ActivityHelper.MenuList=ActivityHelper.setItemMenuK(ItemTitleHelper.K5); // 需要该一下
            }

        }
        String pic =ItemTitleHelper.mapSysModuleItems.get("跟单").get(gBakFlag).get("图片启用");
        if (pic.equals("N")){
            imgCusCard.setVisibility(View.GONE);
        }else {

        }
        initData();
        initDataOnClickListener();

    }

    private void initData() {
        this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
        this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
        this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
        ZDYzuhe1.SetMenu(ActivityHelper.MenuList.get(0));
        ZDYzuhe2.SetMenu(ActivityHelper.MenuList.get(1));
        ZDYzuhe3.SetMenu(ActivityHelper.MenuList.get(2));
        ZDYzuhe4.SetMenu(ActivityHelper.MenuList.get(3));
        ZDYzuhe5.SetMenu(ActivityHelper.MenuList.get(4));
        ZDYzuhe6.SetMenu(ActivityHelper.MenuList.get(5));


    }

    private void initDataOnClickListener() {
        imgCusCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnPhotoClick();
            }
        });

        ZDYzuhe1.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=1;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {
               ZDY1();
            }
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe2.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=2;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {
                ZDY2();
            }
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe3.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=3;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {
                ZDY3();
            }
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe4.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=4;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {
                ZDY4();
                }
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe5.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=5;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {
                ZDY5();
               }
            @Override
            public void OnClickListener3() {}
        });
        ZDYzuhe6.setgifView(new ZDYzuhe.GifViewOnClickListener() {
            @Override
            public void OnClickListener1() {scanFlag=6;onOpenScanBarcode();}
            @Override
            public void OnClickListener2() {
                ZDY6();
                }
            @Override
            public void OnClickListener3() {}
        });

    }






    public void ZDY1()
    {
        String[] strings={ZDYzuhe1.GetText()};
        ZDYzuheHelper.ZDY(ByView1Activity.this,ZDYzuhe1,strings,gBakFlag,1);
    }
    public void ZDY2()
    {
        String[] strings={ZDYzuhe2.GetText(),ZDYzuhe1.GetText()};
        ZDYzuheHelper.ZDY(ByView1Activity.this,ZDYzuhe2,strings,gBakFlag,2);
    }
    public void ZDY3()
    {
        String[] strings={ZDYzuhe3.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText()};
        ZDYzuheHelper.ZDY(ByView1Activity.this,ZDYzuhe3,strings,gBakFlag,3);
    }
    public void ZDY4()
    {
        String[] strings={ZDYzuhe4.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText(),ZDYzuhe3.GetText()};
        ZDYzuheHelper.ZDY(ByView1Activity.this,ZDYzuhe4,strings,gBakFlag,4);
    }
    public void ZDY5()
    {
        String[] strings={ZDYzuhe5.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText(),ZDYzuhe3.GetText(),ZDYzuhe4.GetText()};
        ZDYzuheHelper.ZDY(ByView1Activity.this,ZDYzuhe5,strings,gBakFlag,5);

    }
    public void ZDY6()
    {
        String[] strings={ZDYzuhe6.GetText(),ZDYzuhe1.GetText(),ZDYzuhe2.GetText(),ZDYzuhe3.GetText(),ZDYzuhe4.GetText(),ZDYzuhe5.GetText()};
        ZDYzuheHelper.ZDY(ByView1Activity.this,ZDYzuhe6,strings,gBakFlag,6);
    }

    public void onBtnPhotoClick() {
        String strFilePath = ActivityHelper.getFilePathNoName();
        if (strFilePath != null) {
            SimpleDateFormat sDateFormat = new SimpleDateFormat(
                    "yyyyMMddhhmmss");
            String date = sDateFormat.format(new java.util.Date());
            if(!ActivityHelper.savedImagePath.contains(mFileName))
            {
                File file=new File(mFileName);
                if(file.exists()) file.delete();
            }
            mFileName = strFilePath + "/image/i" + date + ".jpg";
            bOpenCamera=true;
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            Uri imageUri = Uri.fromFile(new File(mFileName));
            intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            startActivityForResult(intent, 1);
        } else {
            ActivityHelper.showDialog(this, "错误", getString(R.string.noPath));
        }
    }
    private void intoNextActivity()
    {
        if (mFileName != null) {
            File file = new File(mFileName);

            if (file.exists()) {

                Bitmap bitmap = ActivityHelper.fileToBitmap(mFileName);
                imgCusCard.setImageBitmap(bitmap);


              //  g_BakModuleInfo.strImgPath = mFileName;
            }
        }
    }


    public void onNext()
    {
        if(ZDYzuhe1.GetText().equals("")||ZDYzuhe2.GetText().equals("")||ZDYzuhe3.GetText().equals("")|| ZDYzuhe4.GetText().equals("")||ZDYzuhe5.GetText().equals("")||ZDYzuhe6.GetText().equals(""))
        {
            ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
            return ;
        }
        ActivityHelper.BYModel.BYName1v=ZDYzuhe1.GetText();
        ActivityHelper.BYModel.BYName2v=ZDYzuhe2.GetText();
        ActivityHelper.BYModel.BYName3v=ZDYzuhe3.GetText();
        ActivityHelper.BYModel.BYName4v=ZDYzuhe4.GetText();
        ActivityHelper.BYModel.BYName5v=ZDYzuhe5.GetText();
        ActivityHelper.BYModel.BYName6v=ZDYzuhe6.GetText();
        ActivityHelper.BYModel.ImgPath=mFileName;
        Intent intent=new Intent(this,ByView2Activity.class);
        if (ActivityHelper.MenuList.get(5).instant.equals("Y")&&ActivityHelper.MenuList.get(5).strEnabled.equals("Y")) {
            intent.putExtra("instant", "6");
        }else if (ActivityHelper.MenuList.get(4).instant.equals("Y")&&ActivityHelper.MenuList.get(4).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "5");
        }else if (ActivityHelper.MenuList.get(3).instant.equals("Y")&&ActivityHelper.MenuList.get(3).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "4");
        }else if (ActivityHelper.MenuList.get(2).instant.equals("Y")&&ActivityHelper.MenuList.get(2).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "3");
        }else if (ActivityHelper.MenuList.get(1).instant.equals("Y")&&ActivityHelper.MenuList.get(1).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "2");
        }else if (ActivityHelper.MenuList.get(0).instant.equals("Y")&&ActivityHelper.MenuList.get(0).strEnabled.equals("Y")) {
            intent.putExtra("instant",  "1");
        }
//
        startActivity(intent);

    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_SCAN_QRCODE_FLAG)
        {//条码扫描完毕返回
            if(resultCode== Activity.RESULT_OK)
            {
                Bundle bundle = data.getExtras();
                String strRst=bundle.getString("result");
                if(scanFlag==1){
                    ZDYzuhe1.SetEditText(strRst);
                    if (ZDYzuhe1.getMenu().instant.equals("Y")) {
                        ZDY1();
                    }
                }
                else if(scanFlag==2){
                    ZDYzuhe2.SetEditText(strRst);
                    if (ZDYzuhe2.getMenu().instant.equals("Y")) {
                        ZDY2();
                    }

                }
                else if(scanFlag==3){
                    ZDYzuhe3.SetEditText(strRst);
                    if (ZDYzuhe3.getMenu().instant.equals("Y")) {
                        ZDY3();
                    }
                }
                else if(scanFlag==4){
                    ZDYzuhe4.SetEditText(strRst);
                    if (ZDYzuhe4.getMenu().instant.equals("Y")) {
                        ZDY4();
                    }

                }
                else if(scanFlag==5){
                    ZDYzuhe5.SetEditText(strRst);
                    if (ZDYzuhe5.getMenu().instant.equals("Y")) {
                        ZDY5();
                    }
                }
                else if(scanFlag==6){
                    ZDYzuhe6.SetEditText(strRst);
                    if (ZDYzuhe6.getMenu().instant.equals("Y")) {
                        ZDY6();
                    }
                }

            }
        }else if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                if (ActivityHelper.bCutPhoto) {//设置为不裁剪
                    bOpenCamera=true;
                    mPreFileNameCut=mFileName;
                    mFileName= CameraTool.cropImageUri(this,Uri.fromFile(new File(mPreFileNameCut)), 2);
                } else
                    intoNextActivity();
            }
        }
        else{
            ActivityHelper.ToastShow(ByView1Activity.this, "扫描失败");
        }
    }

    @Override
    public void processMessage(int msgId, String msg) {

    }
}
