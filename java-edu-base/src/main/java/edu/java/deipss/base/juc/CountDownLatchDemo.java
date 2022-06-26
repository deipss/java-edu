package edu.java.deipss.base.juc;

/**
 * @author deipss
 * @date 2021-11-05
 */
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    private void dealSheet(String sheetName, CountDownLatch countDownLatch) {
        try {
            System.out.println(Thread.currentThread() + " deal with " + sheetName);
            TimeUnit.SECONDS.sleep(2L);
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
        new Thread(() -> {
            demo.dealSheet("sheet1", countDownLatch);
        }).start();
        new Thread(() -> {
            demo.dealSheet("sheet2", countDownLatch);
        }).start();
        new Thread(() -> {
            demo.dealSheet("sheet3", countDownLatch);
        }).start();

        try {
            countDownLatch.await();
            System.out.println("done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
