package edu.java.deipss.common.pattern.chain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        ChainNode1.class,
        ChainNode2.class,
        ChainNodeContext.class,
        ChainTest.class,
        ChainTestEngine.class
})
public class ChainTest {

    @Autowired
    ChainTestEngine engine;

    @Test
    public void test(){
        NodeResult<String> process = engine.process(ChainNodeContext.builder().build());
        System.out.println(process);
    }
}
