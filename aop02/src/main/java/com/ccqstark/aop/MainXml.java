package com.ccqstark.aop;

import com.ccqstark.aop.service.MyCalculator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyCalculator myCalculator = ctx.getBean(MyCalculator.class);
        myCalculator.add(3, 4);
        myCalculator.min(3, 4);
    }
}
