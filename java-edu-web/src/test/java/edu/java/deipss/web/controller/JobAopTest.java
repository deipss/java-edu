package edu.java.deipss.web.controller;

import edu.java.deipss.event.job.RedisManagerJob;
import edu.java.deipss.web.BaseTest;
import edu.java.deipss.web.EduApplication;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = EduApplication.class)
public class JobAopTest extends BaseTest {

    @Autowired
    private RedisManagerJob redisManagerJob;


    @Test
    public void test(){
        redisManagerJob.testAopIneffective();
    }


    @Test
    public void test2(){
        redisManagerJob.runHoursAdd();
    }

}
