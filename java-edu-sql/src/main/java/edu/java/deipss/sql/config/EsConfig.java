package edu.java.deipss.sql.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import edu.java.deipss.sql.config.property.EsConfigProperty;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class EsConfig {

    public static final String ES_REST_CLIENT = "esRestClient";
    public static final String ELASTICSEARCH_TRANSPORT = "elasticsearchTransport";
    public static final String ELASTICSEARCH_CLIENT = "elasticsearchClient";
    ///@Value("${es.host}")
    private String host="192.168.0.104";
    ///@Value("${es.port}")
    private String port="9200";

    @Bean(ES_REST_CLIENT)
    public RestClient initRestClient() {
        return RestClient.builder(
                new HttpHost(host, Integer.parseInt(port))).build();
    }


    @Bean(ELASTICSEARCH_TRANSPORT)
    public ElasticsearchTransport initElasticsearchTransport(@Qualifier("esRestClient") RestClient restClient) {
        return new RestClientTransport(
                restClient, new JacksonJsonpMapper());
    }


    @Bean(ELASTICSEARCH_CLIENT)
    public ElasticsearchClient initElasticsearchClient(ElasticsearchTransport transport) {
        return new ElasticsearchClient(transport);
    }
}
