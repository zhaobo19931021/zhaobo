package com.zb20180409.sygl.action;
//用来转发页面

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DispatcherAction {
	@RequestMapping("/toMain.do")
	public ModelAndView toMain() {
		return new ModelAndView("main.html");
	}
	@RequestMapping("/menu.do")
	public ModelAndView toMenu() {
		return new ModelAndView("menu.json");
	}
	@RequestMapping("/toGys.do")
	public ModelAndView toGys() {
		return new ModelAndView("gys.html");
	}
	@RequestMapping("/toKf.do")
	public ModelAndView toKf() {
		return new ModelAndView("kf.html");
	}
	@RequestMapping("/toKs.do")
	public ModelAndView toKs() {
		return new ModelAndView("ks.html");
	}
	@RequestMapping("/toSp.do")
	public ModelAndView toSp() {
		return new ModelAndView("sp.html");
	}
	@RequestMapping("/toJhd.do")
	public ModelAndView toJhd() {
		return new ModelAndView("jhd.html");
	}
}






