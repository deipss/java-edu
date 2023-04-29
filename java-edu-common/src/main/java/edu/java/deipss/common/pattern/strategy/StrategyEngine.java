package edu.java.deipss.common.pattern.strategy;

import edu.java.deipss.common.pattern.strategy.annatation.LocalStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class StrategyEngine<R, T> {

    @Autowired
    private List<AbstractStrategy<R, T>> strategyList;

    private Map<String, AbstractStrategy<R, T>> strategyMap;

    /**
     * @see LocalStrategy#strategyGroup()
     */
    private String strategyGroup;

    @PostConstruct
    private void init() {
        strategyMap = strategyList.stream().filter(i -> i.getClass().getAnnotation(LocalStrategy.class).strategyGroup().equals(strategyGroup))
                .collect(Collectors.toMap(i -> i.getClass().getAnnotation(LocalStrategy.class).strategyUK(), Function.identity(), (a, b) -> {
                    throw new IllegalStateException("策略uk冲突，请检查是否存在多个,策略组=" + strategyGroup);
                }));
    }

    /**
     * @param e  参数
     * @param uk 唯一标识
     * @return 结果
     */
    public R process(T e, String uk) {
        AbstractStrategy<R, T> rtAbstractStrategy = strategyMap.get(uk);
        if (null == rtAbstractStrategy) {
            log.error("策略未发现，uk={}", uk);
            throw new IllegalArgumentException("策略未发现");
        }

        try {
            R result = strategyMap.get(uk).run(e);
            if (null == result) {
                log.error("执行结果为空,uk={}", uk);
                throw new NullPointerException("执行结果为空");
            }
            return result;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
