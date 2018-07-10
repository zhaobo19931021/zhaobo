package com.zb20180409.sygl.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.zb20180409.sygl.domain.Kf;

public interface IKfService {
	
	public int total(Integer kfbh,String kfmc);
	
	public List<Kf> findKfByPage(Integer page,Integer rows,Integer kfbh,String kfmc);
	
	public void delete(int kfbh);
	
	public void save(List<Kf> kfList);
	
	public Kf edit(int kfbh);
	
	public void update(Kf kf);
}
