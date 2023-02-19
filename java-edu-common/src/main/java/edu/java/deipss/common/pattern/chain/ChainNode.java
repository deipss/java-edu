package edu.java.deipss.common.pattern.chain;

public abstract class ChainNode {
    protected String nodeName;
    protected String nodeUk;


    public abstract NodeResult process(NodeContext context);
}
