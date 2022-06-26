package edu.java.deipss.base.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.time.Instant;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class ThreadPoolDome {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("juc demo" + "-%d")
                .setDaemon(true).build();


        ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()*2,
                16,32, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(32),
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        ReentrantLock lock = new ReentrantLock();



        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("CurrentThread name:" + Thread.currentThread().getName() + "date：" + Instant.now());
            });
        }
        //终止线程池
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished all threads");
    }
}
