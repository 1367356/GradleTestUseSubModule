package com.li;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.li.ftpController")
public class SpringBootFtpApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringBootFtpApplication.class, args);
    }
}
