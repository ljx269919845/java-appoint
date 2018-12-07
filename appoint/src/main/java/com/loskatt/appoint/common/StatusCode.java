package com.loskatt.appoint.common;

public enum StatusCode implements GlobalStatusCode{
	
    RESULT_SUCCESS("00000000", "SUCCESS"),
    
    DEPART_ADD_FAIL("DEPART_10000001","新增科室异常"),
    DEPART_UPDATE_FAIL("DEPART_10000002","修改科室信息失败"),
    
    DOCTOR_ADD_FAIL("DOCTOR_20000001","新增医生信息异常"),
    DOCTOR_UPDATE_FAIL("DOCTOR_20000002","修改医生信息失败"),
    
    USER_ADD_FAIL("USER_30000001","注册失败"),
    USER_UPDATE_FAIL("USER_30000002","修改信息失败"),
    USER_PHONE_IS_EXIST("USER_30000003","该手机号已被注册,请输入新的号码"),
    USER_BIRTHDAY_IS_ERROR("USER_30000004","出生年月日格式有误,示例:1997-09-07"),
    USER_IS_NOT_EXIST("USER_30000005","用户信息不存在"),
    USER_NOT_REGISTER("USER_30000006","用户未注册"),
    USER_AUTH_WX_FAIL("USER_30000007","调用微信小程序接口失败"),
    USER_AUTH_WX_DATA_ERROR("USER_30000008","调用微信小程序接口数据异常"),
    
    APPOINT_ADD_FAIL("APPOINT_40000001","预约申请失败"),
    APPOINT_UPDATE_FAIL("APPOINT_40000002","预约信息更新失败"),
    APPOINT_IS_EXIST("APPOINT_40000003","当天已经预约该医生,不能重复预约"),
    APPOINT_SET_NOT_EXIST("APPOINT_40000004","预约设置不存在，请初始化数据"),
    APPOINT_SURPLUS_NUM_NOT_ENOUGH("APPOINT_40000005","余号不足,无法预约"),
    APPOINT_SET_ADD_FAIL("APPOINT_40000006","新增预约配置信息异常"),
    APPOINT_SET_UPDATE_FAIL("APPOINT_40000007","修改预约设置信息失败"),
    
    FILE_UPLOAD_FAIL("APPOINT_50000001","文件上传失败"),
    PARAM_NULL("0000001", "参数异常"),
    PARAM_LENGTH("0000002", "参数长度异常"),
    UNKNOW_RESULT("99999999", "SYSTEM EXCEPTION");
    
    private String statusCode;
    private String message;

    StatusCode(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
