package com.vcans.adapter;


import java.util.ArrayList;
import java.util.List;

import com.Vcan.activity.R;
import com.Vcan.activity.MlqdActivity1;
import com.vcans.model.Mlqd;
import com.vcans.tool.ActivityHelper;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class listAdapter extends BaseAdapter {
	  private Context context;
	  String mp,mp1;
      List<String> list;  
      List<String> list1; 
      private LayoutInflater inflater;  
      ArrayList<String> List1, List2;
      Cursor cursor;
     
      SQLiteDatabase db=SQLiteDatabase.openDatabase(ActivityHelper.PAHT, null, 2);
      String s;
       Mlqd mlqd;
		String strmlbh;String	mlbh;
      private Pro_type_adapter adapter;
      ViewHolder viewHolder;


	public listAdapter(Context context,ArrayList<String> list,ArrayList<String> list1,String s) {
		this.context = context;  
		inflater = LayoutInflater.from(context);
        this.list=list;	
        this.list1=list1;	
        this.s=s;	
	 }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		 mp = list.get(position);  
		 viewHolder= null;  
        if (convertView == null) {  
            viewHolder = new ViewHolder();  
            convertView = inflater.inflate(R.layout.mmm, null);            
            viewHolder.textView = (TextView) convertView.findViewById(R.id.text); 
            viewHolder.gridView = (GridView) convertView.findViewById(R.id.GridView); 
           
            convertView.setTag(viewHolder);
        } else {  
            viewHolder = (ViewHolder) convertView.getTag();  
        }  
      
         viewHolder.textView.setText(list.get(position));
         adapter=new Pro_type_adapter(context, Query1(),Query2(),Mibh(s));/////////////////////////////////
         viewHolder.gridView.setAdapter(adapter);
         
         viewHolder.textView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				    mlqd= Query(s,list.get(position));
				    if (mlqd!=null) {
				    	Intent intent=new Intent(arg0.getContext(),MlqdActivity1.class);
						intent.putExtra("strcj", mlqd.strcj);
						intent.putExtra("strmlbh",mlqd.strmlbh);
						intent.putExtra("strmlname", mlqd.strmlname);					
						arg0.getContext().startActivity(intent);
					}
				    
			}
		
		 });
		return convertView;
	}
	 class ViewHolder {         
	        private TextView textView;
	        private GridView gridView;
	    }
	 

	 
	   private String Query() {
		   try {
		   CharSequence ss=viewHolder.textView.getText();
			String sql="select * from MLQingdan where  Mlname = "+"'"+ss+"'"+" ";
			
	        cursor = db.rawQuery(sql, new String[]{});	   
	        while (cursor.moveToNext()) {  
	        	
	        	strmlbh  = cursor.getString(2);      
	        }
		    } catch (Exception e) {
				// TODO: handle exception
			}
		   cursor.close();
			return strmlbh;

		}	
	   
	   private String Mibh(String s) {
		   try {
		   CharSequence ss=viewHolder.textView.getText();
			String sql="select * from MLQingdan where Ssfjbh = "+"'"+s+"'"+" and Mlname = "+"'"+ss+"'"+" ";
			
	        cursor = db.rawQuery(sql, new String[]{});	   
	        while (cursor.moveToNext()) {                 
	        	
	       	mlbh  = cursor.getString(2);      
	        }
	        
		    } catch (Exception e) {
				// TODO: handle exception
			}
		   cursor.close();
			return mlbh;

		}	
		
		public ArrayList<String> Query1() {
			try {
			String sql="select * from MLQingdan where Cj = 3  and Ssfjbh = "+"'"+Mibh(s)+"'"+" ";
			Log.e("TAG", sql);
			List1=new ArrayList<String>();
			
				 
			        cursor = db.rawQuery(sql, new String[]{});	   
			        while (cursor.moveToNext()) {      
				        String strmlname = cursor.getString(3);         	    
				        List1.add(strmlname);	       
			        
			        }
			} catch (Exception e) {
				// TODO: handle exception
			}
			cursor.close();
			return List1;
		}
		
		public ArrayList<String> Query2() {
			 try {
			String sql="select * from MLQingdan where Cj = 3 and Ssfjbh = "+"'"+Mibh(s)+"'"+" ";
			List2=new ArrayList<String>();
			
				 cursor = db.rawQuery(sql, new String[]{});	   
			        while (cursor.moveToNext()) {      
				        String img = cursor.getString(5);         	    
				        List2.add(img);	       
			        
			        }
			} catch (Exception e) {
				// TODO: handle exception
			}
			cursor.close();
			return List2;
		}
		
		   private Mlqd Query(String ss,String s) {			
				String sql="select * from MLQingdan where Ssfjbh = "+"'"+ss+"'"+" and  Mlname = "+"'"+s+"'"+" ";
				
		        cursor = db.rawQuery(sql, new String[]{});	   
		        while (cursor.moveToNext()) {  
		        	String strId= cursor.getString(0);
		        	String strcj= cursor.getString(1);
		        	String  strmlbh  = cursor.getString(2); 
		        	String strmlname= cursor.getString(3);
		        	String strssfjbh= cursor.getString(4);
		        	String strspare= cursor.getString(5);
		        	String strspare1= cursor.getString(6);
		        	// mlqd=new Mlqd(strId, strcj, strmlbh, strmlname, strssfjbh, strspare, strspare1);	
		        	Mlqd.Builder builder=new Mlqd.Builder();
		        	mlqd=builder.strcj(strcj)
		        			.strId(strId)
		        			.strmlbh(strmlbh)
		        			.strmlname(strmlname)
		        			.strspare(strspare1)
		        			.strssfjbh(strssfjbh)
		        			.strspare(strspare)
		        			.strspare1(strspare1)
		        			.build();
		        }
			   cursor.close();
			  return mlqd;
			
			}	
		
}

