package com.kathe.springboot.app.controllers.section05;

import com.kathe.springboot.app.exceptions.section05.UserNotFoundException;
import com.kathe.springboot.app.interfaces.section05.UserServiceInt;
import com.kathe.springboot.app.models.section05.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/errors")
public class AppController {
    private final UserServiceInt userService;

    @Autowired
    public AppController(UserServiceInt userService) {
        this.userService = userService;
    }
    @GetMapping
    public String index(){
//         int value = 10 /0;
//        System.out.println(value);
        int value = Integer.parseInt("10z");
        return "ok 200";
    }

    @GetMapping("/{id}")
    public User show(@PathVariable(name="id") Long id){
        return userService.findById(id);
    }
}
