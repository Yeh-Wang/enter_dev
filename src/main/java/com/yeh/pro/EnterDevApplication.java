package com.yeh.pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yeh.pro.mapper")
public class EnterDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterDevApplication.class, args);
    }

}
