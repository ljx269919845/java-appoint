package com.loskatt.appoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.model.AppointSet;
import com.loskatt.appoint.service.AppointService;
import com.loskatt.appoint.service.AppointSetService;
import com.loskatt.appoint.vo.AppointSearch;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "medical")
public class AppointController{

    @Autowired
    private AppointSetService appointSetService;

    @RequestMapping(value = "/load/setting/depart/{departId}",method = RequestMethod.GET)
    @ApiOperation(value="根据科室ID加载预约配置记录", notes="统计当前科室已预约人数")
    public Result loadSettingForDepart(@PathVariable("departId") Long departId){
        return appointSetService.loadSettingForDepart(departId);
    }
    
    @RequestMapping(value = "/load/setting/doctor/{doctorId}",method = RequestMethod.GET)
    @ApiOperation(value="根据医生ID加载预约配置记录", notes="统计当前医生已预约人数")
    public Result loadSettingForDoctor(@PathVariable("doctorId") Long doctorId){
        return appointSetService.loadSettingForDoctor(doctorId);
    }
    
    @RequestMapping(value = "/appoint/setting/add",method = RequestMethod.POST)
    @ApiOperation(value="新增预约配置", notes="根据AppointSet对象创建预约配置信息")
    public Result addSetting(@RequestBody AppointSet appointSet){
        return appointSetService.addSetting(appointSet);
    }
    
    @RequestMapping(value = "/appoint/setting/{id}/update",method = RequestMethod.POST)
    @ApiOperation(value="修改预约配置", notes="根据配置ID修改预约配置")
    public Result updateSetting(@RequestBody AppointSet appointSet){
        return appointSetService.updateSetting(appointSet);
    }
    
    @RequestMapping(value = "/appoint/setting/{id}/update/{status}",method = RequestMethod.POST)
    @ApiOperation(value="修改配置状态", notes="根据配置ID修改配置状态")
    public Result updateStatus(@PathVariable("id") Long id,@PathVariable("status") Integer status){
        return appointSetService.updateStatus(id,status);
    }
    
    @RequestMapping(value = "/appoint/setting/{id}/delete",method = RequestMethod.DELETE)
    @ApiOperation(value="删除预约配置", notes="根据配置ID删除预约配置")
    public Result deleteSetting(@PathVariable("id") Long id){
        return appointSetService.deleteSetting(id);
    }
    
    @RequestMapping(value = "/appoint/setting/list",method = RequestMethod.GET)
    @ApiOperation(value="获取预约配置列表", notes="复合查询，可分页")
    public Result getAppointSetList(AppointSearch appointSearch){
        return appointSetService.getAppointSetList(appointSearch);
    }
    
}
