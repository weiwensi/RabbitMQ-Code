package com.gysoft.rabbitmqsoft.send;

import com.gysoft.entrity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/26 15:06
 */
@Component
public class HelloSender {


    @Autowired
    private AmqpTemplate amqpTemplate;


    public void send() {
        String context = "hello----" + LocalDateTime.now();
        System.out.println("send:" + context);
        //往名称为 hello 的queue中发送消息
        this.amqpTemplate.convertAndSend("hello", context);
    }

    /**
     * 给hello队列发送消息
     */
    public void send2(int i) {
        String context = i + "";
        System.out.println(context + "--send:");
        this.amqpTemplate.convertAndSend("hello2", context);
    }

    /**
     * 发送对象给消费者
     * @param user
     */
    public void sendUser(User user) {
        System.out.println("Send object:" + user.toString());

        this.amqpTemplate.convertAndSend("object_queue", user);

    }


    public void  topicSend1() {
        String context = "my topic 1";
        System.out.println("发送者说 : " + context);
        amqpTemplate.convertAndSend("exchange", "topic.message", context);
    }


    public   void sendDirect(){
        String  context="66666666666666666666666666666666666666";
        System.out.println("开始发送消息消息内容："+context+"现在的时间是：");
        amqpTemplate.convertAndSend("directExchange","ddddd",context);
    }



}
