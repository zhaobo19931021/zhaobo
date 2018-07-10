package com.zb20180409.sygl.action;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zb20180409.sygl.domain.Jhd;
import com.zb20180409.sygl.domain.PageInfo;
import com.zb20180409.sygl.service.IJhdService;

@RestController
public class JhdAction {
	@Autowired
	private IJhdService service ;
	
	@RequestMapping("/jhd.do")
	public PageInfo jhd(int page,int rows) {
		List<Jhd> list  = service.findJhdAll(page, rows);
		int total = service.total();
		
		return new PageInfo(total,list) ;
	}
	
	@RequestMapping("/jhsj.do")
	public String jhsj() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return f.format(LocalDateTime.now()) ;
	}
	@RequestMapping("/jhdbh.do")
	public String jhdbh(HttpServletRequest request) {
		
		ServletContext application = request.getServletContext();
		
		String jhdbh = "";
		
		synchronized ("zhaobo") {
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyyMMdd");
			String jhdbhPrefix = "JHD"+f.format(LocalDate.now());
			
			String oldJhdbh = (String) application.getAttribute("jhdbh");
			if(oldJhdbh==null || !oldJhdbh.startsWith(jhdbhPrefix)) {
				 oldJhdbh = service.findJhdbh(jhdbhPrefix);
			}
			if(oldJhdbh==null || oldJhdbh.equals("")) {
				jhdbh = jhdbhPrefix+"0001";
			}else {
				String xhStr = oldJhdbh.replaceAll(jhdbhPrefix, "");	
				int xh = Integer.parseInt(xhStr)+1;
				xhStr = xh +"";
				switch (xhStr.length()) {
				case 1: xhStr = "000"+xhStr; break;
				case 2: xhStr = "00"+xhStr; break;
				case 3: xhStr = "0"+xhStr; break;	
				}
				jhdbh = jhdbhPrefix + xhStr ; 
			}
			application.setAttribute("jhdbh", jhdbh);
		}
		return jhdbh;
	}
	@RequestMapping("/jhdSave.do")
	public void save(Jhd jhd,String spbhs,String sls,String djs) {
		service.save(jhd, spbhs, sls, djs);
	}
}








