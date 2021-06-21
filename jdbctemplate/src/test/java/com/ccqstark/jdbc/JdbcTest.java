package com.ccqstark.jdbc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTest {

    JdbcTemplate jdbcTemplate;
    AccountService accountService;

    @Before
    public void before(){
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        accountService = ctx.getBean(AccountService.class);
    }

    @Test
    public void test1(){
        // jdbcTemplate的增删改都是用update方法
        jdbcTemplate.update("insert into user(user_id, username, password, email, role) values (?,?,?,?,?)",
                998,"ccqjdbc","abbababababa","ccqstark@qq.com",0);
    }

    // CRUD省略

    @Test
    public void test2() {
        accountService.updateMoney();
    }

}
