package com.vcans.model;

public class Mpsbinfo {

	public String id="";
    public String strcompany="";
    public String strlinkname="";
	public String strposition="";
	public String strphone1="";
    public String strphone2="";
    public String strfax="";
    public String strwww="";
    public String strImgPath="";
    public String stremail=""; 
    public String strnote="";
	public String straddress="";
	public String biaozhi="";
	 public Mpsbinfo(){
		 
	 }
//	 company, linkname ,position ,phone1, phone2, fax ,address , www ,email ,note;
	public Mpsbinfo(String id, String strcompany, String strlinkname,String strposition, String strphone1, String strphone2,String strfax,String straddress, String strwww,  String stremail,String strnote, String strImgPath) {
		super();
		this.id = id;
		this.strcompany = strcompany;
		this.strlinkname = strlinkname;
		this.strposition = strposition;
		this.strphone1 = strphone1;
		this.strphone2 = strphone2;
		this.strfax = strfax;
		this.strwww = strwww;
		this.strImgPath = strImgPath;
		this.stremail = stremail;
		this.strnote = strnote;
		this.straddress = straddress;
	}

	@Override
	public String toString() {
		return "Mpsbinfo [id=" + id + ", strcompany=" + strcompany
				+ ", strlinkname=" + strlinkname + ", strposition="
				+ strposition + ", strphone1=" + strphone1 + ", strphone2="
				+ strphone2 + ", strfax=" + strfax + ", strwww=" + strwww
				+ ", strImgPath=" + strImgPath + ", stremail=" + stremail
				+ ", strnote=" + strnote + ", straddress=" + straddress + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStrcompany() {
		return strcompany;
	}
	public void setStrcompany(String strcompany) {
		this.strcompany = strcompany;
	}
	public String getStrlinkname() {
		return strlinkname;
	}
	public void setStrlinkname(String strlinkname) {
		this.strlinkname = strlinkname;
	}
	public String getStrposition() {
		return strposition;
	}
	public void setStrposition(String strposition) {
		this.strposition = strposition;
	}
	public String getStrphone1() {
		return strphone1;
	}
	public void setStrphone1(String strphone1) {
		this.strphone1 = strphone1;
	}
	public String getStrphone2() {
		return strphone2;
	}
	public void setStrphone2(String strphone2) {
		this.strphone2 = strphone2;
	}
	public String getStrfax() {
		return strfax;
	}
	public void setStrfax(String strfax) {
		this.strfax = strfax;
	}
	public String getStrwww() {
		return strwww;
	}
	public void setStrwww(String strwww) {
		this.strwww = strwww;
	}
	public String getStrImgPath() {
		return strImgPath;
	}
	public void setStrImgPath(String strImgPath) {
		this.strImgPath = strImgPath;
	}
	public String getStremail() {
		return stremail;
	}
	public void setStremail(String stremail) {
		this.stremail = stremail;
	}
	public String getStrnote() {
		return strnote;
	}
	public void setStrnote(String strnote) {
		this.strnote = strnote;
	}
	public String getStraddress() {
		return straddress;
	}
	public void setStraddress(String straddress) {
		this.straddress = straddress;
	}
	

}
