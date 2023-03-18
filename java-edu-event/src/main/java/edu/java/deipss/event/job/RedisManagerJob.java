package edu.java.deipss.event.job;

import edu.java.deipss.sql.redis.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisManagerJob {

    @Autowired
    private RedisRepository redisRepository;


    @Scheduled(cron = "0/5 * * * * ?")
    @Async("executeThreadPoolExecutor")
    public void runHoursAdd() {
        Boolean aBoolean = redisRepository.eduAdd();
        log.info("redis定时runHoursAdd任务执行结果={}",aBoolean);
    }

    @Scheduled(cron = "0/5 * * * * ?")
    @Async("executeThreadPoolExecutor")
    public void runHoursAddMeanwhile() {
        Boolean aBoolean = redisRepository.eduAdd();
        log.info("redis定时runHoursAddMeanwhile任务执行结果={}",aBoolean);
    }

}
