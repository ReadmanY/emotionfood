package com.team.emofood.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.emofood.common.Constants;
import com.team.emofood.common.EmoExcption;
import com.team.emofood.common.ServiceResultEnum;
import com.team.emofood.dto.User;
import com.team.emofood.mapper.UserMapper;
import com.team.emofood.service.UserService;
import com.team.emofood.util.BeanUtil;
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

    @Override
    public String register(User user) {
        if (userMapper.selectByPrimaryKey(user.getUemail()) != null) {
            return ServiceResultEnum.SAME_LOGIN_NAME_EXIST.getResult();
        }
        User registerUser = new User();
        BeanUtil.copyProperties(user, registerUser);
        if (userMapper.insertSelective(registerUser) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String login(String loginEmail, String password, HttpSession httpSession) {
        User user = userMapper.selectByloginEmailAndPasswd(loginEmail, password);
        if (user != null && httpSession != null) {
            // 유저 세션
            User tmpUser = new User();
            BeanUtil.copyProperties(user, tmpUser);
            if(tmpUser.getUage()==9){
                httpSession.setAttribute(Constants.ADMIN_SESSION_KEY, tmpUser);
                httpSession.setMaxInactiveInterval(60 * 60 * 2);
            }
            httpSession.setAttribute(Constants.USER_SESSION_KEY, tmpUser);
            // session 만료 시간을 2시간으로 설정
            httpSession.setMaxInactiveInterval(60 * 60 * 2);
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.LOGIN_ERROR.getResult();
    }
}
