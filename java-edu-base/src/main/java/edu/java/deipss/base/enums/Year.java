package edu.java.deipss.base.enums;


import java.util.Arrays;

public class Year {
    public static void main(String[] args) {
        System.out.println(Season.SPRING.toString());
        Arrays.stream(Season.values()).forEach(i -> System.out.print(i.name() + "\t"));
        System.out.println();
        //java.lang.IllegalArgumentException: No enum constant enumdemo.Season.SP2RING
        System.out.println(Season.valueOf("SPRING").getName());

        Season.SPRING.show();
        System.out.println(Season.valueOf("SPRING").equals(Season.SPRING));
    }
}
