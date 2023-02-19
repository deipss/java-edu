package edu.java.deipss.common.pattern.producer;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 一种生产者消费旨
 */
@Slf4j
@NoArgsConstructor
public class Producer {

    /**
     * 当ArrayBlockingQueue满了以后，会抛出异常
     */
    private final BlockingQueue<HappyItem> blockingQueue = new ArrayBlockingQueue<>(128, false);

    public void put(HappyItem item) {
        blockingQueue.add(item);
        System.out.println("add a item=" + item);
    }

    public HappyItem get() {
        HappyItem poll = null;
        try {
            poll = blockingQueue.poll(3, TimeUnit.SECONDS);
            System.out.println("get a item=" + poll);
        } catch (InterruptedException e) {
            log.error("get item exception", e);
        }
        return poll;
    }

    @Builder
    @ToString
    public static class HappyItem {
        private String name;
        private Integer item;
    }
}
