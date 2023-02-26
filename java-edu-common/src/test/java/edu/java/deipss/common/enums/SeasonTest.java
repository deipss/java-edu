package edu.java.deipss.common.enums;


import org.junit.Test;

import java.util.Arrays;

public class SeasonTest {

    @Test
    public void test() {
        System.out.println(Season.SPRING);
        Arrays.stream(Season.values()).forEach(i -> System.out.print(i.name() + "\t"));
        System.out.println();
        System.out.println(Season.valueOf("SPRING").getName());
        Season.SPRING.show();
        System.out.println(Season.valueOf("SPRING").equals(Season.SPRING));
    }
}
