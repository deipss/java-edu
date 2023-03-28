package edu.java.deipss.web;


import edu.java.deipss.service.config.ThreadConfig;
import edu.java.deipss.sql.config.SchedulingMysqlDataSourceConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@EnableConfigurationProperties
// 测试导入公共的配置类
@Import({SchedulingMysqlDataSourceConfig.class, ThreadConfig.class})
public class BaseTest {
}
