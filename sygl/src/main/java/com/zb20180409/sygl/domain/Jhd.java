package com.zb20180409.sygl.domain;

public class Jhd {
	private String jhdbh ;
	private String jhsj ;
	private int jhr ;//关联user.uno
	private int gys ;//关联gys.gysbh
	private int kf ;//关联kf.kfbh
	private int zj ;
	
	private String yl1 ;
	private String yl2 ;
	private String yl3 ;
	
	private String jhrmc ;
	private String gysmc ;
	private String kfmc ;
	public Jhd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jhd(String jhdbh, String jhsj, int jhr, int gys, int kf, int zj, String yl1, String yl2, String yl3,
			String jhrmc, String gysmc, String kfmc) {
		super();
		this.jhdbh = jhdbh;
		this.jhsj = jhsj;
		this.jhr = jhr;
		this.gys = gys;
		this.kf = kf;
		this.zj = zj;
		this.yl1 = yl1;
		this.yl2 = yl2;
		this.yl3 = yl3;
		this.jhrmc = jhrmc;
		this.gysmc = gysmc;
		this.kfmc = kfmc;
	}
	public String getJhdbh() {
		return jhdbh;
	}
	public void setJhdbh(String jhdbh) {
		this.jhdbh = jhdbh;
	}
	public String getJhsj() {
		return jhsj;
	}
	public void setJhsj(String jhsj) {
		this.jhsj = jhsj;
	}
	public int getJhr() {
		return jhr;
	}
	public void setJhr(int jhr) {
		this.jhr = jhr;
	}
	public int getGys() {
		return gys;
	}
	public void setGys(int gys) {
		this.gys = gys;
	}
	public int getKf() {
		return kf;
	}
	public void setKf(int kf) {
		this.kf = kf;
	}
	public int getZj() {
		return zj;
	}
	public void setZj(int zj) {
		this.zj = zj;
	}
	public String getYl1() {
		return yl1;
	}
	public void setYl1(String yl1) {
		this.yl1 = yl1;
	}
	public String getYl2() {
		return yl2;
	}
	public void setYl2(String yl2) {
		this.yl2 = yl2;
	}
	public String getYl3() {
		return yl3;
	}
	public void setYl3(String yl3) {
		this.yl3 = yl3;
	}
	public String getJhrmc() {
		return jhrmc;
	}
	public void setJhrmc(String jhrmc) {
		this.jhrmc = jhrmc;
	}
	public String getGysmc() {
		return gysmc;
	}
	public void setGysmc(String gysmc) {
		this.gysmc = gysmc;
	}
	public String getKfmc() {
		return kfmc;
	}
	public void setKfmc(String kfmc) {
		this.kfmc = kfmc;
	}
	
	
}
