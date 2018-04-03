package com.li;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
@MapperScan(value = "com.li.dao.Mapper")
public class SpringBootShrioApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringBootShrioApplication.class, args);
    }
}
