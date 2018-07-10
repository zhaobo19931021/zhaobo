package com.zb20180409.sygl.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zb20180409.sygl.domain.User;
import com.zb20180409.sygl.service.IUserService;

@RestController
public class UserAction {
	@Autowired
	private IUserService service;
	@RequestMapping("/login.do")
	public String login(String uname,String upass,HttpSession session) { 
		User user = service.findUserForLogin(uname, upass);
		if(user==null) {
			return "fail";
		}else {
			session.setAttribute("loginUser", user);
			return "ok";
		}
	}
}
