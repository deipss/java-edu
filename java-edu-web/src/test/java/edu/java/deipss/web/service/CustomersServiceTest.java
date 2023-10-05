package edu.java.deipss.web.service;

import edu.java.deipss.service.config.ThreadConfig;
import edu.java.deipss.service.service.MapperQueryService;
import edu.java.deipss.sql.config.ClassicmodelMysqlDataSourceConfig;
import edu.java.deipss.sql.dal.service.impl.CustomersServiceImpl;
import edu.java.deipss.web.BaseTest;
import edu.java.deipss.web.controller.MapperController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootTest(classes = {MapperController.class,
        ClassicmodelMysqlDataSourceConfig.class, ThreadConfig.class, CustomersServiceImpl.class,
        MapperQueryService.class

})
@EnableAsync
public class CustomersServiceTest extends BaseTest {

    @Autowired
    CustomersServiceImpl mapperQueryService;

    @Test
    public void test(){

    }
}
