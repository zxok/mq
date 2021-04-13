package com.smart.mq.msg.impl;

import com.smart.mq.msg.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * RocketMQTemplate  直接使用
 * @author Hzx
 *  生产者
 */
@Service
@Slf4j
public class ProducerServiceImpl implements ProducerService {
    @Value("${rocketmq.topic}")
    String topic;
    /**
     *
     */
    @Resource
    RocketMQTemplate mqTemplate;

    /**
     * 主题
     */
    @Override
    public void sendMsg() {
        /*
         * 使用异步消息
         * 异步
         * 发送消息的方式
         * String destination,
         * Message<?> message,
         * SendCallback sendCallback,
         * long timeout, 发送的超时时间
         * int delayLevel  默认值为“1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h”
         * 延迟消息  订单状态 30  取消订单  修改订单状态
         */
        // 分析问题
        mqTemplate.asyncSend(topic, "hello rocketmq-producer", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info(sendResult.getSendStatus() +"");
            }

            @Override
            public void onException(Throwable throwable) {
                log.info(throwable.getMessage());
            }
        });

    }
}
