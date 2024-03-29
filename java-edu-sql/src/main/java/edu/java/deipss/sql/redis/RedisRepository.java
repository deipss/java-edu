package edu.java.deipss.sql.redis;

import edu.java.deipss.common.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static edu.java.deipss.sql.config.SpringRedisConfig.DEFAULT_REDIS_TEMPLATE;

@Repository
@Slf4j
public class RedisRepository {


    private DefaultRedisScript<Boolean> redisScript;
    @Resource(name = DEFAULT_REDIS_TEMPLATE)
    private RedisTemplate<String, String> redisTemplate;

    @PostConstruct
    public void initRedisScript() {
        redisScript = new DefaultRedisScript<>();
        // redis 脚本执行
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("test.lua")));
        redisScript.setResultType(Boolean.class);
        log.info("redis script initialled");
    }

    @Async("executeThreadPoolExecutor")
    public Boolean eduAdd() {
        return Boolean.TRUE.equals(redisTemplate.opsForZSet().add(TimeUtil.formatToday(), String.valueOf(LocalTime.now().getHour()), 1.0));
    }

    @Async("executeThreadPoolExecutor")
    public Boolean exeLua() {
        List<String> keys = Arrays.asList(TimeUtil.formatToday() + "_lua", "hello lua");
        Boolean execute = redisTemplate.execute(redisScript, keys, "100");
        return execute;
    }
}