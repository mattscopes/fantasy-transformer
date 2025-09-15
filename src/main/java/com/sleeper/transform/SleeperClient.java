package com.sleeper.transform;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sleeper.transform.models.League;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SleeperClient {
    
    private final HttpClient client;
    private final String leagueId;
    
    private static final String BASE_URL = "https://api.sleeper.app/v1/";
    
    public static final ObjectMapper mapper = new ObjectMapper()
        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    
    public SleeperClient(HttpClient client, String leagueId) {
         this.client = client;
         this.leagueId = leagueId;
    }
    
    public League getLeagueData() throws IOException, InterruptedException {
        String url = BASE_URL + "league/" + leagueId;
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        return mapper.readValue(response.body(), League.class);
    }
    
    
    
}
