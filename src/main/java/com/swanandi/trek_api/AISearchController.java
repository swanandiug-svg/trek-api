package com.swanandi.trek_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/trails")
public class AISearchController {

    @Autowired
    private AISearchService aiSearchService;

    @PostMapping("/search/ai")
    public ResponseEntity<String> aiSearch(@RequestBody Map<String, String> request) {
        String query = request.get("query");
        String result = aiSearchService.searchWithAI(query);
        return ResponseEntity.ok(result);
    }
}