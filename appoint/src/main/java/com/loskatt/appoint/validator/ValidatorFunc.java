package com.loskatt.appoint.validator;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public class ValidatorFunc {
	
	   @Autowired
	   private MessageSource messageSource;
	   
       public String validator(BindingResult result){
    	   StringBuffer msg = new StringBuffer();
           //获取错误字段集合
           List<FieldError> fieldErrors = result.getFieldErrors();
           //获取本地locale,zh_CN
           Locale currentLocale = LocaleContextHolder.getLocale();
           //遍历错误字段获取错误消息
           for (FieldError fieldError:fieldErrors) {
               //获取错误信息
               String errorMessage = messageSource.getMessage(fieldError,currentLocale);
               //添加到错误消息集合内
               msg.append(fieldError.getField()+"："+errorMessage+" , ");
           }
           return msg.toString();
       }
}
