package edu.java.deipss.base.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import edu.java.deipss.base.util.TimeUtil;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.dubbo.common.utils.LogUtil;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用google的线程工厂
 */
public class ThreadPoolUtil {

    public static void main(String[] args) {
        scheduleAtFixedRate();
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

    /**
     * 使用线程池，固定定时执行某个任务
     */
    private static void scheduleAtFixedRate(){
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("juc demo" + "-%d")
                .setDaemon(true).build();

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1,threadFactory);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(()-> System.out.println(LocalDateTime.now()),0,10,TimeUnit.SECONDS);
    }

}
