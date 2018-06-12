package com.bjb.springboot.bootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjb.springboot.bootdemo.pojo.Doctor;
import com.bjb.springboot.bootdemo.service.DoctorService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping("/all")
	@ResponseBody
	public ModelAndView findAllDoctors(
			@RequestParam(name="pageNum",required=false,defaultValue="1")
			int pageNum,
			@RequestParam(name="pageSize",required=false,defaultValue="5")
			int pageSize
			) {
		
		PageInfo<Doctor> all = doctorService.findAllDoctor(pageNum, pageSize);
		
		ModelAndView mv = new ModelAndView("doctors");
		
		mv.addObject("all",all);
		
		return mv;
	}
	
	@RequestMapping("/modify")
	@ResponseBody
	public ModelAndView modify(
			@RequestParam(name="id",required=true)
			int id
			) {
		
		doctorService.updateDoctorById(id);
		
		ModelAndView mv = new ModelAndView("redirect:/doctor/all");
		
		return mv;
	}
}
