package edu.java.deipss.event.job;

import edu.java.deipss.service.test.domain.event.QueryEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class QueryEventPublishJob implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;


    @Scheduled(cron = "0/15 * * * * ?")
    @Async("executeThreadPoolExecutor")
    public void execute() {
        // 发布一个事件
        applicationContext.publishEvent(new QueryEvent(new QueryEvent.QueryEventData("查询事件", "数据")));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet()方法调用");
    }

    @PostConstruct
    public void postConstruct(){
        log.info("postConstruct()");
    }

}
