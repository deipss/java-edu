package edu.java.deipss.base.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import edu.java.deipss.base.util.TimeUtil;

import java.time.Instant;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用google的线程工厂
 */
public class ThreadPoolUtil {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = getThreadPoolExecutor();
        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("CurrentThread name:" + Thread.currentThread().getName() + "date：" + Instant.now()+"    "+ finalI);
            });
        }
        //终止线程池
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.println("Finished all threads");
    }

    private static ThreadPoolExecutor getThreadPoolExecutor() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("juc demo" + "-%d")
                .setDaemon(true).build();


        ThreadPoolExecutor executor = new ThreadPoolExecutor( 2,
                2, 32, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(32),
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );


        return executor;
    }
}
