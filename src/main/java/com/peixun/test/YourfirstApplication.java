package com.peixun.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/peixun/test/mapper")
public class YourfirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(YourfirstApplication.class, args);

    }


}
