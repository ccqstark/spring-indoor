package com.ccqstark.aop;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyCalculatorImpl implements MyCalculator {

    @Override
    @Action
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    @Action
    public void min(int a, int b) {
        System.out.println(a + "-" + b + "=" + (a - b));
    }

}
