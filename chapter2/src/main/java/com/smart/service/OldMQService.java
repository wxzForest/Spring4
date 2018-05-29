package com.smart.service;

import com.zhubajie.messagequeuesdk.consumer.ConsumeManager;
import com.zhubajie.messagequeuesdk.message.Message;
import com.zhubajie.messagequeuesdk.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OldMQService {

    @Autowired
    Publisher myPublish;
    @Autowired
    ConsumeManager userManager;
    @Autowired
    ConsumeManager userManager2;

    public void oldPublish(){
        Message message=new Message();
        message.setRoutingKey("wxz01.pub.routingKey");
        message.setExchange("wxz01.pub.exchange");
        message.setContent("oldPublish");
        try {
            myPublish.publish(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void oldGetMessage(){
        try {
            userManager.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void oldGetMessage2(){
        try {
            userManager2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}