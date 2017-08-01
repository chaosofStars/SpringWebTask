package com.netease.course.web.controller;


import com.netease.course.meta.User;
import com.netease.course.service.impl.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;


@Controller
public class IndexController {
    @Autowired
    IndexService productService;

    @RequestMapping({"/index", "/"})
    public ModelAndView indexView(ModelMap modelMap, HttpSession httpSession) throws UnsupportedEncodingException {
        if (httpSession.getAttribute("user") != null) {
            User user = (User) httpSession.getAttribute("user");
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("productList", productService.listProductByUser(user));
        } else {
            modelMap.addAttribute("productList", productService.listProduct());
        }
        return new ModelAndView("index", modelMap);
    }

}
