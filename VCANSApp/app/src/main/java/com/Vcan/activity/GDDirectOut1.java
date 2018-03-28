package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.GDDirectOutDownFZ1Processor;
import com.vcans.Processor.GDDirectOutDownGoodsProcessor;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;

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
 * 直接出货   有4个界面类 分别  GDDirectOut GDDirectOut1 GDDirectOut2 GDDirectOut3
 * @author vcans
 *
 */
public class GDDirectOut1 extends BaseActivity {
	// public static GDDirectOut1 directOut1 = null;
	private Spinner dropFuZhu1;
	private Spinner dropFuZhu2;
	private Spinner dropFuZhu3;
	private ListView mLvTouPei;
	private Button mBtnOk;
	private ImageButton imgBtnOk;
	private GDDirectOutDownGoodsProcessor downGoods=new GDDirectOutDownGoodsProcessor();
	private TextView tvPage ;
	private boolean bLoadFlag=true;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gd_directout1);
		// directOut1=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		setListItemClickMethod("onGoodsItemClick","onGoodsItemDbClick");

		dropFuZhu1=(Spinner)this.findViewById(R.id.dropFuZhuData1);
		dropFuZhu2=(Spinner)this.findViewById(R.id.dropFuZhuData2);
		dropFuZhu3=(Spinner)this.findViewById(R.id.dropFuZhuData3);
		mLvTouPei=(ListView)this.findViewById(R.id.lvProdct);
		mBtnOk=(Button)this.findViewById(R.id.btnOk);
		imgBtnOk=(ImageButton)this.findViewById(R.id.imgBtnOk);
		imgBtnOk.setImageResource(R.drawable.load_goods);
		mBtnOk.setText(getString(R.string.goodsLoad));
		tvPage=(TextView)this.findViewById(R.id.tvPage);

		dropFuZhu1.setOnItemSelectedListener(onItemSelectedFZ1);
		dropFuZhu2.setOnItemSelectedListener(onItemSelectedFZ1);

		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.szData=new String[]{GDDirectOut.g_DirectOutInfo.strRZPlanId,GDDirectOut.g_DirectOutInfo.strDataItem1};
		sendParam.processor =new GDDirectOutDownFZ1Processor(GDDirectOutDownFZ1Processor.FZ1);
		getDataTrunsfer().request(sendParam);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	public void onGoodsItemClick(int index)
	{
		//获得选中项的HashMap对象
		HashMap<String,Object> mapToupei=(HashMap<String,Object>)mLvTouPei.getItemAtPosition(index);

		GDDirectOut.g_DirectOutInfo.goods.strGoodsId=(String)mapToupei.get("GoodsId");
		GDDirectOut.g_DirectOutInfo.goods.strGoodsDescribe=(String)mapToupei.get("GoodDescribe");
		GDDirectOut.g_DirectOutInfo.goods.strStoreDescribe=(String)mapToupei.get("StoreDescribe");
		GDDirectOut.g_DirectOutInfo.goods.strStoreFlag=(String)mapToupei.get("StoreFlag");
		GDDirectOut.g_DirectOutInfo.goods.strPiShu=(String)mapToupei.get("GPiShu");
		GDDirectOut.g_DirectOutInfo.goods.strNum=(String)mapToupei.get("GNum");
		GDDirectOut.g_DirectOutInfo.goods.strRemark1=(String)mapToupei.get("Remark1");
		GDDirectOut.g_DirectOutInfo.goods.strRemark2=(String)mapToupei.get("Remark2");
		GDDirectOut.g_DirectOutInfo.goods.strRemark3=(String)mapToupei.get("Remark3");
		GDDirectOut.g_DirectOutInfo.goods.strRemark4=(String)mapToupei.get("Remark4");
		GDDirectOut.g_DirectOutInfo.goods.strRemark5=(String)mapToupei.get("Remark5");

		//设置按钮为下一步
		bLoadFlag=false;
		mBtnOk.setText(getString(R.string.btn_next));
		imgBtnOk.setImageResource(R.drawable.next_blue);


		String[] szStr=tvPage.getText().toString().split("/");
		tvPage.setText("("+(index+1)+"/"+szStr[1]);
	}

	public void onGoodsItemDbClick(int index)
	{
		//获得选中项的HashMap对象
		HashMap<String,Object> mapToupei=(HashMap<String,Object>)mLvTouPei.getItemAtPosition(index);

		List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();
		mDataList.add(mapToupei);
		downGoods.displayDetail(mDataList);
	}


	final OnItemSelectedListener onItemSelectedFZ1 = new OnItemSelectedListener(){

		public void onItemSelected(AdapterView<?> arg0, View arg1,
								   int arg2, long arg3) {

			TextView tv = (TextView)arg1;

			if(tv!=null)
			{
				tv.setTextColor(Color.BLACK);    //设置颜色
				tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL);//设置居中
				imgBtnOk.setImageResource(R.drawable.load_goods);
				mBtnOk.setText(getString(R.string.goodsLoad));
				bLoadFlag=true;

				String strSelectedText=tv.getText().toString();
				String[] szFz=split(strSelectedText,"\\[","\\]");

				SendParam sendParam=null;

				if(arg0.getId()==R.id.dropFuZhuData1)
				{
					GDDirectOut.g_DirectOutInfo.strFuZhuData1Id=szFz[1];
					GDDirectOut.g_DirectOutInfo.strFuZhuData1Name=szFz[0];

					sendParam = new SendParam();
					sendParam.parent =GDDirectOut1.this;
					sendParam.processor = new GDDirectOutDownFZ1Processor(GDDirectOutDownFZ1Processor.FZ2);
					sendParam.szData=new String[]{GDDirectOut.g_DirectOutInfo.strRZPlanId,
							GDDirectOut.g_DirectOutInfo.strDataItem1,
							szFz[1],szFz[0]};
				}
				else if(arg0.getId()==R.id.dropFuZhuData2)
				{
					GDDirectOut.g_DirectOutInfo.strFuZhuData2Id=szFz[1];
					GDDirectOut.g_DirectOutInfo.strFuZhuData2Name=szFz[0];

					sendParam = new SendParam();
					sendParam.parent =GDDirectOut1.this;
					sendParam.processor = new GDDirectOutDownFZ1Processor(GDDirectOutDownFZ1Processor.FZ3);
					sendParam.szData=new String[]
							{ GDDirectOut.g_DirectOutInfo.strRZPlanId,
									GDDirectOut.g_DirectOutInfo.strDataItem1,
									GDDirectOut.g_DirectOutInfo.strFuZhuData1Id,
									GDDirectOut.g_DirectOutInfo.strFuZhuData1Name,
									szFz[1],szFz[0]  //辅助二编号、名称
							};
				}

				if(sendParam!=null)
					getDataTrunsfer().request(sendParam);
			}

		};


		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			int ii=0;
			ii=1;
		}
	};

	public void onLoadGoodsInfo()
	{
		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.processor = downGoods;
		sendParam.szData=new String[]{GDDirectOut.g_DirectOutInfo.strRZPlanId,
				GDDirectOut.g_DirectOutInfo.strDataItem1,
				GDDirectOut.g_DirectOutInfo.strFuZhuData1Id,
				GDDirectOut.g_DirectOutInfo.strFuZhuData1Name,
				GDDirectOut.g_DirectOutInfo.strFuZhuData2Id,
				GDDirectOut.g_DirectOutInfo.strFuZhuData2Name,
				GDDirectOut.g_DirectOutInfo.strFuZhuData3Id,
				GDDirectOut.g_DirectOutInfo.strFuZhuData3Name,
		};
		getDataTrunsfer().request(sendParam);
	}

	public void onNext()
	{
		if(bLoadFlag)
		{
			String strFZ1=getDropText(dropFuZhu1);
			String strFZ2=getDropText(dropFuZhu2);
			String strFZ3=getDropText(dropFuZhu3);

			if(strFZ1.equals("")||strFZ2.equals("")||strFZ3.equals(""))
			{
				ActivityHelper.showDialog(this,"错误",getString(R.string.isNUll));
				return ;
			}

			String[] szFz3=split(strFZ3,"\\[","\\]");


			GDDirectOut.g_DirectOutInfo.strFuZhuData3Id=szFz3[1];
			GDDirectOut.g_DirectOutInfo.strFuZhuData3Name=szFz3[0];

			onLoadGoodsInfo();
		}
		else
		{
			Intent intent=new Intent(this,GDDirectOut2.class);
			startActivity(intent);
		}
	}

	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub

	}

}
