package com.springboot.chapter5.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.springboot.chapter5"})
@EnableJpaRepositories(basePackages = "com.springboot.chapter5.dao")
@EntityScan(basePackages = "com.springboot.chapter5.pojo")
public class Chapter5Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter5Application.class,args);
    }
}
