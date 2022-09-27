package edu.java.deipss.pattern.strategy;

public abstract class AbstractStrategy<R,T> {

    protected String strategyName;

    protected String strategyUK;

    public AbstractStrategy(String strategyName,String strategyUK){
        this.strategyName = strategyName;
        this.strategyUK=strategyUK;
    }

    abstract R run(T t);

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public String getStrategyUK() {
        return strategyUK;
    }

    public void setStrategyUK(String strategyUK) {
        this.strategyUK = strategyUK;
    }
}
