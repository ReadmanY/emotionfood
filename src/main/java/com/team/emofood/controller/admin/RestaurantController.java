package com.team.emofood.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class RestaurantController {
    @GetMapping({"/restaurants"})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "restaurants");
        return "admin/restaurant-list";
    }
}
