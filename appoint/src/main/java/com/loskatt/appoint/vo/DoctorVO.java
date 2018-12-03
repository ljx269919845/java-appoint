package com.loskatt.appoint.vo;

import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.loskatt.appoint.common.BaseObject;
import com.loskatt.appoint.model.Depart;

public class DoctorVO extends BaseObject {

    private Long id;
	
	private String doctorName;
	
	private String doctorBref;
	
	private Integer doctorAge;
	
	private Integer doctorSex;
	
	private String doctorPhone;
	
	private String doctorImg;
	
	private String professional;
	
	private Depart depart;
	
	private Integer status;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;

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

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
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
}
