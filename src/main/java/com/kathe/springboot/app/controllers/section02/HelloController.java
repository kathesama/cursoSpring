package com.kathe.springboot.app.controllers.section02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/test")
public class HelloController {

    @GetMapping("/foo")
    public Map<String, String> foo() {
        Map<String, String> json = new HashMap<String, String>();
        json.put("message", "Hello foo world!!!");

        return json;
    }
}
