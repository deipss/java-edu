package edu.java.deipss.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author deipss
 * @date 2021-11-09
 */

interface ExecutorService {
    public void run();
}

class ExecutorServiceImpl implements ExecutorService {

    @Override
    public void run() {
        System.out.println(ExecutorServiceImpl.class.getName() + " is run");
    }
}

class ExecutorHandler implements InvocationHandler {

    private final ExecutorService executorService;

    public ExecutorHandler(ExecutorService executorService) {
        this.executorService = executorService;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(proxy, args);
        return invoke;
    }
}

public class ProxyDemo {

    public static void main(String[] args) {
        ExecutorService executorService = new ExecutorServiceImpl();
        ExecutorService proxyInstance =(ExecutorService) Proxy.newProxyInstance(executorService.getClass().getClassLoader(),
                executorService.getClass().getInterfaces(),
                new ExecutorHandler(executorService));
        proxyInstance.run();
    }
}
