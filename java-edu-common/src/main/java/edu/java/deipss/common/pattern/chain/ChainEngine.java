package edu.java.deipss.common.pattern.chain;

import edu.java.deipss.common.pattern.chain.annotation.LocalChainNode;
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

    public ChainEngine(String engineName) {
        this.engineName = engineName;
    }

    @PostConstruct
    private void init() {
        for (ChainNode<T> node : nodeList) {
            LocalChainNode annotation = node.getClass().getAnnotation(LocalChainNode.class);
            if (annotation.engineName().equals(engineName)) {
                if (annotation.stated()) {
                    statedNode = node;
                }
                nodeMap.putIfAbsent(annotation.nodeUk(), node);
            }
        }
        if (statedNode == null) {
            throw new RuntimeException("未配置起始节点，chain engine name =" + engineName);
        }

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
        } while (!result.isEnd());
        return result;
    }
}
