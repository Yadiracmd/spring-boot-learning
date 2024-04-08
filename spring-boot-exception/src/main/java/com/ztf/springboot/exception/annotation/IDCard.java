package com.ztf.springboot.exception.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IDCardValidator.class})
public @interface IDCard {
    String message() default "身份证不正确";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
