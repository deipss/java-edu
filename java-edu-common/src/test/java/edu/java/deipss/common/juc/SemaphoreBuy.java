package edu.java.deipss.common.juc;

/**
 * @author deipss
 * @date 2021-11-05
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreBuy {
    Semaphore semaphore ;
    public void buyTicket(){
        // 事务初始不成功
        boolean isSucessed = false;

        try {
            if(semaphore.tryAcquire(100, TimeUnit.MICROSECONDS)) {
                System.out.println(Thread.currentThread()+"buying....");
                // 事务操作，确定是否成功 修改isSucessed
                TimeUnit.SECONDS.sleep(2);
            }
            System.out.println(Thread.currentThread()+"waiting....");

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            // 事务执行失败,释放资源
            if(!isSucessed) {
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        SemaphoreBuy semaphoreDemo= new SemaphoreBuy();
        semaphoreDemo.semaphore = new Semaphore(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                semaphoreDemo.buyTicket();
            });
        }

    }
}
