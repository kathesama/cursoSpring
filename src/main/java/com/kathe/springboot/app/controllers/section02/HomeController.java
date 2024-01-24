package com.kathe.springboot.app.controllers.section02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// para hacer redirection de URL
@Controller
public class HomeController {
    // redidirige y cambia la URL a la nueva URL
    @GetMapping({"", "/", "/home"})
    public String redirectToHome() {
        return "redirect:/api/v1/listDTO";
    }

    // redidirige pero no cambia la URL, es como un include
    @GetMapping({"/forward"})
    public String forwardToHome() {
        return "forward:/api/v1/listDTO";
    }
}
