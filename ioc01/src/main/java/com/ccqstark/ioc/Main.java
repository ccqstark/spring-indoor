package com.ccqstark.ioc;

import com.ccqstark.ioc.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        //不常用
        //FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("/Users/ccqstark/Code/spring-indoor/ioc01/src/main/resources/applicationContext.xml");

        // 常用
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        User u4 = ctx.getBean("user4", User.class);
        System.out.println("u4 = " + u4);

    }

    public static void getBeans(ClassPathXmlApplicationContext ctx) {

        // 获取bean的方法
        User u1 = (User) ctx.getBean("user");
        User u2 = ctx.getBean("user", User.class);
        User u3 = ctx.getBean(User.class);

        System.out.println("u1=" + u1);
        System.out.println("u2=" + u2);
        System.out.println("u3=" + u3);

    }

}
