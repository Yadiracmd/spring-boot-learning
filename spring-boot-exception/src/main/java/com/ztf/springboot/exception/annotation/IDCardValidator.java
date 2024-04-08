package com.ztf.springboot.exception.annotation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class IDCardValidator implements ConstraintValidator<IDCard,String> {

    // 身份证正则表达式
    private static final String REGEX_ID_CARD = "^(^\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";

    @Override
    public void initialize(IDCard constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(value)){
            return true;
        }
        return Pattern.matches(REGEX_ID_CARD, value);
    }
}
