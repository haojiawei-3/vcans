package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.GDQueryDownGoodsProc;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * 综合查询结果
 * @author vcans
 *
 */
public class GDQueryResult extends BaseActivity {
	//	public static GDQueryResult gdQueryResult = null;
	private ListView mLvTouPei;
	private GDQueryDownGoodsProc downGoods=new GDQueryDownGoodsProc();
	private TextView tvPage ;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gd_query3_result);
		// gdQueryResult=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		setListItemClickMethod("onGoodsItemClick","");

		mLvTouPei=(ListView)this.findViewById(R.id.lvProdct);
		tvPage=(TextView)this.findViewById(R.id.tvPage);

		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.szData=new String[]{
				GDQuery.queryData.strBakType,
				GDQuery.queryData.strDataItem1,
				GDQuery.queryData.strDataItem2,
				GDQuery.queryData.strFuZhuData1Id,
				GDQuery.queryData.strFuZhuData1Name,
				GDQuery.queryData.strFuZhuData2Id,
				GDQuery.queryData.strFuZhuData2Name,
				GDQuery.queryData.strFuZhuData3Id,
				GDQuery.queryData.strFuZhuData3Name,
				GDQuery.queryData.strUser};
		sendParam.processor= downGoods;
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
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
