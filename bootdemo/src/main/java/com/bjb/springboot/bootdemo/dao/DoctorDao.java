package com.bjb.springboot.bootdemo.dao;

import java.util.List;

import com.bjb.springboot.bootdemo.pojo.Doctor;

public interface DoctorDao {

	public List<Doctor> selectDoctors();
	public int updateDoctor(int id);
}
