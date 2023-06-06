package edu.java.deipss.common.pattern.chain;


import edu.java.deipss.common.pattern.chain.annotation.LocalChainNode;
import org.springframework.stereotype.Component;

@Component
@LocalChainNode(engineName = ChainTestEngine.CHAIN_TEST_ENGINE,nodeUk = "2",nodeName = "2",stated = true)

public class ChainNode2 extends ChainNode<String>{
    @Override
    public NodeResult<String> process(NodeContext context) {
        System.out.println("节点2执行");
        return NodeResult.<String>builder().end(true).data("2").success(true).build();
    }
}
