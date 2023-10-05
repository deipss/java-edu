package edu.java.deipss.sql.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import edu.java.deipss.sql.dal.entity.scheduling.SchedulingTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
@Slf4j
public class CaffeineCacheConfig {


    public static final String SCHEDULING_TASK_CACHE = "schedulingTaskCache";
    public static final String GENERAL_CACHE = "generalCache";
    public static final String DEFAULT_SCHEDULING_TASK = "defaultSchedulingTask";


    /**
     * 两种过期方式，
     * expireAfterWrite 写入多长时间后过期
     * expireAfterAccess 读取多长时间后过期
     *
     * @return caffeine 缓存
     */
    @Bean(DEFAULT_SCHEDULING_TASK)
    public LoadingCache<String, SchedulingTask> initCache() {
        LoadingCache<String, SchedulingTask> cache = Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).maximumSize(100).build(k -> new SchedulingTask());
        return cache;
    }

    @Bean
    @Primary
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCacheNames(Arrays.asList(
                SCHEDULING_TASK_CACHE, GENERAL_CACHE
        ));
        cacheManager.setCaffeine(caffeineCacheBuilder());
        return cacheManager;
    }

    Caffeine<Object, Object> caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(1)
                .maximumSize(1)
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .recordStats();
    }

}
