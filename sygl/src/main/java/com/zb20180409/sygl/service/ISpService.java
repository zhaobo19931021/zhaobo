package com.zb20180409.sygl.service;

import java.util.List;

import com.zb20180409.sygl.domain.Sp;

public interface ISpService {

	public int total(Integer spbh , String spmc) ;
	
	public List<Sp> findSpByPage(Integer page , Integer rows , Integer spbh,String spmc) ;
	
	public void delete(int spbh) ;
	
	public void saves(List<Sp> spList) ;
	
	public Sp edit(int spbh) ;
	
	public void update(Sp sp) ;
}

