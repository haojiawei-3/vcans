package com.Vcan.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.DPMachiAimFactoryProcessor;
import com.vcans.Processor.DPMachiDownGoodsProcessor;
import com.vcans.Processor.DPPIDownGoodsProcessor;
import com.vcans.Processor.DPTPDownFactoryProcessor;
import com.vcans.Processor.DPTPDownGoodsProcessor;
import com.vcans.Processor.DownloadProcessor;
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
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * 此类关联两个布局文件,三个模块（成品入库、生产投坯及加工送仓库），程序统一处理。
 * 二个布局文件分别：dp_productin1（成品入仓），dp_toupei1(两模块共用 该布局文件，分别为 生成投坯、加工送仓库)
 *
 * @author vcans
 *
 */
public class DPTouPei1 extends BaseActivity {
	// public static DPTouPei1 dpTouPei1 = null;
	public static final String DP_TOUPEI1="0";//生产投坯
	public static final String DP_PRODUCT_IN1="1";//成品进仓
	public static final String DP_MACHINING1="2";//加工送仓库

	private ListView mLvTouPei;
	private String mActFlag;
	private EditText mTxtDelPiShu;// 扣除匹数
	private EditText mTxtDelNum; // 扣除数量
	private EditText txtFactory; // 染整工厂名称
	private Activity mThis;
	private int mLastClickId = -1;
	private long mLastClickTime = 0;
	private DownloadProcessor downFactoryProcessor = null;
	private DownloadProcessor downWork = null;
	private DownloadProcessor downGoods = null;
	private TextView tvPage;
	private Button mBtnOk;
	private ImageButton imgBtnOk;
	private List<HashMap<String, Object>> mDataList = new ArrayList<HashMap<String, Object>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		Intent intent = this.getIntent();
		mActFlag = intent.getStringExtra("actFlag");
		String strRZPlanId = ActivityHelper.gToupei.strRZPlanId;
		String strRZFactoryId = ActivityHelper.gToupei.strRZFactoryId;

		mThis = this;

		/**
		 * 不同模块的条件执行
		 */
		if (mActFlag.equals(DP_PRODUCT_IN1)) {//成品进仓
			setContentView(R.layout.dp_productin1);

			txtFactory = (EditText) findViewById(R.id.txtRZFactory);
			ActivityHelper.InitDrop(this, R.id.dropWorkProcess, ActivityHelper.lstGongXu, false);
			txtFactory.setText(ActivityHelper.gToupei.strRZFactoryName);
			mTxtDelPiShu = (EditText) this.findViewById(R.id.txtDelPiShu);
			mTxtDelNum = (EditText) this.findViewById(R.id.txtDelNum);
			// mTxtDelPiShu.setBackgroundResource(R.drawable.et_disabled);
			// mTxtDelNum.setBackgroundResource(R.drawable.et_disabled);
		} else {                               //生产投坯
			setContentView(R.layout.dp_toupei1);

			if (mActFlag.equals(DP_MACHINING1)) {
				TextView tvFactory = (TextView) this.findViewById(R.id.tvRZFactoryName);
				tvFactory.setText(getString(R.string.AimFactoryName));
				downFactoryProcessor = new DPMachiAimFactoryProcessor();

			} else {
				downFactoryProcessor = new DPTPDownFactoryProcessor();
			}
		}
		//dpTouPei1=this;
		mBtnOk = (Button) this.findViewById(R.id.btnOk);
		mBtnOk.setText(getString(R.string.goodsLoad));
		imgBtnOk = (ImageButton) this.findViewById(R.id.imgBtnOk);
		imgBtnOk.setImageResource(R.drawable.load_goods);

		/**
		 * 不同模块的条件执行
		 */
		if (mActFlag.equals(DP_TOUPEI1)) {
			downGoods = new DPTPDownGoodsProcessor();
		} else if (mActFlag.equals(DP_MACHINING1)) {

			downGoods = new DPMachiDownGoodsProcessor();

			if (ActivityHelper.gToupei.strColorAllOut.equals("Y"))
				mBtnOk.setText(getString(R.string.ColorAllOut));

		} else {
			downGoods = new DPPIDownGoodsProcessor();
		}

		this.<Button> RegOnClickEvent(R.id.btnBack, "finish");
		this.<Button> RegOnClickEvent(R.id.btnOk, "onNext");
		this.<Button> RegOnClickEvent(R.id.imgBtnOk, "onNext");
		txtFactory = (EditText) findViewById(R.id.txtRZFactory);
		this.<TextView>RegOnClickEvent(R.id.tvLoad,"onLoadGoodsInfo");

