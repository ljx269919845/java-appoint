package com.loskatt.appoint.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.common.StatusCode;
import com.loskatt.appoint.mapper.AppointSetMapper;
import com.loskatt.appoint.model.AppointSet;
import com.loskatt.appoint.service.AppointSetService;
import com.loskatt.appoint.util.Tools;
import com.loskatt.appoint.vo.AppointSearch;
import com.loskatt.appoint.vo.AppointSetVO;
import com.loskatt.appoint.vo.AppointVO;
import com.loskatt.appoint.vo.DepartAppointSetVO;
@Service
public class AppointSetServiceImpl implements AppointSetService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppointSetServiceImpl.class);
	
	@Autowired
	private AppointSetMapper appointsetMapper;

	@Override
	public Result loadSettingForDepart(Long departId) {
		Map<String,Object> result = new HashMap<String,Object>();
		AppointSearch appointSearch = new AppointSearch();
		appointSearch.setDepartId(departId);
		appointSearch.setAppointDate(Tools.getDateToStr(Tools.dateAdd(new Date(), 1),"yyyy-MM-dd"));
		List<AppointSet> settingList = appointsetMapper.loadSettingForDepart(departId);
		List<DepartAppointSetVO> appointSetVOLst = new ArrayList<DepartAppointSetVO>();
		int appointNum = 0;
		if(settingList!=null && settingList.size()>0) {
			//根据科室ID获取当前科室的预约设置按<时间段>分组
			Map<String, List<AppointSet>> appointSetMap = settingList.stream().collect(Collectors.groupingBy(AppointSet::getTimeFrame));
			appointSetMap.forEach((k,v)->{
				     DepartAppointSetVO vo = new DepartAppointSetVO();
				      //对每个分组的List<AppointSet>累计余号量
				      vo.setBalanceNum(v.stream().filter(obj ->obj.getSurplusNum()!=null).mapToInt(obj -> obj.getSurplusNum().intValue()).sum());
				      vo.setSettingList(v);
				      vo.setTimeFrame(k);
				      vo.setDepartId(departId);
				      appointSetVOLst.add(vo);
				});
			
		}
		//当前科室已经预约总数
	    result.put("appointNum", appointsetMapper.countAppoints(appointSearch));
	    //当前科室按时间段分组的预约配置记录
		result.put("appointSetList", appointSetVOLst);
		return new Result<Map<String,Object>>(StatusCode.RESULT_SUCCESS,result);
	}

	@Override
	public Result loadSettingForDoctor(Long doctorId) {
		Map<String,Object> result = new HashMap<String,Object>();
		AppointSearch appointSearch = new AppointSearch();
		appointSearch.setDoctorId(doctorId);
		appointSearch.setAppointDate(Tools.getDateToStr(Tools.dateAdd(new Date(), 1),"yyyy-MM-dd"));
		List<AppointSet> settingList = appointsetMapper.loadSettingForDoctor(doctorId);
		//当前医生第二天所有预约配置记录
		result.put("appointSetList", settingList);
		//当前医生第二天已经预约总数
		result.put("appointNum", appointsetMapper.countAppoints(appointSearch));
		return new Result<Map<String,Object>>(StatusCode.RESULT_SUCCESS,result);
	}

	@Override
	public Result addSetting(AppointSet appointSet) {
		if (appointsetMapper.insertSetting(appointSet)>0)
		return new Result<Integer>(StatusCode.RESULT_SUCCESS);
		else
	    return new Result<String>(StatusCode.APPOINT_SET_ADD_FAIL);	
	}

	@Override
	public Result updateSetting(AppointSet appointSet) {
		if (appointsetMapper.updateSetting(appointSet)>0)
		return new Result<Integer>(StatusCode.RESULT_SUCCESS);
		else
	    return new Result<String>(StatusCode.APPOINT_SET_UPDATE_FAIL);
	}

	@Override
	public Result deleteSetting(Long settingId) {
		return new Result<Integer>(StatusCode.RESULT_SUCCESS,appointsetMapper.deleteSetting(settingId));
	}

	@Override
	public Result getAppointSetList(AppointSearch appointSearch) {
		return new Result<List<AppointSetVO>>(StatusCode.RESULT_SUCCESS,appointsetMapper.getAppointSetList(appointSearch));
	}

	@Override
	public Result updateStatus(Long id, Integer status) {
		if (appointsetMapper.updateStatus(id,status)>0)
		return new Result<Integer>(StatusCode.RESULT_SUCCESS);
		else
	    return new Result<String>(StatusCode.APPOINT_SET_UPDATE_FAIL);	
	}

}
