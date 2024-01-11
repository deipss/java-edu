package edu.java.deipss.web.spring;

import edu.java.deipss.web.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SprintInitTestBean.class)
public class SprintLifeTest extends BaseTest {

    @Autowired
    private SprintInitTestBean sprintInitTestBean;

    @Test
    public void test(){
        sprintInitTestBean.print();
    }
}
