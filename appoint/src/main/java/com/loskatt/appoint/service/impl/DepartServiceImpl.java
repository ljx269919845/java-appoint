package com.loskatt.appoint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.common.StatusCode;
import com.loskatt.appoint.mapper.DepartMapper;
import com.loskatt.appoint.model.Depart;
import com.loskatt.appoint.service.DepartService;

@Service
public class DepartServiceImpl implements DepartService{

	@Autowired
	private DepartMapper departMapper;
	
	@Override
	public Result addDepart(Depart depart) {
		if (departMapper.insert(depart)>0)
		return new Result<Integer>(StatusCode.RESULT_SUCCESS);
		else
	    return new Result<String>(StatusCode.DEPART_ADD_FAIL);	
	}

	@Override
	public Result updateDepart(Depart depart) {
		if (departMapper.update(depart)>0)
		return new Result<Integer>(StatusCode.RESULT_SUCCESS);
		else
	    return new Result<String>(StatusCode.DEPART_UPDATE_FAIL);	
	}

	@Override
	public Result findById(Long id) {
		return new Result<Depart>(StatusCode.RESULT_SUCCESS,departMapper.select(id));
	}

	@Override
	public Result updateStatus(Long id,Integer status) {
		if (departMapper.updateStatus(id,status)>0)
		return new Result<Integer>(StatusCode.RESULT_SUCCESS);
		else
	    return new Result<String>(StatusCode.DEPART_UPDATE_FAIL);	
	}

	@Override
	public Result deleteById(Long id) {
		return new Result<Integer>(StatusCode.RESULT_SUCCESS,departMapper.delete(id));
	}

	@Override
	public Result getDepartListByStatus(Integer status) {
		return new Result<List<Depart>>(StatusCode.RESULT_SUCCESS,departMapper.getDepartListByStatus(status));
	}

}
