package edu.java.deipss.spring.job;

import edu.java.deipss.spring.event.QueryEvent;
import edu.java.deipss.spring.service.MapperQueryService;
import edu.java.deipss.sql.dal.entity.SchedulingTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class QueryEventPublishJob {

    @Autowired
    private ApplicationContext applicationContext;


    @Scheduled(cron = "0/15 * * * * ?")
    @Async("executeThreadPoolExecutor")
    public void execute() {
        applicationContext.publishEvent(new QueryEvent(new QueryEvent.QueryEventData("查询事件", "数据")));
    }
}
