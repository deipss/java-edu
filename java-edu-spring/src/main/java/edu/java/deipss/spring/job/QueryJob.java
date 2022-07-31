package edu.java.deipss.spring.job;

import edu.java.deipss.spring.service.MapperQueryService;
import edu.java.deipss.sql.dal.entity.SchedulingTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

///@Component
@Slf4j
public class QueryJob {

    @Autowired
    private MapperQueryService mapperQueryService;

    @Scheduled(cron = "0/5 * * * * ?")
    @Async("executeThreadPoolExecutor")
    public void execute() {
        List<SchedulingTask> query = mapperQueryService.query();
        log.info("执行查询结果={}",query);
    }
}
