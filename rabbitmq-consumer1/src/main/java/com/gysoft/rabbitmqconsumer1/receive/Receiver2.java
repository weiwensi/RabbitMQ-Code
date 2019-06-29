package com.gysoft.rabbitmqconsumer1.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/26 15:34
 */
/*@Component
@RabbitListener(queues = "hello2")*/
public class Receiver2{


   // @RabbitHandler
    public void process(Object message){
        System.out.println("Receiver2 收到消息:"+message);
    }


}