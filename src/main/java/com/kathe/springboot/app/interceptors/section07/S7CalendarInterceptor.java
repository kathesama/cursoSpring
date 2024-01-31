package com.kathe.springboot.app.interceptors.section07;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component("calendarInterceptor")
public class S7CalendarInterceptor implements HandlerInterceptor {

    @Value("${config.calendar.open}")
    private Integer open;

    @Value("${config.calendar.close}")
    private Integer close;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Calendar calendar = Calendar.getInstance();
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if (hour >= open && hour <= close){
            System.out.println(open);
            System.out.println(hour);
            System.out.println(close);
            StringBuilder sb = new StringBuilder("Bienvenidos a topeca");
            sb.append(", atendemos desde las ").append(open).append(", hasta las ").append(close);
            System.out.println(sb.toString());

            request.setAttribute("message", sb.toString());
            return true;
        }

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();

        StringBuilder message = new StringBuilder("Cerrado, fuera de horario, ")
                .append("Por favor visítenos en horario de apertura, ").append("atendemos desde las ")
                .append(open).append(", hasta las ").append(close);
        data.put("message", message);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(mapper.writeValueAsString(message));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
