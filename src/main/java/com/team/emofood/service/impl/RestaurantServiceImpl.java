package com.team.emofood.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.emofood.common.EmoExcption;
import com.team.emofood.common.ServiceResultEnum;
import com.team.emofood.dto.Restaurant;
import com.team.emofood.mapper.RestaurantMapper;
import com.team.emofood.service.RestaurantService;
import com.team.emofood.util.PageQueryUtil;
import com.team.emofood.util.PageResult;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Override
    public PageResult getRestaurantPage(PageQueryUtil pageUtil) {
        List<Restaurant> RestaurantList = restaurantMapper.findKakaoInfoRestaurantList(pageUtil);
        int total = restaurantMapper.getTotalKakaoInfoRestaurant(pageUtil);
        PageResult pageResult = new PageResult(RestaurantList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String updateRestaurant(Restaurant restaurant) {
        Restaurant temp = restaurantMapper.selectByPrimaryKey(restaurant.getRid());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (restaurantMapper.updateByPrimaryKeySelective(restaurant) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public Restaurant getRestaurantById(Integer id) {
        Restaurant Restaurant = restaurantMapper.selectByPrimaryKey(id);
        if (Restaurant == null) {
            EmoExcption.fail(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        return Restaurant;
    }

    @Override
    public Boolean deleteBatch(Long[] ids) {
        if (ids.length < 1) {
            return false;
        }
        // 데이터 삭제
        return restaurantMapper.deleteBatch(ids) > 0;
    }

}
