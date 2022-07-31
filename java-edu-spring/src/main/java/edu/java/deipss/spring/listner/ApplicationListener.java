package edu.java.deipss.spring.listner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
  实现这两个方法，来完成spring 应用的启动事件
 */
@Component
@Slf4j
public class ApplicationListener implements CommandLineRunner, DisposableBean {


    @Override
    public void destroy() throws Exception {
        log.info("程序关闭");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("程序启动成功");
    }
}
