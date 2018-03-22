package com.li;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.test.annotation.Commit;

@SpringBootApplication
@ComponentScan("com.li.dao.Mapper")
public class SpringBootShrioApplication extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(SpringBootShrioApplication.class, args);
    }
}
