package com.gysoft.rabbitmqsoft.ack;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description  确认消息后回调
 * @Author DJZ-WWS
 * @Date 2019/7/1 11:22
 */
@Component
public class MsgSendConfirmCallBack  implements RabbitTemplate.ConfirmCallback {
    //ConfirmCallback这个接口是当消息成功到达exchange的时候触发ack回调。
    //ReturnCallback 这个接口当消息成功到达exchange，但是没有队列与之绑定的时候触发ack回调。发生网络分区会出现这种情况
    //生产者端使用ConfirmCallBackHereturnCallBanck回调机制，最大限度的保证消息不丢失，对原有CorrelationData类进行扩展，来实现消息的重发
    //callback 是异步的
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(this);            //指定 ConfirmCallback
    }
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("消息唯一标识："+correlationData);
        System.out.println("确认结果："+ack);
        System.out.println("失败原因："+cause);
    }

}
