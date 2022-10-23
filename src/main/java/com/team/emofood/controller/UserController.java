package com.team.emofood.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.team.emofood.dto.User;
import com.team.emofood.service.UserService;

public class UserController {
    
    private UserService userService;

    /**
     * localhost:8080 시 login 으로 redirect
     * @return
     */
    @GetMapping
    public String root() {
        return "redirect:/index";
    }

    /**
     * 로그인 폼
     * @return
     */
    @GetMapping("/index")
    public String login(){
        return "index";
    }

    /**
     * 회원가입 폼
     * @return
     */
    @GetMapping("/join")
    public String signUpForm() {
        return "join";
    }

    /**
     * 회원가입 진행
     * @param user
     * @return
     */
    @PostMapping("/join")
    public String signUp(User user) {
        userService.joinUser(user);
        return "redirect:/index";
    }
}
