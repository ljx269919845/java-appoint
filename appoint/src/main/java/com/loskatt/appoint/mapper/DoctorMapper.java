package com.loskatt.appoint.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.loskatt.appoint.model.Doctor;
import com.loskatt.appoint.vo.DoctorSearch;

@Mapper
public interface DoctorMapper {
	
	Doctor select(@Param("id") long id);

    int update(Doctor doctor);

    int insert(Doctor doctor);

    int delete(Long id);
    
    int updateStatus(@Param("id") Long id,@Param("status") Integer status);
    
    List<Doctor> getDoctorList(@Param("doctorSearch") DoctorSearch doctorSearch);

}
