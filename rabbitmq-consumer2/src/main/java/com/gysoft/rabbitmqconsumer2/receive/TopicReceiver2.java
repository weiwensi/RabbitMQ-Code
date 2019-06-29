package com.gysoft.rabbitmqconsumer2.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/27 15:24
 */

@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver2 {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("TopicReceiver2:" + msg);
    }

}
