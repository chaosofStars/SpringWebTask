package com.netease.course.web.controller;


import com.netease.course.meta.User;
import com.netease.course.service.impl.ShowService;
import com.netease.course.service.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;



@Controller
public class ShowController {
    ShowService productService;

    @Autowired
    public ShowController(ShowService productService) {
        this.productService = productService;
    }

    @RequestMapping("/show")
    public ModelAndView showView(HttpSession httpSession, ModelMap modelMap, @RequestParam("id") int productId) throws UnsupportedEncodingException {
        Product product = productService.getProductById(productId);
        //判断是否登录
        if (httpSession.getAttribute("user") != null) {
            //从session中得到User对象
            User user = (User) httpSession.getAttribute("user");
            Product product1 = productService.getProductByUser(product, user);
            modelMap.addAttribute("product", product1);
            modelMap.addAttribute("user", user);
        } else {
            modelMap.addAttribute("product", product);
        }

        return new ModelAndView("show", modelMap);
    }
}
