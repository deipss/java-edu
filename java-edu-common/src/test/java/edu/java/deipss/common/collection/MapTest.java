package edu.java.deipss.common.collection;


import com.alibaba.fastjson2.JSON;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author deipss
 * @since 2021-11-10
 */
public class MapTest {

    @Test
    public void demo() {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, 1);
        concurrentHashMap.compute(2, (k, v) -> v == null ? 1 : v + 1);
        System.out.println(JSON.toJSONString(concurrentHashMap));
        concurrentHashMap.computeIfAbsent(3, v -> 1);
        concurrentHashMap.computeIfPresent(2, (k, v) -> v + 1);
        System.out.println(JSON.toJSONString(concurrentHashMap));
    }

}
