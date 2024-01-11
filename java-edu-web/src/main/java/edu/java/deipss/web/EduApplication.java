package edu.java.deipss.web;

import org.apache.dubbo.spring.boot.autoconfigure.DubboAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DubboAutoConfiguration.class})
@ComponentScan("edu.java.deipss")
@EnableConfigurationProperties
@EnableAspectJAutoProxy(exposeProxy = true)
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
