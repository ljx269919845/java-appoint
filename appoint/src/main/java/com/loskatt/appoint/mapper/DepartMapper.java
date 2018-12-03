package com.loskatt.appoint.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.loskatt.appoint.model.Depart;

@Mapper
public interface DepartMapper {
	
	    Depart select(@Param("id") long id);

	    int update(Depart depart);

	    int insert(Depart depart);

	    int delete(Long id);
	    
	    int updateStatus(@Param("id") Long id,@Param("status") Integer status);
	    
	    List<Depart> getDepartListByStatus(@Param("status") Integer status);

}
