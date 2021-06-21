package com.ccqstark.jdbc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class JavaConfig {
    @Bean
    DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
          dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
          dataSource.setUrl("xxxxxxxxxxxxx");
          dataSource.setUsername("root");
          dataSource.setPassword("xxxxxxxxxx");
          return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

}
