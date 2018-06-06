package com.bjb.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bjb.dao.DoctorDao;
import com.bjb.pojo.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Doctor> selectDoctors() {
		
		return sqlSessionTemplate.selectList("com.bjb.dao.selectDoctors");
	}

	public int updateDoctor(int id) {
		return sqlSessionTemplate.update("com.bjb.dao.updateDoctor", id);
	}

}
