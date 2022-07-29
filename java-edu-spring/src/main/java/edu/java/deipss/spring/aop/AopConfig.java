package edu.java.deipss.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author deipss
 * @date 2021-07-31
 */
@Aspect
@Slf4j
@Component
public class AopConfig {
    /**
     * 1、execution(): 表达式主体。
     * <p>
     * 2、第一个*号：表示返回类型，*号表示所有的类型。
     * <p>
     * 3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，spring.aop.component包、子孙包下所有类的方法。
     * <p>
     * 4、第二个*号：表示类名，*号表示所有的类。
     * <p>
     * 5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
     */
    @Pointcut("execution(* edu.deipss.springer.service.*.*(..))")
    public void point() {

    }

    /**
     * @param point
     * @return
     */
    @Around("point()")
    public Object process(ProceedingJoinPoint point) {
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