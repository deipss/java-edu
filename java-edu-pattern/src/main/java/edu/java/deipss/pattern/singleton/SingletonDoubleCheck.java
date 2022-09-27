package edu.java.deipss.pattern.singleton;

/**
 * @author deipss
 * @date 2021-11-05
 * https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/?ref=lbp
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
