package com.Vcan.activity;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPMenuProcessor;
import com.vcans.Processor.DPUserProcessor;
import com.vcans.model.SendParam;
import com.vcans.model.User;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;
import com.vcans.tool.PlProcessor;



public class VcansLogin extends BaseActivity {

	Spinner mTxtUserName;
	EditText mTxtPwd;
	CheckBox mChkBox;
	CheckBox mAutoLogin;
	private DPUserProcessor loginProce=null;
	private DPMenuProcessor menuProcessor;
	String strUser="";
	String strPwd="";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vcans_login);

		this.<Button>RegOnClickEvent(R.id.btnLogin,"onLogin");
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		//initState();
		mTxtUserName=(Spinner)this.findViewById(R.id.dropUser);
		mTxtPwd=(EditText)this.findViewById(R.id.txtPwd);
		mTxtPwd.addTextChangedListener(mPwdWatcher);
		mChkBox=(CheckBox)this.findViewById(R.id.chkSavePwd);
		mAutoLogin=(CheckBox)this.findViewById(R.id.chkAutoLogin);
		TextView tvTitle = (TextView) this.findViewById(R.id.tvActtitle);
		tvTitle.setTypeface(this.getTypeFace());

		this.<Button>RegOnClickEvent(R.id.btnClearPwd,"onClearPwd");
		this.<Button>RegOnClickEvent(R.id.btnLoadUser,"onLoadUser");
		this.<CheckBox>RegOnClickEvent(R.id.chkSavePwd,"onCheckClick");
		this.<CheckBox>RegOnClickEvent(R.id.chkAutoLogin,"onAutoLoginCheck");

		PlProcessor.SetParent(this);
		menuProcessor=new DPMenuProcessor();

		loginProce=new DPUserProcessor();
		loginProce.InitDropUser();
		onLoadUser();
	}


	public void onLoadUser()
	{
		SendParam sendParam=new SendParam();
		sendParam.parent=this;
		sendParam.tip=getString(R.string.btn_load)+"...";
		sendParam.processor=loginProce;
		getDataTrunsfer().request(sendParam);
	}


	public void onCheckClick()
	{
		String user=mTxtUserName.getSelectedItem().toString();
		String pwd=mTxtPwd.getText().toString().trim();

		if(!user.equals("")&&!pwd.equals(""))
		{


			if(mChkBox.isChecked())
			{
				mAutoLogin.setEnabled(true);
			}
			else
			{
				mAutoLogin.setEnabled(false);
				mAutoLogin.setChecked(false);
			}

			HashMap<String,String> mapParms=new HashMap<String,String>();
			mapParms.put("isSave", mChkBox.isChecked()?"1":"0");
			mapParms.put("isAutoLogin", mAutoLogin.isChecked()?"1":"0");
			ActivityHelper.saveParams(this,mapParms);
		}
		else
		{
			mChkBox.setChecked(false);
			ActivityHelper.showDialog(this,"提示",getString(R.string.rememberValid));
		}
	}

	public void onAutoLoginCheck()
	{
		HashMap<String,String> mapParms=new HashMap<String,String>();
		mapParms.put("isAutoLogin", mAutoLogin.isChecked()?"1":"0");
		ActivityHelper.saveParams(VcansLogin.this,mapParms);
	}



	public void onClearPwd()
	{
		mTxtPwd.setText("");
	}

	final  TextWatcher mPwdWatcher= new TextWatcher() {

		public void onTextChanged(CharSequence s, int start, int before, int count) {


		}

		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			Button btn=(Button) findViewById(R.id.btnClearPwd);


			if(s.toString().trim().equals(""))
			{
				btn.setVisibility(View.INVISIBLE);
			}
			else
			{
				btn.setVisibility(View.VISIBLE);
			}
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
									  int after) {
			// TODO Auto-generated method stub

		}
	} ;


	public void onLogin()
	{
		strUser=mTxtUserName.getSelectedItem().toString();
		strPwd=mTxtPwd.getText().toString().trim();

		if(!strPwd.equals("")&&!strUser.equals(""))
		{
			String[] szData={strUser,strPwd};



			SendParam sendParam=new SendParam();
			sendParam.parent=VcansLogin.this;//设置为为窗体，以便回调主窗体中的方法
			sendParam.tip=getString(R.string.login)+"...";
			sendParam.szData=szData;
			sendParam.processor=menuProcessor;
			menuProcessor.setLstMenu(ItemTitleHelper.getMenuInfo());
			menuProcessor.setLstMenu2(ItemTitleHelper.getMenuxx());
			getDataTrunsfer().request(sendParam);

//			 new Handler().postDelayed(new Runnable(){
//
//					public void run() {
//
//						if(BaseActivity.gUser==null)
//						{
			//					ActivityHelper.showDialog(VcansLogin.this, "错误",getString(R.string.loginFail));
//						}
//					}
//				 }, 20000);
		}
		else
			ActivityHelper.showDialog(this, "错误",getString(R.string.userNoNull));

	}

	@Override
	public void processMessage(int msgId, String msg)
	{
		if(msgId==11)
		{//下载用户名成功
			HashMap<String,String> mapParms=ActivityHelper.getParams(this, new String[]{"isSave","isAutoLogin","user_name","password"});

			if(mapParms.size()>0)
			{
				if(mapParms.get("isSave").equals("1"))
				{
					mChkBox.setChecked(true);//
					this.setSpinnerItemSelectedByValue(mTxtUserName, mapParms.get("user_name"));
					mTxtPwd.setText(mapParms.get("password"));
					mAutoLogin.setEnabled(true);
				}

				if(mapParms.get("isAutoLogin").equals("1"))
				{
					mAutoLogin.setChecked(true);
				}
			}
		}
		else
		{//验证密码完成

			User user = new User();
			user.setUserName(strUser);
			user.setPwd(strPwd);
			user.setSzPower(menuProcessor.getSzMenuEnable());
			user.setSzItemPower(menuProcessor.getSZItemEnable());
			BaseActivity.gUser = user;

			ActivityHelper.gToupei.strUser = user.getUserName();
			ActivityHelper.gToupei.strPwd = user.getPwd();

			if(mChkBox.isChecked())
			{
				HashMap<String,String> mapParms=new HashMap<String,String>();
				mapParms.put("user_name", strUser);
				mapParms.put("password", strPwd);

				ActivityHelper.saveParams(this,mapParms);
			}

			Intent resultIntent = new Intent();
			resultIntent.putExtra("sucess", 1);
			this.setResult(2, resultIntent);

			ActivityHelper.showTempDialog(this,getString(R.string.loginSuccess),1000,true);	//登录成功跳转
		}
	}
}
