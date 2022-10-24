package com.team.emofood.controller.common;

import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.emofood.common.Constants;
import com.team.emofood.common.ServiceResultEnum;
import com.team.emofood.dto.User;
import com.team.emofood.service.UserService;
import com.team.emofood.util.Result;
import com.team.emofood.util.ResultGenerator;

@Controller
@RequestMapping("")
public class LoginController {
    @Resource
    private UserService userService;

    @GetMapping({"/logout", "/user/logout", "/admin/logout"})
    public String logout(HttpSession httpSession) {
        if(null == httpSession.getAttribute(Constants.USER_SESSION_KEY)){
            httpSession.removeAttribute(Constants.USER_SESSION_KEY);
        }
        if(null == httpSession.getAttribute(Constants.ADMIN_SESSION_KEY)){
            httpSession.removeAttribute(Constants.ADMIN_SESSION_KEY);
        }
        return "index";
    }

    @GetMapping({"/login", "/login.html"})
    public String loginPage() {
        return "index";
    }

    @GetMapping({"/join", "/join.html"})
    public String registerPage() {
        return "join";
    }

    @PostMapping("/login")
    public @ResponseBody Result login(@RequestParam("user_id") String loginEmail, @RequestParam("user_pw") String password, HttpSession httpSession) {
        if (!StringUtils.hasText(loginEmail)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_NAME_NULL.getResult());
        }
        if (!StringUtils.hasText(password)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_PASSWORD_NULL.getResult());
        }

        String loginResult = userService.login(loginEmail, password, httpSession);
        // 로그인 성공
        if (ServiceResultEnum.SUCCESS.getResult().equals(loginResult)) {
            return ResultGenerator.genSuccessResult();
        }
        // 로그인 실패
        return ResultGenerator.genFailResult(loginResult);
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user, HttpSession httpSession) {
        if ( !StringUtils.hasText(user.getUemail())
                || !StringUtils.hasText(user.getUname())
                || !StringUtils.hasText(user.getUpw())
                || Objects.isNull(user.getUage())
                || Objects.isNull(user.getUgend())) {
            return ResultGenerator.genFailResult("파라미터가 비정상입니다！");
        }

        String registerResult = userService.register(user);
        // 가입 성공
        if (ServiceResultEnum.SUCCESS.getResult().equals(registerResult)) {
            return ResultGenerator.genSuccessResult();
        }
        // 가입 실패
        return ResultGenerator.genFailResult(registerResult);
    }
}
