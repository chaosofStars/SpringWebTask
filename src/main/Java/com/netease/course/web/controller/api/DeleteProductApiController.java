package com.netease.course.web.controller.api;



import com.netease.course.service.webServiceImpl.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping("/api")
public class DeleteProductApiController {
    private DeleteService productService;

    @Autowired
    public DeleteProductApiController(DeleteService productService) {
        this.productService = productService;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap delete(@RequestParam("id") Integer productId, ModelMap modelMap) throws UnsupportedEncodingException {
        //判断商品是否存在
        if (productService.getProductById(productId) != null) {
            //删除商品
            productService.deleteProduct(productId);
            //判断商品是否删除成功
            if (productService.getProductById(productId) == null) {
                modelMap.addAttribute("code", 200);
                modelMap.addAttribute("message", "success");
                modelMap.addAttribute("result", true);
            } else {
                modelMap.addAttribute("code", 400);
                modelMap.addAttribute("message", "删除失败");
                modelMap.addAttribute("result", false);
            }
        } else {
            modelMap.addAttribute("code", 400);
            modelMap.addAttribute("message", "删除失败,商品不存在");
            modelMap.addAttribute("result", false);
        }
        return modelMap;
    }
}
