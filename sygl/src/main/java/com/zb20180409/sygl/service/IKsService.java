package com.zb20180409.sygl.service;

import java.util.List;

import com.zb20180409.sygl.domain.Kf;
import com.zb20180409.sygl.domain.Ks;
import com.zb20180409.sygl.domain.PageInfo;

public interface IKsService {

	public int total(Integer ksbh,Integer ksmc);
	
	public List<Ks> findKsByPage(Integer page,Integer rows,Integer ksbh,Integer ksmc);
	
	public void delete(int ksbh);
	
	public void save(List<Ks> ksList);
	
	public Ks edit(int ksbh);
	
	public void update(Ks ks);
}