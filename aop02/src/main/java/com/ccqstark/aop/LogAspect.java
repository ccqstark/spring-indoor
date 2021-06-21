package com.ccqstark.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
// 表示这是一个切面
@Aspect
public class LogAspect {

    // 方法统一定义切点
//    @Pointcut("@annotation(Action)")
//    public void pointcut(){
//
//    }

    // 非侵入式
    // 返回值 类/方法 参数
    @Pointcut("execution(* com.ccqstark.aop.service.*.*(..))") // 匹配表达式
    public void pointcut(){

    }

    /**
     * 前置通知，在目标方法执行之前执行
     */
    @Before("pointcut()") // 这里可以写注解，也可以是定义切点的方法
    public void before (JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法开始执行了");
    }

    /**
     * 后置通知，在目标方法执行之后执行
     */
    @After("@annotation(Action)")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法执行结束了");
    }

    /**
     * 返回通知，可以获得目标方法的返回值，有返回值的方法才有返回通知，而且返回参数的类型要匹配
     * 返回类型为void，使用Object返回类型收到null
     */
    @AfterReturning(value = "@annotation(Action)",returning = "r") // 这个r要和下面的参数相同
    public void returning(JoinPoint joinPoint, Integer r){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法的返回通知："+r);
    }

    /**
     * 异常通知，但目标方法抛出异常时，该方法会被触发
     */
    @AfterThrowing(value = "@annotation(Action))",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法的异常通知："+e.getMessage());
    }


    /**
     * 环绕通知，上面四种通知的集大成者，环绕通知的核心类似于在反射中执行方法
     */
    @Around("@annotation(Action)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 这个有点类似于method.invoke方法，我们可以在方法前后分别添加日志，相当于前置/后置通知
        Object proceed = pjp.proceed(new Object[]{5,5});
        return proceed;
    }


}
