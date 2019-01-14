package com.loskatt.appoint.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import antlr.collections.List;

import com.loskatt.appoint.mapper.AppointSetMapper;
import com.loskatt.appoint.vo.AppointSearch;
import com.loskatt.appoint.vo.AppointSetVO;

/**
 * @author loskatt
 *
 */
@Component
@EnableScheduling
public class ScheduleUtil {
	
	@Autowired
	private AppointSetMapper appointsetMapper;
	
	/**
	 *  每天17点重置放号量,并设置日期
	 */
	@Scheduled(cron="0 0 0 * * ?")
    public void clearSurplus () {
		AppointSearch appointSearch = new AppointSearch();
		appointSearch.setStatus(1);
		appointSearch.setPageIndex(1);
		appointSearch.setPageSize(2);
		java.util.List<AppointSetVO> appointSetList = appointsetMapper.getAppointSetList(appointSearch);
		if(appointSetList.isEmpty()){
			return;
		}
		AppointSetVO appointSetVO = appointSetList.get(0);
		String now = Tools.getyyyyMMddTime(new Date());
		if(appointSetVO.getDateFrame() == null || !appointSetVO.getDateFrame().equals(now)){
			appointsetMapper.updateSettingAppointDate(now);
		}
		appointsetMapper.clearSurplus(Tools.getyyyyMMddTime(Tools.dateAdd(new Date(), 1)),Tools.getyyyyMMddTime(new Date()));
    }   
}
