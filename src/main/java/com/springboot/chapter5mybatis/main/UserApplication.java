package com.springboot.chapter5mybatis.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

//定义扫描路径
@SpringBootApplication(scanBasePackages = "com.springboot.chapter5mybatis")
//扫描mybatis DAO接口
@MapperScan(basePackages = "com.springboot.chapter5mybatis",
        annotationClass = Repository.class)
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
