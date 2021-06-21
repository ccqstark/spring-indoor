package com.ccqstark.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 代理类
public class CalculatorProxy {
    public static Object getInstance (MyCalculator myCalculator){
        // classLoader，class的getInterfaces，还有InvocationHandler
        return Proxy.newProxyInstance(CalculatorProxy.class.getClassLoader(), myCalculator.getClass().getInterfaces(), new InvocationHandler() {
           /**
            * @Param proxy 代理对象
            * @Param method 代理的方法
            * @Param args 方法的参数
            * @return 方法的返回值
            * @throws Throwable
            */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + "方法开始执行了");
                // 原方法的调用
                Object invoke = method.invoke(myCalculator,args);
                System.out.println(method.getName() + "方法执行结束了");
                return invoke;
            }
        });
    }
}
