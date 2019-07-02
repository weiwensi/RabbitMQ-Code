package com.gysoft.rabbitmqconsumer2.receive;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/28 16:39
 */
@Component
@RabbitListener(queues = "testDirectQueue")
public class DirectListener   {

@Autowired
    RabbitTemplate  rabbitTemplate;

    //消息处理器
    @RabbitHandler
    public   void  process(String  message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long  tag,Message me) throws IOException {
        System.out.println("Direct收到消息，消息内容："+message+"me:------->"+me);
        //确认消息已经消费成功
        //告诉服务器收到这条消息，已经被我消费了，可以在队列删掉，这样以后就不会再发了，否侧消息服务器会以为没有收到消息
       channel.basicAck(me.getMessageProperties().getDeliveryTag(),false);

        System.out.println("消息确认机制已经开启");

    }


}
