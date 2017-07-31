package com.netease.course.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String loginView() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logoutView(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return "login";
    }

}
