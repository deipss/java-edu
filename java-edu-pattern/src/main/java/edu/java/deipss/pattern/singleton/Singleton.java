package edu.java.deipss.pattern.singleton;

/**
 * 单例模式
 */
public final class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }
    private Singleton() {
    }
}
