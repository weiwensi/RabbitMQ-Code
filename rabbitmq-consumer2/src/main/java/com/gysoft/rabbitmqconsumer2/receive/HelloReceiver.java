package com.gysoft.rabbitmqconsumer2.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description  消息监听，接受
 * @Author DJZ-WWS
 * @Date 2019/6/26 15:08
 */
@Component
@RabbitListener(queues = "hello2")  //监听名为hello的queue
public class HelloReceiver {

//消息处理器
    @RabbitHandler
    public   void  process(String  message){
        System.out.println("收到消息，消息内容："+message);
    }

}
