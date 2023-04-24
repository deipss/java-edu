package edu.java.deipss.common.pattern.chain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ChainNode<R> {
    /**
     * @see ChainEngine#engineName
     */
    private String engineName;
    /**
     * 节点名称
     */
    protected String nodeName;
    /**
     * 节点 UK
     */
    protected String nodeUk;
    /**
     * 是否为起始节点
     */
    protected boolean stated;
    /**
     * 是否为结束节点
     */
    protected boolean end;


    public abstract NodeResult<R> process(NodeContext context);
}
