package com.bjb.dao;

import java.util.List;

import com.bjb.pojo.Doctor;

public interface DoctorDao {

	public List<Doctor> selectDoctors();
	public int updateDoctor(int id);
}
