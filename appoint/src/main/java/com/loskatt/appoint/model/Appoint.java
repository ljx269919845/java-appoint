package com.loskatt.appoint.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class Appoint{

	private Long id;
	@NotBlank
	@ApiModelProperty(value = "科室ID",example = "1207",required = true)
	private Long departId;
	@NotBlank
	@ApiModelProperty(value = "医生ID",example = "68",required = true)
	private Long doctorId;
	@NotBlank
	@ApiModelProperty(value = "用户ID",example = "112",required = true)
	private Long userId;
	@NotBlank
	@ApiModelProperty(value = "预约日期",example = "2018-12-12",required = true)
	private String appointDate;
	@NotBlank
	@ApiModelProperty(value = "预约时间段",example = "16:00-17:00",required = true)
	private String appointTime;
	@ApiModelProperty(value = "状态：0 取消预约  1 预约成功 2 已销号",example = "默认为 1")
	private Integer status;
	@ApiModelProperty(value = "病情简述",example = "患者..相思病")
	private String remark;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(String appointDate) {
		this.appointDate = appointDate;
	}

	public String getAppointTime() {
		return appointTime;
	}

	public void setAppointTime(String appointTime) {
		this.appointTime = appointTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
