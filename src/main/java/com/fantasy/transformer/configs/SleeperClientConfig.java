package com.fantasy.transformer.configs;

import com.fantasy.transformer.SleeperClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.net.http.HttpClient;

@Configuration
public class SleeperClientConfig {
    @Bean
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }

    @Bean
    public SleeperClient sleeperClient(HttpClient httpClient) {
        return new SleeperClient(httpClient);
    }
}
