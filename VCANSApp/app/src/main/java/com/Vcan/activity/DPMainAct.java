package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPMenuProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

/**
 * 暂无用
 * @author vcans
 *
 */
public class DPMainAct extends BaseActivity {

	private DPMenuProcessor mMenuProce=null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_main);

		String[] szMethodName={"onOpenTouPei","onOpenProductIn","onOpenMachining"};
		this.<GridView>RegItemOnClickEvent(R.id.gridview,szMethodName);
		this.<Button>RegOnClickEvent(R.id.btnBack, "finish");


		String strUser=this.getIntent().getStringExtra("userName");
		String strPwd=this.getIntent().getStringExtra("pwd");
		String[] szData={strUser,strPwd};

		SendParam sendParam=new SendParam();
		sendParam.parent=this;
		sendParam.processor=mMenuProce;
		sendParam.szData=szData;
		getDataTrunsfer().request(sendParam);

		String[] szMethodNames2=new String[9];
		for(int i=0;i<9;i++)
			szMethodNames2[i]="onTemp";

		this.<GridView>RegItemOnClickEvent(R.id.gvMenu2,szMethodNames2);
		InitGridViewMneu2();
	}


	private void InitGridViewMneu2()
	{
		GridView gridview = (GridView) findViewById(R.id.gvMenu2);

		//生成动态数组，并且转入数据
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> map = null;


		for(int i=0;i<9;i++)
		{
			map = new HashMap<String, Object>();
			map.put("ivItemImage", R.drawable.temp);//添加图像资源的ID
			map.put("tvItemText", "菜单"+(i+1));
			lstImageItem.add(map);
		}

		SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释
				lstImageItem,//数据来源
				R.layout.main_item_icon_left,
				//动态数组与ImageItem对应的子项
				new String[] {"ivItemImage","tvItemText"},
				//ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] {R.id.ivItemImage,R.id.tvItemText});
		//添加并且显示
		gridview.setAdapter(saImageItems);
	}

	public void onTemp()
	{
		if(gUser==null)
		{
			Toast.makeText(this, "系统未登录", 5).show();
			return;
		}


		ActivityHelper.showDialog(this, "", "该功能暂时未实现!");
	}


	public void onOpenTouPei()
	{
		this.setMTitle("生成投坏",R.id.tvActtitle);
		Intent intent=new Intent(this,DPTouPei.class);
		startActivity(intent);
	}

	public void onOpenProductIn()
	{
		this.setMTitle("成品进仓",R.id.tvActtitle);
		Intent intent=new Intent(this,DPProductIn.class);
		startActivity(intent);
	}

	public void onOpenMachining()
	{
		this.setMTitle("再加工/送仓库",R.id.tvActtitle);
		Intent intent=new Intent(this,DPMachining.class);
		startActivity(intent);
	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
