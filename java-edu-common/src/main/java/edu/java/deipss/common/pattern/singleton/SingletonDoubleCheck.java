package edu.java.deipss.common.pattern.singleton;

/**
 * @author deipss
 * @since 2021-11-05
 * <a href="https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/?ref=lbp">参考1</a>
 */


class SingletonDoubleCheck {
    private static SingletonDoubleCheck INSTANCE = null;

    private SingletonDoubleCheck() {
    }

    public static SingletonDoubleCheck getInstance() {
        if (null == INSTANCE) {
            synchronized (SingletonDoubleCheck.class) {
                if (null == INSTANCE) {
                    INSTANCE = new SingletonDoubleCheck();
                }
            }
        }
        return INSTANCE;
    }

}
