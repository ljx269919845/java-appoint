package com.loskatt.appoint.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.loskatt.appoint.common.GlobalException;
import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.common.StatusCode;
import com.loskatt.appoint.mapper.AppointMapper;
import com.loskatt.appoint.mapper.AppointSetMapper;
import com.loskatt.appoint.mapper.UserMapper;
import com.loskatt.appoint.model.Appoint;
import com.loskatt.appoint.model.AppointSet;
import com.loskatt.appoint.model.User;
import com.loskatt.appoint.service.AppointService;
import com.loskatt.appoint.util.Tools;
import com.loskatt.appoint.vo.AppointSearch;
import com.loskatt.appoint.vo.AppointVO;
@Service
public class AppointServiceImpl implements AppointService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppointServiceImpl.class);
	
	@Autowired
	private AppointMapper appointMapper;
	
	@Autowired
	private AppointSetMapper appointsetMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Value("${appoint.hour}")
	private Integer appointHour;

	/**
	 *  1.查询预约设置，锁行
	 *  2.判断是否有该预约设置
	 *  3.判断是否有余号
	 *  4.余号减一并更新
	 */
	@Override
	@Transactional(rollbackOn=Exception.class)
	public Result appoint(Long settingId,Appoint appoint,String dateFrame) {
		long time = System.currentTimeMillis();
		LOGGER.info("[lock] start. time: {}", time);
		User user = userMapper.select(appoint.getUserId());
		if(user==null) {
			throw new GlobalException(StatusCode.USER_IS_NOT_EXIST);
		}
		if(StringUtils.isEmpty(user.getUserName())||StringUtils.isEmpty(user.getUserPhone())) {
			throw new GlobalException(StatusCode.USER_NOT_REGISTER);
		}
		AppointSet appointSet = appointsetMapper.selectSettingForUpdate(settingId);
		if(appointSet == null) {
			LOGGER.info("appoint setting is null .");
			throw new GlobalException(StatusCode.APPOINT_SET_NOT_EXIST);
		}
		//判断预约设置余号量是否大于零
		if(appointSet.getSurplusNum().equals(0)) {
			throw new GlobalException(StatusCode.APPOINT_SURPLUS_NUM_NOT_ENOUGH);
		}
		//判断预约设置是否可用
		if(appointSet.getStatus().equals(0)) {
			throw new GlobalException(StatusCode.APPOINT_SET_NOT_EXIST);
		}
		//判断是否超过可预约的时间范围:比如过了17点不能预约当天的号，只能预约明天的号
		// Date pdate = Tools.ExcepDate(dateFrame,appointHour,0,0);
		// if(pdate==null||pdate.compareTo(new Date())<0) {
		// 	throw new GlobalException(StatusCode.APPOINT_TIME_FRAME_NOT);
		// }
		
		if(appointSet.getStatus().equals(0)) {
			throw new GlobalException(StatusCode.APPOINT_SET_NOT_EXIST);
		}
		//余号量减一
		appointSet.setSurplusNum(appointSet.getSurplusNum()-1);
		if(appointsetMapper.updateSurplusNum(appointSet)<=0) {
			throw new GlobalException(StatusCode.APPOINT_ADD_FAIL);
		}
		long timeEnd = System.currentTimeMillis();
        LOGGER.info("[lock] end. time: {}", timeEnd);
		//当天同一科室同一医生不能重复预约,除非已经销号(才能重新预约)
		int appointNum = appointMapper.checkAppointByCondition(appoint);
		if(appointNum>0) {
			throw new GlobalException(StatusCode.APPOINT_IS_EXIST);	
		}
	    if (appointMapper.appoint(appoint)>0)
		return new Result<Long>(StatusCode.RESULT_SUCCESS,appoint.getId());
		else
		throw new GlobalException(StatusCode.APPOINT_ADD_FAIL);
	}

	@Override
	public Result selectAppointInfo(Long appointId) {
		return new Result<AppointVO>(StatusCode.RESULT_SUCCESS,appointMapper.selectAppointInfo(appointId));
	}

	@Override
	public Result updateStatus(Long id, Integer status) {
		if (appointMapper.updateStatus(id,status)>0){
			if(status.equals(0) || status.equals(2)){
				AppointVO appoint = appointMapper.selectAppointInfo(id);
				AppointSet appointSet = appointsetMapper.selectSetting(appoint.getDoctor().getId(), appoint.getAppointDate(),appoint.getAppointTime());
				if(appointSet != null && appointSet.getSurplusNum() + 1 > appointSet.getUserNum()){
					appointSet.setSurplusNum(appointSet.getUserNum());
				}else if(appointSet != null){
					appointSet.setSurplusNum(appointSet.getSurplusNum() + 1);
				}
				appointsetMapper.updateSurplusNum(appointSet);
			}
			return new Result<Integer>(StatusCode.RESULT_SUCCESS);
		} else {
			return new Result<String>(StatusCode.APPOINT_UPDATE_FAIL);
		}
	}

	@Override
	public Result getAppointList(AppointSearch appointSearch) {
		List<AppointVO> data = appointMapper.getAppointList(appointSearch);
		return new Result(StatusCode.RESULT_SUCCESS, data);
	}

	public Result getAppointListCount(AppointSearch appointSearch){
		int count = appointMapper.getAppointListCount(appointSearch);
		List<AppointVO> data = appointMapper.getAppointList(appointSearch);
		Map<String, Object> resultData = new HashMap();
		resultData.put("count", count);
		resultData.put("appoint", data);
		return new Result(StatusCode.RESULT_SUCCESS, resultData);
	}

}
