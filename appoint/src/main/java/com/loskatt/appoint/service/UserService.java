package com.loskatt.appoint.service;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.model.Appoint;
import com.loskatt.appoint.model.User;
import com.loskatt.appoint.vo.AppointSearch;

public interface UserService {
	
	public Result addUser(User user);
	
	public Result updateUser(User user);
	
	public Result findByOpenId(String openId);

	public Result getUserList(AppointSearch appointSearch);
}
