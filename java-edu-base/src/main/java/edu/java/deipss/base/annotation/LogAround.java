package edu.java.deipss.base.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

/**
 * 用于AOP拦截
 *
 * @author deipss
 * @since  2021-07-31
 * @see java.lang.annotation.Annotation
 */
@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAround {
}
