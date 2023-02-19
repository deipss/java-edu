package edu.java.deipss.common.pattern.chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
@Slf4j
public class ChainEngine {

    @Autowired
    private List<ChainLink> chainLinks;

    private Map<String,ChainLink> chainLinkMap;

    @PostConstruct
    private void init(){
        chainLinkMap = chainLinks.stream().collect(Collectors.toMap(ChainLink::getLinkUK, Function.identity(), (a, b) -> a));
    }

    public NodeResult process(String uk) {
        ChainLink chainLink = chainLinkMap.get(uk);
        if (null == chainLink) {
            log.error("策略未发现，uk={}", uk);
            return null;
        }
        NodeContext init = chainLink.init();
        return chainLink.process(init);
    }
}
