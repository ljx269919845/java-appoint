package com.loskatt.appoint.service;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.model.Doctor;
import com.loskatt.appoint.vo.DoctorSearch;

public interface DoctorService {
	
	public Result addDoctor(Doctor doctor);
	    
    public Result updateDoctor(Doctor doctor);
    
    public Result findById(Long id);
    
    public Result updateStatus(Long id,Integer status);
    
    public Result deleteById(Long id);
    
    public Result getDoctorList(DoctorSearch doctorSearch);

}
