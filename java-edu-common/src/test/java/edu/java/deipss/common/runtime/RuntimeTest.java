package edu.java.deipss.common.runtime;

import org.junit.Test;

public class RuntimeTest {


    @Test
    public void test() {

        System.exit(0);// 使用的是下面的方法
        Runtime.getRuntime().exit(0);


        /**
         * jvm正常关闭或是被其他事件（ctrl+C）中断，会无序并发的调用被注册到队列的线程
         */
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println(this.getClass().getName());
        }));

    }
}
