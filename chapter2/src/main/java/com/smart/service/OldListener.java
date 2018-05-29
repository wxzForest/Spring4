package com.smart.service;

import com.zhubajie.messagequeuesdk.consumer.ConsumeResult;
import com.zhubajie.messagequeuesdk.consumer.MessageListener;
import com.zhubajie.messagequeuesdk.message.MessageExt;

public class OldListener implements MessageListener{
    public ConsumeResult recevieMessage(MessageExt messageExt) {
        System.out.println(messageExt.getContent());
        return ConsumeResult.SUCCESS;
    }
}
