package com.loskatt.appoint.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 参数实体映射注解
 * 配置该注解的参数会使用 com.loskatt.lession.reslover.CustomerArgumentResolver类完成参数装载
 */
@Target(value = ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParameterModel
{

}
