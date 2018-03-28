package com.vcans.Processor;

import com.vcans.tool.DataTrunsfer;

public class Singleton {
   private static DataTrunsfer mTrunsfer=null;
   
   public static DataTrunsfer getDataTrunsfer()
   {
	   if(mTrunsfer==null) 
		   mTrunsfer=new DataTrunsfer();
	   
	   return mTrunsfer;
   }
}
