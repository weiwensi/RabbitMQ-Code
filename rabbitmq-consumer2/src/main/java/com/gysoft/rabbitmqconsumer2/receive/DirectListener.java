package com.gysoft.rabbitmqconsumer2.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/28 16:39
 */
@Component
@RabbitListener(queues = "testDirectQueue")
public class DirectListener {


    //消息处理器
    @RabbitHandler
    public   void  process(String  message){
        System.out.println("Direct收到消息，消息内容："+message);
    }
}
