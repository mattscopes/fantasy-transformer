package com.fantasy.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Objects;

@Configuration
@EnableCaching
public class CacheConfig {

    @Autowired
    private CacheManager cacheManager;

    // Clears the players cache every 24 hours
    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void clearPlayersCache() {
        Objects.requireNonNull(cacheManager.getCache("players")).clear();
    }

    // Clears all other caches every 60 seconds
//    @Scheduled(fixedRate = 60 * 1000)
//    public void clearOtherCaches() {
//        Objects.requireNonNull(cacheManager.getCache("league")).clear();
//        Objects.requireNonNull(cacheManager.getCache("rosters")).clear();
//        Objects.requireNonNull(cacheManager.getCache("users")).clear();
//    }

}

