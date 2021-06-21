package com.ccqstark.aop.service;

import com.ccqstark.aop.Action;
import com.ccqstark.aop.service.MyCalculator;
import org.springframework.stereotype.Component;

@Component
public class MyCalculatorImpl implements MyCalculator {

    @Override
    @Action
    public Integer add(int a, int b) {
//        int i = 1/0;
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    @Override
//    @Action
    public void min(int a, int b) {
        System.out.println(a + "-" + b + "=" + (a - b));
    }

}
