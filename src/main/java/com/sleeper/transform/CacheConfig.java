package com.sleeper.transform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Objects;
import java.util.Optional;

@Configuration
@EnableCaching
public class CacheConfig {

    @Autowired
    private CacheManager cacheManager;

    // Clears the 'getPlayers' cache every 24 hours
    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void clearPlayersCache() {
        Objects.requireNonNull(cacheManager.getCache("players")).clear();
    }

}
