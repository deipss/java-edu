package edu.java.deipss.web.es;

import edu.java.deipss.service.config.ThreadConfig;
import edu.java.deipss.sql.config.EsConfig;
import edu.java.deipss.sql.config.SchedulingMysqlDataSourceConfig;
import edu.java.deipss.sql.config.property.EsConfigProperty;
import edu.java.deipss.sql.repository.ProductRepository;
import edu.java.deipss.web.BaseTest;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Import({EsConfig.class, EsConfigProperty.class, ProductRepository.class})

public class EsTest extends BaseTest {

    @Autowired
    ProductRepository repository;

    @Test
    @SneakyThrows
    public void test1() {
        repository.save();
    }
}
