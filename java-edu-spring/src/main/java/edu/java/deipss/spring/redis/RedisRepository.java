package edu.java.deipss.spring.redis;

import edu.java.deipss.base.util.TimeUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalTime;

@Component
public class RedisRepository {

    @Resource(name = "defaultRedisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    @Scheduled(cron = "0/5 * * * * ?")
    @Async("executeThreadPoolExecutor")
    public Boolean eduAdd() {
        return Boolean.TRUE.equals(redisTemplate.opsForZSet().add(TimeUtil.getFormatToday(), String.valueOf(LocalTime.now().getHour()), 1.0));
    }
}