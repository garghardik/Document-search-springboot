package net.javaguides.document_search.config;
import org.apache.http.HttpHost;

import org.opensearch.client.RestClient;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.transport.rest_client.RestClientTransport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;

@Configuration
public class OpenSearchConfig {

    @Bean
    public OpenSearchClient openSearchClient() {
        final HttpHost httpHost = new HttpHost("localhost", 9200, "http");
        final RestClient restClient = RestClient.builder(httpHost).build();
        final RestClientTransport transport = new RestClientTransport(
                restClient,
                new JacksonJsonpMapper());

        OpenSearchClient client = new OpenSearchClient(transport);
        
        try {
            var info = client.info();
            System.out.println("Successfully connected to OpenSearch cluster: {}"+ info.clusterName());
        } catch (Exception e) {
            System.out.println("Failed to connect"+ e);
        }
        
        return client;
    }
}
