package com.zb20180409.sygl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zb20180409.sygl.domain.Jhd;
@Repository
public interface IJhdDao {
	
	public int total();
	
	public List<Jhd> findJhdAll(@Param("start")int start , @Param("length")int length);
	
	public String findJhdbh(@Param("jhdbhPrefix")String jhdbhPrefix);
	
	public void save(Jhd jhd);
	
	public void saveXq(@Param("jhdbh")String jhdbh,@Param("spbh")int spbh,@Param("sl")int sl,@Param("dj")int dj);
}
