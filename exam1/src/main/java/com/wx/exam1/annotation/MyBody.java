package com.wx.exam1.annotation;

import java.lang.annotation.*;

/***
 * 参数解析注解
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyBody {
    String value();
}