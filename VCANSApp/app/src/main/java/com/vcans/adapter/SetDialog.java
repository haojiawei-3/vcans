package com.vcans.adapter;

import java.util.HashMap;

import com.Vcan.activity.R;
import com.vcans.tool.ActivityHelper;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * 设置对话框 以对话框形式设置相关参数
 * @author vcans
 *
 */
public class SetDialog{

	private Dialog mDialog;
	private int[] szRIds;
	private String[] mParams;
	private int layoutItemId;
	private CheckBox checkBox;
	private HashMap<String, String> mapParms;
	private Activity parent;

	/**
	 * @param parent
	 * @param layoutItemId  资源布局文件Id
	 * @param rIds		        布局文件中控件Id数组
	 * @param params        用来存储布局文件中控件Id值的 参数数组
	 */
	public SetDialog(Activity parent,int layoutItemId,int[] rIds,String[] params)
	{
		this.parent=parent;
		szRIds=rIds;
		mParams=params;
		this.layoutItemId=layoutItemId;
	}

	final OnClickListener onOKListener = new OnClickListener() {

		public void onClick(View arg0) {

			if (arg0.getId() == R.id.btnOk) {

				if(mParams.length==szRIds.length)
				{
					mapParms = new HashMap<String, String>();
					View v;
					for(int i=0;i<mParams.length;++i)
					{
						v=mDialog.findViewById(szRIds[i]);
						if(v instanceof CheckBox)
						{
							checkBox=(CheckBox)v;

							mapParms.put(mParams[i], checkBox.isChecked() ? "1": "0");
						}
					}


					ActivityHelper.saveParams(parent, mapParms);

					ActivityHelper.ToastShow(parent, parent.getString(R.string.saveSuccess));
				}
				else
					ActivityHelper.ToastShow(parent, parent.getString(R.string.saveFail));

				new Handler().postDelayed(new Runnable() {

					public void run() {

						mDialog.dismiss();
					}
				}, 1000);

			} else if (arg0.getId() == R.id.btnClose) {
				mDialog.dismiss();
			}
		}

	};


	public void show() {
		mDialog = new Dialog(parent);
		mDialog.setTitle(parent.getString(R.string.set));
		mDialog.setContentView(layoutItemId);

		Button btnOk = (Button) mDialog.findViewById(R.id.btnOk);
		btnOk.setOnClickListener(onOKListener);

		Button btnClose = (Button) mDialog.findViewById(R.id.btnClose);
		btnClose.setOnClickListener(onOKListener);

		if(mParams.length==szRIds.length)
		{
			mapParms =ActivityHelper.getParams(parent, this.mParams);

			if (mapParms.size() > 0) {
				View view;
				for(int i=0;i<mParams.length;++i)
				{
					view=mDialog.findViewById(szRIds[i]);
					if(view instanceof CheckBox)
					{
						checkBox=(CheckBox)view;

						checkBox.setChecked(mapParms.get(mParams[i]).equals("1"));
					}
				}
			}
		}
		else
		{
			//提示参数数量不对
		}


		mDialog.show();
	}
}
