package com.loskatt.appoint.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = FlagValidator.class)
public @interface Flag
{
    //flag的有效值多个使用','隔开
    String values();
    //提示内容
    String message() default "flag isn't exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
