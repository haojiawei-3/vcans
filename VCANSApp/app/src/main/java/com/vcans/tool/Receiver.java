package com.vcans.tool;

import java.io.File;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
			String    packageName = intent.getDataString();
			Log.e("TAG", packageName);
		}
	}

	public boolean deleteSDFile(File file) {

		//file目标文件夹绝对路径

		if (file.exists()) { //指定文件是否存在
			if (file.isFile()) { //该路径名表示的文件是否是一个标准文件
				file.delete(); //删除该文件
			} else if (file.isDirectory()) { //该路径名表示的文件是否是一个目录（文件夹）
				File[] files = file.listFiles(); //列出当前文件夹下的所有文件
				for (File f : files) {
					deleteSDFile(f); //递归删除
					Log.d("fileName", f.getName()); //打印文件名
				}
			}
			file.delete(); //删除文件夹（song,art,lyric）
		}
		return true;
	}


}
