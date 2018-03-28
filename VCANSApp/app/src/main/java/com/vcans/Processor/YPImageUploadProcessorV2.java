package com.vcans.Processor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.Vcan.activity.R;
import com.vcans.Protocol.YPStandardProtocol;
import com.vcans.adapter.CommentAdapter;
import com.vcans.adapter.CommentReplyAdapter;
import com.vcans.adapter.ImageSimpleAdapter;
import com.vcans.dao.YPInfoDao;
import com.vcans.model.MyProtocol;
import com.vcans.model.YPExpInfo;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.ProtocolCMD;


public class YPImageUploadProcessorV2 extends UploadProcessor {

	public YPInfoDao mSCToupeiDao=null;
	List<HashMap<String,Object> > mTouPeiList=null;
	Vector<Vector<String> > mVctSendData=null;
	private CommentAdapter commentAdapter;
	public CommentAdapter getCommentAdapter() {
		return commentAdapter;
	}

	private CommentReplyAdapter commentReplyAdapter;
	private List<HashMap<String, Object>> list_comment;

	private OnTouchListener onTouchListener;

	public void setOnTouchListener(OnTouchListener onTouchListener) {
		this.onTouchListener = onTouchListener;
	}

	public List<List<HashMap<String, Object>>> getList_comment_child() {
		return list_comment_child;
	}

	private List<List<HashMap<String, Object>>> list_comment_child=new ArrayList<List<HashMap<String, Object> > >();

	//private static final int ONE_COMMENT_CODE = -1;
	//private static final int TWO_COMMENT_CODE = 2;


	public YPImageUploadProcessorV2()
	{
		mSCToupeiDao=new YPInfoDao(YPInfoDao.DbType.YP_IMAGE);
	}

	@Override
	public int ProcessData(Vector<String> vctDataId) {

		String strRecordIds=ConvertStringIds(vctDataId);

		mSCToupeiDao.DeleteAll(strRecordIds);
		System.gc();
		DisplayTouPeiInfo();


		return 1;
	}

	public String  filePaths(){
		String s=list_comment_child.get(0).get(list_comment_child.get(0).size()-1).get("YPValue").toString();
		return s;

	}


	public void DisplayTouPeiInfo()
	{
		list_comment=mSCToupeiDao.GetParentList();

		mTouPeiList=mSCToupeiDao.GetAllTeipei();
		list_comment_child.clear();
		for(HashMap<String,Object> mapList:list_comment)
		{
			List<HashMap<String, Object> > listChild=new ArrayList<HashMap<String, Object> >();
			for(HashMap<String,Object> mapList2:mTouPeiList)
			{
				String stBarcode=(String)mapList.get("Barcode");
				String stBarcode2=(String)mapList2.get("Barcode");
				if(stBarcode.equals(stBarcode2))
				{
					listChild.add(mapList2);
				}
			}

			list_comment_child.add(listChild);
		}


		//String[] szField={"TPId","Barcode","YPField","YPValue"};

		//int[] szRId={R.id.imgYP,R.id.tvBarcode,R.id.tvInnerId,R.id.tvPrice,R.id.tvNum};



		commentAdapter = new CommentAdapter(mActParent, list_comment,list_comment_child, myOnitemcListener, commentReplyAdapter);

		commentAdapter.setOnTouchListener(onTouchListener);

		ListView listView = (ListView) mActParent.findViewById(R.id.lvProdct);
		if(listView==null) return;

		listView.setAdapter(commentAdapter);

		TextView tvPage = (TextView) mActParent.findViewById(R.id.tvPage);
		tvPage.setText("(0/"+listView.getCount()+")");

		mActParent.processMessage(10,"");
	}





