package com.loskatt.appoint.vo;

import com.loskatt.appoint.common.BaseObject;

import io.swagger.annotations.ApiModelProperty;

public class LoginReqVo extends BaseObject{
    
    @ApiModelProperty(value = "账号")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;
    
    
    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}