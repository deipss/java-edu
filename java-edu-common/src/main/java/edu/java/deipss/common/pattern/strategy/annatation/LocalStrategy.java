package edu.java.deipss.common.pattern.strategy.annatation;

import edu.java.deipss.common.pattern.strategy.StrategyEngine;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * 策略模式
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE})
public @interface LocalStrategy {
    /**
     * 策略名称
     */
    String strategyName() default "";

    /**
     * 策略的唯一标识
     */
    String strategyUK() default "";

    /**
     * 策略分组
     *
     * @see StrategyEngine#strategyGroup
     */
    String strategyGroup() default "";

    /**
     * 策略优先级
     */
    int priority() default -1;
}
