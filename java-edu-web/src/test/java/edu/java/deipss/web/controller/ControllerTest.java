package edu.java.deipss.web.controller;

import com.alibaba.fastjson2.JSON;
import edu.java.deipss.spring.service.MapperQueryService;
import edu.java.deipss.sql.config.SchedulingMysqlDataSourceConfig;
import edu.java.deipss.sql.dal.entity.SchedulingTask;
import edu.java.deipss.web.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(classes = {MapperController.class,
        SchedulingMysqlDataSourceConfig.class
})
public class ControllerTest extends BaseTest {

    @Autowired
    private MapperController mapperController;

    @MockBean
    private MapperQueryService mapperQueryService;

    @Test
    public void test(){

    }

}
