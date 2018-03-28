package com.vcans.model;

import java.io.Serializable;

public class CustomerCollect  implements Serializable,Comparable<CustomerCollect>{

	public String id;
	public String mark;
	public String mark1;
	public String khname;
	public String linkman;
	public String Phone;
	public String addr;
	public String khcode;
	public String ypcode;
	public String price;
	public String number;
	public String standby1;
	public String standby2;
	public String standby3;
	    
	    public CustomerCollect(){
	    	
	    }
	    //mark mark1 khname linkman Phone addr khcode ypcode price number standby1 standby2 standby3
	    public CustomerCollect( String id ,String mark, String mark1, String khname,
	    		String linkman,String Phone, String addr,String khcode, String ypcode,
	    		String price, String number,String standby1, String standby2, String standby3){	 
	    	this.id=id; 	
	    	this.mark=mark;
	    	this.mark1=mark1;  	
	    	this.khname=khname;    	
	    	this.linkman=linkman;
	    	this.Phone=Phone;
	    	this.addr=addr;  	
	    	this.khcode=khcode;  	
	    	this.ypcode=ypcode;   	
	    	this.price=price;   	
	    	this.number=number;   	
	    	this.standby1=standby1;
	    	this.standby2=standby2;
	    	this.standby3=standby3;
	    	
	    }
	    
	    public CustomerCollect(String mark, String mark1,
	    		String linkman,String Phone, String addr,
	    		String khname,
	    		String khcode, String ypcode,
	    		String price, String number) {
	    	this.mark=mark;
	    	this.linkman=linkman;
	    	this.Phone=Phone;
	    	this.addr=addr; 
	    	this.mark1=mark1;
	    	this.khname=khname; 
	    	this.khcode=khcode;  	
	    	this.ypcode=ypcode;   	
	    	this.price=price;   	
	    	this.number=number;   	
	    	
	    	
	    }
	    
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getMark() {
			return mark;
		}
		public void setMark(String mark) {
			this.mark = mark;
		}
		public String getMark1() {
			return mark1;
		}
		public void setMark1(String mark1) {
			this.mark1 = mark1;
		}
		public String getKhname() {
			return khname;
		}
		public void setKhname(String khname) {
			this.khname = khname;
		}
		public String getLinkman() {
			return linkman;
		}
		public void setLinkman(String linkman) {
			this.linkman = linkman;
		}
		public String getPhone() {
			return Phone;
		}
		public void setPhone(String phone) {
			Phone = phone;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public String getKhcode() {
			return khcode;
		}
		public void setKhcode(String khcode) {
			this.khcode = khcode;
		}
		public String getYpcode() {
			return ypcode;
		}
		public void setYpcode(String ypcode) {
			this.ypcode = ypcode;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getStandby1() {
			return standby1;
		}
		public void setStandby1(String standby1) {
			this.standby1 = standby1;
		}
		public String getStandby2() {
			return standby2;
		}
		public void setStandby2(String standby2) {
			this.standby2 = standby2;
		}
		public String getStandby3() {
			return standby3;
		}
		public void setStandby3(String standby3) {
			this.standby3 = standby3;
		}
		
		@Override
		public int compareTo(CustomerCollect arg0) {
			// TODO Auto-generated method stub
			return this.khcode.compareTo(arg0.khcode);
		}
	    

	   

	   
	}

