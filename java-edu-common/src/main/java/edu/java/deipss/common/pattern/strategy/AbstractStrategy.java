package edu.java.deipss.common.pattern.strategy;


import lombok.Data;

@Data
/**
 * 抽象的策略类，所以子类要实现run方法
 * @param <T> the type of the input to the function
 * @param <R> the type of the result of the function
 */
public abstract class AbstractStrategy<R, T> {

    /**
     * 策略名称
     */
    protected String strategyName;

    /**
     * 策略的唯一标识
     */
    protected String strategyUK;
    /**
     * 策略分组
     */
    protected String strategyGroup;
    /**
     * 策略优先级
     */
    protected int priority = -1;


    public AbstractStrategy(String strategyName, String strategyUK, String strategyGroup, int priority) {
        this.strategyName = strategyName;
        this.strategyUK = strategyUK;
        this.strategyGroup = strategyGroup;
        this.priority = priority;
    }

    abstract R run(T t);


    public String buildUK() {
        return strategyGroup + "_" + this.getStrategyUK();
    }


}
