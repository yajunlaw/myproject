package com.bjb.springboot.bootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjb.springboot.bootdemo.dao.RoleDao;
import com.bjb.springboot.bootdemo.pojo.Role;
import com.bjb.springboot.bootdemo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public Role selectRoleByUser(String username) {
		
		return roleDao.selectRoleByUser(username);
	}

}
