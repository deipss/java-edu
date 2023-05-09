package edu.java.deipss.common.pattern.chain;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class ChainNode<R> {


    public abstract NodeResult<R> process(NodeContext context);
}
