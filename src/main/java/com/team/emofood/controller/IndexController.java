package com.team.emofood.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
    @GetMapping({"", "index", "index.html"})
    public String indexPage(HttpServletRequest request) {
        return "index";
    }
}
