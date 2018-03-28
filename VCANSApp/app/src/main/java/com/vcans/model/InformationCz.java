package com.vcans.model;

import java.io.Serializable;

public class InformationCz  implements Serializable{
	public String strglxxId="";
	public String strcztype="";
	public String strczId="";
	public String strczname="";
	
	
	public InformationCz(String strglxxId, String strcztype, String strczId,
			String strczname) {
		super();
		this.strglxxId = strglxxId;
		this.strcztype = strcztype;
		this.strczId = strczId;
		this.strczname = strczname;
	}
	
	public String getStrglxxId() {
		return strglxxId;
	}
	public void setStrglxxId(String strglxxId) {
		this.strglxxId = strglxxId;
	}
	public String getStrcztype() {
		return strcztype;
	}
	public void setStrcztype(String strcztype) {
		this.strcztype = strcztype;
	}
	public String getStrczId() {
		return strczId;
	}
	public void setStrczId(String strczId) {
		this.strczId = strczId;
	}
	public String getStrczname() {
		return strczname;
	}
	public void setStrczname(String strczname) {
		this.strczname = strczname;
	}
	
}
