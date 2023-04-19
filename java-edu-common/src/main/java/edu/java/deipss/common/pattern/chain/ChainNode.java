package edu.java.deipss.common.pattern.chain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ChainNode<R> {

    private String engineName;
    protected String nodeName;
    protected String nodeUk;
    protected boolean stated;
    protected boolean end;


    public abstract NodeResult<R> process(NodeContext context);
}
