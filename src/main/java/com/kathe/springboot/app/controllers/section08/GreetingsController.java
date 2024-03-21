package com.kathe.springboot.app.controllers.section08;

import com.kathe.springboot.app.interfaces.section08.GreetingsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
@RestController
@RequestMapping("api/v1/aop")
public class GreetingsController {
    private final GreetingsInterface greetings;

    @Autowired
    public GreetingsController(GreetingsInterface greetings){
        this.greetings = greetings;
    }

    @GetMapping("/greetings")
    public ResponseEntity<?> greetings() {
        return ResponseEntity.ok(Collections.singletonMap("greetings", greetings.sayHello("John", "Doe")));
    }
}
