package edu.java.deipss.service.config.spring;

import edu.java.deipss.service.config.ThreadConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@AutoConfigureAfter(ThreadConfig.class)
@Slf4j
public class AfterConfig {
    public AfterConfig() {
        log.info("在ThreadConfig类之后配置");
    }

    @PostConstruct
    public void init(){
        log.info("AfterConfig PostConstruct()");
    }


    @Bean
    @ConditionalOnMissingBean(ThreadConfig.class)
    public ThreadConfig threadConfig(){
        log.info("不会执行，因为AfterConfig在ThreadConfig之后了");
        return new ThreadConfig();
    }

    @Bean
    @ConditionalOnBean(ThreadConfig.class)
    public Object object(){
        log.info("会执行，因为需要ThreadConfig");
        return new Object();
    }
}
