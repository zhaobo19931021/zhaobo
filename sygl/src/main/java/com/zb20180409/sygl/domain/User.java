package com.zb20180409.sygl.domain;

public class User {
	private Integer uno;
	private String uname;
	private String upass;
	private String truename;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer uno, String uname, String upass, String truename) {
		super();
		this.uno = uno;
		this.uname = uname;
		this.upass = upass;
		this.truename = truename;
	}
	public Integer getUno() {
		return uno;
	}
	public void setUno(Integer uno) {
		this.uno = uno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
}
