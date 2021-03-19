package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        String location = System.getProperty("user.home") + File.separator + "picture" + File.separator;
        registry.addResourceHandler("/pic/**")
                .addResourceLocations("file:" + location);
    }
}
