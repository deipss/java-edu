package edu.java.deipss.spring.listner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ApplicationListener implements CommandLineRunner, DisposableBean {


    @Override
    public void destroy() throws Exception {
        log.info("程序关闭");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("程序启动成功,unlock所有全局锁");
    }
}
