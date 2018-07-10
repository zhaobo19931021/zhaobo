package com.zb20180409.sygl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zb20180409.sygl.domain.Sp;

@Repository
public interface ISpDao {
	public int total(@Param("spbh")Integer spbh , @Param("spmc")String spmc) ;
	
	public List<Sp> findSpByPage(@Param("start")Integer start,@Param("length")Integer length,@Param("spbh")Integer spbh,@Param("spmc")String spmc);
	
	public void delete(@Param("spbh")int spbh) ;
	
	public void save(Sp sp) ;
	
	public Sp findOne(@Param("spbh")int spbh) ;
	
	public void update(Sp sp) ;
}

