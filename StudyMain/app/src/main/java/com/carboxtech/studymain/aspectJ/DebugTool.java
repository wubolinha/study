package com.carboxtech.studymain.aspectJ;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by admin on 2018/11/21.
 *
 *  自定义注解类
 *  监控指定的Pointcut，
 */

@Retention(RetentionPolicy.CLASS) // 注解的保留位置:注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})  //注解的作用目标
public @interface DebugTool {
}
