package com.zb20180409.sygl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zb20180409.sygl.domain.Gys;

@Repository
public interface IGysDao {
	
	public int total(@Param("gysbh")Integer gysbh,@Param("gysmc")String gysmc);
	
	public List<Gys> findGysByPage(@Param("start")Integer start,@Param("length")Integer length,
			                       @Param("gysbh")Integer gysbh,@Param("gysmc")String gysmc);
	
	public void delete(@Param("gysbh")int gysbh);
	
	public void save(Gys gys);
	
	public Gys findOne(@Param("gysbh")int gysbh);
	
	public void update(Gys gys);
}
