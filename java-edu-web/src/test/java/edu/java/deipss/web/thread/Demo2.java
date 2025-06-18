package edu.java.deipss.web.thread;

public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        SaleThread target = new SaleThread();
        long l = System.currentTimeMillis();
        Thread thread = new Thread(target);
        thread.start();


        thread.join();
        System.out.println("总耗时：" + (System.currentTimeMillis() - l)+" 毫秒");
        System.out.println("总耗时：" + (System.currentTimeMillis() - l)/1000+" 秒");

    }


    static class SaleThread implements Runnable {
        private int tickets = 30;
        public void run() {
            while (tickets > 0) {
                saleTicket();

            }
        }

        private  void saleTicket() {
            if (tickets > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "---销售到"
                        + tickets--+"张票");
            }
        }
    }



    static class TicketWindow implements Runnable {
        private int tickets = 100;
        public void run() {
            while (true) {
                if (tickets > 0) {
                    Thread th = Thread.currentThread(); //
                    String th_name = th.getName(); //
                    System.out.println(th_name + " 售卖到 " + tickets-- + " 张票");
                }
            }
        }
    }



    static class MyThreadRunnable implements Runnable {
        public void run() {
            int i  = 3;
            while (i-->0) {
                System.out.println(Thread.currentThread().getName() +" MyThreadRunnable run()");
            }
        }
    }


    static class MyThread extends Thread {
        public void run() {
            int i  = 3;
            while (i-->0) {
                System.out.println(Thread.currentThread().getName()+ "MyThread run() ");
            }
        }
    }
}
