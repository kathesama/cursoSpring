package com.kathe.springboot.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
    @PropertySource(value="classpath:values.properties", encoding = "ISO8859-1")
})
public class AppConfig {
}
