package com.vcans.tool;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.WindowManager;

public class CameraTool {

	public static String cropImageUri(Activity parent,Uri uri, int requestCode) {

		WindowManager wm = (WindowManager) parent.getSystemService(Context.WINDOW_SERVICE);

		
		String fileName;
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", 1200);
		intent.putExtra("outputY", 1200);
		
		intent.putExtra("scale", false);
		fileName=uri.getPath();
		fileName=fileName.substring(0, fileName.length()-4);
		fileName+="_c.jpg";
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(fileName)));
		intent.putExtra("return-data", false);
		intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		intent.putExtra("noFaceDetection", true); // no face detection
		parent.startActivityForResult(intent, requestCode);
		
		return fileName;
	}
}
