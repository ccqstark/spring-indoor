package com.ccqstark.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class JavaConfig {

    // 条件注解，根据条件不同选择不同的实现或bean，用@Conditional指定不同的条件类
    @Bean("cmd")
    @Conditional(WindowCondition.class)
    ShowCmd winCmd() {
        return new WindowShowCmd();
    }

    @Bean("cmd")
    @Conditional(MacCondition.class)
    ShowCmd macCmd() {
        return new MacShowCmd();
    }


    // 多环境切换用@Profile配置环境信息
    @Bean
    @Profile("dev")
    DataSource devDs() {
        DataSource ds = new DataSource();
        ds.setUrl("jdbc:mysql://dev");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    @Profile("prod")
    DataSource prodDs() {
        DataSource ds = new DataSource();
        ds.setUrl("jdbc:mysql://prod");
        ds.setUsername("crud");
        ds.setPassword("crud");
        return ds;
    }

}
