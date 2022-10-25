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
import com.team.emofood.controller.vo.KakaoInfoRestaurantVO;
import com.team.emofood.dto.Restaurant;
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
    
    @GetMapping("/restaurants/edit")
    public String edit(HttpServletRequest request) {
        request.setAttribute("path", "edit");
        request.setAttribute("path", "restaurant-edit");
        return "admin/restaurant-list-edit";
    }

    @GetMapping({"restaurants/edit/{restaurantId}"})
    public String edit(HttpServletRequest request, @PathVariable("restaurantId") Integer restaurantId) {
        request.setAttribute("path", "edit");
        KakaoInfoRestaurantVO restaurant = restaurantService.getRestaurantById(restaurantId);
        request.setAttribute("restaurant", restaurant);
        request.setAttribute("path", "restaurant-edit");
        return "admin/restaurant-list-edit";
    }

    // 업데이트
    @RequestMapping(value = "/restaurants/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody Restaurant restaurant) {
        if ( Objects.isNull(restaurant.getRid())
                || !StringUtils.hasText(restaurant.getRname())
                || !StringUtils.hasText(restaurant.getRcate())
                || !StringUtils.hasText(restaurant.getRaddr())
                || !StringUtils.hasText(restaurant.getRaddr_gu())
                || !StringUtils.hasText(restaurant.getRphone())
                || Objects.isNull(restaurant.getRlocate_x())
                || Objects.isNull(restaurant.getRlocate_x())) {
            return ResultGenerator.genFailResult("파라미터가 비정상입니다！");
        }
        String result = restaurantService.updateRestaurant(restaurant);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    // 상세 정보
    @GetMapping("/restaurants/info")
    public String info(HttpServletRequest request) {
        request.setAttribute("path", "info");
        request.setAttribute("path", "restaurant-info");
        return "admin/restaurant-list-detail";
    }

    @GetMapping("/restaurants/info/{restaurantId}")
    public String info(HttpServletRequest request, @PathVariable("restaurantId") Integer restaurantId) {
        request.setAttribute("path", "info");
        KakaoInfoRestaurantVO restaurant = restaurantService.getRestaurantById(restaurantId);
        request.setAttribute("restaurant", restaurant);
        request.setAttribute("path", "restaurant-info");
        return "admin/restaurant-list-detail";
    }

    // 삭제
    @RequestMapping(value = "/restaurants/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody Long[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("파라미터가 비정상입니다！");
        }
        if (restaurantService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("삭제하지 못했습니다");
        }
    }
}