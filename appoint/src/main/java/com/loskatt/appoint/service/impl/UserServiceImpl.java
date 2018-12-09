package com.loskatt.appoint.service.impl;

import com.loskatt.appoint.vo.AppointSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.common.StatusCode;
import com.loskatt.appoint.mapper.UserMapper;
import com.loskatt.appoint.model.User;
import com.loskatt.appoint.service.UserService;
import com.loskatt.appoint.util.Tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public Result addUser(User user) {
		User userdb = userMapper.selectByPhone(user.getUserPhone());
		if(userdb!=null) {
			return new Result<String>(StatusCode.USER_PHONE_IS_EXIST);	
		}
		try {
			int age = Tools.getAge(Tools.parse(user.getUserDay()));
			user.setUserAge(age);
		} catch (Exception e) {
			return new Result<Integer>(StatusCode.USER_BIRTHDAY_IS_ERROR);
		}
		if (userMapper.insert(user)>0)
		return new Result<Integer>(StatusCode.RESULT_SUCCESS);
		else
	    return new Result<String>(StatusCode.USER_ADD_FAIL);	
	}

	@Override
	public Result updateUser(User user) {
		try {
			int age = Tools.getAge(Tools.parse(user.getUserDay()));
			user.setUserAge(age);
		} catch (Exception e) {
			return new Result<Integer>(StatusCode.USER_BIRTHDAY_IS_ERROR);
		}
	    if (userMapper.update(user)>0)
		return new Result<Integer>(StatusCode.RESULT_SUCCESS);
		else
	    return new Result<String>(StatusCode.USER_UPDATE_FAIL);	
	}

	@Override
	public Result findByOpenId(String openId) {
		return new Result<User>(StatusCode.RESULT_SUCCESS,userMapper.selectByOpenId(openId));
	}

	@Override
	public Result getUserList(AppointSearch appointSearch){
		int  count = userMapper.getUserListCount(appointSearch);
		List<User> users = userMapper.getUserList(appointSearch);
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("count", count);
		dataMap.put("users", users);
		return new Result(StatusCode.RESULT_SUCCESS, dataMap);
	}
}
