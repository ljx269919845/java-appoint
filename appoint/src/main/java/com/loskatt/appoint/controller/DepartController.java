package com.loskatt.appoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.model.Depart;
import com.loskatt.appoint.service.DepartService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "medical")
public class DepartController{

    @Autowired
    private DepartService departService;

    @RequestMapping(value = "/depart/add",method = RequestMethod.POST)
    @ApiOperation(value="创建科室", notes="根据Depart对象创建科室信息")
    public Result addDepart(@RequestBody Depart depart){
        return departService.addDepart(depart);
    }
    
    @RequestMapping(value = "/depart/{id}/update",method = RequestMethod.POST)
    @ApiOperation(value="修改科室", notes="根据科室ID修改科室信息")
    public Result updateDepart(@RequestBody Depart depart){
        return departService.updateDepart(depart);
    }
    
    @RequestMapping(value = "/depart/{id}/update/{status}",method = RequestMethod.POST)
    @ApiOperation(value="修改科室状态", notes="根据科室ID修改科室状态")
    public Result updateStatus(@PathVariable("id") Long id,@PathVariable("status") Integer status){
        return departService.updateStatus(id,status);
    }
    
    @RequestMapping(value = "/depart/{id}/delete",method = RequestMethod.DELETE)
    @ApiOperation(value="删除科室", notes="根据科室ID删除科室信息")
    public Result deleteDepart(@PathVariable("id") Long id){
        return departService.deleteById(id);
    }
    
    @RequestMapping(value = "/depart/list/{status}",method = RequestMethod.GET)
    @ApiOperation(value="获取科室列表", notes="根据状态过滤")
    public Result getDepartListByStatus(@PathVariable("status") Integer status){
        return departService.getDepartListByStatus(status);
    }
    
}
