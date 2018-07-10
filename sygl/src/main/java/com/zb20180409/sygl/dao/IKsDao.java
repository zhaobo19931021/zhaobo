package com.zb20180409.sygl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zb20180409.sygl.domain.Kf;
import com.zb20180409.sygl.domain.Ks;

@Repository
public interface IKsDao {
	
	public int total(@Param("ksbh")Integer ksbh,@Param("ksmc")Integer ksmc);
	
	public List<Ks> findKsByPage(@Param("start")Integer start,@Param("length")Integer length,
			                     @Param("ksbh")Integer ksbh,@Param("ksmc")Integer ksmc);
	
	public void delete(@Param("ksbh")int ksbh);
	
	public void save(Ks ks);
	
	public Ks findOne(@Param("ksbh")int ksbh);
	
	public void update(Ks ks);
	
}
