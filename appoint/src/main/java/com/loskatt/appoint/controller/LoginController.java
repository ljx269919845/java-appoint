package com.loskatt.appoint.controller;

import java.util.HashMap;
import java.util.Map;

import com.loskatt.appoint.common.GlobalStatusCode;
import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.common.StatusCode;
import com.loskatt.appoint.vo.LoginReqVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "medical")
public class LoginController{
    @RequestMapping(value = "/login/admin",method = RequestMethod.POST)
    @ApiOperation(value="用户注册", notes="根据User对象创建用户信息")
    public Result addUser(@RequestBody LoginReqVo loginReqVo){
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("token", "111111111111111111");
        return new Result(StatusCode.RESULT_SUCCESS, userInfo);
    }
}