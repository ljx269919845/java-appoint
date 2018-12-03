package com.loskatt.appoint.service;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.model.Depart;


public interface DepartService{
    
    public Result addDepart(Depart depart);
    
    public Result updateDepart(Depart depart);
    
    public Result findById(Long id);
    
    public Result updateStatus(Long id,Integer status);
    
    public Result deleteById(Long id);
    
    public Result getDepartListByStatus(Integer status);
}
