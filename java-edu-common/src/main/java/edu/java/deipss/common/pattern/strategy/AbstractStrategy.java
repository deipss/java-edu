package edu.java.deipss.common.pattern.strategy;


import lombok.Data;

@Data
/**
 * 抽象的策略类，所以子类要实现run方法
 * @param <T> the type of the input to the function
 * @param <R> the type of the result of the function
 */
public abstract class AbstractStrategy<R, T> {


    abstract R run(T t);


}
