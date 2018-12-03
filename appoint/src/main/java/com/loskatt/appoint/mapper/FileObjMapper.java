package com.loskatt.appoint.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.loskatt.appoint.model.FileObj;

@Mapper
public interface FileObjMapper {
	
	    FileObj selectById(Long id);

	    int insert(FileObj fileObj);
}
