package com.bjb.springboot.bootdemo.pojo;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -6329504651244644453L;

	/**
     * 用户ID
     */
    private Integer id;
 
    /**
     * 用户名
     */
    private String username;
 
    /**
     * 邮箱
     */
    private String email;
 
    /**
     * 手机号
     */
    private String phone;
 
    /**
     * 密码
     */
    private String password;
    
    /**
     * 角色
     */
    private int r_id;
 
    /**
     * 状态：1-正常，0-封禁
     */
    private Integer status;
 
    /**
     * 头像
     */
    private String avatar;
 
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
