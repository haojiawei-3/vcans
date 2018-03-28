package com.Vcan.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.Vcan.activity.R;

import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPUserProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.DataTrunsfer;
import com.vcans.tool.PlProcessor;


public class DPLogin extends BaseActivity {
	 
	 private DPUserProcessor loginProce=null; 
	 int mFirstFlag=0;
	 EditText mTxtPwd;
	 
	 @Override
	 protected void onCreate(Bundle savedInstanceState) 
	 {
		 super.onCreate(savedInstanceState);
		 
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		 setContentView(R.layout.dp_login);
		 
		 this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		 this.<Button>RegOnClickEvent(R.id.btnOk,"onLogin");
		 
		 mTxtPwd=(EditText)this.findViewById(R.id.txtPwd);
		 mTxtPwd.addTextChangedListener(mPwdWatcher);
		 this.<Button>RegOnClickEvent(R.id.btnClearPwd,"onClearPwd");	
		 
		// createDataTrunsfer();
		 
		 PlProcessor.SetParent(this);
		 
		 loginProce=new DPUserProcessor();	 
		 loginProce.InitDropUser();
		 
		 //20150423 //
		 SendParam sendParam=new SendParam();
     	 sendParam.parent=this;
	     sendParam.processor=loginProce;
	     getDataTrunsfer().request(sendParam);
	     
		 TextView tvTip=(TextView) findViewById(R.id.tvTip); 
		 tvTip.setVisibility(View.INVISIBLE);
	 }
	 
	 @Override
	 public void finish()
	 {
		// mDataTrunsfer.CloseSocketConnect();
		 
		finish();
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
		Spinner sp=(Spinner)this.findViewById(R.id.dropUser);
		TextView tvPwd=(TextView)this.findViewById(R.id.txtPwd);
		
		String strUser=sp.getSelectedItem().toString();
		String strPwd=tvPwd.getText().toString();
		
		if(!strPwd.equals("")&&!strUser.equals(""))
		{
			ActivityHelper.gToupei.strUser=strUser;
			ActivityHelper.gToupei.strPwd=strPwd;
			
//		
//								this.setMTitle("����Ӧ��",R.id.tvActtitle);
//								Intent intent=new Intent(this,DPMainAct.class); 
//								intent.putExtra("userName",strUser);
//								intent.putExtra("pwd",strPwd);
//								
//								startActivity(intent); 
			
			
			ActivityHelper.showTempDialog(this,"Ӧ�õ�¼�ɹ�,1.5����Զ��ر�!",1500,true);
		}
		else
			ActivityHelper.showDialog(this, "����","���벻��Ϊ��!");
			
	 }
	 
	@Override
	public void processMessage(int msgId, String msg) 
	{ 
		TextView tvTip=(TextView) findViewById(R.id.tvTip); 
	     
	     if (msgId == DataTrunsfer.OK_FLAG)
	     {  
	    	 tvTip.setTextColor(Color.BLUE);   
	    	 
	    	 if(mFirstFlag==0)
			 {
				 
				 SendParam sendParam=new SendParam();
		     	 sendParam.parent=this;
			     sendParam.processor=loginProce;
			     getDataTrunsfer().request(sendParam);
				 
				 
				 mFirstFlag=1;
			 }
	     }
	     else
	     {
	    	 tvTip.setTextColor(Color.RED);   
	     }
	    
	     tvTip.setText(msg); 
	}
}
