package com.smart.mq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 实现 Listener接口
 * 使用注解
 */
@Component
@Slf4j
//topic（主题），consumerGroup（消费者分组）
@RocketMQMessageListener(consumerGroup = "test-group", topic = "hello-topic")
public class CustomListener implements RocketMQListener<String> {
//    @Resource
//    TestService testService;

    @Override
    public void onMessage(String msg) {
        log.info(msg);
//        testService.save(msg);
    }
}
