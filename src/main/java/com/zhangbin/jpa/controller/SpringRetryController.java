package com.zhangbin.jpa.controller;

import com.zhangbin.jpa.retry.RetryAspectDemo;
import com.zhangbin.jpa.retry.RetryDemo;
import com.zhangbin.jpa.retry.RetryStatistic;
import com.zhangbin.jpa.retry.RetryTemplateDefi;
import com.zhangbin.jpa.service.SpringRetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * mark
 *
 * @Author: zhangbin
 * @Date: 2019-01-21 21:31
 * @Version 1.0
 */
@Controller
@RequestMapping("/retry")
public class SpringRetryController {

    @Autowired
    private SpringRetryService springRetryService;

    @Autowired
    private RetryTemplateDefi retryTemplateDefi;

    @Autowired
    private RetryDemo retryDemo;

    @Autowired
    private RetryAspectDemo retryAspectDemo;

    @Autowired
    private RetryStatistic retryStatistic;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        springRetryService.retry();
        return "index";
    }

    @RequestMapping(value = "/index1", method = RequestMethod.GET)
    @ResponseBody
    public String index1() {
        retryTemplateDefi.getTimeoutRetryPolicy();
        return "index1";
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    @ResponseBody
    public String index2() throws InterruptedException {
        retryDemo.retryDemo();
        return "index2";
    }

    @RequestMapping(value = "/index3", method = RequestMethod.GET)
    @ResponseBody
    public String index3() throws Exception {
        retryAspectDemo.retryAspectDemo();
        return "index3";
    }

    @RequestMapping(value = "/index4", method = RequestMethod.GET)
    @ResponseBody
    public String index4() throws Exception {
        retryStatistic.getRetryStatistic();
        return "index4";
    }
}
