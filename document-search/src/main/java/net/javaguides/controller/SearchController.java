package net.javaguides.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.document_search.model.Document;
import net.javaguides.document_search.service.SearchService;

@RestController
@RequestMapping("/api/document/")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    // POST /api/index
    @PostMapping("/index")
    public String indexDocument(@RequestBody Document document) throws IOException {
        return searchService.createDocument(document);
    }

    // GET /api/search?q=keyword
    @GetMapping("/search")
    public List<Document> searchDocuments(@RequestParam("q") String query) throws IOException {
        return searchService.searchDocuments(query);
    }


}
