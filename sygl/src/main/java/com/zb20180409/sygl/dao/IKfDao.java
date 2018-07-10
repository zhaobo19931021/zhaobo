package com.zb20180409.sygl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zb20180409.sygl.domain.Kf;

@Repository
public interface IKfDao {

	public int total(@Param("kfbh")Integer kfbh,@Param("kfmc")String kfmc);
	
	public List<Kf> findKfByPage(@Param("start")Integer start,@Param("length")Integer length,
			                     @Param("kfbh")Integer kfbh,@Param("kfmc")String kfmc);
	
	public void delete(int kfbh);
	
	public void save(Kf kf);
	
	public Kf findOne(@Param("kfbh")int kfbh);
	
	public void update(Kf kf);
}
