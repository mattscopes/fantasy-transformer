package com.fantasy.transformer;

import com.fantasy.transformer.models.sleeper.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fantasy.transformer.helpers.MillisFromEpochToInstantModule;
import com.fantasy.transformer.helpers.SleeperClientHelper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.lang.NonNull;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Optional;

public class SleeperClient {
    
    private final HttpClient client;
    
    private static final String BASE_URL = "https://api.sleeper.app/v1/";
    
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
        .registerModule(new MillisFromEpochToInstantModule())
        .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    
    private static final TypeReference<List<SleeperRoster>> ROSTER_LIST_TYPE = new TypeReference<>() {};
    private static final TypeReference<List<SleeperUser>> USER_LIST_TYPE = new TypeReference<>() {};
    private static final TypeReference<List<SleeperMatchup>> MATCHUP_LIST_TYPE = new TypeReference<>() {};
    private static final TypeReference<List<SleeperBracket>> BRACKET_LIST_TYPE = new TypeReference<>() {};
    private static final TypeReference<List<SleeperTransaction>> TRANSACTION_LIST_TYPE = new TypeReference<>() {};
    private static final TypeReference<List<SleeperPick>> PICK_LIST_TYPE = new TypeReference<>() {};
    private static final TypeReference<Map<String, SleeperPlayer>> PLAYER_MAP_TYPE = new TypeReference<>() {};
    private static final TypeReference<List<SleeperTrendingPlayer>> TRENDING_PLAYER_LIST_TYPE = new TypeReference<>() {};
    
    public SleeperClient(@NonNull HttpClient client) {
         this.client = client;
    }
    
    //League Section
    
    public SleeperLeague getLeague(@NonNull String leagueId) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId)
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequest(client, url, SleeperLeague.class);
    }
    
    public List<SleeperRoster> getRosters(@NonNull String leagueId) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId, "rosters")
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, ROSTER_LIST_TYPE);
    }
    
    public List<SleeperUser> getUsers(@NonNull String leagueId) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId, "users")
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, USER_LIST_TYPE);
    }
    
    public List<SleeperMatchup> getMatchups(@NonNull String leagueId, @NonNull Integer week) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId, "matchups", week.toString())
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, MATCHUP_LIST_TYPE);
    }
    
    public List<SleeperBracket> getPlayoffBracket(@NonNull String leagueId, @NonNull String bracketType) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId, bracketType)   // bracketType: "winners_bracket" or "losers_bracket"
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, BRACKET_LIST_TYPE);
    }
    
    public List<SleeperTransaction> getTransactions(@NonNull String leagueId, @NonNull Integer round) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId, "transactions", round.toString())
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, TRANSACTION_LIST_TYPE);
    }
    
    public List<SleeperPick> getTradedPicks(@NonNull String leagueId) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId, "traded_picks")
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, PICK_LIST_TYPE);
    }
    
    public SleeperState getState(@NonNull String sport) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("state", sport)
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequest(client, url, SleeperState.class);
    }
    
    //Players Section

    @Cacheable("players")
    public Map<String, SleeperPlayer> getPlayers(@NonNull String sport) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("players", sport)
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestMap(client, url, PLAYER_MAP_TYPE);
    }

    public List<SleeperTrendingPlayer> getTrendingPlayers(@NonNull String sport, String type, Integer lookbackHours, Integer limit) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("players", "trending", sport)
            .queryParamIfPresent("type", Optional.ofNullable(type))
            .queryParamIfPresent("lookback_hours", Optional.ofNullable(lookbackHours))
            .queryParamIfPresent("limit", Optional.ofNullable(limit))
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, TRENDING_PLAYER_LIST_TYPE);
    }
    
}