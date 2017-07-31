package com.netease.course.web.controller;





import com.netease.course.meta.User;
import com.netease.course.service.impl.AccountService;
import com.netease.course.service.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
public class AccountController {
    @Autowired
    private AccountService productService;

    @RequestMapping("/account")
    public ModelAndView acountView(ModelMap modelMap, HttpSession httpSession) throws UnsupportedEncodingException {
        if (httpSession.getAttribute("user") != null) {
            User user = (User) httpSession.getAttribute("user");
            List<Product> products = productService.getProductsByUser(user);
            modelMap.addAttribute("buyList", products);
            modelMap.addAttribute("user", user);
        }
        return new ModelAndView("account", modelMap);
    }
}
