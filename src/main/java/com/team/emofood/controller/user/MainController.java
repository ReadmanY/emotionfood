package com.team.emofood.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MainController {
    @GetMapping({"/", "/index", "/index.html"})
    public String indexPage(HttpServletRequest request) {
        return "user/index";
    }
}
