package com.ccqstark.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    // 条件注解，根据条件不同选择不同的实现或bean，用@Conditional指定不同的条件类
    @Bean("cmd")
    @Conditional(WindowCondition.class)
    ShowCmd winCmd(){
        return new WindowShowCmd();
    }

    @Bean("cmd")
    @Conditional(MacCondition.class)
    ShowCmd macCmd(){
        return new MacShowCmd();
    }

}
