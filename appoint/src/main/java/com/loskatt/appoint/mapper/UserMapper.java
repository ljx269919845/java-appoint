package com.loskatt.appoint.mapper;

import com.loskatt.appoint.vo.AppointSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.loskatt.appoint.model.Appoint;
import com.loskatt.appoint.model.User;
import com.loskatt.appoint.vo.AppointVO;

import java.util.List;

@Mapper
public interface UserMapper {
	
	    User select(@Param("id") Long id);
	    
	    User selectByOpenId(@Param("openId") String openId);
	    
	    User selectByPhone(@Param("userPhone") String userPhone);

	    int update(User user);

	    int insert(User user);

		List<User> getUserList(AppointSearch appointSearch);
		int getUserListCount(AppointSearch appointSearch);
}
