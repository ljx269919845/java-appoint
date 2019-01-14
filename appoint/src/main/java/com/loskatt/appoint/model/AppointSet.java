package com.loskatt.appoint.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class AppointSet{

	private Long id;
	@NotBlank
	@ApiModelProperty(value = "科室ID",example = "68",required = true)
	private Long departId;
	@NotBlank
	@ApiModelProperty(value = "医生ID",example = "68",required = true)
	private Long doctorId;
	@NotBlank
	@ApiModelProperty(value = "预约日期",example = "2018-12-12",required = true)
	private String dateFrame;
	@NotBlank
	@ApiModelProperty(value = "时间段",example = "08:00-10:00",required = true)
	private String timeFrame;
	@NotBlank
	@ApiModelProperty(value = "放号量",example = "6",required = true)
	private Integer userNum;
	@NotBlank
	@ApiModelProperty(value = "余号量",example = "2",required = true)
	private Integer surplusNum;
	@ApiModelProperty(value = "状态：0 禁用  1启用",example = "默认为 0")
	private Integer status;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDepartId() {
		return departId;
	}

	public void setDepartId(Long departId) {
		this.departId = departId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDateFrame() {
		return dateFrame;
	}

	public void setDateFrame(String dateFrame) {
		this.dateFrame = dateFrame;
	}

	public String getTimeFrame() {
		return timeFrame;
	}

	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}

	public Integer getUserNum() {
		return userNum;
	}

	public void setUserNum(Integer userNum) {
		this.userNum = userNum;
	}

	public Integer getSurplusNum() {
		return surplusNum;
	}

	public void setSurplusNum(Integer surplusNum) {
		this.surplusNum = surplusNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
