package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration("classpath*:/smart-context.xml")
public class MQTest  extends AbstractTransactionalTestNGSpringContextTests {

    /*------------------------新 MQ 测 试------------------------*/
    @Autowired
    private MQService mqService;

    @Test
    public void publish(){
        mqService.publishMessage("abcd");
    }

    @Test
    public void getMessage(){
       // System.out.println("bobo");
        mqService.getMessage();
    }

    @Test
    public void getMessage10(){
       // System.out.println("10");
        mqService.getMessage10();
    }

    /*------------------------旧 MQ 测 试-----------------------*/
    @Autowired
    private OldMQService oldMQService;

    @Test
    public void oldPublish(){
        oldMQService.oldPublish();
    }

    @Test
    public void oldGetMessage(){
        oldMQService.oldGetMessage();
    }

    @Test
    public void oldGetMessage2(){
        oldMQService.oldGetMessage2();
    }
}