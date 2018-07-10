package com.zb20180409.sygl.service;

import com.zb20180409.sygl.domain.User;

public interface IUserService {
	
	public User findUserForLogin(String uname,String upass);
}