		Spinner dropwrok = (Spinner) findViewById(R.id.dropWorkProcess);
		dropwrok.setOnItemSelectedListener(dropClickListener);
		Button btnLoad = (Button) this.findViewById(R.id.tvLoad);
		btnLoad.setVisibility(View.INVISIBLE);
		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.processor = downFactoryProcessor;


		/**
		 * 不同模块的条件执行
		 */
		if (mActFlag.equals(DP_MACHINING1)) {
			String[] szExtrData = { ActivityHelper.gToupei.strAimFactoryId, ActivityHelper.gToupei.strOrderType,
					ActivityHelper.gToupei.strRZPlanId, ActivityHelper.gToupei.strRZFactoryId };

			sendParam.szData = szExtrData;
		} else {

			String[] szExtrData = { strRZFactoryId, strRZPlanId };
			sendParam.szData = szExtrData;
		}

		if (sendParam.processor != null)
			getDataTrunsfer().request(sendParam);

		mLvTouPei = (ListView) this.findViewById(R.id.lvProdct);
		mLvTouPei.setOnItemClickListener(listClickListener);
		tvPage = (TextView) findViewById(R.id.tvPage);

		if (mActFlag.equals(DP_MACHINING1))
		{
			ActivityHelper.InitDrop(this, R.id.dropWorkProcess, ActivityHelper.lstGongXu, false);
		}else if (mActFlag.equals(DP_TOUPEI1)){
			ActivityHelper.InitDrop(this, R.id.dropWorkProcess, ActivityHelper.lstGongXu, false);
		}

	}













	public final OnItemClickListener listClickListener = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

			// 获得选中项的HashMap对象
			HashMap<String, Object> mapToupei = (HashMap<String, Object>) mLvTouPei.getItemAtPosition(arg2);

			ActivityHelper.gToupei.strCompanyOrderId = (String) mapToupei.get("companyOrderId");
			ActivityHelper.gToupei.strPurchaseId = (String) mapToupei.get("purchaseId");
			ActivityHelper.gToupei.strGoodsId = (String) mapToupei.get("goodsId");
			ActivityHelper.gToupei.strGoodsDescribe = (String) mapToupei.get("goodDescribe");
			ActivityHelper.gToupei.strStoreDescribe = (String) mapToupei.get("storeDescribe");
			ActivityHelper.gToupei.strStoreFlag = (String) mapToupei.get("storeFlag");
			ActivityHelper.gToupei.nOldPiShu = (String) mapToupei.get("oldPiShu");
			ActivityHelper.gToupei.nOldNum = (String) mapToupei.get("oldNum");

			/**
			 * 不同模块的条件执行
			 */
			if (mActFlag.equals(DP_PRODUCT_IN1)) {
				// mTxtDelPiShu.setEnabled(true);
				// mTxtDelNum.setEnabled(true);
				// mTxtDelPiShu.setBackgroundResource(R.drawable.et);
				// mTxtDelNum.setBackgroundResource(R.drawable.et);
				mTxtDelPiShu.setBackgroundColor(Color.WHITE);
				mTxtDelNum.setBackgroundColor(Color.WHITE);
			}

			if (mActFlag.equals(DP_MACHINING1)) {
				if (!ActivityHelper.gToupei.strColorAllOut.equals("Y")) {
					mBtnOk.setText(getString(R.string.btn_next));
					imgBtnOk.setImageResource(R.drawable.next_blue);
				}
			} else {
				mBtnOk.setText(getString(R.string.btn_next));
				imgBtnOk.setImageResource(R.drawable.next_blue);
			}

			String[] szStr = tvPage.getText().toString().split("/");
			tvPage.setText("(" + (arg2 + 1) + "/" + szStr[1]);

			// 如果是双击,1秒内连续点击判断为双击
			if (arg2 == mLastClickId && (Math.abs(mLastClickTime - System.currentTimeMillis()) < 1000)) {
				mLastClickId = -1;
				mLastClickTime = 0;

				mDataList.clear();
				mDataList.add(mapToupei);

				/**
				 * 不同模块的条件执行
				 */
				if (mActFlag.equals(DP_PRODUCT_IN1)) {

					DPPIDownGoodsProcessor dppi = (DPPIDownGoodsProcessor) downGoods;
					dppi.displayDetail(mDataList);

				} else {
					if (mActFlag.equals(DP_MACHINING1)) {
						DPMachiDownGoodsProcessor dppi = (DPMachiDownGoodsProcessor) downGoods;
						dppi.displayDetail(mDataList);

					} else {

						DPTPDownGoodsProcessor dppi = (DPTPDownGoodsProcessor) downGoods;
						dppi.displayDetail(mDataList);
					}
				}
			} else {
				mLastClickId = arg2;
				mLastClickTime = System.currentTimeMillis();
			}
		}
	};

	public final OnItemSelectedListener dropClickListener = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

			if (arg1 == null)
				return;
			TextView tv = (TextView) arg1;
			tv.setTextColor(Color.BLACK); // 设置颜色

			// tv.setTextSize(12.0f); //设置大小

			tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL); // 设置居中

			if (!ActivityHelper.gToupei.strColorAllOut.equals("Y")) {
				Button btnOk = (Button) findViewById(R.id.btnOk);
				btnOk.setText(getString(R.string.goodsLoad));
				imgBtnOk.setImageResource(R.drawable.load_goods);
			}

			// 如果不在这获取一下，会为空
			// txtFactory=(EditText)findViewById(R.id.txtRZFactory);

			if (!txtFactory.getText().toString().trim().equals(""))
				getDataTrunsfer().clearReceiveData();

			if (mActFlag.equals(DP_TOUPEI1)) {
				DPTPDownGoodsProcessor tpGoods = (DPTPDownGoodsProcessor) downGoods;
				tpGoods.initGoodsList();
			} else if (mActFlag.equals(DP_MACHINING1)) {
				DPMachiDownGoodsProcessor tpGoods = (DPMachiDownGoodsProcessor) downGoods;
				tpGoods.initGoodsList();
			} else {
				DPPIDownGoodsProcessor tpGoods = (DPPIDownGoodsProcessor) downGoods;
				tpGoods.initGoodsList();
			}
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}
	};

	public void onNext() {
		String btnName = mBtnOk.getText().toString();
		if (btnName.equals(getString(R.string.goodsLoad)) || btnName.equals(getString(R.string.ColorAllOut))) {
			onLoadGoodsInfo();
		} else {
			String[] szStr = tvPage.getText().toString().split("/");

			if (mLvTouPei.getCount() < 1 || szStr[0].equals("(0")
					|| txtFactory.getText().toString().trim().equals("")) {
				ActivityHelper.showDialog(this, "提示", getString(R.string.noData));
				return;
			}

			Intent intent;
			if (mActFlag.equals(DP_TOUPEI1)) {
				intent = new Intent(this, DPTouPei2.class);//DPTouPei2
			} else if (mActFlag.equals(DP_MACHINING1)) {
				ActivityHelper.gToupei.strAimFactoryName = txtFactory.getText().toString().trim();
				intent = new Intent(this, DPMachining2.class);//DPMachining2
			} else {
				EditText txtDelPiShu = (EditText) this.findViewById(R.id.txtDelPiShu);
				EditText txtDelNum = (EditText) this.findViewById(R.id.txtDelNum);

				String strDelPiShu = txtDelPiShu.getText().toString().trim();
				String strDelNum = txtDelNum.getText().toString().trim();

				if (strDelPiShu.equals("") || strDelNum.equals("")) {
					ActivityHelper.showDialog(this, "提示", getString(R.string.delPiShuNumIsNull));
					return;
				}

				ActivityHelper.gToupei.strDelPiShu = strDelPiShu;
				ActivityHelper.gToupei.strDelNum = strDelNum;

				intent = new Intent(this, DPProductIn2.class);//DPProductIn2
			}

			startActivity(intent);
		}
	}

	public void onLoadGoodsInfo() {
		Spinner sp = (Spinner) this.findViewById(R.id.dropWorkProcess);
		String strGongxu = sp.getSelectedItem().toString().trim();

		String[] szGongxu = strGongxu.split("\\[");

		if (szGongxu.length < 2) {
			ActivityHelper.showDialog(this, "错误", getString(R.string.backPre));
			return;
		}

		ActivityHelper.hidesofeKeyboard(this);

		ActivityHelper.gToupei.strGongXuName = szGongxu[0];
		ActivityHelper.gToupei.strGongXuId = szGongxu[1].substring(0, szGongxu[1].length() - 1);

		SendParam sendParam = new SendParam();
		sendParam.parent = this;
		sendParam.processor = downGoods;
		getDataTrunsfer().request(sendParam);
	}

	@Override
	public void processMessage(int msgId, String msg) {

		if (msgId == 0) {
			/*
			 * DPMachiAimFactoryProcessor或DPTPDownFactoryProcessor中调用
			 */
			SendParam sendParam = new SendParam();
			sendParam.parent = this;
			sendParam.processor = downWork;
			getDataTrunsfer().request(sendParam);
		} else if (msgId == 2) {
			Intent intent = new Intent(this, DPMachining2.class);
			intent.putExtra("result", msg);
			startActivity(intent);
		}
	}

}
