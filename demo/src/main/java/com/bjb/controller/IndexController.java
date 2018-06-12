package com.bjb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html")
public class IndexController {

	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
}
