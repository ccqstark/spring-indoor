package com.ccqstark.aop;

import com.ccqstark.aop.service.MyCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        MyCalculator myCalculator = ctx.getBean(MyCalculator.class);
        myCalculator.add(3, 4);
        myCalculator.min(3, 4);
    }
}
