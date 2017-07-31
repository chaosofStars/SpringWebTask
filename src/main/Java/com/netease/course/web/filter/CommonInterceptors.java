package com.netease.course.web.filter;

import com.netease.course.meta.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonInterceptors implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        String requestURI = httpServletRequest.getRequestURI();
        if ("/public".equals(requestURI) || "/edit".equals(requestURI)) {
            if (user.getUserType()!= 1) {
                modelAndView.setViewName("error");
            }
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
