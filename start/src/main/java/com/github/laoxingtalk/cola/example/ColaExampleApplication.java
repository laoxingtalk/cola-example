package com.github.laoxingtalk.cola.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.github.laoxingtalk.cola.example", "com.alibaba.cola" })
@MapperScan("com.github.laoxingtalk.cola.example.gatewayimpl.database")
public class ColaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColaExampleApplication.class, args);
    }

}
