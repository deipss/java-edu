package edu.java.deipss.common.pattern.chain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 节点结果
 */
@Data
@AllArgsConstructor
public class NodeResult<R> {
    /**
     * 当前节点是否成功
     */
    private boolean success;

    /**
     * 是否结束链路
     */
    private boolean end;
    /**
     * 下一个结点的UK
     */
    private String nextNodeUk;

    /**
     * 节点执行结果
     */
    private R data;
}
