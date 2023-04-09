package edu.java.deipss.sql.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class SpringRedisConfig {

    public static final String DEFAULT_REDIS_TEMPLATE = "defaultRedisTemplate";

    @Bean
    JedisConnectionFactory jedisConnectionFactory( RedisProperties redisProperties) {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        jedisConFactory.setHostName(redisProperties.getHost());
        jedisConFactory.setPassword(redisProperties.getPassword());
        return jedisConFactory;
    }


    @Bean(DEFAULT_REDIS_TEMPLATE)
    public RedisTemplate<String, String> redisTemplate( JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setKeySerializer(StringRedisSerializer.UTF_8);
        template.setValueSerializer(StringRedisSerializer.UTF_8);
        return template;
    }

    @Bean()
    public RedissonClient initRedissonClient(RedisProperties redisProperties){
        Config config = new Config();
        config.useSingleServer()
                .setDatabase(7)
                .setPassword(redisProperties.getPassword())
                .setAddress("redis://"+redisProperties.getHost()+":6379");

        return Redisson.create(config);
    }
}
