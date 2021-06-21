package com.ccqstark.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 事务的注解
    @Transactional
    public void updateMoney(){
        jdbcTemplate.update("update money set money=money-500 where username = ?","ccq");
        int i = 1/0;
        jdbcTemplate.update("update money set money=money+500 where username = ?","cys");
    }

}
