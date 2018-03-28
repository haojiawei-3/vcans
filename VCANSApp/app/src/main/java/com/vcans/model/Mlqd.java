package com.vcans.model;

import java.io.Serializable;

public class Mlqd  implements Serializable {
	public String strId="";
	public String strcj="";
	public String strmlbh="";
	public String strmlname="";
	public String strssfjbh="";
	public String strspare="";
	public String strspare1="";
	
	
	
	 private Mlqd(Builder builder){
		    this.strId=builder.strId;
		    this.strcj=builder.strcj;
		    this.strmlbh=builder.strmlbh;
		    this.strmlname=builder.strmlname;
		    this.strssfjbh=builder.strssfjbh;
		    this.strspare=builder.strspare;
		    this.strspare1=builder.strspare1;
		  }  
	
  public static class Builder{
	    public String strId="";
		public String strcj="";
		public String strmlbh="";
		public String strmlname="";
		public String strssfjbh="";
		public String strspare="";
		public String strspare1="";
		public Builder strId(String strId) {
			 this.strId=strId;
		      return this;
		}public Builder strcj(String strcj) {
			 this.strcj=strcj;
		      return this;
		}
		public Builder strmlbh(String strmlbh) {
			 this.strmlbh=strmlbh;
		      return this;
		}
		public Builder strmlname(String strmlname) {
			 this.strmlname=strmlname;
		      return this;
		}
		public Builder strssfjbh(String strssfjbh) {
			 this.strssfjbh=strssfjbh;
		      return this;
		}
		public Builder strspare(String strspare) {
			 this.strspare=strspare;
		      return this;
		}
		public Builder strspare1(String strspare1) {
			 this.strspare1=strspare1;
		      return this;
		}
		 public Mlqd build(){
		      return new Mlqd(this);
		    }
		
		
	  
  }
  
	public Mlqd() {
		
	}
	public Mlqd(String strId, String strcj, String strmlbh, String strmlname,
			String strssfjbh, String strspare, String strspare1) {
		super();
		this.strId = strId;
		this.strcj = strcj;
		this.strmlbh = strmlbh;
		this.strmlname = strmlname;
		this.strssfjbh = strssfjbh;
		this.strspare = strspare;
		this.strspare1 = strspare1;
	}
	
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getStrcj() {
		return strcj;
	}
	public void setStrcj(String strcj) {
		this.strcj = strcj;
	}
	public String getStrmlbh() {
		return strmlbh;
	}
	public void setStrmlbh(String strmlbh) {
		this.strmlbh = strmlbh;
	}
	public String getStrmlname() {
		return strmlname;
	}
	public void setStrmlname(String strmlname) {
		this.strmlname = strmlname;
	}
	public String getStrssfjbh() {
		return strssfjbh;
	}
	public void setStrssfjbh(String strssfjbh) {
		this.strssfjbh = strssfjbh;
	}
	public String getStrspare() {
		return strspare;
	}
	public void setStrspare(String strspare) {
		this.strspare = strspare;
	}
	public String getStrspare1() {
		return strspare1;
	}
	public void setStrspare1(String strspare1) {
		this.strspare1 = strspare1;
	}
	
}
