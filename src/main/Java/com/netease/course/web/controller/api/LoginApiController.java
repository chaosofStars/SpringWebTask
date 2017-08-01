package com.netease.course.web.controller.api;

import com.netease.course.meta.User;
import com.netease.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api")
public class LoginApiController {
    UserService userService;

    @Autowired
    public LoginApiController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap login(User user, ModelMap modelMap, HttpSession httpSession) {
        //判断是否登录
        if (userService.isLogin(user)) {
            modelMap.addAttribute("code", 200);
            modelMap.addAttribute("message", "success");
            modelMap.addAttribute("result", true);
            user = userService.getUserByName(user.getUserName());
            //登录成功后，创建session
            httpSession.setAttribute("user", user);
        } else {
            modelMap.addAttribute("code", 400);
            modelMap.addAttribute("message", "failed");
            modelMap.addAttribute("result", false);
        }
        return modelMap;
    }
}
