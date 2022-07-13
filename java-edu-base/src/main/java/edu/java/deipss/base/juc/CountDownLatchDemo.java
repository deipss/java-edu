package edu.java.deipss.base.juc;

/**
 * @author deipss
 * @date 2021-11-05
 */
import javax.annotation.concurrent.ThreadSafe;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    private static void dealSheet(String sheetName, CountDownLatch countDownLatch) {
        try {
            System.out.println(Thread.currentThread() + " deal with " + sheetName);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 完成后，减少
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {

        int N = 3;
        CountDownLatchDemo demo = new CountDownLatchDemo();
        CountDownLatch countDownLatch = new CountDownLatch(N);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->dealSheet("sheet 1",countDownLatch));
        executorService.submit(()->dealSheet("sheet 2",countDownLatch));
        executorService.submit(()->dealSheet("sheet 3",countDownLatch));
        try {
            countDownLatch.await();
            System.out.println("done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
