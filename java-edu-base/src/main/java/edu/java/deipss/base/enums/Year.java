package edu.java.deipss.base.enums;


import java.util.Arrays;

public class Year {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        Arrays.stream(Season.values()).forEach(i -> System.out.print(i.name() + "\t"));
        System.out.println();
        System.out.println(Season.valueOf("SPRING").getName());
        Season.SPRING.show();
        System.out.println(Season.valueOf("SPRING").equals(Season.SPRING));
    }
}
