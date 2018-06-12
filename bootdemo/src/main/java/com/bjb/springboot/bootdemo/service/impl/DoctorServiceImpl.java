package com.bjb.springboot.bootdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjb.springboot.bootdemo.dao.DoctorDao;
import com.bjb.springboot.bootdemo.pojo.Doctor;
import com.bjb.springboot.bootdemo.service.DoctorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(value="doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	@Cacheable(cacheNames="doctor.all")
	public PageInfo<Doctor> findAllDoctor(int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<Doctor> doctors = doctorDao.selectDoctors();
		
		PageInfo<Doctor> info = new PageInfo<Doctor>(doctors);
		
		return info;
	}

	@Transactional
	public int updateDoctorById(int id) {
		
		return doctorDao.updateDoctor(id);
	}

}
