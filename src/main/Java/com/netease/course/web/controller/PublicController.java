package com.netease.course.web.controller;


import com.netease.course.service.webServiceImpl.EditAndPublicService;
import com.netease.course.meta.product.EditProduct;
import com.netease.course.meta.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;


@Controller
public class PublicController {
    @Autowired
    private EditAndPublicService productService;

    @ModelAttribute("title")
    private void setTitle(ModelMap modelMap) {
        modelMap.addAttribute("title", "发布");
    }

    @RequestMapping(value = "/public")
    public ModelAndView publicSells() {
        return new ModelAndView("public");
    }

    @RequestMapping(value = "/publicSubmit", method = RequestMethod.POST)
    public ModelAndView publicSubmit(EditProduct product,ModelMap modelMap) throws UnsupportedEncodingException {
        Product product1 = productService.saveProduct(product);
        modelMap.addAttribute("product", product1);
        return new ModelAndView("publicSubmit", modelMap);
    }
}
