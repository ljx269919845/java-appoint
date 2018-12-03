package com.loskatt.appoint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.common.StatusCode;
import com.loskatt.appoint.mapper.DoctorMapper;
import com.loskatt.appoint.model.Doctor;
import com.loskatt.appoint.service.DoctorService;
import com.loskatt.appoint.vo.DoctorSearch;

@Service
public class DoctorServiceImpl implements DoctorService{

	
	@Autowired
	private DoctorMapper doctorMapper;
	
	@Override
	public Result addDoctor(Doctor doctor) {
		if (doctorMapper.insert(doctor)>0)
		return new Result<Integer>(StatusCode.RESULT_SUCCESS);
		else
	    return new Result<String>(StatusCode.DOCTOR_ADD_FAIL);	
	}

	@Override
	public Result updateDoctor(Doctor doctor) {
		if (doctorMapper.update(doctor)>0)
		return new Result<Integer>(StatusCode.RESULT_SUCCESS);
		else
	    return new Result<String>(StatusCode.DOCTOR_UPDATE_FAIL);	
	}

	@Override
	public Result findById(Long id) {
		return new Result<Doctor>(StatusCode.RESULT_SUCCESS,doctorMapper.select(id));
	}

	@Override
	public Result updateStatus(Long id, Integer status) {
		if (doctorMapper.updateStatus(id,status)>0)
		return new Result<Integer>(StatusCode.RESULT_SUCCESS);
		else
	    return new Result<String>(StatusCode.DOCTOR_UPDATE_FAIL);	
	}

	@Override
	public Result deleteById(Long id) {
		return new Result<Integer>(StatusCode.RESULT_SUCCESS,doctorMapper.delete(id));
	}

	@Override
	public Result getDoctorList(DoctorSearch doctorSearch) {
		return new Result<List<Doctor>>(StatusCode.RESULT_SUCCESS,doctorMapper.getDoctorList(doctorSearch));
	}

}
