package edu.java.deipss.common.pattern.chain;

import lombok.Data;

import java.util.List;

@Data
public abstract class ChainLink {
    protected String linkName;
    protected String linkUK;
    protected List<ChainNode> nodeList;

    public ChainLink(String linkName, String linkUK, List<ChainNode> nodeList) {
        this.linkName = linkName;
        this.linkUK = linkUK;
        this.nodeList = nodeList;
    }

    public abstract NodeContext init();

    public NodeResult process (NodeContext context){
        NodeResult result = null;
        for (ChainNode chainNode : nodeList) {
            result = chainNode.process(context);
        }
        return result;
    }
}
