package com.loskatt.appoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.model.Doctor;
import com.loskatt.appoint.service.AppointService;
import com.loskatt.appoint.service.DoctorService;
import com.loskatt.appoint.vo.AppointSearch;
import com.loskatt.appoint.vo.DoctorSearch;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "medical")
public class DoctorController{

    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private AppointService appointService;

    @RequestMapping(value = "/doctor/add",method = RequestMethod.POST)
    @ApiOperation(value="创建医生", notes="根据Doctor对象创建医生信息")
    public Result addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }
    
    @RequestMapping(value = "/doctor/{id}/update",method = RequestMethod.POST)
    @ApiOperation(value="修改医生", notes="根据医生ID修改医生信息")
    public Result updateDoctor(@RequestBody Doctor doctor){
        return doctorService.updateDoctor(doctor);
    }
    
    @RequestMapping(value = "/doctor/{id}/update/{status}",method = RequestMethod.POST)
    @ApiOperation(value="修改医生状态", notes="根据医生ID修改科室状态")
    public Result updateStatus(@PathVariable("id") Long id,@PathVariable("status") Integer status){
        return doctorService.updateStatus(id,status);
    }
    
    @RequestMapping(value = "/doctor/{id}/delete",method = RequestMethod.DELETE)
    @ApiOperation(value="删除医生", notes="根据医生ID删除医生信息")
    public Result deleteDoctor(@PathVariable("id") Long id){
        return doctorService.deleteById(id);
    }
    
    @RequestMapping(value = "/doctor/appoint/{appointId}/{status}",method = RequestMethod.POST)
    @ApiOperation(value="医生在线销号", notes="用户已就诊,医生后台销号 状态: 2")
    public Result removeAppoint(@PathVariable("appointId") Long appointId,@PathVariable("status") Integer status){
        return appointService.updateStatus(appointId,status);
    }
    
    
    @RequestMapping(value = "/doctor/list",method = RequestMethod.GET)
    @ApiOperation(value="获取医生列表", notes="根据条件过滤")
    public Result getDepartListByStatus(DoctorSearch doctorSearch){
        return doctorService.getDoctorList(doctorSearch);
    }
    
    
    @RequestMapping(value = "/doctor/appoint/list",method = RequestMethod.GET)
    @ApiOperation(value="医生获取预约列表", notes="根据条件过滤")
    public Result getAppointList(AppointSearch appointSearch){
        return appointService.getAppointList(appointSearch);
    }
    
}
