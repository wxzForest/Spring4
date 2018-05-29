package com.smart.service;

import com.rabbitmq.client.api.consumer.ConsumerManager;
import com.rabbitmq.client.api.entry.Message;
import com.rabbitmq.client.api.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	public boolean hasMatchUser(String userName, String password){
		int matchCount =userDao.getMatchCount(userName, password);
		return matchCount > 0;
	}
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	@Transactional
    public void loginSuccess(User user) {
		user.setCredits( 5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
	}


    /*-------------------------新 M Q 接 入-------------------------------*/
    @Autowired
    private Publisher publisher;
    @Autowired
    private ConsumerManager testConsumer;

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
