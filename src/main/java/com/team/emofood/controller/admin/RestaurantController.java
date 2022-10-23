package com.team.emofood.controller.admin;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.emofood.service.RestaurantService;
import com.team.emofood.util.PageQueryUtil;
import com.team.emofood.util.Result;
import com.team.emofood.util.ResultGenerator;


@Controller
@RequestMapping("/admin")
public class RestaurantController {

    @Resource
    RestaurantService restaurantService;

    @GetMapping({"/restaurants"})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "restaurants");
        return "admin/restaurant-list";
    }

    // 목록
    @RequestMapping(value = "/restaurants/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (!StringUtils.hasText((CharSequence) params.get("page")) || !StringUtils.hasText((CharSequence) params.get("limit"))) {
            return ResultGenerator.genFailResult("파라미터가 비정상입니다！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(restaurantService.getRestaurantPage(pageUtil));
    }
}
