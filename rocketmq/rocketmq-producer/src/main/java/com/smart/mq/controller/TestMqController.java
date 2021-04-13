package com.smart.mq.controller;

import com.smart.mq.msg.ProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * http://:8087/
 * 普通的异步消息
 */
@RestController
public class TestMqController {
    @Resource
    ProducerService service;

    @GetMapping("/send")
    public String sendMsg() {
        service.sendMsg();
        return "success";
    }
}
