package com.team.emofood.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.emofood.dto.Restaurant;
import com.team.emofood.mapper.RestaurantMapper;
import com.team.emofood.service.RestaurantService;
import com.team.emofood.util.PageQueryUtil;
import com.team.emofood.util.PageResult;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantMapper RestaurantMapper;

    @Override
    public PageResult getRestaurantPage(PageQueryUtil pageUtil) {
        List<Restaurant> RestaurantList = RestaurantMapper.findRestaurantList(pageUtil);
        int total = RestaurantMapper.getTotalRestaurant(pageUtil);
        PageResult pageResult = new PageResult(RestaurantList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

}
