package edu.java.deipss.base.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author deipss
 * @since 2021-11-10
 */
public class Demo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1,1);
        copyOnWriteArrayList.add(1);
    }
}
