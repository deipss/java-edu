package edu.java.deipss.common.pattern.chain.annotation;

import edu.java.deipss.common.pattern.chain.ChainEngine;
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
public @interface LocalChainNode {
    /**
     * @see ChainEngine#engineName
     */
    String engineName() default "";

    /**
     * 节点名称
     */
    String nodeName() default "";

    /**
     * 节点 UK
     */
    String nodeUk() default "";

    /**
     * 是否为起始节点
     */
    boolean stated() default false;


}
