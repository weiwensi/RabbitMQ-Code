package com.gysoft.rabbitmqsoft.controller;

import com.gysoft.rabbitmqsoft.send.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/7/2 10:23
 */
@RestController
public class RabbitMQController {

    @Autowired
    HelloSender helloSender;
    @RequestMapping("/ack")
    @ResponseBody
    public String sendAck() {
        helloSender.sendDirect();

    return  "ok";
    }
}
