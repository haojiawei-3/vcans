package com.Vcan.activity;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.tool.ActivityHelper;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;


public class Pendingapproval001 extends BaseActivity {

	//ZoomImageView  本来是这个  改   PhotoView
	private PhotoView zoomImg;
	TextView tvTitle;
	String tp;
	Bitmap bitmap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pendingapproval001);
		zoomImg = (PhotoView) findViewById(R.id.image);

		this.<Button> RegOnClickEvent(R.id.btnBack, "finish");
		tvTitle = (TextView) findViewById(R.id.tvActtitle);
		this.setTitle(getString(R.string.image));
		//设置TOP颜色

		 tp=ActivityHelper.filePaths;

	//	bitmap = BitmapFactory.decodeFile(tp);
		zoomImg.setImageBitmap(ActivityHelper.BitmapFactory(tp, 1));
	//	zoomImg.setImageBitmap(bitmap);

//		zoomImg.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
//			@Override
//			public void onPhotoTap(View view, float v, float v1) {
//				pic(ActivityHelper.BitmapFactory(tp, 1));
//			}
//		});
        zoomImg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                pic(ActivityHelper.BitmapFactory(tp, 1));
                return false;
            }
        });

	}
    public  void  pic(Bitmap b){
		Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), b, null,null));
	Intent intent = new Intent();
	intent.setAction(Intent.ACTION_SEND);//设置分享行为
	intent.setType("image/*");//设置分享内容的类型
	intent.putExtra(Intent.EXTRA_STREAM, uri);
	intent = Intent.createChooser(intent, "分享");
	startActivity(intent);}

	public  void  pic(ArrayList<File> files) {
		Intent share_intent = new Intent();
		ArrayList<Uri> imageUris = new ArrayList<Uri>();
		Uri uri;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			for (File f : files) {
				Uri imageContentUri = getImageContentUri(Pendingapproval001.this, f);
				imageUris.add(imageContentUri);
			}
		} else {
			for (File f : files) {
				imageUris.add(Uri.fromFile(f));
			}

			//	}
			share_intent.setAction(Intent.ACTION_SEND_MULTIPLE);//设置分享行为
			share_intent.setType("image/png");//设置分享内容的类型
			share_intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
			share_intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
			startActivity(Intent.createChooser(share_intent, "Share"));


		}
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
	protected void onDestroy() {
		// TODO Auto-generated method stub
		ActivityHelper.filePaths=null;
//		if(bitmap != null){
//			bitmap.recycle();
//			bitmap = null;
//		}
		super.onDestroy();
	}



	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
