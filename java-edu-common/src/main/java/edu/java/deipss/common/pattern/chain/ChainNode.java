package edu.java.deipss.common.pattern.chain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public abstract class ChainNode<R> {


    public abstract NodeResult<R> process(NodeContext context);
}
