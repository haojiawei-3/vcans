package com.Vcan.activity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.GDQueryDownGoodsProcessor;
import com.vcans.Processor.GDQueryDownPicProcessor;
import com.vcans.adapter.GridViewAdapter;
import com.vcans.adapter.GridViewAdapter.CheckInterfaces;
import com.vcans.dao.DBHelper;
import com.vcans.model.DataListModel;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 综合查询结果
 * @author vcans
 *
 */
public class GDQuery3Result extends BaseActivity  implements CheckInterfaces {
    //	public static GDQueryResult gdQueryResult = null;
    @Bind(R.id.btn_fx)
    TextView btn_fx;
    @Bind(R.id.btn_xz)
    TextView btn_xz;
    @Bind(R.id.btn_sc)
    TextView btn_sc;
    @Bind(R.id.btn_cancel)
    TextView btn_cancel;
    @Bind(R.id.img_fx)
    ImageView img_fx;
    @Bind(R.id.img_xz)
    ImageView img_xz;
    @Bind(R.id.img_sc)
    ImageView img_sc;
    @Bind(R.id.img_cancel)
    ImageView img_cancel;
    ArrayList<String>  id=new ArrayList<String>();
    private ListView mLvTouPei;
    private GridView GridView;
    LinearLayout pop_layout;
    ArrayList<File>  Files=new ArrayList<File>();
    Bitmap[] szBitmap;
    ContentValues values = new ContentValues();
    SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
    private GDQueryDownGoodsProcessor downGoods=new GDQueryDownGoodsProcessor(GDQuery1.gQueryFlag);
    private GDQueryDownPicProcessor picProcessordownGoods=new GDQueryDownPicProcessor(GDQuery1.gQueryFlag);
    private TextView tvPage ,tvActtitle;
    private  GridViewAdapter GridViewAdapter;
    List<DataListModel>  DataList=new ArrayList<>();
    boolean aBoolean  = false;
    private Handler handler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            //更新UI
            switch (msg.what)
            {
                case 1:
                    GridViewAdapter.setData(DataList);
                    break;
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.gd_query_result);
        ButterKnife.bind(this);
        this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
        setListItemClickMethod("onGoodsItemClick","");
        this.<ImageView>RegOnClickEvent(R.id.img_fx,"btn_fx");
        this.<ImageView>RegOnClickEvent(R.id.img_xz,"btn_xz");
        this.<ImageView>RegOnClickEvent(R.id.img_sc,"btn_sc");
        this.<ImageView>RegOnClickEvent(R.id.img_cancel,"btn_cancel");
        this.<TextView>RegOnClickEvent(R.id.btn_fx,"btn_fx");
        this.<TextView>RegOnClickEvent(R.id.btn_xz,"btn_xz");
        this.<TextView>RegOnClickEvent(R.id.btn_sc,"btn_sc");
        this.<TextView>RegOnClickEvent(R.id.btn_cancel,"btn_cancel");
        pop_layout=(LinearLayout)this.findViewById(R.id.include);
        tvActtitle=(TextView)this.findViewById(R.id.tvActtitle);
        mLvTouPei=(ListView)this.findViewById(R.id.lvProdct);
        tvPage=(TextView)this.findViewById(R.id.tvPage);
        GridView=(GridView)this.findViewById(R.id.GridView);
        btn_sc.setTextColor(this.getResources().getColor(R.color.dimgray));
        GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(GDQuery3Result.this, XYImgActivity.class);  //XYImageView  替换
                ActivityHelper.szBitmaps = szBitmap(ActivityHelper.DataList);
                intent.putExtra("imgIndex", position);
                intent.putExtra("module", 0);
                startActivity(intent);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
            }
        });
        try {
            String processor =ItemTitleHelper.mapSysModuleItems.get("跟单").get(GDQuery1.gQueryFlag).get("启用为图片下载");
            Result(processor);
        }catch (Exception e){
            String processor =ItemTitleHelper.mapSysModuleItems.get("信息中心").get(GDQuery1.gQueryFlag).get("启用为图片下载");
            Result(processor);
        }


    }
    public Bitmap[]  szBitmap( List<HashMap<String,Object> > s){
        szBitmap=new Bitmap[s.size()];
        for (int i=0;i<s.size();i++){
            HashMap<String,Object> b=s.get(i);
            szBitmap[i]= (Bitmap) b.get("images");
        }
        return szBitmap;
    }




    public static File compressImage(int i, Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > 500) {  //循环判断如果压缩后图片是否大于500kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            options -= 10;//每次都减少10
            bitmap.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            long length = baos.toByteArray().length;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        String filename = format.format(date);
        File file = new File(Environment.getExternalStorageDirectory(),i+filename+".png");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            try {
                fos.write(baos.toByteArray());
                fos.flush();
                fos.close();
            } catch (IOException e) {
                //    BAFLogger.e(TAG,e.getMessage());
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            //   BAFLogger.e(TAG,e.getMessage());
            e.printStackTrace();
        }
        // recycleBitmap(bitmap);
        return file;
    }

    public void    btn_cancel(){
        pop_layout.setVisibility(View.GONE);
    }

    public void    btn_xz(){
        if(btn_xz.getText().equals("不全选")){
            for (int i = 0; i < DataList.size(); i++)
            {
                DataList.get(i).setChoosed(false);
                aBoolean=false;
                btn_xz.setText("全选");
            }
        }else {
            for (int i = 0; i < DataList.size(); i++)
            {
                DataList.get(i).setChoosed(true);
                // aBoolean=true;
                btn_xz.setText("不全选");
            }
        }

        handler.sendEmptyMessage(1);
    }

    public void    btn_fx(){
        Files.clear();
        for (int i = 0; i < DataList.size(); i++){
            DataListModel  Model=DataList.get(i);
            if (Model.isChoosed()){
                Files.add(compressImage(i,(Bitmap) Model.DataList.get("images")));
            }
        }
        pic(Files);
    }

    public void    btn_sc(){

        for (int i = 0; i < DataList.size(); i++)
        {
            DataList.get(i).setChoosed(false);
        }
        handler.sendEmptyMessage(1);
        ActivityHelper.ToastShow(GDQuery3Result.this,"无法删除");
    }

    public void  Result(String processor){

        SendParam sendParam = new SendParam();
        sendParam.parent = this;
        sendParam.szData=new String[]{
                ActivityHelper.GDXCModel.GDName1v,
                ActivityHelper.GDXCModel.GDName2v,
                ActivityHelper.GDXCModel.GDName3v,
                ActivityHelper.GDXCModel.GDName4v,
                ActivityHelper.GDXCModel.GDName5v,
                ActivityHelper.GDXCModel.GDName6v,
                ActivityHelper.GDXCModel.GDName7v,
                ActivityHelper.GDXCModel.GDName8v,
                ActivityHelper.GDXCModel.GDName9v,
                ActivityHelper.GDXCModel.GDName10v,
                ActivityHelper.GDXCModel.GDName11v,
                ActivityHelper.GDXCModel.GDName12v,
        };
        if (processor.equals("Y")){
            sendParam.processor= picProcessordownGoods;
            ActivityHelper.DataList.clear();
            GridView.setVisibility(View.VISIBLE);

        }else {
            sendParam.processor= downGoods;
            mLvTouPei.setVisibility(View.VISIBLE);
        }
        getDataTrunsfer().request(sendParam);
    }


    public void onGoodsItemClick(int index)
    {
        //获得选中项的HashMap对象
        HashMap<String,Object> mapToupei=(HashMap<String,Object>)mLvTouPei.getItemAtPosition(index);

        String[] szStr=tvPage.getText().toString().split("/");
        tvPage.setText("("+(index+1)+"/"+szStr[1]);
    }

    public void onGoodsItemDbClick(int index)
    {
        //获得选中项的HashMap对象
        HashMap<String,Object> mapToupei=(HashMap<String,Object>)mLvTouPei.getItemAtPosition(index);

        List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
        mDataList.add(mapToupei);
        // downGoods.displayDetail(mDataList);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void processMessage(int msgId, String msg) {
        // TODO Auto-generated method stub
        if (msgId==1000){
            DataList.clear();
            for (int i=0;i<ActivityHelper.DataList.size();i++){
                HashMap<String,Object> Data=ActivityHelper.DataList.get(i);
                DataListModel   DataListModel=new DataListModel(Data);
                DataList.add(DataListModel);
            }
            GridViewAdapter=new GridViewAdapter(GDQuery3Result.this,DataList);
            GridViewAdapter.setCheckInterfaces(this);
            GridView.setAdapter(GridViewAdapter);
            handler.sendEmptyMessage(1);//发送消息


        }else if(msgId==200){
            db.delete(DBHelper.History,null,null);
            for(int j = 0; j<ActivityHelper.DataList.size();j++){
                HashMap<String,Object>  bitmap=  ActivityHelper.DataList.get(j);
                Bitmap  map= (Bitmap) bitmap.get("images");
                ActivityHelper.saveBitmap2file(map,"images"+j);
                String filePath=ActivityHelper.getFilePathNoName()+"/image/"+"images"+j+".jpg";
                values.put("Type","1");                         //这个字段便于扩展   根据模块不同  做为标准
                values.put("ImagePath",filePath);
                values.put("Spare1",   "null");
                values.put("Spare2",   "null");
                values.put("Spare3",   "null");
                values.put("Spare4",   "null");
                values.put("Spare5",   "null");
                values.put("Spare6",   "null");
                values.put("Spare7",   "null");
                db.insert("History", null, values);
            }
        }

    }


    public   void  pic(ArrayList<File> files) {
        Intent share_intent = new Intent();
        ArrayList<Uri> imageUris = new ArrayList<Uri>();
        Uri uri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (File f : files) {
                Uri imageContentUri = getImageContentUri(GDQuery3Result.this, f);
                imageUris.add(imageContentUri);
            }
        } else {
            for (File f : files) {
                imageUris.add(Uri.fromFile(f));
            }
        }
        share_intent.setAction(Intent.ACTION_SEND_MULTIPLE);//设置分享行为
        share_intent.setType("image/png");//设置分享内容的类型
        share_intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        share_intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        startActivity(Intent.createChooser(share_intent, "分享"));



    }

    public static Uri getImageContentUri(Context context, File imageFile) {
        String filePath = imageFile.getAbsolutePath();
        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID}, MediaStore.Images.Media.DATA + "=? ",
                new String[]{filePath}, null);
        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex(MediaStore.MediaColumns._ID));
            Uri baseUri = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(baseUri, "" + id);
        } else {
            if (imageFile.exists()) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATA, filePath);
                return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            } else {
                return null;
            }
        }
    }



    @Override
    public void checkGroup(int Position, boolean isChecked) {
        for (int i = 0; i < DataList.size(); i++)
        {
            if (i==Position){
                DataList.get(i).setChoosed(isChecked);
                //  ActivityHelper.ToastShow(GDQuery3Result.this, (String) DataList.get(i).DataList.get("images"));
            }
            if (DataList.get(i).isChoosed()==false){

            }else {
                aBoolean=true;
            }
        }
        handler.sendEmptyMessage(1);
        if (aBoolean==false){
            pop_layout.setVisibility(View.GONE);
        }else {
            pop_layout.setVisibility(View.VISIBLE);
        }

    }
}
