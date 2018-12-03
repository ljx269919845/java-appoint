package com.loskatt.appoint.service;

import org.springframework.web.multipart.MultipartFile;

import com.loskatt.appoint.common.Result;

public interface FileObjService {
	
	Result selectByFileId(Long fileId);
	
	Result upload(MultipartFile file);

}
