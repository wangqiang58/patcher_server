package com.xdf.patcher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.xdf.patcher.mapper"})
public class PatcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatcherApplication.class, args);
    }

}
