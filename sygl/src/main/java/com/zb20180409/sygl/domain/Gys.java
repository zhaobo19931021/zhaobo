package com.zb20180409.sygl.domain;

public class Gys {
	private Integer gysbh;//供应商编号
	private String gysmc;//供应商名称
	private String zjm ;
	private String gyslxfs;//供应商联系方式
	private String gysdz;//供应商地址
	private String gyslxr;//供应商联系人
	
	private String yl1;
	private String yl2;
	private String yl3;
	private String yl4;
	private String yl5;
	public Gys() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gys(Integer gysbh, String gysmc, String zjm, String gyslxfs, String gysdz, String gyslxr, String yl1,
			String yl2, String yl3, String yl4, String yl5) {
		super();
		this.gysbh = gysbh;
		this.gysmc = gysmc;
		this.zjm = zjm;
		this.gyslxfs = gyslxfs;
		this.gysdz = gysdz;
		this.gyslxr = gyslxr;
		this.yl1 = yl1;
		this.yl2 = yl2;
		this.yl3 = yl3;
		this.yl4 = yl4;
		this.yl5 = yl5;
	}
	public Integer getGysbh() {
		return gysbh;
	}
	public void setGysbh(Integer gysbh) {
		this.gysbh = gysbh;
	}
	public String getGysmc() {
		return gysmc;
	}
	public void setGysmc(String gysmc) {
		this.gysmc = gysmc;
	}
	public String getZjm() {
		return zjm;
	}
	public void setZjm(String zjm) {
		this.zjm = zjm;
	}
	public String getGyslxfs() {
		return gyslxfs;
	}
	public void setGyslxfs(String gyslxfs) {
		this.gyslxfs = gyslxfs;
	}
	public String getGysdz() {
		return gysdz;
	}
	public void setGysdz(String gysdz) {
		this.gysdz = gysdz;
	}
	public String getGyslxr() {
		return gyslxr;
	}
	public void setGyslxr(String gyslxr) {
		this.gyslxr = gyslxr;
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
	public String getYl4() {
		return yl4;
	}
	public void setYl4(String yl4) {
		this.yl4 = yl4;
	}
	public String getYl5() {
		return yl5;
	}
	public void setYl5(String yl5) {
		this.yl5 = yl5;
	}
}