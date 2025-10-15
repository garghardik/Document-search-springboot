package net.javaguides.document_search.config;

import org.apache.hc.core5.http.HttpHost;
import org.opensearch.client.RestClient;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.transport.rest_client.RestClientTransport;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;

public class OpenSearchConfig {
    public static void main(String[] args) throws Exception {
        // Connect to local OpenSearch without SSL / auth
        final HttpHost host = new HttpHost("https", "localhost", 9200);
        final RestClient restClient = RestClient.builder(host).build();
        final RestClientTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        final OpenSearchClient client = new OpenSearchClient(transport);

        // Test connection
        var info = client.info();
        System.out.println("Connected to cluster: " + info.clusterName());
    }
}
