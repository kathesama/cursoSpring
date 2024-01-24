package com.kathe.springboot.app.controllers.section02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/thymeleaf")
public class UserController {
    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "Details str");
        model.addAttribute("firstName", "Fulano");
        model.addAttribute("lastName", "Detal");

        return "details";
    }
}
