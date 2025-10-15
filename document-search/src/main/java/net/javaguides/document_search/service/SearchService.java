package net.javaguides.document_search.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.search.Hit;

import net.javaguides.document_search.model.Document;

public class SearchService {
    private final OpenSearchClient searchClient;
    private final String INDEX = "documents";

    public SearchService(OpenSearchClient client) {
        this.searchClient = client;
    }

    public String createDocument(Document document) throws IOException {
        IndexRequest<Document> request = IndexRequest.of(j -> j.index(INDEX)
                .id(document.getId())
                .document(document));

        IndexResponse response = searchClient.index(request);
        return response.result().toString();
    }

    public List<Document> searchDocuments(String query) throws IOException {
        SearchRequest request = SearchRequest.of(s -> s
                .index(INDEX)
                .query(q -> q
                        .multiMatch(m -> m
                                .fields("title", "content")
                                .query(query))));

        SearchResponse<Document> response = searchClient.search(request, Document.class);

        return response.hits().hits().stream()
                .map(Hit::source)
                .collect(Collectors.toList());
    }
}
