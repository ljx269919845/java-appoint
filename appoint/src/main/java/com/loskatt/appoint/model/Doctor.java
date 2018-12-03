package com.loskatt.appoint.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class Doctor {

    private Long id;
    @ApiModelProperty(value = "医生姓名",example = "张三")
    @NotBlank
	private String doctorName;
    @ApiModelProperty(value = "医生简介",example = "张三毕业于XX医科大学,从事...")
	private String doctorBref;
    @ApiModelProperty(value = "医生年龄",example = "35")
	private Integer doctorAge;
    @ApiModelProperty(value = "医生性别",example = "男 /女")
	private Integer doctorSex;
    @ApiModelProperty(value = "医生联系方式",example = "13800138000")
	private String doctorPhone;
    @ApiModelProperty(value = "医生相片",example = "相片地址URL")
	private String doctorImg;
    @ApiModelProperty(value = "医生职称",example = "主任医师")
	private String professional;
    @ApiModelProperty(value = "所属科室",example = "科室ID")
    @NotBlank
	private Long departId;
    @ApiModelProperty(value = "医生出诊状态",example = "1 出诊 0 休息")
	private Integer status;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorBref() {
		return doctorBref;
	}

	public void setDoctorBref(String doctorBref) {
		this.doctorBref = doctorBref;
	}

	public Integer getDoctorAge() {
		return doctorAge;
	}

	public void setDoctorAge(Integer doctorAge) {
		this.doctorAge = doctorAge;
	}

	public Integer getDoctorSex() {
		return doctorSex;
	}

	public void setDoctorSex(Integer doctorSex) {
		this.doctorSex = doctorSex;
	}

	public String getDoctorPhone() {
		return doctorPhone;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	public String getDoctorImg() {
		return doctorImg;
	}

	public void setDoctorImg(String doctorImg) {
		this.doctorImg = doctorImg;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public Long getDepartId() {
		return departId;
	}

	public void setDepartId(Long departId) {
		this.departId = departId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
