package com.smart.service;

import com.rabbitmq.client.api.consumer.MessageListener;
import com.rabbitmq.client.api.entry.ConsumeResult;
import com.rabbitmq.client.api.entry.MessageExt;

public class Listener implements MessageListener {

    public ConsumeResult recevieMessage(MessageExt messageExt) {
        if (messageExt.getContent().equals("abc")) {
            System.out.println("retry:"+messageExt.getContent());
            return ConsumeResult.RETRY;
        }
        System.out.println(messageExt.getContent());
        return ConsumeResult.SUCCESS;
    }
}
