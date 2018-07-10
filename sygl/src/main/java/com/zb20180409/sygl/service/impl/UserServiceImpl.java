package com.zb20180409.sygl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zb20180409.sygl.dao.IUserDao;
import com.zb20180409.sygl.domain.User;
import com.zb20180409.sygl.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao dao;
	@Override
	public User findUserForLogin(String uname, String upass) {
		return dao.findUserByNameAndPass(uname, upass);
	}
	
	
}
