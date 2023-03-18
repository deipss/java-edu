package edu.java.deipss.service.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author deipss
 */
@Aspect
@Slf4j
@Component
public class AopConfig {
    /**
     * 1、execution(): 表达式主体。
     * 2、第一个*号：表示返回类型，*号表示所有的类型。
     * 3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，spring.aop.component包、子孙包下所有类的方法。
     * 4、第二个*号：表示类名，*号表示所有的类。
     * 5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
     */
    @Pointcut("execution(* edu.java.deipss.service..*.*(..))")
    public void point() {

    }

    /**
     * @param point 织点
     * @return 结果集
     */
    @Around("point()")
    public Object process(ProceedingJoinPoint point) {
        Object[] args = point.getArgs();
        log.info("aop请求参数={}", args);
        try {
            Object proceed = point.proceed();
            log.info("结果={}",proceed);
            return proceed;
        } catch (Throwable throwable) {
            log.error("调用异常",throwable);
        }
        return null;
    }


}
