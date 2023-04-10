package edu.java.deipss.common.pattern.singleton;

/**
 * 饿汉单例模式
 */
public final class SingletonHunger {
    private static final SingletonHunger INSTANCE = new SingletonHunger();

    public static SingletonHunger getInstance() {
        return INSTANCE;
    }
    private SingletonHunger() {
    }
}
