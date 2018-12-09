package com.loskatt.appoint.controller;

import javax.security.sasl.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.model.Appoint;
import com.loskatt.appoint.model.User;
import com.loskatt.appoint.service.AppointService;
import com.loskatt.appoint.service.UserService;
import com.loskatt.appoint.service.impl.WechatSupport;
import com.loskatt.appoint.vo.AppointSearch;

import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 *   1.移动端用户注册/修改信息
 *   2.在线预约
 *   3.获取预约详情
 * @author loskatt
 *
 */
@RestController
@RequestMapping(value = "medical")
public class UserController{

    @Autowired
    private UserService userService;
    
    @Autowired
    private AppointService appointService;
    
    @Autowired
    private WechatSupport wechatSupport;

 /*   @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    @ApiOperation(value="用户注册", notes="根据User对象创建用户信息")
    public Result addUser(@RequestBody User user){
        return userService.addUser(user);
    }*/
    
    @RequestMapping(value = "/user/{id}/update",method = RequestMethod.POST)
    @ApiOperation(value="修改用户信息", notes="根据用户ID修改用户信息")
    public Result updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    
    @RequestMapping(value = "/user/{openId}",method = RequestMethod.GET)
    @ApiOperation(value="获取用户信息", notes="根据用户openId查询用户信息")
    public Result getUser(@PathVariable("openId") String openId){
        return userService.findByOpenId(openId);
    }
    
    @RequestMapping(value = "/user/appoint/{settingId}",method = RequestMethod.POST)
    @ApiOperation(value="在线预约申请", notes="根据前端页面加载的预约设置ID提交预约")
    public Result appoint(@PathVariable("settingId") Long settingId,@RequestBody Appoint appoint){
        return appointService.appoint(settingId,appoint);
    }
    
    @RequestMapping(value = "/user/appoint/{appointId}",method = RequestMethod.GET)
    @ApiOperation(value="获取预约详情", notes="根据预约ID获取预约详情")
    public Result selectAppointInfo(@PathVariable("appointId") Long appointId){
        return appointService.selectAppointInfo(appointId);
    }
    
    @RequestMapping(value = "/user/appoint/{appointId}/{status}",method = RequestMethod.POST)
    @ApiOperation(value="用户取消预约", notes="用户预约成功后,可在线取消预约，状态status=0")
    public Result removeAppoint(@PathVariable("appointId") Long appointId,@PathVariable("status") Integer status){
        return appointService.updateStatus(appointId,status);
    }
    
    @RequestMapping(value = "/user/appoint/list/{userId}",method = RequestMethod.GET)
    @ApiOperation(value="获取当前用户的预约列表", notes="根据条件过滤")
    public Result getAppointList(AppointSearch appointSearch,@PathVariable("userId") Long userId){
    	appointSearch.setUserId(userId);
        return appointService.getAppointList(appointSearch);
    }
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @ApiOperation(value="根据小程序临时登录凭证code获取登录Token", notes="返回User对象")
    public Result<Long> createAuthenticationToken(String code)throws AuthenticationException {
        return wechatSupport.wechatLogin(code);
    }

    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    @ApiOperation(value="获取用户列表")
    public Result getUserList(AppointSearch appointSearch){
        appointSearch.setPageIndex(appointSearch.getPageIndex());
        return userService.getUserList(appointSearch);
    }
}
