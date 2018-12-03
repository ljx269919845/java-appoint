package com.loskatt.appoint.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.loskatt.appoint.mapper.AppointSetMapper;

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
	 *  每天晚上23点重置放号量
	 */
	@Scheduled(cron="0 0 23 * * ?")
    public void clearSurplus () {
		appointsetMapper.clearSurplus();
    }   
}
