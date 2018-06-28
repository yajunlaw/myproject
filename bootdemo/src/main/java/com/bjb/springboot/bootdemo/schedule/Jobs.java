package com.bjb.springboot.bootdemo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bjb.springboot.bootdemo.service.MailService;

@Component
public class Jobs {

	public final static long ONE_MINUTE = 60*1000;
	
	@Autowired
	private MailService mailService;
	
//	@Autowired
//	private DoctorService doctorService;
	
//	@Scheduled(fixedDelay=ONE_MINUTE)
//	public void fixDelayJob() {
//		PageInfo<Doctor> all = doctorService.findAllDoctor(1, 10);
//		
//		for (int i = 0; i < all.getList().size(); i++) {
//			System.out.println("delay: " + all.getList().get(i).getDoctorName());
//		}
//		
//	}
//	
//	@Scheduled(fixedRate=ONE_MINUTE)
//	public void fixRateJob() {
//		PageInfo<Doctor> all = doctorService.findAllDoctor(1, 10);
//		
//		for (int i = 0; i < all.getList().size(); i++) {
//			System.out.println("rate: " + all.getList().get(i).getDoctorName());
//		}
//	}
	
	@Scheduled(cron="0 24 11 * * ?")
	public void cronJob() {
		
		
		String to = "yajunlaw@163.com";
		String subject = "测试邮件";
		String content = "刘雅军  先生：<br />\r\n" + 
				"	&nbsp;&nbsp;&nbsp;&nbsp;你好，正式通知你被&nbsp;&nbsp;兰州交通大学&nbsp;&nbsp;的&nbsp;&nbsp;电子与信息技术学院&nbsp;&nbsp;的&nbsp;&nbsp;计算机科学与技术专业&nbsp;&nbsp;录取，请于&nbsp;&nbsp;2008年09月01号到学校报道\r\n" + 
				"\r\n" + 
				"	<div style=\"align:right;width:20%;float:right\">兰州交通大学招生处<br />2008年08月23号</div>";
		
		mailService.sendHtmlMail(to, subject, content);
	}
}
