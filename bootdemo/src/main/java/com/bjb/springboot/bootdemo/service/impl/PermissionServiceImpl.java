package com.bjb.springboot.bootdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjb.springboot.bootdemo.dao.PermissionDao;
import com.bjb.springboot.bootdemo.pojo.Permission;
import com.bjb.springboot.bootdemo.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;
	
	public List<Permission> selectPermissionsByRole(int rid) {
		
		return permissionDao.selectPermissionByRole(rid);
	}

}
