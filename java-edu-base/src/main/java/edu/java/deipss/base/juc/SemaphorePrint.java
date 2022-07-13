package edu.java.deipss.base.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author deipss
 * @date 2021-11-05
 */


class SemaphorePrint {
    Semaphore semaphore2;
    Semaphore semaphore3;

    public SemaphorePrint(){
        semaphore2= new Semaphore(0);
        semaphore3= new Semaphore(0);
    }
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore2.release();
    }
    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        semaphore2.acquire();
        printSecond.run();
        semaphore3.release();
    }
    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        semaphore3.acquire();
        printThird.run();

    }

    public static void main(String[] args) {
        SemaphorePrint semaphorePrint = new SemaphorePrint();
        ExecutorService exe1 = Executors.newFixedThreadPool(100);
        ExecutorService exe2 = Executors.newSingleThreadExecutor();
        ExecutorService exe3 = Executors.newSingleThreadExecutor();
        while (true){
            exe1.submit(()->{
                try {
                    semaphorePrint.third(()->{
                        System.out.println("third");
                    });
                } catch (InterruptedException e) {
                }
            });
            exe1.submit(()->{
                try {
                    semaphorePrint.second(()->{
                        System.out.println("second");
                    });
                } catch (InterruptedException e) {
                }
            });
            exe1.submit(()->{
                try {
                    semaphorePrint.first(()->{
                        System.out.println("first");
                    });
                } catch (InterruptedException e) {
                }
            });

        }

    }
}