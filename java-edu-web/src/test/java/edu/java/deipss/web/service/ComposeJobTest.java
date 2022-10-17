package edu.java.deipss.web.service;

import edu.java.deipss.spring.config.ThreadConfig;
import edu.java.deipss.spring.service.MapperQueryService;
import edu.java.deipss.sql.config.SchedulingMysqlDataSourceConfig;
import edu.java.deipss.web.BaseTest;
import edu.java.deipss.web.controller.MapperController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootTest(classes = {MapperController.class,
        SchedulingMysqlDataSourceConfig.class, ThreadConfig.class,
        MapperQueryService.class

})
@EnableAsync
public class ComposeJobTest extends BaseTest {

    @Autowired
    MapperQueryService mapperQueryService;

    @Test
    public void test(){
        mapperQueryService.query();
    }
}
