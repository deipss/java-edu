package edu.java.deipss.common.generic;


import org.junit.Test;

import java.util.ArrayList;

/**
 * since jdk1.5,
 * 1 是伪泛型，只在编译阶段存在，编译之后，泛型会被擦除(为了兼容1.5之前的代码)
 * 2 泛型不具有继承性，但是数据具备
 */
public class GenericTest {

    @Test
    public void test(){

        /**
         * 上界通配符，只能读，不能写
         */
        ArrayList<? extends CharSequence> stringExtend = new ArrayList<>();
        // stringExtend.add(new StringBuffer("ee"));

        /**
         * 下界通配符
         */
        ArrayList<? super String> stringSuper = new ArrayList<>();

    }

}
