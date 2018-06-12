package com.bjb.springboot.bootdemo.dao;

import com.bjb.springboot.bootdemo.pojo.Role;

public interface RoleDao {

	public Role selectRoleByUser(String username);
}
