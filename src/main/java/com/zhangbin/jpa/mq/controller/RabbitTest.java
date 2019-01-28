package com.zhangbin.jpa.mq.controller;

import com.zhangbin.jpa.mq.produce.CallBackSender;
import com.zhangbin.jpa.mq.produce.HelloSender1;
import com.zhangbin.jpa.mq.produce.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private CallBackSender callBackSender;

    @PostMapping("/hello")
    public void hello() {
        helloSender1.send();
    }

    @PostMapping("/hello2")
    public void hello2() {
        helloSender1.send("hello1");
    }

    @PostMapping("/oneToMany")
    public void oneToMany() {
        for (int i = 0; i < 10; i++) {
            helloSender1.send("hello2");
        }
    }

    /**
     * topic exchange类型rabbitmq测试
     */
    @PostMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }

    @PostMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }
}