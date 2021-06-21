package com.ccqstark.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
// 表示这是一个切面
@Aspect
public class LogAspect {

    /**
     * 前置通知
     */
    @Before("@annotation(Action)")
    public void before (JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法开始执行了");
    }



}
