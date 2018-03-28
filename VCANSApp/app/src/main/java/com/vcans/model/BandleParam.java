package com.vcans.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


public class BandleParam implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6257537837275858714L;
	public List<HashMap<String,Object> >  dataList=null;
	public String[] szFieldData=null;
	public int[] szRId=null;
	public int rid;
	public int itemRId;
	public int listRId;
	public int pageRId;
	public Object other;
}
