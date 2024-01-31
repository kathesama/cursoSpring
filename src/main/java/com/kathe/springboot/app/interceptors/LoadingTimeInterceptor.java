package com.kathe.springboot.app.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("loadingTimeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long starting = System.currentTimeMillis();
        request.setAttribute("starting", starting);

        logger.info("LoadingTimeInterceptor: starting preHandle()...");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long ending = System.currentTimeMillis();
        long starting = (long) request.getAttribute("starting");
        long difference = ending - starting;

        logger.info("LoadingTimeInterceptor: closing postHandle()...");
        logger.info("LoadingTimeInterceptor: time is [" + difference + "] milliseconds");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
