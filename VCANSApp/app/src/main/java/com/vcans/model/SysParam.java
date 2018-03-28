package com.vcans.model;

import com.vcans.Processor.Skin;



public class SysParam {
	
	public enum ELanguage{CH,EN};
	public int nYpQueryHistoryNum;
	public boolean bAutoCreateId=false;
	public ELanguage language=ELanguage.CH;  
	public Skin sysSkin=new Skin();
}
