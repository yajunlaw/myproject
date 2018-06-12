package com.bjb.springboot.bootdemo.pojo;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = -6270705218198663886L;

	/**
     * 角色唯一标识符
     */
    private Integer rId;
 
    /**
     * 角色名称
     */
    private String rName;
 
    /**
     * 角色别名
     */
    private String rAlias;
 
    public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getrAlias() {
		return rAlias;
	}

	public void setrAlias(String rAlias) {
		this.rAlias = rAlias;
	}
}
