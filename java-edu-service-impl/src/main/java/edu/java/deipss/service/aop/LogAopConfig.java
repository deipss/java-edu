package edu.java.deipss.service.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * @author deipss
 * @date 2021-07-31
 */
///@Aspect
@Slf4j
///@Component
public class LogAopConfig {

    /**
     *
     * 使用注解的方式来切面
     * @see LogAround
     */
    @Around("@annotation(LogAround)")
    public Object process(ProceedingJoinPoint point,LogAround logAround) {
        Object[] args = point.getArgs();
        log.info("请示参数={}", args);
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }


}
