package com.ccqstark.jdbc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTest {

    JdbcTemplate jdbcTemplate;

    @Before
    public void before(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
    }

    @Test
    public void test1(){
        // jdbcTemplate的增删改都是用update方法
        jdbcTemplate.update("insert into user(user_id, username, password, email, role) values (?,?,?,?,?)",
                998,"ccqjdbc","abbababababa","ccqstark@qq.com",0);
    }

    // CRUD省略

}
