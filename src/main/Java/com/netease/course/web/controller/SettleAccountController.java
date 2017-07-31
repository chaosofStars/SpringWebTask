package com.netease.course.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SettleAccountController {
    @RequestMapping("/settleAccount")
    public String settleAccount() {
        return "settleAccount";
    }
}
