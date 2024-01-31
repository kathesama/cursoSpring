package com.kathe.springboot.app.controllers.section07;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/interceptors")
public class S7AppController {

    @GetMapping("time")
    public ResponseEntity<?> foo2(HttpServletRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("title", "Welcome to topeca");
        data.put("time", new Date());
        data.put("message", request.getAttribute("message"));

        return ResponseEntity.ok(data);
    }
}
