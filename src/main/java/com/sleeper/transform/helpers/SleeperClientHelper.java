package com.sleeper.transform.helpers;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import static com.sleeper.transform.SleeperClient.OBJECT_MAPPER;

public class SleeperClientHelper {
    
    public static HttpResponse<String> sendGetRequest(HttpClient client, String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
    
    public static <T> T processGetRequest(HttpClient client, String url, Class<T> type) throws IOException, InterruptedException {
        HttpResponse<String> response = sendGetRequest(client, url);
        return OBJECT_MAPPER.readValue(response.body(), type);
    }
    
    public static <T> List<T> processGetRequestList(HttpClient client, String url, TypeReference<List<T>> typeRef) throws IOException, InterruptedException {
        HttpResponse<String> response = sendGetRequest(client, url);
        return OBJECT_MAPPER.readValue(response.body(), typeRef);
    }
    
    public static <K, V> Map<K, V> processGetRequestMap(HttpClient client, String url, TypeReference<Map<K, V>> typeRef) throws IOException, InterruptedException {
        HttpResponse<String> response = sendGetRequest(client, url);
        return OBJECT_MAPPER.readValue(response.body(), typeRef);
    }
    
}
