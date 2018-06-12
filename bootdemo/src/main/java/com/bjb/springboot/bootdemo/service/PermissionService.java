package com.bjb.springboot.bootdemo.service;

import java.util.List;

import com.bjb.springboot.bootdemo.pojo.Permission;

public interface PermissionService {

	public List<Permission> selectPermissionsByRole(int rid);
}
