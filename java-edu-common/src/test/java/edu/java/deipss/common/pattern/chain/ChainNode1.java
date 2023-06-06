package edu.java.deipss.common.pattern.chain;


import edu.java.deipss.common.pattern.chain.annotation.LocalChainNode;
import org.springframework.stereotype.Component;

@Component
@LocalChainNode(engineName = ChainTestEngine.CHAIN_TEST_ENGINE,nodeUk = "1",nodeName = "1",stated = true)
public class ChainNode1 extends ChainNode<String>{
    @Override
    public NodeResult<String> process(NodeContext context) {
        System.out.println("节点1执行");
        return NodeResult.<String>builder().end(true).data("1").success(true).build();
    }
}
