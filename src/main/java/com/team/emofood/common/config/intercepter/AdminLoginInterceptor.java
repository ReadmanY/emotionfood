package com.team.emofood.common.config.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.team.emofood.common.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Admin 인증 및 권한 제어
// 실제 controller(handler)가 실행되기 전에 실행
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (null == request.getSession().getAttribute(Constants.ADMIN_SESSION_KEY)) {
            response.sendRedirect(request.getContextPath() + "/index");
            return false;
        } else {
            return true;
        }
    }

    // handler가 실행된 후에 실행
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }
    
    // 전체 요청이 끝나고 난 후 마지막에 실행
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
