package com.ccqstark.aop;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
// 开启自动代理
@EnableAspectJAutoProxy
public class JavaConfig {

}
