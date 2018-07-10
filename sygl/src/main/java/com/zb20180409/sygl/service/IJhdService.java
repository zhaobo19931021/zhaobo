package com.zb20180409.sygl.service;

import java.util.List;

import com.zb20180409.sygl.domain.Jhd;

public interface IJhdService {
	
	public int total();
	
	public List<Jhd> findJhdAll(int page , int rows);
	
	public String findJhdbh(String jhdbhPrefix);
	
	public void save(Jhd jhd,String spbhs,String sls,String djs);
}
