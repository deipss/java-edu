package edu.java.deipss.sql.repository;

import edu.java.deipss.sql.dal.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;

import static edu.java.deipss.sql.config.EsConfig.ES_REST_CLIENT;


@Repository
@Slf4j
public class ProductRepository {

    @Autowired
    @Qualifier(ES_REST_CLIENT)
    private RestHighLevelClient esClient;

    public void save() throws IOException {
        Product product = new Product("bk-1", "City bike", 123.0);

    }

}
