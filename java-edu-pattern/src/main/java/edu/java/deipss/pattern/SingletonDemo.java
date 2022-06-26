package edu.java.deipss.pattern;

/**
 * @author deipss
 * @date 2021-11-05
 */
enum SingletonEnum {

}

class SingletonDouble {
    private static SingletonDouble INSTANCE = null;

    // private构造方法保证外部无法实例化:
    private SingletonDouble() {
    }

    public static SingletonDouble getInstance() {
        if (null == INSTANCE) {
            synchronized (SingletonDouble.class) {
                if (null == INSTANCE) {
                    INSTANCE = new SingletonDouble();
                }
            }
        }
        return INSTANCE;
    }

}

class Singleton {
    // 静态字段引用唯一实例:
    private static final Singleton INSTANCE = new Singleton();

    // 通过静态方法返回实例:
    public static Singleton getInstance() {
        return INSTANCE;
    }

    // private构造方法保证外部无法实例化:
    private Singleton() {
    }
}

public class SingletonDemo {

}
