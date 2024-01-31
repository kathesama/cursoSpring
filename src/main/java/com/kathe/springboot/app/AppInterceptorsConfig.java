package com.kathe.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppInterceptorsConfig implements WebMvcConfigurer {
    private final HandlerInterceptor timeInterceptor;

    @Autowired
    public AppInterceptorsConfig(@Qualifier("loadingTimeInterceptor") HandlerInterceptor timeInterceptor) {
        this.timeInterceptor = timeInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);

        registry.addInterceptor(timeInterceptor).addPathPatterns("/api/v1/interceptors/faz");
    }
}
