package com.Vcan.activity;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.adapter.ImageSimpleAdapter;
import com.vcans.adapter.ImageSimpleAdapter.ItemTitleListener;
import com.vcans.model.BandleParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ItemTitleHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class DPDetailInfo extends BaseActivity {

	 private BandleParam mBdParam=null;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) 
	 {
		 setEnabledChangeTitle(false);
		 super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		 setContentView(R.layout.dp_detail_info);
		 this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		 
		 TextView tvTitle=(TextView)findViewById(R.id.tvActtitle);
		 String title=getString(R.string.detailInfo);
		 tvTitle.setText(title);
		 
		 ImageView tvTip=(ImageView) findViewById(R.id.imgNetStatus); 
		 tvTip.setVisibility(View.INVISIBLE);
		 
		 TextView tvNetStatus=(TextView) findViewById(R.id.tvNetStatus); 
		 tvNetStatus.setVisibility(View.INVISIBLE);
		 
		 
		 LinearLayout layTitle = (LinearLayout) findViewById(R.id.include01);
		 layTitle.setBackgroundResource(ActivityHelper.globalSysParam.sysSkin.selectedColor);
		 
		 Intent intent=this.getIntent();
		 mBdParam=(BandleParam)intent.getSerializableExtra("data");
		 
		 if(mBdParam!=null)
			 displayDetail();
	 }
	 
	 
	 
	 
	 
	public void displayDetail()
	{
		/*SimpleAdapter adpter=new SimpleAdapter(this,mBdParam.dataList,mBdParam.rid,
				mBdParam.szFieldData,mBdParam.szRId);
		ListView listView = (ListView) findViewById(R.id.lvProdct);
		listView.setAdapter(adpter); */
		
		ImageSimpleAdapter adpter=new ImageSimpleAdapter(this,mBdParam.dataList,
				mBdParam.rid,
				mBdParam.szFieldData,
				mBdParam.szRId);
		
		adpter.addItemTitleListener(new ItemTitleListener()
		{
			public void SetItemTitle(View view) {
				
				ItemTitleHelper.setItemTitle(view);
			}
		});
		
		ListView listView = (ListView) findViewById(R.id.lvProdct);
		listView.setAdapter(adpter);
	}

	 
	
	
	
	
	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
