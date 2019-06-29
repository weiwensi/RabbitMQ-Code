package com.gysoft.rabbitmqconsumer1.receive;

import com.gysoft.entrity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/26 15:44
 */
@Component
@RabbitListener(queues = "object_queue")
public class UserListener {
 @RabbitHandler
    public void process(User user){
        System.out.println("用户消费者 收到消息:"+user.toString());
    }

}
