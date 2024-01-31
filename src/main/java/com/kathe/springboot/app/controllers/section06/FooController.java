package com.kathe.springboot.app.controllers.section06;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("api/v1/interceptors")
public class FooController {

    @GetMapping
    public Map<String, String> foo() {
        return Collections.singletonMap("message", "get handler foo");
    }

    @GetMapping("/faz")
    public Map<String, String> faz() {
        return Collections.singletonMap("message", "get handler faz");
    }
}
