package com.ccqstark.aop;

public class Main {
    public static void main(String[] args) {
        MyCalculatorImpl myCalculator = new MyCalculatorImpl();
        //获得代理对象
        MyCalculator calculator = (MyCalculator) CalculatorProxy.getInstance(myCalculator);
        // 使用代理对象调用方法
        int add = calculator.add(3,4);
        System.out.println(add);
    }
}
