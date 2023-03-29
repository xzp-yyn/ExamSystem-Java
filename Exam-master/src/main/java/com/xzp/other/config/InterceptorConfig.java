package com.xzp.other.config;

import com.xzp.other.interceptor.StudentInterceptor;
import com.xzp.other.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author 薛展鹏
 * @date 2023/03/29
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private UserInterceptor userInterceptor;
    @Autowired
    private StudentInterceptor studentInterceptor;

    // 与学生相关
    public static final String[] aboutStudent = {
            "/student/**"
    };

    // 与管理员相关
    public static final String[] aboutAdmin = {
            "/admin/**"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
          用户拦截器思路（拦截未登录的请求）：
          1. 拦截管理员请求
          2. 拦截学生请求
         */
        registry.addInterceptor(userInterceptor)
                .addPathPatterns(aboutAdmin)
                .addPathPatterns(aboutStudent);

        /*
         * 学生拦截器思路（拦截管理员的请求）：
         * 1. 拦截管理员请求
         */
        registry.addInterceptor(studentInterceptor)
                .addPathPatterns(aboutAdmin);

    }
}
