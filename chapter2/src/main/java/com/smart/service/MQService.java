package com.smart.service;

import com.rabbitmq.client.api.consumer.ConsumerClient;
import com.rabbitmq.client.api.entry.Message;
import com.rabbitmq.client.api.publisher.PublisherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQService {

    @Autowired
    private PublisherClient publisher;
    @Autowired
    private ConsumerClient testConsumer;
    @Autowired
    private ConsumerClient testConsumer10;

    public void publishMessage(String content){
        Message message=new Message();
        message.setExchange("balala.xiaomoxian.exchange");
        message.setRoutingKey("balala.xiaomoxian.routingKey");
        message.setContent(content);
        try {
            publisher.publish(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMessage(){
        try {
            testConsumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMessage10(){
        try {
            testConsumer10.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
