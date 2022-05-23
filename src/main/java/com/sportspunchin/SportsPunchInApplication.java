package com.sportspunchin;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sportspunchin.mapper")
public class SportsPunchInApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsPunchInApplication.class, args);
    }

}
