package com.vcans.tool;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;

import android.content.Context;
import android.os.Environment;

import android.util.JsonReader;
import android.util.JsonWriter;

public class JsonHelper {
	public static final String JSON_FILE="vcansStore.json";
	
	public static HashMap<String,String> GetJsonData()
    {
		HashMap<String,String> mapValue=new HashMap<String,String>();
    	String strIp="",strPort="";
    	String strContent="";
    	FileInputStream fin=null;
		JsonReader jw=null;
		String filePath;
		try
		{
			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
			{
				filePath=Environment.getExternalStorageDirectory().toString()+"/"+ActivityHelper.APP_DIR+"/"+JSON_FILE;
	
				
				fin=new FileInputStream(filePath);
				
				jw=new JsonReader(new InputStreamReader(fin,"utf-8"));
				
				jw.beginArray();
				while(jw.hasNext())
				{
					jw.beginObject();
					
					while(jw.hasNext())
					{
						String strField=jw.nextName();
						
						if(strField!=null)
						{
							mapValue.put(strField, jw.nextString());
//							if(strField.equals("ipAdr"))
//								strIp=jw.nextString();
//							else if(strField.equals("port"))
//								strPort=jw.nextString();
						}
							
					}
					
					jw.endObject();
				}
				
				jw.endArray();
				
				jw.close();
				
				strContent=strIp+";"+strPort;
			}
			else
			{
				//fin = c.openFileInput(JSON_FILE);//(, Activity.MODE_WORLD_WRITEABLE);
				//byte[] buf=new byte[100];
				//int count=fin.read(buf);
			}
				
			fin.close();
		}
		catch(IOException e)
		{
			e.getMessage();
		}
		
		return mapValue;
    }
	
	public static int SaveJsonData(HashMap<String,String> mapValues)
	{
		//дjson
		
		if(mapValues==null)
			return -1;
		
		try
		{
			//android.os.Environment.getDataDirectory()
			FileOutputStream fo = null;
			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
			{
			     fo=new FileOutputStream(android.os.Environment.getExternalStorageDirectory()+"/"+ActivityHelper.APP_DIR+"/"+JSON_FILE);
			     
					JsonWriter jw=new JsonWriter(new OutputStreamWriter(fo,"utf-8"));
					jw.setIndent(" ");
					jw.beginArray();
					jw.beginObject();
					
					for(Iterator<String> it=mapValues.keySet().iterator();it.hasNext();)
					{
						String key=it.next();
						jw.name(key).value(mapValues.get(key));
					}
					
					jw.endObject();
					jw.endArray();
					jw.close();	
			}
			else
			{
				//fo = c.openFileOutput(JSON_FILE,Context.MODE_PRIVATE);
				//fo.write("".getBytes("utf-8"));
			}
			
			fo.close();
		}
		catch(IOException e)
		{
			return -1;
		}
		
		return 1;
	}
	
}
