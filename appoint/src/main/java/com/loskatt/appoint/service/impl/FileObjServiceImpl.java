package com.loskatt.appoint.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.loskatt.appoint.common.GlobalException;
import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.common.StatusCode;
import com.loskatt.appoint.mapper.FileObjMapper;
import com.loskatt.appoint.model.FileObj;
import com.loskatt.appoint.service.FileObjService;
@Service
public class FileObjServiceImpl implements FileObjService{
	
	@Autowired
	private FileObjMapper fileObjMapper;
	
	@Value("${server.gateway}")
	private String gateway;
	
	@Value("${server.filepath}")
	private String filePath;
	
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	@Override
	public Result selectByFileId(Long fileId) {
		return new Result<FileObj>(StatusCode.RESULT_SUCCESS,fileObjMapper.selectById(fileId));
	}
	@Override
	public Result upload(MultipartFile file) {
		 //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        //上传文件名
        String filename = UUID.randomUUID() +"." +suffix;
        //服务器端保存的文件对象
        Calendar calendar = Calendar.getInstance();
        String pattern = DateFormatUtils.format(calendar, "/yyyy/MM/dd/");
        File dir = new File(filePath+pattern);
        if(!dir.getParentFile().exists()) {
        	dir.mkdirs();
        }
        //将上传的文件写入到服务器端文件内
        File serverFile = new File(dir.getPath()+"/"+ filename);
        try {
			file.transferTo(serverFile);
		} catch (IllegalStateException | IOException e) {
			throw new GlobalException(StatusCode.FILE_UPLOAD_FAIL);
		}
        FileObj fileObj = new FileObj();
        fileObj.setFileName(filename);
        fileObj.setFormat(suffix);
        fileObj.setFilePath(serverFile.getPath());
        fileObj.setFileUrl(gateway+pattern+filename);
        fileObj.setFileSize(serverFile.length());
        fileObjMapper.insert(fileObj);
        //保存文件到本地库
        return new Result<String>(StatusCode.RESULT_SUCCESS,fileObj.getFileUrl());
	}

}
