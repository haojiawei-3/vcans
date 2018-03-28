package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPPBDownGoodsProcessor;
import com.vcans.model.BandleParam;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * 坯布进仓   有3个界面类 分别  DPPeibuIn DPPeibuIn1 DPPeibuIn2
 * @author vcans
 *
 */
public class DPPeibuIn extends BaseActivity {
	//public static DPPeibuIn dpPeibuIn = null;
	ListView mLvTouPei;
	String mActFlag;
	EditText mTxtDelPiShu;
	EditText mTxtDelNum;
	EditText txtOutNotifyId;

	DPPBDownGoodsProcessor downGoods=null;
	TextView tvPage ;
	Button mBtnOk;
	ImageButton imgBtnOk;
	List<HashMap<String,Object> > mDataList=new ArrayList<HashMap<String,Object> >();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dp_peibuin);
		// dpPeibuIn=this;
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		this.<Button>RegOnClickEvent(R.id.btnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.imgBtnOk,"onNext");
		this.<Button>RegOnClickEvent(R.id.btnScanBarcode,"scanBarcode");
		setListItemClickMethod("onGoodsItemClick","onGoodsItemDbClick");
		mBtnOk=(Button)this.findViewById(R.id.btnOk);

		imgBtnOk=(ImageButton)this.findViewById(R.id.imgBtnOk);
		imgBtnOk.setImageResource(R.drawable.load_goods);

		Button btnLoad=(Button)this.findViewById(R.id.tvLoad);
		btnLoad.setVisibility(View.INVISIBLE);
		//坯布进仓
		downGoods=new DPPBDownGoodsProcessor();

		txtOutNotifyId= (EditText) findViewById(R.id.txtOutNotifyId);
		txtOutNotifyId.addTextChangedListener(mTxtWatcher);

		mLvTouPei=(ListView)this.findViewById(R.id.lvProdct);
		//mLvTouPei.setOnItemClickListener(listClickListener);
		tvPage = (TextView) findViewById(R.id.tvPage);

		mBtnOk.setText(getString(R.string.goodsLoad));
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		if(ActivityHelper.globalSysParam.bAutoCreateId)
		{
			ActivityHelper.globalSysParam.bAutoCreateId=false;
			mBtnOk.setText(getString(R.string.goodsLoad));
			String strOutId=txtOutNotifyId.getText().toString().trim();
			//strOutId=ActivityHelper.autoCreator(strOutId);


			if(!strOutId.equals(""))
			{
				//txtOutNotifyId.setText("");
				getDataTrunsfer().clearReceiveData();
				if(downGoods!=null)
				{
					PlProcessor.mActParent=this;
					downGoods.initGoodsList();                            //进入
				}
			}
		}
		super.onResume();
	}





	public void scanBarcode()
	{
		onOpenScanBarcode();
	}


	final  TextWatcher mTxtWatcher= new TextWatcher() {

		public void onTextChanged(CharSequence s, int start, int before, int count) {


		}

		public void afterTextChanged(Editable s) {

			if(s.toString().trim().equals(""))
			{
				mBtnOk.setText(getString(R.string.goodsLoad));

				getDataTrunsfer().clearReceiveData();
				downGoods.initGoodsList();                                      //进入
			}
			else
			{
				//if(!ActivityHelper.gToupei.strOutNotifyId.equals(txtOutNotifyId.getText().toString().trim()))
				mBtnOk.setText(getString(R.string.goodsLoad));
			}

			imgBtnOk.setImageResource(R.drawable.load_goods);
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
									  int after) {
			// TODO Auto-generated method stub

		}
	} ;

	public void onGoodsItemClick(int index)
	{
		//mLvTouPei.setBackgroundColor(Color.parseColor("#A7CE39"));
		//获得选中项的HashMap对象
		HashMap<String,Object> mapToupei=(HashMap<String,Object>)mLvTouPei.getItemAtPosition(index);

		ActivityHelper.gToupei.strSupplierId=(String)mapToupei.get("SupplierId");
		ActivityHelper.gToupei.strCompanyOrderId=(String)mapToupei.get("companyOrderId");
		ActivityHelper.gToupei.strPurchaseId=(String)mapToupei.get("purchaseId");
		ActivityHelper.gToupei.strGoodsId=(String)mapToupei.get("goodsId");
		ActivityHelper.gToupei.strGoodsDescribe=(String)mapToupei.get("goodDescribe");
		ActivityHelper.gToupei.strSendGoodsNum=(String)mapToupei.get("SendGoodsNum");
		ActivityHelper.gToupei.strOrderNum=(String)mapToupei.get("OrderNum");
		ActivityHelper.gToupei.strGoodsRecordId=(String)mapToupei.get("GoodsRecordId");

		if(ActivityHelper.gToupei.strOutNotifyId.equals(txtOutNotifyId.getText().toString().trim()))
		{
			mBtnOk.setText(getString(R.string.btn_next));
			imgBtnOk.setImageResource(R.drawable.next_blue);
		}

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

	@Override
	public void onActivityResult(int requestCode,int resultCode,Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode==REQUEST_SCAN_QRCODE_FLAG)
		{//条码扫描完毕返回
			if(resultCode==Activity.RESULT_OK)
			{
				Bundle bundle = data.getExtras();
				String strRst=bundle.getString("result");

				txtOutNotifyId.setText(strRst);
				onLoadGoodsInfo();
			}
		}
		else
		{}
	}







//	 public void finish(){
//		 ActivityHelper.showDialog(this, "错误", "Vcans you can");
//	 }







	public void onNext()
	{
		String btnName=mBtnOk.getText().toString();
		if(btnName.equals(getString(R.string.goodsLoad)))
		{
			onLoadGoodsInfo();
		}
		else
		{
			String[] szStr=tvPage.getText().toString().split("/");

			if(mLvTouPei.getCount()<1)
			{
				ActivityHelper.showDialog(this, "提示", getString(R.string.infoNull));
				return;
			}
			else if(szStr[0].equals("(0"))
			{
				ActivityHelper.showDialog(this, "提示", getString(R.string.noSelected));
				return;
			}

			Intent intent=new Intent(this,DPPeibuIn1.class);
			startActivity(intent);
		}
	}

	public void onLoadGoodsInfo() //用于查询与下载
	{
		String strOutNotifyId=txtOutNotifyId.getText().toString().trim();
		if(strOutNotifyId.equals(""))
		{
			ActivityHelper.showDialog(this, "", getString(R.string.chukutongzi)+getString(R.string.isNUll));
			return;
		}

		ActivityHelper.hidesofeKeyboard(this);


		ActivityHelper.gToupei.strOutNotifyId=strOutNotifyId;
		//ActivityHelper.showStatusDialog(this, "等待服务器响应...");
		//this.getDataTrunsfer().SetProcessor(downGoods);
		//downGoods.SendInfo(null); 	

		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.processor = downGoods;
		getDataTrunsfer().request(sendParam);
	}


	@Override
	public void processMessage(int msgId, String msg) {

	}

}
