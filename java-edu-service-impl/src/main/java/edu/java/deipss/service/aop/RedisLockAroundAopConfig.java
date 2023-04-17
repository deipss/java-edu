package edu.java.deipss.service.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author deipss
 * @date 2021-07-31
 */
@Aspect
@Slf4j
@Component
public class RedisLockAroundAopConfig {


    @Autowired
    private RedissonClient redissonClient;

    /**
     * 使用注解的方式来切面
     *
     * @see RedisLockAround
     */

    @Around("@annotation(redisLockAround)")
    public Object process(ProceedingJoinPoint point, RedisLockAround redisLockAround) {
        String lockedKey = redisLockAround.lockedKey();
        String clazz = point.getSignature().getDeclaringType().getName();
        String methodName = point.getSignature().getName();
        RLock fairLock = redissonClient.getLock(lockedKey);
        try {
            if (fairLock.tryLock(3,60, TimeUnit.SECONDS)) {
                Object[] args = point.getArgs();
                log.info("上锁成功方法参数={}", args);
                return point.proceed();
            }
            log.info("上锁失败,key={},clazz={},method={}",lockedKey,clazz,methodName);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fairLock.unlock();
                log.info("锁释放成功,key={}",lockedKey);
            }catch (Exception e){
                log.error("锁释放失败,key={}",lockedKey);
            }
        }
        return null;
    }

}
