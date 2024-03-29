package edu.java.deipss.service.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

/**
 * 用于AOP拦截
 *
 * @author deipss
 * @see java.lang.annotation.Annotation
 * @since 2021-07-31
 */
@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisLockAround {

    String lockedKey();

    int timeout() default 3000;
}
