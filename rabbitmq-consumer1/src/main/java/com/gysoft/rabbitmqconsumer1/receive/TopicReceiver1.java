package com.gysoft.rabbitmqconsumer1.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/27 15:24
 */

@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver1 {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("TopicReceiver1 :" + msg);
    }
}



