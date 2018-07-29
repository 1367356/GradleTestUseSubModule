package com.li.mySpringFrameWork.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * controller层
 * requestMapping注解
 */
@Target(ElementType.METHOD)  //作用在方法上面
@Retention(RetentionPolicy.RUNTIME)   //作用在方法上
public @interface CotrollerMappingAnnotation {
    public String mappingPath();
}
