package edu.java.deipss.service.dubbo;

import edu.java.deipss.service.test.DubboTest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@Slf4j
@DubboService
public class DubboTestImpl implements DubboTest {
    public String exe(){
        log.info("dubbo 执行成功");
        return "done";
    }
}
