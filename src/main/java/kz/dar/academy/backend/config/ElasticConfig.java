package kz.dar.academy.backend.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticConfig extends AbstractElasticsearchConfiguration {
    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("employee-task.es.eu-west-1.aws.found.io:9243")
                .usingSsl()
                .withBasicAuth("elastic", "lJi2kPsE8cywaYrBARAndqvs")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
