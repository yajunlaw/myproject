package com.bjb.springboot.bootdemo.dao;

import java.util.List;

import com.bjb.springboot.bootdemo.pojo.Permission;

public interface PermissionDao {

	public List<Permission> selectPermissionByRole(int rid);
}
