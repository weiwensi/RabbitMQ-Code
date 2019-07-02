package com.gysoft.rabbitmqsoft.ack;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description  失败后return 回调
 * @Author DJZ-WWS
 * @Date 2019/7/1 11:22
 */
@Component
public class MsgSendReturnCallback  implements RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("失败后回调"+message.getBody()+"replyCode:"+replyCode+"replyText :"+replyText
        +"exchange :"+exchange +"routingKey:"+routingKey);
    }
}
