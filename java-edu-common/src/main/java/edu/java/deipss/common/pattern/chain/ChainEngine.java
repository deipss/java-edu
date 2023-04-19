package edu.java.deipss.common.pattern.chain;

import edu.java.deipss.service.test.exception.AppInnerException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ChainEngine<T> {

    @Autowired
    List<ChainNode<T>> nodeList;
    /**
     * 节点映射
     */
    Map<String, ChainNode<T>> nodeMap;
    /**
     * 引擎名称
     */
    private String engineName;

    /**
     * 开始节点
     */
    private ChainNode<T> statedNode;

    @PostConstruct
    private void init() {
        nodeMap = nodeList.stream().filter(i -> i.getEngineName().equals(engineName))
                .collect(Collectors.toMap(ChainNode::getNodeUk, Function.identity(), (a, b) -> a));

        Optional<ChainNode<T>> any = nodeList.stream().filter(ChainNode::isStated).findAny();
        any.orElseThrow(() -> AppInnerException.builder().message("未找到开始节点").build());
        any.ifPresent(i -> statedNode = any.get());
    }

    /**
     * @param context 执行的上下文
     * @return 返回结果
     */
    public NodeResult<T> process(NodeContext context) {
        ChainNode<T> currentNode = statedNode;
        NodeResult<T> result = null;
        do {
            result = currentNode.process(context);
            currentNode = nodeMap.get(result.getNextNodeUk());
        } while (!currentNode.isEnd());
        return result;
    }
}
