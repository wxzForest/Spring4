package com.smart.service;


import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.api.consumer.ConsumerManager;
import com.rabbitmq.client.api.entry.Message;
import com.rabbitmq.client.api.publisher.Publisher;
import com.smart.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    private Publisher publisher;

    @Autowired
    private ConsumerManager testConsumer;

    public boolean hasMatchUser(String userName,String passWord){
        int u=userDao.getMatchCount(userName,passWord);
        return u>0;
    }

    public void publishMessage(){
        Message message=new Message();
        message.setExchange("balala.xiaomoxian.exchange");
        message.setRoutingKey("balala.xiaomoxian.routingKey");
        message.setContent("Hellodawdawd");
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
}
