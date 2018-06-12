package com.bjb.springboot.bootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjb.springboot.bootdemo.dao.UserDao;
import com.bjb.springboot.bootdemo.pojo.User;
import com.bjb.springboot.bootdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User selectUserByPass(String username, String password) {
		
		return userDao.selectUserByPass(username, password);
	}

}
