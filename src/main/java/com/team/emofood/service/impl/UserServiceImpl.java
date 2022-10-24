package com.team.emofood.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.emofood.common.EmoExcption;
import com.team.emofood.common.ServiceResultEnum;
import com.team.emofood.dto.User;
import com.team.emofood.mapper.UserMapper;
import com.team.emofood.service.UserService;
import com.team.emofood.util.PageQueryUtil;
import com.team.emofood.util.PageResult;

import lombok.AllArgsConstructor;

@Service 
public class UserServiceImpl implements UserService  {

    Date time = new Date();

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult getUserPage(PageQueryUtil pageUtil) {
        List<User> UserList = userMapper.findUserList(pageUtil);
        int total = userMapper.getTotalUser(pageUtil);
        PageResult pageResult = new PageResult(UserList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String updateUser(User user) {
        User temp = userMapper.selectByPrimaryKey(user.getUemail());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (userMapper.updateByPrimaryKeySelective(user) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public User getUserById(String id) {
        User User = userMapper.selectByPrimaryKey(id);
        if (User == null) {
            EmoExcption.fail(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        return User;
    }

    @Override
    public Boolean deleteBatch(String[] ids) {
        if (ids.length < 1) {
            return false;
        }
        // 데이터 삭제
        return userMapper.deleteBatch(ids) > 0;
    }
}
