package edu.java.deipss.sql.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import edu.java.deipss.sql.dal.entity.SchedulingTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineCacheConfig {

    public static final String SCHEDULING_TASK_CACHE = "schedulingTaskCache";

    /**
     * 两种过期方式，
     * expireAfterWrite 写入多长时间后过期
     * expireAfterAccess 读取多长时间后过期
     *
     * @return caffeine 缓存
     */
    @Bean(SCHEDULING_TASK_CACHE)
    public LoadingCache<String, SchedulingTask> initCache() {
        LoadingCache<String, SchedulingTask> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(100)
                .build(k -> new SchedulingTask());
        return cache;
    }
}
