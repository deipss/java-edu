package edu.java.deipss.web.controller;

import edu.java.deipss.service.service.MapperQueryService;
import edu.java.deipss.sql.config.SchedulingMysqlDataSourceConfig;
import edu.java.deipss.web.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = {MapperController.class,
        SchedulingMysqlDataSourceConfig.class
})
// web 测试
@AutoConfigureMockMvc
public class ControllerTest extends BaseTest {

    @Autowired
    private MapperController mapperController;

    @MockBean
    private MapperQueryService mapperQueryService;

    @Test
    public void test(){

    }

}
