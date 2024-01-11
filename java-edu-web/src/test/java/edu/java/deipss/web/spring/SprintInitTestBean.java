package edu.java.deipss.web.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.LifecycleProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class SprintInitTestBean implements LifecycleProcessor, InitializingBean, DisposableBean
, BeanFactoryPostProcessor, BeanPostProcessor, ApplicationRunner, CommandLineRunner {

    public void print(){
        log.info("print do something" );
    }
    @Override
    public void destroy() throws Exception {
        log.info("SprintInitTestBean destroy ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("SprintInitTestBean afterPropertiesSet ");

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("SprintInitTestBean postProcessBeanFactory ");

    }

    @Override
    public void run(String... args) throws Exception {
        log.info("SprintInitTestBean run ,args={}", Arrays.stream(args).toArray());

    }

    @Override
    public void onRefresh() {
        log.info("SprintInitTestBean onRefresh ");

    }

    @Override
    public void onClose() {
        log.info("SprintInitTestBean onClose ");

    }

    @Override
    public void start() {
        log.info("SprintInitTestBean start ");

    }

    @Override
    public void stop() {
        log.info("SprintInitTestBean stop ");

    }

    @Override
    public boolean isRunning() {
        log.info("SprintInitTestBean isRunning ");

        return false;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("SprintInitTestBean run  ,ApplicationArguments={}",args.getOptionNames());

    }
}
