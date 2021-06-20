package com.ccqstark.ioc;

import com.ccqstark.ioc.javaconfig.JavaConfig;
import com.ccqstark.ioc.javaconfig.SayHello;
import com.ccqstark.ioc.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class JavaConfigTest {
    public  static void main(String[] args) {
        // 注解方式
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        // 这里的"sayHello"是配置类返回对象的方法名,或者@Bean里的名字，相当于xml中的id
        SayHello sayHello = ctx.getBean("sayHola", SayHello.class);
        System.out.println(sayHello.sayHello("ccq"));

        UserService userService = ctx.getBean(UserService.class);
        List<String> allUsers = userService.getAllUsers();
        System.out.println("allUsers=" + allUsers);
    }
}
