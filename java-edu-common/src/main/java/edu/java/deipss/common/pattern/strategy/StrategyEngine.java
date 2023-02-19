package edu.java.deipss.common.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
/// @Component
public class StrategyEngine<R,T> {

    @Autowired
    private List<AbstractStrategy<R,T>> strategyList;

    private Map<String,AbstractStrategy<R,T>> strategyMap;

    @PostConstruct
    private void init(){
        strategyMap= strategyList.stream().collect(Collectors.toMap(AbstractStrategy::getStrategyUK, Function.identity(), (a, b) -> a));
    }

    public R process(T e,String uk){
        AbstractStrategy<R, T> rtAbstractStrategy = strategyMap.get(uk);
        if(null == rtAbstractStrategy){
            log.error("策略未发现，uk={}",uk);
            return null;
        }
        return strategyMap.get(uk).run(e);
    }
}
