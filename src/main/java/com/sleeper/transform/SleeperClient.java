package com.sleeper.transform;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.sleeper.transform.models.sleeper.*;
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
    
    public static final ObjectMapper mapper = new ObjectMapper()
        .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    
    public SleeperClient(@NonNull HttpClient client) {
         this.client = client;
    }
    
    //League Section
    
    public League getLeague(@NonNull String leagueId) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId)
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequest(client, url, League.class);
    }
    
    public List<Roster> getRosters(@NonNull String leagueId) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId, "rosters")
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, new TypeReference<List<Roster>>() {});
    }
    
    public List<User> getUsers(@NonNull String leagueId) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId, "users")
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, new TypeReference<List<User>>() {});
    }
    
    public List<Matchup> getMatchups(@NonNull String leagueId, @NonNull Integer week) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId, "matchups", week.toString())
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, new TypeReference<List<Matchup>>() {});
    }
    
    public List<Bracket> getPlayoffBracket(@NonNull String leagueId, @NonNull String bracketType) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId, bracketType)   // bracketType: "winners_bracket" or "losers_bracket"
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, new TypeReference<List<Bracket>>() {});
    }
    
    public List<Transaction> getTransactions(@NonNull String leagueId, @NonNull Integer round) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId, "transactions", round.toString())
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, new TypeReference<List<Transaction>>() {});
    }
    
    public List<Pick> getTradedPicks(@NonNull String leagueId) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("league", leagueId, "traded_picks")
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, new TypeReference<List<Pick>>() {});
    }
    
    public State getState(@NonNull String sport) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("state", sport)
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequest(client, url, State.class);
    }
    
    //Players Section
    
    public Map<String, Player> getPlayers(@NonNull String sport) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("player", sport)
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestMap(client, url, new TypeReference<Map<String, Player>>() {});
    }
    
    public List<TrendingPlayer> getTrendingPlayers(@NonNull String sport, String type, Integer lookbackHours, Integer limit) throws IOException, InterruptedException {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment("players", "trending", sport)
            .queryParamIfPresent("type", Optional.ofNullable(type))
            .queryParamIfPresent("lookback_hours", Optional.ofNullable(lookbackHours))
            .queryParamIfPresent("limit", Optional.ofNullable(limit))
            .build()
            .toUriString();
        return SleeperClientHelper.processGetRequestList(client, url, new TypeReference<List<TrendingPlayer>>() {});
    }
    
}
