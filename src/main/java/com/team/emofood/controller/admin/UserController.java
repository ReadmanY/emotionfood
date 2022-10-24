package com.team.emofood.controller.admin;

import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.emofood.common.ServiceResultEnum;
import com.team.emofood.dto.User;
import com.team.emofood.service.UserService;
import com.team.emofood.util.PageQueryUtil;
import com.team.emofood.util.Result;
import com.team.emofood.util.ResultGenerator;


@Controller
@RequestMapping("/admin")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping({"users"})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "users");
        return "admin/user-list";
    }

    // 목록
    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (!StringUtils.hasText((CharSequence) params.get("page")) || !StringUtils.hasText((CharSequence) params.get("limit"))) {
            return ResultGenerator.genFailResult("파라미터가 비정상입니다！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(userService.getUserPage(pageUtil));
    }

    @GetMapping("/users/edit")
    public String edit(HttpServletRequest request) {
        request.setAttribute("path", "edit");
        request.setAttribute("path", "user-edit");
        return "admin/user-list-edit";
    }

    @GetMapping({"users/edit/{userId}"})
    public String edit(HttpServletRequest request, @PathVariable("userId") String userId) {
        request.setAttribute("path", "edit");
        User user = userService.getUserById(userId);
        request.setAttribute("user", user);
        request.setAttribute("path", "user-edit");
        return "admin/user-list-edit";
    }

    // 업데이트
    @RequestMapping(value = "/users/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody User user) {
        if ( !StringUtils.hasText(user.getUemail())
                || !StringUtils.hasText(user.getUname())
                || !StringUtils.hasText(user.getUpw())
                || Objects.isNull(user.getUage())
                || Objects.isNull(user.getUgend())) {
            return ResultGenerator.genFailResult("파라미터가 비정상입니다！");
        }
        String result = userService.updateUser(user);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    // 상세 정보
    @GetMapping("/users/info")
    public String info(HttpServletRequest request) {
        request.setAttribute("path", "info");
        request.setAttribute("path", "user-info");
        return "admin/user-list-detail";
    }

    @GetMapping("/users/info/{userId}")
    public String info(HttpServletRequest request, @PathVariable("userId") String userId) {
        request.setAttribute("path", "info");
        User user = userService.getUserById(userId);
        request.setAttribute("user", user);
        request.setAttribute("path", "user-info");
        return "admin/user-list-detail";
    }

    // 삭제
    @RequestMapping(value = "/users/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody String[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("파라미터가 비정상입니다！");
        }
        if (userService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("삭제하지 못했습니다");
        }
    }
}
