package edu.java.deipss.sql.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import edu.java.deipss.sql.dal.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;

import static edu.java.deipss.sql.config.EsConfig.ELASTICSEARCH_CLIENT;

@Repository
@Slf4j
public class ProductRepository {

    @Autowired
    @Qualifier(ELASTICSEARCH_CLIENT)
    private ElasticsearchClient esClient;

    public void save() throws IOException {
        Product product = new Product("bk-1", "City bike", 123.0);

        IndexResponse response = esClient.index(i -> i
                .index("deipss_test_products")
                .id(product.getSku())
                .document(product)
        );

        log.info("Indexed with version " + response.version());
    }
}
