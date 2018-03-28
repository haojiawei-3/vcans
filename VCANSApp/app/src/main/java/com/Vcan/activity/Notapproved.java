package com.Vcan.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.Processor.BaseActivity;
import com.vcans.adapter.NotapprovedAdapter;
import com.vcans.model.Information;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.playListview;

import android.os.Bundle;
import android.os.Environment;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
/**
 *
 * @author vcans
 *
 */
public class Notapproved extends BaseActivity {
	    private int mLastClickId=-1;
	    private long mLastClickTime=0;
		List<Information> Informationlist; 
		SQLiteDatabase db;
		String mDbPath;
		Cursor cursor;
		ListView myview;
		Information information;
		NotapprovedAdapter adapter;
		playListview playListview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notapproved);
		this.<Button>RegOnClickEvent(R.id.btnBack,"finish");
		myview=(ListView)findViewById(R.id.splist);	
		playListview = (playListview) findViewById(R.id.refreshable_view);
		myview.setEmptyView(findViewById(R.id.img));
	    Informationlist = new ArrayList<Information>();		
		db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, REQUEST_SCAN_QRCODE_FLAG);
		Query();
		adapter = new NotapprovedAdapter(Notapproved.this,  Informationlist);
		myview.setAdapter(adapter);		
		myview.setOnItemClickListener(listClickListener);  
		myview.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {	           
				mstrDataId=Informationlist.get(position).strId;
				onDelete();
				return true;
			}
		});
		 playListview.setOnRefreshListener(new com.vcans.tool.playListview.PullToRefreshListener() {
				
				@Override
				public void onRefresh() {
					// TODO Auto-generated method stub
					try {
						    Thread.sleep(1000);
						   
						   						    
						   
						    
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					playListview.finishRefreshing();
				}
			}, 0);
	}


     public final OnItemClickListener listClickListener=new OnItemClickListener(){   
        
        public void onItemClick(AdapterView<?> parent, View view, int position,   
                long id) {   
        	  
           
			// �����˫��,1������������ж�Ϊ˫��
			if(position==mLastClickId && (Math.abs(mLastClickTime-System.currentTimeMillis()) < 1000))
			{
				mLastClickId = -1;
				mLastClickTime = 0;									  
	        		

		   }
          else
          {
        	    Intent intent = new Intent(Notapproved.this,Notapproved1.class);  
        	    information=new Information();	        	   
        	    information.setStrcontent(Informationlist.get(position).strcontent);
        	    information.setStrId(Informationlist.get(position).strId);
        	    information.setStrinitiator(Informationlist.get(position).strinitiator);
        	    information.setStrmoduletype(Informationlist.get(position).strmoduletype);
        	    information.setStrmoduletypeId(Informationlist.get(position).strmoduletypeId);
        	    information.setStrodd(Informationlist.get(position).strodd);
        	    information.setStroddId(Informationlist.get(position).stroddId);
        	    information.setStrstate(Informationlist.get(position).strstate);
        	    information.setStrstateId(Informationlist.get(position).strstateId);	
        	    information.setStrthemer(Informationlist.get(position).strthemer);	        	   
        	    information.setStrtype(Informationlist.get(position).strtype);
        	    information.setStrmodulename(Informationlist.get(position).strmodulename);
          	    information.setStrdate(Informationlist.get(position).strdate);
          	    information.setStrSpare2(Informationlist.get(position).strSpare2);
          	    information.setStrxxId(Informationlist.get(position).strxxId);
          	    information.setStrSpare4(Informationlist.get(position).strSpare4);
        		intent.putExtra("Informationlist", information);
        		startActivity(intent);       		
				mLastClickId =position;
				mLastClickTime = System.currentTimeMillis();
				
		   }			
        }    
    };
    
    @Override
	protected void onRestart() {
		// TODO Auto-generated method stub
	 Informationlist.clear();		            	 	
	 Query();
	 adapter.notifyDataSetChanged();
			Log.e("TAG", "onRestart");
		super.onRestart();
	}
    
    
    public void onDelete()
	 {		
		 if(myview.getCount()<1)
		 {
			 return ;
		 }
		 
		 new AlertDialog.Builder(this).setTitle(getString(R.string.askDelete))  
		    .setIcon(android.R.drawable.ic_dialog_info)  
		    .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {  
		  
		        public void onClick(DialogInterface dialog, int which) {  
		        // �����ȷ�ϡ���Ĳ���  
		            if(!mstrDataId.equals(""))
		            {
		            	 Informationlist.clear();		            	 	
		            	 DeleteById(mstrDataId);
		            	 Query();
		            	 adapter.notifyDataSetChanged();	
		            }
		        }  
		    })  
		    .setNegativeButton(getString(R.string.cancle), new DialogInterface.OnClickListener() {  
		  
		        public void onClick(DialogInterface dialog, int which) {  
		        // ��������ء���Ĳ���,���ﲻ����û���κβ���  
		        }  
		    }).show();  	 
	 }
    
    
    public int DeleteById(String strIds)
	{  	   
    	   db.execSQL("delete from Pendingapproval where TPId=?",   new Object[]{strIds});  
		 return mLastClickId;		
	}
    
	public void Query() {
	            cursor = db.rawQuery("select * from Pendingapproval where Type = 1   and Spare1 = 3  order by TPId  desc", new String[]{});	            
	            while (cursor.moveToNext()) {              	
	    	        information = new Information(cursor.getString(0), 
			        		  cursor.getString(1), 
			        		  cursor.getString(2), 
			        		  cursor.getString(3), 
			        		  cursor.getString(4),
			        		  cursor.getString(5),
			        		  cursor.getString(6),
			        		  cursor.getString(7),
			        		  cursor.getString(8),
			        		  cursor.getString(9),
			        		  cursor.getString(10),
			        		  cursor.getString(11), 
			        		  cursor.getString(12),
			        		  cursor.getString(13),
	                          cursor.getString(14),
	                          cursor.getString(15),
	                          cursor.getString(16), 
	                          cursor.getString(17), 
	                          cursor.getString(18));
	            Informationlist.add(information); 	           	           
	        }  
	       
	       
	}
	


	@Override
	public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub
		
	}

}
