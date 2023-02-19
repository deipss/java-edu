package edu.java.deipss.service.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "local.dubbo",havingValue = "true")
@EnableDubbo(scanBasePackages={"edu.java.deipss.service.dubbo"})
public class DubboConfig {
}
