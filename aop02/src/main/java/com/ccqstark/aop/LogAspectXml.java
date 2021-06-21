package com.ccqstark.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

// xml配置实现aop
public class LogAspectXml {

    /**
     * 前置通知，在目标方法执行之前执行
     */
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法开始执行了");
    }

    /**
     * 后置通知，在目标方法执行之后执行
     */
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法执行结束了");
    }

    /**
     * 返回通知，可以获得目标方法的返回值，有返回值的方法才有返回通知，而且返回参数的类型要匹配
     * 返回类型为void，使用Object返回类型收到null
     */
    public void returning(JoinPoint joinPoint, Integer r) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法的返回通知：" + r);
    }

    /**
     * 异常通知，但目标方法抛出异常时，该方法会被触发
     */
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法的异常通知：" + e.getMessage());
    }


    /**
     * 环绕通知，上面四种通知的集大成者，环绕通知的核心类似于在反射中执行方法
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 这个有点类似于method.invoke方法，我们可以在方法前后分别添加日志，相当于前置/后置通知
        Object proceed = pjp.proceed(new Object[]{5, 5});
        return proceed;
    }

}
