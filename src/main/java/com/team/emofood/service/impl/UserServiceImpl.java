package com.team.emofood.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.emofood.controller.vo.AccountContext;
import com.team.emofood.dto.User;
import com.team.emofood.mapper.UserMapper;
import com.team.emofood.service.UserService;
import com.team.emofood.util.PageQueryUtil;
import com.team.emofood.util.PageResult;

import lombok.AllArgsConstructor;

// DB에 연동되게끔 하는 곳
@AllArgsConstructor
@Service("userDetailsService")  // 빈 등록하기
public class UserServiceImpl implements UserService, UserDetailsService  {

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

    @Transactional
    public void joinUser(User user){
        user.setUemail(user.getUemail());
        user.setUname(user.getUname());
        user.setUpw(user.getUpw());
        user.setUgend(user.getUgend());
        user.setUage(user.getUage());
        user.setUjoindate(time);
        UserMapper.saveUser(user);
    }

    @Override
    public User loadUserByUsername(String userId) {

        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        User user = UserMapper.getUserAccount(userId);
       
        List<GrantedAuthority> roles = new ArrayList<>();
        if(user.getUage()==9){
            roles.add(new SimpleGrantedAuthority("ADMIN"));}
        else{
            roles.add(new SimpleGrantedAuthority("USER"));}

        AccountContext accountContext = new AccountContext(user, roles);

        return user;
    }

}
