package com.Vcan.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;

import com.vcans.adapter.MPAdapter;
import com.vcans.adapter.GridViewAdapter.CheckInterfaces;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vcans.Processor.BaseActivity;
import com.vcans.adapter.GridViewAdapter;
import com.vcans.model.DataListModel;
import com.vcans.tool.ActivityHelper;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HistoryActivity extends BaseActivity implements CheckInterfaces {
    @Bind(R.id.GridView)
    GridView GridView;
//    private GridLayoutManager mLayoutManager;
    @Bind(R.id.tvActtitle)
    TextView tvActtitle;

//    @Bind(R.id.grid_recycler)
//    RecyclerView recyclerview;

    @Bind(R.id.include)
    LinearLayout  pop_layout;

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
    private MPAdapter mAdapter;
    boolean aBoolean  = false;
    Bitmap[] szBitmap;
    GridViewAdapter GridViewAdapter;
    HashMap<String,Object> HashMap ;
    SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
    Cursor cursor;
    ArrayList<File>  Files=new ArrayList<File>();
    ArrayList<String>  id=new ArrayList<String>();
    List<DataListModel>  DataLists=new ArrayList<>();
    private Handler handler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            //更新UI
            switch (msg.what)
            {
                case 1:
                    GridViewAdapter.setData(DataLists);
                    GridViewAdapter.notifyDataSetChanged();
                    break;
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
        this.<ImageView>RegOnClickEvent(R.id.img_fx,"btn_fx");
        this.<ImageView>RegOnClickEvent(R.id.img_xz,"btn_xz");
        this.<ImageView>RegOnClickEvent(R.id.img_sc,"btn_sc");
        this.<ImageView>RegOnClickEvent(R.id.img_cancel,"btn_cancel");
        this.<TextView>RegOnClickEvent(R.id.btn_fx,"btn_fx");
        this.<TextView>RegOnClickEvent(R.id.btn_xz,"btn_xz");
        this.<TextView>RegOnClickEvent(R.id.btn_sc,"btn_sc");
        this.<TextView>RegOnClickEvent(R.id.btn_cancel,"btn_cancel");
//


        GridView=(GridView)this.findViewById(R.id.GridView);
        GridViewAdapter=new GridViewAdapter(HistoryActivity.this,History());
        GridViewAdapter.setCheckInterfaces(this);
        GridView.setAdapter(GridViewAdapter);
        GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(HistoryActivity.this, XYImgActivity.class);  //XYImageView  替换
                ActivityHelper.szBitmaps =szBitmap(Historys());
                intent.putExtra("imgIndex", position);
                intent.putExtra("module", 0);
                startActivity(intent);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });
   }

    public void    btn_cancel(){
        pop_layout.setVisibility(View.GONE);
    }

    public void    btn_xz(){
        if(btn_xz.getText().equals("不全选")){
            for (int i = 0; i < DataLists.size(); i++)
            {
                DataLists.get(i).setChoosed(false);
                aBoolean=false;
                btn_xz.setText("全选");
            }
        }else {
            for (int i = 0; i < DataLists.size(); i++)
            {
                DataLists.get(i).setChoosed(true);
                // aBoolean=true;
                btn_xz.setText("不全选");
            }
        }

        handler.sendEmptyMessage(1);
    }

    public void    btn_fx(){
        Files.clear();
        for (int i = 0; i < DataLists.size(); i++){
            DataListModel  Model=DataLists.get(i);
            if (Model.isChoosed()){
                Files.add(compressImage(i,(Bitmap) Model.DataList.get("images")));
            }
        }
        pic(Files);
    }

    public void    btn_sc(){
        // 得到要删除的图片名
        for (int i = 0; i < DataLists.size(); i++)
        {
            if (DataLists.get(i).isChoosed()){
                id.add(DataLists.get(i).imgname);
            }else {


            }
        }
        //数据库删除
        for (int i = 0; i < id.size(); i++)
        {
            db.execSQL("delete from History  where ImagePath = ?",   new Object[]{id.get(i)});
        }
        //更新界面
        DataLists.clear();
        History();
        //还原标记
        for (int i = 0; i < DataLists.size(); i++)
        {
            DataLists.get(i).setChoosed(false);
        }
        handler.sendEmptyMessage(1);
    }

    public Bitmap[]  szBitmap( List<HashMap<String,Object> > s){
        szBitmap=new Bitmap[s.size()];
        for (int i=0;i<s.size();i++){
            HashMap<String,Object> b=s.get(i);
            szBitmap[i]= (Bitmap) b.get("images");
        }
        return szBitmap;
    }

    public   List<DataListModel>  History()   {
        List<DataListModel> DataList=new ArrayList<DataListModel >();
        String sql="select * from History where Type = 1 ";

        cursor = db.rawQuery(sql, new String[]{});
        while (cursor.moveToNext()) {
            String strmlname = cursor.getString(2);
            try {
                HashMap =new HashMap<String,Object>();
                HashMap.put("images",decodeFile(strmlname));
                DataListModel DataListModel=new DataListModel(HashMap,strmlname);



                DataLists.add(DataListModel);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        cursor.close();
        return DataLists;
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

    public    List<HashMap<String,Object> > Historys()   {
        List<HashMap<String,Object> > DataList=new ArrayList<HashMap<String,Object> >();
        String sql="select * from History where Type = 1 ";

        cursor = db.rawQuery(sql, new String[]{});
        while (cursor.moveToNext()) {
            String strmlname = cursor.getString(2);
            try {
                HashMap =new HashMap<String,Object>();
                HashMap.put("images",decodeFile(strmlname));
                DataList.add(HashMap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        cursor.close();




        return DataList;
    }

    public   void  pic(ArrayList<File> files) {
        Intent share_intent = new Intent();
        ArrayList<Uri> imageUris = new ArrayList<Uri>();
        Uri uri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (File f : files) {
                Uri imageContentUri = getImageContentUri(HistoryActivity.this, f);
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
        startActivity(Intent.createChooser(share_intent, "Share"));



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

    public  Bitmap decodeFile(String filePath) throws IOException {
        Bitmap b = null;
        int IMAGE_MAX_SIZE = 600;

        File f = new File(filePath);
        if (f == null){
            return null;
        }
        //Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;

        FileInputStream fis = new FileInputStream(f);
        BitmapFactory.decodeStream(fis, null, o);
        fis.close();

        int scale = 1;
        if (o.outHeight > IMAGE_MAX_SIZE || o.outWidth > IMAGE_MAX_SIZE) {
            scale = (int) Math.pow(2, (int) Math.round(Math.log(IMAGE_MAX_SIZE / (double) Math.max(o.outHeight, o.outWidth)) / Math.log(0.5)));
        }

        //Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        fis = new FileInputStream(f);
        b = BitmapFactory.decodeStream(fis, null, o2);
        fis.close();
        return b;
    }
    @Override
    public void processMessage(int msgId, String msg) {

    }
    //  MorePopWindow02 Window02 = new MorePopWindow02(HistoryActivity.this);
    ////              设置Popupwindow显示位置（从底部弹出）
//        Window02.showAtLocation(findViewById(R.id.tvActtitle),
//        Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
    @Override
    public void checkGroup(int Position, boolean isChecked) {
        for (int i = 0; i < DataLists.size(); i++)
        {
            if (i==Position){
                DataLists.get(i).setChoosed(isChecked);
                //  ActivityHelper.ToastShow(GDQuery3Result.this, (String) DataList.get(i).DataList.get("images"));
            }
            if (DataLists.get(i).isChoosed()==false){

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
