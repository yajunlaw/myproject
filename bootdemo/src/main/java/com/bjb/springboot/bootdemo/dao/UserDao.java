package com.bjb.springboot.bootdemo.dao;

import org.apache.ibatis.annotations.Param;

import com.bjb.springboot.bootdemo.pojo.User;

public interface UserDao {

	public User selectUserByPass(@Param("username")String username,@Param("password")String password);
}
