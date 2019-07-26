package com.wx.exam1.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ANNOTATION_TYPE, METHOD, CONSTRUCTOR, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = IsAdressValidator.class)
public @interface AdressExist {
    //是否必须
    boolean required() default false;

    String message() default "地址必须为有效地址";

    //分组
    Class<?>[] groups() default {};

    //负载
    Class<? extends Payload>[] payload() default {};
}
