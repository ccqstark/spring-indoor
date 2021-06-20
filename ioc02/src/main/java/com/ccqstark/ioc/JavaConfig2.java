package com.ccqstark.ioc;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ImportResource;

@Configurable
// 混合配置，相当于在Java配置这里引入xml配置
@ImportResource("classpath:applicationContext.xml")
public class JavaConfig2 {

}
