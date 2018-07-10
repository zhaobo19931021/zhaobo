package com.zb20180409.sygl.service;

import java.util.List;

import com.zb20180409.sygl.domain.Gys;

public interface IGysService {
	
	public int total(Integer gysbh,String gysmc);
	
	public List<Gys> findGysByPage(Integer page,Integer rows,Integer gysbh,String gysmc);
	
	public void delete(int gysbh);
	
	public void save(List<Gys> gysList);
	
	public Gys edit(int gysbh);
	
	public void update (Gys gys);
}
