package com.zb20180409.sygl.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IKcDao {
	
	public int findKcBySpAndKf(@Param("spbh")int spbh,@Param("kfbh")int kfbh);
	
	public void saveKc(@Param("kfbh")int kcbh,@Param("spbh")int spbh,@Param("sl")int sl);
	
	public void updateKc(@Param("kfbh")int kcbh,@Param("spbh")int spbh,@Param("sl")int sl);
}