	final public OnClickListener myOnitemcListener = new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			commentAdapter.setSelectIndex(v.getId());
			commentAdapter.notifyDataSetChanged();
		}
	};

	public void DisplayOneInfo(List<HashMap<String,Object> > listMap)
	{

		String[] szField={"ImgName","Barcode","TPId","Price","Num"};

		int[] szRId={R.id.imgYP,R.id.tvBarcode,R.id.tvInnerId,R.id.tvPrice,R.id.tvNum};

		SimpleAdapter adpter=new ImageSimpleAdapter(mActParent,listMap,R.layout.yp_barcodenoimg_item,szField,szRId);
		ListView listView = (ListView) mActParent.findViewById(R.id.lvProdct);
		listView.setAdapter(adpter);
		TextView tvPage = (TextView) mActParent.findViewById(R.id.tvPage);
		tvPage.setText("(0/"+listView.getCount()+")");

		//mActParent.processMessage(0,"");
	}

	public int SaveToupeiInfo(YPExpInfo toupei)
	{
		if(toupei.strBarcode.equals("")||toupei.strImgName.equals(""))
		{
			ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.isNUll));
			return 0;
		}

		int nRst=mSCToupeiDao.AddToupei(toupei);
		if(nRst==2)
		{
			ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.datareplace));
			DisplayTouPeiInfo();
		}
		else if(nRst<1)
		{
			ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.saveFail));
		}
		else
		{
			ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.saveSuccess));
			DisplayTouPeiInfo();
			return 1;
		}

		return 0;
	}


	public int updatePhoto(YPExpInfo toupei)
	{

		String s=toupei.strImgName;
		int nRst=mSCToupeiDao.update(toupei);
		if(nRst==0)
		{
			ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.saveFail));
			DisplayTouPeiInfo();
		}
		else if(nRst<1)
		{
			ActivityHelper.showDialog(mActParent,"错误",mActParent.getString(R.string.saveFail));
		}
		else
		{
			String[] files=ActivityHelper.mySplit(toupei.strFiles, ";");
			ActivityHelper.showDialog(mActParent,"提示",mActParent.getString(R.string.saveSuccess)+"("+(toupei.imgIndex+1)+"/"+files.length+")");
			DisplayTouPeiInfo();
			return 1;
		}

		return 0;
	}

	/*
	public Bitmap[] getBitmapsByFilepaths(String paths)
	{
		String[] szFiles=ActivityHelper.mySplit(paths, ";");

		Bitmap[] images=new Bitmap[szFiles.length];
		int i=0;
		for(String filePath:szFiles)
		{
			BitmapFactory.Options options=new BitmapFactory.Options();
			options.inPurgeable=true;
	        options.inSampleSize = ActivityHelper.IMAGE_COMPRESS_RATIO;

	        //旋转  纠正图片
	        Bitmap bitmap;
            
	        if(!filePath.equals(""))
	        {
	            bitmap=BitmapFactory.decodeFile(filePath,options);
	            bitmap=ActivityHelper.autoMatrixBitmap(filePath, bitmap);
	        }
	        else
	        {
	        	bitmap=BitmapFactory.decodeResource(mActParent.getResources(), R.drawable.no_img);
	        }
	        
	
            
        	images[i++]=bitmap;
	        	
		}
		
		return images;
	}
	*/

	public void ClearToupeiInfo()
	{
		mSCToupeiDao.DeleteAll(null);
		DisplayTouPeiInfo();
	}

	public void DeleteToupeiInfo(String dataId)
	{
		mSCToupeiDao.DeleteAll("'"+dataId+"'");
		DisplayTouPeiInfo();
	}

	@Override
	public Vector<Vector<String>> GetSendData(String[] extrData) {

		mVctSendData=new Vector<Vector<String> > ();

		for(List<HashMap<String,Object>> mapToupeiList:list_comment_child)
		{
			Vector<String> child= new Vector<String>();

			for(HashMap<String,Object> mapYpInfo:mapToupeiList)
			{
				String strField=(String)mapYpInfo.get("YPField");
				if(strField.equals(mActParent.getString(R.string.image)))
					child.add(ProtocolCMD.FILE_FIELD_FLAG+(String)mapYpInfo.get("YPValue"));
				else
					child.add((String)mapYpInfo.get("YPValue"));
			}

			mVctSendData.add(child);
		}

		return mVctSendData;
	}

	@Override
	public MyProtocol GetProtocol() {

		MyProtocol myProtocol=new MyProtocol();

		myProtocol.sendCmd0= YPStandardProtocol.m_vfxVAG43VcanYangpinImage0;
		myProtocol.sendCmd1=YPStandardProtocol.m_vfxVAG43VcanYangpinImage1;
		myProtocol.sendCmd2=YPStandardProtocol.m_vfxVAG43VcanYangpinImage2;
		myProtocol.sendCmd3=YPStandardProtocol.m_vfxVAG43VcanYangpinImage3;
		myProtocol.receCmd0=YPStandardProtocol.m_vfxVAG43VcanYangpinImageRe0;
		myProtocol.receCmd1=YPStandardProtocol.m_vfxVAG43VcanYangpinImageRe1;
		myProtocol.receCmd3=YPStandardProtocol.m_vfxVAG43VcanYangpinImageRe3;
		myProtocol.receCmd5=YPStandardProtocol.m_vfxVAG43VcanYangpinImageRe5;

		return myProtocol;
	}
}
