package edu.java.deipss.spring.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author deipss
 * @date 2021-07-31
 */
@Aspect
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
     *
     * @param point
     */
    @Around("execution(* edu.deipss.springer.service.*.*(..))")
    public Object run(ProceedingJoinPoint point) {
        System.out.println("AOP拦截 run()");

        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Order(1)
    public Object log(ProceedingJoinPoint point) {
        System.out.println("AOP拦截 log()");

        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }


}
