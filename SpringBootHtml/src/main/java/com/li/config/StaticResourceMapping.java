package com.li.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticResourceMapping extends WebMvcConfigurerAdapter {

    /**
     * 配置静态资源映射
     */
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //将所有/static/** 访问都映射到classpath:/static/ 目录下
            registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/js/");
        }

}
