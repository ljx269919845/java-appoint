package com.loskatt.appoint.service;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.model.Appoint;
import com.loskatt.appoint.vo.AppointSearch;

public interface AppointService {
	
	public Result appoint(Long settingId,Appoint appoint);
	
	public Result selectAppointInfo(Long appointId);
	
	public Result updateStatus(Long id,Integer status);
	
	public Result getAppointList(AppointSearch appointSearch);
	
	public Result getAppointListCount(AppointSearch appointSearch);
	
}
