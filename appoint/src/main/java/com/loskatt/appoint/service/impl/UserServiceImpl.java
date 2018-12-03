package com.loskatt.appoint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.common.StatusCode;
import com.loskatt.appoint.mapper.UserMapper;
import com.loskatt.appoint.model.User;
import com.loskatt.appoint.service.UserService;
import com.loskatt.appoint.util.Tools;
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

}
