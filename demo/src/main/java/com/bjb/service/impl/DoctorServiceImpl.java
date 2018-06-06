package com.bjb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bjb.dao.DoctorDao;
import com.bjb.pojo.Doctor;
import com.bjb.service.DoctorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	public PageInfo<Doctor> findAllDoctor(int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<Doctor> doctors = doctorDao.selectDoctors();
		
		PageInfo<Doctor> info = new PageInfo<Doctor>(doctors);
		
		return info;
	}

	public int updateDoctorById(int id) {
		
		return doctorDao.updateDoctor(id);
	}

}
