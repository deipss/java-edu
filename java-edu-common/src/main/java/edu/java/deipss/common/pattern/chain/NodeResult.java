package edu.java.deipss.common.pattern.chain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 节点结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeResult<R> {
    /**
     * 当前节点是否成功
     */
    private boolean success;


    private String nextNodeUk;


    /**
     * 节点执行结果
     */
    private R data;
}
