package com.zb20180409.sygl.domain;

import java.util.List;

public class PageInfo {
	
	private int total;
	
	private List<?> rows;

	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageInfo(int total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
