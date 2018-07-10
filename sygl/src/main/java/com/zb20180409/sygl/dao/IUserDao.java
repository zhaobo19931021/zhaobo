package com.zb20180409.sygl.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zb20180409.sygl.domain.User;

@Repository //实现ioc
public interface IUserDao {
	//根据业务的要求编写相应方法
	//因为执行传参数时，需要将多个参数组合形成一个对象或者MAP 故添加标签@param
	public User findUserByNameAndPass(@Param("uname")String uname,@Param("upass")String upass);
}
