package com.team.emofood.controller.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.team.emofood.dto.User;

public class AccountContext extends User{
    private User user;

    public AccountContext(User user, Collection<? extends GrantedAuthority> authorities) {
        super();
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
