package com.sportspunchin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sportspunchin.mapper")
public class MybatisConfig {

}
