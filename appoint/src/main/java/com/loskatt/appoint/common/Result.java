package com.loskatt.appoint.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result <T> extends BaseObject implements Serializable {

    /**
     * 
     */
    private static final String RESULT_SUCCESS = "00000000";
    private static final long serialVersionUID = 7237821738979926948L;

    private String resultCode = RESULT_SUCCESS;

    private String resultMsg = "SUCCESS";

    private T data;

    public Result() {
    }

    public Result(GlobalStatusCode globalStatusCode) {
        this(globalStatusCode, null);
    }

    public Result(String statusCode, String message) {
        this(statusCode, message, null);
    }

    public Result(GlobalStatusCode globalStatusCode, T data) {
        this(globalStatusCode.getStatusCode(), globalStatusCode.getMessage(), data);
    }

    public Result(String resultCode, String resultMsg, T data) {
        this.data = data;
        this.resultMsg = resultMsg;
        this.resultCode = resultCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setStatusCode(GlobalStatusCode statusCode) {
        this.resultCode = statusCode.getStatusCode();
        this.resultMsg = statusCode.getMessage();
    }

    public boolean hasError() {
        return !this.getResultCode().equalsIgnoreCase(RESULT_SUCCESS);
    }
}
