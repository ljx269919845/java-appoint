package com.loskatt.appoint.vo;

import java.util.List;

import com.loskatt.appoint.common.BaseObject;
import com.loskatt.appoint.model.AppointSet;

public class DepartAppointSetVO extends BaseObject {
	
	private Integer balanceNum;//总余号量
	private String timeFrame;//时间段
	private Long departId;//科室ID
	private List<AppointSet> settingList;//设置记录
	
	public List<AppointSet> getSettingList() {
		return settingList;
	}
	public void setSettingList(List<AppointSet> settingList) {
		this.settingList = settingList;
	}
	public Integer getBalanceNum() {
		return balanceNum;
	}
	public void setBalanceNum(Integer balanceNum) {
		this.balanceNum = balanceNum;
	}
	public String getTimeFrame() {
		return timeFrame;
	}
	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}
	public Long getDepartId() {
		return departId;
	}
	public void setDepartId(Long departId) {
		this.departId = departId;
	}
}
