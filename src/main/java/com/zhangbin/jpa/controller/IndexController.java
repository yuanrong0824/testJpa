package com.zhangbin.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * mark
 *
 * @Author: zhangbin
 * @Date: 2019-01-21 21:31
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class IndexController {

    @RequestMapping(value = "login_view",method = RequestMethod.GET)
    public String loginView() {
        return "login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
