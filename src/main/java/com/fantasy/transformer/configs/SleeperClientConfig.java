<<<<<<<< HEAD:backend/src/main/java/com/fantasysports/dashboard/SleeperClientConfig.java
package com.fantasysports.dashboard;
========
package com.fantasy.transformer.configs;
>>>>>>>> d9ac6469b24e61475a39ec7d714d2fc3257e2f8e:src/main/java/com/fantasy/transformer/configs/SleeperClientConfig.java

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
