package com.bjb.service;

import com.bjb.pojo.Doctor;
import com.github.pagehelper.PageInfo;

public interface DoctorService {

	public PageInfo<Doctor> findAllDoctor(int pageNum,int pageSize);
	
	public int updateDoctorById(int id);
}
