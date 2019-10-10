package com.lll.frame.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName TimeAnnotation
 * @Description 自定义的时间注解
 * @Author zl
 * @Create 2019-07-01 11:22
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeAnnotation {

}
