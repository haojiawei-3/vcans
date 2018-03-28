package com.vcans.Processor;

import java.util.ArrayList;
import java.util.Vector;

import com.Vcan.activity.R;
import com.vcans.Protocol.DPProtocol;
import com.vcans.model.MenuU;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ItemTitleHelper;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

/**
 * 菜单权限，用户名及密码验证处理者
 * @author vcans
 *
 */
public class DPMenuProcessor extends DownloadProcessor {

	public static final int LOGIN_SUCCESS=1000;
	/**
	 * 选项 与 菜单 分开  原因是  菜单单独便于菜单是否启用的实现
	 */
	static String[] m_szItem={"选项设置"};

	static String[] m_YPMenu={"样品查询_在线模式","展会询样","样品图片采集","名片收集"};

	//static String[] m_YPMenu={"","展会询样","样品图片采集","名片收集"};
	static int[] m_szIconId={ R.drawable.toupei,R.drawable.productin,R.drawable.reproduct};

	/**
	 * 菜单权限标志
	 */
	private String[] m_szMenuEnableFlag;

	public String[] getSzMenuEnable() {
		return m_szMenuEnableFlag;
	}

	private String[] m_szItemEnable;

	public String[] getSZItemEnable() {
		return m_szItemEnable;
	}

	/**
	 * 模块配制信息
	 */
	private ArrayList<MenuU> listMenu;
	private ArrayList<MenuU> listMenu2;
	public ArrayList<MenuU>  getLstMenu() {
		return listMenu;
	}

	public void setLstMenu(ArrayList<MenuU> lstMenu) {
		this.listMenu = lstMenu;
	}
	public void setLstMenu2(ArrayList<MenuU> lstMenu2) {
		this.listMenu2 = lstMenu2;
	}
	@Override
	public int ProcessData() {

		Vector<Vector<String>> vctReceData=mDataTrunsfer.GetReceiveData();

		int totalMenuCout;

		//跟单菜单数(从服务端的模块配制信息中获得)+样品菜单数
		totalMenuCout=listMenu.size()+m_YPMenu.length;

		for(Vector<String> record : vctReceData)
		{
			m_szItemEnable=new String[m_szItem.length];
			m_szMenuEnableFlag=new String[totalMenuCout];

			int i=0;
			//选项设置(如系统设置)
			for(i=0;i<m_szItemEnable.length;++i)
			{
				if(i<record.size())
					m_szItemEnable[i]=record.get(i);
			}

			int j=0;
			for(;i<record.size()&&j<m_szMenuEnableFlag.length;++i)
			{//菜单
				m_szMenuEnableFlag[j++]=record.get(i);
			}
		}

		if(vctReceData.size()>0){
			mActParent.processMessage(LOGIN_SUCCESS,"");
			//ActivityHelper.ToastShow(mActParent, LOGIN_SUCCESS+"");
		}

		return 1;
	}

	public static String getDeviceId()
	{
		String m_szDevIDShort = "35" + //we make this look like a valid IMEI

				Build.BOARD.length()%10 + Build.BRAND.length()%10 + Build.DEVICE.length()%10 + Build.DISPLAY.length()%10 +
				Build.HOST.length()%10 +
				Build.ID.length()%10 +
				Build.MANUFACTURER.length()%10 +
				Build.MODEL.length()%10 +
				Build.PRODUCT.length()%10 +
				Build.TAGS.length()%10 +
				Build.TYPE.length()%10 +
				Build.USER.length()%10 ; //13 digits

		// 20160727 add by df begin
		boolean bOK = true;
		try
		{
			m_szDevIDShort = ((TelephonyManager) mActParent.getSystemService(mActParent.TELEPHONY_SERVICE))
					.getDeviceId();
			if ("000000000000000".equals(m_szDevIDShort))
			{
				bOK = false;
			}
		} catch (Exception ex)
		{
			bOK = false;
		}
		if (!bOK)
		{
			m_szDevIDShort = Secure.getString(mActParent.getContentResolver(), Secure.ANDROID_ID);
		}
		// 20160727 add by df end

		return m_szDevIDShort;
	}

	public static String getDeviceName()
	{
		return Build.MANUFACTURER+" "+Build.MODEL;
	}

	@Override
	public Vector<Vector<String> > GetSendData(String[] extrData) {

		Vector<Vector<String>> vctSendData=new Vector<Vector<String>>();
		Vector<String> vctChild=new Vector<String>();
		//用户名，密码
		for(String str:extrData)
		{
			vctChild.add(str);
		}

		vctChild.add(getDeviceId());//设备Id

		vctChild.add(getDeviceName());//设备描述

		//选项设置
		for(String item:m_szItem)
		{
			vctChild.add(item);
		}

		//跟单菜单
		if(listMenu!=null)
		{
			int i=0;
			for(MenuU menu:listMenu)
			{
				if(menu.strEnabled.equals("Y"))
					vctChild.add(menu.nameCh);
			}
		}
		else {//默认
			for (String menu : ItemTitleHelper.szModuleIds)
				vctChild.add(menu);
		}


		//样品菜单
		for(String ypmenu:m_YPMenu)
		{
			vctChild.add(ypmenu);
		}


		//信息中心
		if(listMenu2!=null)
		{
			int i=0;
			for(MenuU menu:listMenu2)
			{
				if(menu.strEnabled.equals("Y"))
					vctChild.add(menu.nameCh);
			}
		}
		else {//默认
			for (String menu : ItemTitleHelper.szModuleIds2)
				vctChild.add(menu);
		}

		vctSendData.add(vctChild);

		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p=new MyProtocol();
		//==VCANS通用==登录信息==
		p.sendCmd1=DPProtocol.m_vfxVAG_DengLuXinXi1;
		p.receCmd0= DPProtocol.m_vfxVAG_DengLuXinXiRe0;
		p.receCmd1=DPProtocol.m_vfxVAG_DengLuXinXiRe1;

		return p;
	}

}
