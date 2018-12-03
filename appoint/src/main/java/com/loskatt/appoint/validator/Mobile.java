package com.loskatt.appoint.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR})
@Constraint(validatedBy = {MobileValidator.class })
public @interface Mobile {
	
	boolean required() default true;
	 
	String message() default "手机号码格式错误";
 
	Class<?>[] groups() default {};
 
	Class<? extends Payload>[] payload() default {};
}
