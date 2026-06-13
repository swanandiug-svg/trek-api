package com.swanandi.trek_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.*;

@Service
public class AISearchService {

    @Autowired
    private TrailRepository trailRepository;

    @Value("${gemini.api.key}")
    private String apiKey;

    public String searchWithAI(String userQuery) {

        List<Trail> trails = trailRepository.findAll();


        StringBuilder trailData = new StringBuilder();
        for (Trail trail : trails) {
            trailData.append("Name: ").append(trail.getName())
                    .append(", State: ").append(trail.getState())
                    .append(", Difficulty: ").append(trail.getDifficulty())
                    .append(", Distance: ").append(trail.getDistance()).append("km")
                    .append(", Elevation: ").append(trail.getElevation()).append("m")
                    .append(", Location: ").append(trail.getLocation())
                    .append("\n");
        }


        String prompt = "You are a trekking assistant. Here are the available trails:\n"
                + trailData
                + "\nUser query: " + userQuery
                + "\nReturn only the matching trail names and a one line reason why they match.";


        Map<String, Object> requestBody = new HashMap<>();
        Map<String, Object> content = new HashMap<>();
        Map<String, Object> part = new HashMap<>();
        part.put("text", prompt);
        content.put("parts", List.of(part));
        requestBody.put("contents", List.of(content));


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + apiKey;
        ResponseEntity<Map> response = restTemplate.postForEntity(url, entity, Map.class);


        List<Map> candidates = (List<Map>) response.getBody().get("candidates");
        Map firstCandidate = candidates.get(0);
        Map contentMap = (Map) firstCandidate.get("content");
        List<Map> parts = (List<Map>) contentMap.get("parts");
        return (String) parts.get(0).get("text");
    }
}