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
public class StrategyEngine<R, T> {

    @Autowired
    private List<AbstractStrategy<R, T>> strategyList;

    private Map<String, AbstractStrategy<R, T>> strategyMap;

    @PostConstruct
    private void init() {
        strategyMap = strategyList.stream().collect(Collectors.toMap(AbstractStrategy::getStrategyUK, Function.identity(), (a, b) -> {
            throw new IllegalStateException("策略uk冲突，请检查是否存在多个" + a.getStrategyUK());
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
