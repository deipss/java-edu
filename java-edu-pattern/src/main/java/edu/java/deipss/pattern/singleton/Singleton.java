package edu.java.deipss.pattern.singleton;

public final class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }
    private Singleton() {
    }
}
