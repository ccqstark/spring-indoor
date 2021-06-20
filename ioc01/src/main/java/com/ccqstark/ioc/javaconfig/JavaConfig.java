package com.ccqstark.ioc.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
// 包扫描配置，默认扫这个包以及子包下的所有类
// 不用默认过滤器，可以指定要扫的注解类型
@ComponentScan(basePackages = "com.ccqstark.ioc",useDefaultFilters = false,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Service.class),@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class)})
public class JavaConfig {
    @Bean("sayHola")
    SayHello sayHello(){
        return new SayHello();
    }
}
