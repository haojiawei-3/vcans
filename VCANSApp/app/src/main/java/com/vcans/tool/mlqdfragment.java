package com.vcans.tool;

import java.util.ArrayList;
import java.util.List;

import com.Vcan.activity.R;
import com.vcans.adapter.listAdapter;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

public class mlqdfragment extends Fragment {
		private ArrayList<String> list1,list2;
		private ImageView hint_img;
		private ListView listView;
		private listAdapter adapter2;
		private String typename,typename1;
		Cursor cursor;
		SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
		String strmlbh;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_pro_type, null);
		listView = (ListView) view.findViewById(R.id.listView);
		
		typename=getArguments().getString("typename");
		
		
		list1=new ArrayList<String>();
		list2=new ArrayList<String>();
		adapter2=new listAdapter(view.getContext(), Query1(),Query2(),Query());
		listView.setAdapter(adapter2);
		
		return view;
	}
	private String Query() {
		String sql="select * from MLQingdan where  Mlname = "+"'"+typename+"'"+" ";
		
        cursor = db.rawQuery(sql, new String[]{});	   
        while (cursor.moveToNext()) {  
        	
        	strmlbh  = cursor.getString(2);      
        }
		cursor.close();
		return strmlbh;

	}	
	
	public ArrayList<String> Query1() {
		String sql="select * from MLQingdan where Cj = 2 and Ssfjbh = "+"'"+Query()+"'"+" ";
	
        cursor = db.rawQuery(sql, new String[]{});	   
        while (cursor.moveToNext()) {      
	        String strmlname = cursor.getString(3);         	    
	        list1.add(strmlname);	       
        
        }
		cursor.close();
		return list1;
	}
	
	public ArrayList<String> Query2() {
		String sql="select * from MLQingdan where Cj = 2 and Ssfjbh = "+"'"+Query()+"'"+" ";
		try {
			 cursor = db.rawQuery(sql, new String[]{});	   
		        while (cursor.moveToNext()) {      
			        String strmlbh = cursor.getString(2);         	    
			        list2.add(strmlbh);	       
		        
		        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		cursor.close();
		return list2;
	}

}
