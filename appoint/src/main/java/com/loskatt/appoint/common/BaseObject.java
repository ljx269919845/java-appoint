package com.loskatt.appoint.common;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class BaseObject implements Serializable {
	private static final long serialVersionUID = 1L;

	public String toString(){
        return JSON.toJSONString(this);
    }
}

