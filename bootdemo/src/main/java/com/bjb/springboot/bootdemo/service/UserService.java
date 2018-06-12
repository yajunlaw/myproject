package com.bjb.springboot.bootdemo.service;

import com.bjb.springboot.bootdemo.pojo.User;

public interface UserService {

	public User selectUserByPass(String username,String password);
}
