package com.bjb.springboot.bootdemo.pojo;

import java.io.Serializable;

public class Permission implements Serializable {

	private static final long serialVersionUID = 1208154545770670443L;

	/**
     * 权限唯一标识ID
     */
    private Integer pId;
 
    /**
     * 权限名称
     */
    private String pName;
 
    /**
     * 权限别名
     */
    private String pAlias;

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpAlias() {
		return pAlias;
	}

	public void setpAlias(String pAlias) {
		this.pAlias = pAlias;
	}
 
   
}
