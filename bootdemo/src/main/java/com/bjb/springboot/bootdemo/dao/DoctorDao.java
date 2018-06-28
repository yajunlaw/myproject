package com.bjb.springboot.bootdemo.dao;

import java.util.List;

import org.springframework.cache.annotation.CachePut;
import com.bjb.springboot.bootdemo.pojo.Doctor;

public interface DoctorDao {

	public List<Doctor> selectDoctors();
	
	@CachePut(key = "#p0.id")
	public int updateDoctor(int id);
	
	@CachePut(key = "#p0.id")
	public int saveDoctor(Doctor doctor);
}
