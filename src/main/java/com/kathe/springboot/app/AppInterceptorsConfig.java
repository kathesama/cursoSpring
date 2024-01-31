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
    private final HandlerInterceptor calendarInterceptor;

    @Autowired
    public AppInterceptorsConfig(
            @Qualifier("loadingTimeInterceptor") HandlerInterceptor timeInterceptor,
            @Qualifier("calendarInterceptor") HandlerInterceptor calendarInterceptor
            ) {
        this.timeInterceptor = timeInterceptor;
        this.calendarInterceptor = calendarInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);

        registry.addInterceptor(calendarInterceptor);
        registry.addInterceptor(timeInterceptor).addPathPatterns("/api/v1/interceptors/faz");
    }
}
