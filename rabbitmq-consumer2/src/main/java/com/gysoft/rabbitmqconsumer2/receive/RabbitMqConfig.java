package com.gysoft.rabbitmqconsumer2.receive;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/27 15:11
 */

@Configuration
public class RabbitMqConfig {
    /**
     * 只接一个topic
     */
    final static String message = "topic.message";
    /**
     * 接收多个topic
     */
    final static String messages = "topic.messages";


    /**
     * 队列声明
     *
     * @return
     */
    @Bean
    public Queue queueMessager() {
        return new Queue(RabbitMqConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(RabbitMqConfig.messages);
    }
    @Bean
    public Queue testDirectQueue() {
        return new Queue("testDirectQueue");
    }

    /**
     *声明一个Topic交换机
     *
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    DirectExchange  directExchange(){
        return  new DirectExchange("directExchange");
    }


    /**
     * 测试topic模式
     * @return
     */
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(queueMessager()).to(exchange()).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages() {
        //这里的#表示零个或多个词。
        return BindingBuilder.bind(queueMessages()).to(exchange()).with("topic.#");
    }
    /**
     * 测试点对点的模式
     */
    @Bean
    Binding  bindDirect(){
        return  BindingBuilder.bind(testDirectQueue()).to(directExchange()).with("ddddd");
    }



}
