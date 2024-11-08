package com.example.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 允許所有路徑
                .allowedOrigins("http://localhost:5173")  // 允許的來源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 允許的請求方法
                .allowCredentials(true);  // 是否允許發送憑證
    }
}
