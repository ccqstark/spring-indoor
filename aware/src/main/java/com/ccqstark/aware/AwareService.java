package com.ccqstark.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 使用aware会提高Spring耦合度，但是问题不大
@Service
@PropertySource(value = "ccqstark.properties")
public class AwareService implements BeanNameAware, BeanFactoryAware, ResourceLoaderAware, EnvironmentAware {

    private String beanName;
    private ResourceLoader resourceLoader;
    private Environment environment;

    /**
     * 获取bean的生成工厂
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    /**
     * 获取bean的名字
     */
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void output () throws IOException {
        System.out.println(beanName);

        Resource resource = resourceLoader.getResource("ccq.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String s = br.readLine();
        System.out.println("s = " + s);
        br.close();

        String address = environment.getProperty("ccq.address");
        System.out.println("address = " + address);
    }

}
