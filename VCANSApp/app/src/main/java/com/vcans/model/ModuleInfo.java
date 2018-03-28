package com.vcans.model;

import java.util.ArrayList;

public class ModuleInfo {
	
	public ArrayList<MenuU> lstMenu=new ArrayList<MenuU>();
	
	public static void sort(ArrayList<MenuU> lst)
	{
		int flag=0;
		
		for(int i=0;i<lst.size();++i)
		{
			flag=0;
			
			for(int j=0;j<lst.size()-i-1;++j)
			{
				if(lst.get(j).sortId>lst.get(j+1).sortId)
				{
					flag=1;
					MenuU temp=lst.get(j);
					lst.set(j, lst.get(j+1));
					lst.set(j+1, temp);
				}
			}
			
			if(flag==0)
			{
				break;
			}
			
		}
	}
}
