package com.loskatt.appoint.common;


public class GlobalException extends RuntimeException {
    
    private static final long serialVersionUID = -1178522679073184111L;
    
    private String statusCode;
    private String message;
    
    
    public GlobalException() {
        super();
    }

    public GlobalException(GlobalStatusCode status) {        
        super();
        this.statusCode = status.getStatusCode();
        this.message = status.getMessage();
    }
    
    public <T> GlobalException(Result<T> result) {        
        this(result.getResultCode(),result.getResultMsg());
    }

    public GlobalException(String statusCode,String message) {        
        super();
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

