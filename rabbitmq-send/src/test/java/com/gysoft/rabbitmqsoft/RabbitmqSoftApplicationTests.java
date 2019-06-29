package com.gysoft.rabbitmqsoft;

import com.gysoft.entrity.User;
import com.gysoft.rabbitmqsoft.send.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqSoftApplicationTests {

    @Resource
    private HelloSender helloSender;

    @Test
    public void contextLoads() {
        helloSender.send();
    }
    @Test
    public void manyReceiver(){
        for (int i=0;i<100;i++){
            helloSender.send2(i);
        }
    }
   @Test
    public void testSendObject() {
       User  user=new User();
       user.setPassword("sfsfs");
       user.setUserName("张三");
        helloSender.sendUser(user);
    }

    /**
     * 测试topic模式
     */
    @Test
    public   void  testTopic(){
        helloSender.topicSend1();

    }
    /**
     * 测试发单个 点对点的模式
     */
    @Test
    public  void  testDirect(){
        helloSender.sendDirect();
    }




}
