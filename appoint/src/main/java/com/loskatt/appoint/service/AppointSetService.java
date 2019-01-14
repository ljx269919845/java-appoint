package com.loskatt.appoint.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.model.AppointSet;
import com.loskatt.appoint.vo.AppointSearch;

public interface AppointSetService {
	
	public Result loadSettingForDepart(Long departId,String dateFrame);
	
	public Result loadSettingForDoctor(Long doctorId,String dateFrame);
	
	public Result addSetting(AppointSet appointSet);
	
	public Result updateSetting(AppointSet appointSet);
	
	public Result deleteSetting(Long settingId);
	
	public Result getAppointSetList(AppointSearch appointSearch);
	
	public Result updateStatus(Long id,Integer status);
}
