package com.team.emofood.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.team.emofood.common.config.intercepter.AdminLoginInterceptor;
import com.team.emofood.common.config.intercepter.LoginInterceptor;



@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;
    @Autowired
    private LoginInterceptor LoginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        // /admin 접두사가 붙은 url 경로에 인터셉터 추가
        // 백엔드 로그인 인터셉터 (AdminLoginInterceptor)
        /*registry.addInterceptor(adminLoginInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/dist/**")
                .excludePathPatterns("/admin/plugins/**");*/

        // 프론트엔드 로그인 인터셉터
        registry.addInterceptor(LoginInterceptor)
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/dist/**")
                .excludePathPatterns("/user/plugins/**");
    }
}
