package com.xzp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.xzp.mapper")
@EnableAspectJAutoProxy
public class ExamApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamApiApplication.class, args);
    }

}
