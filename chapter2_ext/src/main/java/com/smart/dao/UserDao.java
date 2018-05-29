package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static String MATCH_COUNT_SQL="select count(user_id) from t_user where user_name=? and password=?";

    public int getMatchCount(String username,String password){
        String[] parameters={username,password};
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL,parameters,Integer.class);
    }
}
