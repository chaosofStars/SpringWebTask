package com.netease.course.web.controller;

import com.netease.course.service.impl.EditAndPublicService;
import com.netease.course.service.product.EditProduct;
import com.netease.course.service.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

@Controller
public class EditController {

    private EditAndPublicService productService;

    @Autowired
    public void setProductService(EditAndPublicService productService) {
        this.productService = productService;
    }

    @RequestMapping("/edit")
    public String editView(@RequestParam("id") int productId, ModelMap modelMap) throws UnsupportedEncodingException {
        Product product = productService.getProductById(productId);
        modelMap.addAttribute("product", product);
        return "edit";
    }

    @RequestMapping("/editSubmit")
    public ModelAndView editSubmitView(@RequestParam("id") Integer productId, EditProduct product, ModelMap modelMap) throws UnsupportedEncodingException {
        productService.updateProduct(product);
        modelMap.addAttribute("product", productService.getProductById(productId));
        return new ModelAndView("editSubmit", modelMap);
    }
}
