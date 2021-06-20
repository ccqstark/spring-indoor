package com.ccqstark.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.jvm.hotspot.HelloWorld;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig2.class);
        DataSource d1 = ctx.getBean("d1", DataSource.class);
        System.out.println("d1 = " + d1);

    }

    // xml方式实现多环境配置
    private static void multiplyEnvironmentConfigByXML() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.setConfigLocation("applicationContext.xml");
        ctx.refresh();
        DataSource ds1 = ctx.getBean(DataSource.class);
        DataSource ds2 = ctx.getBean(DataSource.class);
        System.out.println(ds1==ds2);
    }

    // 注解方式实现多环境配置
    private static void multiplyEnvironmentConfigByAnnotation() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.register(JavaConfig.class);
        ctx.refresh();
        DataSource ds1 = ctx.getBean(DataSource.class);
        DataSource ds2 = ctx.getBean(DataSource.class);
        System.out.println(ds1==ds2);
    }


    // 条件注解测试方法
    private static void conditionAnnotationTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ShowCmd cmd = (ShowCmd) ctx.getBean("cmd");
        String s = cmd.showCmd();
        System.out.println("s = " + s);
    }

}
