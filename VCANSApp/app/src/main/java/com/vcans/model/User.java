package com.vcans.model;

public class User {
	private String userName="";
	private String pwd="";
	private String[] szPower;
	private String[] szItemPower;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	


	public void setSzPower(String[] szPower) {
		this.szPower = szPower;
	}
	public boolean getPower(int index) {
		
		boolean bEnabled=false;
		if(szPower!=null&&index<szPower.length)
			bEnabled=szPower[index].equals("Y")?true:false;
		
		return bEnabled;
	}
	


	public void setSzItemPower(String[] szPower) {
		 szItemPower = szPower;
	}
	public boolean getItemPower(int index) {
		
		boolean bEnabled=false;
		if(szItemPower!=null&&index<szItemPower.length)
			bEnabled=szItemPower[index].equals("Y")?true:false;
		
		return bEnabled;
	}

}
