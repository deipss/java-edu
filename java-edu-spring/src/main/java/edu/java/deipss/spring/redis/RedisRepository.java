package edu.java.deipss.spring.redis;

import edu.java.deipss.base.util.TimeUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Component
public class RedisRepository {

    @Resource(name = "defaultRedisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    @Async("executeThreadPoolExecutor")
    public Boolean eduAdd() {
        return Boolean.TRUE.equals(redisTemplate.opsForZSet().add(TimeUtil.formatToday(), String.valueOf(LocalTime.now().getHour()), 1.0));
    }

    @Async("executeThreadPoolExecutor")
    public Boolean exeLua() {
        List<String> keys = Arrays.asList(TimeUtil.formatToday()+"_lua", "hello lua");
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("test.lua")));
        redisScript.setResultType(Boolean.class);
        Boolean execute = redisTemplate.execute(redisScript, keys, "100");
        return execute;
    }
}