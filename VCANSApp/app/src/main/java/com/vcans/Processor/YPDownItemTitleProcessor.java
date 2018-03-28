package com.vcans.Processor;

import java.util.Vector;

import android.database.sqlite.SQLiteDatabase;

import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.dao.ItemTitleDao;
import com.vcans.model.ItemTitle;
import com.vcans.model.MyProtocol;
import com.vcans.tool.ActivityHelper;

/**
 * 从服务端下载界面标题信息
 *
 * @author vcans
 *
 */
public class YPDownItemTitleProcessor extends DownloadProcessor {

	public ItemTitleDao titleDao = new ItemTitleDao();
	public static final String GEN_DAN="跟单_";
	public static final String YANG_PIN="样品管家_";
	public static final String XIN_PIN="信息中心_";
	public static final int DOWNLOAD_TITLE_DONE=1003;//下载标题完成
	SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
	public boolean bDeleted=false; //只删除一次  避免续下载时，再次清除


	@Override
	public int ProcessData() {

		if(!bDeleted)
		{
			titleDao.DeleteAll(null);
//			ActivityHelper.delete(DBHelper.MLQingdan);
//			ActivityHelper.delete(DBHelper.MLQingdanone);
//			ActivityHelper.delete(DBHelper.Collect);
			db.delete("MLQingdan",null,null);
			db.delete("MLQingdanone",null,null);
			db.delete("Collect",null,null);
			ActivityHelper. MenuKLists1.clear();
			bDeleted=true;
		}

		AddItemTitle();

		if(!mDataTrunsfer.isDownloadContinue())
			mActParent.processMessage(DOWNLOAD_TITLE_DONE,"");

		return 1;
	}

	public void AddItemTitle() {
		if (mDataTrunsfer != null) {
			Vector<Vector<String>> vctReceData = this.mDataTrunsfer.GetReceiveData();

			// 下载记录格式[配置项(固定值),配置值] (配置项(固定值): 跟单_坯布进仓_模块标题/跟单_坯布进仓_模块标题_En)
			for (Vector<String> record : vctReceData) {

				if (record.size() < 2)
					continue;

				ItemTitle itemTitle = new ItemTitle();

				itemTitle.itemName = record.get(0);
				itemTitle.itemValue = record.get(1);

				if(itemTitle.itemName.indexOf(GEN_DAN)>=0||itemTitle.itemName.indexOf(YANG_PIN)>=0||itemTitle.itemName.indexOf(XIN_PIN)>=0)
					titleDao.AddBatchItemTitle(itemTitle,ItemTitleDao.TRUN_BEGIN);
			}

			titleDao.AddBatchItemTitle(null,ItemTitleDao.TRUN_END);
		}
	}


	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		Vector<Vector<String>> vctSendData = new Vector<Vector<String>>();

		Vector<String> child = new Vector<String>();
		child.add("下载界面标题");
		vctSendData.add(child);

		return vctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol p = new MyProtocol();

		p.sendCmd1 = YPStandardProtocol.m_vfxVAGSTD_UIItemTitle1;
		p.sendCmd2 = YPStandardProtocol.m_vfxVAGSTD_UIItemTitle2;
		p.receCmd0 = YPStandardProtocol.m_vfxVAGSTD_UIItemTitleRe0;
		p.receCmd1 = YPStandardProtocol.m_vfxVAGSTD_UIItemTitleRe1;
		p.receCmd2 = YPStandardProtocol.m_vfxVAGSTD_UIItemTitleRe2;

		return p;
	}
}
