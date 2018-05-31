package com.smart.service;

import com.smart.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public boolean hasMatchUser(String userName,String passWord){
        int u=userDao.getMatchCount(userName,passWord);
        return u>0;
    }
}
