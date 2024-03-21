package com.kathe.springboot.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AppAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(String com.kathe.springboot.app.services.section08.GreetingsService.sayHello(..))")
    public void loggerBefore(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String methodArgs = Arrays.toString(joinPoint.getArgs());

        logger.info("Before: [" + methodName + "] with args " + methodArgs);
    }
}
