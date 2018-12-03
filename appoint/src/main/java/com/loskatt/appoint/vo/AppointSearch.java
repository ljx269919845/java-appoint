package com.loskatt.appoint.vo;

public class AppointSearch extends PageSearch{
    
    private static final long serialVersionUID = 1L;

    private Integer status;
    
    private Long departId;
    
    private Long doctorId;
    
    private Long userId;
    
    private String appointDate;
	
	private String beginDate;

	private String endDate;

	private Integer pageIndex = 1;

	private Integer pageSize = 20;

	private String timeFrame;


	public String getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(String appointDate) {
		this.appointDate = appointDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public void setBeginDate(String beginDate){
		this.beginDate = beginDate;
	}

	public String getBeginDate(){
		return this.beginDate;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public int getPageIndex(){
		return this.pageIndex;
	}

	public int getPageSize(){
		return this.pageSize;
	}

	public void setPageIndex(Integer pageIndex){
		this.pageIndex = pageIndex;
	}

	public void setPageSize(Integer pageSize){
		this.pageSize = pageSize;
	}

	public int getOffset(){
		return (this.pageIndex - 1) * this.pageSize;
	}

	public String getTimeFrame(){
		return timeFrame;
	}

	public void setTimeFrame(String timeFrame){
		this.timeFrame = timeFrame;
	}
}

