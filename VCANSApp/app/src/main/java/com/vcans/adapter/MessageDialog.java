package com.vcans.adapter;

import java.util.HashMap;

import com.Vcan.activity.R;
import com.vcans.tool.ActivityHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class MessageDialog {



	private String title;
	private String msg;
	private boolean clickResult;
	private int clickFlag=0;;
	private String yesBtnName; // 确定按钮名称
	private String noBtnName; // 消息按钮名称

	private Activity parent;

	public MessageDialog(Activity parent, String title) {
		this.parent = parent;
		this.title = title;
		clickFlag=0;
		yesBtnName = parent.getString(R.string.ok);
		noBtnName = parent.getString(R.string.cancle);
	}

	public MessageDialog(Activity parent, String title, String yesButtonName, String noButtonName) {

		this.parent = parent;
		this.title = title;
		clickFlag=0;
		yesBtnName = yesButtonName;
		noBtnName = noButtonName;
	}

	public boolean show() {

		new AlertDialog.Builder(parent).setTitle(title).setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(yesBtnName, new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 点击“确认”后的操作
						clickResult = true;
						clickFlag=1;

					}
				}).setNegativeButton(noBtnName, new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// 点击“返回”后的操作,这里不设置没有任何操作
				clickResult = false;
				clickFlag=1;
			}
		}).show();

		return clickResult;
	}

}
