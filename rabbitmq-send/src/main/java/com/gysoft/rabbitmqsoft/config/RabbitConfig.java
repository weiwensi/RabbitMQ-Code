package com.gysoft.rabbitmqsoft.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/26 15:03
 */
@Configuration
public class RabbitConfig {
   /* @Bean
    public Queue queue() {
        return new Queue("hello");
    }

    @Bean
    public Queue  queue2(){
        return   new Queue("hello2");
    }

    *//**
     * 测试发送对象的队列
     * @return
     *//*
    @Bean
    public Queue  queue3(){
        return   new Queue("object_queue");
    }*/
}
