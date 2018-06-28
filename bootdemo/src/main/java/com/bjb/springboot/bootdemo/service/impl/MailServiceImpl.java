package com.bjb.springboot.bootdemo.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bjb.springboot.bootdemo.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	private static Logger logger = LogManager.getLogger(MailServiceImpl.class);
	
	@Autowired
	public JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	public String from;
	
	public void sendSimpleMail(String to, String subject, String content) {
	
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		
		try {
			sender.send(message);
			logger.info("邮件发送成功");
		} catch (MailException e) {
			logger.error("邮件发送遇到问题："+e.getMessage());
		}
	}

	
	public void sendHtmlMail(String to, String subject, String content) {
		
		MimeMessage message = sender.createMimeMessage();
		
		try {			
			message.setFrom(from);
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setContent(content,"text/html;charset=utf-8");
			sender.send(message);
			logger.info("邮件发送成功");
			
		} catch (MessagingException e) {
			logger.error("邮件发送遇到问题："+e.getMessage());
		}
	}

}
