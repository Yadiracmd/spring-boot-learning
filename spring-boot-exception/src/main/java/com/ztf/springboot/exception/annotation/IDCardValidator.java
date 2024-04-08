package com.ztf.springboot.exception.annotation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class IDCardValidator implements ConstraintValidator<Phone,String> {

    // 手机号正则表达式
    private static final String REGEX_PHONE = "^1[3456789]\\d{9}$";

    @Override
    public void initialize(Phone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(value)){
            return true;
        }
        return Pattern.matches(REGEX_PHONE, value);
    }
}
