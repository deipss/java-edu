package edu.java.deipss.pattern.producer;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ProducerTest {


    Producer producer;

    @Before
    public void init() {
        producer = new Producer();
    }

    @Test
    public void test() {
        ExecutorService putExecutorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 4; i++) {
            putExecutorService.execute(() -> {
                for (; ; ) {
                    producer.put(Producer.HappyItem.builder().name(Thread.currentThread().getName()).item(ThreadLocalRandom.current().nextInt()).build());
                    try {
                        TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(10, 20));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        ExecutorService getExecuteService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 4; i++) {
            getExecuteService.execute(() -> {
                for (; ; ) {
                    producer.get();
                    try {
                        TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(100, 200));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        while (true) {

        }
    }
}
