package com.xzp.other.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 时间未到，资格未够，继续努力！
 *
 * @Author xuezhanpeng
 * @Date 2023/3/26 9:33
 * @Version 1.0
 */
@Target(ElementType.METHOD)   //定义注解的使用范围为方法
@Retention(RetentionPolicy.RUNTIME )
public @interface ViewCountAnnotion {
}
