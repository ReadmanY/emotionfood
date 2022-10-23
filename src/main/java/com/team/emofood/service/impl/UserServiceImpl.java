package com.team.emofood.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private UserMapper UserMapper;

    @Override
    public PageResult getUserPage(PageQueryUtil pageUtil) {
        List<User> UserList = UserMapper.findUserList(pageUtil);
        int total = UserMapper.getTotalUser(pageUtil);
        PageResult pageResult = new PageResult(UserList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }


}
