package com.bjb.springboot.bootdemo.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjb.springboot.bootdemo.pojo.User;

@Controller
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/to_login")
	public String to_login() {
		
		return "login";
	}
	
	@RequestMapping("login")
	public String login(String username,String password,HttpSession session) {
	
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		
		Subject subject= SecurityUtils.getSubject();
		
		try {
			subject.login(token);
			User user = (User)subject.getPrincipal();
			session.setAttribute("user", user);
			return "redirect:/doctor/all";
		} catch (Exception e) {
			logger.info(e.getMessage());
			return "login";
		}
	}
}
