package com.bjb.springboot.bootdemo.service;

import com.bjb.springboot.bootdemo.pojo.Role;

public interface RoleService {

	public Role selectRoleByUser(String username);
}
