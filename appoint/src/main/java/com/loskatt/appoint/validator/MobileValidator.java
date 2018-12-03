package com.loskatt.appoint.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class MobileValidator implements ConstraintValidator<Mobile, Object> {
	private boolean required = false;
	
	@Override
	public void initialize(Mobile constraintAnnotation) {
		required = constraintAnnotation.required();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (required) {
			return ValidatorUtil.isMobile(value);
		} else {
			if (StringUtils.isEmpty(value)) {
				return true;
			} else {
				return ValidatorUtil.isMobile(value);
			}
		}

	}
}


class ValidatorUtil {
	 
	private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");
 
	public static boolean isMobile(Object src) {
		if (StringUtils.isEmpty(src)) {
			return false;
		}
		Matcher m = mobile_pattern.matcher(src.toString());
		return m.matches();
	}
}