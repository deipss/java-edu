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

    /**
     * When running tests, it is sometimes necessary to mock certain components within your application context. For example, you may have a facade over some remote service that is unavailable during development. Mocking can also be useful when you want to simulate failures that might be hard to trigger in a real environment.
     *
     * Spring Boot includes a @MockBean annotation that can be used to define a Mockito mock for a bean inside your ApplicationContext. You can use the annotation to add new beans or replace a single existing bean definition. The annotation can be used directly on test classes, on fields within your test, or on @Configuration classes and fields. When used on a field, the instance of the created mock is also injected. Mock beans are automatically reset after each test method.
     */
    @MockBean
    private MapperQueryService mapperQueryService;

    @Test
    public void test(){

    }

}
