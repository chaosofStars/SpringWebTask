package com.netease.course.web.controller.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netease.course.meta.User;
import com.netease.course.service.webServiceImpl.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/api")
public class BuyProductApiController {
    private BuyService productService;

    @Autowired
    public BuyProductApiController(BuyService productService) {
        this.productService = productService;
    }


    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap buy(@RequestBody String data, ModelMap modelMap, HttpSession httpSession) {
        //判断是否登陆，user ！= null
        if (httpSession.getAttribute("user") != null) {
            User user = (User) httpSession.getAttribute("user");
            int userId = user.getUserId();

            //获取数据
            List<JSONObject> jsonObjectList = JSON.parseArray(data, JSONObject.class);

            for (JSONObject jsonObject : jsonObjectList) {
                String id = jsonObject.getString("id");
                String number = jsonObject.getString("number");
                //保存交易记录
                productService.saveTransaction(Integer.valueOf(id),Integer.valueOf(number), userId);
            }

            //返回成功响应
            modelMap.addAttribute("code", 200);
            modelMap.addAttribute("message", "success");
            modelMap.addAttribute("result", true);
        } else {
            modelMap.addAttribute("code", 400);
            modelMap.addAttribute("message", "failed");
            modelMap.addAttribute("result", false);
        }

        return modelMap;
    }
}
