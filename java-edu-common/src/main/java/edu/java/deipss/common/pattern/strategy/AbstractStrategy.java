package edu.java.deipss.common.pattern.strategy;


import lombok.Data;

@Data
public abstract class AbstractStrategy<R, T> {


    abstract R run(T t);


}
