package edu.java.deipss.service.config.spring;

import edu.java.deipss.service.config.ThreadConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@AutoConfigureAfter(ThreadConfig.class)
@Slf4j
public class BeforeConfig {
    public BeforeConfig() {
        log.info("在ThreadConfig类之前配置");
    }


    @PostConstruct
    public void init(){
        log.info("BeforeConfig PostConstruct()");
    }

//    @Autowired
//    public void autowired(@Value("${JAVA_HOME}" ) String javaHome){
//        log.info("autowired");
//    }
}
