package com.bjb.springboot.bootdemo.service;

import com.bjb.springboot.bootdemo.pojo.Doctor;
import com.github.pagehelper.PageInfo;

public interface DoctorService {

	public PageInfo<Doctor> findAllDoctor(int pageNum,int pageSize);
	
	public int updateDoctorById(int id);
}
