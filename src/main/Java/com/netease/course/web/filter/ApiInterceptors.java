package com.netease.course.web.filter;

import com.netease.course.meta.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiInterceptors implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        String requestURI = httpServletRequest.getRequestURI();
        if (!"/api/login".equals(requestURI)) {
            if (user == null) {
                modelAndView.setViewName("error");
            }
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
